package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.TariffPageInternetAndPhone;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("KD")
@Feature("ST")
@Story("WFBT-10678")
public class WFBT_10678 extends ST_KDSetup {
    @TmsLink("WFBT-10835")
    @Test(description = "GC01 || when user clicks on booked options accordion, he can see all his booked options")
    public void viewBookedOptions(){
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).expandBookedOptionsAccordion().assertOnBookedOptionsAccordion()
                .validateBookedOptionsCard();
    }

    @TmsLink("WFBT-10836")
    @Test(description = "GC02 || check that if user doesn't have any booked options, a static notification appears to him")
    public void checkStaticNotificationInBookedOptionsAcc(){
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).expandBookedOptionsAccordion().validateNoBookedOptionMsg();
    }
}