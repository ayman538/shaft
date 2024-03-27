package de.vodafone.pages.CableOnboarding;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SelfInstallDashboard {

    // Variables
    private final SHAFT.GUI.WebDriver driver;

    //Locators
    private static final By moreInfo_Button = By.xpath("//*[@automation-id='Moreinfo_Link']//a");
    private By Headline = By.xpath("//div[@id='content']//div/div[1]/ws10-headline-brix/h3");
    private By Tile1 = By.xpath("//div[@id='content']//ws10-link-tiles//ul/li[1]/a//span");
    private By Tile2 = By.xpath("//div[@id='content']//ws10-link-tiles//ul/li[2]/a//span");
    private By Tile3 = By.xpath("//div[@id='content']//ws10-link-tiles//ul/li[3]/a//span");
    private By Tile4 = By.xpath("//div[@id='content']//ws10-link-tiles//ul/li[4]/a//span");
    private By HeadlineError = By.xpath("//h1[@automation-id='h1_tv']");
    private By ErrorMsg = By.xpath("//div[@id='content']//ws10-notification//div[2]");
    //CLs
    private static String HeadlineText = "So geht's für Dich weiter";
    private static String TileText1 = "Router Lieferung";
    private static String TileText2 = "Dein Anbieterwechsel";
    private static String TileText3 = "Anschluss einrichten";
    private static String TileText4 = "WLAN einrichten";
    private static String HeadlineErrorText = "Das hat leider nicht geklappt";
    private static String ErrorMsgText = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";
    private static String Tile1Text = "Router-Check";
    private static String Tile3Text = "Router aktivieren";
    //constructor
    public SelfInstallDashboard(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //keywords
    public FAQsPage navigateToFAQsPage() {
        (new ElementActions(driver.getDriver())).click(moreInfo_Button);
        return new FAQsPage(driver);
    }
    @Step("Validate the Dashboard in Case1")
    public void validateDashboardCase1() {
        driver.verifyThat()
                .element(Headline)
                .text()
                .isEqualTo(HeadlineText)
                .perform();
        driver.verifyThat()
                .element(Tile1)
                .text()
                .isEqualTo(TileText1)
                .perform();
        driver.verifyThat()
                .element(Tile2)
                .text()
                .isEqualTo(TileText2)
                .perform();
        driver.verifyThat()
                .element(Tile3)
                .text()
                .isEqualTo(TileText3)
                .perform();
        driver.verifyThat()
                .element(Tile4)
                .text()
                .isEqualTo(TileText4)
                .perform();
    }
    @Step("Validate the Dashboard in Case2")
    public void validateDashboardCase2() {
        driver.verifyThat()
                .element(Headline)
                .text()
                .isEqualTo(HeadlineText)
                .perform();
        driver.verifyThat()
                .element(Tile1)
                .text()
                .isEqualTo(TileText1)
                .perform();
        driver.verifyThat()
                .element(Tile2)
                .text()
                .isEqualTo(TileText3)
                .perform();
        driver.verifyThat()
                .element(Tile3)
                .text()
                .isEqualTo(TileText4)
                .perform();
    }
    @Step("Validate the Dashboard in Case3")
    public void validateDashboardCase3() {
        driver.verifyThat()
                .element(Headline)
                .text()
                .isEqualTo(HeadlineText)
                .perform();
        driver.verifyThat()
                .element(Tile1)
                .text()
                .isEqualTo(Tile1Text)
                .perform();
        driver.verifyThat()
                .element(Tile2)
                .text()
                .isEqualTo(TileText2)
                .perform();
        driver.verifyThat()
                .element(Tile3)
                .text()
                .isEqualTo(Tile3Text)
                .perform();
    }
    @Step("Validate the Dashboard in Case4")
    public void validateDashboardCase4() {
        driver.verifyThat()
                .element(Headline)
                .text()
                .isEqualTo(HeadlineText)
                .perform();
        driver.verifyThat()
                .element(Tile1)
                .text()
                .isEqualTo(Tile1Text)
                .perform();
        driver.verifyThat()
                .element(Tile2)
                .text()
                .isEqualTo(Tile3Text)
                .perform();
    }
    @Step("Validate the Dashboard in error Case5")
    public void validateDashboardCase5() {
        driver.verifyThat()
                .element(HeadlineError)
                .text()
                .isEqualTo(HeadlineErrorText)
                .perform();
        driver.verifyThat()
                .element(ErrorMsg)
                .text()
                .isEqualTo(ErrorMsgText)
                .perform();
    }

}
