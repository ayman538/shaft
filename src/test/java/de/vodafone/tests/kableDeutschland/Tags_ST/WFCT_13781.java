package de.vodafone.tests.kableDeutschland.Tags_ST;


import de.vodafone.pages.Kabledeutschland.BankDetails;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.commons.Tags;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFCT-13781")

public class WFCT_13781 extends ST_TagsSetup {
    Dashboard dashboard;
    MeineDaten meineDaten;
    BankDetails bankDetails;
    Tags tags;
    String start, iban, pageview, firstStepSiteStructure,oForm,review,secondStepSiteStructure,endSuccess,
            thirdStepSiteStructure,errorTagContent,error,endFailure;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        meineDaten = new MeineDaten(driver);
        bankDetails = new BankDetails(driver);
        tags = new Tags(driver);
        start = testData.getTestData((method.getName()+".start"));
        iban = testData.getTestData(method.getName()+".iban");
        pageview = testData.getTestData((method.getName()+".pageview"));
        firstStepSiteStructure = testData.getTestData((method.getName()+".siteStructure1"));
        oForm =  testData.getTestData((method.getName()+".oForm"));
        review = testData.getTestData((method.getName()+".review"));
        secondStepSiteStructure = testData.getTestData((method.getName()+".siteStructure2"));
        endSuccess = testData.getTestData((method.getName()+".endSuccess"));
        thirdStepSiteStructure = testData.getTestData((method.getName()+".siteStructure3"));
        errorTagContent = testData.getTestData((method.getName()+".errorTagContent"));
        error = testData.getTestData((method.getName()+".error"));
        endFailure = testData.getTestData((method.getName()+".endFailure"));
    }

    @Test(description = "Tag01 - KD user checks start and end tagging for successfully changed bank details" )
    @TmsLink("WFCT-14947")
    public void Tag01_KdCserChecksStartAndEndTaggingForSuccessfullyChangedBankDetails() {
        dashboard.clickMeineDatenTile();
        meineDaten.ExpandBankDetailsAccordion();
        meineDaten.clickOnChangeBankDetailsButton();
        tags.assertOnCompleteTag(pageview,oForm,start);
        tags.assertOnSiteStructure(firstStepSiteStructure);
        bankDetails.TypeIbanRegex(iban);
        bankDetails.SubmitFirstStepOfEditBank();
        tags.assertOnCompleteTag(pageview,oForm,review);
        tags.assertOnSiteStructure(secondStepSiteStructure);
        bankDetails.checkSepaMandateCheckBox()
                .SubmitSecondStepOfEditBank();
        tags.assertOnCompleteTag(pageview,oForm,endSuccess);
        tags.assertOnSiteStructure(thirdStepSiteStructure);

    }

    @Test(description = "Tag02 - KD user checks BE failures tracking at change bank details page" )
    @TmsLink("WFCT-14948")
    public void Tag02_KdUserChecksBeFailuresTrackingAtChangeBankDetailsPage() {
        dashboard.clickMeineDatenTile();
        meineDaten.ExpandBankDetailsAccordion();
        meineDaten.clickOnChangeBankDetailsButton();
        bankDetails.TypeIbanRegex(iban);
        bankDetails.SubmitFirstStepOfEditBank();
        tags.assertOnCompleteTag(error,errorTagContent);
    }

    @Test(description = "Tag03 - KD user with one referenzKonto failed to change bank details at confirmation step checks tagging" )
    @TmsLink("WFCT-14949")
    public void Tag03_KdUserWithOneReferenzKontoFailedToChangeBankDetailsAtConfirmationStepChecksTagging() {
        dashboard.clickMeineDatenTile();
        meineDaten.ExpandBankDetailsAccordion();
        meineDaten.clickOnChangeBankDetailsButton();
        tags.assertOnCompleteTag(pageview,oForm,start);
        tags.assertOnSiteStructure(firstStepSiteStructure);
        bankDetails.TypeIbanRegex(iban);
        bankDetails.SubmitFirstStepOfEditBank();
        tags.assertOnCompleteTag(pageview,oForm,review);
        tags.assertOnSiteStructure(secondStepSiteStructure);
        bankDetails.checkSepaMandateCheckBox()
                .SubmitSecondStepOfEditBank();
        tags.assertOnCompleteTag(pageview,oForm,endFailure);
        tags.assertOnSiteStructure(thirdStepSiteStructure);
    }

    @Test(description = "Tag04 - KD check tracking at Partially successful update bank account" )
    @TmsLink("WFCT-15015")
    public void Tag04_KdCheckTrackingAtPartiallySuccessfulUpdateBankAccount() {
        dashboard.clickMeineDatenTile();
        meineDaten.ExpandBankDetailsAccordion();
        meineDaten.clickOnChangeBankDetailsButton();
        tags.assertOnCompleteTag(pageview,oForm,start);
        tags.assertOnSiteStructure(firstStepSiteStructure);
        bankDetails.TypeIbanRegex(iban);
        bankDetails.SubmitFirstStepOfEditBank();
        tags.assertOnCompleteTag(pageview,oForm,review);
        tags.assertOnSiteStructure(secondStepSiteStructure);
        bankDetails.checkSepaMandateCheckBox()
                .SubmitSecondStepOfEditBank();
        tags.assertOnCompleteTag(pageview,oForm,endSuccess);
        tags.assertOnSiteStructure(thirdStepSiteStructure);
        tags.assertOnCompleteTag(error,errorTagContent);
    }

    @Test(description = "Tag05 - KD checks tracking for valid IBAN but not the IBAN in the contract" )
    @TmsLink("WFCT-15016")
    public void Tag05_KdChecksTrackingForValidIbanButNotTheIbanInTheContract() {
        dashboard.clickMeineDatenTile();
        meineDaten.ExpandBankDetailsAccordion();
        meineDaten.clickOnChangeBankDetailsButton();
        tags.assertOnCompleteTag(pageview,oForm,start);
        tags.assertOnSiteStructure(firstStepSiteStructure);
        bankDetails.TypeIbanRegex(iban);
        bankDetails.SubmitFirstStepOfEditBank();
        tags.assertOnCompleteTag(pageview,oForm,review);
        tags.assertOnSiteStructure(secondStepSiteStructure);
        bankDetails.checkSepaMandateCheckBox()
                .SubmitSecondStepOfEditBank();
        tags.assertOnCompleteTag(pageview,oForm,endFailure);
        tags.assertOnSiteStructure(thirdStepSiteStructure);
        tags.assertOnCompleteTag(error,errorTagContent);
    }

}
