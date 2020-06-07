package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookNewsFeedPage {

	WebDriver driver;
	public FacebookNewsFeedPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	private By validateText=By.cssSelector("._1vp5");
	private By messengerLink=By.xpath("//a[@title='Messenger']");
	private By postEditor=By.cssSelector("[role='textbox']");
	private By postButton=By.cssSelector("button[class='_1mf7 _4r1q _4jy0 _4jy3 _4jy1 _51sy selected _42ft']");
	private By postFocus=By.cssSelector("[aria-label='Create a post']");
	private By textPosted=By.xpath("//p[contains(text(),'india')]");
	
	public WebElement textPosted()
	{
		return driver.findElement(textPosted);
	}
	public WebElement postFocusClick()
	{
		return driver.findElement(postFocus);
	}
	public WebElement getLoginValidator()
	{
		return driver.findElement(validateText);
		
	}
	public WebElement clickPostButton()
	{
		return driver.findElement(postButton);
		
	}
	public WebElement getMessengerNavigation()
	{
		return driver.findElement(messengerLink);
		
	}
	
	public WebElement writePost()
	{
		return driver.findElement(postEditor);
		
	}
	
}
