package de.vodafone.pages.DSL;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class StatusPage {

    private SHAFT.GUI.WebDriver driver;
    public StatusPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public static By StatusPageHeaderLocator = By.xpath("//*[@automation-id='pageHeader_tv']//h1");
    public static By StatusSO_Locator = By.xpath("//*[@automation-id='processingStatus_so']");
    public static By StatusSO_HeaderLocator = By.xpath("//*[@automation-id='processingStatus_so']//h3");
    public static By StatusSO_TextLocator = By.xpath("(//*[@automation-id='processingStatus_so']//div)[5]");
    public static By StatusAccordionLocator = By.xpath("(//*[@automation-id='processingStatus_acc'])");
    public static By StatusAccordionHeaderLocator = By.xpath("(//*[@automation-id='processingStatus_acc'])//h4");
    public static By StatusAccordionTextLocator = By.xpath("((//*[@automation-id='processingStatus_acc'])//h5)[1]");

    public static String StatusPageHeaderCL = "Status";
    public static String StatusSO_HeaderCL = "Bearbeitungsstand";
    public static String StatusSO_TextCL = "Auftrag in Bearbeitung";
    public static String StatusAccordionHeaderCL = "Bearbeitungsstand";
    public static String StatusAccordionTextCL = "Sehen Sie hier, wie weit Ihr Auftrag ist.";

    public DSL_Dashboard closeEmailNotification() {
        return new DSL_Dashboard(driver);

    }

}
