package org.example.hooks;

import io.cucumber.java.After;
import org.example.factory.DriverFactory;
import org.example.utilities.ConfigReader;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Hooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;
    @Before (order = 0)
    public void getProperty()
    {
        configReader=new ConfigReader();
        prop = configReader.init_prop();
    }
    @Before (order = 1)
    public void launchBrowser()
    {
       String browserName = prop.getProperty("browser");
        System.out.println("Browser from config: " + browserName);
        driverFactory = new DriverFactory();
       driver = driverFactory.init_driver(browserName);
    }

    @After(order = 0)
    public  void quitBrowser()
    {
        driver.quit();
    }

}
