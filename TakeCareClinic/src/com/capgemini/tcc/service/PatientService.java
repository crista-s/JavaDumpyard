package com.capgemini.tcc.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.dao.IPatientDAO;
import com.capgemini.tcc.dao.PatientDAO;
import com.capgemini.tcc.exception.invalidInput;

public class PatientService implements IPatientService{
	int flag=0;
	
	/*******************************************************************************************************
	 - Function Name	:	isValid(PatientBean pb)
	 - Input Parameters	:	PatientBean pb
	 - Return Type		:	boolean
	 - Author			:	Alfaran
	 - Throws			:	invalidInput
	 - Creation Date	:	26/10/2017
	 - Description		:	Validations for input
	 ********************************************************************************************************/
	
	@Override
	public boolean isValid(PatientBean pb) throws invalidInput {
		Pattern p1=Pattern.compile("[A-Z][A-Za-z/s]{1,19}");
		Matcher m1=p1.matcher(pb.getPatient_Name());
		if(m1.find())
			flag++;
		else
			throw new invalidInput("Invalid Name");
		if(pb.getAge()>0 && pb.getAge()<150)
			flag++;
		else
			throw new invalidInput("Invalid Age");
		Pattern p2=Pattern.compile("[1-9]{1}[0-9]{9}");
		Matcher m2=p2.matcher(pb.getPhone());
		if(m2.find())
			flag++;
		else
			throw new invalidInput("Invalid Phone Number");
		Pattern p3=Pattern.compile("[A-Za-z\\s]{1,80}");
		Matcher m3=p3.matcher(pb.getDescription());
		if(m3.find())
			flag++;
		else
			throw new invalidInput("Invalid Description");
		if(flag==4)
			return true;
		else
			return false;
	}
	
	/*******************************************************************************************************
	 - Function Name	:	addDetails(PatientBean patient)
	 - Input Parameters	:	PatientBean patient
	 - Return Type		:	int
	 - Author			:	Alfaran
	 - Creation Date	:	26/10/2017
	 - Description		:	Service method to call PatientDAO method
	 ********************************************************************************************************/
	
	@Override
	public int addDetails(PatientBean patient) {
		IPatientDAO pdao=new PatientDAO();
		int id=pdao.addPatientDetatils(patient);
		return id;
		
		/*******************************************************************************************************
		 - Function Name	:	PatientBean search(int pid)
		 - Input Parameters	:	int pid
		 - Return Type		:	PatientBean 
		 - Author			:	Alfaran
		 - Creation Date	:	26/10/2017
		 - Description		:	Service method to call PatientDAO method
		 ********************************************************************************************************/
		
	}
	@Override
	public PatientBean search(int pid) {
		IPatientDAO pdao=new PatientDAO();
		PatientBean patient=pdao.searchPatientDetatils(pid);
		return patient;
	}

}
