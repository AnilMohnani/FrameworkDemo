package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
WebDriver driver;
public SearchResultsPage(WebDriver driver) {
	this.driver=driver;
	
}
private By headertext=By.cssSelector(".ListingContentHeader__h1");
//WebDriverWait wait=new WebDriverWait(driver,10);
//WebElement headertextFinal=wait.until(ExpectedConditions.visibilityOfElementLocated(headertext));

public WebElement getSearchPageHeaderText()
{
	return driver.findElement(headertext);
}
}
