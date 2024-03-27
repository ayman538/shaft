package de.vodafone.tests.eShop.ST;

import de.vodafone.pages.eShop.DeviceListPage;
import de.vodafone.pages.eShop.ManufacturersPage;
import de.vodafone.pages.eShop.RedPlusEshopDashboardPage;
import de.vodafone.pages.eShop.eShop_Dashboard;
import io.qameta.allure.*;
import org.testng.annotations.*;

@Epic("eShop")
@Feature("ST")
@Story("WFHT-916")
public class WFHT_916 extends ST_eShop_Setup {

    @TmsLink("WFHT-940")
    @Test(description = "GC01 - Check Generic DOP Page Headers")
    public void GC01() {
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlow();

        new DeviceListPage(driver)
                .validateHeaderAndSubHeaderCL();
    }

    @TmsLink("WFHT-941")
    @Test(description = "GC02 - Check Red+ (FamilyCard S) DOP Page Headers")
    public void GC02() {
        new RedPlusEshopDashboardPage(driver)
                .deepLinkToTariffFirstFlowFamilyCardS();
        new DeviceListPage(driver)
                .validateRedPlusHeaderAndSubHeaderCLFamilyCardS();
    }

    @TmsLink("WFHT-942")
    @Test(description = "GC03 - Check Red+ (FamilyCard M) DOP Page Headers")
    public void GC03() {
        new RedPlusEshopDashboardPage(driver)
                .deepLinkToTariffFirstFlowFamilyCardM();

        new DeviceListPage(driver)
                .validateRedPlusHeaderAndSubHeaderCLFamilyCardM();

    }

    @TmsLink("WFHT-943")
    @Test(description = "GC04 - Check Red+ (FamilyCard L) DOP Page Headers")
    public void GC04() {
        new RedPlusEshopDashboardPage(driver)
                .deepLinkToTariffFirstFlowFamilyCardL();

        new DeviceListPage(driver)
                .validateRedPlusHeaderAndSubHeaderCLFamilyCardL();

    }

    @TmsLink("WFHT-944")
    @Test(description = "GC05 - Check SOHO DOP Page Headers - Device First Flow")
    public void GC05() {
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlow();

        new DeviceListPage(driver)
                .validateSohoHeaderAndSubHeaderCL();

    }

    @TmsLink("WFHT-945")
    @Test(description = "GC06 - Check SOHO DOP Page Headers - Tariff First Flow")
    public void GC06() {
        new eShop_Dashboard(driver)
                .deepLinkToTariffFirstFlowSoho();

        new DeviceListPage(driver)
                .validateSohoHeaderAndSubHeaderCL();
    }

    @TmsLink("WFHT-946")
    @Test(description = "GC07 - Check Manufacturer's (Samsung) page DOP Headers")
    public void GC07(){
        new eShop_Dashboard(driver)
                .deepLinkToTariffFirstFlowConsumer();

        new ManufacturersPage(driver)
                .validateOnPageHeaderInCaseSamsung()
                .validateOnSubPageHeaderInCaseSamsung();
    }

    @TmsLink("WFHT-967")
    @Test(description = "GC11 - Check Young DOP Page Headers - Device First Flow")
    public void GC11() {
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlow();

        new DeviceListPage(driver)
                .validateYoungHeaderCL();
    }

    @TmsLink("WFHT-968")
    @Test(description = "GC12 - Check Young DOP Page Headers - Tariff First Flow")
    public void GC12() {
        new eShop_Dashboard(driver)
                .deepLinkToTariffFirstFlowYoung();

        new DeviceListPage(driver)
                .validateYoungHeaderCL();
    }
}








