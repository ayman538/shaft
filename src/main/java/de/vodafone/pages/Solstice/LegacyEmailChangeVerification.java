package de.vodafone.pages.Solstice;
import org.openqa.selenium.By;

public class LegacyEmailChangeVerification {
    public static By LECPageHeadline = By.xpath("(//*[@class='title-ecare overview']/div)/h1");
    public static final String LECPageHeadlineCL = "E-Mail-Adresse bestätigen";

    public static By LECConfNotHeadline = By.xpath("(//*[@class='alert-content'])[1]/div/div[2]/h4");
    public static final String LECConfNotHeadlineCL = "Vielen Dank!";

    public static By LECConfNotText = By.xpath("(//*[@class='alert-content'])[1]/p");
    public static final String LECConfNotTextCL = "Deine E-Mail-Adresse wurde bestätigt und wird ab sofort für MeinVodafone genutzt.";

    public static By LECConfSummaryHeader = By.xpath("//*[@class='ac-head ac-active']/span");
    public static final String LECConfSummaryHeaderCL = "Übersicht";

    public static By LECConfSummaryText = By.xpath("//*[@class='ac-body']/div/p[1]");
    public static final String LECConfSummaryTextCL = "Diese E-Mail-Adresse wurde für MeinVodafone bestätigt:";

    public static By LECConfSummaryEmail = By.xpath("//*[@class='ac-body']/div/p[2]/strong");
    public static final String LECConfSummaryEmailCL = "Kontakt-E-Mail:";

    public static By LECConfSummaryCTA = By.xpath("//*[@class='ac-body']/div/a");
    public static final String LECConfSummaryCTACL = "Weiter geht's";

}
