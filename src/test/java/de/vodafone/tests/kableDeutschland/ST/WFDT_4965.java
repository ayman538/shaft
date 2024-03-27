package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.TVProductDetails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT-4965")
public class WFDT_4965 extends ST_KableDeutschlandSetup {

    @TmsLink("WFDT-5055")
    @Test(description = "GC01 - Consumer Martin - Check Smart card for TV product in case device name and serial number retrieved",groups = {"eCare"})
    private void gc01() {
        new TVProductDetails(driver)
                .NavigateToSettingsPage()
                .ValidateTVSmartCardDetails();
    }

    @TmsLink("WFDT-5056")
    @Test(description = "GC02 - Consumer Martin - Check Smart card for TV product in case device name not retrieved",groups = {"eCare"})
    private void gc02() {
        new TVProductDetails(driver)
                .NavigateToSettingsPage()
                .ValidateTVSmartCardInCaseNoDetails();
    }
}
