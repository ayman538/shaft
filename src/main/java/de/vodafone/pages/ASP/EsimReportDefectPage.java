package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class EsimReportDefectPage {
    // Variables
    private static SHAFT.GUI.WebDriver driver;
    public static final By Header_CL = By.xpath("//*[@automation-id='pageHeader_tv']//h1");


    // Constructor
    public EsimReportDefectPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Methods
}