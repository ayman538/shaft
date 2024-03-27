package de.vodafone.tests.Payment.SIT;

import de.vodafone.pages.Payment.Dashboard;
import de.vodafone.pages.Payment.TopUp;
import de.vodafone.pages.Payment.TopupGPP;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Payment")
@Feature("SIT")
public class WFCT_12063 extends SIT_PaymentSetup {
    String contractNumber;
    String tileOrder;
    String numberIndex;

    @TmsLink("WFCT-12108")
    @Test(description = "SIT - GC01 - User with Active auto top up changes the selection of the number with no Auto TopUp")
    public void SIT_GC01_UserWithActiveAutoTopUpChangesTheSelectionOfTheNumberWithNoAutoTopUp(){
        new Dashboard(driver).expandContracts(contractNumber);
        new Dashboard(driver).clickTopUpTile(tileOrder);
        new TopUp(driver).clickDirektAufladen();
//        new TopupGPP(driver).clickCallYaRufnummerDropDownList();
        new TopupGPP(driver).clickChosenCallYaRufnummer(numberIndex);
        new TopupGPP(driver).checkAutoTopUpSectionSublineCL();
        new TopupGPP(driver).checkSwitchOffToggleExist();
        new TopupGPP(driver).clickSwitchOffToggle();
        new TopupGPP(driver).checkLowerBalanceAutoTopUpExist();
        new TopupGPP(driver).checkLowerBalanceAutoTopUpHeadlineCL();
        new TopupGPP(driver).checkRechargeDateAutoTopUpExist();
        new TopupGPP(driver).checkRechargeDateAutoTopUpHeadlineCL();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        tileOrder = testData.getTestData(method.getName() + ".tileOrder");
        contractNumber = testData.getTestData(method.getName() + ".contractNumber");
        numberIndex = testData.getTestData(method.getName() + ".numberIndex");
    }
}
