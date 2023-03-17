package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage
{
	public LoginPage(WebDriver BaseDriver) {
		super(BaseDriver);
		// TODO Auto-generated constructor stub
	}

	By UserNameTxtBox=By.id("user-name");
	By PasswrdTxtBox=By.id("password");
	By LoginBtn=By.id("login-button");
	By UserLoginPage=By.xpath("//h4[text()=\"Accepted usernames are:\"]");


	public LoginPage InsertUserName(String Userdata)
	{
		WaitExplicitly(20,UserNameTxtBox);
		FindElement(UserNameTxtBox);
		InsertText(UserNameTxtBox, Userdata);
		return this;
	}

	public LoginPage InsertPassWord(String Passdata)
	{
		WaitExplicitly(20,PasswrdTxtBox);
		FindElement(PasswrdTxtBox);
		InsertText(PasswrdTxtBox, Passdata);
		return this;
	}
	public HomePage ClickLogin()

	{
		WaitExplicitly(20,LoginBtn);
		Click(LoginBtn);
		return new HomePage(driver);
	}
	
	public String UsersLoginPageText()
	{
		WaitExplicitly(20,UserLoginPage);
		String expected=FindElement(UserLoginPage).getText();
		return expected;
	}
}
