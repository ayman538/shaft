package de.vodafone.tests.Payment.ST;

import de.vodafone.pages.Payment.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Payment")
@Story("WFCT-12173")
@Feature("ST")
public class WFCT_12173 extends ST_PaymentSetup {
    Dashboard dashboard;
    DunningGPP dunningGPP;
    Dunning dunning;
    PaymentArrangementPage paymentArrangementPage;
    InstallmentPage installmentPage;
    RedirectDebitPage redirectDebitPage;

    String instalmentValue;
    String paAmountValue;
    String paAdditionalAmountValue;
    String paDateValue;
    String dlaAmount;

    @TmsLink("WFCT-9608")
    @Test(description = "WFCT-2232-GC01 Marie user eligible for PA has only 1 Value is displayed to user in Due amount section checks dunning accordion")
    public void GC01MarieUserEligibleForPAHasOnly1ValueIsDisplayedToIUserInDueAmountSectionChecksDunningAccordion() {
        dashboard.goToDunningTab();
        dunning.assertOnPaymentArrangementTitleCl();
        dunning.assertOnPaymentArrangementTextCl();
        dunning.assertOnPaBtnCl();
        dunning.clickPaymentArrangementButton();
        paymentArrangementPage.assertThatPaymentArrangementPageIsLoaded();
    }

    @TmsLink("WFCT-9631")
    @Test(description = "WFCT-2232-GC06- Bart user submits Payment Arrangment Transaction successfully")
    public void GC02BartUserSubmitsPaymentArrangementTransactionSuccessfully() {
        dashboard.goToDunningTab();
        dunning.clickPaymentArrangementButton();
        paymentArrangementPage.assertOnPaInformativeText();
        paymentArrangementPage.selectPaymentDate();
        paymentArrangementPage.clickOnPaymentArrangementContinueButton();
        paymentArrangementPage.assertOnPAAmountTitle();
        paymentArrangementPage.assertOnPAAmountValue(paAmountValue);
        paymentArrangementPage.assertOnPAAdditionalAmountTitle();
        paymentArrangementPage.assertOnPAAdditionalAmountValue(paAdditionalAmountValue);
        paymentArrangementPage.assertOnPADateTitle();
        paymentArrangementPage.assertOnPADateValue(paDateValue);
        paymentArrangementPage.clickOnPaymentArrangementSubmitButton();
        paymentArrangementPage.assertOnPaymentArrangementSuccessNotificationTitle();
        paymentArrangementPage.assertOnPaymentArrangementSuccessNotificationText();
        paymentArrangementPage.assertThatPaConfirmationAccIsClosedByDefault();
    }

    @TmsLink("WFCT-9629")
    @Test(description = "WFCT-2232-GC04- Bart user not eligible for PA checks the dunning accordion")
    public void GC03BartUserNotEligibleForPAChecksTheDunningAccordion() {
        dashboard.goToDunningTab();
        dunning.assertThatPaymentArrangementSectionIsNotExist();
    }

    @TmsLink("WFCT-9612")
    @Test(description = "WFCT-2537 | GC01- Marie Dunning user has credit checks the amount in the Dunning tile and accordion")
    public void GC04MarieDunningUserHasCreditChecksTheAmountInTheDunningTileAndAccordion() {
        dashboard.assertThatDunningTileDoesNotExist();
        dashboard.goToDunningTab();
        dunning.assertOnCreditAmountNotificationCl();
    }

    @TmsLink("WFCT-9613")
    @Test(description = "WFCT-2537 | GC02- Kay user has DLA equals to AR Balance (Both>0) and his next dunning status is HL checks the dunning tile and the amount section in dunning accordion")
    public void GC05KayUserDLAEqualsARBalanceBothLargerThanZeroAndHisNextDunningStatusIsHLChecksTheDunningTileAndTheAmountSectionInDunningAccordion() {
        dashboard.assertThatDunningRedFlagExists();
        dashboard.goToDunningTab();
        dunning.assertOnDlaAmountSectionCl();
        dunning.assertThatArBalanceRadiobuttonDoesNotExists();
    }


    @TmsLink("WFCT-9617")
    @Test(description = "WFCT-2537 | GC06- Marie user has DLA not equals to AR Balance (Both>0) and his next dunning status is TD checks the dunning tile and the amount section in dunning accordion")
    public void GC06MarieUserHasDLANotEqualsToARBalanceBothLargerThanZeroAndHisNextDunningStatusIsTDChecksTheDunningTileAndTheAmountSectionInDunningAccordion() {
        dashboard.assertThatDunningRedFlagExists();
        dashboard.goToDunningTab();
        dunning.assertOnDlaAmountSectionCl();
        dunning.assertOnArBalanceAmountSectionClWhenDlaLargerThanZero();
    }


    @TmsLink("WFCT-9619")
    @Test(description = "WFCT-2537 | GC08- Kay user has DLA equals to 0 and AR >0 checks the dunning tile and the amount section in dunning accordion")
    public void GC07KayUserHasDlaEqualZeroAndArLargerThanZeroChecksTheDunningTileAndTheAmountSectionInDunningAccordion() {
        dashboard.assertThatDunningRedFlagDoesNotExist();
        dashboard.goToDunningTab();
        dunning.assertOnArBalanceAmountSectionClWhenDlaEqualsZero();
        dunning.assertThatDunningAmountValueIsPresentedCorrectly(dlaAmount);
        dunning.assertThatDlaRadiobuttonDoesNotExists();
    }

    @TmsLink("WFCT-9620")
    @Test(description = "WFCT-2537 | GC09- Marie user has DLA equals to 0 and AR 0 checks the dunning tile and the amount section in dunning accordion")
    public void GC08MarieUserHasDlaAndArEqualZeroChecksTheDunningTileAndTheAmountSectionInDunningAccordion() {
        dashboard.assertThatDunningTileDoesNotExist();
        dashboard.goToDunningTab();
        dunning.assertOnNotificationWhenDlaAndArEqualZero();
        dunning.assertThatArBalanceRadiobuttonDoesNotExists();
        dunning.assertThatDlaRadiobuttonDoesNotExists();
    }

    @TmsLink("WFCT-9632")
    @Test(description = "WFCT-2229-GC01-Marie User checks Dunning Accordion when eligible to Renew Direct Debit")
    public void GC09MarieUserCheckDunningAccordionWhenEligibleToRenewDirectDebit() {
        dashboard.goToDunningTab();
        dunning.assertOnRedirectDebitTitleCl();
        dunning.assertOnRedirectDebitTextCl();
        dunning.assertThatRedirectDebitButtonExists();
    }

    @TmsLink("WFCT-9633")
    @Test(description = "WFCT-2229-GC02-Kay User checks Dunning Accordion when not eligible to Renew Direct Debit")
    public void GC10KayUserCheckDunningAccordionWhenNotEligibleToRenewDirectDebit() {
        dashboard.goToDunningTab();
        dunning.assertThatRedirectDebitSectionDoesNotExist();
        dunning.assertThatRedirectDebitButtonDoesNotExist();
    }

    @TmsLink("WFCT-9634")
    @Test(description = "WFCT-2229-GC03-Bart user submits Renew Direct Debit")
    public void GC11BartUserSubmitsRenewDirectDebit() {
        dashboard.goToDunningTab();
        dunning.clickRenewDirectDebitButton();
        redirectDebitPage.waitPageToBeLoaded();
        redirectDebitPage.assertOnRDDPreConfirmationInformativeText();
        redirectDebitPage.clickOnRenewDirectDebitSubmitButton();
        redirectDebitPage.assertThatRDDSuccessNotificationTitleIsCorrect();
        redirectDebitPage.assertThatRDDSuccessNotificationTextIsCorrect();
    }

    @TmsLink("WFCT-9637")
    @Test(description = "WFCT-2643-GC02- Kay user has more than 20 Payment Transactions check payment history section in dunning accordion")
    public void GC12KayUserHasMoreThan20PaymentTransactionCheckPaymentHistorySectionInDunningAccordion() {
        dashboard.goToDunningTab();
        dunning.assertThatPaymentHistoryTitleIsCorrect();
        dunning.assertThatPaymentHistoryTextIsCorrect();
        dunning.assertThatPaymentHistoryPaginationSettingsExists();
        dunning.assertThatDefaultViewForTheTableIs20Rows();
        dunning.assertThatPaymentHistoryTableShowsTheRightColumns();

    }

    @TmsLink("WFCT-9638")
    @Test(description = "WFCT-2643-GC03- Bart user has no Payment Transactions check payment history section in dunning accordion")
    public void GC13BartUserHasNoPaymentTransactionCheckPaymentHistorySectionInDunningAccordion() {
        dashboard.goToDunningTab();
        dunning.assertOnNoPaymentHistoryNotificationCl();
        dunning.assertThatPaymentHistoryTableDoesNotExist();
    }


    @TmsLink("WFCT-9670")
    @Test(description = "WFCT-2240 | GC03- Bart user checks notification section in Dunning accordion when B-02 is displayed")
    public void GC14BartUserChecksNotificationSectionInDunningAccordionWhenB02IsDisplayed() {
        dashboard.goToDunningTab();
        dunning.assertOnDunningNotificationTitleCaseB02();
        dunning.assertOnDunningNotificationDescriptionCaseB02();

    }

    @TmsLink("WFCT-9673")
    @Test(description = "WFCT-2240 | GC03- Kay user checks notification section in Dunning accordion when B-07 is displayed")
    public void GC15KayUserChecksNotificationSectionInDunningAccordionWhenB07IsDisplayed() {
        dashboard.goToDunningTab();
        dunning.assertOnDunningNotificationTitleCaseB07();
        dunning.assertOnDunningNotificationDescriptionCaseB07();

    }

    @TmsLink("WFCT-9688")
    @Test(description = "WFCT-2240 | GC15- Kay user checks notification section in Dunning accordion when B-14 is displayed")
    public void GC16BartUserChecksNotificationSectionInDunningAccordionWhenB14IsDisplayed() {
        dashboard.goToDunningTab();
        dunning.assertOnDunningNotificationTitleCaseB14();
        dunning.assertOnDunningNotificationDescriptionCaseB14();

    }

    @TmsLink("WFCT-9689")
    @Test(description = "WFCT-2240 | GC16- Kay user checks notification section in Dunning accordion when B-15 is displayed")
    public void GC17MarieUserChecksNotificationSectionInDunningAccordionWhenB15IsDisplayed() {
        dashboard.goToDunningTab();
        dunning.assertOnDunningNotificationTitleCaseB15();
        dunning.assertOnDunningNotificationDescriptionCaseB15();

    }

    @TmsLink("WFCT-9694")
    @Test(description = "WFCT-2240 | GC21- Kay user checks notification section in Dunning accordion when B-20 is displayed")
    public void GC18BartUserChecksNotificationSectionInDunningAccordionWhenB20IsDisplayed() {
        dashboard.goToDunningTab();
        dunning.assertOnDunningNotificationCaseB20();

    }

    @TmsLink("WFCT-9674")
    @Test(description = "WFCT-2244-GC02- Marie user who is not Eligible for Payment Installment Method checks dunning accordion")
    public void GC19MarieUserNotEligibleForPaymentInstallmentChecksDunningAccordion() {
        dashboard.goToDunningTab();
        dunning.assertThatInstallmentPaymentMethodDoesNotExist();

    }

    @TmsLink("WFCT-9675")
    @Test(description = "WFCT-2244-GC03- Bart user submits Payment Installment Transaction successfully")
    public void GC20BartUserSubmitsPaymentInstallmentTransactionSuccessfully() {
        dashboard.goToDunningTab();
        dunning.clickInstallmentButton();
        installmentPage.selectInstallmentValue(instalmentValue);
        installmentPage.assertWaitElementDoesNotExist();
        installmentPage.clickOnInstallmentContinueButton();
        installmentPage.assertOnInstallmentInformativeText();
        installmentPage.clickOnInstallmentSubmitButton();
        installmentPage.assertOnInstallmentSuccessNotificationTitleCl();
        installmentPage.assertOnInstallmentSuccessNotificationTextCl();


    }


    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        dunningGPP = new DunningGPP(driver);
        dunning = new Dunning(driver);
        paymentArrangementPage = new PaymentArrangementPage(driver);
        installmentPage = new InstallmentPage(driver);
        redirectDebitPage = new RedirectDebitPage(driver);
        instalmentValue = testData.getTestData(method.getName() + ".instalmentValue");
        paAmountValue = testData.getTestData(method.getName() + ".paAmountValue");
        paAdditionalAmountValue = testData.getTestData(method.getName() + ".paAdditionalAmountValue");
        paDateValue = testData.getTestData(method.getName() + ".paDateValue");
        dlaAmount = testData.getTestData(method.getName() + ".dlaAmount");


    }

}
