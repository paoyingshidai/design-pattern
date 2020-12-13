package com.michael.proxy.cglib;

public class BookFacadeImpl1 { 
	
    public void addBook() {  
        System.out.println("新增图书...");
    }

    public void delBook() {
        System.out.println("删除图书...");
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }
}  

