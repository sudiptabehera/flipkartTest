package com.amz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amz.qa.base.TestBase;
import com.amz.qa.pages.AccountPage;
import com.amz.qa.pages.AddToCartPage;
import com.amz.qa.pages.HomePage;
import com.amz.qa.pages.ProductPage;
import com.amz.qa.pages.WishlistPage;
import com.amz.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	HomePage homePage;
	ProductPage productPage;
	AddToCartPage addToCartPage;
	WishlistPage wishlistPage;
	TestUtil testUtil;
	
	public HomePageTest() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil=new TestUtil();
		homePage= new HomePage();
		
		productPage = new ProductPage();
		addToCartPage = new AddToCartPage();
		wishlistPage = new WishlistPage();
//		homePage.closePopup();
		homePage.loginToSite(prop.getProperty("phone"),prop.getProperty("password"));
		Thread.sleep(2500);
	}
	
	
	@Test(priority=1)
	public void searchItem() throws InterruptedException {
		
		productPage=homePage.searchItem("Dell Monitor",2);
		testUtil.switchToWindow(false);
		String itemProductPage=productPage.getProductDetails();
		System.out.println(itemProductPage);
		addToCartPage=productPage.addToCartnow();
		String itemCartPage=addToCartPage.checkCart();
		System.out.println(itemCartPage);
		
		Assert.assertTrue(itemProductPage.contains(itemCartPage));
		
	}
	@Test(priority=2)
	public void addDeleteItem() throws InterruptedException {
		
		productPage=homePage.searchItem("Fastrack Watch",2);
		testUtil.switchToWindow(false);
		String itemProductPage=productPage.getProductDetails();
		System.out.println(itemProductPage);
		addToCartPage=productPage.addToCartnow();
		addToCartPage.cartRemove();
		
	}
	
	@Test(priority=3)
	public void categoryTest() throws InterruptedException{
//		testUtil.switchToFrame();
		String resultHeader=homePage.categorySelect( 5,"Gaming","Gaming Keyboards");
		Assert.assertTrue(resultHeader.contains("Samsung"));
	}

	@Test(priority=4)
	public void saveForLaterTest() throws InterruptedException {
		
		productPage=homePage.searchItem("REALME note",1);
		testUtil.switchToWindow(false);
		String itemProductPage=productPage.getProductDetails();
		System.out.println(itemProductPage);
		addToCartPage=productPage.addToCartnow();
		String itemCartPage=addToCartPage.checkSaveForLAter();
		System.out.println(itemCartPage);
		Assert.assertTrue(itemProductPage.contains(itemCartPage));
		
	}
	@Test(priority=5)
	public void shareTest() throws InterruptedException {
		
		
		productPage=homePage.searchItem("Redmi",2);
		testUtil.switchToWindow(false);
		String itemProductPage=productPage.getProductDetails();
		System.out.println(itemProductPage);
		productPage.shareProduct();
		
		
	}
	@Test(priority=6)
	public void cartLimitTest() throws InterruptedException {
		String[] items= {"smart speaker","Home threater","Projector","iKall","Printer"};
		while(Integer.valueOf(homePage.getCartValue())<=25) {
			homePage.clearSearchBox();
			productPage=homePage.searchItem(items[(int)(Math.random()*(3-0+1)+0)],1);
			testUtil.switchToWindow(false);
			String itemProductPage=productPage.getProductDetails();
			System.out.println(itemProductPage);
			addToCartPage=productPage.addToCartnow();
			Thread.sleep(3500);
			testUtil.switchToWindow(true);
//			driver.navigate().refresh();
			Thread.sleep(2000);
			if(Integer.valueOf(homePage.getCartValue())==25)
				break;
			driver.navigate().refresh();
		}
		
//		Assert.assertTrue(itemProductPage.contains(itemCartPage));
		
	}
	@Test(priority=7)
	public void compareTest() throws InterruptedException {
		
		String[] items= {"Redmi Note","Infinix Hot"};
		
			
			String item1=homePage.comparePiler(items[0]);
			Thread.sleep(2000);
			homePage.clearSearchBox();
			String item2=homePage.comparePiler(items[1]);
			Thread.sleep(2000);
			homePage.compareClick();
			String itemC1=homePage.compareChecker(2);
			String itemC2=homePage.compareChecker(3);
			System.out.println(item1+"="+itemC1);
			System.out.println(item2+"="+itemC2);
			Assert.assertTrue(item1.contains(itemC1));
			Assert.assertTrue(item2.contains(itemC2));
		
		
//		Assert.assertTrue(itemProductPage.contains(itemCartPage));
		
	}
	@Test(priority=8)
	public void wishlistTest() throws InterruptedException {
		
		String[] items= {"Oppo","Vivo"};
		String eItem=homePage.wishListClicker("oppo");
		wishlistPage=homePage.wishListNavigator();
		String aItem=wishlistPage.verifyItemWishlist();
		System.out.println(eItem+"="+aItem);
		Assert.assertTrue(aItem.contains(eItem));
		
		}
		



	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		driver.quit();
	}
}


