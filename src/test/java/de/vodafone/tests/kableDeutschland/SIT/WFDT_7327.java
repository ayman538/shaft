package de.vodafone.tests.kableDeutschland.SIT;

import de.vodafone.pages.Kabledeutschland.CallBlockingSettings;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.KIPSettings;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("SIT")
@Story("WFDT_7327")
public class WFDT_7327 extends SIT_KableDeutschlandSetup {
    @TmsLink("WFDT-7795")
    @Test(description ="GC02 || Martin SOHO - Verify view & change outgoing call blocking settings section in case of Huawei service",groups = {"eCare"})
    private void gc02(){
        new Dashboard(driver).expandTorstenAccordionForSITCases();
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

}
