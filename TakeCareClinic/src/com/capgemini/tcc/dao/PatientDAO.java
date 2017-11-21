package com.capgemini.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.capgemini.tcc.DBUtil.DbUtil;
import com.capgemini.tcc.bean.PatientBean;

public class PatientDAO implements IPatientDAO {
	Logger log=Logger.getLogger(PatientDAO.class);
	public void logHistory(){
		log.info("inside PatientDAO class");
	}
	Connection conn = null;
	PreparedStatement pStmt = null;
	ResultSet rs=null;
	
	
	/*******************************************************************************************************
	 - Function Name	:	addPatientDetatils(PatientBean patient)
	 - Input Parameters	:	PatientBean patient
	 - Return Type		:	int
	 - Author			:	Alfaran
	 - Creation Date	:	26/10/2017
	 - Description		:	Adding Patient
	 ********************************************************************************************************/

	@Override
	public int addPatientDetatils(PatientBean patient) {
		try {
			log.info("inside try");

			conn = DbUtil.getConnection();
			pStmt = conn.prepareStatement(JdbcConstants.INSERTSQL);
			pStmt.setString(1, patient.getPatient_Name());
			pStmt.setInt(2, patient.getAge());
			pStmt.setString(3, patient.getPhone());
			pStmt.setString(4, patient.getDescription());
			pStmt.executeQuery();
			pStmt = conn.prepareStatement(JdbcConstants.IDSQL);
			pStmt.setString(1, patient.getPhone());
			pStmt.setString(2, patient.getPatient_Name());
			pStmt.setInt(3, patient.getAge());
			pStmt.setString(4, patient.getDescription());
			ResultSet rs1=pStmt.executeQuery();
			while(rs1.next()){
				int id=(rs1.getInt("patient_id"));
				
				return id;
			}
			
			
		
				
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			log.error("error encountered");
			e.printStackTrace();
		}
		return 0;

	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	searchPatientDetatils(int pid)
	 - Input Parameters	:	int pid
	 - Return Type		:	PatientBean
	 - Author			:	Alfaran
	 - Creation Date	:	26/10/2017
	 - Description		:	Searching Patient
	 ********************************************************************************************************/


	@Override
	public PatientBean searchPatientDetatils(int pid) {
		conn = DbUtil.getConnection();
		PatientBean patient=new PatientBean();
		try{
			log.info("inside try");
		pStmt = conn.prepareStatement(JdbcConstants.SEARCHSQL);
		pStmt.setInt(1, pid);
		rs=pStmt.executeQuery();
		while(rs.next()){
			patient.setPatient_Name(rs.getString("patient_name"));
			patient.setAge(rs.getInt("age"));
			patient.setConsultation_Date(rs.getDate("consultation_date"));
			patient.setDescription(rs.getString("description"));
			patient.setPhone(rs.getString("phone"));
			
			return patient;
		}
		conn.commit();
		
		}
		catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			log.error("error encountered");
			e.printStackTrace();
		}
		
		return null;
		
	}
	

}
