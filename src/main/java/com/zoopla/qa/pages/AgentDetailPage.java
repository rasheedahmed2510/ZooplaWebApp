package com.zoopla.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.base.BaseTest;

public class AgentDetailPage extends BaseTest{
	
	//Object Repository
	@FindBy(xpath="//div[@id='content']//h1[@class='bottom-half']")
	private WebElement AgentName;
	
	
	//Create a constructor to initailize the current class members
	public AgentDetailPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Action Methods
	public String getAgentName(){
		return AgentName.getText().replaceAll(",[a-zA-Z0-9] ", "");
	}
	
}
