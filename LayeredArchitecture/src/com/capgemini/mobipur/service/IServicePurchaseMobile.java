package com.capgemini.mobipur.service;

import com.capgemini.mobipur.bean.PurchaseDetailsBean;
import com.capgemini.mobipur.exception.MobilePurchaseException;

public interface IServicePurchaseMobile {
         public boolean insertPurchaseDetails(PurchaseDetailsBean purchaseDetailsBean)
        		 throws MobilePurchaseException;
        
}
