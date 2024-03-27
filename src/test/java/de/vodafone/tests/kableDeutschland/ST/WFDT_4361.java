package de.vodafone.tests.kableDeutschland.ST;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;


@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_4361")
public class WFDT_4361 extends ST_KableDeutschlandSetup {

    @TmsLink("WFDT-4747")
    @Test(description = "GC01 || Martin - Check 'Datenschutz' menu item in both products' burger menu",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).clickKabelTVBurgerMenu();
        new Dashboard(driver).validateDatenSchutzLinkout();
        new Dashboard(driver).clickDatenSchutzMenuItem();
        new MeineDaten(driver).validateDatenSchutzAccordion();
    }
}
