package com.employee.dao;

public interface QueryMapperEmployee {

	public static final String INSERT_EMPLOYEE=
			"INSERT INTO employee VALUES(emp_sequence.nextVal,?,?,?,?)";

	public static final String DELETE_EMPLOYEE=
			"DELETE FROM employee WHERE employeeid=?";
	
	public static final String UPDATE_EMPLOYEE=
			"UPDATE employee SET salary=? WHERE employeeid=?";
	
	public static final String EMPID_QUERY_SEQUENCE=
			"SELECT emp_sequence.CURRVAL FROM DUAL";

	public static final String RETRIVE_ALL_QUERY=
			"SELECT * FROM employee";

}
