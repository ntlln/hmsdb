package src;

import db.connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Allen Caingcoy
 */
public class admininventoryFrame extends javax.swing.JFrame {

    public static boolean dataUpdate = true;

    public admininventoryFrame() {
        initComponents();
        calendar.setTextField(expirationField);
        calendar.setDateFormat(new SimpleDateFormat("yyyy-dd-MM"));
        retrieveData();
        salesData();
        updateData();
        LowStocksData();
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

    void deleteData(int Id) {
        try {
            Connection connection = connect.getConnection();
            String checkQuery = "SELECT ID FROM inventoryTable WHERE ID = ?";
            PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
            checkStatement.setInt(1, Id);
            ResultSet checkResultSet = checkStatement.executeQuery();

            if (checkResultSet.next()) {
                String deleteQuery = "DELETE FROM inventoryTable WHERE ID = ?";
                PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                deleteStatement.setInt(1, Id);
                deleteStatement.executeUpdate();

                String updateQuery = "UPDATE inventoryTable SET ID = ID - 1 WHERE ID > ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setInt(1, Id);
                updateStatement.executeUpdate();
            } else {
                System.out.println("ID does not exist.");
            }

            checkStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void salesData() {
        DefaultTableModel model = (DefaultTableModel) salesList.getModel();
        model.setRowCount(0);

        String url = connect.url;
        String user = connect.user;
        String password = connect.password;

        double totalSales = 0.0;
        String formattedPrice = "";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM salesTable";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String product = resultSet.getString("Product Name");
                String developer = resultSet.getString("Manufacturer");
                int quantity = resultSet.getInt("Quantity");
                double price = resultSet.getDouble("Price");
                String expiry = resultSet.getString("Expiry Date");
                String dots = resultSet.getString("Date and Time Sold");

                String formattedPriceRow = "₱" + decimalFormat.format(price);

                if (quantity > 0) {
                    model.addRow(new Object[]{id, product, developer, quantity, formattedPriceRow, expiry, dots});
                }

                totalSales += price;
            }

            formattedPrice = "₱" + decimalFormat.format(totalSales);
            salesList.setModel(model);
            totalsalesField.setText(formattedPrice);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void updateData() {
        DefaultTableModel retrievemodel = (DefaultTableModel) updateList.getModel();
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
                String expirydate = resultSet.getString("Expiry Date");

                retrievemodel.addRow(new Object[]{ID, productname, manufacturer, expirydate});
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void LowStocksData() {
        DefaultTableModel retrievemodel = (DefaultTableModel) lowstocksList.getModel();
        retrievemodel.setRowCount(0);

        try {
            Connection connection = connect.getConnection();
            String query = "SELECT * FROM inventoryTable WHERE Quantity < 20";
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

        calendar = new com.raven.datechooser.DateChooser();
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
        addinventoryPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        productField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        manufacturerField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        expirationField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        minusIncrement = new javax.swing.JButton();
        quantityField = new javax.swing.JTextField();
        addIncrement = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        updateSearch = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        updateList = new javax.swing.JTable();
        updateButton = new javax.swing.JButton();
        inventoryPanel = new javax.swing.JPanel();
        inventorysearchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventoryList = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        lowstocksPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lowstocksList = new javax.swing.JTable();
        salesPanel = new javax.swing.JPanel();
        salesearchField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        salesList = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        totalsalesField = new javax.swing.JLabel();

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Inventory", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 24))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel3.setText("Product Name");

        productField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        productField.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        productField.setSelectionColor(new java.awt.Color(195, 177, 225));

        jLabel4.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel4.setText("Manufacturer");

        manufacturerField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        manufacturerField.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        manufacturerField.setSelectionColor(new java.awt.Color(195, 177, 225));

        jLabel5.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel5.setText("Price");

        priceField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        priceField.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        priceField.setSelectionColor(new java.awt.Color(195, 177, 225));
        priceField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                priceFieldKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel6.setText("Expiry Date");

        expirationField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        expirationField.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        expirationField.setSelectionColor(new java.awt.Color(195, 177, 225));

        jLabel7.setFont(new java.awt.Font("Inter", 0, 13)); // NOI18N
        jLabel7.setText("Quantity");

        minusIncrement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rsc/minus.png"))); // NOI18N
        minusIncrement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusIncrementActionPerformed(evt);
            }
        });

        quantityField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        quantityField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantityField.setText("0");
        quantityField.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        quantityField.setSelectionColor(new java.awt.Color(195, 177, 225));

        addIncrement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rsc/plus.png"))); // NOI18N
        addIncrement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addIncrementActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel8.setText("Search:");

        updateSearch.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        updateSearch.setText("jTextField1");
        updateSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                updateSearchKeyTyped(evt);
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
                "ID", "Product Name", "Manufacturer", "Expiry Date"
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(minusIncrement, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addIncrement, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(expirationField)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(priceField)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(manufacturerField)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(productField)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(manufacturerField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(expirationField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(minusIncrement, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(addIncrement, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 40, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout addinventoryPanelLayout = new javax.swing.GroupLayout(addinventoryPanel);
        addinventoryPanel.setLayout(addinventoryPanelLayout);
        addinventoryPanelLayout.setHorizontalGroup(
            addinventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        addinventoryPanelLayout.setVerticalGroup(
            addinventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Add Inventory", addinventoryPanel);

        inventoryPanel.setBackground(new java.awt.Color(255, 255, 255));
        inventoryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inventory", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 24))); // NOI18N

        inventorysearchField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        inventorysearchField.setMaximumSize(new java.awt.Dimension(200, 30));
        inventorysearchField.setMinimumSize(new java.awt.Dimension(200, 30));
        inventorysearchField.setPreferredSize(new java.awt.Dimension(200, 30));
        inventorysearchField.setSize(new java.awt.Dimension(200, 30));
        inventorysearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inventorysearchFieldKeyTyped(evt);
            }
        });

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
        jScrollPane1.setViewportView(inventoryList);

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

        javax.swing.GroupLayout inventoryPanelLayout = new javax.swing.GroupLayout(inventoryPanel);
        inventoryPanel.setLayout(inventoryPanelLayout);
        inventoryPanelLayout.setHorizontalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inventoryPanelLayout.createSequentialGroup()
                .addContainerGap(800, Short.MAX_VALUE)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inventorysearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        inventoryPanelLayout.setVerticalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryPanelLayout.createSequentialGroup()
                .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inventorysearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inventory", inventoryPanel);

        lowstocksPanel.setBackground(new java.awt.Color(255, 255, 255));
        lowstocksPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Low Stocks", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 24))); // NOI18N

        lowstocksList.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        lowstocksList.setModel(new javax.swing.table.DefaultTableModel(
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
        lowstocksList.setRowHeight(30);
        jScrollPane4.setViewportView(lowstocksList);

        javax.swing.GroupLayout lowstocksPanelLayout = new javax.swing.GroupLayout(lowstocksPanel);
        lowstocksPanel.setLayout(lowstocksPanelLayout);
        lowstocksPanelLayout.setHorizontalGroup(
            lowstocksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lowstocksPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1258, Short.MAX_VALUE)
                .addContainerGap())
        );
        lowstocksPanelLayout.setVerticalGroup(
            lowstocksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lowstocksPanelLayout.createSequentialGroup()
                .addGap(0, 43, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Low Stocks", lowstocksPanel);

        salesPanel.setBackground(new java.awt.Color(255, 255, 255));
        salesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 24))); // NOI18N

        salesearchField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        salesearchField.setMaximumSize(new java.awt.Dimension(200, 30));
        salesearchField.setMinimumSize(new java.awt.Dimension(200, 30));
        salesearchField.setPreferredSize(new java.awt.Dimension(200, 30));
        salesearchField.setSize(new java.awt.Dimension(200, 30));

        salesList.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        salesList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Product Name", "Manufacturer", "Quantity", "Price", "Expiry Date", "Date and Time Sold"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        salesList.setRowHeight(30);
        jScrollPane2.setViewportView(salesList);

        jLabel2.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Search:");
        jLabel2.setMaximumSize(new java.awt.Dimension(90, 40));
        jLabel2.setMinimumSize(new java.awt.Dimension(90, 40));
        jLabel2.setPreferredSize(new java.awt.Dimension(90, 40));
        jLabel2.setSize(new java.awt.Dimension(90, 40));

        jLabel9.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Total Sales:");

        totalsalesField.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        totalsalesField.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout salesPanelLayout = new javax.swing.GroupLayout(salesPanel);
        salesPanel.setLayout(salesPanelLayout);
        salesPanelLayout.setHorizontalGroup(
            salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, salesPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalsalesField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salesearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1270, Short.MAX_VALUE)
        );
        salesPanelLayout.setVerticalGroup(
            salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salesPanelLayout.createSequentialGroup()
                .addGroup(salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salesearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalsalesField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sales", salesPanel);

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
        // TODO add your handling code here:
        dispose();
        adminstaffsFrame staffs = new adminstaffsFrame();
        staffs.setVisible(true);
    }//GEN-LAST:event_staffsButtonActionPerformed

    private void inventorysearchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inventorysearchFieldKeyTyped
        DefaultTableModel retrievemodel = (DefaultTableModel) inventoryList.getModel();
        retrievemodel.setRowCount(0);

        String url = connect.url;
        String user = connect.user;
        String password = connect.password;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String searchTerm = inventorysearchField.getText().trim(); // Assuming 'searchField' is the JTextField for the search term

            String query = "SELECT * FROM inventoryTable WHERE ID LIKE ? OR `Product Name` LIKE ? OR Manufacturer LIKE ? OR Quantity LIKE ? OR Price LIKE ? OR `Expiry Date` LIKE ?";
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
                    int id = resultSet.getInt("ID");
                    String product = resultSet.getString("Product Name");
                    String developer = resultSet.getString("Manufacturer");
                    int quantity = resultSet.getInt("Quantity");
                    double price = resultSet.getDouble("Price");
                    String expiration = resultSet.getString("Expiry Date");

                    retrievemodel.addRow(new Object[]{id, product, developer, quantity, price, expiration});
                } while (resultSet.next());
            } else {
                JOptionPane.showMessageDialog(null, "No Product Found!", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_inventorysearchFieldKeyTyped

    private void priceFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceFieldKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_priceFieldKeyTyped

    private void minusIncrementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusIncrementActionPerformed
        String currentText = quantityField.getText();
        if (!currentText.isEmpty()) {
            try {
                int currentValue = Integer.parseInt(currentText);
                int newValue = currentValue - 1;

                quantityField.setText(String.valueOf(newValue));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } else {
        }
    }//GEN-LAST:event_minusIncrementActionPerformed

    private void addIncrementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addIncrementActionPerformed
        String currentText = quantityField.getText();
        if (!currentText.isEmpty()) {
            try {
                int currentValue = Integer.parseInt(currentText);
                int newValue = currentValue + 1;

                quantityField.setText(String.valueOf(newValue));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } else {
        }
    }//GEN-LAST:event_addIncrementActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) inventoryList.getModel();
        int rowCount = model.getRowCount();
        int ID = rowCount + 1;

        Object[] rowData = new Object[]{
            ID,
            productField.getText(),
            manufacturerField.getText(),
            priceField.getText(),
            expirationField.getText(),
            quantityField.getText()
        };
        model.addRow(rowData);
        model.setValueAt(ID, rowCount, 0);

        try {
            Connection connection = connect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO inventoryTable (ID, `Product Name`, Manufacturer, Quantity, Price, `Expiry Date`)"
                    + "VALUES (?, ? ,? ,?, ?, ?)");
            preparedStatement.setInt(1, ID);
            preparedStatement.setString(2, productField.getText());
            preparedStatement.setString(3, manufacturerField.getText());
            preparedStatement.setString(4, quantityField.getText());
            preparedStatement.setString(5, priceField.getText());
            preparedStatement.setString(6, expirationField.getText());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        productField.setText("");
        manufacturerField.setText("");
        priceField.setText("");
        expirationField.setText("");
        quantityField.setText("0");
        retrieveData();
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        int selectedRow = updateList.getSelectedRow();
        if (selectedRow == -1) {
            return;
        }
        int patientId = (int) updateList.getValueAt(selectedRow, 0);

        if (dataUpdate) {
            try {
                Connection connection = connect.getConnection();
                String query = "SELECT * FROM inventoryTable WHERE ID = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, patientId);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String productName = resultSet.getString("Product Name");
                    String manufacturer = resultSet.getString("Manufacturer");
                    String price = resultSet.getString("Price");
                    String expiryDate = resultSet.getString("Expiry Date");
                    String quantity = resultSet.getString("Quantity");

                    productField.setText(productName);
                    manufacturerField.setText(manufacturer);
                    priceField.setText(price);
                    expirationField.setText(expiryDate);
                    quantityField.setText(quantity);

                    dataUpdate = false;
                }

                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String updatedProductName = productField.getText();
            String updatedManufacturer = manufacturerField.getText();
            String updatedExpiryDate = expirationField.getText();
            String updatedPrice = priceField.getText();
            String updatedQuantity = quantityField.getText();

            try {
                Connection connection = connect.getConnection();
                String updateQuery = "UPDATE inventoryTable SET `Product Name` = ?, Manufacturer = ?, Quantity = ?, Price = ?, `Expiry Date` = ? WHERE ID = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setString(1, updatedProductName);
                updateStatement.setString(2, updatedManufacturer);
                updateStatement.setString(3, updatedQuantity);
                updateStatement.setString(4, updatedPrice);
                updateStatement.setString(5, updatedExpiryDate);
                updateStatement.setInt(6, patientId);
                updateStatement.executeUpdate();
                dataUpdate = true;

                updateStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            productField.setText("");
            manufacturerField.setText("");
            priceField.setText("");
            expirationField.setText("");
            quantityField.setText("0");
            retrieveData();
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int selectedRow = inventoryList.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel delmodel = (DefaultTableModel) inventoryList.getModel();
            int itemId = (int) delmodel.getValueAt(selectedRow, 0);

            int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this item from the inventory?", "Confirmation", JOptionPane.YES_NO_OPTION);

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
                        deleteData(itemId);
                        retrieveData();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid admin credentials. Item removal canceled.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No item selected.");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updateSearchKeyTyped
        DefaultTableModel retrievemodel = (DefaultTableModel) updateList.getModel();
        retrievemodel.setRowCount(0);

        String url = connect.url;
        String user = connect.user;
        String password = connect.password;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String searchTerm = inventorysearchField.getText().trim();

            String query = "SELECT * FROM inventoryTable WHERE ID LIKE ? OR `Product Name` LIKE ? OR Manufacturer LIKE ? OR Quantity LIKE ? OR Price LIKE ? OR `Expiry Date` LIKE ?";
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
                    int id = resultSet.getInt("ID");
                    String product = resultSet.getString("Product Name");
                    String developer = resultSet.getString("Manufacturer");
                    String expiration = resultSet.getString("Expiry Date");

                    retrievemodel.addRow(new Object[]{id, product, developer, expiration});
                } while (resultSet.next());
            } else {
                JOptionPane.showMessageDialog(null, "No Product Found!", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateSearchKeyTyped

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
                new admininventoryFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton addIncrement;
    private javax.swing.JPanel addinventoryPanel;
    private javax.swing.JButton appointmentsButton;
    private javax.swing.JButton billingButton;
    private com.raven.datechooser.DateChooser calendar;
    private javax.swing.JButton dashboardButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField expirationField;
    private javax.swing.JButton inventoryButton;
    private javax.swing.JTable inventoryList;
    private javax.swing.JPanel inventoryPanel;
    private javax.swing.JTextField inventorysearchField;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JTable lowstocksList;
    private javax.swing.JPanel lowstocksPanel;
    private javax.swing.JTextField manufacturerField;
    private javax.swing.JButton minusIncrement;
    private javax.swing.JButton patientsButton;
    private javax.swing.JButton pharmacyButton;
    private javax.swing.JTextField priceField;
    private javax.swing.JTextField productField;
    private javax.swing.JTextField quantityField;
    private javax.swing.JTable salesList;
    private javax.swing.JPanel salesPanel;
    private javax.swing.JTextField salesearchField;
    private javax.swing.JButton staffsButton;
    private javax.swing.JLabel totalsalesField;
    private javax.swing.JButton updateButton;
    private javax.swing.JTable updateList;
    private javax.swing.JTextField updateSearch;
    // End of variables declaration//GEN-END:variables
}
