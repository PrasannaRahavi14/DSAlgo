package org.example.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Register {
	
	
	WebDriver driver;
	
	
	@Given("the user is on the Home page")
	public void the_user_is_on_the_home_page() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://dsportalapp.herokuapp.com/");
		driver.findElement(By.xpath("//button[text()='Get Started']")).click();
	   
	}

	@When("the user clicks on Register link on the Home page")
	public void the_user_clicks_on_register_link_on_the_home_page() {
			driver.findElement(By.xpath("//body/div/nav/div/div[2]/ul/a[2][contains(@href, 'register')]")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Then("the user should be redirected to the Register page")
	public void the_user_should_be_redirected_to_the_register_page() {
		boolean text = driver.findElement(By.xpath("//html[@lang=\"en\"]")).isDisplayed();
    	Assert.assertEquals(text,true);
	   
	}

	@Given("the user is on the Register page")
	public void the_user_is_on_the_register_page() {
		//Assert.assertTrue(driver.findElement(By.xpath("//html[@lang=\"en\"]")).isDisplayed());
	
		 
	}

	@When("the user clicks on Register button with all fields empty")
	public void the_user_clicks_on_register_button_with_all_fields_empty() {
		driver.findElement(By.id("id_username")).sendKeys("");
		driver.findElement(By.id("id_password1")).sendKeys("");
		driver.findElement(By.id("id_password2")).sendKeys("");
		driver.findElement(By.xpath("//input[@value='Register']")).click();

	   
	}

	@Then("the user should see an error message as {string} below Username textbox")
	public void the_user_should_see_an_error_message_as_below_username_textbox(String string) {
		
	   
	}

	@When("the user clicks on Register button after entering Username with other fields empty")
	public void the_user_clicks_on_register_button_after_entering_username_with_other_fields_empty() {
	    
	
	}

	@Then("the user should see an error message as {string} below Password textbox")
	public void the_user_should_see_an_error_message_as_below_password_textbox(String string) {
	    
	   
	}

	@When("the user clicks on Register button after entering Password with other fields empty")
	public void the_user_clicks_on_register_button_after_entering_password_with_other_fields_empty() {
	    
	   
	}

	@When("the user clicks on Register button after entering Username and Password without Password confirmation")
	public void the_user_clicks_on_register_button_after_entering_username_and_password_without_password_confirmation() {
	    
	   
	}

	@Then("the user should see an error message as {string} below Password confirmation textbox")
	public void the_user_should_see_an_error_message_as_below_password_confirmation_textbox(String string) {
	    
	   
	}

}
