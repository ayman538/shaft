package de.vodafone.tests.NetAssistant.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.HelpPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("SIT")
public class WFET_3067 extends SITNetAssistantSetup {
    //Variables
    private String chatbot_Deeplink;

    //Test
    @BeforeMethod
    public void setup(Method method) {

        chatbot_Deeplink = testData.getTestData(method.getName()+".link");
        super.setup(method);

    }
    @Test(groups={"WFET_3067","regression"})
    @TmsLink("WFET-3144")
    @Description("UM - Deeplink to Net Assistant Chatbot - Verify the C_ID Value is Updated in URL")
    private void SIT_GC01() {

        new ChatbotPage(driver)
                .navigate(chatbot_Deeplink);
        setCookieECHO();
        new ChatbotPage(driver)
                .acceptCookies()
                .navigate(chatbot_Deeplink);

        Validations.assertThat()
                .element(driver.getDriver(), HelpPage.getQuestion1())
                .exists()
                .withCustomReportMessage("Question1 Exists Successfully")
                .perform();
        new HelpPage(driver)
                .getCurruntURL();
        Validations.assertThat().browser(driver.getDriver()).url().contains("c_id=hilfe_netzass_kip")
                .withCustomReportMessage("C_ID updated")
                .perform();
    }
    @Test(groups={"WFET_3067","regression"})
    @TmsLink("WFET-3146")
    @Description("UM - Deeplink to help form - Verify the C_ID Value is Updated in URL")
    private void SIT_GC02() {

        new ChatbotPage(driver)
                .navigate(chatbot_Deeplink);
        setCookieECHO();
        new ChatbotPage(driver)
                .acceptCookies()
                .navigate(chatbot_Deeplink);

        Validations.assertThat()
                .element(driver.getDriver(), HelpPage.getQuestion1())
                .exists()
                .withCustomReportMessage("Question1 Exists Successfully")
                .perform();
        new HelpPage(driver)
                .getCurruntURL();
        Validations.assertThat().browser(driver.getDriver()).url().contains("c_id=hilfe_netzass_kip")
                .withCustomReportMessage("C_ID updated")
                .perform();
    }


};

