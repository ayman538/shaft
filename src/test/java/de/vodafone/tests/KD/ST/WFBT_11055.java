package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.KabelTVPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("KD")
@Feature("ST")
@Story("WFBT-11055")
public class WFBT_11055 extends ST_KDSetup{

    @TmsLink("WFBT_11091")
    @Test(description = "WFBT_11091 || GC01 Check that static card exists when no bookable options")
    public void GC01_UserCheckThatStaticCardExistsWhenNoBookableOptions(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion()
                .navigateToKabelTVPage();
        new KabelTVPage(driver).checkInternetAndPhoneButtonExist()
                .validateKabelTVTitle(testData.getTestData(method.getName() + ".KabelTVTitleCL"))
                .validateBookableOptionSO()
                .expandBookableOptionAccordion()
                .validateBookableOptionAccordionCard();
    }
}