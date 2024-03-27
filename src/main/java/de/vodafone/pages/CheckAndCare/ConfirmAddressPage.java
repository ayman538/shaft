package de.vodafone.pages.CheckAndCare;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class ConfirmAddressPage {
    // Variables
    private final SHAFT.GUI.WebDriver driver;

    //Locators
    public static By headline_text = By.xpath("//address-new-trail//*[@automation-id='headline_tv']");
    public static By firstSubHeadline_text = By.xpath("//address-new-trail//*[@automation-id='sub_headline_tv']");
    public static By secondSubHeadline_text = By.xpath("//address-new-trail//*[@automation-id='text_body_tv']");
    public static By addressNotes_textarea = By.name("static-textarea-regular");
    public static By terminAuswählen_btn = By.xpath("//address-new-trail//*[@automation-id='navigate_btn_Link']");
    //constructor
    public ConfirmAddressPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //keywords

    public void enterAddressNotesText(String text) {
        driver.element().type(addressNotes_textarea,text);
    };

    public CalendarPage clickOnTerminAuswählenButton() {
        driver.element().click(terminAuswählen_btn);
        return new CalendarPage(driver);
    };
}
