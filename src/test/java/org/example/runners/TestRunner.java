package org.example.runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/Graph.feature",
        glue = {"org.example.stepdefinitions","org.example.hooks"},
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                           "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true
        
)

public class TestRunner extends AbstractTestNGCucumberTests  {
	
	  @Override
	  @DataProvider(parallel = false) 
	  public Object[][] scenarios()
	  { return super.scenarios(); 
	  }
	 
}
