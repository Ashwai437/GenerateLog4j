package com.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest 
{
	
	
	//What is log? : capturing info/activities at the time of program execution. 
		// types of logs:
			//1. info
			//2. warn
			//3. debug
			//4. fatal
			
		//how to generate the logs? : use Apache log4j API (log4j jar)
		//How it works? : it reads log 4j configuration from log4j.properties file
		//where to create: create inside resources folder
	
	
	
	
	
	
	
	
WebDriver driver;

Logger log = Logger.getLogger(LoginTest.class);


@BeforeMethod

public void setup() 
{
	log.info("****************************** Starting test cases execution  *****************************************");

	System.setProperty("webdriver.chrome.driver", "D:\\Sel\\chromedriver.exe");

	 driver=new ChromeDriver();
	
driver.manage().window().maximize();  // for window maxmize
driver.manage().deleteAllCookies();  // for delete all cookies

// Dynamic wait

driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

driver.get("https://classic.crmpro.com");
	
}



@Test(priority=1)

public void freeCrmTitleTest() {
	log.info("****************************** starting test case *****************************************");
	log.info("****************************** freeCrmTitleTest *****************************************");
	
	
	String tilte=driver.getTitle();
	System.out.println(tilte);
	Assert.assertEquals(tilte, "CRMPRO  - CRM software for customer relationship management, sales, and support.");

	
	log.info("****************************** ending test case *****************************************");
	log.info("****************************** freeCrmTitleTest *****************************************");
}



@Test(priority=2)
public void freeCRMLogoTest() 
{
	log.info("****************************** starting test case *****************************************");
	log.info("****************************** freemCRMLogoTest *****************************************");
	
	boolean b = driver.findElement(By.xpath("//a[@class='navbar-brand']//img[@class='img-responsive']")).isDisplayed();
	Assert.assertTrue(b);
	
	log.info("****************************** ending test case *****************************************");
	log.info("****************************** freemCRMLogoTest *****************************************");
}






@AfterMethod
public void teardown() 
{
	driver.quit();
	log.info("****************************** Browser is closed *****************************************");
}

	
	
}
