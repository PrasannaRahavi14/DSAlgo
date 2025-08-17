package org.example.stepdefinitions;

import org.example.factory.DriverFactory;
import org.example.pages.HomePage;
import org.example.pages.LandingPage;
import org.example.pages.LinkedListPage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LinkedListSteps {
	 WebDriver driver = DriverFactory.getDriver();
	 HomePage home = new HomePage(DriverFactory.getDriver());
	 LandingPage landingPage = new LandingPage(DriverFactory.getDriver());
	 LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	 LinkedListPage linkedlistpage = new LinkedListPage(DriverFactory.getDriver());

	
	

@Given("the user in Linked List page after signed in")
public void the_user_in_linked_list_page_after_signed_in() {
	
	landingPage.getURL();
	landingPage.clickGetStartedBtn();
	home.clickSignIn();
	   loginpage.doLogin("dummyuser", "numpy@123");
	   home.clickLinkedListGet();
	   
    
}

@When("The user clicks on  Introduction link on Linked List module")
public void the_user_clicks_on_introduction_link_on_linked_list_module() {
	System.out.println("Find Intro Link");
    linkedlistpage.clickIntroLink();
}

@Then("The user should navigate to Introduction page")
public void the_user_should_navigate_to_introduction_page() {
   
}




}
