package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ContractChooser {

    private SHAFT.GUI.WebDriver driver;
    public static By PageHeader_text = By.xpath("//*[@automation-id='pageHeader_tv']");
    protected static final String PageHeader = "Altersnachweis hochladen";
    public static By contract_button = By.xpath("  (//a[@class='btn btn-alt subscription__container'])[1]");


    public ContractChooser (SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    public UploadDocument chooseContract() {
        driver.element().click(contract_button );
        return new UploadDocument(driver);
    }
}
