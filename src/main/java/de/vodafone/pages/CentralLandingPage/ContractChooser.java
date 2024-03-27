package de.vodafone.pages.CentralLandingPage;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ContractChooser {
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public ContractChooser (SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    public static By PageHeader_text = By.xpath("//*[@automation-id='pageHeader_tv']");
    public static By contract_button = By.xpath("  (//a[@class='btn btn-alt subscription__container'])[1]");

    //CL
    public static String PageHeader = "Altersnachweis hochladen";

    //Actions
    public UploadDocument chooseContract() {
        driver.element().click(contract_button);
        return new UploadDocument(driver);
    }
}
