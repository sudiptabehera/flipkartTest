package com.amz.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amz.qa.base.TestBase;
public class HomePage extends TestBase{
	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")
	WebElement searchBox;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button")
	WebElement searchButton;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div[1]/div")
	WebElement accountSignIn;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")
	WebElement accountUserName;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[6]/div/div/a/div")
	WebElement cartValue;
	
	@FindBy(xpath="(//div/a/div[1]/div[3])[1]")
	WebElement wishListBtn;
	
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div[2]/div[2]/div/div/div/div[2]")
	WebElement accountSignUp;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div[2]/div[2]/div/ul/li[5]/a")
	WebElement wishlistPageNav;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
	WebElement accountLoginEmailField;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")
	WebElement accountLoginPwdField;
	
	@FindBy(xpath="/html/body/div[2]/div/div/button")
	WebElement popUpCloser;
	
	@FindBy(xpath="//button/span[text()=\"Login\"]")
	WebElement loginBtn;

	@FindBy(xpath="/html/body/div[2]/div/div/button")
	WebElement PopUpCloser ;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div[2]/div[2]/div/ul/li[1]/a")
	WebElement AccountPgLnk ;
	
	@FindBy(xpath="//*[@id=\"high-price\"]")
	WebElement highPriceFilter ;
	
	@FindBy(xpath="//*[@id=\"low-price\"]")
	WebElement lowPriceFilter ;
	
	
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public String verifyUserName() {
		return accountUserName.getAttribute("innerHTML");
	}
	
	public void loginToSite(String phn,String pwd) throws InterruptedException {
//		popUpCloser.click();
//		accountSignIn.click();
//		Thread.sleep(2000);
		accountLoginEmailField.sendKeys(phn);
		accountLoginPwdField.sendKeys(pwd);
		loginBtn.click();
		
		return;
	}
	
	public AccountPage clickOnActLink() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(accountSignIn).perform();
		Thread.sleep(2000);
		AccountPgLnk.click();
		return new AccountPage();
	}

	public ProductPage searchItem(String item,int i) throws InterruptedException {
		searchBox.sendKeys(item+"\n");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[text()=\"Availability\"]")).click();
//		driver.findElement(By.xpath("//div[text()=\"Exclude Out of Stock\"]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//a/div[2]/div[1]/div[1])["+i+"]")).click();
		return new ProductPage();
	}
	public void clearSearchBox() {
		searchBox.clear();
	}
	
	public void closePopup() throws InterruptedException {
		popUpCloser.click();
		return;
	}
	
	public String getCartValue() throws InterruptedException {
		
		return cartValue.getAttribute("innerHTML");
//		return "0";
	}


	public String categorySelect(int i,String itemCategory,String item) throws InterruptedException {
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[4]/a/div[1]/div")).click();
		Thread.sleep(4000);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/span[1]]"))).perform();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()=\"Samsung\"]")).click();
//		Thread.sleep(4000);
//		
		return driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/h1")).getAttribute("innerHTML");
	}
	

	public String comparePiler(String item) throws InterruptedException {
		
		searchBox.sendKeys(item+"\n");
		Thread.sleep(3000);
		String name= driver.findElement(By.xpath("(//a/div[2]/div/div)[1]")).getAttribute("innerHTML");
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div[2]/div/div/div/a/div[1]/div[2]/div")).click();
		
		
		return name;
	}
	
	public void compareClick() throws InterruptedException {
		driver.findElement(By.xpath("//div/div[4]/div/a")).click();
		return;
	}
	
	public String compareChecker(int i) throws InterruptedException {
		
		String itemC=driver.findElement(By.xpath("//*[@id=\"fk-compare-page\"]/div/div/div/div[1]/div[2]/div/div[1]/div[1]/div["+i+"]/a")).getAttribute("innerHTML");
		
		return itemC;
		}
	public String wishListClicker(String item) throws InterruptedException {
		searchBox.sendKeys(item+"\n");
		Thread.sleep(2000);
		wishListBtn.click();
		return driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")).getAttribute("innerHTML");
	}
	public WishlistPage wishListNavigator() throws InterruptedException {
		
		Actions action = new Actions(driver);
		action.moveToElement(accountSignIn).perform();
		wishlistPageNav.click();
		
		return new WishlistPage();
		}

}
