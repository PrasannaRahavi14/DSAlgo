package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class DataStructurePage {

    private WebDriver driver;
    private By getTitle_DSI = By.cssSelector("h4[class='bg-secondary text-white']");
    private By getTitle_TimeComplexity = By.cssSelector("div[class='col-sm'] p[class='bg-secondary text-white']");
    private By getTopicLinkByText(String topic) {
        String xpath = "//a[text()='" + topic + "']";
        return By.xpath(xpath);
    }
    public DataStructurePage(WebDriver driver)
    {
        this.driver = driver;
    }
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

}
