package de.vodafone.pages.unityMedia;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Tarif_andern {
    private SHAFT.GUI.WebDriver driver;

    //CLs
    private static String pageTitleCL = "Tarif wechseln";
    private static String deinNeuerTarif_P1TextCL = "Es gelten die Allgemeinen Geschäftsbedingungen für Vodafone-Dienstleistungen" +
            " und - bei Verträgen über Kabel- u./o. TV-Produkte - die Ergänzenden Geschäftsbedingungen für Vodafone Kabel-Dienstleistungen (Internet und Telefon) sowie Vodafone TV-Dienstleistungen und die Preisliste/Leistungsbeschreibung" +
            " für das jeweils beauftragte Produkt. Für die Nutzung von TV-Inhalten über Smartphone oder TV-Hardware-Applikationen (sog. Entertainment-Apps) gelten zusätzlich die Besonderen Geschäftsbedingungen Vodafone Entertainment-Apps und Vodafone App-Plattform.";
    private static String deinNeuerTarif_P2TextCL = "Du hast ein 14-tägiges Widerrufsrecht, die Details findest Du in der Widerrufsbelehrung.";
    private static String deinNeuerTarif_P3TextCL = "Hier findest Du Deine Vertragszusammenfassung. So kannst Du nochmal alles in Ruhe prüfen, bevor Du Deine Buchung abschickst.";

    //Locators
    private static final By callYa_Allnet_FlatL = By.xpath("//*[@id='availableTariffBlock']//li[4]");
    private static final By weiterBtn=By.xpath("//*[@class='btn btn-em' and contains(text(),'weiter')]");
    private static final By deinNeuerTarif_P1Text =By.xpath("//*[@class='white-box']//div/span/p[1]");
    private static final By deinNeuerTarif_P2Text =By.xpath("//*[@class='white-box']//div/span/p[2]");

    private static final By deinNeuerTarif_P3Text =By.xpath("(//*[@class='white-box'])[2]//div/div");
    private static final By kostenpflichtig_wechselnBtn=By.xpath("//*[@class='btn' and contains(text(),'Jetzt kostenpflichtig wechseln')]");
    private static final By backButton = By.xpath("//*[@id='transaction-link']");

    //Constractor
    public Tarif_andern(SHAFT.GUI.WebDriver driver)
    {
        this.driver = driver;
    }
    // Methods
    private void clickOnCallYa_Allnet_FlatL(){
        driver.element().click( callYa_Allnet_FlatL);
    }
    @Step("Click on Weiter Button")
    public void clickOnWeiterBtn(){
        driver.element().click(weiterBtn);
    }
    @Step("Validate CallYa Page content's text")
    public void validateCallYaPage(){
        Validations.assertThat()
                .element(driver.getDriver(), Tarif_andern.deinNeuerTarif_P1Text)
                .text()
                .isEqualTo(Tarif_andern.deinNeuerTarif_P1TextCL)
                .withCustomReportMessage("Verify second step Text1")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), Tarif_andern.deinNeuerTarif_P2Text)
                .text()
                .isEqualTo(Tarif_andern.deinNeuerTarif_P2TextCL)
                .withCustomReportMessage("Verify second step Text2")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), Tarif_andern.deinNeuerTarif_P3Text)
                .text()
                .isEqualTo(Tarif_andern.deinNeuerTarif_P3TextCL)
                .withCustomReportMessage("Verify second step Text2")
                .perform();
    }
    public void validateKostenpflichtinBtnExist()
    {        
        Validations.assertThat().element(driver.getDriver(), Tarif_andern.kostenpflichtig_wechselnBtn).exists();
    }
        public void validateBackButtonExist()

    {
        Validations.assertThat().element(driver.getDriver(), Tarif_andern.backButton).exists();
    }

}

