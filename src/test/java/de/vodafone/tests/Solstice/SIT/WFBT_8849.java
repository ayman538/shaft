package de.vodafone.tests.Solstice.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.ChangePassword;
import de.vodafone.pages.Solstice.ChangePasswordConfirmation;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static de.vodafone.pages.Solstice.ChangePasswordConfirmation.ConfirmationMsgBodyTXT;
import static de.vodafone.pages.Solstice.ChangePasswordConfirmation.ConfirmationMsgHeaderTXT;

@Epic("Solstice")
@Feature("SIT")
public class WFBT_8849 extends SolsticeSetup {



    @Test(groups = {"WFBT_8849", "regression"})
    @Description("Given I'm a logged in user, I want to find a CTA button for changing my password, so that I can change it without accessing any other data.")
    private void GC01() {

        new SolsticeDashboard(driver)
                .chooseLoginDatenFromMeinKonto()
                .changePassword();

        Validations.assertThat()
                .element(driver.getDriver(), ChangePassword.PageHeader)
                .text().contains(ChangePassword.PageHeaderTxt);

        Validations.assertThat()
                .browser(driver.getDriver()).url().contains(ChangePassword.URL);

        new ChangePassword(driver)
                .fillOldPassword(ChangePassword.OldPasswordTxt)
                .fillNewPassword(ChangePassword.NewPasswordTxt)
                .repeatPassword(ChangePassword.NewPasswordTxt)
                .submitNewPassword();

        Validations.assertThat()
                .element(driver.getDriver(), ChangePasswordConfirmation.ConfirmationMsgHeader)
                .text().contains(ConfirmationMsgHeaderTXT);

        Validations.assertThat()
                .element(driver.getDriver(), ChangePasswordConfirmation.ConfirmationMsgBody)
                .text().contains(ConfirmationMsgBodyTXT);

    }

    @Test(groups = {"WFBT_8849", "regression"})
    private void GC02() {

        new SolsticeDashboard(driver)
                .handleMarieException()
                .chooseLoginDatenFromMeinKonto()
                .changePassword();

        Validations.assertThat()
                .element(driver.getDriver(), ChangePassword.PageHeader)
                .text().contains(ChangePassword.PageHeaderTxt);

        Validations.assertThat()
                .browser(driver.getDriver()).url().contains(ChangePassword.URL);

        new ChangePassword(driver)
                .fillOldPassword(ChangePassword.OldPasswordTxt)
                .fillNewPassword(ChangePassword.NewPasswordTxt)
                .repeatPassword(ChangePassword.NewPasswordTxt)
                .submitNewPassword();

        Validations.assertThat()
                .element(driver.getDriver(), ChangePasswordConfirmation.ConfirmationMsgHeader)
                .text().contains(ConfirmationMsgHeaderTXT);

        Validations.assertThat()
                .element(driver.getDriver(), ChangePasswordConfirmation.ConfirmationMsgBody)
                .text().contains(ConfirmationMsgBodyTXT);

    }

    @Test(groups = {"WFBT_8849", "regression"})
    private void GC03() {

        new SolsticeDashboard(driver)
                .chooseLoginDatenFromMeinKonto()
                .changePassword();

        Validations.assertThat()
                .element(driver.getDriver(), ChangePassword.PageHeader)
                .text().contains(ChangePassword.PageHeaderTxt);

        Validations.assertThat()
                .browser(driver.getDriver()).url().contains(ChangePassword.URL);

        new ChangePassword(driver)
                .fillOldPassword(ChangePassword.OldPasswordTxt)
                .fillNewPassword(ChangePassword.NewPasswordTxt)
                .repeatPassword(ChangePassword.NewPasswordTxt)
                .submitNewPassword();

        Validations.assertThat()
                .element(driver.getDriver(), ChangePasswordConfirmation.ConfirmationMsgHeader)
                .text().contains(ConfirmationMsgHeaderTXT);

        Validations.assertThat()
                .element(driver.getDriver(), ChangePasswordConfirmation.ConfirmationMsgBody)
                .text().contains(ConfirmationMsgBodyTXT);

    }

    @Test(groups = {"WFBT_8849", "regression"})
    private void GC04() {

        new SolsticeDashboard(driver)
                .chooseLoginDatenFromMeinKonto()
                .changePassword();

        Validations.assertThat()
                .element(driver.getDriver(), ChangePassword.PageHeader)
                .text().contains(ChangePassword.PageHeaderTxt);

        Validations.assertThat()
                .browser(driver.getDriver()).url().contains(ChangePassword.URL);

        new ChangePassword(driver)
                .fillOldPassword(ChangePassword.OldPasswordTxt)
                .fillNewPassword(ChangePassword.NewPasswordTxt)
                .repeatPassword(ChangePassword.NewPasswordTxt)
                .submitNewPassword();

        Validations.assertThat()
                .element(driver.getDriver(), ChangePasswordConfirmation.ConfirmationMsgHeader)
                .text().contains(ConfirmationMsgHeaderTXT);

        Validations.assertThat()
                .element(driver.getDriver(), ChangePasswordConfirmation.ConfirmationMsgBody)
                .text().contains(ConfirmationMsgBodyTXT);

    }

    @Test(groups = {"WFBT_8849", "regression"})
    private void GC05() {

        new SolsticeDashboard(driver)
                .chooseLoginDatenFromMeinKonto()
                .changePassword();

        Validations.assertThat()
                .element(driver.getDriver(), ChangePassword.PageHeader)
                .text().contains(ChangePassword.PageHeaderTxt);

        Validations.assertThat()
                .browser(driver.getDriver()).url().contains(ChangePassword.URL);

        new ChangePassword(driver)
                .fillOldPassword(ChangePassword.OldPasswordTxt)
                .fillNewPassword(ChangePassword.NewPasswordTxt)
                .repeatPassword(ChangePassword.NewPasswordTxt)
                .submitNewPassword();

        Validations.assertThat()
                .element(driver.getDriver(), ChangePasswordConfirmation.ConfirmationMsgHeader)
                .text().contains(ConfirmationMsgHeaderTXT);

        Validations.assertThat()
                .element(driver.getDriver(), ChangePasswordConfirmation.ConfirmationMsgBody)
                .text().contains(ConfirmationMsgBodyTXT);

    }

    @Test(groups = {"WFBT_8849", "regression"})
    private void GC07() {

        new SolsticeDashboard(driver)
                .handlePersonalBenefitsException()
                .chooseLoginDatenFromMeinKonto()
                .changePassword();

        Validations.assertThat()
                .element(driver.getDriver(), ChangePassword.PageHeader)
                .text().contains(ChangePassword.PageHeaderTxt);

        Validations.assertThat()
                .browser(driver.getDriver()).url().contains(ChangePassword.URL);

        new ChangePassword(driver)
                .fillOldPassword(ChangePassword.OldPasswordTxt)
                .fillNewPassword(ChangePassword.NewPasswordTxt)
                .repeatPassword(ChangePassword.NewPasswordTxt)
                .submitNewPassword();

        Validations.assertThat()
                .element(driver.getDriver(), ChangePasswordConfirmation.ConfirmationMsgHeader).text().contains(ConfirmationMsgHeaderTXT);

        Validations.assertThat()
                .element(driver.getDriver(), ChangePasswordConfirmation.ConfirmationMsgBody)
                .text().contains(ConfirmationMsgBodyTXT);

        new ChangePassword(driver)
                .navigateChangePassword()
                .fillOldPassword(ChangePassword.OldPasswordTxt_SIT)
                .fillNewPassword(ChangePassword.NewPasswordTxt_SIT)
                .repeatPassword(ChangePassword.NewPasswordTxt_SIT)
                .submitNewPassword();

    }

    @Test(groups = {"WFBT_8849", "regression"})
    private void GC08() {

        new SolsticeDashboard(driver)
                //  .handlePersonalBenefitsException()
                .chooseLoginDatenFromMeinKonto()
                .changePassword();

        Validations.assertThat()
                .element(driver.getDriver(), ChangePassword.PageHeader)
                .text().contains(ChangePassword.PageHeaderTxt);

        Validations.assertThat()
                .browser(driver.getDriver()).url().contains(ChangePassword.URL);

        new ChangePassword(driver)
                .fillOldPassword(ChangePassword.OldPasswordTxt)
                .fillNewPassword(ChangePassword.NewPasswordTxt)
                .repeatPassword(ChangePassword.NewPasswordTxt)
                .submitNewPassword();

        Validations.assertThat()
                .element(driver.getDriver(), ChangePasswordConfirmation.ConfirmationMsgHeader).text().contains(ConfirmationMsgHeaderTXT);

        Validations.assertThat()
                .element(driver.getDriver(), ChangePasswordConfirmation.ConfirmationMsgBody)
                .text().contains(ConfirmationMsgBodyTXT);

        new ChangePassword(driver)
                .navigateChangePassword()
                .fillOldPassword(ChangePassword.OldPasswordTxt_SIT)
                .fillNewPassword(ChangePassword.NewPasswordTxt_SIT)
                .repeatPassword(ChangePassword.NewPasswordTxt_SIT)
                .submitNewPassword();

    }


}








