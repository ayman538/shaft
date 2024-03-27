package de.vodafone.pages.CheckAndCare;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class CancelContractPage {
    // Variables
    private final SHAFT.GUI.WebDriver driver;

    //Locators
    public static final By Cancel_header_Cl = By.xpath("//cancel-contract//*[@class='check-and-care-headline mb-20']");
    public static final By subHeadlineText_Cl = By.xpath("//p[@class='mb-24 page-subHeadline']");
    public static final By retourenportal_Button = By.xpath("//*[@class='brix-ws10-button__text']");
    public static final By subHeadlineText2_Cl = By.xpath("//*[@class='mb-40 page-subHeadline']//b");

    public static final By calendarNavigation_Link = By.xpath("//*[@class='mb-40 page-subHeadline']//u");

    //constructor
    public CancelContractPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //keywords
    public void clickOn_RetourenportalButton () {
        driver.element().click(retourenportal_Button);
    }
    public int getNumberOfOpennedTabs(){
        ArrayList<String> tabHandles = new ArrayList<String>(driver.getDriver().getWindowHandles());
        return tabHandles.size();
    }
    public void clickOn_CalendarNavigation() {
        driver.element().click(calendarNavigation_Link);
    }

}
