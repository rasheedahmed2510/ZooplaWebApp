package com.zoopla.qa.analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import com.zoopla.qa.base.BaseTest;

public class RetryAnalyzer extends BaseTest implements IRetryAnalyzer {
	
	int retryLimit=1;
	int counter=0;
	
	public boolean retry(ITestResult res){
		if(counter< retryLimit){
			counter++;
			return true;
		}else
			return false;
	}
	
	
}
