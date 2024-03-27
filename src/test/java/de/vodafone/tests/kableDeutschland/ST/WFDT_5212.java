package de.vodafone.tests.kableDeutschland.ST;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.DocInboxFiltering;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_5212")
public class WFDT_5212  extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-6594")
    @Test(description = "GC01 || Martin - Verify document's Filtering by date range of last month and the confirmation button",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).clickDocumentsAndOrdersNotification();
        new Dashboard(driver).clickMyDocumentsInbox();

        new DocInboxFiltering(driver)
                .checkAccordionFiltersTitles()
                .ExpandDocumentsFiltersAccordion()
                .checkDocumentsDisplayed()
                .ExpandDocumentsFiltersDDL()
                .ChooseLastMonthFilter()
                .checkRelatedDocumentsDisplayed()
                .ConfirmFiltering()
                .checkDocumentsFilter();
    }

    @TmsLink("WFDT-6595")
    @Test(description = "GC02 || Martin - Verify document's Filtering by date range of last two month and the cancellation button",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).clickDocumentsAndOrdersNotification();
        new Dashboard(driver).clickMyDocumentsInbox();

        new DocInboxFiltering(driver)
                .ExpandDocumentsFiltersAccordion()
                .ExpandDocumentsFiltersDDL()
                .ChooseLastTwoMonthsFilter()
                .ConfirmFiltering()
                .checkFilters();
    }

    @TmsLink("WFDT-6596")
    @Test(description = "GC03 || Martin - Verify document's Filtering by date range of this year in case user has more than 10 documents",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).clickDocumentsAndOrdersNotification();
        new Dashboard(driver).clickMyDocumentsInbox();

        new DocInboxFiltering(driver)
                .ExpandDocumentsFiltersAccordion()
                .ExpandDocumentsFiltersDDL()
                .ChooseThisYearFilter()
                .ConfirmFiltering()
                .checkChosenFilters()
                .ClickOnPaginationNext()
                .ClickOnPaginationPrevious()
                .ClickOnPaginationLastNext()
                .ClickOnPaginationFirstPrevious();
    }

    @TmsLink("WFDT-6597")
    @Test(description = "GC04 || Martin - Verify document's Filtering by date range of last year in case user has less than 10 documents",groups = {"eCare"})
    private void gc04() {
        new Dashboard(driver).clickDocumentsAndOrdersNotification();
        new Dashboard(driver).clickMyDocumentsInbox();

        new DocInboxFiltering(driver)
                .ExpandDocumentsFiltersAccordion()
                .ExpandDocumentsFiltersDDL()
                .ChooseLastYearFilter()
                .ConfirmFiltering()
                .checkNewChosenFilters();
    }

    @TmsLink("WFDT-6598")
    @Test(description = "GC05 || Martin - Verify document's Filtering by date range of this month and reloading the page after apply filter",groups = {"eCare"})
    private void gc05() {
        new Dashboard(driver).clickDocumentsAndOrdersNotification();
        new Dashboard(driver).clickMyDocumentsInbox();

        new DocInboxFiltering(driver)
                .ExpandDocumentsFiltersAccordion()
                .ExpandDocumentsFiltersDDL()
                .ChooseThisMonthFilter()
                .ConfirmFiltering()
                .checkFiltersAppliedAfterReload();

        new Dashboard(driver).GoToPreviousPage();
        new Dashboard(driver).GoToForwardPage();

        new DocInboxFiltering(driver)
                .checkChosenFilter()
                .BackToDashboard();

        new Dashboard(driver).clickDocumentsAndOrdersNotification();
        new Dashboard(driver).clickMyDocumentsInbox();

        new DocInboxFiltering(driver)
                .ExpandDocumentsFiltersAccordion()
                .checkDefaultFilterOfDeeplink();
    }

}
