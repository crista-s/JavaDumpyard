package com.capgemini.mobipur.dao;

import com.capgemini.mobipur.bean.PurchaseDetailsBean;
import com.capgemini.mobipur.exception.MobilePurchaseException;

public interface IPurchaseDetailsDAO {
      public boolean insertPurchase
      (final PurchaseDetailsBean purchaseDetailsBean)
      throws MobilePurchaseException;
      
      public boolean deletePurchaseDetails(final int mobileId)
      throws MobilePurchaseException;
}
