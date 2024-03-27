package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_5210")
public class WFDT_5210 extends ST_KableDeutschlandSetup {

    //test
    @TmsLink("WFDT-6572")
    @Test(description = "GC01 | Martin - Verify information Message highlighting that my contract is suspended",groups = {"eCare"})
    private void gc01(){

        new Dashboard(driver);
        new Dashboard(driver).validateSuspendedMsg();
    }

    @TmsLink("WFDT-6618")
    @Test(description = "GC02 | MartinSOHO - Verify information Message highlighting that my contract is suspended",groups = {"eCare"})
    private void gc02(){
        new Dashboard(driver);
        new Dashboard(driver).validateSuspendedMsg();
    }
}
