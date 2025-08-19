package org.example.pages;

import org.example.utilities.BaseLogger;
import org.example.utilities.ConfigReader;
import org.example.utilities.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class LoginPage extends BaseLogger {

    private WebDriver driver;
    String filepath = ConfigReader.getProperty("testData");
    //1. By Locators :
    private By SignInLink = By.xpath("//a[text()='Sign in']");
    private By Username = By.xpath("//input[@name='username']");
    private By Password = By.xpath("//input[@name='password']");
    private By LoginBtn = By.cssSelector("input[value='Login']");
    private By Alertmsg = By.id("id_username");
    
    String url = ConfigReader.getProperty("baseurl");


    //2. Constructor of the page class :
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }
    
    public void Loginurl()
    {
    	driver.get(url);
    }

    //3. page actions
    public void enterUserName(String un)
    {
        driver.findElement(Username).sendKeys(un);
    }

    public void enterPassword(String pwd)
    {
        driver.findElement(Password).sendKeys(pwd);
    }

    public  void clickOnLogin()
    {
        driver.findElement(LoginBtn).click();
    }
    public void performLoginDataDriven()
    {
        log.info("Performing Login with TestData from Excel");
        Map<String, String> loginData = ExcelReader.getDefaultLogin(filepath);
        String username = loginData.get("Username");
        String password = loginData.get("Password");
        driver.findElement(Username).sendKeys(username);
        driver.findElement(Password).sendKeys(password);
        driver.findElement(LoginBtn).click();
    }
    public void doLogin(String un, String pwd)
    {
        log.info("Performing Login");
        driver.findElement(Username).sendKeys(un);
        driver.findElement(Password).sendKeys(pwd);
        driver.findElement(LoginBtn).click();
    }

    public void InvalidLogin()
    {
    	log.info("Performing Login with TestData from Excel:");
        Map<String, String> loginData = ExcelReader.getRowByTestCaseId(filepath,"Login","TC01");
       
       String username = loginData.get("username");
       String password = loginData.get("password");
       driver.findElement(Username).sendKeys(username);
       driver.findElement(Password).sendKeys(password);
        
        driver.findElement(LoginBtn).click();
    }
    
    public void UsernameMissing()
    {
    	log.info("Performing Login with TestData from Excel:");
        Map<String, String> loginData = ExcelReader.getRowByTestCaseId(filepath,"Login","TC02");
       
       String username = loginData.get("username");
       String password = loginData.get("password");
       driver.findElement(Username).sendKeys(username);
       driver.findElement(Password).sendKeys(password);
        
        driver.findElement(LoginBtn).click();
    }
    
    public void Passwordmissing()
    {
    	log.info("Performing Login with TestData from Excel:");
        Map<String, String> loginData = ExcelReader.getRowByTestCaseId(filepath,"Login","TC03");
       
       String username = loginData.get("username");
       String password = loginData.get("password");
       driver.findElement(Username).sendKeys(username);
       driver.findElement(Password).sendKeys(password);
        
        driver.findElement(LoginBtn).click();
       
    }
    
    public void Invalidusername()
    {
    	log.info("Performing Login with TestData from Excel:");
        Map<String, String> loginData = ExcelReader.getRowByTestCaseId(filepath,"Login","TC04");
       
       String username = loginData.get("username");
       String password = loginData.get("password");
       driver.findElement(Username).sendKeys(username);
       driver.findElement(Password).sendKeys(password);
        
        driver.findElement(LoginBtn).click();
    	
    }
    
    public void Invalidpassword()
    {
    	log.info("Performing Login with TestData from Excel:");
        Map<String, String> loginData = ExcelReader.getRowByTestCaseId(filepath,"Login","TC05");
       
       String username = loginData.get("username");
       String password = loginData.get("password");
       driver.findElement(Username).sendKeys(username);
       driver.findElement(Password).sendKeys(password);
        
        driver.findElement(LoginBtn).click();
    	
    }
    
    public void alert()
    {
    	
    	WebElement field = driver.findElement(Alertmsg);
    	boolean isRequired = Boolean.parseBoolean(field.getAttribute("required"));
    	System.out.println("Is required? " + isRequired);
    	
    	Boolean valid = (Boolean) ((JavascriptExecutor) driver)
    	        .executeScript("return arguments[0].checkValidity();", field);

    	if (!valid) {
    	    String validationMessage = (String) ((JavascriptExecutor) driver)
    	        .executeScript("return arguments[0].validationMessage;", field);
    	    System.out.println("Browser says: " + validationMessage);
    	}
    }

}
