package com.employee.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.employee.bean.EmployeeBean;
import com.employee.dao.EmployeeDAOImpl;
import com.employee.dao.IEmployeeDAO;
import com.employee.exception.EmployeeException;

public class ServiceEmployeeImpl implements IServiceEmployee {

	@Override
	public int insertEmployeeDetails(EmployeeBean employeeBean) throws EmployeeException {
		
		boolean isItInserted=false;
		int eid=0;
		IEmployeeDAO employeeDAO=new EmployeeDAOImpl();
		
		eid=employeeDAO.insertEmployee(employeeBean);
		
		return eid;
	}

	@Override
	public boolean deleteEmployeeDetails(int empId) throws EmployeeException {
		
		IEmployeeDAO employeeDAO=new EmployeeDAOImpl();
		boolean isDeleted=employeeDAO.deleteEmployee(empId);
		return isDeleted;
	}

	@Override
	public boolean updateEmployeeDetails(int empId,int salary) throws EmployeeException {
		
		IEmployeeDAO employeeDAO=new EmployeeDAOImpl();
		boolean isupdated=employeeDAO.updateEmployee(empId, salary);
		return isupdated;
	}

	public boolean isValidName(String name) throws EmployeeException{
		
		boolean isValid=false;
		
		String pattern="[A-Z]{1}[a-z]{0,19}";
		
		Pattern ptn=Pattern.compile(pattern);
		
		Matcher matcher=ptn.matcher(name);
		isValid=matcher.matches();
		
		if(!isValid)
			throw new EmployeeException("Invalid Name");
		
		return isValid;
		
	}
	
	public boolean isValidSalary(int salary) throws EmployeeException{
		
		boolean isValid=false;
		
		if(salary>0)
			isValid=true;
		
		if(!isValid)
			throw new EmployeeException("Salary Must Be Positive");
		
		return isValid;
		
	}
	
}
