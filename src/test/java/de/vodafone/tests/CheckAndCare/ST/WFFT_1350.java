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
public class WFFT_1350 extends CheckAndCareSTSetup {
    @Test(description ="GC01- Verify the option to request another visit flow.")
    @TmsLink("")
    private void GC01(Method method) throws InterruptedException {

        //Verify DashBoard page opened successfully
        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".Dashboardheader"))
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
                .element(driver.getDriver(), RefusedProductPage.subHeadlineText_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RefusedProductSubHeadline"))
                .withCustomReportMessage("Check Refused Product Page SubHeadline")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), RefusedProductPage.text_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RefusedProductSubHeadline2"))
                .withCustomReportMessage("Check Refused Product Page SubHeadline2")
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

        new RefusedProductPage(driver).clickOn_JaButton();

        // Verify Calendar page
        Validations.assertThat()
                .element(driver.getDriver(), CalendarPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Calendarheader"))
                .withCustomReportMessage("Check Calendar page Header Title")
                .perform();
        new CalendarPage(driver).selectAvailableDate();

        Validations.assertThat()
                .element(driver.getDriver(), CalendarPage.evening_CheckBox)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".EveningCheckBoxText"))
                .withCustomReportMessage("Check Evening CheckBox Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), CalendarPage.weiter_Button)
                .attribute("disabled")
                .isNotNull()
                .withCustomReportMessage("Check button is disabled")
                .perform();


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

    @Test(description ="GC02- Verify the option to refuse the product flow.")
    @TmsLink("")
    private void GC02(Method method) throws InterruptedException {
        // Verify DashBoard page opened successfully
        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".Dashboardheader"))
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
                .element(driver.getDriver(), RefusedProductPage.subHeadlineText_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RefusedProductSubHeadline"))
                .withCustomReportMessage("Check Refused Product Page SubHeadline")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), RefusedProductPage.text_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RefusedProductSubHeadline2"))
                .withCustomReportMessage("Check Refused Product Page SubHeadline2")
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

        /*Validations.assertThat()
                .element(driver.getDriver(), CancelContractPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".CancelContractheader"))
                .withCustomReportMessage("Check Cancel Contract Header Title")
                .perform();*/
        Validations.assertThat()
                .element(driver.getDriver(), CancelContractPage.subHeadlineText_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".CancelContractSubHeadline"))
                .withCustomReportMessage("Check Cancel Contract Page SubHeadline")
                .perform();
        /*Validations.assertThat()
                .element(driver.getDriver(), CancelContractPage.retourenportal_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RetourenportalButton"))
                .withCustomReportMessage("Check Cancel Contract Page Retourenportal Button")
                .perform();*/
        //int NoOfTabsOpened = new CancelContractPage(driver).getNumberOfOpennedTabs();
        //new CancelContractPage(driver).clickOn_RetourenportalButton();
       // int NoOfTabsOpenedAfterClick = new CancelContractPage(driver).getNumberOfOpennedTabs();
       /* Validations.assertThat()
                .number(NoOfTabsOpenedAfterClick)
                .isEqualTo(NoOfTabsOpened+1);*/

    }
}
