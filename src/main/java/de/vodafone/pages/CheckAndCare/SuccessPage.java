package de.vodafone.pages.CheckAndCare;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class SuccessPage {

    // Variables
    private SHAFT.GUI.WebDriver driver;

    public static By headline_text = By.xpath("//h1[@automation-id=\"headline_tv\"]");
    public static By firstSubHeadline_text = By.xpath("//p[@automation-id=\"paragrah_1_tv\"]");
    public static By secondSubHeadline_text = By.xpath("//p[@automation-id=\"paragrah_2_tv\"]");
    public static By thirdSubHeadline_text = By.xpath("//p[@automation-id=\"paragrah_3_tv\"]");
    public static By fourthSubHeadline_text = By.xpath("//p[@automation-id='paragrah_4_tv']");
    public static By fourthSubHeadline_Link_text = By.xpath("//*[@automation-id='paragrah_4_tv']//a");




    public static String headlineText = "Super! Danke für Deine Antwort.";

    //constructor
    public SuccessPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    //Keywords
    public void clickOn_BackLink(){
        driver.element().click(fourthSubHeadline_Link_text);

    }

}
