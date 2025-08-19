package org.example.pages;

import java.time.Duration;
import java.util.Map;

import org.example.utilities.ConfigReader;
import org.example.utilities.ElementsUtil;
import org.example.utilities.ExcelReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Queue {
	

    private WebDriver driver;
    private ElementsUtil elementsutil;
    
    String filepath = ConfigReader.getProperty("testData");

    private By getTitle_Queue = By.xpath("//div/h4[text()='Queue']");
    private By Tryhere = By.xpath("//a[text()='Try here>>>']");
    private By Run = By.xpath("//button[@type='button']");
    private By output = By.xpath("//pre[@id='output']");
    private By ImplementofQueue = By.cssSelector("a[href='implementation-lists']");
    private By ImplementCollections = By.cssSelector("a[href='implementation-collections']");
    private By ImplementArray = By.cssSelector("a[href='Implementation-array']");
    private By QueueOp = By.cssSelector("a[href='QueueOp']");
    private By tryEditor_text = By.cssSelector(".CodeMirror div.CodeMirror-code");
    
    public Queue (WebDriver driver) 
    {
        this.driver = driver;
        this.elementsutil = new ElementsUtil(driver);
    }

    public String getTitleforQueue()
    {
       return driver.findElement(getTitle_Queue).getText();
    }

    
    public void QueueTopics(String option) {
    	System.out.println("Received option: " + option);
    	if(option.equalsIgnoreCase("Implementation of Queue in python"))
    	{
    		elementsutil.doClick(ImplementofQueue);
    	}
    	else if (option.equalsIgnoreCase("Implementation using collections deque")) {
        
        elementsutil.doClick(ImplementCollections);
        } 
        else if (option.equalsIgnoreCase("Implementation using Array")) {
        	
        elementsutil.doClick(ImplementArray);
        } 
        else if (option.equalsIgnoreCase("Queue operations")) {
        	
        	elementsutil.doClick(QueueOp);
        } 
        else {
            throw new IllegalArgumentException("Unknown option: " + option);
        }
    
    }
    
    
    public void Tryhere()
    {
    	
    	driver.findElement(Tryhere).click();
    }
      
    public void enterPythonCode(String input)
    {
        WebElement editor = driver.findElement(tryEditor_text);
        Actions actions = new Actions(driver);
        actions.moveToElement(editor).click().sendKeys(input).perform();
    }
    public String getPythonCodeDataDriven()
    {
        Map<String, String> getCode = ExcelReader.getRowByTestCaseId(filepath,"DataStructure","ValidCode");
        String codeToInput = getCode.get("Python Code");
        return codeToInput;
    }
    public String getInvalidCodeDataDriven()
    {
        Map<String, String> getCode = ExcelReader.getRowByTestCaseId(filepath,"DataStructure","InvalidCode");
        String codeToInput = getCode.get("Python Code");
        return codeToInput;
    }
    public void Run()
    {
    	
    	driver.findElement(Run).click();
    	Handlealert();
    	String Op = driver.findElement(output).getText();
        System.out.println(Op);
        driver.navigate().back();
    }
    
    public void Handlealert()
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
    
    
}
