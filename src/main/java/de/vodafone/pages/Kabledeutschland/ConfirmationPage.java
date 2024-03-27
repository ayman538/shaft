package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ConfirmationPage {
    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Locators
    private By accordionTitle_Locator = By.xpath("//a[@class='ac-head']//span");
    private By rufnummerSection_Locator = By.xpath("//p[@automation-id='confirmationTelephoneNumber_tv']");
    private By evnLabel_Locator = By.xpath("//p[@automation-id='confirmationBillingType_tv']/strong");
    private By evnDescription_Locator = By.xpath("//p[@automation-id='confirmationBillingType_tv']/span");
    private By mitbenutzerSection_Locator = By.xpath("//p[@automation-id='confirmationLegal_tv']");
    private By greenNotificationTitle_Locator = By.xpath
            ("//notification[@automation-id='confirmationNotificationSuccessSingle_nt']//h4");
    private By greenNotificationText_Locator = By.xpath
            ("//notification[@automation-id='confirmationNotificationSuccessSingle_nt']//p");
    private By errorNotificationTitle_Locator = By.xpath("//notification//h4");
    private By errorNotificationDescription_Locator = By.xpath("//notification//p");

    //Methods
    public ConfirmationPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    @Step("expand confirmation accordion")
    public void expandConfirmationAcc(){
        driver.element().click(accordionTitle_Locator);
    }

    //CLs
    private String accordionTitle_CL = "Übersicht";
    private String rufnummerHeaderSection_CL = "Rufnummer:";
    private String consumerRufnummerDescriptionSection_CL = "Der bearbeitete Status wird für alle Telefonnummern dieses Kontos übernommen";
    private String sohoRufnummerDescriptionSection_CL = "Deine Einstellung wird für alle Rufnummern dieses Kontos übernommen.";
    private String evnLabel_CL = "EVN:";
    private String mitbenutzerSection_CL = "Mitbenutzer:innen-Erklärung:";
    private String mitbenutzerDescription_CL = "Erteilt";
    private String greenNotificationConsumerText_CL = "Deine Änderung haben wir gespeichert";
    private String greenNotificationSohoTitle_CL = "Vielen Dank!";
    private String greenNotificationSohoText_CL = "Wir haben Deine Änderungen gespeichert. Es kann einen Augenblick dauern, bis diese aktiviert sind.";
    private String errorNotificationTitle_CL = "Das hat leider nicht geklappt";
    private String errorNotificationDescription_CL = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";



    //Validations
    public void assertOnConsumerSuccessNotification(){
        driver.verifyThat().element(greenNotificationTitle_Locator).text().contains(greenNotificationConsumerText_CL).withCustomReportMessage("Assert on success consumer notification").perform();
    }

    public void assertOnAccordionTitle(){
        driver.verifyThat().element(accordionTitle_Locator).text().contains(accordionTitle_CL).withCustomReportMessage("Assert on accordion title").perform();
    }

    public void assertOnRufnummerHeaderSectionText(){
        driver.verifyThat().element(rufnummerSection_Locator).text().contains(rufnummerHeaderSection_CL).withCustomReportMessage("Assert on Consumer rufnummer header section text").perform();
    }

    public void assertOnConsumerRufnummerDescriptionSectionText(){
        driver.verifyThat().element(rufnummerSection_Locator).text().contains(consumerRufnummerDescriptionSection_CL).withCustomReportMessage("Assert on consumer rufnummer description section text").perform();
    }

    public void assertOnEvnLabel(){
        driver.verifyThat().element(evnLabel_Locator).text().contains(evnLabel_CL).withCustomReportMessage("Assert on EVN label").perform();
    }

    public void assertOnEvnDescription(String newOption){
        driver.verifyThat().element(evnDescription_Locator).text().contains(newOption).withCustomReportMessage("Assert on EVN description").perform();
    }

    public void assertOnMitbenutzerSectionHeaderText(){
        driver.verifyThat().element(mitbenutzerSection_Locator).text().contains(mitbenutzerSection_CL).withCustomReportMessage("Assert on mitbenutzer Section text").perform();
    }
    public void assertOnMitbenutzerSectionDezcriptionText(){
        driver.verifyThat().element(mitbenutzerSection_Locator).text().contains(mitbenutzerDescription_CL).withCustomReportMessage("Assert on mitbenutzer Section text").perform();
    }



    public void assertOnErrorNotificationTitle(){
        driver.verifyThat().element(errorNotificationTitle_Locator).text().contains(errorNotificationTitle_CL).withCustomReportMessage("Assert on error notification title").perform();
    }

    public void assertOnErrorNotificationDescription(){
        driver.verifyThat().element(errorNotificationDescription_Locator).text().contains(errorNotificationDescription_CL).withCustomReportMessage("Assert on error notification description").perform();
    }

    public void assertOnSohoSuccessNotificationTitle(){
        driver.verifyThat().element(greenNotificationTitle_Locator).text().contains(greenNotificationSohoTitle_CL).withCustomReportMessage("Assert on success soho notification").perform();
    }

    public void assertOnSohoSuccessNotificationText(){
        driver.verifyThat().element(greenNotificationText_Locator).text().contains(greenNotificationSohoText_CL).withCustomReportMessage("Assert on success soho notification").perform();
    }

    public void assertOnSohoRufnummerDescriptionSectionText(){
        driver.verifyThat().element(rufnummerSection_Locator).text().contains(sohoRufnummerDescriptionSection_CL).withCustomReportMessage("Assert on Soho rufnummer description section text").perform();
    }
}
