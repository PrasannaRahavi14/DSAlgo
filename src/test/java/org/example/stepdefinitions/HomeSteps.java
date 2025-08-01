package org.example.stepdefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {
	WebDriver driver;
	@Given("The user is on dsAlgo portal page")
	public void the_user_is_on_ds_algo_portal_page() {
		driver= new ChromeDriver();
		driver.manage().window().maximize(); 
		 driver.get("https://dsportalapp.herokuapp.com/");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@When("The user click Get started button")
	public void the_user_click_get_started_button() {
		
		driver.findElement(By.xpath("//button[text()='Get Started']")).click();

	}

	/*@Then("The user should be redireced to Home page to verify NumbyNinja")
	public void the_user_should_be_redireced_to_home_page_to_verify_numby_ninja() {
		 boolean numbytext=driver.findElement(By.xpath("//a[text()='NumpyNinja']")).isDisplayed();
		  Assert.assertEquals(numbytext,true);
		  driver.quit();

	    
	}*/
	}
