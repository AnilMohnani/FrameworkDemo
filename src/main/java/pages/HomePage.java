package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	private By loginNavigation = By.cssSelector("div.sideMenuAuthButton__text");
	private By search=By.id("autoComplete__home");
	private By datePicker=By.cssSelector(".datePickerDesktop__checkInOutText");
	private By add=By.cssSelector(".guestRoomPickerPopUp__plus");
	private By editQuantity=By.cssSelector("div[class='oyo-cell oyo-cell--12-col oyo-cell--8-col-tablet oyo-cell--4-col-phone d-text16 is-fontBold u-textEllipsis guestRoomPicker__guestRoomCount']");
	private By searchButton=By.cssSelector("button.u-textCenter.searchButton.searchButton--home");
	private By dates=By.xpath("(//table)[1]//td[contains(@class,'DateRangePicker__Date')]//span[@class='DateRangePicker__DateLabel']");
	private By monthDropdown=By.cssSelector(".DateRangePicker__MonthHeaderSelect");
	
	
	public WebElement getLoginNavigation() {
		return driver.findElement(loginNavigation);

	}
	public WebElement getMonth() {
		return driver.findElement(monthDropdown);

	}
	public WebElement getSearchText() {
		return driver.findElement(search);

	}
	public WebElement getDate() {
		return driver.findElement(datePicker);

	}
	public WebElement getQuantity() {
		return driver.findElement(editQuantity);

	}
	public WebElement getAdd() {
		return driver.findElement(add);

	}
	public WebElement getSearchButton() {
		return driver.findElement(searchButton);

	}
	
	
	public ArrayList<WebElement> getalldates() {
		return (ArrayList<WebElement>) driver.findElements(dates);

	}
}
