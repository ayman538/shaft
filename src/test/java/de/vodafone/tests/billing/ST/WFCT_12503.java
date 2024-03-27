package de.vodafone.tests.billing.ST;


import de.vodafone.pages.Account.KontaktDatenPage;
import de.vodafone.pages.billing.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

@Epic("Billing")
@Feature("ST")
@Story("WFCT-12503")


public class WFCT_12503 extends ST_BillingSetup {
    Dashboard dashboard;
    Rechnungen rechnungen;
    Einstellungen einstellungen;
    MeineDaten meineDaten;
    MeineRechnungen meineRechnungen;
    KontaktDatenPage kontaktDatenPage;
    String billType , emailStatus , smsStatus , emailColor , currentBillType , newBillType , mobileNumber,buttonColor;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        einstellungen = new Einstellungen(driver);
        meineDaten = new MeineDaten(driver);
        meineRechnungen = new MeineRechnungen(driver);
        kontaktDatenPage = new KontaktDatenPage(driver);
        billType = testData.getTestData(method.getName()+ ".billType");
        emailStatus = testData.getTestData(method.getName()+ ".emailStatus");
        smsStatus = testData.getTestData(method.getName()+ ".smsStatus");
        emailColor = testData.getTestData(method.getName()+ ".emailColor");
        currentBillType = testData.getTestData(method.getName()+ ".currentBillType");
        newBillType = testData.getTestData(method.getName()+ ".newBillType");
        mobileNumber = testData.getTestData(method.getName()+ ".mobileNumber");
        buttonColor= testData.getTestData(method.getName()+ ".buttonColor");
    }

    @Test(description = "GC01 - Marie user that receives the bill online and the e-mail and SMS notifications are active checks the Einstellungen page.")
    @TmsLink("WFCT-14757")
    public void GC01_MarieUserWithOnlineBillChecksEinstellungenPage() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnBillType(billType);
        einstellungen.clickOnInfoIcon();
        einstellungen.assertOnInfoIconMessage();
        einstellungen.assertOnBillNotificationIndicationTitle();
        einstellungen.assertOnEditEmailButtonInOnlineCase(buttonColor);
        einstellungen.assertOnEmailCheckMarkIcon();
        einstellungen.assertOnEmailColor(emailColor);
        einstellungen.assertOnEmailStatus(emailStatus);
        einstellungen.assertThatMobileNumberExists(mobileNumber);
        einstellungen.assertOnSMSLabel();
        einstellungen.assertOnSmsCheckMarkIcon();
        einstellungen.assertOnSMSStatus(smsStatus);
        einstellungen.clickOnEditEmailBtnInOnlineCase();
        kontaktDatenPage.assertThatUserIsNavigatedToKontaktDaten();
    }
    @Test(description = "GC02 - Bart user that receives the bill online and the e-mail notification is active but the SMS notification is inactive checks the einstellungen tab.")
    @TmsLink("WFCT-14758")
    public void GC02_BartUserWithOnlineBillAndInActiveSMSChecksEinstellungenPage(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertThatMobileNumberDoesNotExist();
        einstellungen.assertOnSmsXMarkIcon();
        einstellungen.assertOnSMSStatus(smsStatus);
    }
    @Test(description = "GC03 - Kay user that receives the bill online has a not verified e-mail and an inactive SMS notification checks the einstellungen tab")
    @TmsLink("WFCT-14759")
    public void GC03_KayUserWithOnlineBillAndNotVerifiedEmailChecksEinstellungenPage(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnEmailColor(emailColor);
        einstellungen.assertOnEmailStatus(emailStatus);
        einstellungen.assertOnConfirmEmailNotification();
        einstellungen.ClickOnsendConfirmationEmailBtn();
        einstellungen.assertThatUserIsRedirectedToSendValidationEmailAgainPage();
        einstellungen.navigateToEinstellungenPage();
        einstellungen.assertOnEditEmailButton(buttonColor);
        einstellungen.clickOnEditEmailBtn();
        kontaktDatenPage.assertThatUserIsNavigatedToKontaktDaten();
    }

    @Test(description = "GC04 - Marie user that receives the bill online has no email in the contact data and an inactive SMS notification.")
    @TmsLink("WFCT-14777")
    public void GC04_KayUserWithOnlineBillAndNoEmailChecksEinstellungenPage(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnNoEmailGivenCl();
        einstellungen.assertOnNoContactDetailsNotification();
        einstellungen.assertOnCreateEmailButton();
        einstellungen.clickOnCreateEmailBtn();
        kontaktDatenPage.assertThatUserIsNavigatedToKontaktDaten();
    }
    @Test(description = "GC05 - Bart user that receives the bill online has an undeliverable e-mail and it bounces back and an active SMS notification.")
    @TmsLink("WFCT-14760")
    public void GC05_KayUserWithOnlineBillAndUndeliverableEmailChecksEinstellungenPage(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnEmailColor(emailColor);
        einstellungen.assertOnEmailStatus(emailStatus);
        einstellungen.assertOnUndeliverableEmailNotification();
    }

    @Test(description = "GC06 - Kay user with bill type online and paper has an inactive e-mail notification and an inactive SMS notification checks einstellungen tab.")
    @TmsLink("WFCT-14761")
    public void GC06_KayUserWithOnlineAndPaperBillChecksEinstellungenTab(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnEditNotificationSettingsBtnCl();
        einstellungen.assertOnNotificationServiceNotActiveMsg();
        einstellungen.clickOnEditEmailBtn();
        kontaktDatenPage.assertThatUserIsNavigatedToKontaktDaten();
    }

    @Test(description = "GC07 - Marie user that receives the bill online encounters a service failure")
    @TmsLink("WFCT-14762")
    public void GC07_MarieUserEncountersServiceFailure(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnGeneralErrorMessage();
    }
    @Test(description = "GC08 - Bart user with a GKO account checks the Einstellungen page")
    @TmsLink("WFCT-14763")
    public void GC08_BartUserWithGKOaccountChecksEinstellungenPage(){
        dashboard.clickMeineDatenTile();
        meineDaten.clickOnKontaktDatenAccordion();
        meineDaten.clickOnrechnungseinstellungenLink();
        einstellungen.assertOnGKoNotification();

    }
    @Test(description = "GC09 - Kay user bill type is set to online and paper bill checks the Einstellungen page and changes the bill type to online")
    @TmsLink("WFCT-14764")
    public void GC09_KayUserWithOnlineAndPaperBillChangesToOnlineBill(){
        dashboard.clickMeineDatenTile();
        meineDaten.clickOnKontaktDatenAccordion();
        meineDaten.clickOnrechnungseinstellungenLink();
        einstellungen.clickOnRechnungsadresseEinsehen();
        meineDaten.assertThatAdressenAccIsExpanded();
        einstellungen.navigateToEinstellungenPage();
        einstellungen.clickOnOnlineBillRadioBtn();
        einstellungen.clickOnSecondRadioBtn();
        einstellungen.assertThatSaveChangeBtnIsDimmed();
        einstellungen.clickOnOnlineBillRadioBtn();
        einstellungen.assertOnChangingToOnlineBillNotification();
        einstellungen.clickOnSaveChangesBtn();
        einstellungen.assertOnThankYouMessage();
        einstellungen.assertThatRadioButtonsDoesNotExist();
        einstellungen.assertOnBillType(newBillType);
    }
    @Test(description = "GC10 - Marie user bill type is set to paper checks the Einstellungen page and changes the bill type to online")
    @TmsLink("WFCT-14765")
    public void GC10_MarieUserWithPaperBillChangesToOnlineBill(){
        dashboard.clickMeineDatenTile();
        meineDaten.clickOnKontaktDatenAccordion();
        meineDaten.clickOnrechnungseinstellungenLink();
        einstellungen.assertOnRadioButtonsCLs(currentBillType);
        einstellungen.assertThatTheCurrentBillTypeIsSelected();
        einstellungen.assertOnAddressSection();
        einstellungen.assertOnBillingAddressNote();
        einstellungen.assertOnNoBillingNotificationMsgCl();
        einstellungen.assertThatSaveChangeBtnIsDimmed();
        einstellungen.clickOnOnlineBillRadioBtn();
        einstellungen.assertOnChangeFromPaperToOnlineNotification();
        einstellungen.clickOnSaveChangesBtn();
        einstellungen.assertOnThankYouMessage();
        einstellungen.assertThatRadioButtonsDoesNotExist();
        einstellungen.assertOnBillType(newBillType);
    }
    @Test(description = "GC11 - Bart user bill type is set to paper encounters a service error when changing the bill type to online")
    @TmsLink("WFCT-14766")
    public void GC11_BartUserEncountersServiceFailure(){
        dashboard.clickMeineDatenTile();
        meineDaten.clickOnKontaktDatenAccordion();
        meineDaten.clickOnrechnungseinstellungenLink();
        einstellungen.clickOnOnlineBillRadioBtn();
        einstellungen.clickOnSaveChangesBtn();
        einstellungen.assertOnTransactionErrorMessage();
    }

}
