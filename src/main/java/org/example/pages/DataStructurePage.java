package org.example.pages;

import org.example.utilities.BaseLogger;
import org.example.utilities.ConfigReader;
import org.example.utilities.ElementsUtil;
import org.example.utilities.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class DataStructurePage extends BaseLogger {

    ElementsUtil elementsUtil;
    String filepath = ConfigReader.getProperty("testData");

    //1. locators
    private WebDriver driver;
    private By getTitle_DSI = By.cssSelector("h4[class='bg-secondary text-white']");
    private By getTitle_TimeComplexity = By.cssSelector("div[class='col-sm'] p[class='bg-secondary text-white']");

    private By getTopicLinkByText(String topic) {
        String xpath = "//a[text()='" + topic + "']";
        return By.xpath(xpath);
    }

    private By tryHereBtn = By.cssSelector("a.btn.btn-info");
    private By tryEditor = By.xpath("//div[@class='input']");
    private By runBtn = By.cssSelector("button[type='button']");
    private By tryEditor_text = By.cssSelector(".CodeMirror div.CodeMirror-code");
    private By outputConsole = By.xpath("//pre[@id='output']");

    //2. constructor
    public DataStructurePage(WebDriver driver) {

        this.driver = driver;
        this.elementsUtil = new ElementsUtil(driver);
    }


    //3. actions for the page
    public String getTitleforDSI() {
        log.info("Getting the title of DataStructure Page");
        return driver.findElement(getTitle_DSI).getText();
    }

    public void clickTopicLink(String text) {
        log.info("Clicking on the topic link : " + text);
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

    public String validateTitle(String title) {
        log.info("Title of the page : " + title);
        By xpath = getTitleXPath(title);
        return driver.findElement(xpath).getText();
    }

    public void clickTryHereBtn() {
        log.info("Clicking on the Try Here Button");
        driver.findElement(tryHereBtn).click();
    }

    public boolean tryEditorVisible() {
        try {
            return elementsUtil.isElementDisplayed(tryEditor);
        } catch (NoSuchElementException e) {
            return false; // Element(s) not found
        }
    }
    public boolean runBtnVisible() {
        try {
            return elementsUtil.isElementDisplayed(runBtn);
        } catch (NoSuchElementException e) {
            return false; // Element(s) not found
        }
    }
    public void enterPythonCode(String input)
    {
        WebElement editor = driver.findElement(tryEditor_text);
        Actions actions = new Actions(driver);
        actions.moveToElement(editor).click().sendKeys(input).perform();
    }
    public void clickRunBtn()
    {
        driver.findElement(runBtn).click();
    }
    public String getOutputFromConsole()
    {
        return driver.findElement(outputConsole).getText();
    }

    public String getPythonCodeDataDriven()
    {
        Map<String, String> getCode = ExcelReader.getRowByTestCaseId(filepath,"DataStructure","ValidCode");
        String codeToInput = getCode.get("Python Code");
        return codeToInput;
    }

    public String getOutputDataDriven()
    {
        Map<String, String> getOutput = ExcelReader.getRowByTestCaseId(filepath,"DataStructure","ValidCode");
        String output = getOutput.get("Expected Output");
        return output;
    }




}
