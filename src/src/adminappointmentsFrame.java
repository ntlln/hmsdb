package src;

import db.connect;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Allen Caingcoy
 */
public class adminappointmentsFrame extends javax.swing.JFrame {

    public static boolean dataUpdate = true;

    public adminappointmentsFrame() {
        initComponents();
        calendar.setTextField(dateField);
        calendar.setDateFormat(new SimpleDateFormat("MMM-dd-yyyy"));
        retrieveData();
        updateData();
    }

    void retrieveData() {
        DefaultTableModel retrievemodel = (DefaultTableModel) appointmentList.getModel();
        retrievemodel.setRowCount(0);

        String url = connect.url;
        String user = connect.user;
        String password = connect.password;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM appointmentTable";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("Patient Name");
                String guardian = resultSet.getString("Guardian Name");
                String phonenumber = resultSet.getString("Phone Number");
                String concern = resultSet.getString("Concern");
                String dat = resultSet.getString("Date and Time");

                retrievemodel.addRow(new Object[]{ID, name, guardian, phonenumber, concern, dat});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void deleteData(int Id) {
        String url = connect.url;
        String user = connect.user;
        String password = connect.password;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String checkQuery = "SELECT ID FROM appointmentTable WHERE ID = ?";
            PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
            checkStatement.setInt(1, Id);
            ResultSet checkResultSet = checkStatement.executeQuery();

            if (checkResultSet.next()) {
                String deleteQuery = "DELETE FROM appointmentTable WHERE ID = ?";
                PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                deleteStatement.setInt(1, Id);
                deleteStatement.executeUpdate();

                String updateQuery = "UPDATE appointmentTable SET ID = ID - 1 WHERE ID > ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setInt(1, Id);
                updateStatement.executeUpdate();

            } else {
                System.out.println("ID does not exist.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void updateData() {
        DefaultTableModel retrievemodel = (DefaultTableModel) updateList.getModel();
        retrievemodel.setRowCount(0);

        String url = connect.url;
        String user = connect.user;
        String password = connect.password;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM appointmentTable";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("Patient Name");
                String phonenumber = resultSet.getString("Phone Number");
                String dat = resultSet.getString("Date and Time");

                retrievemodel.addRow(new Object[]{ID, name, phonenumber, dat});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        calendar = new com.raven.datechooser.DateChooser();
        clock = new com.raven.swing.TimePicker();
        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        dashboardButton = new javax.swing.JButton();
        billingButton = new javax.swing.JButton();
        patientsButton = new javax.swing.JButton();
        appointmentsButton = new javax.swing.JButton();
        pharmacyButton = new javax.swing.JButton();
        inventoryButton = new javax.swing.JButton();
        staffsButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        addpatientPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        patientName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        guardianName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        phoneNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        concernField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dateField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        timeField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        updateSearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        updateList = new javax.swing.JTable();
        patientsPanel = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        appointmentList = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();

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

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rsc/logout.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jTabbedPane1.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jTabbedPane1.setMaximumSize(new java.awt.Dimension(1280, 600));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(1280, 600));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1280, 600));
        jTabbedPane1.setSize(new java.awt.Dimension(1280, 600));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Appointment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 24))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel2.setText("Patient Name");

        patientName.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel3.setText("Guardian Name");

        guardianName.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel4.setText("Phone Number");

        phoneNumber.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        phoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneNumberKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel5.setText("Concern");

        concernField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel6.setText("Date");

        dateField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel7.setText("Time");

        timeField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        timeField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                timeFieldMouseReleased(evt);
            }
        });

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

        jLabel8.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Search:");

        updateButton.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        updateList.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        updateList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PID", "Patient Name", "Phone Number", "Date and Time"
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(patientName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(guardianName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(concernField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(100, 100, 100)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(patientName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(guardianName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(concernField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout addpatientPanelLayout = new javax.swing.GroupLayout(addpatientPanel);
        addpatientPanel.setLayout(addpatientPanelLayout);
        addpatientPanelLayout.setHorizontalGroup(
            addpatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        addpatientPanelLayout.setVerticalGroup(
            addpatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Add Appointment", addpatientPanel);

        patientsPanel.setBackground(new java.awt.Color(255, 255, 255));
        patientsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Appointments", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 24))); // NOI18N

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

        appointmentList.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        appointmentList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Patient Name", "Guardian Name", "Phone Number", "Concern", "Date and Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        appointmentList.setRowHeight(30);
        jScrollPane1.setViewportView(appointmentList);

        jLabel1.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Search:");
        jLabel1.setMaximumSize(new java.awt.Dimension(90, 40));
        jLabel1.setMinimumSize(new java.awt.Dimension(90, 40));
        jLabel1.setPreferredSize(new java.awt.Dimension(90, 40));
        jLabel1.setSize(new java.awt.Dimension(90, 40));

        deleteButton.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 51, 51));
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout patientsPanelLayout = new javax.swing.GroupLayout(patientsPanel);
        patientsPanel.setLayout(patientsPanelLayout);
        patientsPanelLayout.setHorizontalGroup(
            patientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patientsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1270, Short.MAX_VALUE)
        );
        patientsPanelLayout.setVerticalGroup(
            patientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientsPanelLayout.createSequentialGroup()
                .addGroup(patientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Appointments", patientsPanel);

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

    private void searchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyTyped
        DefaultTableModel retrievemodel = (DefaultTableModel) appointmentList.getModel();
        retrievemodel.setRowCount(0);

        String url = connect.url;
        String user = connect.user;
        String password = connect.password;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String searchTerm = searchField.getText().trim();

            String query = "SELECT * FROM appointmentTable WHERE ID LIKE ? OR `Patient Name` LIKE ? OR `Guardian Name` LIKE ? OR Concern LIKE ? OR `Date and Time` LIKE ?";
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
                    String name = resultSet.getString("Patient Name");
                    String guardian = resultSet.getString("Guardian Name");
                    String phonenumber = resultSet.getString("Phone Number");
                    String concern = resultSet.getString("Concern");
                    String dat = resultSet.getString("Date and Time");

                    retrievemodel.addRow(new Object[]{ID, name, guardian, phonenumber, concern, dat});
                } while (resultSet.next());
            } else {
                JOptionPane.showMessageDialog(null, "No Appointment Found!", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_searchFieldKeyTyped

    private void phoneNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNumberKeyTyped
        char c = evt.getKeyChar();
        JTextField phoneNumber = (JTextField) evt.getSource();
        String currentText = phoneNumber.getText();
        int limit = 11;

        if (!Character.isDigit(c) || currentText.length() >= limit) {
            evt.consume();
        }
    }//GEN-LAST:event_phoneNumberKeyTyped

    private void timeFieldMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeFieldMouseReleased
        clock.showPopup(this, 340, 350);
        clock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeField.setText(clock.getSelectedTime());
            }
        });
    }//GEN-LAST:event_timeFieldMouseReleased

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) appointmentList.getModel();
        int rowCount = model.getRowCount();
        int ID = rowCount + 1;
        String datetime = dateField.getText() + " " + timeField.getText();

        Object[] rowData = new Object[]{
            ID,
            patientName.getText(),
            guardianName.getText(),
            phoneNumber.getText(),
            concernField.getText(),
            datetime
        };

        model.addRow(rowData);
        model.setValueAt(ID, rowCount, 0);

        try {
            Connection connection = connect.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO appointmentTable (ID, `Patient Name`, `Guardian Name`, `Phone Number`, Concern, `Date and Time`) "
                    + "VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, ID);
            preparedStatement.setString(2, patientName.getText());
            preparedStatement.setString(3, guardianName.getText());
            preparedStatement.setString(4, phoneNumber.getText());
            preparedStatement.setString(5, concernField.getText());
            preparedStatement.setString(6, datetime);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        patientName.setText("");
        guardianName.setText("");
        phoneNumber.setText("");
        concernField.setText("");
        dateField.setText("");
        timeField.setText("");
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        int selectedRow = updateList.getSelectedRow();
        if (selectedRow == -1) {
            return;
        }

        int appointmentId = (int) updateList.getValueAt(selectedRow, 0);

        if (dataUpdate) {
            String url = connect.url;
            String user = connect.user;
            String password = connect.password;

            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                String query = "SELECT * FROM appointmentTable WHERE ID = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, appointmentId);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString("Patient Name");
                    String guardianname = resultSet.getString("Guardian Name");
                    String phonenumber = resultSet.getString("Phone Number");
                    String concern = resultSet.getString("Concern");
                    String timeAndDate = resultSet.getString("Date and Time");

                    patientName.setText(name);
                    guardianName.setText(guardianname);
                    phoneNumber.setText(phonenumber);
                    concernField.setText(concern);
                    String[] dateTimeParts = timeAndDate.split(" ");
                    if (dateTimeParts.length == 2) {
                        dateField.setText(dateTimeParts[0]);
                        timeField.setText(dateTimeParts[1]);
                    }
                    dataUpdate = false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String updatedName = patientName.getText();
            String updatedGuardianName = guardianName.getText();
            String updatedPhoneNumber = phoneNumber.getText();
            String updatedConcern = concernField.getText();
            String updatedTime = timeField.getText();
            String updatedDate = dateField.getText();
            String updatedDateTime = updatedDate + " " + updatedTime;

            try {
                Connection connection = connect.getConnection();

                String updateQuery = "UPDATE appointmentTable SET `Patient Name` = ?, `Guardian Name` = ?, `Phone Number` = ?, Concern = ?, `Date and Time` = ? WHERE ID = ?";

                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setString(1, updatedName);
                updateStatement.setString(2, updatedGuardianName);
                updateStatement.setString(3, updatedPhoneNumber);
                updateStatement.setString(4, updatedConcern);
                updateStatement.setString(5, updatedDateTime);
                updateStatement.setInt(6, appointmentId);
                updateStatement.executeUpdate();
                dataUpdate = true;
                retrieveData();
                updateData();

                updateStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            patientName.setText("");
            guardianName.setText("");
            phoneNumber.setText("");
            concernField.setText("");
            dateField.setText("");
            timeField.setText("");
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int selectedRow = appointmentList.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel delmodel = (DefaultTableModel) appointmentList.getModel();
            int patientId = (int) delmodel.getValueAt(selectedRow, 0);

            int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this appointment?", "Confirmation", JOptionPane.YES_NO_OPTION);

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

                    if (adminUsername.equals("admin") && adminPassword.equals("admin")) {
                        delmodel.removeRow(selectedRow);
                        deleteData(patientId);
                        retrieveData();
                        updateData();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid admin credentials. Appointment removal canceled.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No appointment selected.");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updateSearchKeyTyped
        DefaultTableModel retrievemodel = (DefaultTableModel) updateList.getModel();
        retrievemodel.setRowCount(0);

        String url = connect.url;
        String user = connect.user;
        String password = connect.password;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String searchTerm = updateSearch.getText();

            String query = "SELECT * FROM appointmentTable WHERE ID LIKE ? OR `Patient Name` LIKE ? OR `Guardian Name` LIKE ? OR Concern LIKE ? OR `Date and Time` LIKE ?";
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
                    String name = resultSet.getString("Patient Name");
                    String phonenumber = resultSet.getString("Phone Number");
                    String dat = resultSet.getString("Date and Time");

                    retrievemodel.addRow(new Object[]{ID, name, phonenumber, dat});
                } while (resultSet.next());
            } else {
                JOptionPane.showMessageDialog(null, "No Appointment Found!", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateSearchKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int logout = JOptionPane.showConfirmDialog(null, "This will bring you back to login. Are you Sure?", "WARNING!", JOptionPane.YES_NO_OPTION);
        if (logout == JOptionPane.YES_OPTION) {
            dispose();
            loginFrame login = new loginFrame();
            login.setVisible(true);
        } else {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminappointmentsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel addpatientPanel;
    private javax.swing.JTable appointmentList;
    private javax.swing.JButton appointmentsButton;
    private javax.swing.JButton billingButton;
    private com.raven.datechooser.DateChooser calendar;
    private com.raven.swing.TimePicker clock;
    private javax.swing.JTextField concernField;
    private javax.swing.JButton dashboardButton;
    private javax.swing.JTextField dateField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField guardianName;
    private javax.swing.JButton inventoryButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField patientName;
    private javax.swing.JButton patientsButton;
    private javax.swing.JPanel patientsPanel;
    private javax.swing.JButton pharmacyButton;
    private javax.swing.JTextField phoneNumber;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton staffsButton;
    private javax.swing.JTextField timeField;
    private javax.swing.JButton updateButton;
    private javax.swing.JTable updateList;
    private javax.swing.JTextField updateSearch;
    // End of variables declaration//GEN-END:variables
}
