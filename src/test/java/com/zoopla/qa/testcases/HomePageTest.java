package com.zoopla.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.zoopla.qa.base.BaseTest;
import com.zoopla.qa.pages.PropertyForSalePage;
import com.zoopla.qa.pages.HomePage;

@Listeners(com.zoopla.qa.retryanalyzer.TestListener.class)
public class HomePageTest extends BaseTest {
	
	HomePage homePage;
	PropertyForSalePage propForSalePage;
	
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
		homePage= new HomePage();
		propForSalePage= new PropertyForSalePage();
		propForSalePage= homePage.searchForLocationInHomePage(prop.getProperty("Location"));
		Assert.assertTrue(propForSalePage.verifyLocation(prop.getProperty("Location")));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
