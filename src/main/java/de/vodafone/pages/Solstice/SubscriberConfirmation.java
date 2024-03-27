package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class SubscriberConfirmation {
    private SHAFT.GUI.WebDriver driver;
    private static By uploadDocument_button = By.xpath("//*[@automation-id='returnToUploadDocmentFlow_btn']");
    private static final String uploadDocument = "Hochladen fortsetzen";

    public SubscriberConfirmation(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void pageNewButtonValidation() {
        Validations.assertThat()
                .element(driver.getDriver(), SubscriberConfirmation.uploadDocument_button)
                .text()
                .isEqualTo(SubscriberConfirmation.uploadDocument)
                .withCustomReportMessage("confirmation page with an additional/new CTA button \"under add missing subscribers button\"")
                .perform();
    }
}
