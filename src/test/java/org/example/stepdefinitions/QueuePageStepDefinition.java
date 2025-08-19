package org.example.stepdefinitions;

import org.example.factory.DriverFactory;
import org.example.pages.DataStructurePage;
import org.example.pages.HomePage;
import org.example.pages.LandingPage;
import org.example.pages.LoginPage;
import org.example.pages.Queue;
import org.example.utilities.BaseLogger;
import org.example.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class QueuePageStepDefinition extends BaseLogger{
	
	
	WebDriver driver = DriverFactory.getDriver();
    LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
    LandingPage landingpage = new LandingPage(DriverFactory.getDriver());
    HomePage homePage = new HomePage(DriverFactory.getDriver());
   
    Queue Qp = new Queue(DriverFactory.getDriver());
    DataStructurePage Ds = new DataStructurePage(DriverFactory.getDriver());
    
    @When("the user clicks the {string} button under {string}")
    public void the_user_clicks_the_button_under(String un, String pwd) {
    	loginpage.Loginurl();
        String title_lp =  landingpage.getTitle();
        Assert.assertEquals(title_lp, "Preparing for the Interviews");
    	landingpage.clickGetStartedBtn();
    	homePage.clickSignIn();
		loginpage.performLoginDataDriven();
		homePage.clickGetStartedForQueue();
    }
    
    @Then("the user should be directed to {string} page")
    public void the_user_should_be_directed_to_page(String string) {
    	System.out.println(driver.getCurrentUrl());
    }
    
    @When("the user clicks {string} hyperlink")
    public void the_user_clicks_hyperlink(String string) {
    	Qp.ImplementationofQueue();
    }
    
    @Then("the user should be directed to the next page")
    public void the_user_should_be_directed_to_the_next_page() {
        
    } 
    
    @Given("the user is on {string} Page")
    public void the_user_is_on_page(String string) {
       Qp.ImplementationofQueue();
    }
    
    @When("the user clicks on {string} button")
    public void the_user_clicks_on_button(String string) {
        Qp.Tryhere();
    }
    @Then("the user is displayed with editor page")
    public void the_user_is_displayed_with_editor_page() {
        
    }
    
    
    @Given("the user is in {string} Page")
    public void the_user_is_in_page(String string) {
    	Qp.ImplementationofQueue();
    	Qp.Tryhere();
    }
    @When("the user enters the valid python code and clicks {string}")
    public void the_user_enters_the_valid_python_code_and_clicks(String string) {
   // 	Ds.enterPythonCode(Ds.getPythonCodeDataDriven());
        Qp.Run();
        
    }
    @Then("the user is dispalyed with the code")
    public void the_user_is_dispalyed_with_the_code() {
    	
        log.info("<------Test info----->");
    }
    
    @When("the user enters invalid python data")
    public void the_user_enters_invalid_python_data() {
    	Qp.ImplementationofQueue();
    	Qp.Tryhere();
    //	Ds.enterPythonCode(Ds.getInvalidCodeDataDriven());
    	
    }
    @Then("the user should see error popup {string}")
    public void the_user_should_see_error_popup(String string) {
         
    	Qp.Run();
    	log.error("<------Test Error----->");
        
    }
    
    @Given("the user is on Queue Page")
    public void the_user_is_on_queue_page() {
        
    }
    @When("the user clicks {string}")
    public void the_user_clicks(String option) {
        Qp.QueueTopics(option);
        Qp.Tryhere();
    //    Ds.enterPythonCode(Ds.getPythonCodeDataDriven());
        Qp.Run();
       
        
        
    }
    @Then("the user is redirected to the next page")
    public void the_user_is_redirected_to_the_next_page() {
        
    }
	
    @When("the user clicks {string} on Queue page")
    public void the_user_clicks_on_queue_page(String option) {
        Qp.QueueTopics(option);
        Qp.Tryhere();
    //    Ds.enterPythonCode(Ds.getInvalidCodeDataDriven());
        Qp.Run();
        
    }
    @Then("the user is in next page")
    public void the_user_is_in_next_page() {
        
    }
}
