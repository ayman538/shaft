package de.vodafone.tests.billing.SIT;

import de.vodafone.pages.billing.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("SIT")
@Story("WFCT-10045")

public class WFCT_10045 extends SIT_BillingSetup {
    String contractOrder;
    Dashboard dashboard;
    AutoTopUPAccordion autoTopUPAccordion;
    AutoTopUpDeletionPage autoTopUpDeletionPage;
    String mappedValue;



    @BeforeMethod
    public void testDataSetup(Method method) {
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");
        dashboard = new Dashboard(driver);
        autoTopUPAccordion = new AutoTopUPAccordion(driver);
        autoTopUpDeletionPage = new AutoTopUpDeletionPage(driver);
        mappedValue = testData.getTestData(method.getName() + ".mappedValue");
    }

    @Test(description = "WFCT-10045 | GC01 - user check dynamic value for recharge")
    @TmsLink("WFCT-11243")
    public void GC01_userCheckDynamicValueForRecharge() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineAufladungTile();
        autoTopUPAccordion.assertThatUserHasActiveAutoTopUp();
        autoTopUPAccordion.assertThatAutoTopUpDaysValueIsCorrectlyMapped(mappedValue);
        autoTopUPAccordion.clickAutoTopUpDeleteBtn();
        autoTopUpDeletionPage.assertThatAutoTopUpDaysValueIsCorrectlyMappedInDeletionPage(mappedValue);
    }

}
