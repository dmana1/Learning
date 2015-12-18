package com.me.care.model;

// Generated Apr 7, 2015 5:11:35 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * NewTable generated by hbm2java
 */
@Entity
@Table(name = "new_table", catalog = "projectdb")
public class NewTable implements java.io.Serializable {

	private Integer enterpriseId;
	private String name;
	private Integer enterpriseType;

	public NewTable() {
	}

	public NewTable(String name, Integer enterpriseType) {
		this.name = name;
		this.enterpriseType = enterpriseType;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "EnterpriseID", unique = true, nullable = false)
	public Integer getEnterpriseId() {
		return this.enterpriseId;
	}

	public void setEnterpriseId(Integer enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	@Column(name = "Name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "EnterpriseType")
	public Integer getEnterpriseType() {
		return this.enterpriseType;
	}

	public void setEnterpriseType(Integer enterpriseType) {
		this.enterpriseType = enterpriseType;
	}

}