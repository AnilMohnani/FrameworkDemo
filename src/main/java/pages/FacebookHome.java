package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookHome {
WebDriver driver;
public FacebookHome(WebDriver driver)
{
	this.driver=driver;
}
private By username=By.id("email");
private By password=By.id("pass");
private By loginButton=By.id("loginbutton");

public WebElement getUsername()
{
	return driver.findElement(username);
}
public WebElement getPassword()
{
	return driver.findElement(password);
}
public WebElement getLoginbutton()
{
	return driver.findElement(loginButton);
}

}
