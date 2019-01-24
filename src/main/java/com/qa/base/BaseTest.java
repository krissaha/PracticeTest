package com.qa.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest 
{
	public static WebDriver driver;
	
	public static void init()
	{
		//Launching chrome driver
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver.exe");  
		driver = new ChromeDriver();
		
		//Launching Url
	    driver.get("https://www.google.com"); 
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
	 }
	
	public void failed(String testMethodName) 
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("E:/Selenium/PracticeTest/ScreenShots/"+testMethodName+"_"+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
