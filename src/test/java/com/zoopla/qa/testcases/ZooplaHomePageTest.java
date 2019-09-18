package com.zoopla.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.zoopla.qa.base.BaseTest;
import com.zoopla.qa.pages.ZooplaPropertyForSalePage;
import com.zoopla.qa.pages.ZooplaHomePage;

public class ZooplaHomePageTest extends BaseTest {
	
	ZooplaHomePage homePage;
	ZooplaPropertyForSalePage propForSalePage;
	
	@BeforeMethod
	public void preCondition(){
		initialization();
	}
	
	@Test
	public void verifyZooplaHomePageTitle(){
		String zooplaHomePageTitle= driver.getTitle();
		Assert.assertEquals(zooplaHomePageTitle, prop.getProperty("ZooplaHomePageTitle"));
	}
	
	@Test
	public void verifyPropertyForSalePageBasedOnLocationTest(){
		homePage= new ZooplaHomePage();
		propForSalePage= new ZooplaPropertyForSalePage();
		propForSalePage= homePage.searchForLocationInHomePage(prop.getProperty("Location"));
		Assert.assertTrue(propForSalePage.verifyLocation(prop.getProperty("Location")));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
