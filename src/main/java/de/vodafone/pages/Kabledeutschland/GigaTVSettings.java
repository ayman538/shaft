package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class GigaTVSettings {
    private SHAFT.GUI.WebDriver driver;

    //CLs
    private static String gigaTV_CL = "GigaTV-Geräte";
    private static String gigaTVSO_Footer_CL = "Deine GigaTV-Geräte verwalten";
    private static String gigaTVACC_Footer_CL = "Leg fest, welche Geräte Zugriff auf die GigaTV-App haben";
    private static String gigaTVNotificationTitle_CL = "Gut zu wissen";
    private static String gigaTVNotificationDescription_CL = "Bald kannst Du hier Deine GigaTV-Geräte verwalten.";


    //Giga TV Locators
    private static final By gigaTV_SO = By.xpath("//div[@automation-id='cableGigatv_so']");
    private static final By gigaTV_SO_Header = By.xpath("//div[@automation-id='cableGigatv_so']//h3");
    private static final By gigaTV_SO_Footer = By.xpath("//div[@automation-id='cableGigatv_so']//div[@class='sb-block-footer']");
    private static final By gigaTV_ACC = By.xpath("//li[@automation-id='gigatv_acc']");
    private static final By gigaTV_ACC_Footer = By.xpath("//li[@automation-id='gigatv_acc']//h5");
    private static final By gigaTV_ACC_Header = By.xpath("(//li[@automation-id='gigatv_acc']//h4)[1]");
    private static final By gigaTVNotificationTitle = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private static final By gigaTVNotificationDescription = By.xpath("//div[@automation-id='successMsg_tv']//p");


    //constructor
    public GigaTVSettings(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Validate Giga Tv Smart Object is displayed in GigaTV Settings page")
    public GigaTVSettings validateGigaTvSOAppears() {
        driver.element().isElementDisplayed(gigaTV_SO_Header);
        driver.verifyThat()
                .element(gigaTV_SO_Header)
                .text()
                .contains(gigaTV_CL)
                .withCustomReportMessage("Validate Giga Tv Smart Object Header Text")
                .perform();

        driver.verifyThat()
                .element(gigaTV_SO_Footer)
                .text()
                .contains(gigaTVSO_Footer_CL)
                .withCustomReportMessage("Validate Giga Tv Smart Object Footer Text")
                .perform();
        return this;
    }

    @Step("Click On Giga Tv Smart Object On GigaTV Settings Page")
    public GigaTVSettings clickOnGigaTVSmartObject() {
        driver.element().click(gigaTV_SO);
        return this;
    }

    @Step("Validate Giga TV Accordion is displayed")
    public GigaTVSettings validateGigaTVAccAppears() {
        driver.assertThat()
                .element(gigaTV_ACC)
                .exists()
                .withCustomReportMessage("Validate Giga TV Accordion is displayed")
                .perform();

        driver.assertThat()
                .element(gigaTV_ACC_Header)
                .text()
                .contains(gigaTV_CL)
                .withCustomReportMessage("Validate Giga TV Accordion Header Text")
                .perform();

        driver.assertThat()
                .element(gigaTV_ACC_Footer)
                .text()
                .contains(gigaTVACC_Footer_CL)
                .withCustomReportMessage("Validate Giga TV Accordion Footer Text")
                .perform();
        return this;
    }

    @Step("validate Giga TV notification")
    public void validateGigaTVNotification() {
        driver.assertThat()
                .element(gigaTVNotificationTitle)
                .text()
                .contains(gigaTVNotificationTitle_CL)
                .withCustomReportMessage("Validate Giga TV notification Title Text")
                .perform();

        driver.assertThat()
                .element(gigaTVNotificationDescription)
                .text()
                .contains(gigaTVNotificationDescription_CL)
                .withCustomReportMessage("Validate Giga TV notification description Text")
                .perform();
    }


}

