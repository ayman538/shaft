package de.vodafone.tests.Solstice.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import de.vodafone.pages.Solstice.SolsticeSimilarAccountAccordion;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Solstice")
@Feature("SIT")
@Story("WFAT_11778")
public class WFAT_11778 extends SolsticeSetup {

    @Test(groups = {"WFAT_11778", "regression"})
    @Description(" Given As a User with any (Mobile,DSL,Cable) MBO  ,\nWhen I open other admins accordion," +
            "\n then  I want to find list of my contracts, in each contract I want to find the number of other admins, and more info collapsible panel. ")
    private void GC01_VerifyMobileWithAdmins() {
        new SolsticeDashboard(driver)
                .chooseÜbersichtFromMeinKonto()
                .chooseOtherAdminAccordion();
        Validations.assertThat().element(driver.getDriver(), SolsticeSimilarAccountAccordion.numberOfAdmins_text)
                .text().equals(SolsticeSimilarAccountAccordion.numberOfAdmins);
        new SolsticeSimilarAccountAccordion(driver).clickOnMoreDetails();
        Validations.assertThat().element(driver.getDriver(), SolsticeSimilarAccountAccordion.phoneAdminTitle)
                .text().equals(SolsticeSimilarAccountAccordion.Title);
        Validations.assertThat().element(driver.getDriver(), SolsticeSimilarAccountAccordion.phoneAdminDescription)
                .text().equals(SolsticeSimilarAccountAccordion.Description);

    }

    @Test(groups = {"WFAT_11778", "regression"})
    @Description(" Given As a User with any (Mobile,DSL,Cable) MBO  ,\nWhen I open other admins accordion," +
            "\n then  I want to find list of my contracts, in each contract I want to find the number of other admins, and more info collapsible panel. ")
    private void GC02_VerifyMobileWithOutAdmins() {
        new SolsticeDashboard(driver)
                .chooseÜbersichtFromMeinKonto()
                .chooseOtherAdminAccordion();
        Validations.assertThat().element(driver.getDriver(), SolsticeSimilarAccountAccordion.numberOfAdmins_text)
                .text().equals(SolsticeSimilarAccountAccordion.numberOfAdmins);
        Validations.assertThat().element(driver.getDriver(), SolsticeSimilarAccountAccordion.numberOfAdminsValue)
                .text().equals(SolsticeSimilarAccountAccordion.zeroAdmins);


    }

    @Test(groups = {"WFAT_11778", "regression"})
    @Description(" Given As a User with UM MBO  ,\nWhen I open other admins accordion," +
            "\n then  I want to find number of invited account  ")
    private void GC03_VerifyUMWithInvitations() {
        new SolsticeDashboard(driver)
                .chooseÜbersichtFromMeinKonto()
                .chooseOtherAdminAccordion().clickOnMoreForUM();
        Validations.assertThat().element(driver.getDriver(), SolsticeSimilarAccountAccordion.UMtitle_text)
                .equals(SolsticeSimilarAccountAccordion.UMTitle);
        Validations.assertThat().element(driver.getDriver(), SolsticeSimilarAccountAccordion.UMMoretitle_text)
                .equals(SolsticeSimilarAccountAccordion.UMMoreTitle);
        Validations.assertThat().element(driver.getDriver(), SolsticeSimilarAccountAccordion.inviteButton_Buttton)
                .text().equals(SolsticeSimilarAccountAccordion.inviteButton);


    }
}
