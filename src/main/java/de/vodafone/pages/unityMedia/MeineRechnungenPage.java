package de.vodafone.pages.unityMedia;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MeineRechnungenPage {
    private SHAFT.GUI.WebDriver driver;

    //locators
    private By kostenkontrolleTab = By.xpath("//a[@automation-id='Kostenkontrolle_Link']");
    private By tvAndVideoTab = By.xpath("//fieldset/radio-item[1][@automation-id='unbilledMeineRechnungenBothProductsTV_rb']");
    private By thirdPartyBillHeader = By.xpath("//h3[@class='third_party_header']");
    private By thirdPartyBillSubHeader = By.xpath("//p[@class='third_party_text']");
    private By thirdPartyBillName = By.xpath("(//span[@automation-id='unbilledVideoContentConnectionDetailsName_tv'])[3]");
    private By thirdPartyDropDownBtn = By.xpath("(//div[@class='sub-item'])[3]");

    private By thirdPartyBillPrice = By.xpath("(//span[@automation-id='unbilledVideoContentConnectionDetailsTotalAmount_tv'])[3]");
    private By thirdPartyBillDate = By.xpath("(//div[@automation-id='unbilledVideoContentConnectionDetailsExpandedDateLabel_tv'])[3]");
    private By thirdPartyBillDateNum = By.xpath("(//div[@automation-id='unbilledVideoContentConnectionDetailsExpandedDate_tv'])[3]");
    private By thirdPartyBillTime = By.xpath("(//div[@automation-id='unbilledVideoContentConnectionDetailsExpandedTimeLabel_tv'])[3]");
    private By thirdPartyBillTimeNum = By.xpath("(//div[@automation-id='unbilledVideoContentConnectionDetailsExpandedTime_tv'])[3]");

    private static By lastChartBarLocator = By.xpath("//div[@id = 'line-11']");
    private By MonthLocator = By.xpath("//*[@automation-id='billMonth_tv']");
    /* Those locator are for any active month (Selected month) */
    private By dateLocator = By.xpath("//div[contains(@class,'active')]/span[@automation-id='billDate_tv']");
    private By amountLocator = By.xpath("//div[contains(@class,'active')]/span[@automation-id='billAmount_tv']");
    private By belowChartText_Locator = By.xpath("//*[@automation-id='umBillChart_con']//span[@class='ml-8 pointer']");
    private By getBarLocator(String barOrder) {
        return By.xpath("(//*[@automation-id='billBar_cbar'])[" + barOrder + "]");
    }

    private By getMonthLocator(String barOrder) {
        return By.xpath("(//*[@automation-id='billMonth_tv'])[" + barOrder + "]");
    }

    //CL
    private String belowChartText_CL = "Übersicht der letzten 12 Monate ausblenden";


    //constructor
    public MeineRechnungenPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click On Kostenkontrolle tab")
    public MeineRechnungenPage clickOnKonstenKontrolleTab() {
        driver.element().click(kostenkontrolleTab);
        return this;
    }

    @Step("Click on TV and Video Tab")
    public MeineRechnungenPage clickOnTvAndVideoTab() {
        driver.element().click(tvAndVideoTab);
        return this;
    }

    //methods
    @Step("Verify the third party unbilled charges")
    public MeineRechnungenPage verifyThirdPartyUnbilledCharges(String billHeader, String billSubHeader
            , String billName, String billPrice) {
        driver.element().verifyThat(thirdPartyBillHeader).text().isEqualTo(billHeader).perform();
        driver.element().verifyThat(thirdPartyBillSubHeader).text().isEqualTo(billSubHeader).perform();
        driver.element().verifyThat(thirdPartyBillName).text().isEqualTo(billName).perform();
        driver.element().verifyThat(thirdPartyBillPrice).text().isEqualTo(billPrice).perform();
        return this;
    }

    @Step("Click on the third party drop down button")
    public MeineRechnungenPage clickOnTheThirdPartyBillDropDownBtn() {
        driver.element().click(thirdPartyDropDownBtn);
        return this;
    }

    @Step("Verify third party bill details")
    public MeineRechnungenPage verifyThirdPartyBillsDetails(String billDate, String billDateNum, String billTime) {
        driver.element().verifyThat(thirdPartyBillDate).text().isEqualTo(billDate).perform();
        driver.element().verifyThat(thirdPartyBillDateNum).text().isEqualTo(billDateNum).perform();
        driver.element().verifyThat(thirdPartyBillTime).text().isEqualTo(billTime).perform();
        return this;
    }



    public MeineRechnungenPage assertOnNotRetrievedBarHeight(String barOrder) {
        driver.verifyThat()
                .element(getBarLocator(barOrder))
                .cssProperty("height")
                .isEqualTo("0px")
                .withCustomReportMessage("Assert that bar height equals Zero")
                .perform();
        return this;
    }

    public MeineRechnungenPage assertOnNotClickableMonth(String barOrder) {
        driver.verifyThat()
                .element(getMonthLocator(barOrder))
                .attribute("class")
                .contains("not-active")
                .withCustomReportMessage("Assert that month is not clickable")
                .perform();
        return this;
    }


    public MeineRechnungenPage assertOnSelectedBarColor(String barOrder) {
        driver.verifyThat().element(getBarLocator(barOrder)).cssProperty("background-color").contains("230, 0, 0").withCustomReportMessage("assert on selected bar color").perform();
        driver.verifyThat().element(getBarLocator(barOrder)).attribute("class").contains("active").withCustomReportMessage("assert on selected bar color").perform();
        return this;
    }

    public MeineRechnungenPage assertOnNotSelectedBarColor(String barOrder) {
        driver.verifyThat().element(getBarLocator(barOrder)).cssProperty("background-color").contains("230, 0, 0").withCustomReportMessage("assert on  not selected bar color").perform();
        driver.verifyThat().element(getBarLocator(barOrder)).attribute("class").doesNotContain("active").withCustomReportMessage("assert on not selected bar color").perform();
        return this;
    }

    public MeineRechnungenPage assertThatChartHas12Months() {
        SHAFT.Validations.verifyThat().object(driver.element().getElementsCount(MonthLocator)).isEqualTo(12).withCustomReportMessage("assert that chart has 12 months").perform();
        return this;
    }

    public MeineRechnungenPage assertOnDateValue(String dateValue) {
        driver.verifyThat().element(dateLocator).text().isEqualTo(dateValue).withCustomReportMessage("assert on date value").perform();
        return this;
    }


    public MeineRechnungenPage assertOnAmountValue(String amountValue) {
        driver.verifyThat().element(amountLocator).text().isEqualTo(amountValue).withCustomReportMessage("assert on amount value").perform();
        return this;
    }


    public MeineRechnungenPage assertOnTheBelowChartText() {
        driver.verifyThat().element(belowChartText_Locator).textTrimmed().isEqualTo(belowChartText_CL).withCustomReportMessage("assert on the below chart text").perform();
        return this;
    }

    public MeineRechnungenPage assertOnBarHeight(String barOrder,String barHeight){
        driver.verifyThat().element(getBarLocator(barOrder)).attribute("style").isEqualTo("height: "+barHeight+";").withCustomReportMessage("assert on bar height").perform();
        return this;
    }
}
