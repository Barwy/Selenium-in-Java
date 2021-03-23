import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccountTest extends TestSettings {

    @Test
    public void registerNewAccount() {
        driver.get("https://allegro.pl/rejestracja");
        NewAccount newAccount = new NewAccount(driver);

        newAccount.acceptCookies();
        newAccount.enterEmailAddress("spoof@email.com");
        newAccount.enterPassword("Password123");
        newAccount.clickAgeRange();
        newAccount.clickObligatoryConsent();
        newAccount.clickSubmit();
        newAccount.rregisterConfirmation("https://allegro.pl/rejestracja/potwierdzenie");

        }
}
