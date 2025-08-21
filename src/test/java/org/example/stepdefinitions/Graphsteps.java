package org.example.stepdefinitions;

import org.example.factory.DriverFactory;
import org.example.pages.Graph;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.example.utilities.BaseLogger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Graphsteps extends BaseLogger{
	
	
	WebDriver driver = DriverFactory.getDriver();
    LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
    HomePage homePage = new HomePage(DriverFactory.getDriver());
	Graph Graphpage = new Graph(DriverFactory.getDriver());
    
	@Given("the user has signed in and navigated to the Graph page")
	public void the_user_has_signed_in_and_navigated_to_the_graph_page() {
		loginpage.Login();
		homePage.clickGetStartedForGraph();
		
	}
	@When("the user selects {string} from the Graph page")
	public void the_user_selects_from_the_graph_page(String option) {
	    Graphpage.selectGraphOption(option);
	    Graphpage.Tryhere();
	    
	}
	@Then("the user should be redirected to the {string} page")
	public void the_user_should_be_redirected_to_the_page(String string) {
		Graphpage.enterPythonCode(Graphpage.getPythonCodeDataDriven());
	    Graphpage.Run();
		log.info("<----Testing Info---->");
	}

	
	
	@Then("the user should remain on the {string} page with an error")
	public void the_user_should_remain_on_the_page_with_an_error(String string) {
	    Graphpage.enterPythonCode(Graphpage.getInvalidCodeDataDriven());
	    Graphpage.Run();
	    log.error("<-----Testing error----->");
	}
	
}
