package com.me.care.model;

import java.io.Serializable;

public class Registration implements Serializable {
	
	private static final long serialVersionUID = 6182390898687671093L;

	private String mrn;
	private String userName;
	private String password;
	private String iAgree;
	
	
	public String getiAgree() {
		return iAgree;
	}
	public void setiAgree(String iAgree) {
		this.iAgree = iAgree;
	}
	
	public String getMrn() {
		return mrn;
	}
	public void setMrn(String mrn) {
		this.mrn = mrn;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
