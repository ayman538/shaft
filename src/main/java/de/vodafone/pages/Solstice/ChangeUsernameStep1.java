package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class ChangeUsernameStep1 {
    private SHAFT.GUI.WebDriver driver;

    //public static By CUStep1PageHeadline = By.xpath("//*[@automation-id='pageHeader_tv']//h1");
    public static By CUStep1PageHeadline =By.xpath("//*[text()='Benutzernamen ändern']");
    public static final String CUStep1PageHeadlineCL = "Benutzernamen ändern";

    public static By CUStep1Header = By.xpath("//*[@automation-id='step1_containertv']//a//div[2]");
    public static final String CUStep1HeaderCL = "Neuen Benutzernamen wählen";

    public static By CUStep2Header = By.xpath("//*[@automation-id='step2_containertv']//a//div[2]");
    public static final String CUStep2HeaderCL = "Neuen Benutzernamen bestätigen";

    public static By CUStep1Text = By.xpath("//*[@automation-id='change-user-name-text_tv']");
    public static final String CUStep1TextCL = "Nimm bitte als Benutzernamen Deine E-Mail-Adresse. Sie ist künftig auch Deine Kontakt-E-Mail-Adresse.";

    public static By CUStep1ExistingUN = By.xpath("//*[@automation-id='user-email-header_tv']");
    public static final String CUStep1ExistingUNCL = "Aktueller Benutzername:";

    public static By CUStep1InputFieldHeader = By.xpath("//*[@validationid='emailAddress']//div//text//div//div//label");
    public static final String CUStep1InputFieldHeaderCL = "Gib den neuen Benutzernamen ein *";

    public static By CUStep1Text2 = By.xpath("//*[@automation-id='captcha-title_tv']");
    public static final String CUStep1Text2CL = "Zum Schutz Deiner Benutzerdaten benötigen wir für den Login die Eingabe des unten gezeigten Sicherheitscodes.";

    public static By CUStep1CaptchaHeader = By.xpath("//*[@id='captchaField']//div//text//div//div//label");
    public static final String CUStep1CaptchaHeaderCL = "Sicherheitscode *";

    public static By CUStep1Checkbox1 = By.xpath("//*[@formcontrolname='recoveryEmail']");
    public static final String CUStep1Checkbox1CL = "Diese E-Mail-Adresse zum Passwort zurücksetzen nutzen";

    public static By CUStep1Checkbox2 = By.xpath("//*[@formcontrolname='solsticeBilling']");
    public static final String CUStep1Checkbox2CL = "An diese E-Mail-Adresse Rechnungsbenachrichtigungen senden";

    public static By Pflichtfelder = By.xpath("//*[@automation-id='requiredLabeldxl_tv']");
    public static final String PflichtfelderCL = "* Pflichtfelder";

    public static By SubmitButton = By.xpath("//*[@automation-id='changeUsernamedxl_btn']");
    public static final String SubmitButtonCL = "Bestätigen";

//    public static By InfoIcon = By.xpath("");
//    public static By InfoIconNot = By.xpath("");
//    public static final String InfoIconNotCL = "Wir schicken Dir eine Bestätigungs-E-Mail an diese Adresse.\n" +
//            "Wichtig: Nimm keine Vodafone-E-Mail-Adresse. Sonst bekommst Du kein neues Passwort, falls Du Deins mal vergisst.";

    private static By Username_inputfield = By.xpath("//*[@automation-id='emailField_et']");
    private static By Captcha_inputfield = By.xpath("//*[@automation-id='captchaField_et']");


    public ChangeUsernameStep1(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public ChangeUsernameStep1 typeUsername() {
        (new ElementActions(driver.getDriver())).type(Username_inputfield, "user_name@vodafone.com");
        return this;
    }

    public ChangeUsernameStep1 typeCaptcha() {
        (new ElementActions(driver.getDriver())).type(Captcha_inputfield, "12345");
        return this;
    }

    public ChangeUsernameStep1 selectCheckbox1() {
        (new ElementActions(driver.getDriver())).click(By.xpath("(//*[@automation-id='checkboxItemModel.id_container_tv'])[1]"));

        return this;
    }

    public ChangeUsernameStep1 selectCheckbox2() {
        (new ElementActions(driver.getDriver())).click(By.xpath("(//*[@automation-id='checkboxItemModel.id_container_tv'])[2]"));
        return this;
    }
    //    public ChangeUsernameStep1 clickInfoIcon() {
//        (new ElementActions(driver.getDriver())).click(InfoIcon);
//        return this;
//    }
    public ChangeUsernameStep1 submit() {
        (new ElementActions(driver.getDriver())).click(SubmitButton);
        return this;
    }


}
