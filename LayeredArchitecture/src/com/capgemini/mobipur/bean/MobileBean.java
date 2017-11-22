package com.capgemini.mobipur.bean;

public class MobileBean {
     @Override
	public String toString() {
		return "MobileBean [mobileId=" + mobileId + ", name=" + name
				+ ", price=" + price + ", quantity=" + quantity + "]";
	}
	public int getMobileId() {
		return mobileId;
	}
	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public MobileBean(int mobileId, String name, float price, String quantity) {
		super();
		this.mobileId = mobileId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	private int mobileId;
     private String name;
     private float price;
     private String quantity;
	public MobileBean() {
		super();
	}
}
