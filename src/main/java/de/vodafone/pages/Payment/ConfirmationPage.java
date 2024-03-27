package de.vodafone.pages.Payment;

import com.shaft.driver.SHAFT;
import joptsimple.internal.AbbreviationMap;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConfirmationPage {
    SHAFT.GUI.WebDriver driver;

    public ConfirmationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    } //constructor

    /* ******WFCT-8765****** */
    //Locators and getters
    private By confirmationPageNotificationtitleLocator = By.xpath("//div[@class='alert noselect success']/div/div/div[2]/h4");
    private By confirmationAccordionLocator = By.xpath("//li[@automation-id='accordion0_acc']");
    private By confirmationPageNotificationTextLocator = By.xpath("//*[@id='content']//payment-confirmation//div[1]/notification//p[1]");
    private By ConfirmatioPageAutoTopInfoTextLocator = By.xpath("//div[@class='ac-body']/div/p[6]");
    private By closeSurveyBTNLocator = By.id("kplDeferButton");
    private By confirmatioPagePaymentMethodTextLocator = By.xpath("(//div[@class='white-box']//span)[1]");
    private By confirmationPageTopUpNotificationLink_Locator = By.xpath("//a[@class='link1a']");
    private By statusLabel_Locator = By.xpath("(//div[@class='white-box']/p)[1]");
    private By statusValue_Locator = By.xpath("(//div[@class='white-box']/p)[1]");
    private By rufnummerLabel_Locator = By.xpath("(//div[@class='white-box']/p)[2]");
    private By rufnummerValue_Locator = By.xpath("(//div[@class='white-box']/p)[2]");
    private By amountLabel_Locator = By.xpath("(//div[@class='white-box']/p)[3]");
    private By amountValue_Locator = By.xpath("(//div[@class='white-box']/p)[3]");
    private By bookingNumberLabel_Locator = By.xpath("(//div[@class='white-box']/p)[4]");
    private By timeLabel_Locator = By.xpath("(//div[@class='white-box']/p)[6]");
    private By paymentMethodLabel_Locator = By.xpath("(//div[@class='white-box']/p)[5]");
    private By paymentMethodValue_Locator = By.xpath("(//div[@class='white-box']/p)[5]");
    private By bookingNumberValue_Locator = By.xpath("(//div[@class='white-box']/p)[4]");
    private By timeValue_Locator = By.xpath("(//div[@class='white-box']/p)[6]");
    private By balanceDetailsAccordion_Locator = By.xpath("//li[@automation-id='balanceDetails_acc']/a");


    //CL and getters
    private String confirmationPagePayPalAndCcAutoTopUpNotificationtitle_Cl = "Zahlung beauftragt";
    private String confirmationPagePayPalAndCcAutoTopUpNotificationDescription_Cl = "Wir haben Deinen Auftrag angenommen und prüfen die Zahlung.";

    private String confirmationPageSofortAutoTopUpNotificationtitle_Cl = "Erledigt!";
    private String confirmationPageSofortAutoTopUpNotificationDescription_Cl = "Wir haben Deinen Auftrag angenommen. Wichtig für Dich: Es kann ein paar Stunden dauern, bis die automatische Aufladung aktiviert ist.";

    private String confirmationPageTopUpNotificationBody_Cl = "Wir haben Deinen Auftrag angenommen. Alle Aufträge findest Du im Bereich Guthaben & Aufladehistorie. Wichtig für Dich: Es kann etwas dauern, bis der Auftrag dort sichtbar ist.";

    private String confirmationPageTopUpNotificationLink_Cl = "Aufladehistorie ansehen";

    private String confirmationPageLowerBalanceAutoTopUpInfoCl = "Automatische Aufladung\nBei Guthaben unter 5 €";
    private String confirmationPageDaysAutoTopUpPaymentInfo_Cl = "Automatische Aufladung\nAlle 28 Tage";

    private String confirmationPageSofortPaymentInfo_Cl = "Sofort";
    private String confirmationPagePaypalPaymentInfo_Cl = "PayPal";
    private String confirmationPageCreditCardPaymentInfo_Cl = "Kreditkarte";

    private String statusLabel_CL = "Status Deiner Zahlung";
    private String statusValue_CL = "angenommen";
    private String rufnummerLabel_CL = "Auflade-Rufnummer:";
    private String amountLabel_CL = "Zahlungsbetrag";
    private String bookingNumberLabel_CL = "Buchungsnummer";
    private String paymentMethodLabel_CL = "Bezahlmethode";
    private String timeLabel_CL = "Bezahlt am";

    public void closeSurvey() {
        if (driver.element().getElementsCount(closeSurveyBTNLocator) == 1) {
            driver.element().click(closeSurveyBTNLocator);
        }
    }

    public void clickOnNotificationLink(){
        driver.element().click(confirmationPageTopUpNotificationLink_Locator);
    }

    public void assertOnPaymentMethod(String paymentMethod) {
        driver.verifyThat().element(confirmatioPagePaymentMethodTextLocator).text().contains(paymentMethod).withCustomReportMessage("Payment method text assertion").perform();
    }

    public void assertOnAutoTopUpPaymentMethod(String paymentMethod) {
        driver.verifyThat().element(confirmatioPagePaymentMethodTextLocator).text().isEqualTo(paymentMethod + " für nächste Aufladung gespeichert").withCustomReportMessage("Payment method text assertion").perform();
    }

    /* methods wfct-8626*/
    public void assertOnConfirmationPagePaypalAndCcAutoTopUpNotificationTitle() {
        driver.verifyThat().element(confirmationPageNotificationtitleLocator).text().isEqualTo(confirmationPagePayPalAndCcAutoTopUpNotificationtitle_Cl).withCustomReportMessage("Notification title assertion").perform();
    }

    public void assertOnConfirmationPagePaypalAndCcAutoTopUpNotificationBody() {
        driver.verifyThat().element(confirmationPageNotificationTextLocator).text().isEqualTo(confirmationPagePayPalAndCcAutoTopUpNotificationDescription_Cl).withCustomReportMessage("Notification body assertion").perform();
    }

    /* Sofort */
    public void assertOnConfirmationSofortAutoTopUpNotificationTitle() {
        driver.verifyThat().element(confirmationPageNotificationtitleLocator).text().isEqualTo(confirmationPageSofortAutoTopUpNotificationtitle_Cl).withCustomReportMessage("Sofort Auto TopUp Notification title assertion").perform();
    }

    public void assertOnConfirmationPageSofortAutoTopUpNotificationBody() {
        driver.verifyThat().element(confirmationPageNotificationTextLocator).text().isEqualTo(confirmationPageSofortAutoTopUpNotificationDescription_Cl).withCustomReportMessage("Sofort Auto TopUp Notification body assertion").perform();
    }
    /* ****TopUp**** */

    public ConfirmationPage waitForSpecifiedTime(int Duration) {
        try{
            Thread.sleep(Duration);
        }catch (Exception e){

        }
        return this;
    }
    public ConfirmationPage assertOnConfirmationPageTopUpNotificationBody() {
        waitForSpecifiedTime(5000);
        driver.verifyThat().element(confirmationPageNotificationTextLocator).text().contains(confirmationPageTopUpNotificationBody_Cl).withCustomReportMessage("TopUp Notification body assertion").perform();
         return this;
    }

    public ConfirmationPage assertOnConfirmationPageTopUpNotificationLinkText() {
        driver.verifyThat().element(confirmationPageTopUpNotificationLink_Locator).textTrimmed().isEqualTo(confirmationPageTopUpNotificationLink_Cl).withCustomReportMessage("Assert on confirmation Page TopUp Notification Link text").perform();
        return this;
    }

    public void assertOnConfirmationPageTopUpNotificationLinkNavigation() {
        driver.verifyThat().element(balanceDetailsAccordion_Locator).attribute("class").isEqualTo("ac-head ac-active").withCustomReportMessage("Assert on confirmation Page TopUp Notification Link text").perform();
    }


    public void assertOnConfirmationPageDaysAutoTopUpInfoText() {
        driver.verifyThat().element(ConfirmatioPageAutoTopInfoTextLocator).text().isEqualTo(confirmationPageDaysAutoTopUpPaymentInfo_Cl).withCustomReportMessage("assert on Days auto TopUp text info").perform();
    }

    public void assertOnConfirmationPageLowerBalanceAutoTopUpInfoText() {
        driver.verifyThat().element(ConfirmatioPageAutoTopInfoTextLocator).text().isEqualTo(confirmationPageLowerBalanceAutoTopUpInfoCl).withCustomReportMessage("assert on Lower Balance auto TopUp text info").perform();
    }


    /* ****** added temporary locators and methods ****** */
    private By ConfirmatioPageLowerBalanceInfoTextLocator = By.xpath("//div[@class='ac-body']/div/p[6]");
    private String confirmationPageNotificationtitleCl = "Zahlung beauftragt";
    private String confirmationPageNotificationDescriptionCl = "Wir haben Deinen Auftrag angenommen und prüfen die Zahlung.";
    private String confirmationPageautoTopUpInfoCl = "Automatische Aufladung\nBei Guthaben unter 5 €";

    public void assertOnTopUpNotificationTitle() {
        driver.verifyThat().element(confirmationPageNotificationtitleLocator).text().isEqualTo(confirmationPageNotificationtitleCl).withCustomReportMessage("Notification title assertion").perform();
    }
    public void assertConfirmationAccordionExists() {
        driver.verifyThat().element(confirmationAccordionLocator).exists().withCustomReportMessage("Assert Confirmation Accordion Exists").perform();
    }

    public void assertOnTopUPNotificationBody() {
        driver.verifyThat().element(confirmationPageNotificationTextLocator).text().isEqualTo(confirmationPageNotificationDescriptionCl).withCustomReportMessage("Notification body assertion").perform();
    }
    public void assertThatTopUPNotificationBodyExist() {
        driver.verifyThat().element(confirmationPageNotificationTextLocator).exists().withCustomReportMessage("Notification body exist assertion").perform();
    }

    /* *************************************************************** */




    public ConfirmationPage waitForPageLoad(){
        driver.verifyThat().element(By.xpath("Locator")).doesNotExist().perform();
        return this;
    }
    public void assertOnIbanConfirmationAccordion(String rufnummerValue , String amountValue , String paymentMethodValue ){
        driver.verifyThat().element(statusLabel_Locator).textTrimmed().contains(statusLabel_CL).withCustomReportMessage("Assert on status label text").perform();

        driver.verifyThat().element(rufnummerLabel_Locator).textTrimmed().contains(rufnummerLabel_CL).withCustomReportMessage("Assert on rufnummer label text").perform();

        driver.verifyThat().element(amountLabel_Locator).textTrimmed().contains(amountLabel_CL).withCustomReportMessage("Assert on amount label text").perform();

        driver.verifyThat().element(bookingNumberLabel_Locator).textTrimmed().contains(bookingNumberLabel_CL).withCustomReportMessage("Assert on booking number label text").perform();

        driver.verifyThat().element(paymentMethodLabel_Locator).textTrimmed().contains(paymentMethodLabel_CL).withCustomReportMessage("Assert on payment method label text").perform();

        driver.verifyThat().element(timeLabel_Locator).textTrimmed().contains(timeLabel_CL).withCustomReportMessage("Assert on time label text").perform();

        driver.verifyThat().element(statusValue_Locator).textTrimmed().contains(statusValue_CL).withCustomReportMessage("Assert on status Value text").perform();

        driver.verifyThat().element(rufnummerValue_Locator).textTrimmed().contains(rufnummerValue).withCustomReportMessage("Assert on rufnummer value text").perform();

        driver.verifyThat().element(amountValue_Locator).textTrimmed().contains(amountValue).withCustomReportMessage("Assert on amount value text").perform();

        driver.verifyThat().element(bookingNumberValue_Locator).isVisible().withCustomReportMessage("Assert on booking number Value").perform();

        driver.verifyThat().element(paymentMethodValue_Locator).textTrimmed().contains(paymentMethodValue).withCustomReportMessage("Assert on payment method value text").perform();

        driver.verifyThat().element(timeValue_Locator).isVisible().withCustomReportMessage("Assert on time value").perform();
    }




}