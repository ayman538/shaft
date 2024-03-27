package de.vodafone.tests.Solstice.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import de.vodafone.pages.Solstice.SolsticeMyAccount;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
@Epic("Solstice")
@Feature("SIT")
@Story("WFAT_12036")
public class WFAT_12036 extends SolsticeSITSetup {
    @TmsLink("WFAT-12270")
    @Test(description = "WFAT-12270 Given I'm a logged in as a Solstice user ,When  I visit the MyVF Account Mgmt area for Login Data then  I want to find my salutation/firstname/lastname in the personal data area, combined with a short information text box and a deactivated Edit Button.")
    private void GC02() {
        new SolsticeDashboard(driver).chooseLoginDatenFromMeinKonto();
        driver.assertThat().element(SolsticeMyAccount.PersonalDataTitle)
                .text().contains(SolsticeMyAccount.PersonalDataTitle_text)
                .withCustomReportMessage("Check that Personal data title don't exist in confirmation").perform();
        driver.assertThat().element(SolsticeMyAccount.ErrorMsgTitle)
                .text().contains(SolsticeMyAccount.ErrorMsgTitle_text)
                .withCustomReportMessage("Check that Personal data error title is exist ").perform();
        driver.assertThat().element(SolsticeMyAccount.ErrorMsgBody)
                .text().contains(SolsticeMyAccount.ErrorMsgBody_text)
                .withCustomReportMessage("Check that Personal data error title is exist ").perform();
    }
}