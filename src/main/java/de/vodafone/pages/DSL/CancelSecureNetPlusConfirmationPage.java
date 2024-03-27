package de.vodafone.pages.DSL;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static de.vodafone.pages.commons.UtilitiesPage.getCurrentDate;

public class CancelSecureNetPlusConfirmationPage {

    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public CancelSecureNetPlusConfirmationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Element Locators
    private By pageHeader = By.xpath("//div[@automation-id='pageHeader_tv']//h1");
    private By confirmationMessageHeader = By.xpath("//div[@automation-id='confirm-cancel-secure-net-plus_nt']//h4");
    private By confirmationMessageBody = By.xpath("//div[@automation-id='confirm-cancel-secure-net-plus_nt']//p");
    private By overviewMenuHeader = By.xpath("//li[@automation-id='accordion0_acc']//a");
    private By dateTitle = By.xpath("//div[@class='white-box date-card mt-5']//h5");
    private By currentDate = By.xpath("//span[@automation-id='confirm-cancel-secure-net-plus-date_tv']");
    private By oldSecurityPackageNotificationHeader = By.xpath("//div[@automation-id='old-security-package_nt']//h4");
    private By oldSecurityPackageNotificationBody = By.xpath("//div[@automation-id='old-security-package_nt']//p");

    //CLs
    private String pageHeaderCL = "Secure Net+";
    private String confirmationMessageHeaderCL = "Du hast gekündigt!";
    private String confirmationMessageBodyCL = "Deine Vertragszusammenfassung wird an folgende Adresse geschickt:";
    private String confirmationMessageMailCL = "rafael.zelek@googlemail.com";
    private String overviewMenuHeaderCL = "Übersicht";
    private String dateTitleCL = "Secure Net+ endet am:";
    private String oldSecurityPackageNotificationHeaderCL = "Wichtig zu wissen";
    private String oldSecurityPackageNotificationBodyCL = "Dein altes Sicherheitspaket musst Du extra kündigen, das geschieht nicht automatisch.";

    //Methods
    @Step("Validations for confirmation page")
    public CancelSecureNetPlusConfirmationPage validateConfirmationPageElements(){
        driver.verifyThat().element(pageHeader).textTrimmed().equals(pageHeaderCL);
        driver.verifyThat().element(overviewMenuHeader).textTrimmed().equals(overviewMenuHeaderCL);
        return this;
    }

    @Step("Validate confirmation message")
    public CancelSecureNetPlusConfirmationPage validateConfirmationMessage(){
        driver.verifyThat().element(confirmationMessageHeader).textTrimmed().equals(confirmationMessageHeaderCL);
        driver.verifyThat().element(confirmationMessageBody).text().contains(confirmationMessageBodyCL).perform();
        driver.verifyThat().element(confirmationMessageBody).text().contains(confirmationMessageMailCL).perform();
        return this;
    }

    @Step("Expand overview menu")
    public CancelSecureNetPlusConfirmationPage expandOverviewMenu(){
        driver.element().click(overviewMenuHeader);
        return this;
    }

    @Step("Validate cancellation current date")
    public CancelSecureNetPlusConfirmationPage validateCancellationDate(){
        driver.verifyThat().element(dateTitle).textTrimmed().equals(dateTitleCL);
        driver.verifyThat().element(currentDate).textTrimmed().isEqualTo(getCurrentDate("dd.MM.yyyy")).perform();
        return this;
    }

    @Step("Validate on Old security package notification")
    public CancelSecureNetPlusConfirmationPage validateOldSecurityPackageNotification(){
        driver.verifyThat().element(oldSecurityPackageNotificationHeader).textTrimmed().equals(oldSecurityPackageNotificationHeaderCL);
        driver.verifyThat().element(oldSecurityPackageNotificationBody).textTrimmed().equals(oldSecurityPackageNotificationBodyCL);
        return this;
    }

}
