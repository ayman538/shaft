package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.KabelTVPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("KD")
@Feature("ST")
@Story("WFBT-10768")
public class WFBT_10768 extends ST_KDSetup {

    @TmsLink("WFBT_11074")
    @Test(description = "GC01 Check that Mein Kabel TV Smart Object exists in the Kabel-TV tarif page")
    public void GC01_CheckSOMeinKabelTVExistsInKabelTVTarifPage(){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickMeinKabelTVSO();
        new KabelTVPage(driver).validateMeinKabelTVSO();
    }

    @TmsLink("WFBT_11075")
    @Test(description = "GC02 Check that when user clicks on SO Mein Kabel TV the related accordion Mein Kabel TV is expanded correctly with all details mentioned in story")
    public void GC02_CheckMeinKabelTVSOLinkedCorrectlyWithRelatedAccordionWithAllDetails(){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).clickOnMeinKabelTVSO().validateMeinKabelTVAccordion();
    }

    @TmsLink("WFBT_11076")
    @Test(description = "GC03 Validate first card in Mein kabel TV Accordion")
    public void GC03_ValidateFirstCardInMeinkabelTVAccordion(){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnKabelTVBurgerMenu().clickOnMeinTarifList();
        new KabelTVPage(driver).clickOnMeinKabelTVAccordion().validateAccessNameAndUSPsCard();
    }

    @TmsLink("WFBT_11077")
    @Test(description = "GC04 Validate contract details in the second card in Mein Kabel TV Accordion if user is self-paid")
    public void GC04_ValidateContractDetailsInTheSecondCardInMeinKabelTVAccordionIfUserIsSelf_Paid(){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnKabelTVBurgerMenu().clickOnMeinTarifList();
        new KabelTVPage(driver).clickOnMeinKabelTVAccordion().validateContractDetailsSelfPayer().clickOnCancellationLink();
    }

    @TmsLink("WFBT_11078")
    @Test(description = "GC05 Validate contract details in the second card in MeinKabelTV Accordion if user is Renter")
    public void GC05_ValidateContractDetailsInTheSecondCardInMeinKabelTVAccordionIfUserIsRenter(){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnKabelTVBurgerMenu().clickOnMeinTarifList();
        new KabelTVPage(driver).clickOnMeinKabelTVAccordion().validateContractDetailsRenter();
    }

    @TmsLink("WFBT_11079")
    @Test(description = "GC06 Check that the banner suggestions with links to book are displayed in case there is no Tariffs")
    public void GC06_CheckThatTheBannerSuggestionsWithLinksToBookAreDisplayedInCaseThereIsNoTariffs(){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnKabelTVBurgerMenu().clickOnMeinTarifList();
        new KabelTVPage(driver).clickOnMeinKabelTVAccordion().validateNoTariffImg().validateNoTariffHeadline()
                .validateNoTariffSubLine().validateNoTariffCTA().clickOnBookNowCTA();
    }

    @TmsLink("WFBT_11452")
    @Test(description = "BC01 Check Mein Kabel TV Accordion when it returns general error")
    public void BC01_CheckMeinKabelTVAccordionWhenItReturnsGeneralError(){
        new KD_Dashboard(driver).clickOnKabelTVBurgerMenu().clickOnMeinKabelTVBM();
        new KabelTVPage(driver).validateErrorMessageNotification();
    }
}