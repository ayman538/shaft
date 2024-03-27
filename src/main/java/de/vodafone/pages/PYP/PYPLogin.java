package de.vodafone.pages.PYP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class PYPLogin {
    private SHAFT.GUI.WebDriver driver;
    public PYPLogin(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    //Login page locators and CL
    private static By hereWeGo_button = By.xpath("//*[@automation-id='pypLandingPage_btn']");
    public static By loginMSISDNLocator = By.xpath("//input[@id='msisdn']");
    public static By sendTanLocator = By.xpath("//*[text()='SMS-Code anfordern']");
    public static By resendTanLocator = By.xpath("//*[text()='Verifizierungscode anfordern']");
    public static By loginTANLocator = By.xpath("//*[@automation-id='tan_et']");
    private static By loginButton = By.xpath("//button[text()='Anmelden']");
    public static By resendLimitNot_header = By.xpath("//*[@class='alert noselect error']/div/div[1]/div/h4");
    public static By resendLimitNot_text = By.xpath("//*[@class='alert noselect error']/div/p");
    public static By msisdnInlineError = By.xpath("//*[@automation-id='msisdn_patternErrorMessage_et']");
    public static final String msisdnInlineErrorCL = "Vertippt? Oder keine deutsche Mobilfunk-Nummer?";

    public static final String resendLimitNot_headerCL = "Das geht leider nicht mehr";
    public static final String resendLimitNot_textCL = "Du hast zu oft einen neuen Code angefordert. Gib bitte den letzten Code ein, den Du bekommen hast, oder versuch es später noch einmal.";


    public PYPLogin loginAction(String MSISDN, String TAN) {
        {
            (new ElementActions(driver.getDriver())).type(loginMSISDNLocator, MSISDN)
                    .click(sendTanLocator)
                    .typeSecure(loginTANLocator, TAN)
                    .click(loginButton);
        }
        return null;
    }

    public PYPLogin clickLoginButton()
    {
        new ElementActions(driver.getDriver()).click(loginButton);
        return this;
    }
    public PYPLogin clickSendTanButton()
    {
        new ElementActions(driver.getDriver()).click(sendTanLocator);
        return this;
    }

    public PYPLogin resendTan() {
        {
            (new ElementActions(driver.getDriver())).click(resendTanLocator);
        }
        return this;
    }

    public PYPLogin typeMSISDNandTAN(String MSISDN, String TAN) {
        {
            (new ElementActions(driver.getDriver())).type(loginMSISDNLocator, MSISDN)
                    .click(sendTanLocator)
                    .typeSecure(loginTANLocator, TAN);
        }
        return this;
    }

    public PYPLogin typeMSISDN(String MSISDN) {
        {
            new ElementActions(driver.getDriver()).type(loginMSISDNLocator, MSISDN);
        }
        return this;
    }




    //validation methods\\



    public void Verify_Resendpage(){



        Validations.assertThat()
                .element(driver.getDriver(), PYPLogin.resendLimitNot_header)
                .text().isEqualTo(PYPLogin.resendLimitNot_headerCL)
                .withCustomReportMessage("Check Error Msg Header")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), PYPLogin.resendLimitNot_text)
                .text().isEqualTo(PYPLogin.resendLimitNot_textCL)
                .withCustomReportMessage("Check Error Msg Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), PYPLogin.resendTanLocator)
                .isDisabled()
                .withCustomReportMessage("Check that resend button is disabled")
                .perform();
    }


}
