package src;

import db.connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Allen Caingcoy
 */
public class adminbillingFrame extends javax.swing.JFrame {

    public adminbillingFrame() {
        initComponents();
        retrieveData();
        billingData();
    }

    void retrieveData() {
        DefaultTableModel retrievemodel = (DefaultTableModel) patientList.getModel();
        retrievemodel.setRowCount(0);

        String url = connect.url;
        String user = connect.user;
        String password = connect.password;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM patientTable";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int patientId = resultSet.getInt("PID");
                String name = resultSet.getString("Patient Name");
                String phonenumber = resultSet.getString("Phone Number");
                String admit = resultSet.getString("Admit");

                retrievemodel.addRow(new Object[]{
                    patientId, name, phonenumber, admit});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void billingData() {
        DefaultTableModel retrievemodel = (DefaultTableModel) billingList.getModel();
        retrievemodel.setRowCount(0);

        String url = connect.url;
        String user = connect.user;
        String password = connect.password;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM billingTable";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int patientId = resultSet.getInt("PID");
                String name = resultSet.getString("Patient Name");
                String guardian = resultSet.getString("Guardian Name");
                String phonenumber = resultSet.getString("Phone Number");
                String address = resultSet.getString("Address");
                String stay = resultSet.getString("Number of Stay");
                String medstotal = resultSet.getString("Medication Total");
                String totalbill = resultSet.getString("Total Bill");

                retrievemodel.addRow(new Object[]{
                    patientId, name, guardian, phonenumber, address, stay, medstotal, totalbill});
            }
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        patientName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        guardianName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        phoneNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressText = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        updateField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        patientList = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        minusIncrement = new javax.swing.JButton();
        countField = new javax.swing.JTextField();
        addIncrement = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        billingList = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        billOut = new javax.swing.JButton();

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

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Billing", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 24))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel1.setText("Patient Name");

        patientName.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel2.setText("Guardian Name");

        guardianName.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel3.setText("Phone Number");

        phoneNumber.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel5.setText("Address");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        addressText.setColumns(20);
        addressText.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        addressText.setRows(5);
        jScrollPane1.setViewportView(addressText);

        jLabel6.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel6.setText("Search:");

        updateField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                updateFieldKeyTyped(evt);
            }
        });

        patientList.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        patientList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PID", "Patient Name", "Phone Number", "Admit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        patientList.setRowHeight(30);
        patientList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(patientList);

        jLabel7.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel7.setText("Days of Stay");

        minusIncrement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rsc/minus.png"))); // NOI18N
        minusIncrement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusIncrementActionPerformed(evt);
            }
        });

        countField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        countField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        countField.setText("1");

        addIncrement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rsc/plus.png"))); // NOI18N
        addIncrement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addIncrementActionPerformed(evt);
            }
        });

        addButton.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(patientName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(guardianName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(minusIncrement, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(countField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(addIncrement, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(236, 236, 236)
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(patientName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(guardianName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(countField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addIncrement, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(minusIncrement, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Billing", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Billing List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 24))); // NOI18N

        jTextField1.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel4.setText("Search:");

        billingList.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        billingList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PID", "Patient Name", "Guardian Name", "Phone Number", "Address", "Number of Stay", "Medicine Bill", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        billingList.setRowHeight(30);
        jScrollPane3.setViewportView(billingList);

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        billOut.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        billOut.setText("Bill Out");
        billOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1258, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(billOut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(billOut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Billing List", jPanel5);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 120, 1280, 600);

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

    private void updateFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updateFieldKeyTyped
        DefaultTableModel retrievemodel = (DefaultTableModel) patientList.getModel();
        retrievemodel.setRowCount(0);

        String url = connect.url;
        String user = connect.user;
        String password = connect.password;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String searchTerm = updateField.getText().trim();

            String query = "SELECT * FROM patientTable WHERE PID LIKE ? OR `Patient Name` LIKE ? OR `Guardian Name` LIKE ? OR Address LIKE ? OR Allergies LIKE ? OR Admit LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + searchTerm + "%");
            preparedStatement.setString(2, "%" + searchTerm + "%");
            preparedStatement.setString(3, "%" + searchTerm + "%");
            preparedStatement.setString(4, "%" + searchTerm + "%");
            preparedStatement.setString(5, "%" + searchTerm + "%");
            preparedStatement.setString(6, "%" + searchTerm + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                do {
                    int patientId = resultSet.getInt("PID");
                    String name = resultSet.getString("Patient Name");
                    String phonenumber = resultSet.getString("Phone Number");
                    String address = resultSet.getString("Address");

                    retrievemodel.addRow(new Object[]{patientId, name, phonenumber, address});
                } while (resultSet.next());
            } else {
                JOptionPane.showMessageDialog(null, "No Patient Found!", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateFieldKeyTyped

    private void patientListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientListMouseClicked
        if (evt.getClickCount() == 2) {
            int selectedRow = patientList.getSelectedRow();
            if (selectedRow == -1) {
                return;
            }
            int patientId = (int) patientList.getValueAt(selectedRow, 0);

            String url = connect.url;
            String user = connect.user;
            String password = connect.password;

            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                String query = "SELECT * FROM patientTable WHERE PID = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, patientId);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString("Patient Name");
                    String guardian = resultSet.getString("Guardian Name");
                    String phonenumber = resultSet.getString("Phone Number");
                    String address = resultSet.getString("Address");

                    patientName.setText(name);
                    guardianName.setText(guardian);
                    phoneNumber.setText(phonenumber);
                    addressText.setText(address);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_patientListMouseClicked

    private void minusIncrementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusIncrementActionPerformed
        String currentText = countField.getText();
        if (!currentText.isEmpty()) {
            try {
                int currentValue = Integer.parseInt(currentText);
                int newValue = currentValue - 1;

                countField.setText(String.valueOf(newValue));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } else {
        }
    }//GEN-LAST:event_minusIncrementActionPerformed

    private void addIncrementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addIncrementActionPerformed
        String currentText = countField.getText();
        if (!currentText.isEmpty()) {
            try {
                int currentValue = Integer.parseInt(currentText);
                int newValue = currentValue + 1;

                countField.setText(String.valueOf(newValue));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } else {
        }
    }//GEN-LAST:event_addIncrementActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) billingList.getModel();
        int rowCount = model.getRowCount();

        try {
            Connection connection = connect.getConnection();

            String patient = patientName.getText();
            String guardian = guardianName.getText();
            String phone = phoneNumber.getText();

            String query = "SELECT PID FROM patientTable WHERE `Patient Name` = ? AND `Guardian Name` = ? AND `Phone Number` = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, patient);
            preparedStatement.setString(2, guardian);
            preparedStatement.setString(3, phone);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int patientId = resultSet.getInt("PID");

                Object[] rowData = new Object[]{
                    patientId,
                    patientName.getText(),
                    guardianName.getText(),
                    phoneNumber.getText(),
                    addressText.getText(),
                    countField.getText(),
                    null,
                    null
                };
                model.addRow(rowData);

                // Insert data into billingTable
                PreparedStatement insertStatement = connection.prepareStatement(
                        "INSERT INTO billingTable (PID, `Patient Name`, `Guardian Name`, `Phone Number`, Address, `Number of Stay`, `Medication Total`, `Total Bill`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                insertStatement.setInt(1, patientId);
                insertStatement.setString(2, patientName.getText());
                insertStatement.setString(3, guardianName.getText());
                insertStatement.setString(4, phoneNumber.getText());
                insertStatement.setString(5, addressText.getText());
                insertStatement.setString(6, countField.getText());
                insertStatement.setNull(7, Types.DECIMAL);
                insertStatement.setNull(8, Types.DECIMAL);

                insertStatement.executeUpdate();
                insertStatement.close();
            } else {
                JOptionPane.showMessageDialog(null, "Patient not found.");
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        patientName.setText("");
        guardianName.setText("");
        phoneNumber.setText("");
        addressText.setText("");
        countField.setText("1");
    }//GEN-LAST:event_addButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selectedRow = billingList.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "No row selected.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int patientId = (int) billingList.getValueAt(selectedRow, 0);
        String updatedNumberOfStay = billingList.getValueAt(selectedRow, 5).toString();
        billingList.setValueAt(updatedNumberOfStay, selectedRow, 5);

        String url = connect.url;
        String user = connect.user;
        String password = connect.password;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement updateStatement = connection.prepareStatement("UPDATE billingTable SET `Number of Stay` = ? WHERE PID = ?");
            updateStatement.setString(1, updatedNumberOfStay);
            updateStatement.setInt(2, patientId);
            updateStatement.executeUpdate();
            updateStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void billOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billOutActionPerformed
        int selectedRow = billingList.getSelectedRow();
        if (selectedRow == -1) {
            return;
        }
        String name = billingList.getValueAt(selectedRow, 1).toString();
        double stay = Double.parseDouble(billingList.getValueAt(selectedRow, 5).toString());
        double mfee = Double.parseDouble(billingList.getValueAt(selectedRow, 6).toString());

        double multipliedValue = stay * 500;
        double dfee = 350;
        double subtotal = dfee + multipliedValue + mfee;
        double tax = subtotal * 0.03;
        double total = subtotal + tax;

        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");

        billoutFrame billout = new billoutFrame();
        billout.PATIENTNAME.setText("Patient Name: " + name);
        billout.dfeeLabel.setText("₱" + decimalFormat.format(dfee));
        billout.rfeeLabel.setText("₱" + decimalFormat.format(multipliedValue));
        billout.mfeeLabel.setText("₱" + decimalFormat.format(mfee));
        billout.subtotalLabel.setText("₱" + decimalFormat.format(subtotal));
        billout.taxLabel.setText("₱" + decimalFormat.format(tax));
        billout.totalLabel.setText("₱" + decimalFormat.format(total));
        billout.setVisible(true);
    }//GEN-LAST:event_billOutActionPerformed

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
                new adminbillingFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton addIncrement;
    private javax.swing.JTextArea addressText;
    private javax.swing.JButton appointmentsButton;
    private javax.swing.JButton billOut;
    private javax.swing.JButton billingButton;
    private javax.swing.JTable billingList;
    private javax.swing.JTextField countField;
    private javax.swing.JButton dashboardButton;
    private javax.swing.JTextField guardianName;
    private javax.swing.JButton inventoryButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel logo;
    private javax.swing.JButton minusIncrement;
    private javax.swing.JTable patientList;
    private javax.swing.JTextField patientName;
    private javax.swing.JButton patientsButton;
    private javax.swing.JButton pharmacyButton;
    private javax.swing.JTextField phoneNumber;
    private javax.swing.JButton staffsButton;
    private javax.swing.JTextField updateField;
    // End of variables declaration//GEN-END:variables
}
