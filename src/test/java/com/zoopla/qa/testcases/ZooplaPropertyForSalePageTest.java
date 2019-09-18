package com.zoopla.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.qa.base.BaseTest;
import com.zoopla.qa.pages.ZooplaPropertyForSalePage;

public class ZooplaPropertyForSalePageTest extends BaseTest{
		
	ZooplaPropertyForSalePage propForSale;
	
	@BeforeMethod
	public void preCondition(){
		initialization();
		propForSale = new ZooplaPropertyForSalePage();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
