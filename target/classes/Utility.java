package resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pages.FacebookHome;

public class Utility extends Base{
	WebDriver driver;

	
	public WebDriver loginMethod() throws IOException {
		driver=driverInitialisation();
		driver.get(prop.getProperty("faceurl"));
		FacebookHome fh=new FacebookHome(driver);
		fh.getUsername().sendKeys(prop.getProperty("username"));
		fh.getPassword().sendKeys(prop.getProperty("password"));
		fh.getLoginbutton().click();	
		return driver;
	}
}
