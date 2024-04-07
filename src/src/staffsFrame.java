package src;

import db.connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Allen Caingcoy
 */
public class staffsFrame extends javax.swing.JFrame {

    public static String genderSelect;
    public static boolean dataUpdate = true;

    public staffsFrame() {
        initComponents();
        calendar.setTextField(birthField);
        calendar.setDateFormat(new SimpleDateFormat("MMM-dd-yyyy"));
        retrieveData();
        updateData();
    }

    void retrieveData() {
        DefaultTableModel retrievemodel = (DefaultTableModel) staffsList.getModel();
        retrievemodel.setRowCount(0);

        try {
            Connection connection = connect.getConnection();
            String query = "SELECT ID, Name, `Phone Number`, Specialization FROM staffsTable";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                String phoneNumber = resultSet.getString("Phone Number");
                String specialization = resultSet.getString("Specialization");

                retrievemodel.addRow(new Object[]{ID, name, phoneNumber, specialization});
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void deleteData(int staffId) {
        String url = connect.url;
        String user = connect.user;
        String password = connect.password;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String checkQuery = "SELECT ID FROM staffsTable WHERE ID = ?";
            PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
            checkStatement.setInt(1, staffId);
            ResultSet checkResultSet = checkStatement.executeQuery();

            if (checkResultSet.next()) {
                String deleteQuery = "DELETE FROM staffsTable WHERE ID = ?";
                PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                deleteStatement.setInt(1, staffId);
                deleteStatement.executeUpdate();

                String updateQuery = "UPDATE staffsTable SET ID = ID - 1 WHERE ID > ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setInt(1, staffId);
                updateStatement.executeUpdate();

            } else {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void updateData() {
        DefaultTableModel retrievemodel = (DefaultTableModel) updateList.getModel();
        retrievemodel.setRowCount(0);

        try {
            Connection connection = connect.getConnection();
            String query = "SELECT ID, Name, `Phone Number`, Specialization FROM staffsTable";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                String phoneNumber = resultSet.getString("Phone Number");
                String specialization = resultSet.getString("Specialization");

                retrievemodel.addRow(new Object[]{ID, name, phoneNumber, specialization});
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderGroup = new javax.swing.ButtonGroup();
        calendar = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        dashboardButton = new javax.swing.JButton();
        billingButton = new javax.swing.JButton();
        patientsButton = new javax.swing.JButton();
        appointmentsButton = new javax.swing.JButton();
        pharmacyButton = new javax.swing.JButton();
        inventoryButton = new javax.swing.JButton();
        staffsButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        addstaffPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        birthField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        numberField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        maleButton = new javax.swing.JRadioButton();
        femaleButton = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        specializationField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        employmentField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        availabilityField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        shiftField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        addInfo = new javax.swing.JTextArea();
        addButton = new javax.swing.JButton();
        updateSearch = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        updateList = new javax.swing.JTable();
        updateButton = new javax.swing.JButton();
        staffsPanel = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        staffsList = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        addaccount = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        confirmPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        calendar.setTextField(birthField);

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

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rsc/logout.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        staffsButton.setEnabled(false);
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
        jTabbedPane1.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jTabbedPane1.setMaximumSize(new java.awt.Dimension(1280, 600));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(1280, 600));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1280, 600));
        jTabbedPane1.setSize(new java.awt.Dimension(1280, 600));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Staff", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 24))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel2.setText("Full Name:");

        nameField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel3.setText("Date of Birth");

        birthField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel4.setText("Phone Number");

        numberField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        numberField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numberFieldKeyTyped(evt);
            }
        });

        jLabel8.setText("Gender");

        genderGroup.add(maleButton);
        maleButton.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        maleButton.setText("Male");
        maleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleButtonActionPerformed(evt);
            }
        });

        genderGroup.add(femaleButton);
        femaleButton.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        femaleButton.setText("Female");
        femaleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel6.setText("Specialization");

        specializationField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel7.setText("Employment");

        employmentField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel5.setText("Days Available");

        availabilityField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N

        jLabel9.setText("Shift");

        jLabel10.setText("Additional Info");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        addInfo.setColumns(20);
        addInfo.setRows(5);
        jScrollPane2.setViewportView(addInfo);

        addButton.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        updateSearch.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        updateSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                updateSearchKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel11.setText("Search:");

        updateList.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        updateList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Phone Number", "Specialization"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        updateList.setRowHeight(30);
        jScrollPane3.setViewportView(updateList);

        updateButton.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(994, 994, 994)
                        .addComponent(jLabel11)
                        .addGap(6, 6, 6)
                        .addComponent(updateSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numberField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(specializationField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(availabilityField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(90, 90, 90)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(birthField)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(maleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(femaleButton))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(employmentField)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(shiftField)
                                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(numberField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(specializationField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(availabilityField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(birthField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(maleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(femaleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(employmentField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(shiftField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(55, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout addstaffPanelLayout = new javax.swing.GroupLayout(addstaffPanel);
        addstaffPanel.setLayout(addstaffPanelLayout);
        addstaffPanelLayout.setHorizontalGroup(
            addstaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        addstaffPanelLayout.setVerticalGroup(
            addstaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Add Staff", addstaffPanel);

        staffsPanel.setBackground(new java.awt.Color(255, 255, 255));
        staffsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Staffs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 24))); // NOI18N

        searchField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        searchField.setMaximumSize(new java.awt.Dimension(200, 30));
        searchField.setMinimumSize(new java.awt.Dimension(200, 30));
        searchField.setPreferredSize(new java.awt.Dimension(200, 30));
        searchField.setSize(new java.awt.Dimension(200, 30));
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchFieldKeyTyped(evt);
            }
        });

        staffsList.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        staffsList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Phone Number", "Specialization"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        staffsList.setRowHeight(30);
        staffsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                staffsListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(staffsList);

        jLabel1.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Search:");
        jLabel1.setMaximumSize(new java.awt.Dimension(90, 40));
        jLabel1.setMinimumSize(new java.awt.Dimension(90, 40));
        jLabel1.setPreferredSize(new java.awt.Dimension(90, 40));
        jLabel1.setSize(new java.awt.Dimension(90, 40));

        deleteButton.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout staffsPanelLayout = new javax.swing.GroupLayout(staffsPanel);
        staffsPanel.setLayout(staffsPanelLayout);
        staffsPanelLayout.setHorizontalGroup(
            staffsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1270, Short.MAX_VALUE)
        );
        staffsPanelLayout.setVerticalGroup(
            staffsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffsPanelLayout.createSequentialGroup()
                .addGroup(staffsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Staffs", staffsPanel);

        addaccount.setBackground(new java.awt.Color(255, 255, 255));
        addaccount.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Add Account", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 24))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel12.setText("ID");

        idField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel13.setText("Name");

        NameField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel14.setText("Password");

        jLabel15.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel15.setText("Confirm Password");

        passwordField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N

        confirmPassword.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 51, 51));
        jButton1.setText("Forgot Password");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addaccountLayout = new javax.swing.GroupLayout(addaccount);
        addaccount.setLayout(addaccountLayout);
        addaccountLayout.setHorizontalGroup(
            addaccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addaccountLayout.createSequentialGroup()
                .addGap(535, 535, 535)
                .addGroup(addaccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(535, Short.MAX_VALUE))
        );
        addaccountLayout.setVerticalGroup(
            addaccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addaccountLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Add Account", addaccount);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 120, 1280, 600);

        setSize(new java.awt.Dimension(1280, 748));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseReleased
        dispose();
        dashboardFrame dashboard = new dashboardFrame();
        dashboard.setVisible(true);
    }//GEN-LAST:event_logoMouseReleased

    private void dashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardButtonActionPerformed
        dispose();
        dashboardFrame dashboard = new dashboardFrame();
        dashboard.setVisible(true);
    }//GEN-LAST:event_dashboardButtonActionPerformed

    private void billingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billingButtonActionPerformed
        dispose();
        billingFrame billing = new billingFrame();
        billing.setVisible(true);
    }//GEN-LAST:event_billingButtonActionPerformed

    private void patientsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientsButtonActionPerformed
        dispose();
        patientsFrame patients = new patientsFrame();
        patients.setVisible(true);
    }//GEN-LAST:event_patientsButtonActionPerformed

    private void appointmentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointmentsButtonActionPerformed
        dispose();
        staffsFrame appointments = new staffsFrame();
        appointments.setVisible(true);
    }//GEN-LAST:event_appointmentsButtonActionPerformed

    private void pharmacyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pharmacyButtonActionPerformed
        dispose();
        pharmacyFrame pharmacy = new pharmacyFrame();
        pharmacy.setVisible(true);
    }//GEN-LAST:event_pharmacyButtonActionPerformed

    private void inventoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryButtonActionPerformed
        dispose();
        inventoryFrame inventory = new inventoryFrame();
        inventory.setVisible(true);
    }//GEN-LAST:event_inventoryButtonActionPerformed

    private void staffsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffsButtonActionPerformed
        dispose();
        staffsFrame staff = new staffsFrame();
        staff.setVisible(true);
    }//GEN-LAST:event_staffsButtonActionPerformed

    private void searchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyTyped
        DefaultTableModel retrievemodel = (DefaultTableModel) staffsList.getModel();
        retrievemodel.setRowCount(0);

        String url = connect.url;
        String user = connect.user;
        String password = connect.password;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String searchTerm = searchField.getText().trim();

            String query = "SELECT * FROM staffsTable WHERE ID LIKE ? OR Name LIKE ? OR Specialization LIKE ? OR Availability LIKE ? OR Shift LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + searchTerm + "%");
            preparedStatement.setString(2, "%" + searchTerm + "%");
            preparedStatement.setString(3, "%" + searchTerm + "%");
            preparedStatement.setString(4, "%" + searchTerm + "%");
            preparedStatement.setString(5, "%" + searchTerm + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                do {
                    int ID = resultSet.getInt("ID");
                    String name = resultSet.getString("Name");
                    String phoneNumber = resultSet.getString("Phone Number");
                    String specialization = resultSet.getString("Specialization");

                    retrievemodel.addRow(new Object[]{ID, name, phoneNumber, specialization});
                } while (resultSet.next());
            } else {
                JOptionPane.showMessageDialog(null, "No Staff Found!", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_searchFieldKeyTyped

    private void numberFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numberFieldKeyTyped
        char c = evt.getKeyChar();
        JTextField phoneNumber = (JTextField) evt.getSource();
        String currentText = phoneNumber.getText();
        int limit = 11;

        if (!Character.isDigit(c) || currentText.length() >= limit) {
            evt.consume();
        }
    }//GEN-LAST:event_numberFieldKeyTyped

    private void maleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleButtonActionPerformed
        if (maleButton.isSelected()) {
            genderSelect = "Male";
        }
    }//GEN-LAST:event_maleButtonActionPerformed

    private void femaleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleButtonActionPerformed
        if (femaleButton.isSelected()) {
            genderSelect = "Female";
        }
    }//GEN-LAST:event_femaleButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) staffsList.getModel();
        int minID = 100000;
        int maxID = 999999;

        Random random = new Random();
        int ID = random.nextInt(maxID - minID + 1) + minID;

        Object[] rowData = new Object[]{
            ID,
            nameField.getText(),
            numberField.getText(),
            birthField.getText(),
            genderSelect,
            specializationField.getText(),
            employmentField.getText(),
            availabilityField.getText(),
            shiftField.getText(),
            addInfo.getText()
        };
        model.addRow(rowData);

        JOptionPane.showMessageDialog(null, "Generated ID: " + ID, "Generated ID", JOptionPane.INFORMATION_MESSAGE);

        try {
            Connection connection = connect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO staffsTable (ID, Name, `Phone Number`, `Date of Birth`, Gender, Specialization, Employment, Availability, Shift, `Additional Info`)"
                    + "VALUES (?, ? ,? ,?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, ID);
            preparedStatement.setString(2, nameField.getText());
            preparedStatement.setString(3, numberField.getText());
            preparedStatement.setString(4, birthField.getText());
            preparedStatement.setString(5, genderSelect);
            preparedStatement.setString(6, specializationField.getText());
            preparedStatement.setString(7, employmentField.getText());
            preparedStatement.setString(8, availabilityField.getText());
            preparedStatement.setString(9, shiftField.getText());
            preparedStatement.setString(10, addInfo.getText());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        nameField.setText("");
        numberField.setText("");
        birthField.setText("");
        genderGroup.clearSelection();
        specializationField.setText("");
        employmentField.setText("");
        availabilityField.setText("");
        shiftField.setText("");
        addInfo.setText("");
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        int selectedRow = updateList.getSelectedRow();
        if (selectedRow == -1) {
            return;
        }

        int staffId = (int) updateList.getValueAt(selectedRow, 0);

        if (dataUpdate) {
            String url = connect.url;
            String user = connect.user;
            String password = connect.password;

            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                String query = "SELECT * FROM staffsTable WHERE ID = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, staffId);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString("Name");
                    String phoneNumber = resultSet.getString("Phone Number");
                    String birth = resultSet.getString("Date of Birth");
                    String gender = resultSet.getString("Gender");
                    String specialization = resultSet.getString("Specialization");
                    String employment = resultSet.getString("Employment");
                    String availability = resultSet.getString("Availability");
                    String shift = resultSet.getString("Shift");
                    String additionalInfo = resultSet.getString("Additional Info");

                    nameField.setText(name);
                    numberField.setText(phoneNumber);
                    birthField.setText(birth);
                    specializationField.setText(specialization);
                    employmentField.setText(employment);
                    availabilityField.setText(availability);
                    shiftField.setText(shift);
                    addInfo.setText(additionalInfo);

                    if (gender.equalsIgnoreCase("Male")) {
                        maleButton.setSelected(true);
                    } else if (gender.equalsIgnoreCase("Female")) {
                        femaleButton.setSelected(true);
                    }

                    dataUpdate = false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String updatedName = nameField.getText();
            String updatedPhoneNumber = numberField.getText();
            String updatedDob = birthField.getText();
            String updatedSpecialization = specializationField.getText();
            String updatedEmployment = employmentField.getText();
            String updatedAvailability = availabilityField.getText();
            String updatedShift = shiftField.getText();
            String updatedAdditionalInfo = addInfo.getText();

            String updatedGender = "";
            if (maleButton.isSelected()) {
                updatedGender = "Male";
            } else if (femaleButton.isSelected()) {
                updatedGender = "Female";
            } else {
            }

            String url = connect.url;
            String user = connect.user;
            String password = connect.password;

            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                String updateQuery = "UPDATE staffsTable SET Name = ?, `Phone Number` = ?, `Date of Birth` = ?, Gender = ?, Specialization = ?, Employment = ?, Availability = ?, Shift = ?, `Additional Info` = ? WHERE ID = ?";

                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setString(1, updatedName);
                updateStatement.setString(2, updatedPhoneNumber);
                updateStatement.setString(3, updatedDob);
                updateStatement.setString(4, updatedGender);
                updateStatement.setString(5, updatedSpecialization);
                updateStatement.setString(6, updatedEmployment);
                updateStatement.setString(7, updatedAvailability);
                updateStatement.setString(8, updatedShift);
                updateStatement.setString(9, updatedAdditionalInfo);
                updateStatement.setInt(10, staffId);
                updateStatement.executeUpdate();
                dataUpdate = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            nameField.setText("");
            numberField.setText("");
            birthField.setText("");
            genderGroup.clearSelection();
            specializationField.setText("");
            employmentField.setText("");
            availabilityField.setText("");
            shiftField.setText("");
            addInfo.setText("");
            retrieveData();
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int selectedRow = staffsList.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel delmodel = (DefaultTableModel) staffsList.getModel();
            int staffId = (int) delmodel.getValueAt(selectedRow, 0);

            int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this staff from the list?", "Confirmation", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                JTextField usernameField = new JTextField();
                JPasswordField passwordField = new JPasswordField();
                Object[] message = {
                    "Admin Username:", usernameField,
                    "Admin Password:", passwordField
                };
                int adminConfirm = JOptionPane.showConfirmDialog(null, message, "Admin Authentication", JOptionPane.OK_CANCEL_OPTION);
                if (adminConfirm == JOptionPane.OK_OPTION) {
                    String adminUsername = usernameField.getText();
                    String adminPassword = new String(passwordField.getPassword());

                    if (adminUsername.equals("admin") && adminPassword.equals("password")) {
                        delmodel.removeRow(selectedRow);
                        deleteData(staffId);
                        retrieveData();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid admin credentials. Staff removal canceled.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No staff selected.");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void staffsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffsListMouseClicked
        if (evt.getClickCount() == 2) {

            int selectedRow = staffsList.getSelectedRow();
            if (selectedRow >= 0) {
                int ID = (int) staffsList.getValueAt(selectedRow, 0);
                String name = (String) staffsList.getValueAt(selectedRow, 1);
                String phoneNumber = (String) staffsList.getValueAt(selectedRow, 2);
                String specialization = (String) staffsList.getValueAt(selectedRow, 3);

                String url = connect.url;
                String user = connect.user;
                String password = connect.password;

                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    String query = "SELECT * FROM staffsTable WHERE ID = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setInt(1, ID);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        String dob = resultSet.getString("Date of Birth");
                        String gender = resultSet.getString("Gender");
                        String employment = resultSet.getString("Employment");
                        String availability = resultSet.getString("Availability");
                        String shift = resultSet.getString("Shift");
                        String additionalInfo = resultSet.getString("Additional Info");

                        String message = "ID: " + ID + "\n"
                                + "Name: " + name + "\n"
                                + "Phone Number: " + phoneNumber + "\n"
                                + "Date of Birth: " + dob + "\n"
                                + "Gender: " + gender + "\n"
                                + "Specialization: " + specialization + "\n"
                                + "Employment: " + employment + "\n"
                                + "Availability: " + availability + "\n"
                                + "Shift: " + shift + "\n"
                                + "Additional Info: " + additionalInfo;

                        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_staffsListMouseClicked

    private void updateSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updateSearchKeyTyped
        DefaultTableModel retrievemodel = (DefaultTableModel) updateList.getModel();
        retrievemodel.setRowCount(0);

        String url = connect.url;
        String user = connect.user;
        String password = connect.password;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String searchTerm = searchField.getText().trim();

            String query = "SELECT * FROM staffsTable WHERE ID LIKE ? OR Name LIKE ? OR Specialization LIKE ? OR Availability LIKE ? OR Shift LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + searchTerm + "%");
            preparedStatement.setString(2, "%" + searchTerm + "%");
            preparedStatement.setString(3, "%" + searchTerm + "%");
            preparedStatement.setString(4, "%" + searchTerm + "%");
            preparedStatement.setString(5, "%" + searchTerm + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                do {
                    int ID = resultSet.getInt("ID");
                    String name = resultSet.getString("Name");
                    String phoneNumber = resultSet.getString("Phone Number");
                    String specialization = resultSet.getString("Specialization");

                    retrievemodel.addRow(new Object[]{ID, name, phoneNumber, specialization});
                } while (resultSet.next());
            } else {
                JOptionPane.showMessageDialog(null, "No Staff Found!", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateSearchKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String url = connect.url;
        String user = connect.user;
        String dbPassword = connect.password;

        int option = JOptionPane.showConfirmDialog(null, "Forgot Password?", "Password Reset", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            boolean idMatch = false;

            while (!idMatch) {
                String enteredID = JOptionPane.showInputDialog(null, "Enter Staff ID:");
                int id = Integer.parseInt(enteredID);

                try (Connection connection = DriverManager.getConnection(url, user, dbPassword)) {
                    String selectQuery = "SELECT COUNT(*) FROM accountsTable WHERE ID = ?";
                    PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
                    selectStatement.setInt(1, id);
                    ResultSet resultSet = selectStatement.executeQuery();
                    resultSet.next();

                    int count = resultSet.getInt(1);
                    if (count > 0) {
                        idMatch = true;

                        String newPassword = "";
                        String confirmPassword = "";

                        while (newPassword.length() < 6 || !newPassword.equals(confirmPassword)) {
                            JPasswordField passwordField = new JPasswordField();
                            JPasswordField confirmPasswordField = new JPasswordField();
                            Object[] message = {
                                "New Password (at least 6 characters):", passwordField,
                                "Confirm Password:", confirmPasswordField
                            };
                            int confirmOption = JOptionPane.showConfirmDialog(null, message, "Reset Password", JOptionPane.OK_CANCEL_OPTION);

                            if (confirmOption == JOptionPane.OK_OPTION) {
                                newPassword = new String(passwordField.getPassword());
                                confirmPassword = new String(confirmPasswordField.getPassword());

                                if (newPassword.length() < 6) {
                                    JOptionPane.showMessageDialog(null, "Password must be at least 6 characters long.", "Error", JOptionPane.ERROR_MESSAGE);
                                } else if (!newPassword.equals(confirmPassword)) {
                                    JOptionPane.showMessageDialog(null, "Passwords do not match. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Password reset canceled.", "Canceled", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            }
                        }

                        if (newPassword.length() >= 6 && newPassword.equals(confirmPassword)) {
                            int confirmation = JOptionPane.showConfirmDialog(null, "Confirm password reset?", "Confirmation", JOptionPane.YES_NO_OPTION);
                            if (confirmation == JOptionPane.YES_OPTION) {
                                String updateQuery = "UPDATE accountsTable SET Password = ? WHERE ID = ?";
                                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                                updateStatement.setString(1, newPassword);
                                updateStatement.setInt(2, id);
                                updateStatement.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Password updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Staff ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String id = idField.getText();
        String name = NameField.getText();
        String password = passwordField.getText();
        String confirmpassword = confirmPassword.getText();

        if (id.isEmpty() || name.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill all fields", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
        } else if (id.isEmpty() && name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID and Name are empty", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
        } else if (id.isEmpty() && password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID and password are empty", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
        } else if (name.isEmpty() && password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name and password are empty", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
        } else if (!confirmpassword.equals(password)) {
            JOptionPane.showMessageDialog(null, "Passwords do not match", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
        } else if (password.length() < 6) {
            JOptionPane.showMessageDialog(null, "Password must be longer than 6 characters", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                Connection connection = connect.getConnection();

                String query = "INSERT INTO accountsTable (ID, Name, Password) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, password);

                preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();

                JOptionPane.showMessageDialog(null, "Account Registered", "SUCCESS!", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int logout = JOptionPane.showConfirmDialog(null, "This will bring you back to login. Are you Sure?", "WARNING!", JOptionPane.YES_NO_OPTION);
        if (logout == JOptionPane.YES_OPTION) {
            dispose();
            loginFrame login = new loginFrame();
            login.setVisible(true);
        } else {
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new staffsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NameField;
    private javax.swing.JButton addButton;
    private javax.swing.JTextArea addInfo;
    private javax.swing.JPanel addaccount;
    private javax.swing.JPanel addstaffPanel;
    private javax.swing.JButton appointmentsButton;
    private javax.swing.JTextField availabilityField;
    private javax.swing.JButton billingButton;
    private javax.swing.JTextField birthField;
    private com.raven.datechooser.DateChooser calendar;
    private javax.swing.JPasswordField confirmPassword;
    private javax.swing.JButton dashboardButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField employmentField;
    private javax.swing.JRadioButton femaleButton;
    private javax.swing.ButtonGroup genderGroup;
    private javax.swing.JTextField idField;
    private javax.swing.JButton inventoryButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JRadioButton maleButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField numberField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton patientsButton;
    private javax.swing.JButton pharmacyButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextField shiftField;
    private javax.swing.JTextField specializationField;
    private javax.swing.JButton staffsButton;
    private javax.swing.JTable staffsList;
    private javax.swing.JPanel staffsPanel;
    private javax.swing.JButton updateButton;
    private javax.swing.JTable updateList;
    private javax.swing.JTextField updateSearch;
    // End of variables declaration//GEN-END:variables
}
