package de.vodafone.pages.KD;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SettingPage {
    private SHAFT.GUI.WebDriver driver;
    public SettingPage(SHAFT.GUI.WebDriver driver){
                this.driver = driver ;
            }

    //Locator
    private By DeviceAndSettingHeaderPage = By.xpath("//div[@automation-id='pageHeader_tv']//h1");
    private By RegisterDevicesText = By.xpath("((//div[@class='ac-body'])[4]//span)[1]");
    //URL
    private String TVSettingURL = "https://simplicity.wf-de.vodafone.com/meinvodafone/services/meine-produkte/tv/geraete-einstellungen";
    private String PhoneSettingURL = "https://simplicity.wf-de.vodafone.com/meinvodafone/services/meine-produkte/internet-phone/geraete-einstellungen";

   //Locators
    private By gigaTVSO = By.xpath("//div[@automation-id='cableGigatv_so']");
    private By expandedGigaTVAcc = By.xpath("(//li[@automation-id='gigatv_acc']//div)[2]");

    //Methods
    @Step("Validate when click on TV Setting smart object will directed to TV Setting URL")
    public void validateTVSettingURL() {
        Validations.assertThat().browser(driver.getDriver()).url().isEqualTo(TVSettingURL).perform();
    }

    @Step("Validate when click on Internet and Phone Setting smart object")
    public SettingPage clickOnGigaTVsSO()
    {
        driver.element().click(gigaTVSO);
        return this;
    }

    @Step("Validate when click on TV Setting smart object will directed to Phone Setting URL")
    public void validatePhoneSettingURL(){
        Validations.assertThat().browser(driver.getDriver()).url().isEqualTo(PhoneSettingURL).perform();
    }
    @Step("validate that GigaTV accordion has been expanded successfully")
    public SettingPage validateAccordionexpandedsuccessfully(){
        driver.element().isElementDisplayed(expandedGigaTVAcc);
        return this;
    }
    @Step("Validate That Giga TV Gerate accordion is expanded by default")
    public SettingPage validateGigaTVGerateAccExpanded(String RegisterDevicesTextCL){
        driver.verifyThat().element(RegisterDevicesText).textTrimmed().isEqualTo(RegisterDevicesTextCL).perform();
        return this;
    }
    @Step("Validate Device and Setting Header Page")
    public SettingPage validateDeviceAndSettingHeaderPage(String DeviceAndSettingHeaderPageCL){
        driver.verifyThat().element(DeviceAndSettingHeaderPage).text().isEqualTo(DeviceAndSettingHeaderPageCL).perform();
    return this;
    }
}