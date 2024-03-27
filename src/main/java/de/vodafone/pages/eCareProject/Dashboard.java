package de.vodafone.pages.eCareProject;


import com.shaft.driver.SHAFT;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import org.openqa.selenium.By;
import org.testng.Assert;


public class Dashboard {
    // Variables
    private SHAFT.GUI.WebDriver driver;



    //CLs
    public static String Datenschutz_MenuItem_Link = "Datenschutz";
    public static String Datenschutz_SO_HeaderText = "Datenschutz- & Werbe-Einstellungen";
    public static String Datenschutz_SO_FooterText = "Hier schützt Du Deine Privatsphäre";
    public static String Datenschutz_Accordion_HeaderText = "Datenschutz & Werbeeinstellungen";
    public static String Datenschutz_Accordion_FooterText = "Hier schützt Du Deine Privatsphäre";


    //Locators
    public static By loginIndicator = By.xpath("//span[@class='indicator' and @style='display: block;']");
    public static By STloginIndicator = By.xpath("//div[@class='dashHeader']/h1");
    private By internetAndPhone_accordion = By.xpath("//span[@class='mbo-name' and contains(text(),'Internet & Phone')]");
    public static By einstellungen_SmartObject = By.xpath("//h3[contains(text(),'te & Einstellungen')]");
    public static By meineKundendaten_Tile =By.xpath("//a[@automation-id='Meine Kundendaten_btn']");
    public static By bewOverlayDismissDashboard =By.xpath("//div/a[@class='btn btn-alt' and @ng-click='submit(cta.buttonAction)']");
    public static By bewOverlayAcceptDashboard =By.xpath("//div[@class='overlay-content']//a[@class='btn' and contains(text(),'Ja')]");
    public static By bewOverlayAcceptSuccessMessage =By.xpath("//div[contains(@class,'alert success')]//h4");
    public static By DashboardTitle =By.xpath("//*[@class='dashHeader']");
    public static By KABEL_TV_BURGER_MENU =By.xpath("(//*[@class='expert-mode'])[2]");
    public static By DATENSCHUTZ_MENU_ITEM_LINK =By.xpath("(//*[@class='dashHeader'])[2]");
    //Dashboard email notification message ignoring
    public static final By MSG_Container = By.xpath("//*[@class=\"notification-message-container\"]");
    public static final By Close_BTN = By.xpath("//*[@class=\"icon-close-i-xxsml i-xxsml\"]");
    public static final By Mein_Tarif_SO = By.xpath("(//*[@automation-id='_so'])[2]");
    public static final By Change_Tarif_Btn = By.xpath("(//*[@automation-id='undefined_rb'])[3]");
    public static final By Weiter_Btn = By.xpath("(//*[@class='btn btn-em'])[5]");
    public static final By PDF_Link = By.xpath("((//*[@class='white-box'])[2]//strong)[6]");






    //constructor
    public Dashboard(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }




//keywords



    public MeineDaten openMeineKundenDatenTile(DashboardSmartObject card) {
        switch (card) {
            case MEINEKUNDENDATEN -> {
                driver.element().click( meineKundendaten_Tile);
//return new MeineKundendaten(driver.getDriver());
            }
        }
        return new MeineDaten(driver);
    }



    public void clickDismissBEWOverlay (){
        driver.element().click(bewOverlayDismissDashboard);
    }



    public MeineDaten openTile(DashboardSmartObject card) {
        switch (card) {
            case MEINEKUNDENDATEN -> {
                driver.element().click( meineKundendaten_Tile);
            }
        }
        return new MeineDaten(driver);
    }





    public void clickKabelTVBurgerMenu (){
        driver.element().click(KABEL_TV_BURGER_MENU);
    }



    public void clickDatenSchutzMenuItem (){
        driver.element().click(DATENSCHUTZ_MENU_ITEM_LINK);
    }



    public void isBEWOverlayfound()
    {
// WebDriverWait wait =new WebDriverWait(driver.getDriver(),30);
// wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
        driver.element().getElementsCount(bewOverlayAcceptDashboard);
        if (driver.element().getElementsCount(bewOverlayAcceptDashboard)!=0)
        {
            driver.element().click(bewOverlayAcceptDashboard);
        }
        else
        {
            Assert.assertTrue(true,"Element not clicked as it didn't appear");
        }
    }
    public void IsEmailMsgFound()
    {
        driver.element().getElementsCount(MSG_Container);
        if (driver.element().getElementsCount(MSG_Container)!=0)
        {
            driver.element().click(Close_BTN);
        }
        else
        {
            Assert.assertTrue(true,"Element not clicked as it didn't appear");
        }
    }

    public void IgnoreDashboardNotifications() throws InterruptedException {
        new de.vodafone.pages.Kabledeutschland.Dashboard(driver).isBEWOverlayfound();
        new de.vodafone.pages.Kabledeutschland.Dashboard(driver).IsEmailMsgFound();
    }



    public enum DashboardSmartObject {
        MEINEKUNDENDATEN
    }



    public enum DashboardAccordion {
        KABELVERTRAG
    }

    public void clickMeinTarif (){
        driver.element().click(Mein_Tarif_SO);
    }

    public void clickChangeTarif (){
        driver.element().click(Change_Tarif_Btn);
    }

    public void clickWeiterBtn (){
        driver.element().click(Weiter_Btn);
    }

    public void clickPDFLink (){
        driver.element().click(PDF_Link);
    }


}