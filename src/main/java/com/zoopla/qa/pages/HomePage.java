package com.zoopla.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.base.BaseTest;

public class HomePage extends BaseTest {
	
	//Object Repository
	
	@FindBy(xpath="//input[@id='search-input-location']")
	private WebElement SearchInputLocation;
	
	@FindBy(xpath="//button[text()='Search']")
	private WebElement SearchBtn;
	
	//Create a constructor to initialize the current class objects
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Action methods for Zoopla Home Page
	public PropertyForSalePage searchForLocationInHomePage(String location){
		Actions act = new Actions(driver);
		act.moveToElement(SearchInputLocation).perform();
		SearchInputLocation.sendKeys(location);
		SearchBtn.submit();
		return new PropertyForSalePage();	
	}
	
}
