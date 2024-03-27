package de.vodafone.tests.billing.SIT;


import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.EditNotificationSettings;
import de.vodafone.pages.billing.Einstellungen;
import de.vodafone.pages.billing.MeineRechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("SIT")
@Story("WFCT-14608")
public class WFCT_14608 extends SIT_BillingSetup {
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Einstellungen einstellungen;
    EditNotificationSettings editNotificationSettings;
    String contractOrder;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        einstellungen = new Einstellungen(driver);
        editNotificationSettings = new EditNotificationSettings(driver);
        contractOrder = testData.getTestData(method.getName()+".contractOrder");
    }

    @Test(description = "GC04 - Marie user 'online bill' with only one number checks change notification settings page")
    @TmsLink("WFCT-14895")
    public void GC04_MarieUserOnlineBillWithOnlyOneNumberChecksChangeNotificationSettingsPage(){
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile(contractOrder);
        meineRechnungen.clickEinstellungenTab();
        einstellungen.clickEditNotificationButton();
        editNotificationSettings.assertThatDropDownIsDisabled();
    }

}
