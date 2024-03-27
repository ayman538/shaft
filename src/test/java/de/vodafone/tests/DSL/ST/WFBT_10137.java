package de.vodafone.tests.DSL.ST;

import de.vodafone.pages.DSL.DSL_Dashboard;
import de.vodafone.pages.DSL.MyDSLProducts;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("DSL")
@Feature("ST")
@Story("WFBT-10137")
public class WFBT_10137 extends ST_DSLSetup {

    @TmsLink("WFBT-10260")
    @Test(description = "GC02 | WFBT-10137 | Check all booked TV options exist in booked options accordion")
    public void GC01() {
        new DSL_Dashboard(driver).chooseMyProductsFromMyProductsAcc();
        new MyDSLProducts(driver).assertOnVodafoneTVSO()
                .expandBookedOptionsAccordion()
                .validateBookedOptionsAccordionBody()
                .assertOnAllBookedOptions();
    }

    @TmsLink("WFBT-10261")
    @Test(description = "GC03 | WFBT-10137 | Check all booked options for TV and Voice")
    public void GC02(Method method) {
        new DSL_Dashboard(driver).chooseMyProductsFromMyProductsAcc();
        new MyDSLProducts(driver).expandBookedOptionsAccordion().validateTVBookedOptions(
                testData.getTestData(method.getName() + ".bookedOptionTV1"),
                testData.getTestData(method.getName() + ".bookedOptionTV2"))
                .validateVoiceBookedOptions(testData.getTestData(method.getName() + ".bookedOptionVoice1"));
    }
}