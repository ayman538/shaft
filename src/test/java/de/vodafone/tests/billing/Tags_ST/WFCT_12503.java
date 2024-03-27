package de.vodafone.tests.billing.Tags_ST;

import de.vodafone.pages.billing.*;
import de.vodafone.pages.commons.Tags;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


@Epic("Billing")
@Feature("ST")
@Story("WFCT-12503")


public class WFCT_12503 extends ST_TagsSetup {
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    MeineDaten meineDaten;
    Einstellungen einstellungen;
    Tags tags;
    String tagName, oForm, siteStructure , oFormName,oFormStatus,oFormStepName,oFormStep,oFormType,oFormOutcome,pageType,platformType,siteArea,loginStatus,visitorSubscription,visitorType,oFormValue;


    @BeforeMethod
    public void beforeMethod(Method method) {
        meineDaten = new MeineDaten(driver);
        dashboard = new Dashboard(driver);
        einstellungen = new Einstellungen(driver);
        meineRechnungen = new MeineRechnungen(driver);
        tags = new Tags(driver);
        siteStructure =testData.getTestData(method.getName()+".siteStructure");
        oFormName =testData.getTestData(method.getName()+".oFormName");
        oFormStatus =testData.getTestData(method.getName()+".oFormStatus");
        oFormStepName =testData.getTestData(method.getName()+".oFormStepName");
        oFormStep =testData.getTestData(method.getName()+".oFormStep");
        oFormType =testData.getTestData(method.getName()+".oFormType");
        oFormOutcome=testData.getTestData(method.getName()+".oFormOutcome");
        pageType = testData.getTestData(method.getName()+".pageType");
        platformType = testData.getTestData(method.getName()+".platformType");
        siteArea = testData.getTestData(method.getName()+".siteArea");
        loginStatus = testData.getTestData(method.getName()+".loginStatus");
        visitorSubscription = testData.getTestData(method.getName()+".visitorSubscription");
        visitorType = testData.getTestData(method.getName()+".visitorType");
        oFormValue = testData.getTestData(method.getName()+".oFormValue");
        tagName = testData.getTestData(method.getName()+".tagName");
        oForm = testData.getTestData(method.getName()+".oForm");
    }


    @Test(description = "TG01 - Marie user checks 'page view' tag before confirming changing the bill type from paper to online.")
    @TmsLink("WFCT-14786")
    public void Tg01_MarieUserChecksPageViewbeforeChangingFromPaperToOnline() {
        dashboard.clickMeineDatenTile();
        meineDaten.clickOnKontaktDatenAccordion();
        meineDaten.clickOnrechnungseinstellungenLink();
        einstellungen.clickOnOnlineBillRadioBtn();
        tags.assertOnSiteStructure(siteStructure);
        tags.assertOnCompleteTag(tagName,oForm,oFormValue);
        tags.assertOnVisitorSubscription(visitorSubscription);
        tags.assertOnLoginStatus(loginStatus);
        tags.assertOnSiteArea(siteArea);
        tags.assertOnPageType(pageType);
        tags.assertOnPlatformType(platformType);
    }
    @Test(description = "TG02 - Kay user checks 'page view' tag after confirming changing bill type from paper and online to online.")
    @TmsLink("WFCT-14787")
    public void Tg02_MarieUserChecksPageViewAfterChangingFromPaperToOnline() {
        dashboard.clickMeineDatenTile();
        meineDaten.clickOnKontaktDatenAccordion();
        meineDaten.clickOnrechnungseinstellungenLink();
        einstellungen.clickOnOnlineBillRadioBtn();
        einstellungen.clickOnSaveChangesBtn();
        tags.assertOnSiteStructure(siteStructure);
        tags.assertOnCompleteTag(tagName,oForm,oFormValue);
        tags.assertOnVisitorSubscription(visitorSubscription);
        tags.assertOnLoginStatus(loginStatus);
        tags.assertOnSiteArea(siteArea);
        tags.assertOnPageType(pageType);
        tags.assertOnPlatformType(platformType);
    }
    @Test(description = "TG03 - Marie user checks 'page view' tag after unsuccessful changing bill type from paper to online.")
    @TmsLink("WFCT-14788")
    public void Tg03_MarieUserChecksPageViewAfterUnsuccessfulChangingFromPaperToOnline() {
        dashboard.clickMeineDatenTile();
        meineDaten.clickOnKontaktDatenAccordion();
        meineDaten.clickOnrechnungseinstellungenLink();
        einstellungen.clickOnOnlineBillRadioBtn();
        einstellungen.clickOnSaveChangesBtn();
        tags.assertOnSiteStructure(siteStructure);
        tags.assertOnCompleteTag(tagName,oForm,oFormValue);

    }

}
