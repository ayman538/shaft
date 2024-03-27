package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.KabelTVPage;
import de.vodafone.pages.KD.TariffPageInternetAndPhone;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("KD")
@Feature("ST")
@Story("WFBT-11220")
public class WFBT_11220 extends ST_KDSetup {
    @TmsLink("WFBT-11498")
    @Test(description = "WFBT-11498 || GC01 - Check that the cross links in their right order in the burger menu")
    public void assertOnTheBurgerMenuOrder(){
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).validateCrossLinksInKIPTariffPage()
                .navigateToTVProductPageFromCrossLink();
        new KabelTVPage(driver).validateCrossLinksInTVTariffPage()
                .navigateToKIPProductPageFromCrossLink();
    }

    @TmsLink("WFBT-11499")
    @Test(description = "WFBT-11499 || GC02 - When user in KIP page and navigates to TV page with no products, a teaser should be exist")
    public void checkNavigationFromKIPToTVPageAndHasCampaign(){
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).navigateToTVProductPageFromCrossLink();
        new KabelTVPage(driver).assertOnTeaserDoesNotExistsInTVPage();
    }

    @TmsLink("WFBT-11500")
    @Test(description = "GC03 - When user in TV page and navigates to KIP page with no products, a teaser should be exist")
    public void checkNavigationFromTVToKIPPageAndHasCampaign(){
        new KD_Dashboard(driver).navigateToKabelTVPageFromBurgerMenu();
        new KabelTVPage(driver).navigateToKIPProductPageFromCrossLink();
        new TariffPageInternetAndPhone(driver).assertOnTeaserDoesNotExistsInKIPPage();
    }
}