package com.capgemini.go.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.sql.Date;

import com.capgemini.go.dao.RetailerInventoryDao;
import com.capgemini.go.dao.RetailerInventoryDaoImpl;
import com.capgemini.go.dto.RetailerInventoryDTO;
import com.capgemini.go.exception.ProductNotFoundException;
import com.capgemini.go.exception.RetailerException;

public class RetailerInventoryServiceImpl implements RetailerInventoryService{
RetailerInventoryDao dao;
Scanner sc;

public RetailerInventoryServiceImpl() throws SQLException {
	dao=new RetailerInventoryDaoImpl();
	 sc=new Scanner(System.in);
}

public List<RetailerInventoryDTO> getListOfRetailers() throws SQLException {
	return dao.getListOfRetailers(); 
	
}

public boolean addItemToInventory(RetailerInventoryDTO dto) throws ParseException, SQLException, RetailerException {
	
	
System.out.println("eneter the values");
System.out.println("enter retailer id");
String R_ID=sc.next();
   dto.setRetailerid(R_ID);
	boolean b2=Pattern.compile("[1-9][0-9][0-9]").matcher(R_ID).matches();
	if(b2==false)
		throw new RetailerException("only 3 digit number are allowed in R_ID");
    sc.nextLine();
    System.out.println("enter product category");
    dto.setProductCategory(sc.nextLine());
    System.out.println("enter product id");
    dto.setProductId(sc.nextLine());
    System.out.println("enter p unique id");
    dto.setProductUniqueId(sc.nextLine());
    System.out.println("enter dispatch time");
   
    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");
    java.sql.Date date2=new java.sql.Date(dateFormat.parse(sc.next()).getTime());
   
    dto.setProductDispatchTimeStamp(date2);
    System.out.println("enter receive time");
    java.sql.Date date3=new java.sql.Date(dateFormat.parse(sc.next()).getTime()); 
    dto.setProductReceiveTimeStamp(date3);
    System.out.println("enter sale time");
    java.sql.Date date5=new java.sql.Date(dateFormat.parse(sc.next()).getTime());   
    dto.setProductSaleTimeStamp(date5);
    
    return dao.insertItemInRetailerInventory(dto);
}

public boolean deleteItemFromInventory(String ri, String puid) throws SQLException, RetailerException, ProductNotFoundException {
	   System.out.println("delete item");
       System.out.println("enter retailerid and productUID");
        ri=sc.next();
    	boolean b2=Pattern.compile("[1-9][0-9][0-9]").matcher(ri).matches();
		if(b2==false)
			throw new RetailerException("only 3 digit number are allowed in R_ID");
       
    	   puid=sc.next();
       return dao.deleteItemInRetailerInventory(ri, puid);
        
}

public List<RetailerInventoryDTO> getInventoryById(String rid) throws SQLException, RetailerException {
	System.out.println("view items");
	System.out.println("enter retailerid");
	String c=sc.next();
	boolean b2=Pattern.compile("[1-9][0-9][0-9]").matcher(c).matches();
	if(b2==false)
		throw new RetailerException("only 3 digit number are allowed in R_ID");
   
	 return dao.getItemListByRetailer(c);
}


}
