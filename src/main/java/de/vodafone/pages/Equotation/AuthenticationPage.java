package de.vodafone.pages.Equotation;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class AuthenticationPage {

    // Variables
    private final SHAFT.GUI.WebDriver driver;

    //Locators
    public static final By header_Text = By.xpath("//*[@id=\"content\"]/div[2]//h1");
    public static final By title_Text = By.xpath("//span[@automation-id=\"oneStepStepperHeader_tv\"]");
    public static final By content_Text = By.xpath("//*[@id=\"postCodeFormId\"]/p");
    public static final By postalcode_Textbox = By.xpath("//input[@automation-id=\"postCode_et\"]");
    public static final By postalcode_Text = By.xpath("//*[@id=\"postCodeFormId\"]/form//label");
    public static final By submit_Button = By.xpath("//*[@id=\"postCodeFormId\"]/button");
    public static final By required_Text = By.xpath("//*[@id=\"postCodeFormId\"]/label");
    public static final By errorMessage_Text = By.xpath("//p[@automation-id=\"postCode_patternErrorMessage_et\"]");

    public static final By invalidFormat_ErrorMessage_Text = By.xpath("//*[@automation-id='postCodeadditionalErrorMessage_et']");

    public static By acceptCookies_button=By.xpath("//button//span[contains(text(),'ablehnen')]");


    //constructor
    public AuthenticationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //keywords


    public AuthenticationPage clickOnPostalCodeTextBox() {
        (new ElementActions(driver.getDriver())).click(postalcode_Textbox);
        return this;
    }

    public void enterpostalcode(String text) {

        (new ElementActions(driver.getDriver())).type(postalcode_Textbox,text);
    }

    public void deletepostalcode() {

        (new ElementActions(driver.getDriver())).keyPress(postalcode_Textbox,Keys.DELETE);


    }

    public void navigateToEquotationPortalPage() {
        (new ElementActions(driver.getDriver())).click(submit_Button);
    }


    public AuthenticationPage acceptCookies() {
        driver.element().click( acceptCookies_button);
        return this;
    }

}
