package tests;

import core.TestBase;
import helpDesk.MainPage;
import helpDesk.TicketPage;
import helpers.TestValues;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import readProperties.ConfigProvider;

import java.sql.SQLOutput;

import static helpers.StringModifier.getUniqueString;
public class HelpDeskTest extends TestBase {
    @Test
    public void checkTicket(){
        String title = getUniqueString(TestValues.TEST_TITLE);
        TicketPage ticketPage = new MainPage().createTicket(title, TestValues.TEST_BODY, TestValues.TEST_EMAIL)
                .openLoginPage()
                .auth(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD)
                .findTicket(title);
        Assertions.assertTrue(ticketPage.getTitle().contains(title));
        Assertions.assertEquals(ticketPage.getBody(), TestValues.TEST_BODY);
        Assertions.assertEquals(ticketPage.getEmail(), TestValues.TEST_EMAIL);
    }
}
