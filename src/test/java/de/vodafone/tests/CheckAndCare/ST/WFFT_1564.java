package de.vodafone.tests.CheckAndCare.ST;

import com.shaft.validation.Validations;
import de.vodafone.pages.CheckAndCare.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Check And Care")
@Feature("ST")
public class WFFT_1564 extends CheckAndCareSTSetup {
    @Test(description ="GC01 - Verify Browser back button behavior in reserve appointment confirmation page in case (TAM 6000)")
    @TmsLink("WFFT-1571")
    private void GC01(Method method) {

        // Verify DashBoard page opened successfully
        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Dashboardheader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();

        new DashboardPage(driver)
                .clickOnNeinButton();

        // Verify Refused Product Page
        Validations.assertThat()
                .element(driver.getDriver(), RefusedProductPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RefusedProductheader"))
                .withCustomReportMessage("Check Refused Product Page Header Title")
                .perform();

        new RefusedProductPage(driver).clickOn_JaButton();

        // Verify Calendar page
        Validations.assertThat()
                .element(driver.getDriver(), CalendarPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Calendarheader"))
                .withCustomReportMessage("Check Calendar page Header Title")
                .perform();
        new CalendarPage(driver).selectAvailableDate();
        new CalendarPage(driver).selectMorningCheck();
        new CalendarPage(driver).clickOn_Weiter();

        // Verify Review Date Page
        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.header2_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDataheader"))
                .withCustomReportMessage("Check Review Data Page Header Title")
                .perform();

        new ReviewDatePage(driver).clickOn_ConfirmDate();

        // Verify Confirmed Date Page
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmedDatePage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmedDateheader"))
                .withCustomReportMessage("Check Confirmed Date Page Header Title")
                .perform();
        //driver.browser().navigateBack();
        driver.getDriver().navigate().back();
        // Verify Confirmed Date Page
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmedDatePage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmedDateheader"))
                .withCustomReportMessage("Check Confirmed Date Page Header Title")
                .perform();
    }

    @Test(description ="GC02 - Verify Browser back button behavior in reserve appointment confirmation page in case (TAM 6001)")
    @TmsLink("WFFT-1572")
    private void GC02(Method method) {

        // Verify DashBoard page opened successfully
        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Dashboardheader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();

        new DashboardPage(driver)
                .clickOnNeinButton();

        // Verify Missed Technician Page
        Validations.assertThat()
                .element(driver.getDriver(), MissedTechnicianPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".MissedTechnicianheader"))
                .withCustomReportMessage("Check Missed Technician Page Header Title")
                .perform();

        new MissedTechnicianPage(driver).clickOn_TechnikerTerminAussuchen();

        // Verify Calendar page
        Validations.assertThat()
                .element(driver.getDriver(), CalendarPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Calendarheader"))
                .withCustomReportMessage("Check Calendar page Header Title")
                .perform();
        new CalendarPage(driver).selectAvailableDate();
        new CalendarPage(driver).selectMorningCheck();
        new CalendarPage(driver).clickOn_Weiter();

        // Verify Review Date Page
        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDataheader"))
                .withCustomReportMessage("Check Review Data Page Header Title")
                .perform();

        new ReviewDatePage(driver).clickOn_jaCheckBox();
        new ReviewDatePage(driver).clickOn_ConfirmDate2();

        // Verify Confirmed Date Page
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmedDatePage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmedDateheader"))
                .withCustomReportMessage("Check Confirmed Date Page Header Title")
                .perform();
       // driver.browser().navigateBack();
        driver.getDriver().navigate().back();

        // Verify Confirmed Date Page
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmedDatePage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmedDateheader"))
                .withCustomReportMessage("Check Confirmed Date Page Header Title")
                .perform();

    }

    @Test(description ="GC03 - Verify Browser back button behavior in reserve appointment confirmation page in case (TAM 6002)")
    @TmsLink("WFFT-1573")
    private void GC03(Method method) {
        // Verify DashBoard page opened successfully
        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Dashboardheader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();

        new DashboardPage(driver)
                .clickOnNeinButton();

        // Verify APL page
        Validations.assertThat()
                .element(driver.getDriver(), APLInfoPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".APLInfoheader"))
                .withCustomReportMessage("Check APL Page Header Title")
                .perform();

        new APLInfoPage(driver).clickOn_NeuenTerminAussuchen();

        // Verify Calendar page
        Validations.assertThat()
                .element(driver.getDriver(), CalendarPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Calendarheader"))
                .withCustomReportMessage("Check Calendar page Header Title")
                .perform();
        new CalendarPage(driver).selectAvailableDate();
        new CalendarPage(driver).selectMorningCheck();
        new CalendarPage(driver).clickOn_Weiter();

        // Verify Review Date Page
        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.header2_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDateheader"))
                .withCustomReportMessage("Check Review Date Page Header Title")
                .perform();

        new ReviewDatePage(driver).clickOn_ConfirmDate();

        // Verify Confirmed Date Page
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmedDatePage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmedDateheader"))
                .withCustomReportMessage("Check Confirmed Date Page Header Title")
                .perform();
        //driver.browser().navigateBack();
        driver.getDriver().navigate().back();

        // Verify Confirmed Date Page
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmedDatePage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmedDateheader"))
                .withCustomReportMessage("Check Confirmed Date Page Header Title")
                .perform();
    }

    @Test(description ="GC04 - Verify Browser back button behavior in reserve appointment confirmation page in case (TAM 6003)")
    @TmsLink("WFFT-1574")
    private void GC04(Method method) {

        // Verify DashBoard page opened successfully
        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Dashboardheader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();

        new DashboardPage(driver)
                .clickOnNeinButton();

        // Verify Check Address Page
        Validations.assertThat()
                .element(driver.getDriver(), CheckAddressPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".CheckAddressheader"))
                .withCustomReportMessage("Verify Check Address Page Header Title")
                .perform();

        new CheckAddressPage(driver).clickOnJaButton();

        // Verify Confirm Address page
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmAddressPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmAddressheader"))
                .withCustomReportMessage("Check Confirm Address Page Header Title")
                .perform();
        new ConfirmAddressPage(driver).clickOnTerminAuswählenButton();

        // Verify Calendar page
        Validations.assertThat()
                .element(driver.getDriver(), CalendarPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Calendarheader"))
                .withCustomReportMessage("Check Calendar page Header Title")
                .perform();
        new CalendarPage(driver).selectAvailableDate();
        new CalendarPage(driver).selectMorningCheck();
        new CalendarPage(driver).clickOn_Weiter();

        // Verify Review Date Page
        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.klingelschildDrucken_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDataklingelschildDruckenButton"))
                .withCustomReportMessage("Check Review Data Page klingelschild Drucken Btn Text")
                .perform();

        new ReviewDatePage(driver).clickOn_ConfirmDate3();

        // Verify Confirmed Date Page
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmedDatePage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmedDateheader"))
                .withCustomReportMessage("Check Confirmed Date Page Header Title")
                .perform();
        //driver.browser().navigateBack();
        driver.getDriver().navigate().back();
        // Verify Confirmed Date Page
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmedDatePage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmedDateheader"))
                .withCustomReportMessage("Check Confirmed Date Page Header Title")
                .perform();

    }

    /* // the TC not needed for daily pipeline execution
    @Test(description ="GC05 - Verify Browser back button behavior in callback confirmation page in case (TAM 6003)",enabled = false)
    @TmsLink("WFFT-1575")
    private void GC05(Method method) {

        // Verify DashBoard page opened successfully
        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Dashboardheader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();

        new DashboardPage(driver)
                .clickOnNeinButton();

        // Verify Check Address Page
        Validations.assertThat()
                .element(driver.getDriver(), CheckAddressPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".CheckAddressheader"))
                .withCustomReportMessage("Verify Check Address Page Header Title")
                .perform();

        new CheckAddressPage(driver).clickOnNeinButton();

        // Verify Recall page
        Validations.assertThat()
                .element(driver.getDriver(), RecallPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Recallheader"))
                .withCustomReportMessage("Check Recall Page Header Title")
                .perform();

        new RecallPage(driver).enterPhoneNumberText(testData.getTestData(method.getName() + ".RecallPhoneNo"));
        new RecallPage(driver).clickOnTerminAuswählenButton();

        // Verify Recall Confirmation Page
        Validations.assertThat()
                .element(driver.getDriver(), RecallConfirmationPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RecallConfirmationheader"))
                .withCustomReportMessage("Check Recall Confirmation Page Header Title")
                .perform();
       // driver.browser().navigateBack();
        driver.getDriver().navigate().back();
        // Verify Recall Confirmation Page
        Validations.assertThat()
                .element(driver.getDriver(), RecallConfirmationPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RecallConfirmationheader"))
                .withCustomReportMessage("Check Recall Confirmation Page Header Title")
                .perform();


    }
     */

     /* // the TC not needed for daily pipeline execution
    @Test(description ="GC06 - Verify Browser back button behavior in callback confirmation page in case (TAM 6004)",enabled = false)
    @TmsLink("WFFT-1576")
    private void GC06(Method method) {

        // Verify DashBoard page opened successfully
        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Dashboardheader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();

        new DashboardPage(driver)
                .clickOnNeinButton();

        // Verify Recall page
        Validations.assertThat()
                .element(driver.getDriver(), RecallPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Recallheader"))
                .withCustomReportMessage("Check Recall Page Header Title")
                .perform();

        new RecallPage(driver).enterPhoneNumberText(testData.getTestData(method.getName() + ".RecallPhoneNo"));
        new RecallPage(driver).clickOnTerminAuswählenButtonupdated();

        // Verify Recall Confirmation Page
        Validations.assertThat()
                .element(driver.getDriver(), RecallConfirmationPage.header2_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RecallConfirmationheader"))
                .withCustomReportMessage("Check Recall Confirmation Page Header Title")
                .perform();
        //driver.browser().navigateBack();
        driver.getDriver().navigate().back();
        // Verify Recall Confirmation Page
        Validations.assertThat()
                .element(driver.getDriver(), RecallConfirmationPage.header2_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RecallConfirmationheader"))
                .withCustomReportMessage("Check Recall Confirmation Page Header Title")
                .perform();

    }
      */

    @Test(description ="GC07 - Verify Browser back button behavior in installed confirmation page in case (TAM 6000)")
    @TmsLink("WFFT-1577")
    private void GC07(Method method) {

        // validate Dashboard Headlines
        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Dashboardheader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();

        new DashboardPage(driver).clickOnJeButton();

        // validate success page headlines
        Validations.assertThat()
                .element(driver.getDriver(), SuccessPage.headline_text)
                .text()
                .contains(testData.getTestData(method.getName() + ".InstalledConfirmationheader"))
                .withCustomReportMessage("Check Installed Confirmation header is displayed")
                .perform();
        //driver.browser().navigateBack();
        driver.getDriver().navigate().back();
        // validate success page headlines
        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Dashboardheader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();
    }

    @Test(description ="GC08 - Verify The new link added in installed confirmation page in case (TAM 6001)")
    @TmsLink("WFFT-1578")
    private void GC08(Method method) {

        // validate Dashboard Headlines
        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Dashboardheader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();

        new DashboardPage(driver).clickOnJeButton();

        // validate success page headlines
        Validations.assertThat()
                .element(driver.getDriver(), SuccessPage.headline_text)
                .text()
                .contains(testData.getTestData(method.getName() + ".InstalledConfirmationheader"))
                .withCustomReportMessage("Check Installed Confirmation header is displayed")
                .perform();
        new SuccessPage(driver).clickOn_BackLink();
        // validate Dashboard Headlines
        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Dashboardheader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();
    }

}
