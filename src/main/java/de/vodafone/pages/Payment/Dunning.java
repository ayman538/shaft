package de.vodafone.pages.Payment;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Dunning {
    SHAFT.GUI.WebDriver driver;
    private By dunningContinueButtonLocator = By.xpath("//a[@class='btn btn-em dunning-btn']");

    public By getDunningContinueButtonLocator() {
        return dunningContinueButtonLocator;
    }

    public Dunning(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private static By dunningNotificationTextLocator = By.xpath("//div[@automation-id='undefined_nt']//p");
    private static By dunningNotificationTitleLocator = By.xpath("//div[@automation-id='undefined_nt']//h4");
    private static By dunningAmountLocator = By.xpath("//input[@id='dunningAmount']");
    private static By arBalanceAmountLocator = By.xpath("//input[@id='arBalanceAmount']");
    private static By redirectDebitSectionTitleLocator = By.xpath("//div[@id='renewDirectDebit']/h4");
    private static By redirectDebitSectionLocator = By.xpath("//div[@id='renewDirectDebit']");
    private static By redirectDebitSectionTextLocator = By.xpath("//div[@id='renewDirectDebit']/p");
    private static By installmentSectionTitleLocator = By.xpath("//div[@id='installment']/h4");
    private static By installmentSectionTextLocator = By.xpath("//div[@id='installment']/p");
    private static By paymentArrangementTitleLocator = By.xpath("//div[@id='paymentArrangement']/h4");
    private static By paymentArrangementTextLocator = By.xpath("//div[@id='paymentArrangement']/p");
    private static By redirectDebitBtnLocator = By.xpath("//div[@id='renewDirectDebit']/a");
    private static By installmentBtnLocator = By.xpath("//div[@id='installment']/a");
    private static By paymentArrangementBtnLocator = By.xpath("//div[@id='paymentArrangement']/a");
    private static By bankDetailsLinkLocator = By.xpath("(//a[@data-type='Standard'])[1]");
    private static By vodafoneStoreLinkLocator = By.xpath("(//a[@data-type='Standard'])[2]");
    private static By historyTableSectionLocator = By.xpath("//div[@id='history-table']");
    private static By historyTableTitleLocator = By.xpath("//div[@id='history-table']/../h4");
    private static By dunningAmountValueLocator = By.xpath("//div[@class='due-amount']//h3");
    private static By dlaAmountTextLocator = By.xpath("(//div[@class='due-amount']//span)[1]");
    private static By arBalanceAmountTextLocator = By.xpath("//input[@id='arBalanceAmount']/..//strong");
    private static By arBalanceInputLocator = By.xpath("//input[@id='arBalanceAmount']");
    private static By dlaInputLocator = By.xpath("//input[@id='dunningAmount']");
    private static By paymentHistoryTitleLocator = By.xpath("//div[@id='history-table']/../h4");
    private static By paymentHistoryTextLocator = By.xpath("//div[@id='history-table']/../p");
    private static By paymentHistoryTableRowsNumberBtnLocator = By.xpath("//span[@class='btn btn-sml btn-alt settings']");
    private static By paymentHistoryTablePagerLocator = By.xpath("(//div[@class='pager'])[1]");
    private static By paymentHistoryTableRowsNumberLocator = By.xpath("(//span[@class='numbers'])[1]");
    private static By paymentHistoryTableDateColumnLocator = By.xpath("(//span[@class='column-name'])[1]");
    private static By paymentHistoryTableAmountColumnLocator = By.xpath("(//span[@class='column-name'])[2]");
    private static By paymentHistoryTableStatusColumnLocator = By.xpath("(//span[@class='column-name'])[3]");
    private static By paymentHistoryTablePaymentMethodColumnLocator = By.xpath("(//span[@class='column-name'])[4]");
    private static By noPaymentHistoryNotificationLocator = By.xpath("//span[@class='va-middle']");


    private String paymentArrangementTitleCl = "Stundung";
    private String paymentArrangementTextCl = "Du kannst einmal Deine Zahlungsfrist verlängern. Das kostet 0,15 €. Diesen Betrag findest Du auf Deiner nächsten Rechnung.";
    private String installmentTitleCl = "Ratenzahlung";
    private String installmentTextCl = "Wichtig: Bei einer Ratenzahlung wird die aktuelle Rechnung mit berücksichtigt. Dein offener Betrag beträgt 5,00 € . Du zahlst einmal 1,00 € für die Ratenzahlung. Diesen Betrag findest Du auf Deiner nächsten Rechnung.";
    private String redirectDebitTitleCl = "Erneuter Einzug";
    private String redirectDebitTextCl = "Du kannst Deinen Betrag von Deinem bestehenden Bankkonto einziehen lassen.";
    private String creditNotificationCl = "Dein Konto weist ein Guthaben auf. Wir verrechnen es mit der nächsten Rechnung.";
    private String dlaAmountTextCl = "Du musst den Betrag sofort zahlen!";
    private String arBalanceAmountTextCl = "Das ist die Summe Deiner neuen Rechnung + Mahnbetrag.";
    private String arBalanceAmountTextCaseDlaEqualZeroCl = "";
    private String notificationDlaAndArEqualZeroCl = "Dein Konto ist ausgeglichen.";
    private String paymentHistoryTitleCl = "Deine Online-Zahlungen";
    private String paymentHistoryTextCl = "Hier siehst Du nur Deine Zahlungen, die Du online bei uns tätigst – nicht Deine Zahlungen im Shop oder von Deinem Bankkonto.";
    private String paymentHistory20RowsNumberCl = "20 Einträge";
    private String paymentHistoryTableDateColumnTitleCl = "Datum";
    private String paymentHistoryTableAmountColumnTitleCl = "Betrag";
    private String paymentHistoryTableStatusColumnTitleCl = "Status";
    private String paymentHistoryTablePaymentMethodColumnTitleCl = "Zahlungsart";
    private String noPaymentHistoryNotificationCl = "Es liegen noch keine Online-Zahlungen vor";
    private String dunningNotificationTitleClB02 = "Deine Stundung";
    private String dunningNotificationTextClB02 = "Zahl bitte den Betrag von 1,00 Euro bis zum 17.09.2018. Du kannst auch vorher die unten aufgeführten Zahlungsmöglichkeiten nutzen.";
    private String dunningNotificationTitleClB07 = "Dein Konto ist für abgehende Verbindungen gesperrt";
    private String dunningNotificationTextClB07 = "Zahl bitte bis zum 18.09.2018, um eine komplette Sperrung Deines Mobilfunk-Anschlusses zu vermeiden.";
    private String dunningNotificationTitleClB14 = "Dein Konto ist für eingehende und abgehende Verbindungen gesperrt";
    private String dunningNotificationTextClB14 = "Zahl bitte bis zum 18.09.2018, um eine Kündigung Deines Mobilfunk-Anschlusses zu vermeiden.";

    private String dunningNotificationTitleClB15 = "Vermeide nächste Mahnschritte";
    private String dunningNotificationTextClB15 = "Gleich Dein Kundenkonto in Höhe von 5,00 Euro aus.";
    private String dunningNotificationClB20 = "Deinen Auftrag zum erneuten Einzug haben wir entgegengenommen.";
    private String paButtonCl = "Weiter";

    @Step("Click on DunningGpp button")
    public void clickContinueToGPP() {
        driver.element().click(dunningContinueButtonLocator);
    }

    @Step("Click on payment arrangement button")
    public void clickPaymentArrangementButton() {
        driver.element().click(paymentArrangementBtnLocator);
    }

    @Step("click on installment button")
    public void clickInstallmentButton() {
        driver.element().click(installmentBtnLocator);
    }

    @Step("click on renew direct debit button")
    public void clickRenewDirectDebitButton() {
        driver.element().click(redirectDebitBtnLocator);
    }

    public void assertOnPaymentArrangementTitleCl() {
        driver.verifyThat().element(paymentArrangementTitleLocator).textTrimmed().isEqualTo(paymentArrangementTitleCl).withCustomReportMessage("Assert on  payment arrangement title cl").perform();
    }

    public void assertOnPaymentArrangementTextCl() {
        driver.verifyThat().element(paymentArrangementTextLocator).textTrimmed().isEqualTo(paymentArrangementTextCl).withCustomReportMessage("Assert on  payment arrangement text cl").perform();
    }

    public void assertOnPaBtnCl() {
        driver.verifyThat().element(paymentArrangementBtnLocator).textTrimmed()
                .isEqualTo(paButtonCl).withCustomReportMessage("Assert on PA btn cl").perform();
    }

    public void assertOnInstallmentTitleCl() {
        driver.verifyThat().element(installmentSectionTitleLocator).textTrimmed().isEqualTo(installmentTitleCl).withCustomReportMessage("assert on  installment title cl").perform();
    }

    public void assertOnInstallmentTextCl() {
        driver.verifyThat().element(installmentSectionTextLocator).textTrimmed().isEqualTo(installmentTextCl).withCustomReportMessage("assert on  installment text cl").perform();
    }

    public void assertOnRedirectDebitTitleCl() {
        driver.verifyThat().element(redirectDebitSectionTitleLocator).textTrimmed().isEqualTo(redirectDebitTitleCl).withCustomReportMessage("assert on  redirect debit title cl").perform();
    }

    public void assertOnRedirectDebitTextCl() {
        driver.verifyThat().element(redirectDebitSectionTextLocator).textTrimmed().isEqualTo(redirectDebitTextCl).withCustomReportMessage("assert on  redirect debit text cl").perform();
    }

    public void assertThatPaymentArrangementSectionIsNotExist() {
        driver.verifyThat().element(paymentArrangementBtnLocator).doesNotExist().withCustomReportMessage("Assert that payment arrangement section is not exist").perform();
    }

    public void assertOnCreditAmountNotificationCl() {
        driver.verifyThat().element(dunningNotificationTitleLocator).textTrimmed().isEqualTo(creditNotificationCl).withCustomReportMessage("Assert on DLA credit amount notification cl").perform();
    }

    public void assertOnDlaAmountSectionCl() {
        driver.verifyThat().element(dlaAmountTextLocator)
                .textTrimmed().contains(dlaAmountTextCl).withCustomReportMessage("assert on Dla Amount section Cl").perform();
    }

    public void assertThatArBalanceRadiobuttonDoesNotExists() {
        driver.verifyThat().element(arBalanceInputLocator).doesNotExist().withCustomReportMessage("assert that Ar balance radio button doesn`t exists").perform();
    }

    public void assertOnArBalanceAmountSectionClWhenDlaLargerThanZero() {
        driver.verifyThat().element(arBalanceAmountTextLocator)
                .textTrimmed().contains(arBalanceAmountTextCl).withCustomReportMessage("assert on AR balance section Cl case DLa > 0 ").perform();
    }

    public void assertOnArBalanceAmountSectionClWhenDlaEqualsZero() {
        driver.verifyThat().element(arBalanceAmountTextLocator)
                .doesNotExist().withCustomReportMessage("assert on AR balance section Cl case DLa = 0").perform();
    }


    public void assertThatDlaRadiobuttonDoesNotExists() {
        driver.verifyThat().element(dlaInputLocator).doesNotExist().withCustomReportMessage("assert that dla radio button doesn't exists").perform();
    }

    public void assertOnNotificationWhenDlaAndArEqualZero() {
        driver.verifyThat().element(dunningNotificationTitleLocator).textTrimmed().isEqualTo(notificationDlaAndArEqualZeroCl).withCustomReportMessage("assert on notification when Dla = Ar = zero").perform();
    }

    public void assertThatRedirectDebitButtonExists() {
        driver.verifyThat().element(redirectDebitBtnLocator).exists().withCustomReportMessage("assert that redirect Debit button exists").perform();

    }

    public void assertThatRedirectDebitButtonDoesNotExist() {
        driver.verifyThat().element(redirectDebitBtnLocator).doesNotExist().withCustomReportMessage("assert that redirect Debit button doesn't exist").perform();

    }

    public void assertThatRedirectDebitSectionDoesNotExist() {
        driver.verifyThat().element(redirectDebitSectionLocator).doesNotExist().withCustomReportMessage("assert that redirect Debit section doesn't exist").perform();
    }

    public void assertThatPaymentHistoryTitleIsCorrect() {
        driver.verifyThat().element(paymentHistoryTitleLocator).textTrimmed().isEqualTo(paymentHistoryTitleCl).withCustomReportMessage("assert that payment history title is correct").perform();
    }

    public void assertThatPaymentHistoryTextIsCorrect() {
        driver.verifyThat().element(paymentHistoryTextLocator).textTrimmed().isEqualTo(paymentHistoryTextCl).withCustomReportMessage("assert that payment history text is correct").perform();
    }

    public void assertThatPaymentHistoryPaginationSettingsExists() {
        driver.verifyThat().element(paymentHistoryTableRowsNumberBtnLocator).exists().withCustomReportMessage("assert that rows number btn exists").perform();
        driver.verifyThat().element(paymentHistoryTablePagerLocator).exists().withCustomReportMessage("assert that table pager is exists").perform();
    }

    public void assertThatDefaultViewForTheTableIs20Rows() {
        driver.verifyThat().element(paymentHistoryTableRowsNumberLocator).textTrimmed().isEqualTo(paymentHistory20RowsNumberCl).withCustomReportMessage("assert that default view for the table is 20 rows").perform();
    }

    public void assertThatPaymentHistoryTableShowsTheRightColumns() {
        driver.verifyThat().element(paymentHistoryTableDateColumnLocator).textTrimmed().isEqualTo(paymentHistoryTableDateColumnTitleCl).withCustomReportMessage("assert first that column title is correct").perform();
        driver.verifyThat().element(paymentHistoryTableAmountColumnLocator).textTrimmed().isEqualTo(paymentHistoryTableAmountColumnTitleCl).withCustomReportMessage("assert second that column title is correct").perform();
        driver.verifyThat().element(paymentHistoryTableStatusColumnLocator).textTrimmed().isEqualTo(paymentHistoryTableStatusColumnTitleCl).withCustomReportMessage("assert third that column title is correct").perform();
        driver.verifyThat().element(paymentHistoryTablePaymentMethodColumnLocator).textTrimmed().isEqualTo(paymentHistoryTablePaymentMethodColumnTitleCl).withCustomReportMessage("assert fourth that column title is correct").perform();
    }

    public void assertOnNoPaymentHistoryNotificationCl() {
        driver.verifyThat().element(noPaymentHistoryNotificationLocator).textTrimmed().isEqualTo(noPaymentHistoryNotificationCl).withCustomReportMessage("assert on no payment history notification Cl").perform();

    }


    public void assertOnDunningNotificationTitleCaseB02() {
        driver.verifyThat().element(dunningNotificationTitleLocator).textTrimmed().isEqualTo(dunningNotificationTitleClB02).withCustomReportMessage("assert on dunning notification title case B-02").perform();
    }

    public void assertOnDunningNotificationDescriptionCaseB02() {
        driver.verifyThat().element(dunningNotificationTextLocator).textTrimmed().isEqualTo(dunningNotificationTextClB02).withCustomReportMessage("assert on dunning notification description case B-02").perform();
    }

    public void assertOnDunningNotificationTitleCaseB07() {
        driver.verifyThat().element(dunningNotificationTitleLocator).textTrimmed().isEqualTo(dunningNotificationTitleClB07).withCustomReportMessage("assert on dunning notification title case B-07").perform();
    }

    public void assertOnDunningNotificationDescriptionCaseB07() {
        driver.verifyThat().element(dunningNotificationTextLocator).textTrimmed().isEqualTo(dunningNotificationTextClB07).withCustomReportMessage("assert on dunning notification description case B-07").perform();
    }

    public void assertOnDunningNotificationTitleCaseB14() {
        driver.verifyThat().element(dunningNotificationTitleLocator).textTrimmed().isEqualTo(dunningNotificationTitleClB14).withCustomReportMessage("assert on dunning notification title case B-14").perform();
    }

    public void assertOnDunningNotificationDescriptionCaseB14() {
        driver.verifyThat().element(dunningNotificationTextLocator).textTrimmed().isEqualTo(dunningNotificationTextClB14).withCustomReportMessage("assert on dunning notification description case B-14").perform();
    }

    public void assertOnDunningNotificationTitleCaseB15() {
        driver.verifyThat().element(dunningNotificationTitleLocator).textTrimmed().isEqualTo(dunningNotificationTitleClB15).withCustomReportMessage("assert on dunning notification title case B-15").perform();
    }

    public void assertOnDunningNotificationDescriptionCaseB15() {
        driver.verifyThat().element(dunningNotificationTextLocator).textTrimmed().isEqualTo(dunningNotificationTextClB15).withCustomReportMessage("assert on dunning notification description case B-15").perform();
    }

    public void assertOnDunningNotificationCaseB20() {
        driver.verifyThat().element(dunningNotificationTitleLocator).textTrimmed().isEqualTo(dunningNotificationClB20).withCustomReportMessage("assert on dunning notification title case B-20").perform();
    }

    public void assertThatInstallmentPaymentMethodDoesNotExist() {
        driver.verifyThat().element(installmentBtnLocator).doesNotExist().withCustomReportMessage("assert that installment payment method doesn't exist").perform();
    }

    public void assertThatDunningAmountValueIsPresentedCorrectly(String amount) {
        driver.verifyThat().element(dunningAmountValueLocator).textTrimmed().isEqualTo(amount).withCustomReportMessage("assert that dunning amount value is presented correctly").perform();
    }

    public void assertThatPaymentHistoryTableDoesNotExist() {
        driver.verifyThat().element(historyTableSectionLocator).doesNotExist().withCustomReportMessage("Assert that payment history table doesnot exist").perform();
    }


}

