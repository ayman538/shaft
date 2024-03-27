package de.vodafone.tests.PYP.ST;

import com.shaft.validation.Validations;
import de.vodafone.pages.PYP.ConsumerOverview;
import de.vodafone.pages.PYP.PYPLandingPage;
import de.vodafone.pages.PYP.PYPLogin;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

/*@Epic("PYP")
@Feature("ST")
@Story("WFAT-11622")
public class WFAT_11622 extends PYPSTSetup {
    @TmsLink("WFAT-11638")
    @Test(description = "GC01-Michael user with a Vodafone number - Verify Login Page and Login successfully")
    public void GC01() {


        new PYPLandingPage(driver).GoTologin().GoToBTN();
        Validations.assertThat().element(driver.getDriver(), PYPLogin.sendTanLocator).isDisabled().perform();
        Validations.assertThat().element(driver.getDriver(), PYPLogin.loginTANLocator).isDisabled().perform();
        new PYPLogin(driver).typeMSISDNandTAN(MSISDN, TAN);
        Validations.assertThat().element(driver.getDriver(), PYPLogin.loginMSISDNLocator).isDisabled().perform();
        new PYPLogin(driver).clickLoginButton();
        Validations.assertThat().element(driver.getDriver(), ConsumerOverview.stepper1).isVisible().perform();
        Validations.assertThat().browser(driver.getDriver()).url().contains("overview").perform();

    }

    @TmsLink("WFAT-11642")
    @Test(description = "GC02-Michael user - Validate the MSISDN field")
    public void GC02() {
        new PYPLandingPage(driver)
                .GoTologin()
                .GoToBTN();
        new PYPLogin(driver).typeMSISDN("abc");
        inlineErrorValidation();
        new PYPLogin(driver).typeMSISDN("121212121.");
        inlineErrorValidation();
        new PYPLogin(driver).typeMSISDN("49312312312");
        inlineErrorValidation();
        new PYPLogin(driver).typeMSISDN("00123232327");
        inlineErrorValidation();
        new PYPLogin(driver).typeMSISDN("0049121212111");
        inlineErrorValidation();
        new PYPLogin(driver).typeMSISDN("");
        inlineErrorValidation();

    }

    private void inlineErrorValidation()
    {
        Validations.assertThat()
                .element(driver.getDriver(), PYPLogin.msisdnInlineError)
                .text()
                .isEqualTo(PYPLogin.msisdnInlineErrorCL)
                .perform();
    }
}
*/