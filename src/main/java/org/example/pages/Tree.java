package org.example.pages;

import org.example.utilities.BaseLogger;
import org.example.utilities.ElementsUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Tree extends BaseLogger {
    private WebDriver driver;
    ElementsUtil elementsUtil;

    public Tree(WebDriver driver) {
        this.driver = driver;
        this.elementsUtil = new ElementsUtil(driver);
    }

    private By getTitle_Tree = By.cssSelector("h4[class='bg-secondary text-white']");
    private By getTopicLinkByText(String topic) {
        String xpath = "//a[text()='" + topic + "']";
        return By.xpath(xpath);
    }

    private By tryHereBtn = By.cssSelector("a.btn.btn-info");
    private By tryEditor = By.xpath("//div[@class='input']");
    private By runBtn = By.cssSelector("button[type='button']");
    private By tryEditor_text = By.cssSelector(".CodeMirror div.CodeMirror-code");
    private By outputConsole = By.xpath("//pre[@id='output']");

    public String getTitleforTree() {
        log.info("Getting the title of Tree Page");
        return driver.findElement(getTitle_Tree).getText();
    }
    public void clickTopicLink(String text) {
        log.info("Clicking on the topic link : " + text);
        driver.findElement(getTopicLinkByText(text)).click();

    }

}
