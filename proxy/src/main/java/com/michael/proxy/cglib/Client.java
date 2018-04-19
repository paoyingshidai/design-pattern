package com.michael.proxy.cglib;

/**
 * 关于 cglib 的 filter 的一篇文章 https://blog.csdn.net/difffate/article/details/70552056
 * 
 * @author Michael
 *
 */
public class Client {

	public static void main(String[] args) {      
        BookFacadeImpl1 bookFacade=new BookFacadeImpl1();
        BookFacadeCglib  cglib=new BookFacadeCglib();  
        BookFacadeImpl1 bookCglib=(BookFacadeImpl1)cglib.getInstance(bookFacade);  
        bookCglib.addBook();  
    } 
	
}
