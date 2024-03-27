package de.vodafone.pages.TwoFA;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class BackupCodeConfirmation {


    private static SHAFT.GUI.WebDriver driver;

    public BackupCodeConfirmation(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By pageHeader = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    private By bodymsg1 = By.xpath("//div[@class='flex-disply']");
    private By bodymsg2 = By.xpath("//div[@automation-id='successMsg_tv']/p");
    private By bodymsg3 = By.xpath("//p[@class='notification-text mb-10 mt-10']/strong");
    private By copyButton = By.xpath("//a[@automation-id='copy_btn']");
    private By backButtonCTA = By.xpath("//a[@automation-id='redirectLink_Link']");

    private String pageHeader_CL = "Backup-Codes erstellen";
    private String  bodymsg1_CL = "Deine Backup-Codes wurden erfolgreich erstellt";
    private String  bodymsg2_CL = "Speicher sie oder druck sie aus. Benutz jeden Code nur 1-mal. Die Reihenfolge bestimmst Du. Nutz diese Codes, wenn Du nicht auf Dein Smartphone oder die Authentifizierungs-App zugreifen kannst.\n" +
            "Erstell Dir am besten direkt neue Codes, wenn Du nur noch 2 übrig hast.";
    private String  bodymsg3_CL = "Erstell Dir am besten direkt neue Codes, wenn Du nur noch 2 übrig hast.";

    private String  backbutton_CL = "Zurück zu Mein Konto";
    private String  copyButton_CL = "Backup-Codes kopieren";

    @Step("Verify error message for deeplink")
    public void backupValidation(){
        driver.verifyThat().element(pageHeader).text().isEqualTo(pageHeader_CL).perform();
        driver.verifyThat().element(bodymsg1).text().isEqualTo(bodymsg1_CL).perform();
        driver.verifyThat().element(bodymsg2).text().isEqualTo(bodymsg2_CL).perform();
        driver.verifyThat().element(bodymsg3).text().isEqualTo(bodymsg3_CL).perform();
        driver.verifyThat().element(copyButton).text().isEqualTo(copyButton_CL).perform();
        driver.verifyThat().element(backButtonCTA).text().isEqualTo(backbutton_CL).perform();

    }
    public BackupCodeConfirmation clickBackCTA() {
        driver.element().click(backButtonCTA);
        return this;
    }

}
