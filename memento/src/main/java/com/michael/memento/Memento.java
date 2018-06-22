package com.michael.memento;

/**
 * 作为保存记录的实体类
 * @author Michael
 *
 */
public class Memento {

   private String state;

   public Memento(String state){
      this.state = state;
   }

   public String getState(){
      return state;
   }
}

