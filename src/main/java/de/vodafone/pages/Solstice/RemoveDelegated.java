package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class RemoveDelegated {


    private SHAFT.GUI.WebDriver driver;


    //Story 12255 locators and Strings

    public static By backBTN = By.xpath("(//*[text()='Abbrechen'])[1]");
    protected static String backBTN_text ="Abbrechen";

    public static By pageHeader = By.xpath("//*[@automation-id='pageHeader_tv']/h1");
    protected static String pageHeader_text ="Vertrag oder Teilnehmer aus dem MeinVodafone-Konto entfernen";

    public static By areYouSure = By.xpath("//*[text()='Bist Du sicher?']");
    protected static String areYouSure_text ="Bist Du sicher?";

    public static By warningDescription = By.xpath("//*[text()='Mit einem Klick unten bestätigst Du, dass Du den Vertrag oder Teilnehmer nicht mehr in MeinVodafone verwalten möchtest.']");
    protected static String warningDescription_text ="Mit einem Klick unten bestätigst Du, dass Du den Vertrag oder Teilnehmer nicht mehr in MeinVodafone verwalten möchtest.";

    public static By warningTitle = By.xpath("//*[text()='Gut zu wissen']");
    protected static String warningTitle_text ="Gut zu wissen";

    public static By warningBody = By.xpath("//*[text()='Du kannst dann auch nicht mehr die Alternativen zum Benutzernamen für den Login nutzen.']");
    protected static String warningBody_text ="Du kannst dann auch nicht mehr die Alternativen zum Benutzernamen für den Login nutzen.";

    public static By willBeDelete = By.xpath("//*[text()='Gelöscht wird:']");
    protected static String willBeDelete_text ="Gelöscht wird:";

    public static By deleteCTAbutton = By.xpath("//*[text()='Aus MeinVodafone löschen']");
    protected static String deleteCTAbutton_text ="Aus MeinVodafone löschen";
    public static By warningDescriptionProduct = By.xpath("//*[text()='Mit einem Klick unten bestätigst Du, dass Du den Vertrag oder das Produkt nicht mehr in MeinVodafone verwalten willst.']");
    protected static String warningDescriptionProduct_text ="Mit einem Klick unten bestätigst Du, dass Du den Vertrag oder das Produkt nicht mehr in MeinVodafone verwalten willst";








    public RemoveDelegated(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // validations methods
    public void validationNotifictionMessage_Contract(){

        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.backBTN)
                .text()
                .contains(RemoveDelegated.backBTN_text)
                .withCustomReportMessage("Check back button")
                .perform();


        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.pageHeader)
                .text()
                .contains(RemoveDelegated.pageHeader_text)
                .withCustomReportMessage("Check page header")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.areYouSure)
                .text()
                .contains(RemoveDelegated.areYouSure_text)
                .withCustomReportMessage("Check confirmation header msg")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.warningDescription)
                .text()
                .contains(RemoveDelegated.warningDescription_text)
                .withCustomReportMessage("Check warning description msg")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.warningTitle)
                .doesNotExist()
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.warningBody)
                .doesNotExist()
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.willBeDelete)
                .text()
                .contains(RemoveDelegated.willBeDelete_text)
                .withCustomReportMessage("Check confirmation deletion")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.deleteCTAbutton)
                .text()
                .contains(RemoveDelegated.deleteCTAbutton_text)
                .withCustomReportMessage("Check delete CTA button")
                .perform();
    }
    public  void VerifyNotifictions_message_product()
    {

        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.backBTN)
                .text()
                .contains(RemoveDelegated.backBTN_text)
                .withCustomReportMessage("Check back button")
                .perform();


        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.pageHeader)
                .text()
                .contains(RemoveDelegated.pageHeader_text)
                .withCustomReportMessage("Check page header")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.areYouSure)
                .text()
                .contains(RemoveDelegated.areYouSure_text)
                .withCustomReportMessage("Check confirmation header msg")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.warningDescriptionProduct)
                .text()
                .contains(RemoveDelegated.warningDescriptionProduct_text)
                .withCustomReportMessage("Check warning description msg")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.warningTitle)
                .doesNotExist()
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.warningBody)
                .doesNotExist()
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.willBeDelete)
                .text()
                .contains(RemoveDelegated.willBeDelete_text)
                .withCustomReportMessage("Check confirmation deletion")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.deleteCTAbutton)
                .text()
                .contains(RemoveDelegated.deleteCTAbutton_text)
                .withCustomReportMessage("Check delete CTA button")
                .perform();

    }
    public void verifyRemove_delgatedContract(){


        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.backBTN)
                .text()
                .contains(RemoveDelegated.backBTN_text)
                .withCustomReportMessage("Check back button")
                .perform();


        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.pageHeader)
                .text()
                .contains(RemoveDelegated.pageHeader_text)
                .withCustomReportMessage("Check page header")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.areYouSure)
                .text()
                .contains(RemoveDelegated.areYouSure_text)
                .withCustomReportMessage("Check confirmation header msg")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.warningDescription)
                .text()
                .contains(RemoveDelegated.warningDescription_text)
                .withCustomReportMessage("Check warning description msg")
                .perform();



        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.willBeDelete)
                .text()
                .contains(RemoveDelegated.willBeDelete_text)
                .withCustomReportMessage("Check confirmation deletion")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.deleteCTAbutton)
                .text()
                .contains(RemoveDelegated.deleteCTAbutton_text)
                .withCustomReportMessage("Check delete CTA button")
                .perform();
    }


    public void VerifyRemovedelgated_Product(){



        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.backBTN)
                .text()
                .contains(RemoveDelegated.backBTN_text)
                .withCustomReportMessage("Check back button")
                .perform();


        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.pageHeader)
                .text()
                .contains(RemoveDelegated.pageHeader_text)
                .withCustomReportMessage("Check page header")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.areYouSure)
                .text()
                .contains(RemoveDelegated.areYouSure_text)
                .withCustomReportMessage("Check confirmation header msg")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.warningDescriptionProduct)
                .text()
                .contains(RemoveDelegated.warningDescriptionProduct_text)
                .withCustomReportMessage("Check warning description msg")
                .perform();



        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.willBeDelete)
                .text()
                .contains(RemoveDelegated.willBeDelete_text)
                .withCustomReportMessage("Check confirmation deletion")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), RemoveDelegated.deleteCTAbutton)
                .text()
                .contains(RemoveDelegated.deleteCTAbutton_text)
                .withCustomReportMessage("Check delete CTA button")
                .perform();

    }
}




