package de.vodafone.tests.PYP.ST;

import com.shaft.validation.Validations;
import de.vodafone.pages.PYP.PYPAutoLogout;
import de.vodafone.pages.PYP.PYPLandingPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

/*@Epic("PYP")
@Feature("ST")
@Story("WFAT-9806")
public class WFAT_9806 extends PYPSTSetup {

    @TmsLink("WFAT-13166")
    @Test(description=" Given  I'm logged in user  " +
            "\nWhen    I'm not active for 20 minutes (user session duration)" +
            "\n then  The user session shall expire automatically")
    public void GCO1() {
        new PYPLandingPage(driver)
                .GoToBTN()
                .loginAction(MSISDN ,TAN );
        Validations.assertThat()
                .element(driver.getDriver(), PYPAutoLogout.NotificationTitle_text)
                .text().isEqualTo(PYPAutoLogout.NotificationTitle)
                .withCustomReportMessage("check that same page title  is exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), PYPAutoLogout.NotificationDescription_text)
                .text().isEqualTo(PYPAutoLogout.NotificationDescription)
                .withCustomReportMessage("check that same page description  is exist")
                .perform();
    }
}*/
