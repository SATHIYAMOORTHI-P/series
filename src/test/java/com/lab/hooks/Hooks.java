package com.lab.hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
public  static  WebDriver driver;
	
@Before
public void getBrowser() {
System.out.println("hooks");
System.setProperty("webdriver.chrome.driver","D:\\LabSeries\\Lab\\drivers\\chromedriver.exe");
 driver=new ChromeDriver();
driver.get("https://www.labseries.com/");
driver.manage().window().maximize();
	}

	
@After
	public void end() {
driver.quit();
	}
}	 
	
	
	
	

