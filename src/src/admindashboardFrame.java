package src;

import com.formdev.flatlaf.FlatClientProperties;
import java.sql.*;
import db.connect;
import javax.swing.JOptionPane;

/**
 *
 * @author Allen Caingcoy
 */
public class admindashboardFrame extends javax.swing.JFrame {

    public admindashboardFrame() {
        initComponents();
        jPanel4.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        jPanel5.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        jPanel6.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        jPanel10.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        jPanel18.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        jPanel19.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        PatientCount();
        InPatientCount();
        AppointmentCount();
        InventoryCount();
        LowInventoryCount();
        StaffsCount();
    }

    void PatientCount() {
        String url = connect.url;
        String user = connect.user;
        String password = connect.password;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT COUNT(*) FROM patientTable";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            int count = 0;
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }

            String countText = String.valueOf(count);

            patientCount.setText(countText);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void InPatientCount() {
        String url = connect.url;
        String user = connect.user;
        String password = connect.password;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT COUNT(*) FROM patientTable WHERE TRIM(Admit) = 'Yes'"; // Use TRIM() function in the query
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            int count = 0;
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }

            String countText = String.valueOf(count);

            inpatientCount.setText(countText);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void AppointmentCount() {
        String url = connect.url;
        String user = connect.user;
        String password = connect.password;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT COUNT(*) FROM appointmentTable";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            int count = 0;
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }

            String countText = String.valueOf(count);

            appointmentCount.setText(countText);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void InventoryCount() {
        String url = connect.url;
        String user = connect.user;
        String password = connect.password;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT COUNT(*) FROM inventoryTable";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            int count = 0;
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }

            String countText = String.valueOf(count);

            inventoryCount.setText(countText);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void LowInventoryCount() {
        String url = connect.url;
        String user = connect.user;
        String password = connect.password;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT COUNT(*) FROM inventoryTable WHERE Quantity < 20";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            int count = 0;
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }

            String countText = String.valueOf(count);

            lowinventoryCount.setText(countText);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void StaffsCount() {
        String url = connect.url;
        String user = connect.user;
        String password = connect.password;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT COUNT(*) FROM staffsTable";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            int count = 0;
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }

            String countText = String.valueOf(count);

            staffsCount.setText(countText);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        dashboardButton = new javax.swing.JButton();
        billingButton = new javax.swing.JButton();
        patientsButton = new javax.swing.JButton();
        appointmentsButton = new javax.swing.JButton();
        pharmacyButton = new javax.swing.JButton();
        inventoryButton = new javax.swing.JButton();
        staffsButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        patientCount = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        inpatientCount = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        appointmentCount = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        inventoryCount = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lowinventoryCount = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        staffsCount = new javax.swing.JLabel();

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
        logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logoMouseReleased(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rsc/logout.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 984, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1280, 90);

        jPanel2.setBackground(new java.awt.Color(195, 177, 225));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setMaximumSize(new java.awt.Dimension(1280, 30));
        jPanel2.setPreferredSize(new java.awt.Dimension(1280, 30));
        jPanel2.setSize(new java.awt.Dimension(1280, 30));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, -2));

        dashboardButton.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        dashboardButton.setText("Dashboard");
        dashboardButton.setContentAreaFilled(false);
        dashboardButton.setMaximumSize(new java.awt.Dimension(120, 30));
        dashboardButton.setMinimumSize(new java.awt.Dimension(120, 30));
        dashboardButton.setPreferredSize(new java.awt.Dimension(120, 30));
        dashboardButton.setSize(new java.awt.Dimension(120, 30));
        dashboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardButtonActionPerformed(evt);
            }
        });
        jPanel2.add(dashboardButton);

        billingButton.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        billingButton.setText("Billing");
        billingButton.setContentAreaFilled(false);
        billingButton.setMaximumSize(new java.awt.Dimension(120, 30));
        billingButton.setMinimumSize(new java.awt.Dimension(120, 30));
        billingButton.setPreferredSize(new java.awt.Dimension(120, 30));
        billingButton.setSize(new java.awt.Dimension(120, 30));
        billingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billingButtonActionPerformed(evt);
            }
        });
        jPanel2.add(billingButton);

        patientsButton.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        patientsButton.setText("Patients");
        patientsButton.setContentAreaFilled(false);
        patientsButton.setMaximumSize(new java.awt.Dimension(120, 30));
        patientsButton.setMinimumSize(new java.awt.Dimension(120, 30));
        patientsButton.setPreferredSize(new java.awt.Dimension(120, 30));
        patientsButton.setSize(new java.awt.Dimension(120, 30));
        patientsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientsButtonActionPerformed(evt);
            }
        });
        jPanel2.add(patientsButton);

        appointmentsButton.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        appointmentsButton.setText("Appointments");
        appointmentsButton.setContentAreaFilled(false);
        appointmentsButton.setMaximumSize(new java.awt.Dimension(120, 30));
        appointmentsButton.setMinimumSize(new java.awt.Dimension(120, 30));
        appointmentsButton.setPreferredSize(new java.awt.Dimension(120, 30));
        appointmentsButton.setSize(new java.awt.Dimension(120, 30));
        appointmentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appointmentsButtonActionPerformed(evt);
            }
        });
        jPanel2.add(appointmentsButton);

        pharmacyButton.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        pharmacyButton.setText("Pharmacy");
        pharmacyButton.setContentAreaFilled(false);
        pharmacyButton.setMaximumSize(new java.awt.Dimension(120, 30));
        pharmacyButton.setMinimumSize(new java.awt.Dimension(120, 30));
        pharmacyButton.setPreferredSize(new java.awt.Dimension(120, 30));
        pharmacyButton.setSize(new java.awt.Dimension(120, 30));
        pharmacyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pharmacyButtonActionPerformed(evt);
            }
        });
        jPanel2.add(pharmacyButton);

        inventoryButton.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        inventoryButton.setText("Inventory");
        inventoryButton.setContentAreaFilled(false);
        inventoryButton.setMaximumSize(new java.awt.Dimension(120, 30));
        inventoryButton.setMinimumSize(new java.awt.Dimension(120, 30));
        inventoryButton.setPreferredSize(new java.awt.Dimension(120, 30));
        inventoryButton.setSize(new java.awt.Dimension(120, 30));
        inventoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryButtonActionPerformed(evt);
            }
        });
        jPanel2.add(inventoryButton);

        staffsButton.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        staffsButton.setText("Staffs");
        staffsButton.setContentAreaFilled(false);
        staffsButton.setMaximumSize(new java.awt.Dimension(120, 30));
        staffsButton.setMinimumSize(new java.awt.Dimension(120, 30));
        staffsButton.setPreferredSize(new java.awt.Dimension(120, 30));
        staffsButton.setSize(new java.awt.Dimension(120, 30));
        staffsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffsButtonActionPerformed(evt);
            }
        });
        jPanel2.add(staffsButton);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 90, 1280, 30);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setMaximumSize(new java.awt.Dimension(1280, 600));
        jPanel3.setPreferredSize(new java.awt.Dimension(1280, 600));
        jPanel3.setSize(new java.awt.Dimension(1280, 600));

        jPanel4.setMaximumSize(new java.awt.Dimension(300, 150));
        jPanel4.setSize(new java.awt.Dimension(300, 150));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel4MouseReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rsc/patients.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel2.setText("Total Patients");

        patientCount.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(patientCount, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientCount, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel5.setMaximumSize(new java.awt.Dimension(300, 150));
        jPanel5.setSize(new java.awt.Dimension(300, 150));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel5MouseReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rsc/inpatient.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel4.setText("In Patient");

        inpatientCount.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(inpatientCount, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inpatientCount, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jPanel6.setMaximumSize(new java.awt.Dimension(300, 150));
        jPanel6.setPreferredSize(new java.awt.Dimension(300, 150));
        jPanel6.setSize(new java.awt.Dimension(300, 150));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel6MouseReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rsc/appointments.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel6.setText("Appointments");

        appointmentCount.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(appointmentCount, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appointmentCount, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jPanel10.setMaximumSize(new java.awt.Dimension(300, 150));
        jPanel10.setPreferredSize(new java.awt.Dimension(300, 150));
        jPanel10.setSize(new java.awt.Dimension(300, 150));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel10MouseReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rsc/inventory.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel14.setText("Inventory");

        inventoryCount.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(inventoryCount, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inventoryCount, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addContainerGap())
        );

        jPanel18.setMaximumSize(new java.awt.Dimension(300, 150));
        jPanel18.setPreferredSize(new java.awt.Dimension(300, 150));
        jPanel18.setSize(new java.awt.Dimension(300, 150));
        jPanel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel18MouseReleased(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rsc/lowinventory.png"))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel30.setText("Low Stocks");

        lowinventoryCount.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(lowinventoryCount, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel30)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lowinventoryCount, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addContainerGap())
        );

        jPanel19.setMaximumSize(new java.awt.Dimension(300, 150));
        jPanel19.setPreferredSize(new java.awt.Dimension(300, 150));
        jPanel19.setSize(new java.awt.Dimension(300, 150));
        jPanel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel19MouseReleased(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rsc/staffs.png"))); // NOI18N

        jLabel32.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel32.setText("Staffs");

        staffsCount.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(staffsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel32)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(staffsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(223, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 120, 1280, 600);

        setSize(new java.awt.Dimension(1280, 748));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseReleased
        dispose();
        admindashboardFrame dashboard = new admindashboardFrame();
        dashboard.setVisible(true);
    }//GEN-LAST:event_logoMouseReleased

    private void dashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardButtonActionPerformed
        dispose();
        admindashboardFrame dashboard = new admindashboardFrame();
        dashboard.setVisible(true);
    }//GEN-LAST:event_dashboardButtonActionPerformed

    private void billingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billingButtonActionPerformed
        dispose();
        adminbillingFrame billing = new adminbillingFrame();
        billing.setVisible(true);
    }//GEN-LAST:event_billingButtonActionPerformed

    private void patientsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientsButtonActionPerformed
        dispose();
        adminpatientsFrame patients = new adminpatientsFrame();
        patients.setVisible(true);
    }//GEN-LAST:event_patientsButtonActionPerformed

    private void appointmentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointmentsButtonActionPerformed
        dispose();
        adminappointmentsFrame appointments = new adminappointmentsFrame();
        appointments.setVisible(true);
    }//GEN-LAST:event_appointmentsButtonActionPerformed

    private void pharmacyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pharmacyButtonActionPerformed
        dispose();
        adminpharmacyFrame pharmacy = new adminpharmacyFrame();
        pharmacy.setVisible(true);
    }//GEN-LAST:event_pharmacyButtonActionPerformed

    private void inventoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryButtonActionPerformed
        dispose();
        admininventoryFrame inventory = new admininventoryFrame();
        inventory.setVisible(true);
    }//GEN-LAST:event_inventoryButtonActionPerformed

    private void staffsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffsButtonActionPerformed
        dispose();
        adminstaffsFrame staffs = new adminstaffsFrame();
        staffs.setVisible(true);
    }//GEN-LAST:event_staffsButtonActionPerformed

    private void jPanel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseReleased
        dispose();
        adminpatientsFrame patients = new adminpatientsFrame();
        adminpatientsFrame.jTabbedPane1.setSelectedIndex(1);
        patients.setVisible(true);
    }//GEN-LAST:event_jPanel4MouseReleased

    private void jPanel5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseReleased
        dispose();
        adminpatientsFrame patients = new adminpatientsFrame();
        adminpatientsFrame.jTabbedPane1.setSelectedIndex(2);
        patients.setVisible(true);
    }//GEN-LAST:event_jPanel5MouseReleased

    private void jPanel6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseReleased
        dispose();
        adminappointmentsFrame appointments = new adminappointmentsFrame();
        adminappointmentsFrame.jTabbedPane1.setSelectedIndex(1);
        appointments.setVisible(true);
    }//GEN-LAST:event_jPanel6MouseReleased

    private void jPanel10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseReleased
        dispose();
        admininventoryFrame inventory = new admininventoryFrame();
        admininventoryFrame.jTabbedPane1.setSelectedIndex(1);
        inventory.setVisible(true);
    }//GEN-LAST:event_jPanel10MouseReleased

    private void jPanel18MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseReleased
        dispose();
        admininventoryFrame inventory = new admininventoryFrame();
        admininventoryFrame.jTabbedPane1.setSelectedIndex(2);
        inventory.setVisible(true);
    }//GEN-LAST:event_jPanel18MouseReleased

    private void jPanel19MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseReleased
        dispose();
        adminstaffsFrame staffs = new adminstaffsFrame();
        adminstaffsFrame.jTabbedPane1.setSelectedIndex(1);
        staffs.setVisible(true);
    }//GEN-LAST:event_jPanel19MouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int logout = JOptionPane.showConfirmDialog(null, "This will bring you back to login. Are you Sure?", "WARNING!", JOptionPane.YES_NO_OPTION);
        if (logout == JOptionPane.YES_OPTION) {
            dispose();
            loginFrame login = new loginFrame();
            login.setVisible(true);
        } else {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admindashboardFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appointmentCount;
    private javax.swing.JButton appointmentsButton;
    private javax.swing.JButton billingButton;
    private javax.swing.JButton dashboardButton;
    private javax.swing.JLabel inpatientCount;
    private javax.swing.JButton inventoryButton;
    private javax.swing.JLabel inventoryCount;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel lowinventoryCount;
    private javax.swing.JLabel patientCount;
    private javax.swing.JButton patientsButton;
    private javax.swing.JButton pharmacyButton;
    private javax.swing.JButton staffsButton;
    private javax.swing.JLabel staffsCount;
    // End of variables declaration//GEN-END:variables
}
