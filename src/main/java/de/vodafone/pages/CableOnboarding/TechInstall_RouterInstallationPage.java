package de.vodafone.pages.CableOnboarding;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class TechInstall_RouterInstallationPage {


    // Variables
    private final SHAFT.GUI.WebDriver driver;

    //Locators
    public static final By header_Cl = By.xpath("//*[@id='content']//app-header/h1");
    public static final By deviceInfo_Cl = By.xpath("//*[@automation-id='deviceInfo_tv']");
    public static final By deviceHelp_Button = By.xpath("//*[@automation-id='vodafoneStationHelp_btn']//span");
    public static final By videoHelp_Button = By.xpath("//*[@automation-id='videoHelp_btn']//span");


    //constructor
    public TechInstall_RouterInstallationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //keywords
    public TechInstall_RouterInstallationPage clickOnDeviceHelpButton() {
        (new ElementActions(driver.getDriver())).click(deviceHelp_Button);
        return new TechInstall_RouterInstallationPage(driver);
    }
    public TechInstall_RouterInstallationPage clickOnVideoHelpButton() {
        (new ElementActions(driver.getDriver())).click(videoHelp_Button);
        return new TechInstall_RouterInstallationPage(driver);
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
