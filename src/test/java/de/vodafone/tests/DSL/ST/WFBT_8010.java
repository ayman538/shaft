package de.vodafone.tests.DSL.ST;

import de.vodafone.pages.DSL.*;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("DSL")
@Feature("ST")
@Story("WFBT-8010")
public class WFBT_8010 extends ST_DSLSetup {

    @TmsLink("WFBT-9634")
    @Test(description = "GC01 | WFBT-8010 | Check booking transaction for a priced option - Success Flow")
    private void GC01(Method method) {
        new DSL_Dashboard(driver).clickOnMeinTarifSO();
        new MyDSLProducts(driver).clickOnBookableOptionsAcc()
                .bookPricedOption(testData.getTestData(method.getName() + ".buttonText"));
        new BookingTransactionPage(driver)
                .validateTransactionPageTitles(testData.getTestData(method.getName() + ".reviewDetailsHeaderCL"))
                .validatePricedBookedOptionCard(
                        testData.getTestData(method.getName() + ".optionName"),
                        testData.getTestData(method.getName() + ".optionPrice"))
                .validateBookingDate()
                .validatePolicyTerms()
                .clickOnConfirmBookingCTA(testData.getTestData(method.getName() + ".confirmBookingCTA"));
        new BookingConfirmationPage(driver).validateConfirmationPageTitles()
                .validateConfirmationMessage()
                .expandOverviewAccordion()
                .validatePricedBookedOptionCard(
                        testData.getTestData(method.getName() + ".optionName"),
                        testData.getTestData(method.getName() + ".optionPrice"))
                .validateActualBookingDate();
    }

    @TmsLink("WFBT-9642")
    @Test(description = "GC02 | WFBT-8010 | Check Booking flow for free option to be booked - Success Flow")
    private void GC02(Method method) {
        new DSL_Dashboard(driver).clickOnMeinTarifSO();
        new MyDSLProducts(driver).clickOnBookableOptionsAcc()
                .bookFreeOption(testData.getTestData(method.getName() + ".buttonText"));
        new BookingTransactionPage(driver)
                .validateTransactionPageTitles(testData.getTestData(method.getName() + ".reviewDetailsHeaderCL"))
                .validateFreeBookedOptionCard(
                        testData.getTestData(method.getName() + ".optionName"),
                        testData.getTestData(method.getName() + ".optionPrice"))
                .validateBookingDate()
                .validatePolicyTerms()
                .clickOnConfirmBookingCTA(testData.getTestData(method.getName() + ".confirmBookingCTA"));
        new BookingConfirmationPage(driver).validateConfirmationPageTitles()
                .validateConfirmationMessage()
                .expandOverviewAccordion()
                .validateFreeBookedOptionCard(
                        testData.getTestData(method.getName() + ".optionName"),
                        testData.getTestData(method.getName() + ".optionPrice"))
                .validateActualBookingDate();
    }
}