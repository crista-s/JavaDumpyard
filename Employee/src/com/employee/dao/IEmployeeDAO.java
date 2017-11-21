package com.employee.dao;

import com.employee.bean.EmployeeBean;
import com.employee.exception.EmployeeException;

public interface IEmployeeDAO {

	public int insertEmployee(final EmployeeBean employeeBean) 
			throws EmployeeException;

	public boolean deleteEmployee(final int empId)
			throws EmployeeException;
	
	public boolean updateEmployee(final int empId,final int salary)
			throws EmployeeException;
	
}
