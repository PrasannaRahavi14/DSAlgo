package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.factory.DriverFactory;
import org.example.pages.DataStructurePage;
import org.example.pages.HomePage;
import org.example.pages.LandingPage;
import org.example.pages.LoginPage;
import org.example.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ArraySteps {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
    LandingPage landingpage = new LandingPage(DriverFactory.getDriver());
    HomePage homePage = new HomePage(DriverFactory.getDriver());

    DataStructurePage dsp = new DataStructurePage(DriverFactory.getDriver());
    String url = ConfigReader.getProperty("baseurl");

    @Given("User is in Home page after successful sign-in")
    public void userIsInHomePageAfterSuccessfulSignIn() {
    }

    @When("Click Get Started in the array or click on Data Structures dropdown to select Arrays")
    public void clickGetStartedInTheArrayOrClickOnDataStructuresDropdownToSelectArrays() {
    }

    @Then("User should be navigated to the Array page")
    public void userShouldBeNavigatedToTheArrayPage() {
    }

    @Given("User is on the Array page")
    public void userIsOnTheArrayPage() {
    }

    @When("User clicks Arrays in Python hyperlink")
    public void userClicksArraysInPythonHyperlink() {
    }

    @Then("User should be redirected to Arrays in Python page")
    public void userShouldBeRedirectedToArraysInPythonPage() {
    }

      @Given("User is in Array page after successful login using username {string} and password {string}")
    public void userIsInArrayPageAfterSuccessfulLoginUsingUsernameAndPassword(String username, String password) {

          driver.get(url);
          String title_lp =  landingpage.getTitle();
          Assert.assertEquals(title_lp, "Preparing for the Interviews");
          landingpage.clickGetStartedBtn();
          homePage.clickSignInLink();
          loginpage.doLogin(username,password);
    }
}
