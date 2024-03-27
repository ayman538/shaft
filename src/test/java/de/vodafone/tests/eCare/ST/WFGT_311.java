package de.vodafone.tests.eCare.ST;

import de.vodafone.pages.eCare.Dashboard;
import de.vodafone.pages.eCare.MeinTarif;
import de.vodafone.pages.eCare.TariffAndern;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class WFGT_311 extends ST_eCareSetup {
    @Test( description = "GC01 | WFGT-311 | Contract Summary | MeinVodafone: Showing the contract Summary for Prepaid users / Changing Tariff")
    @TmsLink("WFGT-440")
    @Issue("WFGT-617")
    @Issue("WFGT-1103")
    private void GC01(Method method){
        new Dashboard(driver).CLosePopUpMessage().ClickOnMeinTariffTile();
        new MeinTarif(driver).clickOnTariffAndern();
        new TariffAndern(driver)
                .clickOnWeiter()
                .validateTLegalText(testData.getTestData((method.getName() + ".expectedlegalText")))
                .checkdownloadHyperlinkText(testData.getTestData((method.getName() + ".expectedHyperlinkText")))
                .clickOnVertragszusammenfassungBtn()
                .validateAndDeletePDF();
    }
    @Test( description = "BC01 | WFGT-443 | prepaid user | verify failure service handling")
    @TmsLink("WFGT-443")
    @Issue("WFGT-1103")
    private void BC01(Method method){
        new Dashboard(driver).CLosePopUpMessage().ClickOnMeinTariffTile();
        new MeinTarif(driver).clickOnTariffAndern();
        new TariffAndern(driver)
                .clickOnWeiter()
                .validateTLegalText(testData.getTestData((method.getName() + ".expectedlegalText")))
                .checkdownloadHyperlinkText(testData.getTestData((method.getName() + ".expectedHyperlinkText")))
                .clickOnVertragszusammenfassungBtn()
                .validateGeneralErrorMessage((method.getName() + ".expectedErrorTitle"), (method.getName() + ".expectedErrorBody"));
    }
}
