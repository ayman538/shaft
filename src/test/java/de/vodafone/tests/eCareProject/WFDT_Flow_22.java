package de.vodafone.tests.eCareProject;

import de.vodafone.pages.eCareProject.Dashboard;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

@Epic("eCare Project")
public class WFDT_Flow_22 extends eCareProjectSetup {

    //Test
    @Test
    @Description("GC22 - Paul - EECC Contract Summary for changing tariff Callya user")
    private void gc22() {
        new Dashboard(driver).clickMeinTarif();
        new Dashboard(driver).clickChangeTarif();
        new Dashboard(driver).clickWeiterBtn();
        new Dashboard(driver).clickPDFLink();
    }
}
