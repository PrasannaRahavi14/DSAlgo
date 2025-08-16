package org.example.pages;


import java.util.NoSuchElementException;

import org.example.factory.DriverFactory;
import org.example.utilities.ConfigReader;
import org.example.utilities.ElementsUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Stackpage {
	
	private WebDriver driver;
    private By getStartedStackbtn = By.xpath("//a[@href='stack']");
    HomePage homePage = new HomePage(DriverFactory.getDriver());
    LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
    LandingPage landingpage = new LandingPage(DriverFactory.getDriver());
    String url = ConfigReader.getProperty("baseurl");
    private By stackpagetitle = By.xpath("//h4[@class='bg-secondary text-white']");
    private By operationspage = By.xpath("//a[contains(text(), 'Operations in Stack')]");
    private By tryherebtn = By.xpath("//a[@href='/tryEditor']");
    private By tryEditor = By.xpath("//div[@class='CodeMirror cm-s-default']");
    private By runBtn = By.cssSelector("button[type='button']");
    ElementsUtil elementsUtil;
    
    public Stackpage(WebDriver driver) {
        this.driver = driver;
    } 
    
    public void getStartedStack()
    {
      driver.get(url);
   	  landingpage.clickGetStartedBtn();
   	  homePage.clickSignInLink();
   	  loginpage.doLogin("Prasanna","Welcome@01");
   	  driver.findElement(getStartedStackbtn).click();
   	
    }
    
    public String getStackpagetitle()
    {
       return driver.findElement(stackpagetitle).getText();
    }
    
    public void getOperationsinstack()
    {
    	driver.findElement(operationspage);
    }
    
    public String getOperationspagetitle()
    {
    	return driver.findElement(operationspage).getText();
    }
    
    public void ClickTryherebtn()
    {
    	driver.findElement(tryherebtn).click();
    }
    
//    public void Click_TryEditor()
//    {
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(pwdMismatchAlertmsg));
//        return alert.getText();
    
    public boolean tryEditorRunBtnVisible() {
        try {
            return elementsUtil.isElementDisplayed(tryEditor) && elementsUtil.isElementDisplayed(runBtn);
        } catch (NoSuchElementException e) {
            return false; // Element(s) not found
        }

    }}