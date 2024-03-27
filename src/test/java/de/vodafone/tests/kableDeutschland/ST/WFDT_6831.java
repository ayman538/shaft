package de.vodafone.tests.kableDeutschland.ST;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.EditServiceAddress;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_6831")
public class WFDT_6831 extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-7347 and WFDT-7348")
    @Test(description = "GC01 || Martin - Validate edit Service address inside Germany and Fuzzy logic ",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver)
                .expandAddressesAccordion()
                .validateServiceAddressesSectionContent()
                .clickOnEditServiceAddressButton();

        new EditServiceAddress(driver)
                .validateNonCheckedOutSideGermany()
                .validateEditServiceAddressPage()
                .validateFieldsRegex()
                .enterServiceAddressdate()
                .clearFields()
                .changeAddress()
                .clickOnContinueBtn()
                .validateAddressSuggestionView()
                .selectSuggestedAddress()
                .validateReviewStep_InsideGermany()
                .validateAgreedCheckbox()
                .clickOnChangeAddressBtn()
                .validateConfirmationStep_InsideGermany();
    }

    @TmsLink("WFDT-7349")
    @Test(description = "GC03 || Martin - Validate edit service address Outside Germany",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver)
                .expandAddressesAccordion()
                .clickOnEditServiceAddressButton();

        new EditServiceAddress(driver)
                .clickOnOutSideGermanyCheckBox()
                .validateDimmedFields()
                .enterServiceAddressdate()
                .clickOnContinueBtn()
                .validateReviewStepOutsideGermany()
                .clickOnChangeAddressBtn_OutsideGermany()
                .validateConfirmationStep_OutsideGermany();
    }

    @TmsLink("WFDT-7350")
    @Test(description = "GC04 || Martin - Validate the view of Service Address in case of suspended contract",groups = {"eCare"})
    private void gc04() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver)
                .expandAddressesAccordion()
                .validateDunningNotification()
                .validateServiceAddressesSectionContent()
                .validateEditServiceButtonDimmed();
    }

    @TmsLink("WFDT-7351")
    @Test(description = "GC05 || Martin- Validate edit Service Address in case the new address isn't in Database",groups = {"eCare"})
    private void gc05() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver)
                .expandAddressesAccordion()
                .clickOnEditServiceAddressButton();

        new EditServiceAddress(driver)
                .validateNonCheckedOutSideGermany()
                .changeAddressWithNonExistingAddressInDB()
                .clickOnContinueBtn()
                .validateNotificationMsgOfNonExistedAddress();
    }

    @TmsLink("WFDT-7358")
    @Test(description = "GC06 || Martin - Validate edit Service Address in case the new address Same as old address",groups = {"eCare"})
    private void gc06() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver)
                .expandAddressesAccordion()
                .clickOnEditServiceAddressButton();

        new EditServiceAddress(driver)
                .validateNonCheckedOutSideGermany()
                .enterServiceAddressdate()
                .clickOnContinueBtn()
                .validateNotificationMsgSameAddress();
    }

    @TmsLink("WFDT-7359")
    @Test(description = "GC07 || SOHO - Validate edit service address in case New Address inside Germany and check fields regex",groups = {"eCare"})
    private void gc07() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver)
                .expandAddressesAccordion()
                .validateServiceAddressesSectionContent()
                .clickOnEditServiceAddressButton();

        new EditServiceAddress(driver)
                .validateNonCheckedOutSideGermany()
                .validateEditServiceAddressPage()
                .validateFieldsRegex()
                .enterServiceAddressdate()
                .clearFields()
                .changeAddress()
                .clickOnContinueBtn()
                .validateAddressSuggestionView()
                .selectSuggestedAddress()
                .validateReviewStep_InsideGermany()
                .validateAgreedCheckbox()
                .clickOnChangeAddressBtn()
                .validateConfirmationStep_InsideGermany();
    }

}
