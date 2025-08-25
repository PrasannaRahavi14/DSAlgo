    package org.example.stepdefinitions;

	import java.util.Map;

    import org.example.factory.DriverFactory;
	import org.example.pages.HomePage;
	import org.example.pages.LandingPage;
	import org.example.pages.LoginPage;
    import org.example.utilities.ConfigReader;
    import org.example.utilities.ExcelReader;
    import org.openqa.selenium.WebDriver;
	import org.testng.Assert;

	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;

	public class HomeSteps {
		 WebDriver driver = DriverFactory.getDriver();
		 HomePage home = new HomePage(DriverFactory.getDriver());
	     LandingPage landingPage = new LandingPage(DriverFactory.getDriver());
		 LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
		
		

		
		@Given("The user is on dsAlgo portal page")
		public void the_user_is_on_ds_algo_portal_page() {
			 landingPage.getURL();

					}

		@When("The user click Get started button")
		public void the_user_click_get_started_button() {
			
			landingPage.clickGetStartedBtn();

		}

		@Then("The user should be redireced to Home page to verify NumbyNinja")
		public void the_user_should_be_redireced_to_home_page_to_verify_numby_ninja() {
			 
			
			String expectedTitle=home.titleNumby();
			Assert.assertEquals(expectedTitle, "NumpyNinja");
			}
		@Given("The user is on the Home page")
		public void the_user_is_on_the_home_page() {
			landingPage.getURL();
			landingPage.clickGetStartedBtn();
		   
		}
		@When("The user clicks on Get Started link on homepage {string} without login")
		public void the_user_clicks_on_get_started_link_on_homepage_without_login(String option) {
			
			switch(option) {
			case "Datastructures" :
				home.clickGetStartedForDS();
				break;
			case "Array" :
				home.clickGetStartedForArray(); 
				break;
			case "Linkedlist" :
				home.clickGetStartedForLinkedList(); 
				break;
			case "Stack" :
				home.clickGetStartedForStack();
				break;
			case "Queue" :
				home.clickGetStartedForQueue();
				break;
			case "Tree" :
				home.clickGetStartedForTree();
				break;
			case "Graph" :
				home.clickGetStartedForGraph(); 
				break;
			}		
			
		}
		@When("The user clicks on {string} from dropdown on home page without Sign in")
		public void the_user_clicks_on_from_dropdown_on_home_page_without_sign_in(String option) {
			home.clickDrpdown();
			
			switch(option) {
			case "Array" :
				home.clickArraysDrpdown();
				break;
			case "Linkedlist" :
				home.clickLinkedListDrpdown();
				break;
			case "Stack" :
				home.clickStackDrpdown();
				break;
			case "Queue" :
				home.clickQueueDrpdown(); 
				break;
			case "Tree" :
				home.clickTreeDrpdown();
				break;
			case "Graph" :
				home.clickGraphDrpdown();
				break;
			}		
		    
		}

		@Then("The user get warning message {string}")
		public void the_user_get_warning_message(String string) {
			home.getErrorMessageText();
		}
		@Given("The user successfully sign in {string} and {string}")
		public void the_user_successfully_sign_in_and(String UserName, String Password) {
			/*landingPage.getURL();
			landingPage.clickGetStartedBtn();
			   home.clickSignIn();
			   Map<String, String> loginData = ExcelReader.getDefaultLogin(filePath);
			   loginpage.doLogin(loginData.get("Username"),loginData.get("Password"));*/
			loginpage.Login();
			   
		}

		

		@When("The user clicks {string} button under {string} page")
		public void the_user_clicks_button_under_page(String button,String module) {
			switch(module) {
			case "Datastructures" :
				home.clickDataStructureAftsign();
				break;
			case "Array" :
				home.clickArrayAftsign();
				break;
			case "Linkedlist" :
			    home.clickLinkedListAftsign();
			    break;
		    case "Stack" :
			    home.clickStackAftsign();
			    break;
		    case "Queue" :
				home.clickQueueAftsign();
				break;
			case "Tree" :
				home.clickTreeAftsign();
				break;
			case "Graph" :
				home.clickGraphAftsign();
				break;
		   		}
		}

		@Then("The user should be directed to {string} page to verify the title")
		public void the_user_should_be_directed_to_page_to_verify_the_title(String module) {
			switch(module)
			{
			case "Datastructures" :
				String titleDSI=home.getDataStructuretitle();
				Assert.assertEquals(titleDSI, "Data Structures-Introduction");
				break;
			case "Array" :
				String titleArray=home.getArraytitle();
				Assert.assertEquals(titleArray, "Array");
				break;
			case "Linkedlist" :
				String titleLL=home.getLinkedListtitle();
				Assert.assertEquals(titleLL, "Linked List");
				break;
			case "Stack" :
				String titleStack=home.getStacktitle();
				Assert.assertEquals(titleStack, "Stack");
				break;
			case "Queue" :
				String titleQueue=home.getQueuetitle();
				Assert.assertEquals(titleQueue, "Queue");
				break;
			case "Tree" :
				String titleTree=home.getTreetitle();
				Assert.assertEquals(titleTree, "Tree");
				break;
			case "Graph" :
				String titleGraph=home.getGraphtitle();
				Assert.assertEquals(titleGraph, "Graph");
				break;
			}
			
			
		}
		@When("The user clicks on {string} from dropdown on home page after Sign in")
		public void the_user_clicks_on_from_dropdown_on_home_page_after_sign_in(String module) {
			home.clickDrpdown();
			switch(module) {
			case "Array" :
				home.clickArraysDrpdown();
				break;
			case "Linkedlist" :
				home.clickLinkedListDrpdown();
				break;
			case "Stack" :
				home.clickStackDrpdown();
				break;
			case "Queue" :
				home.clickQueueDrpdown(); 
				break;
			case "Tree" :
				home.clickTreeDrpdown();
				break;
			case "Graph" :
				home.clickGraphDrpdown();
				break;
			}		
			
			
		    
		}


		@When("the user clicks Register button")
		public void the_user_clicks_register_button() {
		   home.clickRegister();
		}

       @Then("The user should be redirected to Register page to verify register button")
       public void the_user_should_be_redirected_to_register_page_to_verify_register_button() {
	   home.isRegisterElementDisplayed();
}

       @When("the user clicks Sign in button")
       public void the_user_clicks_sign_in_button() {
    	   home.clickSignIn();
          
       }

       @Then("The user should be redirected to sign in page to verify element displayed or not")
       public void the_user_should_be_redirected_to_sign_in_page_to_verify_element_displayed_or_not() {
    	   home.isSignInElementDisplayed();
            
       }	
       @When("The user click on Sign Out button from home page")
       public void the_user_click_on_sign_out_button_from_home_page() {
    	   home.clickSignOut();
           
       }

       @Then("The user can able to see {string} message")
       public void the_user_can_able_to_see_message(String actualtxt) {
    	   String expectedtxt=home.getSuccessMessageText();
			Assert.assertEquals(expectedtxt, "Logged out successfully");
    	   
                  }
       @Then("The user should be redireced to Home page and the page title should be {string}")
       public void the_user_should_be_redireced_to_home_page_and_the_page_title_should_not_be(String title) {
    	   String actualTitle =home.verifyIncorrectTitle();
       	String expectedTitle = "Data structure";
       	if (!actualTitle.equals(expectedTitle)) {
       	    Assert.fail("Condition failed: expected true but got false.");
       	}
       }


}
		

