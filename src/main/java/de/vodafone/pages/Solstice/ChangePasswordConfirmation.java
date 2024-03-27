package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ChangePasswordConfirmation {

    private SHAFT.GUI.WebDriver driver;

    public static By ConfirmationMsgHeader = By.xpath("//*[@class='flexDiv'  and contains (., 'Vielen Dank!')]");
    public static By ConfirmationMsgBody = By.xpath("//*[@class='notification-text mb-10 mt-10'  and contains (., 'Dein Internet-Passwort wurde geändert und gilt ab sofort.')]");
    public  static String ConfirmationMsgHeaderTXT = "Vielen Dank!";

    public static String ConfirmationMsgBodyTXT = "Dein Internet-Passwort wurde geändert und gilt ab sofort.";



    public ChangePasswordConfirmation(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


}
