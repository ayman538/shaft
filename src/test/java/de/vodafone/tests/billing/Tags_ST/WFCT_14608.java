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
public class WFCT_14608 extends ST_TagsSetup {
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Einstellungen einstellungen;
    EditNotificationSettings editNotificationSettings;
    Tags tags;
    String siteStructure;
    String errorArea;
    String errorCode;
    String errorMessage;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        einstellungen = new Einstellungen(driver);
        editNotificationSettings = new EditNotificationSettings(driver);
        tags = new Tags(driver);
        siteStructure = testData.getTestData(method.getName()+".siteStructure");
        errorArea = testData.getTestData(method.getName()+".errorArea");
        errorCode = testData.getTestData(method.getName()+".errorCode");
        errorMessage = testData.getTestData(method.getName()+".errorMessage");
    }

    @Test(description = "Tag01 - User checks Page view tags and Page URL in the change settings page")
    @TmsLink("WFCT-14905")
    public void Tag01_UserChecksPageViewTagsAndPageUrlInTheChangeSettingsPage(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.clickEditNotificationButton();
        tags.assertOnSiteStructure(siteStructure);
    }


    @Test(description = "Tag02 - User checks Page view tags and Page URL in the confirmation page")
    @TmsLink("WFCT-14906")
    public void Tag02_UserChecksPageViewTagsAndPageUrlInTheConfirmationPage(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.clickEditNotificationButton();
        editNotificationSettings.clickOnSmsNotificationToggleBtn()
                .clickOnConfirmBtn();
        tags.assertOnSiteStructure(siteStructure);
    }

    @Test(description = "Tag03 - User checks Error tag in the change settings page")
    @TmsLink("WFCT-14907")
    public void Tag03_UserChecksErrorTagInTheChangeSettingsPage(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.clickEditNotificationButton();
        tags.assertOnErrorArea(errorArea);
        tags.assertOnErrorCode(errorCode);
        tags.assertOnErrorMessage(errorMessage);
    }

    @Test(description = "Tag04 - User checks Error tag in the confirmation page")
    @TmsLink("WFCT-14908")
    public void Tag04_UserChecksErrorTagInTheConfirmationPage(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.clickEditNotificationButton();
        editNotificationSettings.clickOnSmsNotificationToggleBtn()
                .clickOnConfirmBtn();
        tags.assertOnErrorArea(errorArea);
        tags.assertOnErrorCode(errorCode);
        tags.assertOnErrorMessage(errorMessage);
    }

}
