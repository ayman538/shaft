package de.vodafone.tests.MobileCom.ST;

import de.vodafone.pages.MobileCom.Dashboard;
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
public class WFCT_14600 extends ST_MobileComSetup {
    Dashboard dashboard;
    int requiredCount,requiredNumberOfSmartCard;
    String contractOrder,pageHeader,color,cardTitle, TilesNumber,productsTitleCl,productsSublineCl,
            numberOfOptions,numberOfSmartCards,option1,option2,option3,aktuelleGuthabenAmount
            , remainingData,tariffPlan,aktuelleGuthabenErrorHL,aktuelleGuthabenErrorBody,dataPackageErrorHl
            ,dataPackageErrorBody,tariffPlanErrorHl,tariffPlanErrorBody,negativeCurrentBalance
            ,aktuelleGuthabenAmountSubtitle,aktuelleGuthabenTitle,totalData,datenSoSubline,dataEndDate
            ,remainingDataColor,tariffDuration,tariffEndDate,tariffStartDate,datenSoGenericCl,tariffSoGenericCl;




    @BeforeMethod
    public void beforeMethod(Method method){
        dashboard = new de.vodafone.pages.MobileCom.Dashboard(driver);
        contractOrder = testData.getTestData(method.getName()+".contractOrder");
        pageHeader = testData.getTestData(method.getName()+".pageHeader");
        color = testData.getTestData(method.getName()+".color");
        cardTitle = testData.getTestData(method.getName()+".cardTitle");
        TilesNumber = testData.getTestData(method.getName()+".smartTileNumber");
        productsTitleCl = testData.getTestData(method.getName()+".productsTitleCl");
        productsSublineCl = testData.getTestData(method.getName()+".productsSublineCl");
        numberOfOptions = testData.getTestData(method.getName()+".numberOfOptions");
        option1 = testData.getTestData(method.getName()+".option1");
        option2 = testData.getTestData(method.getName()+".option2");
        option3 = testData.getTestData(method.getName()+".option3");
        numberOfSmartCards = testData.getTestData(method.getName()+".numberOfSmartCards");
        aktuelleGuthabenAmount = testData.getTestData(method.getName()+".aktuelleGuthabenAmount");
        aktuelleGuthabenTitle = testData.getTestData(method.getName()+".aktuelleGuthabenTitle");
        aktuelleGuthabenAmountSubtitle = testData.getTestData(method.getName()+".aktuelleGuthabenAmountSubtitle");
        tariffPlan = testData.getTestData(method.getName()+".tariffPlan");
        aktuelleGuthabenErrorHL = testData.getTestData(method.getName()+".aktuelleGuthabenErrorHL");
        aktuelleGuthabenErrorBody = testData.getTestData(method.getName()+".aktuelleGuthabenErrorBody");
        dataPackageErrorHl = testData.getTestData(method.getName()+".dataPackageErrorHl");
        dataPackageErrorBody = testData.getTestData(method.getName()+".dataPackageErrorBody");
        tariffPlanErrorHl = testData.getTestData(method.getName()+".tariffPlanErrorHl");
        tariffPlanErrorBody = testData.getTestData(method.getName()+".tariffPlanErrorBody");
        requiredCount = Integer.parseInt(testData.getTestData(method.getName() + ".requiredCount"));
        requiredNumberOfSmartCard = Integer.parseInt(testData.getTestData(method.getName() + ".numberOfSmartCards"));
        negativeCurrentBalance = testData.getTestData(method.getName()+".negativeCurrentBalance");
        remainingData = testData.getTestData(method.getName()+".remainingData");
        totalData =testData.getTestData(method.getName()+".totalData");
        datenSoSubline = testData.getTestData(method.getName()+".datenSoSubline");
        dataEndDate = testData.getTestData(method.getName()+".dataEndDate");
        remainingDataColor = testData.getTestData(method.getName()+".remainingDataColor");
        tariffDuration = testData.getTestData(method.getName()+".tariffDuration");
        tariffEndDate = testData.getTestData(method.getName()+".tariffEndDate");
        tariffStartDate = testData.getTestData(method.getName()+".tariffStartDate");
        datenSoGenericCl = testData.getTestData(method.getName()+".datenSoGenericCl");
        tariffSoGenericCl = testData.getTestData(method.getName()+".tariffSoGenericCl");

    }

    @Test(description = "GC01 - Robert with (zero amount, 10% consumption at daten and recurring tariff) checks dashboard")
    @TmsLink("WFCT-15106")
    public void GC01_RobertUserWithZeroAmountChecksDashboard(Method method){
        dashboard.navigateToRobertUserDashboard();
        dashboard.assertOnPageHeaderForRobertAndItsColor(pageHeader,color);
        dashboard.assertOnCardTitleAndNoSublineForRobert(cardTitle);
        dashboard.assertOnTilesNumberForRobert(TilesNumber);
        dashboard.assertOnProductsClAndSublineForRobert(productsTitleCl,productsSublineCl);
        dashboard.assertOnTeilenhmerAndNumber();
        dashboard.assertOnAktuelleGuthabenTile(aktuelleGuthabenAmount,aktuelleGuthabenTitle,aktuelleGuthabenAmountSubtitle);
        dashboard.assertOnDataSO(remainingData,totalData,datenSoSubline, dataEndDate,remainingDataColor);
        dashboard.assertOnTariffSO(tariffPlan,tariffDuration,tariffEndDate);
        dashboard.clickBurgerMenuIcon(contractOrder);
        dashboard.assertOnBurgerMenuOptionsNumberForRobert(numberOfOptions);
        assertOnBurgerMenuOptionNames(requiredCount,method);
        dashboard.assertOnSmartCardNumbersForRobert(numberOfSmartCards);
        assertOnSmartCardsNames(requiredNumberOfSmartCard,method);

    }

    @Test(description = "GC02 - Robert user with (not returned amount, 30% consumption at daten and not recurring tariff) checks dashboard")
    @TmsLink("WFCT-15107")
    public void GC02_RobertUserWithUnreturnedAmountAtAktuellesGuthabenChecksDashboard(){
        dashboard.assertThatCurrentBalanceTileIsDimmedAndNotAvailableCL();
        dashboard.assertOnDataSO(remainingData,totalData,datenSoSubline, dataEndDate,remainingDataColor);
        dashboard.assertOnNonRecurringTariffPlan(tariffPlan,tariffDuration);

    }

    @Test(description = "GC03 - Robert user with (negative amount, less than 10% consumption at daten and cancelled tariff) checks dashboard")
    @TmsLink("WFCT-15108")
    public void GC03_RobertUserWithNegativeAmountAtAktuellesGuthabenChecksDashboard(){
        dashboard.assertThatCurrentBalanceTileWithNegativeAndRedAmount(negativeCurrentBalance,color);
        dashboard.assertOnDataSO(remainingData,totalData,datenSoSubline, dataEndDate,remainingDataColor);
        dashboard.assertOnCancelledTariff(tariffPlan,tariffDuration,tariffEndDate);
    }

    @Test(description = "GC04 - Robert user with (service failure, complete consumption at daten and future dated tariff) checks dashboard")
    @TmsLink("WFCT-15109")
    public void GC04_RobertUserWithFailedAktuellesGuthabenChecksDashboard(){
        dashboard.assertThatCurrentBalanceTileIsDimmedAndNotAvailableCL();
        dashboard.assertOnDataSO(remainingData,totalData,datenSoSubline, dataEndDate,remainingDataColor);
        dashboard.assertOnFutureDatedTariff(tariffPlan,tariffDuration,tariffStartDate);
    }

    @Test(description = "GC05 - Robert user with (big amount, service failure at daten and service failure) checks dashboard")
    @TmsLink("WFCT-15110")
    public void GC05_RobertUserWithFailedTariffChecksDashboard(Method method){
        dashboard.assertOnAktuelleGuthabenTile(aktuelleGuthabenAmount,aktuelleGuthabenTitle,aktuelleGuthabenAmountSubtitle);
        dashboard.assertOnDataSoFailure(datenSoGenericCl);
        dashboard.assertOnTariffFailure(tariffSoGenericCl);
    }

    @Test(description = "GC06 - Robert user with (big amount, you can not use data notification at daten and sleeping tariff) checks dashboard")
    @TmsLink("WFCT-15112")
    public void GC06_RobertUserWithSleepingTariffChecksDashboard(){
        dashboard.assertOnAktuelleGuthabenTile(aktuelleGuthabenAmount,aktuelleGuthabenTitle,aktuelleGuthabenAmountSubtitle);
        dashboard.assertOnSleepingTariffRedNotificationMsgAtTariffSo();
        dashboard.assertThatDatenSoDisplayedRedNotificationAtSleepingTariff();
    }

    public void assertOnBurgerMenuOptionNames(int requiredCount, Method method) {
        for (int x = 1; x <= requiredCount; x++) {
            driver.verifyThat().element(de.vodafone.pages.MobileCom.Dashboard.burgerMenuOptionLocator(x)).textTrimmed().isEqualTo(testData.getTestData(method.getName() + ".option"+x)).withCustomReportMessage("assert Burger Menu Option"+x).perform();
        }

    }


    public void assertOnSmartCardsNames(int requiredNumberOfSmartCard, Method method) {
        for (int x = 1; x <= requiredNumberOfSmartCard; x++) {
            driver.verifyThat().element(Dashboard.smartObjectCardLocator(x)).textTrimmed().isEqualTo(testData.getTestData(method.getName() + ".smartCard"+x)).withCustomReportMessage("assert Burger Menu Option"+x).perform();
        }

    }


}
