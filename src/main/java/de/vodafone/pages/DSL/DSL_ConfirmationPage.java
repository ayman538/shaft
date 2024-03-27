package de.vodafone.pages.DSL;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DSL_ConfirmationPage {
    private static SHAFT.GUI.WebDriver driver;
    public DSL_ConfirmationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public static By CancelationNotification = By.xpath("//*[@automation-id='confirm-cancel-dsl-extra_nt']");
    public static By OverviewAccordionLocator = By.xpath("(//*[@automation-id='accordion0_acc'])");
    public static By BookedExtraTitleLocator = By.xpath("(//*[@class='tariff-card-header'])//span");
    public static By BookedExtraPriceLocator = By.xpath("(//*[@class='tariffPrice'])");
    public static By BookedExtraDescriptionLocator = By.xpath("(//*[@class='short-description'])//p");
    public static By SuccessHeaderLocator = By.xpath("(//*[@automation-id='successNotification_nt']//h4)");
    public static By SuccessTextLocator = By.xpath("(//*[@automation-id='successNotification_nt']//p)");
    public static By SuccessOverviewAccordionLocator = By.xpath("(//*[@id='confirmEntriesData'])//a");

    public static By PersonalDataHeaderLabelLocator = By.xpath("(//*[@class='white-box']//h3)[1]");
    public static By FirstNameLabelLocator = By.xpath("//*[text()='Vorname']");
    public static By FirstNameValLocator = By.xpath("//*[text()='Vorname']/following-sibling::p");
    public static By LastNameLabelLocator = By.xpath("//*[text()='Nachname']");
    public static By LastNameValLocator = By.xpath("//*[text()='Nachname']/following-sibling::p");
    public static By PhoneNumberLabLoctor = By.xpath("//*[text()='Telefonnummer für Rückfragen']");
    public static By PhoneNumberValLocator = By.xpath("//*[text()='Telefonnummer für Rückfragen']/following-sibling::p");
    public static By PhonebookEntryHeaderLabelLocator = By.xpath("(//*[@class='white-box']//h3)[2]");
    public static By PhoneNumberLabLocator = By.xpath("//*[text()='1. Rufnummer']");
    public static By PhoneNumberValueLocator = By.xpath("//*[text()='1. Rufnummer']/following-sibling::p");
    public static By EntryTypeLabLocator = By.xpath("//*[text()='Eintragsart']");
    public static By EntryTypeValLocator = By.xpath("//*[text()='Eintragsart']/following-sibling::p");
    public static By TypeOfInfoLabLocator = By.xpath("//*[text()='Auskunftsart']");
    public static By TypeOfInfoValLocator = By.xpath("//*[text()='Auskunftsart']/following-sibling::p");
    public static By ConflictErrorMessageLocator = By.xpath("//*[@automation-id='undefined_nt']");
    public static String confMsg = "Fast geschafft!\n" +
            "Wir haben Dir Deine Vertragszusammenfassung an die folgende E-Mail-Adresse geschickt:\n" +
            "mgagnot@web.de\n" +
            "\n" +
            "Klick bitte auf den Button in der E-Mail, um Deine Angaben zu bestätigen. Dann wird die Kündigung Deiner Option bald wirksam sein. Keine E-Mail bekommen? Schau doch mal im Spam-Ordner nach. Wichtig: Ohne Deine Bestätigung ändern wir nichts!\n" +
            "\n" +
            "Warum ist Deine Bestätigung nötig?\n" +
            "Du kannst Dir in der E-Mail nochmal alles in Ruhe durchlesen. So hast Du mehr Sicherheit für Deine Entscheidung, wie es in der neuen EU-Richtlinie zum European Electronic Communication Code (EECC) vorgesehen ist.";

    public static String SuccessHeaderCL = "Geschafft!";
    public static String SuccessTextCL  = "Es kann etwas dauern, bis Dein Auftrag umgesetzt wird. Hab bitte etwas Geduld und stell den Auftrag nicht nochmal.";
    public static String SuccessOverviewAccordionCL  = "Übersicht";

    public static String PersonalDataHeaderLabelCL = ("Persönliche Daten");
    public static String FirstNameLabelCL = ("Vorname");
    public static String LastNameLabelCL = ("Nachname");
    public static String PhoneNumberLabelCL = ("Telefonnummer für Rückfragen");
    public static String PhonebookEntryHeaderLabelCL = ("Telefonbucheinträge");
    public static String PhoneNumberLabCL = ("1. Rufnummer");
    public static String EntryTypeLabCL = ("Eintragsart");
    public static String TypeOfInfoLabCL = ("Auskunftsart");
    public static String ConflictErrorMessageCL = "Das geht leider nicht\n" +
            "Du hast aktuell eine Option gebucht, die mit der Option, die Du gerade neu hinzufügen möchtest, nicht kompatibel ist. Bitte kündige erst die alte und buche dann die neue nochmal.\n" +
            "Wichtig: Die Kündigung muss erst vollständig abgeschlossen sein. Das dauert in der Regel 24 Stunden.";
    private final Duration PT60S = Duration.ofSeconds(60);

    public DSL_ConfirmationPage expandOverviewAccordion(By locator)
    {
        driver.element().click( locator);
        return this;
    }

    public String getConfText(By locator){
        String text = driver.element().getText(locator);
        return text;
    }
    public DSL_ConfirmationPage click(By Element){
        WebElement element = driver.getDriver().findElement(Element);
        ((JavascriptExecutor) driver.getDriver()).executeScript("arguments[0].click();", element);
        return this;
    }
    public DSL_ConfirmationPage waitUntilErrorMsg(){
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), PT60S);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ConflictErrorMessageLocator));
        return this;
    }

}


