//package de.vodafone.tests.Solstice.ST;
//import de.vodafone.pages.Solstice.SolsticeDashboard;
//import de.vodafone.pages.Solstice.SolsticeMeineDaten;
//import io.qameta.allure.Epic;
//import io.qameta.allure.Feature;
//import io.qameta.allure.TmsLink;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import java.lang.reflect.Method;
//
//@Epic("Solstice")
//@Feature("ST")
//public class WFDT_7999 extends SolsticeSTSetup {
//    SolsticeDashboard dashboard;
//    SolsticeMeineDaten meineDaten;
//
//    @TmsLink("WFDT-8104")
//    @Test(description = "GC01 || Sophie - Validate first Link-out with its direction.")
//    public void GC01 () {
//        dashboard.openMeineKundenDatenTile(SolsticeDashboard.DashboardSmartObject.MEINEKUNDENDATEN);
//        meineDaten.pressOnSmartObject(SolsticeMeineDaten.MeineDatenSmartObjects.DatenschutzAndWerbeeinstellungen);
//        meineDaten.validateFirstLinkOut();
//        meineDaten.validatePrivacyPageTitle();
//
//    }
//    @TmsLink("WFDT-8106")
//    @Test(description = "GC03 || Sophie - Validate second Link-out with its direction.")
//    public void GC02 () {
//        dashboard.openMeineKundenDatenTile(SolsticeDashboard.DashboardSmartObject.MEINEKUNDENDATEN);
//        meineDaten.pressOnSmartObject(SolsticeMeineDaten.MeineDatenSmartObjects.DatenschutzAndWerbeeinstellungen);
//        meineDaten.validateSecondLinkOut();
//        meineDaten.validateDataProtectionLinkOut();
//    }
//    @BeforeMethod
//    public void setUp(Method method){
//        dashboard =  new SolsticeDashboard(driver);
//        meineDaten = new SolsticeMeineDaten(driver);
//    }
//}
