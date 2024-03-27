package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.KundenKontaktdaten;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("KableDeutschland")
@Feature("ST")
@Story("WFDT_4562")
public class WFDT_4562 extends ST_KableDeutschlandSetup {
    //Variables
    String[] listOfValidTelephoneNumbers = {"+491512345678", "0491512345678", "00491512345678", "01512345678", "01612345678", "01712345678"};

    //Test
    @TmsLink("WFDT-5294")
    @Test(description = "GC01 || Martin - Verify edit contact data details section without entering E-mail address",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver)
                .openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .clickOnEditContactDataButton();

        new KundenKontaktdaten(driver)
                .assertOnKontaktdatenAndernSection()
                .deleteTextBox(KundenKontaktdaten.telephoneNumberTextBoxLocator)
                .typeTelephoneNumberOnTextBox(KundenKontaktdaten.ValidMobileNumber)
                .deleteTextBox(KundenKontaktdaten.emailTextBoxLocator)
                .afterDeleteTextBoxHandler(KundenKontaktdaten.emailTextBoxLocator)
                .assertOnEmailErrorMessage()
                .typeEmailOnTextBox(KundenKontaktdaten.ValidEmail)
                .clickOnSaveButton()
                .assertOnUbersichtSectionReviewTitles()
                .clickOnConfirmButton()
                .clickOnConfirmationOverviewAccordion();
    }

    @TmsLink("WFDT-5295")
    @Test(description = "GC02 || Martin - Verify change phone number and check regex and number format",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver)
                .openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .clickOnEditContactDataButton();

        new KundenKontaktdaten(driver)
                .assertOnKontaktdatenAndernSection()
                .deleteTextBox(KundenKontaktdaten.telephoneNumberTextBoxLocator)
                .typeTelephoneNumberOnTextBox(KundenKontaktdaten.InvalidLandlineNumber)
                .clickOnEmailTextBox()
                .assertOnTelephoneNumberErrorMessage();

        //valid cases for right Telephone numbers
        for (int i = 0; i < listOfValidTelephoneNumbers.length; i++) {
            new KundenKontaktdaten(driver).deleteTextBox(KundenKontaktdaten.telephoneNumberTextBoxLocator);
            new KundenKontaktdaten(driver).typeTelephoneNumberOnTextBox(listOfValidTelephoneNumbers[i]);
            new KundenKontaktdaten(driver).assertOnLandlineRegexWFDT_4562();//Telephone Regex same as Landline Regex
        }
    }

    @TmsLink("WFDT-5296")
    @Test(description = " GC03 || Martin - Verify change not validated email address and check regex with phone number field empty",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver)
                .openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .clickOnEditContactDataButton();

        new KundenKontaktdaten(driver)
                .assertOnKontaktdatenAndernSection()
                .deleteTextBox(KundenKontaktdaten.telephoneNumberTextBoxLocator)
                .clickOnSaveButton()
                .assertOnEmptyTelephoneNumberFieldErrorMessage()
                .typeTelephoneNumberOnTextBox(KundenKontaktdaten.ValidMobileNumber)
                .assertOnLandlineRegexWFDT_4562()
                .deleteTextBox(KundenKontaktdaten.emailTextBoxLocator)
                .typeEmailOnTextBox(KundenKontaktdaten.ValidEmail)
                .assertOnEmailRegex()
                .clickOnSaveButton()
                .assertOnUbersichtSectionReviewTitles()
                .assertOnTelephoneBeforeOverviewSection()
                .assertOnEmailBeforeOverviewSection()
                .assertOnConfirmButtonText()
                .clickOnConfirmButton()
                .assertOnConfirmationMessage()
                .clickOnConfirmationOverviewAccordion()
                .assertOnEmailInOverviewSection();
    }

    @TmsLink("WFDT-5297")
    @Test(description = "GC04 || Martin- Verify change validated email address and check regex",groups = {"eCare"})
    private void gc04() {
        new Dashboard(driver)
                .openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .clickOnEditContactDataButton();

        new KundenKontaktdaten(driver)
                .assertOnKontaktdatenAndernSection()
                .deleteTextBox(KundenKontaktdaten.telephoneNumberTextBoxLocator)
                .typeTelephoneNumberOnTextBox(KundenKontaktdaten.ValidMobileNumber)
                .assertOnLandlineRegexWFDT_4562()
                .deleteTextBox(KundenKontaktdaten.emailTextBoxLocator)
                .typeEmailOnTextBox(KundenKontaktdaten.ValidEmail)
                .assertOnEmailRegex()
                .clickOnSaveButton()
                .assertOnUbersichtSectionReviewTitles()
                .assertOnTelephoneBeforeOverviewSection()
                .assertOnEmailBeforeOverviewSection()
                .assertOnConfirmButtonText()
                .clickOnConfirmButton()
                .assertOnConfirmationMessage()
                .clickOnConfirmationOverviewAccordion()
                .assertOnEmailInOverviewSection()
                .assertOnTelephoneInOverviewSection();
    }
}
