package de.vodafone.tests.PYP.ST;

import de.vodafone.pages.PYP.ConsumerOverview;
import de.vodafone.pages.PYP.PYPLandingPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

/*@Epic("PYP")
@Feature("ST")
@Story("WFAT-11623")
public class WFAT_11623 extends PYPSTSetup{
    @TmsLink("WFAT-11623")
    @Test(description = "Consumer user with no Ultracards - Michael - User navigates to overview page and checks display")
    public void ConsumerUserWithNoUltraCardsMichaelUserNavigatesToOverviewPageAndChecksDisplay() {
        new PYPLandingPage(driver)
                .GoTologin()
                .GoToBTN()
                .typeMSISDNandTAN(MSISDN, TAN)
                .clickLoginButton();
        new ConsumerOverview(driver)
                .pageHeadlineValidation();
        new ConsumerOverview(driver)
                .pageTermsAndConditionButtonsValidation();
    }
}

*/