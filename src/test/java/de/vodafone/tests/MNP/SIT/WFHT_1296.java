package de.vodafone.tests.MNP.SIT;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.MNP.LandingPage;
import de.vodafone.pages.MNP.PortingWODocumentsPostpaidPage;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

import static de.vodafone.pages.commons.UtilitiesPage.getFutureDateFormatted;

@Epic("MNP")
@Feature("SIT")
@Story("WFHT-1296")
public class WFHT_1296 extends SIT_MNP_Setup {
    private SHAFT.GUI.WebDriver driver;
    private String deeplink;
    private String contactNumber;
    private String vorname;
    private String nachname;
    private String geburtsdatum;
    private String phoneNumber;
    private String phoneNumber2;
    private String provider2;
    private String email;
    private String repeatEmail;
    private JSONFileManager cookieMap;
    private JSONFileManager testData;
    private HashMap<String,String> cookieSwitcherMap;
    private String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        deeplink = testData.getTestData(method.getName() + ".deeplink");
        contactNumber = testData.getTestData(method.getName() + ".contactNumber");
        vorname = testData.getTestData(method.getName() + ".vorname");
        nachname = testData.getTestData(method.getName() + ".nachname");
        geburtsdatum = testData.getTestData(method.getName() + ".geburtsdatum");
        phoneNumber = testData.getTestData(method.getName() + ".phoneNumber");
        phoneNumber2 = testData.getTestData(method.getName() + ".phoneNumber2");
        provider2 = testData.getTestData(method.getName() + ".provider2");
        email = testData.getTestData(method.getName() + ".email");
        repeatEmail = testData.getTestData(method.getName() + ".repeatEmail");

        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(method.getName());
        driver= new SHAFT.GUI.WebDriver();

        new de.vodafone.pages.commons.LoginPage(driver).
                navigateSIT().
                acceptCookies().
                setCookieSwitchers(cookieSwitcherMap);
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "MNP/SIT/SIT_" + className + "_CookieSwitcher.json");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "MNP/SIT/" + className + ".json");
        cookieSwitcherMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "MNP/SIT/SIT_" +className+"_CookieSwitcher.json").getTestDataAsMap("$");
    }

    @TmsLink("WFHT-1480")
    @Test(description = "GC01 - Logged in Vodafone User - Step 3 - Verify Title, filling valid email and matching Repeated email address")
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
                .validateStep3HeaderCLWithoutDocs()
                .validateStep3SubHeaderCLWithoutDocs()
                .validateMandatoryTextInStep3WithoutDocs()
                .clickNextStepButton7();

    }

    @TmsLink("WFHT-1481")
    @Test(description = "GC02 - Logged in Vodafone User - Step 3 - Verify filling valid email and mismatching Repeated email address")
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
                .fillStep3InvalidRepeatEmailAddressWithoutDocs(repeatEmail)
                .clickNextStepButton7()
                .validateMismatchingErrorWithoutDocs();
    }

    @TmsLink("WFHT-1482")
    @Test(description = "GC03 - Logged in Vodafone User - Step 3 - Verify filling invalid email and valid Repeated email address")
    public void GC03() {
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
                .fillStep3InvalidEmailAddressWithoutDocs(email)
                .clickNextStepButton7()
                .validateInvalidEmailErrorEmailAddressWithoutDocs()
                .fillStep3ValidRepeatEmailAddressWithoutDocs(repeatEmail)
                .clickNextStepButton7()
                .validateMismatchingErrorWithoutDocs();

    }

    @TmsLink("WFHT-1483")
    @Test(description = "GC04 - Logged in Vodafone User - Step 3 - Verify filling invalid email and invalid Repeated email address")
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
                .fillStep3InvalidEmailAddressWithoutDocs(email)
                .clickNextStepButton7()
                .validateInvalidEmailErrorEmailAddressWithoutDocs()
                .fillStep3InvalidRepeatEmailAddressWithoutDocs(repeatEmail)
                .clickNextStepButton7()
                .validateInvalidEmailErrorRepeatEmailAddressWithoutDocs();
    }

    @TmsLink("WFHT-1484")
    @Test(description = "GC05 - Logged in Vodafone User - Step 3 - Verify email and Repeated email are mandatory fields")
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
                .fillStep3ValidRepeatEmailAddressWithoutDocs(repeatEmail)
                .clickNextStepButton7()
                .validateMandatoryErrorEmailAddressWithoutDocs()
                .fillStep3ValidEmailAddressWithoutDocs(email)
                .clearRepeatEmailAddressWithoutDocs()
                .clickNextStepButton7()
                .validateMandatoryErrorRepeatEmailAddressWithoutDocs();
    }

    @TmsLink("WFHT-1485")
    @Test(description = "GC06 - Logged in Vodafone User - Step 3 - Verify Cancel button behavior")
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
                .fillStep3PrivatkundeCheckBox()
                .fillStep3Privatkunde(vorname,nachname,geburtsdatum,phoneNumber,phoneNumber2,provider2)
                .clickNextStepButton6()
                .fillStep3ValidEmailAddressWithoutDocs(email)
                .fillStep3ValidRepeatEmailAddressWithoutDocs(repeatEmail)
                .clickOnCancelButton3()
                .verifyCancelButtonBehaviour();
    }

    @TmsLink("WFHT-1486")
    @Test(description = "GC07 - Logged in Vodafone User - Step 3 - Verify Next button behavior")
    public void GC07() {
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
                .clickNextStepButton7();
    }
}








