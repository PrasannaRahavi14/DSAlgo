package org.example.runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.example.stepdefinitions","org.example.hooks"},
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true
        
)

public class TestRunner extends AbstractTestNGCucumberTests  {
	
	  @Override
	  @DataProvider(parallel = true) public Object[][] scenarios() { return
	  super.scenarios(); }
	 
}
