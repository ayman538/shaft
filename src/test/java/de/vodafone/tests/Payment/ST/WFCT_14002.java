package de.vodafone.tests.Payment.ST;


import com.shaft.driver.SHAFT;
import de.vodafone.pages.Payment.Dashboard;
import de.vodafone.pages.Payment.PontisOffersConfirmationPage;
import de.vodafone.pages.Payment.PontisOffersViewPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Payment")
@Feature("ST")
@Story("WFCT-14002")

public class WFCT_14002 extends ST_PaymentSetup {
    Dashboard dashboard;
    PontisOffersViewPage pontisOffersViewPage;
    PontisOffersConfirmationPage pontisOffersConfirmationPage;
    String offerTitle;
    String offerDescription;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        pontisOffersViewPage = new PontisOffersViewPage(driver);
        pontisOffersConfirmationPage = new PontisOffersConfirmationPage(driver);
        offerTitle = testData.getTestData(method.getName() + ".offerTitle");
        offerDescription = testData.getTestData(method.getName() + ".offerDescription");
    }

    @Test(description = "GC01 - Paul user with 'book option' offer checks booking the offer")
    public void GC01_PaulUserWithBookOptionOfferChecksBookingTheOffer() {
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

    @Test(description = "GC02 - Paul user with 'change tariff' offer checks booking the offer")
    public void GC02_PaulUserWithChangeTariffOfferChecksBookingTheOffer() {
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

    @Test(description = "GC03 - Paul user with 'various' offer checks booking the offer")
    public void GC03_PaulUserWithVariousOfferChecksBookingTheOffer() {
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
    public void GC04_PaulUserWithTopUpOfferChecksBookingTheOffer() {
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

}
