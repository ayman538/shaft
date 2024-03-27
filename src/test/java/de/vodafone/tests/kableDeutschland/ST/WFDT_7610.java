package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.KIPSettings;
import de.vodafone.pages.Kabledeutschland.PhoneLineSettings;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("KableDeutschland")
@Feature("ST")
@Story("WFDT_7610")
public class WFDT_7610 extends ST_KableDeutschlandSetup {

    @TmsLink("WFDT-8599")
    @Test(description = "GC01 || Martin Consumer - Validate change phoneline configuration settings with 3 numbers per line.",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .expandPhoneLineAcc()
                .validateMainNumberSectionDisplayed()
                .clickOnPhoneLineEditButton();

        new PhoneLineSettings(driver)
                .validatePhoneLineSettingPage()
                .selectThreeNumberForLineOne()
                .selectThreeNumberForLineTwo()
                .validateNumbersForDDLLineOne()
                .validateNumbersForDDLLineTwo()
                .clickOnSaveButton()
                .validateConformationMessage();
    }

    @TmsLink("WFDT-8600")
    @Test(description = "GC02 || Martin SOHO - Validate change phoneline configuration settings with only number per line.",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .expandPhoneLineAcc()
                .validateMainNumberSectionDisplayed()
                .clickOnPhoneLineEditButton();

        new PhoneLineSettings(driver)
                .validatePhoneLineSettingPage()
                .selectOneNumberForLineOne()
                .selectOneNumberForLineTwo()
                .validateOneNumberReflectedForDDLLineOne()
                .validateOneNumberReflectedInDDLLineTwo()
                .clickOnSaveButton()
                .validateConformationMessage();
    }

    @TmsLink("WFDT-8601")
    @Test(description = "GC03 || Martin SOHO - Validate change phoneline configuration settings with more than 3 numbers per line.",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .expandPhoneLineAcc()
                .validateMainNumberSectionDisplayed()
                .clickOnPhoneLineEditButton();

        new PhoneLineSettings(driver)
                .validatePhoneLineSettingPage()
                .selectThreeNumberForLineOne()
                .selectNumbersForLineTwo()
                .validateNumbersForDDLLineOne()
                .validateNumbersForDDLLineTwo()
                .clickOnSaveButton()
                .validateConformationMessage();
    }

    @TmsLink("WFDT-8602")
    @Test(description = "GC04 || Martin Consumer - Validate that phoneline configuration settings Deeplinking is disabled.",groups = {"eCare"})
    private void gc04() {
        new KIPSettings(driver).validateDeepLinkingIsDisabledPhoneLine();
    }

    @TmsLink("WFDT-8607")
    @Test(description = "GC05|| Martin Consumer - Validate phoneline configuration settings in case user with a homebox router.",groups = {"eCare"})
    private void gc05() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .expandPhoneLineAcc()
                .validateMainNumberSectionNotDisplayed();
    }

    @TmsLink("WFDT-8608")
    @Test(description = "BC01 || Martin Consumer - Validate change phoneline configuration settings with 1 number per line in case of service failure.",groups = {"eCare"})
    private void bc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .expandPhoneLineAcc()
                .validateMainNumberSectionDisplayed()
                .clickOnPhoneLineEditButton();

        new PhoneLineSettings(driver)
                .validatePhoneLineSettingPage()
                .selectThreeNumberForLineOne()
                .selectThreeNumberForLineTwo()
                .validateNumbersForDDLLineOne()
                .validateNumbersForDDLLineTwo()
                .clickOnSaveButton()
                .validateErrorMessage();
    }

}
