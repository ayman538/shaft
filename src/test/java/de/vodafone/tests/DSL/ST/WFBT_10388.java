package de.vodafone.tests.DSL.ST;

import de.vodafone.pages.DSL.*;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("DSL")
@Feature("ST")
@Story("WFBT-10388")
public class WFBT_10388 extends ST_DSLSetup{
    @TmsLink("WFBT-10491")
    @Test(description = "GC01 || Check review conflict page")
    public void validateReviewConflictPage() {
        new DSL_Dashboard(driver).chooseMyProductsFromMyProductsAcc();
        new MyDSLProducts(driver).clickOnBookableOptionsAcc().clickOnBookEuroFlat();
        new DSL_BookingTransaction(driver).bookEuroFlatNow();
        new ReviewConflictPage(driver).validateMainPageElement()
                .validateWarningMessage().validateNewOption().validateReplacedOption().validatePolicyTerms();
    }
}