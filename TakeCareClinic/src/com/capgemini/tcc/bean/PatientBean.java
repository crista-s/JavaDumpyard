package com.capgemini.tcc.bean;

import java.sql.Date;

public class PatientBean {
	private int patient_Id;
	private String patient_Name;
	private int age;
	private String phone;
	private String description;
	private Date consultation_Date;
	public int getPatient_Id() {
		return patient_Id;
	}
	public void setPatient_Id(int patient_Id) {
		this.patient_Id = patient_Id;
	}
	public String getPatient_Name() {
		return patient_Name;
	}
	public void setPatient_Name(String patient_Name) {
		this.patient_Name = patient_Name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getConsultation_Date() {
		return consultation_Date;
	}
	public void setConsultation_Date(Date consultation_Date) {
		this.consultation_Date = consultation_Date;
	}

}
