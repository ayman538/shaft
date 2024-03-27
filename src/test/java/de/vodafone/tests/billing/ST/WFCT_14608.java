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
@Story("WFCT-14608")
public class WFCT_14608 extends ST_BillingSetup {
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Einstellungen einstellungen;
    EditNotificationSettings editNotificationSettings;
    String number;
    String smsStatus;
    String emailStatus;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        einstellungen = new Einstellungen(driver);
        editNotificationSettings = new EditNotificationSettings(driver);
        number = testData.getTestData(method.getName()+".number");
        smsStatus = testData.getTestData(method.getName()+".smsStatus");
        emailStatus = testData.getTestData(method.getName()+".emailStatus");
    }

    @Test(description = "GC02 - Bart user 'online bill' deactivates SMS notification")
    @TmsLink("WFCT-14893")
    public void GC02_BartUserOnlineBillDeactivatesSmsNotification(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.clickEditNotificationButton();
        editNotificationSettings.assertOnPageTitle()
                .assertOnAccordionTitle()
                .assertOnEmailSectionTitle()
                .assertOnEmailSectionDescription()
                .assertOnEmailSectionNotification()
                .assertThatEmailNotificationToggleBtnNotActive()
                .assertOnSmsSectionTitle()
                .assertOnSmsSectionDescription()
                .clickOnSmsNotificationToggleBtn()
                .clickOnConfirmBtn()
                .assertOnSuccessConfirmationNotification()
                .assertOnEmailStatusLabel()
                .assertOnEmailStatusValue(emailStatus)
                .assertOnSmsStatusLabel()
                .assertOnSmsStatusValue(smsStatus);
    }

    @Test(description = "GC03 - Kay user 'online bill' activates SMS notification")
    @TmsLink("WFCT-14894")
    public void GC03_KayUserOnlineBillActivatesSmsNotification(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.clickEditNotificationButton();
        editNotificationSettings.clickOnSmsNotificationToggleBtn()
                .selectNumberFromDropDown(number)
                .clickOnConfirmBtn()
                .assertOnNumberStatusLabel()
                .assertOnNumberValue(number);
    }

    @Test(description = "GC04 - Marie user 'online bill' with only one number checks change notification settings page")
    @TmsLink("WFCT-14895")
    public void GC04_MarieUserOnlineBillWithOnlyOneNumberChecksChangeNotificationSettingsPage(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.clickEditNotificationButton();
        editNotificationSettings.assertThatDropDownIsDisabled();
    }

    @Test(description = "GC05 - Kay user 'online and paper bill' activates email notification")
    @TmsLink("WFCT-14896")
    public void GC05_KayUserOnlineAndPaperBillActivatesEmailNotification(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.clickEditNotificationButton();
        editNotificationSettings.clickOnEmailNotificationToggleBtn()
                .assertThatEmailSectionNotificationNotDisplayed()
                .clickOnConfirmBtn()
                .assertOnEmailStatusValue(emailStatus);
    }

    @Test(description = "GC06 - Bart user 'online and paper bill' deactivates email notification")
    @TmsLink("WFCT-14897")
    public void GC06_BartUserOnlineAndPaperBillDeActivatesEmailNotification(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.clickEditNotificationButton();
        editNotificationSettings.clickOnEmailNotificationToggleBtn()
                .clickOnConfirmBtn()
                .assertOnEmailStatusValue(emailStatus);
    }

    @Test(description = "GC07 - Kay user with 20 numbers check the numbers dropdown list")
    @TmsLink("WFCT-14898")
    public void GC07_KayUserWith20NumbersCheckTheNumbersDropdownList(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.clickEditNotificationButton();
        editNotificationSettings.
                assertThat20NumbersNotificationNotDisplayed();
    }



    @Test(description = "BC01 - Kay user \" SMS notification active \" with \"GET subscriber list \" service failure")
    @TmsLink("WFCT-14902")
    public void BC01_KayUserSmsNotificationActiveWithGetSubscriberListServiceFailure(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.clickEditNotificationButton();
        editNotificationSettings.assertThatSmsNotificationToggleBtnIsActive()
                .assertOnSmsErrorNotification()
                .assertThatDropDownIsDisabled();
    }

    @Test(description = "BC02 - Bart user \" SMS notification inactive \" with \"GET subscriber list \" service failure")
    @TmsLink("WFCT-14903")
    public void BC02_BartUserSmsNotificationInActiveWithGetSubscriberListServiceFailure(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.clickEditNotificationButton();
        editNotificationSettings
                .assertOnSmsErrorNotification()
                .assertThatSmsNotificationToggleBtnNotActive()
                .assertThatDropDownNotDisplayed();

    }

    @Test(description = "BC03 - Marie user with \"UpdateMediaCategory PUT\" service failure")
    @TmsLink("WFCT-14904")
    public void BC03_MarieUserWithUpdateMediaCategoryPutServiceFailure(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.clickEditNotificationButton();
        editNotificationSettings
                .clickOnSmsNotificationToggleBtn()
                .clickOnConfirmBtn()
                .assertOnErrorConfirmationNotification();
    }



}
