package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SolsticeSimilarAccountAccordion {

    private static SHAFT.GUI.WebDriver driver;
    private static By otherAdminAccordion = By.xpath("//*[text()='Andere Verwalter Deiner Verträge und Rufnummern']");
    public static By numberOfAdmins_text = By.xpath("//*[text()='Dieses Konto hat insgesamt:']");
    public static final String numberOfAdmins = "Dieses Konto hat insgesamt:";
    public static By numberOfAdminsValue = By.cssSelector("p.primary-grey.m-0.bold");
    public static final String zeroAdmins = "0 Verwalter:innen";
    private static By MoreDetails = By.xpath("(//*[@automation-id='otherAdminsCollapsiblePanelcollapseButtonTxt_tv'])[1]");
    public static By phoneAdminTitle = By.xpath("//*[@automation-id='contractOtherAdminsTitle_tv']");
    public static By phoneAdminDescription = By.xpath("//*[@automation-id='contractOtherAdminsDesc_tv']");
    public static final String Title = "Andere Verwalter:innen";
    public static final String Description = "Hier kannst Du den Zugriff der anderen Verwalter:innen auf Dein Konto entfernen. Oder das Konto mit anderen zusammenlegen. Diese Verwalter:innen haben Zugriff auf all Deine Dienste:";
    public static By inviteButton_Buttton = By.xpath("//*[@automation-id='unityMediaInvitees_btn']");
    public static final String inviteButton = "Weitere Person einladen";
    public static By UMtitle_text = By.xpath("//*[text()='Einladungen angenommen :']");
    public static final String UMTitle = "Einladungen angenommen :";
    public static By uMMoreDetails = By.xpath("//*[@id=\"similarAccountsId\"]/similar-accounts-list/form/ol-contract-other-admin/div/collapsible-panel[1]/div/div[2]/div/span/strong");
    public static By UMMoretitle_text = By.xpath("//*[text()='Teile Deinen Horizon Go-Vertrag']");
    public static final String UMMoreTitle = "Teile Deinen Horizon Go-Vertrag";
    public static By personEinladenForContract = By.xpath("(//*[@automation-id='addDelegate_btn'])[1]");
    public static By personEinladenForProduct = By.xpath("(//*[@automation-id='addDelegate_btn'])[2]");
    //Story 12208
    public static By ausladen_button = By.xpath("(//*[@automation-id='unityMediaInviteesEditAccess_btn'])[1]");




    public SolsticeSimilarAccountAccordion(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public SolsticeSimilarAccountAccordion chooseOtherAdminAccordion() {
        driver.element().click( otherAdminAccordion);
        return new SolsticeSimilarAccountAccordion(driver);
    }
    public SolsticePersonEinladen clickOnPersonEinladenForContract() {
        driver.element().click( personEinladenForContract);
        return new SolsticePersonEinladen(driver);
    }
    public SolsticePersonEinladen clickOnPersonEinladenForProduct() {
        driver.element().click( personEinladenForProduct);
        return new SolsticePersonEinladen(driver);
    }

        
    public SolsticeSimilarAccountAccordion clickOnMoreDetails() {
        driver.element().click( MoreDetails);
        return new SolsticeSimilarAccountAccordion(driver);

    }
    public void clickOnMoreForUM() {
        driver.element().click( uMMoreDetails);
    }
    public SolsticeAusladen clickOnAusladenButton() {
        driver.element().click( ausladen_button);
        return new SolsticeAusladen(driver);
    }


}
