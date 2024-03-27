package de.vodafone.tests.DSLOnboarding.SIT;

import de.vodafone.pages.DSLOnboarding.DashboardPage;
import de.vodafone.pages.DSLOnboarding.FirstStepPage;
import de.vodafone.pages.DSLOnboarding.SecondStepPage;
import de.vodafone.pages.DSLOnboarding.ThirdStepPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("DSL Onboarding")
@Feature("SIT")
public class WFFT_2576 extends DSLOnboardingSITSetup {

        @Test(description = "GC01 - Verify that Input field first name and the First Name text deleted in second step")
        @TmsLink("WFFT-2626")
        private void GC01(Method method) {
                new DashboardPage(driver).validateDSLOnboardingPage(testData.getTestData(method.getName() + ".dashboardHeaderText"),
                        testData.getTestData(method.getName() + ".dashboardButtonText"));
                new DashboardPage(driver).clickOnGetStartedButton();
                new FirstStepPage(driver).validateFirstStepPageHeadline(testData.getTestData(method.getName() + ".firstStepHeaderText"))
                        .selectDate().clickOnWeiterButton();
                new SecondStepPage(driver).validateFirstNameDeletedInSecondStepPage(testData.getTestData(method.getName() + ".secondStepHeaderText"));
        }

        @Test(description = "GC02 - Verify that the First Name input deleted in Third step")
        @TmsLink("WFFT-2627")
        private void GC02(Method method) {
                new DashboardPage(driver).validateDSLOnboardingPage(testData.getTestData(method.getName() + ".dashboardHeaderText"),
                        testData.getTestData(method.getName() + ".dashboardButtonText"));
                new DashboardPage(driver).clickOnGetStartedButton();
                new FirstStepPage(driver).validateFirstStepPageHeadline(testData.getTestData(method.getName() + ".firstStepHeaderText"))
                        .selectDate().clickOnWeiterButton();
                new SecondStepPage(driver).clickOnWeiterButton();
                new ThirdStepPage(driver).validateFirstNameDeletedInThirdStepPage(testData.getTestData(method.getName() + ".thirdStepHeaderText"));
        }
}