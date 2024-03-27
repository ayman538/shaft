package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class ChangeUsernameStep2 {
    private SHAFT.GUI.WebDriver driver;

    public static By CUStep2PageHeadline = By.xpath("//*[@automation-id='pageHeader_tv']//h1");
    public static final String CUStep2PageHeadlineCL = "Benutzernamen ändern";

    public static By CUStep1Header = By.xpath("//*[@automation-id='step1_containertv']//a//div[2]");
    public static final String CUStep1HeaderCL = "Neuen Benutzernamen wählen";

    public static By CUStep2Header = By.xpath("//*[@automation-id='step2_containertv']//a//div[2]");
    public static final String CUStep2HeaderCL = "Neuen Benutzernamen bestätigen";

    public static By CUStep2NotHeadline = By.xpath("//*[@class='alert noselect info']//div[2]//div//div[2]");
    public static final String CUStep2NotHeadlineCL = "Bestätige Deinen neuen Benutzernamen";

    public static By CUStep2NotText = By.xpath("//*[@class='alert noselect info']//div[2]//p");
    public static final String CUStep2NotTextCL = "Wir haben Dir einen Code an user_name@vodafone.com geschickt. Gib diesen Code unten ein.";

    public static By CUStep2TextBoxTitle = By.xpath("//*[@formcontrolnamelabel='tan']//div//div//label");
    public static final String CUStep2TextBoxTitleCL = "Code eingeben *";

    public static By Pflichtfelder = By.xpath("//*[@automation-id='requiredLabel_tv']");
    public static final String PflichtfelderCL = "* Pflichtfelder";

    public static By ResendTanCodeEmailButton = By.xpath("//*[@automation-id='resendTan_btn']");
    public static final String ResendTanCodeEmailButtonCL = "Neuen Code anfordern";

    public static By SubmitTanCodeButton = By.xpath("//*[@automation-id='submitTan_btn']");
    public static final String SubmitTanCodeButtonCL = "Neuen Benutzernamen bestätigen";

    private static By TanCode_inputfield = By.xpath("//*[@automation-id='tan_et']");


    public ChangeUsernameStep2(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public ChangeUsernameStep2 typeTanCode() {
        (new ElementActions(driver.getDriver())).type(TanCode_inputfield, "123456");
        return this;
    }

    public ChangeUsernameStep2 resendTanCodeEmail() {
        (new ElementActions(driver.getDriver())).click(ResendTanCodeEmailButton);
        return this;
    }

    public ChangeUsernameConfirmation submitTanCode() {
        (new ElementActions(driver.getDriver())).click(SubmitTanCodeButton);
        return new ChangeUsernameConfirmation(driver);
    }
}
