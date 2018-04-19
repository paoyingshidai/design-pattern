package com.michael.proxy.statical.sendgift;

/** 
 * 代理者 
 */  
public class Proxy implements GiveGift {  
	
    Pursuit gg;
    
    public Proxy(SchoolGirl mm) {         
        this.gg = new Pursuit(mm);  
    }  
    
	@Override  
    public void giveDolls() {  
        gg.giveDolls();  
    }  
	
    @Override  
    public void giveFlowers() {  
        gg.giveFlowers();  
    }  
    
    @Override  
    public void giveChocolate() {  
        gg.giveChocolate();  
    }  
}  
