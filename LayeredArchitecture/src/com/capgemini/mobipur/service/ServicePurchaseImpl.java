package com.capgemini.mobipur.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.mobipur.bean.PurchaseDetailsBean;
import com.capgemini.mobipur.dao.IMobileDAO;
import com.capgemini.mobipur.dao.IPurchaseDetailsDAO;
import com.capgemini.mobipur.dao.MobileDAOImpl;
import com.capgemini.mobipur.dao.PurchaseDetailsDAOImpl;
import com.capgemini.mobipur.exception.MobilePurchaseException;

public class ServicePurchaseImpl implements IServicePurchaseMobile {

	@Override
	public boolean insertPurchaseDetails(PurchaseDetailsBean purchaseDetailsBean) 
			throws MobilePurchaseException {
		int mobileQuantity = 0;
		
		boolean isItInserted = false;  
		boolean isUpdated = false;  
		
		  IPurchaseDetailsDAO purchaseDetailsDAO = new PurchaseDetailsDAOImpl();
		  IMobileDAO mobileDAO = new MobileDAOImpl();
		  
		  mobileQuantity = mobileDAO.getQuantity(purchaseDetailsBean.getMobileId());
		  if(mobileQuantity > 0){
			  isItInserted = purchaseDetailsDAO.insertPurchase(purchaseDetailsBean);
			  mobileQuantity--;
			  isUpdated = mobileDAO.updateMobile(purchaseDetailsBean.getMobileId(), mobileQuantity);
		  }
		 // boolean isItInserted = purchaseDetailsDAO.insertPurchase(purchaseDetailsBean);
				   return (isItInserted && isUpdated);
	}
    public boolean isValidCName (String cname) throws MobilePurchaseException{
    	boolean isValid = false;
    	
    	String pattern = "[A-Z][A-Za-z]{2,19}";
    	Pattern ptn = Pattern.compile(pattern);
    	Matcher matcher = ptn.matcher(cname);
    	isValid = matcher.matches();
    	if(!isValid){
    		throw new MobilePurchaseException("Invalid name");
    	}
    	return isValid;
    }
    public boolean isValidPhoneNo(String phoneNo) throws MobilePurchaseException{
    	boolean isValid = false;
    	
    	String pattern = "[\\d]{10}";
    	Pattern ptn = Pattern.compile(pattern);
    	Matcher matcher = ptn.matcher(phoneNo);
    	isValid = matcher.matches();
    	if(!isValid){
    		throw new MobilePurchaseException(" Phone no must be 10 digits");
    	}
		return isValid;
    }
    public boolean isValidMail(String mail) throws MobilePurchaseException{
    	boolean isValid = false;
    	
    	String pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$";
    	Pattern ptn = Pattern.compile(pattern);
    	Matcher matcher = ptn.matcher(mail);
    	isValid = matcher.matches();
    	if(!isValid){
    		throw new MobilePurchaseException("Invalid email");
    	}
		return isValid;
    }
}
