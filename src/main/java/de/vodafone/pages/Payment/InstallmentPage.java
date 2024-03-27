package de.vodafone.pages.Payment;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class InstallmentPage {
    SHAFT.GUI.WebDriver driver;

    public InstallmentPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    private static By installmentBackBtnLocator = By.xpath("//a[@automation-id='back_Link']");

    private By getInstallmentValueLocator(String valueIndex) {
        return By.xpath("//input[@id='" + valueIndex + "']");

    }

    private static By installmentContinueBtnLocator = By.xpath("//div[@class ='fm-buttons']/button");
    private static By installmentSubmitBtnLocator = By.xpath("//a[@automation-id='confirmation_btn']");
    private static By installmentInformativeTextLocator = By.xpath("//ng-component/div/p");
    private static By installmentSuccessNotificationTitleLocator = By.xpath("//div[@automation-id='undefined_nt']//h4");
    private static By installmentSuccessNotificationTextLocator = By.xpath("//div[@automation-id='undefined_nt']//p");


    private String installmentInformativeTextCl = "Bitte überprüfen Sie nochmal die ausgewählten Raten:";
    private String installmentSuccessNotificationTitleCl = "Vielen Dank für Ihren Auftrag";
    private String installmentSuccessNotificationTextCl = "Sie erhalten in den nächsten Tagen die Bestätigung zu Ihrer Ratenzahlungsvereinbarung mit der Post.";


    @Step("select installment value")
    public void selectInstallmentValue(String value) {
        driver.element().click(getInstallmentValueLocator(value));
    }

    @Step("click installment continue button")
    public void clickOnInstallmentContinueButton() {
        driver.element().hover(installmentContinueBtnLocator);
        driver.element().doubleClick(installmentContinueBtnLocator);
    }

    @Step("click installment submit button")
    public void clickOnInstallmentSubmitButton() {
        driver.element().click(installmentSubmitBtnLocator);
    }

    public void assertOnInstallmentInformativeText() {
        driver.verifyThat().element(installmentInformativeTextLocator).text().isEqualTo(installmentInformativeTextCl).withCustomReportMessage("assert on installment informative text").perform();
    }

    public void assertOnInstallmentSuccessNotificationTitleCl() {
        driver.verifyThat().element(installmentSuccessNotificationTitleLocator).text().isEqualTo(installmentSuccessNotificationTitleCl).withCustomReportMessage("assert on installment success notification title cl").perform();
    }


    public void assertOnInstallmentSuccessNotificationTextCl() {
        driver.verifyThat().element(installmentSuccessNotificationTextLocator).text().isEqualTo(installmentSuccessNotificationTextCl).withCustomReportMessage("assert on installment success notification text cl").perform();
    }

    public void assertWaitElementDoesNotExist()
    {
        driver.verifyThat().element(By.xpath("//a[@automation-id='back_Linksdsasadssad']")).doesNotExist().withCustomReportMessage("wait assertion").perform();
    }


}

