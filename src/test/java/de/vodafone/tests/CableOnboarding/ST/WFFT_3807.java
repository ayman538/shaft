/*
package de.vodafone.tests.CableOnboarding.ST;


import de.vodafone.pages.CableOnboarding.SelfInstallDashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

@Epic("Cable OnBoarding")
@Feature("ST")
@Story("WFFT-3807_Onboarding - Self Install | VKD | Self-install | Start-Portal Dashboard")
public class WFFT_3807 extends CableOnboardingSTSetup {


    @Test(description = "GC01- Verify the dashboard in case of a self installed device user, booked a provider change & has a router from vodafone (Kabel 250)")
    @TmsLink("WFFT-4066")
    public void GC01(Method method) {
        new SelfInstallDashboard(driver)
                .validateDashboardCase1();

    }
    @Test(description = "GC02- Verify the dashboard in case of a self installed device user, don’t booked a provider change & has a router from vodafone (kabel 500)")
    @TmsLink("WFFT-4067")
    public void GC02(Method method) {
        new SelfInstallDashboard(driver)
                  .validateDashboardCase2();
    }
    @Test(description = "GC03- Verify the dashboard in case of a self installed device user, booked a provider change & has a own router (Red business internet & Phone 100)")
    @TmsLink("WFFT-4068")
    public void GC03(Method methoad) {
        new SelfInstallDashboard(driver)
                .validateDashboardCase3();
    }
    @Test(description = "GC04- Verify the dashboard in case of a self installed device user, don’t booked a provider change & has a own route (Red business internet 1000)")
    @TmsLink("WFFT-4069")
    public void GC04(Method methoad) {
        new SelfInstallDashboard(driver)
                .validateDashboardCase4();
    }
    @Test(description = "GC05- Verify self install start-portal dashboard when there is an error in the page")
    @TmsLink("WFFT-4100")
    public void GC05(Method methoad) {
        new SelfInstallDashboard(driver)
                .validateDashboardCase5();
    }

}
*/