package org.example.pages;

import org.example.utilities.BaseLogger;
import org.example.utilities.ConfigReader;
import org.example.utilities.ElementsUtil;
import org.example.utilities.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Map;
import java.util.NoSuchElementException;

public class TreePage extends BaseLogger {
    private WebDriver driver;
    ElementsUtil elementsUtil;
    String filepath = ConfigReader.getProperty("testData");

    public TreePage(WebDriver driver) {
        this.driver = driver;
        this.elementsUtil = new ElementsUtil(driver);
    }

    private By getTitle_Tree = By.cssSelector("h4[class='bg-secondary text-white']");
    private By getTitle_topic = By.cssSelector("div[class='col-sm'] p[class='bg-secondary text-white']");
    private By getTopicLinkByText(String topic) {
        String xpath = "//a[text()='" + topic + "']";
        return By.xpath(xpath);
    }

    private By tryHereBtn = By.cssSelector("a.btn.btn-info");
    private By tryEditor = By.xpath("//div[@class='input']");
    private By runBtn = By.cssSelector("button[type='button']");
    private By tryEditor_text = By.cssSelector(".CodeMirror div.CodeMirror-code");
    private By outputConsole = By.xpath("//pre[@id='output']");
    private By totalLinks = By.cssSelector("a.list-group-item");
    private By topicsCovered = By.cssSelector("p.bg-secondary.text-white");
    private By pq_brokenLink = By.cssSelector(".list-group-item.list-group-item-light.text-info");

    public String getTitleforTree() {
        log.info("Getting the title of Tree Page");
        return driver.findElement(getTitle_Tree).getText();
    }
    public void clickTopicLink(String text) {
        log.info("Clicking on the topic link : " + text);
        driver.findElement(getTopicLinkByText(text)).click();

    }

    public void validateTitleforTopics(String topic)
    {
        String topicsPageTitle = driver.findElement(getTitle_topic).getText();
        if(topicsPageTitle.equalsIgnoreCase(topic))
        {
            log.info ("The user is in the correct topic page as expected : "+topicsPageTitle);

        }
        else {
            log.info ("The user is in the topics page "+topicsPageTitle+" but expected to be in "+topic);
        }

    }
    public void clickTryHereBtn(String topic) {

        String topicsPageTitle = driver.findElement(getTitle_topic).getText();
        if(topicsPageTitle.equalsIgnoreCase(topic))
        {
            log.info("Clicking on the Try Here Button of "+topic);
            driver.findElement(tryHereBtn).click();
        }
        else{ log.info("you are in the wrong topics page "+topic);}

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
    public void tryEditorPageWithRunBtn()
    {
        if(tryEditorVisible() && runBtnVisible())
        {
            log.info("you are in the Try Editor Page with Editor and Run Button");
        }
        else
        {
            log.info("Try Editor or Run button is not present in this page");
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
    public String getPythonCodeDataDriven(String inputID)
    {
        Map<String, String> getCode = ExcelReader.getRowByTestCaseId(filepath,"Tree",inputID);
        String codeToInput = getCode.get("Python Code");
        return codeToInput;
    }

    public String getOutputDataDriven(String inputID)
    {
        Map<String, String> getOutput = ExcelReader.getRowByTestCaseId(filepath,"Tree",inputID);
        String output = getOutput.get("Expected Output");
        return output;
    }

    public String processInputAndReturnStatus() {
        String alertMessage = elementsUtil.getAlertTextSafe();
        if (alertMessage != null) {
            elementsUtil.acceptAlertSafe();
            log.error("Alert output: " + alertMessage);
            return alertMessage;
        }

        // Otherwise get console output
        try {
            String output = getOutputFromConsole();
            log.info("Console output: " + output);
            return output;
        } catch (TimeoutException e) {
            log.error("Console output not found within timeout.");
            return null;
        }
    }
    public int getTotalCountofTopicsLink()
    {
        WebElement topic = driver.findElement(topicsCovered);
        if(topic.isDisplayed())
        {
            return driver.findElements(totalLinks).size();
        }
        else return 0;
    }
    public void topicsCoveredSection()
    {
        String topicCoveredText = driver.findElement(topicsCovered).getText();
        if(topicCoveredText.equalsIgnoreCase("Topics Covered"))
        {
            log.info("The Page has Topics Covered Section");
        }
        else {
            log.info("The page doesn't have any topics");
        }

    }
    public void clickOnPQLink()
    {
        driver.findElement(pq_brokenLink).click();
        String pageSource = driver.getPageSource();
        if (pageSource.trim().isEmpty() || pageSource.contains("404") || pageSource.contains("Not Found")) {
            log.warn("❌ Broken Link Navigated to Empty/404 Page");
        } else {
            log.info("✅ Practice Questions Link Working Fine");
        }
    }
    public void emptyPage()
    {
        WebElement container = driver.findElement(By.cssSelector("div.container"));
        if (container.getText().trim().isEmpty()) {
            log.warn("⚠️ The container is empty → no practice content found");
        } else {
            log.info("✅ Container has content: " + container.getText());
        }

    }

}
