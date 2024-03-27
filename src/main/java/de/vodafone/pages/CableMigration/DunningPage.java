package de.vodafone.pages.CableMigration;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class DunningPage {
    private final SHAFT.GUI.WebDriver driver;
    public static final By header_Text = By.xpath("//h3[@class='ws10-headline--h3']");


    //constructor
    public DunningPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

}