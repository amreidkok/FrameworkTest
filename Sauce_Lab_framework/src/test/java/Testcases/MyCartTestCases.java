package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.AboutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyCart;
import Pages.Products;
import Pages.SauceLabsBackPackProduct;

public class MyCartTestCases extends BaseTest{
	HomePage hp;
	LoginPage Lp;
	Products pr;
	MyCart mc;
	@Test
	public void ChooseProductAndClickContinueShopping()
	{
		logger = extent.createTest("ChooseProductAndClickContinueShopping");
		hp=new HomePage(driv);
		Lp=new LoginPage(driv);
		Lp.Naviagte("https://www.saucedemo.com/");
		Lp.InsertUserName("standard_user").InsertPassWord("secret_sauce");
		hp=Lp.ClickLogin();
		pr=new SauceLabsBackPackProduct(driv);
		pr.AddToCart();
		mc=hp.ClickOnMyCart();
		Assert.assertEquals(mc.YourCartText(), "YOUR CART");
		mc.ClickOnContinueShopping();
		Assert.assertEquals(hp.ProductText(), "PRODUCTS");
		
	}
	
	@Test
	public void ChooseProductandremoveit()
	{
		logger = extent.createTest("ChooseProductandremoveit");
		hp=new HomePage(driv);
		Lp=new LoginPage(driv);
		Lp.Naviagte("https://www.saucedemo.com/");
		Lp.InsertUserName("standard_user").InsertPassWord("secret_sauce");
		hp=Lp.ClickLogin();
		pr=new SauceLabsBackPackProduct(driv);
		pr.AddToCart();
		mc=hp.ClickOnMyCart();
		Assert.assertEquals(mc.YourCartText(), "YOUR CART");
		mc.ClickOnRemoveBtn();
		Assert.assertEquals(hp.ShoppingCartIsEmpty(),"0");
		mc.ClickOnContinueShopping();
		Assert.assertEquals(hp.ProductText(), "PRODUCTS");
		
	}
	@Test
	public void ValidateOnAllProducts()
	{
		logger = extent.createTest("ValidateOnAllProducts");
		hp=new HomePage(driv);
		Lp=new LoginPage(driv);
		Lp.Naviagte("https://www.saucedemo.com/");
		Lp.InsertUserName("standard_user").InsertPassWord("secret_sauce");
		hp=Lp.ClickLogin();
		hp.HomePageSelectDrop("Price (high to low)");
		Assert.assertEquals(hp.GetProductNameByindex(0),"Sauce Labs Fleece Jacket");
		Assert.assertEquals(hp.GetProductNameByindex(1),"Sauce Labs Backpack");
		Assert.assertEquals(hp.GetProductNameByindex(2),"Sauce Labs Bolt T-Shirt");
		Assert.assertEquals(hp.GetProductNameByindex(3),"Test.allTheThings() T-Shirt (Red)");
		Assert.assertEquals(hp.GetProductNameByindex(4),"Sauce Labs Bike Light");
		Assert.assertEquals(hp.GetProductNameByindex(5),"Sauce Labs Onesie");
	}
	
	@Test
	public void ValidateEndToEndWorkflow()
	{
		logger = extent.createTest("ValidateEndToEndWorkflow");
		hp=new HomePage(driv);
		Lp=new LoginPage(driv);
		Lp.Naviagte("https://www.saucedemo.com/");
		Lp.InsertUserName("standard_user").InsertPassWord("secret_sauce");
		hp=Lp.ClickLogin();
		pr=new SauceLabsBackPackProduct(driv);
		pr.AddToCart();
		mc=hp.ClickOnMyCart();
		Assert.assertEquals(mc.YourCartText(), "YOUR CART");
		mc.ClickOnCheckOut();
		mc.InsertCheckoutInformation("amr","eid","02");
		mc.ContinueCheckout();
		mc.ClickOnFinish();
		Assert.assertEquals(mc.CheckoutCompletion(), "CHECKOUT: COMPLETE!");
			}
	
	@Test
	public void ValidateCheckOutValidations()
	{
		logger = extent.createTest("ValidateCheckOutValidations");
		hp=new HomePage(driv);
		Lp=new LoginPage(driv);
		Lp.Naviagte("https://www.saucedemo.com/");
		Lp.InsertUserName("standard_user").InsertPassWord("secret_sauce");
		hp=Lp.ClickLogin();
		pr=new SauceLabsBackPackProduct(driv);
		pr.AddToCart();
		mc=hp.ClickOnMyCart();
		Assert.assertEquals(mc.YourCartText(), "YOUR CART");
		mc.ClickOnCheckOut();
		mc.ContinueCheckout();
		Assert.assertEquals(mc.CheckoutvalidationError(), "Error: First Name is required");
				
		
	}
}
