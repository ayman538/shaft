package de.vodafone.pages.billing;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AutoTopUPAccordion {
    private SHAFT.GUI.WebDriver driver;
    private static By autoTopUpStatus = By.xpath("//div[@class=\"auto-topup\"]/div[1]/span[2]");
    private static By autoTopUpDays = By.xpath("//div[@class=\"auto-topup\"]/div[4]/span[2]");
    private static By autoTopUpDeletionBtn = By.xpath("//button[@accordion-id=\"aufladen\"][contains(.,\"löschen\")]");
    private static By autoTopUpStatusBtn = By.xpath("//button[@accordion-id=\"aufladen\"][contains(.,\"ändern\")]");

    public AutoTopUPAccordion(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public static By getAutoTopUpStatus() {
        return autoTopUpStatus;
    }

    public static By getAutoTopUpDays() {
        return autoTopUpDays;
    }


    // CL

    String activeTopUp_CL = "aktiv";
    String pausedTopUp_CL = "pausiert";


    //method
    @Step("Click on auto topup delete button")
    public AutoTopUpDeletionPage clickAutoTopUpDeleteBtn() {
        driver.element().click( autoTopUpDeletionBtn);
        return new AutoTopUpDeletionPage(driver);
    }

    // Validations
    /* *****************WFCT-10045******************* */

    public void assertThatUserHasActiveAutoTopUp() {
        Validations.assertThat()
                .element(driver.getDriver(), AutoTopUPAccordion.getAutoTopUpStatus()).text()
                .isEqualTo(activeTopUp_CL)
                .withCustomReportMessage("assert that user has active auto topup")
                .perform();
    }


    public void assertThatUserHasPausedAutoTopUp() {
        Validations.assertThat()
                .element(driver.getDriver(), AutoTopUPAccordion.getAutoTopUpStatus()).text()
                .isEqualTo(pausedTopUp_CL)
                .withCustomReportMessage("assert that user has paused auto topup")
                .perform();
    }


    public void assertThatAutoTopUpDaysValueIsCorrectlyMapped(String mappedValue) {
        Validations.assertThat()
                .element(driver.getDriver(), AutoTopUPAccordion.getAutoTopUpDays()).text()
                .isEqualTo(mappedValue)
                .withCustomReportMessage("assert that auto top up days value is correctly mapped")
                .perform();
    }
}
