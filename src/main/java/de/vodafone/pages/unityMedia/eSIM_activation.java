package de.vodafone.pages.unityMedia;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
public class eSIM_activation {
    private SHAFT.GUI.WebDriver driver;

    //CLs
    private static String page_TitleCL = "Aktivierungscode und Aktivierungs-PIN";
    private static String pageSubTitleCL = "Mobilfunk-Vertrag (Kundennummer: 108332703)";
    private static String activationAcc_HeaderCL = "Codes zum Aktivieren Ihres eSIM-Profils";
    private static String info_msgCL = "Haben Sie ein eSIM-fähiges Gerät, das auch QR-Codes lesen kann? Dann können Sie das eSIM-Profil aktivieren, indem Sie den QR-Code direkt scannen oder herunterladen.";
    private static String confirmation_code_TitleCL = "Dein Bestätigungscode / ePIN";
    //Locators
    private static final By page_Title = By.xpath("//*[@automation-id='pageHeader_tv']/h1");
    private static final By pageSubTitle = By.xpath("(//*[@automation-id='pageHeader_tv']//span)[2]");
    private static final By activationAcc_Header = By.xpath("//*[@automation-id='oneStepStepperHeader_tv']");
    private static final By info_msg = By.xpath("(//*[@class='content-block']/p)[1]");
    private static final By phoneStatus = By.xpath("//*[@class='white-box']//span[2]");//exists
    private static final By qrCode = By.xpath("//*[@id='exportqr']");//exists
    private static final By pdf_Btn = By.xpath("//*[@class='btn btn-em mt-10']");//exists
    private static final By confirmation_code_Title = By.xpath("(//*[@class='block-details']/h3)[2]");
    private static final By verification_code = By.xpath("//*[@class='password-block']");//exists
    private static final By back_Button = By.xpath("//*[@automation-id='back_Link']");//exists
    private static final By first_linkout = By.xpath("(//*[@class='custom-arrordion-list']//li)[1]");//exists
    private static final By second_Linkout = By.xpath("    (//*[@class='custom-arrordion-list']//li)[2]");//exists

    // Methods


    //Constractor
    public eSIM_activation(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    
    @Step("validate eSIM Activation page's content" )
    public void validatePageContent() {
    Validations.assertThat().element(driver.getDriver(), eSIM_activation.back_Button).exists();
    Validations.assertThat()
            .element(driver.getDriver(), eSIM_activation.pageSubTitle)
            .text()
            .isEqualTo(eSIM_activation.pageSubTitleCL)
            .withCustomReportMessage("Verify Page Title")
            .perform();
    Validations.assertThat()
            .element(driver.getDriver(), eSIM_activation.page_Title)
            .text()
            .isEqualTo(eSIM_activation.page_TitleCL)
            .withCustomReportMessage("Verify Page Title")
            .perform();
    Validations.assertThat()
            .element(driver.getDriver(), eSIM_activation.activationAcc_Header)
            .text()
            .isEqualTo(eSIM_activation.activationAcc_HeaderCL)
            .withCustomReportMessage("Verify Activation Header")
            .perform();
    Validations.assertThat()
            .element(driver.getDriver(), eSIM_activation.info_msg)
            .text()
            .isEqualTo(eSIM_activation.info_msgCL)
            .withCustomReportMessage("Verify Info Message")
            .perform();
    Validations.assertThat().element(driver.getDriver(), eSIM_activation.phoneStatus).exists();
    Validations.assertThat().element(driver.getDriver(), eSIM_activation.qrCode).exists();
    Validations.assertThat().element(driver.getDriver(), eSIM_activation.pdf_Btn).exists();
    Validations.assertThat()
            .element(driver.getDriver(), eSIM_activation.confirmation_code_Title)
            .text()
            .isEqualTo(eSIM_activation.confirmation_code_TitleCL)
            .withCustomReportMessage("Verify confirmation code")
            .perform();
    Validations.assertThat().element(driver.getDriver(), eSIM_activation.verification_code).exists();
    Validations.assertThat().element(driver.getDriver(), eSIM_activation.first_linkout).exists();
    Validations.assertThat().element(driver.getDriver(), eSIM_activation.second_Linkout).exists();
}
}
