package de.vodafone.tests.billing.Tags_ST;


import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.MeineRechnungen;
import de.vodafone.pages.billing.Verbindungsubersicht;
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
@Story("WFCT-11159")
public class WFCT_11159 extends ST_TagsSetup {
    Verbindungsubersicht verbindungsubersicht;
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Tags tags;
    String siteStructure;
    String clickName;
    String clickInfo;
    String downloadName;
    String downloadType;
    String firstInformation;
    String secondInformation;
    @BeforeMethod
    public void beforeMethod(Method method) {
        verbindungsubersicht = new Verbindungsubersicht(driver);
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        tags = new Tags(driver);
        siteStructure = testData.getTestData(method.getName()+".siteStructure");
        clickName = testData.getTestData(method.getName()+".clickName");
        clickInfo = testData.getTestData(method.getName()+".clickInfo");
        downloadName = testData.getTestData(method.getName()+".downloadName");
        downloadType = testData.getTestData(method.getName()+".downloadType");
        firstInformation = testData.getTestData(method.getName()+".firstInformation");
        secondInformation = testData.getTestData(method.getName()+".secondInformation");
    }

    @Test(description = "Tag01 - user checks the page view tags")
    @TmsLink("")
    public void Tag01_UserChecksThePageViewTags(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        tags.assertOnSiteStructure(siteStructure);
    }

    @Test(description = "Tag02 - user checks tags after PDF download")
    @TmsLink("")
    public void Tag02_UserChecksTagsAfterPdfDownload(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.downloadPDF();
        tags.assertOnClickTags(clickName , clickInfo);
        tags.assertOnDownloadTags(downloadName , downloadType);
    }
    @Test(description = "Tag03 - user checks tags after CSV download" , enabled = false)
    @TmsLink("")
    public void Tag03_UserChecksTagsAfterCsvDownload(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.downloadCSV();
        tags.assertOnClickTags(clickName , clickInfo);
        tags.assertOnDownloadTags(downloadName , downloadType);
    }
    @Test(description = "Tag04 - user checks tags after expanding FAQ accordions")
    @TmsLink("")
    public void Tag04_UserChecksTagsAfterExpandingFaqAccordions(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.expandFirstAccordion();
        tags.assertOnInformationTag(firstInformation);
        verbindungsubersicht.expandSecondAccordion();
        tags.assertOnInformationTag(secondInformation);
    }


}
