package de.vodafone.tests.Solstice.ST;

import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("Solstice")
@Feature("ST")
@Story("WFAT_13594")
public class WFAT_13594 extends SolsticeSTSetup {
    @TmsLink("WFAT-13796")
    @Test(description = "WFAT-13796 Solstice user checks expanded Solstice MBO in dashboard")
    public void GC01() throws InterruptedException {
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeDashboard.SolsticeMBONotificationHeadline)
                .text()
                .isEqualTo(SolsticeDashboard.SolsticeMBONotificationHeadlineCL)
                .withCustomReportMessage("Check Notification Headline")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeDashboard.SolsticeMBONotificationText)
                .text()
                .isEqualTo(SolsticeDashboard.SolsticeMBONotificationTextCL)
                .withCustomReportMessage("Check Notification Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeDashboard.SolsticeMBOTile1Title)
                .text()
                .isEqualTo(SolsticeDashboard.SolsticeMBOTile1TitleCL)
                .withCustomReportMessage("Check Tile 1 Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeDashboard.SolsticeMBOTile1Subtitle)
                .text()
                .isEqualTo(SolsticeDashboard.SolsticeMBOTile1SubtitleCL)
                .withCustomReportMessage("Check Tile 1 Subtitle")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeDashboard.SolsticeMBOTile2Title)
                .text()
                .isEqualTo(SolsticeDashboard.SolsticeMBOTile2TitleCL)
                .withCustomReportMessage("Check Tile 2 Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeDashboard.SolsticeMBOTile2Subtitle)
                .text()
                .isEqualTo(SolsticeDashboard.SolsticeMBOTile2SubtitleCL)
                .withCustomReportMessage("Check Tile 2 Subtitle")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeDashboard.SolsticeMBOTile1)
                .isDisabled().withCustomReportMessage("Check Tile 1 is disabled").perform();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeDashboard.SolsticeMBOTile2)
                .isDisabled().withCustomReportMessage("Check Tile 2 is disabled").perform();

    }
    @TmsLink("WFAT-13797")
    @Test(description = "WFAT-13797 Solstice user checks url navigation in Solstice MBO Notification")
    public void GC02() throws InterruptedException {
        Validations.assertThat().element(driver.getDriver(), SolsticeDashboard.SolsticeMBONotificationURL)
                .attribute("class")
                .isEqualTo("link")
                .withCustomReportMessage("Check that url is a link")
                .perform();
        Validations.assertThat().element(driver.getDriver(), SolsticeDashboard.SolsticeMBONotificationURL)
                .attribute("href")
                .isEqualTo("https://www.vodafone.de/kontakt")
                .withCustomReportMessage("Check url redirection link")
                .perform();
    }
}
