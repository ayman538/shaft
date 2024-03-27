package de.vodafone.pages.CableMigration;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class MeinRechnungPage {

    // Variables
    private static SHAFT.GUI.WebDriver driver;
    public static final By backlink_link = By.xpath("//a[@automation-id='back_Link']");
    public static final By header_txt = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    public static final By billChartHeadline_txt = By.xpath("//*[@id='content']//bar-chart//p/span[3]");
    public static final By firstIcon = By.xpath("//div[@automation-id='navTab_0_tv']");
    public static final By secondIcon = By.xpath("//div[@automation-id='navTab_1_tv']");
    public static final By thirdIcon = By.xpath("//div[@automation-id='navTab_2_tv']");
    public static final By fourthIcon = By.xpath("//div[@automation-id='navTab_3_tv']");
    public static final By NotificationMessageHeadline_Text = By.xpath("//bills-accordion-martin/div[2]/div/div/div/notification//h4");public static final By NotificationMessageSubHeadline_Text = By.xpath("//bills-accordion-martin/div[2]/div/div/div/notification//p");public static final By Check_Button = By.xpath("//button[@class='btn btn-em btn-sml']");
    public static final By table_Headline = By.xpath("//div[@automation-id='navTab_1_tv']");
    public static final By table_SubHeadline = By.xpath("//*[@automation-id='table_description_tv']");
    public static By table_ColumnsCount = By.xpath("//*[@automation-id='root_table']//th");
    public static final By table_FirstColumnName = By.xpath("//*[@automation-id='root_table']//th[1]//h5");
    public static final By table_SecondColumnName = By.xpath("//*[@automation-id='root_table']//th[2]//h5");
    public static final By table_ThirdColumnName = By.xpath("//*[@automation-id='root_table']//th[3]//h5");
    public static final By table_FourthColumnName = By.xpath("//*[@automation-id='root_table']//th[4]//h5");
    public static final By table_FifthColumnName = By.xpath("//*[@automation-id='root_table']//th[5]//h5");
    public static final By table_SixthColumnName = By.xpath("//*[@automation-id='root_table']//th[6]//h5");
    public static By table_thirdRowItemizedIcon = By.xpath("(//div[@class='ws10-hybrid-table__icons-container']//span)[11]");
    public static By table_RowsCount = By.xpath("//*[@automation-id='root_table']//tr");
    public static By table_AmountFirstRow = By.xpath("//table//tr[1]//td[2]//span");

    public static By table_RechnungFirstRow_Download = By.xpath("//table//tr[1]//td[4]//*[@automation-id='table_2_svg']");
    public static By table_ItemizedFirstRow_Download = By.xpath("//table//tr[1]//td[4]//*[@automation-id='table_2_svg']");
    public static By table_ProductNameFirstRow = By.xpath("//table//tr[1]//td[3]//span");
    public static By table_ProductNameSecondRow = By.xpath("//table//tr[2]//td[3]//span");
    public static By table_ProductNameThirdRow = By.xpath("//table//tr[3]//td[3]//span");
    public static By table_ProductNameFourRow = By.xpath("//table//tr[4]//td[3]//span");
    public static By table_ProductNameFiveRow = By.xpath("//table//tr[5]//td[3]//span");
    public static By table_ProductNameSixRow = By.xpath("//table//tr[6]//td[3]//span");
    public static By table_ProductNameSevenRow = By.xpath("//table//tr[7]//td[3]//span");

    public static By table_PDFErrorMsg = By.xpath("//*[text() = 'PDF-Dokument kann gerade nicht geladen werden']");

    public static final By headlineThirdParty = By.xpath("//third-party-bills//h3[@class='table-container__headline']");
    public static final By subHeadlineThirdParty = By.xpath("//third-party-bills//p[@class='table-container__subheadline']");
    public static final By headlineThirdParty_error= By.xpath("//div[@class='table-container__modal-error']//h2");
    public static final By subheadlineThirdParty_error= By.xpath("//div[@class='table-container__modal-error']//p");
    public static final By thirdparty_RowsCount= By.xpath("//div[@class='btn-links-container']//div//li");
    public static final By showMore_LessLink = By.xpath("//div[@class='show-more-external-bills']");
    public static final By thirdParty_NormalFirstBill_Download = By.xpath("(//a[@target='containerItem.target'])[1]");
    public static final By thirdParty_ItemiziedFirstBill_Download = By.xpath("(//a[@target='containerItem.target'])[2]");
    public static final By ute_thirdParty_ItemiziedThirdBill_Download = By.xpath("(//a[@target='containerItem.target'])[3]");
    public static final By ute_headlineThirdParty = By.xpath("//third-party-bills//h3[@class='table-container__headline']");
    public static final By ute_subHeadlineThirdParty = By.xpath("//third-party-bills//p[@class='table-container__subheadline']");
    // WFFT-2170
    private static final By noInvoicesInfoTitleMsg_Text = By.xpath("//*[@automation-id='noBill_nt']//h4");
    private static final By noInvoicesInfoContentMsg_Text = By.xpath("//*[@automation-id='noBill_nt']//p");
    private static final By noProductNameAndPDFInfoContentMsg_Text = By.xpath("//*[@class='table-container-no-notification']//p");
    private static final By table_DueDateFirstRow_Text = By.xpath("(//*[@automation-id= 'table_tbody'])[1]//td[3]//span");
    private static final By table_AmountSecondRow_Text = By.xpath("(//*[@automation-id= 'table_tbody'])[2]//td[2]//span");
    private static final By table_DueDateSecondRow_Text = By.xpath("(//*[@automation-id= 'table_tbody'])[2]//td[3]//span");
    private static final By tabNotLoadedErrorTitle_Text = By.xpath("//*[@automation-id= 'generalError_nt']//h4");
    private static final By tabNotLoadedErrorContent_Text = By.xpath("//*[@automation-id= 'generalError_nt']//p");
    private static final By tabNotLoaded_NochmalVersuchen_Button = By.xpath("//*[@automation-id= 'generalError_btn']");
    // WFFT-2608
    private By creditTitleMsg_Text = By.xpath("//*[@class='tooltip-dialog brix']//*[@class='headline h4']");
    private By creditContentMsg_Text = By.xpath("//*[@class='tooltip-dialog brix']//*[@class='content']");
    private By firstInvoiceInfoTitleMsg_Text = By.xpath("//div[2]/div/div/div/div[1]/notification//div[1]//h4[@class='flexDiv']");
    private By firstInvoiceInfoContentMsg_Text = By.xpath("//*[@class='alert noselect inProgress']//p");
    private By downloadFailedInfoTitleMsg_Text = By.xpath("//*[@class='overlay nsm-overlay-open']//h2");
    private By downloadFailedInfoContentMsg_Text = By.xpath("//*[@class='overlay nsm-overlay-open']//p");

    //constructor
    public MeinRechnungPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public static int getNumOfTableColumns(){
        int count = driver.element().getElementsCount(table_ColumnsCount);
        return count;
    }
    public static int getNumOfTableRows(){
        int count = driver.element().getElementsCount(table_RowsCount);
        return count;
    }
    public void downloadRechnungFile(){
        new ElementActions(driver.getDriver()).click(table_RechnungFirstRow_Download);
    }
    public void downloadItemizedFile(){
        new ElementActions(driver.getDriver()).click(table_ItemizedFirstRow_Download);
    }
    public DunningPage navigateToDunningPage() {
        (new ElementActions(driver.getDriver())).click(Check_Button);
        return new DunningPage(driver);
    }

    public static int getNumOfThirdPartyRows(){
        int count = driver.element().getElementsCount(thirdparty_RowsCount);
        return count;
    }

    public MeinRechnungPage clickOnShowMoreLessLink(){
        (new ElementActions(driver.getDriver())).click(showMore_LessLink);
        return this;

    }

    public void downloadRechungFile()
    {
        new ElementActions(driver.getDriver()).click(thirdParty_NormalFirstBill_Download);
    }
    public void downloadDetailedFile()
    {
        new ElementActions(driver.getDriver()).click(thirdParty_ItemiziedFirstBill_Download);
    }
    public void downloadDetailedThirdFile()
    {
        new ElementActions(driver.getDriver()).click(ute_thirdParty_ItemiziedThirdBill_Download);
    }

    public void validateMeinRechnungNoInvoicesReturned(String expectedTitleMessage,String expectedContentMessage){
        Validations.assertThat().element(driver.getDriver(),noInvoicesInfoTitleMsg_Text)
                .text().contains(expectedTitleMessage)
                .withCustomReportMessage("Check That No Invoices Title Message is displayed").perform();
        Validations.assertThat().element(driver.getDriver(), noInvoicesInfoContentMsg_Text)
                .text().contains(expectedContentMessage)
                .withCustomReportMessage("Check That No Invoices Content Message is displayed").perform();
    }
    public void validateMeinRechnungNoProductNameAndPDFReturned(String expectedInfoMessage,String expectedProductName,String expectedNoPDFErrorMsg){
        Validations.assertThat().element(driver.getDriver(),noProductNameAndPDFInfoContentMsg_Text)
                .text().contains(expectedInfoMessage)
                .withCustomReportMessage("Check That No Product Name&PDF Info Message is displayed").perform();
        Validations.assertThat().element(driver.getDriver(), table_ProductNameFirstRow)
                .text().contains(expectedProductName)
                .withCustomReportMessage("Check That Expected Product Name is displayed").perform();
        Validations.assertThat().element(driver.getDriver(), table_PDFErrorMsg)
                .text().contains(expectedNoPDFErrorMsg)
                .withCustomReportMessage("Check That PDF Not returned Error Message is displayed").perform();
    }
    public void validateMeinRechnungNoAmountAndDueDateReturnedSingleInvoice(String expectedTableAmount,String expectedDueDate,String expectedChartAmount){
        Validations.assertThat().element(driver.getDriver(),table_AmountFirstRow)
                .text().contains(expectedTableAmount)
                .withCustomReportMessage("Check The Table amount value is displayed").perform();
        Validations.assertThat().element(driver.getDriver(), table_DueDateFirstRow_Text)
                .text().contains(expectedDueDate)
                .withCustomReportMessage("Check The Due Date value is displayed").perform();
    }
    public void validateMeinRechnungNoAmountAndDueDateReturnedALLInvoice(String expectedFirstAmount,String expectedFirstDueDate,String expectedSecondAmount,String expectedSecondDueDate){
        Validations.assertThat().element(driver.getDriver(),table_AmountFirstRow)
                .text().contains(expectedFirstAmount)
                .withCustomReportMessage("Check The Table first amount value is displayed").perform();
        Validations.assertThat().element(driver.getDriver(), table_DueDateFirstRow_Text)
                .text().contains(expectedFirstDueDate)
                .withCustomReportMessage("Check The Table first Due Date value is displayed").perform();
        Validations.assertThat().element(driver.getDriver(),table_AmountSecondRow_Text)
                .text().contains(expectedSecondAmount)
                .withCustomReportMessage("Check The Table second amount value is displayed").perform();
        Validations.assertThat().element(driver.getDriver(), table_DueDateSecondRow_Text)
                .text().contains(expectedSecondDueDate)
                .withCustomReportMessage("Check The Table second Due Date value is displayed").perform();
    }
    public void validateMeinRechnungTabIsNOTLoaded(String expectedTitleMessage,String expectedContentMessage,String expectedButtonText){
        Validations.assertThat().element(driver.getDriver(),tabNotLoadedErrorTitle_Text)
                .text().contains(expectedTitleMessage)
                .withCustomReportMessage("Check That Tab Not Loaded Error Title Message is displayed").perform();
        Validations.assertThat().element(driver.getDriver(), tabNotLoadedErrorContent_Text)
                .text().contains(expectedContentMessage)
                .withCustomReportMessage("Check That Tab Not Loaded Error Content Message is displayed").perform();
        Validations.assertThat().element(driver.getDriver(), tabNotLoaded_NochmalVersuchen_Button)
                .text().contains(expectedButtonText)
                .withCustomReportMessage("Check That NochmalVersuchen Button is displayed").perform();
    }
    //wfft-2608
    public void validateMeinRechnungCreditAmount(String expectedTitleMessage,String expectedContentMessage){
        Validations.assertThat().element(driver.getDriver(),creditTitleMsg_Text)
                .text().contains(expectedTitleMessage)
                .withCustomReportMessage("Check That Credit Title Message is displayed").perform();
        Validations.assertThat().element(driver.getDriver(), creditContentMsg_Text)
                .text().contains(expectedContentMessage)
                .withCustomReportMessage("Check That Credit Content Message is displayed").perform();
    }
    public void validateMeinRechnungFirstInvoice(String expectedTitleMessage,String expectedContentMessage){
        Validations.assertThat().element(driver.getDriver(),firstInvoiceInfoTitleMsg_Text)
                .text().contains(expectedTitleMessage)
                .withCustomReportMessage("Check That First Invoice Info Title Message is displayed").perform();
        Validations.assertThat().element(driver.getDriver(), firstInvoiceInfoContentMsg_Text)
                .text().contains(expectedContentMessage)
                .withCustomReportMessage("Check That First Invoice Info Content Message is displayed").perform();
    }
    public void validateMeinRechnungDownloadFailed(String expectedTitleMessage,String expectedContentMessage){
        Validations.assertThat().element(driver.getDriver(),downloadFailedInfoTitleMsg_Text)
                .text().contains(expectedTitleMessage)
                .withCustomReportMessage("Check That Download Failed Info Title Message is displayed").perform();
        Validations.assertThat().element(driver.getDriver(), downloadFailedInfoContentMsg_Text)
                .text().contains(expectedContentMessage)
                .withCustomReportMessage("Check That Download Failed Info Content Message is displayed").perform();
    }

    public void validateTvIconMeinRechnungPage(String fithColumnName){
            driver.verifyThat().element(table_ProductNameThirdRow).textTrimmed().contains(fithColumnName).perform();
            driver.verifyThat().element(table_thirdRowItemizedIcon).exists().perform();
    }
}