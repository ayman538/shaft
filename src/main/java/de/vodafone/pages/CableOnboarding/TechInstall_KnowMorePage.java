package de.vodafone.pages.CableOnboarding;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class TechInstall_KnowMorePage {
    // Variables
    private final SHAFT.GUI.WebDriver driver;

    //Locators
    public static final By More_info_link = By.xpath("//*[@automation-id='Moreinfo_Link']");
    public static final By Back_link = By.xpath("//*[@automation-id='Back_Link']");


    //constructor
    public TechInstall_KnowMorePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    //keywords
    public TechInstallDashboard Clickonbacklink() {
        driver.element().click(Back_link);
        return new TechInstallDashboard(driver);
    }
    public FAQsPage ClickOnMoreInfolink() {
        driver.element().click(More_info_link);
        return new FAQsPage (driver);
    }
}
