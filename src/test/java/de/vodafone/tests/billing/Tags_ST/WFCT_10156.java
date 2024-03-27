package de.vodafone.tests.billing.Tags_ST;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Kostenubersicht;
import de.vodafone.pages.billing.MeineRechnungen;
import de.vodafone.pages.commons.Tags;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;



@Epic("Billing")
@Feature("SIT")
@Story("WFCT-10156")


public class WFCT_10156 extends ST_TagsSetup {
    Kostenubersicht kostenubersicht;
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Tags tags;
    String contractOrder;
    String siteStructure;
    String downloadName;


    @BeforeMethod
    public void beforeMethod(Method method) {
        kostenubersicht = new Kostenubersicht(driver);
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        tags = new Tags(driver);
        contractOrder =testData.getTestData(method.getName()+".contractOrder");
        siteStructure =testData.getTestData(method.getName()+".siteStructure_value");
        downloadName =testData.getTestData(method.getName()+".downloadName_value");


    }


    @Test(description = "Kay user with more than 12 numbers checks Kostenübersicht Tab in Meine Rechnungen page",enabled = false )
    @TmsLink("WFCT-10496")
    public void GC01_KayUserWithLessThan12NumbersChecksKostenübersichtTabInMeineRechnungenPage() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        tags.assertOnSiteStructure(siteStructure);
        kostenubersicht.clickOnDownloadSubscriberBillByOrder("1");
        tags.assertOnDownloadName(downloadName);
    }

}
