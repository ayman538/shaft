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
public class WFET_3143 extends SITNetAssistantSetup {
    //Variables
    private String chatbot_Deeplink;
    private String ticket_Deeplink;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        chatbot_Deeplink = testData.getTestData(method.getName() + ".link");
        ticket_Deeplink = testData.getTestData(method.getName() + ".link");
        super.setup(method);

    }

    @Test(groups = {"WFET_3143", "regression"})
    @TmsLink("WFET-3595")
    @Description("SIT - GC01 - cable user - Deeplink to Cable ticket then verify ticket details view Displayed")
    private void SIT_GC01() {
        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver).
                acceptCookies().
                navigate(ticket_Deeplink);
        Validations.assertThat()

                .element(driver.getDriver(), TicketsPage.getDetails_header_gelost())
                .exists()
                .withCustomReportMessage("ticket details view displayed")
                .perform();

    }

    @Test(groups = {"WFET_3143", "regression"})
    @TmsLink("WFET-3598")
    @Description("SIT - GC04 - cable user - Deeplink to Cable ticket then verify user redirection in-case token number doesn't exist")
    private void SIT_GC04() {
        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver).
                acceptCookies().
                navigate(ticket_Deeplink);
        Validations.assertThat()

                .element(driver.getDriver(), TicketsPage.getError_msg_button_token())
                .exists()
                .withCustomReportMessage("error msg displayed ")
                .perform();

    }
    @Test(groups = {"WFET_3143", "regression"})
    @TmsLink("WFET-3597")
    @Description("SIT - GC03 - cable user - Deeplink to Cable ticket then verify vodafone icon navigation")
    private void SIT_GC03() {
        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver).
                acceptCookies().
                navigate(ticket_Deeplink);
        Validations.assertThat()

                .element(driver.getDriver(), TicketsPage.getDetails_header_gelost())
                .exists()
                .withCustomReportMessage("ticket details displayed")
                .perform();

        new TicketsPage(driver)
                .clickOn(TicketsPage.getVodafone_icon());
        Validations.assertThat()

                .element(driver.getDriver(), TicketsPage.getMeinvodafone_icon())
                .exists()
                .withCustomReportMessage("meinvodafone home page displayed")
                .perform();

    }
}
