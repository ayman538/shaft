package de.vodafone.tests.billing.ST;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Rechnungen;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("ST")

public class WFCT_9503 extends ST_BillingSetup {

    Dashboard dashboard;
    Rechnungen rechnungen;
    String amount;
    int i;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        amount = testData.getTestData(method.getName() + ".amount");
    }

    @Test(description = "ST - GC01- kay user with credit amount check Rechnung graph and table in Meine Rechnungen")
    @TmsLink("WFCT-10339")
    public void GC01_kayCreditAmountChecksRechnungGraphAndTable() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertThatGuthabenWordExists();
        rechnungen.assertThatCreditIconExists();
        rechnungen.assertOnCreditNotificationTitle();
        rechnungen.assertOnCreditNotificationDescription();
        rechnungen.assertThatTheAmountTextColorIsGreen();
    }

    @Test(description = "ST - GC02- bart user with zero amount bill check Rechnung graph and table in Meine Rechnungen")
    @TmsLink("WFCT-10340")
    public void GC02_bartZeroAmountChecksRechnungGraphAndTable() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertThatBarHeight2px();
        rechnungen.assertOnThatFirstAmountValue(amount);
    }

    @Test(description = "ST - GC03- marie user has no invoices check Rechnung graph and table in Meine Rechnungen")
    @TmsLink("WFCT-10341")
    public void GC03_marieNoBillsChecksRechnungGraphAndTable() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertOnEmptyBeResponseNotificationTitle();
        rechnungen.assertOnEmptyBeResponseNotificationDescription();
    }

    @Test(description = "ST - GC04- kay user with one invoice check Rechnung graph and table in Meine Rechnungen")
    @TmsLink("WFCT-10342")
    public void GC04_kayOneInvoiceChecksRechnungGraphAndTable() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertThatFirstBarHeightIsNotZero();
        rechnungen.assertThatBarHeightIsZero(i);

    }

    @Test(description = "ST - GC05- bart user check Rechnung graph and table in Meine Rechnungen while service is not available")
    @TmsLink("WFCT-10343")
    public void GC05_bartServiceErrorChecksRechnungGraphAndTable() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertOnServiceErrorNotificationTitle();
        rechnungen.assertOnServiceErrorNotificationDescription();
        rechnungen.assertOnServiceErrorNotificationBtnText();
    }

    @Test(description = "ST - GC06- kay user has some invoice documents not retrieved check Rechnung graph and table in Meine Rechnungen")
    @TmsLink("WFCT-10344")
    public void GC06_kayInvoicePDFNotRetrievedChecksRechnungGraphAndTable() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertOnTheInvoiceWarningIconText();
    }

    @Test(description = "ST - GC07- bart user has PDF retrieved with no amount and due date check Rechnung graph and table in Meine Rechnungen")
    @Description("WFCT-10345")
    public void GC07_bartAmountAndDateNotRetrievedChecksRechnungGraphAndTable() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertOnNotRetrievedAmountText();
        rechnungen.assertOnNotRetrievedDateText();
        rechnungen.assertThatTheFirstBarHeightIsZero();
    }


    @Test(description = "ST - GC08- marie user has some itemized documents not retrieved check Rechnung graph and table in Meine Rechnungen")
    @TmsLink("WFCT-10346")
    public void GC08_marieItemizedPDFNotRetrievedChecksRechnungGraphAndTable() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertOnTheItemizedWarningIconText();
    }

}



