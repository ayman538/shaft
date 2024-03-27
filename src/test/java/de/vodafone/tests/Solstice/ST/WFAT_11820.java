package de.vodafone.tests.Solstice.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.ConfirmationPage;
import de.vodafone.pages.Solstice.FirstLogin;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("Solstice")
@Feature("ST")
@Story("WFAT_11820")
public class WFAT_11820  {
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
    String baseUrl = System.getProperty("de.vodafone.baseUrl.st");
    public String url = baseUrl + "meinvodafone/account/willkommen?token=";
    public String urlAfterRedirectionPass = System.getProperty("de.vodafone.baseUrl.st") + "meinvodafone/account/willkommen/firstlogin";
    public String urlAfterRedirectionFail = baseUrl + "meinvodafone/account/willkommen?token=";
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");

    @BeforeMethod
    @Description("Enter and repeat paswword , go to confirmation page")
    public void setup(Method method) {
        token = testData.getTestData(method.getName() + ".token");
        tokenURL = url + token;
        urlAfterRedirectionFail = urlAfterRedirectionFail + token;
        password = testData.getTestData(method.getName() + ".password");
        reEnterPassword = testData.getTestData(method.getName() + ".confirmPassword");

        password1 = testData.getTestData(method.getName() + ".password1");
        reEnterPassword1 = testData.getTestData(method.getName() + ".confirmPassword1");

        password2 = testData.getTestData(method.getName() + ".password2");
        reEnterPassword2 = testData.getTestData(method.getName() + ".confirmPassword2");

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

    @TmsLink("WFAT-12084")
    @Test(description = "WFAT-12084-Solstice User - enter valid password - verify confirmation page")
    private void GC01() {

        new FirstLogin(driver).navigate()
                .setCookie(cookieMap)
                .navigate(tokenURL, urlAfterRedirectionPass)
                .acceptCookies();

        Validations.assertThat()
                .element(driver.getDriver(), FirstLogin.firstLoginHeader_text)
                .text()
                .contains(FirstLogin.firstLoginHeader)
                .withCustomReportMessage("verify first login header")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), FirstLogin.setPassHere_text)
                .text()
                .contains(FirstLogin.setPassHere).
                withCustomReportMessage("verify password field title")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), FirstLogin.regexDescription_text)
                .text()
                .contains(FirstLogin.regexDescription).withCustomReportMessage("verify regex instruction")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), FirstLogin.confirmaPass_button)
                .text().contains(FirstLogin.confirmaPass).withCustomReportMessage("verify CTA button field")
                .perform();

        new FirstLogin(driver).navigate()
                .addPassword(password)
                .reEnterPassword(reEnterPassword);

        Validations.assertThat()
                .element(driver.getDriver(), ConfirmationPage.firstLoginHeader_text)
                .text()
                .contains(FirstLogin.firstLoginHeader).withCustomReportMessage("verify confirmation page header")
                .perform();


        Validations.assertThat()
                .element(driver.getDriver(), ConfirmationPage.confirmationTitle_text)
                .text()
                .contains(ConfirmationPage.confirmationTitle).withCustomReportMessage("verify confirmation page title")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), ConfirmationPage.confirmationDescription_text)
                .text()
                .contains(ConfirmationPage.confirmationDescription).withCustomReportMessage("verify confirmation page description")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), ConfirmationPage.toHomePage_button)
                .text()
                .contains(ConfirmationPage.toHomePage).withCustomReportMessage("verify CTA button text")
                .perform();

    }

    @TmsLink("WFAT-12085")
    @Test(description = "WFAT-12085-Solstice User - validate password field")
    private void GC02() {


        new FirstLogin(driver).navigate()
                .setCookie(cookieMap)
                .navigate(tokenURL, urlAfterRedirectionPass)
                .acceptCookies();

        Validations.assertThat()
                .element(driver.getDriver(), FirstLogin.firstLoginHeader_text)
                .text()
                .contains(FirstLogin.firstLoginHeader)
                .withCustomReportMessage("verify first login header")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), FirstLogin.setPassHere_text)
                .text()
                .contains(FirstLogin.setPassHere).
                withCustomReportMessage("verify password field title")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), FirstLogin.regexDescription_text)
                .text()
                .contains(FirstLogin.regexDescription).withCustomReportMessage("verify regex instruction")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), FirstLogin.confirmaPass_button)
                .text().contains(FirstLogin.confirmaPass).withCustomReportMessage("verify CTA button field")
                .perform();

        new FirstLogin(driver).navigate()
                .addPassword(password)
                .reEnterInValidPassword(reEnterPassword);

        Validations.assertThat()
                .element(driver.getDriver(), FirstLogin.errorMessage_text)
                .text()
                .contains(FirstLogin.errorMessage).withCustomReportMessage("verify Error Message")
                .perform();

        new FirstLogin(driver).navigate()
                .addPassword(password1)
                .reEnterInValidPassword(reEnterPassword1);

        new FirstLogin(driver).navigate()
                .addPassword(password2)
                .reEnterInValidPassword(reEnterPassword2);

    }

    @TmsLink("WFAT-12088")
    @Test(description = "WFAT-12088-Solstice User - enters username in password filed-verify error message")
    private void BC03() {

        new FirstLogin(driver).navigate()
                .setCookie(cookieMap)
                .navigate(tokenURL, urlAfterRedirectionPass)
                .acceptCookies().addPassword(password).reEnterPassword(reEnterPassword);

        Verifysameusername_error();
    }
    @TmsLink("WFAT-12089")
    @Test(description = "WFAT-12089-Solstice User - enters invalid password-verify error message")
    private void BC04() {

        new FirstLogin(driver).navigate()
                .setCookie(cookieMap)
                .navigate(tokenURL, urlAfterRedirectionPass)
                .acceptCookies().addPassword(password).reEnterPassword(reEnterPassword);
        VerifyInvalidpassword_msg();
    }


    public void Verifysameusername_error(){

        Validations.assertThat()
                .element(driver.getDriver(), FirstLogin.firstLoginHeader_text)
                .text()
                .contains(FirstLogin.firstLoginHeader)
                .withCustomReportMessage("verify first login header")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FirstLogin.errorMessage_text_password)
                .text()
                .contains(FirstLogin.errorMessage_samepassword)
                .withCustomReportMessage("verify error message text")
                .perform();
    }


    public void VerifyInvalidpassword_msg(){

        Validations.assertThat()
                .element(driver.getDriver(), FirstLogin.firstLoginHeader_text)
                .text()
                .contains(FirstLogin.firstLoginHeader)
                .withCustomReportMessage("verify first login header")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FirstLogin.errorMessage_text_password)
                .text()
                .contains(FirstLogin.errorMessage_invalidpassword_text)
                .withCustomReportMessage("verify invalid error message text")
                .perform();


    }


}