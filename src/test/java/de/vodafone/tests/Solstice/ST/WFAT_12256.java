package de.vodafone.tests.Solstice.ST;

import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("Solstice")
@Feature("ST")
@Story("WFAT_12256")
public class WFAT_12256 extends SolsticeSTSetup {
    @TmsLink("WFAT-12922")
    @Test(description = "WFAT-12922 Given I'm logged in Solstice user When I sign in to my account and open my Dashboard, then I want to find my solstice MBO collapsed ( more than 1 MBO assigned), the Dashboard Element should include the of the MBO (top level) and Solstice Customer Account (second level).")
    public void GCO1(){
        new SolsticeDashboard(driver).expandSolsticeMbo();
        solsticeMBOValidation();
    }

    @TmsLink("WFAT-12923")
    @Test(description = "WFAT-12923 Given I'm logged in Solstice user When I sign in to my account and open my Dashboard, then I want to find my solstice MBO Expanded, the Dashboard Element should include the of the MBO (top level) and Solstice Customer Account (second level).")
    public void GCO2(){
        solsticeMBOValidation();
    }

    private void solsticeMBOValidation(){
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeDashboard.SolsticeMboHeader_text)
                .text()
                .contains(SolsticeDashboard.SolsticeMboHeader)
                .withCustomReportMessage("Check that Header text exist in MBO label")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeDashboard.SolsticeMboTitle_text)
                .text()
                .contains(SolsticeDashboard.SolsticeMboTitle)
                .withCustomReportMessage("Check that Header text exist in MBO label")
                .perform();
    }

}
