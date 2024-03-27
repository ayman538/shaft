package de.vodafone.tests.kableDeutschland.SIT;

import de.vodafone.pages.Kabledeutschland.KablePersonalOfferPrivacy;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
@Epic("kableDeutschland")
@Feature("SIT")
@Story("WFDT_4489")
public class WFDT_4489 extends SIT_KableDeutschlandSetup{
    @TmsLink("WFDT-6290")
    @Test(description = "GC01 || Martin - Verify 'Persönliche Angebote' privacy display and changing settings",groups = {"eCare"})
    private void gc01(){
        new KablePersonalOfferPrivacy(driver)
                .NavigateToPrivacyAccordion()
                .AssertPersonalOfferSection()
                .NavigateToEditPersonalOfferPrivacy()
                .AssertEditPersonalOfferPage()
                .SetPrivacyToggleOn()
                .ConfirmEditChanges()
                .SetPrivacyToggleOff()
                .AssertEditPersonalOfferWarningMessage()
                .ConfirmWarningMessage()
                .ConfirmEditChanges()
                .AssertEditPersonalOfferSuccessMessage();

    }

}
