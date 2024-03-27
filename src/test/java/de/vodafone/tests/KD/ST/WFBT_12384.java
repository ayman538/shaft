package de.vodafone.tests.KD.ST;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.KabelTVPage;

@Epic("KD")
@Feature("ST")
@Story("WFBT-12384")

public class WFBT_12384 extends ST_KDSetup {
    @TmsLink("WFBT-12479")
    @Test(description = "WFBT-12479 || GC01 || KD user has booked TV option | Check booked option with price")
    private void gc01() {
        new KD_Dashboard(driver).clickOnKabelTVBurgerMenu()
                .clickOnMeinTarifList();
        new KabelTVPage(driver).expandBookedOptionAcc()
                .validateBookedOptionWithPrice();
    }

    @TmsLink("WFBT-12480")
    @Test(description = "WFBT-12480 || GC02 |KD user has booked TV option | Check booked Free option")
    private void gc02() {
        new KD_Dashboard(driver).clickOnKabelTVBurgerMenu()
                .clickOnMeinTarifList();
        new KabelTVPage(driver).expandBookedOptionAcc()
                .clickOnDropDownAndChooseSecondContactID()
                .validateBookedOptionForFree();
    }

    @TmsLink("WFBT-12481")
    @Test(description = "WFBT-12481 || GC03|KD user has booked TV option | Check booked negative price")
    private void gc03(Method method) {
        new KD_Dashboard(driver).clickOnKabelTVBurgerMenu()
                .clickOnMeinTarifList();
        new KabelTVPage(driver).expandBookedOptionAcc()
                .validateBookedOptionNegativePriceKabelTV(testData.getTestData(method.getName() + ".bookedOptionNegativePriceTVCL")
                        ,testData.getTestData(method.getName() + ".bookedOptionCurrencyCL")
                        ,testData.getTestData(method.getName() + ".bookedOptionNegativePriceTextTVCL")
                        ,testData.getTestData(method.getName() + ".bookedOptionNegativePriceNotificationTVCL"));
    }

    @TmsLink("WFBT-12482")
    @Test(description = "WFBT-12482 || GC04|KD user has booked TV option | Priced option that is not cancellable online")
    private void gc04() {
        new KD_Dashboard(driver).clickOnKabelTVBurgerMenu()
                .clickOnMeinTarifList();
        new KabelTVPage(driver).expandBookedOptionAcc()
                .clickOnDropDownAndChooseSecondContactID()
                .validateBookedOptionNotCancellable();
    }

    @TmsLink("WFBT-12483")
    @Test(description = "WFBT-12483 || GC05|KD user has booked TV option | Check Missing email notification (Cancellation CTA is dimmed)")
    private void gc05() {
        new KD_Dashboard(driver).clickOnKabelTVBurgerMenu()
                .clickOnMeinTarifList();
        new KabelTVPage(driver).expandBookedOptionAcc()
                .validateCanellationBtnDimmed();
    }

    @TmsLink("WFBT-12484")
    @Test(description = "WFBT-12484 || GC06|KD user has booked TV option | Check Missing email notification CTA redirects to the right link")
    private void gc06() {
        new KD_Dashboard(driver).clickOnKabelTVBurgerMenu()
                .clickOnMeinTarifList();
        new KabelTVPage(driver).expandBookedOptionAcc()
                .clickOnAddEmailAddress()
                .validateMissingEmailBtnRedirection();
    }

    @TmsLink("WFBT-12485")
    @Test(description = "WFBT-12485 || GC07|KD user has booked TV option | Check if details link appeared it should redirect to details page successfully.")
    private void gc07() {
        new KD_Dashboard(driver).clickOnKabelTVBurgerMenu()
                .clickOnMeinTarifList();
        new KabelTVPage(driver).expandBookedOptionAcc()
                .clickOnDetailsLink()
                .validateRedirectionofDetailsLink();
    }

    @TmsLink("WFBT-12487")
    @Test(description = "WFBT-12487 || BC01 |KD user has booked TV option | Check when Booked Options accordion failed to Load")
    private void bc01() {
        new KD_Dashboard(driver).clickOnKabelTVBurgerMenu()
                .clickOnMeinTarifList();
        new KabelTVPage(driver)
                .validateThatBookedOptionFailed();
    }
}