package de.vodafone.pages.eCare;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class EditBankDetails {
    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Locators

    private By iBanInputField_Locator = By.id("iban");
    private By weiterBtn_Locator = By.xpath("//button[contains(.,'Weiter')]");
    private By checkBox_Locator = By.xpath("//label[@automation-id='checkboxItemModel.id_text_tv']");
    private By bankverbindungSpeichernBtn_Locator = By.xpath("//button[contains(.,'Bankverbindung speichern')]");
    private By greenNotificationTitle_Locator = By.xpath("(//h4[@class='flexDiv'])[1]");
    private By redNotificationTitle_Locator = By.xpath("(//h4[@class='flexDiv'])[2]");
    private By redNotificationDescription_Locator = By.xpath("(//p[@class='notification-text mb-10 mt-10'])[1]");
    private By editAccordionTitle_Locator = By.xpath("//div[@id='step0']//div[@class='header-title']");
    private By kontoinhaberLabel_Locator = By.xpath("(//text//label)[1]");
    private By iBanLabel_Locator = By.xpath("(//text//label)[2]");
    private By confirmationTitle_Locator = By.xpath("//bank-details-update-steptwo/div/h3");
    private By confirmationKontoinhaberLabel_Locator = By.xpath("(//div[contains(@class,'white-box')]/p/strong)[1]");
    private By confirmationIbanLabel_Locator = By.xpath("(//div[contains(@class,'white-box')]/p/strong)[2]");
    private By confirmationBicLabel_Locator = By.xpath("(//div[contains(@class,'white-box')]/p/strong)[3]");
    private By confirmationBankLabel_Locator = By.xpath("(//div[contains(@class,'white-box')]/p/strong)[4]");
    private By ubersichtAcc_Locator = By.xpath("//a[@class='ac-head']");
    private By ubersichtAccDescription_Locator = By.xpath("//div[@class='ac-body']/h3");
    private By ubersichtAccNotificationHeader_Locator = By.xpath("//h4[contains(.,'Wichtig')]");

    //Methods
    public EditBankDetails(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    @Step("Expand ubersicht accordion")
    public void expandUbersichtAcc(){
        driver.element().click(ubersichtAcc_Locator);
    }

    @Step("Type IBAN")
    public void typeIban(String iBan){
        driver.element().type(iBanInputField_Locator,iBan);
    }

    @Step("Click on weiter botton")
    public void clickOnWeiterBtn(){
        driver.element().click(weiterBtn_Locator);
    }

    @Step("Click on the check box")
    public void clickCheckBox(){
        driver.element().click(checkBox_Locator);
    }

    @Step("Click on bankverbindungSpeichern Button")
    public void clickOnBankVerbindungSpeichernBtn(){
        driver.element().click(bankverbindungSpeichernBtn_Locator);
    }

    //CLs

    private String greenNotificationTitleText_CL = "Vielen Dank für Deinen Auftrag!";
    private String redNotificationTitleText_CL = "Deine Bankverbindung wird geändert";
    private String redNotificationDescriptionText_CL = "Das Ändern kann bis zu 3 Tage dauern. Erst dann kannst Du es in MeinVodafone sehen.\n" +
            "Wichtig: Für MeinDSL & Festnetz oder Deinen Kabel-Vertrag musst Du Deine Bankverbindung separat ändern.";
    private String editAccTitle_CL = "Kontodaten bearbeiten";
    private String kontoinhaberLabel_CL = "Kontoinhaber";
    private String iBanLabel_CL = "IBAN";
    private String bicLabel_CL = "BIC";
    private String bankLabel_CL = "BANK";
    private String confirmationTitle_CL = "Überprüf Deine Daten bitte nochmal, bevor Du die Bankverbindung speicherst:";
    private String ubersichtAccDescription_CL = "Vielen Dank für Deinen Auftrag zur Änderung der Bankverbindung";
    private String ubersichtAccNotificationHeader_CL = "Wichtig";

    //Validations

    public void assertOnUbersichtAccNotification(){
        driver.verifyThat().element(ubersichtAccNotificationHeader_Locator).text().contains(ubersichtAccNotificationHeader_CL).withCustomReportMessage("Assert on ubersicht accordion notification header").perform();
    }

    public void assertOnUbersichtAccDescription(){
        driver.verifyThat().element(ubersichtAccDescription_Locator).text().contains(ubersichtAccDescription_CL).withCustomReportMessage("Assert on ubersicht accordion description").perform();
    }

    public void assertOnConfirmationBankLabel(){
        driver.verifyThat().element(confirmationBankLabel_Locator).text().contains(bankLabel_CL).withCustomReportMessage("Assert on confirmation Bank label").perform();
    }

    public void assertOnConfirmationBicLabel(){
        driver.verifyThat().element(confirmationBicLabel_Locator).text().contains(bicLabel_CL).withCustomReportMessage("Assert on confirmation BIC label").perform();
    }

    public void assertOnConfirmationIbanLabel(){
        driver.verifyThat().element(confirmationIbanLabel_Locator).text().contains(iBanLabel_CL).withCustomReportMessage("Assert on confirmation IBAN label").perform();
    }

    public void assertOnConfirmationKontoinhaberLabel(){
        driver.verifyThat().element(confirmationKontoinhaberLabel_Locator).text().contains(kontoinhaberLabel_CL).withCustomReportMessage("Assert on confirmation Kontoinhaber label").perform();
    }

    public void assertOnConfirmationTitle(){
        driver.verifyThat().element(confirmationTitle_Locator).text().contains(confirmationTitle_CL).withCustomReportMessage("Assert on confirmation title ").perform();
    }

    public void assertOnEditAccTitle(){
        driver.verifyThat().element(editAccordionTitle_Locator).text().contains(editAccTitle_CL).withCustomReportMessage("Assert on edit accordion title").perform();
    }

    public void assertOnKontoinhaberLabel(){
        driver.verifyThat().element(kontoinhaberLabel_Locator).text().contains(kontoinhaberLabel_CL).withCustomReportMessage("Assert on Kontoinhaber label").perform();
    }

    public void assertOnIbanLabel(){
        driver.verifyThat().element(iBanLabel_Locator).text().contains(iBanLabel_CL).withCustomReportMessage("Assert on IBAN label").perform();
    }

    @Step("assert on green notification title text")
    public void assertOnGreenNotificationTitleText(){
        driver.verifyThat().element(greenNotificationTitle_Locator).text().isEqualTo(greenNotificationTitleText_CL).perform();
    }

    @Step("assert on red notification title text")
    public void assertOnRedNotificationTitleText(){
        driver.verifyThat().element(redNotificationTitle_Locator).text().isEqualTo(redNotificationTitleText_CL).perform();
    }

    @Step("assert on red notification description text")
    public void assertOnRedNotificationDescriptionText(){
        driver.verifyThat().element(redNotificationDescription_Locator).text().isEqualTo(redNotificationDescriptionText_CL).perform();
    }
}
