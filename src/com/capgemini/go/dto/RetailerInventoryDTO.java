package com.capgemini.go.dto;

import java.sql.Date;
import java.util.Calendar;

public class RetailerInventoryDTO {
private String retailerid;
private String productCategory;
private String productId;
private String productUniqueId;
private Date productDispatchTimeStamp;
private Date productReceiveTimeStamp;
private Date productSaleTimeStamp;
private String retailerName;

public RetailerInventoryDTO(String retailerid, String productCategory, String productId, String productUniqueId,
		Date productDispatchTimeStamp, Date productReceiveTimeStamp, Date productSaleTimeStamp) {
	super();
	this.retailerid = retailerid;
	this.productCategory = productCategory;
	this.productId = productId;
	this.productUniqueId = productUniqueId;
	this.productDispatchTimeStamp = productDispatchTimeStamp;
	this.productReceiveTimeStamp = productReceiveTimeStamp;
	this.productSaleTimeStamp = productSaleTimeStamp;
}

public RetailerInventoryDTO() {
	
}
public String getRetailerid() {
	return retailerid;
}
public void setRetailerid(String retailerid) {
	this.retailerid = retailerid;
}
public String getProductCategory() {
	return productCategory;
}
public void setProductCategory(String productCategory) {
	this.productCategory = productCategory;
}
public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}
public String getProductUniqueId() {
	return productUniqueId;
}
public void setProductUniqueId(String productUniqueId) {
	this.productUniqueId = productUniqueId;
}
public Date getProductDispatchTimeStamp() {
	return productDispatchTimeStamp;
}
public void setProductDispatchTimeStamp(Date productDispatchTimeStamp) {
	this.productDispatchTimeStamp = productDispatchTimeStamp;
}
public Date getProductReceiveTimeStamp() {
	return productReceiveTimeStamp;
}
public void setProductReceiveTimeStamp(Date productReceiveTimeStamp) {
	this.productReceiveTimeStamp = productReceiveTimeStamp;
}
public Date getProductSaleTimeStamp() {
	return productSaleTimeStamp;
}
public void setProductSaleTimeStamp(Date productSaleTimeStamp) {
	this.productSaleTimeStamp = productSaleTimeStamp;
}

public String getRetailerName() {
	return retailerName;
}

public void setRetailerName(String retailerName) {
	this.retailerName = retailerName;
}

@Override
public String toString() {
	return "RetailerInventory [retailerid=" + retailerid + ", productCategory=" + productCategory + ", productId="
			+ productId + ", productUniqueId=" + productUniqueId + ", productDispatchTimeStamp="
			+ productDispatchTimeStamp + ", productReceiveTimeStamp=" + productReceiveTimeStamp
			+ ", productSaleTimeStamp=" + productSaleTimeStamp + "]";
}


}
