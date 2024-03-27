package de.vodafone.pages.FormCenter;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class FormRendering {

    //Variables
    private SHAFT.GUI.WebDriver driver;
    private String FailedFormURL = System.getProperty("de.vodafone.baseUrl.st") + "hilfe/formulare/5";
    private String InvalidCaptchaFormURL = System.getProperty("de.vodafone.baseUrl.st") + "hilfe/formulare/23595";

    private String FormURL = System.getProperty("de.vodafone.baseUrl.st") + "hilfe/formulare/4916244100612";
    //Element Locators
    private By firstName_inputField = By.xpath("(//*[@automation-id='field-aut-id-456_et'])[1]");
    private By firstName_inputField5 = By.xpath("//*[@name='first_name']");

    private By age_inputField = By.xpath("//*[@automation-id='field-aut-id-789_et']");
    private By age_inputField5 = By.xpath("//*[@name='number']");

    private By email_inputField = By.xpath("(//*[@automation-id='field-aut-id-456_et'])[2]");
    private By radioButtonOption1 = By.xpath("(//span[@class='ws10-form-selection-control__text'])[1]");
    private By checkBoxOption2 = By.xpath("(//span[@class='ws10-form-selection-control__text'])[4]");
    private By contractType_dropdownMenu = By.xpath("//*[@automation-id='ws10-form-select_dropdown']");
    private By requestInfo_inputField = By.xpath("//*[@automation-id='field-aut-id-753_et']");
    private By invalidCaptchaError = By.xpath("//*[@automation-id='captcha-aut_error_tv']");

    private By date_inputField = By.xpath("//*[@automation-id='field-aut-id-963_et']");
    private By time_inputField = By.xpath("//*[@automation-id='field-aut-id-987_et']");
    private By downloadFile_Button = By.xpath("//a[@role='button']");
    private By submit_Button = By.xpath("//*[@automation-id='undefined_Link' and contains(.,'Abesenden')]");
    private By captcha_inputField = By.xpath("//*[@automation-id='captcha-aut_text_input_et']");
    private By invalidCaptchaErrorMSG = By.xpath("//*[@class='ws10-notification__headline']");


    //CLs
    private String invalidCaptchaErrorCL = "Der Code ist nicht richtig. Gib den Code bitte nochmal ein.";
    private String invalidCaptchaErrorMSGCL = "Der Sicherheitscode ist nicht korrekt";

    //Constructor
    public FormRendering(SHAFT.GUI.WebDriver driver)
    {
        this.driver = driver;
    }

    //Methods
    public FormRendering navigateToFormURL(){
        driver.browser().navigateToURL( FormURL);
        return new FormRendering(driver);
    }

    public FormRendering navigateToFailedFormURL(){
        driver.browser().navigateToURL( FailedFormURL);
        return new FormRendering(driver);
    }

    public FormRendering navigateToInvalidCaptchaFormURL(){
        driver.browser().navigateToURL( InvalidCaptchaFormURL);
        return new FormRendering(driver);
    }
    public FormRendering typeFirstName(String firstName){
        new ElementActions(driver.getDriver()).type(firstName_inputField, firstName);
        return this;
    }

    public FormRendering typeFirstNameForm5(String firstName){
        new ElementActions(driver.getDriver()).type(firstName_inputField5, firstName);
        return this;
    }

    public FormRendering typeAge(String age){
        new ElementActions(driver.getDriver()).type(age_inputField, age);
        return this;
    }

    public FormRendering typeAge5(String age){
        new ElementActions(driver.getDriver()).type(age_inputField5, age);
        return this;
    }

    public FormRendering typeEmail(String email){
        new ElementActions(driver.getDriver()).type(email_inputField, email);
        return this;
    }

    public FormRendering chooseRadioOption1(){
        new ElementActions(driver.getDriver()).click(radioButtonOption1);
        return this;
    }

    public FormRendering checkOption2(){
        new ElementActions(driver.getDriver()).click(checkBoxOption2);
        return this;
    }

    public FormRendering chooseFromDropDownMenu(String option){
        new ElementActions(driver.getDriver()).select(contractType_dropdownMenu, option);
        return this;
    }

    public FormRendering typeRequestInfo(String Info){
        new ElementActions(driver.getDriver()).type(requestInfo_inputField, Info);
        return this;
    }


    public FormRendering typeCaptcha(String captcha){
        new ElementActions(driver.getDriver()).type(captcha_inputField, captcha);
        return this;
    }

    public FormRendering setDate(){
        new ElementActions(driver.getDriver()).click(date_inputField);
        return this;
    }

    public FormRendering setTime(){
        new ElementActions(driver.getDriver()).click(time_inputField);
        return this;
    }

    public FormRendering checkDownloadButtonIsExisted(){
        Validations.assertThat().element(driver.getDriver(), downloadFile_Button).exists().perform();
        return this;
    }

    public FormRendering checkSubmitButtonIsEnabled(){
        Validations.assertThat().element(driver.getDriver(), submit_Button).isEnabled().perform();
        return this;
    }

    public FormRendering checkSubmitButtonIsNotEnabled(){
        Validations.assertThat().element(driver.getDriver(), submit_Button).isDisabled().perform();
        return this;
    }

    public FormRendering clickOnSubmit(){
        new ElementActions(driver.getDriver()).click(submit_Button);
        return this;
    }

    @Step("Validate invalid captcha error")
    public void validateInvalidCaptchaError() {
        Validations.assertThat()
                .element(driver.getDriver(), invalidCaptchaErrorMSG)
                .text().isEqualTo(invalidCaptchaErrorMSGCL).perform();

        Validations.assertThat()
                .element(driver.getDriver(), invalidCaptchaError)
                .text().isEqualTo(invalidCaptchaErrorCL).perform();
    }

}
