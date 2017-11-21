package com.capgemini.bank.bean;

public class DemandDraft {

	private int transactionId;
	private String customer_name;
	private String in_favor_of;
	private String phone_number;
	private String date_of_transaction;
	private int dd_amount;
	private int dd_commission;
	private String dd_description;

	public int getTransaction_id() {
		return transactionId;
	}

	public void setTransaction_id(int transaction_id) {
		this.transactionId = transaction_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getIn_favor_of() {
		return in_favor_of;
	}

	public void setIn_favor_of(String in_favor_of) {
		this.in_favor_of = in_favor_of;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getDate_of_transaction() {
		return date_of_transaction;
	}

	public void setDate_of_transaction(String date_of_transaction) {
		this.date_of_transaction = date_of_transaction;
	}

	public int getDd_amount() {
		return dd_amount;
	}

	public void setDd_amount(int dd_amount) {
		this.dd_amount = dd_amount;
	}

	public int getDd_commission() {
		return dd_commission;
	}

	public void setDd_commission(int dd_commission) {
		this.dd_commission = dd_commission;
	}

	public String getDd_description() {
		return dd_description;
	}

	public void setDd_description(String dd_description) {
		this.dd_description = dd_description;
	}

}
