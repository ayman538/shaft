package de.vodafone.pages.DSL;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static de.vodafone.pages.commons.UtilitiesPage.getCurrentDate;

public class SecureNetPlusBookingTransaction {

    //Variables
    SHAFT.GUI.WebDriver driver;

    //Constructor
    public SecureNetPlusBookingTransaction(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Element Locators
    private By pageHeader = By.xpath("//div[@automation-id='pageHeader_tv']//h1");
    private By contractNumberHeader = By.xpath("//div[@automation-id='pageHeader_tv']//h2");
    private By overviewHeader = By.xpath("//h3[@automation-id='transactionReviewDetails_headline_tv']");
    private By secureNetTileName = By.xpath("(//*[@automation-id='book-secure-net-plus_tcrd']//span)[1]");
    private By secureNetTilePrice = By.xpath("//*[@class='tariffPrice']");
    private By secureNetTileDescription = By.xpath("//div[@class='short-description']");
    private By secureNetTileDetailsLink = By.xpath("//*[@class='tariff-card-details']//a");
    private By secureNetStartDateLabel = By.xpath("//div[@class='white-box date-card mt-5']//h5");
    private By currentDate = By.xpath("//span[@automation-id='book-secure-net-plus-date_tv']");
    private By legalInformationTermsAndConditions = By.xpath("//div[@class='white-box contract-summary-card mt-15']");
    private By secureNetBookNowCTA = By.xpath("//*[@automation-id='book-secure-net-plus_btn']");
    private By conflictMsgHeader = By.xpath("//*[@automation-id='old-security-package_nt']//h4");
    private By conflictMsgBody = By.xpath("//*[@automation-id='old-security-package_nt']//p");

    //CLs
    private String pageHeaderCL = "Secure Net+";
    private String contractNumberHeaderCL = "(Kundennummer: 001944180035)";
    private String overviewHeaderCL = "Willst Du Secure Net+ buchen?";
    private String secureNetTileNameCL = "Vodafone Secure Net+";
    private String secureNetTilePriceCL = "3,99 €";
    private String secureNetStartDateLabelCL = "Secure Net+ beginnt am:";
    private String legalInformationTermsAndConditionsCL = "Gut zu wissen: Bevor Secure Net+ wirksam wird, musst Du der Vertragszusammenfassung zustimmen. Diese schicken wir Dir zu. So kannst Du alles nochmal in Ruhe prüfen.";
    private String secureNetBookNowCTACL = "Los geht’s";
    private String conflictMsgHeaderCL = "Wichtig zu wissen";
    private String conflictMsgBodyCL = "Dein altes Sicherheitspaket musst Du extra kündigen, das geschieht nicht automatisch.";

    //Methods
    public SecureNetPlusBookingTransaction clickConfirmBookSecureNetPlusCTA(){
        driver.element().click(secureNetBookNowCTA);
        return this;
    }

    @Step("Validate booking date")
    public SecureNetPlusBookingTransaction validateBookingDate(){
        driver.verifyThat().element(secureNetStartDateLabel).textTrimmed().isEqualTo(secureNetStartDateLabelCL).perform();
        driver.verifyThat().element(currentDate).textTrimmed().isEqualTo(getCurrentDate("dd.MM.yyyy")).perform();
        return this;
    }

    @Step("Validate Secure Net Transaction Page")
    public SecureNetPlusBookingTransaction validateSecureNetTransactionPage() {
        driver.verifyThat().element(pageHeader).textTrimmed().isEqualTo(pageHeaderCL).perform();
        driver.verifyThat().element(contractNumberHeader).text().contains(contractNumberHeaderCL).perform();
        driver.verifyThat().element(overviewHeader).textTrimmed().isEqualTo(overviewHeaderCL).perform();
        driver.verifyThat().element(legalInformationTermsAndConditions).text().contains(legalInformationTermsAndConditionsCL).perform();
        driver.verifyThat().element(secureNetBookNowCTA).textTrimmed().isEqualTo(secureNetBookNowCTACL).perform();
        return this;
    }

    @Step("Validate Secure Net option card")
    public SecureNetPlusBookingTransaction validateSecureNetCard(){
        driver.verifyThat().element(secureNetTileName).textTrimmed().isEqualTo(secureNetTileNameCL).perform();
        driver.verifyThat().element(secureNetTilePrice).text().contains(secureNetTilePriceCL).perform();
        driver.verifyThat().element(secureNetTileDescription).text().isNotNull().perform();
        driver.verifyThat().element(secureNetTileDetailsLink).exists().perform();
        return this;
    }

    @Step("Validate Conflict Msg")
    public SecureNetPlusBookingTransaction validateConflictMsgInTransactionPage(){
        driver.verifyThat().element(conflictMsgHeader).textTrimmed().isEqualTo(conflictMsgHeaderCL).perform();
        driver.verifyThat().element(conflictMsgBody).textTrimmed().isEqualTo(conflictMsgBodyCL).perform();
        return this;
    }
}
