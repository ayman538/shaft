package de.vodafone.tests.kableDeutschland.SIT;

import de.vodafone.pages.Kabledeutschland.CallForward;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.KIPSettings;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("SIT")
@Story("WFDT_7330")
public class WFDT_7330 extends SIT_KableDeutschlandSetup {
    @TmsLink("WFDT-7538")
    @Test(description = "GC01 || Martin Consumer - Verify new section 'Weiterleitung einrichten'",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).expandTorstenAccordionForSITCases();
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .validatePhoneSettinsSOExisted()
                .validateTelephoneSettingsSO()
                .clickOnTelephoneSettingsAcc()
                .validateTelephoneSettingsAcc()
                .validateCallForwardCard()
                .clickOnViewAndChangeCallForwardCard();
    }

    @TmsLink("WFDT-7539")
    @Test(description = "GC02 || Martin SOHO - Verify call forward settings view in case user has homebox router",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).expandTorstenAccordionForSITCases();
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnTelephoneSettingsAcc()
                .clickOnViewAndChangeCallForwardCard();

        new CallForward(driver)
                .validateCallForwardPage()
                .validateHomeBoxTitle()
                .validateHomeBoxFirstCard()
                .validateHomeBoxSecondCard();
    }

    @TmsLink("WFDT-7540")
    @Test(description = "GC03 || Martin Consumer - Verify call forward settings view in case user has non-homebox router",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).expandTorstenAccordionForSITCases();
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnTelephoneSettingsAcc()
                .clickOnViewAndChangeCallForwardCard();

        new CallForward(driver)
                .validateCallForwardPage()
                .validateNonHomeBoxTitle()
                .validateNonHomeBoxFirstCard()
                .openInfoIconFirstCardNonHomeBox()
                .validateFirstCardInfoIconContent()
                .closeInfoIconFirstCardNonHomeBox();
    }

    @TmsLink("WFDT-7541")
    @Test(description = "GC04 || Martin SOHO 'homebox router' - Verify call forward for 'busy' reason with valid number format",groups = {"eCare"})
    private void gc04() {
        new Dashboard(driver).expandTorstenAccordionForSITCases();
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnTelephoneSettingsAcc()
                .clickOnViewAndChangeCallForwardCard();

        new CallForward(driver)
                .clickOnChooseForwardSettingsBtn()
                .validateSecondStep()
                .switchToggleBtnOnBusyReason()
                .validateDestinationNumberDetails()
                .openInfoIconDestinationNumber()
                .validateInfoIconForDestinationNumberContent()
                .closeInfoIconDestinationNumber()
                .insertValidDestinationNumber()
                .clickOnProceedBtn()
                .clickOnSaveBtn()
                .validateSuccessMessageStep()
                .expandOverViewSectionUnderSuccessMessage();
    }

    @TmsLink("WFDT-7543")
    @Test(description = "GC06 || Martin Consumer 'non-homebox router' - Verify call forward for 'After 30 seconds' reason with valid number format",groups = {"eCare"})
    private void gc06() {
        new Dashboard(driver).expandTorstenAccordionForSITCases();
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnTelephoneSettingsAcc()
                .clickOnViewAndChangeCallForwardCard();

        new CallForward(driver)
                .clickOnChooseForwardSettingsBtn()
                .validateSecondStep()
                .switchToggleBtnOnAfter30SecondsReason()
                .validateDestinationNumberDetails()
                .openInfoIconDestinationNumber()
                .validateInfoIconForDestinationNumberContent()
                .closeInfoIconDestinationNumber()
                .insertValidDestinationNumber()
                .clickOnProceedBtn()
                .validateThirdStepForNonHomeBox()
                .openInfoIconFirstCardNonHomeBox()
                .validateFirstCardInfoIconContent()
                .closeInfoIconFirstCardNonHomeBox()
                .clickOnSaveBtn()
                .validateSuccessMessageStep()
                .expandOverViewSectionUnderSuccessMessage()
                .validateOverviewSectionForNonHomeBox()
                .openInfoIconFirstCardNonHomeBox()
                .validateFirstCardInfoIconContent()
                .closeInfoIconFirstCardNonHomeBox();
    }
    @TmsLink("WFDT-7544")
    @Test(description = "GC07 || Martin Consumer 'non-homebox router' - Verify call forward for closing all the reasons with valid number format",groups = {"eCare"})
    private void gc07() {
        new Dashboard(driver).expandTorstenAccordionForSITCases();
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnTelephoneSettingsAcc()
                .clickOnViewAndChangeCallForwardCard();

        new CallForward(driver)
                .clickOnChooseForwardSettingsBtn()
                .validateSecondStep()
                .switchToggleBtnOffBusyReason()
                .switchToggleBtnOffAfter30SecondsReason()
                .validateDisappearingDestinationNumberDetails()
                .clickOnProceedBtn()
                .validateThirdStepForNonHomeBox()
                .openInfoIconFirstCardNonHomeBox()
                .validateFirstCardInfoIconContent()
                .closeInfoIconFirstCardNonHomeBox()
                .clickOnSaveBtn()
                .validateSuccessMessageStep()
                .expandOverViewSectionUnderSuccessMessage()
                .validateOverviewSectionForNonHomeBox()
                .openInfoIconFirstCardNonHomeBox()
                .validateFirstCardInfoIconContent()
                .closeInfoIconFirstCardNonHomeBox();

    }

    @TmsLink("WFDT-7545")
    @Test(description = "GC08 || Martin Consumer - Verify call forward settings view incase no new changes on reason",groups = {"eCare"})
    private void gc08() {
        new Dashboard(driver).expandTorstenAccordionForSITCases();
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnTelephoneSettingsAcc()
                .clickOnViewAndChangeCallForwardCard();

        new CallForward(driver)
                .clickOnChooseForwardSettingsBtn()
                .validateSecondStep();

    }

    @TmsLink("WFDT-7547")
    @Test(description = "GC10 || Martin Consumer - Verify call forward for 'directly' & 'After 30 seconds' reasons",groups = {"eCare"})
    private void gc10() {
        new Dashboard(driver).expandTorstenAccordionForSITCases();
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnTelephoneSettingsAcc()
                .clickOnViewAndChangeCallForwardCard();

        new CallForward(driver)
                .clickOnChooseForwardSettingsBtn()
                .validateSecondStep()
                .switchToggleBtnOnAfter30SecondsReason()
                .switchToggleBtnOnRightAwayReason()
                .validateToggleBtnForAfter30SecondsReasonSwitchedOff()
                .switchToggleBtnOnAfter30SecondsReason()
                .validateToggleBtnForRightAwayReasonSwitchedOff();

    }

    @TmsLink("WFDT-7548")
    @Test(description = "GC11 || Martin Consumer - Verify call forward for 'directly' & 'busy' reasons",groups = {"eCare"})
    private void gc11() {
        new Dashboard(driver).expandTorstenAccordionForSITCases();
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnTelephoneSettingsAcc()
                .clickOnViewAndChangeCallForwardCard();

        new CallForward(driver)
                .clickOnChooseForwardSettingsBtn()
                .validateSecondStep()
                .switchToggleBtnOnBusyReason()
                .switchToggleBtnOnRightAwayReason()
                .validateToggleBtnForBusyReasonSwitchedOff()
                .switchToggleBtnOnBusyReason()
                .validateToggleBtnForRightAwayReasonSwitchedOff();

    }

    @TmsLink("WFDT-7549")
    @Test(description = "GC12 || Martin SOHO - Verify deeplink to the forward settings",groups = {"eCare"})
    private void gc12() {

        new CallForward(driver).deeplinkToCallForwardSettingsPage();
        new KIPSettings(driver).validateDeeplinkIsDisabled();
    }

    @TmsLink("WFDT-7632")
    @Test(description = "GC14 || Martin Consumer - Check 'Telefoneinstellungen' SO and accordion in case the user has no phone lines",groups = {"eCare"})
    private void gc14() {
        new Dashboard(driver).expandTorstenAccordionForSITCases();
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .validateCallForwardSODoesNotExist()
                .validateCallForwardAccordionDoesNotExist();
    }

}
