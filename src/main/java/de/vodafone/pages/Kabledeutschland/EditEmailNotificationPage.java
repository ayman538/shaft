package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class EditEmailNotificationPage {

    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public EditEmailNotificationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Cls
    private String pageHeaderText = "Benachrichtigung ändern";
    private String emailNotificationStatusCL = "E-Mail-Benachrichtigung";
    private String NotificationStatusBody_CL = "Du bekommst Deine monatliche Rechnungsbenachrichtigung per E-Mail zugeschickt.";
    private String pageTitle = "E-Mail-Benachrichtigung";


    //Locators
    private By TableHeaderLocator = By.xpath("//span[@automation-id='Header_tv']");
    private By emailNotificationStatusLocator = By.xpath("//h4[@automation-id='titleHeader_tv']");
    private By emailNotificationBodyLocator = By.xpath("//span[@automation-id='description_tv']");
    private By pageTitleLocator = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    private By toggleBtnLocator = By.xpath("//input[@automation-id='1_swt']");
    private By confirmButton = By.xpath("//button[@automation-id='confirmButton_btn']");
    private By dimmedBtn = By.xpath("//button[@automation-id='confirmButton_btn']");


    public By getDimmedButton(String btnText){
        return By.xpath("//*[@disabled=''][contains(.,"+btnText+")]");
    }

    @Step("Click On Toggle Button")
    public void clickOnToggleBtn(){
        driver.element().click(toggleBtnLocator);
    }

    @Step("Click On Confirm Button")
    public void clickOnConfirmButton(){
        driver.element().click(confirmButton);
    }


    public void assertOnTableHeader(){
        driver.verifyThat().element(TableHeaderLocator).textTrimmed()
                .isEqualTo(pageHeaderText)
                .withCustomReportMessage("Assert On Table Header")
                .perform();
    }

    public void assertOnEmailNotificationStatus_CL(){
        driver.verifyThat().element(emailNotificationStatusLocator).textTrimmed()
                .isEqualTo(emailNotificationStatusCL)
                .withCustomReportMessage("Assert On Email Notification Status CL")
                .perform();
    }

    public void assertOnEmailNotificationBody_CL(){
        driver.verifyThat().element(emailNotificationBodyLocator).textTrimmed()
                .isEqualTo(NotificationStatusBody_CL)
                .withCustomReportMessage("Assert On Email Notification Body CL")
                .perform();
    }

    public void assertOnPageTitle(){
        driver.verifyThat().element(pageTitleLocator).textTrimmed()
                .isEqualTo(pageTitle)
                .withCustomReportMessage("Assert On Page Title")
                .perform();
    }

    public void assertThatConfirmButtonIsDimmed(){
        driver.verifyThat().element(dimmedBtn).isDisabled()
                .withCustomReportMessage("Assert That Confirmation Button Is Dimmed")
                .perform();
    }

}
