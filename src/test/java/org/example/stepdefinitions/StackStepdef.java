package org.example.stepdefinitions;

import org.example.factory.DriverFactory;
import org.example.pages.Stackpage;
import org.example.utilities.BaseLogger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StackStepdef extends BaseLogger{
	WebDriver driver = DriverFactory.getDriver();
	  Stackpage stackpage = new Stackpage(DriverFactory.getDriver());
	 	 
	@Given("the user is on the Stack Page")
	  public void the_user_is_on_the_stack_page() {
		  stackpage.getStartedStack();
		  String title_stackpage = stackpage.getStackpagetitle();
		 log.info("Title of the Page is : " + title_stackpage);
		        
	  }
	  
	  @When("the user clicks on {string} link")
	  public void the_user_clicks_on_link(String string) {
	      stackpage.getOperationsinstack();
	  }

	  @Then("the user The user should be redirected to {string} page")
	  public void the_user_the_user_should_be_redirected_to_page(String Expectedpage) {
		  String Actualpage = stackpage.getOperationspagetitle();
		  Assert.assertEquals(Expectedpage, Actualpage);
			
	  }

	  @Given("the user is on {string} page")
	  public void the_user_is_on_page(String topic) { 
		  stackpage.clickTopicLink(topic);
	       Assert.assertEquals(stackpage.validateTitle(topic),"Operations in Stack");
	  }
	  
	  @When("the user clicks the Try Here button on operations in stackpage")
	  public void the_user_clicks_the_try_here_button_on_operations_in_stackpage(){
	      stackpage.clickTryHereBtn();
	  }
	  
	  @Then("the user should be redirected to a page having an try Editor with a Run button to test")
	  public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button_to_test() {
		  log.info("Checking the try editor code block is available");
	        Assert.assertTrue(stackpage.tryEditorVisible(),"Try Editor Code block not available");
	        log.info("Checking the Run button is available");
	        Assert.assertTrue(stackpage.runBtnVisible(),"Run button not visible"); 
	  }
	  
	  @Given("the user is on TryEditor page of {string}")
	  public void the_user_is_on_try_editor_page_of(String string) {
		  stackpage.getOperationsinstack();
	      stackpage.clickTryHereBtn();
	      log.info("User is on TryEditor page");
       
	  }
	  @When("the user write the valid code in Editor and click the {string} button")
	  public void the_user_write_the_valid_code_in_editor_and_click_the_button(String string) {
		  log.info("Entering the Python Code in the editor "+ stackpage.getPythonCodeDataDriven());
		  stackpage.enterPythonCode(stackpage.getPythonCodeDataDriven());
	      log.info("Clicking on Run button");
	      stackpage.ClickRun();
	  }

	  @Then("The user should able to see output in the console below")
	  public void the_user_should_able_to_see_output_in_the_console_below() {
		  String actualOutput = stackpage.getOutputFromConsole();
	        log.info("Output printed in the console : "+actualOutput);
	        String expectedOutput = stackpage.getOutputDataDriven();
	        log.info("Expected Output : "+expectedOutput);
	        Assert.assertEquals(actualOutput,expectedOutput);
	        log.info("Actual Output matched with the Expected Output");
	  }
	  
	  @When("the user write the invalid code in Editor and click the {string} button")
	  public void the_user_write_the_invalid_code_in_editor_and_click_the_button(String string) {
		  log.info("Entering the Python Code in the editor "+ stackpage.getInvalidCodeDataDriven());
	        stackpage.enterPythonCode(stackpage.getInvalidCodeDataDriven());
	        log.info("Clicking on Run button");
	        stackpage.ClickRun(); 
	  }

	  @Then("The user should able to see an {string} in alert window")
	  public void the_user_should_able_to_see_an_in_alert_window(String string) {
    	  
    	  log.error("<------Test Error----->");
    	  stackpage.Alertmessage();
      }
	  
	  @Given("the user is on the TryEditor page of {string}")
	  public void the_user_is_on_the_try_editor_page_of(String option) {
		  stackpage.StackTopics(option);
	      stackpage.clickTryHereBtn();
	      
	  }

	  @When("the user input the valid python code and clicks run button")
	  public void the_user_input_the_valid_python_code_and_clicks_run_button() {
		  log.info("Entering the Python Code in the editor "+ stackpage.getInvalidCodeDataDriven());
	        stackpage.enterPythonCode(stackpage.getInvalidCodeDataDriven());
	      log.info("Clicking on Run button");
	      stackpage.ClickRun();
	  }

	  @Then("the user should be able to see the output from the console")
	  public void the_user_should_be_able_to_see_the_output_from_the_console() {
		  String actualOutput = stackpage.getOutputFromConsole();
	        log.info("Output printed in the console : "+actualOutput);
	        String expectedOutput = stackpage.getOutputDataDriven();
	        log.info("Expected Output : "+expectedOutput);
	        Assert.assertEquals(actualOutput,expectedOutput);
	        log.info("Actual Output matched with the Expected Output");
	  }
	  
	  @When("the user input the invalid python code and clicks run button")
	  public void the_user_input_the_invalid_python_code_and_clicks_run_button() {
		  log.info("Entering the Python Code in the editor "+ stackpage.getInvalidCodeDataDriven());
	        stackpage.enterPythonCode(stackpage.getInvalidCodeDataDriven());
	        log.info("Clicking on Run button");
	        stackpage.ClickRun();   
		  }
}
