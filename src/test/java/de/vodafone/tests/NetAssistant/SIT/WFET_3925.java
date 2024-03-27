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
public class WFET_3925 extends SITNetAssistantSetup {

    //Variables
    private String chatbot_Deeplink;
    private String tickets_Deeplink;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        chatbot_Deeplink = testData.getTestData(method.getName() + ".link");
        tickets_Deeplink = testData.getTestData(method.getName() + ".link");
        super.setup(method);

    }
    //Obsolete Old Business Scope
/*
    @Test(groups = {"WFET_3925", "regression"})
    @TmsLink("WFET-4376")
    @Description("SIT03 - DSL user -Navigate with Net Assistant Token Deeplink")
    private void SIT_GC03(){
        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink);

        Validations
                .assertThat()
                .element(driver.getDriver(), TicketsPage.getErrorMsgIconToken())
                .isVisible()
                .withCustomReportMessage("Token Error Icon is displayed Succesfully")
                .perform();

        Validations
                .assertThat()
                .element(driver.getDriver(), TicketsPage.getErrorMsgTextStrongToken())
                .text()
                .isEqualTo("Das hat leider nicht geklappt");

        Validations
                .assertThat()
                .element(driver.getDriver(), TicketsPage.getErrorMsgTextPToken())
                .text()
                .isEqualTo("Aber ein Klick auf den Button bringt Dich weiter.");

        Validations
                .assertThat()
                .element(driver.getDriver(), TicketsPage.getErrorMsgButtonToken())
                .exists()
                .withCustomReportMessage("error msg button displayed ")
                .perform();

        Validations
                .assertThat()
                .element(driver.getDriver(), TicketsPage.getErrorMsgButtonToken())
                .text()
                .isEqualTo("Zum Netz-Assistenten");

        Validations
                .assertThat()
                .element(driver.getDriver(), TicketsPage.getErrorMsgButtonToken())
                .isVisible()
                .withCustomReportMessage("Zum Netz-Assistenten Button is displayed Succesfully")
                .perform();

        new TicketsPage(driver)
                .navigate(tickets_Deeplink)
                .clickOn(TicketsPage.getErrorMsgButtonToken())
                .getCurruntURL();

        Validations
                .assertThat()
                .browser(driver.getDriver())
                .url().isEqualTo("https://www.vodafone.de/meinvodafone/public/netzassistent/review?product=dsl")
                .withCustomReportMessage("C_ID updated")
                .perform();
    }
    */
}
