package de.vodafone.tests.Solstice.ST;

import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import de.vodafone.pages.Solstice.SolsticePhoneNumberConfirmation;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Solstice")
@Feature("ST")
@Story("WFAT_12034")
public class WFAT_12034 extends SolsticeSTSetup {

    private String newPhoneNumber;
    private String smsCode;

    @TmsLink("WFAT-12166")
    @Test(description="WFAT-12166-Given I'm a logged in Solstice user," + " \nWhen I process the change phone number"
            + "\nThen I want the same old process of change phone number and find a notification stating that this phone number is going to be synced to solstice " +
            "\nand is going to be used as my Primary contact number")
    private void GC02_verifySolsticeFlow(Method method) {
        newPhoneNumber = testData.getTestData(method.getName() + ".phoneNum");
        smsCode = testData.getTestData(method.getName() + ".smsCode");
        new SolsticeDashboard(driver)
                .chooseLoginDatenFromMeinKonto()
                .changePhoneNumberOption()
                .changePhoneNumberActions(newPhoneNumber)
                .addSmsCode(smsCode);

        Validations.assertThat()
                .element(driver.getDriver(), SolsticePhoneNumberConfirmation.notificationTitle_text)
                .text()
                .contains(SolsticePhoneNumberConfirmation.confirmationNotificationTitle)
                .withCustomReportMessage("Check that notification title exist in confirmation")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticePhoneNumberConfirmation.notificationDescription_text)
                .text()
                .contains(SolsticePhoneNumberConfirmation.confirmationNotificationDescription)
                .withCustomReportMessage("Check that notification description exist in confirmation")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticePhoneNumberConfirmation.headerTitle_text)
                .text()
                .contains(SolsticePhoneNumberConfirmation.confirmationHeaderTitle)
                .withCustomReportMessage("Check that  title exist in change phone number confirmation screen")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticePhoneNumberConfirmation.smsCodeRufnummer)
                .text()
                .contains(newPhoneNumber)
                .withCustomReportMessage("Check that phone number in confirmation screen is the same changed number")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticePhoneNumberConfirmation.hauptrufnummer)
                .text().contains(newPhoneNumber)
                .withCustomReportMessage("Check that phone number in confirmation screen is the same changed number")
                .perform();
    }

    @TmsLink("WFAT-12165")
    @Test(description="WFAT-12165-Given I'm a logged in MyVF user (not mapped to a Solstice Party ID)"
            + "\nWhen I process the change phone number" +
            "\nThen I want to process the same old process of change phone number")
    private void GC01_verifyLegacyFlow(Method method) {
        newPhoneNumber = testData.getTestData(method.getName() + ".phoneNum");
        smsCode = testData.getTestData(method.getName() + ".smsCode");

        new SolsticeDashboard(driver)
                .chooseLoginDatenFromMeinKonto()
                .changePhoneNumberOption()
                .changePhoneNumberActions(newPhoneNumber)
                .addSmsCode(smsCode);

        Validations.assertThat()
                .element(driver.getDriver(), SolsticePhoneNumberConfirmation.notificationTitle_text)
                .text()
                .contains(SolsticePhoneNumberConfirmation.confirmationNotificationTitle)
                .withCustomReportMessage("Check that notification title exist in confirmation")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticePhoneNumberConfirmation.notificationDescription_text)
                .text()
                .contains(SolsticePhoneNumberConfirmation.confirmationNotificationDescription)
                .withCustomReportMessage("Check that notification description exist in confirmation")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticePhoneNumberConfirmation.hauptrufnummer)
                .doesNotExist()
                .withCustomReportMessage("check that hauptrufnummer does not exist in case of legacy user")
                .perform();
    }
}