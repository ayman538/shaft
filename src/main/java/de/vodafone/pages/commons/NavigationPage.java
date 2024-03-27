package de.vodafone.pages.commons;

import com.shaft.driver.SHAFT;
import de.vodafone.pages.NetAssistant.ChatbotPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.ArrayList;
public class NavigationPage {
    private SHAFT.GUI.WebDriver driver;

    //Locators
    private static By tobiIcon = By.xpath("(//div[@class='svg-wrapper'])[1]");
    public NavigationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    @Step("Navigate in new tab Method with deeplink - ST environment")
    public NavigationPage navigateInNewTab(String url) {
        driver.browser().switchToNewTab(System.getProperty("de.vodafone.baseUrl.st") + url);
        if(!(url.contains("tickets") || url.contains("token")))
           netassitantRedirection();
        return this;
    }


    @Step("Navigate in new tab Method with deeplink - SIT environment")
    public NavigationPage navigateInNewTabSIT(String deeplink) {
        driver.browser().switchToNewTab(System.getProperty("de.vodafone.baseUrl.sit") + deeplink);
        if(!(deeplink.contains("tickets") || deeplink.contains("token")))
            netassitantRedirection();
        return this;
    }

    @Step("Redirection to Net Assistant")
    public NavigationPage netassitantRedirection() {
        {
            String currentURL;

            if (driver.element().isElementDisplayed(tobiIcon) && driver.browser().getCurrentURL().contains("tickets")) {
                currentURL = driver.browser().getCurrentURL().replace("tickets", "chatbot");
                driver.browser().navigateToURL(currentURL);
            }

        }
        return this;
    }

    @Step("Navigate in new tab Method using deeplink with tickets redirection feature enabled - ST environment")
    public NavigationPage navigateInNewTabWithTicketsRedirection(String url) {
        driver.browser().switchToNewTab(System.getProperty("de.vodafone.baseUrl.st") + url);

        return this;
    }
}
