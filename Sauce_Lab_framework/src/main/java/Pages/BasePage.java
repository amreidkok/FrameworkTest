package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	
	protected WebDriver driver;
	
	BasePage(WebDriver BaseDriver)
	{
		driver=BaseDriver;
	}
	
	public void Click(By ElementLocator)
	{
		driver.findElement(ElementLocator).click();
	}
	
	public void ClearTextBox(By ElementLocator)
	{
		driver.findElement(ElementLocator).clear();
	}
	
	public void InsertText(By ElementLocator,String Text)
	{
		ClearTextBox(ElementLocator);
		driver.findElement(ElementLocator).sendKeys(Text);
	}
	
	public WebElement FindElement(By ElementLocator)
	{
		WebElement we=driver.findElement(ElementLocator);
		return we;
	}
	
	
	public void WaitExplicitly(int time,By element)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(FindElement(element)));
		
	}
	
	
	public String GetText(By element)
	{
		WaitExplicitly(20, element);
		String text=FindElement(element).getText();
		return text;
		
	}
	public void CloseBrowser()
	{
		driver.close();
	}
	
	public void Naviagte(String Url)
	{
		driver.get(Url);
	}
	
	public void NaviagteBack(String Url)
	{
		driver.navigate().back();
	}
public void SelectDropDownMenu(By element,String selecttext)
{
	Select drop=new Select(FindElement(element));
	drop.selectByVisibleText(selecttext);
	}

public List<WebElement> FindElements(By element)
{
	List<WebElement> mylist = driver.findElements(element);	
	return mylist;
}

public boolean ElementExist(By element)
{
	
	boolean flag=true;
	if (driver.findElements(element).isEmpty())
	{
		flag=false;
	}
	return flag;
}
}
