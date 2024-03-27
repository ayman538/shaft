package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.KabelTVPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("KD")
@Feature("ST")
@Story("WFBT-12355")
public class WFBT_12355 extends ST_KDSetup {
    @TmsLink("WFBT-13054")
    @Test(description = "GC01 || KD TV user - Check the bookable options Accordion when User having only a main tariff")
    public void GC01(Method method){
        new KD_Dashboard(driver).clickOnKabelTVBurgerMenu()
                .clickOnMeinTarifList();
        new KabelTVPage(driver).expandBookableOptionAccordion()
                .validateBookableAccWhenTheresOnlyMeinTarif();
    }

    @TmsLink("WFBT-13055")
    @Test(description = "GC02 || KD TV user - Check dropdown menu when the user have two tariffs the main tariff and CLS Tariffs")
    public void GC02(Method method){
        new KD_Dashboard(driver).clickOnKabelTVBurgerMenu()
                .clickOnMeinTarifList();
        new KabelTVPage(driver).expandBookableOptionAccordion()
                .validateBookableAccWhenThereCLSandMainTarif()
                .clickOnDropDwonListOnBookableOpAcc()
                .validateThereTwoKudnumbersInDDL()
                .validateFirstKudnumberInDDL(testData.getTestData(method.getName() + ".MeinTarifKudnumber"));
    }

    @TmsLink("WFBT-13056")
    @Test(description = "GC03 || KD TV user - Check when User having only a CLS tariff we shall list the CLS options available to the user normally identified by the contract number")
    public void GC03(Method method){
        new KD_Dashboard(driver).clickOnKabelTVBurgerMenu()
                .clickOnMeinTarifList();
        new KabelTVPage(driver).expandBookableOptionAccordion()
                .validateCLSTarifsKudnumerIsDisplayed(testData.getTestData(method.getName() + ".clsTarifKudnumber"));
    }

    @TmsLink("WFBT-13326")
    @Test(description = "GC04 || KD TV user - Check when User having a CLS tariff with no bookable options.")
    public void GC04(Method method){
        new KD_Dashboard(driver).clickOnKabelTVBurgerMenu()
                .clickOnMeinTarifList();
        new KabelTVPage(driver).expandBookableOptionAccordion()
                .validateCLSTarifsKudnumerIsDisplayed(testData.getTestData(method.getName() + ".clsTarifKudnumber"))
                .validateBookableoptionAccWithNoOps();
    }

    @TmsLink("WFBT-13327")
    @Test(description = "GC05 || KD TV user - Check when User having a CLS tariff and Mein Tariff with no bookable options for the Mein Tariff")
    public void GC05(Method method){
        new KD_Dashboard(driver).clickOnKabelTVBurgerMenu()
                .clickOnMeinTarifList();
        new KabelTVPage(driver).expandBookableOptionAccordion()
                .validateBookableAccWhenThereCLSandMainTarif()
                .validateTheresNoOptsForMeinTarif()
                .clickOnDropDwonListOnBookableOpAcc()
                .clickOnSecondOptionInDDL()
                .validateTheresNoOptsForCLSTarif();
    }
}