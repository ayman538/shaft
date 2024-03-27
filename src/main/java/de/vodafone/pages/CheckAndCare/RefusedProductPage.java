package de.vodafone.pages.CheckAndCare;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class RefusedProductPage {

    // Variables
    private final SHAFT.GUI.WebDriver driver;

    //Locators
    public static final By header_Cl = By.xpath("//*[@class='check-and-care-headline mb-20']");
    public static final By subHeadlineText_Cl = By.xpath("//*[@class='page-subHeadline mb-16']");
    public static final By text_Cl = By.xpath("//*[@class='mb-44 page-subHeadline']");
    public static final By ja_Button = By.xpath("(//*[@automation-id='undefined_Link']//span)[1]");
    public static final By nein_Button = By.xpath("(//*[@automation-id='undefined_Link']//span)[2]");



    //constructor
    public RefusedProductPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //keywords
    public ReserveAppointmentPage clickOn_JaButton () {
        driver.element().click(ja_Button);
        return new ReserveAppointmentPage(driver);
    }
    public CancelContractPage clickOn_NeinButton () {
        driver.element().click(nein_Button);
        return new CancelContractPage(driver);
    }
}

