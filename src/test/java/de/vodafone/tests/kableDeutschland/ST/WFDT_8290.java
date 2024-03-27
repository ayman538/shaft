package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.KundenKontaktdaten;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("KableDeutschland")
@Feature("ST")
@Story("WFDT_8290")
public class WFDT_8290 extends ST_KableDeutschlandSetup{

    @TmsLink("WFDT-8328")
    @Test(description = "GC01 || Martin Consumer - Verify Partial Success Message for changing Contact Data",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).clickOnMeineDatenButton();
        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .clickOnEditContactDataButton();

        new KundenKontaktdaten(driver)
                .typeMobileNumberConsumer(KundenKontaktdaten.ValidMobileNumber)
                .deleteTextBox(KundenKontaktdaten.landlineTextBoxLocator)
                .typeLandlineNumberOnTextBox(KundenKontaktdaten.ValidLandlineNumber)
                .deleteTextBox(KundenKontaktdaten.emailTextBoxLocator)
                .typeEmailOnTextBox(KundenKontaktdaten.ValidEmail)
                .clickOnSaveButton()
                .clickOnConfirmButton()
                .validatePhoneNumberPartialSuccessMessage();
    }

    @TmsLink("WFDT-8329")
    @Test(description = "GC02 || Martin SOHO - Verify Partial Success Message for changing Contact Data",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).clickOnMeineDatenButton();
        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .clickOnEditContactDataButton();

        new KundenKontaktdaten(driver)
                .typeMobileNumberSoho(KundenKontaktdaten.ValidMobileNumber)
                .deleteTextBox(KundenKontaktdaten.emailTextBoxLocator)
                .typeEmailOnTextBox(KundenKontaktdaten.ValidEmail)
                .clickOnSaveButton()
                .clickOnConfirmButton()
                .validatePhoneNumberPartialSuccessMessage();
    }

    @TmsLink("WFDT-8331")
    @Test(description = "GC03 || Martin Consumer - Verify Success Message for changing Contact Data",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).clickOnMeineDatenButton();
        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .clickOnEditContactDataButton();

        new KundenKontaktdaten(driver)
                .typeMobileNumberConsumer(KundenKontaktdaten.ValidMobileNumber)
                .deleteTextBox(KundenKontaktdaten.landlineTextBoxLocator)
                .typeLandlineNumberOnTextBox(KundenKontaktdaten.ValidLandlineNumber)
                .deleteTextBox(KundenKontaktdaten.emailTextBoxLocator)
                .typeEmailOnTextBox(KundenKontaktdaten.ValidEmail)
                .clickOnSaveButton()
                .clickOnConfirmButton()
                .validatePhoneNumberSuccessMessage();
    }

    @TmsLink("WFDT-8332")
    @Test(description = "GC04 || Martin SOHO - Verify Success Message for changing Contact Data",groups = {"eCare"})
    private void gc04() {
        new Dashboard(driver).clickOnMeineDatenButton();
        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .clickOnEditContactDataButton();

        new KundenKontaktdaten(driver)
                .typeMobileNumberSoho(KundenKontaktdaten.ValidMobileNumber)
                .deleteTextBox(KundenKontaktdaten.emailTextBoxLocator)
                .typeEmailOnTextBox(KundenKontaktdaten.ValidEmail)
                .clickOnSaveButton()
                .clickOnConfirmButton()
                .validatePhoneNumberSuccessMessage();
    }

    @TmsLink("WFDT-8333")
    @Test(description = "BC01 || Martin Consumer - Verify Failure Message for changing Contact Data",groups = {"eCare"})
    private void bc01() {
        new Dashboard(driver).clickOnMeineDatenButton();
        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .clickOnEditContactDataButton();

        new KundenKontaktdaten(driver).typeMobileNumberConsumer(KundenKontaktdaten.InvalidNumberBadCase)
                .deleteTextBox(KundenKontaktdaten.landlineTextBoxLocator)
                .typeLandlineNumberOnTextBox(KundenKontaktdaten.InvalidPrivateNumberBadCase)
                .deleteTextBox(KundenKontaktdaten.emailTextBoxLocator)
                .typeEmailOnTextBox(KundenKontaktdaten.InvalidMailBadCase)
                .clickOnSaveButton()
                .clickOnConfirmButton()
                .validatePhoneNumberErrorMessage();
    }

    @TmsLink("WFDT-8334")
    @Test(description = "BC02 || Martin SOHO - Verify Failure Message for changing Contact Data",groups = {"eCare"})
    private void bc02() {
        new Dashboard(driver).clickOnMeineDatenButton();
        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .clickOnEditContactDataButton();

        new KundenKontaktdaten(driver).typeMobileNumberSoho(KundenKontaktdaten.InvalidNumberBadCase)
                .deleteTextBox(KundenKontaktdaten.emailTextBoxLocator)
                .typeEmailOnTextBox(KundenKontaktdaten.InvalidMailBadCase)
                .clickOnSaveButton()
                .clickOnConfirmButton()
                .validatePhoneNumberErrorMessage();
    }

}
