package com.employee.dao;

public interface QueryMapperEmployee {

	public static final String INSERT_EMPLOYEE=
			"INSERT INTO employe VALUES(emp_sequence.nextVal,?,?,?,?)";

	public static final String DELETE_EMPLOYEE=
			"DELETE FROM employe WHERE employeeid=?";
	
	public static final String UPDATE_EMPLOYEE=
			"UPDATE employe SET salary=? WHERE employeeid=?";
	public static final String CUREID_EMPLOYEE="SELECT emp_sequence.currVal FROM DUAL";
	
}
