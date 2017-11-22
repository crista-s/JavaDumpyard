package com.capgemini.mobipur.dao;

public interface QueryMapperPurchaseDetails {
       public static final String INSERT_PURCHASE = "INSERT INTO purchasedetails VALUES(purchMobile_sequence.NEXTVAL,?,?,?,?,?)";
       public static final String DELETE_PURCHASE = "DELETE FROM purchasedetails WHERE mobileid=?";
       
}
