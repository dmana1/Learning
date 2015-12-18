package com.me.care.model;

// Generated Apr 20, 2015 3:47:52 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Patient generated by hbm2java
 */
@Entity
@Table(name = "patient", catalog = "projectdb", uniqueConstraints = @UniqueConstraint(columnNames = "SSN"))
public class Patient implements java.io.Serializable {

	private Integer patientId;
	private String firstName;
	private String lastName;
	private String ssn;
	private Date dob;
	private String emailId;
	private String phoneNumber;
	private String address;
	private String username;
	private String password;
	private Integer primaryDoctorId;
	private Set<Medication> medications = new HashSet<Medication>(0);
	private Set<Encounter> encounters = new HashSet<Encounter>(0);
	private Set<Vitalsign> vitalsigns = new HashSet<Vitalsign>(0);

	public Patient() {
	}

	public Patient(String firstName, String lastName, String ssn, Date dob,
			String emailId, String phoneNumber, String address,
			String username, String password, Integer primaryDoctorId,
			Set<Medication> medications, Set<Encounter> encounters,
			Set<Vitalsign> vitalsigns) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.dob = dob;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.username = username;
		this.password = password;
		this.primaryDoctorId = primaryDoctorId;
		this.medications = medications;
		this.encounters = encounters;
		this.vitalsigns = vitalsigns;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PatientID", unique = true, nullable = false)
	public Integer getPatientId() {
		return this.patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	@Column(name = "FirstName", length = 45)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LastName", length = 45)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "SSN", unique = true, length = 45)
	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DOB", length = 10)
	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name = "EmailID", length = 45)
	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "PhoneNumber", length = 45)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "Address", length = 205)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "Username", length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "Password", length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "PrimaryDoctorID")
	public Integer getPrimaryDoctorId() {
		return this.primaryDoctorId;
	}

	public void setPrimaryDoctorId(Integer primaryDoctorId) {
		this.primaryDoctorId = primaryDoctorId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	public Set<Medication> getMedications() {
		return this.medications;
	}

	public void setMedications(Set<Medication> medications) {
		this.medications = medications;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	public Set<Encounter> getEncounters() {
		return this.encounters;
	}

	public void setEncounters(Set<Encounter> encounters) {
		this.encounters = encounters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	public Set<Vitalsign> getVitalsigns() {
		return this.vitalsigns;
	}

	public void setVitalsigns(Set<Vitalsign> vitalsigns) {
		this.vitalsigns = vitalsigns;
	}

}
