package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DataStructurePage {

    private WebDriver driver;

    private By getTitle_DSI = By.cssSelector("h4[class='bg-secondary text-white']");

    public DataStructurePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleforDSI()
    {
       return driver.findElement(getTitle_DSI).getText();
    }
}
