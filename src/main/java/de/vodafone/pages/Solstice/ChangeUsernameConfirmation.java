package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class ChangeUsernameConfirmation {
    private SHAFT.GUI.WebDriver driver;

    public static By CUConfPageHeadline = By.xpath("//*[@automation-id='pageHeader_tv']//h1");
    public static final String CUConfPageHeadlineCL = "Benutzernamen ändern";

    public static By CUConfNotHeadline = By.xpath("//*[@class='flexDiv']");
    public static final String CUConfNotHeadlineCL = "Geschafft!";

    public static By CUConfNotText = By.xpath("//*[@class='notification-text mb-10 mt-10']");
    public static final String CUConfNotTextCL = "Deinen neuen Benutzernamen haben wir gespeichert.";
    public static final String CUConfNotTextCL2 = "Deinen neuen Benutzernamen haben wir gespeichert. Die Details findest Du in der Übersicht.";

    public static By CUConfSummaryHeader = By.xpath("//*[@class='ac-head ac-active']");
    public static final String CUConfSummaryHeaderCL = "Übersicht";

    public static By CUConfSummaryHeadline = By.xpath("//*[@automation-id='dataChangedHeader_tv']");
    public static final String CUConfSummaryHeadlineCL = "Du hast diese Daten geändert";

    public static By CUConfSummaryUN = By.xpath("//*[@automation-id='userName_tv']//strong");
    public static final String CUConfSummaryUNCL = "Benutzername:";

    public static By CUConfSummaryRP = By.xpath("//*[@automation-id='recoveryEmail_tv']//strong");
    public static final String CUConfSummaryRPCL = "E-Mail-Adresse zum Passwort zurücksetzen:";

    public static By CUConfSummaryBN = By.xpath("//*[@automation-id='billingAddress_tv']//strong");
    public static final String CUConfSummaryBNCL = "E-Mail-Adresse für die Rechnungsbenachrichtigung";

    public static By CUConfSummaryUNValue = By.xpath("");
    public static By CUConfSummaryRPValue = By.xpath("");
    public static By CUConfSummaryBNValue = By.xpath("//*[@automation-id='billingError_tv']");

    public static final String CUConfSummaryNoUpdateCL = "Kann gerade nicht angezeigt werden.";

    public static By BackButton = By.xpath("//*[@automation-id='back_Link']");
    public static final String BackButtonCL = "Zurück";


    public ChangeUsernameConfirmation(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public SolsticeMyAccount clickBackButton() {
        (new ElementActions(driver.getDriver())).click(BackButton);
        return new SolsticeMyAccount(driver);
    }

}
