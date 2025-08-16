package org.example.pages;

import org.example.utilities.ElementsUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import rst.pdfbox.layout.text.ReplacedWhitespace;

public class LoginPage {

    private WebDriver driver;
    private ElementsUtil elementutil;

    //1. By Locators :
    private By SignInLink = By.xpath("//a[text()='Sign in']");
    private By Username = By.xpath("//input[@name='username']");
    private By Password = By.xpath("//input[@name='password']");
    private By LoginBtn = By.cssSelector("input[value='Login']");
    private By Alertmsg = By.id("id_username");
    private By invalidmsg = By.xpath("//div[@role='alert']");

    //2. Constructor of the page class :
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        this.elementutil= new ElementsUtil(driver);
    }

    //3. page actions
    public void enterUserName(String un)
    {
        driver.findElement(Username).sendKeys("dummyuser");
    }

    public void enterPassword(String pwd)
    {
        driver.findElement(Password).sendKeys("numpy@123");
    }

    public  void clickOnLogin()
    {
        driver.findElement(LoginBtn).click();
    }

    public void login()
    {
    	driver.findElement(SignInLink).click();
    }
    
    public void doLogin(String un, String pwd)
    {
        driver.findElement(Username).sendKeys("dummyuser");
        driver.findElement(Password).sendKeys("numpy@123");
        driver.findElement(LoginBtn).click();
    }
    
    public void replacewithemptystring()
    {
    	driver.findElement(Username).sendKeys("");
    	driver.findElement(Password).sendKeys("");
    	driver.findElement(LoginBtn).click();
    }
    public void replacewithemptystringusrnme()
    {
    	driver.findElement(Username).sendKeys("");
    	driver.findElement(LoginBtn).click();
    
    }
    public void replacewithemptystringpwd(String un)
    {
    	driver.findElement(Username).sendKeys(un);
    	driver.findElement(Password).sendKeys("");
    	driver.findElement(LoginBtn).click();
    }
    
    public void invalidusrnme(String pwd)
    {
    	driver.findElement(Username).sendKeys("hello");
    	driver.findElement(Password).sendKeys(pwd);
    }
    
    public void invalidpwd(String un)
    {
    	driver.findElement(Username).sendKeys(un);
    	driver.findElement(Password).sendKeys("world");
    	driver.findElement(LoginBtn).click();
    }
    
    public void alert()
    {
    	driver.findElement(LoginBtn).click();
    	
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
    
    public void Invalidmsg()
    {
    	 driver.findElement(invalidmsg);
    }
   
}
