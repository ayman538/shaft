package de.vodafone.tests.kableDeutschland.SIT;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.KundenKontaktdaten;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("SIT")
@Story("WFDT_4316")
public class WFDT_4316 extends SIT_KableDeutschlandSetup{
    //Variables
    String[] listOfValidMobileNumbers = {"+491512345678", "0491512345678", "00491512345678", "01512345678", "01612345678", "01712345678"};

    // Tests
    @TmsLink("WFDT-5259")
    @Test(description = "GC02 || Martin - Verify change Landline phone number and check regex and number format",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .clickOnEditContactDataButton();

        new KundenKontaktdaten(driver)
                .assertOnKontaktdatenAndernSection()
                .deleteTextBox(KundenKontaktdaten.landlineTextBoxLocator)
                .typeLandlineNumberOnTextBox(KundenKontaktdaten.InvalidLandlineNumber)
                .clickOnMobileTextBox()
                .assertOnLandlineErrorMessage()
                .deleteTextBox(KundenKontaktdaten.landlineTextBoxLocator)
                .typeLandlineNumberOnTextBox(KundenKontaktdaten.ValidLandlineNumber)
                .assertOnLandlineRegexWFDT_4316();
    }

    @TmsLink("WFDT-5260")
    @Test(description = "GC03 || Martin - Verify change Mobile phone number and check regex and number format",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .clickOnEditContactDataButton();

        //edit contact data section
        new KundenKontaktdaten(driver)
                .assertOnKontaktdatenAndernSection()
                .deleteTextBox(KundenKontaktdaten.mobilePhoneTextBoxLocator)
                .typeMobileNumberOnTextBox(KundenKontaktdaten.InvalidMobileNumber)
                .clickOnLandlineTextBox()
                .assertOnMobileErrorMessage();

        //valid cases for right mobile numbers
        for (int i = 0; i < listOfValidMobileNumbers.length; i++) {
            new KundenKontaktdaten(driver)
                    .deleteTextBox(KundenKontaktdaten.mobilePhoneTextBoxLocator)
                    .typeMobileNumberOnTextBox(listOfValidMobileNumbers[i])
                    .assertOnMobileRegex();
        }

    }

}
