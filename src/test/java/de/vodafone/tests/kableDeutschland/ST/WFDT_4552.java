package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_4552")
public class WFDT_4552 extends ST_KableDeutschlandSetup {

    //Test
    @TmsLink("WFDT-5285")
    @Test(description = "GC01 || Martin - Verify Kunden-Kontaktdaten section in case of email not specified",groups = {"eCare"})
    private void gc01(){
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .validateContactDataSection()
                .validateContactDataTelephoneNumber()
                .validateContactDataEmailLabel()
                .validateContactDateEmailNotProvided()
                .validateContactDataEditButton();
    }

    @TmsLink("WFDT-5286")
    @Test(description = "GC02 || Martin - Verify Kunden-Kontaktdaten section in case of email validated",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .validateContactDataSection()
                .validateContactDataTelephoneNumber()
                .validateContactDataEmailLabel()
                .validateContactDataEmailIsProvided()
                .validateContactDataEditButton();
    }

    @TmsLink("WFDT-5287")
    @Test(description = "GC03 || Martin - Verify Kunden-Kontaktdaten section in case email not validated",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .validateContactDataSection()
                .validateContactDataTelephoneNumber()
                .validateContactDataEmailLabel()
                .validateContactDateEmailNotValidated()
                .validateContactDataEditButton();
    }

    @TmsLink("WFDT-5288")
    @Test(description = "GC04 || Martin - Verify Kunden-Kontaktdaten section in case of phone number not specified",groups = {"eCare"})
    private void gc04() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .validateContactDataSection()
                .validateContactDataTelephoneNumber()
                .validateContactDataTelephoneNumberNotProvided()
                .validateContactDataEmailLabel()
                .validateContactDataEditButton();
    }

    @TmsLink("WFDT-5289")
    @Test(description = "GC05 || Martin - Verify Login-Daten section with given and validated Login e-Mail address",groups = {"eCare"})
    private void gc05(){
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .validateLoginDataSection();
    }

}
