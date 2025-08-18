package org.example.pages;

import org.example.utilities.BaseLogger;
import org.example.utilities.ConfigReader;
import org.example.utilities.ElementsUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LinkedListPage extends BaseLogger {
	private WebDriver driver;
    private ElementsUtil elementsUtil;
    String url = ConfigReader.getProperty("baseurl");

   

    private By introductionLink=By.xpath("//a[text()='Introduction']");
    private By creatingLLLink=By.xpath("//a[text()='Creating Linked LIst']");
    private By typesOfLLLink=By.xpath("//a[text()='Types of Linked List']");
    private By implementLLInPythonLink=By.xpath("//a[text()='Implement Linked List in Python']");
    private By traversalLink=By.xpath("//a[text()='Traversal']");
    private By insertionLink=By.xpath("//a[text()='Insertion']");
    private By deletionLink=By.xpath("//a[text()='Deletion']");
    private By tryHerebutton=By.xpath("//a[text()='Try here>>>']");
    private By titleIntroduction=By.xpath("//p[text()='Introduction']");
    
    
    public LinkedListPage(WebDriver driver) {
        this.driver = driver;
        this.elementsUtil = new ElementsUtil(driver);
        PageFactory.initElements(driver, this); 
    }
    
    public void clickIntroLink()
    {
    	log.info("Clicking Introduction link from Linked List page");
    	elementsUtil.doClick(introductionLink);
    }
   
    public String getIntroTitle()
    {
    	log.info("Verifying Title from Introduction page");
    	return driver.findElement(titleIntroduction).getText();
    }
    
    
}
