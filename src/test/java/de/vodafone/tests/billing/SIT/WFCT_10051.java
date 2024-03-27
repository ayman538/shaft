package de.vodafone.tests.billing.SIT;


import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Einstellungen;
import de.vodafone.pages.billing.Rechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("SIT")
@Story("WFCT-10051")

public class WFCT_10051 extends SIT_BillingSetup {
    Dashboard dashboard;
    Rechnungen rechnungen;
    Einstellungen einstellungen;
    String contractOrder;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        einstellungen = new Einstellungen(driver);
        contractOrder =testData.getTestData(method.getName()+".contractOrder");

    }



    @Test(description = "GC01-Mobile user with paper and online bills checks Meine Rechnungen Page")
    @TmsLink("WFCT-10350")
    public void GC01_MobileUserWithPaperAndOnlineBillsChecksMeineRechnungenPage() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile(contractOrder);
        rechnungen.assertOnPaperAndOnlineNotificationTitle();
        rechnungen.assertOnPaperAndOnlineNotificationBody();
        rechnungen.assertOnPaperAndOnlineNotificationColor();
        rechnungen.assertOnPaperAndOnlineBarHeight();
        rechnungen.assertOnPaperNotificationLink();
        rechnungen.clickBillingSettingLink();
        einstellungen.assertThatUserNavigatedToPage();
    }
}
