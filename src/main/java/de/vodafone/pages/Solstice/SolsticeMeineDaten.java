package de.vodafone.pages.Solstice;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class SolsticeMeineDaten {
    private SHAFT.GUI.WebDriver driver;

    public SolsticeMeineDaten(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private static final By pageTitle = By.xpath("");
    private static final By datenschutzSO = By.xpath("//div[@automation-id='datenschutz_so']");
    private static final By datenschutzSO_Header = By.xpath("");
    private static final By datenschutzSO_Footer = By.xpath("");
    private static final By datenschutzAcc = By.xpath("");
    private static final By informationFromVF_EditBtn = By.xpath("");
    private static final By personalData_EditBtn = By.xpath("");
    private static final By internetUsage_EditBtn = By.xpath("");
    private static final By datenschutzAcc_Header = By.xpath("");
    private static final By datenschutzAcc_Footer = By.xpath("");
    private static final By informationFromVF_Title = By.xpath("");
    private static final By informationFromVF_Text = By.xpath("");
    private static final By internetUsage_Card_Title = By.xpath("");
    private static final By internetUsage_Card_Text = By.xpath("");
    private static final By personalData_Card_Text = By.xpath("");
    private static final By personalData_Card_Title = By.xpath("");
    private static final By initialPermissionLinkout = By.xpath("");
    private static final By privacySettingsPageHeader = By.xpath("");
    private static final By dataProtectionLinkout = By.xpath("");
    private static final By dataProtectionHeader = By.xpath("");





    //CLs
    private static String datenschutzSO_HeaderCL = "";
    private static String datenschutzSO_FooterCL = "";

    private static String datenschutzAcc_HeaderCL = "Datenschutz & Werbeeinstellungen";
    private static String datenschutzAcc_FooterCL = "Hier schützt Du Deine Privatsphäre";
    private static String informationFromVF_Card_TitleCL = "Informationen von Vodafone";
    private static String informationFromVF_Card_TextCL = "Leg hier fest, wie wir Dich über unsere Produkte, Services und persönlich zugeschnittene Angebote informieren dürfen.";
    private static String personalData_Card_TitleCL = "Persönliche Daten";
    private static String personalData_Card_TextCL = "Leg hier fest, ob und wie wir Deine persönlichen Daten nutzen dürfen, z.B. um Dich über unsere Produkte zu informieren.";
    private static String internetUsage_Card_TitleCL = "Verbindungs- und Nutzungsdaten";
    private static String internetUsage_Card_TextCL = "Leg hier fest, ob und wie wir Deine Verbindungs- und Nutzungsdaten nutzen dürfen, z.B. um Dich über unsere Produkte zu informieren.";
    private static String editCTABtn = "Bearbeiten";
    private static String PrivacySettingsPageHeaderCL = "Datenschutz-Einstellungen";
    private static String dataProtectionHeaderCL = "Datenschutz";


    //Methods
    public void pressOnSmartObject(SolsticeMeineDaten.MeineDatenSmartObjects SO) {
        switch (SO) {
            case DatenschutzAndWerbeeinstellungen -> {
                driver.element().click(datenschutzSO);
            }
        }
    }

    public enum MeineDatenSmartObjects {
        DatenschutzAndWerbeeinstellungen
    }
    @Step("Validate that Datenschutz SmartObject exists")
    public void validateDatenschutzSmartObjectIsUnhidden() {
        driver.assertThat().element(datenschutzSO).exists().perform();
        driver.assertThat().element(datenschutzSO_Header).text().
                isEqualTo(datenschutzSO_HeaderCL).withCustomReportMessage("validate SO's Header").perform();
        driver.assertThat().element(datenschutzSO_Footer).text().isEqualTo(datenschutzSO_FooterCL)
                .withCustomReportMessage("validate SO's Footer").perform();
    }

    @Step("Validate that Datenschutz Accordion exists")
    public void validateDatenschutzAccordionIsUnhidden() {
        driver.assertThat().element(datenschutzAcc).exists()
                .withCustomReportMessage("Privacy Accordion is Unhidden").perform();
    }

    @Step("validate First link-out of Datenschutz Accordion")
    public void validateFirstLinkOut() {
        driver.element().click(initialPermissionLinkout);
    }
    public void validatePrivacyPageTitle(){
        driver.assertThat().element(privacySettingsPageHeader)
                .text().isEqualTo(PrivacySettingsPageHeaderCL)
                .withCustomReportMessage("validate privacy settings page title")
                .perform();
    }

    @Step("validate second link-out of Datenschutz Accordion")
    public void validateSecondLinkOut() {
        driver.element().click(dataProtectionLinkout);
    }
    public void validateDataProtectionLinkOut(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getDriver().getWindowHandles());
        driver.getDriver().switchTo().window(tabs.get(1));
        driver.assertThat().element(dataProtectionHeader)
                .text().isEqualTo(dataProtectionHeaderCL)
                .withCustomReportMessage("validate page title ")
                .perform();
    }
    @Step("click On Datenschutz & Werbeeinstellungen accordion")
    public void clickOnDatenschutzAccordion() {
        driver.element().click(datenschutzAcc);
    }
    @Step("click on InformationFromVodafone card's Edit button")
    public void clickOnInformationFromVodafoneEditBtn() {
        driver.element().click(informationFromVF_EditBtn);
    }
    @Step("click on Persönliche Daten card's Edit button")
    public void clickOnPersonalDataEditBtn() {
        driver.element().click(personalData_EditBtn);
    }
    @Step("click on Verbindungs- und Nutzungsdaten card's Edit button")
    public void clickOnInternetUsageEditBtn() {
        driver.element().click(internetUsage_EditBtn);
    }
    @Step("validate Redirection Successfully To MeineDaten")
    public void validateRedirectionSuccessfullyToMeineDaten() {
        driver.assertThat().element(datenschutzSO).exists().perform();
        driver.assertThat().element(pageTitle).text().isEqualTo("Meine Daten").perform();
    }
    @Step("validate Datenschutz & Werbeeinstellungen accordion's content")
    public void validateDatenschutzAccordionContent() {
        driver.assertThat().element(datenschutzAcc_Header)
                .text().contains(datenschutzAcc_HeaderCL)
                .withCustomReportMessage("Verify accordon's header")
                .perform();
        driver.assertThat().element(datenschutzAcc_Footer)
                .text().contains(datenschutzAcc_FooterCL)
                .withCustomReportMessage("Verify accordion's footer")
                .perform();

        driver.assertThat().element(informationFromVF_Title)
                .text().contains(informationFromVF_Card_TitleCL)
                .withCustomReportMessage("Verify first card's title")
                .perform();
        driver.assertThat().element(informationFromVF_Text)
                .text().contains(informationFromVF_Card_TextCL)
                .withCustomReportMessage("Verify first card's text")
                .perform();
        driver.assertThat().element(informationFromVF_EditBtn).text().isEqualTo(editCTABtn).perform();
        driver.assertThat().element(informationFromVF_EditBtn).isEnabled().perform();

        driver.assertThat().element(personalData_Card_Title)
                .text().contains(personalData_Card_TitleCL)
                .withCustomReportMessage("Verify second card's title")
                .perform();
        driver.assertThat().element(personalData_Card_Text)
                .text().contains(personalData_Card_TextCL)
                .withCustomReportMessage("Verify second card's text")
                .perform();
        driver.assertThat().element(personalData_EditBtn).text().isEqualTo(editCTABtn).perform();
        driver.assertThat().element(personalData_EditBtn).isEnabled().perform();

        driver.assertThat().element(internetUsage_Card_Title)
                .text().contains(internetUsage_Card_TitleCL)
                .withCustomReportMessage("Verify third card's title")
                .perform();
        driver.assertThat().element(internetUsage_Card_Text)
                .text().contains(internetUsage_Card_TextCL)
                .withCustomReportMessage("Verify third card's text")
                .perform();
        driver.assertThat().element(internetUsage_EditBtn).text().isEqualTo(editCTABtn).perform();
        driver.assertThat().element(internetUsage_EditBtn).isEnabled().perform();

    }

}
