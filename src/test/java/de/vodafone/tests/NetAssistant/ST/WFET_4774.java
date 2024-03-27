package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.RateTechnicianPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_4774")


public class WFET_4774 extends STNetAssistantSetup {
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

    @Test(description = "ST01 - Cable user -Deeplink Rate technician using tokenlink- Verify rating technician appointment page when service is down")
    @TmsLink("WFET-5151")
    private void ST_GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(TokenLink);

        new RateTechnicianPage(driver)
                .verifyServiceDownPageDisplayed()
                .validateServiceDownPageHeader()
                .validaServiceDownPageText();
    }

    @Test(description = "ST02 - Cable user -Deeplink Rate technician using tokenlink- Verify rating technician appointment page when token invalid")
    @TmsLink("WFET-5152")
    private void ST_GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(TokenLink);

        new RateTechnicianPage(driver)
                .verifyInvalidTokenErrorPageDisplayed()
                .validateInvalidTokenPageHeader()
                .validateInvalidTokenPageText()
                .verifyErrorButtonDisplayed();

    }

    @Test(description = "ST03 - Cable user -Deeplink Rate technician using tokenlink- Verify rating technician appointment page when token expired")
    @TmsLink("WFET-5153")
    private void ST_GC03() {

        new NavigationPage(driver)
                .navigateInNewTab(TokenLink);

        new RateTechnicianPage(driver)
                .verifyInvalidTokenErrorPageDisplayed()
                .validateInvalidTokenPageHeader()
                .validateInvalidTokenPageText()
                .verifyErrorButtonDisplayed();

    }


}