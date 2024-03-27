package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.MyDocuments;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_5211")
public class WFDT_5211 extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-5429")
    @Test(description = "GC01 || Multi user has Martin- Verify document inbox for cable user,MBO selection and pagination for more than 10 documents",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).clickDocumentsAndOrdersNotification();
        new Dashboard(driver).clickMyDocumentsInbox();

        new MyDocuments(driver)
                .validateMyDocumentsPage()
                .returnToDashboard();

        new Dashboard(driver).selectSecondSubscriber();
        new Dashboard(driver).clickDocumentsAndOrdersNotification();
        new Dashboard(driver).clickMyDocumentsInbox();

        new MyDocuments(driver)
                .validateDocumentsInformationforMorethan10Docs()
                .validatePaginationFirstPage()
                .clicklastPagebutton()
                .validatePaginationLastPage()
                .validateLastPageNotificationMessage();
    }

    @TmsLink("WFDT-5430")
    @Test(description = "GC02 || Martin - Verify document inbox for single cable user,documents sorting and pagination for less than 10 documents",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).clickDocumentsAndOrdersNotification();
        new Dashboard(driver).clickMyDocumentsInbox();

        new MyDocuments(driver)
                .validateDocumentsInformationforLessthan10Docs()
                .validatePaginationNotExists();
    }

    @TmsLink("WFDT-5431")
    @Test(description = "GC03 || Martin SOHO & Consumer - Check switching between 2 contracts from contract chooser, one with documents and the other without documents",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).clickDocumentsAndOrdersNotification();
        new Dashboard(driver).clickMyDocumentsInbox();

        new MyDocuments(driver)
                .validateMyDocumentsPageInCaseSwitchingWithoutSelectingContract()
                .clickDropdowncontractsChooser()
                .clickSohoContractFromDropdown()
                .validateMyDocumentsPageInCaseSelectingSOHOContract()
                .clickDropdowncontractsChooser()
                .clickConsumerContractFromDropdown()
                .validateMyDocumentsPageInCaseSelectingConsumerContract();
    }

    @TmsLink("WFDT-5432")
    @Test(description = "GC04 || Martin - Verify preview and download buttons functionality and documents naming convention",groups = {"eCare"})
    private void gc04() {
        new Dashboard(driver).clickDocumentsAndOrdersNotification();
        new Dashboard(driver).clickMyDocumentsInbox();

        new MyDocuments(driver)
                .clickDocumentPreviewButton()
                .verifyPreviewButton()
                .clickDocumentContentCloseButton()
                .clickDocumentPreviewButton()
                .clickDocumentContentCloseButton()
                .clickDocumentDownloadButton();
    }

    @TmsLink("WFDT-5433")
    @Test(description = "GC05 || Multi user has Martin - Verify selected and not selected MBO through deep linking to document inbox page",groups = {"eCare"})
    private void gc05() {
        new Dashboard(driver).deeplinkToMyDocumentsInbox();
        new MyDocuments(driver).verifyMyDocumentsPageTitle();
        new Dashboard(driver).returnBackToDashboard();
        new Dashboard(driver).selectSecondSubscriber();
        new Dashboard(driver).deeplinkToMyDocumentsInbox();
        new MyDocuments(driver).verifyMyDocumentsPageTitle();
    }

}