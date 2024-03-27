package de.vodafone.tests.Payment.ST;

import de.vodafone.pages.Payment.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Payment")
@Feature("ST")
public class WFCT_11860 extends ST_PaymentSetup {
    String burgerMenuOrder;
    String quickCheckListOrder;
    String tileOrder;
    String tileActiveStatus;
    String SOActiveStatus;
    String tileBlockStatus;
    String SOBlockStatus;
    String tilePauseStatus;
    String SOPauseStatus;
    String creditCardNum ;
    String creditCardMonth ;
    String creditCardYear ;
    String creditCardCvc;
    String creditCardHolder;
    Dashboard dashboard;
    QuickCheckPage quickCheckPage;
    CreditCardPage creditCardPage;
    TopupGPP topupGPP;
    DeleteAutoTopUpPage deleteAutoTopUpPage;
    @TmsLink("WFCT_11883")
    @Test(description = "ST-GC01-User without auto top-up to checks the accordion & SO and creates auto top-up")
    public void ST_GC01_User_Without_AutoTopUpToChecksTheAccordionAndSOAndCreates_AutoTopUp(){
        dashboard.clickBurgerMenuIcon(burgerMenuOrder);
        dashboard.clickQuickCheckList(quickCheckListOrder);
        quickCheckPage.assertOnAutomatischesAufladen();
        quickCheckPage.assertOnDisabledSOMessageCL();
        quickCheckPage.clickAutomAufladenSmartObject();
        quickCheckPage.checkDeineAutomAufladungHeadlineCL();
        quickCheckPage.assertOnDeineAutomAufladungSublineCL();
        quickCheckPage.clickSetupAutomationRechargeButton();
        topupGPP.clickRechargeRadioButton();
        creditCardPage.enterCreditCardCredentials( creditCardNum
                , creditCardMonth , creditCardYear , creditCardCvc, creditCardHolder);
        topupGPP.assertThatTopUpConfirmationCLHeader();
        topupGPP.assertOnTopUpHistoryCL();
    }

    @TmsLink("WFCT-11884")
    @Test(description = "ST-GC02-User checks the SO(in dashbaord - in quickcheck page)& Check Active statues in automatic top-up accordion & Check the delete flow")
    public void ST_GC02_UserChecksSO_InDashbaord_And_InQuickCheckPage_Check_Active_Check_DeleteFlow(){
        dashboard.checkStatueOfMeineAufladungCL(tileActiveStatus);
        dashboard.clickBurgerMenuIcon(burgerMenuOrder);
        dashboard.clickQuickCheckList(tileOrder);
        quickCheckPage.assertOnAutomatischesAufladen();
        quickCheckPage.checkSOAutomatischesAufladenCL(SOActiveStatus);
        quickCheckPage.clickAutomAufladenSmartObject();
        quickCheckPage.checkAutomatischesAufladenSection();
        quickCheckPage.checkAutomatischesAufladenCLActive();
        quickCheckPage.checkAutoTopUpAmountActiveCL();
        quickCheckPage.clickDeleteButton();
        deleteAutoTopUpPage.checkWarningNotificationHeadlineCL();
        deleteAutoTopUpPage.checkWarningNotificationSublineCL();
        deleteAutoTopUpPage.clickPermanentlyDeleteButton();
        deleteAutoTopUpPage.assertOnConfirmationNotificationSublineCl();
    }

    @TmsLink("WFCT-11885")
    @Test(description = "ST-GC03-User checks the SO(in dashbaord - in quickcheck page)& Check In Progress statues in automatic top-up accordion & Check the delete flow")
    public void ST_GC03_UserChecksSO_InDashbaord_And_InQuickCheckPage_Check_IP_Check_DeleteFlow(){
        dashboard.checkMeineAufladungtileExist();
        dashboard.clickMeineAufladungtile();
        quickCheckPage.waitForPageToBeLoaded();
        quickCheckPage.assertOnAutomatischesAufladen();
        quickCheckPage.checkIPSOMessageCL();
        quickCheckPage.checkAutomatischesAufladenSection();
        quickCheckPage.assertOnIPNotificationInAutoTopupAccordion();
        quickCheckPage.checkIPDeineNotificationSublineCl();
    }

    @TmsLink("WFCT-11886")
    @Test(description = "ST-GC04-User checks the SO(in dashbaord - in quickcheck page)& Check Blocked statues in automatic top-up accordion & Check the delete flow")
    public void ST_GC04_UserChecksSO_InDashbaord_And_InQuickCheckPage_Check_Blocked_Check_DeleteFlow(){
        dashboard.checkStatueOfMeineAufladungCL(tileBlockStatus);
        dashboard.clickMeineAufladungtile();
        quickCheckPage.assertOnAutomatischesAufladen();
        quickCheckPage.checkSOAutomatischesAufladenCL(SOBlockStatus);
        quickCheckPage.checkAutomatischesAufladenSection();
        quickCheckPage.assertOnIPNotificationInAutoTopupAccordion();
        quickCheckPage.checkLockedNotificationMessageCL();
        quickCheckPage.checkAutomatischesAufladenCLBlock();
        quickCheckPage.checkDeleteButtonDisable();
    }

    @TmsLink("WFCT-11887")
    @Test(description = "ST-GC05-User checks the SO(in dashbaord - in quickcheck page)& Check Paused statues in automatic top-up accordion & Check the delete flow")
    public void ST_GC05_UserChecksSO_InDashbaord_And_InQuickCheckPage_Check_Paused_Check_DeleteFlow(){
        dashboard.checkStatueOfMeineAufladungCL(tilePauseStatus);
        dashboard.clickMeineAufladungtile();
        quickCheckPage.assertOnAutomatischesAufladen();
        quickCheckPage.checkSOAutomatischesAufladenCL(SOPauseStatus);
        quickCheckPage.checkAutomatischesAufladenSection();
        quickCheckPage.checkAutomatischesAufladenCLPause();
        quickCheckPage.checkAutoTopUpAmountPauseCL();
        quickCheckPage.clickDeleteButton();
        deleteAutoTopUpPage.checkWarningNotificationHeadlineCL();
        deleteAutoTopUpPage.checkWarningNotificationSublineCL();
        deleteAutoTopUpPage.clickPermanentlyDeleteButton();
        deleteAutoTopUpPage.assertThatPageRedirectedSuccessfully();
        deleteAutoTopUpPage.assertOnConfirmationNotificationSublineCl();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        quickCheckPage = new QuickCheckPage(driver);
        topupGPP = new TopupGPP(driver);
        creditCardPage = new CreditCardPage(driver);
        deleteAutoTopUpPage = new DeleteAutoTopUpPage(driver);

        burgerMenuOrder = testData.getTestData(method.getName() + ".burgerMenuOrder");
        quickCheckListOrder = testData.getTestData(method.getName() + ".quickCheckListOrder");
        tileOrder = testData.getTestData(method.getName() + ".tileOrder");
        tileActiveStatus = testData.getTestData(method.getName() + ".tileActiveStatus");
        SOActiveStatus = testData.getTestData(method.getName() + ".SOActiveStatus");
        tileBlockStatus = testData.getTestData(method.getName() + ".tileBlockStatus");
        SOBlockStatus = testData.getTestData(method.getName() + ".SOBlockStatus");
        tilePauseStatus = testData.getTestData(method.getName() + ".tilePauseStatus");
        SOPauseStatus = testData.getTestData(method.getName() + ".SOPauseStatus");

         creditCardNum = testData.getTestData(method.getName() + ".CreditCardNum");
         creditCardMonth = testData.getTestData(method.getName() + ".CreditCardMonth");
         creditCardYear = testData.getTestData(method.getName() + ".CreditCardYear");
         creditCardCvc = testData.getTestData(method.getName() + ".CreditCardCvc");
        creditCardHolder = testData.getTestData(method.getName() + ".CreditCardHolder");

    }
}