package de.vodafone.tests.kableDeutschland.SIT;

import de.vodafone.pages.Kabledeutschland.BridgeModeSettings;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.KIPSettings;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("kableDeutschland")
@Feature("SIT")
@Story("WFDT_7609")
public class WFDT_7609 extends SIT_KableDeutschlandSetup {
    @TmsLink("WFDT-7741")
    @Test(description = "GC02 || Martin SOHO - Validate bridge mode in case user has internet device 'Wemta' router and eligible to activate the bridge mode.",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).expandTorstenAccordionForSITCases();
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnBridgeModeSO()
                .validateBridgeModeAccInActivationCase()
                .clickOnActivationBridgeModeBtn();

        new BridgeModeSettings(driver)
                .validateActivationBridgeModePage()
                .clickOnActivationBridgeModeBtn()
                .validateActivationConfirmationSuccessMsg();
    }

    @TmsLink("WFDT-7742")
    @Test(description = "GC03 || Martin Consumer - Validate bridge mode in case user has internet device 'Wemta' router and eligible to deactivate the bridge mode.",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).expandTorstenAccordionForSITCases();
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnBridgeModeSO()
                .validateBridgeModeAccInDeactivationCase()
                .clickOnDeactivationBridgeModeBtn();

        new BridgeModeSettings(driver)
                .validateDeactivationBridgeModePage()
                .clickOnDeactivationBridgeModeBtn()
                .validateDeactivationConfirmationSuccessMsg();
    }

    @TmsLink("WFDT-7753")
    @Test(description = "GC05 || Martin Consumer - Validate bridge mode Accordion in case 'Home-Spot' is enabled.",groups = {"eCare"})
    private void gc05() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnBridgeModeSO()
                .validateBridgeModeAccInHomeSpotEnabledCase();
    }

    @TmsLink("WFDT-7904")
    @Test(description = "GC08 || Martin Consumer - Check \"Bridge-Mode\" Accordion in case the customer has KIP product and Bridge Mode service is not returned",groups = {"eCare"})
    private void gc07() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .clickOnBridgeModeSO()
                .validateBridgeModeAccInNotReturnedCase();
    }

}