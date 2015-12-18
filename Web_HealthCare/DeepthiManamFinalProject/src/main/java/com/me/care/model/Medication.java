package com.me.care.model;

// Generated Apr 20, 2015 3:47:52 PM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Medication generated by hbm2java
 */
@Entity
@Table(name = "medication", catalog = "projectdb")
public class Medication implements java.io.Serializable {

	private Integer medicationId;
	private Drug drug;
	private Patient patient;
	private Integer dosage;
	private Integer requestId;
	private Date createdOn;

	public Medication() {
	}

	public Medication(Drug drug, Patient patient, Integer dosage,
			Integer requestId, Date createdOn) {
		this.drug = drug;
		this.patient = patient;
		this.dosage = dosage;
		this.requestId = requestId;
		this.createdOn = createdOn;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MedicationID", unique = true, nullable = false)
	public Integer getMedicationId() {
		return this.medicationId;
	}

	public void setMedicationId(Integer medicationId) {
		this.medicationId = medicationId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DrugID")
	public Drug getDrug() {
		return this.drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PatientID")
	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Column(name = "Dosage")
	public Integer getDosage() {
		return this.dosage;
	}

	public void setDosage(Integer dosage) {
		this.dosage = dosage;
	}

	@Column(name = "RequestId")
	public Integer getRequestId() {
		return this.requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CreatedOn", length = 10)
	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

}