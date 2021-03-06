/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.patientRole;

import business.HealthCareSystem;
import business.enterprise.HospitalEnterprise;
import business.organization.DoctorOrganization;
import business.organization.Organization;
import business.useraccount.UserAccount;
import business.workqueue.AdverseEventRequest;
import business.workqueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Deepthi
 */
public class ViewResponseFromDoctorJPanel extends javax.swing.JPanel {
 private JPanel userProcessContainer;
    private HealthCareSystem system;
    private UserAccount userAccount;
    /**
     * Creates new form ViewResponseFromDoctorJPanel
     */
    public ViewResponseFromDoctorJPanel(JPanel userProcessContainer, HealthCareSystem system, UserAccount userAccount) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.userAccount = userAccount;
        
        populateTable();
        
    }
    
    
    private void populateTable(){
          DefaultTableModel model = (DefaultTableModel) responseJTable.getModel();
        model.setRowCount(0);
        responseJTable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        for(HospitalEnterprise hospital : system.getAllHospitals()){
            for(Organization organization : hospital.getOrganizationDirectory().getOrganizationList()){
                if(organization instanceof DoctorOrganization){
                                    for(WorkRequest wr : organization.getWorkQueue().getWorkRequestList()){
                                        if(wr instanceof AdverseEventRequest){
                                            if(wr.getSender() == userAccount){
                                               Object[] row = new Object[7] ;
                                               row[0] = ((AdverseEventRequest)wr);
                                               row[1] = ((AdverseEventRequest)wr).getDrugCompanyEnterprise();
                                               row[2] = ((AdverseEventRequest)wr).getDrug();
                                               row[3] =  hospital.getName();
                                               row[4] = ((AdverseEventRequest)wr).getAdverseEvent();
                                               row[5] = ((AdverseEventRequest)wr).getStatus();
                                               row[6] =((AdverseEventRequest)wr).getResult();
                                               
                                               model.addRow(row);
                                               
                                            }
                                        }
                                    }

                }
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
        responseJTable = new javax.swing.JTable();
        backJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("View Response From Doctors");

        responseJTable.setBackground(new java.awt.Color(204, 224, 253));
        responseJTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        responseJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Request ID", "Drug Manufacturer", "Drug Name", "Hospital", "AdverseEvent", "Status", "Result"
            }
        ));
        jScrollPane1.setViewportView(responseJTable);

        backJButton.setBackground(new java.awt.Color(137, 185, 239));
        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(558, 558, 558)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 722, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(backJButton)
                .addContainerGap(403, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
          userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable responseJTable;
    // End of variables declaration//GEN-END:variables
}
