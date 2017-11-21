package com.capgemini.bank.constant;

public interface JdbcConstant {
	
	public static final String INSERTSQL="insert into demand_draft values(BANKSEQ.nextval,?,?,?,sysdate,?,?,?)";
	public static final String IDSQL="select BANKSEQ.currval from dual";
	public static final String DISPLAYSQL="select * from demand_draft where transaction_id=?";
}
