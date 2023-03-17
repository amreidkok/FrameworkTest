package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceLabsBackPackProduct extends Products {

	public SauceLabsBackPackProduct(WebDriver BaseDriver) 
	{
		super(BaseDriver);
		// TODO Auto-generated constructor stub
	}
	By Addproductlocator=By.name(ProductCartNameslocator.valueOf("SauceLabsBackPack").toString());
	By Removeproductlocator=By.name(ProductCartNameslocator.valueOf("SauceLabsBackPackRemove").toString());
	By Price=By.xpath("//button[contains(@name,\"sauce-labs-backpack\")]/preceding-sibling::*");
	//By RemoveFromCart=By.name
	
	@Override
	public void AddToCart() 
	{
		WaitExplicitly(10,Addproductlocator);
				
		Click(Addproductlocator);
		
	
	}

	@Override
	public void RemoveFromCart() {
		WaitExplicitly(10,Removeproductlocator);
		Click(Removeproductlocator);
		
	}

	@Override
	public String GetPrice()
	{
		WaitExplicitly(10, Price);
		String text=GetText(Price);
		return text;
		
	}

}
