package de.vodafone.tests.billing.SIT;

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
@Feature("SIT")
@Story("WFCT-7763")

public class WFCT_12503 extends SIT_BillingSetup {
    Dashboard dashboard;
    Rechnungen rechnungen;
    Einstellungen einstellungen;
    MeineDaten meineDaten;
    MeineRechnungen meineRechnungen;
    KontaktDatenPage kontaktDatenPage;
    String billType , emailStatus , smsStatus , emailColor , currentBillType , newBillType,contractOrder, buttonColor,mobileNumber;


    @BeforeMethod
    public void testDataSetup(Method method) {
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
        contractOrder = testData.getTestData(method.getName()+ ".contractOrder");
        mobileNumber = testData.getTestData(method.getName()+ ".mobileNumber");
        buttonColor= testData.getTestData(method.getName()+ ".buttonColor");
    }

    @Test(description = "GC01 - SIT - user that receives the bill online and the e-mail bounces back and SMS notifications are inactive checks the \"Einstellungen\" page.")
    @TmsLink("WFCT-15100")
    public void GC01_MarieUserWithOnlineBillChecksEinstellungenPage() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile(contractOrder);
        einstellungen.assertOnBillType(billType);
        einstellungen.assertOnInfoIconMessage();
        einstellungen.assertOnBillNotificationIndicationTitle();
        einstellungen.assertOnEmailColor(emailColor);
        einstellungen.assertOnEmailStatus(emailStatus);
        einstellungen.assertThatMobileNumberDoesNotExist();
        einstellungen.assertOnSMSStatus(smsStatus);
        einstellungen.clickOnEditEmailBtn();
        kontaktDatenPage.assertThatUserIsNavigatedToKontaktDaten();
    }
}
