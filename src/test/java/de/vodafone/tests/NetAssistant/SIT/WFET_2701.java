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
public class WFET_2701 extends SITNetAssistantSetup {
    //Variables
    private String chatbot_Deeplink;
    private String tickets_Deeplink;
    //Test
    @BeforeMethod
    public void setup(Method method) {

        chatbot_Deeplink = testData.getTestData(method.getName()+".link");
        tickets_Deeplink = testData.getTestData(method.getName()+".link");
        super.setup(method);

    }
    @Test(groups={"WFET_2701","regression"})
    @TmsLink("WFET-3030")
    @Description("Cable - Deeplink to Net assistant Cable ticket Details - Verify icon removed behind previous steps when accordion is closed")
    private void SIT_GC01() {
        new TicketsPage(driver)
                .navigate();
        setCookieECHO();
        new TicketsPage(driver)
                .navigate(tickets_Deeplink)
                .acceptCookies()
                .navigate(tickets_Deeplink);
        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.getStatus())
                .exists()
                .withCustomReportMessage("Ticket Status Exists Successfully")
                .perform();

        new TicketsPage(driver)
                .clickMoreInfoButton();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.getOpenTicketDetailsInfoButtonText())
                .exists()
                .withCustomReportMessage("More Info Button Exists Successfully")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Ticket_Previous_Steps_Accordion())
                .doesNotExist()
                .withCustomReportMessage("Previous Steps Accordion does not exists")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Icon())
                .doesNotExist()
                .withCustomReportMessage("Icon does not Exist")
                .perform();


    }

    @Test(groups={"WFET_2701","regression"})
    @TmsLink("WFET-3034")
    @Description("Cable user - Deeplink to Net Assistant Cable ticket Details - Verify icon removed behind previous steps when accordion is closed")
    private void SIT_GC05() {

        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver)
                .navigate(tickets_Deeplink)
                .acceptCookies()
                .navigate(tickets_Deeplink);

        new TicketsPage(driver)
                .SwitchToIframe("kampyleInvite")
                .declineCookies()
                .SwitchToParent();

        new TicketsPage(driver)
                .clickExpandClosedTicketsButton();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.getStatus())
                .exists()
                .withCustomReportMessage("Ticket Status Exists Successfully")
                .perform();

        new TicketsPage(driver)
                .clickOn(TicketsPage.get_Closed_Ticket_Details_Button())
                .validateClosedTicketsMoreInfoBtnExsits();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Ticket_Previous_Steps_Accordion())
                .exists()
                .withCustomReportMessage("Previous Steps Accordion Exists Successfully")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Icon())
                .doesNotExist()
                .withCustomReportMessage("Icon does not Exist")
                .perform();


    }
}
