package Part_5_ElementInteractions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFailedLogin extends TestSettings {
    @Test
    //Trry to log in with unregistered email address and some password;
    public void incorrectCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.closeInfoBar();
        loginPage.inputLoginEmail("nonexistent@email.com");
        loginPage.inputLoginPassword("incorrectpassword");

        loginPage.clickLoginButton();
        Assertions.assertTrue(driver.getPageSource().contains("<li>\n" +
                "\t\t\tNieznany adres email."), "Error message did not appear");
    }
}
