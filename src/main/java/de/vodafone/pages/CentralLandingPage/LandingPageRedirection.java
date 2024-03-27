package de.vodafone.pages.CentralLandingPage;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.GeneralError;

public class LandingPageRedirection {
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public LandingPageRedirection(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    public GeneralError redirectToGeneralErrorST() {
        String pagePath = "";
        String url = "";
        pagePath = "meinvodafone/services/teilnehmer/mein-tarif?documentUrl=/zuhause-legi";
        url = System.getProperty("de.vodafone.baseUrl.st") + pagePath;
        driver.browser().navigateToURL(url);
        return new GeneralError(driver);
    }
}