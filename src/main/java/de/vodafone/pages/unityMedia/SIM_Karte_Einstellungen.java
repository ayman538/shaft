package de.vodafone.pages.unityMedia;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SIM_Karte_Einstellungen {
    private SHAFT.GUI.WebDriver driver;
    //Constractor
    public SIM_Karte_Einstellungen (SHAFT.GUI.WebDriver driver)
    {
        this.driver = driver;
    }


    //CLs

    /*Rufnummern_Bereiche_AccordionCLs*/
    public static String rufnummern_Bereiche_ACCHeader_CL = "Rufnummern-Bereiche";
    public static String rufnummern_Bereiche_ACCFooter_CL = "Rufnummern-Sperren einstellen oder aufheben";

 //   public static String rufnummern_Bereiche_ACCText_CL = "Du kannst hier verschiedene Service-Nummern sperren. So verhinderst Du, dass Du diese Nummern versehentlich wählst und dafür zahlen musst. Standardmäßig sind alle Service-Nummern zugelassen.";
    public static String rufnummern_Bereiche_ACC_Info_MsgTextCL = "Bearbeite hier Rufnummern-Sperren für 0900-Service-Nummern. Du kannst auch Teilbereiche sperren oder zulassen, z.B. 0900-1, 0900-3 und so weiter.";
    public static String rufnummern_Bereiche_ACC_Info_MsgTitleCL = "0900-Rufnummern-für-Premium-Dienste";


    //Rufnummern-BereichCLs
    public static String stepperTitle_CL = "Einzelne Rufnummern-Gruppen zulassen";
    public static String stepperHeader_CL = "0900-Rufnummern für Premium-Dienste";
    public static String stepperSubTitle_CL = "Stell hier den Schalter auf „ein“, wenn Du diese 0900-Rufnummern zulassen willst.";


    //Locators
    /*Rufnummern_Bereiche_AccordionLocators*/
    private static final By simKarteSO =By.xpath("(//*[@automation-id='simEsim_so'])[1]");
    private static final By firstPIN = By.xpath("(//*[@class='card-header'])[1]");
    private static final By rufnummern_Bereiche_ACC = By.xpath("//*[@automation-id='rufnummern-bereich_acc']");
    public static final By rufnummern_Bereiche_ACCFooter = By.xpath("//*[@id='rufnummern-bereich']//a/h5");
    public static final By rufnummern_Bereiche_ACCHeader = By.xpath("//*[@id='rufnummern-bereich']//a/h4");
    public static final By page_Title = By.xpath("//*[@automation-id='pageHeader_tv']/h1");
    //public static final By rufnummern_Bereiche_ACCText =By.xpath ("//*[@id='call-settings']//div[1]/text()");
    public static final By rufnummern_Bereiche_ACC_Info_MsgTitle =By.xpath("(//*[@class='serviceName'])[2]");
    public static final By rufnummern_Bereiche_ACC_Info_MsgText = By.xpath("//*[@id='call-settings']/call-settings-accordion//div[3]//p");
    public static final By rufnummern_Bereiche_ACC_Info_MsgBtn = By.xpath("(//*[@class='btn btn-sml btn-em'])[2]");



    private static final By neue_SIM_KarteSO = By.xpath("//*[@automation-id='simSwap_so']");



    //Rufnummern-BereichLocators
     public static final By stepperHeader = By.xpath("//*[@automation-id='oneStepStepperHeader_tv']//strong");
    public static final By stepperTitle = By.xpath("//*[@class='white-box call-setting']//h4");
    public static final By stepperSubTitle = By.xpath("//*[@id='call-setting']/div//div[1]/text()");

    public static final By backButton = By.xpath("//*[@id='transaction-link']");
    public static final By confirmationBtn = By.xpath("//*[@id='call-setting']//div[2]/button");


    //toggles locators
    private static final By toggleBtn1on = By.xpath("(//*[@class='switch fm-flip-switch'])[1]//span[1]");
    private static final By toggleBtn1off = By.xpath("(//*[@class='switch fm-flip-switch'])[1]//span[2]");
    private static final By toggleBtn2on = By.xpath("(//*[@class='switch fm-flip-switch'])[2]//span[1]");
    private static final By toggleBtn2off = By.xpath("(//*[@class='switch fm-flip-switch'])[2]//span[2]");
    private static final By toggleBtn3on = By.xpath("(//*[@class='switch fm-flip-switch'])[3]//span[1]");
    private static final By toggleBtn3off = By.xpath("(//*[@class='switch fm-flip-switch'])[3]//span[2]");
    private static final By toggleBtn4on = By.xpath("(//*[@class='switch fm-flip-switch'])[4]//span[1]");
    private static final By toggleBtn4off = By.xpath("(//*[@class='switch fm-flip-switch'])[4]//span[2]");

    //NOTIFICATION MESSAGES LOCATORS
    private static final By feedback_Msg_Close_BTN = By.xpath("//*[@id='kplDeclineButton']");




    /* ***Methods*** */


    public void FeedbackMsgFound()
    {
        driver.element().getElementsCount(feedback_Msg_Close_BTN);
        if (driver.element().getElementsCount(feedback_Msg_Close_BTN)!=0)
        {
            driver.element().click( feedback_Msg_Close_BTN);
        }
        else
        {
            Assert.assertTrue(true,"Element not clicked as it didn't appear");
        }
    }


    public void clickOnRufnummern_Bereiche() {
        driver.element().click( rufnummern_Bereiche_ACC);
    };

    public void clickOnRufnummern_BereicheACC_Info_MsgBtn(){

        driver.element().click( rufnummern_Bereiche_ACC_Info_MsgBtn);}

    public void changetoggle1()
    {
        if (driver.element().isElementDisplayed(toggleBtn1on))
        {
            driver.element().click(toggleBtn1on);
        }
        else
        {
            driver.element().click(toggleBtn1off);
        }
    }
    public void changetoggle2()
    {
        if (driver.element().isElementDisplayed(toggleBtn2on))
        {driver.element().click(toggleBtn2on);}
        else
        {driver.element().click(toggleBtn2off);}
    }
    public void changetoggle3()
    {
        if (driver.element().isElementDisplayed(toggleBtn3on))
        {
            driver.element().click(toggleBtn3on);
        }
        else
        {
            driver.element().click(toggleBtn3off);
        }
    }
    public void changetoggle4()
    {
        if (driver.element().isElementDisplayed(toggleBtn4on))
        {
            driver.element().click(toggleBtn4on);
        }
        else
        {
            driver.element().click(toggleBtn4off);
        }
    }
   /*public void changetoggle1toOFF() {  driver.element().click(toggleBtn1on);  }
    public void changetoggle2toOFF() {  driver.element().click(toggleBtn2on);  }
    public void changetoggle3toOFF() {  driver.element().click(toggleBtn3on);  }
    public void changetoggle4toOFF() {  driver.element().click(toggleBtn4on);  }
    public void changetoggle1toOn() {  driver.element().click(toggleBtn1off);  }
    public void changetoggle2toOn() {  driver.element().click(toggleBtn2off);  }
    public void changetoggle3toOn() {  driver.element().click(toggleBtn3off);  }
    public void changetoggle4toOn() {  driver.element().click(toggleBtn4off);  }*/

    public void clickOnConfirmationBtn() {
        driver.element().click( confirmationBtn);
    }

    public void clickOnNeue_SIM_KarteSO() {
        driver.element().click( neue_SIM_KarteSO);
        Validations.assertThat().element(driver.getDriver(), Neue_SIM_Karte_bestellen.SubTitle).exists();

    }
    public void clickOnSIMKarteSO(){
        driver.element().click( simKarteSO);
    }
    public void clickOnSubscriberPIN(){
        driver.element().click( firstPIN);
    }
}

