package com.amz.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amz.qa.base.TestBase;
import com.amz.qa.pages.AccountPage;
import com.amz.qa.pages.HomePage;
import com.amz.qa.pages.ProductPage;
import com.amz.qa.util.TestUtil;

public class AccountPageTest extends TestBase{
	HomePage homePage;
	TestUtil testUtil;
	AccountPage accountPage;
	
	public AccountPageTest() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil=new TestUtil();
		homePage= new HomePage();
		accountPage = new AccountPage();
//		
	}
	
	
	@Test(priority=1)
	public void loginAndLogoutTest() throws InterruptedException {
		homePage.loginToSite(prop.getProperty("phone"),prop.getProperty("password"));
		Thread.sleep(2000);
		accountPage=homePage.clickOnActLink();
		accountPage.clickLogOutBtn();
	}
	


	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}


