/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.doctorRole;

import business.HealthCareSystem;
import business.enterprise.Enterprise;
import business.enterprise.HospitalEnterprise;
import business.organization.Organization;
import business.organization.PatientManagerOrganization;
import business.useraccount.UserAccount;
import business.workqueue.PatientHistoryRequest;
import business.workqueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Deepthi
 */
public class ViewPatientInformationRequestsJPanel extends javax.swing.JPanel {
    
    private HealthCareSystem system;
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private Organization organization;
    private UserAccount userAccount;
     private int requestNo;

    /**
     * Creates new form ViewPatientInformationRequestsJPanel
     */
    public ViewPatientInformationRequestsJPanel(HealthCareSystem system,JPanel userProcessContainer, Enterprise enterprise,
            Organization organization, UserAccount userAccount,  int requestNo) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.organization = organization;
        this.userAccount = userAccount;
        this.system = system;
        this.requestNo = requestNo;
        
        populateTable();
    }

    
    private void populateTable(){
        
        DefaultTableModel model = (DefaultTableModel)requestJTable.getModel();
         model.setRowCount(0);
                 requestJTable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
                 for(HospitalEnterprise hospital :system.getAllHospitals()){
                     for(Organization organization : hospital.getOrganizationDirectory().getOrganizationList()){
                         if(organization instanceof PatientManagerOrganization){
                             for(WorkRequest wr : organization.getWorkQueue().getWorkRequestList()){
                                 if(wr instanceof PatientHistoryRequest){
                                     int requestTemp = ((PatientHistoryRequest)wr).getRequestNo();
                                     if(requestTemp == requestNo){
                                         Object[] row = new Object[4];
                                         row[0] = ((PatientHistoryRequest)wr).getRequestNo();
                                         row[1] = ((PatientHistoryRequest)wr).getRequestDate();
                                         row[2] = ((PatientHistoryRequest)wr).getSentToHospital();
                                         row[3] = ((PatientHistoryRequest)wr).getStatus();
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
        requestJTable = new javax.swing.JTable();
        backJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("View Patient Information Requests");

        requestJTable.setBackground(new java.awt.Color(204, 219, 252));
        requestJTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        requestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "RequestID", "Request Date", "Receiver", "Status"
            }
        ));
        jScrollPane1.setViewportView(requestJTable);

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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(622, 622, 622)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1478, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(588, 588, 588)
                        .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(backJButton)
                .addContainerGap(269, Short.MAX_VALUE))
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
    private javax.swing.JTable requestJTable;
    // End of variables declaration//GEN-END:variables
}
