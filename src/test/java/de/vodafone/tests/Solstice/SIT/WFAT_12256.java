package de.vodafone.tests.Solstice.SIT;

import de.vodafone.pages.Solstice.SolsticeDashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
@Epic("Solstice")
@Feature("SIT")
@Story("WFAT_12256")
public class WFAT_12256 extends SolsticeSITSetup{
    @TmsLink("WFAT-12924")
    @Test(description = "WFAT-12924 Given   I'm logged in Solstice user+" +
            "\n the Dashboard Element should include " +
            "of the MBO (top level) and Solstice Customer Account (second level).")
    private void TC01(){
        new SolsticeDashboard(driver)
                .expandSolsticeMbo()
                .solsticeMBOValidation();
    }
}
