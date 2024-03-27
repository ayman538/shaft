package de.vodafone.pages.billing;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Kostenubersicht {
    // Locators
    private SHAFT.GUI.WebDriver driver;

    private static By latestAmount = By.xpath("(//*[@class=\"brix-ws10-hybrid-table__table-cell brix-ws10-hybrid-table__table-content\"])[2]/span[1]");
    private static By headLineLocator = By.xpath("//h3[@automation-id=\"table_header_tv\"]");
    private static By descriptionTextLocator = By.xpath("//p[@automation-id=\"table_description_tv\"]");
    private static By tableDescriptionLocator = By.xpath("//p[@automation-id=\"table_description_tv\"]/span[1]");
    private static By notBookedDescriptionTextLocator = By.xpath("//p[@automation-id=\"table_description_tv\"]/span[3]");
    private By notBookedHyperLink_Locator = By.xpath("//p[@automation-id=\"table_description_tv\"]//a");
    private static By mobileNumberTitleLocator = By.xpath("//h5[contains(.,\"Rufnummer\")]");
    private static By amountTitleLocator = By.xpath("(//h5[contains(.,\"Kosten\")])[1]");
    private static By costOverviewTitleLocator = By.xpath("//h5[contains(.,\"Kosten\u00ADinformation\")]");
    private static By itemizedBillTitleLocator = By.xpath("//h5[contains(.,\"Verbindungs\u00ADübersicht\")]");
    private static By firstNumberLocator = By.xpath("//tr[1]/td[1]/span");
    private static By firsrtCostOverviewDownloadLocator = By.xpath("//table/tbody/tr[1]/td[3]//*[local-name()='svg' and @automation-id='table_2_svg']");
    private static By firsrtCostOverviewDownloadLocator_Peter = By.xpath("//table/tbody/tr[1]/td[3]//*[local-name()='svg' and @automation-id='table_2_svg']");
    private static By firstCostOverviewPreviewLocator = By.xpath("//table/tbody/tr[1]/td[3]//*[local-name()='svg' and @automation-id='table_1_svg']");
    private static By firstCostOverviewPreviewLocator_Peter = By.xpath("//table/tbody/tr[1]/td[3]//*[local-name()='svg' and @automation-id='table_1_svg']");
    private static By firstItemizedBillDownloadLocator = By.xpath("//table/tbody/tr[1]/td[4]//*[local-name()='svg' and @automation-id='table_2_svg']");
    private static By firstItemizedBillDownloadLocator_Peter = By.xpath("//table/tbody/tr[1]/td[4]//*[local-name()='svg' and @automation-id='table_2_svg']");
    private static By secondItemizedBillDownloadLocator_Peter = By.xpath("//table/tbody/tr[2]/td[4]//*[local-name()='svg' and @automation-id='table_2_svg']");
    private static By firstItemizedBillPreviewLocator = By.xpath("//table/tbody/tr[1]/td[4]//*[local-name()='svg' and @automation-id='table_1_svg']");
    private static By firstItemizedBillPreviewLocator_Peter = By.xpath("//table/tbody/tr[1]/td[4]//*[local-name()='svg' and @automation-id='table_1_svg']");
    private static By seventhCostOverviewDownloadLocator = By.xpath("//table/tbody/tr[7]/td[3]//*[local-name()='svg' and @automation-id='table_2_svg']");
    private static By seventhCostOverviewPreviewLocator = By.xpath("//table/tbody/tr[7]/td[3]//*[local-name()='svg' and @automation-id='table_1_svg']");
    private static By seventhItemizedBillDownloadLocator = By.xpath("//table/tbody/tr[7]/td[4]//*[local-name()='svg' and @automation-id='table_2_svg']");
    private static By seventhItemizedBillPreviewLocator = By.xpath("//table/tbody/tr[7]/td[4]//*[local-name()='svg' and @automation-id='table_1_svg']");
    private static By showMoreButtonLocator = By.xpath("//*[@automation-id=\"see_more_btn\"]");
    private static By showLessButtonLocator = By.xpath("//*[@automation-id=\"see_more_btn\"]");
    private static By firstCostOverviewWarningLocator = By.xpath("//table/tbody/tr[1]/td[3]//*[local-name()='svg' and @automation-id='table_1_svg']");
    private static By firstCostOverviewWarningLocator_Peter = By.xpath("//table/tbody/tr[1]/td[3]//*[local-name()='svg' and @automation-id='table_1_svg']");
    private static By firstItemizedBillWarningLocator = By.xpath("//table/tbody/tr[1]/td[4]//*[local-name()='svg' and @automation-id='table_1_svg']");
    private static By firstItemizedBillWarningLocator_Peter = By.xpath("//table/tbody/tr[1]/td[4]//*[local-name()='svg' and @automation-id='table_1_svg']");
    private static By firstCostOverviewWarningLocatorNotification = By.xpath("//table/tbody/tr[1]/td[3]//*[local-name()='svg' and @automation-id='table_1_svg']/*[name()='title']");
    private static By firstItemizedBillWarningLocatorNotification = By.xpath("//table/tbody/tr[1]/td[4]//*[local-name()='svg' and @automation-id='table_1_svg']/*[name()='title']");
    private static By serviceErrorNotificationDescriptionLocator = By.xpath("//p[@class=\"notification-text mb-10 mt-10\"]");
    private static By serviceErrorNotificationTitleLocator = By.xpath("//h4[@class=\"flexDiv\"]");
    private static By emptyBeNotificationDescriptionLocator = By.xpath("//p[@class=\"notification-text mb-10 mt-10\"]");
    private static By emptyBeNotificationTitleLocator = By.xpath("//h4[@class=\"flexDiv\"]");
    private static By firstMonthAmountLocator = By.xpath("(//table[@automation-id=\"root_table\"]/tbody/tr[1]/td[2]/span)[1]");
    private static By dateColumnLocator = By.xpath("//h5[contains(.,\"Datum\")]");
    private By dummyLocator = By.xpath("");
    private By exitIcon = By.xpath("//button[@class='nsm-dialog-btn-close']");
    private static By firstMonthNameLocator = By.xpath("//table[@automation-id=\"root_table\"]/tbody/tr[1]/td[1]/span");
    private static By secondMonthNameLocator = By.xpath("//table[@automation-id=\"root_table\"]/tbody/tr[2]/td[1]/span");
    private static By missingAllInformationNotificationDescriptionLocator = By.xpath("//p[@class=\"notification-text mb-10 mt-10\"]");
    private static By missingAllInformationNotificationTitleLocator = By.xpath("//h4[@class=\"flexDiv\"]");
    private static By pdfNotBookedErrorNotificationTitle = By.xpath("(//div[@class = 'item-2 w-100']/h4)[1]");
    private static By pdfNotBookedErrorNotificationText = By.xpath("(//p[@class = 'notification-text mb-10 mt-10'])[1]");
    private static By pdfNotBookedErrorIconText = By.xpath("((//div/*[@automation-id='table_1_svg'])[1]/*)[1]");
    private static By monthFilterLocator = By.xpath("(//select[@id='undefined'])[1]");
    private static By mobileNumberFilterLocator = By.xpath("(//select[@id='undefined'])[2]");
    private static By tableRowsLocator = By.xpath("//tr");
    private static By kostenubersichtPageHeaderLocator = By.xpath("//div[@automation-id=\"pageHeader_tv\"]/h1");
    private static By kostenubersichtTableHeaderLocator = By.xpath("//div[@class='table-container']/h3");
    static private By firstAmountAtTable = By.xpath("(//span[@class='ws10-hybrid-table__text ws10-hybrid-table__text-limit pointer text-underline no-mobile'])[1]");
    static private By firstAmountAtTableNotReturned = By.xpath("(//span[@class='ws10-hybrid-table__text ws10-hybrid-table__text-limit'])[2]");

    static private By firstAmountAtTableWithCredit = By.xpath("(//span[@class='ws10-hybrid-table__text ws10-hybrid-table__text-limit i-green ws10 pointer text-underline no-mobile'])[1]");

    static private By sieheKostenubersichtLocator =By.xpath("(//span[@class='ws10-hybrid-table__text ws10-hybrid-table__text-limit'])[2]");
    static private By msisdnLocator = By.xpath("(//span[@class='ws10-hybrid-table__text ws10-hybrid-table__text-limit'])[1]");
    static private By tableLocator = By.xpath("//div[@class='table-container']");
    static private By waitLocaotr = By.xpath("");
    static private By blueBoxMsgLocator = By.xpath("//div[@class='alert noselect inProgress']");
    static private By creditAmountIcon = By.xpath("(//div[@class='tooltip-text'])[1]");

    public static By getHeadLineLocator() {
        return headLineLocator;
    }

    public static By getFirstItemizedBillPreviewLocator() {
        return firstItemizedBillPreviewLocator;
    }

    public static By getFirstItemizedBillDownloadLocator() {
        return firstItemizedBillDownloadLocator;
    }

    public static By getFirstCostOverviewPreviewLocator() {
        return firstCostOverviewPreviewLocator;
    }

    public static By getFirsrtCostOverviewDownloadLocator() {
        return firsrtCostOverviewDownloadLocator;
    }

    public static By getItemizedBillTitleLocator() {
        return itemizedBillTitleLocator;
    }

    public static By getCostOverviewTitleLocator() {
        return costOverviewTitleLocator;
    }

    public static By getAmountTitleLocator() {
        return amountTitleLocator;
    }

    public static By getMobileNumberTitleLocator() {
        return mobileNumberTitleLocator;
    }

    public static By getDescriptionTextLocator() {
        return descriptionTextLocator;
    }

    public static By getShowLessButtonLocator() {
        return showLessButtonLocator;
    }

    public static By getShowMoreButtonLocator() {
        return showMoreButtonLocator;
    }

    public static By getDateColumnLocator() {
        return dateColumnLocator;
    }

    public static By getWarningIconLocator(String rowOrder, String columnOrder) {
        return By.xpath("//table/tbody/tr[" + rowOrder + "]/td[" + columnOrder + "]//*[local-name()='svg' and @automation-id='table_1_svg']");
    }

    public static By getItemizedBillWarningLocatorNotification(String rowOrder, String columnOrder) {
        return By.xpath("//table/tbody/tr[" + rowOrder + "]/td[" + columnOrder + "]//*[local-name()='svg' and @automation-id='table_1_svg']/*[name()='title']");
    }


    public static By getPdfNotBookedErrorIcon(String rowOrder, String columnOrder) {
        return By.xpath("//tbody/tr[" + rowOrder + "]/td[" + columnOrder + "]//*[local-name()='svg' and @automation-id='table_1_svg']");
    }

    private By getIConnectionOverviewDownloadIconLocator(String connectionOverviewDownloadIconRowNumber) {
        return By.xpath("//tbody/tr[" + connectionOverviewDownloadIconRowNumber + "]/td[3]//*[local-name()='svg' and @automation-id='table_2_svg']");
    }

    private By getCreditAmountIconLocator(String creditIconRowNumber) {
        return By.xpath("//tr[" + creditIconRowNumber + "]//inline-tooltip//*[local-name()='svg' and @class='i-sml i-grey']");
    }

    private By getCreditAmountIconInfoTitleLocator(String creditIconRowNumber) {
        return By.xpath("//tr[" + creditIconRowNumber + "]//inline-tooltip//div[@class='headline h4']");
    }

    private By getCreditAmountIconInfoDescriptionLocator(String creditIconRowNumber) {
        return By.xpath("//tr[" + creditIconRowNumber + "]//inline-tooltip//div[@class='content']");
    }

    private By getCreditAmountLocator(String creditIconRowNumber) {
        return By.xpath("//tr[" + creditIconRowNumber + "]/td[2]/span[1]");
    }

    private By getIConnectionOverviewPreviewIconLocator(String connectionOverviewPreviewIconRowNumber) {
        return By.xpath("//tbody/tr[" + connectionOverviewPreviewIconRowNumber + "]/td[3]//*[local-name()='svg' and @automation-id='table_1_svg']");
    }

    private By getCostPDFOverviewPreviewIconLocator(String costPDFOverviewPreviewIconLocator) {
        return By.xpath("//table/tbody/tr[" + costPDFOverviewPreviewIconLocator + "]/td[3]//*[local-name()='svg' and @automation-id='table_1_svg']");
    }

    private By getConnectionPdfPreviewIcon_Peter(String connectionPdfPreviewIcon_Peter) {
        return By.xpath("//table/tbody/tr[" + connectionPdfPreviewIcon_Peter + "]/td[4]//*[local-name()='svg' and @automation-id='table_1_svg']");
    }

    private By getConnectionPdfDownloadIcon_Peter(String connectionPdfDownloadIcon_Peter) {
        return By.xpath("//table/tbody/tr[" + connectionPdfDownloadIcon_Peter + "]/td[4]//*[local-name()='svg' and @automation-id='table_2_svg']");
    }

    private By getCostPdfDownloadIcon(String costPdfDownloadIcon) {
        return By.xpath("//table/tbody/tr[" + costPdfDownloadIcon + "]/td[3]//*[local-name()='svg' and @automation-id='table_2_svg']");
    }

    private By getSubscriberNumberLocator(String subscriberNumberRowNumber) {
        return By.xpath("//tr[" + subscriberNumberRowNumber + "]/td[1]/span");
    }

    private int getNumberCountInTable(String Number) {

        return driver.element().getElementsCount(By.xpath("//td//span[text()=' " + Number + " ']"));
    }

    private By getDropdownMonthLocator(String month) {
        return By.xpath("//option[contains(.,'" + month + "')]");
    }

    private By getItemizedBillWarningIconLocator(String itemizedBillWarningIconRowNumber) {
        return By.xpath("//tbody/tr[" + itemizedBillWarningIconRowNumber + "]/td[4]//*[local-name()='svg' and @automation-id='table_1_svg']");
    }

    private By getItemizedBillBlockingIconLocator(String itemizedBilBlockingIconRowNumber) {
        return By.xpath("//tbody/tr[" + itemizedBilBlockingIconRowNumber + "]/td[4]//*[local-name()='svg' and @automation-id='table_1_svg']");
    }
    /* *************************************************************** */

    private static String showLessButtonCL = "Weniger anzeigen";

    private static String showMoreButtonCL = "Mehr anzeigen";

    private static String amountDateNotRetrievedCL = "Siehe Kostenübersicht";

    private static String tableDescriptionCL_Peter = "Du findest hier alle Details zu Deiner Kostenübersicht für folgendene Rufnummer:";

    private static String tableTitleCL = "Deine Übersicht";

    private static String tableDescription_CL = "Du findest hier die Kostenübersicht für all Deine registrierten Rufnummern.";

    private static String noInvoiceNotificationTitleCL = "Es gibt noch keine Übersicht";

    private static String noInvoiceNotificationDescriptionCL = "Deine erste Kostenübersicht kommt bald. Hier findest Du alle wichtigen Infos rund ums Thema Kosten.";

    private static String serviceErrorNotificationTitleCL = "Das hat leider nicht geklappt";

    private static String serviceErrorNotificationDescriptionCL = "Entschuldige bitte, unser Fehler. Versuch es einfach später nochmal.";

    private static String pdfNotBookedErrorNotificationTitle_CL = "Das hat leider nicht geklappt";

    private static String pdfNotBookedErrorNotificationText_CL = "Wir können Dir das Dokument mit der Kostenübersicht gerade nicht zum Download bereitstellen. Wichtig für Dich: Die Kostenübersicht wird nur dann angezeigt, wenn Du sie gebucht hast.\n" +
            "Du willst die Kostenübersicht haben? Dann ruf uns einfach an. Jeden Tag und kostenlos aus allen deutschen Netzen: 0800 172 1212\n" +
            "\n" +
            "Oder dauert das Laden vielleicht gerade etwas länger, weil es ein Problem mit Deiner Internetverbindung gibt? Dann versuch es bitte gleich nochmal.";
    private static String pdfNotBookedErrorIconText_CL = "Kostenübersicht nicht gefunden";

    private static String warningIconCL = "PDF-Dokument kann gerade nicht geladen werden";

    private static String rufnummerTableColumn_CL = "Rufnummer";

    private static String missingAllInfoNotificationTitle_CL = "Da ist etwas schief gelaufen";

    private static String missingAllInfoNotificationDescription_CL = "Die Daten für diese Rufnummer konnten nicht geladen werden. Unser Fehler... Versuch es bitte später nochmal.";

    private static String noInvoiceNotificationBody_CL = "Es gibt noch keine Übersicht. Hier findest Du alle wichtigen Infos zum Thema Rechnungen. In Kürze erscheint hier auch die erste Übersicht über Deine Kosten.";


    private static String creditAmountInfoTitleCl = "Du hast Guthaben";

    private static String creditAmountInfoDescriptionCl = "Dieses verrechnen wir mit der nächsten Rechnung. Wie sich der Betrag zusammensetzt, siehst Du auf Deiner PDF-Rechnung.";

    private String itemizedBillBlockingIcon_Cl = "Keine Verbindungsübersicht gebucht";
    private static String itemizedBillWarningIconCL = "Verbindungsübersicht nicht gefunden";

    private String peterTableDescription_Cl = "Du findest hier alle Details zu Deiner Kostenübersicht für folgendene Rufnummer:";

    private String notBookedItemizedBillDescriptionLinkCl = "Hast Du schon die Verbindungsübersicht gebucht? Beantrage sie einfach hier";
    private String notBookedHyperLinkText_CL = "Alles zur Rechnung";

    private String kayAndBartlTableDescription_Cl = "Du findest hier die Kostenübersicht für all Deine registrierten Rufnummern.";

    private String peterKostenubersichtPageHeaderCl = "Meine Kosten";
    private String costOverViewTableHeader = "Deine Übersicht";
    private String cssPropertyIncludesUnderline = "text-decoration";
    private String notReturnedCL = "Siehe Kostenübersicht";

    /* ********************************************************************** */
    // Constructor
    public Kostenubersicht(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Hard Reload")
    public void hardReloadMethod(){
        Actions actions = new Actions(driver.getDriver());
        actions.keyDown(Keys.CONTROL)
                .keyDown(Keys.SHIFT)
                .sendKeys("r")
                .keyUp(Keys.CONTROL)
                .keyUp(Keys.SHIFT)
                .build()
                .perform();
    }

    // Methods

    @Step("Click On Underlined Amount At The Table")
    public void clickOnFirstAmountAtTable(){
        driver.element().click(firstAmountAtTable);
    }
    @Step("Click On Siehe Kostenubersicht")
    public void clickOnNotReturnedAmountText(){
        driver.element().click(sieheKostenubersichtLocator);
    }

    @Step("Click 1st Amount At The Table")
    public void clickOnFirstAmountAtTheTable(){
        driver.element().click(sieheKostenubersichtLocator);
    }


    @Step("Click on show more button")
    public Kostenubersicht clickShowMore() {
        driver.element().click(getShowMoreButtonLocator());
        return this;
    }

    @Step("Click on show less button")
    public Kostenubersicht clickShowLess() {
        driver.element().click(getShowLessButtonLocator());
        return this;
    }

    @Step("wait for show more button text to be changed")
    public void waitForShowMoreBtnTextChange() {
        driver.element().waitForTextToChange(getShowMoreButtonLocator(), "Mehr anzeigen");
    }

    @Step("hover on credit icon")
    public void hoverOnCreditAmountIcon() {
        driver.element().click(creditAmountIcon);
    }

    /* *******************************WFCT-14089*************************** */
    public By getPreviewBillLocator(String billRow){
        return By.xpath("(//*[@automation-id='table_1_svg'])["+billRow+"]");
    }

    public By getDownloadBillLocator(String billRow){
        return By.xpath("(//*[@automation-id='table_2_svg'])["+billRow+"]");
    }

    @Step("Click On Preview Subscriber Bill By Its Order")
    public void clickOnPreviewSubscriberBillByOrder(String billRowOrder){
        driver.element().click(getPreviewBillLocator(billRowOrder));
    }

    @Step("Click On Download Subscriber Bill By Its Order")
    public void clickOnDownloadSubscriberBillByOrder(String billRowOrder){
        driver.element().click(getDownloadBillLocator(billRowOrder));
    }

    @Step("Click On Preview Itemized Bill By Its Order")
    public void clickOnPreviewItemizedBillByOrder(String billRowOrder){
        driver.element().click(getPreviewBillLocator(billRowOrder));
    }

    @Step("Click On Download Itemized Bill By Its Order")
    public void clickOnDownloadItemizedBillByOrder(String billRowOrder){
        driver.element().click(getDownloadBillLocator(billRowOrder));
    }

    @Step("Click On Exit Button")
    public void clickOnExitPreviewingBill(){
        driver.element().click(exitIcon);
    }

    @Step("Wait Till Tags Returned Successfully")
    public void waitTillTagsReturnedSuccessfully(){
        driver.verifyThat().element(dummyLocator).doesNotExist()
                .withCustomReportMessage("Assert That Previewed Tracking is returned Successfullty").perform();
    }



    /* ***************** WFCT_10240 ***************** */

    @Step("Select month from the month's filter")
    public void chooseMonthFilter(String choice) {
        driver.element().select(monthFilterLocator, choice);
    }

    @Step("Select number from the number's filter")
    public void choosePhoneNumberFilter(String choice) {
        String number = driver.element().getText(By.xpath("//option[@value='" + choice + "']")).trim();
        driver.element().select(mobileNumberFilterLocator, number);
    }

    public int getRowsCount() {
        return driver.element().getElementsCount(tableRowsLocator) - 1;
    }


    public SubscriberSummary clickOnLatestDetails() {
        driver.element().click(latestAmount);
        return new SubscriberSummary(driver);

    }

    @Step("click on the underlined amount")
    public SubscriberSummary clickOnTheFirstUnderlinedAmount() {
        driver.element().click(firstMonthAmountLocator);
        return new SubscriberSummary(driver);
    }

    @Step("click on not booked link")
    public void clickOnNotBookedLink() {
        driver.element().click(notBookedHyperLink_Locator);
    }

    @Step("wait for month to be selected")
    public void waitForMonthToBeSelected() {
        if (driver.element().getElementsCount(By.xpath("fakeLocator")) == 1) {
            driver.element().click(By.xpath("fakeLocator"));
        }
    }
    // Validations

    /* **************************WFCT-10480********************************** */
    public void assertOnNotRetrievedErrorNotificationTitle() {
        driver.verifyThat()
                .element(pdfNotBookedErrorNotificationTitle)
                .text()
                .isEqualTo(pdfNotBookedErrorNotificationTitle_CL)
                .withCustomReportMessage(" Error notification title assertion")
                .perform();
    }

    public void assertOnNotRetrievedErrorNotificationText() {
        driver.verifyThat()
                .element(pdfNotBookedErrorNotificationText)
                .textTrimmed()
                .contains(pdfNotBookedErrorNotificationText_CL)
                .withCustomReportMessage(" Error notification text assertion")
                .perform();
    }

    public void assertOnCostOverViewErrorIconText(String rowOrder, String columnOrder) {
        driver.verifyThat()
                .element(getPdfNotBookedErrorIcon(rowOrder, columnOrder))
                .text()
                .isEqualTo(pdfNotBookedErrorIconText_CL)
                .withCustomReportMessage(" Error icon text assertion")
                .perform();
    }

    public void assertOnErrorIcon(String rowOrder, String columnOrder) {
        driver.verifyThat()
                .element(getPdfNotBookedErrorIcon(rowOrder, columnOrder))
                .isVisible()
                .withCustomReportMessage(" Error icon assertion")
                .perform();
    }

    public void assertOnErrorNotificationNotDisplayed() {
        driver.verifyThat()
                .element(pdfNotBookedErrorNotificationTitle)
                .doesNotExist()
                .withCustomReportMessage(" Error notification not displayed assertion")
                .perform();
    }


    public void assertOnNotRetrievedConnectionPdfWarningText() {
        driver.verifyThat()
                .element(firstItemizedBillWarningLocatorNotification)
                .text()
                .isEqualTo(itemizedBillWarningIconCL)
                .withCustomReportMessage("Assert on not retrieved connection overview warning text")
                .perform();
    }

    public void assertOnNotRetrievedConnectionPdfWarningText(String rowOrder, String columnOrder) {
        driver.verifyThat()
                .element(getItemizedBillWarningLocatorNotification(rowOrder, columnOrder))
                .text()
                .isEqualTo(itemizedBillWarningIconCL)
                .withCustomReportMessage("Assert on not retrieved connection overview warning text")
                .perform();
    }


    /* ************************** WFCT-10156 ********************* */
    public void assertOnTableHeadLineText() {
        driver.verifyThat()
                .element(Kostenubersicht.getHeadLineLocator())
                .text().contains(tableTitleCL)
                .withCustomReportMessage("Assert on Headline Text")
                .perform();
    }

    public void assertOnTableDescriptionText() {
        driver.verifyThat()
                .element(Kostenubersicht.getDescriptionTextLocator())
                .text()
                .isEqualTo(tableDescription_CL)
                .withCustomReportMessage("Assert on description text")
                .perform();
    }


    public void assertOnTableDescriptionTextForPeter() {
        driver.verifyThat()
                .element(descriptionTextLocator)
                .text().contains(tableDescriptionCL_Peter)
                .withCustomReportMessage("assert on Table description text ")
                .perform();

    }

    public void assertOnMobileNumberTitleText() {
        driver.verifyThat()
                .element(Kostenubersicht.getMobileNumberTitleLocator())
                .text().isEqualTo(rufnummerTableColumn_CL)
                .withCustomReportMessage("assert on mobile number title text")
                .perform();
    }


    public void assertOnKostenTitleText() {
        driver.verifyThat()
                .element(amountTitleLocator)
                .exists()
                .withCustomReportMessage("Assert on Kosten title text")
                .perform();
    }

    public void assertOnCostOverviewTitleText() {
        driver.verifyThat()
                .element(Kostenubersicht.getCostOverviewTitleLocator())
                .exists()
                .withCustomReportMessage("Assert on cost overview title text")
                .perform();
    }

    public void assertOnConnectionOverviewTitleText() {
        driver.verifyThat()
                .element(Kostenubersicht.getItemizedBillTitleLocator())
                .exists()
                .withCustomReportMessage("Assert on connection overview title text")
                .perform();
    }

    public void assertOnTheFirstCostPdfDownloadIcon() {
        driver.verifyThat()
                .element(Kostenubersicht.getFirsrtCostOverviewDownloadLocator())
                .exists()
                .withCustomReportMessage("Assert on the First Cost overview Download icon")
                .perform();
    }

    public void assertOnTheFirstCostPdfDownloadIcon_Peter() {
        driver.verifyThat()
                .element(firsrtCostOverviewDownloadLocator_Peter)
                .exists()
                .withCustomReportMessage("Assert on the First Cost overview Download icon")
                .perform();
    }

    public void assertOnTheCostPdfDownloadIcon_Peter(String costPdfDownloadIcon) {
        driver.verifyThat()
                .element(getCostPdfDownloadIcon(costPdfDownloadIcon))
                .exists()
                .withCustomReportMessage("Assert on the First Cost overview Download icon")
                .perform();
    }

    public void assertOnCostPdfDownloadIcon_Peter(String tableRowOrder) {
        driver.verifyThat()
                .element(firsrtCostOverviewDownloadLocator_Peter)
                .exists()
                .withCustomReportMessage("Assert on the First Cost overview Download icon")
                .perform();
    }

    public void assertOnTheFirstCostPdfPreviewIcon() {
        driver.verifyThat()
                .element(Kostenubersicht.getFirstCostOverviewPreviewLocator())
                .exists()
                .withCustomReportMessage("Assert on the First Cost overview Preview icon")
                .perform();
    }

    public void assertOnTheFirstCostPdfPreviewIcon_Peter() {
        driver.verifyThat()
                .element(firstCostOverviewPreviewLocator_Peter)
                .exists()
                .withCustomReportMessage("Assert on the First Cost overview Preview icon")
                .perform();
    }

    public void assertOnTheCostPdfPreviewIcon_Peter(String tableRowOrder) {
        driver.verifyThat()
                .element(getCostPDFOverviewPreviewIconLocator(tableRowOrder))
                .exists()
                .withCustomReportMessage("Assert on the First Cost overview Preview icon")
                .perform();
    }

    public void assertOnTheFirstConnectionPdfDownloadIcon() {
        driver.verifyThat()
                .element(Kostenubersicht.getFirstItemizedBillDownloadLocator())
                .exists()
                .withCustomReportMessage("Assert on the First Connection bill Download icon")
                .perform();
    }

    public void assertOnTheFirstConnectionPdfDownloadIcon_Peter() {
        driver.verifyThat()
                .element(firstItemizedBillDownloadLocator_Peter)
                .exists()
                .withCustomReportMessage("Assert on the First Connection bill Download icon")
                .perform();
    }

    public void assertOnTheConnectionPdfDownloadIcon_Peter(String connectionPdfDownloadIcon_Peter) {
        driver.verifyThat()
                .element(getConnectionPdfDownloadIcon_Peter(connectionPdfDownloadIcon_Peter))
                .exists()
                .withCustomReportMessage("Assert on the First Connection bill Download icon")
                .perform();
    }

    public void assertOnTheSecondConnectionPdfDownloadIcon_Peter() {
        driver.verifyThat()
                .element(secondItemizedBillDownloadLocator_Peter)
                .exists()
                .withCustomReportMessage("Assert on the Second Connection bill Download icon")
                .perform();
    }

    public void assertOnTheFirstConnectionPdfPreviewIcon() {
        driver.verifyThat()
                .element(Kostenubersicht.getFirstItemizedBillPreviewLocator())
                .exists()
                .withCustomReportMessage("Assert on the First Connection bill Preview icon")
                .perform();
    }

    public void assertOnTheFirstConnectionPdfPreviewIcon_Peter() {
        driver.verifyThat()
                .element(firstItemizedBillPreviewLocator_Peter)
                .exists()
                .withCustomReportMessage("Assert on the First Connection bill Preview icon")
                .perform();
    }

    public void assertOnTheConnectionPdfPreviewIcon_Peter(String connectionPdfPreviewIcon_Peter) {
        driver.verifyThat()
                .element(getConnectionPdfPreviewIcon_Peter(connectionPdfPreviewIcon_Peter))
                .exists()
                .withCustomReportMessage("Assert on the First Connection bill Preview icon")
                .perform();
    }

    public void assertThatShowMoreBtnDoesNotExist() {
        driver.verifyThat()
                .element(Kostenubersicht.getShowMoreButtonLocator())
                .doesNotExist()
                .withCustomReportMessage("Assert that Show more button doesn't exist")
                .perform();

    }

    public void assertOnShowMoreBtnText() {
        driver.verifyThat()
                .element(Kostenubersicht.getShowMoreButtonLocator())
                .textTrimmed().isEqualTo(showMoreButtonCL)
                .withCustomReportMessage("Showmore button first Assertion")
                .perform();
    }

    public void assertOnShowLessBtnText() {
        driver.verifyThat()
                .element(Kostenubersicht.getShowLessButtonLocator())
                .textTrimmed().isEqualTo(showLessButtonCL)
                .withCustomReportMessage("Showless button Assertion")
                .perform();
    }

    /* ********************** WFCT-10305 *********************** */
    public void assertOnNotReturnedAmountText() {
        driver.verifyThat()
                .element(firstMonthAmountLocator)
                .textTrimmed()
                .isEqualTo(amountDateNotRetrievedCL)
                .withCustomReportMessage("Assert on Not Returned Amount text")
                .perform();
    }

    public void assertOnNotRetrievedConnectionPdfWarningIcon() {
        driver.verifyThat()
                .element(firstItemizedBillWarningLocator)
                .exists()
                .withCustomReportMessage("Assert on not retrieved connection overview warning icon")
                .perform();
    }

    public void assertOnNotRetrievedPdfWarningIcon(String rowOrder, String columnOrder) {
        driver.verifyThat()
                .element(getWarningIconLocator(rowOrder, columnOrder))
                .exists()
                .withCustomReportMessage("Assert on not retrieved PDF warning icon")
                .perform();
    }

    public void assertOnMissingAllInfoNotificationTitleText() {
        driver.verifyThat().
                element(missingAllInformationNotificationTitleLocator)
                .text()
                .isEqualTo(missingAllInfoNotificationTitle_CL)
                .withCustomReportMessage("Assert on missing all info Notification title text")
                .perform();
    }

    public void assertOnMissingAllInfoNotificationBodyText() {
        driver.verifyThat().
                element(Kostenubersicht.missingAllInformationNotificationDescriptionLocator)
                .text()
                .isEqualTo(missingAllInfoNotificationDescription_CL)
                .withCustomReportMessage("Assert on missing all info Notification body text")
                .perform();
    }

    public void assertOnNotReturnedNumber(String num) {
        driver.verifyThat()
                .element(firstNumberLocator)
                .text().doesNotEqual(num)
                .withCustomReportMessage("Assert on complete information missing for one month for one MSISDN")
                .perform();

    }

    public void assertOnEmptyBeNotificationTitleText() {
        driver.verifyThat().
                element(emptyBeNotificationTitleLocator)
                .text()
                .isEqualTo(noInvoiceNotificationTitleCL)
                .withCustomReportMessage("Assert on empty BE Notification title text")
                .perform();
    }

    public void assertOnEmptyBeNotificationBodyText() {
        driver.verifyThat().
                element(emptyBeNotificationDescriptionLocator)
                .text()
                .isEqualTo(noInvoiceNotificationBody_CL)
                .withCustomReportMessage("Assert on empty BE Notification body text")
                .perform();
    }

    public void assertOnErrorNotificationTitleText() {
        driver.verifyThat().
                element(serviceErrorNotificationTitleLocator)
                .text()
                .isEqualTo(serviceErrorNotificationTitleCL)
                .withCustomReportMessage("Assert on error Notification title text")
                .perform();
    }

    public void assertOnErrorNotificationBodyText() {
        driver.verifyThat().
                element(serviceErrorNotificationDescriptionLocator)
                .text()
                .isEqualTo(serviceErrorNotificationDescriptionCL)
                .withCustomReportMessage("Assert on error Notification description text")
                .perform();
    }

    /* *****************WFCT-9236 ***********************/
    public void assertOnMonthTitleText() {
        driver.verifyThat()
                .element(dateColumnLocator)
                .exists().withCustomReportMessage("assert on Month Title text")
                .perform();
    }

    public void assertOnNotReturnedMonthText() {
        driver.verifyThat()
                .element(firstMonthNameLocator)
                .textTrimmed()
                .isEqualTo(amountDateNotRetrievedCL)
                .withCustomReportMessage("assert On not retrieved month text ")
                .perform();
    }

    public void assertOnNotReturnedConnectionOverViewIconText_Peter() {
        driver.verifyThat()
                .element(firstItemizedBillWarningLocator_Peter)
                .attribute("title").isEqualTo(warningIconCL)
                .withCustomReportMessage("assert that connection overview bill with PDF not retrieved")
                .perform();

    }

    public void assertOnNotReturnedCostOverViewIconText_Peter() {
        driver.verifyThat()
                .element(firstCostOverviewWarningLocator_Peter)
                .attribute("title").isEqualTo(pdfNotBookedErrorIconText_CL)
                .withCustomReportMessage("assert that connection overview bill with PDF not retrieved")
                .perform();

    }

    public void assertThatConnectionOverviewColumnNotExist() {
        driver.verifyThat()
                .element(itemizedBillTitleLocator)
                .doesNotExist()
                .withCustomReportMessage("Assert That connection overview Column doesn't exist")
                .perform();
    }

    public void assertOnEmptyResponseNotificationTitle_Peter() {
        driver.verifyThat()
                .element(emptyBeNotificationTitleLocator)
                .text()
                .isEqualTo(noInvoiceNotificationTitleCL)
                .withCustomReportMessage("assert on empty notification title text")
                .perform();
    }

    public void assertOnEmptyResponseNotificationDescription_Peter() {
        driver.verifyThat()
                .element(emptyBeNotificationDescriptionLocator)
                .text()
                .isEqualTo(noInvoiceNotificationDescriptionCL)
                .withCustomReportMessage("assert on empty notification description text")
                .perform();
    }

    public void assertOnErrorServiceNotificationTitle_Peter() {
        driver.verifyThat()
                .element(serviceErrorNotificationTitleLocator)
                .text()
                .isEqualTo(serviceErrorNotificationTitleCL)
                .withCustomReportMessage("assert on service error notification title text")
                .perform();
    }

    public void assertOnErrorServiceNotificationDescription_Peter() {
        driver.verifyThat()
                .element(serviceErrorNotificationDescriptionLocator)
                .text()
                .isEqualTo(serviceErrorNotificationDescriptionCL)
                .withCustomReportMessage("assert on service error notification description text")
                .perform();
    }

    /* *********************WFCT-10240********************* */
    public void assertThatInvoicesNumEquals1() {
        Validations.verifyThat()
                .number(getRowsCount())
                .isEqualTo(1)
                .withCustomReportMessage("Assert That invoices number = 1")
                .perform();
    }

    public void assertThatInvoicesNumMoreThan1() {
        Validations.verifyThat()
                .number(getRowsCount())
                .isGreaterThan(1)
                .withCustomReportMessage("Assert That invoices number is more than 1")
                .perform();
    }


    public void assertThatInvoicesNumEquals12() {
        Validations.verifyThat()
                .number(getRowsCount())
                .isEqualTo(12)
                .withCustomReportMessage("Assert That invoices number is more than 1")
                .perform();
    }

    public void assertThatInvoicesNumMoreThan12() {
        Validations.verifyThat()
                .number(getRowsCount())
                .isGreaterThan(12)
                .withCustomReportMessage("Assert That invoices number is more than 12")
                .perform();
    }

    @Step("assert That amount column exists ")
    public void assertThatAmountColumnExists() {
        driver.verifyThat()
                .element(amountTitleLocator).exists()
                .withCustomReportMessage("assert that amount column exists").perform();
    }


    @Step("assert that subscriber number exists more than one time")
    public void assertThatNumberIsDuplicated(String Number) {
        Validations.verifyThat().number(getNumberCountInTable(Number)).isGreaterThan(1).
                withCustomReportMessage("assert that number is duplicated").perform();
    }

    @Step("assert that only eh selected number is displayed")
    public void assertThatOnlyTheSelectedNumberIsDisplayed(String Number) {
        Validations.verifyThat().number(getNumberCountInTable(Number)).isEqualTo(getRowsCount())
                .withCustomReportMessage("Assert that only the selected number is displayed").perform();

    }

    @Step("assert that connection overview bill exists")
    public void assertThatConnectionOverviewBillsExist(String rowOrder) {
        driver.verifyThat()
                .element(getIConnectionOverviewPreviewIconLocator(rowOrder))
                .exists().withCustomReportMessage("assert that " + rowOrder + " row connection overview is exist").perform();
    }

    @Step("assert that connection overview column doesn't exist")
    public void assertThatConnectionOverviewColumnDoesNotExist() {
        driver.verifyThat()
                .element(itemizedBillTitleLocator).doesNotExist()
                .withCustomReportMessage("assert that connection overview column does not exist").perform();
    }

    @Step("assert that credit icon notification title is correct")
    public void assertThatCreditIconNotificationTitleIsCorrect(String creditIconRowOrder) {
        driver.assertThat()
                .element(getCreditAmountIconInfoTitleLocator(creditIconRowOrder)).text()
                .isEqualTo(creditAmountInfoTitleCl)
                .withCustomReportMessage("assert that credit notification title is correct")
                .perform();
    }

    @Step("assert that credit icon notification description is correct")
    public void assertThatCreditIconNotificationDescriptionIsCorrect(String creditIconRowOrder) {
        driver.assertThat()
                .element(getCreditAmountIconInfoDescriptionLocator(creditIconRowOrder)).text()
                .isEqualTo(creditAmountInfoDescriptionCl)
                .withCustomReportMessage("assert that credit notification Description is correct")
                .perform();
    }

    @Step("assert that credit amount written in green")
    public void assertThatCreditAmountWrittenInGreen(String creditIconRowOrder) {
        driver.assertThat()
                .element(getCreditAmountLocator(creditIconRowOrder)).cssProperty("color")
                .contains("0, 138, 0")
                .withCustomReportMessage("assert that amount text in green color")
                .perform();
    }

    @Step("assert that the month is selected from dropdown list")
    public void assertThatMonthIsSelected(String month) {
        driver.verifyThat()
                .element(getDropdownMonthLocator(month)).isSelected()
                .withCustomReportMessage("assert that month is selected").perform();
    }

    @Step("assert that peter not booked table description is correct")
    public void assertOnPeterNotBookedItemizedBillTableDescription() {
        driver.verifyThat().element(tableDescriptionLocator).text()
                .contains(peterTableDescription_Cl)
                .withCustomReportMessage("assert that peter not booked table description is correct")
                .perform();

    }

    @Step("assert that peter Partially booked table description is correct")
    public void assertOnPeterPartiallyBookedItemizedBillTableDescription() {
        driver.verifyThat().element(tableDescriptionLocator).text()
                .contains(peterTableDescription_Cl)
                .withCustomReportMessage("assert that peter Partially booked table description is correct")
                .perform();
    }

    @Step("assert that peter not retrieved itemized bill table description is correct")
    public void assertOnPeterNotRetrievedItemizedBillTableDescription() {
        driver.verifyThat().element(tableDescriptionLocator).text()
                .contains(peterTableDescription_Cl)
                .withCustomReportMessage("assert that peter not retrieved itemized bill table description is correct")
                .perform();
    }

    @Step("assert that Kay||Bart not booked table description is correct")
    public void assertOnKayAndBartNotBookedItemizedBillTableDescription() {
        driver.verifyThat().element(tableDescriptionLocator).text()
                .isEqualTo(kayAndBartlTableDescription_Cl)
                .withCustomReportMessage("assert that Kay||Bart not booked table description is correct")
                .perform();
    }

    @Step("assert that Kay||Bart Partially booked table description is correct")
    public void assertOnKayAndBartPartiallyBookedItemizedBillTableDescription() {
        driver.verifyThat().element(tableDescriptionLocator).text()
                .isEqualTo(kayAndBartlTableDescription_Cl)
                .withCustomReportMessage("assert that Kay||Bart Partially booked table description is correct")
                .perform();
    }

    @Step("assert that Kay||Bart not retrieved itemized bill table description is correct")
    public void assertOnKayAndBartNotRetrievedItemizedBillTableDescription() {
        driver.verifyThat().element(tableDescriptionLocator).text()
                .isEqualTo(kayAndBartlTableDescription_Cl)
                .withCustomReportMessage("assert that Kay||Bart not retrieved itemized bill table description is correct")
                .perform();
    }

    @Step("assert that blocking icon exists")
    public void assertThatBlockingIconExists(String rowOrder) {
        driver.verifyThat()
                .element(getItemizedBillBlockingIconLocator(rowOrder)).exists()
                .withCustomReportMessage("assert that blocking icon exists").perform();
    }

    @Step("assert on blocking icon cl")
    public void assertOnBlockingIconCl(String rowOrder) {
        driver.verifyThat()
                .element(getItemizedBillBlockingIconLocator(rowOrder)).text().isEqualTo(itemizedBillBlockingIcon_Cl)
                .withCustomReportMessage("assert on blocking icon cl").perform();
    }

    @Step("assert that warning icon exists")
    public void assertThatWarningIconExists(String rowOrder) {
        driver.verifyThat()
                .element(getItemizedBillWarningIconLocator(rowOrder)).exists()
                .withCustomReportMessage("assert that warning icon exists").perform();
    }

    @Step("assert on warning icon cl")
    public void assertOnWarningIconCl(String rowOrder) {
        driver.verifyThat()
                .element(getItemizedBillWarningIconLocator(rowOrder)).text().isEqualTo(itemizedBillWarningIconCL)
                .withCustomReportMessage("assert on warning icon cl").perform();
    }

    @Step("assert on not booked link cl")
    public void assertOnNotBookedLinkCl() {
        driver.verifyThat().element(notBookedDescriptionTextLocator).textTrimmed()
                .contains(notBookedItemizedBillDescriptionLinkCl)
                .withCustomReportMessage("assert that peter not booked table description is correct")
                .perform();
        driver.verifyThat().element(notBookedHyperLink_Locator).textTrimmed().isEqualTo(notBookedHyperLinkText_CL).withCustomReportMessage("Assert on hyperlink text").perform();
    }

    @Step("assert that not booked link does not exist")
    public void assertThatNotBookedLinkDoesNotExist() {
        driver.verifyThat().element(notBookedDescriptionTextLocator).doesNotExist()
                .withCustomReportMessage("assert that not booked link doesn't exist").perform();
    }

    public void assertThatKostenubersichtPageIsLoaded() {
        hardReloadMethod();
        driver.assertThat().browser().url().isEqualTo("https://simplicity.wf-de.vodafone.com/meinvodafone/services/ihre-rechnungen/kostenuebersicht")
                .withCustomReportMessage("Assert That Kostenubersicht Page Is Loaded").perform();

    }

    public void assertThatUserNavigatedBackToCostOverviewPage(){
                driver.assertThat().element(kostenubersichtTableHeaderLocator).textTrimmed().isEqualTo(costOverViewTableHeader)
                .withCustomReportMessage("Assert That User Navigated To Cost Overview Page").perform();
    }

    public void assertThatUserNavigatedBackToCostOverviewPageWithWait(){
        driver.waitUntil(ExpectedConditions.visibilityOfElementLocated(kostenubersichtTableHeaderLocator));
        driver.verifyThat().element(kostenubersichtTableHeaderLocator).textTrimmed().isEqualTo(costOverViewTableHeader)
                .withCustomReportMessage("Assert That User Navigated To Cost Overview Page").perform();
    }

    public void asssertOnAmountNotReturnedText(){
        driver.verifyThat().element(sieheKostenubersichtLocator).textTrimmed()
                .isEqualTo(notReturnedCL).withCustomReportMessage("Assert Kostenubersicht Text")
                .perform();
    }
    public void asssertThatAmountAtTheTableIsUnderlined(String underlineAndColorCssProperty){
        driver.verifyThat().element(firstAmountAtTable).cssProperty(cssPropertyIncludesUnderline)
                .isEqualTo(underlineAndColorCssProperty).withCustomReportMessage("Assert That Table Amount Is Underlined")
                .perform();
    }

    public void asssertThatAmountAtTheTableIsNotUnderlinedAndItsColor(String notUnderlineAndColorCssProperty){
        driver.verifyThat().element(firstAmountAtTable).cssProperty(cssPropertyIncludesUnderline)
                .isEqualTo(notUnderlineAndColorCssProperty).withCustomReportMessage("Assert That Table Amount Is Underlined")
                .perform();
    }

    public void assertOnFirstAmountAtTableColorAndItsNotUnderlined(String notUnderlineAndColorCssProperty){
        driver.verifyThat().element(firstAmountAtTableNotReturned).cssProperty(cssPropertyIncludesUnderline)
                .isEqualTo(notUnderlineAndColorCssProperty).withCustomReportMessage("Assert That Table Amount Is Underlined")
                .perform();
    }

    public void asssertThatAmountAtTheTableIsUnderlinedWithCredit(String underlineAndColorCssProperty){
        driver.verifyThat().element(firstAmountAtTableWithCredit).cssProperty(cssPropertyIncludesUnderline)
                .isEqualTo(underlineAndColorCssProperty).withCustomReportMessage("Assert That Table Amount Is Underlined")
                .perform();
    }

    public void assertOnMSISDN(String msisdn){
        driver.verifyThat().element(msisdnLocator).textTrimmed()
                .isEqualTo(msisdn).withCustomReportMessage("Assert On MSISDN")
                .perform();
    }



    public void assertThatTheAmountTextColorIsGreen() {
        driver.verifyThat()
                .element(firstAmountAtTableWithCredit).cssProperty("color")
                .contains("0, 138, 0")
                .withCustomReportMessage("assert that amount text in green color")
                .perform();
    }

    public void assertOnNotificationColor(String notificationMessageColor){
        driver.verifyThat().element(blueBoxMsgLocator).cssProperty("border-bottom-color")
                .contains(notificationMessageColor).withCustomReportMessage("Assert That Blue Box Exists").perform();
    }

    public void assertOnFirstNumberAtTheTable(String num) {
        driver.verifyThat()
                .element(firstNumberLocator)
                .text().doesNotEqual(num)
                .withCustomReportMessage("Assert on complete information missing for one month for one MSISDN")
                .perform();

    }


}



