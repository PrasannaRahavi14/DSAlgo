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
	private By getRegister_Page = By.cssSelector("a[href='/register']");
	private By username = By.id("id_username");
	private By password = By.id("id_password1");
	private By pwdconfirmation = By.id("id_password2");
	private By pwdMismatchAlertmsg = By.cssSelector("div[role='alert']");
	private By NewAccountAlertmsg = By.xpath("//div[contains(@class,'alert') and contains(text(),'New Account Created')]");
	private By LoginLink = By.xpath("(//a[@href='/login'])[2]");
	private By Loginpage = By.xpath("//a[contains(text(), 'NumpyNinja')]");
	private By Registerbtn = By.xpath("//input[@value='Register']");
	String filepath = ConfigReader.getProperty("testData");		
    
	public RegisterPage(WebDriver driver) {
    this.driver = driver;
    this.elementsUtil = new ElementsUtil(driver);
   
    }
    public boolean getRegister()
    {
    	return driver.findElement(getRegister_Page).isEnabled();
    }
    
    public String ValidateTitleRegisterPage()
    {
    	return driver.findElement(getRegister_Page).getText();
    }
    public boolean isRegisterPageDisplayed() {
    	
        return driver.findElement(Loginpage).isDisplayed();
    }
    
   
    
    public void getEmptyValues()
    {
    	log.info("Performing Register with TestData from Excel:");
        Map<String, String> RegisterData = ExcelReader.getRowByTestCaseId(filepath,"Register","EmptyValues");       
        String Excelusername = RegisterData.get("username");
        String Excelpassword = RegisterData.get("password");
        String Excelpwdconfirmation = RegisterData.get("password confirmation");
        driver.findElement(username).sendKeys(Excelusername);
        driver.findElement(password).sendKeys(Excelpassword);
        driver.findElement(pwdconfirmation).sendKeys(Excelpwdconfirmation);
     	driver.findElement(Registerbtn).click();
     	System.out.println("Username is: " + Excelusername);
 		System.out.println("Password is: " + Excelpassword);
 		System.out.println("Password Confirmation is: " + Excelpwdconfirmation);
    
    }

    public void getUsernameValues()
    {
    	log.info("Performing Register with TestData from Excel:");
    	Map<String, String> RegisterData = ExcelReader.getRowByTestCaseId(filepath,"Register","UsernameValues");
    	String Excelusername = RegisterData.get("username");
        String Excelpassword = RegisterData.get("password");
        String Excelpwdconfirmation = RegisterData.get("password confirmation");
        driver.findElement(username).sendKeys(Excelusername);
        driver.findElement(password).sendKeys(Excelpassword);
        driver.findElement(pwdconfirmation).sendKeys(Excelpwdconfirmation);
     	driver.findElement(Registerbtn).click();
     	System.out.println("Username is: " + Excelusername);
 		System.out.println("Password is: " + Excelpassword);
 		System.out.println("Password Confirmation is: " + Excelpwdconfirmation);
    }
    
    public String getUsernameValidationMessage()
    {
    	WebElement field = driver.findElement(username);
        return (String) ((JavascriptExecutor) driver)
            .executeScript("return arguments[0].validationMessage;", field);	
    }

    public void getPasswordValues()
    {   
    	log.info("Performing Register with TestData from Excel:");
    	Map<String, String> RegisterData = ExcelReader.getRowByTestCaseId(filepath,"Register","PasswordValues");
    	String Excelusername = RegisterData.get("username");
        String Excelpassword = RegisterData.get("password");
        String Excelpwdconfirmation = RegisterData.get("password confirmation");
        driver.findElement(username).sendKeys(Excelusername);
        driver.findElement(password).sendKeys(Excelpassword);
        driver.findElement(pwdconfirmation).sendKeys(Excelpwdconfirmation);
     	driver.findElement(Registerbtn).click();
     	System.out.println("Username is: " + Excelusername);
 		System.out.println("Password is: " + Excelpassword);
 		System.out.println("Password Confirmation is: " + Excelpwdconfirmation);
		
    }
    
    public String getPaswordValidationMessage()
    {
    	WebElement field = driver.findElement(password);
        return (String) ((JavascriptExecutor) driver)
            .executeScript("return arguments[0].validationMessage;", field);
    	
    }

    public void getNoPasswordConfirmation()
    {
    	log.info("Performing Register with TestData from Excel:");
    	Map<String, String> RegisterData = ExcelReader.getRowByTestCaseId(filepath,"Register","NoPasswordConfirmation");
    	String Excelusername = RegisterData.get("username");
        String Excelpassword = RegisterData.get("password");
        String Excelpwdconfirmation = RegisterData.get("password confirmation");
        driver.findElement(username).sendKeys(Excelusername);
        driver.findElement(password).sendKeys(Excelpassword);
        driver.findElement(pwdconfirmation).sendKeys(Excelpwdconfirmation);
     	driver.findElement(Registerbtn).click();
     	System.out.println("Username is: " + Excelusername);
 		System.out.println("Password is: " + Excelpassword);
 		System.out.println("Password Confirmation is: " + Excelpwdconfirmation);
    }
    
    public String getPwdConfimationValidationMessage()
    {
    	WebElement field = driver.findElement(pwdconfirmation);
        return (String) ((JavascriptExecutor) driver)
            .executeScript("return arguments[0].validationMessage;", field);
    	
    }
    
    public void getValidCredentials()
    {
  	    log.info("Performing Register with TestData from Excel:");
    	Map<String, String> RegisterData = ExcelReader.getRowByTestCaseId(filepath,"Register","ValidCredentials");
    	String Excelusername = RegisterData.get("username");
        String Excelpassword = RegisterData.get("password");
        String Excelpwdconfirmation = RegisterData.get("password confirmation");
        driver.findElement(username).sendKeys(Excelusername);
        driver.findElement(password).sendKeys(Excelpassword);
        driver.findElement(pwdconfirmation).sendKeys(Excelpwdconfirmation);
     	driver.findElement(Registerbtn).click();
     	System.out.println("Username is: " + Excelusername);
 		System.out.println("Password is: " + Excelpassword);
 		System.out.println("Password Confirmation is: " + Excelpwdconfirmation);
    	
    }
    
    public String getNewAccountAlertmsg()
    {
    	WebElement field = driver.findElement(NewAccountAlertmsg);
        return (String) ((JavascriptExecutor) driver)
            .executeScript("return arguments[0].validationMessage;", field);
    	
    }
    
    public void getMismatchPassword()
    {
    	log.info("Performing Register with TestData from Excel:");
     	Map<String, String> RegisterData = ExcelReader.getRowByTestCaseId(filepath,"Register","MismatchPassword");
     	String Excelusername = RegisterData.get("username");
        String Excelpassword = RegisterData.get("password");
        String Excelpwdconfirmation = RegisterData.get("password confirmation");
        driver.findElement(username).sendKeys(Excelusername);
        driver.findElement(password).sendKeys(Excelpassword);
        driver.findElement(pwdconfirmation).sendKeys(Excelpwdconfirmation);
     	driver.findElement(Registerbtn).click();
     	System.out.println("Username is: " + Excelusername);
 		System.out.println("Password is: " + Excelpassword);
 		System.out.println("Password Confirmation is: " + Excelpwdconfirmation);
 		System.out.println("Message" + getpwdmismatchtext());
 	
    }
    
    public String getPwdMismatchAlertmsg()
    {
    	WebElement field = driver.findElement(pwdMismatchAlertmsg);
        return (String) ((JavascriptExecutor) driver)
            .executeScript("return arguments[0].validationMessage;", field);
    }

    public String getpwdmismatchtext() {
       
            return elementsUtil.doGetText(pwdMismatchAlertmsg);
    }
    
    public void getInvalidUsername()
    {
    	log.info("Performing Register with TestData from Excel:");
     	Map<String, String> RegisterData = ExcelReader.getRowByTestCaseId(filepath,"Register","InvalidUsername");
     	String Excelusername = RegisterData.get("username");
        String Excelpassword = RegisterData.get("password");
        String Excelpwdconfirmation = RegisterData.get("password confirmation");
        driver.findElement(username).sendKeys(Excelusername);
        driver.findElement(password).sendKeys(Excelpassword);
        driver.findElement(pwdconfirmation).sendKeys(Excelpwdconfirmation);
     	driver.findElement(Registerbtn).click();
     	System.out.println("Username is: " + Excelusername);
 		System.out.println("Password is: " + Excelpassword);
 		System.out.println("Password Confirmation is: " + Excelpwdconfirmation);
 		System.out.println("Message" + getpwdmismatchtext());
    }
        
    public void getPwdNumericValue()
    {
    	log.info("Performing Register with TestData from Excel:");
     	Map<String, String> RegisterData = ExcelReader.getRowByTestCaseId(filepath,"Register","PwdNumericValue");
     	String Excelusername = RegisterData.get("username");
        String Excelpassword = RegisterData.get("password");
        String Excelpwdconfirmation = RegisterData.get("password confirmation");
        driver.findElement(username).sendKeys(Excelusername);
        driver.findElement(password).sendKeys(Excelpassword);
        driver.findElement(pwdconfirmation).sendKeys(Excelpwdconfirmation);
     	driver.findElement(Registerbtn).click();
     	System.out.println("Username is: " + Excelusername);
 		System.out.println("Password is: " + Excelpassword);
 		System.out.println("Password Confirmation is: " + Excelpwdconfirmation);
 		System.out.println("Message" + getpwdmismatchtext());
    }
    
    public void getClickLoginLink()
    {
    	
    	driver.findElement(LoginLink).click();
    }
   
    public boolean isLoginPageDisplayed() {
    	
        return driver.findElement(Loginpage).isDisplayed();
    }

	

}