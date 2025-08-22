package org.example.stepdefinitions;

import org.example.factory.DriverFactory;
import org.example.pages.HomePage;
import org.example.pages.LandingPage;
import org.example.pages.RegisterPage;
import org.example.utilities.BaseLogger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStepdef extends BaseLogger {

	WebDriver driver = DriverFactory.getDriver();
	RegisterPage registerpage = new RegisterPage(DriverFactory.getDriver());
	HomePage homePage = new HomePage(DriverFactory.getDriver());
	LandingPage landingpage = new LandingPage(DriverFactory.getDriver());
	    
	@Given("the user is on the Home page")
	public void the_user_is_on_the_home_page() {
		
		landingpage.getURL();
		landingpage.clickGetStartedBtn();
      }

	 @When("the user clicks on Register link on the Home page") 
	 public void the_user_clicks_on_register_link_on_the_home_page() { 	
		 homePage.clickRegister();	 
	  }
	 
	 @Then("The user should land on Register page.")
	 public void the_user_should_land_on_register_page() { 
		 registerpage.getRegister(); 
	     String ActualTitle = registerpage.ValidateTitleRegisterPage();
	     log.info("The user is on page: " + ActualTitle);

	 }

	@Given("The user is on Register page after clicking on register link from homepage")
	 public void the_user_is_on_register_page_after_clicking_on_register_link_from_homepage() {
		 landingpage.getURL();
		 landingpage.clickGetStartedBtn();
		 homePage.clickRegister();
		 String ActualTitle = registerpage.ValidateTitleRegisterPage();
	     log.info("The user is on page: " + ActualTitle);
	 }
	 
	@When("the user clicks on Register button with all fields empty")
	 public void the_user_clicks_on_register_button_with_all_fields_empty() {
	  	 registerpage.getEmptyValues();
	 }

	@Then("the user should see an error message as {string} below Username textbox")
	public void the_user_should_see_an_error_message_as_below_username_textbox(String ExpectedMsg) {
		String ActualMsg = registerpage.getUsernameValidationMessage();	
		log.info("Actual message: " + ActualMsg);
	    Assert.assertEquals(ActualMsg, ExpectedMsg, "Please fill out this field.");
	}

   @When("the user clicks on Register button after entering Username with other fields empty")
   public void the_user_clicks_on_register_button_after_entering_username_with_other_fields_empty() {
       registerpage.getUsernameValues();
	  
    }

   @Then("the user should see an error message as {string} below Password textbox")
   public void the_user_should_see_an_error_message_as_below_password_textbox(String ExpectedMsg) {
       String ActualMsg = registerpage.getPaswordValidationMessage();
       log.info("Actual message: " + ActualMsg);
	   Assert.assertEquals(ActualMsg, ExpectedMsg, "Please fill out this field.");
    }

   @When("the user clicks on Register button after entering Password with other fields empty")
   public void the_user_clicks_on_register_button_after_entering_password_with_other_fields_empty() {
       registerpage.getPasswordValues();
    }
   
   @When("the user clicks on Register button after entering Username and Password without Password confirmation")
   public void the_user_clicks_on_register_button_after_entering_username_and_password_without_password_confirmation() {
       registerpage.getNoPasswordConfirmation();
   }

   @Then("the user should see an error message as {string} below Password confirmation textbox")
   public void the_user_should_see_an_error_message_as_below_password_confirmation_textbox(String ExpectedMsg) {
       String ActualMsg = registerpage.getPwdConfimationValidationMessage();
       log.info("Actual message: " + ActualMsg);
	   Assert.assertEquals(ActualMsg, ExpectedMsg, "Please fill out this field.");
   }
   
   @When("the user clicks Register button after entering different passwords in Password and Password Confirmation fields")
   public void the_user_clicks_Register_button_after_entering_different_passwords_in_password_and_password_confirmation_fields() {
     registerpage.getMismatchPassword();
	     }

   @Then("The user should able to see an pwd warning message {string}")
   public void the_user_should_able_to_see_an_pwd_warning_message(String ExpectedAlert) {
	   registerpage.getPwdMismatchAlertmsg();
	  }
   
   @When("the user clicks Register button with valid Username,Password and Password Confirmation")
   public void the_user_clicks_register_button_with_valid_username_password_and_password_confirmation() {
       registerpage.getValidCredentials();
   }

   @Then("The user should be redirected to Home Page of DS Algo with message {string}")
   public void the_user_should_be_redirected_to_home_page_of_ds_algo_with_message(String ExpectedMsg) {
       String ActualMsg = registerpage.getNewAccountAlertmsg();
       log.info("Actual message: " + ActualMsg);
	   Assert.assertEquals(ActualMsg,ExpectedMsg);
	}
   
 @When("the user clicks Register button after entering Invalid data in Username field")
 public void the_user_clicks_register_button_after_entering_invalid_data_in_username_field() {
      registerpage.getInvalidUsername();
    }

 @Then("the user should see an warning message as {string} below Username textbox")
 public void the_user_should_see_an_warning_message_as_below_username_textbox(String ExpectedMsg) {
	 String ActualMsg = registerpage.getpwdmismatchtext();
     log.info("Actual message: " + ActualMsg);
	 Assert.assertEquals(ActualMsg,ExpectedMsg, "Username is not valid");
    }
 
 @When("the user clicks Register button after entering a password with numeric values")
 public void the_user_clicks_register_button_after_entering_a_password_with_numeric_values() {
     registerpage.getPwdNumericValue();
    }

 @Then("The user should see an warning message as {string} below password textbox")
 public void the_user_should_see_an_warning_message_as_below_password_textbox(String ExpectedMsg) {
	 String ActualMsg = registerpage.getpwdmismatchtext();
	 System.out.println("Actual message: " + ActualMsg);
	 Assert.assertEquals(ActualMsg,ExpectedMsg, "Your password can’t be entirely numeric.");
    }
   
 @When("The user clicks the Login link in the register page")
 public void the_user_clicks_the_login_link_in_the_register_page() {
	 registerpage.getClickLoginLink();
    }

 @Then("The user should be redirected to Login page.")
 public void the_user_should_be_redirected_to_login_page() {
     Assert.assertTrue(registerpage.isLoginPageDisplayed());
    }
	
}