package com.zoopla.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.zoopla.qa.base.BaseTest;
import com.zoopla.qa.pages.ZooplaHomePage;
import com.zoopla.qa.pages.ZooplaPropertyDetailPage;
import com.zoopla.qa.pages.ZooplaPropertyForSalePage;

public class ZooplaPropertyForSalePageTest extends BaseTest{
		
	ZooplaHomePage homePage;
	ZooplaPropertyForSalePage propForSale;
	ZooplaPropertyDetailPage propDetail;
	
	@BeforeMethod
	public void preCondition(){
		initialization();
		homePage = new ZooplaHomePage();
		propForSale = homePage.searchForLocationInHomePage(prop.getProperty("Location"));
	}
	
	/*@Test
	public void verifyPropertyForSalePageHeaderTest(){
		propForSale = new ZooplaPropertyForSalePage();
		String propForSaleHeader= driver.getTitle();
		Assert.assertEquals(propForSaleHeader, prop.getProperty("PropertyForSalePageTitle").contains("Property for Sale"));
	}*/
	
	
	/*@Test
	public void verifyToSortThePropertyPriceListInDescendingOrderTest(){
		propForSale = new ZooplaPropertyForSalePage();
		propForSale.getPropertyPriceListInDescendingOrder();
	}*/
	
	@Test
	public void verifyToSelectTheLocationBasedOnPosition(){
		propForSale = new ZooplaPropertyForSalePage();
		propDetail = new ZooplaPropertyDetailPage();
		String agentNameInPropDetailPage= propForSale.getAgentNameBasedOnProperty();
		propDetail = propForSale.getPropertyByPosition(5);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
