package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class ASPConfirmationPage {
    // Variables
    private static SHAFT.GUI.WebDriver driver;
    public static final By confirmation_Header_CL = By.xpath("//div[@automation-id='pageHeader_tv']//h1");
    public static final By tiger_confirmation_subHeadline_CL = By.xpath("//div[@automation-id='undefined_nt']//h4");
    public static final By ZurückzurStartseite_BTN = By.xpath("//*[@id='transaction-link']");

    // Constructor
    public ASPConfirmationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void clickOn_ZurückzurStartseite(){
        new ElementActions(driver.getDriver()).click(ZurückzurStartseite_BTN);
    }

}
