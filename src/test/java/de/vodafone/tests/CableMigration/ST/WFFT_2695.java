package de.vodafone.tests.CableMigration.ST;

import de.vodafone.pages.CableMigration.KostenkontrollePage;
import de.vodafone.pages.CableMigration.MeinVodafoneDashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Cable Migration")
@Feature("ST")
@Story("Billing | Cable Migration - KD Unbilled Usage - Telefon")
public class WFFT_2695 extends CableMigrationSTSetup{
    @Test(description ="GC01-Verify the 1st entry point for Telephone usage While user has single number & single category & full itemized bill." )
    @TmsLink("WFFT-2956")
    private void GC01(Method method){
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();
        new KostenkontrollePage(driver).ClickOnKostenkontrolleTab();
        new KostenkontrollePage(driver).ClickOnTelefonButton();
        new KostenkontrollePage(driver).validateKostenkontrolleTabDetails(testData.getTestData(method.getName() + ".tabHeader"),
                testData.getTestData(method.getName() + ".tabSubHeader"));
        new KostenkontrollePage(driver).selectTelefonTail();
        new KostenkontrollePage(driver).validateTelefonTailDetails(testData.getTestData(method.getName() + ".tailHeader"),
                testData.getTestData(method.getName() + ".tailSubHeader"));
        new KostenkontrollePage(driver).validateTelefonNumberDetails(testData.getTestData(method.getName() + ".numberHeader"),
                testData.getTestData(method.getName() + ".numberSubHeader"));
        new KostenkontrollePage(driver).selectFirstCategory();
    }

    @Test(description ="GC02- Verify the 2nd entry point for Telephon usage While user has single number & multiple categories & short itemized bill." )
    @TmsLink("WFFT-2957")
    private void GC02(Method method){
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();
        new KostenkontrollePage(driver).ClickOnKostenkontrolleTab();
        new KostenkontrollePage(driver).ClickOnTelefonButton();
        new KostenkontrollePage(driver).validateKostenkontrolleTabDetails(testData.getTestData(method.getName() + ".tabHeader"),
                testData.getTestData(method.getName() + ".tabSubHeader"));
        new KostenkontrollePage(driver).selectTelefonTail();
        new KostenkontrollePage(driver).validateTelefonTailDetails(testData.getTestData(method.getName() + ".tailHeader"),
                testData.getTestData(method.getName() + ".tailSubHeader"));
        new KostenkontrollePage(driver).validateTelefonNumberDetails(testData.getTestData(method.getName() + ".numberHeader"),
                testData.getTestData(method.getName() + ".numberSubHeader"));
        new KostenkontrollePage(driver).selectFirstCategory();

    }

    @Test(description ="GC03- Verify the 1st entry point for Telephon usage While user has multiple numbers & single category & short itemized bills." )
    @TmsLink("WFFT-2958")
    private void GC03(Method method){
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();
        new KostenkontrollePage(driver).ClickOnKostenkontrolleTab();
        new KostenkontrollePage(driver).ClickOnTelefonButton();
        new KostenkontrollePage(driver).validateKostenkontrolleTabDetails(testData.getTestData(method.getName() + ".tabHeader"),
                testData.getTestData(method.getName() + ".tabSubHeader"));
        new KostenkontrollePage(driver).selectTelefonTail();
        new KostenkontrollePage(driver).validateTelefonTailDetails(testData.getTestData(method.getName() + ".tailHeader"),
                testData.getTestData(method.getName() + ".tailSubHeader"));
        new KostenkontrollePage(driver).validateTelefonNumberDetails(testData.getTestData(method.getName() + ".numberHeader"),
                testData.getTestData(method.getName() + ".numberSubHeader"));
        new KostenkontrollePage(driver).selectFirstCategory();
        new KostenkontrollePage(driver).selectSecondNumber();
        new KostenkontrollePage(driver).selectFirstCategory();

    }

    @Test(description ="GC04- Verify the 2nd entry point for Telephone usage While user has multiple numbers & multiple categories & full itemized bills." )
    @TmsLink("WFFT-2959")
    private void GC04(Method method){
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();
        new KostenkontrollePage(driver).ClickOnKostenkontrolleTab();
        new KostenkontrollePage(driver).ClickOnTelefonButton();
        new KostenkontrollePage(driver).validateKostenkontrolleTabDetails(testData.getTestData(method.getName() + ".tabHeader"),
                testData.getTestData(method.getName() + ".tabSubHeader"));
        new KostenkontrollePage(driver).selectTelefonTail();
        new KostenkontrollePage(driver).validateTelefonTailDetails(testData.getTestData(method.getName() + ".tailHeader"),
                testData.getTestData(method.getName() + ".tailSubHeader"));
        new KostenkontrollePage(driver).validateTelefonNumberDetails(testData.getTestData(method.getName() + ".numberHeader"),
                testData.getTestData(method.getName() + ".numberSubHeader"));

    }

    @Test(description ="GC05- Vrify the 1st entry point for Telephone usage While user has multiple numbers & no telephone calls." )
    @TmsLink("WFFT-2960")
    private void GC05(Method method){
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();
        new KostenkontrollePage(driver).ClickOnKostenkontrolleTab();
        new KostenkontrollePage(driver).ClickOnTelefonButton();
        new KostenkontrollePage(driver).validateKostenkontrolleTabDetails(testData.getTestData(method.getName() + ".tabHeader"),
                testData.getTestData(method.getName() + ".tabSubHeader"));
        new KostenkontrollePage(driver).selectTelefonTail();
        new KostenkontrollePage(driver).validateTelefonTailDetails(testData.getTestData(method.getName() + ".tailHeader"),
                testData.getTestData(method.getName() + ".tailSubHeader"));
        new KostenkontrollePage(driver).validateTelefonNoCallsCaseDetails(testData.getTestData(method.getName() + ".noCallsHeader"),
                testData.getTestData(method.getName() + ".noCallsSubHeader"));
    }

    @Test(description ="GC06- Verify the 2nd entry point for Telephone usage While user has One number & no telephone calls." )
    @TmsLink("WFFT-2961")
    private void GC06(Method method){
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();
        new KostenkontrollePage(driver).ClickOnKostenkontrolleTab();
        new KostenkontrollePage(driver).ClickOnTelefonButton();
        new KostenkontrollePage(driver).validateKostenkontrolleTabDetails(testData.getTestData(method.getName() + ".tabHeader"),
                testData.getTestData(method.getName() + ".tabSubHeader"));
        new KostenkontrollePage(driver).selectTelefonTail();
        new KostenkontrollePage(driver).validateTelefonTailDetails(testData.getTestData(method.getName() + ".tailHeader"),
                testData.getTestData(method.getName() + ".tailSubHeader"));
        new KostenkontrollePage(driver).validateTelefonNoCallsCaseDetails(testData.getTestData(method.getName() + ".noCallsHeader"),
                testData.getTestData(method.getName() + ".noCallsSubHeader"));
    }

    @Test(description ="GC08- Verify the 1st entry point for Telephone usage While user has no telephone activated." )
    @TmsLink("WFFT-2963")
    private void GC08(Method method){
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();
        new KostenkontrollePage(driver).ClickOnKostenkontrolleTab();
        new KostenkontrollePage(driver).ClickOnTelefonButton();
        new KostenkontrollePage(driver).validateKostenkontrolleTabDetails(testData.getTestData(method.getName() + ".tabHeader"),
                testData.getTestData(method.getName() + ".tabSubHeader"));
        new KostenkontrollePage(driver).selectTelefonTail();
        new KostenkontrollePage(driver).validateTelefonNotActiveCaseDetails(testData.getTestData(method.getName() + ".notActiveHeader"),
                testData.getTestData(method.getName() + ".notActiveSubHeader"),testData.getTestData(method.getName() + ".activationButton"));
    }
}
