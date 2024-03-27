package de.vodafone.pages.unityMedia;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ContractTermination {
    private SHAFT.GUI.WebDriver driver;
    public ContractTermination(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By noTerminationReason = By.xpath("//*[@automation-id='noReasons_rb']");
    private By continueTermination_CTA = By.xpath("//*[@automation-id='submitTerminationReason_btn']");
    private By terminationReviewCard = By.xpath("//*[@id='review-container'and contains (.,'Ich möchte keine Gründe angeben.')]");

    @Step("click don't want to choose specific reason for termination")
    public void clickNoTerminationReason(){
        driver.element().click( noTerminationReason);
    }
    @Step("click continue termination")
    public void clickContinueTermination(){
        driver.element().click( continueTermination_CTA);
    }
    @Step("validate review page user")
    public void contractCancellationValidation(){
        Validations.verifyThat().element(driver.getDriver(), terminationReviewCard).exists()
                .perform();
    }

}
