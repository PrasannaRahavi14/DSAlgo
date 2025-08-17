package org.example.stepdefinitions;


	

import org.example.factory.DriverFactory;
import org.example.pages.HomePage;
import org.example.pages.LandingPage;
import org.example.pages.LoginPage;
import org.example.utilities.ConfigReader;
//import org.example.utilities.LoggerLoad;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;

	public class LoginSteps {
		
		WebDriver driver = DriverFactory.getDriver();
	    LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	    LandingPage landingpage = new LandingPage(DriverFactory.getDriver());
	    HomePage homePage = new HomePage(DriverFactory.getDriver());
	    //LoggerLoad logload = new LoggerLoad();
	    
		
	    		
	    String url = ConfigReader.getProperty("baseurl");

	    @Given("the user is on the Signin page")
		public void the_user_is_on_the_signin_page() {
	    	 driver.get(url);
	    	 landingpage.clickGetStartedBtn();
	    	homePage.clickSignInLink();
		  
		}
		@When("the user clicks {string} button")
		public void the_user_clicks_button(String LoginBtn) {
			
			loginpage.clickOnLogin();
		  
		}
		@Then("the error message should be displayed")
		public void the_error_message_should_be_displayed() {
		    //LoggerLoad.error("<---------Testing Error---------->");
		}
	
		@When("the user clicks the {string} button without entering username field")
		public void the_user_clicks_the_button_without_entering_username_field(String LoginBtn) {
		    
	//		loginpage.replacewithemptystringusrnme();
			loginpage.clickOnLogin();
			
		}
		
		
		 @When("the user clicks the {string} button without entering password field")
	        public void the_user_clicks_the_button_without_entering_password_field(String string) {
	//              loginpage.replacewithemptystringpwd(string);
	        }
		
		
		@Then("the user should be displayed with error message {string}")
		public void the_user_should_be_displayed_with_error_message(String string) {
	//	   loginpage.alert();
		   //LoggerLoad.error("<-----------Testing Error--------->");
		}
			
		
		@When("the user clicks the {string} button after the invalid Username is entered")
		public void the_user_clicks_the_button_after_the_invalid_username_is_entered(String enterPassword) {
		    
	//		loginpage.invalidusrnme(enterPassword);
			loginpage.clickOnLogin();
			
		}
		@Then("the error message {string} should be displayed")
		public void the_error_message_should_be_displayed(String string) {
	//	    loginpage.Invalidmsg();
		    //LoggerLoad.error("<----------Testing Error--------->");
		}
		
		@When("the user clicks the {string} button after the invalid Password is entered")
		public void the_user_clicks_the_button_after_the_invalid_password_is_entered(String enterUserName) {
		    
	//		loginpage.invalidpwd(enterUserName);
			
			
		}
		
		@When("the user clicks the Login button after the valid {string} and {string} is entered")
		public void the_user_clicks_the_login_button_after_the_valid_and_is_entered(String un, String pwd) {    
		
			loginpage.doLogin(un,pwd);
		}
		@Then("the user will be directed to the Home Page with {string} message displayed")
		public void the_user_will_be_directed_to_the_home_page_with_message_displayed(String string) {
		    //LoggerLoad.info("<---------Testing info------>");
		    
		}
	}

	

