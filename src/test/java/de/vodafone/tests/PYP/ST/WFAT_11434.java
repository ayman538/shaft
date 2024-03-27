package de.vodafone.tests.PYP.ST;

import de.vodafone.pages.PYP.ConsumerOverview;
import de.vodafone.pages.PYP.PYPLandingPage;
import de.vodafone.pages.PYP.PYPLogin;
import de.vodafone.pages.PYP.UpsellingConfirmationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

/*@Epic("PYP")
@Feature("ST")
@Story("WFAT-11434")
public class WFAT_11434 extends PYPSTSetup {
    @TmsLink("WFAT-11751")
    @Test(description = "Consumer User with 1 Sim ultracard- Verify the Upselling Flow")
    public void GC01() {
        new PYPLandingPage(driver).GoTologin().GoToBTN();
        new PYPLogin(driver).typeMSISDNandTAN(MSISDN, TAN).clickLoginButton();
        new ConsumerOverview(driver).clickUpsellingDetailsButton().upsellingValidations().clickUpsellingSubmitButton();
        new UpsellingConfirmationPage(driver).notificationValidation();
    }
}
*/