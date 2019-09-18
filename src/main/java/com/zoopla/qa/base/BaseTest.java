package com.zoopla.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.zoopla.qa.generic.AutoConstants;

public abstract class BaseTest implements AutoConstants{
	
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public static Logger log;
	
	public BaseTest(){
		log = Logger.getLogger(this.getClass());
		prop= new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\zoopla\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//static block to allocate static memory variables only 1 time when the class file loads in the memory
	static{
		System.setProperty(chromeKey, chromeValue);
		System.setProperty(firefoxKey, firefoxValue);
	}
	
	public static void initialization(){
		//read the browser value from property file
		String browserName= prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
			log.info("Chrome browser launched");
		}else if(browserName.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
			log.info("Firefox browser launched");
		}else{
			log.info("Failed to launch the browser.. Check the browser name in config file..");
		}
		driver.manage().window().maximize();
		log.info("browser window maximized");
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		log.info("Implicit wait applied");
		driver.get(prop.getProperty("url"));
		log.info("URL entered");
	}
	
	
}
