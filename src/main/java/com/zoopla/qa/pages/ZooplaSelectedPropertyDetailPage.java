package com.zoopla.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zoopla.qa.base.BaseTest;

public class ZooplaSelectedPropertyDetailPage extends BaseTest{
	
	//Object Repository
	@FindBy(xpath="//div[@class='dp-sidebar-wrapper__contact']//h4[@class='ui-agent__name']")
	private WebElement AgentName;
	
	
	
}
