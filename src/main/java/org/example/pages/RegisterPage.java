package org.example.pages;

import java.util.Map;

import org.example.utilities.BaseLogger;
import org.example.utilities.ConfigReader;
import org.example.utilities.ElementsUtil;
import org.example.utilities.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BaseLogger {

	private WebDriver driver;
	ElementsUtil elementsUtil;
	private By getTitle_DSI = By.cssSelector("h4[class='bg-secondary text-white']");
	private By getTitleRegisterpage = By.xpath("//title[contains(text(), ' Registration ')]");
	private By getRegister_Page = By.cssSelector("a[href='/register']");
	private By username = By.id("id_username");
	private By password = By.id("id_password1");
	private By pwdconfirmation = By.id("id_password2");
	private By pwdMismatchAlertmsg = By.xpath("//div[@role='alert']");
	private By NewAccountAlertmsg = By.xpath("//div[contains(@class,'alert') and contains(text(),'New Account Created')]");
	private By LoginLink = By.xpath("(//a[@href='/login'])[2]");
	private By Loginpage = By.xpath("//a[contains(text(), 'NumpyNinja')]");
	String filepath = ConfigReader.getProperty("testData");		
    
	public RegisterPage(WebDriver driver) {
    this.driver = driver;
    this.elementsUtil = new ElementsUtil(driver);
   
    }

    public String getTitleforDSI()
    {
  return driver.findElement(getTitle_DSI).getText();
    }
    
    public String getTitleRegisterpage()
    {
    	log.info("Getting the title of RegisterPage");
    	return driver.findElement(getTitleRegisterpage).getText();
    }
    public boolean getRegister()
    {
    	return driver.findElement(getRegister_Page).isEnabled();
    }
   
    public boolean isRegisterPageDisplayed() {
    	
        return driver.findElement(Loginpage).isDisplayed();
    }
    
    public void getEmptyValues()
    {
    	log.info("Performing Register with TestData from Excel:");
        Map<String, String> RegisterData = ExcelReader.getRowByTestCaseId(filepath,"Register","EmptyValues");       
        String username = RegisterData.get("username");
        String password = RegisterData.get("password");
        String pwdconfirmation = RegisterData.get("password confirmation");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		System.out.println("Username is: " + username);
		System.out.println("Password is: " + password);
		System.out.println("Password Confirmation is: " + pwdconfirmation);
    
    }

    public void getUsernameValues()
    {
    	log.info("Performing Register with TestData from Excel:");
    	Map<String, String> RegisterData = ExcelReader.getRowByTestCaseId(filepath,"Register","UsernameValues");
    	String username = RegisterData.get("username");
        String password = RegisterData.get("password");
        String pwdconfirmation = RegisterData.get("password confirmation");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		System.out.println("Username is: " + username);
		System.out.println("Password is: " + password);
		System.out.println("Password Confirmation is: " + pwdconfirmation);
    }
    
    public String getUsernameValidationMessage()
    {
    	WebElement field = driver.findElement(username);
        return (String) ((JavascriptExecutor) driver)
            .executeScript("return arguments[0].validationMessage;", field);
    	
    }
    
    public By getusernamelocator() {
        return username;
    }
    
    public void getPasswordValues()
    {   
    	log.info("Performing Register with TestData from Excel:");
    	Map<String, String> RegisterData = ExcelReader.getRowByTestCaseId(filepath,"Register","PasswordValues");
    	String username = RegisterData.get("username");
        String password = RegisterData.get("password");
        String pwdconfirmation = RegisterData.get("password confirmation");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		System.out.println("Username is: " + username);
		System.out.println("Password is: " + password);
		System.out.println("Password Confirmation is: " + pwdconfirmation);
		
    }
    
    public String getPaswordValidationMessage()
    {
    	WebElement field = driver.findElement(password);
        return (String) ((JavascriptExecutor) driver)
            .executeScript("return arguments[0].validationMessage;", field);
    	
    }
  
    public By getPasswordlocator() {
        return password;
    } 

    public void getNoPasswordConfirmation()
    {
    	log.info("Performing Register with TestData from Excel:");
    	Map<String, String> RegisterData = ExcelReader.getRowByTestCaseId(filepath,"Register","NoPasswordConfirmation");
    	String username = RegisterData.get("username");
        String password = RegisterData.get("password");
        String pwdconfirmation = RegisterData.get("password confirmation");
    	driver.findElement(By.xpath("//input[@value='Register']")).click();
    	System.out.println("Username is: " + username);
		System.out.println("Password is: " + password);
		System.out.println("Password Confirmation is: " + pwdconfirmation);
    }
    
    public String getPwdConfimationValidationMessage()
    {
    	WebElement field = driver.findElement(pwdconfirmation);
        return (String) ((JavascriptExecutor) driver)
            .executeScript("return arguments[0].validationMessage;", field);
    	
    }
    
    public By getPwdConfirmationlocator() {
        return pwdconfirmation;
    }
    
    public void getValidCredentials()
    {
  	    log.info("Performing Register with TestData from Excel:");
    	Map<String, String> RegisterData = ExcelReader.getRowByTestCaseId(filepath,"Register","ValidCredentials");
    	String username = RegisterData.get("username");
        String password = RegisterData.get("password");
        String pwdconfirmation = RegisterData.get("password confirmation");
    	driver.findElement(By.xpath("//input[@value='Register']")).click();
    	System.out.println("Username is: " + username);
		System.out.println("Password is: " + password);
		System.out.println("Password Confirmation is: " + pwdconfirmation);
    	
    }
    
    public String getNewAccountAlertmsg()
    {
    	WebElement field = driver.findElement(NewAccountAlertmsg);
        return (String) ((JavascriptExecutor) driver)
            .executeScript("return arguments[0].validationMessage;", field);
    	
    }
    
    public By getNewAccountAlertlocator() {
        return NewAccountAlertmsg;
    } 
    
    public void getMismatchPassword()
    {
    	log.info("Performing Register with TestData from Excel:");
     	Map<String, String> RegisterData = ExcelReader.getRowByTestCaseId(filepath,"Register","MismatchPassword");
     	String username = RegisterData.get("username");
        String password = RegisterData.get("password");
        String pwdconfirmation = RegisterData.get("password confirmation");
     	driver.findElement(By.xpath("//input[@value='Register']")).click();
     	System.out.println("Username is: " + username);
 		System.out.println("Password is: " + password);
 		System.out.println("Password Confirmation is: " + pwdconfirmation);
 	
    }
    
    public String getPwdMismatchAlertmsg()
    {
    	WebElement field = driver.findElement(pwdMismatchAlertmsg);
        return (String) ((JavascriptExecutor) driver)
            .executeScript("return arguments[0].validationMessage;", field);
		
    }
    
    public By getPwdMismatchAlertlocator() {
        return pwdMismatchAlertmsg;
    }
    
    public void getInvalidUsername()
    {
    	log.info("Performing Register with TestData from Excel:");
     	Map<String, String> RegisterData = ExcelReader.getRowByTestCaseId(filepath,"Register","InvalidUsername");
     	String username = RegisterData.get("username");
        String password = RegisterData.get("password");
        String pwdconfirmation = RegisterData.get("password confirmation");
     	driver.findElement(By.xpath("//input[@value='Register']")).click();
     	System.out.println("Username is: " + username);
 		System.out.println("Password is: " + password);
 		System.out.println("Password Confirmation is: " + pwdconfirmation);
    }
        
    public void getPwdNumericValue()
    {
    	log.info("Performing Register with TestData from Excel:");
     	Map<String, String> RegisterData = ExcelReader.getRowByTestCaseId(filepath,"Register","PwdNumericValue");
     	String username = RegisterData.get("username");
        String password = RegisterData.get("password");
        String pwdconfirmation = RegisterData.get("password confirmation");
     	driver.findElement(By.xpath("//input[@value='Register']")).click();
     	System.out.println("Username is: " + username);
 		System.out.println("Password is: " + password);
 		System.out.println("Password Confirmation is: " + pwdconfirmation);
    }
    
    public void getClickLoginLink()
    {
    	
    	driver.findElement(LoginLink).click();
    }
   
    public boolean isLoginPageDisplayed() {
    	
        return driver.findElement(Loginpage).isDisplayed();
    }

}
