package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.GenerateSIP;
import de.vodafone.pages.Kabledeutschland.KIPSettings;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("KableDeutschland")
@Feature("ST")
@Story("WFDT-8122")
public class WFDT_8122 extends ST_KableDeutschlandSetup {
    //Test
    @TmsLink("WFDT-8399")
    @Test(description ="GC01 || Martin Consumer - Validate generate SIP credentials for KD user",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver).ExpandSIPAccordion();
        new GenerateSIP(driver)
                .ValidateGenerateSIPSection()
                .NavigateToGenerateSIPPage()
                .ValidateGenerateSIPPage()
                .ClickOnGenerateSIPCredentials()
                .ValidateGenerateSIPSuccessMessage()
                .ValidateNewSIPSection();
    }

    @TmsLink("WFDT-8401")
    @Test(description ="GC02 || Martin Consumer - Validate that Deep-linking for generating SIP credentials is Disabled.",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver).ExpandSIPAccordion();
        new GenerateSIP(driver)
                .ValidateGenerateSIPSection()
                .ValidateDeeplinkBlocking();
    }

    @TmsLink("WFDT-8400")
    @Test(description ="BC01 || Martin SOHO - Validate generating SIP credentials for KD user in case of Service Failure",groups = {"eCare"})
    private void bc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver).ExpandSIPAccordion();
        new GenerateSIP(driver)
                .ValidateGenerateSIPSection()
                .NavigateToGenerateSIPPage()
                .ValidateGenerateSIPPage()
                .ClickOnGenerateSIPCredentials()
                .ValidateGenerateSIPFailureMessage();
    }
}
