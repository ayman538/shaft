package de.vodafone.tests.billing.Tags_ST;


import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.EditNotificationSettings;
import de.vodafone.pages.billing.Einstellungen;
import de.vodafone.pages.billing.MeineRechnungen;
import de.vodafone.pages.commons.Tags;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("ST")
@Story("WFCT-14608")
public class WFCT_14659 extends ST_TagsSetup {
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Einstellungen einstellungen;
    EditNotificationSettings editNotificationSettings;
    Tags tags;

    String oFormStepOne,oFormStepTwo;


    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        einstellungen = new Einstellungen(driver);
        editNotificationSettings = new EditNotificationSettings(driver);
        tags = new Tags(driver);
        oFormStepOne = testData.getTestData(method.getName()+".oFormStepOne");
        oFormStepTwo = testData.getTestData(method.getName()+".oFormStepTwo");
    }

    @Test(description = "Tag01 - Kay soho user with active email notification enables pdf notification then checks tagging")
    @TmsLink("WFCT-15261")
    public void Tag01_KaySohoUserWithActiveEmailNotificationEnablesPdfNotificationThenChecksTagging(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.clickEditNotificationButton();
        tags.assertOnoFormObject(oFormStepOne);
        editNotificationSettings.checkTheCheckbox()
                .clickOnConfirmBtn();
        tags.assertOnoFormObject(oFormStepTwo);
    }


    @Test(description = "Tag02 - Marie soho user with active email notification disables pdf notification then checks tagging")
    @TmsLink("WFCT-15262")
    public void Tag02_MarieSohoUserWithActiveEmailNotificationDisablesPdfNotificationThenChecksTagging(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.clickEditNotificationButton();
        tags.assertOnoFormObject(oFormStepOne);
        editNotificationSettings.unCheckTheCheckbox()
                .clickOnConfirmBtn();
        tags.assertOnoFormObject(oFormStepTwo);
    }



}
