package org.example.stepdefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.factory.DriverFactory;
import org.example.pages.*;
import org.example.utilities.BaseLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class DatastructureSteps extends BaseLogger {

    LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
    LandingPage landingpage = new LandingPage(DriverFactory.getDriver());
    HomePage homePage = new HomePage(DriverFactory.getDriver());
    DataStructurePage dsp = new DataStructurePage(DriverFactory.getDriver());


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
       landingpage.getURL();
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

    @Then("The user should be in {string} Page")
    public void theUserShouldBeInPage(String textPage) {
        Assert.assertEquals(dsp.validateTitle(textPage),textPage);

    }

    @Given("The user is in the time complexity page after clicking {string}")
    public void theUserIsInTheTimeComplexityPageAfterClicking(String topic) {
       dsp.clickTopicLink(topic);
       Assert.assertEquals(dsp.validateTitle(topic),"Time Complexity");
    }

    @When("The user click Try here button")
    public void theUserClickTryHereButton() {
        dsp.clickTryHereBtn();
    }

    @Then("The user should be redirected to the page having a try editor with run button")
    public void theUserShouldBeRedirectedToThePageHavingATryEditorWithRunButton() {
        log.info("Checking the try editor code block is available");
        Assert.assertTrue(dsp.tryEditorVisible(),"Try Editor Code block not available");
        log.info("Checking the Run button is available");
        Assert.assertTrue(dsp.runBtnVisible(),"Run button not visible");
    }


    @Given("The user is in the try editor page of the topic {string}")
    public void theUserIsInTheTryEditorPageOfTheTopic(String topic) {
        dsp.clickTopicLink(topic);
        Assert.assertEquals(dsp.validateTitle(topic),"Time Complexity");
        dsp.clickTryHereBtn();
        log.info("Checking the try editor code block is available");
        Assert.assertTrue(dsp.tryEditorVisible(),"Try Editor Code block not available");
        log.info("Checking the Run button is available");
        Assert.assertTrue(dsp.runBtnVisible(),"Run button not visible");
    }

    @When("The user enters the valid python code and clicks run button")
    public void theUserEntersTheValidPythonCodeAndClicksRunButton() {

        log.info("Entering python code in the editor : "+dsp.getPythonCodeDataDriven());
        dsp.enterPythonCode(dsp.getPythonCodeDataDriven());
        log.info("Clicking on Run button");
        dsp.clickRunBtn();
    }

    @Then("The user should be able to see the output in the console")
    public void theUserShouldBeAbleToSeeTheOutputInTheConsole() {
        String actualOutput = dsp.getOutputFromConsole();
        log.info("Output printed in the console : "+actualOutput);
        String expectedOutput = dsp.getOutputDataDriven();
        log.info("Expected Output : "+expectedOutput);
        Assert.assertEquals(actualOutput,expectedOutput);
        log.info("Actual Output matched with the Expected Output");

    }

    @Given("the user is in DataStructure page after login")
    public void theUserIsInDataStructurePageAfterLogin() {
        log.info("Executing the Background Scenario : Navigating to the DataStructure Page");
        landingpage.getURL();
        Assert.assertEquals(landingpage.getTitle(), "Preparing for the Interviews");
        landingpage.clickGetStartedBtn();
        Assert.assertEquals(homePage.getTitle(), "NumpyNinja");
        homePage.clickSignInLink();
        loginpage.performLoginDataDriven();
        Assert.assertEquals(homePage.CheckName(), "Prasanna");
        homePage.clickGetStartedForDS();
        Assert.assertEquals(dsp.getTitleforDSI(),"Data Structures-Introduction");
        log.info ("Background Scenario executed successfully : Landed in DataStructure Page");
    }
}
