package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class PhoneLineSettings {
    private SHAFT.GUI.WebDriver driver;
    //CLs
    private static String phoneLineExplainingText_Header_CL = "Ordne Deine Rufnummern den Leitungen zu";
    private static String phoneLineExplainingText_Footer_CL = "Du kannst pro Leitung 3 Rufnummern auswählen.";
    private static String mainNumberTextTitle_CL = "Wähl pro Leitung eine Hauptnummer";
    private static String mainNumberTextDescription_CL = "Die Hauptnummer ist die Rufnummer, die Deinem Gesprächspartner angezeigt wird. Du kannst pro Leitung nur eine Hauptnummer zuweisen.";
    private static String confirmationMessageTittle_CL = "Geschafft";
    private static String confirmationMessageDescription_CL="Deine Änderung wurde gespeichert. Es kann noch wenige Minuten dauern,  bis Du die Änderung siehst.";
    private static String errorMessageTittle_CL = "Das hat leider nicht geklappt";
    private static String errorMessageDescription_CL="Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";
    private static String numberOne_CL = "+498920939955";
    private static String numberTwo_CL = "+498920939922";
    private static String numberFour_CL = "+498920939912";


    //phone Line Setting Locators
    private static final By phoneLineExplainingText_Footer = By.xpath("//div[@automation-id='assignNumbers_tv']//p");
    private static final By phoneLineExplainingText_Header = By.xpath("//div[@automation-id='assignNumbers_tv']//h3");
    private static final By mainNumberTextTitle = By.xpath("//div[@automation-id='mainNumber_tv']//h3");
    private static final By mainNumberTextDescription = By.xpath("//div[@automation-id='mainNumber_tv']//p");
    private static final By radiobuttonOneForLineOne = By.xpath("//ol-radio[@automation-id='numberOne0_rb']//label[@for='numberOne0']");
    private static final By radiobuttonTwoForLineOne = By.xpath("//ol-radio[@automation-id='numberOne1_rb']//label[@for='numberOne1']");
    private static final By radiobuttonThreeForLineOne = By.xpath("//ol-radio[@automation-id='numberOne2_rb']//label[@for='numberOne2']");
    private static final By radiobuttonOneForLineTwo = By.xpath("//ol-radio[@automation-id='numberTwo0_rb']//label[@for='numberTwo0']");
    private static final By radiobuttonFourForLineTwo = By.xpath("//ol-radio[@automation-id='numberTwo3_rb']//label[@for='numberTwo3']");
    private static final By radiobuttonFiveForLineTwo = By.xpath("//ol-radio[@automation-id='numberTwo4_rb']//label[@for='numberTwo4']");
    private static final By radiobuttonSixForLineTwo = By.xpath("//ol-radio[@automation-id='numberTwo5_rb']//label[@for='numberTwo5']");
    private static final By dropDownListBtnForMultipleNumbersLineOne = By.xpath("//select[@automation-id='1_lv']");
    private static final By dropDownListBtnForMultipleNumbersLineTwo = By.xpath("//select[@automation-id='2_lv']");
    private static final By saveButton = By.xpath("//button[@automation-id='phoneLinesConfiguration_btn']");
    private static final By conformationMessageTittle = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private static final By conformationMessageDescription = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private static final By errorMessageTittle = By.xpath("//div[@automation-id='undefined_nt']//h4");
    private static final By errorMessageDescription = By.xpath("//div[@automation-id='undefined_nt']//p");
    private static final By dropDownListBtnForOneNumberLineOne = By.xpath("//div[@automation-id='lineOnePrimaryNum_tv']");
    private static final By dropDownListBtnForOneNumberLineTwo = By.xpath("//div[@automation-id='lineTwoPrimaryNum_tv']");


    //constructor
    public PhoneLineSettings(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Validate phone line setting page is displayed")
    public PhoneLineSettings validatePhoneLineSettingPage() {

        driver.assertThat()
                .element(phoneLineExplainingText_Header)
                .text()
                .contains(phoneLineExplainingText_Header_CL)
                .withCustomReportMessage("Validate phone line explaining text header")
                .perform();

        driver.assertThat()
                .element(phoneLineExplainingText_Footer)
                .text()
                .contains(phoneLineExplainingText_Footer_CL)
                .withCustomReportMessage("Validate phone line explaining text footer")
                .perform();

        driver.assertThat()
                .element(mainNumberTextTitle)
                .text()
                .contains(mainNumberTextTitle_CL)
                .withCustomReportMessage("Validate main number text title")
                .perform();

        driver.assertThat()
                .element(mainNumberTextDescription)
                .text()
                .contains(mainNumberTextDescription_CL)
                .withCustomReportMessage("Validate main number text description")
                .perform();

        return this;
    }
    //Validate change phoneline configuration settings with 3 numbers per line
   @Step("Select three numbers for line One.")
    public PhoneLineSettings selectThreeNumberForLineOne()
    {
        driver.element().click(radiobuttonOneForLineOne);
        driver.element().click(radiobuttonTwoForLineOne);
        driver.element().click(radiobuttonThreeForLineOne);
        return this;
    }
    @Step("Select three numbers for line Two.")
    public PhoneLineSettings selectThreeNumberForLineTwo()
    {
        driver.element().click(radiobuttonFourForLineTwo);
        driver.element().click(radiobuttonFiveForLineTwo);
        driver.element().click(radiobuttonSixForLineTwo);
        return this;
    }
    //Validate change phoneline configuration settings with only number per line.
    @Step("Select only one number for line one")
    public PhoneLineSettings selectOneNumberForLineOne()
    {
        driver.element().click(radiobuttonTwoForLineOne);
        return this;
    }
    @Step("Select only one number for line two")
    public PhoneLineSettings selectOneNumberForLineTwo()
    {
        driver.element().click(radiobuttonOneForLineTwo);
        return this;
    }
    @Step("Validate one number reflected in Drop Down List for line one")
    public PhoneLineSettings validateOneNumberReflectedForDDLLineOne() {
        driver.assertThat()
                .element(dropDownListBtnForOneNumberLineOne)
                .text()
                .contains(numberTwo_CL)
                .withCustomReportMessage("Validate number for line one in Drop Down List")
                .perform();
        return this;
    }
    @Step("Validate one number reflected in Drop down List for line Two")
    public PhoneLineSettings validateOneNumberReflectedInDDLLineTwo () {
        driver.assertThat()
                .element(dropDownListBtnForOneNumberLineTwo)
                .text()
                .contains(numberOne_CL)
                .withCustomReportMessage("Validate number for line Two in Drop Down List")
                .perform();
        return this;
    }

   // Validate change phoneline configuration settings with more than 3 numbers per line.

    @Step("Select Two Numbers For Line Two")
    public PhoneLineSettings selectNumbersForLineTwo()
    {
        driver.element().click(radiobuttonFourForLineTwo);
        driver.element().click(radiobuttonFiveForLineTwo);
        return this;
    }

    @Step("Validate that the numbers were chosen reflected in the drop-down list.")
    public PhoneLineSettings validateNumbersForDDLLineOne()
    {
        driver.assertThat()
                .element(dropDownListBtnForMultipleNumbersLineOne)
                .text()
                .contains(numberOne_CL)
                .withCustomReportMessage("Validate number one reflected in Drop Down List one")
                .perform();
        return this;
    }
    @Step("Validate that the numbers were chosen reflected in the drop-down list.")
    public PhoneLineSettings validateNumbersForDDLLineTwo() {
        driver.assertThat()
                .element(dropDownListBtnForMultipleNumbersLineTwo)
                .text()
                .contains(numberFour_CL)
                .withCustomReportMessage("Validate number four reflected in Drop Down List Two")
                .perform();
        return this;
    }

    @Step("Click On save Button")
    public PhoneLineSettings clickOnSaveButton()
    {
        driver.element().click(saveButton);
        return this;
    }
    @Step("Validate Conformation message for phone line")
    public PhoneLineSettings validateConformationMessage()
    {
        driver.assertThat()
                .element(conformationMessageTittle)
                .text()
                .contains(confirmationMessageTittle_CL)
                .withCustomReportMessage("Validate conformation message tittle Text")
                .perform();

        driver.assertThat()
                .element(conformationMessageDescription)
                .text()
                .contains(confirmationMessageDescription_CL)
                .withCustomReportMessage("Validate conformation message description Text")
                .perform();
        return this;
    }
    @Step("Validate Error message for phone line")
    public PhoneLineSettings validateErrorMessage()
    {
        driver.assertThat()
                .element(errorMessageTittle)
                .text()
                .contains(errorMessageTittle_CL)
                .withCustomReportMessage("Validate Error message tittle Text")
                .perform();

        driver.assertThat()
                .element(errorMessageDescription)
                .text()
                .contains(errorMessageDescription_CL)
                .withCustomReportMessage("Validate Error message description Text")
                .perform();
        return this;
    }

}
