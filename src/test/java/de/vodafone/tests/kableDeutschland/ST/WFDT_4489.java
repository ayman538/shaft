package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.KablePersonalOfferPrivacy;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_4489")
public class WFDT_4489 extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-6091")
    @Issue("WFDT-9682")
    @Test(description = "GC01 - Martin - Verify 'Persönliche Angebote' privacy display and changing settings",groups = {"eCare"})
    private void gc01(){
        new KablePersonalOfferPrivacy(driver)
                .NavigateToPrivacyAccordion()
                .AssertPersonalOfferSection()
                .NavigateToEditPersonalOfferPrivacy()
                .AssertEditPersonalOfferPage()
                .changePersonalOfferPrivacyToggle()
                .ConfirmEditChanges()
                .AssertEditPersonalOfferSuccessMessage();
    }

}
