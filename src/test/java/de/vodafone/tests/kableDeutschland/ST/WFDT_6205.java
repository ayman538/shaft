package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.MeineDaten;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_6205")
public class WFDT_6205 extends ST_KableDeutschlandSetup {

    @TmsLink("WFDT-6354")
    @Test(description = "Validate billing address in case one address for all products and service address",groups = {"eCare"})
    private void gc01() {
        new MeineDaten(driver).navigateToAddressesAccordion();
        new MeineDaten(driver).validateAddressesAccordionTitleAndDescription();
        new MeineDaten(driver).validateAccountOwnerInfoForCustomer();
        new MeineDaten(driver).validateUsedForLabel();
        new MeineDaten(driver).validateReferenceAccount0001();
        new MeineDaten(driver).validateKIP_Product();
        new MeineDaten(driver).CheckInfoIconForProduct1();
        new MeineDaten(driver).validateTV_Product();
        new MeineDaten(driver).CheckInfoIconForProduct2();
        new MeineDaten(driver).validateReferenceAccount0002();
        new MeineDaten(driver).validateCLS_Product();
        new MeineDaten(driver).CheckInfoIconForProduct3();
        new MeineDaten(driver).validateChangeBillingAddressButton();
        new MeineDaten(driver).validateStoreDifferentBillingAddressesLink();
        new MeineDaten(driver).validateServiceAddressesTitleAndDescription();
        new MeineDaten(driver).validateAccountInfoForServiceAddressesForConsumer();
    }

    @TmsLink("WFDT-6380")
    @Test(description = "Validate billing address in case two different addresses for all products",groups = {"eCare"})
    private void gc02() {
        new MeineDaten(driver).navigateToAddressesAccordion();
        new MeineDaten(driver).validateAddressesAccordionTitleAndDescription();
        new MeineDaten(driver).validateChangeAllAddressesNotification();
        new MeineDaten(driver).validateAccountOwnerInfoForCustomer();
        new MeineDaten(driver).validateUsedForLabel();
        new MeineDaten(driver).validateReferenceAccount0001();
        new MeineDaten(driver).validateKIP_Product();
        new MeineDaten(driver).CheckInfoIconForProduct1();
        new MeineDaten(driver).validateReferenceAccount0002();
        new MeineDaten(driver).validateTV_Product();
        new MeineDaten(driver).CheckInfoIconForProduct2();
        new MeineDaten(driver).validateChangeBillingAddressButton();
        new MeineDaten(driver).validateStoreDifferentBillingAddressesLink();
        new MeineDaten(driver).validateAccountOwnerInfoForCustomer2();
        new MeineDaten(driver).validateUsedForLabel2();
        new MeineDaten(driver).validateReferenceAccount0003();
        new MeineDaten(driver).validateCLS_Product();
        new MeineDaten(driver).CheckInfoIconForProduct3();
        new MeineDaten(driver).validateChangeBillingAddressButton2();
        new MeineDaten(driver).validateServiceAddressesTitleAndDescription();
        new MeineDaten(driver).validateAccountInfoForServiceAddressesForConsumer();
    }

    @TmsLink("WFDT-6387")
    @Test(description = "Validate billing address in case different addresses for all products",groups = {"eCare"})
    private void gc03() {
        new MeineDaten(driver).navigateToAddressesAccordion();
        new MeineDaten(driver).validateAddressesAccordionTitleAndDescription();
        new MeineDaten(driver).validateChangeAllAddressesNotification();
        new MeineDaten(driver).validateAccountOwnerInfoForCustomer();
        new MeineDaten(driver).validateUsedForLabel();
        new MeineDaten(driver).validateReferenceAccount0001();
        new MeineDaten(driver).validateKIP_Product();
        new MeineDaten(driver).CheckInfoIconForProduct1();
        new MeineDaten(driver).validateChangeBillingAddressButton();
        new MeineDaten(driver).validateAccountOwnerInfoForCustomer2();
        new MeineDaten(driver).validateUsedForLabel2();
        new MeineDaten(driver).validateReferenceAccount0002();
        new MeineDaten(driver).validateTV_Product();
        new MeineDaten(driver).CheckInfoIconForProduct2();
        new MeineDaten(driver).validateChangeBillingAddressButton2();
        new MeineDaten(driver).validateAccountOwnerInfoForCustomer3();
        new MeineDaten(driver).validateUsedForLabel3();
        new MeineDaten(driver).validateReferenceAccount0003();
        new MeineDaten(driver).validateCLS_Product();
        new MeineDaten(driver).CheckInfoIconForProduct3();
        new MeineDaten(driver).validateChangeBillingAddressButton3();
        new MeineDaten(driver).validateServiceAddressesTitleAndDescription();
        new MeineDaten(driver).validateAccountInfoForServiceAddressesForConsumer();

    }

    @TmsLink("WFDT-6393")
    @Test(description = "SOHO - Validate billing address in case different addresses for all products and service address",groups = {"eCare"})
    private void gc04() {
        new MeineDaten(driver).navigateToAddressesAccordion();
        new MeineDaten(driver).validateAddressesAccordionTitleAndDescription();
        new MeineDaten(driver).validateChangeAllAddressesNotification();
        new MeineDaten(driver).validateAccountOwnerInfoForSOHO();
        new MeineDaten(driver).validateUsedForLabel();
        new MeineDaten(driver).validateReferenceAccount0001();
        new MeineDaten(driver).validateKIP_Product();
        new MeineDaten(driver).CheckInfoIconForProduct1();
        new MeineDaten(driver).validateChangeBillingAddressButton();
        new MeineDaten(driver).validateAccountOwnerInfoForSOHO2();
        new MeineDaten(driver).validateUsedForLabel2();
        new MeineDaten(driver).validateReferenceAccount0002();
        new MeineDaten(driver).validateTV_Product();
        new MeineDaten(driver).CheckInfoIconForProduct2();
        new MeineDaten(driver).validateChangeBillingAddressButton2();
        new MeineDaten(driver).validateAccountOwnerInfoForSOHO3();
        new MeineDaten(driver).validateUsedForLabel3();
        new MeineDaten(driver).validateReferenceAccount0003();
        new MeineDaten(driver).validateCLS_Product();
        new MeineDaten(driver).CheckInfoIconForProduct3();
        new MeineDaten(driver).validateServiceAddressesTitleAndDescription();
        new MeineDaten(driver).validateAccountInfoForServiceAddressesForSOHO();
    }

    @TmsLink("WFDT-6454")
    @Test(description = "Validate service address in case no billing address",groups = {"eCare"})
    private void gc05() {
        new MeineDaten(driver).navigateToAddressesAccordion();
        new MeineDaten(driver).validateAddressesAccordionTitleAndDescription();
        new MeineDaten(driver).validateNoBillingAddressNotification();
        new MeineDaten(driver).validateServiceAddressesTitleAndDescription();
        new MeineDaten(driver).validateAccountInfoForServiceAddressesForConsumer();
    }

    @TmsLink("WFDT-6924")
    @Test(description = "Martin in Dunning State - Validate billing address in case two different addresses for all products",groups = {"eCare"})
    private void gc07() {
        new MeineDaten(driver).navigateToAddressesAccordion();
        new MeineDaten(driver).validateAddressesAccordionTitleAndDescription();
        new MeineDaten(driver).validateBillingDunningNotification();
        new MeineDaten(driver).validateAccountOwnerInfoForCustomer();
        new MeineDaten(driver).validateUsedForLabel();
        new MeineDaten(driver).validateReferenceAccount0001();
        new MeineDaten(driver).validateKIP_Product();
        new MeineDaten(driver).CheckInfoIconForProduct1();
        new MeineDaten(driver).validateTV_Product();
        new MeineDaten(driver).CheckInfoIconForProduct2();
        new MeineDaten(driver).validateDimmedChangeBillingAddressButton();
        new MeineDaten(driver).validateAccountOwnerInfoForCustomer2();
        new MeineDaten(driver).validateUsedForLabel2();
        new MeineDaten(driver).validateReferenceAccount0002();
        new MeineDaten(driver).validateCLS_Product();
        new MeineDaten(driver).CheckInfoIconForProduct3();
        new MeineDaten(driver).validateDimmedChangeBillingAddressButton2();
        new MeineDaten(driver).validateServiceAddressesTitleAndDescription();
        new MeineDaten(driver).validateAccountInfoForServiceAddressesForConsumer();
    }

    @TmsLink("WFDT-6455")
    @Test(description = "BC - Check billing and service addresses in case of service failure",groups = {"eCare"})
    private void bc01() {
        new MeineDaten(driver).navigateToAddressesAccordion();
        new MeineDaten(driver).validateBadCaseNotification();
    }
}
