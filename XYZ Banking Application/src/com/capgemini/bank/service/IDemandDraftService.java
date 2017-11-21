package com.capgemini.bank.service;

import com.capgemini.bank.bean.DemandDraft;
import com.capgemini.bank.exception.ErrorException;

public interface IDemandDraftService {
	
	int addDemandDraftDetails(DemandDraft demanddraft) throws ErrorException;
	DemandDraft getDemandDraftDetails(int transactionId) throws ErrorException;
	boolean isValidate(DemandDraft demanddraft) throws ErrorException;
	boolean isValidID(int transactionId) throws ErrorException;
	

}
