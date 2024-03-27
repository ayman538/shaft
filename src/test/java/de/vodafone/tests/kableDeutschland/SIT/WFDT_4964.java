package de.vodafone.tests.kableDeutschland.SIT;

import de.vodafone.pages.Kabledeutschland.TVProductDetails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("SIT")
@Story("WFDT_4964")
public class WFDT_4964 extends SIT_KableDeutschlandSetup{
    @TmsLink("WFDT-5069")
    @Test(description ="GC02 || Consumer Martin has multiple TV devices - Check device details in case some details is not available & Check Settings Smart Object",groups = {"eCare"})
    private void gc02() {
        new TVProductDetails(driver)
                .NavigateToSettingsPage()
                .ValidateTVSettingSO()
                .ValidateTVSettingAccordion()
                .ValidateDetailsInCaseOwnershipNotRetrieved();
    }

}
