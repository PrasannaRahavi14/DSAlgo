package org.example.pages;

import org.example.utilities.ElementsUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private ElementsUtil elementsUtil;
    private By PageTitle = By.cssSelector(".navbar-brand");
    private By SignInLink = By.cssSelector("a[href='/login']");
    private By NameCheckAfterLogin = By.xpath("//a[contains(text(),'Prasanna')]");

    private By GetStartedBtn_DS = By.xpath("//a[@href='data-structures-introduction']");

    public HomePage(WebDriver driver)
    {

        this.driver = driver;
        this.elementsUtil = new ElementsUtil(driver);
    }

    public String getTitle()
    {
       // return driver.findElement(PageTitle).getText();
        return elementsUtil.doGetText(PageTitle);
    }

    public void clickSignInLink()
    {
        //driver.findElement(SignInLink).click();
        elementsUtil.doClick(SignInLink);
    }

    public String CheckName()
    {

        //return driver.findElement(NameCheckAfterLogin).getText();
        return elementsUtil.doGetText(NameCheckAfterLogin);
    }

    public  void clickGetStartedForDS()
    {
        driver.findElement(GetStartedBtn_DS).click();
    }
}
