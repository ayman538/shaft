package de.vodafone.pages.unityMedia;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class KabelTV {
   private SHAFT.GUI.WebDriver driver;
    //CLs

    public static String SmartcardAktivierenTitle_CL= "Smartcard aktivieren";
    public static String SmartcardAktivierenSOFooter_CL= "Smartcard selbst aktivieren und Sender freischalten";
    public static String SmartcardAktivierenAccText_CL= "Mit unserer Anleitung kannst Du Deine Smartcards ganz einfach selbst aktivieren.";
    public static String SmartcardAccCTACL= "Zur Aktivierung";
    public static String SmartcardAktivierenHeader_CL= "Smartcards ganz einfach selbst aktivieren";
    public static String SmartcardAktivierenBody_CL= "Du bekommst auf Deinen abonnierten Sendern die Fehlermeldung \"Sender ist verschlüsselt\" oder \"Smartcard ist nicht aktiviert\"? Hier kannst Du die Sender mit einem Klick selbst freischalten.";





    //Locators
    public static By KabelTV_SmartcardaktivierenSO =By.xpath("//*[@automation-id='smartCard_so']");
    public static final By SmartcardAktivierenSOTitle= By.xpath("//*[@automation-id='smartcard_so']//h3");
    public static final By SmartcardAktivierenSOFooter= By.xpath("//*[@automation-id='smartcard_so'] //smart-object-footer/div");
    public static final By SmartcardAktivierenAccText= By.xpath("//*[@automation-id='smartcard_acc']//h5");
    public static final By SmartcardAccCTA= By.xpath("//*[@automation-id='activateSMCardTrans_btn']");
    public static final By SmartcardAktivierenHeader= By.xpath("//*[@automation-id='activateSMCardHeader_tv']");
    public static final By SmartcardAktivierenBody= By.xpath("//*[@automation-id='activateSMCardbody_tv']");



    public KabelTV(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Keywords

    public KabelTV openCard (KabelTV.KabelTVCards card) {
        switch (card) {
            case SmartCardAktivation -> {
                driver.element().click( KabelTV_SmartcardaktivierenSO);
            }
        }
        return this;
    }



    public void clickOnSmartCardAcctivationSO()
    { driver.element().click( KabelTV_SmartcardaktivierenSO);}

    public void clickOnSmartcardaktivierenCTA()
    {driver.element().click(SmartcardAccCTA ); }



    public enum KabelTVCards {
        SmartCardAktivation
    }

}
