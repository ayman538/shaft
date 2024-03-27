package de.vodafone.pages.MobileCom;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import de.vodafone.pages.Payment.Dunning;
import de.vodafone.pages.Payment.TopUp;
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
    private static By pageHeaderLocator = By.xpath("//h1[@automation-id='mainHeaderContainertv']");
    private static By negativeCurrentBalanceLocator = By.xpath("//div[@class='price negative']");
    private static By meineAufladung = By.xpath("//a[@class = 'btn btn-alt eqHeight'][contains(.,'Meine Aufladung')]");
    private static By waitLocator = By.xpath("//span[@class='']");
    private static By cardTitleLocator = By.xpath("//div[@class='contractName']");
    private static By cardSublineLocator = By.xpath("//div[@class='contract-info']");
    private static By cardSmartTilesLocator = By.xpath("//div[@class='tiles cf mod mod-cta-chooser mod-eq-height']//a");
    private static By productsTitleLocator = By.xpath("//*[@class='dashInfoText']/*[@class='title']");
    private static By productsSublineLocator = By.xpath("//*[@class='dashInfoText']/*[@class='subTitle']");
    private static By burgerMEnuOptionsLocator = By.xpath("//ul[@class='onclick-menu-content']//a");
    private static By smartCardsNumberLocator = By.xpath("//div[@automation-id='_so']");
    private static By TeilenhmerTitleLocator = By.xpath("//span[@class='mbo-name']");
    private static By NumberAtTeilenhmerLocator = By.xpath("//span[@class='mbo-msisdn']");
    private static By aktuelleGuthabenAmountLocator = By.xpath("//div[@class='price']");
    private static By aktuelleGuthabenTitleLocator = By.xpath("//*[@class='tiles cf mod mod-cta-chooser mod-eq-height']//*[@class='title']");
    private static By aktuelleGuthabenSubtitleLocator = By.xpath("//*[@class='tiles cf mod mod-cta-chooser mod-eq-height']//*[@class='subTitle']/span");
    private static By currentBalanceTileLocator = By.xpath("//*[@account-id='item.ban']//a");
    private static By currentBalanceNotAvailableLocator = By.xpath("//*[@class='not-available']/span");
    private static By remainingDataLocator = By.xpath("//*[@class='circleRemain']");
    private static By remainingDataColorLocator = By.xpath("(//*[@fill='none'])[2]");
    private static By totalDataLocator = By.xpath("//div[@class='circleTotal']/span[2]");
    private static By dataEndDateLocator = By.xpath("//div[@class='sb-block-footer smart-object-footer']//span[2]");
    private static By datenSO_SublineLocator = By.xpath("(//*[@automation-id='_so'])[1]//p");
    private static By noDataPackageLocator = By.xpath("(//*[@class='sb-block-footer'])[1]");
    private static By canNotUseDataErrorMsgLocator = By.xpath("(//*[@class='alert warning '])[1]");
    private static By tariffNotActiveErrorMsgLocator = By.xpath("(//*[@class='alert warning '])[2]");
    private static By tariffPlanLocator = By.xpath("//*[@class='tarrifCardName ucmTariff ucm-tariff-name']");
    private static By tariffEndDateLocator = By.xpath("(//*[@class='ucm-tariff-name-details-h5'])[2]");
    private static By tariffStartDateLocator = By.xpath("(//h5[@class='ucm-tariff-future-change lh-12'])");
    private static By cancelledTariffEndDateLocator = By.xpath("//h5[@class='ucm-sleeping-footer-text']/span");
    private static By tariffDurationLocator = By.xpath("(//*[@class='ucm-tariff-name-details-h5'])[1]");
    private static By noTariffPlanLocator = By.xpath("(//*[@class='sb-block-footer'])[2]");


    String notAvailableCl = "nicht verfügbar";

    public static By burgerMenuLocator(String burgerMenuOrder) {
        return By.xpath("(//div[@class='expert-mode dots-menu'])[" + burgerMenuOrder + "]");
    }
    public static By burgerMenuOptionLocator(int burgerMenuOptionOrder) {
        return By.xpath("//ul[@class='onclick-menu-content']/li["+burgerMenuOptionOrder+"]/a");
    }

    public static By smartObjectCardLocator(int smartObjectOrder) {
        return By.xpath("(//div[@automation-id='_so']//h3)[" + smartObjectOrder + "]");
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

    public static By getTopUpLocator(String contractOrder) {
        return By.xpath("(//div[@class='tile-wrapper'][contains(.,'Jetzt aufladen')])[" + contractOrder + "]");
    }

    public static By getMeineAufladungLocator(String tileOrder) {
        return By.xpath("((//a[@class = 'btn btn-alt eqHeight'])[" + tileOrder + "]//div[contains(.,'Meine Aufladung')])[2]");
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
    public QuickCheck clickMeineAufladungtile(String tileOrder) {
        driver.element().click(getMeineAufladungLocator(tileOrder));
        return new QuickCheck(driver);
    }

    @Step("Click on burger menu")
    public Dashboard clickBurgerMenuIcon(String burgerMenuOrder) {
        driver.element().click(burgerMenuLocator(burgerMenuOrder));
        return this;
    }

    @Step("Click on Quickcheck")
    public Dashboard clickQuickCheckList(String quickCheckListOrder) {
        driver.element().click(quickCheckListOrderLocator(quickCheckListOrder));
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

    public void navigateToRobertUserDashboard(){
        driver.browser().navigateToURL("https://simplicity.wf-de.vodafone.com/meinvodafone/services/?forApp=true");
    }

    public void assertOnPageHeaderForRobertAndItsColor(String pageHeader,String color) {
        driver.verifyThat().element(pageHeaderLocator).textTrimmed()
                .isEqualTo(pageHeader)
                .withCustomReportMessage("Assert On Page Title")
                .perform();
        driver.verifyThat().element(pageHeaderLocator).cssProperty("color")
                .contains(color).withCustomReportMessage("Assert On Page Title Color")
                .perform();
    }

    public void assertOnCardTitleAndNoSublineForRobert(String cardTitle) {
        driver.verifyThat().element(cardTitleLocator).textTrimmed().isEqualTo(cardTitle)
                .withCustomReportMessage("Assert On Card Title")
                .perform();
        driver.verifyThat().element(cardSublineLocator).doesNotExist()
                .withCustomReportMessage("Assert On No Card Subline")
                .perform();
    }

    public void assertOnTilesNumberForRobert(String smartTilesNumber) {
        int count = driver.element().getElementsCount(cardSmartTilesLocator);
        String countInString = String.valueOf(count);
        Validations.verifyThat().object(countInString).isEqualTo(smartTilesNumber)
                .withCustomReportMessage("Assert On Smart Tiles Number").perform();
    }

    public void assertOnProductsClAndSublineForRobert(String productCl, String prodctSubline) {
        driver.verifyThat().element(productsTitleLocator).textTrimmed()
                .isEqualTo(productCl)
                .withCustomReportMessage("Assert On Product CL")
                .perform();
        driver.verifyThat().element(productsSublineLocator).textTrimmed()
                .isEqualTo(prodctSubline)
                .withCustomReportMessage("Assert On Product Subline")
                .perform();
    }

    public void assertOnBurgerMenuOptionsNumberForRobert(String numberOfOptions) {
        int count = driver.element().getElementsCount(burgerMEnuOptionsLocator);
        String countInString = String.valueOf(count);
        Validations.verifyThat().object(countInString).isEqualTo(numberOfOptions)
                .withCustomReportMessage("Assert On Smart Tiles Number").perform();
    }

    public void assertOnSmartCardNumbersForRobert(String numberOfOptions) {
        int count = driver.element().getElementsCount(smartCardsNumberLocator);
        String countInString = String.valueOf(count);
        Validations.verifyThat().object(countInString).isEqualTo(numberOfOptions)
                .withCustomReportMessage("Assert On Smart Cards Number").perform();
    }

    public void assertOnTeilenhmerAndNumber() {
        driver.verifyThat().element(TeilenhmerTitleLocator).exists()
                .withCustomReportMessage("Assert On  Teilenhmer Title")
                .perform();
        driver.verifyThat().element(NumberAtTeilenhmerLocator).exists()
                .withCustomReportMessage("Assert On  Teilenhmer Section Number Title")
                .perform();
    }

    public void assertOnAktuelleGuthabenTile(String aktuelleGuthabenAmount,String aktuelleGuthabenTitle,String aktuelleGuthabenSubtitle) {
        driver.verifyThat().element(aktuelleGuthabenAmountLocator).textTrimmed()
                .isEqualTo(aktuelleGuthabenAmount)
                .withCustomReportMessage("Assert On  Aktuelle Guthaben Amount")
                .perform();
        driver.verifyThat().element(aktuelleGuthabenTitleLocator).textTrimmed()
                .isEqualTo(aktuelleGuthabenTitle)
                .withCustomReportMessage("Assert On  Aktuelle Guthaben Title")
                .perform();
        driver.verifyThat().element(aktuelleGuthabenSubtitleLocator).textTrimmed()
                .isEqualTo(aktuelleGuthabenSubtitle)
                .withCustomReportMessage("Assert On  Aktuelle Guthaben Subtitle")
                .perform();
    }
    //*[@class='tiles cf mod mod-cta-chooser mod-eq-height']//*[@class='title']
    public void assertThatCurrentBalanceTileWithNegativeAndRedAmount(String negativeAmount, String color){
        driver.verifyThat().element(negativeCurrentBalanceLocator).textTrimmed()
                .isEqualTo(negativeAmount)
                .withCustomReportMessage("Assert On Page Title")
                .perform();
        driver.verifyThat().element(negativeCurrentBalanceLocator).cssProperty("color")
                .contains(color).withCustomReportMessage("Assert On Page Title Color")
                .perform();
    }

    public void assertThatCurrentBalanceTileIsDimmedAndNotAvailableCL(){
        driver.verifyThat().element(currentBalanceTileLocator).isDisabled()
                .withCustomReportMessage("assert That Current Balance Tile Is Dimmed").perform();
        driver.verifyThat().element(currentBalanceNotAvailableLocator).textTrimmed().isEqualTo(notAvailableCl)
                .withCustomReportMessage("assert That Current Balance Tile Is Dimmed").perform();
    }

    public void assertOnDataSO(String remainingData,String totalData,String datenSoSubline,String dataEndDate,String remainingDataColor) {
        driver.verifyThat().element(remainingDataLocator).textTrimmed()
                .isEqualTo(remainingData)
                .withCustomReportMessage("Assert On Remaining Data Locator")
                .perform();
        driver.verifyThat().element(remainingDataColorLocator).cssProperty("stroke")
                .contains(remainingDataColor)
                .withCustomReportMessage("Assert On Data End Date Locator")
                .perform();
        driver.verifyThat().element(totalDataLocator).textTrimmed()
                .isEqualTo(totalData)
                .withCustomReportMessage("Assert On Total Data Locator")
                .perform();
        driver.verifyThat().element(datenSO_SublineLocator).textTrimmed()
                .isEqualTo(datenSoSubline)
                .withCustomReportMessage("Assert On Daten Subline Locator")
                .perform();
        driver.verifyThat().element(dataEndDateLocator).textTrimmed()
                .isEqualTo(dataEndDate)
                .withCustomReportMessage("Assert On Data End Date Locator")
                .perform();

    }

    public void assertOnDataSoFailure(String dataPackage) {
        driver.verifyThat().element(noDataPackageLocator).textTrimmed()
                .isEqualTo(dataPackage)
                .withCustomReportMessage("Assert On Data Package Locator")
                .perform();
    }

    public void assertOnSleepingTariffRedNotificationMsgAtTariffSo() {
        driver.verifyThat().element(tariffNotActiveErrorMsgLocator).exists()
                .withCustomReportMessage("Assert On No Tariff")
                .perform();
    }

    public void assertThatDatenSoDisplayedRedNotificationAtSleepingTariff(){
        driver.verifyThat().element(canNotUseDataErrorMsgLocator).exists()
                .withCustomReportMessage("Assert On No Data Package")
                .perform();
    }



    public void assertOnTariffSO(String tariffPlan, String tariffDuration, String tariffEndDate ) {
        driver.verifyThat().element(tariffPlanLocator).textTrimmed()
                .isEqualTo(tariffPlan)
                .withCustomReportMessage("Assert On Tariff Plan Name")
                .perform();
        driver.verifyThat().element(tariffDurationLocator).textTrimmed()
                .contains(tariffDuration)
                .withCustomReportMessage("Assert On Tariff")
                .perform();
        driver.verifyThat().element(tariffEndDateLocator).textTrimmed()
                .contains(tariffEndDate)
                .withCustomReportMessage("Assert On Tariff")
                .perform();

    }

    public void assertOnFutureDatedTariff(String tariffPlan, String tariffDuration, String tariffStartDate ) {
        driver.verifyThat().element(tariffPlanLocator).textTrimmed()
                .isEqualTo(tariffPlan)
                .withCustomReportMessage("Assert On Tariff Plan Name")
                .perform();
        driver.verifyThat().element(tariffDurationLocator).textTrimmed()
                .contains(tariffDuration)
                .withCustomReportMessage("Assert On Tariff")
                .perform();
        driver.verifyThat().element(tariffStartDateLocator).textTrimmed()
                .contains(tariffStartDate)
                .withCustomReportMessage("Assert On Tariff")
                .perform();
    }

    public void assertOnCancelledTariff(String tariffPlan, String tariffDuration, String tariffEndDate ) {
        driver.verifyThat().element(tariffPlanLocator).textTrimmed()
                .isEqualTo(tariffPlan)
                .withCustomReportMessage("Assert On Tariff Plan Name")
                .perform();
        driver.verifyThat().element(tariffDurationLocator).textTrimmed()
                .contains(tariffDuration)
                .withCustomReportMessage("Assert On Tariff")
                .perform();
        driver.verifyThat().element(cancelledTariffEndDateLocator).textTrimmed()
                .contains(tariffEndDate)
                .withCustomReportMessage("Assert On Tariff")
                .perform();

    }

    public void assertOnNonRecurringTariffPlan(String tariffPlan, String tariffDuration) {
        driver.verifyThat().element(tariffPlanLocator).textTrimmed()
                .isEqualTo(tariffPlan)
                .withCustomReportMessage("Assert On Tariff Plan Name")
                .perform();
        driver.verifyThat().element(tariffDurationLocator).textTrimmed()
                .contains(tariffDuration)
                .withCustomReportMessage("Assert On Tariff")
                .perform();
    }

    public void assertOnTariffFailure(String tariffPlan) {
        driver.verifyThat().element(noTariffPlanLocator).textTrimmed()
                .isEqualTo(tariffPlan)
                .withCustomReportMessage("Assert On No Tariff")
                .perform();
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

    @Step("Click On Meine Daten SO")
    public void clickOnMeineDatenSO(String contractOrder){
        driver.element().click(getMeineDatenLocator(contractOrder));
    }

    @Step("Click On Meine Daten SO")
    public void clickOnMeineDatenSO(){
        driver.element().click(meinDatenSO_Locator);
    }

    private By aktuelleRechnungenTile_Locator = By.xpath("//div[@class=\"subTitle\"][contains(.,\"Beträge und Datenvolumen\")]");
    private By meinDatenSO_Locator = By.xpath("//div[@automation-id='_so'][contains(.,'Daten')]");

    public Dashboard clickOnAktuelleRechnungTile(){
        driver.element().click(aktuelleRechnungenTile_Locator);
        return this;
    }
    @Step("navigate to dashboard ST")
    public Dashboard navigateToDashboardST(){
        driver.browser().navigateToURL(System.getProperty("de.vodafone.baseUrl.st")+"/meinvodafone/services/");
        driver.browser().refreshCurrentPage();
        return this;
    }
}
