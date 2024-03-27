package de.vodafone.tests.MobileCom.Tags_ST;

import com.shaft.driver.SHAFT;
import de.vodafone.pages.Payment.Dashboard;
import de.vodafone.pages.Payment.PontisOffersViewPage;
import de.vodafone.pages.commons.Tags;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("MobileCom")
@Feature("ST")
@Story("WFCT-14003")

public class WFCT_14003 extends ST_TagsSetup{
    Tags tags;
    Dashboard dashboard;
    PontisOffersViewPage pontisOffersViewPage;
    String siteStructureAfterConfirm;
    String siteStructureBeforeConfirm;

    @BeforeMethod
    public void beforeMethod(Method method) {
        SHAFT.Properties.flags.set().disableCache(true);
        dashboard = new Dashboard(driver);
        tags = new Tags(driver);
        pontisOffersViewPage = new PontisOffersViewPage(driver);
        siteStructureBeforeConfirm =testData.getTestData(method.getName()+".siteStructureBeforeConfirm");
        siteStructureAfterConfirm =testData.getTestData(method.getName()+".siteStructureAfterConfirm");
    }
    @Test(description = "Tag01 - Robert user checks tags for the pontis offer")
    @TmsLink("WFCT-15077")
    public void GC02_RobertUserChecksTagsForPontisOffer() {
        dashboard.clickOnOfferButton();
        tags.assertOnSiteStructure(siteStructureBeforeConfirm);
        pontisOffersViewPage
                .clickConfirmBtn();
        tags.assertOnSiteStructure(siteStructureAfterConfirm);
    }
}
