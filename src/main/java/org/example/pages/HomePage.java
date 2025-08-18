package org.example.pages;

import org.example.utilities.BaseLogger;
import org.example.utilities.ElementsUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseLogger {

    private WebDriver driver;
    private ElementsUtil elementsUtil;
    private By PageTitle = By.cssSelector(".navbar-brand");
    private By SignInLink = By.cssSelector("a[href='/login']");
    private By NameCheckAfterLogin = By.xpath("//a[contains(text(),'Prasanna')]");

    private By GetStartedBtn_DS = By.xpath("//a[@href='data-structures-introduction']");
    private By GetStartedBtn_Array = By.xpath("//a[@href='array']");
    private By GetStartedBtn_LinkedList=By.xpath("//a[@href='linked-list']");
    private By GetStartedBtn_Stack=By.xpath("//a[@href='stack']");
    private By GetStartedBtn_Queue=By.xpath("//a[@href='queue']");
    private By GetStartedBtn_Tree = By.xpath("//a[@href='tree']");
    private By GetStartedBtn_Graph=By.xpath("//a[@href='graph']");
    private By dataDrpdown= By.xpath("//a[@class='nav-link dropdown-toggle']");
    private By arraysDrpdown= By.xpath("//a[@href='/array']");
    private By linkedListDrpdown=By.xpath("//a[@href='/linked-list']");
    private By stackDrpdown=By.xpath("//a[@href='/stack']");
    private By queueDrpdown=By.xpath("//a[@href='/queue']");
    private By treeDrpdown= By.xpath("//a[@href='/tree']");
    private By graphDrpdown= By.xpath("//a[@href='/graph']");
    private By titleDataStructure=By.xpath("//h4[text()='Data Structures-Introduction']");
    private By titleArray=By.xpath("//h4[text()='Array']");
    private By titleLinkedList=By.xpath("//h4[text()='Linked List']");
    private By titleStack=By.xpath("//h4[text()='Stack']");
    private By titleQueue=By.xpath("//h4[text()='Queue']");
    private By titleTree=By.xpath("//h4[text()='Tree']");
    private By titleGraph=By.xpath("//h4[text()='Graph']");
    private By warnMsg=By.xpath("//div[@class='alert alert-primary']");
    private By registerButton=By.xpath("//a[text()=' Register ']");
    private By signInButton=By.xpath("//a[text()='Sign in']");
    private By signOutButton=By.xpath("//a[text()='Sign out']");
    private By successLogOut=By.xpath("//div[@class='alert alert-primary']");


    public HomePage(WebDriver driver)
    {

        this.driver = driver;
        this.elementsUtil = new ElementsUtil(driver);
    }

    public String getTitle()
    {
        log.info("Getting the title of HomePage");
       
        return elementsUtil.doGetText(PageTitle);
    }

    public void clickSignInLink()
    {
        log.info("Clicking on the SignIn Link from the HomePage");
        
        elementsUtil.doClick(SignInLink);
    }

    public String CheckName()
    {
        log.info("Successfully logged in");
        
        return elementsUtil.doGetText(NameCheckAfterLogin);
    }

    public  void clickGetStartedForDS()
    {
        log.info("Clicking on the Get Started Button of DataStructure from HomePage");
        driver.findElement(GetStartedBtn_DS).click();
    }
    public void clickGetStartedForTree()
    {
        log.info("Clicking on the Get Started Button of Tree from HomePage");
        driver.findElement(GetStartedBtn_Tree).click();
    }
    public String titleNumby()
    {
    	log.info("Verifying Home Page Title");
        return elementsUtil.doGetText(PageTitle);
    }

    public void clickGetStartedForArray()
    {
    	 log.info("Clicking on the Get Started Button of Array from HomePage");
        elementsUtil.doClick(GetStartedBtn_Array);
    }
    public void clickGetStartedForLinkedList()
    {
    	log.info("Clicking on the Get Started Button of Linked List from HomePage");
        elementsUtil.doClick(GetStartedBtn_LinkedList);
    }
    public void clickGetStartedForStack()
    {
    	 log.info("Clicking on the Get Started Button of Stack from HomePage");
        elementsUtil.doClick(GetStartedBtn_Stack);
    }

    public void clickGetStartedForQueue() {
    	log.info("Clicking on the Get Started Button of Queue from HomePage");
        elementsUtil.doClick(GetStartedBtn_Queue);
    }
   public void clickGetStartedForGraph() {
	   log.info("Clicking on the Get Started Button of Graph from HomePage");
        elementsUtil.doClick(GetStartedBtn_Graph);
    }
    public void clickDrpdown() {
    	log.info("Clicking on the Drop down from HomePage");
        elementsUtil.doClick(dataDrpdown);
    }
    public void clickArraysDrpdown() {
    	log.info("Clicking on the Arrays from Drop down");
        elementsUtil.doClick(arraysDrpdown);
    }
    public void clickLinkedListDrpdown() {
    	log.info("Clicking on the Linked List from Drop down");
        elementsUtil.doClick(linkedListDrpdown);
    }
    public void clickStackDrpdown() {
    	log.info("Clicking on the Stack from Drop down");
        elementsUtil.doClick(stackDrpdown);
    }
    public void clickQueueDrpdown() {
    	log.info("Clicking on the Queue from Drop down");
        elementsUtil.doClick(queueDrpdown);
    }
    public void clickTreeDrpdown() {
    	log.info("Clicking on the Tree from Drop down");
        elementsUtil.doClick(treeDrpdown);
    }
    public void clickGraphDrpdown() {
    	log.info("Clicking on the Graph from Drop down");
        elementsUtil.doClick(graphDrpdown);
    }
    public String getErrorMessageText() {
    	log.info("Getting Warning Message before Signed In");
        return driver.findElement(warnMsg).getText();

    }
    public void clickDataStructureAftsign()
    {
    	log.info("Clicking Data Structure Get Started button after Signed In");
        elementsUtil.doClick(GetStartedBtn_DS);
    }
    public String getDataStructuretitle()
    {
    	log.info("Getting Data Structure Title");
        return driver.findElement(titleDataStructure).getText();
    }
    public void clickArrayAftsign()
    {
    	log.info("Clicking Array Get Started button after Signed In");
        elementsUtil.doClick(GetStartedBtn_Array);
    }
    public String getArraytitle()
    {
    	log.info("Getting Array Title");
        return driver.findElement(titleArray).getText();
    }
    public void clickLinkedListAftsign()
    {
    	log.info("Clicking Linked List Get Started button after Signed In");
        elementsUtil.doClick(GetStartedBtn_LinkedList);
    }
    public String getLinkedListtitle()
    {
    	log.info("Getting Linked List Title");
        return driver.findElement(titleLinkedList).getText();
    }

    public void clickStackAftsign()
    {
    	log.info("Clicking Stack Get Started button after Signed In");
        elementsUtil.doClick(GetStartedBtn_Stack);
    }
    public String getStacktitle()
    {
    	log.info("Getting Stack Title");
        return driver.findElement(titleStack).getText();
    }
    public void clickQueueAftsign()
    {
    	log.info("Clicking Queue Get Started button after Signed In");
        elementsUtil.doClick(GetStartedBtn_Queue);
    }
    public String getQueuetitle()
    {
    	log.info("Getting Queue Title");
        return driver.findElement(titleQueue).getText();
    }
    public void clickTreeAftsign()
    {
    	log.info("Clicking Tree Get Started button after Signed In");
        elementsUtil.doClick(GetStartedBtn_Tree);
    }
    public String getTreetitle()
    {
    	log.info("Getting Tree Title");
        return driver.findElement(titleTree).getText();
    }
    public void clickGraphAftsign()
    {
    	log.info("Clicking Graph Get Started button after Signed In");
        elementsUtil.doClick(GetStartedBtn_Graph);
    }
    public String getGraphtitle()
    {
    	log.info("Getting Graph Title");
        return driver.findElement(titleGraph).getText();
    }
    public void clickRegister()
    {
    	log.info("Clicking Register button from Home Page");
        elementsUtil.doClick(registerButton);
    }
    public void clickSignIn()
    {
    	log.info("Clicking Sign In button from Home Page");
        elementsUtil.doClick(signInButton);
    }
    public boolean isRegisterElementDisplayed() {
        try {
        	log.info("Verifying Register button displayed in Register Page");
            return elementsUtil.waitForElementToBeVisible(registerButton).isDisplayed();
            
        } catch (TimeoutException e) {
            return false;
        }
    }
    public boolean isSignInElementDisplayed() {
        try {
        	log.info("Verifying Sign In button displayed in Sign In Page");
            return elementsUtil.waitForElementToBeVisible(signInButton).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
    public void clickSignOut()
    {
    	log.info("Clicking Sign Out button from Home Page");
        elementsUtil.doClick(signOutButton);
    }
    public String getSuccessMessageText() {
    	log.info("Getting Success Message for LogOut");
        return driver.findElement(successLogOut).getText();
    }


}
