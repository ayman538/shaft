package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
public class MyTariffPage {
    SHAFT.GUI.WebDriver driver;
        public MyTariffPage(SHAFT.GUI.WebDriver driver)
        {this.driver=driver;}

        private By TariffPageContainerLocator = By.xpath("//*[@id='content']");
        private By MyTariffSOLocator = By.xpath("//*[@automation-id='cableIpTariffSO_so']");
        private By MyBookedOptionsLocator = By.xpath("//*[@automation-id='ipBookedTariffSO_so']");
        private By MyBookableInternetOptionsLocator = By.xpath("//*[@automation-id='bookableOptionsInternetSO_so']");
        private By MyBookablePhoneOptionsLocator = By.xpath("//*[@automation-id='bookableOptionsPhoneSO_so']");
        private By NoBookableInternetOptionLabelLocator = By.xpath("//*[@automation-id='internetBookableOption_nt']//h4");
        private By NoBookableInternetOptionTextLocator = By.xpath("//*[@automation-id='internetBookableOption_nt']//p");
        private By NoBookableInternetOptionCTALocator = By.xpath("//*[@automation-id='internetBookableOption_nt']//button");
        private By NoBookablePhoneOptionLabelLocator = By.xpath("//*[@automation-id='telephoneBookableOption_nt']//h4");
        private By NoBookablePhoneOptionTextLocator = By.xpath("//*[@automation-id='telephoneBookableOption_nt']//p");
        private By NoBookablePhoneOptionCTALocator = By.xpath("//*[@automation-id='telephoneBookableOption_nt']//button");
        private By NoBookedOptionsLabelLocator = By.xpath("//*[@automation-id='bookedTariffHeadline_tv']");
        private By NoBookedOptionsTextLocator = By.xpath("//*[@automation-id='bookedTariffSubHeadline_tv']");
        private By ExpandedMyTariffAccordionIndicator = By.xpath("(//a[@class='ac-head ac-active']//div//*[name()='svg'])[2]");
        private By MyTariffTitleSoLocator = By.xpath("//*[@automation-id='cableIpTariffSO_so']//h3");
        private By MyTariffTextSoLocator = By.xpath("(//*[@automation-id='tarifName_tv'])");
        private By MyTariffTitleAccLocator = By.xpath("//*[@automation-id='meinTarif_acc']//h4");
        private By MyTariffTextAccLocator = By.xpath("//*[@automation-id='meinTarif_acc']//h5");
        private By MyBookedOptionsTitleSoLocator = By.xpath("//*[@automation-id='ipBookedTariffSO_so']//h3");
        private By MyBookedOptionsTextSoLocator = By.xpath("(//*[@automation-id='ipBookedTariffSO_so']//div)[5]");
        private By MyBookedOptionsTitleAccLocator = By.xpath("//*[@automation-id='bookedTarif_acc']//h4");
        private By MyBookedOptionsTextAccLocator = By.xpath("//*[@automation-id='bookedTarif_acc']//h5");
        private By MyInternetBookableOptionsTitleSoLocator = By.xpath("//*[@automation-id='bookableOptionsInternetSO_so']//h3");
        private By MyInternetBookableOptionsTextSoLocator = By.xpath("(//*[@automation-id='bookableOptionsInternetSO_so']//div)[5]");
        private By MyInternetBookableOptionsTitleAccLocator = By.xpath("//*[@automation-id='internetBookableOptions_acc']//h4");
        private By MyInternetBookableOptionsTextAccLocator = By.xpath("//*[@automation-id='internetBookableOptions_acc']//h5");
        private By MyPhoneBookableOptionsTitleSoLocator = By.xpath("//*[@automation-id='bookableOptionsPhoneSO_so']//h3");
        private By MyPhoneBookableOptionsTextSoLocator = By.xpath("(//*[@automation-id='bookableOptionsPhoneSO_so']//div)[5]");
        private By MyPhoneBookableOptionsTitleAccLocator = By.xpath("//*[@automation-id='phoneBookableOptions_acc']//h4");
        private By MyPhoneBookableOptionsTextAccLocator = By.xpath("//*[@automation-id='phoneBookableOptions_acc']//h5");
        private By NoBookedOptionHeadline = By.xpath("//*[@automation-id='noBookedOptions_nt']//h4");
        private By NoBookedOptionSubLine = By.xpath("//*[@automation-id='noBookedOptions_nt']//p");

        private String MyBookableInternetOptionsTextCL = "Geh bitte zu MeinKabel. Dort kannst Du die Optionen für Deinen Internet-Tarif buchen.";
        private String MyBookablePhoneOptionsTextCL = "Geh bitte zu MeinKabel. Dort kannst Du die Optionen für Deinen Telefon-Tarif buchen.";
        private String NoBookableOptionLabelCL = "Keine Optionen gebucht";
        private String NoBookableInternetOptionTextCL = "Geh bitte zu MeinKabel. Dort kannst Du die Optionen für Deinen Internet-Tarif buchen.";
        private String NoBookableOptionCTACL = "Zu MeinKabel";
        private String NoBookablePhoneOptionTextCL = "Geh bitte zu MeinKabel. Dort kannst Du die Optionen für Deinen Telefon-Tarif buchen.";
        private String NoBookedOptionsLabelCL = "Option dazubuchen";
        private String NoBookedOptionsTextCL = "Geh bitte zu MeinKabel. Dort kannst Du die Optionen für Deinen Internet-Tarif buchen.";
        private String MyTariffTitleCL = "Mein Tarif";
        private String MyTariffTextSoCL = "Red Internet & Phone 250 Cable";
        private String MyTariffTextAccCL = "Laufzeit und Vertragsverlängerung";
        private String MyBookedOptionsTitleCL = "Gebuchte Optionen";
        private String MyBookedOptionsTextSoCL = "Alle gebuchten Tarifoptionen";
        private String MyBookedOptionsTextAccCL = "Ansehen und bearbeiten";
        private String MyInternetBookableOptionsTitleCL = "Buchbare Optionen Internet";
        private String MyInternetBookableOptionsTextCL = "Alle buchbaren Optionen für meinen Internet-Tarif";
        private String MyPhoneBookableOptionsTitleCL = "Buchbare Optionen Telefon";
        private String MyPhoneBookableOptionsTextCL = "Alle buchbaren Optionen für meinen Telefon-Tarif";
    @Step("Check my tariff accordion is collapsed")
        public MyTariffPage validateMyTariffAccIsCollapsed()
        {
            driver.assertThat()
                    .element( MyTariffTitleSoLocator)
                    .text().contains(MyTariffTitleCL).perform();
            driver.assertThat()
                    .element( MyTariffTextSoLocator)
                    .text().contains(MyTariffTextSoCL).perform();
            driver.assertThat()
                    .element( ExpandedMyTariffAccordionIndicator)
                    .doesNotExist().perform();
            return this;
        }
        @Step("Check my booked options accordion is collapsed")
        public MyTariffPage validateMyBookedOptionsAccIsCollapsed()
        {
            driver.assertThat()
                    .element( MyBookedOptionsTitleSoLocator)
                    .text().contains(MyBookedOptionsTitleCL).perform();
            driver.assertThat()
                    .element( MyBookedOptionsTextSoLocator)
                    .text().contains(MyBookedOptionsTextSoCL).perform();
            driver.assertThat()
                    .element( TariffPageContainerLocator)
                    .text().doesNotContain(NoBookedOptionsLabelCL).perform();
            return this;
        }
        @Step("Click my booked options SO")
        public MyTariffPage clickBookedOptionsSO()
        {
            driver.element().click(MyBookedOptionsLocator);
            return this;
        }
        @Step("Check my booked options accordion is expanded")
        public MyTariffPage validateMyBookedOptionsAccIsExpanded()
        {
            driver.assertThat()
                    .element( MyBookedOptionsTitleAccLocator)
                    .text().contains(MyBookedOptionsTitleCL).perform();
            driver.assertThat()
                    .element( MyBookedOptionsTextAccLocator)
                    .text().contains(MyBookedOptionsTextAccCL).perform();
            driver.assertThat()
                    .element( TariffPageContainerLocator)
                    .text().doesNotContain(ExpandedMyTariffAccordionIndicator).perform();
//            driver.assertThat()
//                    .element( TariffPageContainerLocator)
//                    .text().contains(NoBookedOptionsLabelCL).perform();
            driver.assertThat()
                    .element( TariffPageContainerLocator)
                    .text().doesNotContain(MyBookableInternetOptionsTextCL).perform();
            driver.assertThat()
                    .element( TariffPageContainerLocator)
                    .text().doesNotContain(MyBookablePhoneOptionsTextCL).perform();
            return this;
        }

        @Step("Check my bookable internet options accordion is collapsed")
        public MyTariffPage validateMyBookableInternetOptionsAccIsCollapsed()
        {
            driver.assertThat()
                    .element( MyInternetBookableOptionsTitleSoLocator)
                    .text().contains(MyInternetBookableOptionsTitleCL).perform();
            driver.assertThat()
                    .element( MyInternetBookableOptionsTextSoLocator)
                    .text().contains(MyInternetBookableOptionsTextCL).perform();
            driver.assertThat()
                    .element( TariffPageContainerLocator)
                    .text().doesNotContain(MyBookableInternetOptionsTextCL).perform();
            return this;
        }
        @Step("Click bookable internet options options SO")
        public MyTariffPage clickBookableInternetOptionsSO()
        {
            driver.element().click(MyBookableInternetOptionsLocator);
            return this;
        }
        @Step("Check my bookable internet options accordion is expanded")
        public MyTariffPage validateMyBookableInternetOptionsAccIsExpanded()
        {
            driver.assertThat()
                    .element( MyInternetBookableOptionsTitleAccLocator)
                    .text().contains(MyInternetBookableOptionsTitleCL).perform();
            driver.assertThat()
                    .element( MyInternetBookableOptionsTextAccLocator)
                    .text().contains(MyInternetBookableOptionsTextCL).perform();
            driver.assertThat()
                    .element( TariffPageContainerLocator)
                    .text().doesNotContain(ExpandedMyTariffAccordionIndicator).perform();
            driver.assertThat()
                    .element( TariffPageContainerLocator)
                    .text().doesNotContain(NoBookedOptionsLabelCL).perform();
            driver.assertThat()
                    .element( TariffPageContainerLocator)
                    .text().contains(MyBookableInternetOptionsTextCL).perform();
            driver.assertThat()
                    .element( TariffPageContainerLocator)
                    .text().doesNotContain(MyBookablePhoneOptionsTextCL).perform();
            return this;
        }

        @Step("Check my bookable phone options accordion is collapsed")
        public MyTariffPage validateMyBookablePhoneOptionsAccIsCollapsed()
        {
            driver.assertThat()
                    .element( MyPhoneBookableOptionsTitleSoLocator)
                    .text().contains(MyPhoneBookableOptionsTitleCL).perform();
            driver.assertThat()
                    .element( MyPhoneBookableOptionsTextSoLocator)
                    .text().contains(MyPhoneBookableOptionsTextCL).perform();
            driver.assertThat()
                    .element( TariffPageContainerLocator)
                    .text().doesNotContain(MyBookablePhoneOptionsTextCL).perform();
            return this;
        }
        @Step("Click bookable phone options options SO")
        public MyTariffPage clickBookablePhoneOptionsSO()
        {
            driver.element().click(MyBookablePhoneOptionsLocator);
            return this;
        }
        @Step("Check my bookable phone options accordion is expanded")
        public MyTariffPage validateMyBookablePhoneOptionsAccIsExpanded()
        {
            driver.assertThat()
                    .element( MyPhoneBookableOptionsTitleAccLocator)
                    .text().contains(MyPhoneBookableOptionsTitleCL).perform();
            driver.assertThat()
                    .element( MyPhoneBookableOptionsTextAccLocator)
                    .text().contains(MyPhoneBookableOptionsTextCL).perform();
            driver.assertThat()
                    .element( TariffPageContainerLocator)
                    .text().doesNotContain(ExpandedMyTariffAccordionIndicator).perform();
            driver.assertThat()
                    .element( TariffPageContainerLocator)
                    .text().doesNotContain(NoBookedOptionsLabelCL).perform();
            driver.assertThat()
                    .element( TariffPageContainerLocator)
                    .text().doesNotContain(MyBookableInternetOptionsTextCL).perform();
            driver.assertThat()
                    .element( TariffPageContainerLocator)
                    .text().contains(MyBookablePhoneOptionsTextCL).perform();
            return this;
        }


        @Step("Validate no bookable internet options message")
        public MyTariffPage validateNoBookableInternetOptionMsg()
        {
            driver.assertThat()
                    .element( NoBookableInternetOptionLabelLocator)
                    .text().isEqualTo(NoBookableOptionLabelCL).perform();
            driver.assertThat()
                    .element( NoBookableInternetOptionTextLocator)
                    .text().isEqualTo(NoBookableInternetOptionTextCL).perform();
            driver.assertThat()
                    .element( NoBookableInternetOptionCTALocator)
                    .text().isEqualTo(NoBookableOptionCTACL).perform();
            return this;
        }

        @Step("Validate no bookable phone options message")
        public MyTariffPage validateNoBookablePhoneOptionMsg()
        {
            driver.assertThat()
                    .element( NoBookablePhoneOptionLabelLocator)
                    .text().isEqualTo(NoBookableOptionLabelCL).perform();
            driver.assertThat()
                    .element( NoBookablePhoneOptionTextLocator)
                    .text().isEqualTo(NoBookablePhoneOptionTextCL).perform();
            driver.assertThat()
                    .element( NoBookablePhoneOptionCTALocator)
                    .text().isEqualTo(NoBookableOptionCTACL).perform();
            return this;
        }

        @Step("Validate no booked options message")
        public MyTariffPage validateNoBookedOptionMsg()
        {
            driver.assertThat()
                    .element(NoBookedOptionHeadline)
                    .text().isEqualTo(NoBookedOptionsLabelCL).perform();
            driver.assertThat()
                    .element(NoBookedOptionSubLine)
                    .text().isEqualTo(NoBookedOptionsTextCL).perform();
            return this;
        }
}
