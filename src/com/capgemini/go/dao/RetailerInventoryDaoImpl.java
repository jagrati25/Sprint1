package com.capgemini.go.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Date;

import com.capgemini.go.DatabaseUtil.DataBaseUtil;
import com.capgemini.go.dto.RetailerInventoryDTO;

public class RetailerInventoryDaoImpl implements RetailerInventoryDao {

	Connection connection;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	RetailerInventoryDTO dto;
	ArrayList<RetailerInventoryDTO> ar;
	 
	String ch;
	Scanner sc=new Scanner(System.in);
	public RetailerInventoryDaoImpl() throws SQLException {
		connection= DataBaseUtil.myconnection();
		connection.setAutoCommit(false);
	}
	
	public boolean insertItemInRetailerInventory(RetailerInventoryDTO r) throws SQLException 
	{
		st=connection.createStatement();
		rs=st.executeQuery("select * from retailerInventory");
		pst=null;
		pst=connection.prepareStatement( "insert into retailerInventory values(?,?,?,?,?,?,?)");
		pst.setString(1,r.getRetailerid());
		pst.setString(2,r.getProductCategory());
		pst.setString(3,r.getProductId());
		pst.setString(4,r.getProductUniqueId());
		pst.setDate(5, r.getProductDispatchTimeStamp());
		pst.setDate(6,r.getProductReceiveTimeStamp());
		pst.setDate(7,r.getProductSaleTimeStamp());
		
		int res=pst.executeUpdate();
		if(res==1)
		{
			System.out.println("Add it to datay\\n");
			ch=sc.next();
			if(ch.equals("y")) {
				connection.commit();
				return true;
			}
			else
				connection.rollback();
			return false;
		}
		else
			return false;
	}
	public boolean deleteItemInRetailerInventory(String retailerid,String productuniqueid) throws SQLException
	{
		pst=connection.prepareStatement("delete from retailerInventory where R_ID=? and P_UID=?");
		pst.setString(1, retailerid);
		pst.setString(2, productuniqueid);
		int res=pst.executeUpdate();
		if(res==1) {
			System.out.println("Add it to datay\\n");
		ch=sc.next();
		if(ch.equals("y")) {
			connection.commit();
			return true;
		}
		else
			connection.rollback();
			return false;}
		else
		return false;
	}
	
	public List<RetailerInventoryDTO> getItemListByRetailer(String retailerid) throws SQLException {
		pst = connection.prepareStatement("select * from retailerInventory where R_ID=?");
		
		pst.setString(1, retailerid);
		rs=null;
		rs =pst.executeQuery();
		ar = new ArrayList<>();
		while (rs.next()) {
			dto = null;
			dto = new RetailerInventoryDTO();
			
			dto.setProductUniqueId(rs.getString(4));
			
			ar.add(dto);
			
		}
		return ar ;
	}
	
	public List<RetailerInventoryDTO> getListOfRetailers() throws SQLException {
		st = connection.createStatement();
		
		
		rs=null;
		rs =st.executeQuery("select * from retailer");
		ar = new ArrayList<>();
		while (rs.next()) {
			dto = null;
			dto = new RetailerInventoryDTO();
			
			dto.setRetailerid(rs.getString(1));
			dto.setRetailerName(rs.getString(2));
			
			ar.add(dto);
			
		}
		return ar ;
	}
	
}
