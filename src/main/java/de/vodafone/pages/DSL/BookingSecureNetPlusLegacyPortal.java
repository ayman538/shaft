package de.vodafone.pages.DSL;

import com.shaft.driver.SHAFT;

import java.util.ArrayList;

public class BookingSecureNetPlusLegacyPortal {
    private SHAFT.GUI.WebDriver driver;

    public BookingSecureNetPlusLegacyPortal(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public String LegacyURL = "https://www.vodafone.de/privat/service/basic.html";

    public String getLegacyURL()
    {
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getDriver().getWindowHandles());
        driver.getDriver().switchTo().window(tabs2.get(1));
        String URL= driver.browser().getCurrentURL() ;
        return URL;
    }



}
