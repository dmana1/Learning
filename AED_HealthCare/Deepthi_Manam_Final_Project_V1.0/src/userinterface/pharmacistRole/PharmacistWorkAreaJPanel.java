/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.pharmacistRole;

import business.HealthCareSystem;
import business.enterprise.Enterprise;
import business.enterprise.PharmacyEnterprise;
import business.inventory.InventoryItem;
import business.organization.Organization;
import business.useraccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Deepthi
 */
public class PharmacistWorkAreaJPanel extends javax.swing.JPanel {

    private HealthCareSystem system;
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private Organization organization;
    private UserAccount userAccount;

    /**
     * Creates new form PharmacistWorkAreaJPanel
     */
    public PharmacistWorkAreaJPanel(HealthCareSystem system, JPanel userProcessContainer, Enterprise enterprise, Organization organization, UserAccount userAccount) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.organization = organization;
        this.userAccount = userAccount;
        this.system = system;
        broadCastNewsJTextArea.append(system.getNews());
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
        managePrescriptionRequestJButton = new javax.swing.JButton();
        manageInventoryJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        broadCastNewsJTextArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        managePersonalInfoJButton = new javax.swing.JButton();
        resetPasswordJButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        manageRollbackJButton = new javax.swing.JButton();
        compareJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Pharmacist Work Area");

        managePrescriptionRequestJButton.setBackground(new java.awt.Color(137, 185, 239));
        managePrescriptionRequestJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        managePrescriptionRequestJButton.setText("Manage Prescription Requests >>");
        managePrescriptionRequestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePrescriptionRequestJButtonActionPerformed(evt);
            }
        });

        manageInventoryJButton.setBackground(new java.awt.Color(137, 185, 239));
        manageInventoryJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manageInventoryJButton.setText("Manage Inventory >>");
        manageInventoryJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageInventoryJButtonActionPerformed(evt);
            }
        });

        broadCastNewsJTextArea.setBackground(new java.awt.Color(204, 224, 253));
        broadCastNewsJTextArea.setColumns(20);
        broadCastNewsJTextArea.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        broadCastNewsJTextArea.setRows(5);
        jScrollPane1.setViewportView(broadCastNewsJTextArea);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("News ");

        managePersonalInfoJButton.setBackground(new java.awt.Color(137, 185, 239));
        managePersonalInfoJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        managePersonalInfoJButton.setText("Manage Personal Information >>");
        managePersonalInfoJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePersonalInfoJButtonActionPerformed(evt);
            }
        });

        resetPasswordJButton.setBackground(new java.awt.Color(137, 185, 239));
        resetPasswordJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        resetPasswordJButton.setText("Reset Password >>");
        resetPasswordJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetPasswordJButtonActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/pharmacistRole/pharmacies.jpg"))); // NOI18N

        manageRollbackJButton.setBackground(new java.awt.Color(137, 185, 239));
        manageRollbackJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manageRollbackJButton.setText("Manage Rollback Requests >> ");
        manageRollbackJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageRollbackJButtonActionPerformed(evt);
            }
        });

        compareJButton.setBackground(new java.awt.Color(137, 185, 239));
        compareJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        compareJButton.setText(" Inventory By Product");
        compareJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compareJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(531, 531, 531)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(manageInventoryJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                                    .addComponent(manageRollbackJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(172, 172, 172)
                                .addComponent(jLabel3))
                            .addComponent(managePersonalInfoJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(managePrescriptionRequestJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(compareJButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(resetPasswordJButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)))))
                .addContainerGap(403, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(manageInventoryJButton)
                        .addGap(33, 33, 33)
                        .addComponent(manageRollbackJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addGap(30, 30, 30)
                .addComponent(managePrescriptionRequestJButton)
                .addGap(34, 34, 34)
                .addComponent(managePersonalInfoJButton)
                .addGap(37, 37, 37)
                .addComponent(resetPasswordJButton)
                .addGap(40, 40, 40)
                .addComponent(compareJButton)
                .addContainerGap(258, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manageInventoryJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageInventoryJButtonActionPerformed
        // TODO add your handling code here:
        ManageInventoryJPanel panel = new ManageInventoryJPanel(system, userProcessContainer, enterprise, organization, userAccount);
        userProcessContainer.add("ManageInventoryJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageInventoryJButtonActionPerformed

    private void managePersonalInfoJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePersonalInfoJButtonActionPerformed
        // TODO add your handling code here:
        PharmaciestPersonalInformationJPanel panel = new PharmaciestPersonalInformationJPanel(userProcessContainer, enterprise, organization, userAccount);
        userProcessContainer.add("PharmaciestPersonalInformationJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_managePersonalInfoJButtonActionPerformed

    private void resetPasswordJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetPasswordJButtonActionPerformed
        // TODO add your handling code here:
        ResetPasswordPharmacistJPanel panel = new ResetPasswordPharmacistJPanel(userProcessContainer, enterprise, organization, userAccount);
        userProcessContainer.add("ResetPasswordPharmacistJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_resetPasswordJButtonActionPerformed

    private void manageRollbackJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageRollbackJButtonActionPerformed
        // TODO add your handling code here:
        ManageRollbackRequestsJPanel panel = new ManageRollbackRequestsJPanel(system,userProcessContainer, enterprise, organization, userAccount);
        userProcessContainer.add("ManageRollbackRequestsJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageRollbackJButtonActionPerformed

    private void managePrescriptionRequestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePrescriptionRequestJButtonActionPerformed
        // TODO add your handling code here:
          ManagePrescriptionRequestJPanel panel = new ManagePrescriptionRequestJPanel(system,userProcessContainer, enterprise, organization, userAccount);
        userProcessContainer.add("ManageRollbackRequestsJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_managePrescriptionRequestJButtonActionPerformed

    private void compareJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compareJButtonActionPerformed
        // TODO add your handling code here:
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(InventoryItem inventoryItem : ((PharmacyEnterprise)enterprise).getInventory().getInventoryList()){
            dataset.setValue(inventoryItem.getQuantity(), "Drug ", inventoryItem.getDrug().getDrugName());

        }
        //Create a chart
        JFreeChart chart = ChartFactory.createBarChart("Compare the inventory of drugs", "Drug", "Quantity in inventory", dataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        ChartFrame frame = new ChartFrame("Compare the inventory of drugs", chart);
        frame.setVisible(true);
        frame.setSize(450, 350);
    }//GEN-LAST:event_compareJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea broadCastNewsJTextArea;
    private javax.swing.JButton compareJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton manageInventoryJButton;
    private javax.swing.JButton managePersonalInfoJButton;
    private javax.swing.JButton managePrescriptionRequestJButton;
    private javax.swing.JButton manageRollbackJButton;
    private javax.swing.JButton resetPasswordJButton;
    // End of variables declaration//GEN-END:variables
}
