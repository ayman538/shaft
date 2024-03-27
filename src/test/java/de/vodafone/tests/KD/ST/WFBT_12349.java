package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.TariffPageInternetAndPhone;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

@Epic("KD")
@Feature("ST")
@Story("WFBT-12349")
public class WFBT_12349 extends ST_KDSetup{

    @TmsLink("WFBT-12492")
    @Test(description = "GC01 | WFBT-12349 | Check default view (main tarif) for booked options accordion with the CLS drop menu")
    public void checkDefaultViewOfBookedOptionsAccordionWithCLSDropDownMenu(Method method){
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickBookedOptionsSO()
            .validateBookedOptionsAccordionBodyWithCLSMenu(
                    testData.getTestData(method.getName() + ".bookedOptionsAccordionBodyHeaderCL"),
                    testData.getTestData(method.getName() + ".bookedOptionsAccordionBodySubHeaderCL"),
                    testData.getTestData(method.getName() + ".defaultContractHeaderCL"),
                    testData.getTestData(method.getName() + ".defaultContractNumberCL"));
    }

    @TmsLink("WFBT-12493")
    @Test(description = "GC02 | WFBT-12349 | Validate drop down menu having all the contract IDs")
    public void validateAllContractNumberExists(){
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickBookedOptionsSO().getTheDropDownMenuContractIDs();
    }

    @TmsLink("WFBT-12494")
    @Test(description = "GC03 | WFBT-12349 | Check when user choose a contract ID from the drop-down menu, all the booked options related to it are displayed")
    public void validateDisplayedOptionsRelatedToItsContract(){
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickBookedOptionsSO().validateEachContractHasEachOptions();
    }

    @TmsLink("WFBT-12496")
    @Test(description = "GC04 | WFBT-12349 | When user has only CLS tarif, all the CLS booked options will appear only (Multi-contract CLS)")
    public void validateCLSOptionsOnlyDisplayed(Method method){
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickBookedOptionsSO().validateCLSOptions(
                testData.getTestData(method.getName() + ".CLSOption1"),
                testData.getTestData(method.getName() + ".CLSOption2"),
                testData.getTestData(method.getName() + ".CLSOption3"),
                testData.getTestData(method.getName() + ".CLSOption4"),
                testData.getTestData(method.getName() + ".CLSOption5"));
    }

    @TmsLink("WFBT-12497")
    @Test(description = "GC05 | WFBT-12349 | Check when user has only main Tarif booked options (Multi contracts KIP)")
    public void validateKIPOptionsOnlyDisplayed(Method method){
        new KD_Dashboard(driver).openBurgerMenu().goToTariffPage();
        new TariffPageInternetAndPhone(driver).clickBookedOptionsSO().validateKIPOptions(
                testData.getTestData(method.getName() + ".KIPOption1"),
                testData.getTestData(method.getName() + ".KIPOption2"),
                testData.getTestData(method.getName() + ".KIPOption3"),
                testData.getTestData(method.getName() + ".KIPOption4"),
                testData.getTestData(method.getName() + ".KIPOption5"),
                testData.getTestData(method.getName() + ".KIPOption6"),
                testData.getTestData(method.getName() + ".KIPOption7"),
                testData.getTestData(method.getName() + ".KIPOption8")
        );
    }

    @TmsLink("WFBT-12442")
    @Test(description = "GC06 | WFBT-12349 | Check that no drop-down menu appears in the booked accordion when there is only a one contract with only CLS tarif")
    public void assertOnNoDropdownMenuAppearsWhenOnlyOneCLSContract(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickBookedOptionsSO()
            .assertThaNoCLSContractListAppearsInBookedOptionsBody(testData.getTestData(method.getName() + ".CLSOption"));
    }

    @TmsLink("WFBT-12443")
    @Test(description = "GC07 | WFBT-12349 | Check that no drop-down menu appears in the booked accordion when there is only a one contract with only KIP Tarif")
    public void assertOnNoDropdownMenuAppearsWhenOnlyOneKIPContract(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickBookedOptionsSO()
            .assertThaNoKIPContractListAppearsInBookedOptionsBody(testData.getTestData(method.getName() + ".KIPOption"));
    }
}