package com.michael.memento;

/**
 * 产生记录的对象
 * @author Michael
 *
 */
public class Originator {

   private String state;

   public void setState(String state){
      this.state = state;
   }

   public String getState(){
      return state;
   }

   public Memento saveStateToMemento(){
      return new Memento(state);
   }

   public void getStateFromMemento(Memento Memento){
      state = Memento.getState();
   }
}

