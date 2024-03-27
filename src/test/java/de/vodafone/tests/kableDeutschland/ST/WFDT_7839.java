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
@Story("WFDT_7839")
public class WFDT_7839 extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-7894")
    @Test(description = "GC01 || Martin consumer- Validate Homespot SO & accordion in case user has internet product",groups = {"eCare"})
    public void gc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .validateHomespotSO()
                .validateHomespotAccordion()
                .ExpandHomespotAccordion()
                .validateHomespotNotification();
    }

    @TmsLink("WFDT-7895")
    @Test(description = "GC02 || SOHO Martin - Validate Homespot SO & accordion in case use has internet product",groups = {"eCare"})
    public void gc02() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .validateHomespotSO()
                .validateHomespotAccordion()
                .ExpandHomespotAccordion()
                .validateHomespotNotification();
    }

    @TmsLink("WFDT-7896")
    @Test(description = "GC03 || Martin consumer - Validate Homespot Accordion and SO are not displayed in case the user has no internet product",groups = {"eCare"})
    public void gc03() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .validateHomespotSODoesNotExist()
                .validateHomespotAccordionDoesNotExist();

    }

    @TmsLink("WFDT-7932")
    @Test(description = "BC01|| martin consumer - Validate homespot accordion in case of service failure",groups = {"eCare"})
    public void bc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .ExpandHomespotAccordion()
                .validateHomespotServiceFailure();
    }
}

