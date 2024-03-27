package de.vodafone.pages.Payment;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class RedirectDebitPage {
    SHAFT.GUI.WebDriver driver;

    public RedirectDebitPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    private static By redirectDebitSubmitButton = By.xpath("//div[@class='white-box']/../button");
    private static By rddPreConfirmationInformativeTextLocator = By.xpath("//div[@class='white-box']//p");
    private static By redirectDebitSuccessNotificationTitleLocator = By.xpath("//div[@automation-id='undefined_nt']//h4");
    private static By redirectDebitSuccessNotificationTextLocator = By.xpath("//div[@automation-id='undefined_nt']//p");

    private String rddPreConfirmationInformativeTextCl = "ziehen wir in den nächsten Tagen von Ihrem Bankkonto ein.";
    private String rddSuccessNotificationTitleCl = "Vielen Dank für Ihren Auftrag!";
    private String rddSuccessNotificationTextCl = "Den Betrag ziehen wir in den nächsten Tagen von Ihrem Bankkonto ein.";


    @Step("click on renew direct debit submit button")
    public void clickOnRenewDirectDebitSubmitButton() {
        driver.element().click(redirectDebitSubmitButton);
    }

    public void assertOnRDDPreConfirmationInformativeText() {
        driver.verifyThat().element(rddPreConfirmationInformativeTextLocator).text().contains(rddPreConfirmationInformativeTextCl).withCustomReportMessage("assert on RDD pre confirmation informative text").perform();
    }

    public void assertThatRDDSuccessNotificationTitleIsCorrect() {
        driver.verifyThat().element(redirectDebitSuccessNotificationTitleLocator).text().isEqualTo(rddSuccessNotificationTitleCl).withCustomReportMessage("assert that RDD success notification title is correct").perform();
    }

    public void assertThatRDDSuccessNotificationTextIsCorrect() {
        driver.verifyThat().element(redirectDebitSuccessNotificationTextLocator).text().isEqualTo(rddSuccessNotificationTextCl).withCustomReportMessage("assert that RDD success notification text is correct").perform();
    }
    public void waitPageToBeLoaded()
    {
        driver.verifyThat().element(By.xpath("pageloded")).doesNotExist().withCustomReportMessage("wait for page to be loaded").perform();
    }

}
