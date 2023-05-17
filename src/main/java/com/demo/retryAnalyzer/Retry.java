package com.demo.retryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	private static final int maxTry = 3;
	   private int count  = 0;

	   public boolean retry (final ITestResult iTestResult) {
	       if (!iTestResult.isSuccess ()) {
	           if (count < maxTry) {
	               count++;
	               iTestResult.setStatus(iTestResult.FAILURE);
	               return true;
	           }else {
	        	   iTestResult.setStatus(iTestResult.FAILURE);
	           }
	       }else {
	    	   iTestResult.setStatus(iTestResult.SUCCESS);
	       }
	       return false;
	   }

}
