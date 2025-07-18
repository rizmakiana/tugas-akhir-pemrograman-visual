/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.unindra.view.teacher;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.unindra.entity.Teacher;
import com.unindra.model.request.LoginRequest;
import com.unindra.service.center.TeacherMasterService;

/**
 *
 * @author rizmakiana
 */
@Component
public class TeacherLoginView extends javax.swing.JFrame {

    private final RegisterTeacherView registerTeacherView;

    private final TeacherMasterService masterService;

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * Creates new form LoginStudentView
     */

    public TeacherLoginView(RegisterTeacherView registerTeacherView, TeacherMasterService masterService) {
        this.registerTeacherView = registerTeacherView;
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
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameForm = new javax.swing.JTextField();
        passwordForm = new javax.swing.JPasswordField();
        bg = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernameForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(usernameForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 250, 30));

        passwordForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(passwordForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 250, 30));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/Login View Teacher.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1198, 15, 70, 25));

        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 270, 40));

        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerButtonMouseClicked(evt);
            }
        });
        getContentPane().add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 530, 270, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerButtonMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_registerButtonMouseClicked

        openRegisterTeacher();

    }// GEN-LAST:event_registerButtonMouseClicked

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_backButtonMouseClicked

        this.setVisible(false);

    }// GEN-LAST:event_backButtonMouseClicked

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loginButtonActionPerformed

        String username = usernameForm.getText();
        String password = new String(passwordForm.getPassword());

        LoginRequest request = new LoginRequest(username, password);

        String errorMessage = masterService.loginTeacher(request);

        if (errorMessage != null) {
            JOptionPane.showMessageDialog(this, errorMessage, "Login Gagal", JOptionPane.ERROR_MESSAGE);
            return;
        }
        clearField();

        // Ambil Teacher dari username (karena login sukses)
        Teacher teacher = masterService.findTeacherByUsername(username);

        // Ambil instance dashboard baru (prototype)
        TeacherDashboardView dashboardView = applicationContext.getBean(TeacherDashboardView.class);
        dashboardView.showForTeacher(teacher);

    }// GEN-LAST:event_loginButtonActionPerformed

    private void clearField() {
        usernameForm.setText("");
        passwordForm.setText("");
    }

    private void openRegisterTeacher() {
        registerTeacherView.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel bg;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordForm;
    private javax.swing.JButton registerButton;
    private javax.swing.JTextField usernameForm;
    // End of variables declaration//GEN-END:variables
}
