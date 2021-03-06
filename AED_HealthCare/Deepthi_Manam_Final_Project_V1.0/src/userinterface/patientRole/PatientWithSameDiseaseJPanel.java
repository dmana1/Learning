/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.patientRole;

import business.HealthCareSystem;
import business.patient.experience.Experience;
import business.patient.experience.PatientExperience;
import business.person.Person;
import business.useraccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Deepthi
 */
public class PatientWithSameDiseaseJPanel extends javax.swing.JPanel {
 private JPanel userProcessContainer;     
    private HealthCareSystem system;
    private UserAccount userAccount;
    private String disease;
    /**
     * Creates new form PatientWithSameDiseaseJPanel
     */
    public PatientWithSameDiseaseJPanel(JPanel userProcessContainer,HealthCareSystem system,UserAccount userAccount,String disease) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.userAccount = userAccount;
        this.disease = disease;
        populateExperiences();
                
    }
    
    private void populateExperiences(){        
        //get the list of patientExperiences
        feedJTextArea.setText("");
        for(PatientExperience patientExperience : system.getPatientExperienceList()){
            for(Experience experience : patientExperience.getExperienceList()){
                if(disease.equals(experience.getDisease()))
             feedJTextArea.append(patientExperience.getPatientName().concat(" : ").concat(experience.getExperince().concat("\n")));
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
        feedJTextArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        experienceJTextField = new javax.swing.JTextField();
        shareJButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("Share or view the experience of patients with same disease");

        feedJTextArea.setBackground(new java.awt.Color(200, 224, 253));
        feedJTextArea.setColumns(20);
        feedJTextArea.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        feedJTextArea.setRows(5);
        jScrollPane1.setViewportView(feedJTextArea);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Experience:");

        experienceJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        shareJButton.setBackground(new java.awt.Color(137, 185, 239));
        shareJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        shareJButton.setText("Share");
        shareJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shareJButtonActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/patientRole/patient3.png"))); // NOI18N

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
                        .addGap(425, 425, 425)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(shareJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(backJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel2)
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                                    .addComponent(experienceJTextField))
                                .addGap(123, 123, 123)
                                .addComponent(jLabel3)))))
                .addContainerGap(705, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(experienceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(shareJButton)
                .addGap(18, 18, 18)
                .addComponent(backJButton)
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void shareJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shareJButtonActionPerformed
        // TODO add your handling code here:
        
        String experience = experienceJTextField.getText();
        String  patientName = userAccount.getPerson().getFirstName();
        
        //Create  patient experience and add it to the system
        PatientExperience pe = new PatientExperience();
        pe.setPatientName(patientName);
        Experience e = new Experience();
        e.setDisease(disease);
        e.setExperince(experience);
        pe.getExperienceList().add(e);
        
        system.getPatientExperienceList().add(pe);
        populateExperiences();
    }//GEN-LAST:event_shareJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField experienceJTextField;
    private javax.swing.JTextArea feedJTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton shareJButton;
    // End of variables declaration//GEN-END:variables
}
