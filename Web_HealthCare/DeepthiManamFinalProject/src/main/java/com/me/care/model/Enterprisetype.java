package com.me.care.model;

// Generated Apr 20, 2015 3:47:52 PM by Hibernate Tools 4.3.1

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

/**
 * Enterprisetype generated by hbm2java
 */
@Entity
@Table(name = "enterprisetype", catalog = "projectdb")
public class Enterprisetype implements java.io.Serializable {

	private Integer enterpriseTypeId;
	private String description;
	private Set<Enterprise> enterprises = new HashSet<Enterprise>(0);

	public Enterprisetype() {
	}

	public Enterprisetype(String description, Set<Enterprise> enterprises) {
		this.description = description;
		this.enterprises = enterprises;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "EnterpriseTypeId", unique = true, nullable = false)
	public Integer getEnterpriseTypeId() {
		return this.enterpriseTypeId;
	}

	public void setEnterpriseTypeId(Integer enterpriseTypeId) {
		this.enterpriseTypeId = enterpriseTypeId;
	}

	@Column(name = "Description", length = 45)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enterprisetype")
	public Set<Enterprise> getEnterprises() {
		return this.enterprises;
	}

	public void setEnterprises(Set<Enterprise> enterprises) {
		this.enterprises = enterprises;
	}

}