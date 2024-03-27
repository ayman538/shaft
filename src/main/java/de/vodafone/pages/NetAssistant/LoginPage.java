package de.vodafone.pages.NetAssistant;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class LoginPage {
    // Variables
    private SHAFT.GUI.WebDriver driver;

    //Locators

    public static By loginButton= By.xpath("//*[@id='top']/div/header/nav/div/div[2]/div/div/ul[2]/li[2]/a");
    public static By loginIndicator = By.xpath("//span[@class='indicator' and @style='display: block;']");
    private static By loginButtonLocator = By.xpath("//*[@id='mdd-login-form']/fieldset/button");
    private static By loginUsernameLocator = By.xpath("//*[@id='input-username']");
    private static By loginPasswordLocator = By.xpath("//*[@id='input-password']");
    private static By acceptCookiesButton=By.xpath("//button//span[contains(text(),' ablehnen')]");
    private static By loginUsernameLocatorST = By.xpath("//*[@id='name']");
    private static By loginPasswordLocatorST = By.xpath("//*[@id='password']");
    private static By loginButtonLocatorST = By.xpath("//*[@id='sign-in']");
    public static By meinVodafoneIcon = By.xpath("//a[@class='open-overlay-my-vf']");
    public static By logoutButtonMeinVodafoneIcon = By.xpath("//a[@class='btn btn-alt']");
    public static By loginAgainButton  = By.xpath("//a[@class='btn btn-em btn-sml']");
    public static By loginUserNameSIT  = By.xpath("//input[@automation-id='txtUsername_et']");
    public static By loginPasswordSIT  = By.xpath("//input[@automation-id='txtPassword_et']");
    public static By loginButtonSIT = By.xpath("(//button[@class='btn login-btn'])[1]");


//Constructor
    public LoginPage(SHAFT.GUI.WebDriver driver)
    {
        this.driver=driver;
    }

    //Getters

    public static By getLogoutButtonMeinVodafoneIcon(){return logoutButtonMeinVodafoneIcon;}
    public static By getLoginAgainButton(){ return loginAgainButton; }
    public static By getMeinVodafoneIcon(){ return meinVodafoneIcon; }


    //Methods
    @Step("Navigate Method without deeplink")
    public LoginPage navigate()
    {

        driver.browser().navigateToURL(System.getProperty("de.vodafone.baseUrl.st"));
        return this;
    }
    @Step("Accept Cookies")
    public LoginPage acceptCookies(){
        driver.element().waitToBeReady(acceptCookiesButton);
        //Scroll_To(accept_Cookies_button);
        //
        driver.element().click(acceptCookiesButton);
        return this;
    }
    @Step("Logging In actions")
    public LoginPage loginAction(String userName, String userPassword)
    {
        driver.element().type(loginUsernameLocator,userName);
        driver.element().typeSecure(loginPasswordLocator,userPassword);
        driver.element().click(loginButtonLocator);
        return new LoginPage(driver);
    }
    @Step("Logging In actions")
    public LoginPage loginActionST(String userName, String userPassword)
    {
        driver.element().type(loginUsernameLocatorST,userName);
        driver.element().typeSecure(loginPasswordLocatorST,userPassword);
        driver.element().click(loginButtonLocatorST);
        return new LoginPage(driver);
    }
    @Step("Logging In actions")
    public LoginPage loginActionSIT(String userName, String userPassword)
    {
        driver.element().type(loginUserNameSIT,userName);
        driver.element().typeSecure(loginPasswordSIT,userPassword);
        driver.element().click(loginButtonSIT);
        return new LoginPage(driver);
    }
    @Step("Click on login button")
    public LoginPage loginButtonClick()
    {
        driver.element().click(loginButton);
        return this;
    }

    @Step("Navigate Method with deeplink")
    public LoginPage navigate(String deepLink) {

        driver.browser().navigateToURL( System.getProperty("de.vodafone.baseUrl.st") + deepLink);
        return this;
    }
    @Step("Click on element")
    public LoginPage clickOn(By Element){
        driver.element().click(Element);
        return this;
    }
    @Step("Validate login indicator exists")
    public LoginPage validateLoginIndicatorExists()
    {
        driver.assertThat()
                .element(loginIndicator).exists()
                .withCustomReportMessage("Login Indicator Exists Successfully")
                .perform();
        return this;
    }
}
