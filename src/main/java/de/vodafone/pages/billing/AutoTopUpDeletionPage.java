package de.vodafone.pages.billing;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class AutoTopUpDeletionPage {
    private SHAFT.GUI.WebDriver driver;
    public AutoTopUpDeletionPage (SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private static By autoTopUpDays = By.xpath("//div[@class=\"auto-topup\"]/div[4]/span[2]");

    public static By getAutoTopUpDays() {
        return autoTopUpDays;
    }

    //Validations
    /* *******************WFCT-10045 ******************* */

    public void assertThatAutoTopUpDaysValueIsCorrectlyMappedInDeletionPage(String mappedValue){
        Validations.assertThat()
                .element(driver.getDriver(), AutoTopUpDeletionPage.getAutoTopUpDays()).text()
                .isEqualTo(mappedValue)
                .withCustomReportMessage("assert that auto top up days value is correctly mapped in deletion page")
                .perform();
    }


}
