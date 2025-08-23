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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Queue extends BaseLogger {
	

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
    private By pq_brokenLink = By.cssSelector(".list-group-item.list-group-item-light.text-info");
    
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
        Map<String, String> getCode = ExcelReader.getRowByTestCaseId(filepath,"Queue","ValidCode");
        String codeToInput = getCode.get("Python Code");
        return codeToInput;
    }
    public String getInvalidCodeDataDriven()
    {
        Map<String, String> getCode = ExcelReader.getRowByTestCaseId(filepath,"Queue","InvalidCode");
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
        driver.navigate().back();
    }
    
}
