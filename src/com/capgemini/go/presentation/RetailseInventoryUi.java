package com.capgemini.go.presentation;


import java.sql.SQLException;
import java.text.ParseException;

import java.util.List;
import java.util.Scanner;

import com.capgemini.go.dao.RetailerInventoryDaoImpl;
import com.capgemini.go.dto.RetailerInventoryDTO;
import com.capgemini.go.exception.ProductNotFoundException;
import com.capgemini.go.exception.RetailerException;
import com.capgemini.go.service.RetailerInventoryService;
import com.capgemini.go.service.RetailerInventoryServiceImpl;

public class RetailseInventoryUi {
	public static void main(String[] args) throws ParseException, SQLException, RetailerException, ProductNotFoundException {
		
	Scanner sc=new Scanner(System.in);
		RetailerInventoryDaoImpl dao=new RetailerInventoryDaoImpl();
		RetailerInventoryService service=new RetailerInventoryServiceImpl();
		 RetailerInventoryDTO dto=new RetailerInventoryDTO();
			System.out.println("Select Operation");
			System.out.println("1. Insert Items In Inventory");
			System.out.println("2.Delete Items From Inventory");
			System.out.println("3.View Inventory");
			System.out.println("4.List of Retailers");
		
			int op = sc.nextInt();
            String R_ID=null;
            switch(op) {
            	case 1:
            		try {
            			boolean stat=service.addItemToInventory(dto);
            			System.out.println(stat);
            			} catch(SQLException e) {
            				System.out.println(e.getMessage());
            			}
            		break;
            	case 2:
            		try {
            			String ri=null,puid=null;
            			boolean status=service.deleteItemFromInventory(ri, puid);
            			System.out.println(status);
            		} catch (ProductNotFoundException e) {
            			System.out.println(e.getMessage());
            		}
            		break;
            	case 3:
            		try {
            			String rid=null;
            			List<RetailerInventoryDTO> ar=service.getInventoryById(rid);
            			for (RetailerInventoryDTO retailerInventoryDTO : ar) {
            				System.out.println(retailerInventoryDTO.getProductUniqueId());
            		         }
                         } catch (SQLException e) {
                        	 System.out.println(e.getMessage());
                         }
            		break;
            	case 4:
            		try {
            			
            			List<RetailerInventoryDTO> ar1=service.getListOfRetailers();
            			for (RetailerInventoryDTO retailerInventoryDTO1 : ar1) {
            				System.out.println(retailerInventoryDTO1.getRetailerid()+" "+retailerInventoryDTO1.getRetailerName());
            			}
            		} catch (SQLException e) {
            			System.out.println(e.getMessage());
            		}
            		break;
            	default:
            		break;
            
	} 
}
            
}          
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
  
	
	
	
	


