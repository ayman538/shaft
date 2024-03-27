package de.vodafone.tests.Payment.SIT;

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
@Feature("SIT")
@Story("WFCT-14002")

public class WFCT_14002 extends SIT_PaymentSetup {

    Dashboard dashboard;
    PontisOffersViewPage pontisOffersViewPage;
    PontisOffersConfirmationPage pontisOffersConfirmationPage;
    String accordionTitle;
    String accordionDescription;


    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        pontisOffersViewPage = new PontisOffersViewPage(driver);
        pontisOffersConfirmationPage = new PontisOffersConfirmationPage(driver);
        accordionTitle = testData.getTestData(method.getName() + ".accordionTitle");
        accordionDescription = testData.getTestData(method.getName() + ".accordionDescription");
    }

    @Test(description = "GC01 - Paul user with 'book option' offer checks booking the offer")
    public void GC01_PaulUserWithBookOptionOfferChecksBookingTheOffer(){
        dashboard.clickOnOfferButton();
        pontisOffersViewPage
                .assertOnPageTitle()
                .assertOnAccordionHeadline()
                .assertOnOfferTitle(accordionTitle)
                .assertOnOfferDescription(accordionDescription)
                .clickConfirmBtn();
        pontisOffersConfirmationPage
                .assertOnSuccessNotificationTitle()
                .assertOnSuccessNotificationDescription()
                .assertOnAccordionHeadline()
                .expandAccordion()
                .assertOnOfferTitle(accordionTitle)
                .assertOnOfferDescription(accordionDescription)
                .clickSchliesenBtn();
        dashboard.assertThatUserNavigatedToDashboard();
    }
}
