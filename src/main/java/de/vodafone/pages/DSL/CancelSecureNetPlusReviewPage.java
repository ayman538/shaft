package de.vodafone.pages.DSL;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static de.vodafone.pages.commons.UtilitiesPage.getCurrentDate;

public class CancelSecureNetPlusReviewPage {

    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public CancelSecureNetPlusReviewPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Element Locators
    private By pageHeader = By.xpath("//div[@automation-id='pageHeader_tv']//h1");
    private By pageSubHeader = By.xpath("//div[@automation-id='pageHeader_tv']//h2");
    private By cardHeader = By.xpath("//h3[@automation-id='transactionReviewDetails_headline_tv']");
    private By dateTitle = By.xpath("//div[@class='white-box date-card mt-5']//h5");
    private By currentDate = By.xpath("//span[@automation-id='cancel-secure-net-plus-date_tv']");
    private By notificationText = By.xpath("//div[@class='white-box contract-summary-card mt-15']//p");
    private By cancelNowCTA = By.xpath("//button[@automation-id='cancel-secure-net-plus_btn']");
    private By addEmailNotificationHeader = By.xpath("//*[@automation-id='no-dsl-contact-email_nt']//h4");
    private By addEmailNotificationBody = By.xpath("//*[@automation-id='no-dsl-contact-email_nt']//p");
    private By addEmailNotificationCTA = By.xpath("//*[@automation-id='no-dsl-contact-email_btn']");
    private By oldSecurityPackageNotificationHeader = By.xpath("//div[@automation-id='old-security-package_nt']//h4");
    private By oldSecurityPackageNotificationBody = By.xpath("//div[@automation-id='old-security-package_nt']//p");

    //CLs
    private String pageHeaderCL = "Secure Net+";
    private String cardHeaderCL = "Willst Du Secure Net+ kündigen?";
    private String dateTitleCL = "Secure Net+ endet am:";
    private String notificationTextCL = "Wir senden Dir Deine Vertragszusammenfassung per E-Mail zu, nachdem Du gekündigst hast.";
    private String addEmailNotificationHeaderCL = "Wir brauchen Deine E-Mail-Adresse";
    private String addEmailNotificationBodyCL = "Gib uns bitte Deine E-Mail-Adresse. Ohne sie können wir Secure Net+ nicht stornieren.";
    private String addEmailNotificationButtonCL = "E-Mail-Adresse hinzufügen";
    private String oldSecurityPackageNotificationHeaderCL = "Wichtig zu wissen";
    private String oldSecurityPackageNotificationBodyCL = "Dein altes Sicherheitspaket musst Du extra kündigen, das geschieht nicht automatisch.";

    //Methods
    @Step("Click on Cancel Now CTA to confirm cancellation transaction")
    public CancelSecureNetPlusReviewPage clickOnCancelNowCTA(){
        driver.element().click(cancelNowCTA);
        return this;
    }

    @Step("Validations for review page")
    public CancelSecureNetPlusReviewPage validateReviewPageElements(){
        driver.verifyThat().element(pageHeader).textTrimmed().equals(pageHeaderCL);
        driver.verifyThat().element(pageSubHeader).exists().perform();
        driver.verifyThat().element(cardHeader).textTrimmed().equals(cardHeaderCL);
        driver.verifyThat().element(notificationText).textTrimmed().equals(notificationTextCL);
        return this;
    }

    @Step("Validate cancellation current date")
    public CancelSecureNetPlusReviewPage validateCancellationDate(){
        driver.verifyThat().element(dateTitle).textTrimmed().equals(dateTitleCL);
        driver.verifyThat().element(currentDate).textTrimmed().isEqualTo(getCurrentDate("dd.MM.yyyy")).perform();
        return this;
    }

    @Step("Validate Add Email Notification in Review Page")
    public CancelSecureNetPlusReviewPage validateEmailNotification(){
        driver.verifyThat().element(addEmailNotificationHeader).textTrimmed().equals(addEmailNotificationHeaderCL);
        driver.verifyThat().element(addEmailNotificationBody).textTrimmed().equals(addEmailNotificationBodyCL);
        driver.verifyThat().element(addEmailNotificationCTA).textTrimmed().equals(addEmailNotificationButtonCL);
        return this;
    }

    @Step("Validate on Old security package notification")
    public CancelSecureNetPlusReviewPage validateOldSecurityPackageNotification(){
        driver.verifyThat().element(oldSecurityPackageNotificationHeader).textTrimmed().equals(oldSecurityPackageNotificationHeaderCL);
        driver.verifyThat().element(oldSecurityPackageNotificationBody).textTrimmed().equals(oldSecurityPackageNotificationBodyCL);
        return this;
    }
}