package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;

import com.employee.bean.EmployeeBean;
import com.employee.exception.EmployeeException;
import com.employee.util.DBConnection;

public class EmployeeDAOImpl implements IEmployeeDAO {

	@Override
	public String insertEmployee(EmployeeBean employeeBean) throws EmployeeException {
		
		int records=0;
		ResultSet resultSet = null;
		String empId=null;
		
		try(Connection connEmployeeDetails = DBConnection.getInstance().getConnection();)
		{
			PreparedStatement preparedStatement=
					connEmployeeDetails.prepareStatement(QueryMapperEmployee.INSERT_EMPLOYEE);
			
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
			
			preparedStatement = connEmployeeDetails.prepareStatement(QueryMapperEmployee.EMPID_QUERY_SEQUENCE);
			resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				empId=resultSet.getString(1);
						
			}
	
			if(records==0)
			{
				throw new EmployeeException("Inserting employee details failed ");

			}
			else
			{
				return empId;
			}
			
		}
		catch(SQLException sqlEx)
		{
			throw new EmployeeException(sqlEx.getMessage());
		}
	}

	@Override
	public boolean deleteEmployee(int empId) throws EmployeeException {

		int records=0;
		boolean isDeleted=false;
		
		try(Connection connEmployeeDetails = DBConnection.getInstance().getConnection();	
				PreparedStatement preparedStatement=
				connEmployeeDetails.prepareStatement(QueryMapperEmployee.DELETE_EMPLOYEE);)
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
		
		try(Connection connEmployee = DBConnection.getInstance().getConnection();	
				PreparedStatement preparedStatement=
				connEmployee.prepareStatement(QueryMapperEmployee.UPDATE_EMPLOYEE);)
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

	@Override
	public List<EmployeeBean> retriveAllDetails() throws EmployeeException {

		Connection con=DBConnection.getInstance().getConnection();
		
		int empCount = 0;
		
		PreparedStatement ps=null;
		ResultSet resultset = null;
		
		List<EmployeeBean> employeeList=new ArrayList<EmployeeBean>();
		try
		{
			ps=con.prepareStatement(QueryMapperEmployee.RETRIVE_ALL_QUERY);
			resultset=ps.executeQuery();
			
			while(resultset.next())
			{	
				EmployeeBean bean=new EmployeeBean();
				bean.setEmpId(resultset.getInt(1));
				bean.setName(resultset.getString(2));
				bean.setDoj(resultset.getString(3));
				bean.setDname(resultset.getString(4));
				
				employeeList.add(bean);
				
				empCount++;
			}			
			
		} catch (SQLException sqlException) {
			
			throw new EmployeeException("Problem occured.");
		}

		if(empCount == 0)
			return null;
		else
			return employeeList;
	}

}
