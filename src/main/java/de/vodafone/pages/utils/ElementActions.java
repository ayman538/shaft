package de.vodafone.pages.utils;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

public class ElementActions {

    public static void clickOnPopupElement(SHAFT.GUI.WebDriver driver, By elementLocator) {

        ArrayList<String> tabsSizeBeforeClickAction = new ArrayList<String> (driver.getDriver().getWindowHandles());
        driver.element().click(elementLocator);

        try {
            new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10))
                    .until(ExpectedConditions.numberOfWindowsToBe((tabsSizeBeforeClickAction.size()) + 1));
        }
        catch( TimeoutException e){
                Assert.fail("No Tabs were opened by clicking on element " + elementLocator);

        }

        ArrayList<String> tabsSizeAfterClickAction = new ArrayList<String> (driver.getDriver().getWindowHandles());
        driver.browser().switchToWindow(tabsSizeAfterClickAction.get(tabsSizeAfterClickAction.size()-1));
    }
}