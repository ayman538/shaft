package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.GigaTVDeleteDevice;
import de.vodafone.pages.Kabledeutschland.TVProductDetails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT-9067")
public class WFDT_9067 extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-9124")
    @Test(description = "GC01 || Martin Consumer - Validate Delete GigaTV device in case Success message is displayed.",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openGigaTVSettingsPageUsingBurgerMenuLinkout();
        new TVProductDetails(driver)
                .expandGigaTVAccordion()
                .clickOnDeleteButtonForFirstDevice();

        new GigaTVDeleteDevice(driver)
                .validateDeleteDeviceInformationMessage()
                .clickOnConfirmationDeleteButton()
                .validateDeleteDeviceConfirmationMessage();
    }

    @TmsLink("WFDT-9125")
    @Test(description = "GC02 || Martin Consumer - Validate that delete GigaTV device Deeplinking is disabled.",groups = {"eCare"})
    private void gc02() {
        new TVProductDetails(driver).validateDeleteGigaTVDeepLinkingIsDisabled();
    }

    @TmsLink("WFDT-9127")
    @Test(description = "BC01 || Martin SOHO - Validate Delete GigaTV in case Failure message is displayed.",groups = {"eCare"})
    private void bc01() {
        new Dashboard(driver).openGigaTVSettingsPageUsingBurgerMenuLinkout();
        new TVProductDetails(driver)
                .expandGigaTVAccordion()
                .clickOnDeleteButtonForSecondDevice();

        new GigaTVDeleteDevice(driver)
                .validateDeleteDeviceInformationMessageIncaseOfFailure()
                .clickOnConfirmationDeleteButton()
                .validateDeleteDeviceErrorMessage();
    }

}