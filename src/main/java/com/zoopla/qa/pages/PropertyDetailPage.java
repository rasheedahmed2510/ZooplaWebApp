package com.zoopla.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.zoopla.qa.base.BaseTest;

public class PropertyDetailPage extends BaseTest{
	
	//Object Repository
	@FindBy(xpath="//div[@class='dp-sidebar-wrapper__contact']//img[@class='js-lazy-loaded']")
	private WebElement agentLogo;
	
	@FindBy(xpath="//div[@class='dp-sidebar-wrapper__contact']//h4[@class='ui-agent__name']")
	private WebElement agentName;
	
	@FindBy(xpath="//div[@class='dp-sidebar-wrapper__contact']//a[@class='ui-link']")
	private WebElement agentPhone;
	
	public static String AgentName;
	
	//create a constructor to initialize the current class memebers
	public PropertyDetailPage() {	
		PageFactory.initElements(driver, this);
	}
	
	//Action methods
	public void getAgentDetails(){
		System.out.println("Agent details are: ");
		System.out.println("Agent Name: "+agentName.getText());
		System.out.println("Agent Phone: "+agentPhone.getAttribute("href").replaceAll("tel:" , ""));
		System.out.println("Agent Logo text: "+agentLogo.getAttribute("alt"));
	}
	
	public AgentDetailPage clickOnAgentName(){
		AgentName= agentName.getText();
		agentName.click();
		return new AgentDetailPage();
	}
}
