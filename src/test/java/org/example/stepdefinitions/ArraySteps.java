package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.factory.DriverFactory;
import org.example.pages.*;
import org.example.utilities.BaseLogger;
import org.example.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ArraySteps extends BaseLogger {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
    LandingPage landingpage = new LandingPage(DriverFactory.getDriver());
    HomePage homePage = new HomePage(DriverFactory.getDriver());
    ArrayPage arrayPage = new ArrayPage(DriverFactory.getDriver());
    String url = ConfigReader.getProperty("baseurl");


    @Given("User is in Array page after successful login")
    public void userIsInArrayPageAfterSuccessfulLogin() {
        log.info("Executing the Background Scenario : Navigating to the Array Page");
        landingpage.getURL();
        landingpage.clickGetStartedBtn();
        homePage.clickSignInLink();
        loginpage.performLoginDataDriven();
        homePage.clickGetStartedForArray();
        log.info ("Background Scenario executed successfully : Landed in Array Page");
    }

    @When("User clicks {string} hyperlink")
    public void userClicksHyperlink(String ArrayTopics) {
        arrayPage.clickArrayTopicLink(ArrayTopics);
    }

    @Then("User should be redirected to {string} page")
    public void userShouldBeRedirectedToPage(String inArrayTopicsPage) {
        Assert.assertEquals(arrayPage.validateTitle(inArrayTopicsPage),inArrayTopicsPage);
            }

    @Given("User is on the Arrays in Python page after clicking {string}")
    public void userIsOnTheArraysInPythonPageAfterClicking(String ArrayTopics) {
        arrayPage.clickArrayTopicLink(ArrayTopics);
    }

    @When("User scrolls down to the bottom and click on Try here button")
    public void userScrollsDownToTheBottomAndClickOnTryHereButton() {
        arrayPage.clickTryHereBtn();
    }

    @Then("User should be redirected to Try Editor page")
    public void userShouldBeRedirectedToTryEditorPage() {
        log.info("Checking the Run button is available");
        Assert.assertTrue(arrayPage.runBtnVisible(),"Run button not visible");
    }

    @Given("User is on Try Editor page")
    public void userIsOnTryEditorPage() {
        log.info("Checking the Run button is available");
    }

    @When("User enters valid python code and click Run")
    public void userEntersValidPythonCodeAndClickRun() {
        log.info("Entering valid python code in the editor : "+arrayPage.getPythonCodeDataDriven());
        arrayPage.enterPythonCode(arrayPage.getPythonCodeDataDriven());
        log.info("Clicking on Run button");
        arrayPage.clickRunBtn();
    }

    @Then("User should be able to see the output")
    public void userShouldBeAbleToSeeTheOutput() {
        String actualOutput = arrayPage.getOutputFromConsole();
        log.info("Output printed in the console : "+actualOutput);
        String expectedOutput = arrayPage.getOutputDataDriven();
        log.info("Expected Output : "+expectedOutput);
        Assert.assertEquals(actualOutput,expectedOutput);
        log.info("Actual Output matched with the Expected Output");
    }

    @Given("User is on Try Editor page of the topic {string}")
    public void userIsOnTryEditorPageOfTheTopic(String ArrayTopics) {
        arrayPage.clickArrayTopicLink(ArrayTopics);
        arrayPage.clickTryHereBtn();
        log.info("Checking the Run button is available");
    }

    @When("User enters invalid python code and click Run")
    public void userEntersInvalidPythonCodeAndClickRun() {
        log.info("Entering invalid python code in the editor : "+arrayPage.getInvalidCodeDataDriven());
        arrayPage.enterPythonCode(arrayPage.getInvalidCodeDataDriven());
        log.info("Clicking on Run button");
        arrayPage.clickRunBtn();
    }

    @Then("the user should see the error popup {string}")
    public void theUserShouldSeeTheErrorPopup(String expectedErrorMsg) {
        Assert.assertEquals(arrayPage.getAlertPopup(),arrayPage.getInvalidCodeOutput());
    }

    @Then("the user should see the error popup")
    public void theUserShouldSeeTheErrorPopup() {
        Assert.assertEquals(arrayPage.getAlertPopup(),arrayPage.getInvalidCodeOutput());
    }

    @When("User clicks on Practice Questions hyperlink")
    public void userClicksOnPracticeQuestionsHyperlink() {
        log.info("Clicking Practice Questions hyperlink");
       arrayPage.clickPracticeQuestions();
    }

    @Then("User should be redirected to Practice Questions page")
    public void userShouldBeRedirectedToPracticeQuestionsPage() {
        log.info("Checking for Practice Questions page");
        Assert.assertEquals(arrayPage.practiceQuestionsPageVisibility(),"Search the array");
    }

     @When("User clicks {string} option in Practice Questions page")
    public void userClicksOptionInPracticeQuestionsPage(String practiceQuestionsTopic) {
         arrayPage.clickPracticeQuestionsArrayTopicLink(practiceQuestionsTopic);
    }

    @Then("User should be redirected to Run page")
    public void userShouldBeRedirectedToRunPage() {
        log.info("Checking the Run button is available");
        Assert.assertTrue(arrayPage.runBtnVisible(),"Run button not visible");
    }

    @Given("User is in Practice Questions page under {string}")
    public void userIsInPracticeQuestionsPageUnder(String ArrayTopics) {
        arrayPage.clickArrayTopicLink(ArrayTopics);
        log.info("Clicking Practice Questions hyperlink");
        arrayPage.clickPracticeQuestions();
    }

    @Given("User is on Run page under the Array topic {string} and Practice Questions option {string}")
    public void userIsOnRunPageUnderTheArrayTopicAndPracticeQuestionsOption(String ArrayTopics, String practiceQuestionsTopic) {
        arrayPage.clickArrayTopicLink(ArrayTopics);
        log.info("Clicking Practice Questions hyperlink");
        arrayPage.clickPracticeQuestions();
        log.info("Clicking " + practiceQuestionsTopic + " hyperlink");
        arrayPage.clickPracticeQuestionsArrayTopicLink(practiceQuestionsTopic);
    }
}
