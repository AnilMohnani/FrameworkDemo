package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.FacebookHome;
import pages.FacebookNewsFeedPage;
import resources.Base;
import resources.ExcelReader;

public class LoginFunctionalityTest extends Base{
WebDriver driver;
ExcelReader excel;
	@BeforeMethod
	public void setup() throws IOException
	{
		System.out.println("initailosed driver");
		driver=driverInitialisation();  
		driver.get(prop.getProperty("faceurl"));

	}
	
	@Test(dataProvider="getLoginData")
	public void loginTest(String user,String pass)
	{
		FacebookHome fh=new FacebookHome(driver);
		FacebookNewsFeedPage fnfp=new FacebookNewsFeedPage(driver);
		fh.getUsername().sendKeys(user);
		fh.getPassword().sendKeys(pass);
		fh.getLoginbutton().click();
		Assert.assertEquals(fnfp.getLoginValidator().getText(),"Anil");
	}
	@DataProvider
	public Object[][] getLoginData() throws Exception
	{
		excel=new ExcelReader();
		Object obj[][]=ExcelReader.dataReader("loginSheet");
		//System.out.println(obj[0][1]);
		return obj;
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}
