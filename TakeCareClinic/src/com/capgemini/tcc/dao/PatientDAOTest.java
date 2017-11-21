package com.capgemini.tcc.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.tcc.bean.PatientBean;

public class PatientDAOTest {
	IPatientDAO pdao=new PatientDAO();
	

	@Test
	public void testAddPatientDetatils() {
		PatientBean patient=new PatientBean();
		patient.setPatient_Name("Alfaran");
		patient.setAge(15);
		patient.setPhone("8553103088");
		patient.setDescription("cough");
		int id=pdao.addPatientDetatils(patient);
		
		assertNotEquals(0, id);
		//fail("Not yet implemented");
	}


}
