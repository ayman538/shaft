package de.vodafone.tests.Payment.SIT;

import de.vodafone.pages.Payment.Dashboard;
import de.vodafone.pages.Payment.TopupGPP;
import de.vodafone.pages.Payment.MeinDaten;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Payment")
@Feature("SIT")
@Story("WFCT-12626")


public class WFCT_12626 extends SIT_PaymentSetup{

    Dashboard dashboard;
    MeinDaten meinDaten;
    String contractOrder;


    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        meinDaten = new MeinDaten(driver);
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");
    }

    @Test
    @Description("WFCT-12626 | SIT | GC01 - Paul user has no subscribers checks on bank verbindung accordion")
    @TmsLink("WFCT-12666")
    public void paulUserhasNoSubscribersChecksOnBankVerbindungAccordion(){
        dashboard.expandContracts(contractOrder);
        dashboard.clickOnMeineDatenTile(contractOrder);
        meinDaten.expandBankVerveindungAccordion();
        meinDaten.assertThatTheNotificationDoesNotExist();
        meinDaten.assertThatBankAccordionCTADoesNotExist();
    }

}
