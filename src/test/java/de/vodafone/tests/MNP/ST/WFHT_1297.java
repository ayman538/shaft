package de.vodafone.tests.MNP.ST;

import com.shaft.driver.SHAFT;
import de.vodafone.pages.MNP.LandingPage;
import de.vodafone.pages.MNP.PortingWODocumentsPostpaidPage;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

import static de.vodafone.pages.commons.UtilitiesPage.getFutureDateFormatted;

@Epic("MNP")
@Feature("ST")
@Story("WFHT-1297")
public class WFHT_1297 extends ST_MNP_Setup{
    private String deeplink;
    private String contactNumber;
    private String contractType;
    private String vorname;
    private String nachname;
    private String geburtsdatum;
    private String phoneNumber;
    private String phoneNumber2;
    private String provider2;
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
        contractType = testData.getTestData(method.getName() + ".contractType");
        vorname = testData.getTestData(method.getName() + ".vorname");
        nachname = testData.getTestData(method.getName() + ".nachname");
        geburtsdatum = testData.getTestData(method.getName() + ".geburtsdatum");
        phoneNumber = testData.getTestData(method.getName() + ".phoneNumber");
        phoneNumber2 = testData.getTestData(method.getName() + ".phoneNumber2");
        provider2 = testData.getTestData(method.getName() + ".provider2");

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

    @TmsLink("WFHT-1489")
    @Test(description = "GC01 - Logged In Vodafone User - Step 4 - Verify Notification message")
    public void GC01() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getFutureDateFormatted(9))
                .clickOnWeiterButton4()
                .clickOnASARadioButton()
                .clickOnYesInformedRadioButton()
                .verifyStep2SuccessProviderInformedWithoutDocs()
                .clickNextStepButton5()
                .fillStep3PrivatkundeCheckBox()
                .fillStep3Privatkunde(vorname,nachname,geburtsdatum,phoneNumber,phoneNumber2,provider2)
                .clickNextStepButton6()
                .fillStep3ValidEmailAddressWithoutDocs(email)
                .fillStep3ValidRepeatEmailAddressWithoutDocs(repeatEmail)
                .clickNextStepButton7()
                .validateInformationMessage4CL();

    }

    @TmsLink("WFHT-1490")
    @Test(description = "GC02 - Logged In Vodafone User - Step 4 - Verify Previous contract & time of number portability ( previous contract type (Prepaid / Postpaid) , contract status (terminated/ not terminated))")
    public void GC02() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getFutureDateFormatted(9))
                .clickOnWeiterButton4()
                .clickOnASARadioButton()
                .clickOnYesInformedRadioButton()
                .verifyStep2SuccessProviderInformedWithoutDocs()
                .clickNextStepButton5()
                .fillStep3PrivatkundeCheckBox()
                .fillStep3Privatkunde(vorname,nachname,geburtsdatum,phoneNumber,phoneNumber2,provider2)
                .clickNextStepButton6()
                .fillStep3ValidEmailAddressWithoutDocs(email)
                .fillStep3ValidRepeatEmailAddressWithoutDocs(repeatEmail)
                .clickNextStepButton7()
                .validateContractType(contractType)
                .validateTimeOfNumberPortabilityAsSoonAsPossibleWithoutDocs();
    }

    @TmsLink("WFHT-1491")
    @Test(description = "GC03 - Logged In Vodafone User - Step 4 - Verify Previous contract & time of number portability ( In case of not terminated contract: warning message shall be displayed )")
    public void GC03() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnNoCancelledRadioButton()
                .clickOnWeiterButton2()
                .clickOnEOCRadioButton()
                .verifyStep2Failure2WithoutContractEndDateWithoutDocs();
    }

    @TmsLink("WFHT-1492")
    @Test(description = "GC04 - Logged In Vodafone User - Step 4 - Verify Previous contract & time of number portability ( Time of number portability (As Soon As Possible / At end of contract))")
    public void GC04() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getFutureDateFormatted(9))
                .clickOnWeiterButton4()
                .clickOnASARadioButton()
                .clickOnYesInformedRadioButton()
                .verifyStep2SuccessProviderInformedWithoutDocs()
                .clickNextStepButton5()
                .fillStep3PrivatkundeCheckBox()
                .fillStep3Privatkunde(vorname,nachname,geburtsdatum,phoneNumber,phoneNumber2,provider2)
                .clickNextStepButton6()
                .fillStep3ValidEmailAddressWithoutDocs(email)
                .fillStep3ValidRepeatEmailAddressWithoutDocs(repeatEmail)
                .clickNextStepButton7()
                .validateTimeOfNumberPortabilityAsSoonAsPossibleWithoutDocs();
    }

    @TmsLink("WFHT-1493")
    @Test(description = "GC05 - Logged In Vodafone User - Step 4 - Verify Personal Data with previous provider if Contract type is private ( First name, Last name and Date of birth )")
    public void GC05() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getFutureDateFormatted(9))
                .clickOnWeiterButton4()
                .clickOnASARadioButton()
                .clickOnYesInformedRadioButton()
                .verifyStep2SuccessProviderInformedWithoutDocs()
                .clickNextStepButton5()
                .fillStep3PrivatkundeCheckBox()
                .fillStep3Privatkunde(vorname,nachname,geburtsdatum,phoneNumber,phoneNumber2,provider2)
                .clickNextStepButton6()
                .fillStep3ValidEmailAddressWithoutDocs(email)
                .fillStep3ValidRepeatEmailAddressWithoutDocs(repeatEmail)
                .clickNextStepButton7()
                .validateFirstName(vorname)
                .validateLastName(nachname)
                .validateDateOfBirth(geburtsdatum);
    }

    @TmsLink("WFHT-1494")
    @Test(description = "GC06 - Logged In Vodafone User - Step 4 - Verify Personal Data with previous provider if Contract type is business (Company name and Customer number)")
    public void GC06() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getFutureDateFormatted(9))
                .clickOnWeiterButton4()
                .clickOnASARadioButton()
                .clickOnYesInformedRadioButton()
                .verifyStep2SuccessProviderInformedWithoutDocs()
                .clickNextStepButton5()
                .fillStep3geschäftskundeCheckBox()
                .fillStep3Geschäftskunde(firmenname,kundnennummer,phoneNumber,phoneNumber2,provider2)
                .clickNextStepButton6()
                .fillStep3ValidEmailAddressWithoutDocs(email)
                .fillStep3ValidRepeatEmailAddressWithoutDocs(repeatEmail)
                .clickNextStepButton7()
                .validateCompanyName(firmenname)
                .validateCustomerNumber(kundnennummer);
    }

    @TmsLink("WFHT-1496")
    @Test(description = "GC08 - Logged In Vodafone User - Step 4 - Verify Email address")
    public void GC08() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getFutureDateFormatted(9))
                .clickOnWeiterButton4()
                .clickOnASARadioButton()
                .clickOnYesInformedRadioButton()
                .verifyStep2SuccessProviderInformedWithoutDocs()
                .clickNextStepButton5()
                .fillStep3geschäftskundeCheckBox()
                .fillStep3Geschäftskunde(firmenname,kundnennummer,phoneNumber,phoneNumber2,provider2)
                .clickNextStepButton6()
                .fillStep3ValidEmailAddressWithoutDocs(email)
                .fillStep3ValidRepeatEmailAddressWithoutDocs(repeatEmail)
                .clickNextStepButton7()
                .validateEmailAddress(email);
    }

    @TmsLink("WFHT-1497")
    @Test(description = "GC09 - Logged In Vodafone User - Step 4 - Verify that the checkboxs are checkable")
    public void GC09() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getFutureDateFormatted(9))
                .clickOnWeiterButton4()
                .clickOnASARadioButton()
                .clickOnYesInformedRadioButton()
                .verifyStep2SuccessProviderInformedWithoutDocs()
                .clickNextStepButton5()
                .fillStep3PrivatkundeCheckBox()
                .fillStep3Privatkunde(vorname,nachname,geburtsdatum,phoneNumber,phoneNumber2,provider2)
                .clickNextStepButton6()
                .fillStep3ValidEmailAddressWithoutDocs(email)
                .fillStep3ValidRepeatEmailAddressWithoutDocs(repeatEmail)
                .clickNextStepButton7()
                .validateCheckBoxesChecked();
    }

    @TmsLink("WFHT-1498")
    @Test(description = "GC10 - Logged In Vodafone User - Step 4 - Verify Warning message")
    public void GC10() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getFutureDateFormatted(9))
                .clickOnWeiterButton4()
                .clickOnASARadioButton()
                .clickOnYesInformedRadioButton()
                .verifyStep2SuccessProviderInformedWithoutDocs()
                .clickNextStepButton5()
                .fillStep3PrivatkundeCheckBox()
                .fillStep3Privatkunde(vorname,nachname,geburtsdatum,phoneNumber,phoneNumber2,provider2)
                .clickNextStepButton6()
                .fillStep3ValidEmailAddressWithoutDocs(email)
                .fillStep3ValidRepeatEmailAddressWithoutDocs(repeatEmail)
                .clickNextStepButton7()
                .validateInformationMessage4CL();
    }

    @TmsLink("WFHT-1499")
    @Test(description = "GC11 - Logged In Vodafone User - Step 4 - Verify that the user is redirected to login page after clicking Cancel button")
    public void GC11() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getFutureDateFormatted(9))
                .clickOnWeiterButton4()
                .clickOnASARadioButton()
                .clickOnYesInformedRadioButton()
                .verifyStep2SuccessProviderInformedWithoutDocs()
                .clickNextStepButton5()
                .fillStep3PrivatkundeCheckBox()
                .fillStep3Privatkunde(vorname,nachname,geburtsdatum,phoneNumber,phoneNumber2,provider2)
                .clickNextStepButton6()
                .fillStep3ValidEmailAddressWithoutDocs(email)
                .fillStep3ValidRepeatEmailAddressWithoutDocs(repeatEmail)
                .clickNextStepButton7()
                .clickOnCancelButton4()
                .verifyCancelButtonBehaviour();
    }

    @TmsLink("WFHT-1505")
    @Test(description = "BC01 - Logged In Vodafone User - Step 4 - Verify that 'Order Now' button is dimmed if only one of the checkbox is checked")
    public void BC01() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getFutureDateFormatted(9))
                .clickOnWeiterButton4()
                .clickOnASARadioButton()
                .clickOnYesInformedRadioButton()
                .verifyStep2SuccessProviderInformedWithoutDocs()
                .clickNextStepButton5()
                .fillStep3PrivatkundeCheckBox()
                .fillStep3Privatkunde(vorname,nachname,geburtsdatum,phoneNumber,phoneNumber2,provider2)
                .clickNextStepButton6()
                .fillStep3ValidEmailAddressWithoutDocs(email)
                .fillStep3ValidRepeatEmailAddressWithoutDocs(repeatEmail)
                .clickNextStepButton7()
                .enableFirstCheckBoxOnly()
                .disableFirstCheckBoxOnly()
                .enableSecondCheckBoxOnly();
    }

    @TmsLink("WFHT-1506")
    @Test(description = "BC02 - Logged In Vodafone User - Step 4 - Verify Service failure")
    public void BC02() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getFutureDateFormatted(9))
                .clickOnWeiterButton4()
                .clickOnASARadioButton()
                .clickOnYesInformedRadioButton()
                .verifyStep2SuccessProviderInformedWithoutDocs()
                .clickNextStepButton5()
                .fillStep3PrivatkundeCheckBox()
                .fillStep3Privatkunde(vorname,nachname,geburtsdatum,phoneNumber,phoneNumber2,provider2)
                .clickNextStepButton6()
                .fillStep3ValidEmailAddressWithoutDocs(email)
                .fillStep3ValidRepeatEmailAddressWithoutDocs(repeatEmail)
                .clickNextStepButton7()
                .validateCheckBoxesChecked()
                .clickOrderNowButtonWithoutDocs()
                .verifyServiceFailureMessage2();
    }
}








