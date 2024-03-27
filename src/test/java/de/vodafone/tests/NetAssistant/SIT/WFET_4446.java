package de.vodafone.tests.NetAssistant.SIT;

import de.vodafone.pages.NetAssistant.HelpPage;
import de.vodafone.pages.NetAssistant.TicketsPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("SIT")
public class WFET_4446 extends SITNetAssistantSetup {

    //Variables
    private String tickets_Deeplink;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        tickets_Deeplink = testData.getTestData(method.getName() + ".link");
        super.setup(method);

    }


    @Test(description = "SIT01 - DSL user -Navigate with Net Assistant Token Deeplink- Verify that general error page is displayed and CL is Updated in case of expired deeplink")
    @TmsLink("WFET-4366")
    private void SIT_GC01(){
        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink)
                .validateErrorMsgIconDisplayed()
                .validateErrorMsgTextMatch()
                .validateErrorMsgTextMatch2()
                .validateErrorMsgButtonDisplayed()
                .validateErrorMsgButtonTextMatch()
                .validateErrorMsgButtonVisible();
    }


    //Obsolete Old Business Scope
    /*
    @Test(description = "SIT02 - DSL user -Navigate with Net Assistant Token Deeplink- Verify that button in error page redirects to help form in case of expired Deeplink")
    @TmsLink("WFET-4368")
    private void SIT_GC02(){
        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink)
                .validateErrorMsgButtonDisplayed()
                .validateErrorMsgButtonTextMatch()
                .validateErrorMsgButtonVisible();

        new TicketsPage(driver)
                .navigate(tickets_Deeplink)
                .clickOn(TicketsPage.getErrorMsgButtonToken())
                .getCurruntURL();

        new HelpPage(driver)
                .validateErrorMsgButtonRedirection();
    }
     */
}
