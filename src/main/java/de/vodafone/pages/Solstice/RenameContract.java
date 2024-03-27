package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class RenameContract {

    private SHAFT.GUI.WebDriver driver;
    private static By renameContract_InputField = By.xpath("//*[@automation-id='renameTextbox_et']");
    private static By changeName_Button = By.xpath("//*[@automation-id='btnContainer_tv']");
    private static By pageDescription = By.xpath("//*[@automation-id='headContainer_tv']");
    private static String pageDescription_text ="Neuer Name für Deinen Vertrag";

    public RenameContract(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public RenameContract enterNewName() {
        driver.element().type(renameContract_InputField,"NewContract");
        return this ;
    }

    public SolsticeMyContractsAndParticipants ChangeName() {
        driver.element().click( changeName_Button);
        return new SolsticeMyContractsAndParticipants(driver);
    }

    public void PageValidation() {
        Validations.assertThat()
                .element(driver.getDriver(), RenameContract.pageDescription)
                .text()
                .isEqualTo(RenameContract.pageDescription_text)
                .withCustomReportMessage("confirmation page description is exist eith same text")
                .perform();
    }

}
