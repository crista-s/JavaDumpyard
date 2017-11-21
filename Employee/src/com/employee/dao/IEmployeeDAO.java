package com.employee.dao;

import java.util.List;

import com.employee.bean.EmployeeBean;
import com.employee.exception.EmployeeException;

public interface IEmployeeDAO {

	public String insertEmployee(final EmployeeBean employeeBean) 
			throws EmployeeException;

	public boolean deleteEmployee(final int empId)
			throws EmployeeException;
	
	public boolean updateEmployee(final int empId,final int salary)
			throws EmployeeException;
	
	public List<EmployeeBean> retriveAllDetails()
			throws EmployeeException;

}
