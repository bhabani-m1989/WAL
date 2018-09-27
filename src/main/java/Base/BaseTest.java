package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import Utils.Utility;



public class BaseTest {
	
	public static WebDriver driver;
	
	
	
	public WebDriver launchBrowser(String name)
	{
		String bName= name;
		if(bName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome","Users/bhabanimishra/Documents/workspace/WAL/chromedriver.exe");
			driver= new ChromeDriver();
			
		}
		
		else if(bName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("","");
			driver= new FirefoxDriver();
			
		}

		else if(bName.equalsIgnoreCase("IE"))
		{
			System.setProperty("","");
			driver= new InternetExplorerDriver();
		}

		else if(bName.equalsIgnoreCase("Safari"))
		{
			System.setProperty("","");
			driver= new SafariDriver();
		}
		
		return driver;
		
		
	}
	
	public void init()
	{
		WebDriver driver= launchBrowser(Utility.browser_Name);
		driver.manage().window().fullscreen();
		driver.manage().timeouts().setScriptTimeout(Utility.script_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.implicit_WaitTime, TimeUnit.SECONDS);
		
		driver.get(Utility.url);
	}
	
/*	public static void main(String[] args)
	{
		BaseTest t = new BaseTest();
		t.init();
	} */

}
