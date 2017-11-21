package com.capgemini.bank.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.bank.bean.DemandDraft;
import com.capgemini.bank.dao.DemandDraftDAO;
import com.capgemini.bank.dao.IDemandDraftDAO;
import com.capgemini.bank.exception.ErrorException;

public class TestDemandDAO {
	
	@Test
	public void testAddDemandDradftDetails() {

	IDemandDraftDAO demandDraftDAO = new DemandDraftDAO();
		
	DemandDraft demandDraft = new DemandDraft();
	demandDraft.setCustomer_name("Johns");
	demandDraft.setPhone_number("7610079858l");
	demandDraft.setIn_favor_of("Capgemini");
	demandDraft.setDd_amount(45000);
	demandDraft.setDd_description("DD taken in favor of Capgemini");
	
	int testDraft;
	try {
		testDraft = demandDraftDAO.addDemandDraftDetails(demandDraft);
		assertEquals(1,testDraft );
	} catch (ErrorException e) {
		
		e.printStackTrace();
	}
	
	}

}
