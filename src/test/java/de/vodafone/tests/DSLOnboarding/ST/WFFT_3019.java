/*package de.vodafone.tests.DSLOnboarding.ST;

import de.vodafone.pages.DSLOnboarding.StartSoon;
import de.vodafone.tests.DSLOnboarding.ST.DSLOnboardingSTSetup;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("DSL Onboarding")
@Feature("ST")
@Story("WFFT-3019 Onboarding - Frontend Optimization | TT | Change the position of the CTA")
@Test(enabled = false) // the class not needed for daily pipeline execution
public class WFFT_3019 extends DSLOnboardingSTSetup {
        StartSoon startSoon;

        @Test(description = "GC01-Check the position of button in the first Countdown Screen “Soon to start” page (Desktop)")
        @TmsLink("WFFT-3265")
        public void GC01() {
            startSoon = new StartSoon(driver);
            startSoon.validateTexts();
        }
    }
*/