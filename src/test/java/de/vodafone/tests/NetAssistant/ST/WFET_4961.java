package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.commons.NavigationPage;
import de.vodafone.pages.NetAssistant.TicketsPage;
import de.vodafone.pages.NetAssistant.TrackMyTechiePage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_4961")
public class WFET_4961 extends STNetAssistantSetup {
    //Variables
    private String ticketsLink;
    private String userName;
    private String userPassword;
    private String phoneNumber;
    private HashMap<String,String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        ticketsLink = testData.getTestData(method.getName() + ".Link");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        phoneNumber = testData.getTestData(method.getName() + ".phoneNumber");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap,userName,userPassword);
    }


    /*
    @Test(description = "ST-GC02 - Cable | Using deeplink verify that technician details includes the technician phone number")
    @TmsLink("WFET-5267")
    private void ST_GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoButton()
                .clickOn(TicketsPage.track_My_Techie_Button);

        new TrackMyTechiePage(driver)
                .validatePhoneDetailsCL()
                .validatePhoneIconExists()
                .validatePhoneNumberExists(phoneNumber);
    }
    */

    /*
    @Test(description = "ST-GC05 - UM | Using deeplink verify that technician details includes the technician phone number")
    @TmsLink("WFET-5270")
    private void ST_GC05() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoButton()
                .clickOn(TicketsPage.track_My_Techie_Button);

        new TrackMyTechiePage(driver)
                .validatePhoneDetailsCL()
                .validatePhoneIconExists()
                .validatePhoneNumberExists(phoneNumber);
    }
    */

    @Test(description = "ST-GC08 - Cable | Using token deeplink verify that technician details includes the technician phone number")
    @TmsLink("WFET-5273")
    private void ST_GC08() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TrackMyTechiePage(driver)
                .validatePhoneDetailsCL()
                .validatePhoneIconExists()
                .validatePhoneNumberExists(phoneNumber);

    }

    @Test(description = "ST-GC11 - UM | Using token deeplink - Verify that technician details includes the technician phone number")
    @TmsLink("WFET-5276")
    private void ST_GC11() throws InterruptedException {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TrackMyTechiePage(driver)
                .validatePhoneDetailsCL()
                .validatePhoneIconExists()
                .validatePhoneNumberExists(phoneNumber);
    }


}