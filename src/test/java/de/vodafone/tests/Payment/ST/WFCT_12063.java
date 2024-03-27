package de.vodafone.tests.Payment.ST;

import de.vodafone.pages.Payment.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Payment")
@Feature("ST")
@Story("WFCT-12063")
public class WFCT_12063 extends ST_PaymentSetup {
    String tileOrder;
    String contractIndex;
    String numberIndex;
    String autoTopupAmount;
    String autoTopupDate;
    Dashboard dashboard;
    TopUp topup;
    TopupGPP topupGPP;
    QuickCheckPage quickcheck;
    ContractChooserPage contractChooser;

    @TmsLink("WFCT-12099")
    @Test(description = "ST-GC01-User with Active auto top-up - check the displayed notification in GPP page - check the disable of auto top up options")
    public void ST_GC01_UserWithActiveAutoTopUp_checkDisplayedNotificationInGPPPage_CheckDisableOfAutoTopUpOptions(){
        dashboard.clickTopUpTile(tileOrder);
        contractChooser.clickContractFromContractChooser(contractIndex);
        topup.clickDirektAufladen();
        topupGPP.checkTopUpNotificationExist();
        topupGPP.checkTopUpActiveNotificationBodyCL();
        topupGPP.checkTopUpActiveNotificationHyperlinkCL();
        topupGPP.checkSwitchOffToggleNotExist();
        topupGPP.checkSavedPaymentMethodExist();
        topupGPP.checkSavedPaymentMethodSectionHeadlineCL();
        topupGPP.checkAutoTopupSavedPaymentMethod28DaysCL(autoTopupAmount, autoTopupDate);
        topupGPP.clickTopUpNotificationHyperlink();
        topupGPP.acceptAlert();
        quickcheck.checkAutomatischesAufladenSection();
        quickcheck.checkAutomatischesAufladenCLActive();
    }

    @TmsLink("WFCT-12105")
    @Test(description = "ST-GC02-User with Paused auto top-up - check the displayed notification in GPP page - check the disable of auto top up options")
    public void ST_GC02_UserWithPausedAutoTopUp_checkDisplayedNotificationInGPPPage_CheckDisableOfAutoTopUpOptions(){
        dashboard.clickTopUpTile(tileOrder);
        topup.clickDirektAufladen();
        topupGPP.checkTopUpNotificationExist();
        topupGPP.checkTopUpPausedNotificationBodyCL();
        topupGPP.checkTopUpPausedNotificationHyperlinkCL();
        topupGPP.assertThatElementBackgroundIsBlue(topupGPP.getAutoTopUpNotificationColorLocator());
        topupGPP.checkSwitchOffToggleNotExist();
        topupGPP.checkSavedPaymentMethodExist();
        topupGPP.checkSavedPaymentMethodSectionHeadlineCL();
        topupGPP.assertOnSavedPaymentMethodCLForPausedAutoTopup();
        topupGPP.clickTopUpNotificationHyperlink();
        topupGPP.acceptAlert();
        quickcheck.checkAutomatischesAufladenSection();
        quickcheck.checkAutomatischesAufladenCLPause();
    }


    @TmsLink("WFCT-12106")
    @Test(description = "ST-GC03-User with Blocked auto top-up - check the displayed notification in GPP page - check the disable of auto top up options")
    public void ST_GC03_UserWithBlockedAutoTopUp_checkDisplayedNotificationInGPPPage_CheckDisableOfAutoTopUpOptions(){
        dashboard.clickTopUpTile(tileOrder);
        topup.clickDirektAufladen();
        topupGPP.checkTopUpNotificationExist();
        topupGPP.checkTopUpBlockedNotificationBodyCL();
        topupGPP.checkTopUpBlockedNotificationHyperlinkCL();
        topupGPP.assertThatElementBackgroundIsRed(topupGPP.getAutoTopUpNotificationColorLocator());
        topupGPP.checkSwitchOffToggleNotExist();
        topupGPP.checkSavedPaymentMethodExist();
        topupGPP.checkSavedPaymentMethodSectionHeadlineCL();
        topupGPP.assertOnSavedPaymentMethodCLForBlockedAutoTopup();
        topupGPP.clickTopUpNotificationHyperlink();
        topupGPP.acceptAlert();
        quickcheck.checkAutomatischesAufladenSection();
        quickcheck.checkAutomatischesAufladenCLBlock();
    }

    @TmsLink("WFCT-12107")
    @Test(description = "ST-GC04-User with in progress auto top-up - check the displayed notification in GPP page - check the disable of auto top up options")
    public void ST_GC04_UserWithInProgressAutoTopUp_checkDisplayedNotificationInGPPPage_CheckDisableOfAutoTopUpOptions(){
        dashboard.clickTopUpTile(tileOrder);
        topup.clickDirektAufladen();
        topupGPP.checkTopUpNotificationExist();
        topupGPP.checkTopUpInProgressNotificationBodyCL();
        topupGPP.checkTopUpInProgressNotificationHyperlinkCL();
        topupGPP.assertThatElementBackgroundIsBlue(topupGPP.getAutoTopUpNotificationColorLocator());
        topupGPP.checkSwitchOffToggleNotExist();
        topupGPP.checkSavedPaymentMethodExist();
        topupGPP.checkSavedPaymentMethodSectionHeadlineCL();
        topupGPP.assertThatNoSpecialTextIsDisplayedForSavedPaymentMethod();
        topupGPP.clickTopUpNotificationHyperlink();
        topupGPP.acceptAlert();
        quickcheck.checkAutomatischesAufladenSection();
        quickcheck.assertOnIPNotificationInAutoTopupAccordion();
        quickcheck.checkIPDeineNotificationSublineCl();
    }

    @TmsLink("WFCT-12108")
    @Test(description = "ST - GC05 - User with Active auto top up changes the selection of the number with no Auto TopUp")
    public void ST_GC05_UserWithActiveAutoTopUpChangesTheSelectionOfTheNumberWithNoAutoTopUp(){
        dashboard.clickTopUpTile(tileOrder);
        contractChooser.clickContractFromContractChooser(contractIndex);
        topup.clickDirektAufladen();
        topupGPP.clickCallYaRufnummerDropDownList();
        topupGPP.clickChosenCallYaRufnummer(numberIndex);
        topupGPP.checkSwitchOffToggleExist();


    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        topup = new TopUp(driver);
        topupGPP = new TopupGPP(driver);
        quickcheck = new QuickCheckPage(driver);
        contractChooser = new ContractChooserPage(driver);
        tileOrder = testData.getTestData(method.getName() + ".tileOrder");
        contractIndex = testData.getTestData(method.getName() + ".contractIndex");
        numberIndex = testData.getTestData(method.getName() + ".numberIndex");
        autoTopupAmount = testData.getTestData(method.getName() + ".autotopupAmount");
        autoTopupDate = testData.getTestData(method.getName() + ".autotopupDate");
    }
}
