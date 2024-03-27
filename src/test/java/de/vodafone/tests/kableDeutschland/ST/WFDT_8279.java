package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.KIPSettings;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_8361")
public class WFDT_8279 extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-8361")
    @Test(description = "GC01|| Martin Consumer -Validate SIP in case the customer has a KIP with a private router.",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .ExpandSIPAccordion()
                .validateSIPCredentials();
    }

    @TmsLink("WFDT-8362")
    @Test(description = "GC02|| Martin SOHO -Validate SIP in case the customer has a KIP with a private router.",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .ExpandSIPAccordion()
                .validateSIPCredentials();
    }

    @TmsLink("WFDT-8479")
    @Test(description = "GC03|| Martin Consumer -Validate SIP Credentials SO & ACC in case the customer has no phone product.",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver).validateSIPSoAndAccNotDisplayed();
    }

    @TmsLink("WFDT-8363")
    @Test(description = "BC01 || Martin Consumer - Validate SIP credentials with service failure.",groups = {"eCare"})
    private void bc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .ExpandSIPAccordion()
                .validateSIPCredentialsServiceFailure();
    }

    @TmsLink("WFDT-8505")
    @Test(description = "BC02|| Martin Consumer -Validate SIP Credentials SO & ACC in case SIP Credential failure",groups = {"eCare"})
    private void bc02() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .ExpandSIPAccordion()
                .validateSIPCredentialsServiceFailure();
    }

}
