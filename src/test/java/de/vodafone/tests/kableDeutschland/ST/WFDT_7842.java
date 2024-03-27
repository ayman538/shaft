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
@Story("WFDT_7842")
public class WFDT_7842 extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-8646")
    @Test(description = "GC01 ||  Martin consumer - Validate change phone book settings in case of Firma.",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnPhoneBookSettingSO()
                .clickOnChangeBtnOfFirstCard();

        new Phonebook(driver)
                .validateReturnedValuesOnFields()
                .clearAllFields()
                .changeALLFields()
                .clickOnContinueBtn()
                .validateSecondAccordionChange()
                .validateThatitsAlsTelefone()
                .choosePrintedTypeFromDropDownList()
                .clickOnContinueBtn2ndStep()
                .validateReviewStep_ChangeFirmaCase()
                .clickOnConfirmationButton_ReviewChange()
                .validateSuccessStep();
    }

    @TmsLink("WFDT-8649")
    @Test(description = "GC04 || Martin SOHO - Validate Deeplinking for changing phone book settings",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver).validateDeeplinkTOChangePhoneBookIsDisabled();

    }

    @TmsLink("WFDT-8653")
    @Test(description = "BC01 || Martin SOHO - Validate Service Failure while changing phone book settings NotFirma Case.",groups = {"eCare"})
    private void bc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnPhoneBookSettingSO()
                .clickOnChangeBtnOfFirstCard();

        new Phonebook(driver)
                .clearAllFields()
                .changeALLFields()
                .clickOnContinueBtn()
                .validateSecondAccordionChange()
                .validateThatitsAlsTelefone()
                .choosePrintedTypeFromDropDownList()
                .clickOnContinueBtn2ndStep()
                .validateReviewStep_Change()
                .clickOnConfirmationButton_ReviewChange()
                .validateFailureView_ChangePhonebook();

    }

}