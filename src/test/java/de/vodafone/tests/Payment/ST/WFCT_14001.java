package de.vodafone.tests.Payment.ST;

import de.vodafone.pages.Payment.Dashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Payment")
@Feature("ST")
@Story("WFCT-14001")

public class WFCT_14001 extends ST_PaymentSetup {

    Dashboard dashboard;
    String offer1text;
    String offer2text;
    String offer3text;
    String offersCount;
    String informativeOfferOverlayDescription;
    String informativeOfferOverlayTitle;


    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        offer1text = testData.getTestData(method.getName() + ".offer1text");
        offer2text = testData.getTestData(method.getName() + ".offer2text");
        offer3text = testData.getTestData(method.getName() + ".offer3text");
        offersCount = testData.getTestData(method.getName() + ".offersCount");
        informativeOfferOverlayDescription = testData.getTestData(method.getName() + ".informativeOfferOverlayDescription");
        informativeOfferOverlayTitle = testData.getTestData(method.getName() + ".informativeOfferOverlayTitle");


    }

    @Test(description = "GC01 - paul user with one offer check points offers in the dashboard")
    @TmsLink("WFCT-14400")
    public void GC01_paulUserWithOneOfferCheckPointsOffersInTheDashboard() {
        dashboard.assertOnPointsOffersAccTitle();
        dashboard.assertOnPointsOffersAccDescription();
        dashboard.assertOnOfferText(offer1text);
        dashboard.assertOnOfferButtonCL();
        dashboard.assertOnOfferCount(offersCount);
    }

    @Test(description = "GC02- paul (TN) user with Three offers (same type) check points offers in the dashboard")
    @TmsLink("WFCT-14401")
    public void GC02_paulTNUserWithThreeOffersSameTypeCheckPointsOffersInTheDashboard() {
        dashboard.assertOnPointsOffersAccTitle();
        dashboard.assertOnOfferCount(offersCount);
        dashboard.assertOnOfferText(offer1text);
        dashboard.selectOffer("1");
        dashboard.assertOnOfferText(offer2text);
        dashboard.selectOffer("2");
        dashboard.assertOnOfferText(offer3text);
        dashboard.assertOnOfferButtonCL();

    }

    @Test(description = "GC03- paul (kd) user with five offers check points offers in the dashboard")
    @TmsLink("WFCT-14403")
    public void GC03_paulKdUserWithFiveOffersCheckPointsOffersInTheDashboard() {
        dashboard.assertOnPointsOffersAccTitle();
        dashboard.assertOnOfferButtonCL();
        dashboard.assertOnOfferCount(offersCount);

    }

    @Test(description = "GC04- paul user with zero offer check points offers in the dashboard")
    @TmsLink("WFCT-14404")
    public void GC04_paulUserWithZeroOfferCheckPointsOffersInTheDashboard() {
        dashboard.assertThatPointsOffersAccDoesNotExist();

    }

    @Test(description = "GC05- paul user with informative offer check points offers in the dashboard")
    @TmsLink("WFCT-14405")
    public void GC05_paulUserWithInformativeOfferCheckPointsOffersInTheDashboard() {
        dashboard.assertOnPointsOffersAccTitle();
        dashboard.assertOnOfferText(offer1text);
        dashboard.assertOnOfferButtonCL();
        dashboard.clickOnOfferButton();
        dashboard.assertOnInformativeOfferOverlayTitle(informativeOfferOverlayTitle);
        dashboard.assertOnInformativeOfferOverlayDescription(informativeOfferOverlayDescription);
        dashboard.closeInformativeOffer();
        dashboard.waitTillLoad();
        dashboard.assertThatInformativeOfferOverlayIsClosed();
        dashboard.clickOnOfferButton();
        dashboard.waitTillLoad();
        dashboard.assertThatInformativeOfferOverlayIsOpened();


    }

    @Test(description = "GC06- paul user with failure in pontis_get service check points offers in the dashboard")
    @TmsLink("WFCT-14406")
    public void GC06_paulUserWithFailureInPointsGetServiceCheckPointsOffersInTheDashboard() {
        dashboard.assertThatPointsOffersAccDoesNotExist();

    }
}
