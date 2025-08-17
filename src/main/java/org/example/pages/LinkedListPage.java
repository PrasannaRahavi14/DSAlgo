package org.example.pages;

import org.example.utilities.ConfigReader;
import org.example.utilities.ElementsUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LinkedListPage {
	private WebDriver driver;
    private ElementsUtil elementsUtil;
    String url = ConfigReader.getProperty("baseurl");

   

    private By introElement=By.xpath("//a[text()='Introduction']");
    private By creatLLElement=By.xpath("//a[text()='Creating Linked LIst']");
    private By typesOfLLElement=By.xpath("//a[text()='Types of Linked List']");
    private By implementLLElement=By.xpath("/html/body/div[2]/ul[4]/a");
    private By traversalElement=By.xpath("/html/body/div[2]/ul[5]/a");
    private By insertionElement=By.xpath("/html/body/div[2]/ul[6]/a");
    private By deletionElement=By.xpath("/html/body/div[2]/ul[7]/a");
    private By tryHerebutton=By.xpath("//a[text()='Try here>>>']");
    
    
    public LinkedListPage(WebDriver driver) {
        this.driver = driver;
        this.elementsUtil = new ElementsUtil(driver);
        PageFactory.initElements(driver, this); 
    }
    
    public void clickIntroLink()
    {
    	elementsUtil.doClick(introElement);
    }
   
    
    
    
}
