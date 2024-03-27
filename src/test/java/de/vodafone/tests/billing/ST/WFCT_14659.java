package de.vodafone.tests.billing.ST;


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
@Feature("ST")
@Story("WFCT-14659")
public class WFCT_14659 extends ST_BillingSetup {
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Einstellungen einstellungen;
    EditNotificationSettings editNotificationSettings;
    String activePdfCL, inactivePdfCl, greenEmailColor,inactivePdfStatus,activePdfStatus;


    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        einstellungen = new Einstellungen(driver);
        editNotificationSettings = new EditNotificationSettings(driver);
        activePdfCL = testData.getTestData(method.getName() + ".activePdfCL");
        inactivePdfCl = testData.getTestData(method.getName() + ".inactivePdfCl");
        greenEmailColor = testData.getTestData(method.getName() + ".greenEmailColor");
        inactivePdfStatus = testData.getTestData(method.getName() + ".inactivePdfStatus");
        activePdfStatus = testData.getTestData(method.getName() + ".activePdfStatus");
    }

    @Test(description = "GC01 - Marie soho user with active email notification disables pdf notification")
    @TmsLink("WFCT-15259")
    public void GC01_MarieSohoUserWithActiveEmailNotificationDisablesPdfNotification(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnEmailColor(greenEmailColor);
        einstellungen.assertOnPdfStatusDescriptionCL(activePdfCL);
        einstellungen.clickEditNotificationButton();
        editNotificationSettings.unCheckTheCheckbox()
                .clickOnConfirmBtn()
                .assertOnSuccessConfirmationNotification();
        editNotificationSettings.assertOnPdfFieldStatusValueAndCl(inactivePdfStatus);
    }

    @Test(description = "GC02 - Kay soho user with active email notification enables pdf notification")
    @TmsLink("WFCT-15260")
    public void GC02_KaySohoUserWithActiveEmailNotificationEnablesPdfNotification(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnEmailColor(greenEmailColor);
        einstellungen.assertOnPdfStatusDescriptionCL(inactivePdfCl);
        einstellungen.clickEditNotificationButton();
        editNotificationSettings.checkTheCheckbox()
                .clickOnConfirmBtn()
                .assertOnSuccessConfirmationNotification();
        editNotificationSettings.assertOnPdfFieldStatusValueAndCl(activePdfStatus);
    }

    @Test(description = "GC03 - Bart soho user with inactive email notification checks pdf notification")
    @TmsLink("WFCT-15263")
    public void GC03_BartSohoUserWithInactiveEmailNotificationChecksPdfNotification(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnEmailColor(greenEmailColor);
        einstellungen.assertThatPdfStatusDoesNotExist();
        einstellungen.clickEditNotificationButton();
        editNotificationSettings.assertThatPdfClAndChecboxDoesNotExist()
                .clickOnEmailNotificationToggleBtn()
                .checkTheCheckbox()
                .clickOnConfirmBtn()
                .assertOnPdfFieldStatusValueAndCl(activePdfStatus)
                .assertOnSuccessConfirmationNotification();
    }

    @Test(description = "GC04 - GKO user checks enabling pdf notification")
    @TmsLink("WFCT-15264")
    public void GC04_GkoUserChecksEnablingPdfNotification(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertThatGkoRedirectionBtnExist();

    }

    @Test(description = "GC05 - Consumer marie user checks enabling pdf notification")
    @TmsLink("WFCT-15283")
    public void GC05_ConsumerMarieUserChecksEnablingPdfNotification(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.clickEditNotificationButton();
        editNotificationSettings.assertThatPdfClAndChecboxDoesNotExist();
    }

}
