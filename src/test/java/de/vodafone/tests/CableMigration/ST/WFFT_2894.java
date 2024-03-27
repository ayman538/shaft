package de.vodafone.tests.CableMigration.ST;
import de.vodafone.pages.CableMigration.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Cable Migration")
@Feature("ST")
@Story("WFFT_2894 KD Unbilled Usage TV&Video")
public class WFFT_2894 extends CableMigrationSTSetup {
    String Textt;
    String SubTextt;
    String Datee;
    String Durationn;
    String MsgText;
    String MsgSubText;
    String NoBookingMsgText;
    String NoBookingMsgSubText;
    MeinVodafoneDashboard meinVodafoneDashboard;
    KostenkontrollePage kostenkontrollePage;
    @Test(description = "GC01- Check the 1st entry point single TV and full itemized bill")
    @TmsLink("WFFT-2964")
    private void GC01(){
        meinVodafoneDashboard = new MeinVodafoneDashboard(driver);
        meinVodafoneDashboard.navigateToMeinReshnungPage();
        kostenkontrollePage = new KostenkontrollePage(driver);
        kostenkontrollePage.ClickOnKostenkontrolleTab();
        kostenkontrollePage.validateMeinRechnungTexts();
        kostenkontrollePage.ClickOnTVandVideo();
        kostenkontrollePage.validateText(Textt,SubTextt);
        kostenkontrollePage.ClickOnCollapseBtn();
        kostenkontrollePage.validateCollapsibleCard(Datee,Durationn);
    }
    @Test(description = "GC02- Check the 2nd entry point multiple TV and full itemized bill")
    @TmsLink("WFFT-2965")
    public void GC02(){
        meinVodafoneDashboard = new MeinVodafoneDashboard(driver);
        meinVodafoneDashboard.ClickOnTVandVideo();
        meinVodafoneDashboard.ClickOnKostenkontrolleTab();
        kostenkontrollePage = new KostenkontrollePage(driver);
        kostenkontrollePage.ClickOnKostenkontrolleTab();
        kostenkontrollePage.validateMeinRechnungTexts();
        kostenkontrollePage.validateText(Textt,SubTextt);
        kostenkontrollePage.ClickOnCollapseBtn();
        kostenkontrollePage.validateCollapsibleCard(Datee,Durationn);
    }
    @Test(description = "GC03- Check the 1st entry point no TV usage")
    @TmsLink("WFFT-2966")
    public void GC03(){
        meinVodafoneDashboard = new MeinVodafoneDashboard(driver);
        meinVodafoneDashboard.navigateToMeinReshnungPage();
        kostenkontrollePage = new KostenkontrollePage(driver);
        kostenkontrollePage.ClickOnKostenkontrolleTab();
        kostenkontrollePage.validateMeinRechnungTexts();
        kostenkontrollePage.ClickOnTVandVideo();
        kostenkontrollePage.validateText(Textt,SubTextt);
        kostenkontrollePage.validateZeroBillsInfoMsg(MsgText,MsgSubText);
    }
    @Test(description = "GC04- Check the 1st entry point no TV booked")
    @TmsLink("WFFT-2967")
    public void GC04(){
        meinVodafoneDashboard = new MeinVodafoneDashboard(driver);
        meinVodafoneDashboard.navigateToMeinReshnungPage();
        kostenkontrollePage = new KostenkontrollePage(driver);
        kostenkontrollePage.ClickOnKostenkontrolleTab();
        kostenkontrollePage.validateMeinRechnungTexts();
    }
}
