package src;

import com.formdev.flatlaf.*;
import db.connect;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;

/**
 *
 * @author Allen Caingcoy
 */
public class loginFrame extends javax.swing.JFrame {

    public static int attempts = 3;
    public static boolean loginAttempted = false;
    public static String cashiername;

    public loginFrame() {
        initComponents();
        jPanel4.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
        progressBar.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(195, 177, 225));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 90));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 90));
        jPanel1.setSize(new java.awt.Dimension(1280, 90));

        logo.setFont(new java.awt.Font("Inter", 0, 36)); // NOI18N
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rsc/logo.png"))); // NOI18N
        logo.setText("HMS");
        logo.setIconTextGap(5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1280, 90);

        jPanel2.setBackground(new java.awt.Color(195, 177, 225));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setMaximumSize(new java.awt.Dimension(1280, 30));
        jPanel2.setPreferredSize(new java.awt.Dimension(1280, 30));
        jPanel2.setSize(new java.awt.Dimension(1280, 30));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, -2));
        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 90, 1280, 30);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setMaximumSize(new java.awt.Dimension(1280, 600));
        jPanel3.setPreferredSize(new java.awt.Dimension(1280, 600));
        jPanel3.setSize(new java.awt.Dimension(1280, 600));

        jPanel4.setMaximumSize(new java.awt.Dimension(500, 350));
        jPanel4.setPreferredSize(new java.awt.Dimension(500, 350));
        jPanel4.setSize(new java.awt.Dimension(500, 350));

        jLabel1.setFont(new java.awt.Font("Inter", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");

        jLabel2.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        jLabel2.setText("ID");

        idField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        jLabel3.setText("Password");

        passwordField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordFieldKeyReleased(evt);
            }
        });

        loginButton.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        exitButton.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        exitButton.setForeground(new java.awt.Color(255, 51, 51));
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(idField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(388, 388, 388))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 120, 1280, 600);

        setSize(new java.awt.Dimension(1280, 748));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void passwordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String superUser = "admin";
            String superPass = "admin";
            String enteredId = idField.getText();
            String enteredPassword = passwordField.getText();

            if (enteredId.equals(superUser) && enteredPassword.equals(superPass)) {
                progressBar.setVisible(true);
                Timer progressBarTimer = new Timer(30, new ActionListener() {
                    int progress = 0;

                    public void actionPerformed(ActionEvent evt) {
                        if (progress >= 100) {
                            ((Timer) evt.getSource()).stop();
                            admindashboardFrame admindashboard = new admindashboardFrame();
                            admindashboard.setVisible(true);
                            dispose();
                        } else {
                            progress++;
                            progressBar.setValue(progress);
                        }
                    }
                });
                progressBarTimer.start();
            } else if (enteredPassword.length() < 6) {
                JOptionPane.showMessageDialog(null, "Password must be at least 6 characters long.");
            } else {
                if (!loginAttempted) {
                    loginAttempted = true;
                    String selectQuery = "SELECT * FROM accountsTable WHERE ID = ? AND Password = ?";
                    try (PreparedStatement selectStatement = connect.getConnection().prepareStatement(selectQuery)) {
                        selectStatement.setString(1, enteredId);
                        selectStatement.setString(2, enteredPassword);

                        try (ResultSet resultSet = selectStatement.executeQuery()) {
                            if (resultSet.next()) {
                                cashiername = resultSet.getString("Name");

                                progressBar.setVisible(true);
                                Timer progressBarTimer = new Timer(30, new ActionListener() {
                                    int progress = 0;

                                    public void actionPerformed(ActionEvent evt) {
                                        if (progress >= 100) {
                                            ((Timer) evt.getSource()).stop();
                                            dispose();
                                            dashboardFrame dashboard = new dashboardFrame();
                                            dashboard.setVisible(true);
                                        } else {
                                            progress++;
                                            progressBar.setValue(progress);
                                        }
                                    }
                                });
                                progressBarTimer.start();
                            } else {
                                attempts--;
                                if (attempts > 0) {
                                    JOptionPane.showMessageDialog(null, "Invalid ID or Password. Remaining attempts: " + attempts);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Max login attempts reached. Exiting application.");
                                    System.exit(0);
                                }
                            }
                        } catch (SQLException e) {
                            System.out.println("Error occurred while retrieving the cashier name: " + e.getMessage());
                            e.printStackTrace();
                        }
                    } catch (SQLException e) {
                        System.out.println("Error occurred while querying the database: " + e.getMessage());
                        e.printStackTrace();
                    }
                } else {
                    attempts--;
                    if (attempts > 0) {
                        JOptionPane.showMessageDialog(null, "Invalid ID or Password. Remaining attempts: " + attempts);
                    } else {
                        JOptionPane.showMessageDialog(null, "Max login attempts reached. Exiting application.");
                        System.exit(0);
                    }
                    loginAttempted = false;
                }
            }
        }
    }//GEN-LAST:event_passwordFieldKeyReleased

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String superUser = "admin";
        String superPass = "admin";
        String enteredId = idField.getText();
        String enteredPassword = passwordField.getText();

        if (enteredId.equals(superUser) && enteredPassword.equals(superPass)) {
            progressBar.setVisible(true);
            Timer progressBarTimer = new Timer(30, new ActionListener() {
                int progress = 0;

                public void actionPerformed(ActionEvent evt) {
                    if (progress >= 100) {
                        ((Timer) evt.getSource()).stop();
                        admindashboardFrame admindashboard = new admindashboardFrame();
                        admindashboard.setVisible(true);
                        dispose();
                    } else {
                        progress++;
                        progressBar.setValue(progress);
                    }
                }
            });
            progressBarTimer.start();
        } else if (enteredPassword.length() < 6) {
            JOptionPane.showMessageDialog(null, "Password must be at least 6 characters long.");
        } else {
            if (!loginAttempted) {
                loginAttempted = true;
                String selectQuery = "SELECT * FROM accountsTable WHERE ID = ? AND Password = ?";
                try (PreparedStatement selectStatement = connect.getConnection().prepareStatement(selectQuery)) {
                    selectStatement.setString(1, enteredId);
                    selectStatement.setString(2, enteredPassword);

                    try (ResultSet resultSet = selectStatement.executeQuery()) {
                        if (resultSet.next()) {
                            cashiername = resultSet.getString("Name");

                            progressBar.setVisible(true);
                            Timer progressBarTimer = new Timer(30, new ActionListener() {
                                int progress = 0;

                                public void actionPerformed(ActionEvent evt) {
                                    if (progress >= 100) {
                                        ((Timer) evt.getSource()).stop();
                                        dispose();
                                        dashboardFrame dashboard = new dashboardFrame();
                                        dashboard.setVisible(true);
                                    } else {
                                        progress++;
                                        progressBar.setValue(progress);
                                    }
                                }
                            });
                            progressBarTimer.start();
                        } else {
                            attempts--;
                            if (attempts > 0) {
                                JOptionPane.showMessageDialog(null, "Invalid ID or Password. Remaining attempts: " + attempts);
                            } else {
                                JOptionPane.showMessageDialog(null, "Max login attempts reached. Exiting application.");
                                System.exit(0);
                            }
                        }
                    } catch (SQLException e) {
                        System.out.println("Error occurred while retrieving the cashier name: " + e.getMessage());
                        e.printStackTrace();
                    }
                } catch (SQLException e) {
                    System.out.println("Error occurred while querying the database: " + e.getMessage());
                    e.printStackTrace();
                }
            } else {
                attempts--;
                if (attempts > 0) {
                    JOptionPane.showMessageDialog(null, "Invalid ID or Password. Remaining attempts: " + attempts);
                } else {
                    JOptionPane.showMessageDialog(null, "Max login attempts reached. Exiting application.");
                    System.exit(0);
                }
                loginAttempted = false;
            }
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        int exit = JOptionPane.showConfirmDialog(null, "This will Exit the Program. Are you Sure?", "WARNING!", JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
        }
    }//GEN-LAST:event_exitButtonActionPerformed

    public static void main(String args[]) {
        FlatLightLaf.setGlobalExtraDefaults(Collections.singletonMap("@accentColor", "#C3B1E1"));
        FlatLightLaf.setup();
        UIManager.put("TextComponent.arc", 10);
        UIManager.put("Button.arc", 10);
        UIManager.put("Component.arrowType", "triangle");
        UIManager.put("PasswordField.showCapsLock", true);
        UIManager.put("PasswordField.showRevealButton", true);
        UIManager.put("Table.alternateRowColor", true);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
