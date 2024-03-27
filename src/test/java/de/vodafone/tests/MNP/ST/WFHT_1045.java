package de.vodafone.tests.MNP.ST;

import com.shaft.driver.SHAFT;
import de.vodafone.pages.MNP.*;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

import static de.vodafone.pages.commons.UtilitiesPage.*;

@Epic("MNP")
@Feature("ST")
@Story("WFHT-1045")
public class WFHT_1045 extends ST_MNP_Setup {
    private String deeplink;
    private String contactNumber;
    private String phoneNumber;
    private String provider;
    private String vorname;
    private String nachname;
    private String geburtsdatum;
    private String firmenname;
    private String kundnennummer;

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        deeplink = testData.getTestData(method.getName() + ".deeplink");
        contactNumber = testData.getTestData(method.getName() + ".contactNumber");
        phoneNumber = testData.getTestData(method.getName() + ".phoneNumber");
        provider = testData.getTestData(method.getName() + ".provider");
        vorname = testData.getTestData(method.getName() + ".vorname");
        nachname = testData.getTestData(method.getName() + ".nachname");
        geburtsdatum = testData.getTestData(method.getName() + ".geburtsdatum");
        firmenname = testData.getTestData(method.getName() + ".firmenname");
        kundnennummer = testData.getTestData(method.getName() + ".kundnennummer");

        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(method.getName());
        driver= new SHAFT.GUI.WebDriver();

        new de.vodafone.pages.commons.LoginPage(driver)
                .navigateST()
                .acceptCookies()
                .setCookieSwitchers(cookieSwitcherMap);
    }

    @TmsLink("WFHT-1177")
    @Test(description = "GC01 - Logged In Vodafone User - Step 2 - Verify that contract End Date and Opt In Date are not filled")
    public void GC01() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,"","")
                .clickNextStepButton()
                .verifyStep2FailureAllEmpty()
                .verifyWeiterButtonDisabled();
    }

    @TmsLink("WFHT-1225")
    @Test(description = "GC02 - Logged In Vodafone User - Step 2 - Verify that contract end date is not filled in and Valid Opt In date filled and As Soon As Possible")
    public void GC02() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Geschäftskunde(phoneNumber,provider,firmenname,kundnennummer,"",getFutureDateFormatted(1))
                .clickNextStepButton()
                .fillStep2AsSoonAsPossible()
                .verifyStep2SuccessMessageAsSoonAsPossiblePart1();
    }

    @TmsLink("WFHT-1226")
    @Test(description = "GC03 - Logged In Vodafone User - Step 2 - Verify that contract end date is not filled in and Valid Opt In date filled in and At End of Contract")
    public void GC03() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,"",getFutureDateFormatted(1))
                .clickNextStepButton()
                .fillStep2AtEndOfContract()
                .verifyStep2Failure2WithoutContractEndDate()
                .verifyWeiterButtonDisabled();
    }

    @TmsLink("WFHT-1178")
    @Test(description = "GC04 - Logged In Vodafone User - Step 2 - Verify that contract has ended more than 90 Days ago")
    public void GC04() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getPastDateFormatted(91),getCurrentDateFormatted())
                .clickNextStepButton()
                .verifyStep2FailureMoreThan90Days()
                .verifyWeiterButtonDisabled();
    }

    @TmsLink("WFHT-1179")
    @Test(description = "GC05 - Logged In Vodafone User - Step 2 - Verify that contract will end in more than 123 Days in Future and Invalid/Empty Opt In date filled")
    public void GC05() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getFutureDateFormatted(124),"")
                .clickNextStepButton()
                .verifyStep2Failure4OptInDate()
                .verifyWeiterButtonDisabled();
    }

    @TmsLink("WFHT-1180")
    @Test(description = "GC06 - Logged In Vodafone User - Step 2 - Verify that contract will end in more than 123 Days ago and Valid Opt In Date filled and As Soon as Possible")
    public void GC06() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getFutureDateFormatted(124),getFutureDateFormatted(1))
                .clickNextStepButton()
                .fillStep2AsSoonAsPossible()
                .verifyStep2SuccessMessageAsSoonAsPossiblePart1();

    }

    @TmsLink("WFHT-1181")
    @Test(description = "GC07 - Logged In Vodafone User - Step 2 - Verify that contract will end in more than 123 Days ago and Valid Opt In Date filled and At End of Contract")
    public void GC07() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getFutureDateFormatted(124),getFutureDateFormatted(1))
                .clickNextStepButton()
                .fillStep2AtEndOfContract()
                .verifyStep2FailureFourMonthsInFuture()
                .verifyWeiterButtonDisabled();
    }

    @TmsLink("WFHT-1182")
    @Test(description = "GC08 - Logged In Vodafone User - Step 2 - Verify that contract will end in less than 90 days ago or 8 days in future")
    public void GC08() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getPastDateFormatted(89),getCurrentDateFormatted())
                .clickNextStepButton()
                .verifyStep2SuccessMessage3();

        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getFutureDateFormatted(8),getCurrentDateFormatted())
                .clickNextStepButton()
                .verifyStep2SuccessMessage3();
    }

    @TmsLink("WFHT-1183")
    @Test(description = "GC09 - Logged In Vodafone User - Step 2 - Verify that contract will end in less than 123 Days in Future and more than 8 days and As Soon as Possible")
    public void GC09() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getFutureDateFormatted(122),getFutureDateFormatted(9))
                .clickNextStepButton()
                .fillStep2AsSoonAsPossible()
                .verifyStep2SuccessMessageAsSoonAsPossiblePart1();
    }

    @TmsLink("WFHT-1184")
    @Test(description = "GC10 - Logged In Vodafone User - Step 2 - Verify that contract will end in less than 123 Days in Future and more than 8 days and At End of Contract")
    public void GC10() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getFutureDateFormatted(122),getFutureDateFormatted(9))
                .clickNextStepButton()
                .fillStep2AtEndOfContract()
                .verifyStep2SuccessMessageAtEndOfContract();
    }

    @TmsLink("WFHT-1185")
    @Test(description = "GC11 - Logged In Vodafone User - Step 2 - Verify Cancel Behaviour")
    public void GC11() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getCurrentDateFormatted(),getCurrentDateFormatted())
                .clickNextStepButton()
                .clickCancelButton1();

        new StartPage(driver)
                .verifyCancelButtonBehaviour();
    }

    @TmsLink("WFHT-1188")
    @Test(description = "BC01 - Logged in Vodafone User - Step 2 - Verify Service Failure")
    public void BC01() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getCurrentDateFormatted(),getCurrentDateFormatted())
                .clickNextStepButton()
                .verifyServiceFailureMessage1();
    }
}







