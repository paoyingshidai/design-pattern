package com.michael.responsibility.chain.log;

public class Client {

	  private static AbstractLogger getChainOfLoggers(){

	      AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
	      AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
	      AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

	      errorLogger.setNextLogger(fileLogger);
	      fileLogger.setNextLogger(consoleLogger);

	      return errorLogger;    
	   }

	   public static void main(String[] args) {
	      AbstractLogger loggerChain = getChainOfLoggers();

	      loggerChain.logMessage(AbstractLogger.INFO, 
	         "This is an INFO level information.");

		   System.out.println();

	      loggerChain.logMessage(AbstractLogger.DEBUG, 
	         "This is an DEBUG level information.");

		   System.out.println();

	      loggerChain.logMessage(AbstractLogger.ERROR, 
	         "This is an ERROR level information.");
	   }
	   
}
