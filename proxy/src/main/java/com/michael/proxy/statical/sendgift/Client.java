package com.michael.proxy.statical.sendgift;

/**
 * 表面上是 Proxy 送的，但是，实际上是 Pursuit 送的。
 * @author Michael
 *
 */
public class Client {

	public static void main(String[] args) {  
		
        SchoolGirl jiaojiao = new SchoolGirl();  
        jiaojiao.setName("李娇娇");  
          
        Proxy proxy = new Proxy(jiaojiao);  
        proxy.giveDolls();  
        proxy.giveFlowers();  
        proxy.giveChocolate();  
    }  
	
}
