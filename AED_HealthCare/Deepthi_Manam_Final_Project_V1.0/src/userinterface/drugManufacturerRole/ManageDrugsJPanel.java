/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.drugManufacturerRole;

import business.drug.Drug;
import business.enterprise.DrugCompanyEnterprise;
import business.enterprise.Enterprise;
import javax.swing.JPanel;
import business.organization.DrugManagement;
import business.organization.Organization;
import business.useraccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Deepthi
 */
public class ManageDrugsJPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private Organization organization;
    private UserAccount userAccount;

    /**
     * Creates new form ManageDrugsJPanel
     */
    public ManageDrugsJPanel(JPanel userProcessContainer,Enterprise enterprise,Organization organization,UserAccount userAccount) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.organization = organization;
        this.userAccount = userAccount;
        populateTable();
    }
    
    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) drugsJTable.getModel();        
        model.setRowCount(0);
        drugsJTable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));

        for (Drug drug : ((DrugCompanyEnterprise)enterprise).getDrugCatalogue().getDrugsList()){
            Object[] row = new Object[6];
            row[0] = drug;
            row[1] = drug.getDrugModelNo();
            row[2] = drug.getIngredients();
            row[3] = drug.getTreatmentArea();
            row[4] = drug.getWarnings();
            row[5] = drug.getExpiryDate();
            model.addRow(row);
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
        drugsJTable = new javax.swing.JTable();
        addDrugJButton = new javax.swing.JButton();
        deleteDrugJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        viewDrugJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Manage Drugs");

        drugsJTable.setBackground(new java.awt.Color(197, 227, 253));
        drugsJTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        drugsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drug Name", " Model No", "Ingredients", "Treatment Area", "Warnings", "Expiry Date"
            }
        ));
        jScrollPane1.setViewportView(drugsJTable);

        addDrugJButton.setBackground(new java.awt.Color(137, 185, 239));
        addDrugJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addDrugJButton.setText("Add Drug >>");
        addDrugJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDrugJButtonActionPerformed(evt);
            }
        });

        deleteDrugJButton.setBackground(new java.awt.Color(137, 185, 239));
        deleteDrugJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deleteDrugJButton.setText("Delete Drug");
        deleteDrugJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDrugJButtonActionPerformed(evt);
            }
        });

        backJButton.setBackground(new java.awt.Color(137, 185, 239));
        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        refreshJButton.setBackground(new java.awt.Color(137, 185, 239));
        refreshJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        viewDrugJButton.setBackground(new java.awt.Color(137, 185, 239));
        viewDrugJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewDrugJButton.setText("View Drug");
        viewDrugJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDrugJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addComponent(refreshJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addDrugJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(385, 385, 385))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deleteDrugJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(269, 269, 269)
                                .addComponent(viewDrugJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(558, 558, 558)
                        .addComponent(jLabel1)))
                .addContainerGap(824, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshJButton))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addDrugJButton)
                    .addComponent(viewDrugJButton)
                    .addComponent(deleteDrugJButton))
                .addGap(229, 229, 229)
                .addComponent(backJButton)
                .addContainerGap(249, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addDrugJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDrugJButtonActionPerformed
        // TODO add your handling code here:
        AddDrugJPanel panel = new AddDrugJPanel(userProcessContainer, enterprise, organization, userAccount);
        userProcessContainer.add("AddDrugJPanel", panel);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_addDrugJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
         userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void deleteDrugJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDrugJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = drugsJTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select the drug to delete");
            return;
        }
        
        Drug drug = (Drug)drugsJTable.getValueAt(selectedRow, 0);
        if(drug != null){
           ((DrugCompanyEnterprise) enterprise).getDrugCatalogue().removeDrug(drug);
        }
        
        JOptionPane.showMessageDialog(null, "Successfully deleted.");
        return;
    }//GEN-LAST:event_deleteDrugJButtonActionPerformed

    private void viewDrugJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDrugJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = drugsJTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select the drug to view");
            return;
        }
        
        Drug drug = (Drug)drugsJTable.getValueAt(selectedRow, 0);
        
        ViewDrugJPanel panel = new ViewDrugJPanel(userProcessContainer, enterprise, organization, userAccount,drug);
        userProcessContainer.add("ViewDrugJPanel", panel);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewDrugJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDrugJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton deleteDrugJButton;
    private javax.swing.JTable drugsJTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton viewDrugJButton;
    // End of variables declaration//GEN-END:variables
}
