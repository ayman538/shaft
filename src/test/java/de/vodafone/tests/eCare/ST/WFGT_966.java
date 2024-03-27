package de.vodafone.tests.eCare.ST;

import de.vodafone.pages.eCare.*;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class WFGT_966 extends ST_eCareSetup {
    @Test(description = "GC01 | Device Management | PIN-Engine - Resetting the PIN for care | Unity Media user | verify Confirming PIN Reset page after clicking on Neue PIN anfordern button")
    @TmsLink("WFGT-1145")
    private void GC01(Method method) {
        new Dashboard(driver)
                .clickMeineKundendaten();
        new MeinDaten(driver)
                .validateBanNumberExist()
                .clickKennwörterPINsSmartObject()
                .clickPINansehen();
        new ServicePIN(driver)
                .validateBanNumberExist()
                .clickNeuePINanfordernButton();
        new NeueServicePIN(driver)
                .validateBanNumberExist()
                .validateNeueServicePinPageMainHeader(testData.getTestData(method.getName() + ".NeueServicePinPageHeader"))
                .validateDeineServicePINSection(testData.getTestData(method.getName() + ".NeueServicePinHeader"), testData.getTestData(method.getName() + ".NeueServiceDetailsHeader"), testData.getTestData(method.getName() + ".NeueServiceDetailsContent"), testData.getTestData(method.getName() + ".JetztBestätigenButton"));
    }
    @Test(description = "GC02| Sanity | Device Management | PIN-Engine - Resetting the PIN for care | Unity Media user | verify Success confirmation page after clicking on Jetzt bestätigen button")
    @TmsLink("WFGT-1146")
    private void GC02(Method method) {
        new Dashboard(driver)
                .clickMeineKundendaten();
        new MeinDaten(driver)
                .validateBanNumberExist()
                .clickKennwörterPINsSmartObject()
                .clickPINansehen();
        new ServicePIN(driver)
                .validateBanNumberExist()
                .clickNeuePINanfordernButton();
        new NeueServicePIN(driver)
                .validateBanNumberExist()
                .clickOnJetztBestätigenButton();
        new NeueServicePINConfirmation(driver).validateBanNumberExist()
                .validateConfirmationPageMainHeader(testData.getTestData(method.getName() + ".ConfirmationPageHeader"))
                .validateBackLink(testData.getTestData(method.getName() + ".backLink"))
                .validateSuccessNotificationBox(testData.getTestData(method.getName() + ".ConfirmationNotificationHeader"), testData.getTestData(method.getName() + ".ConfirmationNotificationContent"))
                .validateÜbersichtAccordion(testData.getTestData(method.getName() + ".ÜbersichtHeader"), testData.getTestData(method.getName() + ".ÜbersichtHeadline"), testData.getTestData(method.getName() + ".ÜbersichtSubHeadline"));
    }
    @Test(description = "GC03 | Device Management | PIN-Engine - Resetting the PIN for care | Unity Media user | verify failure confirmation page after clicking on Jetzt bestätigen button")
    @TmsLink("WFGT-1147")
    private void GC03(Method method) {
        new Dashboard(driver)
                .clickMeineKundendaten();
        new MeinDaten(driver)
                .validateBanNumberExist()
                .clickKennwörterPINsSmartObject()
                .clickPINansehen();
        new ServicePIN(driver)
                .validateBanNumberExist()
                .clickNeuePINanfordernButton();
        new NeueServicePIN(driver)
                .validateBanNumberExist()
                .clickOnJetztBestätigenButton();
        new NeueServicePINFailure(driver)
                .validateBanNumberExist()
                .validateBackLink(testData.getTestData(method.getName() + ".backLink")).validateFailurePageMainHeader(testData.getTestData(method.getName() + ".FailurePageHeader"))
                .validateFailureNotificationBox(testData.getTestData(method.getName() + ".FailureNotificationHeader"), testData.getTestData(method.getName() + ".FailureNotificationContent"));
    }

    @Test(description = "GC04 | Device Management | PIN-Engine - Resetting the PIN for care | Unity Media user with inActive Pin (ecxeeded no. of resetting pin)| verify the (Kennworter & pins) accordion")
    @TmsLink("WFGT-1148")
    private void GC04(Method method){
        new Dashboard(driver)
                .clickMeineKundendaten();
        new MeinDaten(driver)
                .validateBanNumberExist()
                .clickKennwörterPINsSmartObject()
                .validateErrorExceeds3Trials(testData.getTestData(method.getName() + ".ErrorTitleExceeds3Trials"),testData.getTestData(method.getName() + ".ErrorDetailsExceeds3Trials"));
    }

    @Test(description = "GC11 | Device Management | PIN-Engine - Resetting the PIN for care |KD user with active pin (ecxeeded no. of reseting pin) | Deeplink to Reset PIN page after exceeding no. of resetting(once per day)")
    @TmsLink("WFGT-1155")
    private void GC11(Method method) {
        new NeueServicePIN(driver)
                .deepLinkToResetPin()
                .validateBanNumberExist();
        new NeueServicePIN(driver)
                .validateNeueServicePinPageMainHeader(testData.getTestData(method.getName() + ".NeueServicePinPageHeader"))
                .validateBanNumberExist().errorTitleExceeds3TrialsDeepLinkDeepLink(testData.getTestData(method.getName() + ".ErrorHeader3TrialsDeepLink"),testData.getTestData(method.getName() + ".ErrorBody3TrialsDeepLink"));
    }

}
