package de.vodafone.tests.MNP.SIT;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.MNP.LandingPage;
import de.vodafone.pages.MNP.PortingWODocumentsPostpaidPage;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

import static de.vodafone.pages.commons.UtilitiesPage.*;

@Epic("MNP")
@Feature("SIT")
@Story("WFHT-1045")
public class WFHT_1280 extends SIT_MNP_Setup{
    private SHAFT.GUI.WebDriver driver;
    private String deeplink;
    private String contactNumber;
    private JSONFileManager cookieMap;
    private JSONFileManager testData;
    private HashMap<String,String> cookieSwitcherMap;
    private String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        deeplink = testData.getTestData(method.getName() + ".deeplink");
        contactNumber = testData.getTestData(method.getName() + ".contactNumber");

        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(method.getName());
        driver= new SHAFT.GUI.WebDriver();

        new de.vodafone.pages.commons.LoginPage(driver)
                .navigateST()
                .acceptCookies()
                .setCookieSwitchers(cookieSwitcherMap);
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

    @TmsLink("WFHT-1464")
    @Test(description = "GC01 - Logged In Vodafone User - Step 2 - Verify that Contract Termination radio button appears and In case of terminated contract user is redirected to Step 1")
    public void GC01() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getFutureDateFormatted(1))
                .clickOnWeiterButton4();
    }

    @TmsLink("WFHT-1465")
    @Test(description = "GC02 - Logged In Vodafone User - Step 2 - Verify that contract Date info is not filled")
    public void GC02() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate("")
                .clickOnWeiterButton4()
                .validateMandatoryErrorVertagsEnde();
    }

    @TmsLink("WFHT-1466")
    @Test(description = "GC03 - Logged In Vodafone User - Step 2 - Verify that contract has ended more than 90 Days ago")
    public void GC03() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getPastDateFormatted(91))
                .clickOnWeiterButton4()
                .verifyStep2FailureMoreThan90DaysWithoutDocs()
                .validateWeiterCTAIsDimmed();
    }

    @TmsLink("WFHT-1468")
    @Test(description = "GC04 - Logged In Vodafone User - Step 2 - Verify that contract will end in more than 123 Days in Future and As Soon as Possible and Provider not informed")
    public void GC04() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getFutureDateFormatted(124))
                .clickOnWeiterButton4()
                .clickOnASARadioButton()
                .clickOnNotInformedRadioButton()
                .verifyStep2FailureProviderNotInformedWithoutDocs()
                .validateWeiterCTAIsDimmed();
    }

    @TmsLink("WFHT-1469")
    @Test(description = "GC05 - Logged In Vodafone User - Step 2 - Verify that contract will end in more than 123 Days in Future and As Soon as Possible and Provider informed")
    public void GC05() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getFutureDateFormatted(124))
                .clickOnWeiterButton4()
                .clickOnASARadioButton()
                .clickOnYesInformedRadioButton()
                .verifyStep2SuccessProviderInformedWithoutDocs();
    }

    @TmsLink("WFHT-1470")
    @Test(description = "GC06 - Logged In Vodafone User - Step 2 - Verify that contract will end in more than 123 Days in Future and At End of Contract")
    public void GC06() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getFutureDateFormatted(124))
                .clickOnWeiterButton4()
                .clickOnEOCRadioButton()
                .verifyStep2FailureFourMonthsInFutureWithoutDocs()
                .validateWeiterCTAIsDimmed();

    }

    @TmsLink("WFHT-1471")
    @Test(description = "GC07 - Logged In Vodafone User - Step 2 - Verify that contract will end in less than 90 days ago or today or 8 days in future")
    public void GC07() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getPastDateFormatted(89))
                .clickOnWeiterButton4()
                .verifyStep2SuccessMessage3WithoutDocs();

        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getCurrentDateFormatted())
                .clickOnWeiterButton4()
                .verifyStep2SuccessMessage3WithoutDocs();

        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getFutureDateFormatted(8))
                .clickOnWeiterButton4()
                .verifyStep2SuccessMessage3WithoutDocs();
    }

    @TmsLink("WFHT-1472")
    @Test(description = "GC08 - Logged In Vodafone User - Step 2 - Verify that contract will end in less than 123 Days in Future and more than 8 days and As Soon as Possible and Provider not informed")
    public void GC08() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getFutureDateFormatted(122))
                .clickOnWeiterButton4()
                .clickOnASARadioButton()
                .clickOnNotInformedRadioButton()
                .verifyStep2FailureProviderNotInformedWithoutDocs()
                .validateWeiterCTAIsDimmed();

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
                .clickOnNotInformedRadioButton()
                .verifyStep2FailureProviderNotInformedWithoutDocs()
                .validateWeiterCTAIsDimmed();
    }

    @TmsLink("WFHT-1473")
    @Test(description = "GC09 - Logged In Vodafone User - Step 2 - Verify that contract will end in less than 123 Days in Future and more than 8 days and As Soon as Possible and Provider informed")
    public void GC09() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getFutureDateFormatted(122))
                .clickOnWeiterButton4()
                .clickOnASARadioButton()
                .clickOnYesInformedRadioButton()
                .verifyStep2SuccessProviderInformedWithoutDocs();

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
                .verifyStep2SuccessProviderInformedWithoutDocs();
    }

    @TmsLink("WFHT-1474")
    @Test(description = "GC10 - Logged In Vodafone User - Step 2 - Verify that contract will end in less than 123 Days in Future and more than 8 days and At End of Contract")
    public void GC10() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getFutureDateFormatted(122))
                .clickOnWeiterButton4()
                .clickOnEOCRadioButton()
                .verifyStep2SuccessMessageAtEndOfContractWithoutDocs();

        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getFutureDateFormatted(9))
                .clickOnWeiterButton4()
                .clickOnEOCRadioButton()
                .verifyStep2SuccessMessageAtEndOfContractWithoutDocs();
    }

    @TmsLink("WFHT-1475")
    @Test(description = "GC11 - Logged In Vodafone User - Step 2 - Verify Cancel Behaviour")
    public void GC11() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnYesCancelledRadioButton()
                .clickOnWeiterButton2()
                .enterVertagsendeDate(getFutureDateFormatted(1))
                .clickOnWeiterButton4()
                .clickOnCancelButton2()
                .verifyCancelButtonBehaviour();
    }

    @TmsLink("WFHT-1478")
    @Test(description = "BC01 - Logged in Vodafone User - Step 2 - Verify Service Failure")
    public void BC01() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new PortingWODocumentsPostpaidPage(driver)
                .verifyServiceFailureMessage1();
    }
}







