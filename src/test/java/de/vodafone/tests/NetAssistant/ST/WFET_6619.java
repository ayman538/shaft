package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_6619")
public class WFET_6619 extends STNetAssistantSetup {
    //Variables
    private String deeplink;
    private String userName;
    private String userPassword;
    private String mobileNumber;
    private String postalCode;
    private String familyName;
    private String customerID;
    private HashMap<String, String> cookieSwitcherMap;

    private List<String> Steps;
    private HashMap <String, ArrayList> dslTree;


    @BeforeMethod
    public void setup(Method method) {
        deeplink = testData.getTestData(method.getName() + ".deeplink");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        mobileNumber = testData.getTestData(method.getName() + ".mobileNumber");
        postalCode = testData.getTestData(method.getName() + ".postalCode");
        familyName = testData.getTestData(method.getName() + ".familyName");
        customerID = testData.getTestData(method.getName() + ".customerId");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        Steps = (List<String>) testData.getTestDataAsList(method.getName() + ".Steps");
        dslTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("dslTree");
        super.setup(method);
        loginAction(cookieSwitcherMap, userName, userPassword);
    }

    @Test(description = "WFET-6676 - GC01 - DSL User - through deeplink - Verify that button component is appearing in previous step with grey background when previously selected and other button are disabled in case clickback parameter is returned \"FALSE\"\n")
    @TmsLink("WFET-6676")
    private void GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateJumpBackIsDimmed(Steps.size());
    }

    @Test(description = "WFET-6677 - GC02 - DSL User - through deeplink - Verify that image selector component is appearing in previous step with grey background when previously selected and other button are disabled in case clickback parameter is returned \"FALSE\"")
    @TmsLink("WFET-6677")
    private void GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateImageSelectorComponent()
                .validateJumpBackIsDimmed(Steps.size());
    }

    @Test(description = "WFET-6678 - GC03 - DSL User - through deeplink - Verify that form timer component is appearing in previous step with grey background when previously selected and other button are disabled in case clickback parameter is returned \"FALSE\"")
    @TmsLink("WFET-6678")
    private void GC03() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateTimerComponent()
                .validateJumpBackIsDimmed(Steps.size());
    }

    @Test(description = "WFET-6679 - GC04 - DSL User - through deeplink - Verify that MIC form component is appearing and previously selected components are disabled in case clickback parameter is returned \"FALSE\"")
    @TmsLink("WFET-6679")
    private void GC04() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .fillThreeParametersMicForm(familyName,postalCode,customerID)
                .validateJumpBackIsDimmed(Steps.size());
    }

    @Test(description = "WFET-6680 - GC05 - DSL User - through deeplink - Verify that Callback form component is appearing and previously selected components are disabled in case clickback parameter is returned \"FALSE\"")
    @TmsLink("WFET-6680")
    private void GC05() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .fillCallbackForm(mobileNumber)
                .validateCallBackServiceSucess()
                .validateJumpBackIsDimmed(Steps.size());
    }

    @Test(description = "WFET-6681 - GC06 - DSL User - through SO - Verify that form_formularOneColumn component with questionType=select & nodeType=select is appearing with grey background when clicked on and clickback parameter is returned \"FALSE\"")
    @TmsLink("WFET-6681")
    private void GC06() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateDropDownAppears()
                .validateJumpBackIsDimmed(Steps.size());
    }

    @Test(description = "WFET-6682 - GC07 - DSL User - through SO - Verify that form formularOneColumn component with questionType=info & nodeType=info is appearing with grey background when clicked on and clickback parameter is returned \"FALSE\"")
    @TmsLink("WFET-6682")
    private void GC07() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .fillFormularOneColumn(mobileNumber)
                .validateJumpBackIsDimmed(Steps.size());
    }

    @Test(description = "WFET-6684 - GC08 - DSL User - through SO - Verify that form formularOneColumn component with questionType=info & nodeType=info & Memo_Text_Rows>1 is appearing with grey background when clicked on and clickback parameter is returned 'FALSE'")
    @TmsLink("WFET-6684")
    private void GC08() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .fillFormularOneColumnMultipleRows(mobileNumber)
                .validateJumpBackIsDimmed(Steps.size());
    }

    @Test(description = "WFET-6683  -GC09 - DSL User - through SO - Verify that form formularOneColumn component with questionType=optionPicker & Memo_DD_OR_RB=Dropdown||automatisch&&>3 is appearing with grey background when clicked on and clickback parameter is returned \"FALSE\"")
    @TmsLink("WFET-6683")
    private void GC09() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateDropDownAppears()
                .validateJumpBackIsDimmed(Steps.size());
    }

    @Test(description = "WFET-6685 - GC10 - DSL User - through SO - Verify that form formularOneColumn component with questionType=suggestFields& Memo_DD_OR_RB=RadioButtons||automatisch&&<=3 is appearing with grey background when clicked on and clickback parameter is returned \"FALSE\"")
    @TmsLink("WFET-6685")
    private void GC10() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateOptionPickerAppears()
                .validateJumpBackIsDimmed(Steps.size());
    }

    @Test(description = "WFET-6686 - GC11 - DSL User - through SO - Verify that form wait component is appearing in case clickback parameter is returned \"FALSE\"")
    @TmsLink("WFET-6686")
    private void GC11() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateJumpBackIsDimmed(Steps.size());
    }

    @Test(description = "WFET-6687 - GC12 - DSL User - through SO - Verify that form date picker component is appearing in case clickback parameter is returned \"FALSE\"")
    @TmsLink("WFET-6687")
    private void GC12() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateDatePickerFormSuccess()
                .validateJumpBackIsDimmed(Steps.size());
    }

    @Test(description = "WFET-6835 - GC13 - DSL User - through SO - Verify that button component is appearing in previous step with grey background when previously selected and other button are enabled in case clickback parameter is returned \"TRUE\"")
    @TmsLink("WFET-6835")
    private void GC13() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6836 - GC14 - DSL User - through SO - Verify that image selector component is appearing in previous step with grey background when previously selected and other button are disabled in case clickback parameter is returned as\"TURE\"")
    @TmsLink("WFET-6836")
    private void GC14() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateImageSelectorComponent()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6837 - GC15 - DSL User - through SO - Verify that form timer component is appearing in previous step with grey background when previously selected and other button are disabled in case clickback parameter is returned \"TRUE\"")
    @TmsLink("WFET-6837")
    private void GC15() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateTimerComponent()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6839 - GC16 - DSL User - through SO - Verify that MIC form component is appearing and previously selected components are disabled in case clickback parameter is returned \"TRUE\"")
    @TmsLink("WFET-6839")
    private void GC16() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .fillTwoParametersMicForm(familyName,postalCode)
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6840 - GC17 - DSL User - through SO - Verify that Callback form component is appearing and previously selected components are disabled in case clickback parameter is returned \"TRUE\"")
    @TmsLink("WFET-6840")
    private void GC17() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .fillCallbackForm(mobileNumber)
                .validateCallBackServiceSucess()
                .validateJumpBackIsDimmed(Steps.size());
    }

    @Test(description = "WFET-6841 - GC18 - DSL User - through deeplink - Verify that form_formularOneColumn component with questionType=select & nodeType=select is appearing with grey background when clicked on and clickback parameter is returned \"TRUE\"")
    @TmsLink("WFET-6841")
    private void GC18() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateDropDownAppears()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6842 - GC19 - DSL User - through deeplink- Verify that form formularOneColumn component with questionType=info & nodeType=info is appearing with grey background when clicked on and clickback parameter is returned \"TRUE\"")
    @TmsLink("WFET-6842")
    private void GC19() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .fillFormularOneColumn(mobileNumber)
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6843 - GC20 - DSL User - through deeplink- Verify that form formularOneColumn component with questionType=optionPicker & Memo_DD_OR_RB=Dropdown||automatisch&&>3 is appearing with grey background when clicked on and clickback parameter is returned \"TRUE\"")
    @TmsLink("WFET-6843")
    private void GC20() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .fillFormularOneColumnMultipleRows(mobileNumber)
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6844  - GC21 - DSL User - through deeplink - Verify that form formularOneColumn component with questionType=info & nodeType=info & Memo_Text_Rows>1 is appearing with grey background when clicked on and clickback parameter is returned \"TRUE\"")
    @TmsLink("WFET-6844")
    private void GC21() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateDropDownAppears()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6845 - GC22 - DSL User - through deeplink - Verify that form formularOneColumn component with questionType=suggestFields& Memo_DD_OR_RB=RadioButtons||automatisch&&<=3 is appearing with grey background when clicked on and clickback parameter is returned \"TRUE\"")
    @TmsLink("WFET-6845")
    private void GC22() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateOptionPickerAppears()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6846 - GC23 - DSL User - through deeplink- Verify that form wait component is appearing in case clickback parameter is returned \"TRUE\"")
    @TmsLink("WFET-6846")
    private void GC23() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6847 - GC24 - DSL User - through SO - Verify that form date picker component is appearing in case clickback parameter is returned as \"TRUE\"")
    @TmsLink("WFET-6847")
    private void GC24() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateDatePickerFormSuccess()
                .validateJumpBackIsNotDimmed(Steps.size());
    }
    @Test(description = "WFET-6848 - GC25 - DSL User - through deeplink - Verify that button component is appearing in previous step with grey background when previously selected and other button are disabled in case clickback parameter is not returned")
    @TmsLink("WFET-6848")
    private void GC25() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6849 - GC26 - DSL User - through deeplink - Verify that image selector component is appearing in previous step with grey background when previously selected and other button are disabled in case clickback parameter is not returned")
    @TmsLink("WFET-6849")
    private void GC26() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateImageSelectorComponent()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6850 - GC27 - DSL User - through deeplink - Verify that form timer component is appearing in previous step with grey background when previously selected and other button are disabled in case clickback parameter is not returned")
    @TmsLink("WFET-6850")
    private void GC27() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateTimerComponent()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6851 - GC28 - DSL User - through deeplink - Verify that MIC form component is appearing and previously selected components are disabled in case clickback parameter is not returned")
    @TmsLink("WFET-6851")
    private void GC28() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .fillThreeParametersMicForm(familyName,postalCode,customerID)
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6852 - GC29 - DSL User - through deeplink - Verify that Callback form component is appearing and previously selected components are disabled in case clickback parameter is not returned")
    @TmsLink("WFET-6852")
    private void GC29() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .fillCallbackForm(mobileNumber)
                .validateCallBackServiceSucess()
                .validateJumpBackIsDimmed(Steps.size());
    }

    @Test(description = "WFET-6853 - GC30 - DSL User - through SO - Verify that form_formularOneColumn component with questionType=select & nodeType=select is appearing with grey background when clicked on and clickback parameter is not returned")
    @TmsLink("WFET-6853")
    private void GC30() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateDropDownAppears()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6854 - GC31 - DSL User - through SO - Verify that form formularOneColumn component with questionType=info & nodeType=info is appearing with grey background when clicked on and clickback parameter is not returned")
    @TmsLink("WFET-6854")
    private void GC31() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .fillFormularOneColumn(mobileNumber)
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6855 - GC32 - DSL User - through SO - Verify that form formularOneColumn component with questionType=optionPicker & Memo_DD_OR_RB=Dropdown||automatisch&&>3 is appearing with grey background when clicked on and clickback parameter is not returned")
    @TmsLink("WFET-6855")
    private void GC32() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .fillFormularOneColumnMultipleRows(mobileNumber)
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6856 - GC33 - DSL User - through SO - Verify that form formularOneColumn component with questionType=info & nodeType=info & Memo_Text_Rows>1 is appearing with grey background when clicked on and clickback parameter is not returned")
    @TmsLink("WFET-6856")
    private void GC33() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateDropDownAppears()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6857 - GC34 - DSL User - through SO - Verify that form formularOneColumn component with questionType=suggestFields& Memo_DD_OR_RB=RadioButtons||automatisch&&<=3 is appearing with grey background when clicked on and clickback parameter is not returned")
    @TmsLink("WFET-6857")
    private void GC34() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateOptionPickerAppears()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6858 - GC35 - DSL User - through SO - Verify that form wait component is appearing in case clickback parameter is not returned")
    @TmsLink("WFET-6858")
    private void GC35() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6859 - GC36 - DSL User - through SO - Verify that form date picker component is appearing in case clickback parameter is returned not returned")
    @TmsLink("WFET-6859")
    private void GC36() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateDatePickerFormSuccess()
                .validateJumpBackIsNotDimmed(Steps.size());
    }
}