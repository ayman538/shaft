package de.vodafone.tests.eCare.SIT;

import de.vodafone.pages.eCare.Dashboard;
import de.vodafone.pages.eCare.MeinTarif;
import de.vodafone.pages.eCare.TariffAndern;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
@Epic("eCare")
@Feature("SIT")
@Story("WFGT-311")

public class WFGT_311 extends SIT_eCareSetup{
    @Test(description = "GC01 | WFGT-311 | Contract Summary | MeinVodafone: Showing the contract Summary for Prepaid users / Changing Tariff")
    @TmsLink("WFGT-440")
    private void GC01(Method method){
        new Dashboard(driver).CLosePopUpMessage().ClickOnMeinTariffTile();
        new MeinTarif(driver).clickOnTariffAndern();
        new TariffAndern(driver)
                .clickOnCallyaClassicCard()
                .clickOnWeiter()
                .validateTLegalText(testData.getTestData((method.getName() + ".expectedlegalText")))
                .checkdownloadHyperlinkText(testData.getTestData((method.getName() + ".expectedHyperlinkText")))
                .clickOnVertragszusammenfassungBtn().
                downloadSITPDF();
    }
}
