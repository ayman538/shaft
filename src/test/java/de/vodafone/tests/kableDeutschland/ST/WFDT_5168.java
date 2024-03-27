package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.ActivateSmartCardEntryPoint;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_5168")
public class WFDT_5168 extends ST_KableDeutschlandSetup {
    //Test
    @TmsLink("WFDT-5310")
    @Test(description = "GC01 - Martin - Verify Smart card activation smart object and accordion in devices and setting page ",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver);

        new ActivateSmartCardEntryPoint(driver)
                .ExpandTVProductAccordion()
                .ValidateActivateSmartCardSO()
                .NavigateToActivateSmartCardAccordionFromDashboard()
                .BackToDashboard()
                .ExpandTVProductAccordion()
                .NavigateToActivateSmartCardAccordionFromSettings();
    }
}
