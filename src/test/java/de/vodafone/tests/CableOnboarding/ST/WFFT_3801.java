package de.vodafone.tests.CableOnboarding.ST;


import de.vodafone.pages.CableOnboarding.TechInstallDashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Cable OnBoarding")
@Feature("ST")
@Story("WFFT-3801_Onboarding - Tech Install | VKD | Tech-install | Start-Portal Dashboard\n")
public class WFFT_3801 extends CableOnboardingSTSetup{
    @Test(description = "GC01- Verify the dashboard in case of a tech installed device user, booked a provider change & has a router from Vodafone.",enabled = false)
    @TmsLink("WFFT-4064")
    public void GC01(Method method){
        new TechInstallDashboard(driver).validateChecklistProviderChangeBooked(testData.getTestData(method.getName() + ".header"),testData.getTestData(method.getName() + ".tarrifName"),
                testData.getTestData(method.getName() + ".firstTile"),testData.getTestData(method.getName() + ".secondTile"),testData.getTestData(method.getName() + ".thirdTile"),
                testData.getTestData(method.getName() + ".forthTile")).verifyTeasersProviderChangeBooked(testData.getTestData(method.getName() + ".firstTeaser"),
                testData.getTestData(method.getName() + ".secondTeaser")).verifyTheFAQ(testData.getTestData(method.getName() + ".faqHeader"),testData.getTestData(method.getName() + ".firstFAQ"),testData.getTestData(method.getName() + ".secondFAQ"),
                testData.getTestData(method.getName() + ".thirdFAQ"),testData.getTestData(method.getName() + ".forthFAQ"));
    }
    @Test(description = "GC02- Verify the dashboard in case of a tech installed device user, don’t booked a provider change & has a router from vodafone",enabled = false)
    @TmsLink("WFFT-4065")
    public void GC02(Method method){
        new TechInstallDashboard(driver).validateChecklistProviderChangeNotBooked(testData.getTestData(method.getName() + ".header"),testData.getTestData(method.getName() + ".tarrifName"),
                testData.getTestData(method.getName() + ".firstTile"),testData.getTestData(method.getName() + ".secondTile"),testData.getTestData(method.getName() + ".thirdTile")).verifyTeasersProviderChangeNotBooked(testData.getTestData(method.getName() + ".firstTeaser"),
                testData.getTestData(method.getName() + ".secondTeaser"),testData.getTestData(method.getName() + ".thirdTeaser")).verifyTheFAQ(testData.getTestData(method.getName() + ".faqHeader"),testData.getTestData(method.getName() + ".firstFAQ"),testData.getTestData(method.getName() + ".secondFAQ"),
                testData.getTestData(method.getName() + ".thirdFAQ"),testData.getTestData(method.getName() + ".forthFAQ"));
    }
    @Test(description = "GC03- Verify the dashboard in case of a tech installed device user, booked a provider change & has a own router",enabled = false)
    @TmsLink("WFFT-4074")
    public void GC03(Method method){
        new TechInstallDashboard(driver).validateChecklistProviderChangeBooked(testData.getTestData(method.getName() + ".header"),testData.getTestData(method.getName() + ".tarrifName"),
                testData.getTestData(method.getName() + ".firstTile"),testData.getTestData(method.getName() + ".secondTile"),testData.getTestData(method.getName() + ".thirdTile"),
                testData.getTestData(method.getName() + ".forthTile")).verifyTeasersProviderChangeBooked(testData.getTestData(method.getName() + ".firstTeaser"),
                testData.getTestData(method.getName() + ".secondTeaser")).verifyTheFAQ(testData.getTestData(method.getName() + ".faqHeader"),testData.getTestData(method.getName() + ".firstFAQ"),testData.getTestData(method.getName() + ".secondFAQ"),
                testData.getTestData(method.getName() + ".thirdFAQ"),testData.getTestData(method.getName() + ".forthFAQ"));
    }
    @Test(description = "GC04- Verify the dashboard in case of a tech installed device user, don’t booked a provider change & has a own route",enabled = false)
    @TmsLink("WFFT-4075")
    public void GC04(Method method){
        new TechInstallDashboard(driver).validateChecklistProviderChangeNotBooked(testData.getTestData(method.getName() + ".header"),testData.getTestData(method.getName() + ".tarrifName"),
                testData.getTestData(method.getName() + ".firstTile"),testData.getTestData(method.getName() + ".secondTile"),testData.getTestData(method.getName() + ".thirdTile")).verifyTeasersProviderChangeNotBooked(testData.getTestData(method.getName() + ".firstTeaser"),
                testData.getTestData(method.getName() + ".secondTeaser"),testData.getTestData(method.getName() + ".thirdTeaser")).verifyTheFAQ(testData.getTestData(method.getName() + ".faqHeader"),testData.getTestData(method.getName() + ".firstFAQ"),testData.getTestData(method.getName() + ".secondFAQ"),
                testData.getTestData(method.getName() + ".thirdFAQ"),testData.getTestData(method.getName() + ".forthFAQ"));
    }

}
