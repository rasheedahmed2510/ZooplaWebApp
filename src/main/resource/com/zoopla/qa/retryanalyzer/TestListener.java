package com.zoopla.qa.retryanalyzer;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.zoopla.qa.base.BaseTest;
import com.zoopla.qa.utils.TestUtils;

public class TestListener extends BaseTest implements ITestListener{

	public void onTestStart(ITestResult result) {	
		System.out.println("<----"+result.getName()+"  is Started---->");
		log.info("<----"+result.getName()+ "  is Started---->");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("<----"+result.getName()+"  was Passed---->");
		log.info("<----"+result.getName()+ "  was Passed---->");	
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("<----"+result.getName()+"  was Failed---->");
		log.info("<----"+result.getName()+ "  was Failed---->");
		TestUtils.getScreenShotOnTestFailure(result);
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("<----"+result.getName()+"  was Skipped---->");
		log.info("<----"+result.getName()+ "  was Skipped---->");	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		//
		
	}

	public void onStart(ITestContext context) {
		//
		
	}

	public void onFinish(ITestContext context) {
		//
		
	}

}
