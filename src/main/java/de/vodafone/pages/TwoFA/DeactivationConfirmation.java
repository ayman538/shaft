package de.vodafone.pages.TwoFA;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DeactivationConfirmation {

    private static SHAFT.GUI.WebDriver driver;

    public DeactivationConfirmation(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By pageHeader = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    private By bodymsg1 = By.xpath("//h4[@class='flexDiv']");
    private By bodymsg2 = By.xpath("//div[@automation-id='successMsg_tv']/p");
    private By backButtonCTA = By.xpath("//button[@automation-id='notificationConfirmation_btn']");

    private String pageHeader_CL = "2-Faktor-Authentifizierung deaktivieren";
    private String  bodymsg1_CL = "Du hast die 2-Faktor-Authentifizierung deaktiviert";
    private String  bodymsg2_CL = "Wenn Du die 2-Faktor-Authentifizierung deaktivierst, ist Dein Konto weniger sicher. Aktivier sie für mehr Sicherheit wieder.";

    private String  backbutton_CL = "Zurück zu Mein Konto";

    @Step("Verify error message for deeplink")
    public void deactivationValidation(){
        driver.verifyThat().element(pageHeader).text().isEqualTo(pageHeader_CL).perform();
        driver.verifyThat().element(bodymsg1).text().isEqualTo(bodymsg1_CL).perform();
        driver.verifyThat().element(bodymsg2).text().isEqualTo(bodymsg2_CL).perform();
        driver.verifyThat().element(backButtonCTA).text().isEqualTo(backbutton_CL).perform();

    }
    public DeactivationConfirmation clickBackCTA() {
        driver.element().click(backButtonCTA);
        return this;
    }

}
