package org.example.pages;

import java.time.Duration;
import java.util.Map;

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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkedListPage extends BaseLogger {
	private WebDriver driver;
    private ElementsUtil elementsUtil;
    String url = ConfigReader.getProperty("baseurl");
    String filepath = ConfigReader.getProperty("testData");

   

    private By introductionLink=By.xpath("//a[text()='Introduction']");
  //  private By creatingLLLink=By.xpath("//a[text()='Creating Linked LIst']");
  //  private By typesOfLLLink=By.xpath("//a[text()='Types of Linked List']");
  //  private By implementLLInPythonLink=By.xpath("//a[text()='Implement Linked List in Python']");
  //  private By traversalLink=By.xpath("//a[text()='Traversal']");
  //  private By insertionLink=By.xpath("//a[text()='Insertion']");
  //  private By deletionLink=By.xpath("//a[text()='Deletion']");
    // private By titleIntroduction=By.xpath("//p[text()='Introduction']");
    private By tryHerebutton=By.xpath("//a[text()='Try here>>>']");
    private By runButton=By.xpath("//button[text()='Run']");
    private By tryEditor=By.xpath("//div[@class='input']");
    private By tryEditorTextSpace=By.xpath("//pre[@class=' CodeMirror-line ']");
    private By outputFromConsole=By.xpath("//pre[@id='output']");
    private By practiceQuestions=By.xpath("//a[text()='Practice Questions']");
    private By displayPracticepage=By.xpath("//div[@class='bs-example']");
    public LinkedListPage(WebDriver driver) {
        this.driver = driver;
        this.elementsUtil = new ElementsUtil(driver);
        PageFactory.initElements(driver, this); 
    }
    
    
   public void clickTryHereButton()
    {
    	
    	log.info("Clicking Try Here button from different links page");
    	elementsUtil.doClick(tryHerebutton);
    }
    public void clickLinkFromLL(String dynamicValue)
    {
    	log.info("Clicking different links from Linked List page");
    	elementsUtil.doClick(By.xpath(String.format("//a[text()='%s']", dynamicValue)));
    	
    }
    
    public String getLinksTitle(String dynamicValue)
    {
    	log.info("Checking different links title from Linked list module");
    	 return driver.findElement(By.xpath(String.format("//p[text()='%s']", dynamicValue))).getText();
    }
    
    
    public boolean istryEditorDisplayed() {
        try {
        	log.info("Verifying the Try editor page");
            return elementsUtil.waitForElementToBeVisible(tryEditor).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }    
  
    }
    public void enterPythonCode(String value)
    {
    	log.info("Entering the valid python code");
        WebElement editor = driver.findElement(tryEditorTextSpace);
        Actions actions = new Actions(driver);
        actions.moveToElement(editor).click().sendKeys(value).perform();
    }
    
    public String getPythonCodeFromExcel()
    {
    	log.info("Getting the valid python code from Excel");
        Map<String, String> getCode = ExcelReader.getRowByTestCaseId(filepath,"Linked List","Valid Code");
        String codeToInput = getCode.get("Python Code");
        return codeToInput;
    }
    
   public void clickRunButton()
   {
	   log.info("Clicking the Run button from the try Editor page");
	   elementsUtil.doClick(runButton); 
   }
   
   
   public String getOutputFromConsole()
   {
	   log.info("Getting output from the console window");
       return driver.findElement(outputFromConsole).getText();
   }
   
   public String getOutputDataDriven()
   {
	   log.info("Getting output from the Excel");
       Map<String, String> getOutput = ExcelReader.getRowByTestCaseId(filepath,"Linked List","Valid Code");
       String output = getOutput.get("Expected Output");
       return output;
   }
   public String getInvalidPythonCodeFromExcel()
   {
	   log.info("Getting the Invalid python code from Excel");
       Map<String, String> getCode = ExcelReader.getRowByTestCaseId(filepath,"Linked List","InValid Code");
       String codeToInput = getCode.get("Python Code");
       return codeToInput;
   }
   
   public String getAlertOutputFromDataDriven()
   {
	   log.info("Getting the expected output from Excel for Invalid python code");
       Map<String, String> getOutput = ExcelReader.getRowByTestCaseId(filepath,"Linked List","InValid Code");
       String output = getOutput.get("Expected Output");
       return output;
   }
   
   
    public String alertwindow()
   {
    	   log.info("Getting the Error Text in the alert window");
		   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2));
		   wait.until(ExpectedConditions.alertIsPresent());
		   Alert alert=driver.switchTo().alert();
		   return alert.getText();
   }
    public void clickIntrolink()
    {
    	log.info("Clicking Introduction Link from Linked List module");
    	elementsUtil.doClick(introductionLink);
    }
	public void clickPracticeQuestionsLink()
	   {
		log.info("Clicking Practice Questions Link from Introduction page");
		 elementsUtil.doClick(practiceQuestions);
	   }
	public boolean isPracticePageDisplayed()
	{
		 try {
	        	log.info("Verifying the Practice questions page");
	            return elementsUtil.waitForElementToBeVisible(displayPracticepage).isDisplayed();
	        } catch (TimeoutException e) {
	            return false;
	        }    
		
	}
   }
   
   
