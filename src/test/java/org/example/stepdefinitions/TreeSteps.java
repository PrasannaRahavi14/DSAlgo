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
        log.info("Executing the Background Scenario : Navigating to the DataStructure Page");
        landingpage.getURL();
        Assert.assertEquals(landingpage.getTitle(), "Preparing for the Interviews");
        landingpage.clickGetStartedBtn();
        Assert.assertEquals(homePage.getTitle(), "NumpyNinja");
        homePage.clickSignInLink();
        loginpage.performLoginDataDriven();
        Assert.assertEquals(homePage.CheckName(), "Prasanna");
        homePage.clickGetStartedForTree();
        Assert.assertEquals(treePage.getTitleforTree(),"Tree");
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
        Assert.assertTrue(treePage.tryEditorVisible(),"Try Editor Code block not available");
        Assert.assertTrue(treePage.runBtnVisible(),"Run button not visible");

    }

    @When("The user inputs the valid python code and clicks run button")
    public void theUserInputsTheValidPythonCodeAndClicksRunButton() {
        log.info("Entering the Python Code in the editor "+treePage.getPythonCodeDataDriven());
        treePage.enterPythonCode(treePage.getPythonCodeDataDriven());
        log.info("Clicking on Run button");
        treePage.clickRunBtn();
    }

    @Then("The user should be able to see the output from the console")
    public void theUserShouldBeAbleToSeeTheOutputFromTheConsole() {
        String actualOutput = treePage.getOutputFromConsole();
        log.info("Output printed in the console : "+actualOutput);
        String expectedOutput = treePage.getOutputDataDriven();
        log.info("Expected Output : "+expectedOutput);
        Assert.assertEquals(actualOutput,expectedOutput);
        log.info("Actual Output matched with the Expected Output");
    }
}
