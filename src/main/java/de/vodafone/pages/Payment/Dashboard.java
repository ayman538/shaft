package de.vodafone.pages.Payment;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Dashboard {
    private SHAFT.GUI.WebDriver driver;

    private static By meineRechnungTileLocator = By.xpath("//div[@class=\"subTitle\"][contains(.,\"Vergleichen und herunterladen\")]");
    public static By profileIconLocator = By.xpath("//span[@class=\"icon icon-myvf\"]");
    private static By continueWithoutConsentButtonLocator = By.xpath("//a[contains(.,\"Weiter ohne Einwilligung\")]");
    private static By confirmEmailCloseIconLocator = By.xpath("(//div/*[@class=\"icon-close-i-xxsml i-xxsml\"])[1]");
    private static By meineKostenLocator = By.xpath("//div[@class=\"title\"][contains(.,\"Meine Kosten\")]");
    private static By simProfileCloseIconLocator = By.xpath("(//div[@class='close'][contains(.,'Schließen')])");
    private static By letzteRechnungIconLocator = By.xpath("//div[@class='title'][contains(text(),'Letzte Rechnung')]/../../div[1]/div/*[local-name()='svg' and @class='i-lrg']");
    private static By letzteRechnungAmountLocator = By.xpath("(//div[@class='price'])[1]");
    private static By letzetRechnungCreditFlagLocator = By.xpath("//span[contains(text(),'Dein Guthaben')]");
    private static By logOutBtnLocator = By.xpath("//a[@class='btn btn-alt'][contains(.,'Logout')]");
    private static By MeineAufladungFlagLocator = By.xpath("(//a[@class='btn btn-alt eqHeight']//span)[1]");
    private static By getMeineAufladungtileLocator = By.xpath("(//a[@class = 'btn btn-alt eqHeight'])[2]");
    private static By burgerMenuLoactor = By.xpath("//div[@class='expert-mode dots-menu']");
    private static By meineVodafoneHeaderLocator = By.xpath("//div[@class='dashHeader']/h1");
    private static By meineAufladungTile_Title =By.xpath("//div[@class='title'][contains(., 'Meine Aufladung')]");
    private static By halloMixedUser_Text = By.xpath("//h2[@automation-id='subHeaderContainertv']");
    private static By dunningTabLocator = By.xpath("//div[@class=\"title\"][contains(.,\"Kontostand\")]");
    private static By dunningRedFlagIcon = By.xpath("//div[@class='redTileFlag']");

    private static By meineAufladung = By.xpath("//a[@class = 'btn btn-alt eqHeight'][contains(.,'Meine Aufladung')]");
    private static By waitLocator = By.xpath("//span[@class='']");
    private static By jetztAufladen = By.xpath("(//div[@class='tile-wrapper'][contains(.,'Jetzt aufladen')])[1]");
    public static By burgerMenuLocator(String burgerMenuOrder) {
        return By.xpath("(//div[@class='expert-mode dots-menu'])[" + burgerMenuOrder + "]");
    }

    private static By quickCheckListLocator = By.xpath("(//a[@class='menu-item'])[1]");

    public static By quickCheckListOrderLocator(String quickCheckListOrder) {
        return By.xpath("(//a[@class='menu-item'])[" + quickCheckListOrder + "]");
    }

    public  static By getMeineDatenLocator(String contractOrder) {
        return By.xpath("(//div[@class='tile-wrapper'][contains(.,'Meine Daten')])[" + contractOrder + "]");
    }


    public static By getDunningLocator() {
        return dunningLocator;
    }

    private static By dunningLocator = By.xpath("//div[@class='title'][contains(.,'Zu zahlender Betrag')]");

    private static By dunningLocator_ST = By.xpath("//a[@ng-click='vmDunning.goToState()']");

    private static By offerTextLocator = By.xpath("//pontis-offers//li[@aria-hidden='false']//h2");
    private static By offerButtonTextLocator = By.xpath("//pontis-offers//li[@aria-hidden='false']//a");
    private static By offersPointsLocator = By.xpath("//pontis-offers//a[@data-slide-index]");
    private static By offersAccTitleLocator = By.xpath("//span[@class='offers-icon']/following-sibling::span");
    private static By offersAccDescriptionLocator = By.xpath("//span[@class='offers-icon']/following-sibling::p");
    private static By informativeOfferOverlayTitleLocator = By.xpath("//div[@class='teaser']//h2");
    private static By informativeOfferOverlayDescritionLocator = By.xpath("//div[@class='teaser']//p");
    private static By informativeOfferCloseIconLocatorPaul = By.xpath("(//*[@class='close-icon i-sml i-grey-20'])[2]");
    private static By informativeOfferCloseIconLocatorRobert = By.xpath("(//*[@class='close-icon i-sml i-grey-20'])[1]");
    private static By informativeOfferOverlayClass = By.xpath("//div[@id='offer']");

    private String offerButtonTexCl = "Zum Angebot";
    private String offersAccTitleCl = "Angebote für Dich";
    private String offersAccDescriptionCl = "Jetzt checken!";
    private String closedInformativeOfferOverlayClassStyleCl= "display: none;";
    private String openInformativeOfferOverlayClassStyleCl = "display: block;";

    public static By getTopUpLocator(String contractOrder) {
        return By.xpath("(//div[@class='tile-wrapper'][contains(.,'Jetzt aufladen')])[" + contractOrder + "]");
    }

    public static By getOffersPointsLocator(String offerOrder) {
        return By.xpath("//pontis-offers//a[@data-slide-index='"+ offerOrder +"']");
    }



    public static By getMeineAufladungLocator() {
        return By.xpath("//*[contains(@style,'block')]//div[@class='title' and contains(.,'Meine Aufladung')]");
    }

    public static By getLetzteRechnungIconLocator() {
        return letzteRechnungIconLocator;
    }

    public static By getMeineVodafoneHeaderLocator() {
        return meineVodafoneHeaderLocator;
    }

    public static By getLetzteRechnungAmountLocator() {
        return letzteRechnungAmountLocator;
    }

    public static By getProfileIconLocator() {
        return profileIconLocator;
    }

    public Dashboard(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public static By getLetzetRechnungCreditFlagLocator() {
        return letzetRechnungCreditFlagLocator;
    }

    @Step("click on continue without consent button")
    public Dashboard clickWeiterOhneEinwilligung() {
        if (driver.element().getElementsCount(continueWithoutConsentButtonLocator) == 1) {
            driver.element().click( continueWithoutConsentButtonLocator);
        }
        return this;
    }
    @Step("Click on Confirmation Email Close Icon")
    public Dashboard clickConfirmEmailCloseIcon() {
        if (driver.element().getElementsCount(confirmEmailCloseIconLocator) == 1) {
            driver.element().click( confirmEmailCloseIconLocator);
        }
        return this;
    }
    @Step("Click on Sim Profile Close Icon")
    public Dashboard clickSimProfileCloseIcon() {
        if (driver.element().getElementsCount(simProfileCloseIconLocator) == 1) {
            driver.element().click( simProfileCloseIconLocator);
        }
        return this;
    }
    @Step("Click on Dunning tile")
    public Dunning clickDunningTile() {
        driver.element().click( dunningLocator);
        return new Dunning(driver);
    }

    @Step("Click on Dunning tile")
    public Dunning clickDunningTile_ST() {
        driver.element().click( dunningLocator_ST);
        return new Dunning(driver);
    }

    @Step("Expand contract")
    public Dashboard expandContracts(String contractsOrder) {
        driver.element().click( By.xpath(
                "(//h2[@class='contractName'])[" + contractsOrder + "]"));
        return new Dashboard(driver);
    }
    @Step("Click on Topup tile")
    public TopUp clickTopUpTile(String contractOrder) {
        driver.element().click( getTopUpLocator(contractOrder));
        return new TopUp(driver);
    }
    @Step("Click on Meine Aufladung tile")
    public QuickCheckPage clickMeineAufladungtile() {
        driver.element().click(getMeineAufladungLocator());
        return new QuickCheckPage(driver);
    }

    @Step("Click on burger menu")
    public Dashboard clickBurgerMenuIcon(String burgerMenuOrder) {
        driver.element().click(burgerMenuLocator(burgerMenuOrder));
        return this;
    }

    @Step("Click on Quickcheck")
    public Dashboard clickQuickCheckList(String quickCheckListOrder) {
        driver.element().click(By.xpath("//div[@class='expert-mode dots-menu menu-active']//a[contains(.,'QuickCheck')]"));
        return this;
    }

    @Step("Navigation with deep link")
    public void navigationDeepLink(String url){
        driver.browser().switchToNewTab(url);
    }

    @Step("Logout")
    public void logOut() {
        driver.element().hover(profileIconLocator);
        driver.element().click( logOutBtnLocator);
    }

    @Step("Navigate to Payment Page")
    public void navigateToPaymentPage() {
        driver.browser().navigateToURL( System.getProperty("de.vodafone.baseUrl.sit") + "meinvodafone/account/payment/uebersicht");
    }

    @Step("Navigate to Payment Page")
    public void navigateToPaymentPage_ST() {
        driver.browser().navigateToURL( System.getProperty("de.vodafone.baseUrl.st") + "meinvodafone/account/payment/uebersicht");
    }

    @Step("Go to Dunning tab")
    public void goToDunningTab() {
        driver.element().click(meineRechnungTileLocator);
        driver.element().click(dunningTabLocator);
    }

    @Step("Navigate to Dashboard")
    public void navigateToDashboard() {
        driver.browser().switchToNewTab( System.getProperty("de.vodafone.baseUrl.sit") + "meinvodafone/services");
    }

    @Step("click on offers button")
    public void clickOnOfferButton()
    {
        driver.element().click(offerButtonTextLocator);
    }

    @Step("select an offer")
    public void selectOffer(String offerOrder)
    {
        driver.element().click(getOffersPointsLocator(offerOrder));
    }
    @Step("close informative offer")
    public void closeInformativeOffer()
    {

        driver.element().click(informativeOfferCloseIconLocatorPaul);
    }
    @Step("close informative offer for robert")
    public void closeInformativeOfferRobert(){
        driver.element().click(informativeOfferCloseIconLocatorRobert);

    }


    public void checkStatueOfMeineAufladungCL(String status) {
        driver.verifyThat().element(MeineAufladungFlagLocator)
                .text()
                .contains(status)
                .withCustomReportMessage("Check Status Of Meine Aufladung CL").perform();
    }


    public void checkMeineAufladungtileExist() {
        driver.verifyThat().element(getMeineAufladungtileLocator).exists()
                .withCustomReportMessage("Assert That Meine Aufladung Tile Exists")
                .perform();

    }



    @Step("Assert That Meine Aufladung Tile is Not Exists")
    public void assertThatMeineAufladungTileNotExists(){
        Validations.verifyThat().element(driver.getDriver(),meineAufladungTile_Title)
                .doesNotExist()
                .perform();
    }

    @Step("Assert That User Navigated To Dashboard By Asserting On Object On Dashboard")
    public void assertThatUserNavigatedToDashboard(){
        driver.verifyThat().element(halloMixedUser_Text).exists()
                .withCustomReportMessage("Assert That User Navigated To Dashboard By Asserting On Object On Dashboard").perform();
    }

    @Step("Make Sure That User Navigated To Dashboard")
    public void makeSureThatUserNAvigatedToDashboard(){
        driver.verifyThat().element(waitLocator).doesNotExist()
                .withCustomReportMessage("Make Sure That User Navigated To Dashboard")
                .perform();
    }

    public void assertThatDunningTileDoesNotExist() {
        driver.verifyThat().element(dunningLocator).doesNotExist().withCustomReportMessage("Assert that Dunning tile doesn't exist").perform();
    }

    public void assertThatDunningRedFlagExists() {
        driver.verifyThat().element(dunningRedFlagIcon).exists().withCustomReportMessage("assert that dunning red flag exists").perform();
    }

    public void assertThatDunningRedFlagDoesNotExist() {
        driver.verifyThat().element(dunningRedFlagIcon).doesNotExist().withCustomReportMessage("assert that dunning red flag doesn't exist").perform();
    }

    @Step("Click On Meine Aufladung")
    public void clickOnMeineAufladung(){
        driver.element().click(meineAufladung);
    }

    @Step("Click On Meine Daten Tile")
    public void clickOnMeineDatenTile(String contractOrder){
        driver.element().click(getMeineDatenLocator(contractOrder));
    }
    @Step("Click On Jetzt aufladen Tile")
    public Dashboard clickOnJetztAufladenTile(){
        driver.element().click(jetztAufladen);
        return this;
    }

    public void assertOnPointsOffersAccTitle()
    {
        driver.verifyThat().element(offersAccTitleLocator).textTrimmed().isEqualTo(offersAccTitleCl).withCustomReportMessage("assert on points offer accordion name").perform();
    }
    public void assertOnPointsOffersAccDescription()
    {
        driver.verifyThat().element(offersAccDescriptionLocator).textTrimmed().isEqualTo(offersAccDescriptionCl).withCustomReportMessage("assert on points offer accordion name").perform();

    }
    public void assertOnOfferText(String offerName)
    {
        driver.verifyThat().element(offerTextLocator).textTrimmed().isEqualTo(offerName).withCustomReportMessage("assert on offer text").perform();
    }

    public void assertOnOfferButtonCL()
    {
        driver.verifyThat().element(offerButtonTextLocator).textTrimmed().isEqualTo(offerButtonTexCl).withCustomReportMessage("assert on offer button cl").perform();
    }

    public void assertOnOfferCount(String numberOfOffers)
    {
        Validations.verifyThat().number(driver.element().getElementsCount(offersPointsLocator)).isEqualTo(Integer.parseInt(numberOfOffers)).withCustomReportMessage("assert on offers count").perform();
    }

    public void assertThatPointsOffersAccDoesNotExist()
    {
        driver.verifyThat().element(offerButtonTextLocator).doesNotExist().withCustomReportMessage("assert that points offer accordion doesnot Exist").perform();
    }

    public void assertOnInformativeOfferOverlayTitle(String informativeOfferOverlayTitle)
    {
        driver.verifyThat().element(informativeOfferOverlayTitleLocator).textTrimmed().isEqualTo(informativeOfferOverlayTitle).withCustomReportMessage("assert on informative offer description").perform();
    }

    public void assertOnInformativeOfferOverlayDescription(String informativeOfferOverlayDescription)
    {
        driver.verifyThat().element(informativeOfferOverlayDescritionLocator).textTrimmed().isEqualTo(informativeOfferOverlayDescription).withCustomReportMessage("assert on informative offer description").perform();
    }

    public void assertThatInformativeOfferOverlayIsClosed() {
        driver.verifyThat()
                .element(informativeOfferOverlayClass)
                .attribute("style").isEqualTo(closedInformativeOfferOverlayClassStyleCl)
                .withCustomReportMessage("assert that Informative Offer Overlay Is Closed")
                .perform();

    }

    public void assertThatInformativeOfferOverlayIsOpened() {
        driver.verifyThat()
                .element(informativeOfferOverlayClass)
                .attribute("style").isEqualTo(openInformativeOfferOverlayClassStyleCl)
                .withCustomReportMessage("assert that Informative Offer Overlay Is opened")
                .perform();

    }
    public void waitTillLoad()
    {
        driver.verifyThat().element(By.xpath("ahmed")).doesNotExist().withCustomReportMessage("wait till page loaded").perform();
    }
}
