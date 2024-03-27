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
@Story("WFDT_4562")
public class WFDT_4562 extends SIT_KableDeutschlandSetup {

    //Variables
    String[] listOfValidTelephoneNumbers = {"+491512345678", "0491512345678", "00491512345678", "01512345678", "01612345678", "01712345678"};

    //Test
    @TmsLink("WFDT-5300")
    @Test(description = "GC01 || Martin - Verify edit contact data details section without entering E-mail address",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .clickOnEditContactDataButton();

        new KundenKontaktdaten(driver)
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

    @TmsLink("WFDT-5502")
    @Test(description = "GC02 || Martin - Verify change phone number and check regex and number format",groups = {"eCare"})
    private void gc02() throws InterruptedException {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .clickOnEditContactDataButton();

        new KundenKontaktdaten(driver)
                .deleteTextBox(KundenKontaktdaten.telephoneNumberTextBoxLocator)
                .typeTelephoneNumberOnTextBox(KundenKontaktdaten.InvalidLandlineNumber)
                .clickOnEmailTextBox();

        //valid cases for right Telephone numbers
        for (int i = 0; i < listOfValidTelephoneNumbers.length; i++) {
            new KundenKontaktdaten(driver)
                    .deleteTextBox(KundenKontaktdaten.telephoneNumberTextBoxLocator)
                    .typeTelephoneNumberOnTextBox(listOfValidTelephoneNumbers[i])
                    .assertOnLandlineRegexWFDT_4316();//Telephone Regex same as Landline Regex
        }
    }

}
