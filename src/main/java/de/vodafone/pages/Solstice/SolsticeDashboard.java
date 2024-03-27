package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SolsticeDashboard {

    private SHAFT.GUI.WebDriver driver;

    public static By loginIndicator = By.xpath("//h2[@ng-if='!vm.seamless']");
    private static By meinKonto_button = By.xpath("//li[@class='menu-md'][1]");
    private static By loginDaten_link = By.linkText("Login-Daten");
    private static By Übersicht_link = By.linkText("Übersicht");
    private static By MeineVerträgeUndTeilnehmer_link = By.linkText("Meine Verträge und Teilnehmer");
    private static By closeNotification_button = By.cssSelector("svg.icon-close-i-xxsml.i-xxsml");
    private static By MarieException = By.xpath("//div[@id='esim']//div[@class='overlay-content']");
    private static By PersonalBenefitsException = By.xpath("//*[@class='content-header'  and contains (., 'Lass Dir Deine persönlichen Vorteile nicht entgehen!')]");
    private static By ClosePersonalBenefitsException = By.xpath("//*[@class='btn btn-alt'  and contains (., 'Weiter ohne Einwilligung')]");
    private static By CloseMarieException = By.xpath("//div[@ng-if='canClose']//*[name()='svg']");
    public static By AcceptInvitationHeader_text = By.xpath("//*[text()='angenommen']");
    public static By AcceptInvitationTitle_text = By.xpath("//*[@class='align-super'] /p");
    public static By SolsticeMbo_Label = By.id("dashboard:sophie");
    public static By SolsticeMboHeader_text = By.xpath("(//*[@automation-id='contractDataWrappertv'])[1]");
    public static By SolsticeMboTitle_text = By.xpath("(//*[@automation-id='contractDataWrappertv'])[2]");
    public static By SolsticeProductTitle_text = By.xpath("(//*[@automation-id='productTitleContainertv'])[1]");
    private static By MyProductsAccBurgerMenu = By.xpath("");
    private static By  privacyOption  = By.xpath("");
    public static By meineKundendaten_Tile =By.xpath("(//a[@automation-id='Meine Kundendaten_btn'])[1]");

    public static String SolsticeMboHeader = "Verträge";
    public static String SolsticeMboTitle = "Alles rund um Deine Verträge: z.B. Tarife, Extras, Optionen und SIM-Karten";


    public static String AcceptInvitationHeader = "angenommen";
    public static String AcceptInvitationTitle = "Viel Spaß mit dem riesigen Streaming-Angebot von Horizon Go. Klick hier, schau Dir an, wie's geht und lad Dir noch heute die App herunter.";
    //Story 13012
    public static By OtherAdmin_link = By.xpath("//*[text()='Verwaltete Verträge']");
    public static String OtherAdmin = "Verwaltete Verträge";

    private static By SolsticeDelegatedMbo_Customer = By.xpath("(//*[@id='dashboard:sophie'])[2]");
    private static By SolsticeDelegatedMbo_Products = By.xpath("(//*[@id='dashboard:sophie'])[3]");
    public static By SolsticeDelegatedContract = By.id("dashboard:sophie");
    public static By SolsticeDelegatedMbo_Products_Name = By.xpath("(//*[@id='dashboard:sophie'])[3]");
    public static By SolsticeDelegatedMbo_Label = By.xpath("(//*[@id='dashboard:sophie'])[2]/h2/span");
    public static By SolsticeDelegatedMbo_ProductsLabel = By.xpath("(//*[@id='dashboard:sophie'])[3]/h2/span");
    public static By CustomerProductSectionHeadline = By.xpath("(//*[@automation-id='productWrappertv'])[2]/h2");
    public static By CustomerProductSectionText = By.xpath("(//*[@automation-id='productWrappertv'])[2]/p");
    public static By ProductNumber1 = By.xpath("//*[@automation-id='productBoxWrappertv']");
    public static By DelgProductSectionHeadline = By.xpath("//*[@automation-id='delegatedProducttv']/h2");
    public static By DelgProductSectionText = By.xpath("//*[@automation-id='delegatedProducttv']/p");
    public static By DelgProductNumber1 = By.xpath("//*[@automation-id='delegatedProducttv']/div/div[1]");
    public static By DelgProductNumber2 = By.xpath("//*[@automation-id='delegatedProducttv']/div/div[2]");

    public static String SolsticeDelegatedMboLabel_CL = "- wird verwaltet";
    public static String CustomerProductSectionHeadline_CL = "Verträge";
    public static String CustomerProductSectionText_CL = "Alles rund um Deine Verträge: z.B. Tarife, Extras, Optionen und SIM-Karten";
    public static String SolsticeDelegatedMbo_Products_Name_CL = "Kundenkontos";
    public static String DelgProductSectionHeadline_CL = "Verträge";
    public static String DelgProductSectionText_CL = "Die hier aufgeführten Verträge gehören zu einem Kundenkonto, zu dem Du keinen vollständigen Zugang hast. Bitte einfach den Vertragsinhaber, Dir den vollständigen Zugang zu gewähren, falls nötig.";
    public static String SolsticeDelegatedMbo_ProductsLabel_CL = "- wird verwaltet";
    public static String ExpandedByDefaultClassValue = "ac-head skiphash accordion-state ac-active";

    //WFAT-13594 Locators and CL
    public static By SolsticeMBONotificationHeadline = By.xpath("//*[@class='alert inProgress ']/div/h4/span[2]");
    public static By SolsticeMBONotificationText = By.xpath("//*[@class='alert inProgress ']/div/p/p/p");
    public static By SolsticeMBONotificationURL = By.xpath("//*[@class='alert inProgress ']/div/p/p/p/a");
    public static By SolsticeMBOTile1 = By.xpath("//*[@class='tiles cf mod mod-cta-chooser mod-eq-height']/a[1]");
    public static By SolsticeMBOTile1Title = By.xpath("//*[@class='tiles cf mod mod-cta-chooser mod-eq-height']/a[1]/div/div[2]");
    public static By SolsticeMBOTile1Subtitle = By.xpath("//*[@class='tiles cf mod mod-cta-chooser mod-eq-height']/a[1]/div/div[3]");
    public static By SolsticeMBOTile2 = By.xpath("//*[@class='tiles cf mod mod-cta-chooser mod-eq-height']/a[2]");
    public static By SolsticeMBOTile2Title = By.xpath("//*[@class='tiles cf mod mod-cta-chooser mod-eq-height']/a[2]/div/div[2]");
    public static By SolsticeMBOTile2Subtitle = By.xpath("//*[@class='tiles cf mod mod-cta-chooser mod-eq-height']/a[2]/div/div[3]");

    public static String SolsticeMBONotificationHeadlineCL = "Wichtig";
    public static String SolsticeMBONotificationTextCL = "Wir verbessern und modernisieren unsere IT Systeme – und damit auch unseren Service für Dich. Deshalb befindet sich diese Seite im Aufbau.\n" +
            "Schon gewusst? Alle wichtigen vertrags- und tarifbezogenen Infos (z.B. Kosten & Laufzeiten) findest Du auf auch Deiner Rechnung, die Du per E-Mail bekommst.\n" +
            "Du hast trotzdem noch Fragen? Dann meld Dich einfach auf www.vodafone.de/kontakt.";
    public static String SolsticeMBOTile1TitleCL = "Aktuelle Rechnung";
    public static String SolsticeMBOTile1SubtitleCL = "Noch nicht verfügbar";
    public static String SolsticeMBOTile2TitleCL = "Meine Rechnungen";
    public static String SolsticeMBOTile2SubtitleCL = "Noch nicht verfügbar";


    public SolsticeDashboard(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //methods
    public SolsticeMeineDaten openMeineKundenDatenTile(DashboardSmartObject card) {
        switch (card) {
            case MEINEKUNDENDATEN -> {
                driver.element().click(meineKundendaten_Tile);
            }
        }
        return new SolsticeMeineDaten(driver);
    }
    public enum DashboardSmartObject {
        MEINEKUNDENDATEN
    }
    @Step("Click on Burger Menu of My Products' Accordion")
    public void openBurgerMenuOfMyProductAcc() {
        driver.element().click(MyProductsAccBurgerMenu);
    }
    @Step("Validate that Datenschutz Option is Unhidden in My Products' Accordion's Burger menu")
    public void validatePrivacyOptionisUnhidden() {
        driver.assertThat().element(privacyOption).exists().perform();
    }
    @Step("Click on Privacy option from Burger Menu of My Products' Accordion")
    public void clickOnPrivacyOpeion() {
        driver.element().click(privacyOption);
    }
    public SolsticeMyAccount chooseLoginDatenFromMeinKonto() {
        driver.element().click(meinKonto_button).click(loginDaten_link);
        return new SolsticeMyAccount(driver);

    }

    public SolsticeSimilarAccountAccordion chooseOtherAdminFromMeinKonto() {
        driver.element().click(meinKonto_button).click(OtherAdmin_link);
        return new SolsticeSimilarAccountAccordion(driver);

    }

    public SolsticeDashboard handleMarieException() {
        driver.element().waitToBeReady(MarieException);
        driver.element().click( CloseMarieException);
        return this;

    }

    public SolsticeMyContractsAndParticipants chooseMeineVerträgeUndTeilnehmer() {
        driver.element().click(meinKonto_button).click(MeineVerträgeUndTeilnehmer_link);
        return new SolsticeMyContractsAndParticipants(driver);

    }

    public SolsticeSimilarAccountAccordion chooseÜbersichtFromMeinKonto() {
        driver.element().click(meinKonto_button).click(Übersicht_link);
        return new SolsticeSimilarAccountAccordion(driver);

    }

    public SolsticeDashboard clickSolsticeNotURL() {
        driver.element().click(SolsticeMBONotificationURL);
        return this;
    }

    public SolsticeDashboard closeEmailNotification() {
        driver.element().click( closeNotification_button);
        return new SolsticeDashboard(driver);

    }

    public SolsticeDashboard handlePersonalBenefitsException() {
        driver.element().waitToBeReady(PersonalBenefitsException);
        driver.element().click( ClosePersonalBenefitsException);
        return this;
    }

    public SolsticeDashboard expandSolsticeMbo() {
        driver.element().click( SolsticeMbo_Label);
        return new SolsticeDashboard(driver);

    }
    public SolsticeDashboard expandSolsticeDelegatedMbo() {
        driver.element().click( SolsticeDelegatedMbo_Customer);
        return new SolsticeDashboard(driver);
    }

    public SolsticeDashboard expandSolsticeDelegatedMbo_Products() {
        driver.element().click( SolsticeDelegatedMbo_Products);
        return new SolsticeDashboard(driver);
    }


    public void solsticeMBOValidation() {
        driver.assertThat().element(SolsticeDashboard.SolsticeMboHeader_text)
                .text().contains(SolsticeDashboard.SolsticeMboHeader)
                .withCustomReportMessage("Check that Header text exist in MBO label").perform();
        driver.assertThat().element(SolsticeDashboard.SolsticeMboTitle_text)
                .text().contains(SolsticeDashboard.SolsticeMboTitle)
                .withCustomReportMessage("Check that Header text exist in MBO label").perform();
    }
}