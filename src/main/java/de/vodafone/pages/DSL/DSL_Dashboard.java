package de.vodafone.pages.DSL;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class DSL_Dashboard {

    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public DSL_Dashboard(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Element Locators
    private By meinTarifSO =  By.xpath("(//div[@automation-id='_so']//h3 [contains(.,'Mein Tarif')])");
    private By contractContainer= By.xpath("//ul[@automation-id='dashboardListContainerlv']");
    private By soContainer = By.xpath("//div[@class=\"sb-sushibar\"]");
    private By productTitle = By.xpath("//span[@class='mbo-name mbo-name-fixednet']");
    private static By MyProductsAcc = By.xpath("//div[@class='expert-mode dots-menu']");
    static By MyProductsAccII = By.xpath("(//div[@class='expert-mode dots-menu'])[2]");
    private static By MyProducts = By.xpath("(//*[text()='Meine Produkte'])[2]");
    static By MyProductsII = By.xpath("(//*[text()='Meine Produkte'])[4]");
    //private static By closeNotification_button = By.cssSelector("svg.icon-close-i-xxsml.i-xxsml");
    private static By closeNotification_button = By.xpath("(//*[@class='icon-close-i-xxsml i-xxsml'])[1]");
    private static By NotificationX = By.xpath("//*[@ng-click='vm.closeNotification(vm.notificationModel ,true);  $event.stopPropagation();']");
    public static By StatusSO_Locator = By.xpath("(//*[@automation-id='_so'])[1]");
    public static By StatusSO_HeaderLocator = By.xpath("(//*[@automation-id='_so'])[1]//h3");
    public static By StatusSO_TextLocator = By.xpath("//*[text()='Auftrag in Bearbeitung ']");
    public static By SecondSubscriberAccLocator = By.xpath("(//*[@id='dashboard:fixed'])[2]");
    public static By meineRechnungenBtn = By.xpath("(//a[@href='meinerechnung'])[1]");
    //CLs
    public static String StatusSO_HeaderCL = "Bearbeitungsstand";
    public static String StatusSO_TextCL = "Auftrag in Bearbeitung";


    //Methods
    public DSL_Dashboard closeEmailNotification() {
        driver.element().click( closeNotification_button);
        return new DSL_Dashboard(driver);
    }

    public MyDSLProducts chooseMyProductsFromMyProductsAcc() {
        driver.element().click(MyProductsAcc);
        driver.element().click(MyProducts);
        return new MyDSLProducts(driver);
    }

    public MyDSLProducts chooseMyProductsFromMyProductsSecondAcc() {
        driver.element().click(MyProductsAccII);
        driver.element().click(MyProductsII);
        return new MyDSLProducts(driver);
    }

    public StatusPage click(By Element){
        WebElement element = driver.getDriver().findElement(Element);
        ((JavascriptExecutor) driver.getDriver()).executeScript("arguments[0].click();", element);
        return new StatusPage(driver);
    }

    public DSL_Dashboard closeNotification() {
        driver.element().waitToBeReady(NotificationX);
        driver.element().click( NotificationX);
        return new DSL_Dashboard(driver);
    }

    @Step("Click on Mein Tarif SO to redirect to My products page")
    public DSL_Dashboard clickOnMeinTarifSO(){
        driver.verifyThat().element(contractContainer).exists().perform();
        driver.verifyThat().element(productTitle).exists().perform();
        driver.verifyThat().element(soContainer).isVisible();
        driver.element().click(meinTarifSO);
        return this;
    }

    @Step("Click on Meine Rechnungen page")
    public DSL_Dashboard clickOnMeineRechnungen(){
        driver.element().click(meineRechnungenBtn);
        return this;
    }
}
