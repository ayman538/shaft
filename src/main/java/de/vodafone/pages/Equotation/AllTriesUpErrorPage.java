package de.vodafone.pages.Equotation;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AllTriesUpErrorPage {


    // Variables
    private final SHAFT.GUI.WebDriver driver;
    // Locators
    public static final By header_Text = By.xpath("//*[@class='title-ecare overview']//h1");
    public static final By ErrorTitle_Text = By.xpath("//*[@class='flex-disply']//h4");
    public static final By ErrorContent_Text = By.xpath("(//*[@class='alert-content']//p)[1]");

    //constructor
    public AllTriesUpErrorPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Methods

}
