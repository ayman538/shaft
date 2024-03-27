//package de.vodafone.tests.Solstice.ST;
//import de.vodafone.pages.Solstice.SolsticeDashboard;
//import de.vodafone.pages.Solstice.SolsticeMeineDaten;
//import io.qameta.allure.Epic;
//import io.qameta.allure.Feature;
//import io.qameta.allure.TmsLink;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.lang.reflect.Method;
//
//
//@Epic("Solstice")
//@Feature("ST")
//public class WFDT_7996 extends SolsticeSTSetup {
//    SolsticeDashboard dashboard;
//    SolsticeMeineDaten meineDaten;
//
//    @TmsLink("WFDT-8118")
//    @Test(description = "GC01 || Sophie - Validate that the accordion and a smart object 'Datenschutz & Werbeeinstellungen' is unhidden.")
//    public void GC01 () {
//        dashboard.openMeineKundenDatenTile(SolsticeDashboard.DashboardSmartObject.MEINEKUNDENDATEN);
//        meineDaten.validateDatenschutzSmartObjectIsUnhidden();
//        meineDaten.validateDatenschutzAccordionIsUnhidden();
//    }
//
//    @TmsLink("WFDT-8119")
//    @Test(description = "GC02 || Sophie - Validate that 'Datenschutz' item is unhidden in KIP accordion's.")
//    public void GC02 () {
//        dashboard.openMeineKundenDatenTile(SolsticeDashboard.DashboardSmartObject.MEINEKUNDENDATEN);
//        dashboard.openBurgerMenuOfMyProductAcc();
//        dashboard.validatePrivacyOptionisUnhidden();
//        dashboard.clickOnPrivacyOpeion();
//        meineDaten.validateRedirectionSuccessfullyToMeineDaten();
//    }
//
//    @BeforeMethod
//    public void setUp(Method method){
//        dashboard =  new SolsticeDashboard(driver);
//        meineDaten = new SolsticeMeineDaten(driver);
//    }
//}
