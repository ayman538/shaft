package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class PolarBearDefectReviewPage {

    // Variables
    private static SHAFT.GUI.WebDriver driver;
    public static final By Header_CL = By.xpath("//*[@automation-id='pageHeader_tv']//h1");
    public static final By sendBack_BTN = By.xpath("(//button[@class='btn'])[2]");
    public static final By returnBack_BTN = By.xpath("(//button[@automation-id='ReturnBackToAddAnotherRevocation_btn'])[2]");
    public static final By reportDefect_BTN = By.xpath("(//button[@automation-id='ReturnBackToAddAnotherRevocation_btn'])[1]");


    // Constructor
    public PolarBearDefectReviewPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void clickOn_sendBackDevice(){
        new ElementActions(driver.getDriver()).click(sendBack_BTN);
    }

    public ReportDefectSelectionPage navigateToDefectselectionPage()
    {
        new ElementActions(driver.getDriver()).click(returnBack_BTN);
        return new ReportDefectSelectionPage(driver);
    }

    public RevocationSelectionPage navigateToRevocationSelectionPage()
    {
        new ElementActions(driver.getDriver()).click(reportDefect_BTN);
        return new RevocationSelectionPage(driver);
    }


}
