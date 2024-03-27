package de.vodafone.tests.KD.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.KabelTVPage;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("KD")
@Feature("ST")
@Story("WFBT-10697")
public class WFBT_10697 extends  ST_KDSetup{

    @TmsLink("WFBT-11129")
    @Test(description = "GC01 - Validate Mein Tariff Accordion Existance")
    public void assertOnMeinTariffAccordion(){
        new KD_Dashboard(driver).expandKabelTvAccordion()
                 .clickOnMeinTariffSO();
        new KabelTVPage(driver).validateMeinTariffAcc();
    }

    @TmsLink("WFBT-11130")
    @Test(description = "GC02 - View Mein Tariff accordion with one tariff linked to a smart card")
    public void validateTariffView(){
        new KD_Dashboard(driver).expandKabelTvAccordion()
                 .clickOnMeinTariffSO();
        new KabelTVPage(driver).assertOnSmartCard1()
                  .validateSmartCardTarifDetails()
                  .assertOnUSPsCardExists()
                  .assertOnChangeTariffNotificationExistsOnce()
                  .assertOnMBOXsID();
    }

    @TmsLink("WFBT-11133")
    @Test(description = "GC03 - Check that change tariff notification card appears only once after the first tariff")
    public void validateThatNotificationAppearsOnce(){
        new KD_Dashboard(driver).closeNotification()
                 .expandKabelTvAccordion()
                 .clickOnMeinTariffSO();
        new KabelTVPage(driver).assertOnChangeTariffNotificationExistsOnce()
                  .assertOnMBOXsID();
    }

    @TmsLink("WFBT-11134")
    @Test(description = "GC04 - Check that each tariff is linked to its smart card")
    public void checkThatEachTariffLinkedToASmartCard(){
        new KD_Dashboard(driver).expandKabelTvAccordion()
                 .clickOnMeinTariffSO();
        new KabelTVPage(driver).assertOnSmartCard1()
                  .assertOnUSPsCardExists()
                  .validateSmartCard2()
                  .assertOnSecondUSPsCardExists()
                  .assertOnChangeTariffNotificationExistsOnce();
    }

    @TmsLink("WFBT-11136")
    @Test(description = "GC05 - Check that tariff appears with no smart card ID if it's not linked to a smart card")
    public void assertOnOneTariffAppearance(){
        new KD_Dashboard(driver).expandKabelTvAccordion()
                 .clickOnMeinTariffSO();
        new KabelTVPage(driver).assertOnTariffOnly()
                  .assertOnUSPsCardExists()
                  .assertOnChangeTariffNotificationExistsOnce();
    }

    @TmsLink("WFBT-11137")
    @Test(description = "GC06 - Check that the header is (Tarife ohne smart card) when tariffs not linked to smart card")
    public void checkOnTarifeOhneSmartCard(){
        new KD_Dashboard(driver).expandKabelTvAccordion()
                 .clickOnMeinTariffSO();
        new KabelTVPage(driver).assertOnTariffWithoutSmartCard()
                  .assertOnSecondUSPsCardExists()
                  .assertOnChangeTariffNotificationExistsOnce();
    }

    @TmsLink("WFBT-11138")
    @Test(description = "GC07 - Check that a static notification appears when there is no tariff or booked options")
    public void checkStaticNotification(){
        new KD_Dashboard(driver).expandKabelTvAccordion()
                  .clickOnMeinTariffSO();
        new KabelTVPage(driver).assertOnNoTariffOrBookedOptionsNotificationCard()
                  .assertOnMBOXsID();
    }

    @TmsLink("WFBT-11139")
    @Test(description = "GC08 - when KD user has only booked options, check that there is a static card appears")
    public void assertOnBookedOptionsStaticCard(){
        new KD_Dashboard(driver).expandKabelTvAccordion()
                .clickOnMeinTariffSO();
        new KabelTVPage(driver).assertOnStaticBookedOptionCard()
                  .assertOnChangeTariffNotificationExistsOnce()
                  .assertOnMBOXsID();
    }

    @TmsLink("WFBT-11400")
    @Test(description = "GC10 - Check that all the products appears when KD user has all of them(tariff linked to smart card, " +
            "tariff not linked to a smart card and booked options ")
    public void validateOnAllProducts(){
        new KD_Dashboard(driver).expandKabelTvAccordion()
                 .clickOnMeinTariffSO();
        new KabelTVPage(driver).assertOnSmartCard1()
                  .assertOnUSPsCardExists()
                  .assertOnChangeTariffNotificationExistsOnce()
                  .assertOnTariffWithoutSmartCard()
                  .assertOnSecondUSPsCardExists()
                  .assertOnStaticBookedOptionCardInEdgeCase()
                  .assertOnMBOXsID();
    }

    @TmsLink("WFBT-11401")
    @Test(description = "BC01 - Check that the notification error msg appears when a BE error occurs")
    public void assertOnNotificationBEError(){
        new KD_Dashboard(driver).expandKabelTvAccordion()
                 .clickOnMeinTariffSO();
        new KabelTVPage(driver).assertOnNotificationError();
    }
}
