package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SolsticePhoneNumberConfirmation {
    private  SHAFT.GUI.WebDriver driver;
    public static By notificationTitle_text = By.xpath("//*[text()='Geschafft!']");
    public static By notificationDescription_text = By.xpath("//*[text()='Deine neue Rufnummer für den SMS-Code gilt ab sofort.']");
    public static By headerTitle_text = By.cssSelector("h3[automation-id=accordionHeading_tv]");
    public static By smsCodeRufnummer = By.cssSelector("p[automation-id='accordionSummaryNumber_tv']");
    public static By hauptrufnummer = By.cssSelector("p[automation-id='accordionSummaryNumber2Heading_tv']");
    public static final String confirmationNotificationTitle = "Geschafft!";
    public static final String confirmationNotificationDescription = "Deine neue Rufnummer für den SMS-Code gilt ab sofort.";
    public static final String confirmationHeaderTitle = "Das hast Du geändert:";


    public SolsticePhoneNumberConfirmation(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
}
