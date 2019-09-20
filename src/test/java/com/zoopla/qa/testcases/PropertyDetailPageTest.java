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
public class PropertyDetailPageTest extends BaseTest {
	
	HomePage homePage;
	PropertyForSalePage propForSale;
	PropertyDetailPage propDetail;
	
	@BeforeMethod
	public void preConditon(){
		initialization();
		homePage = new HomePage();
		propForSale = homePage.searchForLocationInHomePage(prop.getProperty("Location"));
		propDetail = propForSale.getPropertyByPosition(Integer.parseInt(prop.getProperty("position")));	
	}
	
	@Test
	public void verifyToGetAgentDetailsPageTest(){
		propDetail.getAgentDetails();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
