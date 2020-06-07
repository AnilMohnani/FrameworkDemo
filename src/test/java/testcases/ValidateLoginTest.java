package testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import resources.Base;

public class ValidateLoginTest extends Base{

	WebDriver driver;
	private static Logger logger=LogManager.getLogger(ValidateLoginTest.class);
	@BeforeMethod
	public void setup() throws IOException
	{
		driver=driverInitialisation();  
		logger.info("Driver Initialised for testLoginLink");
	}
	@Test
	public void testLoginLink() throws IOException
	{
		driver.get(prop.getProperty("url"));
		logger.debug("Browser Launched");
		HomePage hp=new HomePage(driver);
		hp.getLoginNavigation().click();
		LoginPage lp=new LoginPage(driver);
		Assert.assertEquals(lp.getLoginText().getText(),"Please enter your phone number to continue");
		logger.debug("testLoginLink Test Case Validated");

	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		logger.info("Driver closed for testLoginLink");

		

	}
}
