package org.example.stepdefinitions;

import org.example.factory.DriverFactory;
import org.example.pages.Stackpage;
import org.example.utilities.BaseLogger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StackStepdef extends BaseLogger {
	WebDriver driver = DriverFactory.getDriver();
	  Stackpage stackpage = new Stackpage(DriverFactory.getDriver());
	  
	  @Given("the user is on the Stack Page")
	  public void the_user_is_on_the_stack_page() {
		  stackpage.getStartedStack();
		  String title_stackpage = stackpage.getStackpagetitle();
		  System.out.println("Title of the Page: " + title_stackpage);
		  Assert.assertEquals(title_stackpage,"Stack");

	  }

	  @When("the user clicks on {string} link")
	  public void the_user_clicks_on_link(String string) {
		  stackpage.getOperationsinstack();
	  }

	  @Then("the user The user should be redirected to {string} page")
	  public void the_user_the_user_should_be_redirected_to_page(String Expectedpage) {
		  String Actualpage = stackpage.getOperationspagetitle();
			System.out.println("Actual message: " + Actualpage);
			Assert.assertEquals(Actualpage, Expectedpage);
	  }

	  @Given("the user is on Operations in Stack page")
	  public void the_user_is_on_operations_in_stack_page() {
		  stackpage.getStackpagetitle();
	  }

	  @Then("the user should be redirected to a page having an try Editor with a Run button to test")
	  public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button_to_test() {
		  log.info("Checking the try editor code block is available");
	       Assert.assertTrue(stackpage.tryEditorVisible(),"Try Editor Code block not available");
	       log.info("Checking the Run button is available");
	       Assert.assertTrue(stackpage.runBtnVisible(),"Run button not visible");
	  }
}
