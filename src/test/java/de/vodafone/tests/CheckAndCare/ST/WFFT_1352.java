package de.vodafone.tests.CheckAndCare.ST;

import com.shaft.validation.Validations;
import de.vodafone.pages.CheckAndCare.*;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Check And Care")
@Feature("ST")
public class WFFT_1352 extends CheckAndCareSTSetup {

    @Test(description ="GC01 - Verify first accordion in (Technician cannot reach the house) flow")
    @TmsLink("WFFT-1431")
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

        // Verify APL page
        Validations.assertThat()
                .element(driver.getDriver(), APLInfoPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".APLInfoheader"))
                .withCustomReportMessage("Check APL Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), APLInfoPage.subHeader_Cl)
                .text()
                .contains(testData.getTestData(method.getName() + ".APLInfoSubheader"))
                .withCustomReportMessage("Check APL Page Sub Header Text")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), APLInfoPage.firstAcc_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".FirstAccTitle"))
                .withCustomReportMessage("Check First Accordion Title Text")
                .perform();
        new APLInfoPage(driver)
                .clickOn_firstAcc();

        Validations.assertThat()
                .element(driver.getDriver(), APLInfoPage.firstAccInfo_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".FirstAccinfo"))
                .withCustomReportMessage("Check First Accordion Info Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), APLInfoPage.neuenTerminAussuchen_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".TerminAussuchenButtonTxt"))
                .withCustomReportMessage("Check TerminAussuchen Button Text CL")
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
       /* Validations.assertThat()
                .element(driver.getDriver(), CalendarPage.morning_CheckBox)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Morning CheckBox Text"))
                .withCustomReportMessage("Check Morning CheckBox Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), CalendarPage.evening_CheckBox)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Evening CheckBox Text"))
                .withCustomReportMessage("Check Evening CheckBox Text")
                .perform();*/

        new CalendarPage(driver).selectMorningCheck();
        new CalendarPage(driver).clickOn_Weiter();

        // Verify Review Date Page
        /*Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDateheader"))
                .withCustomReportMessage("Check Review Date Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.subHeader_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDateSubheader"))
                .withCustomReportMessage("Check Review Date Page Sub Header Text")
                .perform();*/
        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.date_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDateDateCL"))
                .withCustomReportMessage("Check Review Data Page Date Cl")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.confirmDate_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".TerminwahlbestätigenButtonTxt"))
                .withCustomReportMessage("Check Terminwahl bestätigen Button Txt")
                .perform();

        new ReviewDatePage(driver).clickOn_ConfirmDate();

        // Verify Confirmed Date Page
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmedDatePage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmedDateheader"))
                .withCustomReportMessage("Check Confirmed Date Page Header Title")
                .perform();

    }

    @Test(description ="GC02 - Verify Second accordion in (Technician cannot reach the house) flow")
    @TmsLink("WFFT-1433")
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

        // Verify APL page
        Validations.assertThat()
                .element(driver.getDriver(), APLInfoPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".APLInfoheader"))
                .withCustomReportMessage("Check APL Page Header Title")
                .perform();


        Validations.assertThat()
                .element(driver.getDriver(), APLInfoPage.secondAcc_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".SecondAccTitle"))
                .withCustomReportMessage("Check Second Accordion Title Text")
                .perform();
        new APLInfoPage(driver)
                .clickOn_secondAcc();

        Validations.assertThat()
                .element(driver.getDriver(), APLInfoPage.secondAccInfo_Cl)
                .text()
                .contains(testData.getTestData(method.getName() + ".SecondAccinfo"))
                .withCustomReportMessage("Check Second Accordion Info Text")
                .perform();


        new APLInfoPage(driver).clickOn_NeuenTerminAussuchen();

        // Verify Calendar page
        Validations.assertThat()
                .element(driver.getDriver(), CalendarPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Calendarheader"))
                .withCustomReportMessage("Check Calendar page Header Title")
                .perform();

    }

}
