package de.vodafone.pages.eCare;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class QuickCheck {
    //Locators
    private By smartObjectsCommon_Locator = By.xpath("//smart-object-wrapper");
    private By guthabenAccordion_Locator = By.xpath("//li[@automation-id='balanceDetails_acc']");
    private By guthabenSectionTitle_Locator = By.xpath("//quick-check-accordion-prepaid/div/h3");
    private By aufladungenSectionTitle_Locator = By.xpath("//quick-check-topup-sender-history-list/h3");
    private By guthabenAufladenBtn_Locator = By.xpath("//a[contains(.,' Guthaben aufladen')]");
    private By topUpPageTitle_Locator = By.xpath("//h1[contains(.,'Deine Zahlung an Vodafone')]");
    private By datenAccordion_Locator = By.xpath("//li[@automation-id='kostendetails_acc']");
    private By dateVolumenTitle_Locator = By.xpath("//div[@id='quickCheckPaulDatenAccordionContent']//h3");
    private By datenCard_Locator = By.xpath("(//large-card[contains(.,'Daten')])[1]");
    private By mobilesBezahlenAccordion_Locator = By.xpath("//li[@automation-id='bezahlen-per-handy_acc']");
    private By teilnehmerLable_Locator = By.xpath("//div[@id='mobilePaymentContent']//h3[contains(.,'Teilnehmer ')]");
    private By teilnehmerSection_Locator = By.xpath("//div[@id='mobilePaymentContent']//div[@class='white-box mobile-info']");
    private By mobilesBezahlenDropDown_Locator = By.xpath("//div[@id='mobilePaymentContent']//select[@id='doc-type']");
    private By einzelKaufeSection_Locator = By.xpath("//bill-info-card[contains(.,'Deine Einzelkäufe')]");
    private By abosSection_Locator = By.xpath("//bill-info-card[contains(.,'Deine Abos')]");
    private By einzelKaufeDescription_Locator = By.xpath("//bill-info-card[contains(.,'Deine Einzelkäufe')]//div[@class='white-box card custome-msg']");
    private By abosDescription_Locator = By.xpath("//bill-info-card[contains(.,'Deine Abos')]//div[@class='white-box card custome-msg']");
    private By einstelleugenAndernBtn_Locator = By.xpath("//a[contains(.,'Einstellungen ändern')]");
    private By einstellungenBezahlenPageTitle_Locator = By.xpath("//h1[contains(.,'Einstellungen für Mobiles Bezahlen')]");

    //Variables
    private SHAFT.GUI.WebDriver driver;


    //Methods
    public QuickCheck(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get smart objects number")
    public String getSmartObjectsNumber() {
        return Integer.toString(driver.element().getElementsCount(smartObjectsCommon_Locator));
    }

    private By getSmartObjectLocator(String smartObjectName) {
        return By.xpath("//smart-object[contains(.,'" + smartObjectName + "')]");
    }

    @Step("Click on smart object")
    public void clickOnSmartObject(String smartObjectName) {
        driver.element().click(getSmartObjectLocator(smartObjectName));
    }

    @Step("expand guthaben accordion")
    public void expandGuthabenAcc() {
        driver.element().click(guthabenAccordion_Locator);
    }

    @Step("Click on guthaben aufladen button")
    public void clickOnGuthabenAufladenBtn() {
        driver.element().click(guthabenAufladenBtn_Locator);
    }

    @Step("expand Daten accordion")
    public void expandDatenAcc() {
        driver.element().click(datenAccordion_Locator);
    }

    @Step("expand mobiles bezahlen accordion")
    public void expandMobilesBezahlenAcc() {
        driver.element().click(mobilesBezahlenAccordion_Locator);
    }

    @Step("Click on einstellungen adern button")
    public void clickEinstellungenAndernBtn(){
        driver.element().click(einstelleugenAndernBtn_Locator);
    }

    //CLs
    private String guthabenSectionTitleText_CL = "Guthaben";
    private String aufladungenSectionTitleText_CL = "Aufladungen auf dieses CallYa-Konto";
    private String datenVolumenTitleText_CL = "Datenvolumen";
    private String einzelKaufeDescriptionText_CL = "Es wurden keine Einzelkäufe in diesem Rechnungszeitraum gebucht.";
    private String abosDescriptionText_CL = "Du hast keine Abos in diesem Rechnungszeitraum gebucht.";

    //Validations
    @Step("Assert on Smart objects number")
    public void assertOnSmartObjectsNumbre(String num) {
        SHAFT.Validations.verifyThat().object(getSmartObjectsNumber()).isEqualTo(num).withCustomReportMessage("assert that samrt objects number = " + num).perform();
    }

    @Step("Assert that accordion is expanded")
    public void assertThatAccordionExpanded(String accName) {
        driver.verifyThat().element(By.xpath("//accordion[@id='" + accName + "']/li/div")).attribute("style").isEqualTo("display: block;").perform();
    }

    @Step("Assert that guthaben section exists")
    public void assertThatGuthabenSectionExists() {
        driver.verifyThat().element(guthabenSectionTitle_Locator).text().contains(guthabenSectionTitleText_CL).perform();
    }

    @Step("Assert that aufladungen section exists")
    public void assertThatAufladungenSectionExists() {
        driver.verifyThat().element(aufladungenSectionTitle_Locator).text().contains(aufladungenSectionTitleText_CL).perform();
    }

    @Step("Assert on guthaben aufladen button navigation")
    public void assertOnGutabenAufladenBtnNavigation() {
        driver.verifyThat().element(topUpPageTitle_Locator).exists().perform();
    }

    @Step("Assert on Daten accordion title")
    public void assertOnDatenVolumenTitle() {
        driver.verifyThat().element(dateVolumenTitle_Locator).text().contains(datenVolumenTitleText_CL).perform();
    }

    @Step("Assert that daten card exists")
    public void assertThatDatenCardExists() {
        driver.verifyThat().element(datenCard_Locator).exists().perform();
    }

    @Step("Assert that teilnehmer label exists")
    public void assertThatTeilnehmerLabelExists() {
        driver.verifyThat().element(teilnehmerLable_Locator).exists().perform();
    }

    @Step("Assert that teilnehmer section exists")
    public void assertThatTeilnehmerSectionExists() {
        driver.verifyThat().element(teilnehmerSection_Locator).exists().perform();
    }

    @Step("Assert that mobiles bezahlen dropdown exists")
    public void assertThatMobilesBezhalenDropdownExists() {
        driver.verifyThat().element(mobilesBezahlenDropDown_Locator).exists().perform();
    }

    @Step("Assert that EinzelKaufe section exists")
    public void assertThatEinzelKaufeSectionExists() {
        driver.verifyThat().element(einzelKaufeSection_Locator).exists().perform();
    }

    @Step("Assert that Abos section exists")
    public void assertThatAbosSectionExists() {
        driver.verifyThat().element(abosSection_Locator).exists().perform();
    }

    @Step("Assert on EinzelKaufe description text")
    public void assertOnEinzelKaufeDescriptionText() {
        driver.verifyThat().element(einzelKaufeDescription_Locator).text().contains(einzelKaufeDescriptionText_CL).perform();
    }

    @Step("Assert on Abos description text")
    public void assertOnAbosDescriptionText() {
        driver.verifyThat().element(abosDescription_Locator).text().contains(abosDescriptionText_CL).perform();
    }

    @Step("Assert on einstellungen andren button navigation")
    public void assertOnEinstellungenAnernBtnNavigation(){
        driver.verifyThat().element(einstellungenBezahlenPageTitle_Locator).exists().perform();
    }
}
