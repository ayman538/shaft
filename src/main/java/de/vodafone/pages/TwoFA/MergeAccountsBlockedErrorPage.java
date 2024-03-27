package de.vodafone.pages.TwoFA;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class MergeAccountsBlockedErrorPage {
    private static SHAFT.GUI.WebDriver driver;

    public MergeAccountsBlockedErrorPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By pageHeader = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    private By invalidErrorHeader = By.xpath("//h4[@class='flexDiv']");
    private By invalidErrorText = By.xpath("//p[@class='notification-text mb-10 mt-10']");


    private String pageHeaderCL= "Leg Deine Kundenkonten zusammen";
    private String invalidErrorHeaderCL= "Das geht leider nicht";
    private String invalid2faTextCL= "Dein Zugang ist aus Sicherheitsgründen noch gesperrt. Die Sperrung dauert maximal 24 Stunden.";
    private String invalidBucTextCL= "Dein Zugang ist aus Sicherheitsgründen noch gesperrt. Die Sperrung dauert maximal 24 Stunden.";



    @Step("Check CL for invalid 2fa code error msg")
    public void verify2faBlockedError(){
        driver.verifyThat().element(invalidErrorHeader).text().isEqualTo(invalidErrorHeaderCL).perform();
        driver.verifyThat().element(invalidErrorText).text().isEqualTo(invalid2faTextCL).perform();
    }

    @Step("Check CL for invalid backup code error msg")
    public void verifyBucBlockedError(){
        driver.verifyThat().element(invalidErrorHeader).text().isEqualTo(invalidErrorHeaderCL).perform();
        driver.verifyThat().element(invalidErrorText).text().isEqualTo(invalidBucTextCL).perform();
    }

}
