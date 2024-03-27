package de.vodafone.tests.CableOnboarding.ST;


import de.vodafone.pages.CableOnboarding.DeineChecklistPage;
import de.vodafone.pages.CableOnboarding.TechInstallDashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Cable OnBoarding")
@Feature("ST")
@Story("Onboarding - Tech Install | VKD | Tech-install | Checklist Badge for Dashboard Tiles")
public class WFFT_3806 extends CableOnboardingSTSetup{
    @Test(description = "GC01-Verify the checklist Badge for dashboard Tiles in case of a tech installed device user, booked a provider change & has a router from vodafone",enabled = false)
    @TmsLink("WFFT-4076")
    public void GC01(Method method){
        new TechInstallDashboard(driver).clickOnDeineChecklist();
        new DeineChecklistPage(driver).verifyThePageText(testData.getTestData(method.getName() + ".checklistTitle"),testData.getTestData(method.getName() + ".checklistSubtitle"),testData.getTestData(method.getName() + ".checklistFirstBoxText"),
                testData.getTestData(method.getName() + ".checklistSecondBoxText"),testData.getTestData(method.getName() + ".checklistThirdBoxText"),testData.getTestData(method.getName() + ".firstButton"),
                testData.getTestData(method.getName() + ".secondButton")).checkTheBoxes(testData.getTestData(method.getName() + ".notificationMessage")).clickTheBackBtn();
        new TechInstallDashboard(driver).verifyDeineChecklistBadge(testData.getTestData(method.getName() + ".checklistStatus"));
    }
    @Test(description = "GC02-Verify the checklist Badge for dashboard Tiles in case of a tech installed device user, don’t booked a provider change & has a router from vodafone",enabled = false)
    @TmsLink("WFFT-4077")
    public void GC02(Method method){
        new TechInstallDashboard(driver).clickOnDeineChecklist();
        new DeineChecklistPage(driver).verifyThePageText(testData.getTestData(method.getName() + ".checklistTitle"),testData.getTestData(method.getName() + ".checklistSubtitle"),testData.getTestData(method.getName() + ".checklistFirstBoxText"),
                testData.getTestData(method.getName() + ".checklistSecondBoxText"),testData.getTestData(method.getName() + ".checklistThirdBoxText"),testData.getTestData(method.getName() + ".firstButton"),
                testData.getTestData(method.getName() + ".secondButton")).checkTheBoxes(testData.getTestData(method.getName() + ".notificationMessage")).clickTheBackBtn();
        new TechInstallDashboard(driver).verifyDeineChecklistBadge(testData.getTestData(method.getName() + ".checklistStatus"));
    }
    @Test(description = "GC03-Verify the checklist Badge for dashboard Tiles in case of a tech installed device user, booked a provider change & has a own router",enabled = false)
    @TmsLink("WFFT-4078")
    public void GC03(Method method){
        new TechInstallDashboard(driver).clickOnDeineChecklist();
        new DeineChecklistPage(driver).verifyThePageText(testData.getTestData(method.getName() + ".checklistTitle"),testData.getTestData(method.getName() + ".checklistSubtitle"),testData.getTestData(method.getName() + ".checklistFirstBoxText"),
                testData.getTestData(method.getName() + ".checklistSecondBoxText"),testData.getTestData(method.getName() + ".checklistThirdBoxText"),testData.getTestData(method.getName() + ".firstButton"),
                testData.getTestData(method.getName() + ".secondButton")).checkTheBoxes(testData.getTestData(method.getName() + ".notificationMessage")).clickTheBackBtn();
        new TechInstallDashboard(driver).verifyDeineChecklistBadge(testData.getTestData(method.getName() + ".checklistStatus"));
    }
    @Test(description = "GC04-Verify the checklist Badge for dashboard Tiles in case of a tech installed device user, don’t booked a provider change & has a own router",enabled = false)
    @TmsLink("WFFT-4079")
    public void GC04(Method method){
        new TechInstallDashboard(driver).clickOnDeineChecklist();
        new DeineChecklistPage(driver).verifyThePageText(testData.getTestData(method.getName() + ".checklistTitle"),testData.getTestData(method.getName() + ".checklistSubtitle"),testData.getTestData(method.getName() + ".checklistFirstBoxText"),
                testData.getTestData(method.getName() + ".checklistSecondBoxText"),testData.getTestData(method.getName() + ".checklistThirdBoxText"),testData.getTestData(method.getName() + ".firstButton"),
                testData.getTestData(method.getName() + ".secondButton")).checkTheBoxes(testData.getTestData(method.getName() + ".notificationMessage")).clickTheBackBtn();
        new TechInstallDashboard(driver).verifyDeineChecklistBadge(testData.getTestData(method.getName() + ".checklistStatus"));
    }

}
