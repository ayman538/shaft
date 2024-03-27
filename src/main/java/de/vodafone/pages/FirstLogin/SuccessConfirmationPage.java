package de.vodafone.pages.FirstLogin;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class SuccessConfirmationPage {
    private SHAFT.GUI.WebDriver driver;
    public SuccessConfirmationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By pageHeadline_text = By.xpath("//*[@automation-id='pageHeader_tv']");
    private By notificationHeader_text = By.xpath("//div[@automation-id='undefined_nt']//h4");
    private By notificationContent_text = By.xpath("//div[@automation-id='undefined_nt']//p");
    private By notificationCTA_button = By.xpath("//*[@automation-id='undefined_btn']");
    private By summaryHeader_text = By.xpath("//div[@class='ac-body']//h3");
    private By summaryNameTitle_text = By.xpath("//div[@class='ac-body']//p[1]/strong");
    private By summaryEmailTitle_text = By.xpath("//div[@class='ac-body']//p[2]/strong");
    private By summaryPhoneTitle_text = By.xpath("//div[@class='ac-body']//p[3]/strong");
    private By changeEmail_text = By.xpath("(//div[@class='ac-body']//p)[4]");
    private By changeEmail_button = By.xpath("//div[@class='ac-body']//button");


    private String pageHeadlineCL = "Dein erster Login";
    private String notificationHeaderCL = "Fast geschafft";
    private String notificationContentCL = "Jetzt schicken wir Dir eine E-Mail zu, in der Du Deine E-Mail-Adresse bestätigen musst. Klick dazu auf ";
    private String notificationContent2CL = "“Bestätigungs-E-Mail erhalten”";
    private String notificationContent3CL = "Diese E-Mail schicken wir Dir an folgende Adresse:";
    private String notificationContent4CL = "user@vodafone.com";
    private String notificationCTACL = "Bestätigungs-E-Mail erhalten";
    private String summaryHeaderCL = "Folgende Daten haben wir von Dir gespeichert:";
    private String summaryNameTitleCL = "Benutzername:";
    private String summaryEmailTitleCL = "E-Mail-Adresse:";
    private String summaryPhoneTitleCL = "Rufnummer:";
    private String changeEmailCL = "Die E-Mail-Adresse stimmt nicht? Du kannst sie hier nochmal ändern.";
    private String changeEmailButtonCL = "E-Mail-Adresse ändern";


    @Step("Page Title Validation")
    public void pageTitleValidation(){
        Validations.assertThat()
                .element(driver.getDriver(), pageHeadline_text)
                .text()
                .isEqualTo(pageHeadlineCL)
                .withCustomReportMessage("Check Page Headline")
                .perform();
    }

    @Step("Success Notification Validations")
    public void successNotificationValidations(){
        Validations.assertThat()
                .element(driver.getDriver(), notificationHeader_text)
                .text()
                .isEqualTo(notificationHeaderCL)
                .withCustomReportMessage("Check Notification Header ")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), notificationContent_text)
                .text()
                .contains(notificationContentCL)
                .withCustomReportMessage("Check Notification Content")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), notificationContent_text)
                .text()
                .contains(notificationContent2CL)
                .withCustomReportMessage("Check Notification Content")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), notificationContent_text)
                .text()
                .contains(notificationContent3CL)
                .withCustomReportMessage("Check Notification Content")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), notificationContent_text)
                .text()
                .contains(notificationContent4CL)
                .withCustomReportMessage("Check Notification Content")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), notificationCTA_button)
                .text()
                .isEqualTo(notificationCTACL)
                .withCustomReportMessage("Check Notification CTA CL")
                .perform();
    }

    @Step("Summary Validations")
    public void summaryValidations(){
        Validations.assertThat()
                .element(driver.getDriver(), summaryHeader_text)
                .text()
                .isEqualTo(summaryHeaderCL)
                .withCustomReportMessage("Check Summary Header")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), summaryNameTitle_text)
                .text()
                .isEqualTo(summaryNameTitleCL)
                .withCustomReportMessage("Check summary name title ")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), summaryEmailTitle_text)
                .text()
                .isEqualTo(summaryEmailTitleCL)
                .withCustomReportMessage("Check summary email title ")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), summaryPhoneTitle_text)
                .text()
                .isEqualTo(summaryPhoneTitleCL)
                .withCustomReportMessage("Check summary phone title")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), changeEmail_text)
                .text()
                .isEqualTo(changeEmailCL)
                .withCustomReportMessage("Check change email text")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), changeEmail_button)
                .text()
                .isEqualTo(changeEmailButtonCL)
                .withCustomReportMessage("Check change email CTA CL")
                .perform();
    }
}
