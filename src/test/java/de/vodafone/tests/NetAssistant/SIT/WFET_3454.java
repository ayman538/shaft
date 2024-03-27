package de.vodafone.tests.NetAssistant.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.NetAssistant.TicketsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("SIT")
public class WFET_3454 extends SITNetAssistantSetup {
    //Variables
    private String user_Name;
    private String user_Password;
    private String Link;

    //Test
    @BeforeMethod
    public void setup(Method method) {

        user_Name = testData.getTestData(method.getName()+".name");
        user_Password = testData.getTestData(method.getName()+".password");
        Link = testData.getTestData(method.getName()+".Link");
        super.setup(method);
    }

    @Test(groups={"WFET_3454"})
    @TmsLink("WFET-3720")
    @Description("SIT - GC01 - UM user - Deeplink to UM ticket then verify ticket details view Displayed")
    private void GC01() {
        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver)
                .navigate(Link)
                .acceptCookies();

        Validations
                .assertThat()
                .element(driver.getDriver(), TicketsPage.get_Tickets_Message())
                .exists()
                .withCustomReportMessage("tickets page displayed")
                .perform();

        Validations
                .assertThat()
                .element(driver.getDriver(),TicketsPage.get_Ticket_Details_Status())
                .text()
                .isEqualTo("Gelöst")
                .perform();

    }
    @Test(groups={"WFET_3454"})
    @TmsLink("WFET-3721")
    @Description("SIT - GC02 - UM user - Deeplink to UM ticket then verify back button is removed")
    private void GC02() {

        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver)
                .navigate(Link)
                .acceptCookies();

        Validations
                .assertThat()
                .element(driver.getDriver(), TicketsPage.get_Back_Button())
                .doesNotExist()
                .withCustomReportMessage("ticket page displayed and Back Button does not exist")
                .perform();
    }
    @Test(groups={"WFET_3454"})
    @TmsLink("WFET-3722")
    @Description("SIT - GC03 - UM user - Deeplink to UM ticket then Verify vodafone icon navigation")
    private void GC03() {

        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver)
                .navigate(Link)
                .acceptCookies()
                .clickOn(TicketsPage.getVodafone_icon())
                .getCurruntURL();

        Validations
                .assertThat()
                .element(driver.getDriver(), TicketsPage.getVodafone_icon())
                .exists()
                .withCustomReportMessage("Vodafone icon exists successfully")
                .perform();

        Validations
                .assertThat()
                .browser(driver.getDriver())
                .url()
                .isEqualTo("https://www.vodafone.de/index.html")
                .withCustomReportMessage("Current URL is Vodafone.de")
                .perform();
    }
}
