package de.vodafone.tests.kableDeutschland.SIT;

import de.vodafone.pages.Kabledeutschland.BankDetails;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("SIT")
@Story("WFDT_5830")
public class WFDT_5830 extends SIT_KableDeutschlandSetup{
    //Variables
    public static String IBan = "DE89370400440532013000";

    //Test
    @TmsLink("WFDT-6765")
    @Test(description = "GC01 || Martin - Validate edit bank account details in case user has single invoice with single bank account",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver).ExpandBankDetailsAccordion();

        new BankDetails(driver)
                .EditFirstBankDetails()
                .ValidateFirstStepOfEditBankDetails()
                .SubmitFirstStepOfEditBank()
                .ValidateSecondStepOfEditBankDetails()
                .SubmitSecondStepOfEditBank()
                .SubmitSecondStepOfEditBank()
                .ValidateConfirmationSuccessForSingleContract()
                .clickOnConfirmedDetailsAcc_Title()
                .ValidateConfirmationAccordionDetails();
    }

    @TmsLink("WFDT-6765")
    @Test(description = "GC03 || Martin SOHO - Validate edit bank account details in case user has single invoice with single bank account",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver).ExpandBankDetailsAccordion();

        new BankDetails(driver)
                .EditFirstBankDetails()
                .ValidateFirstStepOfEditBankDetails()
                .SubmitFirstStepOfEditBank()
                .ValidateSecondStepOfEditBankDetails()
                .SubmitSecondStepOfEditBank()
                .ValidateConfirmationSuccessForSingleContract()
                .clickOnConfirmedDetailsAcc_Title()
                .ValidateConfirmationAccordionDetails();

    }

}
