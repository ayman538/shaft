package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ActivateSmartCardEntryPoint {
    //Variables
    private SHAFT.GUI.WebDriver driver;



    //Locators
    public static final By TV_Accordion = By.xpath("//span[@class='mbo-name break-word' and contains(., 'TV')]");
    public static final By TV_Settings_SO = By.xpath("//*[@automation-id='TV_settings_so']");
    public static final By Activate_SmartCard_SO = By.xpath("(//*[@automation-id=\"smartcard_so\"])[2]");
    public static final By Activate_SmartCard_SO_Title = By.xpath("//*[@automation-id=\"smartcard_so\"]/div/h3");
    public static final By Activate_SmartCard_SO_Desc = By.xpath("//div[@automation-id=\"smartcard_so\"]//div[@class='sb-block-footer']");
    public static final By Activate_SmartCard_SO_Icon = By.xpath("(//*[@class=\"icon-circle-i-mdm w-70 smart-object-svg-icon\"])[4]");
    public static final By Activate_SmartCard_SO_InPage = By.xpath("//*[@automation-id=\"smartcard_so\"]");
    public static final By Activate_SmartCard_Container = By.xpath("//*[@automation-id=\"smartcard_acc\"]/div");
    public static final By Back_Dashboard_Btn = By.xpath("//*[@automation-id=\"back_Link\"]");

    //CLs
    public static String Activate_SmartCard_SO_Title_CL = "Smartcard aktivieren";
    public static String Activate_SmartCard_SO_Desc_CL = "Smartcard selbst aktivieren und Sender freischalten";

    public ActivateSmartCardEntryPoint(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    //Methods
    public ActivateSmartCardEntryPoint ExpandTVProductAccordion() {
        driver.element().click(TV_Accordion);
        return this;
    }

    public ActivateSmartCardEntryPoint NavigateToActivateSmartCardAccordionFromDashboard() {
        driver.element().click(Activate_SmartCard_SO);
        driver.verifyThat().element(Activate_SmartCard_Container).exists().perform();
        return this;
    }

    public ActivateSmartCardEntryPoint NavigateToActivateSmartCardAccordionFromSettings() {
        driver.element().click(TV_Settings_SO);
        driver.element().click(Activate_SmartCard_SO_InPage);
        driver.verifyThat().element(Activate_SmartCard_Container).exists().perform();
        return this;
    }

    public ActivateSmartCardEntryPoint BackToDashboard() {driver.element().click(Back_Dashboard_Btn);
        driver.verifyThat().element(TV_Accordion).exists().perform();
        return this;
    }

    public ActivateSmartCardEntryPoint ValidateActivateSmartCardSO() {
        driver.verifyThat().element(Activate_SmartCard_SO).exists().perform();
        driver.verifyThat().element(Activate_SmartCard_SO_Desc)
                .textTrimmed().isEqualTo(Activate_SmartCard_SO_Desc_CL)
                .perform();
        driver.verifyThat().element(Activate_SmartCard_SO_Title)
                .textTrimmed().isEqualTo(Activate_SmartCard_SO_Title_CL)
                .perform();
        driver.verifyThat().element(Activate_SmartCard_SO_Icon).exists().perform();
        return this;
    }
}