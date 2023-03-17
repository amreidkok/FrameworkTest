package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyCart extends BasePage {

	public MyCart(WebDriver BaseDriver) {
		super(BaseDriver);
		// TODO Auto-generated constructor stub
	}


	By YourCartElement=By.xpath("//div[@class=\"header_secondary_container\"]//descendant::*");
	By ContinueShoppingBtn=By.id("continue-shopping");
    By CartRemoveBtn=By.xpath("//button[text()=\"Remove\"]");
    By CheckOutBtn=By.id("checkout");
    By CheckOutFirstName=By.id("first-name");
    By CheckOutLastName=By.id("last-name");
    By CheckOutZipCode=By.id("postal-code");
    By ContinueBtn=By.id("continue");
    By FinishBtn=By.id("finish");
    By ordercompleted=By.xpath("//div[@class=\"header_secondary_container\"]//descendant::*");
    By CheckoutValidationError=By.xpath("//h3[@data-test=\"error\"]");
    
	public String YourCartText()
	{
		WaitExplicitly(10, YourCartElement);
		String txt=GetText(YourCartElement);
		return txt;
	}

	public void ClickOnContinueShopping()
	{
		WaitExplicitly(10, ContinueShoppingBtn);
		Click(ContinueShoppingBtn);
	}
	
	public void ClickOnRemoveBtn()
	{
		WaitExplicitly(10, CartRemoveBtn);
		Click(CartRemoveBtn);
	
	}
	
	public void ClickOnCheckOut()
	{
		WaitExplicitly(10,CheckOutBtn);
		Click(CheckOutBtn);
	
	}
	
	public void InsertCheckoutInformation(String firstname,String lastname,String zipcode)
	{
		WaitExplicitly(10,CheckOutFirstName);
		WaitExplicitly(10,CheckOutLastName);
		WaitExplicitly(10,CheckOutZipCode);
		InsertText(CheckOutFirstName, firstname);
		InsertText(CheckOutLastName, lastname);
		InsertText(CheckOutZipCode, zipcode);
	}
	public void ContinueCheckout()
	{
		WaitExplicitly(10,ContinueBtn);
		Click(ContinueBtn);
		}
	
	public void ClickOnFinish()
	{
		WaitExplicitly(10,FinishBtn);
		Click(FinishBtn);
		}
	
	public String CheckoutCompletion()
	{
		WaitExplicitly(10,ordercompleted);
		String txt=GetText(ordercompleted);
		return txt;
		
	}
	
	public String CheckoutvalidationError()
	{
		WaitExplicitly(20,CheckoutValidationError);
		String txt=GetText(CheckoutValidationError);
		return txt;	
	}
	
}
