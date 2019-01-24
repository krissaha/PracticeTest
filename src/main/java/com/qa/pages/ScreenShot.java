package com.qa.pages;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.base.BaseTest;

@Listeners(CustomListener.class)
public class ScreenShot extends BaseTest
{
	
	@BeforeMethod
	public void setup()
	{
		init();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void takeScreenShot1()
	{
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void takeScreenShot2()
	{
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void takeScreenShot3()
	{
		Assert.assertEquals(false, true);
	}

}
