package Part_5_ElementInteractions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSuccessfulRegistration extends TestSettings {
    @Test
    //Try to log in with valid credentials;
    public void SuccessfulRegistration() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.closeInfoBar();
        loginPage.inputRegisterEmail("test@email.com");
        loginPage.inputRegisterPassword("SecretPassword123!");

        loginPage.clickRegisterButton();
        Assertions.assertTrue(driver.getPageSource().contains("<a class=\"delete-me\""),
                "You have been redirected to incorrect webpage or not at all");
    }

    @Test
    //Same as above but log in by hitting enter button;
    public void SuccessfulRegistrationWithEnter() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.closeInfoBar();
        loginPage.inputRegisterEmail("test8@email.com");
        loginPage.inputRegisterPassword("SecretPassword123!");

        loginPage.hitEnterInRegisterEmail();
        Assertions.assertTrue(driver.getPageSource().contains("<a class=\"delete-me\""),
                "You have been redirected to incorrect webpage or not at all");
    }
}