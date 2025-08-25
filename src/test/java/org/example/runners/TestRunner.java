package org.example.runners;

import org.example.factory.DriverFactory;
import org.testng.annotations.*;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/Register.feature",
        glue = {"org.example.stepdefinitions","org.example.hooks"},
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                           "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true
        
)

public class TestRunner extends AbstractTestNGCucumberTests  {
	@BeforeClass(alwaysRun = true)
	@Parameters("browser")
	public void setBrowser(@Optional("chrome") String browser) {
		DriverFactory.setBrowser(browser);
		System.out.println("Running tests on: " + browser + " | Thread ID: " + Thread.currentThread().getId());
	}
	
//	  @Override
//	  @DataProvider(parallel = true)
//	  public Object[][] scenarios()
//	  { return super.scenarios();
//	  }
//
}
