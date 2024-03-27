package de.vodafone.pages.unityMedia;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class TV{
    //Variables
    private SHAFT.GUI.WebDriver driver;
    public TV(SHAFT.GUI.WebDriver driver) {this.driver = driver;}
    //Locators
    private  By TV_ACC = By.xpath("//*[@class='subscription-heading'  and contains (., 'TV-Produkte')]");
    private  By MeinTariffSO = By.xpath("//*[@automation-id='ipTariffSO_so']");
    private  By BookedOptionsAcc = By.xpath("//li[@automation-id='productBookedOptions_acc']");
    private  By BookedOptionPrice = By.xpath("//*[@class='extras-card-price'and contains(.,'€')]");
    private  By NoCertainPriceNotification = By.xpath("//*[@class='flexDiv'and contains(.,'Den genauen Preis für diese  Option findest Du auf der Detailseite.')]");
    private  By NoCertainPriceDetailsLink = By.xpath("//*[text()='Klick hier für weitere Details zu dieser Option.']");
    private  By BookedOptionPrice_Free = By.xpath("//*[@class='extras-card-price'and contains(.,'€')]");

    @Step("expand TV accordion")
    public TV expandTvAccordion() {
        (new ElementActions(driver.getDriver())).click(TV_ACC);
        return this;
    }
    @Step("open Kable Tv TariffPage")
    public void openKableTvTariffPage() {
        (new ElementActions(driver.getDriver())).click(MeinTariffSO);

    }
    @Step("Exopand booked options accordion")
    public void  expandBookedOptionsAcc() {
        (new ElementActions(driver.getDriver())).click(BookedOptionsAcc);

    }
    @Step("Validate presence of price in booked options tiles")
    public void bookedOptionsPriceValidation()
    {
        Validations.assertThat()
                .element(driver.getDriver(), BookedOptionPrice)
                .exists()
                .perform();
    }

    @Step("Validate presence of price (kostenlos) in booked options tiles")
    public void bookedOptionsPriceValidation_Free()
    {
        Validations.assertThat()
                .element(driver.getDriver(), BookedOptionPrice_Free)
                .exists()
                .perform();
    }

}
