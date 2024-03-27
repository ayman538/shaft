package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ASPFormStep1 {
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public ASPFormStep1(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private By PageHeader = By.xpath("//*[@automation-id='pageHeader_tv']/h1");
    private By PageSubHeader = By.xpath("//*[@automation-id='subHeaderText_tv']");
    private By Stepper1Header = By.xpath("//*[@automation-id='step1_containertv']/a/div[2]");
    private By SalutationHeader = By.xpath("//*[@automation-id='salutationDropDown_tv']/dropdown-stand-alone/form/div/label");
    private By SalutationDropboxText = By.xpath("//*[@automation-id='salutationDropDown_btn']/div");
    private By SalutationDropbox = By.xpath("//*[@automation-id='salutationDropDown_btn']");
    private By SalutationOption1 = By.xpath("(//*[@automation-id='salutationDropDown_lv']/li/button)[1]");
    private By SalutationOption2 = By.xpath("(//*[@automation-id='salutationDropDown_lv']/li/button)[2]");
    private By TitleHeader = By.xpath("//*[@automation-id='titleDropDown_tv']/dropdown-stand-alone/form/div/label");
    private By TitleDropboxText = By.xpath("//*[@automation-id='titleDropDown_btn']/div");
    private By TitleDropbox = By.xpath("//*[@automation-id='titleDropDown_btn']");
    private By TitleOption1 = By.xpath("(//*[@automation-id='titleDropDown_lv']/li/button)[1]");
    private By TitleOption2 = By.xpath("(//*[@automation-id='titleDropDown_lv']/li/button)[2]");
    private By FirstnameHeader = By.xpath("//*[@formcontrolname='firstName']/div/div/label");
    private By FirstnameTextBox = By.xpath("//*[@automation-id='firstName_et']");
    private By LastnameHeader = By.xpath("//*[@formcontrolname='lastName']/div/div/label");
    private By LastnameTextBox = By.xpath("//*[@automation-id='lastName_et']");
    private By RequiredField = By.xpath("//*[@automation-id='required_tv']");
    private By SubmitButton = By.xpath("//*[@automation-id='submiBtn_tv']/button");
    private By FirstnameFieldError = By.xpath("//*[@automation-id='firstName_patternErrorMessage_et']");
    private By LastnameFieldError = By.xpath("//*[@automation-id='lastName_patternErrorMessage_et']");
    private By FirstnameFieldGreen = By.xpath("//*[@formcontrolname='firstName']//*[local-name()='svg']");
    private By LastnameFieldGreen = By.xpath("//*[@formcontrolname='lastName']//*[local-name()='svg']");


    //CL
    private String UMPageHeaderCL = "Vertrag kündigen";
    private String KDPageHeaderCL = "Vertrag widerrufen";
    private String UMPageSubHeaderCL = "Füll bitte das Formular aus, um mit Deiner Kündigung fortzufahren.";
    private String KDPageSubHeaderCL = "Füll bitte das Formular aus, um mit Deinem Widerruf fortzufahren.";
    private String Stepper1HeaderCL = "Persönliche Informationen";
    private String SalutationHeaderCL = "Anrede *";
    private String SalutationDropboxTextCL = "Wähl bitte Deine Anrede.";
    private String SalutationOption1CL = "Frau";
    private String SalutationOption2CL = "Herr";
    private String TitleHeaderCL= "Titel";
    private String TitleDropboxTextCL = "Wähl bitte Deinen Titel.";
    private String TitleOption1CL = "Dr.";
    private String TitleOption2CL = "Prof.";
    private String FirstnameHeaderCL= "Vorname *";
    private String LastnameHeaderCL = "Nachname *";
    private String RequiredFieldCL = "* Pflichtfeld";
    private String SubmitButtonCL = "Weiter";

    //Validations
    @Step("Validate Page header and subheader CL for UM Users")
    public void UMHeaderAndSubHeaderValidation(){
        driver.verifyThat().element(PageHeader).text().isEqualTo(UMPageHeaderCL).perform();
        driver.verifyThat().element(PageSubHeader).text().isEqualTo(UMPageSubHeaderCL).perform();
    }
    @Step("Validate Page header and subheader CL for KD Users")
    public void KDHeaderAndSubHeaderValidation(){
        driver.verifyThat().element(PageHeader).text().isEqualTo(KDPageHeaderCL).perform();
        driver.verifyThat().element(PageSubHeader).text().isEqualTo(KDPageSubHeaderCL).perform();
    }
    @Step("Validate options for salutation dropdown")
    public void salutationDropdownOptionsValidation(){
        driver.verifyThat().element(SalutationOption1).text().isEqualTo(SalutationOption1CL).perform();
        driver.verifyThat().element(SalutationOption2).text().isEqualTo(SalutationOption2CL).perform();
    }
    @Step("Validate options for title dropdown")
    public void titleDropdownOptionsValidation(){
        driver.verifyThat().element(TitleOption1).text().isEqualTo(TitleOption1CL).perform();
        driver.verifyThat().element(TitleOption2).text().isEqualTo(TitleOption2CL).perform();
    }
    @Step("Validate CL for step 1 in ASP Form for UM")
    public ASPFormStep1 step1Validation(){
        driver.verifyThat().element(Stepper1Header).text().isEqualTo(Stepper1HeaderCL).perform();
        driver.verifyThat().element(SalutationHeader).text().isEqualTo(SalutationHeaderCL).perform();
        driver.verifyThat().element(SalutationDropboxText).text().isEqualTo(SalutationDropboxTextCL).perform();
        driver.verifyThat().element(TitleHeader).text().isEqualTo(TitleHeaderCL).perform();
        driver.verifyThat().element(TitleDropboxText).text().isEqualTo(TitleDropboxTextCL).perform();
        driver.verifyThat().element(FirstnameHeader).text().isEqualTo(FirstnameHeaderCL).perform();
        driver.verifyThat().element(LastnameHeader).text().isEqualTo(LastnameHeaderCL).perform();
        driver.verifyThat().element(RequiredField).text().isEqualTo(RequiredFieldCL).perform();
        driver.verifyThat().element(SubmitButton).text().isEqualTo(SubmitButtonCL).perform();
        return this;
    }
    @Step("Validate that user is navigated to form step 1")
    public ASPFormStep1 validateNavigationToForm(){
        driver.verifyThat().element(Stepper1Header).isVisible().perform();
        return this;
    }
    @Step("Validate that submit form step 1 button is enabled")
    public ASPFormStep1 validateSubmitButtonIsEnabled(){
        driver.verifyThat().element(SubmitButton).isEnabled().perform();
        return this;
    }
    @Step("Validate that submit form step 1 button is disabled")
    public ASPFormStep1 validateSubmitButtonIsDisabled(){
        driver.verifyThat().element(SubmitButton).isDisabled().perform();
        return this;
    }
    @Step("Validate that FirstName Error form step 1 is visible")
    public ASPFormStep1 validateFirstnameErrorVisibility(){
        driver.element().keyPress(FirstnameTextBox, Keys.TAB);
        driver.verifyThat().element(FirstnameFieldError).isVisible().perform();
        driver.verifyThat().element(FirstnameFieldError).cssProperty("color").contains("230, 0, 0").perform();
        return this;
    }
    @Step("Validate that LastName Error form step 1 is visible")
    public ASPFormStep1 validateLastnameErrorVisibility(){
        driver.element().keyPress(LastnameTextBox, Keys.TAB);
        driver.verifyThat().element(LastnameFieldError).isVisible().perform();
        driver.verifyThat().element(LastnameFieldError).cssProperty("color").contains("230, 0, 0").perform();
        return this;
    }
    @Step("Validate that FirstName Green form step 1 is visible")
    public ASPFormStep1 validateFirstnameGreenVisibility(){
        driver.element().keyPress(FirstnameTextBox, Keys.TAB);
        driver.verifyThat().element(FirstnameFieldGreen).isVisible().perform();
        return this;
    }
    @Step("Validate that LastName Green form step 1 is visible")
    public ASPFormStep1 validateLastnameGreenVisibility(){
        driver.element().keyPress(LastnameTextBox, Keys.TAB);
        driver.verifyThat().element(LastnameFieldGreen).isVisible().perform();
        return this;
    }

    //Actions
    public ASPFormStep1 fillFormStep1(){
        clickOnSalutationDropBox()
                .clickOnSalutationOption1()
//                .clickOnTitleDropBox()
//                .clickOnTitleOption1()
                .typeFirstName()
                .typeLastName();
        return this;
    }
    public ASPFormStep1 clickOnSalutationOption1(){
        driver.element().click(SalutationOption1);
        return this;
    }
    public ASPFormStep1 clickOnTitleOption1(){
        driver.element().click(TitleOption1);
        return this;
    }
    public ASPFormStep1 clickOnSalutationDropBox(){
        driver.element().click(SalutationDropbox);
        return this;
    }
    public ASPFormStep1 clickOnTitleDropBox(){
        driver.element().click(TitleDropbox);
        return this;
    }
    public ASPFormStep1 typeFirstName(){
        driver.element().type(FirstnameTextBox, "First");
        return this;
    }
    public ASPFormStep1 typeLastName(){
        driver.element().type(LastnameTextBox, "Last");
        return this;
    }
    public ASPFormStep2 clickSubmitButton(){
        driver.element().click(SubmitButton);
        return new ASPFormStep2(driver);
    }
    public ASPFormStep1 typeCustomFirstName(String firstName){
        driver.element().type(FirstnameTextBox, firstName);
        return this;
    }
    public ASPFormStep1 typeCustomLastName(String lastName){
        driver.element().type(LastnameTextBox, lastName);
        return this;
    }
}