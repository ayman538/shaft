package de.vodafone.tests.CableOnboarding.ST;


import de.vodafone.pages.CableOnboarding.TechInstallDashboard;
import de.vodafone.pages.CableOnboarding.WLAN_SetupPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Cable OnBoarding")
@Feature("ST")
@Story("Onboarding - Tech Install | VKD | Tech-install | WLAN Set-up Badge for Dashboard Tiles")
public class WFFT_4090 extends CableOnboardingSTSetup{
    @Test(description = "GC01-Verify the WLAN Set-up flow with yes-case with vodafone station router",enabled = false)
    @TmsLink("WFFT-4214")
    public void GC01(Method method){
    new TechInstallDashboard(driver).clickOnWLANSetUp();
    new WLAN_SetupPage(driver).verifyTheFirstPageOfTheFlow(testData.getTestData(method.getName() + ".headerText1"),
            testData.getTestData(method.getName() + ".subheaderText"),testData.getTestData(method.getName() + ".firstOption"),
            testData.getTestData(method.getName() + ".secondOption"),testData.getTestData(method.getName() + ".nextButton"),
            testData.getTestData(method.getName() + ".firstQuestion"),testData.getTestData(method.getName() + ".secondQuestion"),testData.getTestData(method.getName() + ".thirdQuestion")).selectFirstOption().clickOnTheNextBtn().
            verifyTheYesOptionPick(testData.getTestData(method.getName() + ".secondHeaderText"),testData.getTestData(method.getName() + ".instructionsButton"),
                    testData.getTestData(method.getName() + ".superConnectBtn"),testData.getTestData(method.getName() + ".connectYourDeviceText"),testData.getTestData(method.getName() + ".connectYourDeviceBtn"),
                    testData.getTestData(method.getName() + ".wifiSettingsText"),testData.getTestData(method.getName() + ".wifiSettingsBtn"),testData.getTestData(method.getName() + ".backBtn"));
    }
    @Test(description = "GC02-Verify the WLAN Set-up flow with yes-case with FRITZ!Box 6690 Cable router",enabled = false)
    @TmsLink("WFFT-4215")
    public void GC02(Method method){
        new TechInstallDashboard(driver).clickOnWLANSetUp();
        new WLAN_SetupPage(driver).verifyOtherOptionsPick(testData.getTestData(method.getName() + ".secondHeaderText"),testData.getTestData(method.getName() + ".instructionsButton")
                ,testData.getTestData(method.getName() + ".superConnectBtn"),
                testData.getTestData(method.getName() + ".wifiSettingsText"),testData.getTestData(method.getName() + ".wifiSettingsBtn"),testData.getTestData(method.getName() + ".backBtn"));
    }
    @Test(description = "GC03-Verify the WLAN Set-up flow with yes-case with FRITZ!Box 6660 Cable router",enabled = false)
    @TmsLink("WFFT-4216")
    public void GC03(Method method){
        new TechInstallDashboard(driver).clickOnWLANSetUp();
        new WLAN_SetupPage(driver).verifyOtherOptionsPick(testData.getTestData(method.getName() + ".secondHeaderText"),testData.getTestData(method.getName() + ".instructionsButton")
                ,testData.getTestData(method.getName() + ".superConnectBtn"),
                testData.getTestData(method.getName() + ".wifiSettingsText"),testData.getTestData(method.getName() + ".wifiSettingsBtn"),testData.getTestData(method.getName() + ".backBtn"));
    }
    @Test(description = "GC04-Verify the WLAN Set-up flow with No-case with vodafone station router",enabled = false)
    @TmsLink("WFFT-4217")
    public void GC04(Method method){
        new TechInstallDashboard(driver).clickOnWLANSetUp();
        new WLAN_SetupPage(driver).verifyTheFirstPageOfTheFlow(testData.getTestData(method.getName() + ".headerText1"),
                        testData.getTestData(method.getName() + ".subheaderText"),testData.getTestData(method.getName() + ".firstOption"),
                        testData.getTestData(method.getName() + ".secondOption"),testData.getTestData(method.getName() + ".nextButton"),
                        testData.getTestData(method.getName() + ".firstQuestion"),testData.getTestData(method.getName() + ".secondQuestion"),testData.getTestData(method.getName() + ".thirdQuestion")).selectSecondOption().clickOnTheNextBtn()
                .verifyOtherOptionsPick(testData.getTestData(method.getName() + ".secondHeaderText"),testData.getTestData(method.getName() + ".instructionsButton")
                        ,testData.getTestData(method.getName() + ".superConnectBtn"),
                        testData.getTestData(method.getName() + ".wifiSettingsText"),testData.getTestData(method.getName() + ".wifiSettingsBtn"),testData.getTestData(method.getName() + ".backBtn"));
    }


}
