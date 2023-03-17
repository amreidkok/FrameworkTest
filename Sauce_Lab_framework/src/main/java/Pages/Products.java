package Pages;

import org.openqa.selenium.WebDriver;

public abstract class Products extends BasePage{
	
	
	Products(WebDriver BaseDriver) {
		super(BaseDriver);
		// TODO Auto-generated constructor stub
	}

	public abstract void AddToCart();
	public abstract void RemoveFromCart();
	public abstract String GetPrice();
	}
