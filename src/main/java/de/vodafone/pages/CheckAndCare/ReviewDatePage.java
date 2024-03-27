package de.vodafone.pages.CheckAndCare;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class ReviewDatePage {
    // Variables
    private final SHAFT.GUI.WebDriver driver;

    //Locators

    public static final By header_Cl = By.xpath("//div[@automation-id='appintmentPage-text-headline_et']");
    public static final By header2_Cl = By.xpath("//div[@class='check-and-care-headline mb-20']");
    public static final By subHeader_Cl = By.xpath("//*[@automation-id='appintmentPage-subheadline_et']");
    public static final By subHeader2_Cl = By.xpath("//*[@automation-id='appintmentPage-subheadlinetext_et']");
    public static final By ja_CheckBox = By.xpath("//*[@for='radioOne']//span");
    public static final By nein_CheckBox = By.xpath("//*[@for='radioTwo']//span");
    public static final By jaCheckBoxAlert_CL = By.xpath("//app-customerstatus//span[2]/span");
    public static final By date_Cl = By.xpath("//*[@class='mr-30 va-middle displayinlineblock']");
    public static final By klingelschildDrucken_Button = By.xpath("//*[@automation-id='print_btn_Link']//span");
    public static final By confirmDate_Button = By.xpath("(//*[@automation-id='undefined_Link']//span)[2]");

    public static final By confirmDate_Button2 = By.xpath("//*[@automation-id='submitAppointment_btn_Link']//span");
    public static final By confirmDate_Button3 = By.xpath("//*[@automation-id='send_btn_Link']//span");



    //constructor
    public ReviewDatePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //keywords
    public void clickOn_jaCheckBox(){
        driver.element().click(ja_CheckBox);

    }
    public void clickOn_KlingelschildDrucken(){
        driver.element().click(klingelschildDrucken_Button);
    }
    public ConfirmedDatePage clickOn_ConfirmDate(){
        driver.element().click(confirmDate_Button);
        return new ConfirmedDatePage(driver);
    }
    public ConfirmedDatePage clickOn_ConfirmDate2(){
        driver.element().click(confirmDate_Button2);
        return new ConfirmedDatePage(driver);
    }
    public ConfirmedDatePage clickOn_ConfirmDate3(){
        driver.element().click(confirmDate_Button3);
        return new ConfirmedDatePage(driver);
    }
    public int getNumberOfOpennedTabs(){
        ArrayList<String> tabHandles = new ArrayList<String>(driver.getDriver().getWindowHandles());
        return tabHandles.size();
    }
    public void SwithToParentWindow(){
        ArrayList<String> tabHandles = new ArrayList<String>(driver.getDriver().getWindowHandles());
        driver.getDriver().switchTo().window(tabHandles.get(1));
        driver.getDriver().close();
        driver.getDriver().switchTo().window(tabHandles.get(0));

    }

}
