package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutPage extends BasePage{

	public AboutPage(WebDriver BaseDriver) {
		super(BaseDriver);
		
	}
	
	By SauceLabAboutText= By.cssSelector("h2[class=\"title is-1\"]");
	
	
	public String GetPageText()
	{
		WaitExplicitly(20, SauceLabAboutText);
		return this.GetText(SauceLabAboutText);
	}

}
