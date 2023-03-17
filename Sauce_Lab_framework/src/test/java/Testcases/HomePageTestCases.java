package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.AboutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyCart;
import Pages.Products;
import Pages.SauceLabsBackPackProduct;

public class HomePageTestCases extends BaseTest{
	AboutPage ap;
	HomePage hp;
	LoginPage Lp;
	Products pr;
	MyCart mc;
	@Test
	public void ValidateOnAboutPage() {
		logger = extent.createTest("ValidateOnAboutPage");
		ap=new AboutPage(driv);
		hp=new HomePage(driv);
		Lp=new LoginPage(driv);
		Lp.Naviagte("https://www.saucedemo.com/");
		Lp.InsertUserName("standard_user").InsertPassWord("secret_sauce");
		hp=Lp.ClickLogin();
		hp.ClickAboutBtn();
		Assert.assertEquals(ap.GetPageText(), "Pass or fail. The world relies on your code.");
	}
	
	@Test
	public void ValidateOnDropDownByNameAscending()
	{
		logger = extent.createTest("ValidateOnDropDownByNameAscending");
		hp=new HomePage(driv);
		Lp=new LoginPage(driv);
		Lp.Naviagte("https://www.saucedemo.com/");
		Lp.InsertUserName("standard_user").InsertPassWord("secret_sauce");
		hp=Lp.ClickLogin();
		hp.HomePageSelectDrop("Name (A to Z)");
		Assert.assertEquals(hp.GetProductNameByindex(0),"Sauce Labs Backpack");
		Assert.assertEquals(hp.GetProductNameByindex(5),"Test.allTheThings() T-Shirt (Red)");
		
	}
	
	@Test
	public void ValidateOnDropDownByNamedescending()
	{
		logger = extent.createTest("ValidateOnDropDownByNamedescending");
		hp=new HomePage(driv);
		Lp=new LoginPage(driv);
		Lp.Naviagte("https://www.saucedemo.com/");
		Lp.InsertUserName("standard_user").InsertPassWord("secret_sauce");
		hp=Lp.ClickLogin();
		hp.HomePageSelectDrop("Name (Z to A)");
		Assert.assertEquals(hp.GetProductNameByindex(0),"Test.allTheThings() T-Shirt (Red)");
		Assert.assertEquals(hp.GetProductNameByindex(5),"Sauce Labs Backpack");
		
	}
	
	@Test
	public void ValidateOnDropDownBylowprice()
	{
		logger = extent.createTest("ValidateOnDropDownBylowprice");
		hp=new HomePage(driv);
		Lp=new LoginPage(driv);
		Lp.Naviagte("https://www.saucedemo.com/");
		Lp.InsertUserName("standard_user").InsertPassWord("secret_sauce");
		hp=Lp.ClickLogin();
		hp.HomePageSelectDrop("Price (low to high)");
		Assert.assertEquals(hp.GetProductNameByindex(0),"Sauce Labs Onesie");
		Assert.assertEquals(hp.GetProductNameByindex(5),"Sauce Labs Fleece Jacket");
	
	}
	
	@Test
	public void ValidateOnDropDownByhighprice()
	{
		logger = extent.createTest("ValidateOnDropDownByhighprice");
		hp=new HomePage(driv);
		Lp=new LoginPage(driv);
		Lp.Naviagte("https://www.saucedemo.com/");
		Lp.InsertUserName("standard_user").InsertPassWord("secret_sauce");
		hp=Lp.ClickLogin();
		hp.HomePageSelectDrop("Price (high to low)");
		Assert.assertEquals(hp.GetProductNameByindex(0),"Sauce Labs Fleece Jacket");
		Assert.assertEquals(hp.GetProductNameByindex(5),"Sauce Labs Onesie");
	}
	
	@Test
	public void AddProductToCartCount()
	{
		logger = extent.createTest("AddProductToCartCount");
		hp=new HomePage(driv);
		Lp=new LoginPage(driv);
		Lp.Naviagte("https://www.saucedemo.com/");
		Lp.InsertUserName("standard_user").InsertPassWord("secret_sauce");
		hp=Lp.ClickLogin();
		hp.HomePageSelectDrop("Price (high to low)");
		pr=new SauceLabsBackPackProduct(driv);
		pr.AddToCart();
		Assert.assertEquals(hp.GetCartCount(), "1");
		
	
	}
	
	@Test
	public void AddProductToCartandRemoveItCount()
	{
		logger = extent.createTest("AddProductToCartandRemoveItCount");
		hp=new HomePage(driv);
		Lp=new LoginPage(driv);
		Lp.Naviagte("https://www.saucedemo.com/");
		Lp.InsertUserName("standard_user").InsertPassWord("secret_sauce");
		hp=Lp.ClickLogin();
		hp.HomePageSelectDrop("Price (high to low)");
		pr=new SauceLabsBackPackProduct(driv);
		pr.AddToCart();
		Assert.assertEquals(hp.GetCartCount(), "1");
		pr.RemoveFromCart();
		Assert.assertEquals(hp.ShoppingCartIsEmpty(),"0");
	
	}
	
	@Test
	public void GetPriceforDesiredProduct()
	{
		logger = extent.createTest("GetPriceforDesiredProduct");
		hp=new HomePage(driv);
		Lp=new LoginPage(driv);
		Lp.Naviagte("https://www.saucedemo.com/");
		Lp.InsertUserName("standard_user").InsertPassWord("secret_sauce");
		hp=Lp.ClickLogin();
		hp.HomePageSelectDrop("Price (high to low)");
		pr=new SauceLabsBackPackProduct(driv);
		Assert.assertEquals(pr.GetPrice(),"$29.99");
	
	}
	
	
}
