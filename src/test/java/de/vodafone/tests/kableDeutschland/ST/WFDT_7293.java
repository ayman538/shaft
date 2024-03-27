package de.vodafone.tests.kableDeutschland.ST;
import de.vodafone.pages.Kabledeutschland.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_7293")
public class WFDT_7293 extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-8325")
    @Test(description = "GC01 || Martin SOHO- Validate edit Service address inside Germany in case KD connection is available.",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver)
                .expandAddressesAccordion()
                .clickOnEditServiceAddressButton();

        new EditServiceAddress(driver)
                .validateNoAvailableDateAfter6Ms()
                .SelectNewServiceAddressdateOnSep()
                .validateNonCheckedOutSideGermany()
                .validateEditServiceAddressPage()
                .clickOnContinueBtn()
                .validateAddressSuggestionView()
                .selectSuggestedAddress2()
                .validateTextOfCheckBox()
                .validateAgreedCheckbox();
    }

    @TmsLink("WFDT-8326")
    @Test(description = "GC02 || Martin Consumer - Validate edit Service address Outside Germany in case KD connection is available.",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver)
                .expandAddressesAccordion()
                .clickOnEditServiceAddressButton();

        new EditServiceAddress(driver)
                .SelectNewServiceAddressdate()
                .clickOnOutSideGermanyCheckBox()
                .validateDimmedFields()
                .clickOnContinueBtn()
                .clickOnChangeAddressBtn_OutsideGermany()
                .validateConfirmationStep_OutsideGermany();
    }

    @TmsLink("WFDT-8330")
    @Test(description = "GC04 || Martin Consumer - Validate edit Service address Inside Germany in case UM connection is available",groups = {"eCare"})
    private void gc04() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver)
                .expandAddressesAccordion()
                .clickOnEditServiceAddressButton();

        new EditServiceAddress(driver)
                .validateNonCheckedOutSideGermany()
                .SelectNewServiceAddressdate()
                .clearHouseNumber()
                .changeHouseNumberCaseFour()
                .clickOnContinueBtn()
                .selectSuggestedAddress2()
                .validateUMLConnectionView();
    }

    @TmsLink("WFDT-8335")
    @Test(description = "GC05 || Martin Consumer - Validate edit Service address Inside Germany in case no VF connection is available or other connection other than (UM, KD, DSL)",groups = {"eCare"})
    private void gc05() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver)
                .expandAddressesAccordion()
                .clickOnEditServiceAddressButton();

        new EditServiceAddress(driver)
                .validateNonCheckedOutSideGermany()
                .SelectNewServiceAddressdate()
                .clearHouseNumber()
                .changeHouseNumberCaseFive()
                .clickOnContinueBtn()
                .selectSuggestedAddress2()
                .validateNoVFConnectionAvailableView();
    }

    @TmsLink("WFDT-8336")
    @Test(description = "GC06 || Martin Consumer - Validate edit Service address Inside Germany in case KD, UM, & DSL are available",groups = {"eCare"})
    private void gc06() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver)
                .expandAddressesAccordion()
                .clickOnEditServiceAddressButton();

        new EditServiceAddress(driver)
                .validateNonCheckedOutSideGermany()
                .SelectNewServiceAddressdate()
                .clearHouseNumber()
                .changeHouseNumberCaseSix()
                .clickOnContinueBtn()
                .selectSuggestedAddress2()
                .validateAgreedCheckbox();
    }

    @TmsLink("WFDT-8337")
    @Test(description = "GC07 || Martin Consumer - Validate edit Service address Inside Germany in case UM & DSL are available",groups = {"eCare"})
    private void gc07() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver)
                .expandAddressesAccordion()
                .clickOnEditServiceAddressButton();

        new EditServiceAddress(driver)
                .validateNonCheckedOutSideGermany()
                .SelectNewServiceAddressdate()
                .clearHouseNumber()
                .changeHouseNumberCaseSeven()
                .clickOnContinueBtn()
                .selectSuggestedAddress2()
                .validateUMLConnectionView();
    }

    @TmsLink("WFDT-8341")
    @Test(description = "BC01 || Martin SOHO - Validate Service failure of editing Service address in case DSL connection is available.",groups = {"eCare"})
    private void bc01() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver)
                .expandAddressesAccordion()
                .clickOnEditServiceAddressButton();

        new EditServiceAddress(driver)
                .validateNonCheckedOutSideGermany()
                .SelectNewServiceAddressdate()
                .clearHouseNumber()
                .changeHouseNumberCaseEight()
                .clickOnContinueBtn()
                .selectSuggestedAddress2()
                .validateGeneralErrorMessage();
    }

}
