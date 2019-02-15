package com.qa.pages;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait 
{	
	public static void main(String[] args)throws Exception
	{
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://appdev.nvisionglobal.com/Account/Login#");
		
		WebElement email = driver.findElement(By.id("Email"));
		sendkeys(driver,email,5, "dibyendud@tranistics.com");
		
		WebElement password = driver.findElement(By.id("Password"));
		sendkeys(driver,password,7, "pass123");
		
		String hiddenCaptchaVal = "";
		hiddenCaptchaVal = driver.findElement(By.id("HiddenCaptcha")).getAttribute("value");
		driver.findElement(By.id("Captcha")).sendKeys(hiddenCaptchaVal);
		
		WebElement submit = driver.findElement(By.id("btnLogin"));
		click(driver,submit, 10);
	}
	public static void sendkeys(WebDriver driver,WebElement element,int timeout, String value)
	{	new WebDriverWait(driver, timeout).until(ExpectedConditions.invisibilityOf(element));
		element.sendKeys(value);}
	
	public static void click(WebDriver driver,WebElement element, int timeout)
	{	new WebDriverWait(driver, timeout).until(ExpectedConditions.invisibilityOf(element));
		element.click();}
	}
