package de.vodafone.pages.billing;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class Rechnungen {
    SHAFT.GUI.WebDriver driver;

    private static By firstMonthNameLocator = By.xpath("//table/tbody/tr[1]/td[1]/span");
    private static By secondMonthNameLocator = By.xpath("//table/tbody/tr[2]/td[1]/span");
    private static By tableTitleLocator = By.xpath("//h3[contains(.,\" Rechnungsarchiv \")]");
    private static By tableDescriptionLocator = By.xpath("//p[@automation-id='table_description_tv']");
    private static By tableDescriptionLinkLocator = By.xpath("//p[@automation-id='table_description_tv']/a");

    private static By dateColumnLocator = By.xpath("//tr[@automation-id=\"table_thead\"]/th/h5[contains(.,\"Datum\")]");
    private static By amountColumnLocator = By.xpath("//tr[@automation-id=\"table_thead\"]/th/h5[contains(.,\"Betrag\")]");
    private static By dueDateColumnLocator = By.xpath("//tr[@automation-id=\"table_thead\"]/th/h5[contains(.,\"Zahlbar zum\")]");
    private static By invoiceColumnLocator = By.xpath("//tr[@automation-id=\"table_thead\"]/th/h5[contains(.,\"Rechnung\")]");
    private static By itemizedColumnLocator = By.xpath("//tr[@automation-id='table_thead']/th/h5[contains(.,'Verbindungs')]");
    private static By showMoreButtonLocator = By.xpath("//button[@automation-id=\"see_more_btn\"]");
    private static By invoicePreviewLocator = By.xpath("//table/tbody/tr[1]/td[4]//*[local-name()='svg' and @automation-id='table_1_svg']");
    private static By invoiceDownloadLocator = By.xpath("//table/tbody/tr[1]/td[4]//*[local-name()='svg' and @automation-id='table_2_svg']");
    private static By itemizedPreviewLocator = By.xpath("//table/tbody/tr[1]/td[5]//*[local-name()='svg' and @automation-id='table_1_svg']");
    private static By itemizedDownloadLocator = By.xpath("//table/tbody/tr[1]/td[5]//*[local-name()='svg' and @automation-id='table_2_svg']");
    /* ******* WFCT-9503 Locators ******* */
    private static By creditAmountGraphTextLocator = By.xpath("//span[@automation-id='creditText_tv']");
    private static By CreditAmountInfoIconLocator = By.xpath("//table/tbody/tr[1]/td[2]/span[2]/inline-tooltip/div/div/*[local-name()='svg' and @class='i-sml i-grey']");
    private static By CreditAmountInfoTitleLocator = By.xpath("//table/tbody/tr[1]/td[2]/span[2]/inline-tooltip/div/div[2]/div[1]");
    private static By CreditAmountInfoDescriptionLocator = By.xpath("//table/tbody/tr[1]/td[2]/span[2]/inline-tooltip/div/div[2]/div[2]");
    private static By firstMonthAmountLocator = By.xpath("//table[@automation-id=\"root_table\"]/tbody/tr[1]/td[2]/span[1]");
    private static By firstMonthDueDateLocator = By.xpath("//table[@automation-id=\"root_table\"]/tbody/tr[1]/td[3]/span");
    private static By firstMonthBarLocator = By.xpath("//div[@id='line-11']");
    private static By secondMonthBarLocator = By.xpath("//div[@id='line-10']");
    private static By serviceErrorNotificationDescriptionLocator = By.xpath("//p[@class=\"notification-text mb-10 mt-10\"]");
    private static By serviceErrorNotificationTitleLocator = By.xpath("(//h4[@class=\"flexDiv\"])[1]");
    private static By noInvoiceNotificationDescriptionLocator = By.xpath("//p[@class=\"notification-text mb-10 mt-10\"]");
    private static By noInvoiceNotificationTitleLocator = By.xpath("//h4[@class='flexDiv']");
    private static By serviceErrorNotificationButtonLocator = By.xpath("//button[@automation-id='328686_btn']");
    private By detailsLocator = By.xpath("//div[@id='sideText-11']//a");
    private static By firstRowInvoiceBillWarningIconLocator = By.xpath("//table/tbody/tr[1]/td[4]//*[local-name()='svg' and @automation-id='table_1_svg']/*[name()='use']");

    private static By secondRowItemizedBillWarningIconLocator = By.xpath("//table/tbody/tr[2]/td[5]//*[local-name()='svg' and @automation-id='table_1_svg']/*[name()='use']");

    private static By firstRowInvoiceBillWarningTextLocator = By.xpath("//table/tbody/tr[1]/td[4]//*[local-name()='svg' and @automation-id='table_1_svg']/*[name()='title']");
    private static By secondRowItemizedBillWarningTextLocator = By.xpath("//table/tbody/tr[2]/td[5]//*[local-name()='svg' and @automation-id='table_1_svg']/*[name()='title']");
    public static By graphBarsLocator = By.xpath("//div[starts-with(@id, 'line')]");

    private By notRetrievedItemizedBillNotificationLocator = By.xpath("//div[@automation-id='missing_documents_nt']");
    private By notRetrievedItemizedBillNotificationTextLocator = By.xpath("//div[@automation-id='missing_documents_nt']//p");
    private By notRetrievedItemizedBillNotificationCloseIconLocator = By.xpath("//div[@automation-id='missing_documents_nt']//span");
    private By partiallyBookedItemizedBillNotificationLocator = By.xpath("//div[@automation-id='notBooked_Documents_nt']");
    private By partiallyBookedItemizedBillNotificationTextLocator = By.xpath("//div[@automation-id='notBooked_Documents_nt']//p");
    private By partiallyBookedItemizedBillNotificationCloseIconLocator = By.xpath("//div[@automation-id='notBooked_Documents_nt']//span");
    private By itemizedBillColumnLocator = By.xpath("//h5[contains(.,'Verbindungs')]");
    private static By billingSettingLinkLocator = By.xpath("//span[@automation-id='undefined_description_tv']");
    private static By lastChartBarLocator = By.xpath("//div[@id = 'line-11']");
    private static By paperOnlyNotificationBackGroundLocator = By.xpath("//div[@automation-id='paperBills_nt']/*");
    private static By oldOnlineNotificationBackGroundLocator = By.xpath("//div[@automation-id='oldOnline_nt']/*");
    private static By paperAndOnlineNotificationBackGroundLocator = By.xpath("//div[@automation-id='emailAndpaper_nt']/*");
    private By selectAllCheckboxLocator = By.xpath("(//div[@class='ws10-form-selection-control__item ws10-form-selection-control__item--checkbox ws10-spacing-padding-0'])[1]");
    private By downloadAllBtnLocator = By.xpath("//a[@automation-id='collectiveBillDownload_Link']");
    private By errorNotificationHeaderLocator = By.xpath("(//div[@automation-id='successMsg_tv'])[2]//h4");
    private By errorNotificationBodyLocator = By.xpath("//p[@class='notification-text mb-10 mt-10']");
    /*
    **********************************WFCT-12634 Locators*************************************
     */

    private By editBtn_Bearbeiten_Locator = By.xpath("//div[@automation-id='itemizedBillSingleNumberData_tv']//button");
    private By editBtn_Bearbeiten_Locator_MultipleCase = By.xpath("//button[@automation-id='itemizedBillNavigateButton_btn']");
    private By itemizedBillFailureMessageLocator_Headline = By.xpath("//div[@class='item-2 w-100']/h4");
    private By itemizedBillFailureMessageLocator_Body = By.xpath("//p[@class='notification-text mb-10 mt-10']");
    private By einstellungenTitleLocator = By.xpath("//h3[@automation-id='itemizedBillSingleNumberDataHeadline_tv']");
    private By einstellungenTitleLocator_Multiple = By.xpath("//h3[@automation-id='itemizedBillMultipleNumberDataHeadline_tv']");
    private By einstellungenDescriptionLocator = By.xpath("//p[@automation-id='itemizedBillSingleNumberDataText_tv']");
    private By einstellungenDescriptionLocator_Multiple = By.xpath("//p[@automation-id='itemizedBillMultipleNumberDataText_tv']");
    private By einstellungenNumberSettingsLocator = By.xpath("//p[@automation-id='itemizedBillSingleNumberDataBillNumber_tv']");
    private By billingTypeLocator = By.xpath("//p[@automation-id='itemizedBillSingleNumberDataDisplayText_tv']");
    private By noItemizedBill_Locator= By.xpath("//h4[@automation-id='itemizedBillMultipleNumberDataCategory_tv']");
    private By limitedItemizedBill_Locator= By.xpath("//h4[@automation-id='itemizedBillMultipleNumberDataLimited_tv']");
    private By CompleteItemizedBill_Locator= By.xpath("//h4[@automation-id='itemizedBillMultipleNumberDataComplete_tv']");
    private By invoiceSettings_Rechnungseinstellungen_Locator = By.xpath("//a[@automation-id='Einstellungen_Link']");
    private By rechnungenPageHeaderLocator = By.xpath("//div[@automation-id=\"pageHeader_tv\"]/h1");
    private By detailsBtn = By.xpath("(//a[@class='unitymedia-bill-chart-container__chart-content__bar-container__content__info__details'])[1]");
    private By kostenubersichtLocator = By.xpath("//*[@automation-id='Kostenübersicht_Link']");
    private By exitIcon = By.xpath("//button[@class='nsm-dialog-btn-close']");
    private By dummyLocator = By.xpath("");

    private By getCreditAmountInfoIconLocator (String rowNum){
        return By.xpath("//table/tbody/tr["+rowNum+"]/td[2]/span[2]/inline-tooltip/div/div/*[local-name()='svg' and @class='i-sml i-grey']");
    }
    private  By getCreditAmountInfoTitleLocator (String rowNum){
        return By.xpath("//table/tbody/tr["+rowNum+"]/td[2]/span[2]/inline-tooltip/div/div[2]/div[1]");
    }
    private  By getCreditAmountInfoDescriptionLocator(String rowNum){
        return By.xpath("//table/tbody/tr["+rowNum+"]/td[2]/span[2]/inline-tooltip/div/div[2]/div[2]");
    }

    private By getDetailsLocatorAtBillChartByIndex(String latestDetailsIndex){
        return By.xpath("(//a[@class='unitymedia-bill-chart-container__chart-content__bar-container__content__info__details'])["+latestDetailsIndex+"]");
    }


    public static By getLastChartBarLocator() {
        return lastChartBarLocator;
    }

    public static By getBillingSettingLinkLocator() {
        return billingSettingLinkLocator;
    }

    public static By getCreditAmountGraphTextLocator() {
        return creditAmountGraphTextLocator;
    }


    public static By getFirstMonthAmountLocator() {
        return firstMonthAmountLocator;
    }

    public static By getAmountLocator(String rowNum) {
        return By.xpath("//table[@automation-id=\"root_table\"]/tbody/tr["+rowNum+"]/td[2]/span[1]");
    }

    public static By getFirstMonthDueDateLocator() {
        return firstMonthDueDateLocator;
    }

    public static By getFirstMonthBarLocator() {
        return firstMonthBarLocator;
    }

    public static By getServiceErrorNotificationDescriptionLocator() {
        return serviceErrorNotificationDescriptionLocator;
    }

    public static By getServiceErrorNotificationTitleLocator() {
        return serviceErrorNotificationTitleLocator;
    }

    public static By getNoInvoiceNotificationDescriptionLocator() {
        return noInvoiceNotificationDescriptionLocator;
    }

    public static By getNoInvoiceNotificationTitleLocator() {
        return noInvoiceNotificationTitleLocator;
    }

    public static By getServiceErrorNotificationButtonLocator() {
        return serviceErrorNotificationButtonLocator;
    }

    public static By getSecondRowItemizedBillWarningTextLocator() {
        return secondRowItemizedBillWarningTextLocator;
    }

    public static By getFirstRowInvoiceBillWarningTextLocator() {
        return firstRowInvoiceBillWarningTextLocator;
    }

    public static String getCreditAmountTextCl() {
        return creditAmountTextCl;
    }

    public static String getItemizedPdfWarningIconCL() {
        return itemizedPdfWarningIconCL;
    }

    public static String getInvoicePdfWarningIconCL() {
        return invoicePdfWarningIconCL;
    }

    public static String getNoInvoiceNotificationDescriptionCL() {
        return noInvoiceNotificationDescriptionCL;
    }

    public static String getNoInvoiceNotificationTitleCL() {
        return noInvoiceNotificationTitleCL;
    }

    public static String getServiceErrorNotificationButtonCL() {
        return serviceErrorNotificationButtonCL;
    }

    public static String getServiceErrorNotificationDescriptionCL() {
        return serviceErrorNotificationDescriptionCL;
    }

    public static String getServiceErrorNotificationTitleCL() {
        return serviceErrorNotificationTitleCL;
    }

    public static String getCreditAmountInfoDescriptionCl() {
        return creditAmountInfoDescriptionCl;
    }

    public static String getCreditAmountInfoTitleCl() {
        return creditAmountInfoTitleCl;
    }

    public static String getAmountDateNotRetrievedCL() {
        return amountDateNotRetrievedCL;
    }

    public By getInvoiceCheckboxLocator(int checkBoxOrder) {
        return By.xpath("(//div[@class='ws10-form-selection-control__item ws10-form-selection-control__item--checkbox ws10-spacing-padding-0'])[" + (checkBoxOrder + 1) + "]");
    }




    public By getMonthTextLocator(int monthOrder) {
        return By.xpath("(//p[@class='ws10-spacing-margin-0'])[" + (monthOrder + 1) + "]");
    }

    //CL

    private String notRetrievedItemizedBillNotification_Cl = "Du kannst an einigen Stellen kein Dokument sehen?";


    private String partiallyBookedItemizedBillNotification_Cl = "Wir können Dir leider nicht alle Dokumente zum Download bereitstellen.";

    private String notRetrievedItemizedBillTableDescription_Cl = "Hier findest Du alle Deine Rechnungen als PDF-Dokumente. Du kannst Dir alle Details anschauen und die Rechnungen herunterladen.";

    private String partiallyBookedItemizedBillTableDescription_Cl = "Hier findest Du alle Deine Rechnungen als PDF-Dokumente. Du kannst Dir alle Details anschauen und die Rechnungen herunterladen. Hast Du schon die Verbindungsübersicht gebucht? Beantrage sie einfach hier:";
    private String notBookedItemizedBillTableDescription_Cl = "Hier findest Du alle Deine Rechnungen als PDF-Dokumente. Du kannst Dir alle Details anschauen und die Rechnungen herunterladen. Hast Du schon die Verbindungsübersicht gebucht? Beantrage sie einfach hier";
    private String partiallyBookedItemizedBillTableDescription_Link_CL = "Alles zur Rechnung.";
    private String itemizedBillBlockingIcon_Cl = "Keine Verbindungsübersicht gebucht";
    private static String itemizedBillWarningIconCL = "Verbindungsübersicht nicht gefunden";

    private static String creditAmountTextCl = "Guthaben";
    private static String creditAmountInfoTitleCl = "Du hast Guthaben";
    private static String creditAmountInfoDescriptionCl = "Dieses verrechnen wir mit der nächsten Rechnung. Wie sich der Betrag zusammensetzt, siehst Du auf Deiner PDF-Rechnung.";
    private static String serviceErrorNotificationTitleCL = "Das hat leider nicht geklappt";
    private static String serviceErrorNotificationDescriptionCL = "Entschuldige bitte, unser Fehler. Versuch es einfach später nochmal.";
    private static String serviceErrorNotificationButtonCL = "Nochmal versuchen";
    private static String noInvoiceNotificationTitleCL = "Es gibt noch keine Rechnung";
    private static String noInvoiceNotificationDescriptionCL = "Deine erste Rechnung kommt bald. Hier findest Du alle wichtigen Infos rund ums Thema Rechnung.";
    private static String itemizedPdfWarningIconCL = "Verbindungsübersicht nicht gefunden";
    private static String invoicePdfWarningIconCL = "PDF-Dokument kann gerade nicht geladen werden";
    private static String amountDateNotRetrievedCL = "Siehe Rechnung";
    private String tableDescription = "Alle Details zu Deinen Rechnungen. Und die Verbindungsübersicht der letzten 6 Monate, falls Du sie gebucht hast.";
    private String tableDescription_MarieNotUsageItemized = "Hier findest Du alle Deine Rechnungen als PDF-Dokumente. Du kannst Dir alle Details anschauen und die Rechnungen herunterladen.";
    private String tableDescription_MarieNotRetrievedItemized = "Hier findest Du alle Deine Rechnungen als PDF-Dokumente. Du kannst Dir alle Details anschauen und die Rechnungen herunterladen. Hast Du schon die Verbindungsübersicht gebucht? Beantrage sie einfach hier:";
    private String tableDescriptionHyperLink_CL =  "Alles zur Rechnung.";
    private String tableTitle = "Rechnungsarchiv";
    private String showMoreButtonCL = "Mehr anzeigen";
    private String ShowLessButtonCL = "Weniger anzeigen";
    private static String collectiveErrorNotificationBody_CL = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal. Oder lad die Dokumente für jeden Monat einzeln herunter.";
    private static String paperNotificationLink_CL = "Zu den Rechnungseinstellungen";
    private static String paperNotificationTitle_CL = "Gut zu wissen";
    private static String paperOnlyNotificationBody_CL = "Du bekommst Deine Rechnungen noch in Papierform. Stell bitte auf Online-Rechnung um, um hier zukünftig Deine Rechnungen zu sehen.";

    private static String oldOnlineNotificationBody_CL = "Hier siehst Du momentan nur ältere Rechnungen. Wechsle bitte von Papier zu Online-Rechnung, um auch Deine aktuellen und zukünftigen Rechnungen sehen zu können.";

    private static String paperAndOnlineNotificationBody_CL = "Du bekommst Deine Rechnungen auch noch in Papierform. Wechsle bitte komplett zu Online-Rechnung und schone damit ganz einfach die Umwelt.";
    /* ************** WFCT-12634 ********************** */
    private String itemizedBillFailureMessageText_Headline = "Das hat leider nicht geklappt";
    private String itemizedBillFailureMessageText_Body = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";
    private String einstellungenTitleText = "Einzelverbindungsnachweise";
    private String einstellungenDescriptionText = "Du kannst Einzelverbindungsnachweise nur für Anrufe bekommen, durch die zusätzliche Kosten entstanden sind, z.B. für Sonderrufnummern oder Auslandsgespräche.";
    private String einstellungenDescriptionText_Multiple = "Du kannst Einzelverbindungsnachweise nur für Anrufe bekommen, durch die zusätzliche Kosten entstanden sind, z.B. für Sonderrufnummern oder Auslandsgespräche.";
    private String einstellungenNumberSettingsText = "Deine Einstellung für";
    private String editBtnText = "Bearbeiten";
    private String noItemizedBillText= "Keine Nachweise";
    private String limitedItemizedBillText= "Um die letzten 3 Stellen gekürzt";
    private String CompleteItemizedBillText= "Vollständige Nachweise";
    private String rechnungenPageHeaderCl = "Meine Rechnungen";
    private String cssPropertyIncludesUnderline = "text-decoration";

    /* *************** Methods ************************ */

    public Rechnungen(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Delete a certain words from sentence")
    public static String deleteWords(String sentence, String... wordsToDelete) {
        for (String word : wordsToDelete) {
            sentence = sentence.replace(word, "");
        }
        return sentence;
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

    /* *******************************WFCT-14089*************************** */
    public By getPreviewCustomerBillLocator(String billRow){
        return By.xpath("(//*[@automation-id='table_1_svg'])["+billRow+"]");
    }

    public By getDownloadCustomerBillLocator(String billRow){
        return By.xpath("(//*[@automation-id='table_2_svg'])["+billRow+"]");
    }

    public By getDownloadItemizedBillLocator(String billRow){
        return By.xpath("//tbody/tr["+billRow +"]/td[5]//*[local-name()='svg' and @automation-id='table_2_svg']");
    }

    @Step("Click On Preview Customer Bill By Its Order")
    public void clickOnPreviewCustomerBillByOrder(String billRowOrder){
        driver.element().click(getPreviewCustomerBillLocator(billRowOrder));
    }

    @Step("Click On Download Customer Bill By Its Order")
    public void clickOnDownloadCustomerBillByOrder(String billRowOrder){
        driver.element().click(getDownloadCustomerBillLocator(billRowOrder));
    }

    @Step("Click On Preview Itemized Bill By Its Order")
    public void clickOnPreviewItemizedBillByOrder(String billRowOrder){
        driver.element().click(getPreviewCustomerBillLocator(billRowOrder));
    }

    @Step("Click On Download Itemized Bill By Its Order")
    public void clickOnDownloadItemizedBillByOrder(String billRowOrder){
        driver.element().click(getDownloadItemizedBillLocator(billRowOrder));
    }

    @Step("Click On Kostenubersicht Tab")
    public void clickOnCostOverView(){
        driver.element().click(kostenubersichtLocator);
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


    /* ***************************WFCT-10132****************************** */
    @Step("close partially booked itemized bill notification")
    public void closePartiallyBookedItemizedBillNotification() {
        driver.element().click( partiallyBookedItemizedBillNotificationCloseIconLocator);
    }

    @Step("Click On First Amount Rechnungen Table")
    public void clickOnFirstAmountAtTable(){
        driver.element().click(Rechnungen.getFirstMonthAmountLocator());
    }




    @Step("close not retrieved itemized bill notification")
    public void closeNotRetrievedItemizedBillNotification() {
        driver.element().click( notRetrievedItemizedBillNotificationCloseIconLocator);
    }


    private By getItemizedBillWarningIconLocator(String itemizedBillWarningIconRowNumber) {
        return By.xpath("//tbody/tr[" + itemizedBillWarningIconRowNumber + "]/td[5]//*[local-name()='svg' and @automation-id='table_1_svg']");
    }

    private By getInvoiceBillWarningIconLocator(String invoiceBillWarningIconRowNumber) {
        return By.xpath("//tbody/tr[" + invoiceBillWarningIconRowNumber + "]/td[4]//*[local-name()='svg' and @automation-id='table_1_svg']");
    }

    private By getItemizedBillBlockingIconLocator(String itemizedBilBlockingIconRowNumber) {
        return By.xpath("//tbody/tr[" + itemizedBilBlockingIconRowNumber + "]/td[5]//*[local-name()='svg' and @automation-id='table_1_svg']");
    }

    /* ********************************************************* */
    @Step("Click on show more button")
    public Rechnungen clickShowMore() {
        driver.element().click( showMoreButtonLocator);
        return this;
    }

    @Step("Click on Details Page")
    public InvoiceSummary clickDetailsPage(String locator) {
        driver.element().click(By.xpath("(//a[contains(.,'Details')])[" + locator + "]"));
        return new InvoiceSummary(driver);
    }

    /* *******************WFCT_10051******************* */
    @Step("click on billing settings link from the notification")
    public Einstellungen clickBillingSettingLink() {
        driver.element().click( getBillingSettingLinkLocator());
        return new Einstellungen(driver);
    }
    /* *******************WFCT_10008******************* */

    @Step("click on the underlined amount")
    public Rechnungen clickOnTheUnderlinedAmount() {
        driver.element().click( firstMonthAmountLocator);
        return this;
    }

    /* *******************WFCT_8949******************* */

    private String downloadPath = SHAFT.Properties.paths.downloads();

    public String getDownloadPath() {
        return downloadPath;
    }


    public void clickSelectAllCheckbox() {
        driver.element().click( selectAllCheckboxLocator);
    }

    @Step("Select Checkbox")
    public void clickInvoiceCheckbox(int checkBoxOrder) {
        driver.element().click( getInvoiceCheckboxLocator(checkBoxOrder));
    }

    @Step("Click on download all button")
    public void clickDownloadAllBtn() {
        driver.element().click( downloadAllBtnLocator);
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        int i;
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().contains(fileName)) {
                dir_contents[i].delete();
                return flag = true;
            }

        }

        return flag;

    }

    @Step("wait for file to be downloaded")
    public void waitForFileToBeDownloaded() {
        if (driver.element().getElementsCount(By.xpath("fakeLocator")) == 1) {
            driver.element().click( By.xpath("fakeLocator"));
        }
    }
    @Step("Click on Chart Bar")
    public void clickOnChartBar(String chartBarOrder) {
        driver.element().click(By.xpath("(//div[@automation-id='billBar_cbar'])[" + chartBarOrder + "]"));
    }

    // Validations
    /* ***************** WFCT-10240 **************** */
    public void assertOnSelectAllCheckBox() {
        driver.verifyThat()
                .element( selectAllCheckboxLocator)
                .exists().withCustomReportMessage("Assert on Select All ")
                .perform();
    }

    public void assertOnCollectiveDownloadAllBtn() {
        driver.verifyThat()
                .element( downloadAllBtnLocator)
                .exists()
                .withCustomReportMessage("Assert on Download all Button")
                .perform();

    }

    public void assertThatFileIsDownloaded() {
        Validations.assertThat()
                .object(isFileDownloaded(getDownloadPath(), "getDocuments"))
                .isTrue()
                .withCustomReportMessage("Assert that file is downloaded")
                .perform();
    }

    public void assertOnCollectiveDownloadErrorNotificationHeader() {
        driver.verifyThat()
                .element( errorNotificationHeaderLocator)
                .textTrimmed()
                .isEqualTo(serviceErrorNotificationTitleCL)
                .withCustomReportMessage("Assert on Notification header")
                .perform();
    }

    public void assertOnCollectiveDownloadErrorNotificationBody() {
        driver.verifyThat()
                .element( errorNotificationBodyLocator)
                .textTrimmed()
                .isEqualTo(collectiveErrorNotificationBody_CL)
                .withCustomReportMessage("Assert on Notification body")
                .perform();
    }


    public void assertOnRedMonthColor(int monthOrder) {
        driver.assertThat()
                .element( new Rechnungen(driver).getMonthTextLocator(monthOrder))
                .cssProperty("color")
                .contains("189, 0, 0")
                .withCustomReportMessage(" Assert that Month Text color is red ")
                .perform();
    }
    /* ******************** WFCT-10051 ****************** */

    public void assertOnPaperOnlyNotificationColor() {
        driver.verifyThat()
                .element( paperOnlyNotificationBackGroundLocator)
                .cssProperty("background-color")
                .contains("240, 247, 249")
                .withCustomReportMessage(" Assert on Notification Background color")
                .perform();
    }

    public void assertOnOldOnlineNotificationColor() {
        driver.verifyThat()
                .element( oldOnlineNotificationBackGroundLocator)
                .cssProperty("background-color")
                .contains("240, 247, 249")
                .withCustomReportMessage("  Assert on Notification Background color")
                .perform();
    }

    public void assertOnPaperAndOnlineNotificationColor() {
        driver.assertThat()
                .element( paperAndOnlineNotificationBackGroundLocator)
                .cssProperty("background-color")
                .contains("240, 247, 249")
                .withCustomReportMessage("  Assert on Notification Background color")
                .perform();
    }

    public void assertOnPaperNotificationLink() {
        driver.verifyThat()
                .element( billingSettingLinkLocator)
                .textTrimmed()
                .isEqualTo(paperNotificationLink_CL)
                .withCustomReportMessage("Assert on notification link text")
                .perform();
    }


    public void assertOnPaperOnlyNotificationTitle() {
        driver.verifyThat()
                .element( noInvoiceNotificationTitleLocator)
                .textTrimmed()
                .isEqualTo(paperNotificationTitle_CL)
                .withCustomReportMessage("Assert on paper only notification title")
                .perform();
    }

    public void assertOnOldOnlineNotificationTitle() {
        driver.verifyThat()
                .element( noInvoiceNotificationTitleLocator)
                .textTrimmed()
                .isEqualTo(paperNotificationTitle_CL)
                .withCustomReportMessage("Assert on old online notification title")
                .perform();
    }

    public void assertOnPaperAndOnlineNotificationTitle() {
        driver.verifyThat()
                .element( noInvoiceNotificationTitleLocator)
                .textTrimmed()
                .isEqualTo(paperNotificationTitle_CL)
                .withCustomReportMessage("Assert on old online notification title")
                .perform();
    }

    public void assertOnPaperOnlyNotificationBody() {
        driver.verifyThat()
                .element( noInvoiceNotificationDescriptionLocator)
                .textTrimmed()
                .isEqualTo(paperOnlyNotificationBody_CL)
                .withCustomReportMessage("Assert on paper only notification body")
                .perform();
    }

    public void assertOnOldOnlineNotificationBody() {
        driver.verifyThat()
                .element( noInvoiceNotificationDescriptionLocator)
                .textTrimmed()
                .isEqualTo(oldOnlineNotificationBody_CL)
                .withCustomReportMessage("Assert on old online notification body")
                .perform();
    }

    public void assertOnPaperAndOnlineNotificationBody() {
        driver.verifyThat()
                .element( noInvoiceNotificationDescriptionLocator)
                .textTrimmed()
                .isEqualTo(paperAndOnlineNotificationBody_CL)
                .withCustomReportMessage("Assert on Paper and online notification body")
                .perform();
    }

    public void assertOnOldOnlineBarHeight() {
        driver.verifyThat()
                .element( lastChartBarLocator)
                .cssProperty("height")
                .isEqualTo("0px")
                .withCustomReportMessage("Assert that bar height equals Zero")
                .perform();
    }

    public void assertOnPaperAndOnlineBarHeight() {
        driver.verifyThat()
                .element( lastChartBarLocator)
                .cssProperty("height")
                .doesNotEqual("0px")
                .withCustomReportMessage("Assert that bar height doesn't equal Zero")
                .perform();
    }

    /* ********************WFCT-7763****************** */

    public void assertOnTableTitleText() {
        driver.verifyThat()
                .element( tableTitleLocator)
                .textTrimmed()
                .contains(tableTitle)
                .withCustomReportMessage("assert on table title text")
                .perform();
    }

    public void assertOnTableDescriptionText() {
        driver.verifyThat()
                .element( tableDescriptionLocator)
                .textTrimmed()
                .contains(tableDescription)
                .withCustomReportMessage("assert on table description text")
                .perform();
    }

    public void assertOnTableDescriptionText_MarieNoUsageItemized() {
        driver.verifyThat()
                .element( tableDescriptionLocator)
                .textTrimmed()
                .contains(tableDescription_MarieNotUsageItemized)
                .withCustomReportMessage("assert on table description text")
                .perform();
    }

    public void assertOnTableDescriptionText_MarieNotRetrievedItemized() {
        driver.verifyThat()
                .element( tableDescriptionLocator)
                .textTrimmed()
                .contains(tableDescription_MarieNotRetrievedItemized)
                .withCustomReportMessage("assert on table description text")
                .perform();
        driver.verifyThat()
                .element( tableDescriptionLocator)
                .textTrimmed()
                .contains(tableDescriptionHyperLink_CL)
                .withCustomReportMessage("assert on hyperlink text")
                .perform();
    }

    public void assertThatShowMoreBtnNotExist() {
        driver.verifyThat()
                .element( showMoreButtonLocator)
                .doesNotExist()
                .withCustomReportMessage("assert that show more button doesn't exist")
                .perform();
    }

    public void assertThatShowMoreBtnExists() {
        driver.verifyThat()
                .element( showMoreButtonLocator)
                .exists()
                .withCustomReportMessage("assert that show more button doesn't exist")
                .perform();
    }

    public void assertThatItemizedColumnNotExist() {
        driver.verifyThat()
                .element( itemizedColumnLocator)
                .doesNotExist()
                .withCustomReportMessage("assert that itemized column doesn't exist")
                .perform();
    }

    public void assertThatMonthColumnExists() {
        driver.verifyThat()
                .element( dateColumnLocator)
                .exists()
                .withCustomReportMessage("assert that Month column exists")
                .perform();
    }

    public void assertThatAmountColumnExists() {
        driver.verifyThat()
                .element( amountColumnLocator)
                .exists()
                .withCustomReportMessage("assert that amount column  exists")
                .perform();
    }

    public void assertThatDueDateColumnExists() {
        driver.verifyThat()
                .element( dueDateColumnLocator)
                .exists()
                .withCustomReportMessage("assert that DueDate column exists")
                .perform();
    }

    public void assertThatInvoiceColumnExists() {
        driver.verifyThat()
                .element( invoiceColumnLocator)
                .exists()
                .withCustomReportMessage("assert that invoice column exists")
                .perform();
    }

    public void assertThatInvoiceDownloadIconExists() {
        driver.verifyThat()
                .element( invoiceDownloadLocator)
                .exists()
                .withCustomReportMessage("assert that invoice download icon exists")
                .perform();
    }

    public void assertThatInvoicePreviewIconExists() {
        driver.verifyThat()
                .element( invoicePreviewLocator)
                .exists()
                .withCustomReportMessage("assert that preview icon exists")
                .perform();
    }

    public void assertThatTheFirst2MonthsHaveTheSameName() {
        driver.verifyThat()
                .element( firstMonthNameLocator)
                .textTrimmed()
                .isEqualTo(driver.element().getText(secondMonthNameLocator))
                .withCustomReportMessage("assert that the first two month name are the same")
                .perform();
    }

    public void assertOnShowMoreBtnText() {
        driver.verifyThat()
                .element( showMoreButtonLocator)
                .textTrimmed()
                .isEqualTo(showMoreButtonCL)
                .withCustomReportMessage("assert on show more button text")
                .perform();
    }

    public void assertThatItemizedColumnExists() {
        driver.verifyThat()
                .element( itemizedColumnLocator)
                .exists()
                .withCustomReportMessage("assert that itemized column exists")
                .perform();
    }

    public void assertThatItemizedPreviewIconExists() {
        driver.verifyThat()
                .element( itemizedPreviewLocator)
                .exists()
                .withCustomReportMessage("assert that itemized preview icon exists")
                .perform();
    }

    public void assertThatItemizedDownloadIconExists() {
        driver.verifyThat()
                .element( itemizedDownloadLocator)
                .exists()
                .withCustomReportMessage("assert that itemized download icon exists")
                .perform();
    }

    public void assertOnShowLessBtnText() {
        driver.verifyThat()
                .element( showMoreButtonLocator)
                .textTrimmed()
                .isEqualTo(ShowLessButtonCL)
                .withCustomReportMessage("assert on show less button text")
                .perform();
    }

    /* *************************WFCT-9503 ************************ */

    public void assertThatGuthabenWordExists() {
        driver.verifyThat()
                .element( creditAmountGraphTextLocator).textTrimmed()
                .isEqualTo(creditAmountTextCl)
                .withCustomReportMessage("assert that Guthaben word exists in the the graph")
                .perform();
    }


    public void assertThatCreditIconExists() {
        driver.verifyThat()
                .element( CreditAmountInfoIconLocator)
                .exists()
                .withCustomReportMessage("assert that credit icon exists")
                .perform();

    }
    public void assertThatCreditIconExists(String rowNum) {
        driver.verifyThat()
                .element( getCreditAmountInfoIconLocator(rowNum))
                .exists()
                .withCustomReportMessage("assert that credit icon exists")
                .perform();

    }

    public void assertOnCreditNotificationTitle() {
        driver.verifyThat()
                .element( CreditAmountInfoTitleLocator).textTrimmed()
                .isEqualTo(creditAmountInfoTitleCl)
                .withCustomReportMessage("assert that credit notification title is correct")
                .perform();
    }

    public void assertOnCreditNotificationDescription() {
        driver.verifyThat()
                .element(CreditAmountInfoDescriptionLocator).textTrimmed()
                .isEqualTo(creditAmountInfoDescriptionCl)
                .withCustomReportMessage("assert that credit notification description is correct")
                .perform();
    }

    public void assertOnCreditNotificationTitle(String rowNum) {
        driver.verifyThat()
                .element( getCreditAmountInfoTitleLocator(rowNum)).textTrimmed()
                .isEqualTo(creditAmountInfoTitleCl)
                .withCustomReportMessage("assert that credit notification title is correct")
                .perform();
    }

    public void assertOnCreditNotificationDescription(String rowNum) {
        driver.verifyThat()
                .element(getCreditAmountInfoDescriptionLocator(rowNum)).textTrimmed()
                .isEqualTo(creditAmountInfoDescriptionCl)
                .withCustomReportMessage("assert that credit notification description is correct")
                .perform();
    }

    public void assertThatTheAmountTextColorIsGreen() {
        driver.verifyThat()
                .element( Rechnungen.getFirstMonthAmountLocator()).cssProperty("color")
                .contains("0, 138, 0")
                .withCustomReportMessage("assert that amount text in green color")
                .perform();
    }

    public void assertThatTheAmountTextColorIsGreen(String rowNum) {
        driver.verifyThat()
                .element( getAmountLocator(rowNum)).cssProperty("color")
                .contains("0, 138, 0")
                .withCustomReportMessage("assert that amount text in green color")
                .perform();
    }

    public void assertThatBarHeight2px() {
        driver.verifyThat()
                .element( Rechnungen.getFirstMonthBarLocator())
                .attribute("style")
                .isEqualTo("height: 2px;")
                .withCustomReportMessage("assert that bar height is 2 px")
                .perform();
    }

    public void assertOnBarHeight(String barHeight) {
        driver.verifyThat()
                .element( Rechnungen.getFirstMonthBarLocator())
                .attribute("style")
                .isEqualTo(barHeight)
                .withCustomReportMessage("assert that bar height as Expected")
                .perform();
    }

    public void assertOnThatFirstAmountValue(String amount) {
        driver.verifyThat()
                .element( firstMonthAmountLocator).textTrimmed()
                .isEqualTo(amount)
                .withCustomReportMessage("assert that hte first amount =" + amount)
                .perform();
    }

    public void assertOnEmptyBeResponseNotificationTitle() {
        driver.verifyThat()
                .element( noInvoiceNotificationTitleLocator).textTrimmed()
                .isEqualTo(noInvoiceNotificationTitleCL)
                .withCustomReportMessage("assert no invoice notification title is correct")
                .perform();
    }

    public void assertOnEmptyBeResponseNotificationDescription() {
        driver.verifyThat()
                .element( noInvoiceNotificationDescriptionLocator).textTrimmed()
                .isEqualTo(Rechnungen.getNoInvoiceNotificationDescriptionCL())
                .withCustomReportMessage("assert no invoice notification description is correct")
                .perform();
    }

    public void assertThatFirstBarHeightIsNotZero() {
        driver.verifyThat()
                .element( firstMonthBarLocator).attribute("style").doesNotEqual("height: 0px;")
                .withCustomReportMessage("assert that first graph bar is not 0px")
                .perform();
    }

    public void assertThatBarHeightIsZero(int i) {
        List<WebElement> graphBarsList = driver.getDriver().findElements(Rechnungen.graphBarsLocator);
        for (i = 0; i < 11; i++) {
            Validations.verifyThat()
                    .object(graphBarsList.get(i).getAttribute("style"))
                    .isEqualTo("height: 0px;")
                    .withCustomReportMessage("assert that graph bar #" + (i + 1) + " hight are 0px")
                    .perform();
        }
    }

    public void assertOnServiceErrorNotificationTitle() {
        driver.verifyThat()
                .element( serviceErrorNotificationTitleLocator).textTrimmed()
                .isEqualTo(serviceErrorNotificationTitleCL)
                .withCustomReportMessage("assert that service Error notification title is correct")
                .perform();
    }

    public void assertOnServiceErrorNotificationDescription() {
        driver.verifyThat()
                .element( serviceErrorNotificationDescriptionLocator).textTrimmed()
                .isEqualTo(serviceErrorNotificationDescriptionCL)
                .withCustomReportMessage("assert that service Error notification description is correct")
                .perform();
    }

    public void assertOnServiceErrorNotificationBtnText() {
        driver.verifyThat()
                .element( serviceErrorNotificationButtonLocator).textTrimmed()
                .isEqualTo(serviceErrorNotificationButtonCL)
                .withCustomReportMessage("assert that service Error notification button text is correct")
                .perform();
    }

    public void assertOnTheInvoiceWarningIconText() {
        driver.verifyThat()
                .element( firstRowInvoiceBillWarningTextLocator).textTrimmed()
                .isEqualTo(invoicePdfWarningIconCL)
                .withCustomReportMessage("assert that warning icon exists and generates the correct text on hovering")
                .perform();
    }

    public void assertOnNotRetrievedAmountText() {
        driver.verifyThat()
                .element( firstMonthAmountLocator).textTrimmed()
                .isEqualTo(amountDateNotRetrievedCL)
                .withCustomReportMessage("assert that amount not retrieved cl is applied")
                .perform();
    }

    public void assertOnNotRetrievedDateText() {
        driver.verifyThat()
                .element( firstMonthDueDateLocator).textTrimmed()
                .isEqualTo(amountDateNotRetrievedCL)
                .withCustomReportMessage("assert that due date not retrieved cl is applied")
                .perform();
    }

    public void assertThatTheFirstBarHeightIsZero() {
        driver.verifyThat()
                .element( firstMonthBarLocator)
                .attribute("style")
                .isEqualTo("height: 0px;")
                .withCustomReportMessage("assert that the first bar height is 0 px")
                .perform();
    }

    public void assertOnTheItemizedWarningIconText() {
        driver.verifyThat()
                .element( secondRowItemizedBillWarningTextLocator).textTrimmed()
                .isEqualTo(itemizedPdfWarningIconCL)
                .withCustomReportMessage("assert that warning icon exists and generate the correct CL on hovering")
                .perform();
    }

    /* ***************** WFCT-10478 ***************** */
    public void assertThatBarHeightNot2Px() {
        driver.assertThat()
                .element( firstMonthBarLocator)
                .attribute("style")
                .doesNotEqual("height: 2px;")
                .withCustomReportMessage("assert that bar height is not equal 2 px")
                .perform();
    }

    /* *****************WFCT-10132 Assertion ***************** */
    @Step("assert that itemized bill column doesn't exist")
    public void assertThatItemizedBillColumnDoesNotExist() {
        driver.verifyThat()
                .element( itemizedBillColumnLocator).doesNotExist()
                .withCustomReportMessage("assert that itemized bill column doesn't exist").perform();
    }

    @Step("assert that not booked table description is correct")
    public void assertOnNotBookedItemizedBillTableDescription() {
        driver.verifyThat().element( tableDescriptionLocator).textTrimmed()
                .contains(notBookedItemizedBillTableDescription_Cl)
                .withCustomReportMessage("assert that not booked table description is correct")
                .perform();
        driver.verifyThat().element(tableDescriptionLocator).textTrimmed()
                .contains(tableDescriptionHyperLink_CL)
                .withCustomReportMessage("assert that Partially booked table description is correct")
                .perform();
    }

    @Step("assert that Partially booked table description is correct")
    public void assertOnPartiallyBookedItemizedBillTableDescription() {
        driver.verifyThat().element( tableDescriptionLocator).textTrimmed()
                .contains(partiallyBookedItemizedBillTableDescription_Cl)
                .withCustomReportMessage("assert that Partially booked table description is correct")
                .perform();
        driver.verifyThat()
                .element( tableDescriptionLocator)
                .textTrimmed()
                .contains(tableDescriptionHyperLink_CL)
                .withCustomReportMessage("assert on hyperlink text")
                .perform();
    }

    @Step("assert that Partially booked table description is correct")
    public void assertOnPartiallyBookedItemizedBillTableDescriptions(String partiallyBookedDescription) {
        driver.verifyThat().element(tableDescriptionLocator).textTrimmed()
                .isEqualTo(partiallyBookedItemizedBillTableDescription_Link_CL)
                .withCustomReportMessage("assert that Partially booked table description is correct")
                .perform();

    }

    @Step("assert that not retrieved itemized bill table description is correct")
    public void assertOnNotRetrievedItemizedBillTableDescription() {
        driver.verifyThat().element( tableDescriptionLocator).textTrimmed()
                .contains(notRetrievedItemizedBillTableDescription_Cl)
                .withCustomReportMessage("assert that not retrieved itemized bill table description is correct")
                .perform();
    }

    @Step("assert that partially booked notification exists")
    public void assertThatPartiallyBookedItemizedBillNotificationExists() {
        driver.verifyThat()
                .element( partiallyBookedItemizedBillNotificationLocator).exists()
                .withCustomReportMessage("assert that partially booked notification exists")
                .perform();
    }

    @Step("assert that partially booked notification cl is correct")
    public void assertOnPartiallyBookedItemizedBillNotificationCl() {
        driver.verifyThat()
                .element( partiallyBookedItemizedBillNotificationTextLocator).exists()
                .withCustomReportMessage("assert that partially booked notification cl existance")
                .perform();
    }

    @Step("assert that not retrieved itemized bill notification exists")
    public void assertThatNotRetrievedItemizedBillNotificationExists() {
        driver.verifyThat()
                .element( notRetrievedItemizedBillNotificationLocator).exists()
                .withCustomReportMessage("assert that not retrieved itemized bill notification exists")
                .perform();
    }

    @Step("assert that not retrieved itemized bill notification cl is correct")
    public void assertOnNotRetrievedItemizedBillNotificationCl() {
        driver.verifyThat()
                .element( notRetrievedItemizedBillNotificationTextLocator).exists()
                .withCustomReportMessage("assert that not retrieved itemized bill notification cl is correct")
                .perform();
    }

    @Step("assert that partially booked notification doesn't exist")
    public void assertThatPartiallyBookedItemizedBillNotificationDoesNotExist() {
        driver.verifyThat()
                .element( partiallyBookedItemizedBillNotificationLocator).doesNotExist()
                .withCustomReportMessage("assert that partially booked notification doesn't exist")
                .perform();
    }

    @Step("assert that not retrieved itemized bill notification doesn't not exist")
    public void assertThatNotRetrievedItemizedBillNotificationDoesNotExist() {
        driver.verifyThat()
                .element( notRetrievedItemizedBillNotificationLocator).doesNotExist()
                .withCustomReportMessage("assert that not retrieved itemized bill notification doesn't not exist")
                .perform();
    }

    @Step("assert that blocking icon exists")
    public void assertThatBlockingIconExists(String rowOrder) {
        driver.verifyThat()
                .element( getItemizedBillBlockingIconLocator(rowOrder)).exists()
                .withCustomReportMessage("assert that blocking icon exists").perform();
    }

    @Step("assert on blocking icon cl")
    public void assertOnBlockingIconCl(String rowOrder) {
        driver.verifyThat()
                .element( getItemizedBillBlockingIconLocator(rowOrder)).textTrimmed().isEqualTo(itemizedBillBlockingIcon_Cl)
                .withCustomReportMessage("assert on blocking icon cl").perform();
    }

    @Step("assert that warning icon exists")
    public void assertThatWarningIconExists(String rowOrder) {
        driver.verifyThat()
                .element( getItemizedBillWarningIconLocator(rowOrder)).exists()
                .withCustomReportMessage("assert that warning icon exists").perform();
    }

    @Step("assert on warning icon cl")
    public void assertOnWarningIconCl(String rowOrder) {
        driver.verifyThat()
                .element( getItemizedBillWarningIconLocator(rowOrder)).textTrimmed().isEqualTo(itemizedBillWarningIconCL)
                .withCustomReportMessage("assert on warning icon cl").perform();
    }

    /*
    *********************************************WFCT-12634*****************************************
     */

    public By getNoNumberAtBillOpionMessageLocator(String billOptionOrder){
        return By.xpath("(//p[@class='notification-text'])["+billOptionOrder+"]");
    }

    @Step("Click on Invoice Settings (Rechnungseinstellungen)")
    public void clickOnInvoiceSettings_Rechnungseinstellungen(){
        driver.element().click(invoiceSettings_Rechnungseinstellungen_Locator);
    }
    @Step("Click on Edit Button (Bearbeiten) and Navigates User to Itemized Bill Edit Page")
    public void clickOnEditBtn_Bearbeiten(){
        driver.element().click(editBtn_Bearbeiten_Locator);
    }

    @Step("Click on Edit Button (Bearbeiten) and Navigates User to Itemized Bill Edit Page")
    public void clickOnEditBtn_Bearbeiten_MultipleCase(){
        driver.element().click(editBtn_Bearbeiten_Locator_MultipleCase);
    }

    @Step("Get Billing Type")
    public String getNumberBillingType_SingleCase(){
        return driver.element().getText(billingTypeLocator);
    }

    public void assertOnItemizedBillFailureMessage_Headline(){
        driver.verifyThat().element(itemizedBillFailureMessageLocator_Headline)
                .textTrimmed().isEqualTo(itemizedBillFailureMessageText_Headline)
                .withCustomReportMessage("Assert On Itemized Bill Failure Message Headline").perform();
    }

    public void assertOnItemizedBillFailureMessage_Body(){
        driver.verifyThat().element(itemizedBillFailureMessageLocator_Body)
                .textTrimmed().isEqualTo(itemizedBillFailureMessageText_Body)
                .withCustomReportMessage("Assert On Itemized Bill Failure Message Body").perform();
    }

    public void assertOnEinstellungenTitle(){
        driver.verifyThat().element(einstellungenTitleLocator)
                .textTrimmed().isEqualTo(einstellungenTitleText)
                .withCustomReportMessage("Assert On Einstellungen Page Title").perform();
    }

    public void assertOnEinstellungenTitle_MultipleCase(){
        driver.verifyThat().element(einstellungenTitleLocator_Multiple)
                .textTrimmed().isEqualTo(einstellungenTitleText)
                .withCustomReportMessage("Assert On Einstellungen Page Title").perform();
    }

    public void assertOnEinstellungenDescription(){
        driver.verifyThat().element(einstellungenDescriptionLocator)
                .textTrimmed().isEqualTo(einstellungenDescriptionText)
                .withCustomReportMessage("Assert On Einstellungen Description").perform();
    }
    public void assertOnEinstellungenDescription_MultipleCase(){
        driver.verifyThat().element(einstellungenDescriptionLocator_Multiple)
                .textTrimmed().contains(einstellungenDescriptionText_Multiple)
                .withCustomReportMessage("Assert On Einstellungen Description").perform();
    }

    public void assertOnEinstellungenNumberSettings(){
        driver.verifyThat().element(einstellungenNumberSettingsLocator)
                .textTrimmed().contains(einstellungenNumberSettingsText)
                .withCustomReportMessage("Assert On Einstellungen Number Settings").perform();
    }

    public void assertOnEditButtonText(){
        driver.verifyThat().element(editBtn_Bearbeiten_Locator)
                .textTrimmed().isEqualTo(editBtnText).withCustomReportMessage("Assert On Edit Button Text")
                .perform();
    }

    public void assertOnBillingType(String currentBillingType){
        driver.verifyThat().element(billingTypeLocator).textTrimmed()
                .isEqualTo(currentBillingType)
                .withCustomReportMessage("Assert On Current Billing Type").perform();
    }

    public void assertOnNoItemizedBillFieldExistance(){
        driver.verifyThat().element(noItemizedBill_Locator).textTrimmed()
                .isEqualTo(noItemizedBillText)
                .withCustomReportMessage("Assert On No Itemized Bill Field").perform();
    }

    public void assertOnLimitedItemizedBillFieldExistance(){
        driver.verifyThat().element(limitedItemizedBill_Locator).textTrimmed()
                .isEqualTo(limitedItemizedBillText)
                .withCustomReportMessage("Assert On Limited Itemized Bill Field").perform();
    }

    public void assertOnCompleteItemizedBillFieldExistance(){
        driver.verifyThat().element(CompleteItemizedBill_Locator).textTrimmed()
                .isEqualTo(CompleteItemizedBillText)
                .withCustomReportMessage("Assert On Complete Itemized Bill Field").perform();
    }

    public void assertOnNoNumbersIncludedInBillOptionFieldMessage(String billOptionOrder,String noNumberMessage){
        driver.verifyThat().element(getNoNumberAtBillOpionMessageLocator(billOptionOrder)).textTrimmed()
                .isEqualTo(noNumberMessage)
                .withCustomReportMessage("Assert On No Numbers Message at Certain Bill Option")
                .perform();
    }

    public void assertThatRechnungenPageIsLoaded()
    {
        driver.assertThat().element(rechnungenPageHeaderLocator).textTrimmed().isEqualTo(rechnungenPageHeaderCl).withCustomReportMessage("assert that rechnungen page is loaded").perform();
    }

    public void assertThatUserNavigatedToRechnungen()
    {
        hardReloadMethod();
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe("https://simplicity.wf-de.vodafone.com/meinvodafone/services/ihre-rechnungen/rechnungen"));
        driver.browser().verifyThat().url()
        .isEqualTo("https://simplicity.wf-de.vodafone.com/meinvodafone/services/ihre-rechnungen/rechnungen")
                .withCustomReportMessage("Assert On Rechnungen URL").perform();
    }



    @Step("Click On Details At Bill Chart")
    public void clickOnDetailsAtBillChart(){
        driver.element().click(detailsBtn);
    }

    @Step("Click On Latest Details At Bill Chart")
    public void clickOnLatestDetailsAtBillChartSIT(String detailsOrder){
        driver.element().click(getDetailsLocatorAtBillChartByIndex(detailsOrder));
    }

    public void assertThatDetailsBtnDoesNotExist(){
        driver.verifyThat().element(detailsBtn).doesNotExist()
                .withCustomReportMessage("Assert That details button at bill chart does not exist").perform();
    }

    public void waitPageToBeLoaded()
    {
        driver.verifyThat().element(By.xpath("pageloded")).doesNotExist().withCustomReportMessage("wait for page to be loaded").perform();
    }

    public void asssertThatAmountAtTheTableIsUnderlined(String underlineAndColorCssProperty){
        driver.verifyThat().element(firstMonthAmountLocator).cssProperty(cssPropertyIncludesUnderline)
                .isEqualTo(underlineAndColorCssProperty).withCustomReportMessage("Assert That Table Amount Is Underlined")
                .perform();
    }

}