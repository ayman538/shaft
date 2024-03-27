package de.vodafone.pages.TwoFA;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TwoFAStep1 {

    private static SHAFT.GUI.WebDriver driver;

    public TwoFAStep1(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By pageHeader = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    private By stepperTitle = By.xpath("//div[@class='header-title']");
    private By passwordMsg = By.xpath("//p[@automation-id='activationFlow2faIntro_tv']");
    private By passwordLabel = By.xpath("(//div[@class='tg-label'])[1]");
    private By passwordFiled = By.xpath("(//input[@id='twoFaPasswordField'])");
    private By passwordEmptymsg = By.xpath("//p[@automation-id='twoFaPasswordFieldrequiredErrorMessage_et']");
    private By passwordRGXmsg1 = By.xpath("//div[@automation-id='successMsg_tv']/div[1]");
    private By passwordRGXmsg2 = By.xpath("//div[@automation-id='successMsg_tv']/p");
    private By confirmButton = By.xpath("(//button[@automation-id='submitAuthenticate_btn'])");


    private String PageHeader_CL = "2-Faktor-Authentifizierung aktivieren";
    private String stepperTitle_CL = "Passwort eingeben";
    private String Passwordmsg_CL = "Gib hier aus Sicherheitsgründen nochmal Dein Internet-Passwort ein.";
    private String Passwordlabel_CL = "Internet-Passwort *";
    private String Passwordemptyerror_CL = "Gib bitte Dein Internet-Passwort ein.";
    private String PasswordRGXmsg1_CL ="Hier stimmt was nicht";
    private String PasswordRGXmsg2_CL ="Du hast Dein Internet-Passwort falsch eingegeben. Versuch es bitte nochmal.";

    private String confirmButton_CL = "Bestätigen";


    @Step("Verify 2FA step1 page")
    public void twoFAActivationS1Validation() {
        driver.verifyThat().element(pageHeader).text().isEqualTo(PageHeader_CL).perform();
        driver.verifyThat().element(stepperTitle).text().isEqualTo(stepperTitle_CL).perform();
        driver.verifyThat().element(passwordMsg).text().isEqualTo(Passwordmsg_CL).perform();
        driver.verifyThat().element(passwordLabel).text().isEqualTo(Passwordlabel_CL).perform();
        driver.verifyThat().element(confirmButton).text().isEqualTo(confirmButton_CL).perform();
    }

    @Step("Verify Error msg when password field is empty")
    public void emptypasswordValidation() {
        driver.element().keyPress(passwordFiled, Keys.TAB);
        driver.verifyThat().element(passwordEmptymsg).text().isEqualTo(Passwordemptyerror_CL).perform();

    }
    @Step("Verify Error msg when user insert wrong RGX is empty")
    public void regexValidation() {
        driver.verifyThat().element(passwordRGXmsg1).text().isEqualTo(PasswordRGXmsg1_CL).perform();
        driver.verifyThat().element(passwordRGXmsg2).text().isEqualTo(PasswordRGXmsg2_CL).perform();

    }
    public TwoFAStep1 insertPassword(String password) {
        driver.element().type(passwordFiled, password);
        return this;
    }
    public TwoFAStep1 clickConfirm() {
        driver.element().click(confirmButton);
        return this;
    }
}
