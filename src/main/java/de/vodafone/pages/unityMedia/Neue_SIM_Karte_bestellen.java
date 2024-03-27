package de.vodafone.pages.unityMedia;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;


public class Neue_SIM_Karte_bestellen {
    private SHAFT.GUI.WebDriver driver;
    //Constractor
    public Neue_SIM_Karte_bestellen (SHAFT.GUI.WebDriver driver)
    {
        this.driver = driver;
    }


    //Locators
    public static final By SubTitle = By.xpath("//*[@class='sub-title']");
    private static final By First_Tile_Change_Device= By.xpath("(//*[@automation-id='undefined_rb'])[1]");
    private static final By Second_Tile_SIM_Karte_defekt = By.xpath("(//*[@automation-id='undefined_rb'])[2]");
    private static final By Third_Tile_Lost_Device= By.xpath("(//*[@automation-id='undefined_rb'])[3]");
    private static final By Forth_Tile_Device_Stolen= By.xpath("(//*[@automation-id='undefined_rb'])[4]");
    private static final By Fifth_Tile_Additional_SIMKarte= By.xpath("(//*[@automation-id='undefined_rb'])[5]");


    //Methods
    public void clickOnFirstTile() {
        driver.element().click(First_Tile_Change_Device);
    }

    public void clickOnSecondTile() {
        driver.element().click(Second_Tile_SIM_Karte_defekt);
    }
    public void clickOnThirdTile() {
        driver.element().click(Third_Tile_Lost_Device);
    }
    public void clickOForthTile() {
        driver.element().click(Forth_Tile_Device_Stolen);
    }
    public void clickOnNeue_SIM_Karte_bestellen_Tile() {
        driver.element().click(Fifth_Tile_Additional_SIMKarte);
    }
    public void validatePageTitle(){
        Validations.assertThat().element(driver.getDriver(), Neue_SIM_Karte_bestellen.SubTitle).exists();

    }


}
