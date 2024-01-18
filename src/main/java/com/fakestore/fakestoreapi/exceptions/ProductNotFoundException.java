package com.fakestore.fakestoreapi.exceptions;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message, String s){
        super(message);
    }
}
