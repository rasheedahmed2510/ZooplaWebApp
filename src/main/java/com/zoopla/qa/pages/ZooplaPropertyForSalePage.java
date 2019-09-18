package com.zoopla.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.zoopla.qa.base.BaseTest;

public class ZooplaPropertyForSalePage extends BaseTest{
	
	//Object Repository
	@FindBy(xpath="//h1[contains(text(),'Property for sale in')]")
	private WebElement PropertyForSaleHeader;
	
	
	
	//Create a constructor to initialize the current class objects
	public ZooplaPropertyForSalePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	//Action methods for Property For Sale Page
	public boolean verifyLocation(String location){
		return PropertyForSaleHeader.getText().contains(location);
	}
	
	
}
