package InteractionsTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFailedRegistration extends TestSettings{

    @Test
    public void incorrectEmail() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.closeInfoBar();
        loginPage.inputRegisterEmail("fake1@email.com");
        loginPage.inputRegisterPassword("SecretPassword123!");

        loginPage.clickRegisterButton();
        Assertions.assertEquals("https://fakestore.testelka.pl/moje-konto/", driver.getCurrentUrl(),
                "You have been redirected to incorrect page");
    }
}
