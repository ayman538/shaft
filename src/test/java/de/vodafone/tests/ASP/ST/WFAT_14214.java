package de.vodafone.tests.ASP.ST;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.ASP.ASPLandingPage;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("After Sales Portal")
@Feature("ST")
@Story("WFAT-14214")

public class WFAT_14214 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String environment = "ST";
    public String EmailAddress = "Menh@gmail.com";
    public String CustomerNumber = "1234567891";
    public String ContractNumber = "123456789";
    public String AreaCode = "002";
    public String  PhoneNumber = "1234545345";


    @BeforeClass()
    @Description("Setting cookie map file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "ASP/ST_WFAT-14077_CookieSwitcher.json").getTestDataAsMap("$");
    }

    @BeforeMethod
    @Description("setting branches and navigating to landing page url")
    public void setup(Method method) {
        driver = new SHAFT.GUI.WebDriver();
        new ASPLandingPage(driver).navigate(environment)
                .setCookie(cookieMap)
                .navigate(environment)
                .acceptCookies();
    }
    @TmsLink("WFAT-14887")
    @Test(description = "WFAT-14887-Giraffe user validate user field and fill the form ")
    private void GC01() {
        new ASPLandingPage(driver)
                .GiraffeUser().NavigatetosalesAgent()
                .clickCancelButton()
                .fillFormStep1()
                .clickSubmitButton()
                .fillFormStep2UM().clickSubmitButtonStep2()
                .GiraffeUserfieldsValidation().FillForm3Giraffe(EmailAddress,CustomerNumber,AreaCode,PhoneNumber);
    }
    @TmsLink("WFAT-14888")
    @Test(description = "WFAT-14888-Camel user validate user fields and submit the form ")
    private void GC02() {
        new ASPLandingPage(driver)
                .CamelUser().NavigatetosalesAgent()
                .clickCancelButton()
                .fillFormStep1().clickSubmitButton().fillFormStep2KD().clickSubmitButtonStep2()
                .CamelUserfieldsValidation().FillForm3Camel(EmailAddress,CustomerNumber,ContractNumber,AreaCode,PhoneNumber);
    }

    @TmsLink("WFAT-14889")
    @Test(description = "WFAT-14889-Deer user validate user fields and submit the form ")
    private void GC03() {
        new ASPLandingPage(driver)
                .DeerUser()/*.clickSkipLogin()*/
                .Navigattosalesagnet_tremination()
                .clickCancelButton()
                .fillFormStep1().clickSubmitButton().fillFormStep2UM().clickSubmitButtonStep2()
                .DeerUserfieldsValidation().FillForm3Deer(EmailAddress,CustomerNumber,AreaCode,PhoneNumber);
    }

    @TmsLink("WFAT-14890")
    @Test(description = "WFAT-14890-Foxuser validate user fields and submit the form ")
    private void GC04() {
        new ASPLandingPage(driver)
                .FoxUser().Navigattosalesagnet_tremination()
                .clickCancelButton()
                .fillFormStep1().clickSubmitButton().fillFormStep2KD().clickSubmitButtonStep2()
                .FoxUserfiledsValidation().FillForm3Fox(EmailAddress,CustomerNumber,ContractNumber,AreaCode,PhoneNumber);
    }
    @TmsLink("WFAT-14891")
    @Test(description = "WFAT-14891-Giraffe user click popup button and validate popup ")
    private void GC05() {
        new ASPLandingPage(driver)
                .GiraffeUser().NavigatetosalesAgent()
                .clickCancelButton()
                .fillFormStep1().clickSubmitButton().fillFormStep2UM().clickSubmitButtonStep2().CLickPopup().
                popupValidation();

    }
    @TmsLink("WFAT-14895")
    @Test(description = "WFAT-14895-Cabel user verify new filed displyed when click andere")
    private void GC09() {
        new ASPLandingPage(driver)
                .CamelUser().NavigatetosalesAgent()
                .clickCancelButton()
                .fillFormStep1().clickSubmitButton().fillFormStep2KD().clickSubmitButtonStep2().CLickAndere()
                .AndereValidation();
    }
    @TmsLink("WFAT-14896")
    @Test(description = "WFAT-14896-Deer user verify new filed displayed when click Anderer Grund")
    private void GC10() {
        new ASPLandingPage(driver)
                .DeerUser()/*.clickSkipLogin()*/
                .Navigattosalesagnet_tremination()
                .clickCancelButton()
                .fillFormStep1().clickSubmitButton().fillFormStep2UM().clickSubmitButtonStep2().CLickAndereGrund()
                .AndereGrundValidation();
    }
    @TmsLink("WFAT-14890")
    @Test(description = "WFAT-14890-Fox user Validate information message")
    private void GC11() {
        new ASPLandingPage(driver)
                .FoxUser().Navigattosalesagnet_tremination()
                .clickCancelButton()
                .fillFormStep1().clickSubmitButton().fillFormStep2KD().clickSubmitButtonStep2()
                .ClickandValidateInfomessgae();
    }
    @TmsLink("WFAT-14890")
    @Test(description = "WFAT-14890-Fox user Validate Erorr message")
    private void GC12() {
        new ASPLandingPage(driver)
                .FoxUser().Navigattosalesagnet_tremination()
                .clickCancelButton()
                .fillFormStep1().clickSubmitButton().fillFormStep2KD().clickSubmitButtonStep2()
                .fillInvaildData_KD().ErorrMsgValidation_KD();
    }

}