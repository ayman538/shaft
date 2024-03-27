package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.KIPSettings;
import de.vodafone.pages.Kabledeutschland.Phonebook;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("KableDeutschland")
@Feature("ST")
@Story("WFDT_8545")
public class WFDT_8545 extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-8673")
    @Test(description = "GC01 || Martin consumer - Validate adding new phonebook settings with Firma case.",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnPhoneBookSettingSO()
                .clickOnAddBtnOfThirdCard();

        new Phonebook(driver)
                .validatePhoneBookPageFirmaCase()
                .fillAllFields()
                .clickOnContinueBtn()
                .validateSecondAccordionAdd()
                .validateThatitsAlsTelefone()
                .choosePrintedTypeFromDropDownList()
                .AgreeOnPublishAddress()
                .clickOnContinueBtn2ndStep()
                .validateReviewStep()
                .clickOnConfirmationButton()
                .validateSuccessStep();
    }

    @TmsLink("WFDT-8674")
    @Test(description = "GC02 || Martin consumer - Validate the view of adding a new phonebook settings in not Firma case and its regex.",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnPhoneBookSettingSO()
                .clickOnAddBtnOfThirdCard();

        new Phonebook(driver)
                .validatePhoneBookPageNOTFirmaCase()
                .fillAllFields()
                .clickOnContinueBtn()
                .validateThatitsAlsTelefone()
                .choosePrintedTypeFromDropDownList()
                .AgreeOnPublishAddress()
                .clickOnContinueBtn2ndStep()
                .validateReviewStepInNotFirmaCase()
                .clickOnConfirmationButton()
                .validateSuccessStep();
    }

    @TmsLink("WFDT-8675")
    @Test(description = "GC03 || Martin consumer - Validate fields regex in adding new phonebook settings with Firma case.",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnPhoneBookSettingSO()
                .clickOnAddBtnOfThirdCard();

        new Phonebook(driver)
                .enterInvalidDataInNotFirmaCase()
                .validateRegexofNOTFirma()
                .clearNotFirmaFields()
                .validateRegexofFirma()
                .clearAllFields()
                .fillAllFieldsFirmaCase()
                .validateAllInfoIconsMessagesFirmaCase();
    }

    @TmsLink("WFDT-8677")
    @Test(description = "GC05 || Martin SOHO - Validate Deeplinking for adding new phonebook settings",groups = {"eCare"})
    private void gc05() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver).validateDeeplinkTOAddPhoneBookIsDisabled();
    }

    @TmsLink("WFDT-8678")
    @Test(description = "BC01 || Martin SOHO - Validate Service Failure while adding new phonebook settings",groups = {"eCare"})
    private void bc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnPhoneBookSettingSO()
                .clickOnAddBtnOfThirdCard();

        new Phonebook(driver)
                .validatePhoneBookPageNOTFirmaCase()
                .fillAllFields()
                .clickOnContinueBtn()
                .choosePrintedTypeFromDropDownList()
                .AgreeOnPublishAddress()
                .clickOnContinueBtn2ndStep()
                .validateReviewStepInNotFirmaCase()
                .clickOnConfirmationButton()
                .validateFailureView();
    }

}
