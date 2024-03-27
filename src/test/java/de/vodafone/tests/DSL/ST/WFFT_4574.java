package de.vodafone.tests.DSL.ST;


import de.vodafone.pages.DSL.DSL_Dashboard;
import de.vodafone.pages.DSL.DSL_MeineRechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("DSL")
@Feature("ST")
@Story("Payment | MeinVodafone: DSL Entry point for Account Balance from Rechnungsubersicht accordian")
public class WFFT_4574 extends ST_DSLSetup{
    @Test(description = "GC01- Verify the entry point for account balance in case user is not eligible.")
    @TmsLink("WFFT-4858")
    public void GC01 (Method method){
        new DSL_Dashboard(driver).clickOnMeineRechnungen();
        new DSL_MeineRechnungen(driver).clickOnRechnungsübersichtAccordion().verifyAccountBalanceCardNotEligible(testData.getTestData(method.getName() + ".title"),
                testData.getTestData(method.getName() + ".subtitle"),testData.getTestData(method.getName() + ".price"));

    }
    @Test(description = "GC02- Verify the entry point for account balance in case user has an open amount.")
    @TmsLink("WFFT-4859")
    public void GC02 (Method method){
        new DSL_Dashboard(driver).clickOnMeineRechnungen();
        new DSL_MeineRechnungen(driver).clickOnRechnungsübersichtAccordion().verifyAccountBalanceCardOpenOrDue(testData.getTestData(method.getName() + ".title"),
                testData.getTestData(method.getName() + ".subtitle"),testData.getTestData(method.getName() + ".notificationTitle"),testData.getTestData(method.getName() + ".notificationSubtitle"),
                testData.getTestData(method.getName() + ".price"),testData.getTestData(method.getName() + ".button"));

    }
    @Test(description = "GC03- Verify the entry point for account balance in case user has an overdue or dunning.")
    @TmsLink("WFFT-4860")
    public void GC03 (Method method){
        new DSL_Dashboard(driver).clickOnMeineRechnungen();
        new DSL_MeineRechnungen(driver).clickOnRechnungsübersichtAccordion().verifyAccountBalanceCardOpenOrDue(testData.getTestData(method.getName() + ".title"),
                testData.getTestData(method.getName() + ".subtitle"),testData.getTestData(method.getName() + ".notificationTitle"),testData.getTestData(method.getName() + ".notificationSubtitle"),
                testData.getTestData(method.getName() + ".price"),testData.getTestData(method.getName() + ".button"));
    }
    @Test(description = "GC04- Verify the entry point for account balance in case user is not eligible and the amount is 0.")
    @TmsLink("WFFT-4867")
    public void GC04 (Method method){
        new DSL_Dashboard(driver).clickOnMeineRechnungen();
        new DSL_MeineRechnungen(driver).clickOnRechnungsübersichtAccordion().verifyAccountBalanceCardNotEligible(testData.getTestData(method.getName() + ".title"),
                testData.getTestData(method.getName() + ".subtitle"),testData.getTestData(method.getName() + ".price"));

    }
}
