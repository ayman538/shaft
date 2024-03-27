package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class InvalidToken {


    // Variables
    private SHAFT.GUI.WebDriver driver;
    public static By invalidLink_text = By.xpath("//*[text()='Ungültiger Link']");
    public static By invalidLinkDescription_text = By.xpath("//*[text()='Der Link ist üngültig oder abgelaufen. Fordere bitte einen neuen an.']");

    public static String invalidLink = "Ungültiger Link";
    public static String invalidLinkDescription = "Der Link ist üngültig oder abgelaufen. Fordere bitte einen neuen an.";


    //constructor
    public InvalidToken (SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


}
