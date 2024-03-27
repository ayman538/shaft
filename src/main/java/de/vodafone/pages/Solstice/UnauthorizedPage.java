package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class UnauthorizedPage {


    private SHAFT.GUI.WebDriver driver;

    public static By backBTN = By.xpath("//*[text()='Abbrechen']");
    public  static String backBTN_text ="Abbrechen";

    public static By pageHeader = By.xpath("//*[@automation-id='pageHeader_tv']");
    public  static String pageHeader_text ="Mein Tarif";

    public static By errorMsgHeader = By.xpath("//*[text()='Das geht leider nicht']");
    public static String errorMsgHeader_text ="Das geht leider nicht";

    public static By errorMsgBodybart = By.xpath("//*[text()='Du verwaltest aktuell keine Teilnehmer in MeinVodafone. Füg zuerst einen Teilnehmer hinzu und versuch es danach bitte nochmal.']");
    public static String errorMsgBodybart_text ="Du verwaltest aktuell keine Teilnehmer in MeinVodafone. Füg zuerst einen Teilnehmer hinzu und versuch es danach bitte nochmal.";

    public static By ctaBTN = By.xpath("//*[text()='Vertrag/Rufnummer hinzufügen']");
    public static String ctaBTN_text ="Vertrag/Rufnummer hinzufügen";

    public static By errorMsgBodyEmma = By.xpath("//*[text()='Füg zuerst Deinen Vertrag oder Teilnehmer in MeinVodafone hinzu. Versuch es danach bitte nochmal.']");
    public static String errorMsgBodyEmma_text ="Füg zuerst Deinen Vertrag oder Teilnehmer in MeinVodafone hinzu. Versuch es danach bitte nochmal.";


}


