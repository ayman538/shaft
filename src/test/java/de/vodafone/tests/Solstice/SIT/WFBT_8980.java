package de.vodafone.tests.Solstice.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.OneLoginForEverything;
import de.vodafone.pages.Solstice.SolsticeMyAccount;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("Solstice")
@Feature("SIT")
public class WFBT_8980 extends SolsticeSetup {



    @Test(groups = {"WFBT_8980", "regression"})
    @Description(" Given I am a user who merged two user accounts and got to the confirmation page with the data overview,Then I should find one CTA button to direct me to the respective account management accordion")
    private void GC01() {

        new OneLoginForEverything(driver)
                .navigateMergeConfirmation()
                .editMyDataBtn();

        new SolsticeMyAccount(driver).waitUntilMienKontoOpen();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyAccount.MyAccountHeader)
                .text()
                .contains(SolsticeMyAccount.MyAccountHeader_text)
                .withCustomReportMessage("Check that Account Mgmt Hader is exist")
                .perform();


    }
    private void GC02() {

        new OneLoginForEverything(driver)
                .navigateMergeConfirmation()
                .editMyDataBtn();

        new SolsticeMyAccount(driver).waitUntilMienKontoOpen();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyAccount.MyAccountHeader)
                .text()
                .contains(SolsticeMyAccount.MyAccountHeader_text)
                .withCustomReportMessage("Check that Account Mgmt Hader is exist")
                .perform();


    }
    private void GC03() {

        new OneLoginForEverything(driver)
                .navigateMergeConfirmation()
                .editMyDataBtn();

        new SolsticeMyAccount(driver).waitUntilMienKontoOpen();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyAccount.MyAccountHeader)
                .text()
                .contains(SolsticeMyAccount.MyAccountHeader_text)
                .withCustomReportMessage("Check that Account Mgmt Hader is exist")
                .perform();


    }
    private void GC04() {

        new OneLoginForEverything(driver)
                .navigateMergeConfirmation()
                .editMyDataBtn();

        new SolsticeMyAccount(driver).waitUntilMienKontoOpen();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyAccount.MyAccountHeader)
                .text()
                .contains(SolsticeMyAccount.MyAccountHeader_text)
                .withCustomReportMessage("Check that Account Mgmt Hader is exist")
                .perform();


    }
    private void GC05() {

        new OneLoginForEverything(driver)
                .navigateMergeConfirmation()
                .editMyDataBtn();

        new SolsticeMyAccount(driver).waitUntilMienKontoOpen();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyAccount.MyAccountHeader)
                .text()
                .contains(SolsticeMyAccount.MyAccountHeader_text)
                .withCustomReportMessage("Check that Account Mgmt Hader is exist")
                .perform();


    }

}








