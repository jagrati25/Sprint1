package com.capgemini.go.exception;

public class ProductNotFoundException extends Exception{
public ProductNotFoundException(String msg) {
	super("product not found"+msg);
}
}
