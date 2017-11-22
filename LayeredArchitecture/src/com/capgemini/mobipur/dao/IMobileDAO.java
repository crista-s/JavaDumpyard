package com.capgemini.mobipur.dao;

import java.util.List;

import com.capgemini.mobipur.bean.MobileBean;
import com.capgemini.mobipur.exception.MobilePurchaseException;

public interface IMobileDAO {
         public boolean updateMobile(final int mobileId, final int quantity )
         throws MobilePurchaseException;//update the details 
         
         public List<MobileBean> viewAll()throws MobilePurchaseException;//to view all mobile details
         
         public boolean deleteMobile(final int mobileId)
         throws MobilePurchaseException;//deleting the mobile based on mobile id
         
         public List<MobileBean> search(final float minPrice, final float maxPrice)
  		 throws MobilePurchaseException;//searching on price
         
         public int getQuantity(int mobileId) throws MobilePurchaseException;
}
