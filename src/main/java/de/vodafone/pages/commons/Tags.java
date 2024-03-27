package de.vodafone.pages.commons;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class Tags {
    private SHAFT.GUI.WebDriver driver;
    public Tags(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Download Bill By Locator")
    public void downloadBillWithoutFrames(By downloadLocator){
        String downloadPath = "src/test/resources/TestDataFiles/target/downloadedFiles";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("downloadPath=" + downloadPath);
        driver.element().click(downloadLocator);
    }

    public void assertOnSiteStructure(String expectedResult){
        assertOnTag("pageview","siteStructure",expectedResult);
    }

    public void assertOnDownloadName(String expectedResult){
        assertOnTag("ebpa download","name",expectedResult);
    }

    public void assertOnNotificationArea(String expectedResult){
        assertOnTag("notification","notification_area",expectedResult);
    }

    public void assertOnNotificationAction(String expectedResult){
        assertOnTag("notification","notification_action",expectedResult);
    }

    public void assertOnNotificationType(String expectedResult){
        assertOnTag("notification","notification_type",expectedResult);
    }

    public void assertOnNotificationMessage(String expectedResult){
        assertOnTag("notification","notification_message",expectedResult);
    }

    public void assertOnErrorArea(String expectedResult){
        assertOnTag("error","error_area",expectedResult);
    }

    public void assertOnErrorMessage(String expectedResult){
        assertOnTag("error","error_message",expectedResult);
    }

    public void assertOnErrorCode(String expectedResult){
        assertOnTag("error","error_code",expectedResult);
    }
    public void assertOnErrorType(String expectedResult){
        assertOnTag("error","error_type",expectedResult);
    }
    public void assertOnErrorAction(String expectedResult){
        assertOnTag("error","error_action",expectedResult);
    }
    public void assertOnErrorDetails(String expectedResult){
        assertOnTag("error","error_details",expectedResult);
    }


    public void assertOnoFormName(String expectedResult){
        assertOnTag("pageview","oForm.name",expectedResult);
    }
    public void assertOnOFormTagging(String expectedResult){
        assertOnTag("pageview","oForm",expectedResult);
    }


    public void assertOnoFormStatus(String expectedResult){
        assertOnTag("pageview","oForm.formStatus",expectedResult);
    }
    public void assertOnoApplicationType(String expectedResult){
        assertOnTag("pageview","oForm.oApplication.type",expectedResult);
    }
    public void assertOnoApplicationName(String expectedResult){
        assertOnTag("pageview","oForm.oApplication.name",expectedResult);
    }
    public void assertOnSiteArea(String expectedResult){
        assertOnTag("pageview","siteArea",expectedResult);
    }
    public void assertOnLoginStatus(String expectedResult){
        assertOnTag("pageview","loginStatus",expectedResult);
    }
    public void assertOnPageType(String expectedResult){
        assertOnTag("pageview","pageType",expectedResult);
    }
    public void assertOnPlatformType(String expectedResult){
        assertOnTag("pageview","platformType",expectedResult);
    }
    public void assertOnVisitorSubscription(String expectedResult){
        assertOnTag("pageview","visitorSubscription",expectedResult);
    }
    public void assertOnVisitorType(String expectedResult){
        assertOnTag("pageview","visitorType",expectedResult);
    }

    public void assertOnoFormType(String expectedResult){
        assertOnTag("pageview","oForm.type",expectedResult);
    }
    public void assertOnoFormOutcome(String expectedResult){
        assertOnTag("pageview","oForm.outcome",expectedResult);
    }
    public void assertOnoFormStep(String expectedResult){
        assertOnTag("pageview","oForm.formStep",expectedResult);
    }

    public void assertOnoFormStepName(String expectedResult){
        assertOnTag("pageview","oForm.formStepName",expectedResult);
    }

    public void assertOnaPropositionsName(String expectedResult){
        assertOnTag("pageview","oOrder.aPropositions[0].name",expectedResult);
    }

    public void assertOnaProductsPriceOnce(String expectedResult){
        assertOnTag("pageview","oOrder.aProducts[0].priceOnce",expectedResult);
    }


    public void assertOnoFormObject(String expectedResult){
        assertOnCompleteTag("pageview","oForm", expectedResult);
    }

    public void assertOnInformationTag(String expectedResult){
        assertOnCompleteTag("information", expectedResult);
    }

    public void assertOnTag(String tagName , String valueJsonPath , String expectedResult) {
        String value = null;
        JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
        var time = System.currentTimeMillis() + 60000;

        while (value == null && System.currentTimeMillis() < time) {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
            }

            js.executeScript("console.clear()");
            js.executeScript("for(x of window._ddq.history){if(x[0]=='"+tagName+"'){console.log('result ='+ x[1]."+valueJsonPath+")}}");

            LogEntries logs = driver.getDriver().manage().logs().get(LogType.BROWSER);

            for (LogEntry log : logs) {
                if (log.getMessage().contains("result =")) {
                    String result = log.getMessage();
                    value = result.substring(result.indexOf("=") + 1).replace("\"", "");
                }
            }
        }
        Validations.verifyThat().object(value).isEqualTo(expectedResult).withCustomReportMessage("Assert on "+valueJsonPath+" tag").perform();
    }

    public void assertOnCompleteTag(String tagName , String expectedResult) {
        String value = null;
        JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
        var time = System.currentTimeMillis() + 60000;

        while (value == null && System.currentTimeMillis() < time) {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
            }

            js.executeScript("console.clear()");
            js.executeScript("for(x of window._ddq.history){if(x[0]=='"+tagName+"'){console.log('result ='+ JSON.stringify(x[1]))}}");

            LogEntries logs = driver.getDriver().manage().logs().get(LogType.BROWSER);

            for (LogEntry log : logs) {
                if (log.getMessage().contains("result =")) {
                    String result = log.getMessage();
                    value = result.substring(result.indexOf("=") + 1).replace("\"", "").replace("\\", "");
                }
            }
        }
        Validations.verifyThat().object(value).isEqualTo(expectedResult).withCustomReportMessage("Assert on "+tagName+" tag").perform();
    }

    public void assertOnCompleteTag(String tagName , String objectJsonPath , String expectedResult) {
        String value = null;
        JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
        var time = System.currentTimeMillis() + 60000;

        while (value == null && System.currentTimeMillis() < time) {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
            }

            js.executeScript("console.clear()");
            js.executeScript("for(x of window._ddq.history){if(x[0]=='"+tagName+"'){console.log('result ='+ JSON.stringify(x[1]."+objectJsonPath+"))}}");

            LogEntries logs = driver.getDriver().manage().logs().get(LogType.BROWSER);

            for (LogEntry log : logs) {
                if (log.getMessage().contains("result =")) {
                    String result = log.getMessage();
                    value = result.substring(result.indexOf("=") + 1).replace("\"", "").replace("\\", "");
                }
            }
        }
        Validations.verifyThat().object(value).isEqualTo(expectedResult).withCustomReportMessage("Assert on "+objectJsonPath+" tag").perform();
    }



    public void assertOnDownloadTags(String nameAttributeValue,String typeAttributeValue){
        assertOnTag("ebpa download","name",nameAttributeValue);
        assertOnTag("ebpa download","type",typeAttributeValue);
    }

    public void assertOnClickTags(String nameAttributeValue,String infoAttributeValue){
        assertOnTag("ebpa click","name",nameAttributeValue);
        assertOnTag("ebpa click","info",infoAttributeValue);
    }

}
