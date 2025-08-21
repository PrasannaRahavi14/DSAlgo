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



    @When("The user clicks the {string} from the topics")
    public void theUserClicksTheFromTheTopics(String topic) {
        dsp.clickTopicLink(topic);
    }

   @Then("The user should be in {string} Page")
    public void theUserShouldBeInPage(String textPage) {
        Assert.assertEquals(dsp.validateTitle(textPage),textPage);

    }

    @Given("The user is in the time complexity page after clicking {string}")
    public void theUserIsInTheTimeComplexityPageAfterClicking(String topic) {
       dsp.clickTopicLink(topic);
       dsp.validateTitle(topic);

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
        dsp.validateTitle(topic);
        dsp.clickTryHereBtn();
        dsp.tryEditorPageWithRunBtn();
    }

    @Given("the user is in DataStructure page after login")
    public void theUserIsInDataStructurePageAfterLogin() {
        loginpage.Login();
        log.info("Welcome "+homePage.CheckName());
        homePage.clickGetStartedForDS();
        log.info ("Background Scenario executed successfully : Landed in "+dsp.getTitleforDSI());
    }

    @When("The user enters the {string} code and clicks run button")
    public void theUserEntersTheCodeAndClicksRunButton(String input) {
        String code = dsp.getPythonCodeDataDriven(input);
        dsp.enterPythonCode(code);
        log.info("The code entered in the editor : "+code);
        dsp.clickRunBtn();
        log.info ("Run button clicked");

    }

    @Then("The user should be able to see the output for the {string}")
    public void theUserShouldBeAbleToSeeTheOutputForThe(String input) {
        String actualOutput = dsp.processInputAndReturnStatus();
        if (actualOutput != null) {
            String expectedOutput = dsp.getOutputDataDriven(input);
            log.info("Expected Output: " + expectedOutput);
            Assert.assertEquals(actualOutput, expectedOutput);
            log.info("✅ Actual Output matched with the Expected Output");
        } else {
            log.warn("Test failed due to invalid input, alert was handled.");
        }
    }

    @Then("The user is able to get the total no of topics link present")
    public void theUserIsAbleToGetTheTotalNoOfTopicsLinkPresent() {
       log.info("Total topics present in this page : "+dsp.getTotalCountofTopicsLink());
    }

    @When("The user sees the topics covered section in Datastructure")
    public void theUserSeesTheTopicsCoveredSectionInDatastructure() {
        dsp.topicsCoveredSection();
    }

    @When("The user clicks Practice Questions link")
    public void theUserClicksPracticeQuestionsLink() {
        dsp.clickOnPQLink();
    }
    @Then("The user should be able to check if the page is valid or not")
    public void theUserShouldBeAbleToCheckIfThePageIsValidOrNot() {
        dsp.emptyPage();
    }
}
