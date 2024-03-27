package de.vodafone.pages.KD;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;

public class ExclusiveOfferPage {
    private SHAFT.GUI.WebDriver driver;

    public ExclusiveOfferPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //URL
    private String ExclusiveOfferURLTV = "https://simplicity.wf-de.vodafone.com/meinvodafone/services/mboxcampaign/offer-page?icmp=meinvodafone:dashboard:header-offer";
    private String ExclusiveOfferURLKIP = "https://simplicity.wf-de.vodafone.com/meinvodafone/services/mboxcampaign/offer-page?icmp=meinvodafone:dashboard:header-offer";

    //Method
    @Step("Validate when click on exclusive offer smart object will directed to exclusive offer URL TV")
    public void validateExclusiveOfferURLTV() {
        Validations.assertThat().browser(driver.getDriver()).url().isEqualTo(ExclusiveOfferURLTV).perform();
    }
    @Step("Validate when click on exclusive offer smart object will directed to exclusive offer URL KIP")
    public void validateExclusiveOfferURLKip(){
        Validations.assertThat().browser(driver.getDriver()).url().isEqualTo(ExclusiveOfferURLKIP).perform();
    }
}