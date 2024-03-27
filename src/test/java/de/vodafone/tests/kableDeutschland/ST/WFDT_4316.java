package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.KundenKontaktdaten;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_4316")
public class WFDT_4316 extends ST_KableDeutschlandSetup {
    //Variables
    String[] listOfValidMobileNumbers = {"+491512345678", "0491512345678", "00491512345678", "01512345678", "01612345678", "01712345678"};

    //Test
    @TmsLink("WFDT-4599")
    @Test(description = "GC01 || Martin - Verify edit contact data details section without entering E-mail address",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver)
                .openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .clickOnEditContactDataButton();

        //edit contact data section
        new KundenKontaktdaten(driver)
                .assertOnKontaktdatenAndernSection()
                .deleteTextBox(KundenKontaktdaten.mobilePhoneTextBoxLocator)
                .typeMobileNumberOnTextBox(KundenKontaktdaten.ValidMobileNumber)
                .deleteTextBox(KundenKontaktdaten.emailTextBoxLocator)
                .afterDeleteTextBoxHandler(KundenKontaktdaten.emailTextBoxLocator)
                .assertOnEmailErrorMessage()
                .typeEmailOnTextBox(KundenKontaktdaten.ValidEmail)
                .clickOnSaveButton();

        //review section
        new KundenKontaktdaten(driver)
                .assertOnUbersichtSectionReviewTitles()
                .assertOnMobileInOverviewSection()
                .assertOnEmailInOverviewSection()
                .assertOnConfirmButtonText()
                .clickOnConfirmButton();
    }

    @TmsLink("WFDT-4600")
    @Test(description = "GC02 || Martin - Verify change Landline phone number and check regex and number format",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver)
                .openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .clickOnEditContactDataButton();

        //edit contact data section
        new KundenKontaktdaten(driver)
                .assertOnKontaktdatenAndernSection()
                .deleteTextBox(KundenKontaktdaten.landlineTextBoxLocator)
                .typeLandlineNumberOnTextBox(KundenKontaktdaten.InvalidLandlineNumber)
                .clickOnMobileTextBox()
                .assertOnLandlineErrorMessage();

        //valid landline number
        new KundenKontaktdaten(driver)
                .deleteTextBox(KundenKontaktdaten.landlineTextBoxLocator)
                .typeLandlineNumberOnTextBox(KundenKontaktdaten.ValidLandlineNumber)
                .assertOnLandlineRegexWFDT_4316();
    }

    @TmsLink("WFDT-4601")
    @Test(description = "GC03 || Martin - Verify change Mobile phone number and check regex and number format",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver)
                .openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

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
            new KundenKontaktdaten(driver).deleteTextBox(KundenKontaktdaten.mobilePhoneTextBoxLocator);
            new KundenKontaktdaten(driver).typeMobileNumberOnTextBox(listOfValidMobileNumbers[i]);
            new KundenKontaktdaten(driver).assertOnMobileRegex();
        }
    }

    @TmsLink("WFDT-4602")
    @Test(description = " GC04 || Martin - Verify change not validated email address and check regex with one phone number field empty",groups = {"eCare"})
    private void gc04() {
        new Dashboard(driver)
                .openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .clickOnEditContactDataButton();

        //edit contact data section
        new KundenKontaktdaten(driver)
                .assertOnKontaktdatenAndernSection()
                .deleteTextBox(KundenKontaktdaten.mobilePhoneTextBoxLocator)
                .typeMobileNumberOnTextBox(KundenKontaktdaten.ValidMobileNumber)
                .assertOnMobileRegex()
                .deleteTextBox(KundenKontaktdaten.emailTextBoxLocator)
                .typeEmailOnTextBox(KundenKontaktdaten.ValidEmail)
                .assertOnEmailRegex()
                .clickOnSaveButton();

        //review section
        new KundenKontaktdaten(driver)
                .assertOnUbersichtSectionReviewTitles()
                .assertOnMobileInOverviewSection()
                .assertOnEmailInOverviewSection()
                .assertOnConfirmButtonText()
                .clickOnConfirmButton();
    }

    @TmsLink("WFDT-4603")
    @Test(description = "GC05 || Martin- Verify change validated email address and check regex",groups = {"eCare"})
    private void gc05() {
        new Dashboard(driver)
                .openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .clickOnEditContactDataButton();

        //edit contact data section
        new KundenKontaktdaten(driver)
                .assertOnKontaktdatenAndernSection()
                .deleteTextBox(KundenKontaktdaten.mobilePhoneTextBoxLocator)
                .typeMobileNumberOnTextBox(KundenKontaktdaten.ValidMobileNumber)
                .assertOnMobileRegex()
                .deleteTextBox(KundenKontaktdaten.landlineTextBoxLocator)
                .typeLandlineNumberOnTextBox(KundenKontaktdaten.ValidLandlineNumber)
                .assertOnLandlineRegexWFDT_4316()
                .deleteTextBox(KundenKontaktdaten.emailTextBoxLocator)
                .typeEmailOnTextBox(KundenKontaktdaten.ValidEmail)
                .assertOnEmailRegex()
                .clickOnSaveButton();

        //review section
        new KundenKontaktdaten(driver)
                .assertOnUbersichtSectionReviewTitles()
                .assertOnMobileInOverviewSection()
                .assertOnLandlineInOverviewSection()
                .assertOnEmailInOverviewSection()
                .assertOnConfirmButtonText()
                .clickOnConfirmButton();

        //Confirmation section
        /*
        assertOnConfirmationMessage(); //not develop yet
        new KundenKontaktdaten(driver).clickOnConfirmationOverviewAccordion();
        assertOnUbersichtAccordionConfirmationTitles();
        assertOnMobileInOverviewSection();
        assertOnLandlineInOverviewSection();
        assertOnEmailInOverviewSection();
        */
    }

}