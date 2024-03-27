/*
package de.vodafone.tests.CableOnboarding.ST;

import de.vodafone.pages.CableOnboarding.Info_Technik_Service;
import de.vodafone.pages.CableOnboarding.TechInstallDashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

@Epic("Cable OnBoarding")
@Feature("ST")
@Story("WFFT-4057_Onboarding - Tech Install | VKD | Tech-install | Information about technical service Badge for Dashboard Tiles")
public class WFFT_4057 extends CableOnboardingSTSetup {
    @Test(description = "GC01-Verify Information about technical service Badge for Dashboard Tiles in case of a tech installed device user, booked a provider change & has a router from vodafone")
    @TmsLink("WFFT-4070")
    public void GC01(Method method) {
    new TechInstallDashboard(driver)
            .validateDashboard(testData.getTestData(method.getName() + ".header"))
            .clickOnInfoTile();
    new Info_Technik_Service(driver)
                .validateInfoPageCase1(testData.getTestData(method.getName() + ".headline1"),
                testData.getTestData(method.getName() + ".subline1"),testData.getTestData(method.getName() + ".headline2"),
                testData.getTestData(method.getName() + ".subline2"),testData.getTestData(method.getName() + ".button"))
                .clickOnZumButton();
    new TechInstallDashboard(driver)
            .validateDashboard(testData.getTestData(method.getName() + ".header"));
    }
    @Test(description = "GC02-Verify Information about technical service Badge for Dashboard Tiles in case of a tech installed device user, don’t booked a provider change & has a router from vodafone")
    @TmsLink("WFFT-4071")
    public void GC02(Method method) {
        new TechInstallDashboard(driver)
                .validateDashboard(testData.getTestData(method.getName() + ".header"))
                .clickOnInfoTile();
        new Info_Technik_Service(driver)
                .validateInfoPageCase1(testData.getTestData(method.getName() + ".headline1"),
                        testData.getTestData(method.getName() + ".subline1"),testData.getTestData(method.getName() + ".headline2"),
                        testData.getTestData(method.getName() + ".subline2"),testData.getTestData(method.getName() + ".button"))
                .clickOnZumButton();
        new TechInstallDashboard(driver)
                .validateDashboard(testData.getTestData(method.getName() + ".header"));
    }

    @Test(description = "GC03-Verify Information about technical service Badge for Dashboard Tiles in case of a tech installed device user, booked a provider change & has a own router")
    @TmsLink("WFFT-4072")
    public void GC03(Method method) {
        new TechInstallDashboard(driver)
                .validateDashboard(testData.getTestData(method.getName() + ".header"))
                .clickOnInfoTile();
        new Info_Technik_Service(driver)
                .validateInfoPageCase1(testData.getTestData(method.getName() + ".headline1"),
                        testData.getTestData(method.getName() + ".subline1"),testData.getTestData(method.getName() + ".headline2"),
                        testData.getTestData(method.getName() + ".subline2"),testData.getTestData(method.getName() + ".button"))
                .clickOnZumButton();
        new TechInstallDashboard(driver)
                .validateDashboard(testData.getTestData(method.getName() + ".header"));
    }
    @Test(description = "GC04-Verify Information about technical service Badge for Dashboard Tiles in case of a tech installed device user, don’t booked a provider change & has a own router")
    @TmsLink("WFFT-4073")
    public void GC04(Method method) {
        new TechInstallDashboard(driver)
                .validateDashboard(testData.getTestData(method.getName() + ".header"))
                .clickOnInfoTile();
        new Info_Technik_Service(driver)
                .validateInfoPageCase1(testData.getTestData(method.getName() + ".headline1"),
                        testData.getTestData(method.getName() + ".subline1"),testData.getTestData(method.getName() + ".headline2"),
                        testData.getTestData(method.getName() + ".subline3"),testData.getTestData(method.getName() + ".button"))
                .clickOnZumButton();
        new TechInstallDashboard(driver)
                .validateDashboard(testData.getTestData(method.getName() + ".header"));
    }
}
*/