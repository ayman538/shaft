package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class ChangePassword {

    private SHAFT.GUI.WebDriver driver;
    public static String URL = "/meinvodafone/account/verwaltung/passwort_aendern";
    public static String PageHeaderTxt = "Internet Passwort ändern";
    public static String OldPasswordTxt = "TEST@1234";

    public static String NewPasswordTxt = "Test@4321";

    public static String OldPasswordTxt_SIT = NewPasswordTxt;
    public static String NewPasswordTxt_SIT = OldPasswordTxt;

    public static By PageHeader = By.xpath("//*[@automation-id='pageHeader_tv']");
    public static By OldPassword = By.xpath("//*[@automation-id='old_password_et']");
    public static By NewPassword = By.xpath("//*[@automation-id='new_password_et']");
    public static By RepeatPassword = By.xpath("//*[@automation-id='repeat_password_et']");
    public static By SubmitNewPassword = By.xpath("//*[@automation-id='submitNewPassword_btn']");

    public String ChangePasswordURL = "https://opweb3.vfd2-testnet.de/meinvodafone/account/verwaltung/passwort_aendern";


    public ChangePassword(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    public ChangePassword fillOldPassword(String password) {
        (new ElementActions(driver.getDriver())).type(OldPassword, password);
        return this;
    }

    public ChangePassword fillNewPassword(String newpassword) {
        (new ElementActions(driver.getDriver())).type(NewPassword, newpassword);
        return this;
    }

    public ChangePassword repeatPassword(String repeatpassword) {
        (new ElementActions(driver.getDriver())).type(RepeatPassword, repeatpassword);
        return this;
    }

    public ChangePassword submitNewPassword(){
        new ElementActions(driver.getDriver()).click(SubmitNewPassword);
        return this;
    }

    public ChangePassword navigateChangePassword(){
     driver.browser().navigateToURL( ChangePasswordURL);
        return this;
    }

}
