package de.vodafone.pages.NetAssistant;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.internal.JavaScriptWaitManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class HelpPage {
    // Variables
    private SHAFT.GUI.WebDriver driver;
    private final String help_Form_DSL = System.getProperty("de.vodafone.baseUrl.st") +"meinvodafone/public/netzassistent/review?product=dsl";
    private final String help_Form_Cable = System.getProperty("de.vodafone.baseUrl.sit") + "meinvodafone/public/netzassistent/review?product=cable";
    //Locators
    private static By question1 = By.xpath("//*[@automation-id='helpFlowText_tv']");
    private static By HelpPageHeader = By.xpath("//*[@id='content']/div[2]/div/div/section/div/div/div/app-root/div/app-netzassistent-component/app-netzassistent-landing-component/h1");
    private static By customerID = By.xpath("//*[@automation-id='emailAddress_et']");
    public static By losgehtsbutton = By.xpath("//button[@class='btn btn-sml']");
    private static By QrCodePageHeader = By.xpath("//*[@id='content']/div[2]/div/div/section/div/div/div/app-root/div/app-netzassistent-component/app-netzassistent-qr-component/h1");
    private static By ZurDesktopVeriosbutton = By.xpath("//*[@id='content']/div[2]/div/div/section/div/div/div/app-root/div/app-netzassistent-component/app-netzassistent-qr-component/div[2]/div/div[2]/div/div[2]/div[2]/button");
    private static By regionDropDown = By.xpath("//button[@automation-id='dropdown_btn']");
    private static By regionCodeDSL = By.xpath("//input[@automation-id='areaCode_et']");
    private static By phoneNoDSL = By.xpath("//input[@automation-id='phoneNumber_et']");
    private static By regionSelect(String region) {return By.xpath("//li[@id='option_child' and contains(.,'"+region+"')]");}
    //*[@class='button-wrapper button-wrapper-only fixed-height' and contains(.,' Neu starten')]
    //constructor
    public HelpPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Getters
    public static By getQuestion1() {
        return question1;
    }

    public static By getHelpPageHeader() {
        return HelpPageHeader;
    }
    public static By getQrCodePageHeader() {return QrCodePageHeader;}

    //Methods
    @Step("Navigate Method with deeplink")
    public HelpPage navigate(String deepLink) {

        driver.browser().navigateToURL( System.getProperty("de.vodafone.baseUrl.st") + deepLink);
        return this;
    }

    @Step("Get current URL")
    public HelpPage getCurruntURL() {
        driver.assertThat().browser().url().contains("c_id=hilfe_netzass_kip");

        return this;
    }
    @Step("Enter customer id")
    public HelpPage EnterCustomerID() {
        driver.element().type( customerID, "332881148");
        return this;

    }
    @Step("Click on losgehst button")
    public HelpPage Clicklosgehst() {
        driver.element().click(losgehtsbutton);
        return this;
    }
    @Step("Click on Zur desktop verios button")
    public HelpPage ClickZurversiondesktop() {
        driver.element().click( ZurDesktopVeriosbutton);
        return this;
    }
    @Step("Switch to another tab")
    public HelpPage SwitchToTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getDriver().getWindowHandles());
        driver.browser().switchToWindow(tabs.get(1));
        return this;
    }
    @Step("Validate redirection of error msg button")
    public HelpPage validateErrorMsgButtonRedirection()
    {
        driver.assertThat()
                .browser()
                .url().isEqualTo(help_Form_DSL)
                .withCustomReportMessage("C_ID updated")
                .perform();
        return this;
    }

    @Step("Switch to another tab")
    public HelpPage switchToTab(){
        ArrayList<String> tabs = new ArrayList<String> (driver.getDriver().getWindowHandles());
        driver.browser().switchToWindow(tabs.get(1));
        return this;
    }
    @Step("Validate URL redirection for Cable Helpform")
    public HelpPage validateHelpFormRedirectionCable()
    {
        driver.assertThat()
                .browser()
                .url()
                .doesNotContain("i=")
                .perform();

        driver.assertThat()
                .browser()
                .url()
                .doesNotContain("c=CABLE")
                .perform();

        driver.assertThat()
                .browser()
                .url()
                .contains("c_id=hilfe_netzass_kip")
                .perform();
        return this;
    }
    @Step("Validate URL redirection for UM Helpform")
    public HelpPage validateHelpFormRedirectionUM()
    {
        driver.assertThat()
                .browser()
                .url()
                .doesNotContain("i=")
                .perform();

        driver.assertThat()
                .browser()
                .url()
                .doesNotContain("c=UM")
                .perform();

        driver.assertThat()
                .browser()
                .url()
                .doesNotContain("s=")
                .perform();

        driver.assertThat()
                .browser()
                .url()
                .contains("c_id=hilfe_netzass_kip")
                .perform();
        return this;
    }
    @Step("Validate URL redirection for DSL Helpform")
    public HelpPage validateHelpFormRedirectionDSL()
    {
        driver.assertThat()
                .browser()
                .url()
                .doesNotContain("i=")
                .perform();

        driver.assertThat()
                .browser()
                .url()
                .doesNotContain("c=DSL")
                .perform();

        driver.assertThat()
                .browser()
                .url()
                .doesNotContain("a=")
                .perform();

        driver.assertThat()
                .browser()
                .url()
                .doesNotContain("p=")
                .perform();

        driver.assertThat()
                .browser()
                .url()
                .contains("c_id=hilfe_netzass_dsl")
                .perform();
        return this;
    }
    @Step("Validate UM deeplink c_id value is updated")
    public HelpPage validateUMDeeplinkC_idUpdated()
    {
        driver.assertThat()
                .browser()
                .url()
                .contains("c_id=hilfe_netzass_kip")
                .perform();

        return this;
    }
}



