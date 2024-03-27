package de.vodafone.tests.MobileCom.Tags_ST;

import de.vodafone.pages.MobileCom.Dashboard;
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
@Story("WFCT-14600")

public class WFCT_14600 extends ST_TagsSetup{
    Dashboard dashboard;
    Tags tags;
    String pageview;
    String ecareAccordion;


    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        tags = new Tags(driver);
        pageview =testData.getTestData(method.getName()+".pageview");
        ecareAccordion =testData.getTestData(method.getName()+".ecareAccordion");
    }


    @Test(description = "Tag01 - Robert checks ecare accordion and pageview tagging")
    @TmsLink("WFCT-15113")
    public void Tag01_RobertChecksEcareAccordionAndPageViewTagging() {
        tags.assertOnCompleteTag("pageview",pageview);
        tags.assertOnCompleteTag("ecare accordion",ecareAccordion);
    }

}
