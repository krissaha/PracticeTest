package com.qa.pages;

import java.awt.dnd.DragGestureRecognizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.swing.SortingFocusTraversalPolicy;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tariff {
	
	public static void click(WebDriver driver,WebElement element, int timeout)
	{	new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();}
	
	public static void sendkeys(WebDriver driver,WebElement element,int timeout, String value)
	{	new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);}
	

	public static void main(String[] args) throws InterruptedException {

		String hiddenCaptchaVal = "";
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://appdev.nvisionglobal.com");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		/*---------------------------------------------------------------------------------------------------------------*/
		// Input Email id
		driver.findElement(By.id("Email")).sendKeys("dibyendud@tranistics.com");
		// Input password
		driver.findElement(By.id("Password")).sendKeys("pass123");
		// Input Captcha
		hiddenCaptchaVal = driver.findElement(By.id("HiddenCaptcha")).getAttribute("value");
		driver.findElement(By.id("Captcha")).sendKeys(hiddenCaptchaVal);
		// Click Login Button
		driver.findElement(By.id("btnLogin")).click();
		/*---------------------------------------------------------------------------------------------------------------*/
		// For selecting data from Drop-down
		Select oS = new Select(driver.findElement(By.id("SelectedCompanyId")));
		oS.selectByValue("5692");
		// Click on Submit button
		driver.findElement(By.className("newsc")).click();
		// Click on Pricing menu in Dashboard Page
		WebElement p1 = driver.findElement(By.xpath("//span[contains(text(),'Pricing')]"));
		click(driver, p1, 10);
		WebElement t1 = driver.findElement(By.xpath("//span[contains(text(),'Tariff')]"));
		click(driver, t1, 10);
		
		/*---------------------------------------------------------------------------------------------------------------*/

		// Click on the search button
		// driver.findElement(By.id("btnSearchTariff")).click();
		// Click to navigate last Tariff Details
		// driver.findElement(By.xpath("//span[@class='k-icon
		// k-i-seek-e']")).click();
		// Thread.sleep(2000);
		// Adding Tariff Header Data with AIR
		WebElement e1 = driver.findElement(By.xpath("//span[contains(text(), 'Select Provider')]"));
		click(driver, e1, 5);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul[@id='TPdropdownlist_listbox']//child::li[13]")).click();
		driver.findElement(By.xpath("//input[@id='HTariffName']")).sendKeys("Sel_DATA");
		driver.findElement(By.xpath("//span[contains(text(), '--Service--')]")).click();
		Thread.sleep(5000);
		WebElement e2 = driver.findElement(By.xpath("//input[@aria-owns='Hservice_listbox']"));
		sendkeys(driver, e2, 10, "AIR FREIGHT");
		Thread.sleep(5000);
		WebElement e3 = driver.findElement(By.xpath("//ul[@id='Hservice_listbox']//child::li[2]"));
		click(driver, e3, 10);

		// Adding Tariff Details data
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='k-button k-button-icontext k-grid-add-tariff']//child::span[@class='k-icon k-add']")).click();
		Thread.sleep(3000);
//		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/"
//				+ "div[4]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[4]")).click();
//		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/"
//				+ "div[4]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[4]")).sendKeys("1");
		driver.findElement(By.xpath("//td[contains(text(),'Cost per Weight')]")).click();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.xpath("//td[@id='aria_active_cell']"));
		js.executeScript("arguments[0].click();", element);
		
//		boolean b1 = driver.findElement(By.xpath("//tr[@data-uid='b168566e-2d68-490c-96fc-bee4a17c66d6']//td[6]")).isEnabled();
//		System.out.println(b1);
			
		//tr[@data-uid='d42d33c9-4d0c-42e3-9156-5b18fa77af58']//td[5]
		//tr[@data-uid='b168566e-2d68-490c-96fc-bee4a17c66d6']//td[6]
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// // Adding Tariff Header Data with small package
		// driver.findElement(By.xpath("//span[contains(text(), 'Select
		// Provider')]")).click();
		// Thread.sleep(3000);
		// driver.findElement(By.xpath("//ul[@id='TPdropdownlist_listbox']//child::li[2]")).click();
		// driver.findElement(By.xpath("//input[@id='HTariffName']")).sendKeys("Sel_DATA");
		// driver.findElement(By.xpath("//span[contains(text(),
		// '--Service--')]")).click();
		// Thread.sleep(5000);
		// driver.findElement(By.xpath("//input[@aria-owns='Hservice_listbox']")).sendKeys("STANDARD");
		// Thread.sleep(5000);
		// driver.findElement(By.xpath("//ul[@id='Hservice_listbox']//child::li[2]")).click();
		// Thread.sleep(5000);
		// driver.findElement(By.xpath("//span[contains(text(),'--Select--')]")).click();
		// Thread.sleep(5000);
		// driver.findElement(By.xpath("//ul[@id='HTariffType_listbox']//child::li[5]")).click();
		//
		// // Adding Tariff Details data
		// Thread.sleep(5000);
		// driver.findElement(By.xpath("//a[@class='k-button k-button-icontext
		// k-grid-add-tariff']//child::span[@class='k-icon k-add']")).click();
		// Thread.sleep(5000);
		// driver.findElement(By.xpath("//td[@id='aria_active_cell']")).click();
		// Thread.sleep(3000);
		// //driver.findElement(By.xpath("//td[@role='gridcell' and
		// contains(text(),'01-Oct-2018')]")).click();
		//
		// Actions action = new Actions(driver);
		// WebElement btn =
		// driver.findElement(By.xpath("//td[@id='aria_active_cell' and
		// @data-role='editable']"));
		// Thread.sleep(5000);
		// action.doubleClick(btn).perform();

		// Thread.sleep(5000);
		// driver.findElement(By.xpath("//td[@id='aria_active_cell' and
		// contains(text(),' 0')]")).click();
		// //sendKeys("All-US_GA_30303_US_CA_90001");

		// Click on the Class Rate Tariff
		// driver.findElement(By.xpath("//span[contains(text(),'ClassRateTariff')]")).click();
		// Thread.sleep(5000);
		// driver.close();
	}
}
