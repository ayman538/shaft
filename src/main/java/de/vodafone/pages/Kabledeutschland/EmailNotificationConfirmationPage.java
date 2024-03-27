package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class EmailNotificationConfirmationPage {
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public EmailNotificationConfirmationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Cls
    private String confirmationMessageCL = "Vielen Dank!";
    private String confirmationMessageBodyCL = "Wir haben Deine Änderungen gespeichert. Es kann einen Augenblick dauern, bis diese aktiviert sind. Dann bekommst Du eine E-Mail von uns.";
    private String emailAddressColorCode = "66, 125, 0";
    private String errorMessageHL_Text = "Das hat leider nicht geklappt";
    private String errorMessageBody_Text = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";
    private String aktivFieldText = "aktiv";


    //Locators
    private By confirmationMessageHL = By.xpath("//div[@class='item-2 w-100']/h4");
    private By confirmationMessageBody = By.xpath("//p[@class='notification-text mb-10 mt-10']");
    private By accordionLocator = By.xpath("//a[@class='ac-head']");
    private By emailNotificationField = By.xpath("//span[@automation-id='summaryTitle_tv']");
    private By closeCTA = By.xpath("//button[@automation-id='closeButton_btn']");
    private By emailAddressColorLocator = By.xpath("//span[@class='i-green']");
    private By errorMessageHL_Locator= By.xpath("//div[@class='item-2 w-100']/h4");
    private By errorMessageBodyLocator= By.xpath("//p[@class='notification-text mb-10 mt-10']");
    private By backButtonLocator =By.xpath("//button[@automation-id='backButton_btn']");
    private By aktivLocator = By.xpath("//span[@automation-id='summarySubTitle_tv']");




    //Methods

    @Step("Expand The Accordion")
    public void expandUbersichAccordion(){
        driver.element().click(accordionLocator);
    }

    public void assertOnConfirmationNotificationHeadline(){
        driver.verifyThat().element(confirmationMessageHL).textTrimmed()
                .isEqualTo(confirmationMessageCL)
                .withCustomReportMessage("Assert On Confirmation Notification Headline")
                .perform();
    }

    public void assertOnConfirmationNotificationBody(){
        driver.verifyThat().element(confirmationMessageBody).textTrimmed()
                .isEqualTo(confirmationMessageBodyCL)
                .withCustomReportMessage("Assert On Confirmation Notification Body")
                .perform();
    }

    public void assertOnEmailNotificationField(){
        driver.verifyThat().element(emailNotificationField).exists()
                .withCustomReportMessage("Assert On Email Notification Field")
                .perform();
    }

    public void assertOnCloseCTAUnderAccordionNotExists(){
        driver.verifyThat().element(closeCTA).doesNotExist()
                .withCustomReportMessage("Assert Close Under Accordion Does Not Exist")
                .perform();
    }

    public void assertOnNotificationActivatedColor(){
        driver.verifyThat().element(emailAddressColorLocator)
                .cssProperty("color").contains(emailAddressColorCode)
                .withCustomReportMessage("Assert On Email Address Color")
                .perform();
    }

    public void assertOnErrorMessageHL(){
        driver.verifyThat().element(errorMessageHL_Locator).textTrimmed()
                .isEqualTo(errorMessageHL_Text)
                .withCustomReportMessage("Assert On Error Message Headline")
                .perform();
    }

    public void assertOnErrorMessageBody(){
        driver.verifyThat().element(errorMessageBodyLocator).textTrimmed()
                .isEqualTo(errorMessageBody_Text)
                .withCustomReportMessage("Assert On Error Message Body")
                .perform();
    }

    public void assertOnBackButtonUnderAccordionNotExists(){
        driver.verifyThat().element(backButtonLocator)
                .doesNotExist()
                .withCustomReportMessage("Assert On Back Button Under The Accordion Not Exists")
                .perform();
    }

    public void assertOnNotificationFieldStatus(){
        driver.verifyThat().element(aktivLocator).textTrimmed()
                .isEqualTo(aktivFieldText)
                .withCustomReportMessage("Assert On Notification Field Status")
                .perform();
    }
}
