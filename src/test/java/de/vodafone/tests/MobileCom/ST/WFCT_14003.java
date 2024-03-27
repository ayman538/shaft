package de.vodafone.tests.MobileCom.ST;

import com.shaft.driver.SHAFT;
import de.vodafone.pages.Payment.Dashboard;
import de.vodafone.pages.Payment.PontisOffersConfirmationPage;
import de.vodafone.pages.Payment.PontisOffersViewPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
@Epic("MobileCom")
@Feature("ST")
@Story("WFCT-14003")
public class WFCT_14003 extends ST_MobileComSetup {
    Dashboard dashboard;
    PontisOffersViewPage pontisOffersViewPage;
    PontisOffersConfirmationPage pontisOffersConfirmationPage;
    String offerTitle;
    String offerDescription;
    String informativeOfferOverlayDescription;
    String informativeOfferOverlayTitle;
    String offer1text;

    @BeforeMethod
    public void beforeMethod(Method method) {
        SHAFT.Properties.flags.set().disableCache(true);
        dashboard = new Dashboard(driver);
        pontisOffersViewPage = new PontisOffersViewPage(driver);
        pontisOffersConfirmationPage = new PontisOffersConfirmationPage(driver);
        offerTitle = testData.getTestData(method.getName() + ".offerTitle");
        offerDescription = testData.getTestData(method.getName() + ".offerDescription");
        offer1text = testData.getTestData(method.getName() + ".offer1text");
        informativeOfferOverlayDescription = testData.getTestData(method.getName() + ".informativeOfferOverlayDescription");
        informativeOfferOverlayTitle = testData.getTestData(method.getName() + ".informativeOfferOverlayTitle");
    }

    @Test(description = "GC01 - Robert user with 'book option' offer checks booking the offer")
    @TmsLink("WFCT-15070")
    public void GC01_RobertUserWithBookOptionOfferChecksBookingTheOffer() {
        dashboard.clickOnOfferButton();
        pontisOffersViewPage
                .assertOnPageTitle()
                .assertOnAccordionHeadline()
                .assertOnOfferTitle(offerTitle)
                .assertOnOfferDescription(offerDescription)
                .clickConfirmBtn();
        pontisOffersConfirmationPage
                .assertOnSuccessNotificationTitle()
                .assertOnSuccessNotificationDescription()
                .assertOnAccordionHeadline()
                .expandAccordion()
                .assertOnOfferTitle(offerTitle)
                .assertOnOfferDescription(offerDescription);
    }

    @Test(description = "GC02 - Robert user with 'change tariff' offer checks booking the offer")
    @TmsLink("WFCT-15071")
    public void GC02_RobertUserWithChangeTariffOfferChecksBookingTheOffer() {
        dashboard.clickOnOfferButton();
        pontisOffersViewPage
                .assertOnOfferTitle(offerTitle)
                .assertOnOfferDescription(offerDescription)
                .clickConfirmBtn();
        pontisOffersConfirmationPage
                .expandAccordion()
                .assertOnOfferTitle(offerTitle)
                .assertOnOfferDescription(offerDescription);

    }

    @Test(description = "GC03 - Robert user with 'various' offer checks booking the offer")
    @TmsLink("WFCT-15072")
    public void GC03_RobertUserWithVariousOfferChecksBookingTheOffer() {
        dashboard.clickOnOfferButton();
        pontisOffersViewPage
                .assertOnOfferTitle(offerTitle)
                .assertOnOfferDescription(offerDescription)
                .clickConfirmBtn();
        pontisOffersConfirmationPage
                .expandAccordion()
                .assertOnOfferTitle(offerTitle)
                .assertOnOfferDescription(offerDescription);

    }

    @Test(description = "GC04 - Paul user with 'Topup' offer checks booking the offer")
    @TmsLink("WFCT-15073")
    public void GC04_RobertUserWithTopUpOfferChecksBookingTheOffer() {
        dashboard.clickOnOfferButton();
        pontisOffersViewPage
                .assertOnOfferTitle(offerTitle)
                .assertOnOfferDescription(offerDescription)
                .clickConfirmBtn();
        pontisOffersConfirmationPage
                .expandAccordion()
                .assertOnOfferTitle(offerTitle)
                .assertOnOfferDescription(offerDescription);

    }
    @Test(description = "GC05- Robert user with informative offer check points offers in the dashboard")
    @TmsLink("WFCT-15076")
    public void GC05_RobertUserWithInformativeOfferCheckPointsOffersInTheDashboard() {
        dashboard.assertOnOfferText(offer1text);
        dashboard.assertOnOfferButtonCL();
        dashboard.clickOnOfferButton();
        dashboard.assertOnInformativeOfferOverlayTitle(informativeOfferOverlayTitle);
        dashboard.assertOnInformativeOfferOverlayDescription(informativeOfferOverlayDescription);
        dashboard.closeInformativeOfferRobert();
        dashboard.waitTillLoad();
        dashboard.assertThatInformativeOfferOverlayIsClosed();
        dashboard.clickOnOfferButton();
        dashboard.waitTillLoad();
        dashboard.assertThatInformativeOfferOverlayIsOpened();


    }
}
