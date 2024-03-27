package de.vodafone.tests.Payment.SIT;

import de.vodafone.pages.Payment.Dashboard;
import de.vodafone.pages.Payment.QuickCheckPage;
import de.vodafone.pages.Payment.TopUp;
import de.vodafone.pages.Payment.TopupGPP;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Payment")
@Feature("SIT")
@Story("WFCT-11604")


public class WFCT_11604 extends SIT_PaymentSetup{

    Dashboard dashboard;
    TopUp topUp;
    TopupGPP topupGPP;
    QuickCheckPage quickCheckPage;
    String burgerMenuOrder;
    String quickCkeckListOrder;
    String contractOrder;
    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        topUp = new TopUp(driver);
        topupGPP = new TopupGPP(driver);
        quickCheckPage = new QuickCheckPage(driver);
        burgerMenuOrder  = testData.getTestData(method.getName()+".burgerMenuOrder");
        quickCkeckListOrder = testData.getTestData(method.getName()+".quickCkeckListOrder");
        contractOrder = testData.getTestData(method.getName()+".contractOrder");
    }

    @Test(description = "GC01 - Paul user has no autopup clicks on Automatische Aufladung in autotopup page")
    @TmsLink("WFCT-12454")
    public void paulUserClicksOnAutomatischeAufladungThenChecksThatToggleButtonIsActivated(){
        dashboard.expandContracts(contractOrder);
        dashboard.clickTopUpTile(contractOrder);
        topUp.clickAutomatischeAufladung();
        topupGPP.assertThatToggleBtnActivated();
    }

}
