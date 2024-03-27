package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.*;

import static de.vodafone.pages.commons.UtilitiesPage.*;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_6449")
public class WFET_6449 extends STNetAssistantSetup {
    //Variables
    private String deeplink;
    private String userName;
    private String userPassword;
    private HashMap<String, String> cookieSwitcherMap;

    private List<String> Steps;
    private HashMap <String, ArrayList> cableTree;
    private HashMap <String, ArrayList> unityMediaTree;

    @BeforeMethod
    public void setup(Method method) {
        deeplink = testData.getTestData(method.getName() + ".deeplink");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        Steps = (List<String>) testData.getTestDataAsList(method.getName() + ".Steps");
        cableTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("cableTree");
        unityMediaTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("unityMediaTree");
        super.setup(method);
        loginAction(cookieSwitcherMap, userName, userPassword);
    }

    @Test(description = "GC01 - UM user - Deeplink to net assistant - Verify that User can open an incident ticket online with date/time picker displayed")
    @TmsLink("WFET-6482")
    private void GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillDateTimePickerForm(getCurrentDate(), getCurrentTime())
                .validateWeiterButtonEnabled()
                .validateGreenBorder1Displayed()
                .validateGreenBorder2Displayed();
    }

    @Test(description = "GC02 - VKD user - Deeplink to net assistant - Verify that User can open an incident ticket online with date/time picker displayed")
    @TmsLink("WFET-6483")
    private void GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillDateTimePickerForm(getCurrentDate(), getCurrentTime())
                .validateWeiterButtonEnabled()
                .validateGreenBorder1Displayed()
                .validateGreenBorder2Displayed();
    }

    @Test(description = "GC03 - UM user - Open Net Assistant Via Mein Vodafone SO - Verify that User can open an incident ticket online with date/time picker displayed")
    @TmsLink("WFET-6507")
    private void GC03() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillDateTimePickerForm(getCurrentDate(), getCurrentTime())
                .validateWeiterButtonEnabled()
                .validateGreenBorder1Displayed()
                .validateGreenBorder2Displayed();
    }

    @Test(description = "GC04 - VKD user - Open Net Assistant Via Mein Vodafone SO - Verify that User can open an incident ticket online with date/time picker displayed")
    @TmsLink("WFET-6508")
    private void GC04() {

        new DashboardPage(driver)
                .clickOnNetAssSOCable();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillDateTimePickerForm(getCurrentDate(), getCurrentTime())
                .validateWeiterButtonEnabled()
                .validateGreenBorder1Displayed()
                .validateGreenBorder2Displayed();
    }

    @Test(description = "GC05 - UM user - Deeplink to Net Assistant - Verify that User will view error message if entered date/time in future")
    @TmsLink("WFET-6509")
    private void GC05() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillDateTimePickerForm(getFutureDate(),getFutureTime())
                .validateWeiterButtonDisabled()
                .validateErrorCLFutureInvalidDate()
                .validateErrorCLFutureInvalidTime()
                .validateRedBorder1Displayed()
                .validateRedBorder2Displayed();
    }

    @Test(description = "GC06 - VKD user - Deeplink to Net Assistant - Verify that User will view error message if entered date/time in future")
    @TmsLink("WFET-6510")
    private void GC06() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillDateTimePickerForm(getFutureDate(),getFutureTime())
                .validateWeiterButtonDisabled()
                .validateErrorCLFutureInvalidDate()
                .validateErrorCLFutureInvalidTime()
                .validateRedBorder1Displayed()
                .validateRedBorder2Displayed();
    }

    @Test(description = "GC07 - UM user - Open Net Assistant Via Mein Vodafone SO - Verify that User will view error message if entered date/time in future")
    @TmsLink("WFET-6511")
    private void GC07() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillDateTimePickerForm(getFutureDate(),getFutureTime())
                .validateWeiterButtonDisabled()
                .validateErrorCLFutureInvalidDate()
                .validateErrorCLFutureInvalidTime()
                .validateRedBorder1Displayed()
                .validateRedBorder2Displayed();
    }

    @Test(description = "GC08 - VKD user - Open Net Assistant Via Mein Vodafone SO - Verify that User will view error message if entered date/time in future")
    @TmsLink("WFET-6512")
    private void GC08() {

        new DashboardPage(driver)
                .clickOnNetAssSOCable();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillDateTimePickerForm(getFutureDate(),getFutureTime())
                .validateWeiterButtonDisabled()
                .validateErrorCLFutureInvalidDate()
                .validateErrorCLFutureInvalidTime()
                .validateRedBorder1Displayed()
                .validateRedBorder2Displayed();
    }

    @Test(description = "GC09 - UM user - Deeplink to Net Assistant - Verify that User will view error message if both mandatory fields are left unfilled")
    @TmsLink("WFET-6513")
    private void GC09() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillDateTimePickerForm()
                .validateWeiterButtonDisabled()
                .validateErrorCLDateMandatoryFieldUnfilled()
                .validateErrorCLTimeMandatoryFieldUnfilled()
                .validateRedBorder1Displayed()
                .validateRedBorder2Displayed();
    }

    @Test(description = "GC10 - VKD user - Deeplink to Net Assistant - Verify that User will view error message if both mandatory fields are left unfilled")
    @TmsLink("WFET-6514")
    private void GC10() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillDateTimePickerForm()
                .validateWeiterButtonDisabled()
                .validateErrorCLDateMandatoryFieldUnfilled()
                .validateErrorCLTimeMandatoryFieldUnfilled()
                .validateRedBorder1Displayed()
                .validateRedBorder2Displayed();
    }

    @Test(description = "GC11 - UM user - Open Net Assistant Via Mein Vodafone SO - Verify that User will view error message if both mandatory fields are left unfilled")
    @TmsLink("WFET-6515")
    private void GC11() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillDateTimePickerForm()
                .validateWeiterButtonDisabled()
                .validateErrorCLDateMandatoryFieldUnfilled()
                .validateErrorCLTimeMandatoryFieldUnfilled()
                .validateRedBorder1Displayed()
                .validateRedBorder2Displayed();
    }

    @Test(description = "GC12 - VKD user - Open Net Assistant Via Mein Vodafone SO - Verify that User will view error message if both mandatory fields are left unfilled")
    @TmsLink("WFET-6516")
    private void GC12() {

        new DashboardPage(driver)
                .clickOnNetAssSOCable();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillDateTimePickerForm()
                .validateWeiterButtonDisabled()
                .validateErrorCLDateMandatoryFieldUnfilled()
                .validateErrorCLTimeMandatoryFieldUnfilled()
                .validateRedBorder1Displayed()
                .validateRedBorder2Displayed();
    }

    @Test(description = "GC13 - UM user - Deeplink to Net Assistant - Verify that User will view \"Weiter\" button dimmed if Date is Valid and Time is Invalid")
    @TmsLink("WFET-6517")
    private void GC13() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillDateTimePickerForm(getCurrentDate(),getFutureTime())
                .validateWeiterButtonDisabled()
                .validateErrorCLFutureInvalidTime()
                .validateGreenBorder1Displayed()
                .validateRedBorder2Displayed();
    }

    @Test(description = "GC14 - VKD user - Deeplink to Net Assistant - Verify that User will view \"Weiter\" button dimmed if Date is Valid and Time is Invalid")
    @TmsLink("WFET-6518")
    private void GC14() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillDateTimePickerForm(getCurrentDate(),getFutureTime())
                .validateWeiterButtonDisabled()
                .validateErrorCLFutureInvalidTime()
                .validateGreenBorder1Displayed()
                .validateRedBorder2Displayed();
    }

    @Test(description = "GC15 - UM user - Open Net Assistant Via Mein Vodafone SO - Verify that User will view \"Weiter\" button dimmed if Date is Valid and Time is Invalid")
    @TmsLink("WFET-6519")
    private void GC15() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillDateTimePickerForm(getCurrentDate(),getFutureTime())
                .validateWeiterButtonDisabled()
                .validateErrorCLFutureInvalidTime()
                .validateGreenBorder1Displayed()
                .validateRedBorder2Displayed();
    }

    @Test(description = "GC16 - VKD user - Open Net Assistant Via Mein Vodafone SO - Verify that User will view \"Weiter\" button dimmed if Date is Valid and Time is Invalid")
    @TmsLink("WFET-6520")
    private void GC16() {

        new DashboardPage(driver)
                .clickOnNetAssSOCable();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillDateTimePickerForm(getCurrentDate(),getFutureTime())
                .validateWeiterButtonDisabled()
                .validateErrorCLFutureInvalidTime()
                .validateGreenBorder1Displayed()
                .validateRedBorder2Displayed();
    }

    @Test(description = "GC17 - UM user - Deeplink to Net Assistant - Verify that User will view \"Weiter\" button dimmed if Date is Invalid and Time is Valid")
    @TmsLink("WFET-6521")
    private void GC17() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillDateTimePickerForm(getFutureDate(), getCurrentTime())
                .validateWeiterButtonDisabled()
                .validateErrorCLFutureInvalidDate()
                .validateRedBorder1Displayed()
                .validateGreenBorder2Displayed();
    }

    @Test(description = "GC18 - VKD user - Deeplink to Net Assistant - Verify that User will view \"Weiter\" button dimmed if Date is Invalid and Time is Valid")
    @TmsLink("WFET-6522")
    private void GC18() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillDateTimePickerForm(getFutureDate(), getCurrentTime())
                .validateWeiterButtonDisabled()
                .validateErrorCLFutureInvalidDate()
                .validateRedBorder1Displayed()
                .validateGreenBorder2Displayed();
    }

    @Test(description = "GC19 - UM user - Open Net Assistant Via Mein Vodafone SO - Verify that User will view \"Weiter\" button dimmed if Date is Invalid and Time is Valid")
    @TmsLink("WFET-6523")
    private void GC19() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillDateTimePickerForm(getFutureDate(), getCurrentTime())
                .validateWeiterButtonDisabled()
                .validateErrorCLFutureInvalidDate()
                .validateRedBorder1Displayed()
                .validateGreenBorder2Displayed();
    }

    @Test(description = "GC20 - VKD user - Open Net Assistant Via Mein Vodafone SO - Verify that User will view \"Weiter\" button dimmed if Date is Invalid and Time is Valid")
    @TmsLink("WFET-6524")
    private void GC20() {

        new DashboardPage(driver)
                .clickOnNetAssSOCable();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillDateTimePickerForm(getFutureDate(), getCurrentTime())
                .validateWeiterButtonDisabled()
                .validateErrorCLFutureInvalidDate()
                .validateRedBorder1Displayed()
                .validateGreenBorder2Displayed();
    }

    @Test(description = "GC21 - UM user - Deeplink to Net Assistant - Verify that User will view \"Weiter\" button dimmed if both date and time fields are Invalid")
    @TmsLink("WFET-6521")
    private void GC21() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillDateTimePickerForm(getFutureDate(),getFutureTime())
                .validateWeiterButtonDisabled()
                .validateErrorCLFutureInvalidDate()
                .validateErrorCLFutureInvalidTime()
                .validateRedBorder1Displayed()
                .validateRedBorder2Displayed();
    }

    @Test(description = "GC22 - VKD user - Deeplink to Net Assistant - Verify that User will view \"Weiter\" button dimmed if both date and time fields are Invalid")
    @TmsLink("WFET-6521")
    private void GC22() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillDateTimePickerForm(getFutureDate(),getFutureTime())
                .validateWeiterButtonDisabled()
                .validateErrorCLFutureInvalidDate()
                .validateErrorCLFutureInvalidTime()
                .validateRedBorder1Displayed()
                .validateRedBorder2Displayed();
    }

    @Test(description = "GC23 - UM user - Open Net Assistant Via Mein Vodafone SO - Verify that User will view \"Weiter\" button dimmed if both date and time fields are InvalidGC23 - UM user - Open Net Assistant Via Mein Vodafone SO - Verify that User will view \"Weiter\" button dimmed if both date and time fields are Invalid")
    @TmsLink("WFET-6527")
    private void GC23() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillDateTimePickerForm(getFutureDate(),getFutureTime())
                .validateWeiterButtonDisabled()
                .validateErrorCLFutureInvalidDate()
                .validateErrorCLFutureInvalidTime()
                .validateRedBorder1Displayed()
                .validateRedBorder2Displayed();
    }

    @Test(description = "GC24 - VKD user - Open Net Assistant Via Mein Vodafone SO - Verify that User will view \"Weiter\" button dimmed if both date and time fields are Invalid")
    @TmsLink("WFET-6528")
    private void GC24() {

        new DashboardPage(driver)
                .clickOnNetAssSOCable();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillDateTimePickerForm(getFutureDate(),getFutureTime())
                .validateWeiterButtonDisabled()
                .validateErrorCLFutureInvalidDate()
                .validateErrorCLFutureInvalidTime()
                .validateRedBorder1Displayed()
                .validateRedBorder2Displayed();
    }

    @Test(description = "GC27 - UM user - Deeplink to Net Assistant - Verify that User will view \"Weiter\" button enabled if Date is Valid (Past), and Time is Invalid (Future)")
    @TmsLink("WFET-6769")
    private void GC27() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillDateTimePickerForm(getPastDate(),getFutureTime())
                .validateWeiterButtonEnabled()
                .validateGreenBorder1Displayed()
                .validateGreenBorder2Displayed();
    }

    @Test(description = "GC28 - VKD user - Deeplink to Net Assistant - Verify that User will view \"Weiter\" button enabled if Date is Valid (Past), and Time is Invalid (Future)")
    @TmsLink("WFET-6770")
    private void GC28() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillDateTimePickerForm(getPastDate(),getFutureTime())
                .validateWeiterButtonEnabled()
                .validateGreenBorder1Displayed()
                .validateGreenBorder2Displayed();
    }

    @Test(description = "GC29 - UM user - Open Net Assistant Via Mein Vodafone SO - Verify that User will view \"Weiter\" button enabled if Date is Valid (Past), and Time is Invalid (Future)")
    @TmsLink("WFET-6771")
    private void GC29() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillDateTimePickerForm(getPastDate(),getFutureTime())
                .validateWeiterButtonEnabled()
                .validateGreenBorder1Displayed()
                .validateGreenBorder2Displayed();
    }

    @Test(description = "GC30 - VKD user - Open Net Assistant Via Mein Vodafone SO - Verify that User will view \"Weiter\" button enabled if Date is Valid (Past), and Time is Invalid (Future)")
    @TmsLink("WFET-6772")
    private void GC30() {

        new DashboardPage(driver)
                .clickOnNetAssSOCable();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillDateTimePickerForm(getPastDate(),getFutureTime())
                .validateWeiterButtonEnabled()
                .validateGreenBorder1Displayed()
                .validateGreenBorder2Displayed();
    }
}