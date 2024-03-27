package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.SettingPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

@Epic("KD")
@Feature("ST")
@Story("WFBT-13794")
public class WFBT_13794 extends ST_KDSetup {
    @TmsLink("WFBT_13899")
    @Test(description = "GC01 | WFBT-13794 | Check when open dashboard as TV user will see Giga TV-Geräte Smart Object in Kabel TV accordion")
    public void GC01(Method method) {
        new KD_Dashboard(driver).expandKabelTvAccordion()
                .validateGigaTVGerateSO(testData.getTestData(method.getName() + ".GigaTVGerateSOHeaderCL"),
                        testData.getTestData(method.getName() + ".GigaTVGerateSOSubLineCL"))
                .clickOnGigaTVGerateSO();
        new SettingPage(driver).validateGigaTVGerateAccExpanded(testData.getTestData(method.getName() + ".RegisterDevicesTextCL"));
    }

    @TmsLink("WFBT_13900")
    @Test(description = "GC02 | WFBT-13794 | Check when click Kabel-tv burger menu Then I should find a new field for Geräte & Einstellungen")
    public void GC02(Method method) {
        new KD_Dashboard(driver).clickBurgerMenuKabelTV()
                .validateDeviceAndSettingBurgerMenu(testData.getTestData(method.getName() + ".DeviceAndSettingBurgerMenuCL"))
                .clickOnDeviceAndSettingBurgerMenu();
        new SettingPage(driver).validateDeviceAndSettingHeaderPage(testData.getTestData(method.getName() + ".DeviceAndSettingHeaderPageCL"));
    }
}