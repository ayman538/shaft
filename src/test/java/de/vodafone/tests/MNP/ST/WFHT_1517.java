package de.vodafone.tests.MNP.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.MNP.*;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("MNP")
@Feature("ST")
@Story("WFHT-1517")
public class WFHT_1517 extends ST_MNP_Setup{
    private String deeplink;

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        deeplink = testData.getTestData(method.getName() + ".deeplink");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(method.getName());
        driver= new SHAFT.GUI.WebDriver();

        new de.vodafone.pages.commons.LoginPage(driver).
                navigateST().
                acceptCookies().
                setCookieSwitchers(cookieSwitcherMap);
    }

    @TmsLink("WFHT-1548")
    @Test(description = "GC01- Check React Routing with lazy loading for Status flow.")
    public void GC01() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .verifyStatusRedirection();
    }

    @TmsLink("WFHT-1549")
    @Test(description = "GC02- Check React Routing with lazy loading for Previous Provider flow.")
    public void GC02() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .verifyPreviousProviderRedirection();
    }

    @TmsLink("WFHT-1550")
    @Test(description = "GC03- Check React Routing with lazy loading for Start page.")
    public void GC03() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .verifyStartPageRedirection();
    }

    @TmsLink("WFHT-1551")
    @Test(description = "GC04- Check React Routing with lazy loading for With Porting flow.")
    public void GC04() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .verifyPortingWithDocsRedirection();
    }

    @TmsLink("WFHT-1552")
    @Test(description = "GC05- Check React Routing with lazy loading for Without Porting flow.")
    public void GC05() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .verifyPortingWithOutDocsRedirection();
    }
}








