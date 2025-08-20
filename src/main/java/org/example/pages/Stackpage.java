package org.example.pages;


import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.example.factory.DriverFactory;
import org.example.utilities.BaseLogger;
import org.example.utilities.ConfigReader;
import org.example.utilities.ElementsUtil;
import org.example.utilities.ExcelReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Stackpage extends BaseLogger{
	private WebDriver driver;
    HomePage homePage = new HomePage(DriverFactory.getDriver());
    LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
    LandingPage landingpage = new LandingPage(DriverFactory.getDriver());
    private By stackpagetitle = By.xpath("//h4[@class='bg-secondary text-white']");
    private By operationspage = By.xpath("//a[contains(text(), 'Operations in Stack')]");
    private By operationspage_title = By.xpath("//p[contains(text(), 'Operations in Stack')]");
    private By Implementation_title = By.cssSelector("a[href='implementation']");
    private By Applications_title = By.cssSelector("a[href='stack-applications']");
    private By tryherebtn = By.xpath("//a[@href='/tryEditor']");
    private By runBtn = By.cssSelector("button[type='button']");
    private By tryEditor_text = By.cssSelector(".CodeMirror div.CodeMirror-code");
    private By outputinconsole = By.xpath("//pre[@id='output']");
    ElementsUtil elementsUtil;
    String filepath = ConfigReader.getProperty("testData");
    
    private By getTopicLinkByText(String topic) {
    	//String xpath = "//p[contains(text() = '" + topic + "']";
        String xpath = "//a[text()='" + topic + "']";
        return By.xpath(xpath);
    }
    
    public Stackpage(WebDriver driver) {
        this.driver = driver;
        this.elementsUtil = new ElementsUtil(driver);
    } 
    
    public void getStartedStack()
    {
      landingpage.getURL();
      landingpage.clickGetStartedBtn();
   	  homePage.clickSignInLink();
   	  loginpage.performLoginDataDriven();
   	  homePage.clickGetStartedForStack();
   	
    }
    
    public String getStackpagetitle()
    {
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
    
    public void QueueTopics(String option) {
        if (option.equalsIgnoreCase("Implementation")) {
        
        elementsUtil.doClick(Implementation_title);
        } 
        
        else if (option.equalsIgnoreCase("Applications")) {
        	
        	elementsUtil.doClick(Applications_title);
        } 
        else {
        	
            throw new IllegalArgumentException("Unknown option: " + option);
        }
    }
    
    public void clickTryHereBtn() {
        log.info("Clicking on the Try Here Button");
        driver.findElement(tryherebtn).click();
    }
    
    public void ClickRun()
    {
    driver.findElement(runBtn).click();

    }
    
    
    public void Alertmessage()
    {
    	try {
    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    	    wait.until(ExpectedConditions.alertIsPresent());

    	    Alert alert = driver.switchTo().alert();
    	    System.out.println("Alert text: " + alert.getText());
    	    alert.accept(); 

    	} catch (TimeoutException e) {
    	    System.out.println("No alert appeared.");
    	}
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

    public boolean tryEditorVisible() {
        try {
            return elementsUtil.isElementDisplayed(tryEditor_text);
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
    public String getOutputFromConsole()
    {
        return driver.findElement(outputinconsole).getText();
    }

    public String getPythonCodeDataDriven()
    {
        Map<String, String> getCode = ExcelReader.getRowByTestCaseId(filepath,"Stack","ValidCode");
        String codeToInput = getCode.get("Python Code");
        return codeToInput;
    }

    public String getOutputDataDriven()
    {
        Map<String, String> getOutput = ExcelReader.getRowByTestCaseId(filepath,"Stack","ValidCode");
        String output = getOutput.get("Expected Output");
        return output;
    }

    public String getInvalidCodeDataDriven()
    {
        Map<String, String> getCode = ExcelReader.getRowByTestCaseId(filepath,"Stack","InvalidCode");
        String codeToInput = getCode.get("Python Code");
        return codeToInput;
    }
	
	
		
	}



 