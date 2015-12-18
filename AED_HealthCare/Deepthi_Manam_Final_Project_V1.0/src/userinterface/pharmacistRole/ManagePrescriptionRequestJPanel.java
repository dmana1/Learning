/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.pharmacistRole;

import business.HealthCareSystem;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.useraccount.UserAccount;
import business.workqueue.PrescriptionRequest;
import business.workqueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Deepthi
 */
public class ManagePrescriptionRequestJPanel extends javax.swing.JPanel {
 private HealthCareSystem system;
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private Organization organization;
    private UserAccount userAccount;
    /**
     * Creates new form ManagePrescriptionRequestJPanel
     */
    public ManagePrescriptionRequestJPanel(HealthCareSystem system, JPanel userProcessContainer, Enterprise enterprise, Organization organization, UserAccount userAccount) {
        initComponents();
         this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.organization = organization;
        this.userAccount = userAccount;
        this.system = system;
        populateTable();
    }

    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) prescriptionJTable.getModel();
        model.setRowCount(0);
        prescriptionJTable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));

        for (WorkRequest workRequest : organization.getWorkQueue().getWorkRequestList()) {
            if (workRequest instanceof PrescriptionRequest) {
                Object[] row = new Object[5];
                row[0] = workRequest;
                row[1] = workRequest.getSender().getPerson().getFirstName();
                row[2] = ((PrescriptionRequest) workRequest).getSenderHospital();
                row[3] = ((PrescriptionRequest) workRequest).getPatient().getFirstName();
                row[4] = workRequest.getStatus();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        prescriptionJTable = new javax.swing.JTable();
        backJButton = new javax.swing.JButton();
        processRequestJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("List Of Prescription Orders:");

        prescriptionJTable.setBackground(new java.awt.Color(204, 224, 253));
        prescriptionJTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        prescriptionJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Message", "Doctor", "Hospital", "Patient ", "Status"
            }
        ));
        jScrollPane1.setViewportView(prescriptionJTable);

        backJButton.setBackground(new java.awt.Color(137, 185, 239));
        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        processRequestJButton.setBackground(new java.awt.Color(137, 185, 239));
        processRequestJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        processRequestJButton.setText("ProcessRequest >>");
        processRequestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processRequestJButtonActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(processRequestJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(274, 274, 274)
                        .addComponent(refreshJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(refreshJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(processRequestJButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                .addComponent(backJButton)
                .addGap(257, 257, 257))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void processRequestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processRequestJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = prescriptionJTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select the order to process");
            return;
        }
        
        PrescriptionRequest pr = (PrescriptionRequest)prescriptionJTable.getValueAt(selectedRow, 0);
        if(pr.getStatus().equals("Completed")){
            JOptionPane.showMessageDialog(null, "Order is already completed");
            return;
        }
        OrderJPanel panel = new OrderJPanel(system,userProcessContainer, enterprise, organization, userAccount,pr);
        userProcessContainer.add("ManageRollbackRequestsJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_processRequestJButtonActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable prescriptionJTable;
    private javax.swing.JButton processRequestJButton;
    private javax.swing.JButton refreshJButton;
    // End of variables declaration//GEN-END:variables
}