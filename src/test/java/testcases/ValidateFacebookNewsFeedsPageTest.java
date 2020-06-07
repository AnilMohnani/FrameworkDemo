package testcases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.FacebookNewsFeedPage;
import pages.MessengerPage;
import pages.MyFacebookProfilePage;
import resources.Utility;

public class ValidateFacebookNewsFeedsPageTest {
	WebDriver driver;

	@BeforeMethod
	public void setup() throws IOException {
		Utility util = new Utility();
		driver = util.loginMethod();
	}

	@Test(priority=3)
	public void profileNavigationLink() {

		FacebookNewsFeedPage fnfp = new FacebookNewsFeedPage(driver);

		fnfp.getLoginValidator().click();
		/*
		 * Set<String> s=driver.getWindowHandles(); Iterator<String> itr=s.iterator();
		 * itr.next(); String desired=itr.next(); driver.switchTo().window(desired);
		 */

		MyFacebookProfilePage mfpp = new MyFacebookProfilePage(driver);
		System.out.println(mfpp.getmyProfileLinkValidator().getText());
		Assert.assertEquals(mfpp.getmyProfileLinkValidator().getText(), "Edit Profile");
	}

	@Test(priority=2)
	public void testMessengerLink() {
		FacebookNewsFeedPage fnfp = new FacebookNewsFeedPage(driver);
		fnfp.getMessengerNavigation().click();
		MessengerPage mp = new MessengerPage(driver);
		Assert.assertTrue(mp.getMessengerValidator().isDisplayed());

	}

	@Test(priority=1,dataProvider="getPostData")
	public void postCreationValidation(String text)
	{
		FacebookNewsFeedPage fnfp = new FacebookNewsFeedPage(driver);
		fnfp.postFocusClick().click();
		fnfp.writePost().sendKeys(text);
		fnfp.clickPostButton().click();
		Assert.assertEquals(fnfp.textPosted().getText(),text);
	}
	
	@DataProvider
	public String[][] getPostData() {
		return new String[][] {{"india"}};
	}
	@AfterMethod
	public void tear() {
		driver.close();

	}
}
