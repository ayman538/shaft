package de.vodafone.pages.KD;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class GeneralErrorPage {
    private SHAFT.GUI.WebDriver driver;

    //Locators
    private By GeneralErrorNotificationCard = By.xpath("//div[@automation-id='undefined_nt']");
    private By GeneralErrorNotificationHeader = By.xpath("//div[@automation-id='successMsg_tv']//h4[@class='flexDiv']");
    private By GeneralErrorNotificationBody = By.xpath("//div[@automation-id='successMsg_tv']//p");
    //Constructor
    public GeneralErrorPage(SHAFT.GUI.WebDriver driver){
        this.driver=driver;
    }
    //Methods
    @Step("Validate General Error Notification Message in Cancellation transaction page ")
    public void validateGeneralErrorNotificationMessage(String GeneralErrorNotificationHeaderCL,String GeneralErrorNotificationBodyCL){
        driver.verifyThat().element(GeneralErrorNotificationCard).exists().perform();
        driver.assertThat().element(GeneralErrorNotificationHeader).textTrimmed().isEqualTo(GeneralErrorNotificationHeaderCL).perform();
        driver.assertThat().element(GeneralErrorNotificationBody).textTrimmed().isEqualTo(GeneralErrorNotificationBodyCL).perform();
    }
}
