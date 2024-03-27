package de.vodafone.tests.Solstice.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import de.vodafone.pages.Solstice.SolsticeDeleteAccount;
import de.vodafone.pages.Solstice.SolsticeMyAccount;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Solstice")
@Feature("SIT")
@Story("WFAT_12040")
public class WFAT_12040 extends SolsticeSetup {

    public String deeplink = "https://simplicity.wf-de.vodafone.com/meinvodafone/account/verwaltung/loeschen";
    public String deeplinkAfterRedirection = "https://simplicity.wf-de.vodafone.com/meinvodafone/account/verwaltung/loeschen";

    @Test(groups = {"WFAT_12036", "regression"})
    @Description("Given I'm a logged in as a Legacy user ,When I open my account management page and click on delete my User account " +
            "then  I want to process that deletion as of today ")
    private void GC01() {
        new SolsticeDashboard(driver)
                .chooseLoginDatenFromMeinKonto();


        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyAccount.DeletionTitle)
                .text()
                .contains(SolsticeMyAccount.DeletionTitle_text)
                .withCustomReportMessage("Check that deletion title 't exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyAccount.DeletionBody)
                .text()
                .contains(SolsticeMyAccount.DeletionBody_text)
                .withCustomReportMessage("Check that deletion body exist")
                .perform();

        new SolsticeMyAccount(driver)
                .Accountdeletion();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeDeleteAccount.AccDeletionPageHeader)
                .text()
                .contains(SolsticeDeleteAccount.AccDeletionPageHeader_text)
                .withCustomReportMessage("Check that Deletion Page Header exist")
                .perform();

    }

    @Test(groups = {"WFAT_12036", "regression"})
    @Description("Given I'm a logged in as a Solstice user ,When  I visit the MyVF Account Mgmt area for Login Data " +
            "then  I want to find the CTA responsible for deletion is disabled and a message stating that I am not allowed to delete my User account, as this is not offered / allowed / possible")

    private void GC02() {
        new SolsticeDashboard(driver)
                .chooseLoginDatenFromMeinKonto();


        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyAccount.DeletionTitle)
                .text()
                .contains(SolsticeMyAccount.DeletionTitle_text)
                .withCustomReportMessage("Check that deletion title 't exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyAccount.DeletionBody)
                .text()
                .contains(SolsticeMyAccount.DeletionBody_text)
                .withCustomReportMessage("Check that deletion body exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyAccount.DeletionErrorTitle)
                .text()
                .contains(SolsticeMyAccount.DeletionErrorTitle_text)
                .withCustomReportMessage("Check that Deletion error title is exist ")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyAccount.DeletionErrorBody)
                .text()
                .contains(SolsticeMyAccount.DeletionErrorBody_text)
                .withCustomReportMessage("Check that Deletion error body is exist ")
                .perform();
    }


        @Test(groups = {"WFAT_12036", "regression"})
    @Description("Given I'm a logged in as a Solstice user ,When I request the deeplink for User account deletion " +
            "then will be redirected to the Account Mgmt page  ")
    private void GC03() {
        new SolsticeDashboard(driver);

        driver.browser().navigateToURL( deeplink, deeplinkAfterRedirection);

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyAccount.MyAccountHeader)
                .text()
                .contains(SolsticeMyAccount.MyAccountHeader_text)
                .withCustomReportMessage("Check that Account Mgmt Hader is exist")
                .perform();

    }
}