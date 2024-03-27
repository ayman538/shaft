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
@Story("WFDT_7871")
public class WFDT_7871 extends ST_KableDeutschlandSetup {
        //TEST
        @TmsLink("WFDT-7899")
        @Test(description = "GC01 || Martin consumer - Validate SIP SO & Accordion in case user has Phone Product",groups = {"eCare"})
        public void gc01() {
            new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
            new KIPSettings(driver).validateSIPSO();
            new KIPSettings(driver).validateSIPAccordion();
        }

        @TmsLink("WFDT-7900")
        @Test(description = "GC02 || Martin consumer - Validate SIP SO & Accordion are not displayed in case user doesn't have Phone Product",groups = {"eCare"})
        public void gc02() {
            new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
            new KIPSettings(driver).validateSIPSODoesNotExist();
            new KIPSettings(driver).validateSIPAccordionDoesNotExist();
        }


        @TmsLink("WFDT-7901")
        @Test(description = "GC03 || SOHO Martin - Validate SIP SO & Accordion in case user has Phone Product",groups = {"eCare"})
        public void gc03() {
            new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
            new KIPSettings(driver).validateSIPSO();
            new KIPSettings(driver).validateSIPAccordion();
        }

    @TmsLink("WFDT-7931")
    @Test(description = "BC01 || Martin consumer- Validate SIP Accordion in case of service failure",groups = {"eCare"})
    public void bc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver).ExpandSIPAccordion();
        new KIPSettings(driver).validateSIPServiceFailure();
    }
}








