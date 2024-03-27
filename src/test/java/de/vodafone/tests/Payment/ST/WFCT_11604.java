package de.vodafone.tests.Payment.ST;


import de.vodafone.pages.Payment.Dashboard;
import de.vodafone.pages.Payment.QuickCheckPage;
import de.vodafone.pages.Payment.TopUp;
import de.vodafone.pages.Payment.TopupGPP;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
@Epic("Payment")
@Feature("ST")
@Story("WFCT-11604")

public class WFCT_11604 extends ST_PaymentSetup{
    Dashboard dashboard;
    TopUp topUp;
    QuickCheckPage quickCheckPage;
    TopupGPP topupGPP;
    String contractOrder;
    String burgerMenuOrder;
    String quickCkeckListOrder;
    String legacy_AutoDebitOptionLink;
    String legacy_AutoDebitActivateLink;
    String legacy_AutoDebitRechargeAmountLink;
    String legacy_Aufladen_DirektAufladungLink;
    String baseUrl ;



    @BeforeMethod
    public void beforeMethod(Method method){
        dashboard = new Dashboard(driver);
        topUp = new TopUp(driver);
        topupGPP = new TopupGPP(driver);
        quickCheckPage = new QuickCheckPage(driver);
        burgerMenuOrder  = testData.getTestData(method.getName()+".burgerMenuOrder");
        quickCkeckListOrder = testData.getTestData(method.getName()+".quickCkeckListOrder");
        contractOrder = testData.getTestData(method.getName()+".contractOrder");
        baseUrl = System.getProperty("de.vodafone.baseUrl.st");
        legacy_AutoDebitOptionLink = testData.getTestData(method.getName()+".link1");
        legacy_AutoDebitActivateLink = testData.getTestData(method.getName()+".link2");
        legacy_AutoDebitRechargeAmountLink = testData.getTestData(method.getName()+".link3");
        legacy_Aufladen_DirektAufladungLink = testData.getTestData(method.getName()+".link4");

    }

    @Test(description = "GC01 - Paul user has no autopup clicks on Automatische Aufladung in autotopup page Then Assert That Toggle Button is Activated ")
    @TmsLink("WFCT-12454")
    public void paulUserHasNoAutoTopUpClicksOnAutomatischeAufladung(){
        dashboard.clickTopUpTile(contractOrder);
        topUp.clickAutomatischeAufladung();
        topupGPP.clickOnToggleButton();
        topupGPP.clickOnToggleButton();
        topupGPP.assertThatAutoTopUpEnabled_MeineDaten();
    }

    @Test(description = "GC02 - Paul user has no autopup clicks on Einmalige Direktaufladung in topup page Then Assert That Toggle Button Remains Not Activated")
    @TmsLink("WFCT-12455")
    public void paulUserHasNoAutoTopUpClicksOnEinmaligeDirektaufladung(){
        dashboard.clickTopUpTile(contractOrder);
        topUp.clickDirektAufladen();
        topupGPP.clickOnToggleButton();
        topupGPP.clickOnToggleButton();
        topupGPP.assertThatAutoTopUpIsDisabled_MeineDaten();
    }

    @Test(description = "GC03 - Paul User Has Auto Top Up Checks on Top Up Page and Assert That Automatische Aufladung Tile Does Not Exists ")
    @TmsLink("WFCT-12456")
    public void paulUserHasAutoTopUpChecksTopUpPage(){
        dashboard.clickTopUpTile(contractOrder);
        topUp.assertOnCallNowAufladungExists();
        topUp.assertOnEinmaligeDirektaufladungTileExists();
        topUp.assertOnCallNowAufladungExists();
        topUp.assertThatAutomatischeAufladungDoesNotExist();
    }

    @Test(description = "GC04 - Paul User Checks Payment Legacy Pages Existance And Assert On Redirection To TopUpGPP Not Legacy Pages")
    @TmsLink("WFCT-12457")
    @Issue("Issue due to not existance of simplicity branch")
    public void paulUserHasLegacyTopUpChecksPaymentLegacyPagesExistance(){
        dashboard.assertThatMeineAufladungTileNotExists();
        dashboard.clickBurgerMenuIcon(burgerMenuOrder).clickQuickCheckList(quickCkeckListOrder);
        quickCheckPage.assertOnAutomatischesAufladen();
        quickCheckPage.assertOnDisabledSOMessageCL();
        quickCheckPage.clickAutomAufladenSmartObject();
        quickCheckPage.assertOnDeineAutomAufladungSublineCL();
    }

    @Test(description = "GC05 - Paul User Checks Payment Legacy Pages Existance With Deep Links And Redirected To DashBoard Insted Of Payment Legacy Pagess")
    @TmsLink("WFCT-12492")
    public void paulUserChecksPaymentLegacyPagesExistanceWithDeepLinks() {
        dashboard.navigationDeepLink( baseUrl +legacy_AutoDebitOptionLink);
        dashboard.makeSureThatUserNAvigatedToDashboard();
        dashboard.assertThatUserNavigatedToDashboard();
        dashboard.navigationDeepLink(baseUrl +legacy_AutoDebitActivateLink);
        dashboard.makeSureThatUserNAvigatedToDashboard();
        dashboard.assertThatUserNavigatedToDashboard();
        dashboard.navigationDeepLink(baseUrl +legacy_AutoDebitRechargeAmountLink);
        dashboard.makeSureThatUserNAvigatedToDashboard();
        dashboard.assertThatUserNavigatedToDashboard();
        dashboard.navigationDeepLink(baseUrl +legacy_Aufladen_DirektAufladungLink);
        dashboard.makeSureThatUserNAvigatedToDashboard();
        dashboard.assertThatUserNavigatedToDashboard();
    }

}
