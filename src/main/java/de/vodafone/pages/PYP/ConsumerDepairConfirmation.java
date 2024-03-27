package de.vodafone.pages.PYP;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class ConsumerDepairConfirmation {
    private SHAFT.GUI.WebDriver driver;
    public ConsumerDepairConfirmation(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By pageHeadline_text = By.xpath("//*[@automation-id='pageHeader_tv']/h1");
    private By successNotificationHeader_text = By.xpath("//div[@automation-id='depairSuccessMessage_nt']//h4");
    private By successNotificationContent_text = By.xpath("//div[@automation-id='depairSuccessMessage_nt']//p");
    private By notificationHeader_text = By.xpath("//div[@automation-id='depairinProgressMessage_nt']//h4");
    private By notificationContent_text = By.xpath("//div[@automation-id='depairinProgressMessage_nt']//p");

    private final String pageHeadlineCL = "Vodafone OneNumber Car Data";
    private final String successNotificationHeaderCL = "Verbindung getrennt";
    private final String successNotificationContentCL = "Du bekommst eine Bestätigungs-SMS, wenn Dein Auto getrennt ist.";
    private final String notificationHeaderCL = "Gut zu wissen";
    private final String notificationContentCL = "Deine OneNumber Car Data ist weiterhin gebucht.";

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
