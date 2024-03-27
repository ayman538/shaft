package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.RateTechnicianPage;
import de.vodafone.pages.NetAssistant.TicketsPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_4417")


public class WFET_4417 extends STNetAssistantSetup {
    //Variables

    private String TokenLink;
    private HashMap<String,String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {

        TokenLink = testData.getTestData(method.getName() + ".link");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap);

    }

    @TmsLink("WFET-5127")
    @Test (description = "ST01 - Cable user -Deeplink Rate technician using tokenlink- Verify rating technician appointment page when navigate to it for first time")
    private void ST_GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(TokenLink);

        new RateTechnicianPage(driver)
                .verifyRatePageDisplayed()
                .verifyImageofRatePage()
                .verifyNameofTechnician()
                .verifyTicketNoOfTechnician()
                .validateTheHeaderOfRatePage()
                .validateTheTextOfRatePage()
                .validateTheFeedbackBox()
                .verifyTheFiveRateBox()
                .verifyRateBoxOneClickable();
    }



    @TmsLink("WFET-5128")
    @Test(description="ST02 - Cable user -Deeplink Rate technician using tokenlink- Verify rating technician appointment page while submitting rate for first time")
    private void ST_GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(TokenLink);

        new RateTechnicianPage(driver)
                .verifyRatePageDisplayed()
                .EnterDataAtFeedbackBox("hadeeeeeeeeeertesssssssssstttttttttt")
                .clickOn(RateTechnicianPage.getRateBoxThree())
                .clickOn(RateTechnicianPage.getSubmitRateBtn())
                .verifyRateIsDonePage();
    }

    @TmsLink("WFET-5129")
    @Test(description="ST03 - Cable user -Deeplink Rate technician using tokenlink- Verify rating technician appointment page after submit rate and redirect to it again")
    private void ST_GC03() {

        new NavigationPage(driver)
                .navigateInNewTab(TokenLink);

        new RateTechnicianPage(driver)
                .verifyAlreadyRatedBeforePage()
                .verifyTicketDetailsBtn();
    }


    @TmsLink("WFET-5130")
    @Test(description="ST04- Cable user -Deeplink Rate technician using tokenlink-Check navigation when click on \"ticket details\" button at rate technician page")
    private void ST_GC04() {

        new NavigationPage(driver)
                .navigateInNewTab(TokenLink);

        new RateTechnicianPage(driver)
                .verifyRateIsDonePage()
                .verifyTicketDetailsBtn()
                .clickOn(RateTechnicianPage.getTicketDetialsBtn());

        new TicketsPage(driver)
                .verifyTicketDetailsPage();

    }


    @TmsLink("WFET-5234")
    @Test(description="ST8- Cable user -Deeplink Rate technician using tokenlink-Verify Tobi image displayed when no image returned")
    private void ST_GC08() {

        new NavigationPage(driver)
                .navigateInNewTab(TokenLink);

        new RateTechnicianPage(driver)
                .verifyRatePageDisplayed()
                .verifyTobiImageDisplayed();
    }
}