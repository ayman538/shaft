package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class SecondDeliveryConfirmationPage {
    // Variables
    private static SHAFT.GUI.WebDriver driver;
    public static final By Header_CL = By.xpath("//div[@automation-id='pageHeader_tv']//h1");
    public static final By ArtikelErneutZusenden_BTN = By.xpath("//*[@automation-id='secondDelivery_simHW_Submitbtn']");

    // Constructor
    public SecondDeliveryConfirmationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    // Methods
    public void clickOn_ArtikelErneutZusenden (){

        new ElementActions(driver.getDriver()).click(ArtikelErneutZusenden_BTN);
    }
}
