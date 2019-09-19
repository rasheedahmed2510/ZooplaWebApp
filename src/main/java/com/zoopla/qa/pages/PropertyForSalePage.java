package com.zoopla.qa.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.zoopla.qa.base.BaseTest;

public class PropertyForSalePage extends BaseTest{
	
	//Object Repository
	@FindBy(xpath="//h1[contains(text(),'Property for sale in')]")
	private WebElement PropertyForSaleHeader;
	
	@FindBy(xpath="//small[contains(text(),'Listed on')]/../../../..//a[@class='listing-results-price text-price']")
	private List<WebElement> PropertyPriceList;
	
	@FindBy(xpath="//small[contains(text(),'Listed on')]/..//span")
	private WebElement AgentName;
	
	List<Integer> priceList = new ArrayList<Integer>();
	
	//Create a constructor to initialize the current class objects
	public PropertyForSalePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Action methods for Property For Sale Page
	public boolean verifyLocation(String location){
		return PropertyForSaleHeader.getText().contains(location);
	}
	
	public void getPropertyPriceListInDescendingOrder(){
		log.info("The total no: of properties listed in the Property for sale page are: "+ PropertyPriceList.size());
		for(WebElement propertyPrice: PropertyPriceList){
			//Except nos: remove all other data, ^ represents except
			if(propertyPrice.getText().replaceAll("[^0-9]", "").isEmpty()){
				System.out.println("The property has price which is empty "+propertyPrice.getText()+" was not added to the list");
			}else{
				priceList.add(Integer.parseInt(propertyPrice.getText().replaceAll("[^0-9]", "")));
			}
			System.out.println("The propert price list in descending order is: -->");
			Collections.sort(priceList, Collections.reverseOrder());
			System.out.println(priceList);
		}
	}
	
	public PropertyDetailPage getPropertyByPosition(int position){
		PropertyPriceList.get(position).click();
		return new PropertyDetailPage();
	}
	
	public String getAgentNameBasedOnProperty(){
		return AgentName.getText().replaceAll(", ", "");
	}
	
}
