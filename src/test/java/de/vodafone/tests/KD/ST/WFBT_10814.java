package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.KabelTVPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("KD")
@Feature("ST")
@Story("WFBT-10814")
public class WFBT_10814 extends ST_KDSetup {

    @TmsLink("WFBT_11171")
    @Test(description = "WFBT_11171 || GC01 Check Booked Option Accordion with one SmartCard and one tarif or more")
    public void GC01_UserCheckBookedOptionAccordionWithOneSmartCardAndOneTarif(){
        new KD_Dashboard(driver).expandKabelTvAccordion()
                .clickOnMainTarifTVSO();
        new KabelTVPage(driver).validateBookedOptionOS()
                .expandBookedOptionAccordion()
                .validateExistenceOfBookedOptionAccordionCard()
                .validateBookedOptionFAccordionDetails()
                .validateFirstBookedOptionWithSmartCard()
                .validateSecondBookedOptionWithSmartCard();
    }

    @TmsLink("WFBT_11172")
    @Test(description = "WFBT_11172 || GC02 Check Booked Option Accordion with Two SmartCard")
    public void GC02_UserCheckBookedOptionAccordionWithTwoSmartCard(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion()
                .navigateToKabelTVPage();
        new KabelTVPage(driver).validateBookedOptionOS()
                .expandBookedOptionAccordion()
                .validateExistenceOfBookedOptionAccordionCard()
                .validateSecondSerialNumberInFirstSmartCard(testData.getTestData(method.getName() + ".smartCardSerialNO"))
                .validateBookedOptionFAccordionDetails()
                .validateFirstBookedOptionWithSmartCard()
                .validateSecondBookedOptionWithSmartCard()
                .validateSecondSmartCardDetails()
                .validateBookedOptionSAccordionDetails()
                .validateThirdBookedOptionWithSmartCard();
    }

    @TmsLink("WFBT_11173")
    @Test(description = "WFBT_11173 || GC03 Check Booked Option Accordion with Tarif and No SmartCard")
    public void GC03_UserCheckBookedOptionAccordionWithTarifAndNoSmartCard(){
        new KD_Dashboard(driver).expandKabelTvAccordion()
                .navigateToKabelTVPage();
        new KabelTVPage(driver).expandBookedOptionAccordion()
                .validateExistenceOfBookedOptionAccordionCard()
                .validateFirstSmartCardDoesNotExist()
                .validateBookedOptionFAccordionDetails()
                .validateBookedOptionsWithoutSmartCard();
    }

    @TmsLink("WFBT_11174")
    @Test(description = "WFBT_11174 || GC04 Check Booked Option Accordion with Mixed Tarif")
    public void GC04_UserCheckBookedOptionAccordionWithMixedTarif(){
        new KD_Dashboard(driver).expandKabelTvAccordion()
                .navigateToKabelTVPage();
        new KabelTVPage(driver).validateBookedOptionOS()
                .expandBookedOptionAccordion()
                .validateExistenceOfBookedOptionAccordionCard()
                .validateFirstSmartCardDetails()
                .validateBookedOptionFAccordionDetails()
                .validateFirstBookedOptionWithSmartCard()
                .validateSecondBookedOptionWithSmartCard()
                .validateBookedOptionSAccordionDetails()
                .validateBookedOptionsWithoutSmartCard();
    }

    @TmsLink("WFBT_11178")
    @Test(description = "WFBT_11178 || GC06 Check Booked Option Accordion with No Booked Options")
    public void GC06_UserCheckBookedOptionAccordionWithNoBookedOptions(){
        new KD_Dashboard(driver).expandKabelTvAccordion()
                .navigateToKabelTVPage();
        new KabelTVPage(driver).validateBookedOptionOS()
                .expandBookedOptionAccordion()
                .validateExistenceOfBookedOptionAccordionCard()
                .validateNoBookedOptions();
    }

    @TmsLink("WFBT_11176")
    @Test(description = "WFBT_11176 || BC01 Check Booked Option Accordion when it return General Error")
    public void BC01_UserCheckBookedOptionAccordionWhenItReturnGeneralError() {
        new KD_Dashboard(driver).expandKabelTvAccordion()
                .navigateToKabelTVPage();
        new KabelTVPage(driver)
                .expandBookedOptionAccordion()
                .validateErrorMessageNotification();
    }
}