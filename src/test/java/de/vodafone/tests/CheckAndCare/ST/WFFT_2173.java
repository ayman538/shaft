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
public class WFFT_2173 extends CheckAndCareSTSetup {
    @Test(description ="GC01-Verify the new added Text in Refused Contract page.")
    @TmsLink("WFFT-2210")
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

        // Verify Refused Product Page
        Validations.assertThat()
                .element(driver.getDriver(), RefusedProductPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RefusedProductheader"))
                .withCustomReportMessage("Check Refused Product Page Header Title")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), RefusedProductPage.ja_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RefusedProduct-JAButton"))
                .withCustomReportMessage("Check Refused Product Page JA Button")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), RefusedProductPage.nein_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RefusedProduct-NeinButton"))
                .withCustomReportMessage("Check Refused Product Page Nein Button")
                .perform();

        new RefusedProductPage(driver).clickOn_NeinButton();

        // Verify Cancel Contract Page

        Validations.assertThat()
                .element(driver.getDriver(), CancelContractPage.Cancel_header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".CancelContractheader"))
                .withCustomReportMessage("Check Cancel Contract Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), CancelContractPage.subHeadlineText_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".CancelContractSubHeadline"))
                .withCustomReportMessage("Check Cancel Contract Page SubHeadline")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), CancelContractPage.subHeadlineText2_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".CancelContractSecondSubHeadline"))
                .withCustomReportMessage("Check Cancel Contract Page Second SubHeadline")
                .perform();
    }

    @Test(description ="GC02-Verify the appointment selection flow when click on the link in Refused Contract page.")
    @TmsLink("WFFT-2212")
    private void GC02(Method method) throws InterruptedException {
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

        Validations.assertThat()
                .element(driver.getDriver(), RefusedProductPage.ja_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RefusedProduct-JAButton"))
                .withCustomReportMessage("Check Refused Product Page JA Button")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), RefusedProductPage.nein_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RefusedProduct-NeinButton"))
                .withCustomReportMessage("Check Refused Product Page Nein Button")
                .perform();

        new RefusedProductPage(driver).clickOn_NeinButton();

        // Verify Cancel Contract Page

        Validations.assertThat()
                .element(driver.getDriver(), CancelContractPage.Cancel_header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".CancelContractheader"))
                .withCustomReportMessage("Check Cancel Contract Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), CancelContractPage.subHeadlineText_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".CancelContractSubHeadline"))
                .withCustomReportMessage("Check Cancel Contract Page SubHeadline")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), CancelContractPage.subHeadlineText2_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".CancelContractSecondSubHeadline"))
                .withCustomReportMessage("Check Cancel Contract Page Second SubHeadline")
                .perform();
        new CancelContractPage(driver).clickOn_CalendarNavigation();

        // Verify Calendar page
        Validations.assertThat()
                .element(driver.getDriver(), CalendarPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Calendarheader"))
                .withCustomReportMessage("Check Calendar page Header Title")
                .perform();
        new CalendarPage(driver).selectAvailableDate();

        new CalendarPage(driver).selectMorningCheck();
        Thread.sleep(200);
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
    }
}
