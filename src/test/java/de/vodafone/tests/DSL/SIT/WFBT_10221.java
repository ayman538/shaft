package de.vodafone.tests.DSL.SIT;
import com.shaft.validation.Validations;
import de.vodafone.pages.DSL.DSL_BookingTransaction;
import de.vodafone.pages.DSL.DSL_ConfirmationPage;
import de.vodafone.pages.DSL.DSL_Dashboard;
import de.vodafone.pages.DSL.MyDSLProducts;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

@Epic("DSL")
public class WFBT_10221 extends SIT_DSLSetup {
    DSL_Dashboard dsl_dashboard;
    @Test(groups = {"WFBT-10454", "regression"})
    @Description("Check the new incompatibility booking message")
    private void GC01() {
        dsl_dashboard = new DSL_Dashboard(driver);
        dsl_dashboard.click(DSL_Dashboard.SecondSubscriberAccLocator);
        MyDSLProducts myDSLProducts = dsl_dashboard.chooseMyProductsFromMyProductsSecondAcc();
        myDSLProducts.clickViewMoreSOs().click(MyDSLProducts.BookableOptionsSO_Locator);
        DSL_BookingTransaction dsl_bookingTransaction = myDSLProducts.bookOptionWithConflict();
        DSL_ConfirmationPage dsl_confirmationPage = dsl_bookingTransaction.clickCTA(DSL_BookingTransaction.BookWithChargesCTA_Locator);
        dsl_confirmationPage.waitUntilErrorMsg();
        Validations.assertThat()
                .element(driver.getDriver(), DSL_ConfirmationPage.ConflictErrorMessageLocator)
                .text().equals(DSL_ConfirmationPage.ConflictErrorMessageCL);
    }

}
