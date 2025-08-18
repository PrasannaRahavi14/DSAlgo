package org.example.stepdefinitions;


	

import org.example.factory.DriverFactory;
import org.example.pages.HomePage;
import org.example.pages.LandingPage;
import org.example.pages.LoginPage;
import org.example.utilities.BaseLogger;
import org.example.utilities.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;

	public class LoginSteps extends BaseLogger {
		
		WebDriver driver = DriverFactory.getDriver();
	    LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	    LandingPage landingpage = new LandingPage(DriverFactory.getDriver());
	    HomePage homePage = new HomePage(DriverFactory.getDriver());
	    
	    
		
	    @Given("the user is on the Signin page")
		public void the_user_is_on_the_signin_page() {
	    	 loginpage.Loginurl();
	    	 landingpage.clickGetStartedBtn();
	    	homePage.clickSignInLink();
		  
		}
		
	    @When("the user clicks {string} button")
		public void the_user_clicks_button(String LoginBtn) {
			
	    	loginpage.InvalidLogin();
		
		  
		}
		@Then("the error message should be displayed")
		public void the_error_message_should_be_displayed() {
		    log.error("<-------Testing error------>");
		}
	
		@When("the user clicks the {string} button without entering username field")
		public void the_user_clicks_the_button_without_entering_username_field(String LoginBtn) {
		    
			
			loginpage.UsernameMissing();
			
		}
		
		
		 @When("the user clicks the {string} button without entering password field")
	        public void the_user_clicks_the_button_without_entering_password_field(String string) {
	         
			 loginpage.Passwordmissing();
			 
	        }
		
		
		    @Then("the user should be displayed with error message {string}")
		    public void the_user_should_be_displayed_with_error_message(String string) {
		   
		    	log.error("<-------Testing error------>");
		   
		    }
			
		
		     @When("the user clicks the {string} button after the invalid Username is entered")
		     public void the_user_clicks_the_button_after_the_invalid_username_is_entered(String enterPassword) {
		    
			
			loginpage.Invalidusername();
			
		}
		@Then("the error message {string} should be displayed")
		public void the_error_message_should_be_displayed(String string) {
		    log.error("<-------Testing Error------>");
		    
		}
		
		@When("the user clicks the {string} button after the invalid Password is entered")
		public void the_user_clicks_the_button_after_the_invalid_password_is_entered(String enterUserName) {
		    
			loginpage.Invalidpassword();
			
			
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


	

