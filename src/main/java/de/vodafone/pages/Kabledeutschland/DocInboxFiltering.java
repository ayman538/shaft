package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class DocInboxFiltering {
    //variables
    private SHAFT.GUI.WebDriver driver;

    //Locators
    public static By backButton =By.xpath("//a[@automation-id='back_Link']");
    public static final By Doc_Filter_AccTitle = By.xpath("(//*[@automation-id=\"accordion0_acc\"]//span)[1]");
    public static final By Date_Filter_DDL_Icon = By.xpath("(//*[@automation-id=\"accordion0_acc\"]//span)[2]");
    public static final By Filter_Option_All = By.xpath("//option[contains(text(),'Gesamter Zeitraum')]");
    // //*[@automation-id="duration_lv"]//option[1]
    public static final By Filter_Opt_ThisMonth = By.xpath("//option[contains(text(),'Dieser Monat')]");
    public static final By Filter_Opt_LastMonth = By.xpath("//option[contains(text(),'Letzter Monat')]");
    public static final By Filter_Opt_Last2Months = By.xpath("//option[contains(text(),'Vor 2 Monaten')]");
    public static final By Filter_Opt_ThisYear = By.xpath("//option[contains(text(),'Dieses Jahr')]");
    public static final By Filter_Opt_LastYear = By.xpath("//option[contains(text(),'Letztes Jahr')]");
    public static final By Filter_Confirm_Btn = By.xpath("//*[@automation-id=\"documentsInboxes_applyFilterBtn_btn\"]");
    public static final By Filter_Cancel_Btn = By.xpath("//*[@automation-id=\"documentsInboxes_resetFilterBtn_btn\"]");
    public static final By Doc_Pagination = By.xpath("//*[@id=\"pagination\"]");
    public static final By Doc_Pagination_Next = By.xpath("//*[@id=\"pagination\"]//li[3]/a[1]");
    public static final By Doc_Pagination_LastNext = By.xpath("//*[@id=\"pagination\"]//li[3]/a[2]");
    public static final By Doc_Pagination_Prev = By.xpath("//*[@id=\"pagination\"]//li[1]//a[2]");
    public static final By Doc_Pagination_FirstPrev = By.xpath("//*[@id=\"pagination\"]//li[1]//a[1]");

    //CLs
    public static String Doc_Filter_AccTitle_CL = "Dokumente filtern";
    public static String Filter_Option_All_CL = "Gesamter Zeitraum";
    public static String Filter_Opt_ThisMonth_CL = "Dieser Monat";
    public static String Filter_Opt_LastMonth_CL = "Letzter Monat";
    public static String Filter_Opt_Last2Months_CL = "Vor 2 Monaten";
    public static String Filter_Opt_ThisYear_CL = "Dieses Jahr";
    public static String Filter_Opt_LastYear_CL = "Letztes Jahr";
    public static String Filter_Confirm_Btn_CL = "Filter anwenden";
    public static String Filter_Cancel_Btn_CL = "Filter zurücksetzen";

    //constructor
    public DocInboxFiltering(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public DocInboxFiltering ExpandDocumentsFiltersAccordion() {
        driver.element().click(Doc_Filter_AccTitle);
        return this;
    }

    public DocInboxFiltering ExpandDocumentsFiltersDDL() {
        driver.element().click(Filter_Option_All);
        return this;
    }

    public DocInboxFiltering ChooseThisMonthFilter() {
        driver.element().isElementClickable(Filter_Opt_ThisMonth);
        driver.element().click(Filter_Opt_ThisMonth);
        return this;
    }

    public DocInboxFiltering ChooseLastMonthFilter() {
        driver.element().isElementClickable(Filter_Opt_LastMonth);
        driver.element().click(Filter_Opt_LastMonth);
        return this;
    }

    public DocInboxFiltering ChooseLastTwoMonthsFilter() {
        driver.element().isElementClickable(Filter_Opt_Last2Months);
        driver.element().click(Filter_Opt_Last2Months);
        return this;
    }

    public DocInboxFiltering ChooseThisYearFilter() {
        driver.element().isElementClickable(Filter_Opt_ThisYear);
        driver.element().click(Filter_Opt_ThisYear);
        return this;
    }

    public DocInboxFiltering ChooseLastYearFilter() {
        driver.element().isElementClickable(Filter_Opt_LastYear);
        driver.element().click(Filter_Opt_LastYear);
        return this;
    }

    public DocInboxFiltering ConfirmFiltering() {
        driver.element().click(Filter_Confirm_Btn);
        return this;
    }

    public DocInboxFiltering CancelFiltering() {
        driver.element().click(Filter_Cancel_Btn);
        return this;
    }

    public DocInboxFiltering ClickOnPaginationNext() {
        driver.element().click(Doc_Pagination_Next);
        return this;
    }

    public DocInboxFiltering ClickOnPaginationLastNext() {
        driver.element().click(Doc_Pagination_LastNext);
        return this;
    }

    public DocInboxFiltering ClickOnPaginationPrevious() {
        driver.element().click(Doc_Pagination_Prev);
        return this;
    }

    public DocInboxFiltering ClickOnPaginationFirstPrevious() {
        driver.element().click(Doc_Pagination_FirstPrev);
        return this;
    }

    public DocInboxFiltering DeeplinkWithValidDocFiltersParamsOfThisMonth() {
        // A new tab is opened and switches to it
        driver.browser().switchToNewTab("https://www.vodafone.de/meinvodafone/services/notifizierung/dokumente?duration=Dieser%20Monat");
        return this;
    }

    public DocInboxFiltering DeeplinkWithValidDocFiltersParamsOfThisYear() {
        driver.browser().switchToNewTab("https://www.vodafone.de/meinvodafone/services/notifizierung/dokumente?duration=Dieses%20Jahr");
        return this;
    }

    public DocInboxFiltering DeeplinkWithInValidDocFiltersParams() {
        driver.browser().switchToNewTab("https://www.vodafone.de/meinvodafone/services/notifizierung/dokumente?duration=This%20Month");
        return this;
    }

    public void BackToDashboard() {
        driver.element().isElementClickable(backButton);
        driver.element().click(backButton);
    }

    public DocInboxFiltering checkAccordionFiltersTitles() {
        driver.verifyThat().element(Doc_Filter_AccTitle)
                .text().isEqualTo(Doc_Filter_AccTitle_CL)
                .withCustomReportMessage("Check that Title of Filters accordion is correct")
                .perform();

        return this;
    }

    public DocInboxFiltering checkDocumentsDisplayed() {
        driver.verifyThat().element(Filter_Option_All).isSelected()
                .withCustomReportMessage("Check that All Dates selected by default")
                .perform();
        driver.verifyThat().element(Filter_Option_All)
                .text().isEqualTo(Filter_Option_All_CL)
                .withCustomReportMessage("Check that Text of all dates filter is correct")
                .perform();
        driver.verifyThat().element(Filter_Confirm_Btn)
                .text().isEqualTo(Filter_Confirm_Btn_CL)
                .withCustomReportMessage("Check that Text of Confirm filters button is correct")
                .perform();
        driver.verifyThat().element(Filter_Cancel_Btn)
                .text().isEqualTo(Filter_Cancel_Btn_CL)
                .withCustomReportMessage("Check that Text of Cancel filters button is correct")
                .perform();
        return this;
    }

    public DocInboxFiltering checkRelatedDocumentsDisplayed() {
        driver.verifyThat().element(Filter_Cancel_Btn).isDisabled()
                .withCustomReportMessage("Check that Cancel button is still dimmed")
                .perform();
        driver.verifyThat().element(Filter_Confirm_Btn).isEnabled()
                .withCustomReportMessage("Check that filter's confirmation button is clickable")
                .perform();
        return this;
    }

    public DocInboxFiltering checkDocumentsFilter() {
        driver.verifyThat().element(Filter_Opt_LastMonth).isSelected()
                .withCustomReportMessage("Check that Chosen filter is selected")
                .perform();
        driver.verifyThat().element(Filter_Opt_LastMonth)
                .text().isEqualTo(Filter_Opt_LastMonth_CL)
                .withCustomReportMessage("Check that Text of all dates filter is correct")
                .perform();
        driver.verifyThat().element(Filter_Confirm_Btn)
                .isDisabled()
                .withCustomReportMessage("Check that filter's confirmation button is back to be dimmed")
                .perform();
        driver.verifyThat().element(Filter_Cancel_Btn)
                .isEnabled()
                .withCustomReportMessage("Check that Cancel button is Clickable").perform();
        return this;
    }

    public DocInboxFiltering checkFilters() {
        driver.verifyThat().element(Filter_Opt_Last2Months)
                .isSelected()
                .withCustomReportMessage("Check that Chosen filter is selected")
                .perform();

        new DocInboxFiltering(driver).CancelFiltering();
        driver.verifyThat().element(Filter_Option_All)
                .isSelected()
                .withCustomReportMessage("Check that Filters back to default all dates")
                .perform();
        driver.verifyThat().element(Filter_Confirm_Btn)
                .isDisabled()
                .withCustomReportMessage("Check that filter's confirmation button is back to be dimmed")
                .perform();
        driver.verifyThat().element(Filter_Cancel_Btn).isDisabled()
                .withCustomReportMessage("Check that filter's cancellation button is back to be dimmed")
                .perform();
        return this;
    }

    public DocInboxFiltering checkChosenFilters() {
        driver.verifyThat().element(Filter_Opt_ThisYear).isSelected()
                .withCustomReportMessage("Check that Chosen filter is selected")
                .perform();
        driver.verifyThat().element(MyDocuments.documentDate).exists()
                .withCustomReportMessage("Make sure filter of this year is applied");
        driver.verifyThat().element(Doc_Pagination)
                .exists()
                .withCustomReportMessage("Check that Pagination is displayed for user has more than 10 Documents for applied filter")
                .perform();
        return this;
    }

    public DocInboxFiltering checkNewChosenFilters() {
        driver.verifyThat().element(Filter_Opt_LastYear)
                .isSelected()
                .withCustomReportMessage("Check that Chosen filter is selected")
                .perform();
        driver.verifyThat().element(MyDocuments.documentDate)
                .exists()
                .withCustomReportMessage("Make sure filter of this year is applied").perform();
        driver.verifyThat().element(Doc_Pagination)
                .doesNotExist()
                .withCustomReportMessage("Check that Pagination is not displayed for user has less than 10 Documents for applied filter")
                .perform();
        return this;
    }

    public DocInboxFiltering checkFiltersAppliedAfterReload(){
        driver.verifyThat().element(Filter_Opt_ThisMonth).isSelected()
                .withCustomReportMessage("Check that Chosen filter is selected")
                .perform();

        new Dashboard(driver).ReloadCurrentPage();

        driver.verifyThat().element(Filter_Opt_ThisMonth).isSelected()
                .withCustomReportMessage("Check that Filters still applied after reload")
                .perform();
        return this;
    }

    public DocInboxFiltering checkChosenFilter(){
        driver.verifyThat().element(Filter_Opt_ThisMonth)
                .isSelected()
                .withCustomReportMessage("Check that Chosen filter is selected")
                .perform();
        return this;
    }

    public DocInboxFiltering checkDefaultFilterOfDeeplink() {
        driver.verifyThat().element(Filter_Option_All)
            .isSelected()
            .withCustomReportMessage("Check that default filter shall be selected when try to deeplink with invalid filter's parameters")
            .perform();
        return this;
    }

    public DocInboxFiltering checkSelectedFilters() {
        driver.verifyThat().element(DocInboxFiltering.Filter_Opt_ThisYear)
                .isSelected()
                .withCustomReportMessage("Check that Chosen filter is selected")
                .perform();
        driver.verifyThat().element(MyDocuments.documentDate)
                .textTrimmed().contains(2022)
                .withCustomReportMessage("Make sure filter of this year is applied")
                .perform();
        return this;
    }

}