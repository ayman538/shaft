package de.vodafone.pages.MobileCom;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class QuickCheck {
    SHAFT.GUI.WebDriver driver;

    public QuickCheck(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private static By closeNoticicationMessage = By.xpath("(//div[@class='notification-message-right']//*[name()='svg'])[2]");
    private By guthabenSO_Locator = By.xpath("//*[@type='quickcheck-balance']");
    private By datenSO_Locator = By.xpath("//*[@type='quickcheck']");
    private By guthabenAcc_Locator = By.xpath("//accordion[@id='balanceDetails']//a");
    private By datenAcc_Locator = By.xpath("(//accordion[@id='kostendetails']//a)[1]");
    private By errorNotificationTitle_Locator = By.xpath("(//*[@automation-id='successMsg_tv']//h4)[2]");
    private By errorNotificationDescription_Locator = By.xpath("(//*[@automation-id='successMsg_tv']//p)[2]");
    private By pageTitle = By.xpath("//h1[contains(.,'QuickCheck & Kontostand')]");

    //CLs
    private String errorNotificationTitle_CL = "Ups! Da ist etwas schiefgelaufen.";
    private String errorNotificationDescription_CL = "Bitte versuch es später nochmal.";
    private String expandedAccClassName = "ac-head ac-active";


    //Methods
    @Step("Close Notification")
    public QuickCheck closeNotification() {
        driver.element().click(closeNoticicationMessage);
        return this;
    }

    @Step("Click on Guthaben SO")
    public QuickCheck clickOnGuthabenSO() {
        driver.element().click(guthabenSO_Locator);
        return this;
    }

    @Step("Click on Daten SO")
    public QuickCheck clickOnDatenSO() {
        driver.element().click(datenSO_Locator);
        return this;
    }

    //Assertions
    public QuickCheck assertThatUserNavigatedToPage(){
        driver.verifyThat().element(pageTitle).exists().withCustomReportMessage("assert that user navigated to the quick check page").perform();
        return this;
    }

    public QuickCheck assertThatGuthabenAccIsExpanded() {
        driver.browser().waitUntilUrlContains("balanceDetails");
        driver.verifyThat().element(guthabenAcc_Locator).attribute("class").isEqualTo(expandedAccClassName).withCustomReportMessage("assert that guthaben accordion is expanded").perform();
        return this;
    }

    public QuickCheck assertThatDatenAccIsExpanded() {
        driver.browser().waitUntilUrlContains("kostendetails");
        driver.verifyThat().element(datenAcc_Locator).attribute("class").isEqualTo(expandedAccClassName).withCustomReportMessage("assert that guthaben accordion is expanded").perform();
        return this;
    }




    public QuickCheck assertOnErrorNotification() {
        driver.verifyThat().element(errorNotificationTitle_Locator).textTrimmed().isEqualTo(errorNotificationTitle_CL).withCustomReportMessage("assert on error notification title").perform();
        driver.verifyThat().element(errorNotificationDescription_Locator).textTrimmed().isEqualTo(errorNotificationDescription_CL).withCustomReportMessage("assert on error notification description").perform();
        return this;
    }
}
