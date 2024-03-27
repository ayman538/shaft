package de.vodafone.tests.kableDeutschland.SIT;

import de.vodafone.pages.Kabledeutschland.MeineDaten;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("SIT")
@Story("WFDT_6205")
public class WFDT_6205 extends SIT_KableDeutschlandSetup {
    @TmsLink("WFDT-7156")
    @Test(description = "GC03 || SOHO - Validate billing address in case different addresses for all products and service address",groups = {"eCare"})
    private void gc03() {
        new MeineDaten(driver)
                .navigateToAddressesAccordion()
                .validateAccountOwnerInfoForSOHO()
                .validateUsedForLabel()
                .validateReferenceAccount0001()
                .CheckInfoIconForProduct1()
                .validateChangeBillingAddressButton()
                .validateAccountOwnerInfoForSOHO()
                .validateAccountInfoForServiceAddressesForSOHO();
    }

    @TmsLink("WFDT-7159")
    @Test(description = "GC06 || Validate service address in case no billing address",groups = {"eCare"})
    private void gc06() {
        new MeineDaten(driver)
                .navigateToAddressesAccordion()
                .validateNoBillingAddressNotification()
                .validateAccountInfoForServiceAddressesForSOHO();
    }

}
