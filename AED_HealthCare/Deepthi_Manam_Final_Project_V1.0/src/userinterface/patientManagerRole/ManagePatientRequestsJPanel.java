/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.patientManagerRole;

import business.enterprise.Enterprise;
import business.enterprise.HospitalEnterprise;
import business.organization.PatientManagerOrganization;
import business.patient.Patient;
import business.patient.allergy.Allergy;
import business.patient.allergy.AllergyHistory;
import business.patient.encounter.Encounter;
import business.patient.encounter.EncounterHistory;
import business.patient.encounter.MedicationHistory;
import business.patient.encounter.VitalSign;
import business.useraccount.UserAccount;
import business.validation.ValidationUtil;
import business.workqueue.PatientHistoryRequest;
import business.workqueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Font;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Deepthi
 */
public class ManagePatientRequestsJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private PatientManagerOrganization organization;
    private UserAccount userAccount;

    /**
     * Creates new form ManagePatientRequestsJPanel
     */
    public ManagePatientRequestsJPanel(JPanel userProcessContainer, Enterprise enterprise, PatientManagerOrganization organization, UserAccount userAccount) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.organization = organization;
        this.userAccount = userAccount;

        populateTable();
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) patientHistoryRequestJTable.getModel();
        model.setRowCount(0);

        patientHistoryRequestJTable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));

        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[6];
            row[0] = request;
            row[1] = request.getRequestDate();
            row[2] = ((PatientHistoryRequest) request).getRequestNo();
            row[3] = request.getSender().getPerson().getFirstName() + " " + request.getSender().getPerson().getLastName();         
            row[4] = ((PatientHistoryRequest) request).getSenderEnterprise();
            row[5] = ((PatientHistoryRequest) request).getPatientFoundResult();

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
        patientHistoryRequestJTable = new javax.swing.JTable();
        processRequestJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("Process Requests");

        patientHistoryRequestJTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        patientHistoryRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Work Request Description", "Request Date", "RequestId", "Sender Name", "Sender Enterprise", "Result"
            }
        ));
        jScrollPane1.setViewportView(patientHistoryRequestJTable);

        processRequestJButton.setBackground(new java.awt.Color(137, 185, 239));
        processRequestJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        processRequestJButton.setText("Process Request >>");
        processRequestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processRequestJButtonActionPerformed(evt);
            }
        });

        refreshJButton.setBackground(new java.awt.Color(137, 185, 239));
        refreshJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        refreshJButton.setText("Refresh");

        backJButton.setBackground(new java.awt.Color(137, 185, 239));
        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("List of Requests :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(288, 288, 288)
                                .addComponent(processRequestJButton))
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(refreshJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(514, 514, 514)
                        .addComponent(jLabel1)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(refreshJButton)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(processRequestJButton)
                    .addComponent(backJButton))
                .addContainerGap(414, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void processRequestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processRequestJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = patientHistoryRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select request to process it");

            return;
        }

        PatientHistoryRequest request = (PatientHistoryRequest) patientHistoryRequestJTable.getValueAt(selectedRow, 0);
        request.setStatus("Processing");
        boolean patientFound = false;


      
        for (Patient patient : ((HospitalEnterprise) enterprise).getPatientDirectory().getPatientsList()) {
            String uniqueCode = ValidationUtil.generateUniqueCode(patient.getFirstName(), patient.getLastName(), patient.getSsn(), patient.getDateOfBirth());
            if (uniqueCode.equalsIgnoreCase(request.getPatientUniqueCode())) {
                patientFound = true;
                if(patient.isDetailsEnabled()){
                request.setEncounterHistory(patient.getEncounterHistory());  
                request.setAllergyList(patient.getAllergyList());
                request.setLabTestList(patient.getLabTestList());
                request.setPatientFoundResult("Found");
                request.setAdverseList(patient.getAdverseEventHistory().getAdverseEventList());
                }else{
                    request.setPatientFoundResult("Found,But details are disabled");
                }
            }

        }
        if (patientFound == false) {
            request.setPatientFoundResult("Not Found");

        }
        request.setStatus("Completed");
        JOptionPane.showMessageDialog(null, "Processing Completed");
        populateTable();
    }//GEN-LAST:event_processRequestJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable patientHistoryRequestJTable;
    private javax.swing.JButton processRequestJButton;
    private javax.swing.JButton refreshJButton;
    // End of variables declaration//GEN-END:variables
}