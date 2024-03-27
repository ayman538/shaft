package de.vodafone.pages.Equotation;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class EquotationDashboard {

    // Variables
    private final SHAFT.GUI.WebDriver driver;
    public static final By dashboard_Header_CL = By.xpath("//*[@class='title-ecare overview']//h1");
    public static final By orderDetailsSectionheader_CL = By.xpath("(//*[@id=\"content\"]/div[2]//h3)[1]");
    public static final By deviceDetailsSectionheader_CL = By.xpath("//*[@class='panel-header']//h4");
    public static final By deviceName_CL = By.xpath("//*[@class='panel-header']//h6");
    public static final By showMore_BTN = By.xpath("//*[@automation-id='undefinedcollapseButtonTxt_tv']");
    public static final By articleNumber_CL = By.xpath("(//*[@class='panel-body']//h6)[1]");
    public static final By serialNumber_CL = By.xpath("(//*[@class='panel-body']//h6)[2]");
    public static final By firstOption_CL = By.xpath("//*[@id='radio-option0']//p");
    public static final By secondOption_CL = By.xpath("//*[@id='radio-option1']//p");
    public static final By thirdOption_CL = By.xpath("//*[@id='radio-option2']//p");
    public static final By acceptTerms_CL = By.xpath("//*[@class='label-content']");
    public static final By acceptTerms_BTN = By.xpath("//input[@automation-id='checkboxItemModel.id_tv']");

    public static final By submit_BTN = By.xpath("//*[@class='white-box standard-form']//button");
    public static final By notRepairable_FirstOption_CL = By.xpath("//*[@id='radio-option0']//p");
    public static final By notRepairable_SecondOption_CL = By.xpath("//*[@id='radio-option1']//p");
    //constructor
    public EquotationDashboard(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public void clickOn_ShowMore (){

        new ElementActions(driver.getDriver()).click(showMore_BTN);
    }
    public void clickOn_FirstOption (){

        new ElementActions(driver.getDriver()).click(firstOption_CL);
    }
    public void clickOn_NotRepairableFirstOption (){

        new ElementActions(driver.getDriver()).click(notRepairable_FirstOption_CL);
    }
    public void clickOn_AcceptTerms (){

        //new ElementActions(driver.getDriver()).click(acceptTerms_BTN);
        JavascriptExecutor executor = (JavascriptExecutor)driver.getDriver();
        executor.executeScript("arguments[0].click();", driver.getDriver().findElement(acceptTerms_BTN));
    }
    public void clickOn_Submit (){

        new ElementActions(driver.getDriver()).click(submit_BTN);
    }

}
