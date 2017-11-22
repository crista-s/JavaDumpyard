package com.capgemini.mobipur.bean;

import java.time.LocalDate;

public class PurchaseDetailsBean {
      private int purchaseId;
      private String name;
      private String mailId;
      private LocalDate purDate;
      private int mobileId;
      private String PhoneNo;
      @Override
	public String toString() {
		return "PurchaseDetailsBean [purchaseId=" + purchaseId + ", name="
				+ name + ", mailId=" + mailId + ", purDate=" + purDate
				+ ", mobileId=" + mobileId + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	
	public int getMobileId() {
		return mobileId;
	}
	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}
	public PurchaseDetailsBean( String name, String mailId,String PhoneNo,
			 int mobileId) {
		super();
		
		this.name = name;
		this.mailId = mailId;
		this.PhoneNo = PhoneNo;
		this.mobileId = mobileId;
	}
	public PurchaseDetailsBean() {
		super();
	}
	public String getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}
	
      
}
