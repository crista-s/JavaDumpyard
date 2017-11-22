package com.capgemini.mobipur.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.mobipur.bean.PurchaseDetailsBean;
import com.capgemini.mobipur.exception.MobilePurchaseException;
import com.capgemini.mobipur.service.IServicePurchaseMobile;
import com.capgemini.mobipur.service.ServicePurchaseImpl;

public class ServicePurchaseImplTest {
    private PurchaseDetailsBean purchaseDetailsBean; 
	@Before
	public void setUp() throws Exception {
		purchaseDetailsBean = new PurchaseDetailsBean("abc","abc@anc.com","99889",1002);
	}

	@After
	public void tearDown() throws Exception {
		purchaseDetailsBean = null;
	}

	@Test
	public final void testInsertPurchaseDetails() {
		IServicePurchaseMobile servicePurchaseMobile = new ServicePurchaseImpl();
		try{
		assertTrue(servicePurchaseMobile.insertPurchaseDetails(purchaseDetailsBean));
	}catch (MobilePurchaseException e){
		e.printStackTrace();
	}
	}
}
