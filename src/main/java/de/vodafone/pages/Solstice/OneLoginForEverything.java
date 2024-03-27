package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class OneLoginForEverything {

    private SHAFT.GUI.WebDriver driver;
    public String MergeConfirmationURL = "https://simplicity.wf-de.vodafone.com/meinvodafone/account/zusammenlegung/bestaetigt";
    public static By Meine_Daten_bearbeiten = By.xpath("//*[@class='btn btn-alt btn-sml']");
    public OneLoginForEverything navigateMergeConfirmation(){
        driver.browser().navigateToURL( MergeConfirmationURL);
        return this;
    }

    public OneLoginForEverything editMyDataBtn(){
        new ElementActions(driver.getDriver()).click(Meine_Daten_bearbeiten);
        return this;
    }



    public OneLoginForEverything(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


}
