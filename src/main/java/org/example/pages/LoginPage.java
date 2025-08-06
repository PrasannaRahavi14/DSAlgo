package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

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

    public void doLogin(String un, String pwd)
    {
        driver.findElement(Username).sendKeys(un);
        driver.findElement(Password).sendKeys(pwd);
        driver.findElement(LoginBtn).click();
    }

}
