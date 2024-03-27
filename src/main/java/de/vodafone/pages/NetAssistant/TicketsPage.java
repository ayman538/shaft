package de.vodafone.pages.NetAssistant;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;


public class TicketsPage {
    // Variables
    private SHAFT.GUI.WebDriver driver;

    private final String youtube_Button_Link = "https://www.youtube.com/watch?v=nZYi2WJtwz4";
    //Locator
    private static By technician_Appointment_All_Tickets = By.xpath("//*[@automation-id='openticketStatusTextText_tv']");

    By More_Info_Selection;
    private static By technician_Appointment_Selection;
    private static String technician_Appointment_Text_Colour;
    private static int technician_Appointment_Count;
    private static int ticketWithTechAppointmentNumber;

    private static By youtubeLogoIcon = By.xpath("(//yt-icon[@id='logo-icon'])[1]");
    private static By go_On_Button = By.xpath("//*[@id='chatbot-container']/app-user[1]/div/div[3]/app-button/div");
    private static By go_On_ButtonDSL = By.xpath("//app-ticket-details//app-button/div/div[1]");
    private static By Problem_Still_Exists_Button = By.xpath("//*[@id='chatbot-container']/app-user[3]/div/div[3]/app-button/div/div[1]");
    private static By Contact_Number_Text_Field = By.xpath("//*[@automation-id='SL13287254544627181_13019_et']");
    private static By Problem_Description_Text_Field = By.xpath("//*[@formarrayname='formArray'][2]//*[@id='SL13287254544627181_13019']");

    private static By Ready_Button =  By.xpath("//*[@id='chatbot-container']/app-user[4]/div/div[3]/app-formular-answer/div/form/div[3]/div/button");
    private static By Ja_Button =     By.xpath("//*[@class='button-wrapper button-wrapper-only' and contains(.,'Ja')]");
    private static By refresh_Button= By.xpath("//*[@class='button-wrapper button-wrapper-only fixed-height' and contains(.,' Neu starten')]");

    private static By Ticket_Details_Title = By.xpath("//*[@id='tickets-container']/app-tickets-list/div/div/div/div[3]/div[2]/div[1]/span[1]");
    private static By Ticket_Creation_Date = By.xpath("//div[@class='mt-5'][1]//span[@class='ticket-title']");

    private static By Ticket_Number = By.xpath("//*[@automation-id='openticketNumber_title']");

    private static By ticketNumber = By.xpath("//div[@class='mt-5'][2]//span[@class='ticket-title']");
    private static By ticket_status_description = By.xpath("//div[@class='mt-5'][3]//span[@class='ticket-title']");
    private static By ticket_title = By.xpath("//*[@automation-id='openticketTitle_title']");

    // More Info Button
    private static By more_Info_Button = By.xpath("//*[@automation-id='ticketDetails_btn']");
    private static By more_Info_Button_Closed_Tickets = By.xpath("//*[@automation-id='closeticketsContainer_tv']//*[@automation-id='ticketDetails_btn']");

    private static By ticket_Previous_Steps_Accordion = By.xpath("//span[@class='brix-accordion-item__label ticket-style']");

    private static By Current_Ticket_Status = By.xpath("//*[@class='ticket-details-container']/div[@class='ticket-sub-title']");
    private static By ticketStatus = By.xpath("(//span[@class='ticket-style'])[4]");

    private static By ticket_Previous_Steps_Icon = By.xpath("//span[@class='brix-accordion-item__chevron brix-icon brix-icon--chevron-red']");

    private static By ticketExpandedPreviousStepsIcon = By.xpath("//span[@class='brix-accordion-item__chevron brix-icon brix-icon--chevron---red']");

    // accept and decline cookies buttons
    private static By accept_Cookies_button=By.xpath("//button//span[contains(text(),' ablehnen')]");
    private static By decline_Cookies_button=By.xpath("//*[@id='kplDeclineButton']");

    // Reopen and Close Tickets Action Buttons
    private static By reopen_Ticket_Button = By.xpath("//app-ticket-details/div/div/div[3]/button/span");
    private static By close_ticket_button = By.xpath("//button[@class='toggle-ticket-button toggle-ticket-button-cancelable']");
    private static By resolved_Ticket_Status = By.xpath("//*[@automation-id='openticketStatus_title'][contains(text(),'Gelöst')]");

    //Ticket Details Status for open tickets
    private static By ticket_Details_Status = By.xpath("//app-ticket-details/div/div/div[3]/div[4]/div/span[2]");
    private static By resolved_Ticket_Details_Status = By.xpath("//*[@automation-id='ticketStatus_title_tv'][contains(text(),'Gelöst')]");
    private static By inprogress_Ticket_Details_Status = By.xpath("//*[@automation-id='ticketStatus_title_tv'][contains(text(),'In Arbeit')]");

    // Tickets Status in Tickets List
    private static By inprogress_Ticket_Status = By.xpath("//*[@automation-id='openticketStatus_title'][contains(text(),'In Arbeit')]");
    private static By closed_Ticket_Status =     By.xpath("//*[@automation-id='closeticketStatus_title']");

    private static By ticket_Details_Status_Bar = By.xpath("//*[@id='tickets-container']/app-ticket-details/div/div/div[3]/div[4]/progress-bar/div");
    private static By tickets_List_Status_Bar= By.xpath("(//*[@automation-id='openticketProgressbar_tv'][1])");

    private static By reopen_form_question = By.xpath("//*[@id='chatbot-container']/app-system/div/div[2]/div/p");
    private static By technicianAppointment = By.xpath("(//*[@automation-id='openTicketStatusText_tv'])[1]");
    private static By technicianAppointmentDetails = By.xpath("//*[@automation-id='openTicketStatusText_tv']");
    private static By tickets_Error_Message = By.xpath("//*[@id='tickets-container']/system-info-message/div/div");

    //Headers for Net Assistant Tabs
    private static By chatbot_Tab_Header = By.xpath("//*[@id='chatBot']");
    private static By tickets_Tab_Header = By.xpath("//*[@id='tickets']");

    // Hello Message at Start of Tickets Page
    private static By tickets_Hello_Message = By.xpath("//p[@automation-id='undefined_tv']");

    // Load More Tickets Button for Closed Tickets
    private static By expand_Closed_Tickets_Button =By.xpath("//*[@automation-id='toggleCloseTickets_Tb']");

    // Back Button in Ticket Details Page
    private static By back_button = By.xpath("//app-ticket-details/div/div/div[4]");

    // Change Appointment Button in Ticket Details Page
    private static By change_Appointment_Button = By.xpath("//*[@id='tickets-container']/app-ticket-details/div/div/div[3]/div[6]/div[3]/button/span");

    // Manage Technician Appointment
    private static By Technician_Appointment_Label = By.xpath("//*[@automation-id='openticketStatusTextText_tv']");
    private static By Ticket_Has_Technician_Appointment = By.xpath("//*[@automation-id='openTicketStatusTextText_tv']");
    private static By Ticket_Has_NO_Technician_Appointment = By.xpath("(//div[@class='ticket-details-container'])[2]");
    private static By More_Info_Button_With_Technician_Appointment = By.xpath("(//*[@automation-id='ticketDetails_btn'][1])");
    private static By Technician_Appointment_Manage_Label_In_Ticket_Details = By.xpath("//*[@automation-id='technicianAppointmentReschedule_tv']");
    private static By Technician_Appointment_Set_Label_In_Ticket_Details = By.xpath("//*[@automation-id='technicianAppointmentSet_tv']");
    private static By Technician_Appointment_Manage_Label_In_Ticket_DetailsDSL = By.xpath("//*[@automation-id='openTicketStatusText_tv']");
    private static By Technician_Appointment_Set_Label_In_Ticket_DetailsDSL = By.xpath("//*[@automation-id='openTicketStatusText_tv']");
    private static By Technician_Appointment_Reschedule_Button= By.xpath("//*[@automation-id='technicianAppointmentReschedule_btn']");
    private static By Technician_Appointment_Set_Button= By.xpath("//*[@automation-id='technicianAppointmentSet_btn']");

    private static By details_header_gelost = By.xpath("//*[@id='tickets-container']/app-ticket-details/div/div/div[3]/div[4]/div[1]");
    private static By errorMsgButtonToken = By.xpath("//app-general-error/div/div[2]/div/div");
    private static By errorMsgIconToken = By.xpath("//app-general-error/div/div[1]");
    private static By errorMsgTextStrongToken = By.xpath("//app-general-error/div/div[2]/strong");
    private static By errorMsgTextPToken2 = By.xpath("//app-general-error/div/div[2]/p");
    private static By errorMsgTextPToken = By.xpath("//app-general-error/div/div[2]/p");
    private static By vodafone_icon = By.xpath("//*[@id='top']/div/header/nav/div/div/div/div/div/a");
    private static By meinvodafone_icon = By.xpath("//*[@id='top']/div/header/nav/div/div[2]/div/div/ul[2]/li[2]/a/span[1]");

    private static By Tobi_Tickets_Icon = By.xpath("//*[@id='tickets-container']/app-tickets-list/app-system/div/div[1]");
    public static By reschedule_Button_Ticket_Details = By.xpath("//*[@id='chatbot-container']/app-user[2]/div/div[3]/app-button/div/div[2]/span");
    public static By fourth_Slot = By.xpath("//*[@id='chatbot-container']/app-user[3]/div/div[3]/app-button/div/div[1]");
    public static By Calendar = By.xpath("//*[@id='chatbot-container']/app-user[4]/div/div[3]");
    public static By CalendarDSL = By.xpath("//*[@id='option-picker--item--09:00-09:59 Uhr06.02.2023-1']");
    public static By track_My_Techie_Button = By.xpath("//*[@class='ticket-details-button mt-20']//*[text()=' Jetzt Technik-Service verfolgen ']");
    public static By track_Technician_ArrivalText = By.xpath("//div[@class='ws10-info-overlay__container--subTitle ws10-info-overlay__infoText']");
    public static By tickets_list_Title = By.xpath("//*[@automation-id='openticketHeader_title']");


    private static By ticketHistoryAccordion = By.xpath("//*[@id='tickets-container']/app-ticket-details/div/div/div[3]/div[6]");
    private static By getTicketHistoryListLog = By.xpath("(//div[@class='brix-timestamp-list__headline'])");
    public static By YoutubeButton = By.xpath("//*[@automation-id='ticketWatchYoutubeVideo_btn']");
    private static By ticketDetailsHeader = By.xpath("//div[@class='ticket-header']");
    private static By ticketReOpenBtnDecisionTree = By.xpath("//*[@id='chatbot-container']/app-user[2]/div/div[3]/app-button/div/div[3]");
    private static By ticketDetailsTitle = By.xpath("//*[@id='tickets-container']/app-ticket-details/div/div/div[2]");
    private static By warningMessage = By.xpath("//*[@automation-id='undefined_nt']");
    private static By status (int index) {return By.xpath("(//*[@automation-id='openticketStatus_title'][1])" + "[" + index + "]");}
    private static By technicianAppointmentSelection(int index)  {return By.xpath("(//*[@automation-id='openticketStatusTextText_tv'])" + "[" + index + "]");}
    private static By appointmentIndex(int index)  {return By.xpath("(//*[@automation-id='openticketStatusTextText_tv'])[" + index + "]");}
    private static By moreInfoSelection(int index) {return By.xpath("(//*[@automation-id='ticketDetails_btn'][1])" + "[" + index + "]");}
    private static By ticketsLogoutButton= By.xpath("//*[@id='logout']");
    private static By ticketsImage = By.xpath("//img[@automation-id='undefined_img']");
    private static By welcomeMsg = By.xpath("(//*[@automation-id='undefined_tv'])[1]");
    private static By fehlersucheStartenBtn = By.xpath("//button[@automation-id='netAssistantStart_btn']");
    private static By netzAssistentBtn = By.xpath("//button[@automation-id='ticketsEndMessage_btn']");
    private static By ticketsListMsg = By.xpath("(//p[@automation-id='undefined_tv'])[2]");
    private static By ticketsListEndMsg = By.xpath("//p[@automation-id='ticketsEndMessageText_tv']");

    //CLs
    public static String tickets_list_Title_CL = "Deine offenen Störungstickets";
    private static String back_button_CL = "Zurück zur Übersicht";
    private static String errorMsgTextStrongTokenCL = "Das hat leider nicht geklappt";
    private static String errorMsgTextPToken2CL = "For technical reasons, the link is not available anymore.";
    private static String errorMsgButtonTokenCL = "Zum Netz-Assistenten";
    private static String trackMyTechieButtonCL = "Jetzt Technik-Service verfolgen";
    private static String technicianAppointmentCL = "Der Technik-Service kommt am";
    private static String technicianAppointmentDetailsCL = "Damit wir die Störung beheben können, haben wir einen Service-Techniker für Dich beauftragt.";
    private static String warningMessageHeaderCL = "Hier stimmt was nicht";
    private static String welcomeMsgNewCL = "Hallo, hier siehst Du Deine Tickets!";
    private static String tokenErrorMsgCL="Aber ein Klick auf den Button bringt Dich weiter.";

    private static String setTechnicinanAppointmentCLDSL = "Vereinbaren Sie bitte einen Termin mit unserem Service-Techniker. Nur so können wir die Störung beheben.";
    private static String setTechnicinanAppointmentCLUM = "Mach bitte einen Termin mit dem Technik-Service";
    private static String setTechnicinanAppointmentDetailsCLUM = "Wähl Deinen Technik-Service-Termin";
    private static String setTechnicinanAppointmentDetailsCLDSL = "Vereinbaren Sie bitte einen Termin mit unserem Service-Techniker. Nur so können wir die Störung beheben.";
    private static String reOpenButtonCL = "Ticket wieder öffnen";
    private static String refreshButtonCL = "Neu starten";
    private static String inProgressTicketCL = "In Arbeit";
    private static String closedTicketsCL = "Gelöst";
    private static String ticketsPageHelloMsgCL = "Hallo";
    private static String ticketsErrorMsgCL = "Wir können Deine Kundendaten nicht identifizieren. Starte bitte den Netz-Assistenten über diesen Link nochmal neu.";
    private static String ticketAppointmentCL = "Mach bitte einen Termin mit dem Technik-Service";
    private static String setAppointmentButtonCL = "Wähl Deinen Technik-Service-Termin";
    private static String ticketsListMsgCableUMCL = "Du hast eine Internet-Störung? Dann geh mit dem Netz-Assistenten auf Fehlersuche.";

    private static String ticketsListMsgDSLCL = "Du hast eine Internet-Störung oder eine Festnetz-Telefonie-Störung? Dann geh mit dem Netz-Assistenten auf Fehlersuche.";
    private static String ticketsListNetAssistentClickedMsgCL = "Schade. Komm gerne später wieder. Dann starten wir zusammen die Problemlösung.";

    //constructor
    public TicketsPage(SHAFT.GUI.WebDriver driver)
    {
        this.driver=driver;
    }

    //Getters
    public static By get_Tobi_Clock_Icon(){ return Tobi_Tickets_Icon; }

    public static By getMeinvodafone_icon(){return meinvodafone_icon;}
    public static By getVodafone_icon(){return vodafone_icon;}
    public static By getError_msg_button_token(){return errorMsgButtonToken;}
    public static By getErrorMsgTextStrongToken() {
        return errorMsgTextStrongToken;
    }

    public static By getErrorMsgTextPToken2()
    {
        return errorMsgTextPToken2;
    }

    public static By getErrorMsgTextPToken() {
        return errorMsgTextPToken;
    }

    public static By getErrorMsgButtonToken() {
        return errorMsgButtonToken;
    }

    public static By getDetails_header_gelost() {
        return details_header_gelost;
    }
    public static By getMore_info_btn_closed (){return more_Info_Button;}
    public static By get_Expand_Closed_Tickets(){return expand_Closed_Tickets_Button;}

    public static By getOpenTicketDetailsInfoButtonText() {
        return More_Info_Button_With_Technician_Appointment;
    }


    public static By getStatus() {
        return ticketStatus;
    }
    public static By get_Icon() {
        return ticket_Previous_Steps_Icon;
    }

    public static By getPreviousStepsGreenIcon() {
        return ticketExpandedPreviousStepsIcon;
    }
    public static By get_Ticket_Previous_Steps_Accordion() {
        return ticket_Previous_Steps_Accordion;
    }

    public static By getInprogressTicketStatus() {
        return inprogress_Ticket_Status;
    }

    public static By getResolvedTicketStatus() {
        return resolved_Ticket_Status;
    }

    public static By get_Closed_Ticket_Status() {
        return closed_Ticket_Status;
    }

    public static By get_Reopen_Ticket_Button() {
        return reopen_Ticket_Button;
    }

    public static By get_Close_Ticket_Button() {
        return close_ticket_button;
    }

    public static By get_Ticket_Details_Status() {
        return ticket_Details_Status;
    }

    public static By get_Ticket_Details_Status_Bar() {
        return ticket_Details_Status_Bar;
    }

    public static By getStatus_bar_inprogress_tcktlst() {
        return tickets_List_Status_Bar;
    }

    public static By get_ticket_status_description() {
        return ticket_status_description;
    }

    public static By getTicket_tittle() {
        return ticket_title;
    }

    public static By getReopen_form_question() {
        return reopen_form_question;
    }

    public static By get_Go_On_Button() {
        return go_On_Button;
    }

    public static By get_Go_On_Button_DSL() {
        return go_On_ButtonDSL;
    }

    public static By get_Ja_Button() {
        return Ja_Button;
    }
    public static By get_Refresh_Button(){
        return refresh_Button;
    }
    public static By get_Ticket_Details_Ticket_Title(){ return Ticket_Details_Title; }
    public static By get_Ticket_Creation_Date(){
        return Ticket_Creation_Date;
    }
    public static By get_Ticket_Number(){
        return Ticket_Number;
    }

    public static By getTicketNumber() {
        return ticketNumber;
    }

    public static By get_Status_Bar() {
        return ticket_Details_Status_Bar;
    }

    public static By get_Current_Ticket_Status() {
        return Current_Ticket_Status;
    }
    public static By getTechnicianAppointment() { return technicianAppointment; }
    public static By getTechnicianAppointmentDetails() { return technicianAppointmentDetails; }
    public static By get_Tickets_Error_Message() {
        return tickets_Error_Message;
    }
    public static By get_Chatbot_Tab_Header() {
        return chatbot_Tab_Header;
    }
    public static By get_Tickets_Tab_Header() {
        return tickets_Tab_Header;
    }
    public static By get_Tickets_Message() {
        return tickets_Hello_Message;
    }
    public static By get_Change_Appointment_Button() { return change_Appointment_Button; }
    public static By get_Technician_Appointment_Label_Tickets_List(){
        return Technician_Appointment_Label;
    }
    public static By getTicket_Has_Technician_Appointment(){
        return Ticket_Has_Technician_Appointment;
    }
    public static By get_Ready_Button(){
        return Ready_Button;
    }
    public static By get_Closed_Ticket_Details_Button(){ return  more_Info_Button; }

    public static By getTicket_Has_NO_Technician_Appointment(){
        return Ticket_Has_NO_Technician_Appointment;
    }
    public static By getMore_Info_Button_With_Technician_Appointment(){
        return More_Info_Button_With_Technician_Appointment;
    }

    public static By get_Manage_Technician_Appointment_Label_In_Ticket_Details(){
        return Technician_Appointment_Manage_Label_In_Ticket_Details;
    }

    public static By get_Set_Technician_Appointment_Label_In_Ticket_Details(){
        return Technician_Appointment_Set_Label_In_Ticket_Details;
    }

    public static By getTechnician_Appointment_Reschedule_Button(){
        return Technician_Appointment_Reschedule_Button;
    }

    public static By getTechnician_Appointment_Set_Button(){
        return Technician_Appointment_Set_Button;
    }

    public static By get_Back_Button() { return back_button; }

    public static String get_Back_Button_CL() {
        return back_button_CL;
    }

    public static String get_Technician_Appointment_Text_Colour() { return technician_Appointment_Text_Colour; }
    public static int get_Technician_Appointment_Count() { return technician_Appointment_Count; }
    public static By get_Problem_Description_Text_Field(){ return Problem_Description_Text_Field; }
    public static By get_Contact_Number_Text_Field(){ return Contact_Number_Text_Field; }

    public static By get_Reschedule_Button(){ return reschedule_Button_Ticket_Details; }

    public static By get_Fourth_Slot(){ return fourth_Slot; }

    public static By get_Calendar(){ return Calendar; }
    public static By get_Calendar_DSL(){ return CalendarDSL; }

    public TicketsPage getCurruntURL (){
        driver.browser().getCurrentURL();
        return this;
    }

    public static By getTrackMyTechieButton() { return track_My_Techie_Button;  }


    public static By getErrorMsgIconToken() {
        return errorMsgIconToken;
    }

    public static By get_Tickets_list_Title() {
        return tickets_list_Title;
    }

    public static String get_Tickets_list_Title_CL() {
        return tickets_list_Title_CL;
    }
    public static By getClosedTicketDetailsButton() {
        return more_Info_Button_Closed_Tickets;
    }





    public static By getYoutubeButton() {
        return YoutubeButton;
    }

    public static By getTicketDetailsHeader () {return ticketDetailsHeader;}

    //Methods

    public String TechnicianAppointmentText(){
        return driver.element().getText(Ticket_Has_NO_Technician_Appointment);
    }


    @Step("Navigate Method with deeplink")
    public TicketsPage navigate(String deepLink){

        driver.browser().navigateToURL( System.getProperty("de.vodafone.baseUrl.st") + deepLink);
        return this;
    }

    @Step("Navigate Method without deeplink")
    public TicketsPage navigate()
    {
        driver.browser().navigateToURL(System.getProperty("de.vodafone.baseUrl.st"));
        return this;
    }

    @Step("Navigate Method without deeplink")
    public TicketsPage navigateSIT()
    {
        driver.browser().navigateToURL(System.getProperty("de.vodafone.baseUrl.sit"));
        return this;
    }
    @Step("Redirection")
    public TicketsPage redirect()
    {
        //String Url =
        driver.browser().navigateToURL(driver.browser().getCurrentURL().replace(System.getProperty("de.vodafone.baseUrl.sit"),System.getProperty("de.vodafone.baseUrl.st")));
        return this;
    }
    @Step("Accept Cookies")
    public TicketsPage acceptCookies(){
        driver.element().waitToBeReady(accept_Cookies_button);
        driver.element().click(accept_Cookies_button);
        return this;
    }
    @Step("Decline Cookies")
    public TicketsPage declineCookies(){

        driver.element().click(decline_Cookies_button);
        return this;
    }

    @Step("Switch to another tab")
    public TicketsPage SwitchToIframe(String Frame_Name_Or_ID){
        driver.getDriver().switchTo().frame(Frame_Name_Or_ID);
        return this;
    }
    @Step("Switch to the parent tab")
    public TicketsPage SwitchToParent(){
        driver.getDriver().switchTo().parentFrame();
        return this;
    }
    @Step("Click on more info button")
    public TicketsPage clickMoreInfoButton(){
        driver.element().click(more_Info_Button);
        driver.element().waitToBeReady(ticketDetailsTitle);
        return this;
    }
    @Step("Click on re-open ticket button")
    public TicketsPage Click_Reopen_Ticket_Button(){
        driver.element().click(reopen_Ticket_Button);
        return this;
    }
    @Step("Click on close ticket button")
    public TicketsPage Click_Close_Ticket_Button(){
        driver.element().click(close_ticket_button);
        return this;
    }
    @Step("Click on Problem_Still_Exists button")
    public TicketsPage Click_Problem_Still_Exists_Button(){
        driver.element().click(Problem_Still_Exists_Button);
        return this;
    }
    @Step("Enter text")
    public TicketsPage Enter_Data(By Element , String text){
        driver.element().type(Element,text);
        return this;
    }
    @Step("click on element")
    public TicketsPage clickOn(By Element){
        driver.element().click(Element);
        return this;
    }
    @Step("Scroll to element")
    public TicketsPage scrollTo(By  Element){
        driver.element().waitToBeReady(Element);
        return this;
    }
    @Step("Check element colour")
    public TicketsPage checkColour(By  Element){
        technician_Appointment_Text_Colour = driver.element().getCSSProperty(Element,"color");
        System.out.println(" Colour" + technician_Appointment_Text_Colour);
        return this;
    }
    @Step("Expand closed tickets accordion")
    public TicketsPage clickExpandClosedTicketsButton() {
        driver.element().click(expand_Closed_Tickets_Button);
        return this;
    }
    @Step("Click more info button for closed ticket")
    public TicketsPage clickMoreInfoButtonClosedTicket() {
        driver.element().click(more_Info_Button_Closed_Tickets);
        driver.element().waitToBeReady(ticketDetailsTitle);
        return this;
    }






    @Step("Search for ticket and press more info button")
    public TicketsPage searchForTicketByStatusAndClickMoreInfo(String TargetStatus){
        int count=  driver.element().getElementsCount(more_Info_Button);
        int Index=1;
        while (Index <= count) {
            By Status = By.xpath("(//*[@automation-id='openticketStatus_title'][1])" + "[" + Index + "]");
            By Status2 = By.xpath("//*[@automation-id='closeticketStatus_title']" + "[" + Index + "]");
            String status = driver.element().getText(Status);
            String status2 = driver.element().getText(Status2);
            if (status.equals(TargetStatus)||status2.equals(TargetStatus)) {
                More_Info_Selection = By.xpath("(//*[@automation-id='ticketDetails_btn'][1])" + "[" + Index + "]");
                driver.element().click(More_Info_Selection);
                break;
            }
            Index ++;
        }
        return this;
    }
    @Step("Search for ticket by index and press more info button")
    public TicketsPage clickMoreInfoTicketStatusIndex(String TargetStatus , int index){
        int count= driver.element().getElementsCount(more_Info_Button);
        //int index=1;
        while (index <= count) {
            String Status = driver.element().getText(status(index));
            if (Status.equals(TargetStatus)) {

                driver.element().click(moreInfoSelection(index));
                break;
            }
            index++;
        }
        driver.element().waitToBeReady(ticketDetailsTitle);

        return this;
    }
    @Step("Search for ticket by status")
    public TicketsPage searchForOpenTicketByStatus(String TargetStatus){
        int count= driver.element().getElementsCount(more_Info_Button);
        int Index=1;
        while (Index <= count) {
            By Status = By.xpath("(//*[@automation-id='openticketStatus_title'][1])" + "[" + Index + "]");
            By Status2 = By.xpath("(//*[@automation-id='closeticketStatus_title'])" + "[" + Index + "]");
            String status = driver.element().getText(Status);
            String status2 = driver.element().getText(Status2);
            if (status.equals(TargetStatus)) {
                More_Info_Selection = By.xpath("(//*[@automation-id='ticketDetails_btn'][1])" + "[" + Index + "]");
                //scrollTo(More_Info_Selection);
                break;
            }else if (status2.equals(TargetStatus)){
                More_Info_Selection = By.xpath("(//*[@automation-id='ticketDetails_btn'][1])" + "[" + Index + "]");
                //scrollTo(More_Info_Selection);
                break;
            }
            Index ++;
        }
        return this;
    }
    @Step("Search for ticket by status and get appointment CL colour")
    public TicketsPage searchForTicketByStatusAndGetColour(String TargetStatus){
        int count= driver.element().getElementsCount(technician_Appointment_All_Tickets);
        int Index=1;
        while (Index <= count) {
            By Status = By.xpath("(//*[@automation-id='openticketStatus_title'][1])" + "[" + Index + "]");
            By technician_Appointment_Selection = By.xpath("(//*[@automation-id='openticketStatusTextText_tv'][1])" + "[" + Index + "]");
            String status = driver.element().getText(Status);
            if (status.equals(TargetStatus)) {

                checkColour(technician_Appointment_Selection);
                break;
            }
            Index ++;
        }
        return this;
    }
    @Step("Search for ticket by status and index then get appointment CL colour")
    public TicketsPage searchForTicketByStatusAndGetColourAndIndex(String TargetStatus, int Index){
        int count= driver.element().getElementsCount(technician_Appointment_All_Tickets);
        while (Index <= count) {
            String status = driver.element().getText(status(Index));
            if (status.equals(TargetStatus)) {

                checkColour(technicianAppointmentSelection(Index));
                break;
            }
            Index ++;
        }
        return this;
    }
    @Step("Get number of appointments")
    public int Get_Appointments_Count() {
        int count = driver.element().getElementsCount(technician_Appointment_All_Tickets);
        return count;
    }
    @Step("Navigate to a ticket with appointment")
    public TicketsPage NavigateToTicketWithAppointment() {
        driver.element().isElementDisplayed(get_Set_Technician_Appointment_Label_In_Ticket_Details());
        return this;
    }


    @Step("Search for ticket with appointment and press more info button")
    public TicketsPage ClickOnMoreInfoButtonWithAppointment(){
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollTo(0,850);");
        driver.element().click(getMore_Info_Button_With_Technician_Appointment());
        return this;
    }
    @Step("Validating that error message icon is displayed")
    public TicketsPage validateErrorMsgIconDisplayed()
    {
        driver.assertThat()
                .element(getErrorMsgIconToken())
                .isVisible()
                .perform();
        return this;
    }

    @Step("Validate error message CL")
    public TicketsPage validateErrorMsgTextMatch()
    {
        driver.assertThat()
                .element(getErrorMsgTextStrongToken())
                .text()
                .isEqualTo(errorMsgTextStrongTokenCL)
                .perform();
        return this;
    }
    @Step("Validate error message CL")
    public TicketsPage validateErrorMsgTextMatch2()
    {
        driver.assertThat()
                .element(getErrorMsgTextPToken2())
                .text()
                .isEqualTo(errorMsgTextPToken2CL)
                .perform();
        return this;
    }
    @Step("Validate error message button is displayed")
    public TicketsPage validateErrorMsgButtonDisplayed()
    {
        driver.assertThat()
                .element(errorMsgButtonToken)
                .exists()
                .perform();
        return this;
    }
    @Step("Validate error message button text")
    public TicketsPage validateErrorMsgButtonTextMatch()
    {
        driver.assertThat()
                .element(getErrorMsgButtonToken())
                .text()
                .isEqualTo(errorMsgButtonTokenCL)
                .perform();
        return this;
    }
    @Step("Validate error message button is displayed")
    public TicketsPage validateErrorMsgButtonVisible()
    {
        driver.assertThat()
                .element(getErrorMsgButtonToken())
                .isVisible()
                .perform();
        return this;
    }
    @Step("Validate ticket status is inProgress")
    public TicketsPage validateTicketStatus(String Status)
    {
        driver.assertThat()
                .element(inprogress_Ticket_Status)
                .text()
                .isEqualTo(Status)
                .perform();
        return this;
    }
    @Step("Validate appointment CL")
    public TicketsPage validateTicketAppointmentTextWithIndex(int Index)
    {
        By appointmentText = By.xpath("(//*[@automation-id='openTicketStatusText_tv'])[" + Index + "]");
        driver.assertThat()
                .element(appointmentText)
                .text()
                .contains(technicianAppointmentCL)
                .perform();
        return this;
    }
    @Step("Validate appointment CL")
    public TicketsPage validateTicketAppointmentTextIndex(int Index)
    {
        driver.element().waitToBeReady(appointmentIndex(Index));
        driver.assertThat()
                .element(appointmentIndex(Index))
                .text()
                .contains(technicianAppointmentDetailsCL)
                .perform();
        return this;
    }
    @Step("Validate appointment CL")
    public TicketsPage validateTicketAppointmentText()
    {
        //driver.element().waitToBeReady(get_Manage_Technician_Appointment_Label_In_Ticket_Details());
        driver.assertThat()
                .element(get_Manage_Technician_Appointment_Label_In_Ticket_Details())
                .text()
                .contains(technicianAppointmentCL)
                .perform();
        return this;
    }
    @Step("Validate appointment text colour is red")
    public TicketsPage validateTicketDetailsAppointmentTextColour() {
        driver.element().waitToBeReady(Technician_Appointment_Manage_Label_In_Ticket_Details);
        driver.assertThat()
                .element(Technician_Appointment_Manage_Label_In_Ticket_Details)
                .cssProperty("color")
                .contains("230, 0, 0")
                .perform();
        return this;

    }
    @Step("Validate appointment text colour is red")
    public TicketsPage validateTicketAppointmentTextColour() {
        driver.element().waitToBeReady(Technician_Appointment_Label);
        driver.assertThat()
                .element(Technician_Appointment_Label)
                .cssProperty("color")//get_Technician_Appointment_Text_Colour()
                .contains("230, 0, 0")
                .perform();
        return this;
    }
@Step("Validate track my techie button exists")
    public TicketsPage validateTrackMyTechieTechnicianButtonDisplayed() {
        driver.assertThat()
                .element(getTrackMyTechieButton())
                .isVisible()
                .perform();
        return this;
    }
    @Step("Validate track my techie button text")
    public TicketsPage validateTrackMyTechieTechnicianButtonText()
    {
        driver.assertThat()
                .element(getTrackMyTechieButton())
                .text()
                .isEqualTo(trackMyTechieButtonCL)
                .perform();
        return this;
    }
    @Step("Validate inProgress ticket CL")
    public TicketsPage validateInprogressTicketStatusText()
    {
        driver.assertThat()
                .element(inprogress_Ticket_Status)
                .text()
                .isEqualTo("In Arbeit")
                .perform();
        return this;
    }
    @Step("Validate closed tickets are displayed")
    public TicketsPage validateExpandClosedTicketsDisplayed()
    {
        driver.assertThat()
                .element(expand_Closed_Tickets_Button)
                .exists()
                .perform();
        return this;
    }
    @Step("Validate closed tickets are displayed")
    public TicketsPage validateClosedTicketsExist()
    {
        driver.assertThat()
                .element(closed_Ticket_Status)
                .exists()
                .perform();
        return this;
    }
    @Step("Validate closed tickets status CL")
    public TicketsPage validateClosedTicketStatus(String Status)
    {
        driver.assertThat()
                .element(closed_Ticket_Status)
                .text()
                .isEqualTo(Status)
                .perform();
        return this;
    }
    @Step("Validate that closed tickets has no technician appointment")
    public TicketsPage validateClosedTicketHasNoTechnicianAppointment(int First_Count, int Second_Count)
    {
        SHAFT.Validations
                .verifyThat()
                .object(First_Count)
                .isEqualTo(Second_Count)
                .perform();
        return this;
    }
    @Step("Validate that number of appointments for multiple tickets is more than one")
    public TicketsPage validateTechnicianAppointmentsMultipleTickets()
    {
        int Appointments_count = Get_Appointments_Count();
        System.out.println("Appointments count "+ get_Technician_Appointment_Count());

        SHAFT.Validations
                .verifyThat()
                .number(Appointments_count)
                .isGreaterThan(1)
                .perform();
        return this;
    }
    @Step("Validate ticket status")
    public TicketsPage validateTicketStatusText(String Status)
    {
        driver.assertThat()
                .element(ticket_Details_Status)
                .text()
                .isEqualTo(Status)
                .perform();
        return this;
    }
    @Step("Validate ticket appointment validity with ticket status")
    public TicketsPage validateTicketAppointmentValidityWithTicketStatus(String TargetStatus , int index){
        int count= driver.element().getElementsCount(more_Info_Button);
        //int index=1;
        By Status = By.xpath("(//*[@automation-id='openticketStatus_title'][1])" + "[" + index + "]");
        By technicianAppointment = By.xpath("(//*[@automation-id='openticketStatusTextText_tv'])" + "[" + index + "]");
        String status = driver.element().getText(Status);
        while (index <= count) {
            if (status.equals(TargetStatus)) {

                driver.assertThat()
                        .element(technicianAppointment)
                        .text()
                        .contains(technicianAppointmentDetailsCL)
                        .perform();
                break;
            }
            index ++;
        }
        return this;
    }
    @Step("Validate ticket appointment invalidity with ticket status")
    public TicketsPage validateTicketAppointmentInvalidityWithTicketStatus(String TargetStatus, int index) {
        int count = driver.element().getElementsCount(more_Info_Button);
        //int index=1;
        while (index <= count) {
            By Status = By.xpath("(//*[@automation-id='openticketStatus_title'][1])" + "[" + index + "]");
            By technicianAppointment = By.xpath("(//*[@automation-id='openTicketStatusText_tv'][1])" + "[" + index + "]");
            String status = driver.element().getText(Status);
            if (status.equals(TargetStatus)) {
                driver.verifyThat()
                        .element(technicianAppointment)
                        .doesNotExist()
                        .perform();
                break;
            }
            index++;
        }
        return this;
    }
    @Step("Validate ticket history arrangment")
    public TicketsPage validateTicketHistoryLogArrangedFromRecentlyToOlder() {
        List<WebElement> list = driver.getDriver().findElements(getTicketHistoryListLog);
        int bool_Value = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                SHAFT.Validations.assertThat()
                        .object((list.get(i).getText().compareTo(list.get(j).getText()) > 0))
                        .isEqualTo(false)
                        .perform();
                System.out.println(list.get(i).getText().compareTo(list.get(j).getText()) > 0);
            }
        }
        return this;
    }
    @Step("Validate close ticket button is not visible")
    public TicketsPage validateCloseTicketBtnIsNotVisible(){
        driver.assertThat()
                .element(close_ticket_button)
                .doesNotExist()
                .perform();

        return this;
    }
    @Step("Validate close ticket button is visible")
    public TicketsPage validateCloseTicketBtnIsVisible()
    {
        driver.assertThat()
                .element(close_ticket_button)
                .exists()
                .perform();

        return this;
    }

    @Step("Expand ticket history accordion")
    public TicketsPage clickExpandTicketHistoryAccordion()
    {
        driver.element().click(ticketHistoryAccordion);
        return this;
    }
    @Step("Validate reschedule ticket button is visible")
    public TicketsPage validateRescheduleBtnIsNotVisible()
    {
        driver.assertThat()
                .element(Technician_Appointment_Reschedule_Button)
                .doesNotExist()
                .perform();
        return this;
    }
    @Step("Validate reschedule ticket button is visible")
    public TicketsPage validateRescheduleBtnIsVisible()
    {
        driver.assertThat()
                .element(Technician_Appointment_Reschedule_Button)
                .exists()
                .perform();
        return this;
    }
    @Step("Validate ticket details appointment CL")
    public TicketsPage validateTicketDetailsAppointmentText()
    {
        driver.assertThat()
                .element(getTechnicianAppointmentDetails())
                .text()
                .contains(technicianAppointmentDetailsCL)
                .perform();
        return this;
    }
    @Step("Validate ticket status is dispalyed")
    public TicketsPage validateTicketStatusDisplayed() {
        driver.assertThat()
                .element(getStatus())
                .exists()
                .withCustomReportMessage("Ticket Status Exists Successfully")
                .perform();

        return this;
    }
    @Step("Validate ticket status is dispalyed")
    public TicketsPage validateTicketStatusDisplayedTicketsList() {
        driver.assertThat()
                .element(getInprogressTicketStatus())
                .exists()
                .perform();

        return this;
    }
    @Step("Validate more info button is displayed")
    public TicketsPage validateMoreInfoButtonIsDisplayed() {
        driver.assertThat()
                .element(More_Info_Button_With_Technician_Appointment)
                .exists()
                .perform();

        return this;
    }
    @Step("Validate ticket previous steps accordion is closed")
    public TicketsPage validatePreviouStepsAccordionIsClosed() {
        driver.assertThat()
                .element(ticket_Previous_Steps_Accordion)
                .doesNotExist()
                .perform();

        return this;
    }
    @Step("Validate ticket previous steps icon is not displayed")
    public TicketsPage validatePreviouStepsIconIsNotDisplayed()
    {
        driver.assertThat()
                .element(get_Icon())
                .doesNotExist()
                .perform();

        return this;
    }
    @Step("Click on track my techie button")
    public TicketsPage clickTrackMyTechieButton() {
        driver.element().click(getTrackMyTechieButton());

        return this;
    }
    @Step("Validate youtube button is displayed")
    public TicketsPage validateYoutubeButtonFound() {
        driver.assertThat()
                .element(getYoutubeButton())
                .exists()
                .perform();
        return this;
    }
    @Step("Click on youtube button")
    public TicketsPage clickYoutubeButton() {

        driver.element().click(getYoutubeButton());
        return this;
    }
    @Step("Validate youtube button redirection")
    public TicketsPage validateYoutubeButtonRedirection() {
        Object[] handles = driver.getDriver().getWindowHandles().toArray();
        driver.browser().switchToWindow(handles[2].toString());
        driver
                .assertThat()
                .browser()
                .url()
                .contains(youtube_Button_Link)
                .perform();
        return this;
    }
    @Step("Validate youtube button is not displayed")
    public TicketsPage validateYoutubeButtonNotFound() {
        driver
                .assertThat()
                .element(getYoutubeButton())
                .doesNotExist()
                .perform();
        return this;
    }
    @Step("Validate ticket details page is displayed")
    public TicketsPage verifyTicketDetailsPage()
    {
        driver
                .assertThat()
                .element(getTicketDetailsHeader())
                .exists()
                .perform();
        return this;
    }

    @Step("Choose Re-open Ticket option from decision tree")
    public TicketsPage clickOnReOpenTicketDecisionTree()
    {
        driver.element().click(ticketReOpenBtnDecisionTree);
        return this;
    }
@Step("Validate tickets details title is displayed correctly")
    public TicketsPage validateTicketDetailsTitle()
{
    driver
            .assertThat()
            .element(ticketDetailsTitle)
            .exists()
            .perform();

    return this;
}
    @Step("Validate warning message appears")
public TicketsPage validateWarningMessage()
{
    driver
            .assertThat()
            .element(warningMessage)
            .exists()
            .perform();

    driver.assertThat()
            .element(warningMessage)
            .text()
            .contains(warningMessageHeaderCL)
            .perform();


    return this;
    }
    @Step("Validate appointment text colour is red for DSL ticket")
    public TicketsPage validateTicketAppointmentTextColourDSLTicketDetails()
    {
        driver.assertThat()
                .element(technicianAppointmentDetails)
                .cssProperty("color")//get_Technician_Appointment_Text_Colour()
                .contains("230, 0, 0")
                .perform();
        return this;
    }
    @Step("Validate appointment text colour is red for DSL ticket")
    public TicketsPage validateTicketAppointmentTextColourDSLTicketList(int index)
    {
        driver.assertThat()
                .element(technicianAppointmentSelection(index))
                .cssProperty("color")
                .contains("230, 0, 0")
                .perform();
        return this;
    }

    @Step("Validate set appointment text colour is red")
    public TicketsPage validateTicketDetailsNoAppointmentTextColour() {
        driver.element().waitToBeReady(Technician_Appointment_Set_Label_In_Ticket_Details);
        driver.assertThat()
                .element(Technician_Appointment_Set_Label_In_Ticket_Details)
                .cssProperty("color")
                .contains("230, 0, 0")
                .perform();
        return this;

    }
    @Step("navigate to tickettab from chatbot page")
    public TicketsPage clickOnChatbotTab() {
        driver.element().click(chatbot_Tab_Header);

        return this;
    }
    @Step("Validate logout button displayed in tickets page")
    public TicketsPage validateTicketLogoutButtonExist() {
        driver
                .assertThat()
                .element(ticketsLogoutButton)
                .exists()
                .perform();

        return this;
    }

    @Step("validate that tickets page is not shown")
    public TicketsPage validateTicketsIsNotShown()
    {
        driver.assertThat().element(tickets_list_Title).doesNotExist().perform();
        return this;
    }

    @Step("validate that tickets image is not visible")
    public TicketsPage validateTicketsImageIsNotVisible()
    {
        driver.assertThat().element(ticketsImage).doesNotExist().perform();
        return this;
    }

    @Step("Validate welcome message new CL")
    public TicketsPage validateWelcomeMsgNewCL(){
        driver.assertThat().element(welcomeMsg).textTrimmed().isEqualTo(welcomeMsgNewCL).perform();
        return this;
    }

    @Step("Validate ticket previous steps accordion is closed")
    public TicketsPage validatePreviouStepsAccordionExists() {
        driver.assertThat()
                .element(ticket_Previous_Steps_Accordion)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate ticket previous green icon does not exist")
    public TicketsPage validatePreviousStepsGreenIconDoesNotExist() {
        driver.assertThat()
                .element(ticketExpandedPreviousStepsIcon)
                .doesNotExist()
                .perform();

        return this;
    }

    @Step("Validate that get closed tickets button exists")
    public TicketsPage validateGetClosedTicketsButtonExists()
    {
        driver.assertThat()
                .element(close_ticket_button)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate solved tickets status is displayed")
    public TicketsPage validateSolvedTicketsStatusIsDisplayed()
    {
        driver.assertThat()
                .element(resolved_Ticket_Status)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate that Re-open button exists for solved tickets")
    public TicketsPage validateReopenButtonExistsForSolvedTickets()
    {
        driver.assertThat()
                .element(reopen_Ticket_Button)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate Re-open button CL")
    public TicketsPage validateReopenButtonCL()
    {
        driver.assertThat()
                .element(reopen_Ticket_Button)
                .textTrimmed()
                .isEqualTo(reOpenButtonCL)
                .perform();

        return this;
    }

    @Step("Validate Neu Starten button CL")
    public TicketsPage validateNeuStartenButtonCL()
    {
        driver.assertThat().
                element(refresh_Button)
                .textTrimmed()
                .isEqualTo(refreshButtonCL)
                .perform();

        return this;
    }

    @Step("Validate ticket status description exists")
    public TicketsPage validateTicketStatusDescriptionExists()
    {
        driver.assertThat()
                .element(ticket_status_description)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate ticket creation date exists")
    public TicketsPage validateTicketCreationDateExists()
    {
        driver.assertThat()
            .element(Ticket_Creation_Date)
            .exists()
            .perform();

        return this;
    }

    @Step("Validate ticket number exists")
    public TicketsPage validateTicketNumberExists()
    {
        driver.assertThat()
                .element(ticketNumber)
                .exists()
                .perform();

        return this;
    }
    @Step("Validate ticket status CL")
    public TicketsPage validateTicketStatusCL()
    {
        driver.assertThat().
                element(ticketStatus)
                .textTrimmed()
                .isEqualTo(inProgressTicketCL)
                .perform();

        return this;
    }
    @Step("Validate ticket status bar exists")
    public TicketsPage validateTicketStatusBarExists()
    {
        driver.assertThat()
                .element(ticket_Details_Status_Bar)
                .exists()
                .perform();

        return this;
    }
    @Step("Validate ticket status bar exists")
    public TicketsPage validateCurrentTicketStatusExists()
    {
        driver.assertThat()
                .element(Current_Ticket_Status)
                .exists()
                .perform();

        return this;
    }
    @Step("Validate Closed Ticket CL")
    public TicketsPage validateClosedTicketCL()
    {
        driver.assertThat().
                element(ticketStatus)
                .textTrimmed()
                .isEqualTo(closedTicketsCL)
                .perform();

        return this;
    }

    @Step("Validate Gelost Tickets header ticket details")
    public TicketsPage validateGelostTicketsHeaderDetails()
    {
        driver.assertThat()
                .element(details_header_gelost)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate error message is displayed")
    public TicketsPage validateErrorMsgIsDisplayed()
    {
        driver.assertThat()
                .element(errorMsgButtonToken)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate vodafone icon exists")
    public TicketsPage validateVodafoneIconExists()
    {
        driver.assertThat()
                .element(meinvodafone_icon)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate ticket status bar exists in tickets list")
    public TicketsPage validateTicketStatusBarExistsTicketsList()
    {
        driver.assertThat()
                .element(tickets_List_Status_Bar)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate ticket title exists in tickets list")
    public TicketsPage validateTicketTitleExistsTicketsList()
    {
        driver.assertThat()
                .element(ticket_title)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate ticket number exists in tickets list")
    public TicketsPage validateTicketNumberExistsTicketsList()
    {
        driver.assertThat()
                .element(Ticket_Number)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate ticket date exists in tickets list")
    public TicketsPage validateTicketDateExistsTicketsList()
    {
        driver.assertThat()
                .element(Ticket_Creation_Date)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate ticket date exists in tickets list")
    public TicketsPage validateTicketAppointmentLabelTicketDetails()
    {
        driver.assertThat()
                .element(Technician_Appointment_Manage_Label_In_Ticket_Details)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate tickets hello message CL")
    public TicketsPage validateTicketsHelloMsgCL()
    {
        driver.assertThat()
                .element(tickets_Hello_Message)
                .text()
                .contains(ticketsPageHelloMsgCL)
                .perform();

        return this;
    }

    @Step("Validate chatbot tab header exists")
    public TicketsPage validateChatbotTabHeaderExists()
    {
        driver.assertThat()
                .element(chatbot_Tab_Header)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate tickets tab header exists")
    public TicketsPage validateTicketsTabHeaderExists()
    {
        driver.assertThat()
                .element(tickets_Tab_Header)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate tickets error message CL")
    public TicketsPage validateTicketsErrorMsgCL()
    {
        driver.assertThat()
                .element(tickets_Error_Message)
                .text()
                .contains(ticketsErrorMsgCL)
                .perform();

        return this;
    }

    @Step("Validate tickets details status exists")
    public TicketsPage validateTicketsDetailsStatusExsits()
    {
        driver.assertThat()
                .element(ticket_Details_Status)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate closed tickets more info button exists")
    public TicketsPage validateClosedTicketsMoreInfoBtnExsits()
    {
        driver.assertThat()
                .element(more_Info_Button_Closed_Tickets)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate technician appointment CL")
    public TicketsPage validateTechnicianAppointmentCL()
    {
        driver.assertThat()
                .element(Technician_Appointment_Set_Label_In_Ticket_Details)
                .text()
                .contains(ticketAppointmentCL)
                .perform();

        return this;
    }

    @Step("Validate set technician appointment label exists")
    public TicketsPage validateSetTechnicianAppointmentLabelExists()
    {
        driver.assertThat()
                .element(Technician_Appointment_Set_Label_In_Ticket_Details)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate set technician appointment label CL")
    public TicketsPage validateSetTechnicianAppointmentLabelCL()
    {
        driver.assertThat()
                .element(Technician_Appointment_Set_Label_In_Ticket_Details)
                .text()
                .contains(setAppointmentButtonCL)
                .perform();

        return this;
    }

    @Step("Validate set technician appointment button exists")
    public TicketsPage validateSetTechnicianAppointmentbtnExists()
    {
        driver.assertThat()
                .element(Technician_Appointment_Set_Button)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate set technician appointment label exists")
    public TicketsPage validateSetTechnicianAppointmentLabelDoesNotExists()
    {
        driver.assertThat()
                .element(Technician_Appointment_Set_Label_In_Ticket_Details)
                .doesNotExist()
                .perform();

        return this;
    }

    @Step("Validate ticket appointment label in ticket details does not exist")
    public TicketsPage validateTicketAppointmentLabelTicketDetailsDoesNotExist()
    {
        driver.assertThat()
                .element(Technician_Appointment_Manage_Label_In_Ticket_Details)
                .doesNotExist()
                .perform();

        return this;
    }

    @Step("Validate that calendar appears")
    public TicketsPage validateCalendarAppearsUM()
    {
        driver.verifyThat()
                .element(Calendar)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate CL for ticket with no appointment")
    public TicketsPage validateNoAppointmentTicketCL()
    {
        driver.assertThat()
                .element(Ticket_Has_NO_Technician_Appointment)
                .text()
                .doesNotEqual(technicianAppointmentDetailsCL);

        return this;
    }

    @Step("Validate tickets hello message exists")
    public TicketsPage validateTicketsHelloMsgExists()
    {
        driver.assertThat()
                .element(tickets_Hello_Message)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate that back button does not exist")
    public TicketsPage validateBackButtonDoesNotExist()
    {
        driver.assertThat()
                .element(back_button)
                .doesNotExist()
                .perform();

        return this;
    }

    @Step("Validate that vodafone icon exists")
    public TicketsPage validateVodafoneIconexists()
    {
        driver.assertThat()
                .element(vodafone_icon)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate on URL")
    public TicketsPage validateURL()
    {
        driver.assertThat()
                .browser()
                .url()
                .isEqualTo("https://www.vodafone.de/")
                .perform();

        return this;
    }

    @Step("Validate that ticket has no appointment ticketsList view")
    public TicketsPage validateTicketHasNoAppointmentTicketsList()
    {
        driver
                .assertThat()
                .element(Technician_Appointment_Label)
                .doesNotExist()
                .perform();

        return this;
    }

    @Step("Validate that error token message is appearing")
    public TicketsPage validateTokenMessageIsVisible()
    {
        driver
                .assertThat()
                .element(errorMsgIconToken)
                .isVisible()
                .perform();

        return this;
    }

    @Step("Validate that error token message is appearing")
    public TicketsPage validateTokenMessageCL()
    {
        driver
                .assertThat()
                .element(errorMsgTextStrongToken)
                .text()
                .isEqualTo(errorMsgTextStrongTokenCL);

        return this;
    }

    @Step("Validate token error text message")
    public TicketsPage validateTokenErrorMsg()
    {
        driver.assertThat()
                .element(errorMsgTextPToken)
                .text()
                .isEqualTo(tokenErrorMsgCL);

        return this;
    }

    @Step("Validate URL redirection when token error exists")
    public TicketsPage validateTokenErrorRedirectionURL(String URL)
    {
        driver
                .assertThat()
                .browser()
                .url()
                .isEqualTo(URL)
                .perform();

        return this;
    }

    @Step("Validate that closed tickets has no tecnician appointments")
    public TicketsPage validateClosedTicketHasNoTechAppointment()
    {
        ticketWithTechAppointmentNumber = driver.element().getElementsCount(Technician_Appointment_Manage_Label_In_Ticket_Details);
        clickOn(expand_Closed_Tickets_Button);
        SHAFT.Validations
                .assertThat()
                .object(ticketWithTechAppointmentNumber)
                .isEqualTo(driver.element().getElementsCount(Technician_Appointment_Manage_Label_In_Ticket_Details))
                .perform();

        return this;
    }

    @Step("Click on Technician Appointment Set button")
    public TicketsPage clickTechnicianAppointmentSetButton() {
        driver.element().click(Technician_Appointment_Set_Button);
        return this;
    }

    @Step("Click on Go On DSL button")
    public TicketsPage clickGoOnDSLButton() {
        driver.element().click(go_On_ButtonDSL);
        return this;
    }

    @Step("Click on Calendar Date DSL button")
    public TicketsPage clickCalendarDSLButton() {
        driver.element().click(CalendarDSL);
        return this;
    }

    @Step("Navigate Method with deeplink")
    public TicketsPage navigateSIT(String deepLink){

        driver.browser().navigateToURL( System.getProperty("de.vodafone.baseUrl.sit") + deepLink);
        return this;
    }

    @Step("Validate ticket status is Resolved")
    public TicketsPage validateTicketStatusResolved(String Status)
    {
        driver.assertThat()
                .element(resolved_Ticket_Status)
                .text()
                .isEqualTo(Status)
                .perform();
        return this;
    }

    @Step("Validate ticket status is Resolved in Ticket Details")
    public TicketsPage validateTicketDetailsResolved(String Status)
    {
        driver.assertThat()
                .element(resolved_Ticket_Details_Status )
                .text()
                .isEqualTo(Status)
                .perform();
        return this;
    }

    @Step("Validate ticket status is inProgress in Ticket Details")
    public TicketsPage validateTicketDetailsInprogress(String Status)
    {
        driver.assertThat()
                .element(inprogress_Ticket_Details_Status)
                .text()
                .isEqualTo(Status)
                .perform();
        return this;
    }

    @Step("Validate Set Technician Appointment button exists")
    public TicketsPage validateSetTechnicianAppointmentButtonExists() {
        driver.verifyThat()
                .element(Technician_Appointment_Set_Button)
                .exists()
                .withCustomReportMessage(" Set Appointment Button Exists Successfully")
                .perform();
        return this;
    }

    @Step("Validate Set Technician Appointment button does not exist")
    public TicketsPage validateSetTechnicianAppointmentButtonDoesNotExist() {
        driver.verifyThat()
                .element(Technician_Appointment_Set_Button)
                .doesNotExist()
                .withCustomReportMessage(" Set Appointment Button does not Exist")
                .perform();
        return this;
    }

    @Step("Validate Set Technician Appointment Label does not exists")
    public TicketsPage validateSetTechnicianAppointmentLabelDoesNotExist() {
        driver.verifyThat()
                .element(Technician_Appointment_Set_Label_In_Ticket_DetailsDSL)
                .doesNotExist()
                .perform();
        return this;
    }

    @Step("Validate Manage Technician Appointment Label does not exists")
    public TicketsPage validateManageTechnicianAppointmentLabelDoesNotExist() {
        driver.verifyThat()
                .element(Technician_Appointment_Manage_Label_In_Ticket_DetailsDSL)
                .doesNotExist()
                .perform();
        return this;
    }

    @Step("Validate closed tickets status Exists")
    public TicketsPage validateClosedTicketStatusExists()
    {
        driver.assertThat()
                .element(closed_Ticket_Status)
                .exists()
                .withCustomReportMessage("status is closed in tickets list")
                .perform();
        return this;
    }

    @Step("Validate Calendar Exists")
    public TicketsPage validateCalendarExistsDSL()
    {
        driver.assertThat()
                .element(CalendarDSL)
                .exists()
                .withCustomReportMessage(" Calendar Exists Successfully")
                .perform();
        return this;
    }

    @Step("Validate set appointment text colour is red")
    public TicketsPage validateTicketSetAppointmentTextColourDSL() {
        driver.element().waitToBeReady(Technician_Appointment_Label);
        driver.assertThat()
                .element(Technician_Appointment_Label)
                .cssProperty("color")
                .contains("230, 0, 0")
                .perform();
        return this;

    }
    @Step("Validate set appointment text CL")
    public TicketsPage validateTicketSetAppointmentTextCLDSL() {
        driver.element().waitToBeReady(Technician_Appointment_Label);
        driver.assertThat()
                .element(Technician_Appointment_Label)
                .text()
                .contains(setTechnicinanAppointmentCLDSL)
                .perform();
        return this;

    }

    @Step("Validate set appointment text CL")
    public TicketsPage validateTicketSetAppointmentTextCLUM() {
        driver.element().waitToBeReady(Technician_Appointment_Set_Label_In_Ticket_Details);
        driver.assertThat()
                .element(Technician_Appointment_Set_Label_In_Ticket_Details)
                .text()
                .contains(setTechnicinanAppointmentCLUM)
                .perform();
        return this;

    }

    @Step("Validate set appointment details text CL")
    public TicketsPage validateTicketDetailsSetAppointmentTextCLDSL() {
        driver.element().waitToBeReady(Technician_Appointment_Set_Label_In_Ticket_DetailsDSL);
        driver.verifyThat()
                .element(Technician_Appointment_Set_Label_In_Ticket_DetailsDSL)
                .text()
                .contains(setTechnicinanAppointmentDetailsCLDSL)
                .perform();
        return this;

    }

    @Step("Validate set appointment details text CL")
    public TicketsPage validateTicketDetailsSetAppointmentTextCLUM() {
        driver.element().waitToBeReady(Technician_Appointment_Set_Label_In_Ticket_Details);
        driver.verifyThat()
                .element(Technician_Appointment_Set_Label_In_Ticket_Details)
                .text()
                .contains(setTechnicinanAppointmentDetailsCLUM)
                .perform();
        return this;

    }

    @Step("Validate set appointment text label exists")
    public TicketsPage validateTicketDetailsSetAppointmentTextLabelExistsDSL() {
        driver.element().waitToBeReady(Technician_Appointment_Set_Label_In_Ticket_DetailsDSL);
        driver.verifyThat()
                .element(Technician_Appointment_Set_Label_In_Ticket_DetailsDSL)
                .exists()
                .perform();
        return this;

    }

    @Step("Validate set appointment text label exists")
    public TicketsPage validateTicketDetailsSetAppointmentTextLabelExistsUM() {
        driver.element().waitToBeReady(Technician_Appointment_Set_Label_In_Ticket_Details);
        driver.verifyThat()
                .element(Technician_Appointment_Set_Label_In_Ticket_Details)
                .exists()
                .perform();
        return this;
    }

    @Step("Switch to chatbot page")
    public TicketsPage switchToChatbot(){
        driver.element().click(chatbot_Tab_Header);
        return this;
    }
    @Step("Validate User In tickets page")
    public TicketsPage validateUserInTicketsPage(){
        driver.browser()
                .verifyThat()
                .url()
                .contains("tickets")
                .perform();
        return this;
    }

    @Step("Validate that Fehlersuche Starten button exists")
    public TicketsPage validateFehlersucheStartenBtnExists()
    {
        driver.assertThat().element(fehlersucheStartenBtn).exists().perform();
        return this;
    }
    @Step("Validate that Fehlersuche Starten button does not exist")
    public TicketsPage validateFehlersucheStartenBtnDoesNotExist()
    {
        driver.assertThat().element(fehlersucheStartenBtn).doesNotExist().perform();
        return this;
    }

    @Step("Validate that Netz-Assistent button exists")
    public TicketsPage validateNetzAssistentBtnExists()
    {
        driver.assertThat().element(netzAssistentBtn).exists().perform();
        return this;
    }
    @Step("Validate that Netz-Assistent button does not exist")
    public TicketsPage validateNetzAssistentBtnDoesNotExist()
    {
        driver.assertThat().element(netzAssistentBtn).doesNotExist().perform();
        return this;
    }

    @Step("Click on Fehlersuche Starten button")
    public TicketsPage clickOnFehlersucheStartenBtn()
    {
        driver.element().click(fehlersucheStartenBtn);
        return this;
    }

    @Step("Click on Fehlersuche Starten button")
    public TicketsPage clickOnnetzAssistentBtn()
    {
        driver.element().click(netzAssistentBtn);
        return this;
    }

    @Step("Validate on URL when Fehlersuche Starten button is clicked")
    public TicketsPage validateURLWhenFehlersucheStartenIsClicked()
    {
        driver.assertThat().browser().url().contains("icmp=netz-assistent:chatbot_redirect").perform();
        return this;
    }

    @Step("Validate tickets list new message exists with correct CL for DSL")
    public TicketsPage validateTicketsListNewMsgExistsDSL()
    {
        driver.assertThat().element(ticketsListMsg).exists().perform();
        driver.assertThat().element(ticketsListMsg).textTrimmed().isEqualTo(ticketsListMsgDSLCL).perform();
        return this;
    }


    @Step("Validate tickets list new message exists with correct CL for DSL")
    public TicketsPage validateTicketsListNewMsgExistsCableUM()
    {
        driver.assertThat().element(ticketsListMsg).exists().perform();
        driver.assertThat().element(ticketsListMsg).textTrimmed().isEqualTo(ticketsListMsgCableUMCL).perform();
        return this;
    }

    @Step("Validate tickets list new message does not exist")
    public TicketsPage validateTicketsListNewMsgDoesNotExist()
    {
        driver.assertThat().element(ticketsListMsg).doesNotExist().perform();
        return this;
    }

    @Step("Validate tickets list new message exists with correct CL")
    public TicketsPage validateTicketsListNewMsgCLWhenNetzAssistentBtnIsClicked()
    {
        driver.assertThat().element(ticketsListEndMsg).textTrimmed().isEqualTo(ticketsListNetAssistentClickedMsgCL).perform();
        return this;
    }

    public TicketsPage clickTicketsTabHeader()
    {
        driver.element().click(tickets_Tab_Header);
        return this;
    }
}