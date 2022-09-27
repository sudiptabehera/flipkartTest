package com.amz.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amz.qa.base.TestBase;

public class AccountPage extends TestBase{
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div[2]/div[6]/div/span")
	WebElement logoutBtn;
	
	public AccountPage() {
		PageFactory.initElements(driver, this);
		
	}
	public void clickLogOutBtn() {
	
		logoutBtn.click();
		
	}
	
}
