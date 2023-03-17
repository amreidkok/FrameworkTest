package Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Utilities.JsonDataHelper;


public class LoginTestCases extends BaseTest{
	LoginPage lp;
	HomePage hp;
	@Test(dataProvider="InvalidLoginTestData")
	public void InvalidLoginTestCase(String data)
	{
		String user[] = data.split(",");
		logger = extent.createTest("InvalidLoginTestCase");
		lp=new LoginPage(driv);
		lp.Naviagte("https://www.saucedemo.com/");
		lp.InsertUserName(user[0]).InsertPassWord(user[1]);
		hp=lp.ClickLogin();
		Assert.assertEquals(hp.GetInvalidCredentialsText(),"Epic sadface: Username and password do not match any user in this service");
	}  
	
	@Test (dataProvider="LoginTestData")
	public void ValidLoginTestCase(String data) {
		String user[] = data.split(",");
		logger = extent.createTest("ValidLoginTestCase");
		lp=new LoginPage(driv);
		lp.Naviagte("https://www.saucedemo.com/");
		lp.InsertUserName(user[0]).InsertPassWord(user[1]);
		hp=lp.ClickLogin();
		Assert.assertEquals(hp.ProductText(), "Products");

	} 
	@Test(dataProvider="LoginTestData")
	public void LoginThenLogOutTestCase(String data) {
		String user[] = data.split(",");
		logger = extent.createTest("LoginThenLogOutTestCase");
		lp=new LoginPage(driv);
		lp.Naviagte("https://www.saucedemo.com/");
		lp.InsertUserName(user[0]).InsertPassWord(user[1]);
		hp=lp.ClickLogin();
		Assert.assertEquals(hp.ProductText(), "Products");
	    lp=hp.ClickLogout();
		Assert.assertEquals(lp.UsersLoginPageText(), "Accepted usernames are:");
		
	} 
	
	@DataProvider
	public Object[] LoginTestData() throws  IOException, org.json.simple.parser.ParseException
	{
		return JsonDataHelper.readjson("TestData/Login.json","ValidUser");
		
		
	}
	
	@DataProvider
	public String[] InvalidLoginTestData() throws  IOException, org.json.simple.parser.ParseException
	{
		return JsonDataHelper.readjson("TestData/Login.json","InvalidUser");
		
		
	}

}
