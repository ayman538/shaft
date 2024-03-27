package de.vodafone.pages.CableMigration;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class KontostandPage {
    private SHAFT.GUI.WebDriver driver;

    //Locators
    private By Kontostand_Tab = By.xpath("//div[@automation-id='navTab_0_tv']");
    private By RefAcc2_Tab = By.xpath("//button[2]/span[@class='ws10-filter-pill__item__text ws10-text ws10-spacing-0']");

    private By RefAcc4_Tab = By.xpath("//button[4]/span[@class='ws10-filter-pill__item__text ws10-text ws10-spacing-0']");
    private By RefAcc5_Tab = By.xpath("//button[5]/span[@class='ws10-filter-pill__item__text ws10-text ws10-spacing-0']");
    private By RefAcc3_Tab = By.xpath("//button[3]/span[@class='ws10-filter-pill__item__text ws10-text ws10-spacing-0']");
    private By RefAcc8_Tab = By.xpath("//button[8]/span[@class='ws10-filter-pill__item__text ws10-text ws10-spacing-0']");
    private By tV_Tab      = By.xpath("//div[@id='billoverviewWrapperId']//button[1]");
    private By hotspot_Tab = By.xpath("//div[@id='billoverviewWrapperId']//button[5]");
    private By hotspot1_Tab = By.xpath("//div[@id='billoverviewWrapperId']//button[6]");
    private By produkt_Tab = By.xpath("//div[@id='billoverviewWrapperId']//button[2]");
    private By tv2_Tab = By.xpath("//div[@id='billoverviewWrapperId']//button[4]");
    private By Header_Text = By.xpath("//txt-section[1]//h3[@automation-id='h3_tv']");
    private By SubHeader_Text = By.xpath("//txt-section[1]//p[@class='txtsection__content']");
    private By subHeader_Text2 = By.xpath("//div[@id='billoverviewWrapperId']//account-product-categories/p");
    private By subHeaderInkasso = By.xpath("//div[@class='mb-24']");
    private By SubHeaderCredit_Text = By.xpath("//txt-section[1]//p[@class='txtsection__content']");
    private By SubHeaderDunning_Text = By.xpath("//txt-section[2]//p[@class='txtsection__content']");
    private By CardTopline_Text = By.xpath("//div[@class='cardContainer_column']//h2[@automation-id='h2_tv']");
    private By YellowIcon_Text = By.xpath("//div[@class='ws10-highlight-badge ws10-reset-cms ws10-highlight-badge--yellow ws10-highlight-badge--small']");
    private By GreenIcon_Text = By.xpath("//div[@class='ws10-highlight-badge ws10-reset-cms ws10-highlight-badge--green ws10-highlight-badge--small']");
    private By NoBalance_Text = By.xpath("//h2[@automation-id='h2_tv']");
    private By RedIcon_Text = By.xpath("//div[@class='ws10-highlight-badge ws10-reset-cms ws10-highlight-badge--burgundy ws10-highlight-badge--standard']");
    private By Invoice_Text = By.xpath("//div[1][@class='cardContainer_column']//p[@class='text-default fw-700 p-0-m-0 color-secondary-500-bold']");
    private By Amount_Text = By.xpath("//div[2][@class='cardContainer_column']//p[@class='text-default fw-700 p-0-m-0 color-secondary-500-bold']");
    private By Healine1_Text = By.xpath("//ws10-headline-brix[1]//h5[@class='ws10-headline--h5']");
    private By Subline1_Text = By.xpath("//txt-section[2]//p[@class='txtsection__content']");
    private By Healine2_Text = By.xpath("//ws10-headline-brix[2]//h5[@class='ws10-headline--h5']");
    private By Subline21_Text = By.xpath("//txt-section[4]/div/div[1]//p[@class='txtsection__content']");
    private By Subline22_Text = By.xpath("//txt-section[4]/div/div[2]//p[@class='txtsection__content']");
    private By DocHealine_Text = By.xpath("//txt-section[5]//h3[@automation-id='h3_tv']");
    private By DocSubline_Text = By.xpath("//txt-section[5]//p[@class='txtsection__content']");
    private By DocLink_Text = By.xpath("//div[6]//li[@automation-id='undefined_Link']");
    private By OtherHeadline_Text = By.xpath("//txt-section[6]//h3[@automation-id='h3_tv']");
    private By OtherLink_Text = By.xpath("//div[8]//li[@automation-id='undefined_Link']");
    //CLs
    private static String Header = "Aktuelle Infos zu Deinem Referenzkonto";
    private static String NoBalance = "Alles okay! Du hast im Moment keine offenen Zahlungen.";
    private static String SubHeader = "Du hast eine offene Zahlung bei uns. Überweis bitte den offenen Betrag. Die Bankverbindung siehst Du weiter unten. Denk bitte an die Rechnungsnummer beim Verwendungszweck.\n" +
            "In der Übersicht siehst Du alle Buchungsposten auf Deinem Konto und die Beträge.";
    private static String SubHeaderCredit = "Du hast im Moment ein Guthaben auf Deinem Konto. Den Betrag bekommst Du auf Deiner nächsten Rechnung.\n" +
            "In der Übersicht siehst Du alle Buchungsposten auf Deinem Konto und die Beträge.";
    //private static String SubHeaderDunning = "Du hast schon länger offene Zahlungen bei uns." + "Wir haben die Bearbeitung deshalb an ein + Inkassobüro +übergeben.\n" +
          //  "Zahl bitte den offenen Betrag so bald wie möglich! Wende Dich bei allen Fragen dazu ab jetzt nur noch an:";
    private static String CardTopline = "Offener Betrag";
    private static String CardToplineCredit = "Guthaben";
    private static String YellowIcon = "Offen";
    private static String GreenIcon = "Guthaben";
    private static String RedIcon = "Inkasso";
    private static String Invoice = "Buchungsposten";
    private static String Amount = "Betrag";
    private static String Healine1 = "Wichtig für Dich";
    private static String Subline1 = "Schreib bitte bei Deiner Überweisung beim Verwendungszweck die Rechnungsnummer hinein. Richte die Überweisung an diese Bankverbindung:";
    private static String Healine2 = "Auch wichtig";
    private static String Subline21 = "Dein Anschluss ist schon gesperrt? Dann schalten wir diesen selbstverständlich wieder frei, sobald wir Deine Zahlung erhalten haben. Beachte bitte, dass die Weitergabe der Zahlung durch die Kreditinstitute einige Tage in Anspruch nehmen kann";
    private static String Subline22 = "Wir können zukünftig den fälligen Rechnungsbetrag ganz bequem per Lastschrift von Deinem Konto abbuchen. Du erteilst uns ein Mal eine Einzugsermächtigung und den Rest erledigen wir für Dich. Hier kannst Du die Einzugsermächtigung einrichten.";
    private static String DocHealine = "Deine Dokumente";
    private static String DocSubline = "Alle Details zu Deinen Rechnungen und Mahnungen findest Du hier.";
    private static String DocLink = "Hier geht's zu Deinen Dokumenten";
    private static String OtherHeadline = "Noch mehr Infos für Dich";
    private static String Otherlink = "Jetzt auf Lastschrift umstellen";
  public KontostandPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Clink on the Kontostand tab")
    public KontostandPage ClickOnKontostandTab() {
        driver.element().click(Kontostand_Tab);
        return this;
    }
    @Step("Clink on the Outstanding account")
    public KontostandPage ClickOnOutstandingAccount() {
        driver.element().click(RefAcc4_Tab);
        return this;
    }

    @Step("Clink on the credit account")
    public KontostandPage ClickOnCreditAccount() {
        driver.element().click(RefAcc5_Tab);
        return this;
    }

    @Step("Clink on the no balance account")
    public KontostandPage ClickOnNoBalanceAccount() {
        driver.element().click(RefAcc3_Tab);
        return this;
    }

    @Step("Clink on the Dunning account")
    public KontostandPage ClickOnDunningAccount() {
        driver.element().click(RefAcc8_Tab);
        return this;
    }
    @Step("Clink on the Document Link")
    public KontostandPage ClickOnDocLink() {
        driver.element().click(DocLink_Text);
        return this;
    }
    @Step("Clink on the other link")
    public KontostandPage ClickOnOtherLink() {
        driver.element().click(OtherLink_Text);
        return this;
    }
    //WFFT-2999
    @Step("Clink on the second  Subaccount")
    public KontostandPage ClickOnSecondSubAccount() {
        driver.element().click(RefAcc2_Tab);
        return this;
    }
    @Step("Clink on the TV tab")
    public KontostandPage clickOnTvTab() {
        driver.element().click(tV_Tab);
        return this;
    }
    @Step("Clink on the Hotspot tab")
    public KontostandPage clickOnHotspotTab() {
        driver.element().click(hotspot_Tab);
        return this;
    }
    @Step("Clink on the Hotspot1 tab")
    public KontostandPage clickOnHotspot1Tab() {
        driver.element().click(hotspot1_Tab);
        return this;
    }
    @Step("Clink on the Produkt tab")
    public KontostandPage clickOnProduktab() {
        driver.element().click(produkt_Tab);
        return this;
    }
    @Step("Clink on the TV2e tab")
    public KontostandPage clickOntv2tab() {
        driver.element().click(tv2_Tab);
        return this;
    }
    @Step("Validate texts in outstanding case")
    public void validateOutstandingTexts() {
        driver.verifyThat()
                .element(Header_Text)
                .text()
                .isEqualTo(Header)
                .perform();
        driver.verifyThat()
                .element(SubHeader_Text)
                .text()
                .isEqualTo(SubHeader)
                .perform();
    }

    @Step("Validate card in outstanding case")
    public void validateCardOutstanding() {
        driver.verifyThat()
                .element(CardTopline_Text)
                .text()
                .isEqualTo(CardTopline)
                .perform();
        driver.verifyThat()
                .element(YellowIcon_Text)
                .text()
                .isEqualTo(YellowIcon)
                .perform();
        driver.verifyThat()
                .element(Invoice_Text)
                .text()
                .isEqualTo(Invoice)
                .perform();
        driver.verifyThat()
                .element(Amount_Text)
                .text()
                .isEqualTo(Amount)
                .perform();
    }

    @Step("Validate the Group text1")
    public void validateGroupText1() {
        driver.verifyThat()
                .element(Healine1_Text)
                .text()
                .isEqualTo(Healine1)
                .perform();
        driver.verifyThat()
                .element(Subline1_Text)
                .text()
                .isEqualTo(Subline1)
                .perform();
    }

    @Step("Validate the group Text2")
    public void validateGroupText2() {
        driver.verifyThat()
                .element(Healine2_Text)
                .text()
                .isEqualTo(Healine2)
                .perform();
        driver.verifyThat()
                .element(Subline21_Text)
                .text()
                .isEqualTo(Subline21)
                .perform();
        driver.verifyThat()
                .element(Subline22_Text)
                .text()
                .isEqualTo(Subline22)
                .perform();
    }

    @Step("Validate the document")
    public void validateDocument() {
        driver.verifyThat()
                .element(DocHealine_Text)
                .text()
                .isEqualTo(DocHealine)
                .perform();
        driver.verifyThat()
                .element(DocSubline_Text)
                .text()
                .isEqualTo(DocSubline)
                .perform();
        driver.verifyThat()
                .element(DocLink_Text)
                .text()
                .isEqualTo(DocLink)
                .perform();
    }

    @Step("Validate the other link")
    public void validateOtherLink() {
        driver.verifyThat()
                .element(OtherHeadline_Text)
                .text()
                .isEqualTo(OtherHeadline)
                .perform();
        driver.verifyThat()
                .element(OtherLink_Text)
                .text()
                .isEqualTo(Otherlink)
                .perform();
    }
    @Step("Validate texts in Credit case")
    public void validateCreditTexts() {
        driver.verifyThat()
                .element(Header_Text)
                .text()
                .isEqualTo(Header)
                .perform();
        driver.verifyThat()
                .element(SubHeaderCredit_Text)
                .text()
                .isEqualTo(SubHeaderCredit)
                .perform();
    }

    @Step("Validate card in Credit case")
    public void validateCardCredit() {
        driver.verifyThat()
                .element(CardTopline_Text)
                .text()
                .isEqualTo(CardToplineCredit)
                .perform();
        driver.verifyThat()
                .element(GreenIcon_Text)
                .text()
                .isEqualTo(GreenIcon)
                .perform();
        driver.verifyThat()
                .element(Invoice_Text)
                .text()
                .isEqualTo(Invoice)
                .perform();
        driver.verifyThat()
                .element(Amount_Text)
                .text()
                .isEqualTo(Amount)
                .perform();
    }
    @Step("Validate texts in No balance case")
    public void validateNoBalanceTexts() {
        driver.verifyThat()
                .element(NoBalance_Text)
                .text()
                .isEqualTo(NoBalance)
                .perform();
    }
    @Step("Validate texts in Dunning case")
    public void validateDunningTexts() {
        driver.verifyThat()
                .element(Header_Text)
                .text()
                .isEqualTo(Header)
                .perform();
        driver.verifyThat()
                .element(RedIcon_Text)
                .text()
                .isEqualTo(RedIcon)
                .perform();
    }
    //WFFT-2999
    @Step("Validate texts in outstanding case")
    public void validateOutstandingTexts(String header, String subHeader) {
        driver.verifyThat()
                .element(Header_Text)
                .textTrimmed()
                .isEqualTo(header)
                .perform();
        driver.verifyThat()
                .element(SubHeader_Text)
                .textTrimmed()
                .contains(subHeader)
                .perform();
    }

    @Step("Validate card in outstanding case")
    public void validateCardOutstanding(String cardTopline, String yellowIcon, String invoice, String amount) {
        driver.verifyThat()
                .element(CardTopline_Text)
                .textTrimmed()
                .isEqualTo(cardTopline)
                .withCustomReportMessage("Validate the text")
                .perform();
        driver.verifyThat()
                .element(YellowIcon_Text)
                .textTrimmed()
                .isEqualTo(yellowIcon)
                .withCustomReportMessage("Validate the text")
                .perform();
        driver.verifyThat()
                .element(Invoice_Text)
                .textTrimmed()
                .isEqualTo(invoice)
                .withCustomReportMessage("Validate the text")
                .perform();
        driver.verifyThat()
                .element(Amount_Text)
                .textTrimmed()
                .isEqualTo(amount)
                .withCustomReportMessage("Validate the text")
                .perform();
    }
    @Step("Validate texts in Credit case")
    public void validateCreditTexts(String header, String subHeaderCredit) {
        driver.verifyThat()
                .element(Header_Text)
                .textTrimmed()
                .isEqualTo(header)
                .perform();
        driver.verifyThat()
                .element(SubHeaderCredit_Text)
                .textTrimmed()
                .contains(subHeaderCredit)
                .perform();
    }

    @Step("Validate card in Credit case")
    public void validateCardCredit(String cardToplineCredit, String greenIcon, String invoice, String amount) {
        driver.verifyThat()
                .element(CardTopline_Text)
                .textTrimmed()
                .isEqualTo(cardToplineCredit)
                .perform();
        driver.verifyThat()
                .element(GreenIcon_Text)
                .textTrimmed()
                .isEqualTo(greenIcon)
                .perform();
        driver.verifyThat()
                .element(Invoice_Text)
                .textTrimmed()
                .isEqualTo(invoice)
                .perform();
        driver.verifyThat()
                .element(Amount_Text)
                .textTrimmed()
                .isEqualTo(amount)
                .perform();
    }
    @Step("Validate texts in No balance case")
    public void validateNoBalanceTexts(String noBalance) {
        driver.verifyThat()
                .element(NoBalance_Text)
                .textTrimmed()
                .isEqualTo(noBalance)
                .perform();
    }
    //WFFT_2996
    @Step("Validate texts TV tab")
    public KontostandPage validateTVTexts(String expectedHeaderNew, String expectedSubHeaderNew, String expectedSubHeaderNew2) {
        driver.verifyThat()
                .element(Header_Text)
                .textTrimmed()
                .isEqualTo(expectedHeaderNew)
                .perform();
        driver.verifyThat()
                .element(SubHeader_Text)
                .textTrimmed()
                .isEqualTo(expectedSubHeaderNew)
                .perform();
        driver.verifyThat()
                .element(subHeader_Text2)
                .textTrimmed()
                .isEqualTo(expectedSubHeaderNew2)
                .perform();
        return this;
    }
    @Step("Validate texts hotspot tab")
    public KontostandPage validateHotspotTexts(String expectedHeaderHotspot, String expectedSubHeaderNew, String expectedSubHeaderNew2) {
        driver.verifyThat()
                .element(Header_Text)
                .textTrimmed()
                .isEqualTo(expectedHeaderHotspot)
                .perform();
        driver.verifyThat()
                .element(SubHeader_Text)
                .textTrimmed()
                .isEqualTo(expectedSubHeaderNew)
                .perform();
        driver.verifyThat()
                .element(subHeader_Text2)
                .textTrimmed()
                .isEqualTo(expectedSubHeaderNew2)
                .perform();
        return this;
}
    @Step("Validate texts produkt tab")
    public KontostandPage validateProduktTexts(String expectedHeaderProdukt, String expectedSubHeaderNew, String expectedSubHeaderNew2) {
        driver.verifyThat()
                .element(Header_Text)
                .textTrimmed()
                .isEqualTo(expectedHeaderProdukt)
                .perform();
        driver.verifyThat()
                .element(SubHeader_Text)
                .textTrimmed()
                .isEqualTo(expectedSubHeaderNew)
                .perform();
        driver.verifyThat()
                .element(subHeader_Text2)
                .textTrimmed()
                .isEqualTo(expectedSubHeaderNew2)
                .perform();
        return this;
    }
    @Step("Validate texts Tv2 tab")
    public KontostandPage validateTv2Texts(String expectedHeaderTv, String expectedSubHeaderInkaso) {
        driver.verifyThat()
                .element(Header_Text)
                .textTrimmed()
                .isEqualTo(expectedHeaderTv)
                .perform();
        driver.verifyThat()
                .element(subHeaderInkasso)
                .textTrimmed()
                .isEqualTo(expectedSubHeaderInkaso)
                .perform();
        return this;
    }
    @Step("Validate texts Tv No balance tab")
    public KontostandPage validateTvNoBalanceTexts(String expectedHeaderNew) {
        driver.verifyThat()
                .element(Header_Text)
                .textTrimmed()
                .isEqualTo(expectedHeaderNew)
                .perform();
        return this;
    }

}
