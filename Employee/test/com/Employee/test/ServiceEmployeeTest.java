package com.Employee.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.employee.exception.EmployeeException;
import com.employee.service.IServiceEmployee;
import com.employee.service.ServiceEmployeeImpl;

public class ServiceEmployeeTest extends ServiceEmployeeImpl {
	private IServiceEmployee serviceEmployee;
	@Before
	public void setUp() throws Exception {
		serviceEmployee=new ServiceEmployeeImpl();
	}

	@After
	public void tearDown() throws Exception {
		serviceEmployee=null;
	}

	@Test
	public final void test() {
		try{
			boolean isUpdated=serviceEmployee.updateEmployeeDetails(1002, 10000);
			assertTrue("No such employee",isUpdated==true);
		}
		catch(EmployeeException e)
		{
			e.printStackTrace();
		}
	}

}
