package de.vodafone.tests.Solstice.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.LegacyEmailChangeVerification;
import de.vodafone.pages.Solstice.SolsticeEmailChangeVerification;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("Solstice")
@Feature("ST")
@Story("WFAT_12206")
public class WFAT_12206 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String baseUrl = System.getProperty("de.vodafone.baseUrl.st");
    public String Url;
    public String Token;
    public String FinalUrl;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");
    public final String environment = "ST";

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        Url = baseUrl + "meinvodafone/account/email/verifizieren?";
        Token = testData.getTestData(method.getName() + ".token");
        FinalUrl = Url + Token;
        driver = new SHAFT.GUI.WebDriver();
        new SolsticeEmailChangeVerification(driver).navigate(FinalUrl).setCookie(cookieMap).acceptCookies();
    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "Solstice/ST_WFAT-12206_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "Solstice/" + environment + "/" + className + ".json");
    }

    @TmsLink("WFAT-13383")
    @Test(description = "WFAT-13383-Solsctice User checks confirmation page for change email verification")
    public void GC01() throws InterruptedException {
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeEmailChangeVerification.ECVPageHeadline)
                .text()
                .isEqualTo(SolsticeEmailChangeVerification.ECVPageHeadlineCL)
                .withCustomReportMessage("Check Page Headline")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeEmailChangeVerification.ECVConfNotHeadline)
                .text()
                .contains(SolsticeEmailChangeVerification.ECVConfNotHeadlineCL)
                .withCustomReportMessage("Check Notification Headline")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeEmailChangeVerification.ECVConfNotText)
                .text()
                .contains(SolsticeEmailChangeVerification.ECVConfNotTextCL)
                .withCustomReportMessage("Check Notification Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeEmailChangeVerification.ECVConfSummaryHeader)
                .text()
                .isEqualTo(SolsticeEmailChangeVerification.ECVConfSummaryHeaderCL)
                .withCustomReportMessage("Check Summary Headline")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeEmailChangeVerification.ECVConfSummaryText)
                .text()
                .isEqualTo(SolsticeEmailChangeVerification.ECVConfSummaryTextCL)
                .withCustomReportMessage("Check Summary Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeEmailChangeVerification.ECVConfSummaryCTA)
                .text()
                .isEqualTo(SolsticeEmailChangeVerification.ECVConfSummaryCTACL)
                .withCustomReportMessage("Check Summary CTA")
                .perform();
    }

    @TmsLink("WFAT-13384")
    @Test(description = "WFAT-13384-Legacy User checks confirmation page for change email verification")
    public void GC02() {
        Validations.assertThat()
                .element(driver.getDriver(), LegacyEmailChangeVerification.LECPageHeadline)
                .text()
                .isEqualTo(LegacyEmailChangeVerification.LECPageHeadlineCL)
                .withCustomReportMessage("Check Page Headline")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), LegacyEmailChangeVerification.LECConfNotHeadline)
                .text()
                .isEqualTo(LegacyEmailChangeVerification.LECConfNotHeadlineCL)
                .withCustomReportMessage("Check Notification Headline")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), LegacyEmailChangeVerification.LECConfNotText)
                .text()
                .contains(LegacyEmailChangeVerification.LECConfNotTextCL)
                .withCustomReportMessage("Check Notification Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), LegacyEmailChangeVerification.LECConfSummaryHeader)
                .text()
                .isEqualTo(LegacyEmailChangeVerification.LECConfSummaryHeaderCL)
                .withCustomReportMessage("Check Summary Headline")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), LegacyEmailChangeVerification.LECConfSummaryText)
                .text()
                .isEqualTo(LegacyEmailChangeVerification.LECConfSummaryTextCL)
                .withCustomReportMessage("Check Summary Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), LegacyEmailChangeVerification.LECConfSummaryEmail)
                .text()
                .isEqualTo(LegacyEmailChangeVerification.LECConfSummaryEmailCL)
                .withCustomReportMessage("Check Summary Email")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), LegacyEmailChangeVerification.LECConfSummaryCTA)
                .text()
                .isEqualTo(LegacyEmailChangeVerification.LECConfSummaryCTACL)
                .withCustomReportMessage("Check Summary CTA")
                .perform();
    }
}


