package org.example.stepdefinitions;

import org.example.factory.DriverFactory;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.Queue;
import org.example.utilities.BaseLogger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class QueuePageStepDefinition extends BaseLogger{
	
	
	WebDriver driver = DriverFactory.getDriver();
    LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
    HomePage homePage = new HomePage(DriverFactory.getDriver());
    Queue Qp = new Queue(DriverFactory.getDriver());
    
    @Given("the user is on Queue page after Sign in")
    public void the_user_is_on_queue_page_after_sign_in() {
    	loginpage.Login();
		homePage.clickGetStartedForQueue();
    }
    
    @When("the user clicks {string} on Queue Page")
    public void the_user_clicks_on_queue_page(String option) {
    Qp.QueueTopics(option);
    Qp.clickOnPQLink();
    Qp.emptyPage();
    Qp.Tryhere();
    Qp.enterPythonCode(Qp.getPythonCodeDataDriven());
    Qp.Run();
     }
    
    @Then("the user is redirected to the {string} page")
    public void the_user_is_redirected_to_the_page(String string) {
    log.info("<----Testing Info---->");
     }
    
    @When("the user clicks {string} from Queue page")
    public void the_user_clicks_from_queue_page(String option) {
    	Qp.QueueTopics(option);
    	Qp.clickOnPQLink();
        Qp.emptyPage();
        Qp.Tryhere();
        Qp.enterPythonCode(Qp.getInvalidCodeDataDriven());
        Qp.Run();
    }
    
    @Then("the user is in {string} page")
    public void the_user_is_in_page(String string) {
        log.error("<-----Testing Error----->");
    }
}
