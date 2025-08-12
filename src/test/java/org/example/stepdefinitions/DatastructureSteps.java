package org.example.stepdefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.factory.DriverFactory;
import org.example.pages.DataStructurePage;
import org.example.pages.HomePage;
import org.example.pages.LandingPage;
import org.example.pages.LoginPage;
import org.example.utilities.ConfigReader;
import org.example.utilities.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Map;

public class DatastructureSteps {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
    LandingPage landingpage = new LandingPage(DriverFactory.getDriver());
    HomePage homePage = new HomePage(DriverFactory.getDriver());
    DataStructurePage dsp = new DataStructurePage(DriverFactory.getDriver());
    String url = ConfigReader.getProperty("baseurl");
    private final String filePath = "src/test/resources/testdata/TestData1.xlsx";


    @Given("The user is in Home Page after login")
    public void theUserIsInHomePageAfterLogin() {
        String title_hp = homePage.getTitle();
        Assert.assertEquals(title_hp, "NumpyNinja");
        Assert.assertEquals(homePage.CheckName(), "Prasanna");
    }

//    @When("The user clicks the option {string} from the dropdown")
//    public void theUserClicksTheOptionFromTheDropdown(String arg0) {
//
//    }


    @Given("The user is in {string} Page")
    public void theUserIsInPage(String expectedText) {
   //     Assert.assertEquals(dsp.getTitleforDSI(),expectedText);
       System.out.println("The user is in the page : " +dsp.validateTitle(expectedText));
       Assert.assertEquals(dsp.validateTitle(expectedText),expectedText);
    }

    @Given("the user is on Landing Page")
    public void theUserIsOnLandingPage() {
        driver.get(url);
        String title_lp =  landingpage.getTitle();
        Assert.assertEquals(title_lp, "Preparing for the Interviews");
        landingpage.clickGetStartedBtn();
    }

    @And("the user signed in to ds algo page with username {string} and password {string}")
    public void theUserSignedInToDsAlgoPageWithUsernameAndPassword(String un, String pwd) {
        homePage.clickSignInLink();
        loginpage.doLogin(un,pwd);
    }


    @When("The user clicks the {string} from the topics")
    public void theUserClicksTheFromTheTopics(String topic) {
        dsp.clickTopicLink(topic);
    }

    @When("The user clicks the Get Started Button of DS page")
    public void theUserClicksTheGetStartedButtonOfDSPage() {
        homePage.clickGetStartedForDS();
    }

    @Given("the user is in DataStructure page")
    public void theUserIsInDataStructurePage() {
        driver.get(url);
        String title_lp =  landingpage.getTitle();
        Assert.assertEquals(title_lp, "Preparing for the Interviews");
        landingpage.clickGetStartedBtn();
        String title_hp = homePage.getTitle();
        Assert.assertEquals(title_hp, "NumpyNinja");
        homePage.clickSignInLink();
        Map<String, String> loginData = ExcelReader.getDefaultLogin(filePath);
        loginpage.doLogin(loginData.get("Username"),loginData.get("Password"));
        Assert.assertEquals(homePage.CheckName(), "Prasanna");
        homePage.clickGetStartedForDS();
        Assert.assertEquals(dsp.getTitleforDSI(),"Data Structures-Introduction");


    }

    @Then("The user should be in {string} Page")
    public void theUserShouldBeInPage(String textPage) {
        System.out.println("The user is in the page : " +dsp.validateTitle(textPage));
        Assert.assertEquals(dsp.validateTitle(textPage),textPage);
    }
}
