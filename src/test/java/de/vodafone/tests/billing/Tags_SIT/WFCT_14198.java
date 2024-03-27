package de.vodafone.tests.billing.Tags_SIT;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Kostenubersicht;
import de.vodafone.pages.billing.MeineRechnungen;
import de.vodafone.pages.billing.Verbindungsubersicht;
import de.vodafone.pages.commons.Tags;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static de.vodafone.pages.billing.Kostenubersicht.getFirsrtCostOverviewDownloadLocator;

@Epic("Billing")
@Feature("SIT")
@Story("WFCT-14198")

public class WFCT_14198 extends SIT_TagsSetup {
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Tags tags;
    String type, action, code, area, message,csvErrorDetails,pdfErrorDetails,contractOrder;


    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        tags = new Tags(driver);
        type = testData.getTestData((method.getName()+".type"));
        action = testData.getTestData((method.getName()+".action"));
        code = testData.getTestData((method.getName()+".code"));
        area = testData.getTestData((method.getName()+".area"));
        message = testData.getTestData((method.getName()+".message"));
        csvErrorDetails = testData.getTestData((method.getName()+".csvErrorDetails"));
        pdfErrorDetails = testData.getTestData((method.getName()+".pdfErrorDetails"));
        contractOrder = testData.getTestData(method.getName()+".contractOrder");
    }


    @Test(description = "Tag06 - Kay with no usage checks connection overview notification tracking" )
    @TmsLink("WFCT-14575")
    public void Tag06_KayWithNoUsageChecksConnectionOverviewNotificationTracking() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile(contractOrder);
        meineRechnungen.clickVerbindungsübersichtTab();
        tags.assertOnNotificationAction(action);
        tags.assertOnNotificationType(type);
        tags.assertOnNotificationMessage(message);
        tags.assertOnNotificationArea(area);
    }

    @Test(description = "Tag05 - Brand new kay customer checks connection overview notification tracking" )
    @TmsLink("WFCT-14574")
    public void Tag05_BrandNewKayCustomerChecksConnectionOverviewNotificationTracking() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile(contractOrder);
        meineRechnungen.clickVerbindungsübersichtTab();
        tags.assertOnNotificationAction(action);
        tags.assertOnNotificationType(type);
        tags.assertOnNotificationMessage(message);
        tags.assertOnNotificationArea(area);
    }

}
