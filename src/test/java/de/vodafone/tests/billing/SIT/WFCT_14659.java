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
@Story("WFCT-14659")
public class WFCT_14659 extends SIT_BillingSetup {
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Einstellungen einstellungen;
    EditNotificationSettings editNotificationSettings;
    String contractOrder;
    String  inactivePdfCl, greenEmailColor,activePdfStatus;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        einstellungen = new Einstellungen(driver);
        editNotificationSettings = new EditNotificationSettings(driver);
        contractOrder = testData.getTestData(method.getName()+".contractOrder");
        inactivePdfCl = testData.getTestData(method.getName()+".inactivePdfCl");
        greenEmailColor = testData.getTestData(method.getName()+".greenEmailColor");
        activePdfStatus = testData.getTestData(method.getName() + ".activePdfStatus");
    }

    @Test(description = "GC02 - Kay soho user with active email notification enables pdf notification")
    @TmsLink("WFCT-15260")
    public void GC02_KaySohoUserWithActiveEmailNotificationEnablesPdfNotification(){
        dashboard.clickMeineRechnungenTile(contractOrder);
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnEmailColor(greenEmailColor);
        einstellungen.assertOnPdfStatusDescriptionCL(inactivePdfCl);
        einstellungen.clickEditNotificationButton();
        editNotificationSettings.checkTheCheckbox()
                .clickOnConfirmBtn()
                .assertOnSuccessConfirmationNotification();
        editNotificationSettings.assertOnPdfFieldStatusValueAndCl(activePdfStatus);
    }
}
