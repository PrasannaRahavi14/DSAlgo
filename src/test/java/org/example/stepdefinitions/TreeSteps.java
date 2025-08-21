package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.factory.DriverFactory;
import org.example.pages.*;
import org.example.utilities.BaseLogger;
import org.testng.Assert;

public class TreeSteps extends BaseLogger {
    LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
    LandingPage landingpage = new LandingPage(DriverFactory.getDriver());
    HomePage homePage = new HomePage(DriverFactory.getDriver());
    TreePage treePage = new TreePage(DriverFactory.getDriver());

    @Given("The user is in Tree Page after login")
    public void theUserIsInTreePageAfterLogin() {
        loginpage.Login();
        log.info("Welcome "+homePage.CheckName());
        homePage.clickGetStartedForTree();
        log.info ("Background Scenario executed successfully : Landed in "+treePage.getTitleforTree());
    }

    @When("The user clicks the {string} link from the topics")
    public void theUserClicksTheLinkFromTheTopics(String text) {
        treePage.clickTopicLink(text);
    }

    @Then("The user should be in the {string} Page of the Tree")
    public void theUserShouldBeInThePageOfTheTree(String text) {
        treePage.validateTitleforTopics(text);
    }

    @When("The user click Try here button of the {string} page")
    public void theUserClickTryHereButtonOfThePage(String topicLink) {
        treePage.clickTryHereBtn(topicLink);

    }
    @Then("The user should be redirected to the page having a try editor with run button of the current topic")
    public void theUserShouldBeRedirectedToThePageHavingATryEditorWithRunButtonOfTheCurrentTopic() {
        log.info("Checking the try editor code block is available");
        Assert.assertTrue(treePage.tryEditorVisible(),"Try Editor Code block not available");
        log.info("Checking the Run button is available");
        Assert.assertTrue(treePage.runBtnVisible(),"Run button not visible");
    }

    @Given("The user is in the topics page after clicking the {string} link")
    public void theUserIsInTheTopicsPageAfterClickingTheLink(String text) {
        treePage.clickTopicLink(text);
        treePage.validateTitleforTopics(text);
    }

    @Given("The user is in the try editor page of the Tree topic {string}")
    public void theUserIsInTheTryEditorPageOfTheTreeTopic(String text) {
        treePage.clickTopicLink(text);
        treePage.validateTitleforTopics(text);
        treePage.clickTryHereBtn(text);
        treePage.tryEditorPageWithRunBtn();
    }

    @When("The user enters {string} in the editor and clicks run button")
    public void theUserEntersInTheEditorAndClicksRunButton(String input) {
        String code = treePage.getPythonCodeDataDriven(input);
        treePage.enterPythonCode(code);
        log.info("The code entered in the editor : "+code);
        treePage.clickRunBtn();
        log.info ("Run button clicked");
    }

    @Then("The user should be able to see the output for {string}")
    public void theUserShouldBeAbleToSeeTheOutputFor(String input) {
        String actualOutput = treePage.processInputAndReturnStatus();
        if (actualOutput != null) {
            String expectedOutput = treePage.getOutputDataDriven(input);
            log.info("Expected Output: " + expectedOutput);
            Assert.assertEquals(actualOutput, expectedOutput);
            log.info("✅ Actual Output matched with the Expected Output");
        } else {
            log.warn("Test failed due to invalid input, alert was handled.");
        }
    }

    @When("The user sees the topics covered section in Tree")
    public void theUserSeesTheTopicsCoveredSectionInTree() {
        treePage.topicsCoveredSection();
    }

    @Then("The user is able to get the total no of topics present in the page")
    public void theUserIsAbleToGetTheTotalNoOfTopicsPresentInThePage() {
        log.info("Total topics present in this page : "+treePage.getTotalCountofTopicsLink());
    }

    @When("The user clicks on the practice question link")
    public void theUserClicksOnThePracticeQuestionLink() {
        treePage.clickOnPQLink();
    }

    @Then("The user is able to check if the empty is empty or not")
    public void theUserIsAbleToCheckIfTheEmptyIsEmptyOrNot() {
        treePage.emptyPage();
    }
}
