package com.capgemini.mobipur.dao;

public interface QueryMapperMobile {
	public static final String UPDATE_MOBILES = "UPDATE mobiles SET quantity = ? WHERE mobileid =?";
	
    public static final String DELETE_MOBILES= "DELETE FROM mobiles WHERE mobileid=?";
    
    public static final String VIEW_MOBILES = "SELECT mobileid,name,price,quantity FROM mobiles";
    
    public static final String SEARCH_MOBILES = "SELECT mobileid,name,price,quantity FROM mobiles WHERE price BETWEEN ? AND ?";

    public static final String GET_MOBILES = "SELECT quantity FROM mobiles WHERE mobileid = ?";

}
