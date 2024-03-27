/*
package de.vodafone.tests.CableOnboarding.ST;

import com.shaft.validation.Validations;
import de.vodafone.pages.CableOnboarding.TechInstallDashboard;
import de.vodafone.pages.CableOnboarding.TechInstall_RouterInstallationPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Cable Onboarding")
@Feature("ST")
public class WFFT_1091 extends CableOnboardingSTSetup {

    @Test(description="GC01 - User check info in router installation page when device name is vodafone station.")
    @TmsLink("WFFT-1300")
    private void GC01(Method method) {

        new TechInstallDashboard(driver)
                .clickOnFourthTile();

        Validations.assertThat()
                .element(driver.getDriver(), TechInstall_RouterInstallationPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".header"))
                .withCustomReportMessage("Check Header Title")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TechInstall_RouterInstallationPage.deviceInfo_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".deviceInfo"))
                .withCustomReportMessage("Check Device Info Text")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TechInstall_RouterInstallationPage.deviceHelp_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".devicehelpbtn"))
                .withCustomReportMessage("Check Device Help Button Cl")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TechInstall_RouterInstallationPage.videoHelp_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".videohelpbtn"))
                .withCustomReportMessage("Check Video Help Button Cl")
                .perform();
        int NoOfTabsOpened = new TechInstall_RouterInstallationPage(driver).getNumberOfOpennedTabs();
        new TechInstall_RouterInstallationPage(driver).clickOnDeviceHelpButton();
        int NoOfTabsOpenedAfterClick = new TechInstall_RouterInstallationPage(driver).getNumberOfOpennedTabs();
        Validations.assertThat()
                .number(NoOfTabsOpenedAfterClick)
                .isEqualTo(NoOfTabsOpened+1);
        //System.out.println(NoOfTabsOpened+".....=="+NoOfTabsOpenedAfterClick);
        new TechInstall_RouterInstallationPage(driver).SwithToParentWindow();
        NoOfTabsOpened = new TechInstall_RouterInstallationPage(driver).getNumberOfOpennedTabs();
        new TechInstall_RouterInstallationPage(driver).clickOnVideoHelpButton();
        NoOfTabsOpenedAfterClick = new TechInstall_RouterInstallationPage(driver).getNumberOfOpennedTabs();
        //System.out.println(NoOfTabsOpened+".....22"+NoOfTabsOpenedAfterClick);
        Validations.assertThat()
                .number(NoOfTabsOpenedAfterClick)
                .isEqualTo(NoOfTabsOpened+1);
    }

    @Test(description="GC02 - User click on buttons in router installation page when device name is HomeBox FRITZ!Box 6591.")
    @TmsLink("WFFT-1301")
    private void GC02(Method method) {

        new TechInstallDashboard(driver)
                .clickOnFourthTile();

        Validations.assertThat()
                .element(driver.getDriver(), TechInstall_RouterInstallationPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".header"))
                .withCustomReportMessage("Check Header Title")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TechInstall_RouterInstallationPage.deviceInfo_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".deviceInfo"))
                .withCustomReportMessage("Check Device Info Text")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TechInstall_RouterInstallationPage.deviceHelp_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".devicehelpbtn"))
                .withCustomReportMessage("Check Device Help Button Cl")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TechInstall_RouterInstallationPage.videoHelp_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".videohelpbtn"))
                .withCustomReportMessage("Check Video Help Button Cl")
                .perform();
        int NoOfTabsOpened = new TechInstall_RouterInstallationPage(driver).getNumberOfOpennedTabs();
        new TechInstall_RouterInstallationPage(driver).clickOnDeviceHelpButton();
        int NoOfTabsOpenedAfterClick = new TechInstall_RouterInstallationPage(driver).getNumberOfOpennedTabs();
        Validations.assertThat()
                .number(NoOfTabsOpenedAfterClick)
                .isEqualTo(NoOfTabsOpened+1);
        System.out.println(NoOfTabsOpened+".....=="+NoOfTabsOpenedAfterClick);
        new TechInstall_RouterInstallationPage(driver).SwithToParentWindow();
        NoOfTabsOpened = new TechInstall_RouterInstallationPage(driver).getNumberOfOpennedTabs();
        new TechInstall_RouterInstallationPage(driver).clickOnVideoHelpButton();
        NoOfTabsOpenedAfterClick = new TechInstall_RouterInstallationPage(driver).getNumberOfOpennedTabs();
        System.out.println(NoOfTabsOpened+".....++"+NoOfTabsOpenedAfterClick);
        Validations.assertThat()
                .number(NoOfTabsOpenedAfterClick)
                .isEqualTo(NoOfTabsOpened+1);
    }

        }

*/