package de.vodafone.pages.CableOnboarding;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class TechInstallDashboard {

    // Variables
    private final SHAFT.GUI.WebDriver driver;

    //Locators
    public static final By installation_data_btn = By.xpath("//*[@id='content']//ws10-button-tile-list//a[3]");
    private static final By moreInfo_Button = By.xpath("//*[@automation-id='Moreinfo_Link']//a");
    private static final By fourthTile_button = By.xpath("//*[@id='content']//ws10-button-tile-list//a[4]");
    public static By acceptCookies_button = By.xpath("//button//span[contains(text(),'ablehnen')]");
    private By pageHeader = By.xpath("//h1[@automation-id='h1_tv']");
    private By tarrifName = By.xpath("//div[@class='ws10-text-large font-20-18']");
    private By firstChecklistTile = By.xpath("//div[@id='content']//ws10-link-tiles//ul/li[1]/a//span");
    private By secondChecklistTile = By.xpath("//div[@id='content']//ws10-link-tiles//ul/li[2]/a//span");
    private By thirdChecklistTile = By.xpath("//div[@id='content']//ws10-link-tiles//ul/li[3]/a//span");
    private By forthChecklistTile = By.xpath("//div[@id='content']//ws10-link-tiles//ul/li[4]/a//span");
    private By firstTeaserTitle = By.xpath("//h3[@class='ws10-h3 ws10-discovery-card__headline']");
    private By secondTeaserTitle = By.xpath("(//div[@class='ws10-discovery-card__item ws10-discovery-card__item--horizontal']//h3)[1]");
    private By thirdTeaserTitle = By.xpath("(//div[@class='ws10-discovery-card__item ws10-discovery-card__item--horizontal']//h3)[2]");
    private By faqHeadline = By.xpath("(//h3[@automation-id='h3_tv'])[3]");
    private By faqFirstQuestion = By.xpath("(//label[@class='ws10-accordion-item__label'])[1]");
    private By faqSecondQuestion = By.xpath("(//label[@class='ws10-accordion-item__label'])[2]");
    private By faqThirdQuestion = By.xpath("(//label[@class='ws10-accordion-item__label'])[3]");
    private By faqForthQuestion = By.xpath("(//label[@class='ws10-accordion-item__label'])[4]");
    private By firstChecklistTileBadge = By.xpath("//a[@title='Deine Checkliste']//div//p");





    //constructor
    public TechInstallDashboard(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //keywords
    public FAQsPage navigateToFAQsPage() {
        (new ElementActions(driver.getDriver())).click(moreInfo_Button);
        return new FAQsPage(driver);
    }
    public TechInstall_RouterInstallationPage clickOnFourthTile() {
        (new ElementActions(driver.getDriver())).click(fourthTile_button);
        return new TechInstall_RouterInstallationPage(driver);

    }
// WFFT-1078
    public TechInstall_KnowMorePage Clickinstallationbtn() {
        new ElementActions(driver.getDriver()).click(installation_data_btn);
        return new TechInstall_KnowMorePage (driver);
    }

    public TechInstallDashboard acceptCookies() {
        driver.element().click( acceptCookies_button);
        return this;
    }
    //END WFFT-1078

    //WFFT_4057
    @Step("Clink on the Infos zum Technik-Service")
    public Info_Technik_Service clickOnInfoTile() {
        driver.element().click(secondChecklistTile);
       return new Info_Technik_Service(driver);
    }
    public TechInstallDashboard validateDashboard(String header) {
        driver.verifyThat()
                .element(pageHeader)
                .textTrimmed()
                .contains(header)
                .perform();
      return this;
    }
    //WFFT-3801
    @Step("Verify the dashboard checklist in case of provider change booked")
    public TechInstallDashboard validateChecklistProviderChangeBooked(String header, String tarrifTitle, String deineChecklist, String technicalService
    , String providerChangeTitle, String WLANSetup){
        driver.verifyThat().element(pageHeader).textTrimmed().contains(header).perform();
        driver.verifyThat().element(tarrifName).textTrimmed().contains(tarrifTitle).perform();
        driver.verifyThat().element(firstChecklistTile).textTrimmed().contains(deineChecklist).perform();
        driver.verifyThat().element(secondChecklistTile).textTrimmed().contains(technicalService).perform();
        driver.verifyThat().element(thirdChecklistTile).textTrimmed().contains(providerChangeTitle).perform();
        driver.verifyThat().element(forthChecklistTile).textTrimmed().contains(WLANSetup).perform();
        return this;
    }
    @Step("Verify the dashboard checklist in case of provider change not booked")
    public TechInstallDashboard validateChecklistProviderChangeNotBooked(String header, String tarrifTitle, String deineChecklist, String technicalService,
                                                                         String WLANSetup){
        driver.verifyThat().element(pageHeader).textTrimmed().contains(header).perform();
        driver.verifyThat().element(tarrifName).textTrimmed().contains(tarrifTitle).perform();
        driver.verifyThat().element(firstChecklistTile).textTrimmed().contains(deineChecklist).perform();
        driver.verifyThat().element(secondChecklistTile).textTrimmed().contains(technicalService).perform();
        driver.verifyThat().element(thirdChecklistTile).textTrimmed().contains(WLANSetup).perform();
        return this;
    }

    @Step("Verify the teasers in case of provider change booked")
    public TechInstallDashboard verifyTeasersProviderChangeBooked(String secondTeaser, String thirdTeaser){
        driver.verifyThat().element(secondTeaserTitle).textTrimmed().contains(secondTeaser).perform();
        driver.verifyThat().element(thirdTeaserTitle).textTrimmed().contains(thirdTeaser).perform();
        return this;
    }
    @Step("Verify the teasers in case of provider change not booked")
    public TechInstallDashboard verifyTeasersProviderChangeNotBooked(String firstTeaser, String secondTeaser, String thirdTeaser){
        driver.verifyThat().element(firstTeaserTitle).textTrimmed().contains(firstTeaser).perform();
        driver.verifyThat().element(secondTeaserTitle).textTrimmed().contains(secondTeaser).perform();
        driver.verifyThat().element(thirdTeaserTitle).textTrimmed().contains(thirdTeaser).perform();
        return this;
    }

    @Step("Verify the FAQ at the bottom of the page")
    public TechInstallDashboard verifyTheFAQ(String faqHeadliner, String firstFAQ, String secondFAQ, String thirdFAQ, String forthFAQ){
        driver.verifyThat().element(faqHeadline).textTrimmed().contains(faqHeadliner).perform();
        driver.verifyThat().element(faqFirstQuestion).textTrimmed().contains(firstFAQ).perform();
        driver.verifyThat().element(faqSecondQuestion).textTrimmed().contains(secondFAQ).perform();
        driver.verifyThat().element(faqThirdQuestion).textTrimmed().contains(thirdFAQ).perform();
        driver.verifyThat().element(faqForthQuestion).textTrimmed().contains(forthFAQ).perform();
        return this;
    }
    //END WFFT-3801

    //WFFT_3806
    @Step("Click on deine checklist")
    public TechInstallDashboard clickOnDeineChecklist(){
        driver.element().click(firstChecklistTile);
        return this;
    }
    @Step("Verify the deine checklist badge")
    public TechInstallDashboard verifyDeineChecklistBadge(String badge){
        driver.verifyThat().element(firstChecklistTileBadge).textTrimmed().contains(badge).perform();
        return this;
    }
    //END_WFFT_3806

    //START_WFFT_4090
    @Step("Click on WLAN set up")
    public TechInstallDashboard clickOnWLANSetUp(){
        driver.element().click(forthChecklistTile);
        return this;
    }
}



