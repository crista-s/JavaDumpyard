package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;


import com.employee.bean.EmployeeBean;
import com.employee.exception.EmployeeException;
import com.employee.util.DBConnection;

public class EmployeeDAOImpl implements IEmployeeDAO {

	@Override
	public int insertEmployee(EmployeeBean employeeBean) throws EmployeeException {
		
		int records=0,eid=0;
		//boolean isInserted=false;
		
		try(Connection connPurchaseDetails = DBConnection.getInstance().getConnection();)	{
				PreparedStatement preparedStatement=
				connPurchaseDetails.prepareStatement(QueryMapperEmployee.INSERT_EMPLOYEE);
		
			
			DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			String strDate=employeeBean.getDoj();
			
			TemporalAccessor ta=dtf.parse(strDate);
			
			LocalDate localDate=LocalDate.from(ta);
			
			java.sql.Date doj=java.sql.Date.valueOf(localDate);
			
			preparedStatement.setString(1, employeeBean.getName());
			preparedStatement.setDate(2, doj);
			preparedStatement.setInt(3, employeeBean.getSalary());
			preparedStatement.setString(4, employeeBean.getDname());
			
			records=preparedStatement.executeUpdate();
						
			
			if(records>0){
				preparedStatement=connPurchaseDetails.prepareStatement(QueryMapperEmployee.CUREID_EMPLOYEE);
				ResultSet rsMobiles=preparedStatement.executeQuery();
				if(rsMobiles.next())
					eid=rsMobiles.getInt(1);

				
			}
			
		}
		catch(SQLException sqlEx)
		{
			throw new EmployeeException(sqlEx.getMessage());
		}
		
		return eid;
	}

	@Override
	public boolean deleteEmployee(int empId) throws EmployeeException {

		int records=0;
		boolean isDeleted=false;
		
		try(Connection connPurchaseDetails = DBConnection.getInstance().getConnection();	
				PreparedStatement preparedStatement=
				connPurchaseDetails.prepareStatement(QueryMapperEmployee.DELETE_EMPLOYEE);)
		{
						
			preparedStatement.setInt(1, empId);
			
			records=preparedStatement.executeUpdate();
			
			if(records>0)
				isDeleted=true;
			
		}
		catch(SQLException sqlEx)
		{
			throw new EmployeeException(sqlEx.getMessage());
		}
		
		return isDeleted;
	}

	@Override
	public boolean updateEmployee(int empId, int salary) throws EmployeeException {
		
		int records=0;
		boolean isUpdated=false;
		
		try(Connection connMobile = DBConnection.getInstance().getConnection();	
				PreparedStatement preparedStatement=
				connMobile.prepareStatement(QueryMapperEmployee.UPDATE_EMPLOYEE);)
		{
			
			preparedStatement.setInt(1, salary);
			preparedStatement.setInt(2, empId);
			
			records=preparedStatement.executeUpdate();
			
			if(records>0)
				isUpdated=true;
			
		}
		catch(SQLException sqlEx)
		{
			throw new EmployeeException(sqlEx.getMessage());
		}
		
		return isUpdated;
	}
	
}
