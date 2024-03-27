package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.TVProductDetails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("KableDeutschland")
@Feature("ST")
@Story("WFDT_4964")
public class WFDT_4964 extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-5068")
    @Test(description = "GC01 - Consumer Martin has one TV device - Check device details in case all details is available & Check Settings Smart Object",groups = {"eCare"})
    private void gc01() {
        new TVProductDetails(driver)
                .NavigateToSettingsPage()
                .ValidateTVSettingSO()
                .ValidateTVSettingAccordion()
                .ValidateFirstTVDetails();
    }

    @TmsLink("WFDT-5069")
    @Test(description ="GC02 - Consumer Martin has multiple TV devices - Check device details in case some details is not available & Check Settings Smart Object",groups = {"eCare"})
    private void gc02() {
        new TVProductDetails(driver)
                .NavigateToSettingsPage()
                .ValidateTVSettingSO()
                .ValidateTVSettingAccordion()
                .ValidateDetailsInCaseOwnershipNotRetrieved();

    }

    @TmsLink("WFDT-5070")
    @Test(description = "GC03 - Consumer Martin has multiple TV devices- Check device details in case all details is not available",groups = {"eCare"})
    private void gc03() {
        new TVProductDetails(driver)
                .NavigateToSettingsPage()
                .ValidateTVSettingSO()
                .ValidateTVSettingAccordion()
                .ValidateDetailsInCaseAllNotRetrieved();
    }

    @TmsLink("WFDT-5071")
    @Test(description = "GC04 - Martin has one TV device - Check Linkout for single download as PDF",groups = {"eCare"})
    private void gc04() {
        new TVProductDetails(driver)
                .NavigateToSettingsPage()
                .ValidateTVSettingSO()
                .ValidateTVSettingAccordion()
                .ValidateDownloadSingleCatalogBTN();
    }

    @TmsLink("WFDT-5072")
    @Test(description = "GC05 - Martin has multiple TV devices- Check Linkout for multiple downloads",groups = {"eCare"})
    private void gc05() {
        new TVProductDetails(driver)
                .NavigateToSettingsPage()
                .ValidateTVSettingSO()
                .ValidateTVSettingAccordion()
                .ValidateDownloadMultiCatalogBTN();
    }

    @TmsLink("WFDT-5073")
    @Test(description = "GC06 - Martin - Check that In case of TV Analogue product with no devices, accordion and smart card won't be shown",groups = {"eCare"})
    private void gc06() {
        new TVProductDetails(driver)
                .NavigateToSettingsPage()
                .ValidateDetailsInCaseAnalogTV();
    }

}
