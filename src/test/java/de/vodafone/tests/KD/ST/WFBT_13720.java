package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.SettingPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import de.vodafone.pages.KD.KD_Dashboard;

@Epic("KD")
@Feature("ST")
@Story("WFBT-13720")
public class WFBT_13720 extends ST_KDSetup {
    @TmsLink("WFBT-13897")
    @Test(description = "WFBT-13897 || GC01 || KD TV user - Validate that GigaTV accordion expands successfully after clicking on GigaTV SO on Device and settings pge")
    private void gc01(Method method) {
        new KD_Dashboard(driver)
                .clickOnKabelTVAccordion()
                .clickOnInteretAndPhoneSettingsSO();
        new SettingPage(driver).clickOnGigaTVsSO().validateAccordionexpandedsuccessfully();
    }
}