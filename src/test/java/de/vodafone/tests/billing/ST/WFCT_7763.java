package de.vodafone.tests.billing.ST;


import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Rechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Epic("Billing")
@Feature("ST")
public class WFCT_7763 extends ST_BillingSetup {
    Dashboard dashboard;
    Rechnungen rechnungen;

    @BeforeMethod
    public void beforeMethod() {
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
    }

    @Test(description = "ST - GC01- kay user with less than 12 bills check rechnung table in Meine Rechnungen")
    @TmsLink("WFCT-10432")
    public void GC01_kayUserWithLessThan12BillsCheckRechnungTableInMeineRechnungen() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertOnTableTitleText();
        rechnungen.assertOnTableDescriptionText();
        rechnungen.assertThatShowMoreBtnNotExist();
        rechnungen.assertThatItemizedColumnNotExist();
        rechnungen.assertThatMonthColumnExists();
        rechnungen.assertThatAmountColumnExists();
        rechnungen.assertThatDueDateColumnExists();
        rechnungen.assertThatInvoiceColumnExists();
        rechnungen.assertThatInvoiceDownloadIconExists();
        rechnungen.assertThatInvoicePreviewIconExists();

    }

    @Test(description = "ST - GC02- bart user with 12 bills some of them are in the same month check rechnung table in Meine Rechnungen")
    @TmsLink("WFCT-10433")
    public void GC02_bartUserWith12BillsSomeOfThemAreInTheSameMonthCheckRechnungTableInMeineRechnungen() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertOnTableTitleText();
        rechnungen.assertOnTableDescriptionText();
        rechnungen.assertThatShowMoreBtnNotExist();
        rechnungen.assertThatItemizedColumnNotExist();
        rechnungen.assertThatMonthColumnExists();
        rechnungen.assertThatAmountColumnExists();
        rechnungen.assertThatDueDateColumnExists();
        rechnungen.assertThatInvoiceColumnExists();
        rechnungen.assertThatInvoiceDownloadIconExists();
        rechnungen.assertThatInvoicePreviewIconExists();
        rechnungen.assertThatTheFirst2MonthsHaveTheSameName();

    }


    @Test(description = "ST - GC03- marie user with more than 12 bills some of them are itemized in the last 6 months check rechnung table in Meine Rechnungen")
    @TmsLink("WFCT-10434")
    public void GC03_MarieUserWithMoreThan12BillsSomeOfThemAreItemizedInThelast6MonthsCheckRechnungTableInMeineRechnungen() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertOnTableTitleText();
        rechnungen.assertOnTableDescriptionText_MarieNoUsageItemized();
        rechnungen.assertThatShowMoreBtnExists();
        rechnungen.assertOnShowMoreBtnText();
        rechnungen.clickShowMore();
        rechnungen.assertThatItemizedColumnExists();
        rechnungen.assertThatMonthColumnExists();
        rechnungen.assertThatAmountColumnExists();
        rechnungen.assertThatDueDateColumnExists();
        rechnungen.assertThatInvoiceColumnExists();
        rechnungen.assertThatInvoiceDownloadIconExists();
        rechnungen.assertThatInvoicePreviewIconExists();
        rechnungen.assertThatItemizedPreviewIconExists();
        rechnungen.assertThatItemizedDownloadIconExists();
        rechnungen.assertOnShowLessBtnText();

    }


    @Test(description = "ST - GC04- marie user with less than 12 bills and has no itemized bill check rechnung table in Meine Rechnungen")
    @TmsLink("WFCT-10435")
    public void GC04_MarieUserWithLessThan12BillsAndHasNoItemizedBillCheckRechnungTableInMeineRechnungen() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertOnTableTitleText();
        rechnungen.assertOnTableDescriptionText_MarieNotRetrievedItemized();
        rechnungen.assertThatShowMoreBtnNotExist();
        rechnungen.assertThatItemizedColumnNotExist();
        rechnungen.assertThatMonthColumnExists();
        rechnungen.assertThatAmountColumnExists();
        rechnungen.assertThatDueDateColumnExists();
        rechnungen.assertThatInvoiceColumnExists();
        rechnungen.assertThatInvoiceDownloadIconExists();
        rechnungen.assertThatInvoicePreviewIconExists();

    }

}
