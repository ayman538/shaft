package de.vodafone.tests.eCare.ST;

import de.vodafone.pages.eCare.Dashboard;
import de.vodafone.pages.eCare.MeinTarif;
import de.vodafone.pages.eCare.OptionBuchen;
import de.vodafone.pages.eCare.Optionkundigen;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

@Epic("ecare")
@Feature("ST")
@Story("WFGT-254")
public class WFGT_254 extends ST_eCareSetup{
    @Test( description ="GC01 | WFGT-400 | prepaid user | check view and download my contract summary in case of cancel booked option" )
    @TmsLink("WFGT-400")
    @Issue("WFGT-617")
    @Issue("WFGT-1103")
    public void GC01(Method method){
        new Dashboard(driver).CLosePopUpMessage().clickMeineOptionenTile();
       new MeinTarif(driver).CLosePopUpMessage().clickOnKündigenButton();
       new Optionkundigen(driver).validateCancelLegalTextExist(testData.getTestData(method.getName() + ".cancelLegalText")).clickOnHyperLink().downloadPDF();
    }

    @Test( description ="GC03 | WFGT-403 | prepaid user | add new bookable option | verify contract summary in case of eligible" )
    @TmsLink("WFGT-403")
    @Issue("WFGT-617")
    @Issue("WFGT-1103")
    public void GC03(Method method){
        new Dashboard(driver).CLosePopUpMessage().clickMeineOptionenTile();
        new MeinTarif(driver).expandBuchbareOptionenAccordion().validateBuchbareOptionenAccordionExpanded().CLosePopUpMessage().clickOnJetztBuchen();
        new OptionBuchen(driver).validateEligibleLegalTextExist(testData.getTestData(method.getName() + ".firstNotEligibleLegalText"),testData.getTestData(method.getName() + ".secondNotEligibleLegalText"),testData.getTestData(method.getName() + ".eligibleLegalText")).clickOnHyperLink().downloadPDF();
    }

    @Test( description ="GC04 | WFGT-404 | prepaid user | add new bookable option | verify contract summary in case of not eligible" )
    @TmsLink("WFGT-404")
    @Issue("WFGT-617")
    @Issue("WFGT-1103")
    public void GC04(Method method){
        new Dashboard(driver).CLosePopUpMessage().clickMeineOptionenTile();
        new MeinTarif(driver).expandBuchbareOptionenAccordion().validateBuchbareOptionenAccordionExpanded().CLosePopUpMessage().clickOnJetztBuchen();
        new OptionBuchen(driver).validateNotEligibleLegalTextExist(testData.getTestData(method.getName() + ".firstNotEligibleLegalText"),testData.getTestData(method.getName() + ".secondNotEligibleLegalText"));
    }
    @Test( description ="GC06| WFGT-473 | prepaid user | verify not view or download my contract summary in case of user not eligible for cancel booked option" )
    @TmsLink("WFGT-473")
    @Issue("WFGT-1103")
    public void GC06(Method method){
        new Dashboard(driver).CLosePopUpMessage().clickMeineOptionenTile();
        new MeinTarif(driver).CLosePopUpMessage().clickOnKündigenButton();
        new Optionkundigen(driver).validateCancelLegalTextNotExist(testData.getTestData(method.getName() + ".cancelLegalText"));
    }
}
