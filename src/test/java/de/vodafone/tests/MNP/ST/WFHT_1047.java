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
@Story("WFHT-1047")
public class WFHT_1047 extends ST_MNP_Setup{
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

    @TmsLink("WFHT-1199")
    @Test(description = "GC01 - Logged In Vodafone User - Step 4 - Verify Notification message")
    public void GC01() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getCurrentDateFormatted(),getCurrentDateFormatted())
                .clickNextStepButton()
                .clickNextStepButton2()
                .fillStep3Valid(email,repeatEmail)
                .clickNextStepButton3()
                .validateInformationMessage4CL();

    }

    @TmsLink("WFHT-1200")
    @Test(description = "GC02 - Logged In Vodafone User - Step 4 - Verify Contract dates and Termination info (Contract cancellation date , Opt in validity date 'If existed' and Time of number portability)")
    public void GC02() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getCurrentDateFormatted(),getCurrentDateFormatted())
                .clickNextStepButton()
                .clickNextStepButton2()
                .fillStep3Valid(email,repeatEmail)
                .clickNextStepButton3()
                .validateContractEndDate()
                .validateOptInValidityDate(getCurrentDateFormatted())
                .validateTimeOfNumberPortabilityAtEndOfContract();
    }

    @TmsLink("WFHT-1201")
    @Test(description = "GC03- Logged In Vodafone User - Step 4 - Verify Personal Data with previous provider if Contract type is private ( First name, Last name and Date of birth )")
    public void GC03() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,getCurrentDateFormatted(),getCurrentDateFormatted(),getCurrentDateFormatted())
                .clickNextStepButton()
                .clickNextStepButton2()
                .fillStep3Valid(email,repeatEmail)
                .clickNextStepButton3()
                .validateFirstName(vorname)
                .validateLastName(nachname)
                .validateDateOfBirth(getCurrentDateFormatted());
    }

    @TmsLink("WFHT-1202")
    @Test(description = "GC04- Logged In Vodafone User - Step 4 - Verify Personal Data with previous provider if Contract type is business (Company name and Customer number)")
    public void GC04() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Geschäftskunde(phoneNumber,provider,firmenname,kundnennummer,getCurrentDateFormatted(),getCurrentDateFormatted())
                .clickNextStepButton()
                .clickNextStepButton2()
                .fillStep3Valid(email,repeatEmail)
                .clickNextStepButton3()
                .validateCompanyName(firmenname)
                .validateCustomerNumber(kundnennummer);
    }

    @TmsLink("WFHT-1204")
    @Test(description = "GC06- Logged In Vodafone User - Step 4 - Verify Email address")
    public void GC06() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getCurrentDateFormatted(),getCurrentDateFormatted())
                .clickNextStepButton()
                .clickNextStepButton2()
                .fillStep3Valid(email,repeatEmail)
                .clickNextStepButton3()
                .validateEmailAddress(email);
    }

    @TmsLink("WFHT-1205")
    @Test(description = "GC07- Logged In Vodafone User - Step 4 - Verify that the checkboxs are checkable")
    public void GC07() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getCurrentDateFormatted(),getCurrentDateFormatted())
                .clickNextStepButton()
                .clickNextStepButton2()
                .fillStep3Valid(email,repeatEmail)
                .clickNextStepButton3()
                .validateCheckBoxesChecked();
    }

    @TmsLink("WFHT-1206")
    @Test(description = "GC08- Logged In Vodafone User - Step 4 - Verify Warning message")
    public void GC08() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getCurrentDateFormatted(),getCurrentDateFormatted())
                .clickNextStepButton()
                .clickNextStepButton2()
                .fillStep3Valid(email,repeatEmail)
                .clickNextStepButton3()
                .validateWarningMessageCL();
    }

    @TmsLink("WFHT-1207")
    @Test(description = "GC09- Logged In Vodafone User - Step 4 - Verify that the user is redirected to login page after clicking Cancel button")
    public void GC09() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getCurrentDateFormatted(),getCurrentDateFormatted())
                .clickNextStepButton()
                .clickNextStepButton2()
                .fillStep3Valid(email,repeatEmail)
                .clickNextStepButton3()
                .clickCancelButton1()
                .verifyCancelButtonBehaviour();
    }

    @TmsLink("WFHT-1212")
    @Test(description = "BC01- Logged In Vodafone User - Step 4 - Verify that 'Order Now' button is dimmed if only one of the checkbox is checked")
    public void BC01() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getCurrentDateFormatted(),getCurrentDateFormatted())
                .clickNextStepButton()
                .clickNextStepButton2()
                .fillStep3Valid(email,repeatEmail)
                .clickNextStepButton3()
                .enableFirstCheckBoxOnly()
                .disableFirstCheckBoxOnly()
                .enableSecondCheckBoxOnly();
    }

    @TmsLink("WFHT-1213")
    @Test(description = "BC02- Logged In Vodafone User - Step 4 - Verify Service failure")
    public void BC02() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .fillStep1Privatkunde(phoneNumber,provider,vorname,nachname,geburtsdatum,getCurrentDateFormatted(),getCurrentDateFormatted())
                .clickNextStepButton()
                .clickNextStepButton2()
                .fillStep3Valid(email,repeatEmail)
                .clickNextStepButton3()
                .validateCheckBoxesChecked()
                .clickOrderNowButton()
                .verifyServiceFailureMessage2();
    }
}








