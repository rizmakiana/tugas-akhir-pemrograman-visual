/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.unindra.view.student;

import com.unindra.model.request.RegisterStudentRequest;
import com.unindra.service.center.StudentMasterService;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author rizmakiana
 */
@Component
@Slf4j
public class RegisterStudentView extends javax.swing.JFrame {

    private final StudentMasterService masterService;

    /**
     * Creates new form RegisterView
     * 
     * @param masterService
     * @param role
     */
    @Autowired
    public RegisterStudentView(StudentMasterService masterService) {
        this.masterService = masterService;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fullnameForm = new javax.swing.JTextField();
        genderForm = new javax.swing.JComboBox<>();
        usernameForm = new javax.swing.JTextField();
        phoneNumberForm = new javax.swing.JTextField();
        emailForm = new javax.swing.JTextField();
        confirmPasswordForm = new javax.swing.JPasswordField();
        passwordForm = new javax.swing.JPasswordField();
        dateForm = new javax.swing.JComboBox<>();
        provinceForm = new javax.swing.JComboBox<>();
        monthForm = new javax.swing.JComboBox<>();
        yearForm = new javax.swing.JComboBox<>();
        cityForm = new javax.swing.JComboBox<>();
        districtForm = new javax.swing.JComboBox<>();
        departmentForm = new javax.swing.JComboBox<>();
        bg = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fullnameForm.setBackground(new java.awt.Color(216, 216, 216));
        fullnameForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(fullnameForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 200, 315, 25));

        genderForm.setBackground(new java.awt.Color(216, 216, 216));
        genderForm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));
        genderForm.setBorder(null);
        getContentPane().add(genderForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 200, 125, 25));

        usernameForm.setBackground(new java.awt.Color(216, 216, 216));
        usernameForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(usernameForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 255, 140, 25));

        phoneNumberForm.setBackground(new java.awt.Color(216, 216, 216));
        phoneNumberForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(phoneNumberForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(825, 365, 220, 25));

        emailForm.setBackground(new java.awt.Color(216, 216, 216));
        emailForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(emailForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 365, 220, 25));

        confirmPasswordForm.setBackground(new java.awt.Color(216, 216, 216));
        confirmPasswordForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(confirmPasswordForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(905, 255, 140, 25));

        passwordForm.setBackground(new java.awt.Color(216, 216, 216));
        passwordForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(passwordForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 255, 140, 25));

        dateForm.setBackground(new java.awt.Color(216, 216, 216));
        dateForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(dateForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 310, 140, 25));

        provinceForm.setBackground(new java.awt.Color(216, 216, 216));
        provinceForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        provinceForm.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                provinceFormItemStateChanged(evt);
            }
        });
        getContentPane().add(provinceForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 420, 140, 25));

        monthForm.setBackground(new java.awt.Color(216, 216, 216));
        monthForm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        monthForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(monthForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 310, 140, 25));

        yearForm.setBackground(new java.awt.Color(216, 216, 216));
        yearForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(yearForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(905, 310, 140, 25));

        cityForm.setBackground(new java.awt.Color(216, 216, 216));
        cityForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cityForm.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cityFormItemStateChanged(evt);
            }
        });
        getContentPane().add(cityForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 420, 140, 25));

        districtForm.setBackground(new java.awt.Color(216, 216, 216));
        districtForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(districtForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(905, 420, 140, 25));

        departmentForm.setBackground(new java.awt.Color(216, 216, 216));
        departmentForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(departmentForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 475, 140, 25));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/Register View Student.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 20, 40, 40));

        registerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/Register View Student.png"))); // NOI18N
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerButtonMouseClicked(evt);
            }
        });
        getContentPane().add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 543, 120, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void provinceFormItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_provinceFormItemStateChanged
        
        cityForm.setModel(new DefaultComboBoxModel<>(masterService.getRegenciesByProvinceName(provinceForm.getSelectedItem().toString())));
        districtForm.setModel(new DefaultComboBoxModel<>(masterService.getDistrictsByRegencyName(cityForm.getSelectedItem().toString())));

    }//GEN-LAST:event_provinceFormItemStateChanged

    private void cityFormItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cityFormItemStateChanged
        
        districtForm.setModel(new DefaultComboBoxModel<>(masterService.getDistrictsByRegencyName(cityForm.getSelectedItem().toString())));

    }//GEN-LAST:event_cityFormItemStateChanged

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_backButtonMouseClicked
        
        this.setVisible(false);

    }// GEN-LAST:event_backButtonMouseClicked

    private void registerButtonMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_registerButtonMouseClicked

        String name = fullnameForm.getText();
        String gender = genderForm.getSelectedItem().toString();
        String username = usernameForm.getText();
        String password = new String(passwordForm.getPassword());
        String confirmPassword = new String(confirmPasswordForm.getPassword());
        String date = dateForm.getSelectedItem().toString();
        Integer month = monthForm.getSelectedIndex();
        String year = yearForm.getSelectedItem().toString();
        String email = emailForm.getText();
        String phoneNumber = phoneNumberForm.getText();
        String province = provinceForm.getSelectedItem().toString();
        String city = cityForm.getSelectedItem().toString();
        String district = districtForm.getSelectedItem().toString();

        String department = departmentForm.getSelectedItem().toString();

        RegisterStudentRequest request = new RegisterStudentRequest(name, gender, username, password, confirmPassword, date, month, year, email, phoneNumber, province, city, district, department);

        try {
            String result = masterService.registerStudent(request);
            if (result != null) {
                JOptionPane.showMessageDialog(this, result, "Validasi Gagal", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }// GEN-LAST:event_registerButtonMouseClicked

    public void generateComponents() {
        
        provinceForm.setModel(new DefaultComboBoxModel<>(masterService.getProvinces()));
        cityForm.setModel(new DefaultComboBoxModel<>(masterService.getRegenciesByProvinceName(provinceForm.getSelectedItem().toString())));
        districtForm.setModel(new DefaultComboBoxModel<>(masterService.getDistrictsByRegencyName(cityForm.getSelectedItem().toString())));

        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel bg;
    private javax.swing.JComboBox<String> cityForm;
    private javax.swing.JPasswordField confirmPasswordForm;
    private javax.swing.JComboBox<String> dateForm;
    private javax.swing.JComboBox<String> departmentForm;
    private javax.swing.JComboBox<String> districtForm;
    private javax.swing.JTextField emailForm;
    private javax.swing.JTextField fullnameForm;
    private javax.swing.JComboBox<String> genderForm;
    private javax.swing.JComboBox<String> monthForm;
    private javax.swing.JPasswordField passwordForm;
    private javax.swing.JTextField phoneNumberForm;
    private javax.swing.JComboBox<String> provinceForm;
    private javax.swing.JButton registerButton;
    private javax.swing.JTextField usernameForm;
    private javax.swing.JComboBox<String> yearForm;
    // End of variables declaration//GEN-END:variables
}
