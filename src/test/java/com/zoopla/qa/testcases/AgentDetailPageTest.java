package com.zoopla.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.zoopla.qa.base.BaseTest;
import com.zoopla.qa.pages.AgentDetailPage;
import com.zoopla.qa.pages.HomePage;
import com.zoopla.qa.pages.PropertyDetailPage;
import com.zoopla.qa.pages.PropertyForSalePage;

public class AgentDetailPageTest extends BaseTest {
	
	HomePage homePage;
	PropertyForSalePage propForSale;
	PropertyDetailPage propDetail;
	AgentDetailPage agentDetail;
	
	
	@BeforeMethod
	public void preCondition(){
		initialization();
		homePage = new HomePage();
		propForSale = homePage.searchForLocationInHomePage(prop.getProperty("Location"));
		propDetail = propForSale.getPropertyByPosition(Integer.parseInt(prop.getProperty("position")));
	}
	
	@Test
	public void verifyAgentNameTest(){
		agentDetail= propDetail.clickOnAgentName();
		Assert.assertTrue(agentDetail.getAgentName().contains(PropertyDetailPage.AgentName));
	}
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
