package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	private By loginText=By.cssSelector(".loginCard__phoneNumber");
	public WebElement getLoginText()
	{
		return driver.findElement(loginText);
	}
}
