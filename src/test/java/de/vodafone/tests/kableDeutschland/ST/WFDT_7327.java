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
@Story("WFDT_7327")
public class WFDT_7327 extends ST_KableDeutschlandSetup{

    @TmsLink("WFDT-7794")
    @Test(description ="GC01 || Martin Consumer - Verify view & change outgoing call blocking settings section in case of Huawei service",groups = {"eCare"})
    private void gc01(){
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnTelephoneSettingsAcc()
                .ValidateBlockOutGoingCallSection()
                .clickOnOutGoingCallBlockBtn();

        new CallBlockingSettings(driver)
                .ValidateBlockOutGoingCallPageHeader()
                .ValidateBlockOutGoingCallSubHeaderForHuwai()
                .ValidateFirstStepOfBlockOutGoingCall()
                .ClickOnFirstSwitcherToggle()
                .ClickOnSecondSwitcherToggle()
                .ClickOnThirdSwitcherToggle()
                .ClickOnConfirmationButton()
                .ValidateSuccessMessage();
    }

    @TmsLink("WFDT-7795")
    @Test(description ="GC02 || Martin SOHO - Verify view & change outgoing call blocking settings section in case of Huawei service",groups = {"eCare"})
    private void gc02(){
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnTelephoneSettingsAcc()
                .ValidateBlockOutGoingCallSection()
                .clickOnOutGoingCallBlockBtn();

        new CallBlockingSettings(driver)
                .ValidateBlockOutGoingCallPageHeader()
                .ValidateBlockOutGoingCallSubHeaderForHuwai()
                .ValidateFirstStepOfBlockOutGoingCall()
                .ClickOnFirstSwitcherToggle()
                .ClickOnSecondSwitcherToggle()
                .ClickOnThirdSwitcherToggle()
                .ClickOnConfirmationButton()
                .ValidateSuccessMessage();
    }

    @TmsLink("WFDT-7797")
    @Test(description ="BC01 || Martin - Verify change outgoing call blocking settings in case failure of Huawei service",groups = {"eCare"})
    private void bc01(){
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnTelephoneSettingsAcc()
                .ValidateBlockOutGoingCallSection()
                .clickOnOutGoingCallBlockBtn();

        new CallBlockingSettings(driver)
                .ValidateBlockOutGoingCallPageHeader()
                .ValidateBlockOutGoingCallSubHeaderForHuwai()
                .ValidateFirstStepOfBlockOutGoingCall()
                .ClickOnFirstSwitcherToggle()
                .ClickOnSecondSwitcherToggle()
                .ClickOnThirdSwitcherToggle()
                .ClickOnConfirmationButton()
                .ValidateFailureMessage();
    }


}
