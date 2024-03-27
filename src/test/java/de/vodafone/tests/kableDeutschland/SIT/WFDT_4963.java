package de.vodafone.tests.kableDeutschland.SIT;

import de.vodafone.pages.Kabledeutschland.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("SIT")
@Story("WFDT_4963")
public class WFDT_4963 extends SIT_KableDeutschlandSetup{
    @TmsLink("WFDT-5239")
    @Test(description = "GC01 || Martin has one device KIP - Validate KIP devices details in case all details are available & Check 'Geräte & Einstellungen' Smart Object",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openKIPSettingsPageUsingSmartObject();

        new KIPSettings(driver)
                .validateKIPSOandAccordion()
                .validateDynamicDeviceNameSO()
                .openInternetDevicesAccordion()
                .ValidateKIPDetailsInCaseAllDetailsAvailable()
                .clickOnUserGuideBtnProduct1()
                .verifyRedirectionPage();
    }

    @TmsLink("WFDT-5077")
    @Test(description = "GC02 || Martin has one device KIP - Validate KIP devices details in case all details are available & Check 'Geräte & Einstellungen' Smart Object",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).expandTorstenAccordionForSITCases();
        new Dashboard(driver).openKIPSettingsPageUsingSmartObject();

        new KIPSettings(driver)
                .validateKIPSOandAccordion()
                .validateStaticDeviceNameSO()
                .openInternetDevicesAccordion()
                .ValidateKIPDetailsInCaseAllDetailsAvailable()
                .clickOnUserGuideBtnProduct1()
                .verifyRedirectionPage();
    }

}
