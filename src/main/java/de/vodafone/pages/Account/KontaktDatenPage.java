package de.vodafone.pages.Account;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class KontaktDatenPage {
    private SHAFT.GUI.WebDriver driver;
    private String pageTitle_Cl = "Kunden-Kontaktdaten";
    private By pageTitle_Locator = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    private By telefonTextBox = By.xpath("//input[@automation-id='telefone_et']");
    private By emailTextBox = By.xpath("//input[@automation-id='email_et']");
    public KontaktDatenPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    public void assertThatUserIsNavigatedToKontaktDaten(){
        driver.element().waitUntilElementTextToBe(pageTitle_Locator,pageTitle_Cl);
        driver.verifyThat().element(pageTitle_Locator).textTrimmed().isEqualTo(pageTitle_Cl)
                .withCustomReportMessage("Assert on kontaktDaten page title")
                .perform();
        driver.verifyThat().element(telefonTextBox).exists().withCustomReportMessage("Assert that mobile-number text box exists")
                .perform();
        driver.verifyThat().element(emailTextBox).exists().withCustomReportMessage("Assert that email text box exists")
                .perform();
    }

}
