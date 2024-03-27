package de.vodafone.pages.Payment;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DunningGPP {
    SHAFT.GUI.WebDriver driver;
    private By sofortPayLocator = By.xpath("//button[@type='button'][contains(.,'Jetzt bezahlen')]");
    private By payPalPayLocator = By.xpath("//div[@id='paypalButton']");
    private By amazonPayLocator = By.xpath("//div[@id='amazonpay']");
    private By creditCardPayLocator = By.xpath("//button[@type='button'][contains(.,'Jetzt bezahlen')]");
    private By googlePayLocator = By.id("googlepay");
    private By spinnerLocator = By.xpath("//div[@class='spinnerDim']");
    private By sofortAndAmazonPayErrorNotificationTitleLocator = By.xpath("//h4[@class='flexDiv']");
    private By sofortAndAmazonPayErrorNotificationDivLocator = By.xpath("//div[@automation-id='undefined_nt']");
    private By sofortAndAmazonPayErrorNotificationTextLocator = By.xpath("//p[@class='notification-text mb-10 mt-10']");
    private By creditCarderrorNotification_Locator = By.xpath("//div[@class='alert-content no-head']/p[@class='notification-text']");

    public DunningGPP(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public By getPaymentMethodLocator(String paymentMethod) {
        return By.xpath("//p[text() = '" + paymentMethod + "']");
    }

    public TopupGPP choosePaymentMethod(String paymentMethod) {
        driver.element().click( getPaymentMethodLocator(paymentMethod));
        return new TopupGPP(driver);
    }

    public By getSavedPaymentMethodLocator(String savedPaymentMethodName) {
        return By.xpath("//p[contains(.,'Gespeichert: " + savedPaymentMethodName + "')]");
    }

    public SofortPage payWithSofort() {
        driver.element().click( sofortPayLocator);
        return new SofortPage(driver);
    }

    public CreditCardPage payWithCreditCard() {
        driver.element().click( creditCardPayLocator);
        return new CreditCardPage(driver);
    }

    public PayPalPage payWithPayPal() {
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(payPalPayLocator)).click();

        return new PayPalPage(driver);
    }

    public AmazonPayPage payWithAmazonPay() {
        WebDriverWait wait = new WebDriverWait(driver.getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(amazonPayLocator)).click();

        return new AmazonPayPage(driver);
    }

    public void switchToPaymentPopUp() {
        Object[] handles = driver.getDriver().getWindowHandles().toArray();
        driver.browser().switchToWindow(handles[1].toString());
    }

    public void switchToGPP() {
        Object[] handles = driver.getDriver().getWindowHandles().toArray();
        driver.browser().switchToWindow(handles[0].toString());
    }

    public void selectSavedPaymentMethod(String savedPaymentMethodName) {
        driver.element().click( getSavedPaymentMethodLocator(savedPaymentMethodName));
    }

    public void assertOnSofortAndAmazonPayErrorTitle() {
        Validations.verifyThat().element(driver.getDriver(), sofortAndAmazonPayErrorNotificationTitleLocator).text().isEqualTo("Entschuldigung, da ist was schiefgelaufen.").withCustomReportMessage("Error Notification title Assertion ").perform();
    }

    public void assertOnSofortAndAmazonPayErrorNotificationExixtance() {
        driver.verifyThat().element(sofortAndAmazonPayErrorNotificationDivLocator).exists()
                .withCustomReportMessage("assert On Sofort And Amazon Pay Error Div Exixtance").perform();
    }

    public void assertOnSofortAndAmazonPayErrorText() {
        Validations.verifyThat().element(driver.getDriver(), sofortAndAmazonPayErrorNotificationTextLocator).text().isEqualTo("Bitte versuchen Sie es später noch einmal.").withCustomReportMessage("Error Notification Text Assertion ").perform();
    }

    public void assertOnCreditCardErrorText() {
        Validations.verifyThat().element(driver.getDriver(), creditCarderrorNotification_Locator).text().isEqualTo("Leider gab es mit Ihrer Zahlung ein Problem. Wählen Sie bitte eine andere Bezahlmethode oder wenden Sie sich an Ihre Bank.").withCustomReportMessage("Error Notification Text Assertion ").perform();
    }

    public void assertThatIbanMethodNotExist() {
        driver.verifyThat()
                .element(ibanSavedPaymentMethod_Locator)
                .doesNotExist()
                .withCustomReportMessage("assert that sofort saved payment method doesn not exist").perform();
    }
    private By ibanSavedPaymentMethod_Locator = By.xpath("");
}
