package com.employee.pi;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.employee.bean.EmployeeBean;
import com.employee.exception.EmployeeException;
import com.employee.service.ServiceEmployeeImpl;

public class EmployeeMain {
	
	private static Logger logger=Logger.getRootLogger();

	public static void main(String[] args) {
		
		PropertyConfigurator.configure("resources/log4j.properties");
		
		boolean isInProcess=true;
		boolean isValid=false;
		
		byte choice=0;
		
		String employeeId=null;
		String name=null;
		int salary=0;
		String doj=null;
		String dname=null;
		List<EmployeeBean>employeeList=null;
		
		Scanner sc=new Scanner(System.in);
		
		ServiceEmployeeImpl serviceEmployee=new ServiceEmployeeImpl();
		
		EmployeeBean employeeBean=null;
		
		while(isInProcess)
		{
			System.out.println("1) Insert Employee");
			System.out.println("2) Delete Employee");
			System.out.println("3) Update Salary");
			System.out.println("4) View All Employee");
			System.out.println("0) Exit");
			
			choice=Byte.parseByte(sc.nextLine());
			
			switch(choice){
			case 1:
				
				while(!isValid)
				{
					try{
						System.out.println("Enter Employee name: ");
						name=sc.nextLine();
						
						isValid=serviceEmployee.isValidName(name);
						
					}catch(EmployeeException mpe){
						
						logger.error("Invalid name: "+name);
						System.err.println("Invalid name: "+name);
						isValid=false;
					}
				}

				isValid=false;
				while(!isValid)
				{
					try{
						System.out.println("Enter salary: ");
						salary=Integer.parseInt(sc.nextLine());
						
						isValid=serviceEmployee.isValidSalary(salary);
						
					}catch(EmployeeException mpe){
						
						logger.error("Invalid salary: "+salary);
						System.err.println("Invalid salary: "+salary);
						isValid=false;
					}
				}
				
				System.out.println("Enter Date of Joining in DD/MM/YYYY format: ");
				doj=sc.nextLine();
						
				System.out.println("Enter Department Name: ");
				dname=sc.nextLine();
						
				employeeBean=new EmployeeBean(name,salary,doj,dname);
				try{
					employeeId=serviceEmployee.insertEmployeeDetails(employeeBean);
					
					if(employeeId!=null)
						System.out.println("Inserted Successfully! Employee Id is: "+employeeId);
					
				}catch(EmployeeException e){
					logger.error(e.getMessage());
				}
				
				break;
			
			case 2:
				System.out.println("Enter Employee Id: ");
				int empId=Integer.parseInt(sc.nextLine());
				
				try{
					boolean isDeleted=serviceEmployee.deleteEmployeeDetails(empId);
					
					if(isDeleted)
						System.out.println("Deleted successfully!");
					else
						System.out.println("Invalid Employee Id");
					
				}catch(EmployeeException e){
					logger.error(e.getMessage());
				}
				
				break;
			case 3:
				
				System.out.println("Enter Employee Id: ");
				int empId1=Integer.parseInt(sc.nextLine());
				
				isValid=false;
				int newSalary=0;
				while(!isValid)
				{
					try{
						System.out.println("Enter salary: ");
						newSalary=Integer.parseInt(sc.nextLine());
						
						isValid=serviceEmployee.isValidSalary(newSalary);
						
					}catch(EmployeeException mpe){
						
						logger.error("Invalid salary: "+newSalary);
						System.err.println("Invalid salary: "+newSalary);
						isValid=false;
					}
				}
				
				try{
					boolean isUpdated=serviceEmployee.updateEmployeeDetails(empId1, newSalary);
					
					if(isUpdated)
						System.out.println("Salary Updated!");
					else
						System.out.println("Invalid Employee Id");
					
				}catch(EmployeeException e){
					logger.error(e.getMessage());
				}
				
				break;
				
			case 4:
				try{
					employeeList=serviceEmployee.retriveAll();
					
					for(EmployeeBean employee: employeeList)
						System.out.println(employee);
					System.out.println("=====================================================");
				}catch(EmployeeException mpe){
					logger.error(mpe.getMessage());
				}
				
				break;

			case 0:
				
				isInProcess=false;
				break;
				
			default:
				
				System.out.println("Invalid input");
				logger.error("Invalid input: "+choice);
				System.err.println("Invalid input: "+choice);
				break;
			}
		}
		sc.close();

	}

}
