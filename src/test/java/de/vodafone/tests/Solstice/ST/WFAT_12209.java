package de.vodafone.tests.Solstice.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.FirstLogin;
import de.vodafone.pages.Solstice.SolsticeAcceptInviteStepOne;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("Solstice")
@Feature("ST")
@Story("WFAT_12209")
public class WFAT_12209  {

    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public String token;
    public HashMap<String, String> cookieMap;
    public String tokenURL;
    public String password;
    public String reEnterPassword;
    public String password1;
    public String reEnterPassword1;
    public String password2;
    public String reEnterPassword2;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String newPass;
    private String confirmPass;
    private String captcha="1234";

    String baseUrl = System.getProperty("de.vodafone.baseUrl.st");
    public String url = baseUrl + "meinvodafone/account/einladung?inv_type=solstice-delegation&token=";
    public String urlAfterRedirectionPass = System.getProperty("de.vodafone.baseUrl.st") + "meinvodafone/account/einladung/annehmen";
    public String urlAfterRedirectionFail = baseUrl + "meinvodafone/account/willkommen?token=";
    public String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");

    @BeforeMethod
    @Description("Enter and repeat paswword , go to confirmation page")
    public void setup(Method method) {
        token=testData.getTestData(method.getName()+".token");
        tokenURL = url+token;
        urlAfterRedirectionFail=urlAfterRedirectionFail+token;
        password = testData.getTestData(method.getName()+".password");
        reEnterPassword = testData.getTestData(method.getName()+".confirmPassword");

        password1 = testData.getTestData(method.getName()+".password1");
        reEnterPassword1 = testData.getTestData(method.getName()+".confirmPassword1");

        password2 = testData.getTestData(method.getName()+".password2");
        reEnterPassword2 = testData.getTestData(method.getName()+".confirmPassword2");

        driver = new SHAFT.GUI.WebDriver();
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "Solstice/ST_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "Solstice/ST/" + className + ".json");
    }

    @TmsLink("WFAT-12446")
    @Test(description=" WFAT-12446-Given Un-Registered user" +
            "\nWhen  Accept delegation invitation e-mail then Signup" +
            "\n then Verify confirmation notification")
    public void GCO1(Method method) {
        firstName = testData.getTestData(method.getName() + ".firstName");
        lastName = testData.getTestData(method.getName() + ".lastName");
        phoneNumber = testData.getTestData(method.getName() + ".phoneNumber");
        newPass = testData.getTestData(method.getName() + ".newPass");
        confirmPass = testData.getTestData(method.getName() + ".confirmPass");

        new FirstLogin(driver).navigate()
                .setCookie(cookieMap)
                .navigate(tokenURL, urlAfterRedirectionPass)
                .acceptCookies();
        new SolsticeAcceptInviteStepOne(driver).clickOnRegisterButton()
                .ChooseAnrede().enterVorname(firstName).enterNachname(lastName).clickWeiterButton()
                .enterPhoneNumber(phoneNumber).clickWeiterButton()
                .enterPass(newPass).enterConfirmPass(confirmPass).enterCaptcha(captcha).clickWeiterButton()
                .clickSpeichern().clickWeiterButton();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeDashboard.AcceptInvitationHeader_text)
                .text()
                .contains(SolsticeDashboard.AcceptInvitationHeader)
                .withCustomReportMessage("Check that Header text exist in Dashboard ")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeDashboard.AcceptInvitationTitle_text)
                .text()
                .contains(SolsticeDashboard.AcceptInvitationTitle)
                .withCustomReportMessage("Check that Header text exist in Dashboard")
                .perform();

    }
}