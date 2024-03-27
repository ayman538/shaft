package de.vodafone.pages.eShop;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class FindMyOfferPage {
    private SHAFT.GUI.WebDriver driver;

    public static By neuerVertragMitSmartphoneButton = By.xpath("//div[@class='link-t'][contains(.,'Vertrag mit Smartphone')]");
    public static By neuerVertragOhneSmartphoneButton = By.xpath("//div[@class='link-t'][contains(.,'Vertrag ohne Smartphone')]");
    public static By age28YearsOrOlder = By.xpath("//div[@class='link-t'][contains(.,'28 Jahre oder älter')]");
    public static By ageUnder28Years = By.xpath("//div[@class='link-t'][contains(.,'unter 28 Jahre')]");

    public FindMyOfferPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Clicking on Neuer Vertrag Mit Smart Phone Button then choose the option 28 years or older")
    public FindMyOfferPage navigateToDeviceFirstFlowPageWay2() {
        driver.element().click(neuerVertragMitSmartphoneButton)
                        .click(age28YearsOrOlder);
        return this;
    }
    @Step("Clicking on Neuer Vertrag ohne Smart Phone Button then choose the option 28 years or older")
    public FindMyOfferPage navigateToTariffFirstFlowPageWay2() {
        driver.element().click(neuerVertragOhneSmartphoneButton)
                        .click(age28YearsOrOlder);
        return this;
    }
    @Step("Clicking on Neuer Vertrag ohne Smart Phone Button then choose the option 28 years or older In case of Tariff")
    public FindMyOfferPage navigateToTariffFirstFlowPageWay3() {
        driver.element().click(neuerVertragOhneSmartphoneButton)
                .click(age28YearsOrOlder);
        return this;
    }
    @Step("Choose the option 28 years or older")
    public FindMyOfferPage clickOn28YearsOrOlderButton(){
        driver.element().click(age28YearsOrOlder);
          return this;
    }

}
