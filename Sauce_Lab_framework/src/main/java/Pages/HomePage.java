package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
	public HomePage(WebDriver BaseDriver) {
		super(BaseDriver);
	}

	By OpenMenuBtn=By.id("react-burger-menu-btn");

	By LogOutBtn=By.cssSelector("#logout_sidebar_link");

	By ProductsIcon=By.xpath("//div[@class=\"header_secondary_container\" ]//span[text()='Products']");

	By About_btn=By.id("about_sidebar_link");

	By DropDownMenu=By.cssSelector("select[class=\"product_sort_container\"]");

	By AllProducts=By.cssSelector("div[class=\"inventory_item_name\"]");

	By AddToCartBtn=By.xpath("//button[@class=\"btn btn_primary btn_small btn_inventory\" and @id=\"add-to-cart-sauce-labs-backpack\"");

	By ProductsCount=By.xpath("//span[@class=\"shopping_cart_badge\"]");
	
	By InvalidLoginCredentials=By.xpath("//h3[@data-test=\"error\"]");
	
	public String ProductText()
	{
		WaitExplicitly(20,ProductsIcon);
		String expected=FindElement(ProductsIcon).getText();
		return expected;
	}

	public LoginPage ClickLogout()
	{
		WaitExplicitly(20,OpenMenuBtn);
		Click(OpenMenuBtn);
		WaitExplicitly(30,LogOutBtn);
		Click(LogOutBtn);
		return new LoginPage(driver);

	}

	public AboutPage ClickAboutBtn()
	{
		WaitExplicitly(20,OpenMenuBtn);
		Click(OpenMenuBtn);
		WaitExplicitly(20,About_btn);
		Click(About_btn);
		return new AboutPage(driver);
	}

	public void HomePageSelectDrop(String dropValue)

	{
		WaitExplicitly(20,DropDownMenu);
		Click(DropDownMenu);
		SelectDropDownMenu(DropDownMenu, dropValue);
	}

	public String GetProductNameByindex(int ProductNo)
	{
		WaitExplicitly(20,AllProducts);
		WebElement elementindex=(WebElement) FindElements(AllProducts).get(ProductNo);
		String value=elementindex.getText();
		return value;
	}
	
	public String GetCartCount()
	{
		WaitExplicitly(20,ProductsCount);
		String value=GetText(ProductsCount);
		return value;
		
	}
	public MyCart ClickOnMyCart()
	{
		WaitExplicitly(20,ProductsCount);
		Click(ProductsCount);
		return new MyCart(driver);
	}

//	public void ClickAddToCartForSpecificProduct(String val)
//	{
//		By productlocator;
//
//		switch(val)
//		{
//		case ("SauceLabsBackPack"):
//			WaitExplicitly(10, By.name(ProductCartNameslocator.valueOf(val).toString()));
//		productlocator=By.name(ProductCartNameslocator.valueOf(val).toString());
//		Click(productlocator);
//		break;
//		case ("SauceLabsBikeLight"):
//			WaitExplicitly(10, By.name(ProductCartNameslocator.valueOf(val).toString()));
//		productlocator=By.name(ProductCartNameslocator.valueOf(val).toString());
//		Click(productlocator);
//		break;
//		case ("SauceLabsFleeceJacket"):
//			WaitExplicitly(10, By.name(ProductCartNameslocator.valueOf(val).toString()));
//		productlocator=By.name(ProductCartNameslocator.valueOf(val).toString());
//		Click(productlocator);
//		break;
//		case ("SauceLabsOnesie"):
//			WaitExplicitly(10, By.name(ProductCartNameslocator.valueOf(val).toString()));
//		productlocator=By.name(ProductCartNameslocator.valueOf(val).toString());
//		Click(productlocator);
//		break;
//		case ("TestallTheThingsTShirtRed"):
//			WaitExplicitly(10, By.name(ProductCartNameslocator.valueOf(val).toString()));
//		productlocator=By.name(ProductCartNameslocator.valueOf(val).toString());
//		Click(productlocator);
//		break;
//		case ("SauceLabsBoltTshirt"):
//			WaitExplicitly(10, By.name(ProductCartNameslocator.valueOf(val).toString()));
//		productlocator=By.name(ProductCartNameslocator.valueOf(val).toString());
//		Click(productlocator);
//		break;
//
//		}

	//}
	
	public String ShoppingCartIsEmpty()
	{
		String count=null;
		if (!ElementExist(ProductsCount))
		{
		count="0";
		}
		return count;
	}
	public String GetInvalidCredentialsText()
	{
		WaitExplicitly(20,InvalidLoginCredentials);
		String value=GetText(InvalidLoginCredentials);
		return value;
	}
}
