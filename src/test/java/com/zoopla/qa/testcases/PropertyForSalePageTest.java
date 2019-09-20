package com.zoopla.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.zoopla.qa.base.BaseTest;
import com.zoopla.qa.pages.HomePage;
import com.zoopla.qa.pages.PropertyDetailPage;
import com.zoopla.qa.pages.PropertyForSalePage;

@Listeners(com.zoopla.qa.retryanalyzer.TestListener.class)
public class PropertyForSalePageTest extends BaseTest{
		
	HomePage homePage;
	PropertyForSalePage propForSale;
	PropertyDetailPage propDetail;
	
	@BeforeMethod
	public void preCondition(){
		initialization();
		homePage = new HomePage();
		propForSale = homePage.searchForLocationInHomePage(prop.getProperty("Location"));
	}
	
	/*@Test
	public void verifyPropertyForSalePageHeaderTest(){
		propForSale = new ZooplaPropertyForSalePage();
		String propForSaleHeader= driver.getTitle();
		Assert.assertEquals(propForSaleHeader, prop.getProperty("PropertyForSalePageTitle").contains("Property for Sale"));
	}*/
	
	
	@Test
	public void verifyToSortThePropertyPriceListInDescendingOrderTest(){
		propForSale = new PropertyForSalePage();
		propForSale.getPropertyPriceListInDescendingOrder();
	}
	
	/*@Test
	public void verifyToSelectTheLocationBasedOnPosition(){
		propForSale = new PropertyForSalePage();
		propDetail = new PropertyDetailPage();
		String agentNameInPropDetailPage= propForSale.getAgentNameBasedOnProperty();
		propDetail = propForSale.getPropertyByPosition(5);
	}*/
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
