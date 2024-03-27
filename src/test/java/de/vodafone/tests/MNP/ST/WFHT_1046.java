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
@Story("WFHT-1046")
public class WFHT_1046 extends ST_MNP_Setup{
    private String deeplink;
    private String contactNumber;
    private String phoneNumber;
    private String provider;
    private String vorname;
    private String nachname;
    private String geburtsdatum;
    private String firmenname;
    private String kundnennummer;
    private String previousCompanyCode;
    private String email;
    private String repeatEmail;

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
        previousCompanyCode = testData.getTestData(method.getName() + ".previousCompanyCode");
        email = testData.getTestData(method.getName() + ".email");
        repeatEmail = testData.getTestData(method.getName() + ".repeatEmail");

        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(method.getName());
        driver= new SHAFT.GUI.WebDriver();

        new de.vodafone.pages.commons.LoginPage(driver).
                navigateST().
                acceptCookies().
                setCookieSwitchers(cookieSwitcherMap);
    }

    @TmsLink("WFHT-1189")
    @Test(description = "GC01 - Logged in Vodafone User - Step 3 - Verify Title, filling valid email and matching Repeated email address")
    public void GC01() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getCurrentDateFormatted(),getCurrentDateFormatted())
                .clickNextStepButton()
                .clickNextStepButton2()
                .fillStep3ValidEmailAddress(email)
                .fillStep3ValidRepeatEmailAddress(repeatEmail)
                .validateStep3HeaderCL()
                .validateStep3SubHeaderCL()
                .validateMandatoryTextInStep3();

    }

    @TmsLink("WFHT-1190")
    @Test(description = "GC02 - Logged in Vodafone User - Step 3 - Verify filling valid email and mismatching Repeated email address")
    public void GC02() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getCurrentDateFormatted(),getCurrentDateFormatted())
                .clickNextStepButton()
                .clickNextStepButton2()
                .fillStep3ValidEmailAddress(email)
                .fillStep3InvalidRepeatEmailAddress(repeatEmail)
                .clickNextStepButton3()
                .validateMismatchingError();
    }

    @TmsLink("WFHT-1192")
    @Test(description = "GC03 - Logged in Vodafone User - Step 3 - Verify filling invalid email and valid Repeated email address")
    public void GC03() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getCurrentDateFormatted(),getCurrentDateFormatted())
                .clickNextStepButton()
                .clickNextStepButton2()
                .fillStep3InvalidEmailAddress(email)
                .clickNextStepButton3()
                .validateInvalidEmailErrorEmailAddress()
                .fillStep3ValidRepeatEmailAddress(repeatEmail)
                .clickNextStepButton3()
                .validateMismatchingError();

    }

    @TmsLink("WFHT-1193")
    @Test(description = "GC04 - Logged in Vodafone User - Step 3 - Verify filling invalid email and invalid Repeated email address")
    public void GC04() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getCurrentDateFormatted(),getCurrentDateFormatted())
                .clickNextStepButton()
                .clickNextStepButton2()
                .fillStep3InvalidEmailAddress(email)
                .clickNextStepButton3()
                .validateInvalidEmailErrorEmailAddress()
                .fillStep3InvalidRepeatEmailAddress(repeatEmail)
                .clickNextStepButton3()
                .validateInvalidEmailErrorRepeatEmailAddress();
    }

    @TmsLink("WFHT-1194")
    @Test(description = "GC05 - Logged in Vodafone User - Step 3 - Verify email and Repeated email are mandatory fields")
    public void GC05() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getCurrentDateFormatted(),getCurrentDateFormatted())
                .clickNextStepButton()
                .clickNextStepButton2()
                .clickNextStepButton3()
                .fillStep3ValidRepeatEmailAddress(repeatEmail)
                .clickNextStepButton3()
                .validateMandatoryErrorEmailAddress()
                .fillStep3ValidEmailAddress(email)
                .clearRepeatEmailAddress()
                .clickNextStepButton3()
                .validateMandatoryErrorRepeatEmailAddress();
    }

    @TmsLink("WFHT-1195")
    @Test(description = "GC06 - Logged in Vodafone User - Step 3 - Verify Cancel button behavior")
    public void GC06() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getCurrentDateFormatted(),getCurrentDateFormatted())
                .clickNextStepButton()
                .clickNextStepButton2()
                .fillStep3ValidEmailAddress(email)
                .fillStep3ValidRepeatEmailAddress(repeatEmail)
                .clickCancelButton1();

        new StartPage(driver)
                .verifyCancelButtonBehaviour();
    }

    @TmsLink("WFHT-1196")
    @Test(description = "GC07 - Logged in Vodafone User - Step 3 - Verify Next button behavior")
    public void GC07() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getCurrentDateFormatted(),getCurrentDateFormatted())
                .clickNextStepButton()
                .clickNextStepButton2()
                .fillStep3ValidEmailAddress(email)
                .fillStep3ValidRepeatEmailAddress(repeatEmail)
                .clickNextStepButton3()
                .validateStep4HeaderCL();
    }
}








