package de.vodafone.pages.PYP;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class UpsellingConfirmationPage {
    private SHAFT.GUI.WebDriver driver;
    public UpsellingConfirmationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By notificationHeader_text = By.xpath("//div[@automation-id='upsellConfirmation_nt']//h4");
    private By notificationContent_text = By.xpath("//div[@automation-id='upsellConfirmation_nt']//p");

    private String notificationHeaderCL = "Die neue SIM wurde gebucht";
    private String notificationContentCL = "Du kannst die SIM nun mit Deinem Auto verbinden.";
    @Step("Validate Success Notification")
    public UpsellingConfirmationPage notificationValidation(){
        Validations.assertThat()
                .element(driver.getDriver(), notificationHeader_text)
                .text()
                .isEqualTo(notificationHeaderCL)
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), notificationContent_text)
                .text()
                .isEqualTo(notificationContentCL)
                .perform();
        return this;
    }

}
