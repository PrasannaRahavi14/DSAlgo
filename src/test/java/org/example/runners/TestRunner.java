package org.example.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(
	plugin = {"pretty"},//, "html:target/report1.html"}, //reporting purpose
		monochrome=true,  //console output color
			//tags = "@tag or @persoanlLeave", //tags from feature file
			features = {"src/test/resources/features"}, //location of feature files
			glue= "stepdefinition") //location of step definition files


	public class TestRunner extends AbstractTestNGCucumberTests{
	}
