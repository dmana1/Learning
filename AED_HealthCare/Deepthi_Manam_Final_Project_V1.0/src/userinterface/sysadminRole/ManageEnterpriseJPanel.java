/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.sysadminRole;

import business.HealthCareSystem;
import business.enterprise.Enterprise;
import business.network.Network;
import business.validation.ValidationUtil;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Deepthi
 */
public class ManageEnterpriseJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private HealthCareSystem system;
    private SystemAdminWorkAreaJPanel systemAdminWorkAreaJPanel;

    /**
     * Creates new form ManageEnterpriseJPanel
     */
    public ManageEnterpriseJPanel(JPanel userProcessContainer, HealthCareSystem system, SystemAdminWorkAreaJPanel systemAdminWorkAreaJPanel) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.systemAdminWorkAreaJPanel = systemAdminWorkAreaJPanel;

        populateTable();
        populateComboBox();
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) enterpriseJTable.getModel();
        model.setRowCount(0);
        enterpriseJTable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));

        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDir().getEnterpriseList()) {
                Object[] row = new Object[6];
                row[0] = enterprise.getName();
                row[1] = enterprise.getEnterpriseType().getValue();
                row[2] = network;
                row[3] = enterprise.getLocation();
                row[4] = enterprise.getContactNumber();
                row[5] = enterprise.getContactEmail();
                model.addRow(row);
            }

        }
    }

    private void populateComboBox() {
        networkJComboBox.removeAllItems();
        enterpriseTypeJComboBox.removeAllItems();
        for (Network network : system.getNetworkList()) {
            networkJComboBox.addItem(network);
        }
        for (Enterprise.EnterpriseType type : Enterprise.EnterpriseType.values()) {
            enterpriseTypeJComboBox.addItem(type);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        enterpriseJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        networkJComboBox = new javax.swing.JComboBox();
        enterpriseTypeJComboBox = new javax.swing.JComboBox();
        nameJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        submitJButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        locationJTextField = new javax.swing.JTextField();
        contactNumberJTextField = new javax.swing.JTextField();
        contactEmailJTextField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Manage Enterprise ");

        enterpriseJTable.setBackground(new java.awt.Color(194, 222, 252));
        enterpriseJTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        enterpriseJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enterprise Name", "Enterprise Type", "Network", "Location", "Contact Number", "Contact Email"
            }
        ));
        jScrollPane1.setViewportView(enterpriseJTable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Add Enterprise:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Network:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Enterprise Type:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("* Enterprise Name:");

        networkJComboBox.setBackground(new java.awt.Color(186, 223, 252));
        networkJComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        networkJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        enterpriseTypeJComboBox.setBackground(new java.awt.Color(186, 223, 252));
        enterpriseTypeJComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        enterpriseTypeJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        nameJTextField.setBackground(new java.awt.Color(186, 223, 252));
        nameJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        backJButton.setBackground(new java.awt.Color(137, 185, 239));
        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        submitJButton.setBackground(new java.awt.Color(137, 185, 239));
        submitJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("* Location:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("* Contact Number:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("* Contact Email:");

        locationJTextField.setBackground(new java.awt.Color(186, 223, 252));
        locationJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        contactNumberJTextField.setBackground(new java.awt.Color(186, 223, 252));
        contactNumberJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        contactEmailJTextField.setBackground(new java.awt.Color(186, 223, 252));
        contactEmailJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(410, 410, 410)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1506, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(65, 65, 65))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(51, 51, 51)))
                                .addComponent(jLabel6)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(locationJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(contactNumberJTextField)
                            .addComponent(contactEmailJTextField)
                            .addComponent(networkJComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(enterpriseTypeJComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameJTextField)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(networkJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(enterpriseTypeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(locationJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(contactNumberJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(contactEmailJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton)
                    .addComponent(submitJButton))
                .addContainerGap(186, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        // TODO add your handling code here:

        String name = nameJTextField.getText();
        String location = locationJTextField.getText();
        String contactNumber = contactNumberJTextField.getText();
        String contactEmail = contactEmailJTextField.getText();
        if (name.isEmpty() || location.isEmpty() || contactNumber.isEmpty() || contactEmail.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter values");
            return;
        }

        Network network = (Network) networkJComboBox.getSelectedItem();
        Enterprise.EnterpriseType type = (Enterprise.EnterpriseType) enterpriseTypeJComboBox.getSelectedItem();
        
        //check for validations of contactNumber and email
        if(!ValidationUtil.isValidPhoneNumber(contactNumber)){
            JOptionPane.showMessageDialog(null, "Enter Valid Phone Number");
            return;
        }
        if(!ValidationUtil.isValidEmailId(contactEmail)){
            JOptionPane.showMessageDialog(null, "Enter Valid EmailId");
            return;
        }

        //if the network  is not yet created 
        if (network == null || type == null) {
            return;
        }
        Enterprise enterprise = network.getEnterpriseDir().addEnterprise(name, type);
        enterprise.setLocation(location);
        enterprise.setContactNumber(Long.parseLong(contactNumber));
        enterprise.setContactEmail(contactEmail);
        populateTable();
        JOptionPane.showMessageDialog(null, "Successfully created Enterprise.");
        systemAdminWorkAreaJPanel.populateTree();
        clearFields();
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void clearFields(){
        nameJTextField.setText("");
       locationJTextField.setText("");
       contactNumberJTextField.setText("");
        contactEmailJTextField.setText("");
        
    }
    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField contactEmailJTextField;
    private javax.swing.JTextField contactNumberJTextField;
    private javax.swing.JTable enterpriseJTable;
    private javax.swing.JComboBox enterpriseTypeJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField locationJTextField;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox networkJComboBox;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
