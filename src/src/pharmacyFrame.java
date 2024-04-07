package src;

import db.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class pharmacyFrame extends javax.swing.JFrame {

    public pharmacyFrame() {
        initComponents();
        retrieveData();
    }

    void retrieveData() {
        DefaultTableModel retrievemodel = (DefaultTableModel) inventoryList.getModel();
        retrievemodel.setRowCount(0);

        try {
            Connection connection = connect.getConnection();
            String query = "SELECT * FROM inventoryTable";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String productname = resultSet.getString("Product Name");
                String manufacturer = resultSet.getString("Manufacturer");
                String quantity = resultSet.getString("Quantity");
                String price = resultSet.getString("Price");
                String expirydate = resultSet.getString("Expiry Date");

                retrievemodel.addRow(new Object[]{ID, productname, manufacturer, quantity, price, expirydate});
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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventoryList = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        overviewList = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        subtotalField = new javax.swing.JLabel();
        taxField = new javax.swing.JLabel();
        discountField = new javax.swing.JLabel();
        totalField = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        payButton = new javax.swing.JButton();
        discountButton = new javax.swing.JButton();
        toBilling = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        mopBox = new javax.swing.JComboBox<>();
        cashField = new javax.swing.JTextField();
        changeField = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setMaximumSize(new java.awt.Dimension(1280, 600));
        jPanel3.setPreferredSize(new java.awt.Dimension(1280, 600));
        jPanel3.setSize(new java.awt.Dimension(1280, 600));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inventory List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 13))); // NOI18N

        inventoryList.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        inventoryList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Product Name", "Manufacturer", "Quantity", "Price", "Expiry Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        inventoryList.setRowHeight(30);
        inventoryList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                inventoryListMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(inventoryList);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Overview", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 13))); // NOI18N

        overviewList.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        overviewList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        overviewList.setRowHeight(30);
        jScrollPane2.setViewportView(overviewList);

        jLabel1.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel1.setText("SubTotal");

        jLabel2.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel2.setText("Tax");

        jLabel3.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel3.setText("Discount");

        jLabel4.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        jLabel4.setText("Total");

        subtotalField.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        subtotalField.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        taxField.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        taxField.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        discountField.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        discountField.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        totalField.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        totalField.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subtotalField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(taxField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(discountField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subtotalField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(taxField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(discountField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        payButton.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        payButton.setText("Pay");
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });

        discountButton.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        discountButton.setText("Discount");
        discountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountButtonActionPerformed(evt);
            }
        });

        toBilling.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        toBilling.setText("Billing");
        toBilling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toBillingActionPerformed(evt);
            }
        });

        removeButton.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        removeButton.setForeground(new java.awt.Color(255, 51, 51));
        removeButton.setText("Void");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        mopBox.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        mopBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "GCash", "Debit", "Credit" }));

        cashField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N

        changeField.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Mode of Payment:");

        jLabel7.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Cash:");

        jLabel8.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Change:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(434, 434, 434)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(mopBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cashField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(changeField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(discountButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(toBilling, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(payButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(payButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(discountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(toBilling, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mopBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cashField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(changeField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 120, 1280, 600);

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
        appointmentsFrame appointments = new appointmentsFrame();
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
        staffsFrame staffs = new staffsFrame();
        staffs.setVisible(true);
    }//GEN-LAST:event_staffsButtonActionPerformed

    private void inventoryListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryListMouseReleased
        int selectedRowIndex = inventoryList.getSelectedRow();

        String productName = inventoryList.getValueAt(selectedRowIndex, 1).toString();
        double price = Double.parseDouble(inventoryList.getValueAt(selectedRowIndex, 4).toString());

        int quantity = 1;

        DefaultTableModel model = (DefaultTableModel) overviewList.getModel();

        boolean productExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String existingProductName = model.getValueAt(i, 0).toString();
            if (existingProductName.equals(productName)) {
                int existingQuantity = Integer.parseInt(model.getValueAt(i, 1).toString());
                double existingPrice = Double.parseDouble(model.getValueAt(i, 2).toString());
                double updatedPrice = existingPrice;
                int updatedQuantity = existingQuantity + quantity;

                DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
                String formattedPrice = decimalFormat.format(updatedPrice);

                model.setValueAt(updatedQuantity, i, 1);
                model.setValueAt(formattedPrice, i, 2);
                productExists = true;
                break;
            }
        }

        if (!productExists) {
            model.addRow(new Object[]{productName, quantity, price});
        }

        double subtotal = 0.0;
        for (int i = 0; i < model.getRowCount(); i++) {
            int itemQuantity = Integer.parseInt(model.getValueAt(i, 1).toString());
            double itemPrice = Double.parseDouble(model.getValueAt(i, 2).toString());
            subtotal += itemPrice * itemQuantity;
        }

        double taxRate = 0.01;
        double tax = subtotal * taxRate;
        double totalPrice = subtotal + tax;

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        subtotalField.setText(decimalFormat.format(subtotal));
        taxField.setText(decimalFormat.format(tax));
        totalField.setText(decimalFormat.format(totalPrice));
    }//GEN-LAST:event_inventoryListMouseReleased

    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payButtonActionPerformed
        String cashAmountText = cashField.getText();
        if (cashAmountText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No payment received.");
            return;
        }

        double total = Double.parseDouble(totalField.getText().replace(",", ""));
        double cashAmount = Double.parseDouble(cashAmountText);
        double change = cashAmount - total;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedChange = decimalFormat.format(change);
        changeField.setText(formattedChange);

        if (cashAmount < total) {
            JOptionPane.showMessageDialog(null, "Invalid amount. The cash amount is less than the total.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) overviewList.getModel();
        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String productName = model.getValueAt(i, 0).toString();
            int quantityBought = Integer.parseInt(model.getValueAt(i, 1).toString());

            String selectQuery = "SELECT Quantity, ID, Manufacturer, Price FROM inventoryTable WHERE `Product Name` = ?";
            try (PreparedStatement selectStatement = connect.getConnection().prepareStatement(selectQuery)) {
                selectStatement.setString(1, productName);
                try (ResultSet resultSet = selectStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String currentQuantityStr = resultSet.getString("Quantity").trim();
                        int productID = resultSet.getInt("ID");
                        String manufacturer = resultSet.getString("Manufacturer");
                        double price = resultSet.getDouble("Price");

                        int currentQuantity = Integer.parseInt(currentQuantityStr);

                        if (currentQuantity >= quantityBought) {
                            int updatedQuantity = currentQuantity - quantityBought;
                            String updateQuery = "UPDATE inventoryTable SET Quantity = ? WHERE `Product Name` = ?";
                            try (PreparedStatement updateStatement = connect.getConnection().prepareStatement(updateQuery)) {
                                updateStatement.setInt(1, updatedQuantity);
                                updateStatement.setString(2, productName);
                                updateStatement.executeUpdate();

                                System.out.println("Quantity Updated");

                                double totalSold = quantityBought * price;

                                String insertQuery = "INSERT INTO salesTable (ID, `Product Name`, Manufacturer, Quantity, Price, `Expiry Date`, `Date and Time Sold`) VALUES (?, ?, ?, ?, ?, ?, ?)";
                                try (PreparedStatement insertStatement = connect.getConnection().prepareStatement(insertQuery)) {
                                    insertStatement.setInt(1, productID);
                                    insertStatement.setString(2, productName);
                                    insertStatement.setString(3, manufacturer);
                                    insertStatement.setInt(4, quantityBought);
                                    insertStatement.setDouble(5, price);

                                    String expiryDateQuery = "SELECT `Expiry Date` FROM inventoryTable WHERE `Product Name` = ? AND `ID` = ?";
                                    try (PreparedStatement expiryDateStatement = connect.getConnection().prepareStatement(expiryDateQuery)) {
                                        expiryDateStatement.setString(1, productName);
                                        expiryDateStatement.setInt(2, productID);

                                        try (ResultSet expiryDateResultSet = expiryDateStatement.executeQuery()) {
                                            if (expiryDateResultSet.next()) {
                                                String expiryDate = expiryDateResultSet.getString("Expiry Date");
                                                insertStatement.setString(6, expiryDate);
                                            }
                                        }

                                        Date currentDate = new Date();
                                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                        String formattedDateTime = dateFormat.format(currentDate);

                                        insertStatement.setString(7, formattedDateTime);

                                        insertStatement.executeUpdate();
                                        System.out.println("Sale recorded");
                                    } catch (SQLException e) {
                                        System.out.println("Error occurred while inserting sales data: " + e.getMessage());
                                        e.printStackTrace();
                                    }
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Quantity exceeded the number of inventory stocks.", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
                            model.removeRow(i);
                            i--;
                        }
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error occurred while querying or updating the database: " + e.getMessage());
                e.printStackTrace();
            }
        }

        String paymentMethod = mopBox.getSelectedItem().toString();
        receiptFrame receipt = new receiptFrame();

        if (paymentMethod.equals("Debit") || paymentMethod.equals("Credit")) {
            JOptionPane.showOptionDialog(null, "Swipe or Tap the card onto the Reader.", "PROCESSING", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Print Receipt"}, null);
            receipt.getSubtotal.setText("₱" + subtotalField.getText());
            receipt.getTax.setText("₱" + taxField.getText());
            receipt.getDiscount.setText("₱" + discountField.getText());
            receipt.getTotal.setText("₱" + totalField.getText());
            dispose();
            adminpharmacyFrame pharmacy = new adminpharmacyFrame();
            pharmacy.setVisible(true);
        } else if (paymentMethod.equals("GCash")) {
            JOptionPane.showOptionDialog(null, null, "Scan QR", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Print Receipt"}, null);
            receipt.getSubtotal.setText("₱" + subtotalField.getText());
            receipt.getTax.setText("₱" + taxField.getText());
            receipt.getDiscount.setText("₱" + discountField.getText());
            receipt.getTotal.setText("₱" + totalField.getText());
            dispose();
            adminpharmacyFrame pharmacy = new adminpharmacyFrame();
            pharmacy.setVisible(true);
        } else if (paymentMethod.equals("Cash")) {
            JOptionPane.showOptionDialog(null, "Transaction Successful", "SUCCESS!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Print Receipt"}, null);
            receipt.getSubtotal.setText("₱" + subtotalField.getText());
            receipt.getTax.setText("₱" + taxField.getText());
            receipt.getDiscount.setText("₱" + discountField.getText());
            receipt.getTotal.setText("₱" + totalField.getText());
            dispose();
            adminpharmacyFrame pharmacy = new adminpharmacyFrame();
            pharmacy.setVisible(true);
        }
        DefaultTableModel receiptModel = (DefaultTableModel) receipt.overviewList.getModel();
        for (int i = 0; i < rowCount; i++) {
            String productName = model.getValueAt(i, 0).toString();
            int quantityBought = Integer.parseInt(model.getValueAt(i, 1).toString());
            double price = Double.parseDouble(model.getValueAt(i, 2).toString());
            receiptModel.addRow(new Object[]{productName, quantityBought, price});
        }
        receipt.setVisible(true);
    }//GEN-LAST:event_payButtonActionPerformed

    private void toBillingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toBillingActionPerformed
        String patientNameOrId = JOptionPane.showInputDialog(null, "Enter the Patient ID or Patient Name");
        if (patientNameOrId != null && !patientNameOrId.isEmpty()) {
            try {
                Connection connection = connect.getConnection();
                String query = "SELECT PID, `Medication Total` FROM billingTable WHERE PID IN (SELECT PID FROM patientTable WHERE TRIM(`Patient Name`) = ? OR PID = ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, patientNameOrId);
                preparedStatement.setString(2, patientNameOrId);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    int patientId = resultSet.getInt("PID");
                    double existingMedicationTotal = resultSet.getDouble("Medication Total");

                    double newMedicationTotal = existingMedicationTotal + Double.parseDouble(totalField.getText().replace(",", ""));

                    String formattedMedicationTotal = String.format("%.2f", newMedicationTotal);

                    String patientNameQuery = "SELECT `Patient Name` FROM patientTable WHERE PID = ?";
                    PreparedStatement patientNameStatement = connection.prepareStatement(patientNameQuery);
                    patientNameStatement.setInt(1, patientId);
                    ResultSet patientNameResultSet = patientNameStatement.executeQuery();

                    if (patientNameResultSet.next()) {
                        String patientName = patientNameResultSet.getString("Patient Name");

                        String message = "Patient ID: " + patientId + "\nPatient Name: " + patientName + "\n\nAdd the bill to the patient?";
                        int confirm = JOptionPane.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            String updateQuery = "UPDATE billingTable SET `Medication Total` = ? WHERE PID = ?";
                            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                            updateStatement.setString(1, formattedMedicationTotal);
                            updateStatement.setInt(2, patientId);
                            updateStatement.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Bill added successfully.");

                            DefaultTableModel model = (DefaultTableModel) overviewList.getModel();
                            int rowCount = model.getRowCount();
                            for (int i = 0; i < rowCount; i++) {
                                String productName = model.getValueAt(i, 0).toString();
                                int quantityBought = Integer.parseInt(model.getValueAt(i, 1).toString());

                                String productQuery = "SELECT ID, Manufacturer, `Expiry Date` FROM inventoryTable WHERE `Product Name` = ?";
                                PreparedStatement productStatement = connection.prepareStatement(productQuery);
                                productStatement.setString(1, productName);
                                ResultSet productResultSet = productStatement.executeQuery();

                                if (productResultSet.next()) {
                                    int productId = productResultSet.getInt("ID");
                                    String manufacturer = productResultSet.getString("Manufacturer");
                                    String expiryDate = productResultSet.getString("Expiry Date");

                                    String updateQuantityQuery = "UPDATE inventoryTable SET Quantity = Quantity - ? WHERE `Product Name` = ?";
                                    PreparedStatement updateQuantityStatement = connection.prepareStatement(updateQuantityQuery);
                                    updateQuantityStatement.setInt(1, quantityBought);
                                    updateQuantityStatement.setString(2, productName);
                                    updateQuantityStatement.executeUpdate();

                                    String insertQuery = "INSERT INTO salesTable (ID, `Product Name`, Manufacturer, `Expiry Date`, Quantity, Price, `Date and Time Sold`) VALUES (?, ?, ?, ?, ?, ?, ?)";
                                    PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
                                    insertStatement.setInt(1, productId);
                                    insertStatement.setString(2, productName);
                                    insertStatement.setString(3, manufacturer);
                                    insertStatement.setString(4, expiryDate);
                                    insertStatement.setInt(5, quantityBought);
                                    insertStatement.setDouble(6, Double.parseDouble(totalField.getText().replace(",", "")));

                                    Date currentDate = new Date();
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    String formattedDateTime = dateFormat.format(currentDate);

                                    insertStatement.setString(7, formattedDateTime);

                                    insertStatement.executeUpdate();
                                    System.out.println("Sale recorded");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Product not found in inventory.");
                                }

                                productStatement.close();
                                productResultSet.close();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Bill not added.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Patient name not found.");
                    }

                    patientNameStatement.close();
                    resultSet.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Patient not found.");
                }

                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter the patient name or ID.");
        }
        dispose();
        pharmacyFrame pharmacy = new pharmacyFrame();
        pharmacy.setVisible(true);
    }//GEN-LAST:event_toBillingActionPerformed

    private void discountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountButtonActionPerformed
        String discountRate = JOptionPane.showInputDialog(null, "Enter discount amount: (Percentage)", "Discount", JOptionPane.QUESTION_MESSAGE);

        if (discountRate == null || discountRate.isEmpty()) {
            return;
        }

        double discountAmount = Double.parseDouble(discountRate);

        double subtotal = Double.parseDouble(subtotalField.getText().replace(",", ""));
        double tax = Double.parseDouble(taxField.getText().replace(",", ""));
        double discount = subtotal * (discountAmount / 100.0);
        double totalPrice = subtotal + tax - discount;

        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
        decimalFormat.applyPattern("#,##0.00");

        String formattedDiscount = decimalFormat.format(discount);
        String formattedTotalPrice = decimalFormat.format(totalPrice);

        discountField.setText(formattedDiscount);
        totalField.setText(formattedTotalPrice);
    }//GEN-LAST:event_discountButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int selectedRowIndex = overviewList.getSelectedRow();
        if (selectedRowIndex != -1) {
            int confirm = JOptionPane.showConfirmDialog(null, "This will remove the selected item. Are you sure you want to proceed?", "Remove Item", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
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

                    // Perform admin authentication logic here
                    // Replace the condition below with your actual authentication logic
                    if (adminUsername.equals("admin") && adminPassword.equals("admin")) {
                        DefaultTableModel model = (DefaultTableModel) overviewList.getModel();
                        model.removeRow(selectedRowIndex);

                        // Compute Subtotal
                        double subtotal = 0.0;
                        int rowCount = model.getRowCount();
                        for (int i = 0; i < rowCount; i++) {
                            double price = Double.parseDouble(model.getValueAt(i, 2).toString());
                            int quantity = Integer.parseInt(model.getValueAt(i, 1).toString());
                            subtotal += price * quantity;
                        }

                        // Compute Tax (assuming a tax rate of 12%)
                        double taxRate = 0.12;
                        double tax = subtotal * taxRate;

                        // Compute Total
                        double total = subtotal + tax;

                        // Update the respective fields in the receipt frame
                        subtotalField.setText("₱" + String.format("%.2f", subtotal));
                        taxField.setText("₱" + String.format("%.2f", tax));
                        totalField.setText("₱" + String.format("%.2f", total));
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid admin credentials. Item removal canceled.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No item selected.");
        }
    }//GEN-LAST:event_removeButtonActionPerformed

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
                new pharmacyFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton appointmentsButton;
    private javax.swing.JButton billingButton;
    private javax.swing.JTextField cashField;
    private javax.swing.JLabel changeField;
    private javax.swing.JButton dashboardButton;
    private javax.swing.JButton discountButton;
    private javax.swing.JLabel discountField;
    private javax.swing.JButton inventoryButton;
    private javax.swing.JTable inventoryList;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel logo;
    private javax.swing.JComboBox<String> mopBox;
    private javax.swing.JTable overviewList;
    private javax.swing.JButton patientsButton;
    private javax.swing.JButton payButton;
    private javax.swing.JButton pharmacyButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton staffsButton;
    private javax.swing.JLabel subtotalField;
    private javax.swing.JLabel taxField;
    private javax.swing.JButton toBilling;
    private javax.swing.JLabel totalField;
    // End of variables declaration//GEN-END:variables
}
