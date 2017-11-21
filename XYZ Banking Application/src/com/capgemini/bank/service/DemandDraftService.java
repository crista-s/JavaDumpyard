package com.capgemini.bank.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.bank.bean.DemandDraft;
import com.capgemini.bank.dao.DemandDraftDAO;
import com.capgemini.bank.dao.IDemandDraftDAO;
import com.capgemini.bank.exception.ErrorException;

public class DemandDraftService implements IDemandDraftService {

	IDemandDraftDAO iDemandDao = new DemandDraftDAO();

	@Override
	public int addDemandDraftDetails(DemandDraft demanddraft)
			throws ErrorException {

		return iDemandDao.addDemandDraftDetails(demanddraft);
	}

	@Override
	public DemandDraft getDemandDraftDetails(int transactionId)
			throws ErrorException {

		return iDemandDao.getDemandDraftDetails(transactionId);
	}


	public boolean isValidate(DemandDraft dd) throws ErrorException {
		int count = 0;
		int dd_amount = 0;

		Pattern pattern1 = Pattern.compile("[A-Z][A-Za-z\\s]{1,19}");
		Matcher nameMatch = pattern1.matcher(dd.getCustomer_name());

		if (nameMatch.find()) {
			count++;
		} else {
			throw new ErrorException("Name is not valid");
		}

		Pattern pattern2 = Pattern.compile("[0-9]{10}");
		Matcher phoneMatch = pattern2.matcher(dd.getPhone_number());

		if (phoneMatch.find()) {
			count++;
		} else {
			throw new ErrorException("Name is not valid");
		}

		Pattern pattern3 = Pattern.compile("[A-Za-z\\s]{1,20}");
		Matcher favorMatch = pattern3.matcher(dd.getIn_favor_of());

		if (favorMatch.find()) {
			count++;
		} else {
			throw new ErrorException("Favor is not valid");
		}

		dd_amount = dd.getDd_amount();

		if (dd_amount >= 0 && dd_amount < 500000) {
			count++;
			if (dd_amount <= 5000) {
				dd.setDd_commission(10);
			} else if (dd_amount >= 5001 && dd_amount <= 10000) {
				dd.setDd_commission(41);
			} else if (dd_amount >= 10001 && dd_amount <= 100000) {
				dd.setDd_commission(51);
			} else if (dd_amount <= 500000) {
				dd.setDd_commission(306);
			}
		} else {
			throw new ErrorException("amount should be within 500000");
		}

		Pattern pattern4 = Pattern.compile("[A-Za-z\\s]{1,50}");
		Matcher remarksMatch = pattern4.matcher(dd.getDd_description());

		if (remarksMatch.find()) {
			count++;
		} else {
			throw new ErrorException("Remarks is not valid");
		}

		if (count == 5) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isValidID(int transactionId) throws ErrorException {
		if(transactionId>1001 && transactionId<10000)
		return true;
		else
			throw new ErrorException("Id not Valid");
	}

	
}
