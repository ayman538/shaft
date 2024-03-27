package de.vodafone.pages.Equotation;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class ConfirmationPage {

    // Variables
    private final SHAFT.GUI.WebDriver driver;

    //Locators
    public static final By header_Text = By.xpath("//*[@id=\"content\"]/div[2]//h1");
    public static final By headline_Text = By.xpath("(//*[@id=\"content\"]//h3)[1]");
    public static final By title_Text = By.xpath("(//*[@id=\"content\"]//h4)[1]");
    public static final By content_Text = By.xpath("(//*[@id=\"content\"]//p)[1]");
    public static final By custSectionHeader_Text = By.xpath("(//*[@id=\"content\"]//h4)[2]");
    public static final By deviceName_Text = By.xpath("(//*[@id=\"content\"]//h6)[1]");
    public static final By imeiNum_Text = By.xpath("(//*[@id=\"content\"]//h6)[2]");
    public static final By serialNum_Text = By.xpath("(//*[@id=\"content\"]//h6)[3]");
    public static final By showMore_Link = By.xpath("//span[@automation-id=\"undefinedcollapseButtonTxt_tv\"]");


    //constructor
    public ConfirmationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Methods

    public ConfirmationPage clickOnShowMoreLink(){
        (new ElementActions(driver.getDriver())).click(showMore_Link);
        return this;
    }


}
