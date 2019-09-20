package com.zoopla.qa.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

import com.zoopla.qa.base.BaseTest;

public class TestUtils extends BaseTest {
	
	public static WebElement element;

	//Select and Deselect values from dropdown
	public static void selectByValueFromDropdown(String val){
		Select sel =new Select(element);
		sel.selectByValue(val);
	}
	
	public static void selectByIndexFromDropdown(int index){
		Select sel =new Select(element);
		sel.selectByIndex(index);
	}
	
	public static void selectByVisibleTextFromDropdown(String text){
		Select sel =new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public static void deSelectByValueFromDropdown(String val){
		Select sel =new Select(element);
		sel.deselectByValue(val);
	}
	
	public static void deSelectByIndexFromDropdown(int index){
		Select sel =new Select(element);
		sel.deselectByIndex(index);
	}
	
	public static void deSelectByVisibleTextFromDropdown(String text){
		Select sel = new Select(element);
		sel.deselectByVisibleText(text);
	}
	
	public static void deSelectAllValuesFromDropdown(){
		Select sel = new Select(element);
		sel.deselectAll();
	}
	
	public static WebElement getFirstSelectedOptionFromDropdown(){
		Select sel = new Select(element);
		return sel.getFirstSelectedOption();	
	}
	
	public static List<WebElement> getAllSelectedOptionsFromDropdown(){
		Select sel = new Select(element);
		return sel.getAllSelectedOptions();
	}
	
	public static List<WebElement> getOptionsFromDropdown(){
		Select sel = new Select(element);
		return sel.getOptions();
	}
	
	//Take screenshot
	public static void getScreenShotOnTestFailure(ITestResult res){
		TakesScreenshot ts= (TakesScreenshot) driver;	
		File screenShotSrc= ts.getScreenshotAs(OutputType.FILE);
		File screenShotDest = new File("./screenshot/"+res.getName()+".png");
		try {
			FileUtils.copyFile(screenShotSrc, screenShotDest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
