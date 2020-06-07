package testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.SystemUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchResultsPage;
import resources.Base;

public class ValidateSearch extends Base {
WebDriver driver;
private static Logger logger=LogManager.getLogger(ValidateLoginTest.class);

	@BeforeMethod
	public void setup() throws IOException
	{

		driver=driverInitialisation();
		logger.info("Driver Initialised testSearch");

	}
	
	@Test(dataProvider="getData")
	public void testSearch(String m1,String st,String end) throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		HomePage hp=new HomePage(driver);
		hp.getSearchText().sendKeys("Mum");
		Thread.sleep(2000);
		hp.getSearchText().sendKeys(Keys.ARROW_DOWN);
		hp.getSearchText().sendKeys(Keys.ENTER);
		hp.getDate().click();
		hp.getMonth().click();
		Select select=new Select(hp.getMonth());
		select.selectByValue(m1);

		ArrayList<WebElement> l=hp.getalldates();
		System.out.println(l.size());
		for(int i=0;i<l.size();i++)
		{
			WebElement wb=l.get(i);
			if(wb.getText().equalsIgnoreCase(st))
			{
				wb.click();
				break;
			}
		
		}
		l=hp.getalldates();
		System.out.println(l.size());
		for(int i=0;i<l.size();i++)
		{
			WebElement wb=l.get(i);
			if(wb.getText().equalsIgnoreCase(end))
			{
				wb.click();
				break;
			}
		
		}
		hp.getQuantity().click();
		hp.getAdd().click();
		hp.getSearchButton().click();
		SearchResultsPage srp=new SearchResultsPage(driver);
		Assert.assertTrue(srp.getSearchPageHeaderText().isDisplayed());
		
		
		
	}
	
	@DataProvider
	public Object[][] getData() 
	{
		return new Object[][] {{"6","12","15"},{"4","10","17"} };
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		logger.info("Driver closed for testSearch");

	}
}
