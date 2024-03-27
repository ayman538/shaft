package de.vodafone.tests.Solstice.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.SolsticeAusladen;
import de.vodafone.pages.Solstice.SolsticeAusladenConfirmation;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Solstice")
@Feature("SIT")
@Story("WFAT_12208")
public class WFAT_12208 extends SolsticeSetup {

    @Test(groups = {"WFAT_12208", "regression"})
    @Description(" Given  I'm a logged in Solstice user and the owner of the product/contract  " +
            "\nWhen   I click on Revoke delegation CTA" +
            "\n then  I want to be redirected to a page that asks me if I'm sure I want to revoke my access and explains what will happen if I confirmed the revoking and a Confirm CTA.")
    public void GCO1() {
        new SolsticeDashboard(driver)
                .chooseÜbersichtFromMeinKonto().chooseOtherAdminAccordion()
                .clickOnMoreDetails().clickOnAusladenButton();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeAusladen.PageHeader_text)
                .text().isEqualTo(SolsticeAusladen.PageHeader)
                        .withCustomReportMessage("check that same page header is exist")
                                .perform();
        Validations.assertThat()
                .element(driver.getDriver(),SolsticeAusladen.PageTitle_text)
                .text().isEqualTo(SolsticeAusladen.PageTitle)
                        .withCustomReportMessage("check that same page title is exist")
                                .perform();
        Validations.assertThat()
                .element(driver.getDriver(),SolsticeAusladen.PageDescription_text)
                .text().isEqualTo(SolsticeAusladen.PageDescription)
                .withCustomReportMessage("check that same page Description is exist")
                .perform();

      new SolsticeAusladen(driver).clickOnAusladen();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeAusladenConfirmation.NotificationTitle_text)
                .text().contains(SolsticeAusladenConfirmation.NotificationTitle)
                .withCustomReportMessage("check that same page  notification title is exist")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(),SolsticeAusladenConfirmation.NotificationDescription_text)
                .text().isEqualTo(SolsticeAusladenConfirmation.NotificationDescription)
                .withCustomReportMessage("check that same page  notification title is exist")
                .perform();




    }

}
