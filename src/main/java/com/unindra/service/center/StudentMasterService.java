package com.unindra.service.center;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unindra.entity.Classroom;
import com.unindra.entity.Department;
import com.unindra.entity.District;
import com.unindra.entity.Province;
import com.unindra.entity.Regency;
import com.unindra.entity.Section;
import com.unindra.entity.Student;
import com.unindra.model.request.RegisterStudentRequest;
import com.unindra.model.request.UpdataStudentRequest;
import com.unindra.service.ClassroomService;
import com.unindra.service.DepartmentService;
import com.unindra.service.DistrictService;
import com.unindra.service.PasswordService;
import com.unindra.service.ProvinceService;
import com.unindra.service.RegencyService;
import com.unindra.service.SectionService;
import com.unindra.service.StudentService;
import com.unindra.service.ValidationService;

import lombok.AllArgsConstructor;

/*
 * YANG BOLEH IMPORT SERVICE LAIN CUMA MASTER SERVICE
 * SELAIN MASTER SERVICE, GA BOLEHH 
 * JINGAN EMANG NI PROJECT
 * 
 * NGAPAIN JUGA GW MILIH NI JURUSAN
 * JURUSAN STRESS GINI BANYAK PEMINAT NYA
 * HERAN
 * COKKKK 
 */
@Service
@AllArgsConstructor
public class StudentMasterService {

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private RegencyService regencyService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private StudentService studentService;
    
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private SectionService sectionService;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private PasswordService passwordService;

    public List<Student> findStudents() {
        return studentService.findAll();
    }

    public List<Student> searchStudents(String keyword) {
        return studentService.searchStudents(keyword);
    }

    public String registerStudent(RegisterStudentRequest request) {
        
        String errorMessage = validationService.validate(request);

        if (errorMessage != null) {
            return errorMessage;
        }

        if (studentService.isUsernameExist(request.getUsername())) {
            return "Username sudah digunakan";
        }

        if (!passwordService.isPasswordEquals(request.getPassword(), request.getConfirmPassword())) {
            return "Password tidak sama";
        }

        String hashedPassword = passwordService.generateHashPw(request.getPassword());
        String birthPlace = String.join(", ", request.getDistrict(), request.getCity(), request.getProvience());

        Integer year = Integer.parseInt(request.getYearBirth());
        Integer month = request.getMonthBirth() + 1;
        Integer date = Integer.parseInt(request.getDateBirth());

        LocalDate localDate = LocalDate.of(year, month, date);

        Student student = new Student();
        student.setName(request.getFullName());
        student.setGender(request.getGender());
        student.setUsername(request.getUsername());
        student.setPassword(hashedPassword);
        student.setEmail(request.getEmail());
        student.setPhoneNumber(request.getPhoneNumber());
        student.setBirthDate(localDate);
        student.setBirthPlace(birthPlace);

        Department department = departmentService.findByName(request.getDepartment());

        Classroom classroom = classroomService.findByDepartmentAndName(department, "10");
        if (classroom == null) {
            // Jika belum ada kelas 10, buat dulu
            classroom = new Classroom();
            classroom.setDepartment(department);
            classroom.setName("10");
            
            classroom = classroomService.save(classroom);
        }

        //  Cari semua section di classroom
        List<Section> sections = classroom.getSections();
        Section selectedSection = null;

        for (Section section : sections) {
            int count = studentService.countBySection(section); // kamu harus punya method ini
            if (count < 30) {
                selectedSection = section;
                break;
            }
        }

        if (selectedSection == null) {
            // Semua penuh, buat section baru
            char newSectionChar = (char) ('A' + sections.size());
            String sectionName = String.valueOf(newSectionChar);

            selectedSection = new Section();
            selectedSection.setName(sectionName);
            selectedSection.setClassroom(classroom);
            selectedSection = sectionService.save(selectedSection);
        }

        // ⬇️ Assign student ke section
        student.setDepartment(department);
        student.setClassroom(classroom);
        student.setSection(selectedSection);

        studentService.registerStudent(student);

        return null;
    }

    public Student findStudentByUsername(String username) {
        Optional<Student> studentByUsername = studentService.findStudentByUsername(username);

        return studentByUsername.get();
    }

    public String editStudent(UpdataStudentRequest request) {

        // String errorMessage;

        // errorMessage = studentService.edit(request);

        return null;
    }

    public void deleteStudentById(Integer id) {
        studentService.deleteById(id);
    }


    // REGION SERVICE LOGIC BUSSINESS
    public String[] getProvinces() {

        List<Province> provinces = provinceService.findAll();

        return provinces.stream().map(Province::getName).toArray(String[]::new);

    }

    public String[] getRegenciesByProvinceName(String provinceName) {

        Province province = provinceService.findByName(provinceName);

        List<Regency> regencies = regencyService.findByProvinceId(province.getId());

        return regencies.stream().map(Regency::getName).toArray(String[]::new);
    }

    public String[] getDistrictsByRegencyName(String regencyName) {

        Regency regency = regencyService.findByName(regencyName);

        List<District> districts = districtService.findByRegencyId(regency.getId());

        return districts.stream().map(District::getName).toArray(String[]::new);
    }

    public String[] getDepartments() {
        
        List<Department> departments = departmentService.findDepartments();

        return departments.stream().map(Department::getName).toArray(String[]::new);
    }

    



    
    
}
