package de.vodafone.tests.billing.SIT;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Kostenubersicht;
import de.vodafone.pages.billing.MeineRechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("SIT")
@Story("WFCT-10156")

public class WFCT_10156 extends SIT_BillingSetup {
    Kostenubersicht kostenubersicht;
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    String contractOrder;

    @BeforeMethod
    public void beforeMethod(Method method) {
        kostenubersicht = new Kostenubersicht(driver);
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        contractOrder =testData.getTestData(method.getName()+".contractOrder");

    }


    @Test(description = "Kay user with more than 12 numbers checks Kostenübersicht Tab in Meine Rechnungen page" )
    @TmsLink("WFCT-10496")
    public void GC01_KayUserWithMoreThan12NumbersChecksKostenübersichtTabInMeineRechnungenPage() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile(contractOrder);
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertOnTableHeadLineText();
        kostenubersicht.assertOnTableDescriptionText();
        kostenubersicht.assertOnMobileNumberTitleText();
        kostenubersicht.assertOnCostOverviewTitleText();
        kostenubersicht.assertOnConnectionOverviewTitleText();
        kostenubersicht.assertOnTheFirstCostPdfDownloadIcon();
        kostenubersicht.assertOnTheFirstCostPdfPreviewIcon();
        kostenubersicht.assertOnNotRetrievedConnectionPdfWarningIcon();
        kostenubersicht.assertOnShowMoreBtnText();
        kostenubersicht.clickShowMore();
        kostenubersicht.assertThatInvoicesNumMoreThan12();
        kostenubersicht.assertOnShowLessBtnText();

    }

}
