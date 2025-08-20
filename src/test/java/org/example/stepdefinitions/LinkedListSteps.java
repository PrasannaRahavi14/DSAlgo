package org.example.stepdefinitions;

import java.util.Map;

import org.example.factory.DriverFactory;
import org.example.pages.HomePage;
import org.example.pages.LandingPage;
import org.example.pages.LinkedListPage;
import org.example.pages.LoginPage;
import org.example.utilities.BaseLogger;
import org.example.utilities.ConfigReader;
import org.example.utilities.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LinkedListSteps extends BaseLogger {
	 WebDriver driver = DriverFactory.getDriver();
	 HomePage home = new HomePage(DriverFactory.getDriver());
	 LandingPage landingPage = new LandingPage(DriverFactory.getDriver());
	 LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	 LinkedListPage linkedlistpage = new LinkedListPage(DriverFactory.getDriver());
	 String url = ConfigReader.getProperty("baseurl");
	 private final String filePath = "src/test/resources/testdata/TestData1.xlsx";

	
	

@Given("the user in Linked List page after signed in")
public void the_user_in_linked_list_page_after_signed_in() {
	
	landingPage.getURL();;
	landingPage.clickGetStartedBtn();
	home.clickSignIn();
	Map<String, String> loginData = ExcelReader.getDefaultLogin(filePath);
    loginpage.doLogin(loginData.get("Username"),loginData.get("Password"));
	
     home.clickGetStartedForLinkedList();
	   }

@When("The user clicks on {string} link on Linked List module")
public void the_user_clicks_on_introduction_link_on_linked_list_module(String option) {
	linkedlistpage.clickLinkFromLL(option);
}
   
@Then("The user should navigate to {string} page in Linked List module")
public void the_user_should_navigate_to_page_in_linked_list_module(String option) {
   
	String pageTitle=linkedlistpage.getLinksTitle(option);
	log.info("Verifying the title of " +option + " : Page Title value: "+pageTitle);
   Assert.assertEquals(pageTitle, option);
}

@When("The user clicks on Try here button of {string} Page")
public void the_user_clicks_on_try_here_button_of_page(String string) {
	linkedlistpage.clickTryHereButton();
	
}

@Then("The user should be directed to Try editor page with run button of each {string} page")
public void the_user_should_be_directed_to_try_editor_page_with_run_button_of_each_page(String string) {
	linkedlistpage.istryEditorDisplayed();
}

@Given("The user is in try editor with {string} page from the Linked List module")
public void the_user_is_in_try_editor_with_page_from_the_linked_list_module(String option) {
   linkedlistpage.clickLinkFromLL(option);
   linkedlistpage.clickTryHereButton();
}

@When("The user gives valid python code and clicks Run button from the Try editor")
public void the_user_gives_valid_python_code_and_clicks_run_button_from_the_try_editor() {
	
    linkedlistpage.enterPythonCode(linkedlistpage.getPythonCodeFromExcel());
    linkedlistpage.clickRunButton();
}

@Then("The user can able to see the output from the console window")
public void the_user_can_able_to_see_the_output_from_the_console_window() {
	String actualresult=linkedlistpage.getOutputFromConsole();
	String expectedresult=linkedlistpage.getOutputDataDriven();
	Assert.assertEquals(actualresult, expectedresult);
    log.info("Actual result matched with expected Result");
}
@When("The user gives Invalid python code and clicks Run button from the Try editor")
public void the_user_gives_invalid_python_code_and_clicks_run_button_from_the_try_editor() {
	
    linkedlistpage.enterPythonCode(linkedlistpage.getInvalidPythonCodeFromExcel());
    linkedlistpage.clickRunButton();
    
   }

@Then("The user can able to see the alert window in the Linked list try editor page")
public void the_user_can_able_to_see_the_alert_window_in_the_linked_list_try_editor_page() {
	log.error("Alert window displayed");
	linkedlistpage.alertwindow();
	String actualOutput=linkedlistpage.alertwindow();
	String expectedOutput=linkedlistpage.getAlertOutputFromDataDriven();
	Assert.assertEquals(actualOutput, expectedOutput);
    log.info("Actual result matched with expected Result");
}	
@Given("The user clicks on Introduction link from Linked List module")
public void the_user_clicks_on_introduction_link_from_linked_list_module() {
    linkedlistpage.clickIntrolink();
}

@When("The user clicks on practice questions link from Introduction page")
public void the_user_clicks_on_practice_questions_link_from_introduction_page() {
    linkedlistpage.clickPracticeQuestionsLink();
}

@Then("The user can able to land on practice page with empty content")
public void the_user_can_able_to_land_on_practice_page_with_empty_content() {
	linkedlistpage.isPracticePageDisplayed();
    
}


	
}







