package com.capgemini.tcc.service;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.exception.invalidInput;

public interface IPatientService {
	public boolean isValid(PatientBean pb) throws invalidInput;

	public int addDetails(PatientBean patient);

	public PatientBean search(int pid);
}
