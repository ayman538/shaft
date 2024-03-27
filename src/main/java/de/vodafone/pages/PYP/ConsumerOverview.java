package de.vodafone.pages.PYP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ConsumerOverview {
    private SHAFT.GUI.WebDriver driver;
    public ConsumerOverview(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //overview page locators
    public static By stepper1 = By.xpath("//*[@automation-id='oneStepStepperHeader_tv']");
    private By unpairConsumer_button = By.xpath("//*[@automation-id='simDetailsSubmitBtn_btn']");
    private By pairConsumer_button = By.xpath("(//*[@automation-id='simDetailsSubmitBtn_btn'])[1]");
    private By pageHeader_text = By.xpath("//*[@automation-id='pageHeader_tv']/h1");
    private By upsell_text = By.xpath("//*[@automation-id='overviewUpsellingCardstartOfContractBody_tv']");
    private By firstTerms_LinkText = By.linkText("Allgemeinen Geschäftsbedingungen für Vodafone-Dienstleistungen");
    private By secondTerms_LinkText = By.linkText("Widerrufsbelehrung.");
    private By upsellingHeader_text = By.xpath("//*[@automation-id='overviewUpsellingCardupsellDetailesHeader_tv']");
    private By upsellingSubHeader_text = By.xpath("//*[@automation-id='overviewUpsellingCardupsellDetailesSubHeader_tv']");
    private By upsellingDetails_button = By.xpath("//*[@automation-id='upsellCollapsiblePanelcollapseButtonTxt_tv']");
    private By upsellingCardHeader_text = By.xpath("//*[@automation-id='overviewUpsellingCardupsellBodyHeader_tv']");
    private By upsellingMonthlyFee_text = By.xpath("//*[@automation-id='overviewUpsellingCardupsellMonthlyFeeText_tv']");
    private By upsellingActivationFee_text = By.xpath("//*[@automation-id='overviewUpsellingCardupsellActivationFeeText_tv']");
    private By upsellingActivationFeeSub_text = By.xpath("//*[@automation-id='overviewUpsellingCardupsellActivationFeeSubheadline_tv']");
    private By upsellingStartHeadline_text = By.xpath("//*[@automation-id='overviewUpsellingCardstartOfContractHeadline_tv']");
    private By upsellingStartSubHeadline_text = By.xpath("//*[@automation-id='overviewUpsellingCardstartOfContractSubHead_tv']");
    private By upsellingStartBody_text = By.xpath("//*[@automation-id='overviewUpsellingCardstartOfContractBody_tv']");
    private By upsellingTermsHeadline_text = By.xpath("//*[@automation-id='overviewUpsellingCardstartOfContractBody_tv']");
    private By upsellingSubmit_button = By.xpath("//*[@automation-id='overviewUpsellingCardsubmitButton_btn']");

    private String upsellingHeaderCL = "Eine OneNumber Car Data bestellen";
    private String upsellingSubHeaderCL = "Bestell hier eine neue OneNumber Car Data dazu. Du nutzt dann das Datenvolumen Deines Red-Tarifs.";
    private String upsellingCardHeaderCL = "Vodafone OneNumber Car Data";
    private String upsellingMonthlyFeeCL = "pro Monat inkl. MwSt.";
    private String upsellingActivationFeeCL = "Aktivierungsgebühr";
    private String upsellingActivationFeeSubCL = "einmal";
    private String upsellingStartHeadlineCL = "Vertragsstart";
    private String upsellingStartSubHeadlineCL = "Sofort";
    private String upsellingStartBodyCL = "Keine Mindestlaufzeit, Kündigung jederzeit möglich, tageweise Abrechnung.";


    private static final String PageHeader = "Vodafone OneNumber Car Data";
    private static final String stepper = "Mit Deinem Auto verbinden";
    private static final String upsell = "Keine Mindestlaufzeit, Kündigung jederzeit möglich, tageweise Abrechnung.";

    public ConsumerOverview clickUnpairConsumerButton()
    {
        new ElementActions(driver.getDriver()).click(unpairConsumer_button);
        return this;
    }
    public ConsumerOverview clickPairConsumerButton()
    {
        new ElementActions(driver.getDriver()).click(pairConsumer_button);
        return this;
    }
    public void pageHeadlineValidation(){
        Validations.assertThat()
                .element(driver.getDriver(), stepper1)
                .text().isEqualTo(stepper)
                .withCustomReportMessage("Check Confirmation page stepper")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), pageHeader_text)
                .text().isEqualTo(PageHeader)
                .withCustomReportMessage("Check Confirmation page title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), upsell_text)
                .text().isEqualTo(upsell)
                .withCustomReportMessage("Check upsell title")
                .perform();
    }
    public void pageTermsAndConditionButtonsValidation() {
        Validations.assertThat()
                .element(driver.getDriver(), firstTerms_LinkText)
                .exists()
                .withCustomReportMessage("check that first terms and condition link is exixt")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), secondTerms_LinkText)
                .isVisible()
                .withCustomReportMessage("check that second terms and condition link is exixt")
                .perform();
    }

    @Step("Page Title Validation")
    public ConsumerOverview upsellingValidations(){
        Validations.assertThat()
                .element(driver.getDriver(), upsellingHeader_text)
                .text()
                .isEqualTo(upsellingHeaderCL)
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), upsellingSubHeader_text)
                .text()
                .isEqualTo(upsellingSubHeaderCL)
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), upsellingCardHeader_text)
                .text()
                .isEqualTo(upsellingCardHeaderCL)
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), upsellingMonthlyFee_text)
                .text()
                .isEqualTo(upsellingMonthlyFeeCL)
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), upsellingActivationFee_text)
                .text()
                .isEqualTo(upsellingActivationFeeCL)
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), upsellingActivationFeeSub_text)
                .text()
                .isEqualTo(upsellingActivationFeeSubCL)
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), upsellingStartHeadline_text)
                .text()
                .isEqualTo(upsellingStartHeadlineCL)
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), upsellingStartSubHeadline_text)
                .text()
                .isEqualTo(upsellingStartSubHeadlineCL)
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), upsellingStartBody_text)
                .text()
                .isEqualTo(upsellingStartBodyCL)
                .perform();

        return this;
    }

    @Step("Click upselling details button")
    public ConsumerOverview clickUpsellingDetailsButton()
    {
        new ElementActions(driver.getDriver()).click(upsellingDetails_button);
        return this;
    }

    @Step("Click Upselling Submit Button")
    public ConsumerOverview clickUpsellingSubmitButton()
    {
        new ElementActions(driver.getDriver()).click(upsellingSubmit_button);
        return this;
    }
}
