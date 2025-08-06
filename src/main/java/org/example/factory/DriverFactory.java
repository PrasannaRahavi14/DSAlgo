package org.example.factory;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

	



	   public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	   WebDriver driver;
	    public WebDriver init_driver (String browser)
	    {

	        if(browser.equalsIgnoreCase("chrome"))
	        {
	            WebDriverManager.chromedriver().setup();
	            tlDriver.set(new ChromeDriver());
	        }

	        else if (browser.equalsIgnoreCase("edge"))
	        {
	            WebDriverManager.edgedriver().setup();
	            tlDriver.set(new EdgeDriver());
	        }
	        else
	        {
	            System.out.println("please pass the correct browser values" + browser);
	        }

	        getDriver().manage().deleteAllCookies();
	        getDriver().manage().window().maximize();
	        return getDriver();
	    }

	    public static WebDriver getDriver()
	    {
	        return tlDriver.get();
	    }
}

