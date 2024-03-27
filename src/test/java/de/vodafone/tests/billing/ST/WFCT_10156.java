package de.vodafone.tests.billing.ST;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Kostenubersicht;
import de.vodafone.pages.billing.MeineRechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("ST")

public class WFCT_10156 extends ST_BillingSetup {
    Kostenubersicht kostenubersicht;
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;

    @BeforeMethod
    public void beforeMethod(Method method) {
        kostenubersicht = new Kostenubersicht(driver);
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
    }

    @Test(description = "Kay user with less than 12 numbers checks Kostenübersicht Tab in Meine Rechnungen page")
    @TmsLink("WFCT-10493")
    public void GC01_KayUserWithLessThan12NumbersChecksKostenübersichtTabInMeineRechnungenPage() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertOnTableHeadLineText();
        kostenubersicht.assertOnTableDescriptionText();
        kostenubersicht.assertOnMobileNumberTitleText();
        kostenubersicht.assertOnCostOverviewTitleText();
        kostenubersicht.assertOnConnectionOverviewTitleText();
        kostenubersicht.assertOnTheFirstCostPdfDownloadIcon();
        kostenubersicht.assertOnTheFirstCostPdfPreviewIcon();
        kostenubersicht.assertOnTheFirstConnectionPdfDownloadIcon();
        kostenubersicht.assertOnTheFirstConnectionPdfPreviewIcon();
        kostenubersicht.assertThatShowMoreBtnDoesNotExist();
    }

    @Test(description = "Bart user with 12 numbers checks Kostenübersicht Tab in Meine Rechnungen page")
    @TmsLink("WFCT-10494")
    public void GC02_BartUserWith12NumbersChecksKostenübersichtTabInMeineRechnungenPage() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertOnTableHeadLineText();
        kostenubersicht.assertOnTableDescriptionText();
        kostenubersicht.assertOnMobileNumberTitleText();
        kostenubersicht.assertOnCostOverviewTitleText();
        kostenubersicht.assertOnConnectionOverviewTitleText();
        kostenubersicht.assertOnTheFirstCostPdfDownloadIcon();
        kostenubersicht.assertOnTheFirstCostPdfPreviewIcon();
        kostenubersicht.assertOnTheFirstConnectionPdfDownloadIcon();
        kostenubersicht.assertOnTheFirstConnectionPdfPreviewIcon();
        kostenubersicht.assertThatShowMoreBtnDoesNotExist();
    }

    @Test(description = "Kay user with more than 12 numbers checks Kostenübersicht Tab in Meine Rechnungen page" )
    @TmsLink("WFCT-10495")
    public void GC03_KayUserWithMoreThan12NumbersChecksKostenübersichtTabInMeineRechnungenPage() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertOnTableHeadLineText();
        kostenubersicht.assertOnTableDescriptionText();
        kostenubersicht.assertOnMobileNumberTitleText();
        kostenubersicht.assertOnCostOverviewTitleText();
        kostenubersicht.assertOnConnectionOverviewTitleText();
        kostenubersicht.assertOnTheFirstCostPdfDownloadIcon();
        kostenubersicht.assertOnTheFirstCostPdfPreviewIcon();
        kostenubersicht.assertOnTheFirstConnectionPdfDownloadIcon();
        kostenubersicht.assertOnTheFirstConnectionPdfPreviewIcon();
        kostenubersicht.assertOnShowMoreBtnText();
        kostenubersicht.clickShowMore();
        kostenubersicht.assertOnShowLessBtnText();

    }

}
