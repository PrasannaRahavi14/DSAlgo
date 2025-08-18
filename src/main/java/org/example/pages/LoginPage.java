package org.example.pages;

import org.example.utilities.BaseLogger;
import org.example.utilities.ConfigReader;
import org.example.utilities.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class LoginPage extends BaseLogger {

    private WebDriver driver;
    String filepath = ConfigReader.getProperty("testData");
    //1. By Locators :
    private By SignInLink = By.xpath("//a[text()='Sign in']");
    private By Username = By.xpath("//input[@name='username']");
    private By Password = By.xpath("//input[@name='password']");
    private By LoginBtn = By.cssSelector("input[value='Login']");

    //2. Constructor of the page class :
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
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

}
