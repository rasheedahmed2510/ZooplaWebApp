package com.zoopla.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.base.BaseTest;

public class ZooplaHomePage extends BaseTest {
	
	//Object Repository
	@FindBy(xpath="//a[@id='search-tabs-for-sale']")
	private WebElement ForSaletab;
	
	@FindBy(xpath="//input[@id='search-input-location']")
	private WebElement SearchInputLocation;
	
	@FindBy(xpath="(//li[@class='ui-menu-item'])[1]")
	private WebElement SelectFirstOptionFromInputSearch;
	
	@FindBy(xpath="//button[text()='Search']")
	private WebElement SearchBtn;
	
	//Create a constructor to initialize the current class objects
	public ZooplaHomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Action methods for Zoopla Home Page
	public ZooplaPropertyForSalePage searchForLocationInHomePage(String location){
		//ForSaletab.click();
		Actions act = new Actions(driver);
		act.moveToElement(SearchInputLocation).perform();
		SearchInputLocation.sendKeys(location);
		SelectFirstOptionFromInputSearch.click();
		SearchBtn.submit();
		return new ZooplaPropertyForSalePage();	
	}
	
}
