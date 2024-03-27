package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.*;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class WFBT_12005 extends ST_KDSetup {

    @TmsLink("WFBT_12026")
    @Test(description = "GC01 Check the Mein tariff navigation from the burger menu in the dashboard for Kabel-TV")
    public void GC01_CheckMeinTariffNavigationFromBurgerMenu(){
        new KD_Dashboard(driver).expandKabelTvAccordion()
                .clickMeinTariffButtonFromBurgerMenuTV();
        new KabelTVPage(driver).validateMeinTariffAccordionExpanded();
    }

    @TmsLink("WFBT_12027")
    @Test(description = "GC02 Check that the Overview button shall be removed from the burger menu in dashboard for Kabel-TV")
    public void GC02_CheckOverviewButtonRemovedFromKabelTVDashboard(){
        new KD_Dashboard(driver).expandKabelTvAccordion()
        .clickMeinTariffButtonFromBurgerMenuTV()
        .validateNotExistenceOfOverviewButtontv();
    }

    @TmsLink("WFBT_12028")
    @Test(description = "GC03 Check that Meine TV Optionen SO redirection to the booked options accordion in the tariff detail page expanded for Kabel-TV")
    public void GC03_CheckMeinTVOptionenSORedirectionToBookedOptionAccordion(){
        new KD_Dashboard(driver).expandKabelTvAccordion()
                .clickOnMeinTVOptionenSOTV();
        new KabelTVPage(driver).validateBookedOptionFAccordionDetails();
    }

    @TmsLink("WFBT_12029")
    @Test(description = "GC04 Check the Exklusive Angebote SO redirection for Kabel-TV")
    public void GC04_CheckExklusiveAngeboteSORedirectionForKabelTV(){
        new KD_Dashboard(driver).expandKabelTvAccordion()
                .clickOnExklusiveAngeboteSOTV();
        new ExclusiveOfferPage(driver).validateExclusiveOfferURLTV();
    }

    @TmsLink("WFBT_12030")
    @Test(description = "GC05 Check the TV Einstellungen SO redirection for Kabel-TV")
    public void GC05_CheckEinstellungenSORedirectionForKabelTV(){
        new KD_Dashboard(driver).expandKabelTvAccordion()
                .clickOnTVSettingSOTV();
        new SettingPage(driver).validateTVSettingURL();
    }

    @TmsLink("WFBT_12031")
    @Test(description = "GC06 Check the Phone Settings SO redirection for the KIP")
    public void GC06_CheckPhoneSettingSORedirectionForKIP(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .clickOnPhoneSettingSOKIP();
        new SettingPage(driver).validatePhoneSettingURL();
    }

    @TmsLink("WFBT_12032")
    @Test(description = "GC07 Check the Exklusive Angebote SO redirection for TV")
    public void GC07_CheckExklusiveAngeboteSORedirectionForTV(){
        new KD_Dashboard(driver).expandKabelTvAccordion()
                .clickOnExklusiveAngeboteSOKIP();
        new ExclusiveOfferPage(driver).validateExclusiveOfferURLKip();
    }

    @TmsLink("WFBT_12033")
    @Test(description = "GC08 Check the Tariff Change SO shall redirect to the tariff change section in the KIP tariff detail page.")
    public void GC08_CheckTariffChangeSORedirectToTariffChangeSectionInKIPTariffPage(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .clickOnTariffChangeSOKIP();
        new TariffPageInternetAndPhone(driver).validateChangeTariffHeader();
    }

    @TmsLink("WFBT_12035")
    @Test(description = "GC10 Check that the Overview button shall be removed from the burger menu in dashboard for KIP contract")
    public void GC10_CheckOverviewButtonRemovedFromBurgerMenuDashboardForKIP(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
            .openBurgerMenu()
            .validateNotExistenceOfOverviewButtonkip();
    }
}