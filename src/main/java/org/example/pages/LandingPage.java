package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    private WebDriver driver;

    private By GetStartedBtn = By.cssSelector(".btn");
    private By Title_lp = By.cssSelector("div[class='content'] h1");
    public LandingPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickGetStartedBtn ()
    {
        driver.findElement(GetStartedBtn).click();
    }

    public String getTitle()
    {
        return driver.findElement(Title_lp).getText();
    }


}
