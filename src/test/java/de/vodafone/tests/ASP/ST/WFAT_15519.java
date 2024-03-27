package de.vodafone.tests.ASP.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.ASP.ASPLandingPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("After Sales Portal")
@Feature("ST")
@Story("WFAT-15519")
public class WFAT_15519 {
    private SHAFT.GUI.WebDriver driver;
    private JSONFileManager testData;
    private HashMap<String, String> cookieMap;

    private String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");
    private String environment ="ST";

    @TmsLink("WFAT-15658")
    @Test(description="WFAT-15658 - Check First name Field Regex")
    private void GC01(Method method) {
        new ASPLandingPage(driver).GiraffeUser().clickoption3().clickCancelButton()
                .typeCustomFirstName(testData.getTestData(method.getName() + ".firstNameNumbers"))
                .validateFirstnameErrorVisibility()
                .typeCustomFirstName(testData.getTestData(method.getName() + ".firstNameMixed"))
                .validateFirstnameErrorVisibility()
                .typeCustomFirstName(testData.getTestData(method.getName() + ".firstNameNonLatin"))
                .validateFirstnameErrorVisibility()
                .typeCustomFirstName(testData.getTestData(method.getName() + ".firstNameMixedNonLatin"))
                .validateFirstnameErrorVisibility()
                .typeCustomFirstName(testData.getTestData(method.getName() + ".firstNameMax"))
                .validateFirstnameErrorVisibility()
                .typeCustomFirstName(testData.getTestData(method.getName() + ".firstName"))
                .validateFirstnameGreenVisibility();
    }

    @TmsLink("WFAT-15659")
    @Test(description="WFAT-15659 - Check Last name Field Regex")
    private void GC02(Method method) {
        new ASPLandingPage(driver).GiraffeUser().clickoption3().clickCancelButton()
                .typeCustomLastName(testData.getTestData(method.getName() + ".lastNameNumbers"))
                .validateLastnameErrorVisibility()
                .typeCustomLastName(testData.getTestData(method.getName() + ".lastNameMixed"))
                .validateLastnameErrorVisibility()
                .typeCustomLastName(testData.getTestData(method.getName() + ".lastNameNonLatin"))
                .validateLastnameErrorVisibility()
                .typeCustomLastName(testData.getTestData(method.getName() + ".lastNameMixedNonLatin"))
                .validateLastnameErrorVisibility()
                .typeCustomLastName(testData.getTestData(method.getName() + ".lastNameMax"))
                .validateLastnameErrorVisibility()
                .typeCustomLastName(testData.getTestData(method.getName() + ".lastName"))
                .validateLastnameGreenVisibility();
    }

    @TmsLink("WFAT-15660")
    @Test(description="WFAT-15660 - Check Street name Field Regex")
    private void GC03(Method method) {
        new ASPLandingPage(driver).GiraffeUser().clickoption3().clickCancelButton()
                .fillFormStep1()
                .clickSubmitButton()
                .typeCustomStreetName(testData.getTestData(method.getName() + ".streetNameNumbers"))
                .validateStreetNameErrorVisibility()
                .typeCustomStreetName(testData.getTestData(method.getName() + ".streetNameMixed"))
                .validateStreetNameErrorVisibility()
                .typeCustomStreetName(testData.getTestData(method.getName() + ".streetNameNonLatin"))
                .validateStreetNameErrorVisibility()
                .typeCustomStreetName(testData.getTestData(method.getName() + ".streetNameMixedNonLatin"))
                .validateStreetNameErrorVisibility()
                .typeCustomStreetName(testData.getTestData(method.getName() + ".streetNameMax"))
                .validateStreetNameErrorVisibility()
                .typeCustomStreetName(testData.getTestData(method.getName() + ".streetName"))
                .validateStreetNameGreenVisibility();
    }

    @TmsLink("WFAT-15661")
    @Test(description="WFAT-15661 - Check House Number Field Regex")
    private void GC04(Method method) {
        new ASPLandingPage(driver).GiraffeUser().clickoption3().clickCancelButton()
                .fillFormStep1()
                .clickSubmitButton()
                .typeCustomHouseNumber(testData.getTestData(method.getName() + ".houseNumberNumbers"))
                .validateHouseNumberGreenVisibility()
                .typeCustomHouseNumber(testData.getTestData(method.getName() + ".houseNumberMixed"))
                .validateHouseNumberGreenVisibility()
                .typeCustomHouseNumber(testData.getTestData(method.getName() + ".houseNumberNonLatin"))
                .validateHouseNumberErrorVisibility()
                .typeCustomHouseNumber(testData.getTestData(method.getName() + ".houseNumberMixedNonLatin"))
                .validateHouseNumberErrorVisibility()
                .typeCustomHouseNumber(testData.getTestData(method.getName() + ".houseNumberMax"))
                .validateHouseNumberErrorVisibility()
                .typeCustomHouseNumber(testData.getTestData(method.getName() + ".houseNumberMixedNonLatinNumbers"))
                .validateHouseNumberErrorVisibility();
    }

    @TmsLink("WFAT-15662")
    @Test(description="WFAT-15662 - Check City name Field Regex")
    private void GC05(Method method) {
        new ASPLandingPage(driver).GiraffeUser().clickoption3().clickCancelButton()
                .fillFormStep1()
                .clickSubmitButton()
                .typeCustomCityName(testData.getTestData(method.getName() + ".cityNameNumbers"))
                .validateCityNameErrorVisibility()
                .typeCustomCityName(testData.getTestData(method.getName() + ".cityNameMixed"))
                .validateCityNameErrorVisibility()
                .typeCustomCityName(testData.getTestData(method.getName() + ".cityNameNonLatin"))
                .validateCityNameErrorVisibility()
                .typeCustomCityName(testData.getTestData(method.getName() + ".cityNameMixedNonLatin"))
                .validateCityNameErrorVisibility()
                .typeCustomCityName(testData.getTestData(method.getName() + ".cityNameMax"))
                .validateCityNameErrorVisibility()
                .typeCustomCityName(testData.getTestData(method.getName() + ".cityName"))
                .validateCityNameGreenVisibility();
    }

    @TmsLink("WFAT-15663")
    @Test(description="WFAT-15663 - Check Phone number Field Regex")
    private void GC06(Method method) {
        new ASPLandingPage(driver).FoxUser()/*.clickSkipLogin().clickoption3()*/
                .Navigattosalesagnet_tremination()
                .clickCancelButton()
                .fillFormStep1()
                .clickSubmitButton()
                .fillFormStep2KD()
                .clickSubmitButtonStep2()
                .typeCustomPhoneNumber(testData.getTestData(method.getName() + ".phoneNumber"))
                .validatePhoneNumberGreenVisibility()
                .typeCustomPhoneNumber(testData.getTestData(method.getName() + ".phoneNumberMixed"))
                .validatePhoneNumberErrorVisibility()
                .typeCustomPhoneNumber(testData.getTestData(method.getName() + ".phoneNumberNonLatin"))
                .validatePhoneNumberErrorVisibility()
                .typeCustomPhoneNumber(testData.getTestData(method.getName() + ".phoneNumberMin"))
                .validatePhoneNumberErrorVisibility()
                .typeCustomPhoneNumber(testData.getTestData(method.getName() + ".phoneNumberMax"))
                .validatePhoneNumberErrorVisibility();
    }

    @TmsLink("WFAT-15664")
    @Test(description="WFAT-15664 - Check Customer Number Field Regex")
    private void GC07(Method method) {
        new ASPLandingPage(driver).FoxUser()/*.clickSkipLogin().clickoption3()*/
                .Navigattosalesagnet_tremination()
                .clickCancelButton()
                .fillFormStep1()
                .clickSubmitButton()
                .fillFormStep2KD()
                .clickSubmitButtonStep2()
                .typeCustomCustomerNumber(testData.getTestData(method.getName() + ".customerNumber"))
                .validateCustomerNumberGreenVisibility()
                .typeCustomCustomerNumber(testData.getTestData(method.getName() + ".customerNumberMixed"))
                .validateCustomerNumberErrorVisibility()
                .typeCustomCustomerNumber(testData.getTestData(method.getName() + ".customerNumberNonLatin"))
                .validateCustomerNumberErrorVisibility()
                .typeCustomCustomerNumber(testData.getTestData(method.getName() + ".customerNumberMin"))
                .validateCustomerNumberErrorVisibility()
                .typeCustomCustomerNumber(testData.getTestData(method.getName() + ".customerNumberMax"))
                .validateCustomerNumberErrorVisibility();
    }

    @TmsLink("WFAT-15665")
    @Test(description="WFAT-15665 - Check Product Number Field Regex")
    private void GC08(Method method) {
        new ASPLandingPage(driver).FoxUser()/*.clickSkipLogin().clickoption3()*/
                .Navigattosalesagnet_tremination()
                .clickCancelButton()
                .fillFormStep1()
                .clickSubmitButton()
                .fillFormStep2KD()
                .clickSubmitButtonStep2()
                .typeCustomProductNumber(testData.getTestData(method.getName() + ".productNumber"))
                .validateProductNumberGreenVisibility()
                .typeCustomProductNumber(testData.getTestData(method.getName() + ".productNumberMixed"))
                .validateProductNumberErrorVisibility()
                .typeCustomProductNumber(testData.getTestData(method.getName() + ".productNumberNonLatin"))
                .validateProductNumberErrorVisibility()
                .typeCustomProductNumber(testData.getTestData(method.getName() + ".productNumberMax"))
                .validateProductNumberErrorVisibility();
    }

    /////////////// Configurations \\\\\\\\\\\\\\\\\\
    @BeforeClass()
    @Description("Setting cookie map file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "ASP/ST_WFAT-15519_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "ASP/ST/" + className + ".json");
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

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}