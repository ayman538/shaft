package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.CallBlockingSettings;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.KIPSettings;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;


@Epic("KableDeutschland")
@Feature("ST")
@Story("WFDT-7526")
public class WFDT_7526 extends ST_KableDeutschlandSetup {

    @TmsLink("WFDT-7601")
    @Test(description ="GC01 || Consumer Martin - Verify view & change outgoing call blocking settings section for user has home box router and one phone number",groups = {"eCare"})
    private void gc01(){
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver).clickOnTelephoneSettingsAcc();
        new KIPSettings(driver).ValidateBlockOutGoingCallSection();
        new KIPSettings(driver).clickOnOutGoingCallBlockBtn();
        new CallBlockingSettings(driver)
                .ValidateBlockOutGoingCallPageHeader()
                .ValidateBlockOutGoingCallForSingleNumTile()
                .ValidateFirstStepOfBlockOutGoingCall()
                .ClickOnFirstSwitcherToggle()
                .ClickOnSecondSwitcherToggle()
                .ClickOnThirdSwitcherToggle()
                .ClickOnConfirmationButton()
                .ValidateSuccessMessage();
    }

    @TmsLink("WFDT-7602")
    @Test(description ="GC02 || SOHO Martin - Verify view & change outgoing call blocking settings section for user has home box router and multi phone numbers",groups = {"eCare"})
    private void gc02(){
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver).clickOnTelephoneSettingsAcc();
        new KIPSettings(driver).clickOnOutGoingCallBlockBtn();
        new CallBlockingSettings(driver)
                .ValidateBlockOutGoingCallPageHeader()
                .ValidateBlockOutGoingCallForMultiNumbersDDL()
                .ChooseSecondNumberForMultiNumbersDDL()
                .ValidateFirstStepOfBlockOutGoingCall()
                .ClickOnFirstSwitcherToggle()
                .ClickOnSecondSwitcherToggle()
                .ClickOnThirdSwitcherToggle()
                .ClickOnConfirmationButton()
                .ValidateSuccessMessage();
    }

    @TmsLink("WFDT-7603")
    @Test(description ="GC03 || Consumer Martin - Verify view & change outgoing call blocking settings section for user has a NOT home box router and multi line numbers",groups = {"eCare"})
    private void gc03(){
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver).clickOnTelephoneSettingsAcc();
        new KIPSettings(driver).clickOnOutGoingCallBlockBtn();
        new CallBlockingSettings(driver)
                .ValidateBlockOutGoingCallPageHeader()
                .ValidateBlockOutGoingCallForMultiLandLinesDDL()
                .ValidateInLineMessageForLandLineTile()
                .ChooseSecondNumberForMultiNumbersDDL()
                .ValidateFirstStepOfBlockOutGoingCall()
                .ClickOnFirstSwitcherToggle()
                .ClickOnSecondSwitcherToggle()
                .ClickOnThirdSwitcherToggle()
                .ClickOnConfirmationButton()
                .ValidateSuccessMessage();
    }

    @TmsLink("WFDT-7604")
    @Test(description ="GC04 || SOHO Martin - Verify view & change outgoing call blocking settings section for user has a NOT home box router and single line number",groups = {"eCare"})
    private void gc04(){
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver).clickOnTelephoneSettingsAcc();
        new KIPSettings(driver).clickOnOutGoingCallBlockBtn();
        new CallBlockingSettings(driver)
                .ValidateBlockOutGoingCallPageHeader()
                .ValidateBlockOutGoingCallForSingleLandLineTile()
                .ValidateInLineMessageForLandLineTile()
                .ValidateFirstStepOfBlockOutGoingCall()
                .ClickOnFirstSwitcherToggle()
                .ClickOnSecondSwitcherToggle()
                .ClickOnThirdSwitcherToggle()
                .ClickOnConfirmationButton()
                .ValidateSuccessMessage();
    }

    @TmsLink("WFDT-7605")
    @Test(description ="BC01 || Consumer Martin - Verify view & change outgoing call blocking settings section for user has home box router in case of service failure",groups = {"eCare"})
    private void bc01(){
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver).clickOnTelephoneSettingsAcc();
        new KIPSettings(driver).clickOnOutGoingCallBlockBtn();
        new CallBlockingSettings(driver).
                ValidateBlockOutGoingCallPageHeader()
                .ValidateFirstStepOfBlockOutGoingCall()
                .ClickOnFirstSwitcherToggle()
                .ClickOnSecondSwitcherToggle()
                .ClickOnThirdSwitcherToggle()
                .ClickOnConfirmationButton()
                .ValidateFailureMessage();
    }

    @TmsLink("WFDT-7606")
    @Test(description ="BC02 || SOHO Martin - Verify view & change outgoing call blocking settings section for user Not has home box router in case of service failure",groups = {"eCare"})
    private void bc02(){
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver).clickOnTelephoneSettingsAcc();
        new KIPSettings(driver).clickOnOutGoingCallBlockBtn();
        new CallBlockingSettings(driver)
                .ValidateBlockOutGoingCallPageHeader()
                .ValidateFirstStepOfBlockOutGoingCall()
                .ClickOnFirstSwitcherToggle()
                .ClickOnSecondSwitcherToggle()
                .ClickOnThirdSwitcherToggle()
                .ClickOnConfirmationButton()
                .ValidateFailureMessage();
    }

}
