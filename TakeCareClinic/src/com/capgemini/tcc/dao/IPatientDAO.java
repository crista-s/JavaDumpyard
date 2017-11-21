package com.capgemini.tcc.dao;

import com.capgemini.tcc.bean.PatientBean;

public interface IPatientDAO {

	int addPatientDetatils(PatientBean patient);

	PatientBean searchPatientDetatils(int pid);

}
