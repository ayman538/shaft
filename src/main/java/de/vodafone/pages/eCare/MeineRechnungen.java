package de.vodafone.pages.eCare;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MeineRechnungen {
    //Variables
    private SHAFT.GUI.WebDriver driver;
    private String aktuelleRechnungBtn_Link = "https://webbill.vodafone.de/vf/startEBPP.wb?aim=statement";
    private String quickCheckBtn_Link = "http://dsl.vodafone.de/meindsl/webbill.html?uoi=10010005567725";
    private String rechnungDruckenBtn_Link = "https://webbill.vodafone.de/vf/startEBPP.wb?aim=statement";
    private String alleDokumenteBtn_Link = "notifizierung/dokumente";
    private String weiterBtn_Link = "https://dsl.vodafone.de/meindsl/webbill.html";
    private By overLayHeader_txt = By.xpath("//div[@class='overlay']//div[2]//h1");
    private By overLayContent_txt = By.xpath("//div[@class='overlay']//div[2]/p");

    //Locators
    private By smartObjectsCommon_Locator = By.xpath("//smart-object-wrapper");
    private By rechnungsadresseAndernLink_Locator = By.xpath("(//a[@class='ac-head anchor'])[1]");
    private By bankverbindungAndernLink_Locator = By.xpath("(//a[@class='ac-head anchor'])[2]");
    private By dokumenteLink_Locator = By.xpath("(//a[@class='ac-head anchor'])[3]");
    private By rechnungenSubersichtAccordion_Locator = By.xpath("//li[@automation-id='rechnungsubersicht_acc']");
    private By jahreSubersichtAccordion_Locator = By.xpath("//li[@automation-id='jahresubersicht_acc']");
    private By kontostandLabel_Locator = By.xpath("(//div[@class='invoice-history']//h3)[1]");
    private By aktuelleRechnungenLabel_Locator = By.xpath("(//div[@class='invoice-history']//h3)[2]");
    private By quickCheckLabel_Locator = By.xpath("(//div[@class='invoice-history']//h3)[3]");
    private By actuelleRechnungenBtn_Locator = By.xpath("//a[contains(.,' Deine Rechnung als PDF drucken/herunterladen ')]");
    private By quickCheckBtn_Locator = By.xpath("//a[contains(.,' Zur Verbindungsanalyse')]");
    private By emailAnderenBtn_Locator = By.xpath("//button[contains(.,'E-Mail-Adresse ändern')]");
    private By rechnungsDigrmamTitle_Locator = By.xpath("//collapsible-content/div/div/h3/span");
    private By rechnungenTableTitle_Locaotr = By.xpath("//h3[@class='mt-30']");
    private By alleDokumenteNotificationTitle_Locator = By.xpath("//div[@class='item-2 w-100']//h4");
    private By alleDokumenteNotificationDescription_Locator = By.xpath("(//div[@class='alert-content']//p)[1]");
    private By weitereAnalyseTitle_Locator = By.xpath("//div[@class='white-box mb-15']//h4");
    private By firstRechnungDruckenBtn_Locator = By.xpath("(//a[contains(.,' Rechnung drucken')])[1]");
    private By alleDokumenteBtn_Locator = By.xpath("//button[@automation-id='undefined_btn']");
    private By weiterBtn_Locator = By.xpath("//a[contains(.,'Weiter')]");
    private By bankverbingungPageTitle_Locator = By.xpath("//h1[contains(.,'Bankverbindung bearbeiten')]");
    private By dokumentePageTile_Locator = By.xpath("//h1[contains(.,'Mitteilungen')]");
    private By adressenAccordion_Locator = By.xpath("//li[@automation-id='adressen_acc']/a");
    private By emailAnderenPageTitle_Locator = By.xpath("//h1[contains(.,'E-Mail-Benachrichtigung einstellen')]");
    private By diagram_Locator = By.xpath("//collapsible-content/div");
    private By diagramDescription_Locator = By.xpath("//h4[@class='periodText']");
    private By diagramCollapseIcon_Locator = By.xpath("//div[@class='collapse-icons-container fr']");
    private By contractChooserMartin = By.xpath("//div[@class='stepper-header clickable'][contains(.,'Martin')]\n");
    private By notificationContent_txt = By.xpath("(//div[@class='alert warning ']//p)[1]");
    private By notificationHeader_txt = By.xpath("(//div[@class='alert warning ']//h4)[1]");
    private By loader_img = By.xpath("//div[@class='loader']");
    private By pageHeader = By.xpath("//div[@automation-id='pageHeader_tv']");

    //Methods
    public MeineRechnungen(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    @Step("Navigate to Mein Rechnungen on ST")
    public MeineRechnungen deepLinkRechnungenST() {
        driver.browser().navigateToURL(System.getProperty("de.vodafone.baseUrl.st.rechnungen"));
        driver.element().waitToBeInvisible(loader_img);
        return this;
    }

    @Step("Collapse the diagram")
    public void collapseDiagram(){
        driver.element().click(diagramCollapseIcon_Locator);
    }

    @Step("Get smart objects number")
    public String getSmartObjectsNumber() {
        return Integer.toString(driver.element().getElementsCount(smartObjectsCommon_Locator));
    }

    @Step("Click on rechnungsadresse link")
    public void clickOnRechnungsAdresseLink() {
        driver.element().click(rechnungsadresseAndernLink_Locator);
    }

    @Step("Click on bankverbindung link")
    public void clickOnBankVerbindungLink() {
        driver.element().click(bankverbindungAndernLink_Locator);
    }

    @Step("Click on dokumente link")
    public void clickOnDokumenteLink() {
        driver.element().click(dokumenteLink_Locator);
    }

    @Step("Navigate to meine rechnungen page")
    public void navigateToMeineRechnungenPage(){
        driver.browser().navigateToURL(System.getProperty("de.vodafone.baseUrl.sit")+"meinvodafone/services/meinerechnung");
    }

    @Step("Expand RechnungenSubersicht accordion")
    public void expandRechnungeSubersichtAccordion(){
        driver.element().click(rechnungenSubersichtAccordion_Locator);
    }

    @Step("Expand JahreSubersicht accordion")
    public void expandJahreSubersichtAccordion(){
        driver.element().click(jahreSubersichtAccordion_Locator);
    }

    @Step("Click on e-mail anderen button")
    public void clickOnEmailAnderenBtn(){
        driver.element().click(emailAnderenBtn_Locator);
    }

    @Step("Click on alle dokumente button")
    public void clickOnAlleDokumenteBtn(){
        driver.element().click(alleDokumenteBtn_Locator);
    }

    @Step("Expand Martin accordion from contract chooser")
    public MeineRechnungen expandMartinContractChooser(){
        driver.element().verifyThat(loader_img).isHidden();
        driver.element().click(contractChooserMartin);
        return this;
    }
    //CLs
    private String diagramDescription_CL = "Rechnungsbeträge der letzten 6 Monate";
    private String alleDocumentNotificationDescription_CL = "Hier findest Du Deinen Vertrag, Deine Rechnungen und unsere Post an Dich.";
    private String kontostand_CL = "Kontostand";
    private String aktuelleRechnung_CL = "Aktuelle Rechnung";
    private String quickCheck_CL = "QuickCheck";
    private String rechnungsDiagramm_CL = "Rechnungsdiagramm";
    private String rechnungTableTitle_CL = "Rechnungen der letzten 13 Monate";
    private String alleDokumenteNotificationTitle_CL = "Alle Dokumente";
    private String weitereAnalyseTitle_CL = "Weitere Analyse- und Einstellungsmöglichkeiten";

    //Validations
    public void assertOnDiagramCollapseFunction(){
        driver.verifyThat().element(diagram_Locator).attribute("class").isEqualTo("white-box collapsible-content mb-15").withCustomReportMessage("Assert that diagram is collapsed").perform();
    }
    public void assertOnDiagramDescription(){
        driver.verifyThat().element(diagramDescription_Locator).text().contains(diagramDescription_CL).withCustomReportMessage("Assert on diagram description text").perform();
    }
    public void assertOnSmartObjectsNumber(String num) {
        Validations.verifyThat().object(getSmartObjectsNumber()).isEqualTo(num).withCustomReportMessage("assert that smart objects number = " + num).perform();
    }


    @Step("Assert that the adressen accordion is expanded")
    public void assertThatUserNavigatedToAdressenAccordion(){
        driver.verifyThat().element(adressenAccordion_Locator).attribute("class").isEqualTo("ac-head ac-active").perform();
    }

    @Step("Assert that user navigated to bankverbindug page")
    public void assertThatUserNavigatedToBankVerbindungPage(){
        driver.verifyThat().element(bankverbingungPageTitle_Locator).exists().perform();
    }

    @Step("Assert that user navigated to dokumente page")
    public void assertThatUserNavigatedToDokumentePage(){
        driver.verifyThat().element(dokumentePageTile_Locator).exists().perform();
    }

    @Step("Assert that kontostand section exists")
    public void assertThatKontostandSectionExists(){
        driver.verifyThat().element(kontostandLabel_Locator).text().contains(kontostand_CL).perform();
    }

    @Step("Assert that Aktuelle rechnungen section exists")
    public void assertThatAktuelleRechnungenSectionExists(){
        driver.verifyThat().element(aktuelleRechnungenLabel_Locator).text().contains(aktuelleRechnung_CL).perform();
    }

    @Step("Assert that Quick check section exists")
    public void assertThatQuickCheckSectionExists(){
       driver.verifyThat().element(quickCheckLabel_Locator).text().contains(quickCheck_CL).perform();
    }

    @Step("Assert on aktuelle rechnungen button navigation")
    public void assertOnActuelleRechnungenBtnNavigation(){
        driver.verifyThat().element(actuelleRechnungenBtn_Locator).attribute("href").isEqualTo(aktuelleRechnungBtn_Link).perform();
    }

    @Step("Assert on quick check button navigation")
    public void assertOnQuickCheckBtnNavigation(){
        driver.verifyThat().element(quickCheckBtn_Locator).attribute("href").isEqualTo(quickCheckBtn_Link).perform();
    }


    @Step("Assert on e-mail anderen button navigation")
    public void assertOnEmailAnderenBtnNavigation(){
       driver.verifyThat().element(emailAnderenPageTitle_Locator).exists().perform();
    }

    @Step(" Assert on rechnung diagram title")
    public void assertOnRechnungDiagramTitle(){
      driver.verifyThat().element(rechnungsDigrmamTitle_Locator).text().contains(rechnungsDiagramm_CL).perform();
    }


    @Step("Assert on rechnung table title")
    public void assertOnRechnungTableTitle(){
       driver.verifyThat().element(rechnungenTableTitle_Locaotr).text().contains(rechnungTableTitle_CL).perform();
    }

    @Step("Assert on alle dokumente notification title")
    public void assertOnAlleDokumenteNotificationTitle(){
        driver.verifyThat().element(alleDokumenteNotificationTitle_Locator).text().contains(alleDokumenteNotificationTitle_CL).perform();
    }

    @Step("Assert on alle dokumente notification description")
    public void assertOnAlleDokumenteNotificationDescription(){
        driver.verifyThat().element(alleDokumenteNotificationDescription_Locator).text().contains(alleDocumentNotificationDescription_CL).perform();
    }

    @Step("Assert on weitere analyse title locator")
    public void assertOnWeitereAnalyseTitle(){
       driver.verifyThat().element(weitereAnalyseTitle_Locator).text().contains(weitereAnalyseTitle_CL).perform();
    }

    @Step("Assert on rechnung drucken button navigation")
    public void assertOnRechnungDruckenBtnNavigation(){
       driver.verifyThat().element(firstRechnungDruckenBtn_Locator).attribute("href").isEqualTo(rechnungDruckenBtn_Link).perform();
    }

    @Step("Assert on alle dokumente button navigation")
    public void assertOnAlleDokumenteBtnNavigation(){
        Object[] tabs = driver.getDriver().getWindowHandles().toArray();
        driver.browser().switchToWindow(tabs[1].toString());
        driver.verifyThat().browser().url().contains(alleDokumenteBtn_Link).perform();
    }

    @Step("Assert on Weiter button navigation")
    public void assertOnWeiterBtnNavigation(){
        driver.verifyThat().element(weiterBtn_Locator).attribute("href").isEqualTo(weiterBtn_Link).perform();
    }
    @Step("Assert Meine Rechnungen title")
    public MeineRechnungen assertPageTitle(){
        driver.verifyThat().element(pageHeader).exists().perform();
        return this;
    }
    @Step("Assert on alle dokumente button navigation")
    public MeineRechnungen validateNoNotificationOrOverlayOnAccordion() {
        driver.verifyThat()
                .element(overLayHeader_txt)
                .doesNotExist()
                .perform();
        driver.verifyThat()
                .element(overLayContent_txt)
                .doesNotExist()
                .perform();
        driver.verifyThat()
                .element(overLayHeader_txt)
                .doesNotExist()
                .perform();
        driver.verifyThat()
                .element(overLayContent_txt)
                .doesNotExist()
                .perform();
        driver.verifyThat()
                .element(notificationHeader_txt)
                .doesNotExist()
                .perform();
        driver.verifyThat()
                .element(notificationContent_txt)
                .doesNotExist()
                .perform();
        return this;
    }
}
