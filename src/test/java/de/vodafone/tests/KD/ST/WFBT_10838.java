package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.MeinTarifPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("KD")
@Feature("ST")
@Story("Tariff detail page | Show available tariffs for internet & phone")
public class WFBT_10838 extends ST_KDSetup {

    @Test(description = "GC01 || WFBT-11567 || Check that user can show available options (each available tariff should have USP)")
    @TmsLink("WFBT-11567")
    public void GC01() {
    new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
            .closeNotification()
            .clickMeinTariffSmartObject();
    new MeinTarifPage(driver).validateChangeTariffHeader()
            .validateAvailableTariffs();
    }

    @Test(description = "GC02 || WFBT-11568 || Check that the user is on the best tariff.")
    @TmsLink("WFBT-11568")
    public void GC02(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .closeNotification()
                .clickMeinTariffSmartObject();
        new MeinTarifPage(driver).validateChangeTariffHeader()
                .validateUserOnBestTariff();
    }

    @Test(description = "GC03 ||WFBT-11569 || Check Tarif wechseln CTA redirects to the right link.")
    @TmsLink("WFBT-11569")
    public void GC03(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .closeNotification()
                .clickMeinTariffSmartObject();
        new MeinTarifPage(driver).validateChangeTariffHeader()
                .validateAvailableTariffs()
                .validateChangeTariffCTA();
    }

    @Test(description = "GC04 || WFBT-11570 || Check that the customer has open work orders/web orders, Make sure that Meine Aufträge anzeigen CTA redirects to right page.")
    @TmsLink("WFBT-11570")
    public void GC04(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .closeNotification()
                .clickMeinTariffSmartObject();
        new MeinTarifPage(driver).validateUserHasOpenWorkOrder()
                .validateOpenWorkOrderCTA();
    }

    @Test(description = "GC05 || WFBT-11571 || Check that the customer already has a digital TV product.")
    @TmsLink("WFBT-11571")
    public void GC05(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .closeNotification()
                .clickMeinTariffSmartObject();
        new MeinTarifPage(driver).validateUserHasDigitalTVProduct();
    }

    @Test(description = "GC06 || WFBT-11572 || Check that the customer is an employee (customer class MA) or SOHO")
    @TmsLink("WFBT-11572")
    public void GC06(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .closeNotification()
                .clickMeinTariffSmartObject();
        new MeinTarifPage(driver).validateUserSOHOCustomer();
    }

    @Test(description = "WFBT-11573 ||GC07 ||  Check that customer is in the dunning process.")
    @TmsLink("WFBT-11573")
    public void GC07(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .closeNotification()
                .clickMeinTariffSmartObject();
        new MeinTarifPage(driver).validateUserIsInDunningProcess();
    }

    @Test(description = "WFBT-11574 || GC08 || Check that the customer has phone-only products.")
    @TmsLink("WFBT-11574")
    public void GC08(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .closeNotification()
                .clickMeinTariffSmartObject();
        new MeinTarifPage(driver).validateUserHasPhoneOnlyProduct();
    }

    @Test(description = "WFBT-11575 || GC09 || Check that the customer has a VVO address.")
    @TmsLink("WFBT-11575")
    public void GC09(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .closeNotification()
                .clickMeinTariffSmartObject();
        new MeinTarifPage(driver).validateUserHasVVOAddress();
    }

    @Test(description = "WFBT-11577 ||GC10 ||  Check Notification card appears in mein tariff internet in case I have an easy product Unity Media only")
    @TmsLink("WFBT-11577")
    public void GC10(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .closeNotification()
                .clickMeinTariffSmartObject();
        new MeinTarifPage(driver).validateUserHasEazyProduct()
                 .clickEazyProductCTA()
                .validateEazyProductPage();
    }

    @Test(description = "WFBT-11578 || GC11 || Check Notification card appears in mein tariff internet in case I have a 3Play product Unity Media only")
    @TmsLink("WFBT-11578")
    public void GC11(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .closeNotification()
                .clickMeinTariffSmartObject();
        new MeinTarifPage(driver).validateUserHas3PProduct();
    }

    @Test(description = "GC12 || user NOT eligible for tariff change | Check that The customer is not eligible for tariff change-general case.")
    @TmsLink("WFBT-11579")
    public void GC12(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .closeNotification()
                .clickMeinTariffSmartObject();
        new MeinTarifPage(driver).validateChangeTariffHeader()
                .validateUserOnBestTariff();
    }

    @Test(description = "BC01 || WFBT-11750 || Check Notification card appears in mein tariff internet in case API doesn’t load")
    @TmsLink("WFBT-11750")
    public void BC01(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .closeNotification()
                .clickMeinTariffSmartObject();
        new MeinTarifPage(driver).validateAPIDoesNotLoadErrorMsg();
    }

    @Test(description = "BC02 || WFBT-11751 || user NOT eligible for tariff change | Check Notification card appears in mein tariff internet in case Backend Error")
    @TmsLink("WFBT-11751")
    public void BC02(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .closeNotification()
                .clickMeinTariffSmartObject();
        new MeinTarifPage(driver).validateBEErrorMsg();
    }
}