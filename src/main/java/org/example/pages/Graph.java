package org.example.pages;

import java.time.Duration;
import java.util.Map;

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

public class Graph {
	
	    private WebDriver driver;
	    private ElementsUtil elementsutil;
	    
	    private By Tryhere = By.xpath("//a[text()='Try here>>>']");
	    private By Run = By.xpath("//button[@type='button']");
	    private By tryEditor_text = By.cssSelector(".CodeMirror div.CodeMirror-code");
	    private By GraphLink = By.cssSelector("a[href='graph']");
	    private By GraphRepLink = By.cssSelector("a[href='graph-representations']");
	    
	    
	    String filepath = ConfigReader.getProperty("testData");
	    

	    public Graph (WebDriver driver) 
	    {
	        this.driver = driver;
	        this.elementsutil = new ElementsUtil(driver);
	    }
	    
	    public void selectGraphOption(String option) {
	        switch (option) {
	            case "Graph":
	                elementsutil.doClick(GraphLink);
	                break;

	            case "Graph Representations":
	                elementsutil.doClick(GraphRepLink);
	                break;

	            default:
	                throw new IllegalArgumentException("Invalid option: " + option);
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
	        Map<String, String> getCode = ExcelReader.getRowByTestCaseId(filepath,"Graph","ValidCode");
	        String codeToInput = getCode.get("Python Code");
	        return codeToInput;
	    }
	    public String getInvalidCodeDataDriven()
	    {
	        Map<String, String> getCode = ExcelReader.getRowByTestCaseId(filepath,"Graph","InvalidCode");
	        String codeToInput = getCode.get("Python Code");
	        return codeToInput;
	    }
	    
	    public void Run()
	    {
	    	
	    	driver.findElement(Run).click();
	    	Handlealert();
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
