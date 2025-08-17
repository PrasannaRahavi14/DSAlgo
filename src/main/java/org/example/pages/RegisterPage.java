package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

	private WebDriver driver;
	private By getTitle_DSI = By.cssSelector("h4[class='bg-secondary text-white']");
	private By getTitleRegisterpage = By.xpath("//title[contains(text(), ' Registration ')]");
	private By getRegister_Page = By.cssSelector("a[href='/register']");
	private By username = By.id("id_username");
	private By password = By.id("id_password1");
	private By pwdconfirmation = By.id("id_password2");
	private By pwdMismatchAlertmsg = By.xpath("//div[contains(@class,'alert') and contains(text(),'password_mismatch:')]");
	private By NewAccountAlertmsg = By.xpath("//div[contains(@class,'alert') and contains(text(),'New Account Created')]");
	private By LoginLink = By.xpath("(//a[@href='/login'])[2]");
	private By Loginpage = By.xpath("//a[contains(text(), 'NumpyNinja')]");
			
    
	public RegisterPage(WebDriver driver) {
    this.driver = driver;
   
    }

    public String getTitleforDSI()
    {
  return driver.findElement(getTitle_DSI).getText();
    }
    
    public String getTitleRegisterpage()
    {
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
    	driver.findElement(By.id("id_username")).sendKeys("");
		driver.findElement(By.id("id_password1")).sendKeys("");
		driver.findElement(By.id("id_password2")).sendKeys("");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
    }

    public void getUsernameValues()
    {
    	driver.findElement(By.id("id_username")).sendKeys("Prasanna1");
		driver.findElement(By.id("id_password1")).sendKeys("");
		driver.findElement(By.id("id_password2")).sendKeys("");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
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
    	driver.findElement(By.id("id_username")).sendKeys("");
		driver.findElement(By.id("id_password1")).sendKeys("Welcome@01");
		driver.findElement(By.id("id_password2")).sendKeys("");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
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
    	driver.findElement(By.id("id_username")).sendKeys("Prasanna1");
		driver.findElement(By.id("id_password1")).sendKeys("Welcome@01");
		driver.findElement(By.id("id_password2")).sendKeys("");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
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
    	driver.findElement(By.id("id_username")).sendKeys("NinjaNumpy1");
		driver.findElement(By.id("id_password1")).sendKeys("Welcome@01");
		driver.findElement(By.id("id_password2")).sendKeys("Welcome@01");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
    	
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
    	driver.findElement(By.id("id_username")).sendKeys("Rahavi@123");
		driver.findElement(By.id("id_password1")).sendKeys("Connect@1234");
		driver.findElement(By.id("id_password2")).sendKeys("Connect#123");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		
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

    	driver.findElement(By.id("id_username")).sendKeys("QW!!23 45 QW");
		driver.findElement(By.id("id_password1")).sendKeys("Welcome@01");
		driver.findElement(By.id("id_password2")).sendKeys("Welcome@01");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
    }
        
    public void getPwdNumericValue()
    {
    	driver.findElement(By.id("id_username")).sendKeys("Qwerty@123");
		driver.findElement(By.id("id_password1")).sendKeys("123456789098");
		driver.findElement(By.id("id_password2")).sendKeys("123456789098");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
    }
    
    public void getClickLoginLink()
    {
    	
    	driver.findElement(LoginLink).click();
    }
   
    public boolean isLoginPageDisplayed() {
    	
        return driver.findElement(Loginpage).isDisplayed();
    }

}
