/*package de.vodafone.tests.DSLOnboarding.ST;

import de.vodafone.pages.DSLOnboarding.TodayConfirmation;
import de.vodafone.pages.DSLOnboarding.TodayPage;
import de.vodafone.pages.DSLOnboarding.TomorrowPage;
import de.vodafone.tests.DSLOnboarding.SIT.DSLOnboardingSITSetup;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("DSL Onboarding")
@Feature("ST")
@Story("WFFT-2973 Onboarding - Frontend Optimization | TT | Add SuperConnect-Teaser")
@Test(enabled = false) // the class not needed for daily pipeline execution
public class WFFT_2973 extends DSLOnboardingSTSetup {
    TomorrowPage tomorrowPage;

    @Test(description = "GC01-Selfinstall-Check the SuperConnect-Teaser is added in “Tomorrow comes the technical service” page (desktop)")
    @TmsLink("WFFT-3239")
    public void GC01() {
        tomorrowPage = new TomorrowPage(driver);
        tomorrowPage.validateSelfinstallTexts();
        tomorrowPage.validateSuperConnectedTeaserTexts();
    }
    @Test(description = "GC04-Techinstall-Check the SuperConnect-Teaser is added in “Tomorrow comes the technical service” page (desktop)")
    @TmsLink("WFFT-3242")
    public void GC04() {
        tomorrowPage = new TomorrowPage(driver);
        tomorrowPage.validateTechinstallTexts();
        tomorrowPage.validateSuperConnectedTeaserTexts();
    }
}
 */
