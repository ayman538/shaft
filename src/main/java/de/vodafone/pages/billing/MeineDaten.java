package de.vodafone.pages.billing;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MeineDaten {
    private SHAFT.GUI.WebDriver driver;
    private By kontaktdatenAccordionlocator = By.xpath("(//accordion[@id='kontaktdaten']//a)[1]");
    private By adressenAccordionlocator = By.xpath("//li[@automation-id='adressen_acc']");
    private By rechnungseinstellungenLinkLocator = By.xpath("(//li[@automation-id='kontaktdaten_acc']//span//a)[1]");
    private By adressenAccordionExpandLink = By.xpath("(//li[@automation-id='adressen_acc']//a)[1]");
    public MeineDaten(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click on kontaktdaten accordion")
    public void clickOnKontaktDatenAccordion(){
        driver.element().click(kontaktdatenAccordionlocator);
    }
    @Step("Click on rechnungseinstellungen Link")
    public void clickOnrechnungseinstellungenLink(){
        driver.element().click(rechnungseinstellungenLinkLocator);
    }
    //////////assertions/////////
    public void assertThatAdressenAccIsExpanded(){
        driver.verifyThat().element(adressenAccordionExpandLink).attribute("class")
                .isEqualTo("ac-head ac-active")
                .withCustomReportMessage("assert that adressen accordion is expanded")
                .perform();
    }


}
