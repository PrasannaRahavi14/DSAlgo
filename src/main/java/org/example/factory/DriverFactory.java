package org.example.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {

   public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private static ThreadLocal<String> tlBrowser = new ThreadLocal<>();

   WebDriver driver;
    public WebDriver init_driver (String browser)
    {
        setBrowser(browser);

        if(browser.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        }

        else if (browser.equals("edge"))
        {
            WebDriverManager.edgedriver().setup();
            tlDriver.set(new EdgeDriver());
        }
        else if (browser.equals("firefox"))
        {
        	WebDriverManager.firefoxdriver().setup();
        	tlDriver.set(new FirefoxDriver());
        }
        else
        {
            throw new IllegalArgumentException("Please pass the correct browser value: " + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static void setBrowser(String browser) {
        tlBrowser.set(browser);
    }

    public static String getBrowser() {
        return tlBrowser.get();
    }
    public static WebDriver getDriver()
    {
        return tlDriver.get();
    }



    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
