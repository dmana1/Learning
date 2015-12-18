/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.patientRole;

import business.HealthCareSystem;
import business.enterprise.HospitalEnterprise;
import business.patient.Patient;
import business.patient.adverseevents.AdverseEvent;
import business.patient.allergy.Allergy;
import business.patient.encounter.Encounter;
import business.patient.encounter.Medication;
import business.patient.encounter.VitalSign;
import business.patient.labtest.LabTest;
import business.person.Person;
import business.useraccount.UserAccount;
import business.validation.ValidationUtil;
import java.awt.CardLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Deepthi
 */
public class PatientWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private HealthCareSystem system;
    private UserAccount userAccount;
    private ArrayList<Encounter> encounterList;
    private ArrayList<AdverseEvent> adverseEventList;
    private ArrayList<Allergy> allergyList;
    private ArrayList<LabTest> labList;

    /**
     * Creates new form PatientWorkAreaJPanel
     */
    public PatientWorkAreaJPanel(JPanel userProcessContainer, HealthCareSystem system, UserAccount userAccount) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.userAccount = userAccount;
        encounterList = new ArrayList<Encounter>();
        adverseEventList = new ArrayList<AdverseEvent>();
        allergyList = new ArrayList<Allergy>();
        labList = new ArrayList<LabTest>();
        newsJTextArea.append(system.getNews());


        populateFields();
        populateEncounterTable();
        populateVitalSignTable();
        populateMedicinesTable();
        populateAdverseEventTable();
        populateAllergiesTable();
        populateLabTestTable();
    }

    private void populateFields() {
        Person person = userAccount.getPerson();
        firstNameJLabel.setText(person.getFirstName());
        lastNameJLabel.setText(person.getLastName());
        ssnJLabel.setText(person.getSsn());
        phoneNumberJLabel.setText(String.valueOf(person.getPhoneNumber()));
        emailIdJLabel.setText(person.getEmailId());
        dateOfBirthJLabel.setText(ValidationUtil.formatDate(person.getDateOfBirth()));

    }

    private void populateEncounterTable() {
        Person person = userAccount.getPerson();
        String uniqueCode = ValidationUtil.generateUniqueCode(person.getFirstName(), person.getLastName(), (person.getSsn()).substring(5), person.getDateOfBirth());
        for (HospitalEnterprise hospital : system.getAllHospitals()) {
            for (Patient patient : hospital.getPatientDirectory().getPatientsList()) {
                String uniqueCodeTemp = ValidationUtil.generateUniqueCode(patient.getFirstName(), patient.getLastName(), patient.getSsn(), patient.getDateOfBirth());
                if (uniqueCodeTemp.equals(uniqueCode)) {
                    for (Encounter encounter : patient.getEncounterHistory().getEncounterList()) {
                        encounterList.add(encounter);
                    }
                }

            }
        }

        // fill the encounter table
        DefaultTableModel model = (DefaultTableModel) encounterJTable.getModel();
        model.setRowCount(0);
        encounterJTable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));

        if (encounterList != null) {
            for (Encounter encounter : encounterList) {
                Object[] row = new Object[6];
                row[0] = encounter.getEncounterDate();
                row[1] = encounter.getHospitalName();
                row[2] = encounter.getDoctorName();
                row[3] = encounter.getSymptoms();
                row[4] = encounter.getDiagonizedDisease();
                row[5] = encounter.getAdvice();
                model.addRow(row);

            }
        }

    }

    private void populateVitalSignTable() {
        DefaultTableModel model = (DefaultTableModel) vitalSignJTable.getModel();
        model.setRowCount(0);
        vitalSignJTable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));

        for (Encounter encounter : encounterList) {
            VitalSign vitalSign = encounter.getVitalSign();
            Object[] row = new Object[5];
            row[0] = encounter;
            row[1] = vitalSign.getHeartRate();
            row[2] = vitalSign.getRespiratoryRate();
            row[3] = vitalSign.getSystolicBloodPressure();
            row[4] = vitalSign.getWeight();

            model.addRow(row);
        }
    }

    private void populateMedicinesTable() {
        DefaultTableModel model = (DefaultTableModel) medicinesJTable.getModel();
        model.setRowCount(0);
        medicinesJTable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));

        for (Encounter encounter : encounterList) {
            for (Medication medication : encounter.getMedicationList()) {
                Object[] row = new Object[4];
                row[0] = encounter;
                row[1] = medication.getDrug().getDrugName();
                row[2] = medication.getDrug().getUsageDirections();
                row[3] = medication.getDrug().getWarnings();
                model.addRow(row);
            }
        }
    }

    private void populateAdverseEventTable() {
        Person person = userAccount.getPerson();
        String uniqueCode = ValidationUtil.generateUniqueCode(person.getFirstName(), person.getLastName(), (person.getSsn()).substring(5), person.getDateOfBirth());
        for (HospitalEnterprise hospital : system.getAllHospitals()) {
            for (Patient patient : hospital.getPatientDirectory().getPatientsList()) {
                String uniqueCodeTemp = ValidationUtil.generateUniqueCode(patient.getFirstName(), patient.getLastName(), patient.getSsn(), patient.getDateOfBirth());
                if (uniqueCodeTemp.equals(uniqueCode)) {
                    for (AdverseEvent adverseEvent : patient.getAdverseEventHistory().getAdverseEventList()) {
                        adverseEventList.add(adverseEvent);
                    }
                }

            }
        }

        // fill the adverse table
        DefaultTableModel model = (DefaultTableModel) adverseEffectsJTable.getModel();
        model.setRowCount(0);
        adverseEffectsJTable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));

        if (adverseEventList != null) {
            for (AdverseEvent adverseEvent : adverseEventList) {
                Object[] row = new Object[2];
                row[0] = adverseEvent.getDrug().getDrugName();
                row[1] = adverseEvent.getAdverseEvent();
                model.addRow(row);

            }
        }
    }
    
    private void populateAllergiesTable(){
         Person person = userAccount.getPerson();
        String uniqueCode = ValidationUtil.generateUniqueCode(person.getFirstName(), person.getLastName(), (person.getSsn()).substring(5), person.getDateOfBirth());
        for (HospitalEnterprise hospital : system.getAllHospitals()) {
            for (Patient patient : hospital.getPatientDirectory().getPatientsList()) {
                String uniqueCodeTemp = ValidationUtil.generateUniqueCode(patient.getFirstName(), patient.getLastName(), patient.getSsn(), patient.getDateOfBirth());
                if (uniqueCodeTemp.equals(uniqueCode)) {
                    for (Allergy allergy : patient.getAllergyList()) {
                        allergyList.add(allergy);
                    }
                }

            }
        }

        // fill the allergies table
        DefaultTableModel model = (DefaultTableModel) allergyJTable.getModel();
        model.setRowCount(0);
        allergyJTable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));

        if (allergyList != null) {
            for (Allergy allergy : allergyList) {
                Object[] row = new Object[3];
                row[0] = allergy.getAllergyName();
                row[1] = allergy.getAllergyInformation();
                row[2] = allergy.getStatus();
                model.addRow(row);

            }
        }
    }
    
    
    private void populateLabTestTable(){
         Person person = userAccount.getPerson();
        String uniqueCode = ValidationUtil.generateUniqueCode(person.getFirstName(), person.getLastName(), (person.getSsn()).substring(5), person.getDateOfBirth());
        for (HospitalEnterprise hospital : system.getAllHospitals()) {
            for (Patient patient : hospital.getPatientDirectory().getPatientsList()) {
                String uniqueCodeTemp = ValidationUtil.generateUniqueCode(patient.getFirstName(), patient.getLastName(), patient.getSsn(), patient.getDateOfBirth());
                if (uniqueCodeTemp.equals(uniqueCode)) {
                    for (LabTest labtTest : patient.getLabTestList()) {
                        labList.add(labtTest);
                    }
                }

            }
        }

        // fill the allergies table
        DefaultTableModel model = (DefaultTableModel) labTestsJTable.getModel();
        model.setRowCount(0);
        labTestsJTable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));

        if (labList != null) {
            for (LabTest labTest : labList) {
                Object[] row = new Object[5];
                row[0] = labTest.getDate();
                row[1] = labTest.getWbc();
                row[2] = labTest.getRbc();
                row[3] = labTest.getlDL();
                row[4] = labTest.gethDL();
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

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        firstNameJLabel = new javax.swing.JLabel();
        ssnJLabel = new javax.swing.JLabel();
        lastNameJLabel = new javax.swing.JLabel();
        dateOfBirthJLabel = new javax.swing.JLabel();
        reportAdverseEventJButton = new javax.swing.JButton();
        patientLikeMeJButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        emailIdJLabel = new javax.swing.JLabel();
        phoneNumberJLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        encounterJTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        vitalSignJTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        medicinesJTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        adverseEffectsJTable = new javax.swing.JTable();
        refreshAdverseJButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        newsJTextArea = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        viewResponseJButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        allergyJTable = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        labTestsJTable = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setText("Welcome !");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("First Name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("SSN:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Last Name:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Date Of Birth:");

        firstNameJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        firstNameJLabel.setText("jLabel6");

        ssnJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ssnJLabel.setText("jLabel7");

        lastNameJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lastNameJLabel.setText("jLabel8");

        dateOfBirthJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dateOfBirthJLabel.setText("jLabel9");

        reportAdverseEventJButton.setBackground(new java.awt.Color(137, 185, 239));
        reportAdverseEventJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        reportAdverseEventJButton.setText("Report Adverse Event >>");
        reportAdverseEventJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportAdverseEventJButtonActionPerformed(evt);
            }
        });

        patientLikeMeJButton.setBackground(new java.awt.Color(137, 185, 239));
        patientLikeMeJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        patientLikeMeJButton.setText("Patient Like Me >>");
        patientLikeMeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientLikeMeJButtonActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(93, 154, 248));
        jSeparator1.setForeground(new java.awt.Color(93, 154, 248));
        jSeparator1.setAlignmentX(1.0F);
        jSeparator1.setAlignmentY(1.0F);
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 144, 249), 2));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jSeparator1.setOpaque(true);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Email ID:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Phone Number:");

        emailIdJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        emailIdJLabel.setText("jLabel8");

        phoneNumberJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        phoneNumberJLabel.setText("jLabel9");

        encounterJTable.setBackground(new java.awt.Color(204, 224, 253));
        encounterJTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        encounterJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Encounter Date", "Hospital", "Doctor", "Symptoms", "Diagonized Problem", "Advice"
            }
        ));
        jScrollPane1.setViewportView(encounterJTable);

        vitalSignJTable.setBackground(new java.awt.Color(204, 224, 253));
        vitalSignJTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        vitalSignJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Encounter Date", "Respiratory Rate", "Heart Rate", "Systolic Blood Pressure", "Weight"
            }
        ));
        jScrollPane2.setViewportView(vitalSignJTable);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Encounter Hisory");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("VitalSign History");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Medication History");

        medicinesJTable.setBackground(new java.awt.Color(204, 224, 253));
        medicinesJTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        medicinesJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Encounter Date", "Drug Name", "Usage Directions", "Warnings"
            }
        ));
        jScrollPane3.setViewportView(medicinesJTable);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Adverse Events ");

        adverseEffectsJTable.setBackground(new java.awt.Color(204, 224, 253));
        adverseEffectsJTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        adverseEffectsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drug Name", "Adverse Effect"
            }
        ));
        jScrollPane4.setViewportView(adverseEffectsJTable);

        refreshAdverseJButton.setBackground(new java.awt.Color(137, 185, 239));
        refreshAdverseJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        refreshAdverseJButton.setText("Refresh");
        refreshAdverseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshAdverseJButtonActionPerformed(evt);
            }
        });

        newsJTextArea.setBackground(new java.awt.Color(185, 217, 252));
        newsJTextArea.setColumns(20);
        newsJTextArea.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        newsJTextArea.setRows(5);
        newsJTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane5.setViewportView(newsJTextArea);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("News");

        viewResponseJButton.setBackground(new java.awt.Color(137, 185, 239));
        viewResponseJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewResponseJButton.setText("View Response From Doctor >>");
        viewResponseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewResponseJButtonActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Allergy History");

        allergyJTable.setBackground(new java.awt.Color(204, 224, 253));
        allergyJTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        allergyJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Information", "Status"
            }
        ));
        jScrollPane6.setViewportView(allergyJTable);

        labTestsJTable.setBackground(new java.awt.Color(204, 224, 253));
        labTestsJTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labTestsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "WBC", "RBC", "LPL", "HPL"
            }
        ));
        jScrollPane7.setViewportView(labTestsJTable);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Lab Tests");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1339, Short.MAX_VALUE)
                                .addComponent(jScrollPane3)
                                .addComponent(jLabel10)
                                .addComponent(jLabel9)
                                .addComponent(jLabel8)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(firstNameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel3)
                                                    .addGap(51, 51, 51)
                                                    .addComponent(ssnJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(67, 67, 67)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel4)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(lastNameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel5)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(dateOfBirthJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(73, 73, 73)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel6)))
                                        .addComponent(jLabel2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(emailIdJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(phoneNumberJLabel))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(152, 152, 152)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(patientLikeMeJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(viewResponseJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(reportAdverseEventJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(refreshAdverseJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(610, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(firstNameJLabel)
                    .addComponent(jLabel4)
                    .addComponent(lastNameJLabel)
                    .addComponent(jLabel6)
                    .addComponent(emailIdJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(ssnJLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(dateOfBirthJLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(phoneNumberJLabel)))
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(reportAdverseEventJButton)
                        .addGap(18, 18, 18)
                        .addComponent(patientLikeMeJButton)
                        .addGap(18, 18, 18)
                        .addComponent(viewResponseJButton)))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(refreshAdverseJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(229, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void reportAdverseEventJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportAdverseEventJButtonActionPerformed
        // TODO add your handling code here:

        AdverseEventJPanel panel = new AdverseEventJPanel(userProcessContainer, system, userAccount);
        userProcessContainer.add("AdverseEventJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_reportAdverseEventJButtonActionPerformed

    private void refreshAdverseJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshAdverseJButtonActionPerformed
        // TODO add your handling code here:
        populateAdverseEventTable();
    }//GEN-LAST:event_refreshAdverseJButtonActionPerformed

    private void patientLikeMeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientLikeMeJButtonActionPerformed
        // TODO add your handling code here:
        PatientLikeMeJPanel panel = new PatientLikeMeJPanel(userProcessContainer, system, userAccount);
        userProcessContainer.add("PatientLikeMeJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_patientLikeMeJButtonActionPerformed

    private void viewResponseJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewResponseJButtonActionPerformed
        // TODO add your handling code here:
        ViewResponseFromDoctorJPanel panel = new ViewResponseFromDoctorJPanel(userProcessContainer, system, userAccount);
        userProcessContainer.add("ViewResponseFromDoctorJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_viewResponseJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable adverseEffectsJTable;
    private javax.swing.JTable allergyJTable;
    private javax.swing.JLabel dateOfBirthJLabel;
    private javax.swing.JLabel emailIdJLabel;
    private javax.swing.JTable encounterJTable;
    private javax.swing.JLabel firstNameJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable labTestsJTable;
    private javax.swing.JLabel lastNameJLabel;
    private javax.swing.JTable medicinesJTable;
    private javax.swing.JTextArea newsJTextArea;
    private javax.swing.JButton patientLikeMeJButton;
    private javax.swing.JLabel phoneNumberJLabel;
    private javax.swing.JButton refreshAdverseJButton;
    private javax.swing.JButton reportAdverseEventJButton;
    private javax.swing.JLabel ssnJLabel;
    private javax.swing.JButton viewResponseJButton;
    private javax.swing.JTable vitalSignJTable;
    // End of variables declaration//GEN-END:variables
}
