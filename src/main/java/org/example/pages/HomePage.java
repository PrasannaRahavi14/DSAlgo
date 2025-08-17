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
    private By GetStartedBtn_Tree = By.xpath("//a[@href='tree']");
    private By arrayGet=By.xpath("/html/body/div[2]/div[2]/div/div/a");
    private By linkedListGet=By.xpath("/html/body/div[3]/div[3]/div/div/a");
    private By stackGet=By.xpath("/html/body/div[2]/div[4]/div/div/a");
    private By queueGet=By.xpath("/html/body/div[2]/div[5]/div/div/a");
    private By graphGet=By.xpath("/html/body/div[2]/div[7]/div/div/a");
    private By dataDrpdown= By.xpath("//a[@class='nav-link dropdown-toggle']");
    private By arraysDrpdown= By.xpath("//*[@id=\"navbarCollapse\"]/div[1]/div/div/a[1]");
    private By linkedListDrpdown=By.xpath("//*[@id=\"navbarCollapse\"]/div[1]/div/div/a[2]");
    private By stackDrpdown=By.xpath("//*[@id=\"navbarCollapse\"]/div[1]/div/div/a[3]");
    private By queueDrpdown=By.xpath("//*[@id=\"navbarCollapse\"]/div[1]/div/div/a[4]");
    private By treeDrpdown= By.xpath("//*[@id=\"navbarCollapse\"]/div[1]/div/div/a[5]");
    private By graphDrpdown= By.xpath("//*[@id=\"navbarCollapse\"]/div[1]/div/div/a[6]");
    private By titleDataStructure=By.xpath("//h4[text()='Data Structures-Introduction']");
    private By titleArray=By.xpath("/html/body/div[2]/h4");
    private By titleLinkedList=By.xpath("//h4[text()='Linked List']");
    private By titleStack=By.xpath("//h4[text()='Stack']");
    private By titleQueue=By.xpath("//h4[text()='Queue']");
    private By titleTree=By.xpath("//h4[text()='Tree']");
    private By titleGraph=By.xpath("//h4[text()='Graph']");
    private By DSAfterSignIn=By.xpath("/html/body/div[3]/div[1]/div/div/a");
    private By AAfterSignIn=By.xpath("/html/body/div[3]/div[2]/div/div/a");
    private By LLAfterSignIn=By.xpath("/html/body/div[3]/div[3]/div/div/a");
    private By SAfterSignIn=By.xpath("/html/body/div[3]/div[4]/div/div/a");
    private By QAfterSignIn=By.xpath("/html/body/div[3]/div[5]/div/div/a");
    private By TAfterSignIn=By.xpath("/html/body/div[3]/div[6]/div/div/a");
    private By GAfterSignIn=By.xpath("/html/body/div[3]/div[7]/div/div/a");
    private By warnMsg=By.xpath("//div[@class='alert alert-primary']");
    private By registerButton=By.xpath("//a[text()=' Register ']");
    private By signInButton=By.xpath("//a[text()='Sign in']");
    private By signOutButton=By.xpath("//a[text()='Sign out']");
    private By successLogOut=By.xpath("/html/body/div[2]");


    public HomePage(WebDriver driver)
    {

        this.driver = driver;
        this.elementsUtil = new ElementsUtil(driver);
    }

    public String getTitle()
    {
        log.info("Getting the title of HomePage");
       // return driver.findElement(PageTitle).getText();
        return elementsUtil.doGetText(PageTitle);
    }

    public void clickSignInLink()
    {
        log.info("Clicking on the SignIn Link from the HomePage");
        //driver.findElement(SignInLink).click();
        elementsUtil.doClick(SignInLink);
    }

    public String CheckName()
    {
        log.info("Successfully logged in");
        //return driver.findElement(NameCheckAfterLogin).getText();
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
        return elementsUtil.doGetText(PageTitle);
    }

    public void clickArrayGet()
    {
        elementsUtil.doClick(arrayGet);
    }
    public void clickLinkedListGet()
    {
        elementsUtil.doClick(linkedListGet);
    }
    public void clickStackGet()
    {
        elementsUtil.doClick(stackGet);
    }

    public void clickQueueGet() {

        elementsUtil.doClick(queueGet);
    }
   public void clickGraphGet() {

        elementsUtil.doClick(graphGet);
    }
    public void clickDrpdown() {
        elementsUtil.doClick(dataDrpdown);
    }
    public void clickArraysDrpdown() {
        elementsUtil.doClick(arraysDrpdown);
    }
    public void clickLinkedListDrpdown() {
        elementsUtil.doClick(linkedListDrpdown);
    }
    public void clickStackDrpdown() {
        elementsUtil.doClick(stackDrpdown);
    }
    public void clickQueueDrpdown() {
        elementsUtil.doClick(queueDrpdown);
    }
    public void clickTreeDrpdown() {
        elementsUtil.doClick(treeDrpdown);
    }
    public void clickGraphDrpdown() {
        elementsUtil.doClick(graphDrpdown);
    }
    public String getErrorMessageText() {
        return driver.findElement(warnMsg).getText();

    }
    public void clickDSAftsign()
    {
        elementsUtil.doClick(DSAfterSignIn);
    }
    public String getDataStructuretitle()
    {
        return driver.findElement(titleDataStructure).getText();
    }
    public void clickAAftsign()
    {
        elementsUtil.doClick(AAfterSignIn);
    }
    public String getArraytitle()
    {
        return driver.findElement(titleArray).getText();
    }
    public void clickLLAftsign()
    {
        elementsUtil.doClick(LLAfterSignIn);
    }
    public String getLinkedListtitle()
    {
        return driver.findElement(titleLinkedList).getText();
    }

    public void clickSAftsign()
    {
        elementsUtil.doClick(SAfterSignIn);
    }
    public String getStacktitle()
    {
        return driver.findElement(titleStack).getText();
    }
    public void clickQAftsign()
    {
        elementsUtil.doClick(QAfterSignIn);
    }
    public String getQueuetitle()
    {
        return driver.findElement(titleQueue).getText();
    }
    public void clickTAftsign()
    {
        elementsUtil.doClick(TAfterSignIn);
    }
    public String getTreetitle()
    {
        return driver.findElement(titleTree).getText();
    }
    public void clickGAftsign()
    {
        elementsUtil.doClick(GAfterSignIn);
    }
    public String getGraphtitle()
    {
        return driver.findElement(titleGraph).getText();
    }
    public void clickRegister()
    {
        elementsUtil.doClick(registerButton);
    }
    public void clickSignIn()
    {
        elementsUtil.doClick(signInButton);
    }
    public boolean isRegisterElementDisplayed() {
        try {
            return elementsUtil.waitForElementToBeVisible(registerButton).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
    public boolean isSignInElementDisplayed() {
        try {
            return elementsUtil.waitForElementToBeVisible(signInButton).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
    public void clickSignOut()
    {
        elementsUtil.doClick(signOutButton);
    }
    public String getSuccessMessageText() {
        return driver.findElement(successLogOut).getText();
    }


}
