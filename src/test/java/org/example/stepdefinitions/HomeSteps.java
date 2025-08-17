    package org.example.stepdefinitions;

	import org.example.factory.DriverFactory;
	import org.example.pages.HomePage;
	import org.example.pages.LandingPage;
	import org.example.pages.LoginPage;
	import org.openqa.selenium.WebDriver;
	import org.testng.Assert;

	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;

	public class HomeSteps {
		 WebDriver driver = DriverFactory.getDriver();
		 HomePage home = new HomePage(DriverFactory.getDriver());
	//	 Home home = new Home(DriverFactory.getDriver());
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
				home.clickArrayGet(); 
				break;
			case "Linkedlist" :
				home.clickLinkedListGet(); 
				break;
			case "Stack" :
				home.clickStackGet();
				break;
			case "Queue" :
				home.clickQueueGet(); 
				break;
			case "Tree" :
				home.clickGetStartedForTree();
				break;
			case "Graph" :
				home.clickGraphGet(); 
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
		public void the_user_successfully_sign_in_and(String userName, String password) {
			landingPage.getURL();
			landingPage.clickGetStartedBtn();
			   home.clickSignIn();
			   loginpage.doLogin(userName, password);
		}

		

		@When("The user clicks {string} button under {string} page")
		public void the_user_clicks_button_under_page(String button,String module) {
			switch(module) {
			case "Datastructures" :
				home.clickDSAftsign();
				break;
			case "Array" :
				home.clickAAftsign();
				break;
			case "Linkedlist" :
			    home.clickLLAftsign();
			    break;
		    case "Stack" :
			    home.clickSAftsign();
			    break;
		    case "Queue" :
				home.clickQAftsign();
				break;
			case "Tree" :
				home.clickTAftsign();
				break;
			case "Graph" :
				home.clickGAftsign();
				break;
		   		}
		}

		@Then("The user should be directed to {string} page to verify the title")
		public void the_user_should_be_directed_to_page_to_verify_the_title(String module) {
			switch(module)
			{
			case "Datastructures" :
				String titleDSI=home.getDataStructuretitle();
				System.out.println("titleDSI-->"+titleDSI);
				Assert.assertEquals(titleDSI, "Data Structures-Introduction");
				System.out.println("titleDSI-->");
				
				break;
			case "Array" :
				String titleA=home.getArraytitle();
				System.out.println("titleA-->"+titleA);
				Assert.assertEquals(titleA, "Array");
				System.out.println("titleA-->");
				break;
			case "Linkedlist" :
				String titleLL=home.getLinkedListtitle();
				System.out.println("titleLL-->"+titleLL);
				Assert.assertEquals(titleLL, "Linked List");
				System.out.println("titleLL-->");
				
				break;
			case "Stack" :
				String titleS=home.getStacktitle();
				System.out.println("titleS-->"+titleS);
				Assert.assertEquals(titleS, "Stack");
				System.out.println("titleS-->");
				break;
			case "Queue" :
				String titleQ=home.getQueuetitle();
				System.out.println("titleQ-->"+titleQ);
				Assert.assertEquals(titleQ, "Queue");
				System.out.println("titleQ-->");
				
				break;
			case "Tree" :
				String titleT=home.getTreetitle();
				System.out.println("titleT-->"+titleT);
				Assert.assertEquals(titleT, "Tree");
				System.out.println("titleT-->");
				break;
			case "Graph" :
				String titleG=home.getGraphtitle();
				System.out.println("titleG-->"+titleG);
				Assert.assertEquals(titleG, "Graph");
				System.out.println("titleG-->");
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



			
		    
		}
		

