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

    @Given("User is in Home page after successful sign-in")
    public void userIsInHomePageAfterSuccessfulSignIn() {
        String title_hp = homePage.getTitle();
        Assert.assertEquals(title_hp, "NumpyNinja");
        Assert.assertEquals(homePage.CheckName(), "Prasanna");

        //String loginConfirmation_Text= ArrayPage.LoginConfirmation();
        //Assert.assertEquals(loginConfirmation_Text, "You are logged in");
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

    @Given("User is in Array page after successful login")
    public void userIsInArrayPageAfterSuccessfulLogin() {
        log.info("Executing the Background Scenario : Navigating to the Array Page");
        landingpage.getURL();
        Assert.assertEquals(landingpage.getTitle(), "Preparing for the Interviews");
        landingpage.clickGetStartedBtn();
        Assert.assertEquals(homePage.getTitle(), "NumpyNinja");
        homePage.clickSignInLink();
        loginpage.performLoginDataDriven();
        Assert.assertEquals(homePage.CheckName(), "Prasanna");
        homePage.clickGetStartedForArray();
        Assert.assertEquals(arrayPage.getTitleforArrayPage(),"Array");
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
        //log.info("Checking the try editor code block is available");
        //Assert.assertTrue(arrayPage.tryEditorVisible(),"Try Editor Code block not available");
        log.info("Checking the Run button is available");
        Assert.assertTrue(arrayPage.runBtnVisible(),"Run button not visible");
    }

    @Given("User is on Try Editor page")
    public void userIsOnTryEditorPage() {
        log.info("Checking the Run button is available");
        Assert.assertTrue(arrayPage.runBtnVisible(),"Run button not visible");
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
        Assert.assertTrue(arrayPage.runBtnVisible(),"Run button not visible");
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
}
