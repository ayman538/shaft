package de.vodafone.pages.DSL;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static de.vodafone.pages.commons.UtilitiesPage.getCurrentDate;

public class SecureNetPlusBookingConfirmation {

    //Variables
    SHAFT.GUI.WebDriver driver;

    //Constructor
    public SecureNetPlusBookingConfirmation(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Element Locators
    private By pageHeader = By.xpath("//div[@automation-id='pageHeader_tv']//h1");
    private By contractNumberHeader = By.xpath("//div[@automation-id='pageHeader_tv']//h2");
    private By successMessageHeader = By.xpath("//*[@automation-id='confirm- book-secure-net-plus_nt']//h4");
    private By successMessageBody = By.xpath("//*[@automation-id='confirm- book-secure-net-plus_nt']//p");
    private By overviewHeader = By.xpath("(//li[@automation-id='accordion0_acc']//span)[1]");
    private By secureNetTileName = By.xpath("(//*[@automation-id='confirm- book-secure-net-plus_tile']//span)[1]");
    private By secureNetTilePrice = By.xpath("//div[@class='tariffPrice']");
    private By secureNetTileDescription = By.xpath("//div[@class='short-description']");
    private By secureNetTileDetailsLink = By.xpath("//div[@class='tariff-card-details']//a");
    private By secureNetStartDateLabel = By.xpath("//*[@class='white-box date-card mt-5']//h5");
    private By currentDate = By.xpath("//span[@automation-id='confirm- book-secure-net-plus-date_tv']");
    private By conflictMsgHeader = By.xpath("//*[@automation-id='old-security-package_nt']//h4");
    private By conflictMsgBody = By.xpath("//*[@automation-id='old-security-package_nt']//p");

    //CLs
    private String pageHeaderCL = "Secure Net+";
    private String contractNumberHeaderCL = "(Kundennummer: 001944180035)";
    private String successMessageHeaderCL = "Fast geschafft!";
    private String overviewHeaderCL = "Übersicht";
    private String secureNetTileNameCL = "Vodafone Secure Net+";
    private String secureNetTilePriceCL = "3,99 €";
    private String secureNetStartDateLabelCL = "Secure Net+ beginnt am:";
    private String conflictMsgHeaderCL = "Wichtig zu wissen";
    private String conflictMsgBodyCL = "Dein altes Sicherheitspaket musst Du extra kündigen, das geschieht nicht automatisch.";

    //Methods
    public SecureNetPlusBookingConfirmation expandOverviewAccordion() {
        driver.element().click(overviewHeader);
        return this;
    }

    @Step("Validate OverviewCard")
    public SecureNetPlusBookingConfirmation validateSecureNetCard(){
        driver.verifyThat().element(secureNetTileName).textTrimmed().isEqualTo(secureNetTileNameCL).perform();
        driver.verifyThat().element(secureNetTilePrice).textTrimmed().isEqualTo(secureNetTilePriceCL).perform();
        driver.verifyThat().element(secureNetTileDescription).text().isNotNull().perform();
        driver.verifyThat().element(secureNetTileDetailsLink).exists().perform();
        return this;
    }

    @Step("Validate the Success Message In the Confirmation Page")
    public SecureNetPlusBookingConfirmation validateSuccessMessage(){
        driver.verifyThat().element(pageHeader).textTrimmed().isEqualTo(pageHeaderCL).perform();
        driver.verifyThat().element(contractNumberHeader).text().contains(contractNumberHeaderCL).perform();
        driver.verifyThat().element(successMessageHeader).textTrimmed().isEqualTo(successMessageHeaderCL).perform();
        driver.verifyThat().element(successMessageBody).text().isNotNull().perform();
        driver.verifyThat().element(overviewHeader).textTrimmed().isEqualTo(overviewHeaderCL).perform();
        return this;
    }

    @Step("Validate Conflict Msg in Confirmation Page")
    public SecureNetPlusBookingConfirmation validateConflictMsgInConfirmationPage(){
        driver.verifyThat().element(conflictMsgHeader).textTrimmed().isEqualTo(conflictMsgHeaderCL).perform();
        driver.verifyThat().element(conflictMsgBody).textTrimmed().isEqualTo(conflictMsgBodyCL).perform();
        return this;
    }

    @Step("Validate booking date")
    public SecureNetPlusBookingConfirmation validateBookingDate(){
        driver.verifyThat().element(secureNetStartDateLabel).textTrimmed().isEqualTo(secureNetStartDateLabelCL).perform();
        driver.verifyThat().element(currentDate).textTrimmed().isEqualTo(getCurrentDate("dd.MM.yyyy")).perform();
        return this;
    }

}
