package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class RevocationReviewPage {
    // Variables
    private static SHAFT.GUI.WebDriver driver;
    public static final By revocationReview_Header_CL = By.xpath("//div[@automation-id='pageHeader_tv']//h1");
    public static final By sendBack_BTN = By.xpath("(//button[@class='btn'])[2]");
    public static final By returnBack_BTN = By.xpath("(//button[@automation-id='ReturnBackToAddAnotherRevocation_btn'])[2]");
    public static final By reportDefect_BTN = By.xpath("(//button[@automation-id='ReturnBackToAddAnotherRevocation_btn'])[1]");



    // Constructor
    public RevocationReviewPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void clickOn_sendBackDevice()
    {
        new ElementActions(driver.getDriver()).click(sendBack_BTN);
    }

    public RevocationSelectionPage navigateToRevocationselectionPage()
    {
        new ElementActions(driver.getDriver()).click(returnBack_BTN);
        return new RevocationSelectionPage(driver);
    }

    public ASPReportDefect navigateToReportDefectPage()
    {
        new ElementActions(driver.getDriver()).click(reportDefect_BTN);
        return new ASPReportDefect(driver);
    }

}
