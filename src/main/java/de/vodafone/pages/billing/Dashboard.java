package de.vodafone.pages.billing;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class Dashboard {
    private SHAFT.GUI.WebDriver driver;

    private static By meineRechnungTileLocator = By.xpath("//div[@class=\"subTitle\"][contains(.,\"Vergleichen und herunterladen\")]");
    private static By meineDatenTileLocator = By.xpath("//a[@automation-id='Meine Daten_btn']");
    protected static By profileIconLocator = By.xpath("//span[@class=\"icon icon-myvf\"]");
    private static By continueWithoutConsentButtonLocator = By.xpath("//a[contains(.,\"Weiter ohne Einwilligung\")]");
    private static By confirmEmailCloseIconLocator = By.xpath("(//div/*[@class=\"icon-close-i-xxsml i-xxsml\"])[1]");
    private static By meineKostenLocator = By.xpath("//div[@class=\"title\"][contains(.,\"Meine Kosten\")]");
    private static By simProfileCloseIconLocator = By.xpath("(//div[@class='close'][contains(.,'Schließen')])");
    private static By letzteRechnungIconLocator = By.xpath("//div[@class='title'][contains(text(),'Letzte Rechnung')]/../../div[1]/div/*[local-name()='svg' and @class='i-lrg']");
    private static By letzteRechnungAmountLocator = By.xpath("(//div[@class='price'])[1]");
    private static By letzetRechnungCreditFlagLocator = By.xpath("//span[contains(text(),'Dein Guthaben')]");
    private static By meineAufladungLocator = By.xpath("//div[@class=\"title\"][contains(.,\"Meine Aufladung\")]");
    private static By meineDokumentePageLocator = By.xpath("//li/a[contains(.,'Meine Dokumente ')]");
    private static By meineDatenLocator = By.xpath("//div[@class=\"title\"][contains(.,\"Meine Daten\")]");

    public static By getProfileIconLocator() {
        return profileIconLocator;
    }

    public By getContractLocator(String contractsOrder) {
        return By.xpath("(//h2[@class='contractName'])[" + contractsOrder + "]");
    }

    public By getCustomerBillDownloadLocator(String contractsOrder) {
        return By.xpath("(//a[@class='btn btn-alt eqHeight paperBill'])["+contractsOrder+"]");
    }

    public By getMeineRechnungOrderedTileLocator(String contractOrder) {
        return By.xpath("(//div[@class='subTitle'][contains(.,'Vergleichen und herunterladen')])[" + contractOrder + "]");
    }


    public By getMeineKostenOrderedTileLocator(String contractOrder) {

        return By.xpath("(//div[@class=\"title\"][contains(.,\"Meine Kosten\")])[" + contractOrder + "]");
    }
    public By getMeineDatenOrderedTileLocator(String contractOrder) {

        return By.xpath("(//div[@class=\"title\"][contains(.,\"Meine Daten\")])[" + contractOrder + "]");
    }

    public Dashboard(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    /* *************** WFCT_14089 **************** */
    @Step("User Downloads Bill At Dashboard")
    public void downloadsBillAtDashboard(String contractOrder) {
        driver.element().click(getCustomerBillDownloadLocator(contractOrder));
    }
    @Step("User Navigated to Meine Dokumente Page")
    public void clickMeineDokumenteTile() {
        driver.element().click(meineDokumentePageLocator);
    }

    @Step("Click on meine Rechnungen tile")
    public void clickMeineRechnungenTile() {
        driver.element().click(meineRechnungTileLocator);
    }


    @Step("Click on Meine Rechnungen Tile")
    public void clickMeineRechnungenTile(String contractOrder) {
        driver.element().click(getMeineRechnungOrderedTileLocator(contractOrder));
    }

    @Step("Click on Meine kosten Tile")
    public void clickMeineKostenTile(String contractOrder) {
        driver.element().click(getMeineKostenOrderedTileLocator(contractOrder));
    }
    @Step("Click on Meine kosten Tile")
    public void clickMeineDatenTile(String contractOrder) {
        driver.element().click(getMeineDatenOrderedTileLocator(contractOrder));
    }

    @Step("Click on meine kosten tile")
    public void clickMeineKostenTile() {
        driver.element().click(meineKostenLocator);
    }
    @Step("Click on meine daten tile")
    public void clickMeineDatenTile() {
        driver.element().click(meineDatenLocator);
    }
    @Step("click on meine aufladung tile")
    public void clickMeineAufladungTile() {
        driver.element().click(meineAufladungLocator);
    }

    @Step("Expand contract")
    public void expandContracts(String contractsOrder) {
        driver.element().click(getContractLocator(contractsOrder));
    }

    @Step("Wait Until Dashboard is Loaded Completely")
    public void waitUntilDashboardLoadedCompletely(){
        driver.verifyThat().element(By.xpath("fakeLocator")).doesNotExist()
                .perform();
    }

    // Validations
    /* *************** WFCT_10487 **************** */

    public void assertThatNotRetrievedAmountIconDoesNotExist(){
        driver.verifyThat()
                .element(letzteRechnungIconLocator)
                .doesNotExist()
                .withCustomReportMessage("assert that not retrieved amount icon does not exist")
                .perform();
    }

    public void assertThatNotRetrievedAmountIconExist(){
        driver.verifyThat()
                .element(letzteRechnungIconLocator)
                .exists()
                .withCustomReportMessage("assert that not retrieved amount icon exists")
                .perform();
    }
    public void assertOnTheDisplayedAmountInDashboard(String amount){
        driver.verifyThat()
                .element(letzteRechnungAmountLocator).text()
                .isEqualTo(amount)
                .withCustomReportMessage("assert that amount is displayed correctly case positive amount")
                .perform();
    }

    public void assertThatCreditFlagNotDisplayed(){
        driver.verifyThat()
                .element(letzetRechnungCreditFlagLocator)
                .doesNotExist().withCustomReportMessage("assert that credit flag is not displayed")
                .perform();
    }

    public void assertThatCreditCardFlagDisplayed() {
        driver.verifyThat()
                .element(letzetRechnungCreditFlagLocator)
                .exists().withCustomReportMessage("assert that credit flag is displayed")
                .perform();
    }

    public void assertOnNotRetrievedAmount(){
        driver.assertThat()
                .element(letzteRechnungAmountLocator)
                .doesNotExist()
                .withCustomReportMessage("assert that no amount is displayed when amount not retrieved")
                .perform();
    }

}
