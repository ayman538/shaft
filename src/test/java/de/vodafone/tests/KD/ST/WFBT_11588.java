package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.TariffPageInternetAndPhone;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class WFBT_11588 extends ST_KDSetup{
    @TmsLink("WFBT-12140")
    @Test(description = "GC01 || WFBT-12140 || Validate Security Package SO & Accordion in KIP Tariff Page")
    public void validateSecurityPackageSOAndAccordion() {
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickOnSecurityPackageSO()
                .validateSecurityPackageSO()
                .validateSecurityPackageAccordion();
    }

    @TmsLink("WFBT-12141")
    @Test(description = "GC02 || WFBT-12141 || Validate Security Package Accordion when KD user clicks on it and he is ineligible to book.")
    public void checkIneligibleUserToBookSecurityPackage() {
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickOnSecurityPackageSO()
                .validateIneligibleSecurityPackage();
    }

    @TmsLink("WFBT-12142")
    @Test(description = "GC03 || WFBT-12142 || Validate Security Package Accordion when KD user clicks on it and he is eligible to book.")
    public void checkEligibleUserToBookSecurityPackage() {
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickOnSecurityPackageSO()
                .validateNotBookedSecurityPackage();
    }

    @TmsLink("WFBT-12143")
    @Test(description = "GC04 || WFBT-12143 || Validate when KD user has a security package")
    public void ValidateWhenUserHasBookedSecurityPackage() {
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickOnSecurityPackageSO()
                .validateBookedSecurityPackage();
    }

    @TmsLink("WFBT-12145")
    @Test(description = "BC01 || Validate BE notification message (Inventory fails)")
    public void ValidateInventoryBENotificationMessage() {
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).checkBEInventoryErrorMessage();
    }

    @TmsLink("WFBT-12146")
    @Test(description = "BC02 || Validate BE notification message (Availability fails)")
    public void ValidateAvailabilityBENotificationMessage() {
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickOnSecurityPackageSO()
                .checkBEAvailabilityErrorMessage();
    }
}