package com.autowms.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.autowms.base.BaseClass;
import com.autowms.dataprovider.DataProviders;
import com.autowms.pageobjects.IndexPage;
import com.autowms.utility.ExtentManager;
import com.autowms.utility.Log;



public class IndexPageTest extends BaseClass{
	
	//Step-1
	private IndexPage indexPage;
	
	//Step-2
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		launchApp(browser);
	}
	
	//Step-3
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	//Step-4
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class) 
	public void indexPageTest() throws Throwable {
		
		indexPage= new IndexPage();
		
	//VerifyLogo
		Log.startTestCase("verifyLogo");
		indexPage= new IndexPage();
		boolean result=indexPage.validateLogo();
		Assert.assertTrue(result);
		Log.endTestCase("verifyLogo");
		
	//Verify Title
		Log.startTestCase("verifyTitle");
		String actTitle=indexPage.getMyStoreTitle();
		Assert.assertEquals(actTitle, "My Store1");
		Log.endTestCase("verifyTitle");
		
	}
		
	
	
	

}
