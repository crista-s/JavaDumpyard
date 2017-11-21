package com.employee.service;

import java.util.List;

import com.employee.bean.EmployeeBean;
import com.employee.exception.EmployeeException;

public interface IServiceEmployee {

	public String insertEmployeeDetails(EmployeeBean employeeBean)
			throws EmployeeException;
	
	public boolean deleteEmployeeDetails(int empId)
			throws EmployeeException;
	
	public boolean updateEmployeeDetails(int empId,int salary)
			throws EmployeeException;
	
	public List<EmployeeBean> retriveAll()throws EmployeeException;
}
