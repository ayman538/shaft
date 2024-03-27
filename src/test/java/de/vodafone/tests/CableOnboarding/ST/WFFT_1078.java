/*
package de.vodafone.tests.CableOnboarding.ST;

import com.shaft.validation.Validations;
import de.vodafone.pages.CableOnboarding.TechInstallDashboard;
import de.vodafone.pages.CableOnboarding.TechInstall_KnowMorePage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


@Epic("Cable Onboarding")
@Feature("ST")
public class WFFT_1078 extends CableOnboardingSTSetup {

    @Test(description="GC02 - User click on back link in know more screen")
    @TmsLink("WFFT-1293")
        private void Techinstallinstallanknowmorescreen(Method method) {
            new TechInstallDashboard(driver).Clickinstallationbtn();
            Validations.assertThat()
                    .browser(driver.getDriver())
                    .url()
                    .isEqualTo(testData.getTestData(method.getName()+".Knowmorepage_url"))
                    .perform();
            new TechInstall_KnowMorePage(driver).Clickonbacklink();
            Validations.assertThat()
                    .browser(driver.getDriver())
                    .url()
                    .isEqualTo(testData.getTestData(method.getName()+".Techinstalldashboard_url"))
                    .perform();
        }
    @Test(description="GC03 - User click on link in know more screen")
    @TmsLink("WFFT-1294")
        private void Technstallmoreinfolink(Method method) {
            new TechInstallDashboard(driver).Clickinstallationbtn();
            Validations.assertThat()
                    .browser(driver.getDriver())
                    .url()
                    .isEqualTo(testData.getTestData(method.getName()+".Knowmorepage_url"))
                    .perform();
            new TechInstall_KnowMorePage(driver).ClickOnMoreInfolink();
            Validations.assertThat()
                    .browser(driver.getDriver())
                    .url()
                    .isEqualTo(testData.getTestData(method.getName()+".Moreinfopage_url"))
                    .perform();
        }
    }
 */