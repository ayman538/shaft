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
public class WFET_4194 extends SITNetAssistantSetup {
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

    @Test(groups = {"WFET_4194", "regression"})
    @TmsLink("WFET-4527")
    @Description("SIT - GC01 - DSL user- Navigate to Tickets List - Verify that Tickets List CL is updated")
    private void SIT_GC01() {
        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver)
                .acceptCookies()
                .navigate(ticket_Deeplink);

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Tickets_list_Title())
                .text()
                .isEqualTo(TicketsPage.get_Tickets_list_Title_CL())
                .withCustomReportMessage("ticket list CL Updated Successfully")
                .perform();
    }

    @Test(groups = {"WFET_4194", "regression"})
    @TmsLink("WFET-4529")
    @Description("SIT - GC04 - cable user - Deeplink to Cable ticket then verify user redirection in-case token number doesn't exist")
    private void SIT_GC04() {
        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver)
                .acceptCookies()
                .navigate(ticket_Deeplink)
                .clickMoreInfoTicketStatusIndex("Neu",1);

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Back_Button())
                .text()
                .isEqualTo(TicketsPage.get_Back_Button_CL())
                .withCustomReportMessage("Back button CL Updated Successfully")
                .perform();

    }
}
