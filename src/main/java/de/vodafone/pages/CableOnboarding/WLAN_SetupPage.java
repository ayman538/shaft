package de.vodafone.pages.CableOnboarding;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class WLAN_SetupPage {
    private final SHAFT.GUI.WebDriver driver;

    public WLAN_SetupPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By headerText = By.xpath("//div[@class='wlan__header__container']//h1");
    private By subHeaderText = By.xpath("//div[@class='option-picker-container wlan__options_container']//h3");
    private By firstOption = By.xpath("(//fieldset[@class='ws10-option-picker ws10-option-picker--image']//div//span)[1]");
    private By secondOption = By.xpath("(//fieldset[@class='ws10-option-picker ws10-option-picker--image']//div//span)[2]");
    private By nextBtn = By.xpath("(//a[@automation-id='undefined_Link']//span)[1]");
    private By firstQuestionFAQ = By.xpath("(//div[@class='wlan__accordion']//label//span)[1]");
    private By secondQuestionFAQ = By.xpath("(//div[@class='wlan__accordion']//label//span)[2]");
    private By thirdQuestionFAQ = By.xpath("(//div[@class='wlan__accordion']//label//span)[3]");
    private By instructionsBtn = By.xpath("(//a[@automation-id='undefined_Link']//span)[1]");
    private By superConnectBtn = By.xpath("(//a[@automation-id='undefined_Link']//span)[2]");
    private By connectYourDeviceText = By.xpath("(//h4[@automation-id='h4_tv'])[1]");
    private By connectYourDeviceBtn = By.xpath("(//a[@class='ws10-button-link ws10-button-link--color-primary-200'])[1]");
    private By wifiSettingsText = By.xpath("(//h4[@automation-id='h4_tv'])[2]");
    private By wifiSettingsBtn = By.xpath("(//a[@class='ws10-button-link ws10-button-link--color-primary-200'])[2]");
    private By finalBackBtn = By.xpath("//div[@class='shared__submit-button wlan__submit-button']//span");

    //START_4090
    @Step("Verify the first page of the flow")
    public WLAN_SetupPage verifyTheFirstPageOfTheFlow(String header,String subheader, String firstPick, String secondPick, String nextButton,
                                                      String firstQuestion, String secondQuestion, String thirdQuestion){
        driver.verifyThat().element(headerText).textTrimmed().contains(header).perform();
        driver.verifyThat().element(subHeaderText).textTrimmed().contains(subheader).perform();
        driver.verifyThat().element(firstOption).textTrimmed().contains(firstPick).perform();
        driver.verifyThat().element(secondOption).textTrimmed().contains(secondPick).perform();
        driver.verifyThat().element(nextBtn).textTrimmed().contains(nextButton).perform();
        driver.verifyThat().element(firstQuestionFAQ).textTrimmed().contains(firstQuestion).perform();
        driver.verifyThat().element(secondQuestionFAQ).textTrimmed().contains(secondQuestion).perform();
        driver.verifyThat().element(thirdQuestionFAQ).textTrimmed().contains(thirdQuestion).perform();
        return this;
    }

    @Step("Verify the yes option pick")
    public WLAN_SetupPage verifyTheYesOptionPick(String header, String instructionsButton, String superConnectButton,
                                                 String connectYourDeviceTxt, String connectYourDeviceButton,String wifiSettingsTxt,
                                                 String wifiSettingsButton,String backBtn){
        driver.verifyThat().element(headerText).textTrimmed().contains(header).perform();
        driver.verifyThat().element(instructionsBtn).textTrimmed().contains(instructionsButton).perform();
        driver.verifyThat().element(superConnectBtn).textTrimmed().contains(superConnectButton).perform();
        driver.verifyThat().element(connectYourDeviceText).textTrimmed().contains(connectYourDeviceTxt).perform();
        driver.verifyThat().element(connectYourDeviceBtn).textTrimmed().contains(connectYourDeviceButton).perform();
        driver.verifyThat().element(wifiSettingsText).textTrimmed().contains(wifiSettingsTxt).perform();
        driver.verifyThat().element(wifiSettingsBtn).textTrimmed().contains(wifiSettingsButton).perform();
        driver.verifyThat().element(finalBackBtn).textTrimmed().contains(backBtn).perform();

        return this;
    }

    @Step("Verify the other options picks")
    public WLAN_SetupPage verifyOtherOptionsPick(String header, String instructionsButton, String superConnectButton,String wifiSettingsTxt,
                                                 String wifiSettingsButton,String backBtn){
        driver.verifyThat().element(headerText).textTrimmed().contains(header).perform();
        driver.verifyThat().element(instructionsBtn).textTrimmed().contains(instructionsButton).perform();
        driver.verifyThat().element(superConnectBtn).textTrimmed().contains(superConnectButton).perform();
        driver.verifyThat().element(connectYourDeviceText).textTrimmed().contains(wifiSettingsTxt).perform();
        driver.verifyThat().element(connectYourDeviceBtn).textTrimmed().contains(wifiSettingsButton).perform();
        driver.verifyThat().element(finalBackBtn).textTrimmed().contains(backBtn).perform();
        return this;
    }
    //END_WFFT_4090
    @Step("Click on the next button")
    public WLAN_SetupPage clickOnTheNextBtn(){
        driver.element().click(nextBtn);
        return this;
    }
    @Step("Select first option")
    public WLAN_SetupPage selectFirstOption(){
        driver.element().click(firstOption);
        return this;
    }
    @Step("Select second option")
    public WLAN_SetupPage selectSecondOption(){
        driver.element().click(secondOption);
        return this;
    }


}
