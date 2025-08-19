package org.example.pages;

import java.util.HashMap;
import java.util.Map;
//import java.util.Map;
import java.util.NoSuchElementException;

import org.example.factory.DriverFactory;
import org.example.utilities.BaseLogger;
import org.example.utilities.ConfigReader;
import org.example.utilities.ElementsUtil;
import org.example.utilities.ExcelReader;
//import org.example.utilities.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Stackpage extends BaseLogger{
	private WebDriver driver;
    private By getStartedStackbtn = By.xpath("//a[@href='stack']");
    HomePage homePage = new HomePage(DriverFactory.getDriver());
    LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
    LandingPage landingpage = new LandingPage(DriverFactory.getDriver());
    String url = ConfigReader.getProperty("baseurl");
    private By stackpagetitle = By.xpath("//h4[@class='bg-secondary text-white']");
    private By operationspage = By.xpath("//a[contains(text(), 'Operations in Stack')]");
    private By operationspage_title = By.xpath("//p[contains(text(), 'Operations in Stack')]");
    private By tryherebtn = By.xpath("//a[@href='/tryEditor']");
    private By tryEditor = By.xpath("//div[@class='CodeMirror cm-s-default']");
    private By runBtn = By.cssSelector("button[type='button']");
    private By tryEditor_text = By.cssSelector(".CodeMirror div.CodeMirror-code");
    private By outputConsole = By.xpath("//pre[@id='output']");
    ElementsUtil elementsUtil;
    String filepath = ConfigReader.getProperty("testData");
    
    private By getTopicLinkByText(String topic) {
        String xpath = "//a[text()='" + topic + "']";
        return By.xpath(xpath);
    }
    
    public Stackpage(WebDriver driver) {
        this.driver = driver;
    } 
    
    public void getStartedStack()
    {
      driver.get(url);
   	  landingpage.clickGetStartedBtn();
   	  homePage.clickSignInLink();
   	  loginpage.doLogin("Prasanna","Welcome@01");
   	  driver.findElement(getStartedStackbtn).click();
   	
    }
    
    public String getStackpagetitle()
    {
       log.info("Getting the title of Stack Page");
       return driver.findElement(stackpagetitle).getText();
    }
    
    public void getOperationsinstack()
    {
    	driver.findElement(operationspage).click();
    }
    
    public String getOperationspagetitle()
    {
    	log.info("Getting the title of Operations in Stack");
    	return driver.findElement(operationspage_title).getText();
    }
    public void clickTopicLink(String text) {
        log.info("Clicking on the topic link : " + text);
        driver.findElement(getTopicLinkByText(text)).click();

    }
  //3. actions for the page
  
    public By getTitleXPath(String pageTitle) {
        Map<String, By> titleToXPath = new HashMap<>();
        titleToXPath.put("Stack", stackpagetitle);
        titleToXPath.put("Operations in Stack", operationspage_title);


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
        driver.findElement(tryherebtn).click();
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

    public String getInvalidCodeDataDriven()
    {
        Map<String, String> getCode = ExcelReader.getRowByTestCaseId(filepath,"DataStructure","InvalidCode");
        String codeToInput = getCode.get("Python Code");
        return codeToInput;
    }


    }