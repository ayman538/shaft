package de.vodafone.tests.Solstice.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import de.vodafone.pages.Solstice.SolsticeMyContractsAndParticipants;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
@Epic("Solstice")
@Feature("SIT")
@Story("WFAT_13594")
public class WFAT_13594 extends SolsticeSITSetup {
    @TmsLink("WFAT-13798")
    @Test(description = "WFAT-13798 Solstice user checks expanded Solstice MBO in dashboard")
    public void GC01() throws InterruptedException {
        driver.assertThat().element(SolsticeDashboard.SolsticeMBONotificationHeadline)
                .text().isEqualTo(SolsticeDashboard.SolsticeMBONotificationHeadlineCL)
                .withCustomReportMessage("Check Notification Headline").perform();
        driver.assertThat().element(SolsticeDashboard.SolsticeMBONotificationText)
                .text().isEqualTo(SolsticeDashboard.SolsticeMBONotificationTextCL)
                .withCustomReportMessage("Check Notification Text").perform();
        driver.assertThat().element(SolsticeDashboard.SolsticeMBOTile1Title)
                .text().isEqualTo(SolsticeDashboard.SolsticeMBOTile1TitleCL)
                .withCustomReportMessage("Check Tile 1 Title").perform();
        driver.assertThat().element(SolsticeDashboard.SolsticeMBOTile1Subtitle)
                .text().isEqualTo(SolsticeDashboard.SolsticeMBOTile1SubtitleCL)
                .withCustomReportMessage("Check Tile 1 Subtitle").perform();
        driver.assertThat().element(SolsticeDashboard.SolsticeMBOTile2Title)
                .text().isEqualTo(SolsticeDashboard.SolsticeMBOTile2TitleCL)
                .withCustomReportMessage("Check Tile 2 Title").perform();
        driver.assertThat().element(SolsticeDashboard.SolsticeMBOTile2Subtitle)
                .text().isEqualTo(SolsticeDashboard.SolsticeMBOTile2SubtitleCL)
                .withCustomReportMessage("Check Tile 2 Subtitle").perform();
        driver.assertThat().element(SolsticeDashboard.SolsticeMBOTile1)
                        .isDisabled().withCustomReportMessage("Check Tile 1 is disabled").perform();
        driver.assertThat().element(SolsticeDashboard.SolsticeMBOTile2)
                .isDisabled().withCustomReportMessage("Check Tile 2 is disabled").perform();
        driver.assertThat().element(SolsticeDashboard.SolsticeMBONotificationURL)
                .attribute("class").isEqualTo("link")
                .withCustomReportMessage("Check that url is a link").perform();
        driver.assertThat().element(SolsticeDashboard.SolsticeMBONotificationURL)
                .attribute("href").isEqualTo("https://www.vodafone.de/kontakt")
                .withCustomReportMessage("Check url redirection link").perform();
    }
}
