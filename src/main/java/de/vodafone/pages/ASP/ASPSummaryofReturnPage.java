package de.vodafone.pages.ASP;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ASPSummaryofReturnPage {
    private SHAFT.GUI.WebDriver driver;

    //constructor
    public ASPSummaryofReturnPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By returnSummaryPageHeader = By.xpath("(//div[@automation-id='pageHeader_tv']/h1)[1]");
    private By returnSummaryPageSubHeader = By.xpath("(//span[@automation-id='oneStepStepperHeader_tv'])[1]");
    private By nameField = By.xpath("//p[@automation-id='Name_tv']/strong");
    private By deliveryAddressField = By.xpath("//p[@automation-id='Delivery_Address_tv']/strong");
    private By revocationDateField = By.xpath("//p[@automation-id='Termination_Date_tv']/strong");
    private By declartionField = By.xpath("//p[@automation-id='Notice_Of_Termination_tv']/strong");
    private By declartionbutton = By.xpath("//button[@automation-id='confirmation_btn']");
    private By qrCodeMsg = By.xpath("(//p[@class='notification-text'])[1]");
    private By qrCodeMsg_termination = By.xpath("(//p[@class='notification-text'])[2]");
    private By qrCodebutton = By.xpath("//button[@automation-id='SendingDeviceBack_btn']");
    //CL
    private String returnSummaryPageHeaderCL = "Deine Rücksendung";
    private String returnSummaryPageHeaderCL_Revoke = "Deine Retoure";
    private String returnSummaryPageSubHeaderCL_Revoke = "Wir haben Deinen Widerruf erhalten. Schick uns bitte Dein Gerät zurück.";
    private String returnSummaryPageSubHeaderCL_terminate = "Wir haben Deine Kündigung erhalten. Schick uns bitte Dein Gerät zurück.";

    private String nameField_CL = "Name:";
    private String deliveryAddressField_CL = "Versandadresse:";
    private String revocationDateField_CL = "Widerrufsdatum";
    private String terminationDateField_CL = "Kündigungsdatum";

    private String declartionField_CL_revoke = "Widerrufserklärung";
    private String declartionField_CL_terminate = "Kündigungserklärung";

    private String qrCodeMsg_CL_revocation = "Du kannst für Deine Rücksendung einen QR-Code oder einen Retourenschein nutzen.";
    private String qrCodeMsg_CL_termination = "Warte mit der Rücksendung des Geräts bis zum Ende Deines Vertrags. Wir melden uns dann mit allen Infos zur Rücksendung bei Dir.";

    private String declartionbutton_CL = "Speichern";
    private String qrcodebutton_CL = "QR-Code und Retourenschein anfordern";


    //Validations


    @Step("Validate summary of return page for revocation")
    public ASPSummaryofReturnPage validateReturnSummary_revocation() {
        driver.verifyThat().element(returnSummaryPageHeader).isVisible().perform();
        driver.verifyThat().element(returnSummaryPageHeader).text().isEqualTo(returnSummaryPageHeaderCL_Revoke).perform();
        driver.verifyThat().element(returnSummaryPageSubHeader).text().isEqualTo(returnSummaryPageSubHeaderCL_Revoke).perform();
        driver.verifyThat().element(nameField).text().isEqualTo(nameField_CL).perform();
        driver.verifyThat().element(revocationDateField).text().isEqualTo(revocationDateField_CL).perform();
        driver.verifyThat().element(deliveryAddressField).text().isEqualTo(deliveryAddressField_CL).perform();
        driver.verifyThat().element(declartionField).text().isEqualTo(declartionField_CL_revoke).perform();
        driver.verifyThat().element(declartionbutton).text().isEqualTo(declartionbutton_CL).perform();
        driver.verifyThat().element(qrCodeMsg).text().isEqualTo(qrCodeMsg_CL_revocation).perform();
        driver.verifyThat().element(qrCodebutton).text().isEqualTo(qrcodebutton_CL).perform();

        return this;
    }

    @Step("Validate summary of return page for revocation")
    public ASPSummaryofReturnPage validateReturnSummary_termination() {
        driver.verifyThat().element(returnSummaryPageHeader).isVisible().perform();
        driver.verifyThat().element(returnSummaryPageHeader).textTrimmed().isEqualTo(returnSummaryPageHeaderCL_Revoke).perform();
        driver.verifyThat().element(returnSummaryPageSubHeader).textTrimmed().isEqualTo(returnSummaryPageSubHeaderCL_terminate).perform();
        driver.verifyThat().element(nameField).textTrimmed().isEqualTo(nameField_CL).perform();
        driver.verifyThat().element(revocationDateField).textTrimmed().isEqualTo(terminationDateField_CL).perform();
        driver.verifyThat().element(deliveryAddressField).textTrimmed().isEqualTo(deliveryAddressField_CL).perform();
        driver.verifyThat().element(declartionField).textTrimmed().isEqualTo(declartionField_CL_terminate).perform();
        driver.verifyThat().element(declartionbutton).textTrimmed().isEqualTo(declartionbutton_CL).perform();
        driver.verifyThat().element(qrCodeMsg).textTrimmed().isEqualTo(qrCodeMsg_CL_termination).perform();
        driver.verifyThat().element(qrCodebutton).textTrimmed().isEqualTo(qrcodebutton_CL).perform();

        return this;
    }

    @Step("CLick on QR button")
    public ASPSummaryofReturnPage clickOnQRButton(){
        driver.element().click(qrCodebutton);
        return this;
    }

    @Step("validate url for deer user in summary page")
    public void deerURLValidation() throws InterruptedException {
        Thread.sleep(5000);
        driver.verifyThat().element(nameField).exists().perform();
        driver.verifyThat().browser().url().contains("/retoure/cancel-contract/confirmation-kuendigen-kabel-um").perform();
    }
    @Step("validate url for girrafe user in summary page")
    public void girrafeURLValidation(){
        driver.verifyThat().element(nameField).exists().perform();
        driver.verifyThat().browser().url().contains("/retoure/cancel-contract/confirmation-widerruf-kabel-um").perform();
    }
    @Step("validate url for fox user in summary page")
    public void foxURLValidation() throws InterruptedException {
        Thread.sleep(5000);
        driver.verifyThat().element(nameField).exists().perform();
        driver.verifyThat().browser().url().contains("/retoure/cancel-contract/confirmation-kuendigen-kabel-vkd").perform();
    }
    @Step("validate url for camel user in summary page")
    public void camelURLValidation(){
        driver.verifyThat().element(nameField).exists().perform();
        driver.verifyThat().browser().url().contains("/retoure/cancel-contract/confirmation-widerruf-kabel-vkd").perform();
    }
}


