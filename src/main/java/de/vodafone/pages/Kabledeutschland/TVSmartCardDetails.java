package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class TVSmartCardDetails {
    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Locators
    public static final By TV_SmartCard_Container = By.xpath("(//*[@class=\"smart-card-container\"])[1]");
    public static final By TV_SmartCard_IMG = By.xpath("(//*[@class=\"smart-card-container\"]/div/*[@class=\"i-lrg i-grey mb-0 smart-card-icon\"])[1]");
    public static final By TV_SmartCardID_Title = By.xpath("(//*[@class=\"smart-card-container\"]/div/h4[1])[1]");
    public static final By TV_SmartCardID_Content = By.xpath("(//*[@class=\"smart-card-container\"]/div/h4[2])[1]");
    public static final By TV_SmartCardName_Title = By.xpath("(//*[@class=\"mb-20 details\"])[4]/h4[1]");
    public static final By TV_SmartCardName_Content = By.xpath("(//*[@class=\"mb-20 details\"])[4]/h4[2]");

    //CLs
    public static String TV_SmartCardID_Title_CL = "Smartcard-ID:";
    public static String TV_SmartCardName_Title_CL = "Smartcard name:";
    public static String SmartCardNoDetails_CL = "nicht verfügbar";
}
