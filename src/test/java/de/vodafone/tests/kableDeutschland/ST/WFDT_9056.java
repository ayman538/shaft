package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.TVProductDetails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT-9056")
public class WFDT_9056 extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-9145")
    @Test(description = "GC01 || Martin SOHO - Validate Giga tv accordion in case last edit date within 30 days",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openGigaTVSettingsPageUsingBurgerMenuLinkout();
        new TVProductDetails(driver)
                .expandGigaTVAccordion()
                .validateGigaTVDevicesInCaseLastEditDateWithin30Days();
    }

    @TmsLink("WFDT-9146")
    @Test(description = "GC02 || Martin Consumer - Validate Giga tv accordion in case last edit date after 30 days",groups = {"eCare"})
    private void gc02(){
        new Dashboard(driver).openGigaTVSettingsPageUsingBurgerMenuLinkout();
        new TVProductDetails(driver)
                .expandGigaTVAccordion()
                .validateGigaTVDevicesInCaseLastEditDateAfter30Days();
    }

    @TmsLink("WFDT-9147")
    @Test(description = "GC03 || Martin SOHO - Validate Giga tv accordion in case there's no registered devices",groups = {"eCare"})
    private void gc03(){
        new Dashboard(driver).openGigaTVSettingsPageUsingBurgerMenuLinkout();
        new TVProductDetails(driver)
                .expandGigaTVAccordion()
                .validateGigaTVDevicesInCaseNoRegisteredDevices();
    }

    @TmsLink("WFDT-9148")
    @Test(description = "GC04 || Martin Consumer - Validate Giga tv accordion in case of there's no giga tv subscription",groups = {"eCare"})
    private void gc04(){
        new Dashboard(driver).openGigaTVSettingsPageUsingBurgerMenuLinkout();
        new TVProductDetails(driver)
                .expandGigaTVAccordion()
                .validateGigaTVDevicesInCaseNoGigaTVSubscription();
    }

    @TmsLink("WFDT-9149")
    @Test(description = "GC05 || Martin Consumer - Validate Giga tv accordion in case user has 1 registered device",groups = {"eCare"})
    private void gc05(){
        new Dashboard(driver).openGigaTVSettingsPageUsingBurgerMenuLinkout();
        new TVProductDetails(driver)
                .expandGigaTVAccordion()
                .validateGigaTVDevicesInCaseUserHas1RegisteredDevice();
    }

    @TmsLink("WFDT-9150")
    @Test(description = "GC06 || Martin SOHO - Validate Giga tv accordion in case user has 2 registered devices",groups = {"eCare"})
    private void gc06(){
        new Dashboard(driver).openGigaTVSettingsPageUsingBurgerMenuLinkout();
        new TVProductDetails(driver)
                .expandGigaTVAccordion()
                .validateGigaTVDevicesInCaseUserHas2RegisteredDevice();
    }

    @TmsLink("WFDT-9151")
    @Test(description = "GC07 || Martin Consumer - Validate Giga tv accordion in case user has 3 registered devices",groups = {"eCare"})
    private void gc07(){
        new Dashboard(driver).openGigaTVSettingsPageUsingBurgerMenuLinkout();
        new TVProductDetails(driver)
                .expandGigaTVAccordion()
                .validateGigaTVDevicesInCaseUserHas3RegisteredDevice();
    }

    @TmsLink("WFDT-9152")
    @Test(description = "BC01 || Martin Consumer - Validate Giga tv accordion in case of service failure",groups = {"eCare"})
    private void bc01(){
        new Dashboard(driver).openGigaTVSettingsPageUsingBurgerMenuLinkout();
        new TVProductDetails(driver)
                .expandGigaTVAccordion()
                .validateGigaTVDevicesInCaseServiceFail();
    }

}
