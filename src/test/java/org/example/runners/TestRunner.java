package org.example.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/login.feature",
        glue = {"org.example.stepdefinitions","org.example.hooks"},
        plugin = {"pretty"},// "html:target/cucumber-report.html"},
        monochrome = true,
        tags = "@fail3 or @pass"
)

public class TestRunner extends AbstractTestNGCucumberTests  {
}
