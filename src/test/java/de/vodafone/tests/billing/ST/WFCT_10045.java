package de.vodafone.tests.billing.ST;


import de.vodafone.pages.billing.AutoTopUPAccordion;
import de.vodafone.pages.billing.AutoTopUpDeletionPage;
import de.vodafone.pages.billing.Dashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("ST")

public class WFCT_10045 extends ST_BillingSetup {
    Dashboard dashboard;
    AutoTopUPAccordion autoTopUPAccordion;
    AutoTopUpDeletionPage autoTopUpDeletionPage;
    String mappedValue;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        autoTopUPAccordion = new AutoTopUPAccordion(driver);
        autoTopUpDeletionPage = new AutoTopUpDeletionPage(driver);
        mappedValue = testData.getTestData(method.getName() + ".mappedValue");
    }

    @Test(description = "ST - GC01 - user with active top up check dynamic value for recharge")
    @TmsLink("WFCT-11243")
    public void GC01_paulActiveTopUp20Days() {
        dashboard.clickMeineAufladungTile();
        autoTopUPAccordion.assertThatUserHasActiveAutoTopUp();
        autoTopUPAccordion.assertThatAutoTopUpDaysValueIsCorrectlyMapped(mappedValue);
        autoTopUPAccordion.clickAutoTopUpDeleteBtn();
        autoTopUpDeletionPage.assertThatAutoTopUpDaysValueIsCorrectlyMappedInDeletionPage(mappedValue);
    }


    @Test(description = "ST - GC02 - user with paused auto top up check dynamic value for recharge")
    @TmsLink("WFCT-11244")
    public void GC02_paulPausedTopUp30Days() {
        dashboard.clickMeineAufladungTile();
        autoTopUPAccordion.assertThatUserHasPausedAutoTopUp();
        autoTopUPAccordion.assertThatAutoTopUpDaysValueIsCorrectlyMapped(mappedValue);
        autoTopUPAccordion.clickAutoTopUpDeleteBtn();
        autoTopUpDeletionPage.assertThatAutoTopUpDaysValueIsCorrectlyMappedInDeletionPage(mappedValue);
    }


}
