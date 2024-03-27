package de.vodafone.tests.DSLOnboarding.SIT;

import de.vodafone.pages.DSLOnboarding.DashboardPage;
import de.vodafone.pages.DSLOnboarding.WidgetPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("DSL Onboarding")
@Feature("SIT")
@Story("WFGT-15")
public class WFGT_15 extends DSLOnboardingSITSetup {
    @Test(description ="GC02 | WFGT-290 | DSL user | Self Install | verify delivery status information and the parcel tracking ID is generated In case of one parcel with Parcel Tracking ID" )
    @TmsLink("WFGT-290")
    private void GC02(Method method){
        new DashboardPage(driver)
                .validateSectionExist(testData.getTestData(method.getName() + ".widgetHeader"), testData.getTestData(method.getName() + ".widgetButton"))
                .clickOnWidgetButton();
        new WidgetPage(driver)
                    .validateWidgetPageHeader(testData.getTestData(method.getName() + ".widgetHeader"));
        new WidgetPage(driver)
                    .validateWidgetPageFooter(testData.getTestData(method.getName() + ".widgetFooter"));
    }
    @Test(description ="GC06 | WFGT-294 | DSL USER |Tech Install |verify delivery status information In case of multiple parcel with one without Parcel Tracking ID(2 parcels with tracking Id will displayed and the one without tracking id it's section will not appear )" )
    @TmsLink("WFGT-294")
    private void GC06(Method method){
        new DashboardPage(driver)
                .validateSectionTwoParcelsExist(testData.getTestData(method.getName() + ".widgetHeader"), testData.getTestData(method.getName() + ".widgetButton"))
                .clickOnWidgetButton();
        new WidgetPage(driver)
                .validateWidgetPageHeader(testData.getTestData(method.getName() + ".widgetHeader"))
                .validateWidgetPageFooter(testData.getTestData(method.getName() + ".widgetFooter")).clickOnBackBrowser();
        new DashboardPage(driver)
                .clickOnSecondWidgetButton();
        new WidgetPage(driver)
                .validateWidgetPageHeader(testData.getTestData(method.getName() + ".widgetHeader"))
                .validateWidgetPageFooter(testData.getTestData(method.getName() + ".widgetFooter"));
    }
}


