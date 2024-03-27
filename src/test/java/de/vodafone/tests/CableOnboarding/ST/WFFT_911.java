/*
package de.vodafone.tests.CableOnboarding.ST;

import com.shaft.validation.Validations;
import de.vodafone.pages.CableOnboarding.FAQsPage;
import de.vodafone.pages.CableOnboarding.SelfInstallDashboard;
import de.vodafone.pages.CableOnboarding.TechInstallDashboard;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Cable Onboarding")
@Feature("ST")
public class WFFT_911 extends CableOnboardingSTSetup {

    @Test(description="GC01- Check FAQs page in case of Self installed & provider changed = 'Yes'")
    @TmsLink("WFFT-1169")
    private void GC01(Method method) {

        new SelfInstallDashboard(driver)
                .navigateToFAQsPage();

        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".header"))
                .withCustomReportMessage("Check Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.subHeader_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".SubHeader"))
                .withCustomReportMessage("Check Sub Header Title")
                .perform();

        new FAQsPage(driver).Self_Install_ClickOnWerInstalliertMeinenRouter_Accordion();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.selfInstall_werInstalliertMeinenRouter_Accordion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc1"))
                .withCustomReportMessage("Check Accordion-1 Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.selfInstall_werInstalliertMeinenRouter_AccordionDescribtion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc1Description"))
                .withCustomReportMessage("Check Accordion-1 Description")
                .perform();

        new FAQsPage(driver).Self_Install_ClickOnWannbeginntmeinVertrag_Accordion();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.selfInstall_wannbeginntmeinVertrag_Accordion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc2"))
                .withCustomReportMessage("Check Accordion-2 Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.selfInstall_wannbeginntmeinVertrag_AccordionDescribtion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc2Description"))
                .withCustomReportMessage("Check Accordion-2 Description")
                .perform();

        new FAQsPage(driver).Self_Install_ClickOnAbwannkannichdasInternetnutzen_Accordion();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.selfInstall_AbwannkannichdasInternetnutzen_Accordion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc3"))
                .withCustomReportMessage("Check Accordion-3 Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.selfInstall_AbwannkannichdasInternetnutzen_AccordionDescribtion)
                .text()
                .contains(testData.getTestData(method.getName()+".acc3Description"))
                .withCustomReportMessage("Check Accordion-3 Description")
                .perform();

    }

    @Test(description="GC02 - Check FAQs page in case of Self installed & provider changed = 'No'")
    @TmsLink("WFFT-1172")
    private void GC02(Method method) {
        new SelfInstallDashboard(driver)
                .navigateToFAQsPage();

        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".header"))
                .withCustomReportMessage("Check Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.subHeader_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".SubHeader"))
                .withCustomReportMessage("Check Sub Header Title")
                .perform();

        new FAQsPage(driver).Self_Install_ClickOnWerInstalliertMeinenRouter_Accordion();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.selfInstall_werInstalliertMeinenRouter_Accordion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc1"))
                .withCustomReportMessage("Check Accordion-1 Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.selfInstall_werInstalliertMeinenRouter_AccordionDescribtion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc1Description"))
                .withCustomReportMessage("Check Accordion-1 Description")
                .perform();

        new FAQsPage(driver).Self_Install_ClickOnWannbeginntmeinVertrag_Accordion();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.selfInstall_wannbeginntmeinVertrag_Accordion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc2"))
                .withCustomReportMessage("Check Accordion-2 Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.selfInstall_wannbeginntmeinVertrag_AccordionDescribtion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc2Description"))
                .withCustomReportMessage("Check Accordion-2 Description")
                .perform();

        new FAQsPage(driver).Self_Install_ClickOnWasistderAnbieterwechsel_Accordion();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.selfInstall_WasistderAnbieterwechsel_Accordion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc3"))
                .withCustomReportMessage("Check Accordion-3 Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.selfInstall_WasistderAnbieterwechsel_AccordionDescribtion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc3Description"))
                .withCustomReportMessage("Check Accordion-3 Description")
                .perform();

        new FAQsPage(driver).Self_Install_ClickOnAbwannkannichdasInternetnutzen_Accordion();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.selfInstall_AbwannkannichdasInternetnutzen_Accordion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc4"))
                .withCustomReportMessage("Check Accordion-4 Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.selfInstall_AbwannkannichdasInternetnutzen_AccordionDescribtion)
                .text()
                .contains(testData.getTestData(method.getName()+".acc4Description"))
                .withCustomReportMessage("Check Accordion-4 Description")
                .perform();
    }

    @Test(description="GC03 - Check FAQs page in case of Tech Installed & provider changed = 'Yes'")
    @TmsLink("WFFT-1175")
    private void GC03(Method method) {
        new TechInstallDashboard(driver)
                .navigateToFAQsPage();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".header"))
                .withCustomReportMessage("Check Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.subHeader_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".SubHeader"))
                .withCustomReportMessage("Check Sub Header Title")
                .perform();

        new FAQsPage(driver).Tech_Install_ClickOnWerInstalliertMeinenRouter_Accordion();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.TechInstall_werInstalliertMeinenRouter_Accordion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc1"))
                .withCustomReportMessage("Check Accordion-1 Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.TechInstall_werInstalliertMeinenRouter_AccordionDescribtion)
                .text()
                .contains(testData.getTestData(method.getName()+".acc1Description"))
                .withCustomReportMessage("Check Accordion-1 Description")
                .perform();

        new FAQsPage(driver).Tech_Install_ClickOnWannbeginntmeinVertrag_Accordion();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.TechInstall_wannbeginntmeinVertrag_Accordion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc2"))
                .withCustomReportMessage("Check Accordion-2 Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.TechInstall_wannbeginntmeinVertrag_AccordionDescribtion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc2Description"))
                .withCustomReportMessage("Check Accordion-2 Description")
                .perform();

        new FAQsPage(driver).Tech_Install_ClickOnAbwannkannichdasInternetnutzen_Accordion();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.TechInstall_AbwannkannichdasInternetnutzen_Accordion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc3"))
                .withCustomReportMessage("Check Accordion-3 Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.TechInstall_AbwannkannichdasInternetnutzen_AccordionDescribtion)
                .text()
                .contains(testData.getTestData(method.getName()+".acc3Description"))
                .withCustomReportMessage("Check Accordion-3 Description")
                .perform();

        new FAQsPage(driver).Tech_Install_ClickOnWiekannichbeiAnbieterwechselmeinenAnschlusssofortaktivieren_Accordion();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.TechInstall_WiekannichbeiAnbieterwechselmeinenAnschlusssofortaktivieren_Accordion)
                .text()
                .contains(testData.getTestData(method.getName()+".acc4"))
                .withCustomReportMessage("Check Accordion-4 Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.TechInstall_WiekannichbeiAnbieterwechselmeinenAnschlusssofortaktivieren_AccordionDescribtion)
                .text()
                .contains(testData.getTestData(method.getName()+".acc4Description"))
                .withCustomReportMessage("Check Accordion-4 Description")
                .perform();

    }

    @Test(description="GC04- Check FAQs page in case of Tech Installed & provider changed = 'No'")
    @TmsLink("WFFT-1178")
    private void GC04(Method method) {
        new TechInstallDashboard(driver)
                .navigateToFAQsPage();

        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".header"))
                .withCustomReportMessage("Check Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.subHeader_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".SubHeader"))
                .withCustomReportMessage("Check Sub Header Title")
                .perform();

        new FAQsPage(driver).Tech_Install_ClickOnWerInstalliertMeinenRouter_Accordion();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.TechInstall_werInstalliertMeinenRouter_Accordion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc1"))
                .withCustomReportMessage("Check Accordion-1 Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.TechInstall_werInstalliertMeinenRouter_AccordionDescribtion)
                .text()
                .contains(testData.getTestData(method.getName()+".acc1Description"))
                .withCustomReportMessage("Check Accordion-1 Description")
                .perform();

        new FAQsPage(driver).Tech_Install_ClickOnWannbeginntmeinVertrag_Accordion();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.TechInstall_wannbeginntmeinVertrag_Accordion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc2"))
                .withCustomReportMessage("Check Accordion-2 Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.TechInstall_wannbeginntmeinVertrag_AccordionDescribtion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc2Description"))
                .withCustomReportMessage("Check Accordion-2 Description")
                .perform();
        new FAQsPage(driver).Tech_Install_ClickOnWasistderAnbieterwechsel_Accordion();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.TechInstall_WasistderAnbieterwechsel_Accordion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc3"))
                .withCustomReportMessage("Check Accordion-3 Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.TechInstall_WasistderAnbieterwechsel_AccordionDescribtion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc3Description"))
                .withCustomReportMessage("Check Accordion-3 Description")
                .perform();

        new FAQsPage(driver).Tech_Install_ClickOnAbwannkannichdasInternetnutzen_Accordion();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.TechInstall_AbwannkannichdasInternetnutzen_Accordion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc4"))
                .withCustomReportMessage("Check Accordion-4 Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.TechInstall_AbwannkannichdasInternetnutzen_AccordionDescribtion)
                .text()
                .contains(testData.getTestData(method.getName()+".acc4Description"))
                .withCustomReportMessage("Check Accordion-4 Description")
                .perform();

        new FAQsPage(driver).Tech_Install_ClickOnWiekannichbeiAnbieterwechselmeinenAnschlusssofortaktivieren_Accordion();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.TechInstall_WiekannichbeiAnbieterwechselmeinenAnschlusssofortaktivieren_Accordion)
                .text()
                .contains(testData.getTestData(method.getName()+".acc5"))
                .withCustomReportMessage("Check Accordion-5 Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.TechInstall_WiekannichbeiAnbieterwechselmeinenAnschlusssofortaktivieren_AccordionDescribtion)
                .text()
                .contains(testData.getTestData(method.getName()+".acc5Description"))
                .withCustomReportMessage("Check Accordion-5 Description")
                .perform();

        new FAQsPage(driver).Tech_Install_ClickOnWasistderWechselservice_Accordion();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.TechInstall_WasistderWechselservice_Accordion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc6"))
                .withCustomReportMessage("Check Accordion-6 Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.TechInstall_WasistderWechselservice_AccordionDescribtion)
                .text()
                .contains(testData.getTestData(method.getName()+".acc6Description"))
                .withCustomReportMessage("Check Accordion-6 Description")
                .perform();

        new FAQsPage(driver).Tech_Install_ClickOnWienutzeichdenWechselservice_Accordion();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.TechInstall_WienutzeichdenWechselservice_Accordion)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".acc7"))
                .withCustomReportMessage("Check Accordion-7 Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), FAQsPage.TechInstall_WienutzeichdenWechselservice_AccordionDescribtion)
                .text()
                .contains(testData.getTestData(method.getName()+".acc7Description"))
                .withCustomReportMessage("Check Accordion-7 Description")
                .perform();

    }
}
*/