package de.vodafone.pages.TwoFA;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class MergeAccounts2FAStep {
    private static SHAFT.GUI.WebDriver driver;

    public MergeAccounts2FAStep(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By pageHeader = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    private By sectionHeader = By.xpath("//span[@automation-id='oneStepStepperHeader_tv']");
    private By text = By.xpath("//div[@automation-id='TOTPTxtContainer_tv']/p");
    private By codeLabel = By.xpath("//label[@for='text']");
    private By codeInput = By.xpath("//input[@automation-id='authenticationCodeField_et']");
    private By emptyFieldError = By.xpath("//p[@automation-id='authenticationCodeFieldrequiredErrorMessage_et']");
    private By wrongRegexError = By.xpath("//p[@automation-id='authenticationCodeField_patternErrorMessage_et']");
    private By invalidErrorHeader = By.xpath("//h4[@class='flexDiv']");
    private By invalidErrorText = By.xpath("//p[@class='notification-text mb-10 mt-10']");
    private By weiterButton = By.xpath("//button[@class='btn btn-alt']");


    private String pageHeaderCL= "Leg Deine Kundenkonten zusammen";
    private String sectionHeaderCL= "2-Faktor-Authentifizierung";
    private String textCL= "Gib hier den 6-stelligen Zahlen-Code aus Deiner Authentifizierungs-App ein.";
    private String codeLabelCL= "Zahlen-Code *";
    private String emptyFieldErrorCL= "Das Feld darf nicht leer sein. Gib bitte einen gültigen Code ein.";
    private String wrongRegexErrorCL= "Gib bitte einen gültigen Code ein. Er besteht aus 6 Zahlen.";
    private String invalidErrorHeaderCL= "Hier stimmt was nicht";
    private String invalidErrorTextCL= "Du hast den Zahlen-Code falsch eingegeben. Versuch es bitte nochmal.";
    private String weiterButtonCL= "Weiter";

    public MergeAccounts2FAStep typeCode(String code){
        driver.element().type(codeInput, code);
        return this;
    }
    public MergeAccounts2FAStep clickWeiterButton() {
        driver.element().click(weiterButton);
        return this;
    }

    @Step("Verify page CL")
    public void verifyPageCL(){
        driver.verifyThat().element(pageHeader).text().isEqualTo(pageHeaderCL).perform();
        driver.verifyThat().element(sectionHeader).text().isEqualTo(sectionHeaderCL).perform();
        driver.verifyThat().element(text).text().isEqualTo(textCL).perform();
        driver.verifyThat().element(codeLabel).text().isEqualTo(codeLabelCL).perform();
        driver.verifyThat().element(weiterButton).text().isEqualTo(weiterButtonCL).perform();
    }
    @Step("check inline error for empty code field")
    public MergeAccounts2FAStep checkEmptyFieldErrorMsg(){
        driver.element().keyPress(codeInput, Keys.TAB);
        driver.verifyThat().element(emptyFieldError).text().isEqualTo(emptyFieldErrorCL).perform();
        return this;
    }
    @Step("check inline error for wrong code regex")
    public MergeAccounts2FAStep checkWrongRegexErrorMsg(){
        driver.element().type(codeInput, "1234567");
        driver.element().keyPress(codeInput,Keys.TAB);
        driver.verifyThat().element(wrongRegexError).text().isEqualTo(wrongRegexErrorCL).perform();
        return this;
    }
    @Step("Check CL for invalid code error msg")
    public void verifyInvalidError(){
        driver.verifyThat().element(invalidErrorHeader).text().isEqualTo(invalidErrorHeaderCL).perform();
        driver.verifyThat().element(invalidErrorText).text().isEqualTo(invalidErrorTextCL).perform();
    }

}
