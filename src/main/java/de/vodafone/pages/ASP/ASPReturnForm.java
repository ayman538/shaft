package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ASPReturnForm {
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public ASPReturnForm(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By returnFormPageHeader = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    private By stepperHeader = By.xpath("//span[@automation-id='oneStepStepperHeader_tv']");
    private By emailAddressHeader = By.xpath("//text[@formcontrolname='emailAddress']/div/div/label");
    private By emailAddressTextBox = By.xpath("//input[@automation-id='emailAddress_et']");
    private By firstnameHeader = By.xpath("//text[@formcontrolname='firstName']/div/div/label");
    private By firstnameTextBox = By.xpath("//input[@automation-id='firstName_et']");
    private By lastnameHeader = By.xpath("//text[@formcontrolname='lastName']/div/div/label");
    private By lastnameTextBox = By.xpath("//input[@automation-id='lastName_et']");
    private By streetAddressHeader = By.xpath("//text[@formcontrolname='street']/div/div/label");
    private By streetAddressTextBox = By.xpath("//input[@automation-id='street_et']");
    private By houseNumberHeader = By.xpath("//text[@formcontrolname='houseNumber']/div/div/label");
    private By houseNumberTextBox = By.xpath("//input[@automation-id='houseNumber_et']");
    private By postalCodeHeader = By.xpath("//text[@formcontrolname='postleitzahl']/div/div/label");
    private By postalCodeTextBox = By.xpath("//input[@automation-id='postleitzahl_et']");
    private By cityNameHeader = By.xpath("//text[@formcontrolname='city']/div/div/label");
    private By cityNameTextBox = By.xpath("//input[@automation-id='city_et']");
    private By captchaHeader = By.xpath("//text[@formcontrolname='captchaField']/div/div/label");
    private By captchaTextBox = By.xpath("//input[@automation-id='captcha_et']");
    private By requiredField = By.xpath("//p[@automation-id='requiredText_tv']");
    private By submitButton = By.xpath("//button[@automation-id='submitButton_btn']");

    //CL
    private String returnFormPageHeaderCL = "Rücksendung Deiner Geräte";
    private String stepperHeaderCL = "Füll bitte das Formular aus, um Deine Geräte zurückzuschicken.";
    private String emailAddressHeaderCL = "E-Mail-Adresse *";
    private String firstnameHeaderCL= "Vorname *";
    private String lastnameHeaderCL = "Nachname *";
    private String streetAddressHeaderCL= "Straße *";
    private String houseNumberHeaderCL= "Hausnummer *";
    private String postalCodeHeaderCL= "Postleitzahl *";
    private String cityNameHeaderCL= "Stadt *";
    private String captchaHeaderCL= "Sicherheitscode *";
    private String requiredFieldCL = "Pflichtfeld*";
    private String submitButtonCL = "Speichern und QR-Code/Retourenschein erhalten";

    //Validations
    @Step("Validate CL for return form")
    public ASPReturnForm stepValidation(){
        driver.verifyThat().element(returnFormPageHeader).text().isEqualTo(returnFormPageHeaderCL).perform();
        driver.verifyThat().element(stepperHeader).text().isEqualTo(stepperHeaderCL).perform();
        driver.verifyThat().element(emailAddressHeader).text().isEqualTo(emailAddressHeaderCL).perform();
        driver.verifyThat().element(firstnameHeader).text().isEqualTo(firstnameHeaderCL).perform();
        driver.verifyThat().element(lastnameHeader).text().isEqualTo(lastnameHeaderCL).perform();
        driver.verifyThat().element(streetAddressHeader).text().isEqualTo(streetAddressHeaderCL).perform();
        driver.verifyThat().element(houseNumberHeader).text().isEqualTo(houseNumberHeaderCL).perform();
        driver.verifyThat().element(postalCodeHeader).text().isEqualTo(postalCodeHeaderCL).perform();
        driver.verifyThat().element(cityNameHeader).text().isEqualTo(cityNameHeaderCL).perform();
        driver.verifyThat().element(captchaHeader).text().isEqualTo(captchaHeaderCL).perform();
        driver.verifyThat().element(requiredField).text().isEqualTo(requiredFieldCL).perform();
        driver.verifyThat().element(submitButton).text().isEqualTo(submitButtonCL).perform();
        return this;
    }

    @Step("Validate that user is navigated to return for")
    public ASPReturnForm validateNavigationToReturnForm(){
        driver.verifyThat().element(returnFormPageHeader).isVisible().perform();
        driver.verifyThat().element(stepperHeader).isVisible().perform();
        return this;
    }

    @Step("Validate that submit button is enabled")
    public ASPReturnForm validateSubmitButtonIsEnabled(){
        driver.verifyThat().element(submitButton).isEnabled().perform();
        return this;
    }

    @Step("Validate that submit button is disabled")
    public ASPReturnForm validateSubmitButtonIsDisabled(){
        driver.verifyThat().element(submitButton).isDisabled().perform();
        return this;
    }

    //Actions
    public ASPReturnForm fillReturnForm(String emailAddress , String firstName , String lastName , String streetName , String houseNumber , String postalCode , String cityName , String captcha){
                typeEmailAddress(emailAddress)
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeStreetName(streetName)
                .typeHouseNumber(houseNumber)
                .typePostalCode(postalCode)
                .typeCityName(cityName)
                .typeCaptcha(captcha);
        return this;
    }

    public ASPReturnForm typeEmailAddress(String emailAddress){
        driver.element().type(emailAddressTextBox, emailAddress);
        return this;
    }

    public ASPReturnForm typeFirstName(String firstName){
        driver.element().type(firstnameTextBox, firstName);
        return this;
    }

    public ASPReturnForm typeLastName(String lastName){
        driver.element().type(lastnameTextBox, lastName);
        return this;
    }
    public ASPReturnForm typeStreetName(String streetName){
        driver.element().type(streetAddressTextBox, streetName);
        return this;
    }

    public ASPReturnForm typeHouseNumber(String houseNumber){
        driver.element().type(houseNumberTextBox, houseNumber);
        return this;
    }

    public ASPReturnForm typePostalCode(String postalCode){
        driver.element().type(postalCodeTextBox, postalCode);
        return this;
    }

    public ASPReturnForm typeCityName(String cityName){
        driver.element().type(cityNameTextBox, cityName);
        return this;
    }

    public ASPReturnForm typeCaptcha(String captcha){
        driver.element().type(captchaTextBox, captcha);
        return this;
    }

    public ASPReturnSummary clickSubmitButtonReturnForm(){
        driver.element().click(submitButton);
        return new ASPReturnSummary(driver);
    }
}
