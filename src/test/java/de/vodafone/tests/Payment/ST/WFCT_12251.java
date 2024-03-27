package de.vodafone.tests.Payment.ST;

import de.vodafone.pages.Payment.Dashboard;
import de.vodafone.pages.Payment.MeinDaten;
import de.vodafone.pages.Payment.TopupGPP;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Payment")
@Feature("ST")
@Story("WFCT-12251")

public class WFCT_12251 extends ST_PaymentSetup {
    Dashboard dashboard;
    MeinDaten meinDaten;
    TopupGPP topupGPP;
    String contractOrder;
    String notificationHL;
    String notificationBody;
    String bankAccordionCTA;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        meinDaten = new MeinDaten(driver);
        topupGPP = new TopupGPP(driver);
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");
        notificationHL = testData.getTestData(method.getName() + ".autoTopUpNotificationHL");
        notificationBody = testData.getTestData(method.getName() + ".autoTopUpNotificationBody");
        bankAccordionCTA = testData.getTestData(method.getName() + ".bankAccordionCTA");
    }

    @Test
    @Description("WFCT-12251 | ST | GC01 - paul user has IBAN and auto top-up check bank verbindung accordion")
    @TmsLink("WFCT-12447")
    public void GC01_paulUserNavigatesToBankverbindungThenAssertOnAutoTopUpNotificationHLAndBodyAndBtnTextAndRedirectionToGPP(){
        dashboard.clickOnMeineDatenTile(contractOrder);
        meinDaten.expandBankVerveindungAccordion();
        meinDaten.assertOnbankVerbindunAccordionAutoTopUpNotificationHL_CL(notificationHL);
        meinDaten.assertOnbankVerbindunAccordionAutoTopUpNotificationBody_CL(notificationBody);
        meinDaten.assertOnBankVerbindunAccAutoTopUpBtnText(bankAccordionCTA);
        meinDaten.clicksOnBankAccordionCTAButtonAndRedirectedToGPP();
        topupGPP.assertThatUserNavigatedTOAutoGPP();
    }


    @Test
    @Description("WFCT-12251 | ST | GC02 - paul user has IBAN and hasn't auto top-up check bank verbindung accordion")
    @TmsLink("WFCT-12448")
    public void GC02_paulUserNavigatesToBankverbindungThenAssertOn_NO_AutoTopUpNotificationHLAndBodyAndBtnTextAndRedirectionToGPP(){
        dashboard.clickOnMeineDatenTile(contractOrder);
        meinDaten.expandBankVerveindungAccordion();
        meinDaten.assertOnbankVerbindunAccordionAutoTopUpNotificationHL_CL(notificationHL);
        meinDaten.assertOnbankVerbindunAccordionAutoTopUpNotificationBody_CL(notificationBody);
        meinDaten.assertOnBankVerbindunAccAutoTopUpBtnText(bankAccordionCTA);
        meinDaten.clicksOnBankAccordionCTAButtonAndRedirectedToGPP();
        topupGPP.assertThatAutoTopUpEnabled_MeineDaten();
    }

    @Test
    @Description("WFCT-12251 | ST | GC03 - paul user has no IBAN check bank verbindung accordion")
    @TmsLink("WFCT-12449")
    public void GC03_paulUserNavigatesToBankverbindungThenAssertOn_NO_IBAN_NotificationHLAndBodyAndBtnTextAndRedirectionToGPP() {
        dashboard.clickOnMeineDatenTile(contractOrder);
        meinDaten.expandBankVerveindungAccordion();
        meinDaten.assertOnbankVerbindunAccordionAutoTopUpNotificationHL_CL(notificationHL);
        meinDaten.assertOnbankVerbindunAccordionAutoTopUpNotificationBody_CL(notificationBody);
        meinDaten.assertOnBankVerbindunAccAutoTopUpBtnText(bankAccordionCTA);
        meinDaten.clicksOnBankAccordionCTAButtonAndRedirectedToGPP();
        topupGPP.assertThatAutoTopUpEnabled_MeineDaten();
    }

    @Test
    @Description("WFCT-12251 | ST | GC07 - Paul user has failed paymentMethod service check bank verbindung accordion")
    @TmsLink("WFCT-12609")
    public void GC07_paulUserWithFailed_GETPaymentMethodService_ThenChecksBankverbindungAccordion(){
        dashboard.clickOnMeineDatenTile(contractOrder);
        meinDaten.expandBankVerveindungAccordion();
        meinDaten.assertOnErrorNotificationDoesNotExist();
        meinDaten.assertThatBankAccordionCTADoesNotExist();
    }

    @Test
    @Description("WFCT-12251 | ST | GC08 - Paul user has failed bankDetails service check bank verbindung accordion")
    @TmsLink("WFCT-12610")
    public void GC08_paulUserWithFailed_GETBankDetailsService_ThenChecksBankverbindungAccordion(){
        dashboard.clickOnMeineDatenTile(contractOrder);
        meinDaten.expandBankVerveindungAccordion();
        meinDaten.assertOnBankServiceFailureNotification_HL();
        meinDaten.assertOnBankServiceFailureNotification_Body();
        meinDaten.assertThatBankAccordionCTADoesNotExist();
    }

    @Test
    @Description("WFCT-12251 | ST | GC09 - Paul user has failed paymentMethod and bankDetails services check bank verbindung accordion")
    @TmsLink("WFCT-12611")
    public void GC09_paulUserWithFailed_GETBankDetailsAndGETPaymentMethodServices_ThenChecksBankverbindungAccordion(){
        dashboard.clickOnMeineDatenTile(contractOrder);
        meinDaten.expandBankVerveindungAccordion();
        meinDaten.assertOnBankServiceFailureNotification_HL();
        meinDaten.assertOnBankServiceFailureNotification_Body();
        meinDaten.assertThatBankAccordionCTADoesNotExist();
    }

}
