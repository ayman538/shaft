/*package de.vodafone.tests.CableMigration.ST;
import de.vodafone.pages.CableMigration.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("Cable Migration")
@Feature("ST")
@Story("WFFT-2729 Account Balance Display Self Payer")
public class WFFT_2729 extends CableMigrationSTSetup {
    MeinVodafoneDashboard meinVodafoneDashboard;
    KontostandPage kontostandPage;

    @Test(description = "GC01-Verify Mein Rechnungen page in case of outstanding balance")
    @TmsLink("WFFT-3095")
    public void GC01() {
        meinVodafoneDashboard = new MeinVodafoneDashboard(driver);
        meinVodafoneDashboard.navigateToMeinReshnungPage();
        kontostandPage = new KontostandPage(driver);
        kontostandPage.ClickOnKontostandTab();
        kontostandPage.ClickOnOutstandingAccount();
        kontostandPage.validateOutstandingTexts();
        kontostandPage.validateCardOutstanding();
        kontostandPage.validateGroupText1();
        kontostandPage.validateDocument();
        kontostandPage.validateOtherLink();
    }
    @Test(description = "GC02 - Verify Mein Rechnungen page in case of credit balance")
    @TmsLink("WFFT-3096")
    public void GC02() {
        meinVodafoneDashboard = new MeinVodafoneDashboard(driver);
        meinVodafoneDashboard.navigateToMeinReshnungPage();
        kontostandPage = new KontostandPage(driver);
        kontostandPage.ClickOnKontostandTab();
        kontostandPage.ClickOnCreditAccount();
        kontostandPage.validateCreditTexts();
        kontostandPage.validateCardCredit();
    }
    @Test(description = "GC03 - Verify Mein Rechnungen page in case of no balance")
    @TmsLink("WFFT-3097")
    public void GC03() {
        meinVodafoneDashboard = new MeinVodafoneDashboard(driver);
        meinVodafoneDashboard.navigateToMeinReshnungPage();
        kontostandPage = new KontostandPage(driver);
        kontostandPage.ClickOnKontostandTab();
        kontostandPage.ClickOnNoBalanceAccount();
        kontostandPage.validateNoBalanceTexts();
    }
    @Test(description = "GC04 - Verify Mein Rechnungen page in case of dunning")
    @TmsLink("WFFT-3098")
    public void GC04() {
        meinVodafoneDashboard = new MeinVodafoneDashboard(driver);
        meinVodafoneDashboard.navigateToMeinReshnungPage();
        kontostandPage = new KontostandPage(driver);
        kontostandPage.ClickOnKontostandTab();
        kontostandPage.ClickOnDunningAccount();
        kontostandPage.validateDunningTexts();
    }
}
*/