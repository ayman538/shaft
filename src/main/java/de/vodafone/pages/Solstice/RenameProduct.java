package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class RenameProduct {
    private SHAFT.GUI.WebDriver driver;
    private static By renameContract_InputField = By.xpath("//*[@automation-id='renameTextbox_et']");
    private static By changeName_Button = By.xpath("//*[@automation-id='btnContainer_tv']");
    private static By pageDescription_product = By.xpath("//*[@automation-id='headContainer_tv']");
    private static String pageDescription_text_product ="Neuer Name für Deinen Vertrag";

    public RenameProduct(SHAFT.GUI.WebDriver driver) {this.driver = driver;}


    public RenameProduct enterNewName_product() {
        driver.element().type(renameContract_InputField,"Newproduct");
        return this ;
    }


    public SolsticeMyContractsAndParticipants ChangeName_product() {
        driver.element().click( changeName_Button);
        return new SolsticeMyContractsAndParticipants(driver);
    }


    public void PageValidation_product() {
        Validations.assertThat()
                .element(driver.getDriver(), RenameProduct.pageDescription_product)
                .text()
                .isEqualTo(RenameProduct.pageDescription_text_product)
                .withCustomReportMessage("confirmation page description is exist eith same text")
                .perform();
    }
}


