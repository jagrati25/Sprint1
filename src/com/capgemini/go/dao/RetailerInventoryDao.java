package com.capgemini.go.dao;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.go.dto.RetailerInventoryDTO;

public interface RetailerInventoryDao {
	 List<RetailerInventoryDTO> getListOfRetailers() throws SQLException;
	 List<RetailerInventoryDTO> getItemListByRetailer(String retailerid) throws SQLException;
	 boolean deleteItemInRetailerInventory(String retailerid,String productuniqueid) throws SQLException;
	 boolean insertItemInRetailerInventory(RetailerInventoryDTO r) throws SQLException;
}
