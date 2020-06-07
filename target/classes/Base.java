package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public Properties prop;
	
	ExcelReader excel;
	
	public WebDriver driverInitialisation() throws IOException
	{	prop=new Properties();
	System.out.println("hey");
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\global.properties");
		//FileInputStream fis=new FileInputStream("C:\\Users\\AnilY\\eclipse-workspace\\FrameworkDemo\\src\\main\\java\\resources\\global.properties");

		prop.load(fis);
	//
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		
	//	String browserName=System.getProperty("browser");
	if(browserName.contains("chrome"))
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");		
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\Browser drivers\\chromedriver.exe");
		//if(browserName.contains("headless"))
		//{
		//driver=new ChromeDriver(options);
	//}  else
		
			driver=new ChromeDriver(options);
		}

		
	else 	if(browserName.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();

	}
	else if(browserName.equalsIgnoreCase("IE"))
	{
		WebDriverManager.iedriver().setup();
	driver=new InternetExplorerDriver();
	}
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	
	return driver;
	
}
	public String getScreenshot(String result) throws IOException
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path="C:\\Users\\AnilY\\eclipse-workspace\\FrameworkDemo\\screenshotsFailure\\"+result+"screenshot.png";
		FileUtils.copyFile(source, new File(path));
		return path;
	}
	
	
}