package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;

public class LegacyPortalPage {
    SHAFT.GUI.WebDriver driver;

    public LegacyPortalPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private String LegacyURL = "https://kabel.vodafone.de/meinkabel/vertraege/dienste";


    @Step("Get current URL")
    public String getCurrentURL()
    {
        String CurrentURL = driver.browser().getCurrentURL();
        return CurrentURL;
    }

    @Step("Validate navigation to legacy portal")
    public LegacyPortalPage validateNavToLegacyPortal()
    {
        Validations.assertThat()
                .object(getCurrentURL())
                .isEqualTo(LegacyURL).perform();
        return this;
    }
    @Step("Quit current window")
    public LegacyPortalPage closeCurrentWindow()
    {
        driver.browser().closeCurrentWindow();
        return this;
    }
}
