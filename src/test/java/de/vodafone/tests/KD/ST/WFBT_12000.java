package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.TariffPageInternetAndPhone;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("KD")
@Feature("ST")
@Story("WFBT-12000")
public class WFBT_12000 extends ST_KDSetup {
    @TmsLink("WFBT-12039")
    @Test(description = "WFBT-12039 || Check that one-time payment statement is displayed in the option card")
    public void checkOnePaymentStatementDisplayed(){
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickBookablePhoneOptionsSO()
                .clickInternetBookableOptionsAccordion()
                .validateOneTimePaymentStatement();
    }
}