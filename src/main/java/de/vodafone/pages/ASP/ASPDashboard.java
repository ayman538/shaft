package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class ASPDashboard {
    // Variables
    private static SHAFT.GUI.WebDriver driver;
    public static final By dashboard_Header_CL = By.xpath("//*[@automation-id='pageHeader_tv']//h1");
    public static final By trackingHeader_CL = By.xpath("//*[@automation-id='trackingHeader_tv']");
    public static final By trackingSubHeadline_CL = By.xpath("//*[@automation-id='trackingsubHeadline_tv']");
    public static final By PandAtrackingHeader_CL = By.xpath("//*[@class='activated-text']");
    public static final By PandAtrackingSubHeadline_CL = By.xpath("//*[@class='track-delivery-container']//p");
    public static final By CobraWarningText_CL = By.xpath("//*[@class='track-delivery-container']//h4");
    public static final By revoke_BTN = By.xpath("(//a[@class='btn btn-em'])[1]");
    public static final By reportDefect_BTN = By.xpath("(//a[@class='btn btn-em'])[2]");
    public static final By ElephantReportDefect_BTN= By.xpath("//*[@class='btn btn-em itemCard-btns']");
    public static final By BabyElephantReportDefect_BTN= By.xpath("(//a[@class='btn btn-em itemCard-btns'])");

    public static final By ArtikelErneutZusenden_BTN = By.xpath("(//a[@class='btn btn-em'])[1]");
    public static final By SecondDelivery_ZumWiderruf_BTN = By.xpath("(//a[@class='btn btn-em'])[1]");

    public static final By polarbear_tiger_NeoTiger_revoke_BTN = By.xpath("(//button[@class='btn btn-em'])[2]");
    public static final By polarbear_tiger_NeoTiger_reportDefect_BTN = By.xpath("(//button[@class='btn btn-em'])[3]");
    public ASPDashboard(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void clickOn_Revocation (){

        new ElementActions(driver.getDriver()).click(revoke_BTN);
    }
    public void clickOn_ReportDefect (){

        new ElementActions(driver.getDriver()).click(reportDefect_BTN);
    }

    public void clickOn_ElephantReportDefect (){

        new ElementActions(driver.getDriver()).click(ElephantReportDefect_BTN);
    }

    public void clickOn_BabyElephantReportDefect (){

        new ElementActions(driver.getDriver()).click(BabyElephantReportDefect_BTN);
    }

    public void clickOn_ArtikleErneutZusenden (){

        new ElementActions(driver.getDriver()).click(ArtikelErneutZusenden_BTN);
    }
    public void clickOn_ZumWiderruf (){

        new ElementActions(driver.getDriver()).click(SecondDelivery_ZumWiderruf_BTN);
    }
    public void clickOn_PolarBear_tiger_NeoTigerRevocation (){

        new ElementActions(driver.getDriver()).click(polarbear_tiger_NeoTiger_revoke_BTN);
    }
    public void clickOn_PolarBear_tiger_NeoTigerReportDefect (){

        new ElementActions(driver.getDriver()).click(polarbear_tiger_NeoTiger_reportDefect_BTN);
    }

}
