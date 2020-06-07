package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MessengerPage {
WebDriver driver;
public MessengerPage(WebDriver driver)
{
	this.driver=driver;
}
private By messengerValidator=By.cssSelector("h1._6-xo");
public WebElement getMessengerValidator()
{
	return driver.findElement(messengerValidator);
}


}
