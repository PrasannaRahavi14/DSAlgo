package org.example.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.Logger;
import org.example.factory.DriverFactory;
import org.example.utilities.ConfigReader;
import io.cucumber.java.Before;
import org.example.utilities.LoggerHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

public class Hooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;
    private Logger log = LoggerHelper.getLogger(Hooks.class);
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
        log.info("Browser from config: " + browserName);
        driverFactory = new DriverFactory();
       driver = driverFactory.init_driver(browserName);
    }

    @Before (order = 2)
    public void beforeScenario(Scenario scenario) {
        log.info("Starting scenario: " + scenario.getName());
    }

    @After(order = 0)
    public  void quitBrowser()
    {
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) throws IOException {
        if(scenario.isFailed())
        {
            log.error("Scenario failed: " + scenario.getName());
            // Take screenshot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // Create target folder if not exists
            File destDir = new File("target/screenshots");
            if (!destDir.exists()) {
                destDir.mkdirs();
            }
            // Build screenshot filename
            String fileName = scenario.getName().replaceAll("[^a-zA-Z0-9_-]", "_") + ".png";
            File destFile = new File(destDir, fileName);
            // Save file
            Files.copy(srcFile.toPath(), destFile.toPath());
            System.out.println("✅ Screenshot saved at: " + destFile.getAbsolutePath());
            // Attach to Cucumber report (optional)
            byte[] fileContent = Files.readAllBytes(destFile.toPath());
            scenario.attach(fileContent, "image/png", scenario.getName());
        }
        else { log.info("Scenario passed: " + scenario.getName()); }

    }

}
