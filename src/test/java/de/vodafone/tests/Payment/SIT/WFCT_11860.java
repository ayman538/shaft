package de.vodafone.tests.Payment.SIT;

import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Payment.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Payment")
@Feature("SIT")
public class WFCT_11860 extends SIT_PaymentSetup {
    String tileOrder;
    String quickCheckListOrder;
    String contractNumber;
    String burgerMenuOrder;

    JSONFileManager td = new JSONFileManager(System.getProperty("testDataFolderPath") + "Payment/SIT/WFCT_11804.json");

    @TmsLink("WFCT_11883")
    @Test(priority = 0,description = "SIT-User with No auto top up and Create Auto top up")
    public void SIT_CreateAutoTopUp(){
        new Dashboard(driver).expandContracts(contractNumber);
        new Dashboard(driver).clickBurgerMenuIcon(burgerMenuOrder);
        new Dashboard(driver).clickQuickCheckList(quickCheckListOrder);
        new QuickCheckPage(driver).clickDeineAutomAufladungenAccordion();
        new QuickCheckPage(driver).clickSetupAutomationRechargeButton();
        new TopupGPP(driver).clickSwitchOffToggle();
        new TopupGPP(driver).clickRechargeRadioButton();
        new TopupGPP(driver).choosePaymentMethod("Kreditkarte");
        new CreditCardPage(driver).enterCreditCardCredentials(td.getTestData("CreditCardNum"), td.getTestData("CreditCardMonth"), td.getTestData("CreditCardYear"), td.getTestData("CreditCardCvc"), td.getTestData("CreditCardHolder"));
        new TopupGPP(driver).assertOnconfirmationNotificationHeadlineCL();
        new TopupGPP(driver).assertOnconfirmationNotificationSublineCL();
    }

    @TmsLink("WFCT-12052")
    @Test(priority = 1,description = "SIT-GC01-Check that User change GPP auto top-up amount")
    public void SIT_GC01_Check_User_Change_GPP_AutoTopUp_Amount(){
        new Dashboard(driver).expandContracts(contractNumber);
        new Dashboard(driver).clickMeineAufladungtile();
        new QuickCheckPage(driver).checkAutomatischesAufladenSection();
        new QuickCheckPage(driver).checkAutomatischesAufladenCLActive();
        new QuickCheckPage(driver).clickEditButton();
        new EditAutoTopUpInfotmationPage(driver).clickDropDown();
        new EditAutoTopUpInfotmationPage(driver).chooseAmountFromDropDown();
        new EditAutoTopUpInfotmationPage(driver).clickSaveButton();
        new EditAutoTopUpInfotmationPage(driver).assertOnConfirmationMessageHeadline();
        new EditAutoTopUpInfotmationPage(driver).assertOnConfirmationBodyMessageSubline();
        new EditAutoTopUpInfotmationPage(driver).checkAutoTopUpChangeAmountCL();
    }

    @TmsLink("WFCT-12053")
    @Test(priority = 2,description = "SIT-GC02-Check that User change GPP auto top-up status")
    public void SIT_GC02_Check_User_Change_GPP_AutoTopUp_Status() {
        new Dashboard(driver).expandContracts(contractNumber);
        new Dashboard(driver).clickMeineAufladungtile();
        new QuickCheckPage(driver).checkAutomatischesAufladenSection();
        new QuickCheckPage(driver).checkAutomatischesAufladenCLActive();
        new QuickCheckPage(driver).clickEditButton();
        new QuickCheckPage(driver).clickSwitchOffToggle();
        new EditAutoTopUpInfotmationPage(driver).clickSaveButton();
        new EditAutoTopUpInfotmationPage(driver).checkAutoTopUpChangeStatusCL();
    }

    @TmsLink("WFCT-11890")
    @Test(priority = 3,description = "SIT-GC03-Check that User can delete auto top-up payment method from GPP")
    public void SIT_GC03_Check_User_CanDeleteAuto_Top_UpPaymentMethodFromGPP(){
        new Dashboard(driver).expandContracts(contractNumber);
        new Dashboard(driver).clickTopUpTile(contractNumber);
        new TopUp(driver).clickDirektAufladen();
        new TopupGPP(driver).checkTopUpNotificationExist();
        new TopupGPP(driver).clickDeleteIcon();
        new TopupGPP(driver).checkDeletePopUpHeadline();
        new TopupGPP(driver).clickDeleteButton();
        new TopupGPP(driver).checkDeleteConfirmationNotificationSublineCL();
        new TopupGPP(driver).checkSwitchOffToggleExist();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        tileOrder = testData.getTestData(method.getName() + ".tileOrder");
        quickCheckListOrder = testData.getTestData(method.getName() + ".quickCheckListOrder");
        contractNumber = testData.getTestData(method.getName() + ".contractNumber");
        burgerMenuOrder = testData.getTestData(method.getName() + ".burgerMenuOrder");
    }
}