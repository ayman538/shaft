package de.vodafone.tests.unityMedia.Tags_ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.commons.Tags;
import de.vodafone.pages.unityMedia.Bankverbindung_bearbeiten;
import de.vodafone.pages.unityMedia.MeineDaten;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("UnityMedia")
@Feature("ST")
@Story("WFCT-13466")
public class WFCT_13466 extends ST_TagsSetup {
    Dashboard dashboard;
    MeineDaten meineDaten;
    Bankverbindung_bearbeiten bankDetails;
    String foreignIban;
    String wrongIban;
    String validIban;
    Tags tags;

    String siteStructureStep1Success;
    String siteStructureStep2Success;
    String siteStructureStep3Success;
    String siteStructureStep1Failure;
    String siteStructureStep2Failure;
    String siteStructureStep3Failure;
    String oFormObjectStep1Success;
    String oFormObjectStep2Success;
    String oFormObjectStep3Success;
    String oFormObjectStep1Failure;
    String oFormObjectStep2Failure;
    String oFormObjectStep3Failure;


    @BeforeMethod()
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        meineDaten = new MeineDaten(driver);
        bankDetails = new Bankverbindung_bearbeiten(driver);
        tags = new Tags(driver);
        foreignIban = testData.getTestData(method.getName() + ".foreignIban");
        wrongIban = testData.getTestData(method.getName() + ".wrongIban");
        validIban = testData.getTestData(method.getName() + ".validIban");
        //tags

        siteStructureStep1Success = testData.getTestData(method.getName() + ".siteStructureStep1Success");
        siteStructureStep2Success = testData.getTestData(method.getName() + ".siteStructureStep2Success");
        siteStructureStep3Success = testData.getTestData(method.getName() + ".siteStructureStep3Success");
        siteStructureStep1Failure = testData.getTestData(method.getName() + ".siteStructureStep1Failure");
        siteStructureStep2Failure = testData.getTestData(method.getName() + ".siteStructureStep2Failure");
        siteStructureStep3Failure = testData.getTestData(method.getName() + ".siteStructureStep3Failure");
        oFormObjectStep1Success = testData.getTestData(method.getName() + ".oFormObjectStep1Success");
        oFormObjectStep2Success = testData.getTestData(method.getName() + ".oFormObjectStep2Success");
        oFormObjectStep3Success = testData.getTestData(method.getName() + ".oFormObjectStep3Success");
        oFormObjectStep1Failure = testData.getTestData(method.getName() + ".oFormObjectStep1Failure");
        oFormObjectStep2Failure = testData.getTestData(method.getName() + ".oFormObjectStep2Failure");
        oFormObjectStep3Failure = testData.getTestData(method.getName() + ".oFormObjectStep3Failure");
    }


    @Test(description = "GC05- Check telium tags when Ute user successfully add his bank details")
    @Issue("WFCT-14122")
    @TmsLink("WFCT-7107")
    public void GC05_UteUserWithoutAnyBankDetailsSuccessfullyAddsHisBankDetailsCheckTags() {
        dashboard.clickOnMeineKundenDatenButton();
        meineDaten.clickOnBankAccountSO();
        meineDaten.clickAddBankDetailsButton();
        tags.assertOnoFormObject(oFormObjectStep1Success);
        tags.assertOnSiteStructure(siteStructureStep1Success);
        bankDetails.enterIBAN(validIban);
        bankDetails.clickOnEditBankDetailsFirstSubmitButton();
        tags.assertOnoFormObject(oFormObjectStep2Success);
        tags.assertOnSiteStructure(siteStructureStep2Success);
        bankDetails.clickOnBankDetailsInfoIcon();
        bankDetails.clickOnBankDetailsCheckBox();
        bankDetails.clickOnEditBankDetailsSecondSubmitButton();
        tags.assertOnoFormObject(oFormObjectStep3Success);
        tags.assertOnSiteStructure(siteStructureStep3Success);
    }

    @Test(description = "GC02- Ute user fails to add his bank details check tags ",enabled=false)
    @TmsLink("WFCT-7108")
    public void GC02_UteUserFailsToAddHisBankDetailsCheckTags() {

        meineDaten.clickOnBankAccountSO();
        meineDaten.clickAddBankDetailsButton();
        tags.assertOnoFormObject(oFormObjectStep1Failure);
        tags.assertOnSiteStructure(siteStructureStep1Failure);
        bankDetails.editIBAN(validIban);
        bankDetails.clickOnEditBankDetailsFirstSubmitButton();
        tags.assertOnoFormObject(oFormObjectStep2Failure);
        tags.assertOnSiteStructure(siteStructureStep2Failure);
        bankDetails.clickOnBankDetailsInfoIcon();
        bankDetails.clickOnBankDetailsCheckBox();
        bankDetails.clickOnEditBankDetailsSecondSubmitButton();
        tags.assertOnoFormObject(oFormObjectStep3Failure);
        tags.assertOnSiteStructure(siteStructureStep3Failure);


    }
}
