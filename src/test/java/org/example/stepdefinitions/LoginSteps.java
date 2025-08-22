package org.example.stepdefinitions;

import org.example.factory.DriverFactory;
import org.example.pages.LoginPage;
import org.example.utilities.BaseLogger;
import org.openqa.selenium.WebDriver;


	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;

	public class LoginSteps extends BaseLogger {
		
		WebDriver driver = DriverFactory.getDriver();
	    LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	      
	    		
	    @Given("the user is on the Signin page")
		public void the_user_is_on_the_signin_page() {
	    	 loginpage.Loginurl();
	    	 loginpage.clickGetStartedBtn();
	    	 loginpage.clickSignInLink();
		  
		}
		
	    @When("the user clicks the Login button with {string}")
	    public void the_user_clicks_the_login_button_with(String option) {
	        loginpage.FailedLogin(option);
	    }
	    @Then("the user should be displayed with error message")
	    public void the_user_should_be_displayed_with_error_message() {
	        log.error("<-----Testing error----->");
	    }
	
		
		
		@When("the user clicks the Login button after the valid {string} and {string} is entered")
		public void the_user_clicks_the_login_button_after_the_valid_and_is_entered(String un, String pwd) {    
		
			loginpage.performLoginDataDriven();
		}
		@Then("the user will be directed to the Home Page with {string} message displayed")
		public void the_user_will_be_directed_to_the_home_page_with_message_displayed(String string) {
		    log.info("<------Testing info----->");
		    
		}
	}


	

