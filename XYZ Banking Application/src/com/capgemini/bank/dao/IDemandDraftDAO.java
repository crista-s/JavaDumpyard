package com.capgemini.bank.dao;

import com.capgemini.bank.bean.DemandDraft;
import com.capgemini.bank.exception.ErrorException;

public interface IDemandDraftDAO {
	
	int addDemandDraftDetails(DemandDraft demandDraft) throws ErrorException;
	DemandDraft getDemandDraftDetails(int transactionId) throws ErrorException;

}
