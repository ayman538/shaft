package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class OpenQuestionsPage {
    // Variables
    private static SHAFT.GUI.WebDriver driver;
    public static final By Header_CL = By.xpath("//*[@automation-id='pageHeader_tv']//h1");
    public static final By deineMitteilung_SELECT = By.xpath("//*[@automation-id='chat-link-id_title_tv']");


    // Constructor
    public OpenQuestionsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void clickOn_DeineMitteilung(){

        new ElementActions(driver.getDriver()).click(deineMitteilung_SELECT);
    }
}
