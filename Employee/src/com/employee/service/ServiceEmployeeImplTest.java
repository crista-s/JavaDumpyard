package com.employee.service;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.employee.exception.EmployeeException;

public class ServiceEmployeeImplTest {

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
	public final void testUpdateEmployeeDetails() {
		try{
			boolean isUpdated=serviceEmployee.updateEmployeeDetails(1001,40000);
			assertTrue("No such mobile",isUpdated==true);
		}
		catch(EmployeeException e)
		{
			e.printStackTrace();
		}
	}

}
