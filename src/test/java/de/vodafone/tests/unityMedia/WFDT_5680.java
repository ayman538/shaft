package de.vodafone.tests.unityMedia;

import com.shaft.validation.Validations;
import de.vodafone.pages.unityMedia.MeineDaten;
import de.vodafone.pages.unityMedia.MyDocuments;
import de.vodafone.tests.unityMedia.ST.ST_UnityMediaSetup;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

@Epic("Unity Media")
public class WFDT_5680 extends ST_UnityMediaSetup {

    //Test
    @Test
    @Description("Ute - Check Meine Dokumente SO, link out in Meine Daten page and redirection")
    private void gc01() {
        //new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        //validate Meine Dokumente SO and linkout
        new MeineDaten(driver).clickOnNEXTBTNSUSHI();
        Validations.assertThat().element(driver.getDriver(), MeineDaten.meineDokumenteSOHeader)
                .text().isEqualTo(MeineDaten.meineDokumenteSOHeaderCL)
                .withCustomReportMessage("Validate Dokumente SO Header text")
                .perform();
        Validations.assertThat().element(driver.getDriver(), MeineDaten.meineDokumenteSOFooter)
                .text().isEqualTo(MeineDaten.meineDokumenteSOFooterCL)
                .withCustomReportMessage("Validate Dokumente SO Footer text")
                .perform();
        Validations.assertThat().element(driver.getDriver(), MeineDaten.dokumenteLinkout)
                .text().isEqualTo(MeineDaten.dokumenteLinkoutCL)
                .withCustomReportMessage("Validate Dokumente Linkout text")
                .perform();

        new MeineDaten(driver).clickOnDokumenteLinkout();

        //validate Meine Dokumente Linkout redirection
        Validations.assertThat().element(driver.getDriver(), MyDocuments.Dokumentstab)
                .text().isEqualTo(MyDocuments.DokumentstabCL)
                .withCustomReportMessage("Validate Documents title")
                .perform();
//        Validations.assertThat().element(driver.getDriver(), MyDocuments.MitteilungenTitle)
//                .text().isEqualTo(MyDocuments.MitteilungenTitleCL)
//                .withCustomReportMessage("Validate Mitteilungen Page Title")
//                .perform();


        new MyDocuments(driver).clickOnBackButton();

        Validations.assertThat().element(driver.getDriver(), MeineDaten.meineDokumenteSOHeader)
                .text().isEqualTo(MeineDaten.meineDokumenteSOHeaderCL)
                .withCustomReportMessage("Validate Meine Dokumente SO Header")
                .perform();

        new MeineDaten(driver).clickOnNEXTBTNSUSHI();
        new MeineDaten(driver).clickOnMeineDokumenteSO();    //new MeineDaten(driver).clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.DOKUMENTE);


        //validate Meine Dokumente Smart object redirection
        Validations.assertThat().element(driver.getDriver(), MyDocuments.Dokumentstab)
                .text().isEqualTo(MyDocuments.DokumentstabCL)
                .withCustomReportMessage("Validate Documents title")
                .perform();
//        Validations.assertThat().element(driver.getDriver(), MyDocuments.MitteilungenTitle)
//                .text().isEqualTo(MyDocuments.MitteilungenTitleCL)
//                .withCustomReportMessage("Validate Mitteilungen Page Title")
//                .perform();

    }
}

