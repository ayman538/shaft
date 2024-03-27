package de.vodafone.tests.kableDeutschland.SIT;


import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Kabledeutschland.BankDetails;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("Billing")
@Feature("SIT")
@Story("WFCT-13781")

public class WFCT_13781 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    Dashboard dashboard;
    MeineDaten meineDaten;
    BankDetails bankDetails;
    String toolTipCl,iban,sepaMandateCL, errorTitle, errorBody,contractOrder;


    @BeforeMethod
    public void beforeMethod(Method method) {
        driver = new SHAFT.GUI.WebDriver();
        dashboard = new Dashboard(driver);
        meineDaten = new MeineDaten(driver);
        bankDetails = new BankDetails(driver);
        toolTipCl = testData.getTestData(method.getName()+".toolTipCl");
        iban = testData.getTestData(method.getName()+".iban");
        sepaMandateCL = testData.getTestData(method.getName()+".sepaMandateCL");
        errorTitle = testData.getTestData(method.getName()+".errorTitle");
        errorBody = testData.getTestData(method.getName()+".errorBody");
        contractOrder = testData.getTestData(method.getName()+".contractOrder");
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");

        new LoginPage(driver).navigateSIT()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginSIT(userName, userPassword);
    }

    @AfterMethod()
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {

        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "KableDeutschland/SIT_WFCT_13781_CookieSwitcher.json").getTestDataAsMap("$");


        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "KableDeutschland/SIT/WFCT_13781.json");
    }


    @Test(description = "GC08 - KD user enters valid IBAN but not the IBAN in the contract")
    @TmsLink("WFCT-14951")
    public void GC08_KdUserEntersValidIbanButNotTheIbanInTheContract() {
        dashboard.clickMeineDatenTile();
        meineDaten.ExpandBankDetailsAccordion();
        meineDaten.assertThatHyperlinkDoesNotExist();
        meineDaten.clickOnChangeBankDetailsButton();
        bankDetails.assertOnFirtStepCardNameAndTitle()
                .assertOnOwnerFieldTitleAndDimmed()
                .assertOnIbanFieldTitleAndExistance()
                .assertOnFirstStepSubmitTitle()
                .assertThatFirstStepSubmitIsDimmed();
        bankDetails.TypeIbanRegex(iban);
        bankDetails.SubmitFirstStepOfEditBank();
        bankDetails.assertOnSepaMandateCheckBoxCL(sepaMandateCL)
                .assertOnSepaMandateToolTip(toolTipCl)
                .checkSepaMandateCheckBox()
                .SubmitSecondStepOfEditBank();
        bankDetails.assertOnIbanDoesNotMatchContractedIban(errorTitle, errorBody);
    }

}
