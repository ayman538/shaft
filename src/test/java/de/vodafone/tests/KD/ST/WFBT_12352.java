package de.vodafone.tests.KD.ST;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.KabelTVPage;

@Epic("KD")
@Feature("ST")
@Story("WFBT-12352")
public class WFBT_12352 extends ST_KDSetup {

    @TmsLink("WFBT-9233")
    @Test(description = "GC01 || Martin TV user - Validate the view of Mein Kabel-TV accordion in case the user has only CLS tariff.")
    private void gc01(Method method) {
        new KD_Dashboard(driver)
                .clickOnKabelTVBurgerMenu()
                .clickOnMeinKabelTVBurgerMenu();
        new KabelTVPage(driver)
                .validateCLSTeaser(testData.getTestData(method.getName() + ".clsTeaserHeader_CL"), testData.getTestData(method.getName() + ".clsTeaserTitle_CL"),testData.getTestData(method.getName() + ".clsTeaserText_CL"));
    }

    @TmsLink("WFBT-13174")
    @Test(description = "GC02 || Martin TV user - Validate the view of Mein Kabel-TV accordion in case the user has CLS tariff and Mein Tariff.")
    private void gc02(Method method) {
        new KD_Dashboard(driver)
                .clickOnKabelTVBurgerMenu()
                .clickOnMeinKabelTVBurgerMenu();
        new KabelTVPage(driver)
                .validateViewOfMeinTariffOnly(testData.getTestData(method.getName() + ".clsTeaserHeader_CL"), testData.getTestData(method.getName() + ".clsTeaserTitle_CL"));
    }

}
