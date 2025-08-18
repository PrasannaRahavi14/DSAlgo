package org.example.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementsUtil {
    private WebDriver driver;
    private WebDriverWait wait;

    public ElementsUtil(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public String doGetText(By locator) {
        return waitForElementToBeVisible(locator).getText();
    }
    public void doClick(By locator) {
        waitForElementToBeClickable(locator).click();
    }
    public boolean isElementDisplayed(By locator) {
        try {
            return waitForElementToBeVisible(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
    public void doSendKeys(By locator, String value) {
        WebElement element = waitForElementToBeVisible(locator);
        element.clear();
        element.sendKeys(value);
    }

}
