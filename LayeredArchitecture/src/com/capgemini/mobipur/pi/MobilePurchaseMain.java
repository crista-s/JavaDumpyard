package com.capgemini.mobipur.pi;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.mobipur.bean.MobileBean;
import com.capgemini.mobipur.bean.PurchaseDetailsBean;
import com.capgemini.mobipur.exception.MobilePurchaseException;
import com.capgemini.mobipur.service.ServiceMobileImpl;
import com.capgemini.mobipur.service.ServicePurchaseImpl;

public class MobilePurchaseMain {
    private static Logger logger=Logger.getRootLogger();
	public static void main(String[] args) {
		
		PropertyConfigurator.configure("resources//log4j.properties");
		//PurchaseDetailsBean pdb = new PurchaseDetailsBean("abc","abc@anc.com","998051",1002);
        boolean isInProcess = true;
        boolean isValid = false;
        byte choice = 0;
       String cname = null;
       String mailId = null;
       String phoneNo = null;
       int mobileId = 0;
       
		
		ServiceMobileImpl serviceMobile = new ServiceMobileImpl();
		ServicePurchaseImpl servicePurchaseMobile = new ServicePurchaseImpl();
		
		PurchaseDetailsBean purchaseDetailsBean = null;
		 List<MobileBean>mobileList = null;
		 Scanner scInput = new Scanner(System.in);
		 
		 while(isInProcess){
			 System.out.println("1) Insert Mobile Purchase.");
			 System.out.println("2) View all");
			 System.out.println("3) Delete mobile details.");
			 System.out.println("4) search Mobile Purchase for a range.");
			 System.out.println("0) exit.");
			 
			 choice = Byte.parseByte(scInput.nextLine());
			 
		 
		 switch(choice)
		 {
		 case 1:
			isValid = false;
			 while(!isValid){
				 try{
					 System.out.println("Enter the customer name: ");
					 cname = scInput.nextLine(); 
					 
					 isValid = servicePurchaseMobile.isValidCName(cname);
				 }catch(MobilePurchaseException mpe){
					 logger.error("Invalid name: " + cname);
					 System.err.println("Invalid name: " + cname);
					 isValid = false; 
				 }
			 }
			 
			 isValid = false;
			
			 while(!isValid){
				 try{
					 System.out.println("Enter the mail ID: ");
					 mailId = scInput.nextLine(); 
					 
					 isValid = servicePurchaseMobile.isValidMail(mailId);
				 }catch(MobilePurchaseException mpe){
					 logger.error("Invalid mail ID: " + mailId);
					 System.err.println("Invalid mail ID: " + mailId);
					 isValid = false; 
				 }
			 }
			 isValid = false;
			 while(!isValid){
				 try{
					 System.out.println("Enter the Phone no: ");
					 phoneNo = scInput.nextLine(); 
					 
					 isValid = servicePurchaseMobile.isValidPhoneNo(phoneNo);
				 }catch(MobilePurchaseException mpe){
					 logger.error("Invalid phone no: " + phoneNo);
					 System.err.println("Invalid phone no: " + phoneNo);
					 isValid = false; 
				 }
			 }
			 isValid = false;
			 while(!isValid){
				 try{
					 System.out.println("Enter the mobile id: ");
					mobileId = Integer.parseInt(scInput.nextLine()); 
					 
					 isValid = serviceMobile.isValidMobileId(mobileId);
				 }catch(MobilePurchaseException mpe){
					 logger.error("Invalid mobile Id: " + mobileId);
					 System.err.println("Invalid mobile Id: " + mobileId);
					 isValid = false; 
				 }
			 }
			 purchaseDetailsBean = new PurchaseDetailsBean(cname ,mailId,phoneNo,mobileId);
			 try{
				 servicePurchaseMobile.insertPurchaseDetails(purchaseDetailsBean);
			 }catch(MobilePurchaseException e){
				 logger.error(e.getMessage());
				 System.err.println(e.getMessage());
			 }
			 
			 break;
		 case 2:
			 try{
			 mobileList = serviceMobile.viewAll();
			 for(MobileBean mobileBean : mobileList){
				 System.out.println(mobileBean);
			 }
			 System.out.println("===================================================================================");
			 }catch(MobilePurchaseException e){
				 logger.error(e.getMessage());
				 System.err.println(e.getMessage());
			 }
			 
			 break;
		 case 3:
			 isValid = false;
			 while(!isValid){
				 try{
					 System.out.println("Enter the mobile id: ");
					mobileId = Integer.parseInt(scInput.nextLine()); 
					 
					 isValid = serviceMobile.isValidMobileId(mobileId);
					
				 }catch(MobilePurchaseException mpe){
					 logger.error("Invalid mobile Id: " + mobileId);
					 System.err.println("Invalid mobile Id: " + mobileId);
					 isValid = false; 
				 }
			 }
			 
			try {
				 boolean isDeleted = serviceMobile.deleteMobile(mobileId);
				 if(isDeleted){
					 System.out.println("mobile record deleted successfully!");
				 }
			 }catch(MobilePurchaseException e){
				 logger.error(e.getMessage());
				 System.err.println(e.getMessage());
			 }
			 break;
		 case 4:
			 float minPrice = 0;
			 float maxPrice = 0;
			 System.out.println("enter minimum price : ");
			 minPrice = Float.parseFloat(scInput.nextLine());
			 
			 System.out.println("enter maximum price : ");
			 maxPrice = Float.parseFloat(scInput.nextLine());
			 
			 try {
				mobileList = serviceMobile.search(minPrice, maxPrice);
				
				for(MobileBean mobileBean : mobileList){
					System.out.println(mobileBean);
				}
				System.out.println("======================================================================================");
			 }catch(MobilePurchaseException e){
				 logger.error(e.getMessage());
				 System.err.println(e.getMessage());
			 }
             break;
		 case 0:
			 isInProcess = false;
			 break;
		 default : 
			 System.out.println("invalid input");
			 logger.error("Invalid input : "+ choice);
			 System.err.println("Invalid input : "+ choice);
		 }
		
	}
		 scInput.close();
}
}