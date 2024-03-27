package de.vodafone.tests.DSL.ST;

import de.vodafone.pages.DSL.DSL_Dashboard;
import de.vodafone.pages.DSL.MyDSLProducts;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("DSL")
@Feature("ST")
@Story("WFBT-9657")
public class WFBT_9657 extends  ST_DSLSetup{
    DSL_Dashboard dsl_dashboard;
    @TmsLink("WFBT-9899")
    @Test(description = "GC01 | WFBT_9657 | Check hint for bookable Super WLAN - Check the new teaser")
    private void GC01() {

        dsl_dashboard = new DSL_Dashboard(driver);
        MyDSLProducts myDSLProducts = dsl_dashboard.chooseMyProductsFromMyProductsAcc();
        myDSLProducts.clickViewMoreSOs().clickBookedOptionsSO_expandBookedOptionsAcc();
        driver.verifyThat().element(MyDSLProducts.BookedOptionsSectionHeader_Locator)
                .textTrimmed().equals(MyDSLProducts.BookedOptionsSectionHeader_CL);
        driver.verifyThat().element(MyDSLProducts.BookedOptionsSectionDesc_Locator)
                .textTrimmed().equals(MyDSLProducts.BookedOptionsSectionDesc_CL);

    }
}
