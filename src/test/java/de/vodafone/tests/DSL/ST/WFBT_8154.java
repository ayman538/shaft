package de.vodafone.tests.DSL.ST;

import de.vodafone.pages.DSL.DSL_Dashboard;
import de.vodafone.pages.DSL.MyDSLProducts;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("DSL")
@Feature("ST")
@Story("WFBT-8154")
public class WFBT_8154 extends ST_DSLSetup{

    @Test(description = "GC01 | Check New Basic SecureNet CL - Check Basic SecureNet more info CTA")
    @TmsLink("WFBT-10019")
    public void GC01() {
        new DSL_Dashboard(driver).chooseMyProductsFromMyProductsAcc();
        new MyDSLProducts(driver).clickSecureNetSO_expandSecureNetAcc();
        new MyDSLProducts(driver).basicSecureNetPlusValidations();
    }

    @Test(description = "GC02 | Check SecureNet Plus bookable view")
    @TmsLink("WFBT-10021")
    public void GC02() {
        new DSL_Dashboard(driver).chooseMyProductsFromMyProductsAcc();
        new MyDSLProducts(driver).clickSecureNetSO_expandSecureNetAcc();
        new MyDSLProducts(driver).bookableSecureNetPlusValidations();
    }

    @Test(description = "GC03 | Check SecureNet Plus cancelling view")
    @TmsLink("WFBT-10022")
    public void GC03() {
        new DSL_Dashboard(driver).chooseMyProductsFromMyProductsAcc();
        new MyDSLProducts(driver).clickSecureNetSO_expandSecureNetAcc();
        new MyDSLProducts(driver).bookedSecureNetPlusValidations();
    }

    @Test(description = "GC04 | Check the removal of basic Secure net and SecureNet Plus - Check the hint message of ineligibility")
    @TmsLink("WFBT-10023")
    public void GC04() {
        new DSL_Dashboard(driver).chooseMyProductsFromMyProductsAcc();
        new MyDSLProducts(driver).clickSecureNetSO_expandSecureNetAcc();
        new MyDSLProducts(driver).secureNetConflictMsgValidations();
    }
        @Test(description = "GC05 | user with a booked security Package | Check Security Package Accordion")
        @TmsLink("WFBT-10024")
        public void GC05 () {
            new DSL_Dashboard(driver).chooseMyProductsFromMyProductsAcc();
            new MyDSLProducts(driver).clickSecureNetSO_expandSecureNetAcc();
            new MyDSLProducts(driver).checkExistanceOfSecurityAcc();
        }

        @Test(description = "GC06 | Check the Inexistence of Security Package Accordion")
        @TmsLink("WFBT-10025")
        public void GC06 () {
            new DSL_Dashboard(driver).chooseMyProductsFromMyProductsAcc();
            new MyDSLProducts(driver).clickSecureNetSO_expandSecureNetAcc();
            new MyDSLProducts(driver).checkInexistanceOfSecurityAcc();
        }
    }