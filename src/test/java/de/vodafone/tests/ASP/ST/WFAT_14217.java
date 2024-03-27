package de.vodafone.tests.ASP.ST;

/*@Epic("After Sales Portal")
@Feature("ST")
@Story("WFAT-14217")
public class WFAT_14217 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String environment ="ST";
    @BeforeClass()
    @Description("Setting cookie map file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "ASP/ST_WFAT-14217_CookieSwitcher.json").getTestDataAsMap("$");
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

    @TmsLink("WFAT-14432")
    @Test(description="Deer user navigates to Login/Skip Login page")
    private void GC01() {
        new ASPLandingPage(driver).DeerUser().CLValidations();
    }

    @TmsLink("WFAT-14433")
    @Test(description="Fox user navigates to Login/Skip Login page")
    private void GC02() {
        new ASPLandingPage(driver).FoxUser().CLValidations();
    }

    @TmsLink("WFAT-14435")
    @Test(description="Fox user checks redirection of skip login button")
    private void GC03() {
        new ASPLandingPage(driver).FoxUser().clickSkipLogin().checkSkipLoginRedirection();
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

}
*/