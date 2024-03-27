package de.vodafone.tests.eCare.SIT;

import de.vodafone.pages.eCare.Dashboard;
import de.vodafone.pages.eCare.MeinTarif;
import de.vodafone.pages.eCare.OptionBuchen;
import de.vodafone.pages.eCare.Optionkundigen;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

@Epic("ecare")
@Feature("SIT")
@Story("WFGT-254")
public class WFGT_254 extends SIT_eCareSetup{
    @Test(description ="GC01 | WFGT-400 | prepaid user | check view and download my contract summary in case of cancel booked option" )
    @TmsLink("WFGT-400")
    public void GC01(Method method)   {
        new Dashboard(driver).expandContract("2").clickMeineOptionenTile();
        new MeinTarif(driver).clickOnCancelButton();
        new Optionkundigen(driver).validateCancelLegalTextExist(testData.getTestData(method.getName() + ".cancelLegalText")).clickOnHyperLink().downloadSITPDF();
    }

    @Test(description ="GC05 | WFGT-405 | prepaid user | add new bookable option | verify contract summary in case of eligible | verify CS file sent to user documents" )
    @TmsLink("WFGT-405")
    public void GC05(Method method)   {
        new Dashboard(driver).CLosePopUpMessage().clickMeineOptionenTile();
        new MeinTarif(driver).expandBuchbareOptionenAccordion().clickOnBookingBuchen();
        new OptionBuchen(driver).validateEligibleLegalTextExist(testData.getTestData(method.getName() + ".firstNotEligibleLegalText"),testData.getTestData(method.getName() + ".secondNotEligibleLegalText"),testData.getTestData(method.getName() + ".eligibleLegalText")).clickOnHyperLink();
    }
}
