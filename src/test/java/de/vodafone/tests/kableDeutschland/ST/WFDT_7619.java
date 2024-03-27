package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.KIPSettings;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_7619")
public class WFDT_7619 extends ST_KableDeutschlandSetup {
   @TmsLink("WFDT-8610")
    @Test(description = "GC01 || Martin Consumer - Validate phone book settings in case user has Active Phonebook entry.",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .clickOnPhoneSettingSO()
                .validateActivePhoneBookEntry();

    }

    @TmsLink("WFDT-8611")
    @Test(description = "GC02 || Martin SOHO - Validate phone book settings in case user has No Phonebook entry.",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .clickOnPhoneSettingSO()
                .validateNoPhoneBookEntry();

    }

    @TmsLink("WFDT-8612")
    @Test(description = "GC03 || Martin SOHO - Validate phone book settings in case Phonebook entry is Locked.",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .clickOnPhoneSettingSO()
                .validateLockedPhoneBookEntry();

    }

    @TmsLink("WFDT-8613")
    @Test(description = "GC04 || Martin Consumer - Validate phone book settings in case user has more than 3 phone numbers.",groups = {"eCare"})
    private void gc04() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .clickOnPhoneSettingSO()
                .validateShowMoreButtonDisplayed()
                .clickOnShowMoreButton()
                .validateShowLessButtonDisplayed();

    }

    @TmsLink("WFDT-8689")
    @Test(description = "GC06 || Martin Consumer - Validate phone book settings in case user has less than 3 phone numbers.",groups = {"eCare"})
    private void gc06() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .clickOnPhoneSettingSO()
                .validateExpandableButtonNotDisplayed();
    }

    @TmsLink("WFDT-8615")
    @Test(description = "BC01 || Martin Consumer - Validate phone book settings in case of service failure.",groups = {"eCare"})
    private void bc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .clickOnPhoneSettingSO()
                .validatePhoneSettingAccFailure();

    }

}

