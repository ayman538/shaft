package de.vodafone.tests.kableDeutschland.SIT;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.DocInboxFiltering;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("SIT")
@Story("WFDT_5212")
public class WFDT_5212 extends SIT_KableDeutschlandSetup{
    @TmsLink("WFDT-6848")
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

    @TmsLink("WFDT-6849")
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

    @TmsLink("WFDT-6601")
    @Test(description = "GC07 || Multi has Martin - Verify deep link to document inbox with added parameters for date filter and MBO selection",groups = {"eCare"})
    private void gc07() {
        new DocInboxFiltering(driver)
                .DeeplinkWithValidDocFiltersParamsOfThisYear();


        new DocInboxFiltering(driver).BackToDashboard();
        new DocInboxFiltering(driver)
                .DeeplinkWithValidDocFiltersParamsOfThisMonth()
                .checkSelectedFilters()
                .BackToDashboard();

        new DocInboxFiltering(driver)
                .DeeplinkWithInValidDocFiltersParams()
                .ExpandDocumentsFiltersAccordion()
                .checkDefaultFilterOfDeeplink();

    }

}
