package Part_5_ElementInteractions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSuccessfulLogin extends TestSettings {
    @Test
    //Try to log in with valid credentials for existing user;
    public void successfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.closeInfoBar();
        loginPage.inputLoginEmail("test@email.com");
        loginPage.inputLoginPassword("SecretPassword123!");

        loginPage.clickLoginButton();
        Assertions.assertTrue(driver.getPageSource().contains("<a class=\"delete-me\""),
                "You have been redirected to incorrect webpage or not at all");
    }

    @Test
    //Same test as above but log in by hitting enter;
    public void successfulLoginWithenter() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.closeInfoBar();
        loginPage.inputLoginEmail("fake@email.com");
        loginPage.inputLoginPassword("SecretPassword123!");

        loginPage.hitEnterInLoginEmail();
        Assertions.assertTrue(driver.getPageSource().contains("<a class=\"delete-me\""),
                "You have been redirected to incorrect webpage or not at all");
    }
}