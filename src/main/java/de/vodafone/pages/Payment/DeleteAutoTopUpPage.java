package de.vodafone.pages.Payment;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DeleteAutoTopUpPage {
    SHAFT.GUI.WebDriver driver;

    public DeleteAutoTopUpPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private static By permanentlyDeleteButtonLocator = By.xpath("//button[@class ='btn btn-sml skiphash']");
    private static By warningNotificationHeadlineLocator = By.xpath("(//p[@class= 'notification-text mb-10 mt-10'])/..//h4[contains(.,'Wichtig für Dich')]");
    private static By warningNotificationSublineLocator = By.xpath("(//p[@class= 'notification-text mb-10 mt-10'])");
    private static By confirmationNotificationSublineLocator = By.xpath("//div[@class='alert noselect success']//p");
    private static By autoTopupType_value = By.xpath("//div[@automation-id='deleteAutoTopupCycle_tv']/span[2]");
    private static By fakeLocator = By.xpath("//div[@id='12345']");

    //CL
    private String warningNotificationHeadlineCL = "Wichtig für Dich";
    private String warningNotificationSublineCL = "Nach dem Löschen wird Dein Guthaben nicht mehr automatisch aufgeladen.";
    private String confirmationNotificationSublineCl = "Wir haben die automatische Aufladung gelöscht.";
    private String lowerBalanceCl = "Bei Guthaben unter 5 €";

    //Methods
    @Step("Click on Permanently Delete Button")
    public void clickPermanentlyDeleteButton() {
        driver.element().click(permanentlyDeleteButtonLocator);
    }

    public void checkPermanentlyDeleteButtonNotExist() {
        Validations.verifyThat().element(driver.getDriver(), permanentlyDeleteButtonLocator).doesNotExist().perform();
    }

    public void checkWarningNotificationHeadlineCL() {
        driver.verifyThat().element(warningNotificationHeadlineLocator)
                .text().isEqualTo(warningNotificationHeadlineCL)
                .withCustomReportMessage("Check Warning Notification Headline CL").perform();
    }

    public void checkWarningNotificationSublineCL() {
        driver.verifyThat().element( warningNotificationSublineLocator)
                .text().isEqualTo(warningNotificationSublineCL)
                .withCustomReportMessage("Check Warning Notification Subline CL").perform();
    }

    @Step("Assert on Deletion Confirmation notification subline")
    public void assertOnConfirmationNotificationSublineCl() {
        driver.verifyThat().element(confirmationNotificationSublineLocator)
                .textTrimmed().isEqualTo(confirmationNotificationSublineCl)
                .withCustomReportMessage("Assert on Deletion Confirmation notification subline")
                .perform();
    }

    @Step("Assert on Lower Balance Cl in type field")
    public void assertOnLowerBalanceCLinTypeField() {
        Validations.verifyThat().element(driver.getDriver(), autoTopupType_value)
                .text().isEqualTo(lowerBalanceCl)
                .withCustomReportMessage("Assert on Lower Balance Cl in type field")
                .perform();
    }

    public void assertThatPageRedirectedSuccessfully(){
        driver.verifyThat().element(fakeLocator)
                .doesNotExist()
                .withCustomReportMessage("Assert That Page Redirected Successfully")
                .perform();
    }


}