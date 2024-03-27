package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.KIPSettings;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_4963")
public class WFDT_4963 extends ST_KableDeutschlandSetup {

    @TmsLink("WFDT-5077")
    @Test(description = "GC01 || Martin has one device KIP - Validate KIP devices details in case all details are available & Check 'Geräte & Einstellungen' Smart Object",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openKIPSettingsPageUsingSmartObject();

        new KIPSettings(driver)
                .validateKIPSOandAccordion()
                .validateStaticDeviceNameSO()
                .clickOnInternetDevicesSmartObject()
                .ValidateKIPDetailsInCaseAllDetailsAvailable()
                .clickOnUserGuideBtnProduct1()
                .verifyRedirectionPage();
    }

    @TmsLink("WFDT-5078")
    @Test(description = "GC02 || Martin has multiple devices KIP - Validate KIP devices details in case some details are not available & Check 'Geräte & Einstellungen' Smart Object",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .validateStaticDeviceNameSO()
                .clickOnInternetDevicesSmartObject()
                .ValidateKIPDetailsInCaseSomeDetailsNotAvailable()
                .clickOnUserGuideBtnProduct1()
                .verifyRedirectionPage();
    }

    @TmsLink("WFDT-5079")
    @Test(description = "GC03 || Martin has multiple devices KIP - Validate KIP devices details in case all details are not available, Check 'Geräte & Einstellungen' Smart Object",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .validateStaticDeviceNameSO()
                .clickOnInternetDevicesSmartObject()
                .ValidateKIPDetailsInCaseAllDetailsNotAvailable();
    }

    @TmsLink("WFDT-5102")
    @Test(description = "BC01 || Validate KIP devices details in case of service failure",groups = {"eCare"})
    private void bc01() {
        new Dashboard(driver).openKIPSettingsPageUsingSmartObject();

        new KIPSettings(driver)
                .validateStaticDeviceNameSO()
                .clickOnInternetDevicesSmartObject()
                .ValidateKIPDetailsInCaseServiceFailure();
    }

}
