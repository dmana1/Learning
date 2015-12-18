/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.pharmacistRole;

import business.HealthCareSystem;
import business.drug.Drug;
import business.enterprise.DrugCompanyEnterprise;
import business.enterprise.Enterprise;
import business.enterprise.PharmacyEnterprise;
import business.inventory.Inventory;
import business.inventory.InventoryItem;
import business.organization.Organization;
import business.useraccount.UserAccount;
import business.workqueue.PrescriptionRequest;
import java.awt.CardLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Deepthi
 */
public class OrderDrugsJPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private Organization organization;
    private UserAccount userAccount;
    private HealthCareSystem system;

    /**
     * Creates new form OrderDrugsJPanel
     */
    public OrderDrugsJPanel(HealthCareSystem system,JPanel userProcessContainer,Enterprise enterprise,Organization organization,UserAccount userAccount) {
        initComponents();
         this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.organization = organization;
        this.userAccount = userAccount;
        this.system = system;
       
        
        populateManufacturerComboBox();
    }
    
    private void populateManufacturerComboBox(){
        manufacturerJComboBox.removeAllItems();
        ArrayList<DrugCompanyEnterprise> drugManufacturersList = system.getAllDrugCompanyEnterprisesInNetwork();
        for(DrugCompanyEnterprise drugManf : drugManufacturersList){
            manufacturerJComboBox.addItem(drugManf);
        }
        
    }
    
    
    private void populateTable(DrugCompanyEnterprise drugManf){
        DefaultTableModel model = (DefaultTableModel) drugsJTable.getModel();
        model.setRowCount(0);
        drugsJTable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));

        //get the supplier from the combo box
        if (drugManf == null) {
            return;
        }
        
        for(Drug drug : drugManf.getDrugCatalogue().getDrugsList()){
            if(drug.isIsRemApproved()){
            Object[] row = new Object[6];
            row[0] = drug;
            row[1] = drug.getDrugModelNo();
            row[2] = drug.getIngredients();
            row[3] = drug.getTreatmentArea();
            row[4] = drug.getUsageDirections();
           
            model.addRow(row);
            }
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
        manufacturerJComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        drugsJTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        quantityJTextField = new javax.swing.JTextField();
        OrderdrugJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Select Manufacturer :");

        manufacturerJComboBox.setBackground(new java.awt.Color(137, 185, 239));
        manufacturerJComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manufacturerJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        manufacturerJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manufacturerJComboBoxActionPerformed(evt);
            }
        });

        drugsJTable.setBackground(new java.awt.Color(223, 229, 234));
        drugsJTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        drugsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Drug Name", "Drug Code", "Components", "Treatment Area", "Usage Directions"
            }
        ));
        jScrollPane1.setViewportView(drugsJTable);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Place Order :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Quantity :");

        backJButton.setBackground(new java.awt.Color(137, 185, 239));
        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        quantityJTextField.setBackground(new java.awt.Color(223, 229, 234));
        quantityJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        OrderdrugJButton.setBackground(new java.awt.Color(137, 185, 239));
        OrderdrugJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OrderdrugJButton.setText("Order Drug");
        OrderdrugJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderdrugJButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Order Drugs");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(manufacturerJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(quantityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(OrderdrugJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(572, 572, 572)
                        .addComponent(jLabel2)))
                .addGap(221, 566, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(manufacturerJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel4)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(quantityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OrderdrugJButton))
                .addGap(139, 139, 139)
                .addComponent(backJButton)
                .addContainerGap(303, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void OrderdrugJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderdrugJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = drugsJTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Select the drug");
            return;
        }
        
        String quantityString = quantityJTextField.getText();
        int quantity = 0;
        try{
           quantity = Integer.parseInt(quantityString);
                    
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Enter valid quantity");
            return;
        }
        
        Drug drug = (Drug)drugsJTable.getValueAt(selectedRow, 0);
        
        Inventory inventory = ((PharmacyEnterprise)enterprise).getInventory();        
        ArrayList<InventoryItem> inventoryItemsList = inventory.getInventoryList();
        //if there no drugs in inventory, add the drug to inventory of pharmacy
        boolean added = false;
        if (inventoryItemsList.isEmpty()) {
            inventory.addInventoryItem(drug, quantity);
        } else {
            //if there are already drugs in the inventory,update the quantity in inventory
            for (InventoryItem inventoryItem : inventoryItemsList) {
                if (drug.getDrugName().equals(inventoryItem.getDrug().getDrugName())) {
                    inventoryItem.setQuantity(inventoryItem.getQuantity() + quantity);
                    added = true;
                }
            }
            if(!added){
               inventory.addInventoryItem(drug, quantity); 
            }

        }
        JOptionPane.showMessageDialog(null, "Successfully placed an order");

    }//GEN-LAST:event_OrderdrugJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
         userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void manufacturerJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manufacturerJComboBoxActionPerformed
        // TODO add your handling code here:
        DrugCompanyEnterprise drugManf = (DrugCompanyEnterprise)manufacturerJComboBox.getSelectedItem();
        if(drugManf != null){
            populateTable(drugManf);
        }
    }//GEN-LAST:event_manufacturerJComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OrderdrugJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JTable drugsJTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox manufacturerJComboBox;
    private javax.swing.JTextField quantityJTextField;
    // End of variables declaration//GEN-END:variables
}
