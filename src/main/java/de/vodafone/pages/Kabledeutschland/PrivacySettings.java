package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class PrivacySettings {
    //variables
   private SHAFT.GUI.WebDriver driver;

    //CLs
    private static String PrivacySettingsPageHeader ="Datenschutz-Einstellungen";
    private static String dataProtectionHeaderCL = "Datenschutz";

    // Locators
    private static final By privacySettingsPageHeaderLocator = By.xpath("//div[@automation-id='pageHeader_tv']//h1[contains(text(),'Datenschutz-Einstellungen')]");//div[@automation-id='pageHeader_tv']/h1
    public static final By backButtonLocator = By.xpath("//a[@automation-id='back_Link']");
    private static final By dataProtectionHeaderLocator = By.xpath("//div[@class='headline eq-height']");
    //Constructor
    public PrivacySettings(SHAFT.GUI.WebDriver driver) {
        this.driver=driver;
    }

    //Functions
    public PrivacySettings clickBackbutton(){
        driver.element().isElementClickable(backButtonLocator);
        driver.element().click(backButtonLocator);
        return this;
    }

    public PrivacySettings validatePrivacyPageTitle(){
        driver.verifyThat().element(privacySettingsPageHeaderLocator)
                .text().isEqualTo(PrivacySettingsPageHeader)
                .withCustomReportMessage("Check that page title exists")
                .perform();
        return this;
    }

    public PrivacySettings validateDataProtectionLinkOut(){
//        ArrayList<String> tabs = new ArrayList<String>(driver.getDriver().getWindowHandles());
//        driver.getDriver().switchTo().window(tabs.get(1));
        driver.element().isElementDisplayed(dataProtectionHeaderLocator);
        driver.verifyThat().element(dataProtectionHeaderLocator)
                .text().isEqualTo(dataProtectionHeaderCL)
                .withCustomReportMessage("Check that page title exists")
                .perform();
        return this;
    }
}
