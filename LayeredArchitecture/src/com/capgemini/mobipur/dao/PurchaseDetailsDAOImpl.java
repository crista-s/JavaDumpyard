package com.capgemini.mobipur.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.capgemini.mobipur.bean.PurchaseDetailsBean;
import com.capgemini.mobipur.exception.MobilePurchaseException;
import com.capgemini.mobipur.util.DBConnection;

public class PurchaseDetailsDAOImpl implements IPurchaseDetailsDAO {

	@Override
	public boolean insertPurchase(PurchaseDetailsBean purchaseDetailsBean)
			throws MobilePurchaseException {
		int records = 0;
		
		boolean isInserted = false;
	    try(Connection connPurchaseDetails = DBConnection.getInstance().getConnection();	
		
		PreparedStatement preparedStatement=connPurchaseDetails.prepareStatement(QueryMapperPurchaseDetails.INSERT_PURCHASE);
	    		){
	    	java.sql.Date purchaseDate = new Date(new java.util.Date().getTime());
	    	
	    	
	    	preparedStatement.setString(1, purchaseDetailsBean.getName());
	    	preparedStatement.setString(2, purchaseDetailsBean.getMailId());
	    	preparedStatement.setString(3, purchaseDetailsBean.getPhoneNo());
	    	preparedStatement.setDate(4, purchaseDate);
	    	preparedStatement.setInt(5, purchaseDetailsBean.getMobileId());
	    	
	    	records = preparedStatement.executeUpdate();
	    	
	    	if(records >0){
	    		isInserted = true;
	    	}
	    }catch(SQLException sqlEx){
	    	throw new MobilePurchaseException(sqlEx.getMessage());
	    }
		return isInserted;
	}

	@Override
	public boolean deletePurchaseDetails(int mobileId)
			throws MobilePurchaseException {
	int records = 0;
		
		boolean isDeleted = false;
	    try(Connection connPurchaseDetails = DBConnection.getInstance().getConnection();	
		
		PreparedStatement preparedStatement=connPurchaseDetails.prepareStatement(QueryMapperPurchaseDetails.DELETE_PURCHASE);
	    		){
	    	
	    	
	    	preparedStatement.setInt(1, mobileId);
	    	
	    	
	    	records = preparedStatement.executeUpdate();
	    	
	    	if(records >0){
	    		isDeleted = true;
	    	}
	    }catch(SQLException sqlEx){
	    	throw new MobilePurchaseException(sqlEx.getMessage());
	    }
		return isDeleted;
	}

}
