package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_4298")
public class WFDT_4298 extends ST_KableDeutschlandSetup {

    //Test
    @TmsLink("WFDT-4590")
    @Test(description ="GC01 || Martin - Verify Login-Daten section with given and validated Login e-Mail address",groups = {"eCare"})
    private void gc01(){
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .AssertLoginDataInCaseValidatedEmail();
    }

    @TmsLink("WFDT-4591")
    @Test(description ="GC02 || Martin -Verify Kunden-Kontaktdaten section in case of phone number not given and Not validated contract E-Mail Address",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .AssertLoginDataInCaseNotValidatedEmailAndNPhone();
    }

    @TmsLink("WFDT-4592")
    @Test(description ="GC03 || Martin - Verify Kunden-Kontaktdaten section in case of mobile number and E-mail not provided, phone number provided",groups = {"eCare"})
    private void gc03() {
//        new Dashboard(driver).openAccordion(Dashboard.DashboardAccordion.KABELVERTRAG);
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .AssertLoginDataInCaseNoEmailNoMobile();
    }

}


