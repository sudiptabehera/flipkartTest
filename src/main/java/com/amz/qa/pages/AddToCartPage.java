package com.amz.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amz.qa.base.TestBase;

public class AddToCartPage extends TestBase{
	@FindBy(xpath="//*[@id=\"container\"]/div/div[2]/div/div[1]/div[1]/div/div[3]/div/div[2]/div/div[2]")
	WebElement cartRemoveBtn ;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[2]/div/div[1]/div[1]/div/div[3]/div/div[2]/div[2]/div[1]")
	WebElement svForLtrBtn ;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div/div[3]/div/div[2]")
	WebElement cartRemoveCfrmBtn ;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")
	WebElement searchBox;
	
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String checkCart()  {
		String item;
		item=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[1]/div[1]/div/div[3]/div/div[1]/div[1]/div[1]/a")).getAttribute("innerHTML");
		return item;
		
	}
	public void cartRemove()  {
		cartRemoveBtn.click();
		cartRemoveCfrmBtn.click();
		
		return;
		
	}

	public void clickAddToCart() {
		// TODO Auto-generated method stub
		
	}

	public String checkSaveForLAter() throws InterruptedException {
		svForLtrBtn.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight+40)");
		Thread.sleep(1500);
		String item;
		item=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/a")).getAttribute("innerHTML");
		return item;
	}
	public ProductPage searchItem(String item,int i) throws InterruptedException {
		searchBox.sendKeys(item+"\n");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div["+(i+1)+"]/div/div/div/a/div[1]/div[1]/div/div/img")).click();
		return new ProductPage();
	}

//	/html/body/div[1]/div/div/div[2]/main/div/div/div/div/div/div[4]/div/section/div/div/div[1]/div/div/div/article/div/div/div/div[2]/div[2]/div[2]/div[1]/div/span
	//*[@id="react-root"]/div/div/div[2]/main/div/div/div[3]/div/div/div[1]/div/div/div/div/div[2]/div[1]/div/div/div/div/div/div[2]/div/div/div/div/label/div[1]/div/div/div/div/div/div/div/div/div/div/span[3]/span
	
}
