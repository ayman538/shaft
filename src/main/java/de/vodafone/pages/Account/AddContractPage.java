package de.vodafone.pages.Account;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AddContractPage {
    private SHAFT.GUI.WebDriver driver;

    public AddContractPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    private By addMobileTile = By.xpath("//ol-radio-item[@class='input-container'][1]");
    private By addDSLTile = By.xpath("//ol-radio-item[@class='input-container'][2]");
    private By addKabelTile = By.xpath("//ol-radio-item[@class='input-container'][3]");
    private By addUMTile = By.xpath("//ol-radio-item[@class='input-container'][4]");

    @Step("Check Add contract page and tiles")
    public void checkAddContractPage(){
        driver.verifyThat().element(addMobileTile).exists().perform();
        driver.verifyThat().element(addDSLTile).exists().perform();
        driver.verifyThat().element(addKabelTile).exists().perform();
        driver.verifyThat().element(addUMTile).exists().perform();
    }
    public AddContractPage clickDSLContract() {
        driver.element().click(addDSLTile);
        return this;

    }
}
