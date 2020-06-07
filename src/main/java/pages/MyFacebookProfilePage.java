package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyFacebookProfilePage {

	WebDriver driver;
	public MyFacebookProfilePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By myProfileLinkValidator=By.cssSelector("[class='_42ft _4jy0 _2yfv _4jy4 _517h _9c6']");
	
	public WebElement getmyProfileLinkValidator() {
		return driver.findElement(myProfileLinkValidator);
	}
}
