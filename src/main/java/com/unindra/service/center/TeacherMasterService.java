package com.unindra.service.center;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unindra.entity.Attendance;
import com.unindra.entity.District;
import com.unindra.entity.Grade;
import com.unindra.entity.Province;
import com.unindra.entity.Regency;
import com.unindra.entity.Student;
import com.unindra.entity.Teacher;
import com.unindra.entity.TeachingAssignment;
import com.unindra.model.request.AttendanceRequest;
import com.unindra.model.request.LoginRequest;
import com.unindra.service.AttendanceService;
import com.unindra.service.DistrictService;
import com.unindra.service.GradeService;
import com.unindra.service.PasswordService;
import com.unindra.service.ProvinceService;
import com.unindra.service.RegencyService;
import com.unindra.service.StudentService;
import com.unindra.service.TeacherService;
import com.unindra.service.TeachingAssignmentService;
import com.unindra.service.ValidationService;

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
public class TeacherMasterService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private RegencyService regencyService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private PasswordService passwordService;

    @Autowired
    private TeachingAssignmentService assignmentService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private AttendanceService attendanceService;

    public String loginTeacher(LoginRequest request) {

        String errorMessage = validationService.validate(request);

        if (errorMessage != null) {
            return errorMessage;
        }

        Optional<Teacher> optionalTeacher = teacherService.findByUsername(request.getUsername());

        if (optionalTeacher.isEmpty()) {
            return "Username atau password salah";
        }

        Teacher teacher = optionalTeacher.get();

        if (!passwordService.isPasswordValid(request.getPassword(), teacher.getPassword())) {
            return "Username atau password salah";
        }

        return null;
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

    public Teacher findTeacherByUsername(String username) {

        return teacherService.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Guru tidak ditemukan"));

    }

    public String[] getClassroomList(Integer teacherId) {
        Teacher teacher = teacherService.findById(teacherId).get();

        List<TeachingAssignment> teachingAssignments = teacher.getTeachingAssignments();

        if (teachingAssignments.size() == 0) {
            return new String[0];
        }

        List<String> item = new ArrayList<>();

        for (TeachingAssignment teachingAssignment : teachingAssignments) {
            String department = teachingAssignment.getSection().getClassroom().getDepartment().getName();
            String classroom = teachingAssignment.getSection().getClassroom().getName();
            String section = teachingAssignment.getSection().getName();
            String course = teachingAssignment.getCourse().getName();

            String combined = String.join("/", department, classroom, section, course);
            item.add(combined);
        }
        return item.stream().toArray(String[]::new);
    }

    public TeachingAssignment findByTeacherAndCourseAndSection(Integer teacherId, String strings) {

        String[] parts = strings.split("/");

        String department = parts[0];
        String classroom = parts[1];
        String section = parts[2];
        String course = parts[3];

        return assignmentService.findByTeacherAndCourseAndSection(teacherId, department, classroom, section, course);
    }

    public String saveScoresFromTable(String classroom, DefaultTableModel model, Teacher teacher) {

        try {
            // Parse classroom info: "Multimedia/10/A/Pemrograman"
            String[] parts = classroom.split("/");
            if (parts.length != 4) {
                return "Format pilihan kelas tidak valid";
            }

            String departmentName = parts[0];
            String classroomName = parts[1];
            String sectionName = parts[2];
            String courseName = parts[3];

            // Cari TeachingAssignment
            TeachingAssignment assignment = assignmentService.findByTeacherAndCourseAndSection(
                    teacher.getId(), departmentName, classroomName, sectionName, courseName);

            if (assignment == null)
                return "Data pengajaran tidak ditemukan.";

            List<Grade> grades = assignment.getGrades();

            // Mapping NPM -> Grade
            Map<Integer, Grade> gradeMap = new HashMap<>();
            for (Grade grade : grades) {
                gradeMap.put(grade.getStudent().getId(), grade);
            }

            // Loop tabel dan update nilai
            for (int i = 0; i < model.getRowCount(); i++) {
                Integer studentId = Integer.parseInt(model.getValueAt(i, 0).toString());

                Grade grade = gradeMap.get(studentId);
                if (grade == null)
                    continue;

                // Ambil nilai dari tabel
                Double tugas = toDouble(model.getValueAt(i, 2));
                Double uts = toDouble(model.getValueAt(i, 3));
                Double uas = toDouble(model.getValueAt(i, 4));

                // Set dan simpan
                grade.setTaskScore(tugas);
                grade.setMidTestScore(uts);
                grade.setLastTestScore(uas);

                gradeService.save(grade);
            }

            return null; // sukses

        } catch (Exception e) {
            e.printStackTrace();
            return "Terjadi kesalahan saat menyimpan nilai.";
        }

    }

    private Double toDouble(Object obj) {
        try {
            return Double.parseDouble(obj.toString());
        } catch (Exception e) {
            return 0.0;
        }
    }

    public TeachingAssignment findAssignmentWithStudents(Integer teacherId, String classroom) {

        String[] parts = classroom.split("/");

        String departmentName = parts[0];
        String classroomName = parts[1];
        String sectionName = parts[2];
        String courseName = parts[3];

        return assignmentService.findAssignmentWithStudents(teacherId, departmentName, classroomName, sectionName,
                courseName);
    }

    public String[] getAvailableMeeting(Long assignmentId) {
        int MAX_MEETING = 16;
        List<Integer> takenMeetings = attendanceService.findExistingMeetingNumbers(assignmentId);
        List<String> availableMeetings = new ArrayList<>();

        for (int i = 1; i <= MAX_MEETING; i++) {
            if (!takenMeetings.contains(i)) {
                availableMeetings.add("Pertemuan " + i);
            }
        }

        return availableMeetings.toArray(new String[0]); // bukan takenMeetings
    }

    public String saveAttendance(Integer teacherId, String classroomInfo, int meetingNumber,
            List<AttendanceRequest> requests) {
        // Pecah classroomInfo: "Multimedia/10/A/Pemrograman"
        String[] parts = classroomInfo.split("/");
        if (parts.length != 4)
            return "Format kelas tidak valid.";

        String department = parts[0];
        String classroom = parts[1];
        String section = parts[2];
        String course = parts[3];

        TeachingAssignment assignment = assignmentService.findByTeacherAndCourseAndSection(
                teacherId, department, classroom, section, course);

        if (assignment == null)
            return "Data pengajar tidak ditemukan.";

        // Cek apakah sudah pernah absen
        boolean exists = attendanceService.existsByAssignmentAndMeeting(assignment.getId(), meetingNumber);
        if (exists)
            return "Presensi untuk pertemuan ini sudah pernah dilakukan.";

        // Simpan presensi
        for (AttendanceRequest req : requests) {
            Student student = studentService.findById(req.getStudentId()).orElse(null);
            if (student == null)
                continue;

            Attendance attendance = new Attendance();
            attendance.setTeachingAssignment(assignment);
            attendance.setStudent(student);
            attendance.setMeetingNumber(meetingNumber);
            attendance.setIsPresent(req.getIsPresent());

            attendanceService.save(attendance);
        }

        return null; // null artinya sukses
    }

    public List<Attendance> findAttendacesByTeachingAssignmentId(Long id) {
        return attendanceService.findAttendacesByTeachingAssignmentId(id);
    }

}
