package com.capgemini.go.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.capgemini.go.dto.RetailerInventoryDTO;
import com.capgemini.go.exception.ProductNotFoundException;
import com.capgemini.go.exception.RetailerException;

public interface RetailerInventoryService {
	List<RetailerInventoryDTO> getListOfRetailers() throws SQLException;
	boolean addItemToInventory(RetailerInventoryDTO dto) throws ParseException, SQLException, RetailerException;
	 boolean deleteItemFromInventory(String ri, String puid) throws SQLException, RetailerException, ProductNotFoundException;
	 List<RetailerInventoryDTO> getInventoryById(String rid) throws SQLException, RetailerException;
}
