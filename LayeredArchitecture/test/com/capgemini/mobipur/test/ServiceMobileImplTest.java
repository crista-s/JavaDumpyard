package com.capgemini.mobipur.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.mobipur.bean.MobileBean;
import com.capgemini.mobipur.exception.MobilePurchaseException;
import com.capgemini.mobipur.service.IServiceMobile;
import com.capgemini.mobipur.service.ServiceMobileImpl;

public class ServiceMobileImplTest {
    private IServiceMobile servicePurchaseMobile;
    
	@Before
	public void setUp() throws Exception {
		servicePurchaseMobile = new ServiceMobileImpl(); 
	}

	@After
	public void tearDown() throws Exception {
		servicePurchaseMobile = null;
	}

	@Test
	public final void testSearch() {
		try{
		List<MobileBean>mobileList = servicePurchaseMobile.search(15000, 38000);
		assertTrue("No such mobile", mobileList.size()>0);
	}catch(MobilePurchaseException e){
		e.printStackTrace();
	}

}
}