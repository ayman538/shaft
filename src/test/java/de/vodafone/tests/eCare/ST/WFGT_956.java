package de.vodafone.tests.eCare.ST;

import de.vodafone.pages.eCare.Dashboard;
import de.vodafone.pages.eCare.MeinDaten;
import de.vodafone.pages.eCare.ServicePIN;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class WFGT_956 extends ST_eCareSetup {
    @Test(description = "GC01 | WFGT-956 | GC01 | Device Management | PIN-Engine - Viewing the PIN for care | Unity Media user | verify (Kennworter & pins) smart object and accordion")
    @TmsLink("WFGT-1132")
    private void GC01(Method method){
        new Dashboard(driver).clickMeineDaten();
        new MeinDaten(driver)
                .validateKennwörterPINsSmartObject(testData.getTestData(method.getName() + ".KennwörterPINsSmartObjectTitle"),testData.getTestData(method.getName() + ".KennwörterPINsSmartObjetcDetails"))
                .validateKennwörterPINsAccordion(testData.getTestData(method.getName() + ".KennwörterPINsAccordionTitle"),testData.getTestData(method.getName() + ".KennwörterPINsAccordionDetails"))
                .clickKennwörterPINsSmartObject()
                .validateDeineServicePIN(testData.getTestData(method.getName() + ".DeineServicePINTitle"),testData.getTestData(method.getName() + ".DeineServicePINDetailsFirstPart"),testData.getTestData(method.getName() + ".DeineServicePINDetailsSecondPart"))
                .validatePINansehenBtn((testData.getTestData(method.getName() + ".PINansehen")));
    }

    @Test(description = "GC02 | WFGT-1133 | Sanity | Device Management | PIN-Engine - Viewing the PIN for care | Unity Media user | verify Service PIN page")
    @TmsLink("WFGT-1133")
    private void GC02(Method method){
        new Dashboard(driver).clickMeineKundendaten();
        new MeinDaten(driver)
                .clickKennwörterPINsSmartObject()
                .clickPINansehen();
        new ServicePIN(driver)
                .validateServicePinPageMainHeader((testData.getTestData(method.getName() + ".ServicePinPageHeader")))
                .validateServicePINAnsehenAccordion(testData.getTestData(method.getName() + ".PINAnsehenAccordionTitle"),testData.getTestData(method.getName() + ".PINAnsehenAccordionDetailsFirstPart"),testData.getTestData(method.getName() + ".PINAnsehenAccordionDetailsSecondPart"))
                .validateServicePinHeader((testData.getTestData(method.getName() + ".ServicePinHeader")))
                .validateServiceDetails(testData.getTestData(method.getName() + ".ServiceDetailsFirstPart"),testData.getTestData(method.getName() + ".ServiceDetailsSecondPart"))
                .validateansehenServicePinMessage((testData.getTestData(method.getName() + ".ansehenServicePinMessage")))
                .validateNeuePINanfordernButton((testData.getTestData(method.getName() + ".NeuePINanfordernButton")));
    }

    @Test(description = "GC03 | WFGT-1134 | Device Management | PIN-Engine - Viewing the PIN for care | Unity Media user with inactive Pin (exceed 3 trials) | verify the (Kennworter & pins) accordion")
    @TmsLink("WFGT-1134")
    private void GC03(Method method){
        new Dashboard(driver).clickMeineKundendaten();
        new MeinDaten(driver)
                .clickKennwörterPINsSmartObject()
                .validateErrorExceeds3Trials(testData.getTestData(method.getName() + ".ErrorTitleExceeds3Trials"),testData.getTestData(method.getName() + ".ErrorDetailsExceeds3Trials"));
    }

    @Test(description = "GC04 | WFGT-1135 | Device Management | PIN-Engine - Viewing the PIN for care | Unity Media user with no Pin | verify the (Kennworter & pins) accordion")
    @TmsLink("WFGT-1135")
    private void GC04(Method method){
        new Dashboard(driver).clickMeineKundendaten();
        new MeinDaten(driver)
                .clickKennwörterPINsSmartObject()
                .validateErrorNopin(testData.getTestData(method.getName() + ".ErrorTitleNopin"),testData.getTestData(method.getName() + ".ErrorDetailsNopin"));
    }

    @Test(description = "GC05 | Device Management | PIN-Engine - Viewing the PIN for care | Unity Media user with pin status active (but exceeded no. of viewing pin) | Deeplink to view pin page")
    @TmsLink("WFGT-1136")
    private void GC05(Method method){
        new MeinDaten(driver)
                        .deepLinkToServicePin()
                        .errorTitleExceeds3TrialsDeepLinkDeepLink(testData.getTestData(method.getName() + ".ErrorHeader3TrialsDeepLink"),testData.getTestData(method.getName() + ".ErrorBody3TrialsDeepLink"));
    }

    @Test(description = "GC09 | WFGT-956 | Device Management | PIN-Engine - Viewing the PIN for care | Unity Media user with inActive Pin (exceeded no. of viewing pin)| verify the (Kennworter & pins) accordion")
    @TmsLink("WFGT-1140")
    private void GC09(Method method){
        new Dashboard(driver).clickMeineKundendaten();
        new MeinDaten(driver)
                .clickKennwörterPINsSmartObject()
                .validateErrorExceeds3Trials(testData.getTestData(method.getName() + ".ErrorTitleExceeds3Trials"),testData.getTestData(method.getName() + ".ErrorDetailsExceeds3Trials"));
    }

    @Test(description = "BC01 | WFGT-1161 | Device Management | PIN-Engine - Viewing the PIN for care | Unity Media user | Pin Status service returns response 500")
    @TmsLink("WFGT-1161")
    private void BC01(Method method){
        new Dashboard(driver).clickMeineDaten();
        new MeinDaten(driver)
                .clickKennwörterPINsSmartObject()
                .errorMessageTitle403(testData.getTestData(method.getName() + ".ErrorHeader"),testData.getTestData(method.getName() + ".ErrorBody"));
    }

    @Test(description = "BC02 | WFGT-1162 | Device Management | PIN-Engine - Viewing the PIN for care | Unity Media user | Pin Get service returns response 500")
    @TmsLink("WFGT-1162")
    private void BC02(Method method){
        new Dashboard(driver).clickMeineDaten();
        new MeinDaten(driver)
                .clickKennwörterPINsSmartObject()
                .clickPINansehen();
        new ServicePIN(driver).errorMessageTitle403(testData.getTestData(method.getName() + ".ErrorHeader"),testData.getTestData(method.getName() + ".ErrorBody"));
    }

    @Test(description = "BC01 | WFGT-1161 | Device Management | PIN-Engine - Viewing the PIN for care | Unity Media user | Pin Status service returns response 500")
    @TmsLink("WFGT-1161")
    private void BC03(Method method){
        new Dashboard(driver).clickMeineKundendaten();
        new MeinDaten(driver)
                .clickKennwörterPINsSmartObject()
                .errorMessageTitle403(testData.getTestData(method.getName() + ".ErrorHeader"),testData.getTestData(method.getName() + ".ErrorBody"));

    }

    @Test(description = "BC02 | WFGT-1162 | Device Management | PIN-Engine - Viewing the PIN for care | Unity Media user | Pin Get service returns response 500")
    @TmsLink("WFGT-1162")
    private void BC04(Method method){
        new Dashboard(driver).clickMeineKundendaten();
        new MeinDaten(driver)
                .clickKennwörterPINsSmartObject()
                .clickPINansehen();
        new ServicePIN(driver).errorMessageTitle403(testData.getTestData(method.getName() + ".ErrorHeader"),testData.getTestData(method.getName() + ".ErrorBody"));
    }


}


