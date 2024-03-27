package de.vodafone.tests.kableDeutschland.SIT;

import de.vodafone.pages.Kabledeutschland.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("SIT")
@Story("WFDT_5211")
public class WFDT_5211 extends SIT_KableDeutschlandSetup{
    @TmsLink("WFDT-5455")
    @Test(description = "GC01 || Multi user has Martin- Verify document inbox for cable user,MBO selection and pagination for more than 10 documents",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver);
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

    @TmsLink("WFDT-6277")
    @Test(description = "GC02 || Martin - Verify document inbox for single cable user,documents sorting and pagination for less than 10 documents",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).clickDocumentsAndOrdersNotification();
        new Dashboard(driver).clickMyDocumentsInbox();

        new MyDocuments(driver)
                .validateDocumentsInformationforLessthan10Docs()
                .validatePaginationNotExists();
    }

    @TmsLink("WFDT-6279")
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

}
