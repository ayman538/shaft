package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class SingleHWReportDefectPage {
    // Variables
    private static SHAFT.GUI.WebDriver driver;
    public static final By Header_CL = By.xpath("//*[@automation-id='pageHeader_tv']//h1");
    public static final By HW_SELECT = By.xpath("//input[@id='hardware']");
    public static final By SIM_SELECT = By.xpath("//input[@id='sim']");



    // Constructor
    public SingleHWReportDefectPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void clickOn_HW (){
        JavascriptExecutor executor = (JavascriptExecutor)driver.getDriver();
        executor.executeScript("arguments[0].click();", driver.getDriver().findElement(HW_SELECT));
    }
    public void clickOn_SIM (){

        JavascriptExecutor executor = (JavascriptExecutor)driver.getDriver();
        executor.executeScript("arguments[0].click();", driver.getDriver().findElement(SIM_SELECT));
    }
}
