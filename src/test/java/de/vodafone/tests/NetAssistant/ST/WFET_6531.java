package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.TmsLink;
import org.stringtemplate.v4.ST;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WFET_6531 extends STNetAssistantSetup {

    private String userName;
    private String password;
    private String deeplink;
    private String mobileNumber;
    private HashMap<String, String> cookieSwitcherMap;
    private List<String> Steps;
    private HashMap<String, ArrayList> dslTree;
    private HashMap<String, ArrayList> cableTree;
    private HashMap<String, ArrayList> unityMediaTree;


    @BeforeMethod
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".name");
        password = testData.getTestData(method.getName() + ".password");
        deeplink = testData.getTestData(method.getName() + ".link");
        mobileNumber = testData.getTestData(method.getName() + ".mobileNumber");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        Steps = (List<String>) testData.getTestDataAsList(method.getName() + ".Steps");
        dslTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("dslTree");
        cableTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("cableTree");
        unityMediaTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("unityMediaTree");
        super.setup(method);
        loginAction(cookieSwitcherMap, userName, password);
    }

    @Test(description = "WFET-6907 - GC01 - Cable User - through deeplink - Verify that the pervious answer in enabled when \"Memo_Disable_History=false\" for option picker component")
    @TmsLink("WFET-6907")
    public void ST_GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateOptionPickerAppears()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6908 - GC02 - Cable User - through Meinvodafone - Verify that the pervious answer in enabled when \"Memo_Disable_History=false\" for option picker component")
    @TmsLink("WFET-6908")
    public void ST_GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateOptionPickerAppears()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6909- GC03 - UM User - through deeplink - Verify that the pervious answer in enabled when \"Memo_Disable_History=false\" for option picker component")
    @TmsLink("WFET-6909")
    public void ST_GC03() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateOptionPickerAppears()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6910- GC04 - UM User - through Meinvodafone - Verify that the pervious answer in enabled when \"Memo_Disable_History=false\" for option picker component")
    @TmsLink("WFET-6910")
    public void ST_GC04() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateOptionPickerAppears()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6911 - GC05 - Cable User - through deeplink - Verify that the pervious answer in enabled when \"Memo_Disable_History\" not returned for option picker component")
    @TmsLink("WFET-6911")
    public void ST_GC05() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateOptionPickerAppears()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6912 - GC06 - Cable User - through Meinvodafone - Verify that the pervious answer in enabled when \"Memo_Disable_History\" not returned for option picker component")
    @TmsLink("WFET-6912")
    public void ST_GC06() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateOptionPickerAppears()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6913 - WFET-6913GC07 - UM User - through deeplink - Verify that the pervious answer in enabled when \"Memo_Disable_History\" not returned for option picker componen")
    @TmsLink("WFET-6913")
    public void ST_GC07() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateOptionPickerAppears()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6914 - GC08 - UM User - through Meinvodafone - Verify that the pervious answer in enabled when \"Memo_Disable_History\" not returned for option picker componen")
    @TmsLink("WFET-6914")
    public void ST_GC08() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateOptionPickerAppears()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6916 - GC09 - Cable User - through deeplink - Verify that the pervious answer in disabled when \"Memo_Disable_History=true\"for option picker componen")
    @TmsLink("WFET-6916")
    public void ST_GC09() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateOptionPickerAppears()
                .validateJumpBackIsDimmed(Steps.size());
    }

    @Test(description = "WFET-6917 - GC10 - Cable User - through Meinvodafone - Verify that the pervious answer in disabled when \"Memo_Disable_History=true\"for option picker componen")
    @TmsLink("WFET-6917")
    public void ST_GC10() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateOptionPickerAppears()
                .validateJumpBackIsDimmed(Steps.size());
    }

    @Test(description = "WFET-6919 - GC11 - UM User - through deeplink - Verify that the pervious answer in disabled when \"Memo_Disable_History=true\"for option picker component")
    @TmsLink("WFET-6919")
    public void ST_GC11() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateOptionPickerAppears()
                .validateJumpBackIsDimmed(Steps.size());
    }

    @Test(description = "WFET-6920 - GC12 - UM User - through Meinvodafone - Verify that the pervious answer in disabled when \"Memo_Disable_History=true\"for option picker component")
    @TmsLink("WFET-6920")
    public void ST_GC12() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateOptionPickerAppears()
                .validateJumpBackIsDimmed(Steps.size());
    }

    @Test(description = "WFET-6921 - GC13 - Cable User - through deeplink - Verify that the pervious answer in enabled when \"Memo_Disable_History=false\" for dropdown component")
    @TmsLink("WFET-6921")
    public void ST_GC13() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateDropDownAppears()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6922 - GC14 - Cable User - through Meinvodafone - Verify that the pervious answer in enabled when \"Memo_Disable_History=false\" for dropdown component")
    @TmsLink("WFET-6922")
    public void ST_GC14() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateDropDownAppears()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6923 - GC15 - UM User - through deeplink- Verify that the pervious answer in enabled when \"Memo_Disable_History=false\" for dropdown component")
    @TmsLink("WFET-6923")
    public void ST_GC15() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateDropDownAppears()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6924 - GC16 - UM User - through Meinvodafone- Verify that the pervious answer in enabled when \"Memo_Disable_History=false\" for dropdown component")
    @TmsLink("WFET-6924")
    public void ST_GC16() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateDropDownAppears()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6925 - GC17 - cable User - through deeplink- Verify that the pervious answer in enabled when \"Memo_Disable_History\"not returned for dropdown component")
    @TmsLink("WFET-6925")
    public void ST_GC17() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateDropDownAppears()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6926 - GC18 - cable User - through Meinvodafone- Verify that the pervious answer in enabled when \"Memo_Disable_History\"not returned for dropdown component")
    @TmsLink("WFET-6926")
    public void ST_GC18() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateDropDownAppears()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6927 - GC19 -UM User - through deeplink- Verify that the pervious answer in enabled when \"Memo_Disable_History\"not returned for dropdown component")
    @TmsLink("WFET-6927")
    public void ST_GC19() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateDropDownAppears()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "GC20 -UM User - through Meinvodafone- Verify that the pervious answer in enabled when \"Memo_Disable_History\"not returned for dropdown component")
    @TmsLink("WFET-6928")
    public void ST_GC20() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateDropDownAppears()
                .validateJumpBackIsNotDimmed(Steps.size());
    }

    @Test(description = "WFET-6929 - GC21 - Cable User - through deeplink - Verify that the pervious answer in disabled when \"Memo_Disable_History=true\"for dropdown component\n")
    @TmsLink("WFET-6929")
    public void ST_GC21() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateDropDownAppears()
                .validateJumpBackIsDimmed(Steps.size());
    }

    @Test(description = "WFET-6930 - GC22 - Cable User - through Meinvodafone - Verify that the pervious answer in disabled when \"Memo_Disable_History=true\"for dropdown component\n")
    @TmsLink("WFET-6930")
    public void ST_GC22() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateDropDownAppears()
                .validateJumpBackIsDimmed(Steps.size());
    }

    @Test(description = "WFET-6931 - GC23 - UM User - through deeplink - Verify that the pervious answer in disabled when \"Memo_Disable_History=true\"for dropdown component")
    @TmsLink("WFET-6931")
    public void ST_GC23() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateDropDownAppears()
                .validateJumpBackIsDimmed(Steps.size());
    }

    @Test(description = "WFET-6932 - GC24 - UM User - through Meinvodafone - Verify that the pervious answer in disabled when \"Memo_Disable_History=true\"for dropdown component")
    @TmsLink("WFET-6932")
    public void ST_GC24() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateDropDownAppears()
                .validateJumpBackIsDimmed(Steps.size());
    }
}





