package com.capgemini.tcc.dao;

public class JdbcConstants {

	public static final String INSERTSQL = "insert into patient values(Patient_Id_Seq.nextval,?,?,?,?,sysdate)";
	public static final String SEARCHSQL = "select * from patient where patient_id=?";
	public static final String IDSQL = "select patient_id from patient where phone=? and patient_name=? and age=? and description=?";
	

}
