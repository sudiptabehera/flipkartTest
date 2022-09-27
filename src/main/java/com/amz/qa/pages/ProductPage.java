package com.amz.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amz.qa.base.TestBase;
public class ProductPage extends TestBase{
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//div/div[1]/h1/span")
	WebElement productDetail;
	

	@FindBy(xpath="//div/span/span/span[text()='Share']")
	WebElement shareBtn ;

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public AddToCartPage addToCartnow()  {
		
		addToCartBtn.click();
		
		return new AddToCartPage();
		
	}
	
	public String getProductDetails() {
		return productDetail.getAttribute("innerHTML");
	}
	public String shareProduct() throws InterruptedException {
		shareBtn.click();
		driver.findElement(By.xpath("//div/span[text()='Twitter']")).click();
		return null;
	}

	public void clickAddToCart() {
		// TODO Auto-generated method stub
		
	}
	
	
}
