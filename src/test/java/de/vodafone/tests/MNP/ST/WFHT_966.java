package de.vodafone.tests.MNP.ST;

import com.shaft.driver.SHAFT;
import de.vodafone.pages.MNP.FormPage;
import de.vodafone.pages.MNP.LandingPage;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("MNP")
@Feature("ST")
@Story("WFHT-966")
public class WFHT_966 extends ST_MNP_Setup{
    private String phoneNumber;
    private String wrongPhoneNumber;
    private String deeplink;
    private String vorname;
    private String nachname;
    private String geburtsdatum;
    private String wrongFormatGeburtsdatum;
    private String firmenname;
    private String kundnennummer;

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        deeplink = testData.getTestData(method.getName() + ".deeplink");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(method.getName());
        phoneNumber = testData.getTestData(method.getName() + ".phoneNumber");
        wrongPhoneNumber = testData.getTestData(method.getName() + ".wrongPhoneNumber");
        vorname = testData.getTestData(method.getName() + ".vorname");
        nachname = testData.getTestData(method.getName() + ".nachname");
        geburtsdatum = testData.getTestData(method.getName() + ".geburtsdatum");
        wrongFormatGeburtsdatum = testData.getTestData(method.getName() + ".wrongFormatGeburtsdatum");
        firmenname = testData.getTestData(method.getName() + ".firmenname");
        kundnennummer = testData.getTestData(method.getName() + ".kundnennummer");

        driver= new SHAFT.GUI.WebDriver();

        new LoginPage(driver).
                navigateST().
                acceptCookies().
                setCookieSwitchers(cookieSwitcherMap);
    }

    @TmsLink("WFHT-1074")
    @Test(description = "GC01 - Vodafone logged in User - Validate number porting notification message CL.")
    public void GC01() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new FormPage(driver)
                .validateNotificationMsg();
    }

    @TmsLink("WFHT-1075")
    @Test(description = "GC02 - Vodafone logged in User - Validate MSISDN format.")
    public void GC02() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new FormPage(driver)
                .fillWRONGPhoneNumberField(wrongPhoneNumber)
                .fillPhoneNumberField(phoneNumber);
    }

    @TmsLink("WFHT-1076")
    @Test(description = "GC03 - Vodafone logged in User - Validate country codes dropdown menu.")
    public void GC03() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new FormPage(driver)
                .fillPhoneNumberField(phoneNumber)
                .choosePreviousCompanyCode();
    }

    @TmsLink("WFHT-1077")
    @Test(description = "GC04 - Vodafone logged in User - Validate customer type ( Private , Business ) radio button.")
    public void GC04() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new FormPage(driver)
                .fillPhoneNumberField(phoneNumber)
                .choosePreviousCompanyCode()
                .chooseCustomerTypeRadioButton();
    }

    @TmsLink("WFHT-1078")
    @Test(description = "GC05 - Vodafone Private logged in User - Validate that First name private costumer is mandatory field.")
    public void GC05() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new FormPage(driver)
                .fillPhoneNumberField(phoneNumber)
                .choosePreviousCompanyCode()
                .chooseCustomerTypeRadioButton()
                .fillCustomerFirstName(vorname)
                .leaveFirstNameEmpty()
                .clickOnWeiterCTA()
                .validateMandatoryErrorFirstName();
    }

    @TmsLink("WFHT-1066")
    @Test(description = "GC06 - Logged in new Vodafone User- Validate the info message for customer has \"Export booked\" status.")
    public void GC06() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new FormPage(driver)
                .fillPhoneNumberField(phoneNumber)
                .choosePreviousCompanyCode()
                .chooseCustomerTypeRadioButton()
                .fillCustomerFirstName(vorname)
                .fillCustomerLastName(nachname)
                .leaveLastNameEmpty()
                .clickOnWeiterCTA()
                .validateMandatoryErrorLastName();
    }

    @TmsLink("WFHT-1080")
    @Test(description = "GC07 - Vodafone Private logged in User - Validate that Birth date is mandatory field following DD.MM.YYYY format.")
    public void GC07(){
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new FormPage(driver)
                .fillPhoneNumberField(phoneNumber)
                .choosePreviousCompanyCode()
                .chooseCustomerTypeRadioButton()
                .fillCustomerFirstName(vorname)
                .fillCustomerLastName(nachname)
                .fillBirthdate(geburtsdatum)
                .fillWrongFormatBirthdate(wrongFormatGeburtsdatum)
                .validateMandatoryErrorBirthdate();
    }

    @TmsLink("WFHT-1081")
    @Test(description = "GC08 - Vodafone Business logged in User - Validate that Company name is mandatory field.")
    public void GC08() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new FormPage(driver)
                .fillPhoneNumberField(phoneNumber)
                .choosePreviousCompanyCode()
                .fillCompanyName(firmenname)
                .clearCompanyName()
                .clickOnWeiterCTA()
                .validateMandatoryErrorCompanyName();
    }

    @TmsLink("WFHT-1082")
    @Test(description = "GC09 - Vodafone Business logged in User - Validate that Customer number is mandatory field.")
    public void GC09() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new FormPage(driver)
                .fillPhoneNumberField(phoneNumber)
                .choosePreviousCompanyCode()
                .fillCompanyName(firmenname)
                .fillCustomerNumberField(phoneNumber)
                .fillWrongCustomerNumberField(wrongPhoneNumber)
                .clickOnWeiterCTA()
                .validateMandatoryErrorCustomerNumber();

    }

    @TmsLink("WFHT-1083")
    @Test(description = "GC10 - Vodafone Private logged in User - Validate End of contract info - Notification message to inform user about end date info.")
    public void GC10() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new FormPage(driver)
                .fillPhoneNumberField(phoneNumber)
                .choosePreviousCompanyCode()
                .chooseCustomerTypeRadioButton()
                .validateEndOfContractNotificationMsg();
    }

    @TmsLink("WFHT-1084")
    @Test(description = "GC11 - Vodafone Private logged in User - Validate End of contract info - End of contract date is optional, following DD.MM.YYYY format.")
    public void GC11() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new FormPage(driver)
                .fillPhoneNumberField(phoneNumber)
                .choosePreviousCompanyCode()
                .chooseCustomerTypeRadioButton()
                .fillCustomerFirstName(vorname)
                .fillCustomerLastName(nachname)
                .fillBirthdate(geburtsdatum)
                .fillEndOfContractDate(geburtsdatum);

    }
    @TmsLink("WFHT-1099")
    @Test(description = "GC12 - Vodafone Private logged in User - Validate End of contract info - Opt-in validity date: optional, following DD.MM.YYYY format.")
    public void GC12() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new FormPage(driver)
                .fillPhoneNumberField(phoneNumber)
                .choosePreviousCompanyCode()
                .chooseCustomerTypeRadioButton()
                .fillCustomerFirstName(vorname)
                .fillCustomerLastName(nachname)
                .fillBirthdate(geburtsdatum)
                .fillEndOfContractDate(geburtsdatum)
                .fillOptInDate(geburtsdatum);
    }
    @TmsLink("WFHT-1086")
    @Test(description = "GC13 - Vodafone Business logged in User - Validate End of contract info - Notification message to inform user about end date info.")
    public void GC13() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new FormPage(driver)
                .fillPhoneNumberField(phoneNumber)
                .choosePreviousCompanyCode()
                .chooseCustomerTypeRadioButton()
                .validateEndOfContractNotificationMsg_Business();
    }
    @TmsLink("WFHT-1086")
    @Test(description = "GC14 - Vodafone Business logged in User - Validate End of contract info - End of contract date is optional, following DD.MM.YYYY format.")
    public void GC14() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new FormPage(driver)
                .fillPhoneNumberField(phoneNumber)
                .choosePreviousCompanyCode()
                .fillCompanyName(firmenname)
                .fillCustomerNumberField(phoneNumber)
                .fillEndOfContractDate(geburtsdatum);
    }
    @TmsLink("WFHT-1087")
    @Test(description = "GC15 - Vodafone Business logged in User - Validate End of contract info - Opt-in validity date: optional, following DD.MM.YYYY format.")
    public void GC15() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new FormPage(driver)
                .fillPhoneNumberField(phoneNumber)
                .choosePreviousCompanyCode()
                .fillCompanyName(firmenname)
                .fillCustomerNumberField(phoneNumber)
                .fillEndOfContractDate(geburtsdatum)
                .fillOptInDate(geburtsdatum);

    }
    @TmsLink("WFHT-1089")
    @Test(description = "GC16 - Vodafone logged in User - Validate Weiter button to proceed with Step2.")
    public void GC16() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new FormPage(driver)
                .fillPhoneNumberField(phoneNumber)
                .choosePreviousCompanyCode()
                .chooseCustomerTypeRadioButton()
                .fillCustomerFirstName(vorname)
                .fillCustomerLastName(nachname)
                .fillBirthdate(geburtsdatum)
                .fillEndOfContractDate(geburtsdatum)
                .fillOptInDate(geburtsdatum)
                .clickOnWeiterCTA()
                .validateStep2();
    }
    @TmsLink("WFHT-1090")
    @Test(description = "GC17 - Vodafone logged in User - Validate Option for customer to proceed with MNP without documents.")
    public void GC17() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new FormPage(driver)
                .clickOnPortingWODocumentCTA();
    }
}







