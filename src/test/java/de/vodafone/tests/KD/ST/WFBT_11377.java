package de.vodafone.tests.KD.ST;



import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.KabelTVPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("KD")
@Feature("ST")
@Story("WFBT-11377")
public class WFBT_11377 extends ST_KDSetup {

    @TmsLink("WFBT-11410")
    @Test(description = "WFBT-11410 || GC01 | KD User | Check that Hotline added in Bookable Options Kabel TV Accordion")
    public void GC01CheckHotlineAddedToBookableOptionsKabelTVAccordion() {
        new KD_Dashboard(driver).expandKabelTvAccordion()
                .clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookableOptionAccordion()
                .validateHotlineButton();
    }
}