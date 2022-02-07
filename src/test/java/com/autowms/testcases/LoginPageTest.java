package com.autowms.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.autowms.base.BaseClass;
import com.autowms.dataprovider.DataProviders;
import com.autowms.utility.ExtentManager;
import com.autowms.utility.Log;

public class LoginPageTest extends BaseClass{
	//SH- This class is extending BaseClass, so we can directly user "driver" as this is already defined in baseClass.
	@Parameters("browser")
	
	@BeforeMethod
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

	@Test (dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void loginPageTest(String uname, String pswd) {
		//test = extent.createTest("TestCaseName : loginTest");			/** This will move to ListenerClass, so that we dont have to write again and again in every @Test **/
		
		Log.startTestCase("Login Test");
		getDriver().findElement(By.xpath("//*[@id='txtUsername']")).sendKeys(uname);
		ExtentManager.test.info("Username entered.");
		Log.info("user is entering username");
		getDriver().findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(pswd);
		ExtentManager.test.info("Password entered.");
		Log.info("user is entering password");
		getDriver().findElement(By.xpath("//*[@id='btnLogin']")).click();
		ExtentManager.test.info("Login button clicked.");
		Log.info("Login Button clicked");
		
		Log.info("verifying weather user is able to login");
			String actualTitle = getDriver().getTitle();
			String expectedTitle = "OrangeHRM";
			//AssertJUnit.assertEquals(actualTitle, expectedTitle);
			Assert.assertEquals(actualTitle, expectedTitle);
			//ExtentManager.test.pass("Login Test Successful.");
			Log.info("Login Successful");
	}
	
	/*
	 @Test (priority=3)
		public void sampleCase() {
			//test = extent.createTest("TestCaseName : sampleTest");		/ This will move to ListenerClass, so that we dont have to write again and again in every @Test
			ExtentManager.test.createNode("Validation 1");							// Node is like Steps 
			//AssertJUnit.assertTrue(true);
			Assert.assertTrue(true);
			
			ExtentManager.test.createNode("Validation 2");
			//Assert.assertTrue(true);
			Assert.assertTrue(true);
			
			ExtentManager.test.createNode("Validation 3");
			//Assert.assertTrue(true);
			Assert.assertTrue(true);
		}
	 */
	
	

}
