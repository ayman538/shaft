package de.vodafone.tests.Solstice.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Solstice")
@Feature("SIT")
@Story("WFAT_13012")
public class WFAT_13012 extends SolsticeSetup {

    @Test(groups = {"WFAT_13018", "regression"})
    @Description(" Given  I am a logged in User browsing the MyVF Dashboard " +
            "\nWhen    I click on the \"my account\" icon" +
            "\n then  I want to find an additional link to the \"other admin\" accordion at the end of the list (to keep the same order as accordions in acct mgmt.")
    public void GCO1() {

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeDashboard.OtherAdmin_link)
                .text().isEqualTo(SolsticeDashboard.OtherAdmin)
                .withCustomReportMessage("check that other admin link has same name ")
                .perform();
        new SolsticeDashboard(driver).chooseOtherAdminFromMeinKonto();
        Validations.assertThat()
                .browser(driver.getDriver()).url()
                .contains("accordion=similarAccounts")
                .withCustomReportMessage("Check that link redirect to other admin accordion ")
                .perform();


    }
}
