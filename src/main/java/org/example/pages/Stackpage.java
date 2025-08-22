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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Stackpage extends BaseLogger{
	private WebDriver driver;
    HomePage homePage = new HomePage(DriverFactory.getDriver());
    LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
    LandingPage landingpage = new LandingPage(DriverFactory.getDriver());
    private By stackpagetitle = By.xpath("//h4[@class='bg-secondary text-white']");
    private By OperationLink = By.xpath("//a[contains(text(), 'Operations in Stack')]");
    private By Operationspage_title = By.xpath("//p[contains(text(), 'Operations in Stack')]");
    private By ImplementationLink = By.cssSelector("a[href='implementation']");
    private By Implementationpage_title = By.xpath("//p[contains(text(), 'Implementation')]");
    private By ApplicationsLink= By.cssSelector("a[href='stack-applications']");
    private By Applicationspage_title = By.xpath("//p[contains(text(), 'Applications')]");
    private By tryherebtn = By.xpath("//a[@href='/tryEditor']");
    private By runBtn = By.cssSelector("button[type='button']");
    private By tryEditor_text = By.cssSelector(".CodeMirror div.CodeMirror-code");
    private By outputinconsole = By.xpath("//pre[@id='output']");
    private By PracticeQuestions=By.xpath("//a[text()='Practice Questions']");
    private By DisplayPracticePage=By.xpath("//div[@class='bs-example']");
    ElementsUtil elementsUtil;
    private By pqbrokenLink = By.cssSelector(".list-group-item.list-group-item-light.text-info");
    String filepath = ConfigReader.getProperty("testData");
    
    private By getTopicLinkByText(String topic) {
        String xpath = "//a[text()='" + topic + "']";
        return By.xpath(xpath);
    }
    
    public Stackpage(WebDriver driver) {
        this.driver = driver;
        this.elementsUtil = new ElementsUtil(driver);
    } 
    
    public void getStartedStack()
    {
    	loginpage.Login();
   	  homePage.clickGetStartedForStack();
   	
    }
    
    public String getStackpagetitle()
    {
       return driver.findElement(stackpagetitle).getText();
    }
    
    public void getOperationsinstack()
    {
    	driver.findElement(OperationLink).click();
    	
    }
    
    public String getOperationspagetitle()
    {
    	log.info("Getting the title of Operations in Stack");
    	return driver.findElement(Operationspage_title).getText();
    }
    
    public String StackTopics(String option) {
        if (option.equalsIgnoreCase("Implementation")) {
        
       elementsUtil.doClick(ImplementationLink);    
       log.info("The User is on : " + option);
        return driver.findElement(Implementationpage_title).getText();    
        }     
        else if (option.equalsIgnoreCase("Applications")) {
        	elementsUtil.doClick(ApplicationsLink);  
        	log.info("The User is on : " + option);
            return driver.findElement(Applicationspage_title).getText();
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
        titleToXPath.put("Operations in Stack", Operationspage_title);


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
   
    public void enterPythonCode(String input)
    {
        WebElement editor = driver.findElement(tryEditor_text);
        Actions actions = new Actions(driver);
        actions.moveToElement(editor).click().sendKeys(input).perform();
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
    
    public void ClickPracticeQuestionsLink()
	   {
		log.info("Clicking Practice Question");
		 elementsUtil.doClick(PracticeQuestions);
	   }
	public boolean isPracticePageDisplayed()
	{
		 try {
	        	return elementsUtil.waitForElementToBeVisible(DisplayPracticePage).isDisplayed();
	        } catch (TimeoutException e) {
	            return false;
	        }    	
	}
	 public void ClickPQLink()
	    {
	        driver.findElement(pqbrokenLink).click();
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



 