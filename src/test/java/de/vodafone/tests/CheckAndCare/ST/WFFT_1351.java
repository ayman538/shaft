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
public class WFFT_1351 extends CheckAndCareSTSetup {
    @Test(description ="GC01- Verify the option to request another visit flow.")
    @TmsLink("")
    private void GC01(Method method) throws InterruptedException {

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
        Validations.assertThat()
                .element(driver.getDriver(), MissedTechnicianPage.text_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".MissedTechnicianText"))
                .withCustomReportMessage("Check Missed Technician Page Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), MissedTechnicianPage.technikerTerminAussuchen_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".TechnikerTerminauswählen"))
                .withCustomReportMessage("Check Missed Technician Button Text")
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
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), CalendarPage.weiter_Button)
                .attribute("disabled")
                .isNotNull()
                .withCustomReportMessage("Check button is disabled")
                .perform();*/

        new CalendarPage(driver).selectMorningCheck();
        new CalendarPage(driver).clickOn_Weiter();

        // Verify Review Date Page
        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDataheader"))
                .withCustomReportMessage("Check Review Data Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.subHeader_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDataFirstText"))
                .withCustomReportMessage("Check Review Data Page First Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.subHeader2_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDataSecondText"))
                .withCustomReportMessage("Check Review Data Page Second Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.ja_CheckBox)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".JaCheckBox"))
                .withCustomReportMessage("Check Ja CheckBox Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.nein_CheckBox)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".NeinCheckBox"))
                .withCustomReportMessage("Check Nein CheckBox Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.date_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDateDateCL"))
                .withCustomReportMessage("Check Review Data Page Date Cl")
                .perform();


        new ReviewDatePage(driver).clickOn_jaCheckBox();

        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.jaCheckBoxAlert_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".JaCheckBoxAlert"))
                .withCustomReportMessage("Check Ja CheckBox Alert Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.confirmDate_Button2)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".TerminwahlbestätigenButtonTxt"))
                .withCustomReportMessage("Check Terminwahl bestätigen Button Txt")
                .perform();

        new ReviewDatePage(driver).clickOn_ConfirmDate2();

        // Verify Confirmed Date Page
        Thread.sleep(400);
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmedDatePage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmedDateheader"))
                .withCustomReportMessage("Check Confirmed Date Page Header Title")
                .perform();

    }
}
