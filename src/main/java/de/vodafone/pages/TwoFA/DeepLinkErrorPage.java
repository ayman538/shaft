package de.vodafone.pages.TwoFA;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DeepLinkErrorPage {
    private static SHAFT.GUI.WebDriver driver;

    public   DeepLinkErrorPage (SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By pageHeader = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    private By errormsg1 = By.xpath("//h4[@class='flexDiv']");
    private By errormsg2 = By.xpath("//div[@automation-id='successMsg_tv']/p");

    private String pageHeader_CL = "2-Faktor-Authentifizierung aktivieren";
    private String  errormsg1_CL = "Das hat leider nicht geklappt";
    private String  errormsg2_CL = "Du hast die 2-Faktor-Authentifizierung schon aktiviert.";

    @Step("Verify error message for deeplink")
    public void deeplinkValidation(){
        driver.verifyThat().element(pageHeader).text().isEqualTo(pageHeader_CL).perform();
        driver.verifyThat().element(errormsg1).text().isEqualTo(errormsg1_CL).perform();
        driver.verifyThat().element( errormsg2).text().isEqualTo(errormsg2_CL).perform();
    }
}
