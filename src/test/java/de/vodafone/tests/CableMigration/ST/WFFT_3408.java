package de.vodafone.tests.CableMigration.ST;


import de.vodafone.pages.CableMigration.MeinRechnungPage;
import de.vodafone.pages.CableMigration.MeinVodafoneDashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Cable Migration")
@Feature("ST")
@Story("Billing | TV Product not having itemized bill")
        public class WFFT_3408 extends CableMigrationSTSetup{

    @Test(description = "GC01- Verify the TV product itemized colomun icon within the bill history page for the last 6 months (Sanity)")
    @TmsLink("WFFT_3585")

    private void GC01(Method method){
        MeinVodafoneDashboard meinVodafoneDashboard = new MeinVodafoneDashboard(driver);
        MeinRechnungPage meinRechnungPage = new MeinRechnungPage(driver);

        meinVodafoneDashboard.navigateToMeinReshnungPage();
        meinRechnungPage.validateTvIconMeinRechnungPage(testData.getTestData(method.getName() + ".thirdRowProductName"));
    }
        }
