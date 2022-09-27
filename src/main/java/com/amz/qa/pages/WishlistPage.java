package com.amz.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amz.qa.base.TestBase;

public class WishlistPage extends TestBase{
	
	
	
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[2]/div/div/div[1]/span")
	WebElement wishlistTotalItem ;
	
	
	
	public WishlistPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyItemWishlist() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println(wishlistTotalItem.getAttribute("innerHTML"));
		int totalItem=Integer.valueOf(wishlistTotalItem.getAttribute("innerHTML").replaceAll("[^0-9]", ""));
		
		return driver.findElement(By.xpath("//div/div/div["+(totalItem+1)+"]/a/div[2]/div[1]/div[1]")).getAttribute("innerHTML");
	}
	
}
