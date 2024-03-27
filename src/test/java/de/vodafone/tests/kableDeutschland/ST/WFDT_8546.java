package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.DeletePhoneBook;
import de.vodafone.pages.Kabledeutschland.KIPSettings;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("KableDeutschland")
@Feature("ST")
@Story("WFDT_8546")
public class WFDT_8546 extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-8627")
    @Test(description = "GC01 || Martin Consumer - validate Delete phone book entry in case Success confirmation message is displayed.",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnPhoneSettingSO()
                .clickOnDeletePhoneBookButton();

        new DeletePhoneBook(driver)
                .validateDeletePageReview()
                .clickOnDeletePhoneBookEntry()
                .validateDeletePhoneBookConformationMessage();
    }

    @TmsLink("WFDT-8629")
    @Test(description = "GC02 || Martin Consumer - validate that Delete phone book entry Deep linking is disabled.",groups = {"eCare"})
    private void gc02() {
        new KIPSettings(driver).validateDeletePhoneBookDeepLinkingIsDisabled();
    }


    @TmsLink("WFDT-8628")
    @Test(description = "BC01 || Martin SOHO - validate Delete phone book entry in case Failure confirmation message is displayed.",groups = {"eCare"})
    private void bc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnPhoneSettingSO()
                .clickOnDeletePhoneBookButton();

        new DeletePhoneBook(driver)
                .validateDeletePageReview()
                .clickOnDeletePhoneBookEntry()
                .validateDeletePhoneBookErrorMessage();
    }

}

