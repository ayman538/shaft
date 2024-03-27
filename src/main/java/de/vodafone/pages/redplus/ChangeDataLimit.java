package de.vodafone.pages.redplus;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class ChangeDataLimit {

    //Variables
    private SHAFT.GUI.WebDriver driver;

    //CL
    private String page_Header_CL = "Red+ Datenvolumen ändern";
    private String pageOwnerNumber_Headline_CL = "Teilnehmer (01520 151 03 11)";
    private String dataLimitMax_Title_CL = "10,00 GB von 10,00 GB";


    //Element Locators
    private By page_Header = By.xpath("//*[@automation-id=\"pageHeader_tv\"]/h1[contains(.,'Red+ Datenvolumen ändern')]");
    private By pageOwnerNumber_Headline = By.xpath("//*[@automation-id=\"pageHeader_tv\"]//h2");
    private By dataLimit_Title = By.xpath("//*[@automation-id='RedPlusLimit_tv']//span");
    private By submit_Button = By.xpath("//*[@automation-id=\"RedPlusLimit_btn\"]");

    //Constructors
    public ChangeDataLimit(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    //Methods
    @Step("Change Limit Page Validations")
    public void validateChangeLimitPage(){
        Validations.verifyThat().element(driver.getDriver(),page_Header).text().isEqualTo(page_Header_CL).perform();
        Validations.verifyThat().element(driver.getDriver(),pageOwnerNumber_Headline).text().isEqualTo(pageOwnerNumber_Headline_CL).perform();
        Validations.verifyThat().element(driver.getDriver(),dataLimit_Title).text().isEqualTo(dataLimitMax_Title_CL).perform();
        Validations.verifyThat().element(driver.getDriver(),submit_Button).isDisabled().perform();
    }

}
