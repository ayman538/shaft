package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.DashboardPage;
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
@Story("WFET_6998")
public class WFET_6998 extends STNetAssistantSetup {
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
        deeplink = testData.getTestData(method.getName() + ".link");
        userName = testData.getTestData(method.getName() + ".name");
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

    @Test(description = "WFET-6998-GC13-Cable user-through Deeplink-Verify massouage message displayed when affected service array =empty")
    @TmsLink("WFET-7355")
    private void GC13() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .validateAffectedServicesEmptyArrayMsg()
                .validateIchMöchteEineInfoBekommenBtnDisplayed();
    }
    @Test(description = "WFET-6998-GC14-Cable user-through SO-Verify massouage message displayed when affected service array =empty")
    @TmsLink("WFET-7356")
    private void GC14() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .validateAffectedServicesEmptyArrayMsg()
                .validateIchMöchteEineInfoBekommenBtnDisplayed();
    }
    @Test(description = "WFET-6998-GC15-UM user-through Deeplink-Verify massouage message displayed when affected service array =empty")
    @TmsLink("WFET-7357")
    private void GC15() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .validateAffectedServicesEmptyArrayMsg()
                .validateIchMöchteEineInfoBekommenBtnNotDisplayed();
    }
    @Test(description = "WFET-6998-GC16-UM user-through SO-Verify massouage message displayed when affected service array =empty")
    @TmsLink("WFET-7358")
    private void GC16() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .validateAffectedServicesEmptyArrayMsg()
                .validateIchMöchteEineInfoBekommenBtnNotDisplayed();
    }
    @Test(description = "WFET-6998-GC09-Cable user-through Deeplink-Verify massouage message displayed when there is no massouage")
    @TmsLink("WFET-7276")
    private void GC09() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessageCL()
                .validateIchMöchteEineInfoBekommenBtnNotDisplayed();
    }
    @Test(description = "WFET-6998-GC10-Cable user-through SO-Verify massouage message displayed when there is no massouage")
    @TmsLink("WFET-7277")
    private void GC10() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessageCL()
                .validateIchMöchteEineInfoBekommenBtnNotDisplayed();
    }
    @Test(description = "WFET-6998-GC11-UM user-through deeplink-Verify massouage message displayed when there is no massouage")
    @TmsLink("WFET-7278")
    private void GC11() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessageCL()
                .validateIchMöchteEineInfoBekommenBtnNotDisplayed();
    }
    @Test(description = "WFET-6998-GC12-UM user-through SO-Verify massouage message displayed when there is no massouage")
    @TmsLink("WFET-7279")
    private void GC12() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessageCL()
                .validateIchMöchteEineInfoBekommenBtnNotDisplayed();
    }
    @Test(description = "WFET-6998-GC01-Cable user-through Deeplink-Verify massouage message displayed when there is massouage with affected service")
    @TmsLink("WFET-7268")
    private void GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .validateAffectedServicesMsg()
                .validateIchMöchteEineInfoBekommenBtnDisplayed();
    }
    @Test(description = "WFET-6998-GC02-Cable user-through SO-Verify massouage message displayed when there is massouage with affected service")
    @TmsLink("WFET-7269")
    private void GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .validateAffectedServicesMsg()
                .validateIchMöchteEineInfoBekommenBtnDisplayed();
    }
    @Test(description = "WFET-6998-GC03-UM user-through Deeplink-Verify massouage message displayed when there is massouage with affected service")
    @TmsLink("WFET-7230")
    private void GC03() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .validateAffectedServicesMsg()
                .validateIchMöchteEineInfoBekommenBtnNotDisplayed();
    }
    @Test(description = "WFET-6998-GC03-UM user-through SO-Verify massouage message displayed when there is massouage with affected service")
    @TmsLink("WFET-7231")
    private void GC04() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .validateAffectedServicesMsg()
                .validateIchMöchteEineInfoBekommenBtnNotDisplayed();
    }

}