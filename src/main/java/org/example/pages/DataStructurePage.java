package org.example.pages;

import org.example.utilities.ElementsUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class DataStructurePage {

    ElementsUtil elementsUtil;

    //1. locators
    private WebDriver driver;
    private By getTitle_DSI = By.cssSelector("h4[class='bg-secondary text-white']");
    private By getTitle_TimeComplexity = By.cssSelector("div[class='col-sm'] p[class='bg-secondary text-white']");
    private By getTopicLinkByText(String topic) {
        String xpath = "//a[text()='" + topic + "']";
        return By.xpath(xpath);
    }
    private By tryHereBtn = By.cssSelector("a.btn.btn-info");
    private By tryEditor = By.xpath("//div[@class='CodeMirror cm-s-default']");
    private By runBtn = By.cssSelector("button[type='button']");

    //2. constructor
    public DataStructurePage(WebDriver driver)
    {
        this.driver = driver;
    }


    //3. actions for the page
    public String getTitleforDSI()
    {
       return driver.findElement(getTitle_DSI).getText();
    }
    public void clickTopicLink(String text)
    {
        driver.findElement(getTopicLinkByText(text)).click();

    }
    public By getTitleXPath(String pageTitle) {
        Map<String, By> titleToXPath = new HashMap<>();
        titleToXPath.put("Data Structures-Introduction", getTitle_DSI);
        titleToXPath.put("Time Complexity", getTitle_TimeComplexity);


        if (!titleToXPath.containsKey(pageTitle)) {
            throw new IllegalArgumentException("No XPath mapped for page title: " + pageTitle);
        }

        return titleToXPath.get(pageTitle);
    }

    public String validateTitle(String title)
    {
       By xpath = getTitleXPath(title);
      return driver.findElement(xpath).getText();
    }
    public void clickTryHereBtn()
    {
        driver.findElement(tryHereBtn).click();
    }
    public boolean tryEditorRunBtnVisible() {
        try {
            return elementsUtil.isElementDisplayed(tryEditor) && elementsUtil.isElementDisplayed(runBtn);
        } catch (NoSuchElementException e) {
            return false; // Element(s) not found
        }
    }

}
