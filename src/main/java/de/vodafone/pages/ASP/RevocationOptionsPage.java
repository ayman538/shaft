package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class RevocationOptionsPage {
    // Variables
    private static SHAFT.GUI.WebDriver driver;
    public static final By Header_CL = By.xpath("//*[@automation-id='pageHeader_tv']//h1");
    public static final By firstOption_BTN = By.xpath("//*[@automation-id='revocation-step-one-link_title_tv']");
    public static final By firstOptionDescription_CL = By.xpath("//*[@automation-id='revocation-step-one-link_description_tv']");

    public static final By secondOption_BTN = By.xpath("//*[@automation-id='sales-agent-link_title_tv']");
    public static final By secondOptionDescription_CL = By.xpath("//*[@automation-id='sales-agent-link_description_tv']");

    public static final By ThirdOption_BTN = By.xpath("//*[@automation-id='open-questions-link_title_tv']");
    public static final By ThirdOptionDescription_CL = By.xpath("//*[@automation-id='open-questions-link_description_tv']");

    public static final By fourthOption_BTN = By.xpath("//*[@automation-id='winback-link_title_tv']");
    public static final By fourthOptionDescription_CL = By.xpath("//*[@automation-id='winback-link_description_tv']");



    // Constructor
    public RevocationOptionsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public ExchangeHwStepOnePage navigateToExchangeHwPage (){

        new ElementActions(driver.getDriver()).click(firstOption_BTN);
        return new ExchangeHwStepOnePage(driver);
    }
    public SalesAgentPage navigateToSalesAgentPage (){

        new ElementActions(driver.getDriver()).click(secondOption_BTN);
        return new SalesAgentPage(driver);

    }
    public OpenQuestionsPage navigateToOpenQuestionsPage (){

        new ElementActions(driver.getDriver()).click(ThirdOption_BTN);
        return new OpenQuestionsPage(driver);

    }
    public WinbackPage navigateToWinbackPage (){

        new ElementActions(driver.getDriver()).click(fourthOption_BTN);
        return new WinbackPage(driver);

    }
}
