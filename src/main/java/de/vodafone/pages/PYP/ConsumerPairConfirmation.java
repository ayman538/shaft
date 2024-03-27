package de.vodafone.pages.PYP;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class ConsumerPairConfirmation {
    private SHAFT.GUI.WebDriver driver;
    public ConsumerPairConfirmation(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By pageHeadline_text = By.xpath("//*[@automation-id='pageHeader_tv']/h1");
    private By successNotificationHeader_text = By.xpath("//div[@automation-id='pairSuccessNotification_nt']//h4");
    private By successNotificationContent_text = By.xpath("//div[@automation-id='pairSuccessNotification_nt']//p");
    private By notificationHeader_text = By.xpath("//div[@automation-id='pairInProgressNotification_nt']//h4");
    private By notificationContent_text = By.xpath("//div[@automation-id='pairInProgressNotification_nt']//p");

    private final String pageHeadlineCL = "Vodafone OneNumber Car Data";
    private final String successNotificationHeaderCL = "Fast geschafft";
    private final String successNotificationContentCL = "Du bekommst eine Bestätigungs-SMS, wenn Dein Auto verbunden ist.";
    private final String notificationHeaderCL = "Gut zu wissen";
    private final String notificationContentCL = "Wer im WLAN Deines Autos surft, nutzt das Datenvolumen Deines verbundenen Red-Tarifs.";

    public void pageHeadlineValidation(){
        Validations.assertThat()
                .element(driver.getDriver(), pageHeadline_text)
                .text().isEqualTo(pageHeadlineCL)
                .withCustomReportMessage("Check Confirmation page title")
                .perform();
    }

    public void successNotificationValidation(){
        Validations.assertThat()
                .element(driver.getDriver(), successNotificationHeader_text)
                .text().isEqualTo(successNotificationHeaderCL)
                .withCustomReportMessage("Check Confirmation page success notification header")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), successNotificationContent_text)
                .text().isEqualTo(successNotificationContentCL)
                .withCustomReportMessage("Check Confirmation page success notification text")
                .perform();
    }

    public void notificationValidation() {
        Validations.assertThat()
                .element(driver.getDriver(), notificationHeader_text)
                .text().isEqualTo(notificationHeaderCL)
                .withCustomReportMessage("Check Confirmation page notification header")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), notificationContent_text)
                .text().isEqualTo(notificationContentCL)
                .withCustomReportMessage("Check Confirmation page notification header")
                .perform();
    }
}
