package de.vodafone.tests.Payment.SIT;

import de.vodafone.pages.Payment.Dashboard;
import de.vodafone.pages.Payment.MeinDaten;
import de.vodafone.pages.Payment.TopupGPP;

import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Payment")
@Feature("SIT")
@Story("WFCT-12251")


public class WFCT_12251 extends SIT_PaymentSetup{

    Dashboard dashboard;
    MeinDaten meinDaten;
    TopupGPP topupGPP;
    String contractOrder;
    String autoTopUpNotificationHL;
    String autoTopUpNotificationBody;
    String bankAccordionCTA;


    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        meinDaten = new MeinDaten(driver);
        topupGPP = new TopupGPP(driver);
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");
        autoTopUpNotificationHL = testData.getTestData(method.getName() + ".autoTopUpNotificationHL");
        autoTopUpNotificationBody = testData.getTestData(method.getName() + ".autoTopUpNotificationBody");
        bankAccordionCTA = testData.getTestData(method.getName() + ".bankAccordionCTA");
    }

    @Test
    @Description("WFCT-12251 | SIT | GC01 - paul user has IBAN and auto top-up check bank verbindung accordion")
    @TmsLink("WFCT-12447")
    public void paulUserNavigatesToBankverbindungThenAssertOnAutoTopUpNotificationHLAndBodyAndBtnTextAndRedirectionToGPP(){
        dashboard.expandContracts(contractOrder);
        dashboard.clickOnMeineDatenTile(contractOrder);
        meinDaten.expandBankVerveindungAccordion();
        meinDaten.assertOnbankVerbindunAccordionAutoTopUpNotificationHL_CL(autoTopUpNotificationHL);
        meinDaten.assertOnbankVerbindunAccordionAutoTopUpNotificationBody_CL(autoTopUpNotificationBody);
        meinDaten.assertOnBankVerbindunAccAutoTopUpBtnText(bankAccordionCTA);
        meinDaten.clickBankAccordionCTABtn_IBAN_AutoTopUp();
        topupGPP.assertThatUserNavigatedTOAutoGPP();
    }

    @Test
    @Description("WFCT-12251 | SIT | GC03 - paul user has no IBAN check bank verbindung accordion")
    @TmsLink("WFCT-12449")
    public void paulUserNavigatesToBankverbindungThenAssertOn_NO_IBAN_NotificationHLAndBodyAndBtnTextAndRedirectionToGPP() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickOnMeineDatenTile(contractOrder);
        meinDaten.expandBankVerveindungAccordion();
        meinDaten.assertOnBankVerbindunAccAutoTopUpBtnText(bankAccordionCTA);
        meinDaten.clicksOnBankAccordionCTAButtonAndRedirectedToGPP();
        topupGPP.clickOnToggleButton();
        topupGPP.assertThatAutoTopUpEnabled_MeineDaten();
    }

}
