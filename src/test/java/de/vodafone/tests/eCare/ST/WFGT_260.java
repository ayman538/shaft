package de.vodafone.tests.eCare.ST;

import de.vodafone.pages.eCare.Dashboard;
import de.vodafone.pages.eCare.MeinTarif;
import de.vodafone.pages.eCare.OptionBuchen;
import io.qameta.allure.*;
import org.testng.annotations.Test;


import java.lang.reflect.Method;

@Epic("eCare")
@Feature("ST")
@Story("WFGT-260")

public class WFGT_260 extends ST_eCareSetup {
    @Test( description = "GC01 | WFGT-437 | Sanity | prepaid user | check Outage Message in case of Changing Tariff")
    @TmsLink("WFGT-437")
    @Issue("WFGT-1103")
    private void GC01(Method method) {
        new Dashboard(driver)
                .CLosePopUpMessage()
                .ClickOnMeinTariffTile();
        new MeinTarif(driver)
                .validateTariffNotificationText(testData.getTestData((method.getName() + ".expectedNotificationMsg")));
    }
    @Test( description = "GC03 | WFGT-436 | prepaid user | check Outage Message in case of Booking option")
    @TmsLink("WFGT-436")
    @Issue("WFGT-617")
    @Issue("WFGT-1103")
    private void GC03(Method method) {
        new Dashboard(driver)
                .CLosePopUpMessage()
                .ClickOnMeinTariffTile();
        new MeinTarif(driver)
                .expandBuchbareOptionenAccordion()
                .validateBuchbareOptionenAccordionExpanded();
        new OptionBuchen(driver)
                .validateBuchbareOptionenNotificationText(testData.getTestData((method.getName() + ".expectedNotificationHeader")),testData.getTestData((method.getName() + ".expectedNotificationBody")));
    }
    @Test( description = "GC05 | WFGT-594 |  prepaid user | check Outage Message not displayed in case of Changing Tariff (proceedfulfilmentonerror = true)")
    @TmsLink("WFGT-594")
    @Issue("WFGT-1103")
    private void GC05(Method method) {
        new Dashboard(driver)
                .CLosePopUpMessage()
                .ClickOnMeinTariffTile();
        new MeinTarif(driver)
                .CLosePopUpMessage()
                .validateTariffNotificationNotExist(testData.getTestData((method.getName() + ".expectedNotificationMsg")));
    }
    @Test( description = "GC06 | WFGT-598 | prepaid user | check Outage Message not displayed in case of Booking Option (proceedfulfilmentonerror = true) (contractSummaryRelevant= true)")
    @TmsLink("WFGT-598")
    @Issue("WFGT-1103")
    private void GC06(Method method) {
        new Dashboard(driver)
                .CLosePopUpMessage()
                .ClickOnMeinTariffTile();
        new MeinTarif(driver)
                .expandBuchbareOptionenAccordion()
                .validateBuchbareOptionenAccordionExpanded();
        new OptionBuchen(driver)
                .validateBuchbareOptionenNotificationTextNotExist(testData.getTestData((method.getName() + ".expectedNotificationHeader")),testData.getTestData((method.getName() + ".expectedNotificationBody")));
    }
}
