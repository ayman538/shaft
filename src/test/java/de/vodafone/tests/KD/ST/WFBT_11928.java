package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.TariffPageInternetAndPhone;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("KD")
@Feature("ST")
@Story("WFBT-11928")
public class WFBT_11928 extends ST_KDSetup{

    @TmsLink("WFBT_12151")
    @Test(description = "WFBT_12151 || GC01 Internet option to be booked externally Check Icmp in the booking link")
    public void GC01_Check_Icmp_In_The_Booking_Link_For_External_Internet_Option(){
        new KD_Dashboard(driver).openBurgerMenu()
                .clickOnMeinTarifKIPBurgerMenu();
        new TariffPageInternetAndPhone(driver).clickInternetBookableOptionsAccordion()
                .clickBookExternalOptionCTA();
    }

    @TmsLink("WFBT_12152")
    @Test(description = "WFBT_12152 || GC02 phone option to be booked externally Check Icmp in the booking link")
    public void GC02_Check_Icmp_In_The_Booking_Link_For_External_Phone_Option(){
        new KD_Dashboard(driver).openBurgerMenu()
                .clickOnMeinTarifKIPBurgerMenu();
        new TariffPageInternetAndPhone(driver).clickPhoneBookableOptionsAccordion()
                .clickBookNowPhoneSecondOptionCTA();
    }
}