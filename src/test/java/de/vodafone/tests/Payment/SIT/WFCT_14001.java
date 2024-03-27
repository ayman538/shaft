package de.vodafone.tests.Payment.SIT;

import de.vodafone.pages.Payment.Dashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Payment")
@Feature("SIT")
@Story("WFCT-14001")

public class WFCT_14001 extends SIT_PaymentSetup {
    Dashboard dashboard;
    String offer1text;
    String offer2text;
    String offer3text;
    String offersCount;
    String informativeOfferOverlayDescription;
    String informativeOfferOverlayTitle;
    String contractOrder;


    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        offer1text = testData.getTestData(method.getName() + ".offer1text");
        offer2text = testData.getTestData(method.getName() + ".offer2text");
        offer3text = testData.getTestData(method.getName() + ".offer3text");
        offersCount = testData.getTestData(method.getName() + ".offersCount");
        informativeOfferOverlayDescription = testData.getTestData(method.getName() + ".informativeOfferOverlayDescription");
        informativeOfferOverlayTitle = testData.getTestData(method.getName() + ".informativeOfferOverlayTitle");
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");
    }



        @Test(description = "GC02- paul (TN) user with Three offers (same type) check points offers in the dashboard")
        @TmsLink("WFCT-14401")
        public void GC02_paulTNUserWithThreeOffersSameTypeCheckPointsOffersInTheDashboard() {
            dashboard.expandContracts(contractOrder);
            dashboard.assertOnPointsOffersAccTitle();
            dashboard.assertOnOfferCount(offersCount);
            dashboard.assertOnOfferText(offer1text);
            dashboard.selectOffer("1");
            dashboard.assertOnOfferText(offer2text);
            dashboard.selectOffer("2");
            dashboard.assertOnOfferText(offer3text);
            dashboard.assertOnOfferButtonCL();

        }

        @Test(description = "GC05- paul user with informative offer check points offers in the dashboard")
        @TmsLink("WFCT-14405")
        public void GC05_paulUserWithInformativeOfferCheckPointsOffersInTheDashboard() {
            dashboard.expandContracts(contractOrder);
            dashboard.selectOffer("1");
            dashboard.assertOnOfferText(offer1text);
            dashboard.assertOnOfferButtonCL();
            dashboard.clickOnOfferButton();
            dashboard.assertOnInformativeOfferOverlayTitle(informativeOfferOverlayTitle);
            dashboard.assertOnInformativeOfferOverlayDescription(informativeOfferOverlayDescription);
            dashboard.closeInformativeOffer();
            dashboard.assertThatInformativeOfferOverlayIsClosed();
            dashboard.selectOffer("1");
            dashboard.clickOnOfferButton();
            dashboard.assertThatInformativeOfferOverlayIsOpened();


        }
    }

