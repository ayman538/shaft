package de.vodafone.pages.DSL;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class DSL_BookingTransaction {
    private SHAFT.GUI.WebDriver driver;

    public DSL_BookingTransaction(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public static String OptionHeaderReviewPage_Priced_CL = "Vodafone-Flatrate";

    public static String OptionPriceReviewPage_Pried_CL = "€";
    public static String OptionHeaderReviewPage_Free_CL = "Free DSL Extra";

    public static String OptionPriceReviewPage_Free_CL = " Kostenlos ";
    public static By OptionHeaderReviewPage = By.xpath("//*[@class='tariff-card-header']");
    public static By OptionPriceReviewPage = By.xpath("//*[@class='tariffPrice']");
    public static By ConfirmBookingCTA = By.xpath("//button[@automation-id=\"undefined_btn\"]");
    public static By BookWithChargesCTA_Locator = By.xpath("//*[@automation-id='undefined_btn']");


    public DSL_BookingTransaction bookOptionConfirmation() {
        (new ElementActions(driver.getDriver())).click(ConfirmBookingCTA);
        return this;
    }

    public DSL_ConfirmationPage clickCTA(By CTA)
    {
        driver.element().click( CTA);
        return new DSL_ConfirmationPage(driver);
    }

    public DSL_BookingTransaction bookEuroFlatNow(){
        driver.element().click(ConfirmBookingCTA);
        return this;
    }

}
