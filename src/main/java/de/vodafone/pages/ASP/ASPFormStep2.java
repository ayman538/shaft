package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ASPFormStep2 {
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public ASPFormStep2(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By Stepper2Header = By.xpath("//*[@automation-id='step2_containertv']/a/div[2]");
    private By StreetAddressHeader = By.xpath("//*[@formcontrolname='addressStreet']/div/div/label");
    private By StreetAddressTextBox = By.xpath("//*[@automation-id='addressStreet_et']");
    private By HouseNumberHeader = By.xpath("//*[@formcontrolname='houseNumber']/div/div/label");
    private By HouseNumberTextBox = By.xpath("//*[@automation-id='houseNumber_et']");
    private By PostalCodeHeader = By.xpath("//*[@formcontrolname='postalCode']/div/div/label");
    private By PostalCodeTextBox = By.xpath("//*[@automation-id='postalCode_et']");
    private By StateHeader = By.xpath("//*[@automation-id='stateDropdown_tv']/dropdown-stand-alone/form/div/label");
    private By StateDropboxText = By.xpath("//*[@automation-id='stateDropdown_btn']/div");
    private By StateDropbox = By.xpath("//*[@automation-id='stateDropdown_btn']");
    private By StateOption1 = By.xpath("//*[@id='option_child'][1]");
    private By StateOption2 = By.xpath("//*[@id='option_child'][2]");
    private By StateOption3 = By.xpath("//*[@id='option_child'][3]");
    private By CityNameHeader = By.xpath("//*[@formcontrolname='city']/div/div/label");
    private By CityNameTextBox = By.xpath("//*[@automation-id='city_et']");
    private By RequiredField = By.xpath("//*[@automation-id='required_tv']");
    private By SubmitButton = By.xpath("//*[@automation-id='submitBtn_tv']/button");
    private By StreetNameFieldError = By.xpath("//*[@automation-id='addressStreet_patternErrorMessage_et']");
    private By HouseNumberFieldError = By.xpath("//*[@automation-id='houseNumber_patternErrorMessage_et']");
    private By CityNameFieldError = By.xpath("//*[@automation-id='city_patternErrorMessage_et']");
    private By StreetNameFieldGreen = By.xpath("//*[@formcontrolname='addressStreet']//*[local-name()='svg']");
    private By HouseNumberFieldGreen = By.xpath("//*[@formcontrolname='houseNumber']//*[local-name()='svg']");
    private By CityNameFieldGreen = By.xpath("//*[@formcontrolname='city']//*[local-name()='svg']");
    //CL
    private String Stepper2HeaderCL = "Adresse";
    private String StreetAddressHeaderCL= "Straße *";
    private String HouseNumberHeaderCL= "Hausnummer *";
    private String PostCodeHeaderCL= "Postleitzahl *";
    private String StateHeaderCL= "Bundesland *";
    private String StateDropboxTextCL = "Wähl bitte Dein Bundesland.";
    private String StateOption1CL = "NRW";
    private String StateOption2CL = "Baden-Württemberg";
    private String StateOption3CL = "Hessen";
    private String CityNameHeaderCL= "Stadt *";
    private String RequiredFieldCL = "* Pflichtfeld";
    private String SubmitButtonCL = "Weiter";

    //Validations
    @Step("Validate options for State dropdown")
    public void stateDropdownOptionsValidation() {
        driver.verifyThat().element(StateOption1).text().isEqualTo(StateOption1CL).perform();
        driver.verifyThat().element(StateOption2).text().isEqualTo(StateOption2CL).perform();
        driver.verifyThat().element(StateOption3).text().isEqualTo(StateOption3CL).perform();
    }
    @Step("Validate CL for step 2 in ASP Form for UM")
    public ASPFormStep2 step2UMValidation(){
        driver.verifyThat().element(Stepper2Header).text().isEqualTo(Stepper2HeaderCL).perform();
        driver.verifyThat().element(StreetAddressHeader).text().isEqualTo(StreetAddressHeaderCL).perform();
        driver.verifyThat().element(HouseNumberHeader).text().isEqualTo(HouseNumberHeaderCL).perform();
        driver.verifyThat().element(PostalCodeHeader).text().isEqualTo(PostCodeHeaderCL).perform();
        driver.verifyThat().element(StateHeader).text().isEqualTo(StateHeaderCL).perform();
        driver.verifyThat().element(StateDropboxText).text().isEqualTo(StateDropboxTextCL).perform();
        driver.verifyThat().element(CityNameHeader).text().isEqualTo(CityNameHeaderCL).perform();
        driver.verifyThat().element(RequiredField).text().isEqualTo(RequiredFieldCL).perform();
        driver.verifyThat().element(SubmitButton).text().isEqualTo(SubmitButtonCL).perform();
        return this;
    }
    @Step("Validate CL for step 2 in ASP Form for KD")
    public ASPFormStep2 step2KDValidation(){
        driver.verifyThat().element(Stepper2Header).text().isEqualTo(Stepper2HeaderCL).perform();
        driver.verifyThat().element(StreetAddressHeader).text().isEqualTo(StreetAddressHeaderCL).perform();
        driver.verifyThat().element(HouseNumberHeader).text().isEqualTo(HouseNumberHeaderCL).perform();
        driver.verifyThat().element(PostalCodeHeader).text().isEqualTo(PostCodeHeaderCL).perform();
        driver.verifyThat().element(CityNameHeader).text().isEqualTo(CityNameHeaderCL).perform();
        driver.verifyThat().element(RequiredField).text().isEqualTo(RequiredFieldCL).perform();
        driver.verifyThat().element(SubmitButton).text().isEqualTo(SubmitButtonCL).perform();
        return this;
    }
    @Step("Validate that user is navigated to form step 2")
    public ASPFormStep2 validateNavigationToFormStep2(){
        driver.verifyThat().element(Stepper2Header).isVisible().perform();
        return this;
    }
    @Step("Validate that submit form step 2 button is enabled")
    public ASPFormStep2 validateSubmitButtonIsEnabled(){
        driver.verifyThat().element(SubmitButton).isEnabled().perform();
        return this;
    }
    @Step("Validate that submit form step 2 button is disabled")
    public ASPFormStep2 validateSubmitButtonIsDisabled(){
        driver.verifyThat().element(SubmitButton).isDisabled().perform();
        return this;
    }
    @Step("Validate that Street Name Error form step 2 is visible")
    public ASPFormStep2 validateStreetNameErrorVisibility(){
        driver.element().keyPress(StreetAddressTextBox, Keys.TAB);
        driver.verifyThat().element(StreetNameFieldError).isVisible().perform();
        driver.verifyThat().element(StreetNameFieldError).cssProperty("color").contains("230, 0, 0").perform();
        return this;
    }
    @Step("Validate that House Number Error form step 2 is visible")
    public ASPFormStep2 validateHouseNumberErrorVisibility(){
        driver.element().keyPress(HouseNumberTextBox, Keys.TAB);
        driver.verifyThat().element(HouseNumberFieldError).isVisible().perform();
        driver.verifyThat().element(HouseNumberFieldError).cssProperty("color").contains("230, 0, 0").perform();
        return this;
    }
    @Step("Validate that City Name Error form step 2 is visible")
    public ASPFormStep2 validateCityNameErrorVisibility(){
        driver.element().keyPress(CityNameTextBox, Keys.TAB);
        driver.verifyThat().element(CityNameFieldError).isVisible().perform();
        driver.verifyThat().element(CityNameFieldError).cssProperty("color").contains("230, 0, 0").perform();
        return this;
    }
    @Step("Validate that Street Name Green form step 2 is visible")
    public ASPFormStep2 validateStreetNameGreenVisibility(){
        driver.element().keyPress(StreetAddressTextBox, Keys.TAB);
        driver.verifyThat().element(StreetNameFieldGreen).isVisible().perform();
        return this;
    }
    @Step("Validate that House Number Green form step 2 is visible")
    public ASPFormStep2 validateHouseNumberGreenVisibility(){
        driver.element().keyPress(HouseNumberTextBox, Keys.TAB);
        driver.verifyThat().element(HouseNumberFieldGreen).isVisible().perform();
        return this;
    }
    @Step("Validate that City Name Green form step 2 is visible")
    public ASPFormStep2 validateCityNameGreenVisibility(){
        driver.element().keyPress(CityNameTextBox, Keys.TAB);
        driver.verifyThat().element(CityNameFieldGreen).isVisible().perform();
        return this;
    }
    //actions
    public ASPFormStep2 fillFormStep2UM(){
        typeStreetAddress()
                .typeHouseNumber()
                .typePostCode()
                .clickOnStateDropBox()
                .clickOnStateOption1()
                .typeCityName();
        return this;
    }
    public ASPFormStep2 fillFormStep2KD(){
        typeStreetAddress()
                .typeHouseNumber()
                .typePostCode()
                .typeCityName();
        return this;
    }
    public ASPFormStep2 typeStreetAddress(){
        driver.element().type(StreetAddressTextBox, "Street");
        return this;
    }
    public ASPFormStep2 typeHouseNumber(){
        driver.element().type(HouseNumberTextBox, "1234");
        return this;
    }
    public ASPFormStep2 typePostCode(){
        driver.element().type(PostalCodeTextBox, "12345");
        return this;
    }
    public ASPFormStep2 clickOnStateDropBox(){
        driver.element().click(StateDropbox);
        return this;
    }
    public ASPFormStep2 clickOnStateOption1(){
        driver.element().click(StateOption1);
        return this;
    }
    public ASPFormStep2 typeCityName(){
        driver.element().type(CityNameTextBox, "Cairo");
        return this;
    }
    public ASPFormStep3 clickSubmitButtonStep2(){
        driver.element().click(SubmitButton);
        return new ASPFormStep3(driver);
    }
    public void streetAddressHeaderValidation() {
        driver.verifyThat().element(StreetAddressHeader).text().isEqualTo(StreetAddressHeaderCL).perform();
    }
    public ASPFormStep2 typeCustomStreetName(String streetName){
        driver.element().type(StreetAddressTextBox, streetName);
        return this;
    }
    public ASPFormStep2 typeCustomHouseNumber(String houseNumber){
        driver.element().type(HouseNumberTextBox, houseNumber);
        return this;
    }
    public ASPFormStep2 typeCustomCityName(String cityName){
        driver.element().type(CityNameTextBox, cityName);
        return this;
    }
}