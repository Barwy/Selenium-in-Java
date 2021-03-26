import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccountTest extends TestSettings {

    @Test
    //This test checks if it is possible to register a new account for an adult user
    // and if user is then redirected to correct page
    public void registerNewAccount() {
        driver.get("https://allegro.pl/rejestracja");
        NewAccount newAccount = new NewAccount(driver);

        newAccount.acceptCookies();
        //checks if correct account type is selected;
        Assertions.assertFalse(driver.getPageSource().contains("label class=\"m-label\" for=\"radio1\""),
                "You are on business account tab");

        newAccount.enterEmailAddress("spoof@email.com");

        newAccount.enterPassword("Password123");
        //checks if correct e-mail address has been provided (user must first leave password input field);
        Assertions.assertTrue(driver.getPageSource().contains("class=\"ozg4u ftsdx f1sm5\""),
                "Invalid e-mail address");
        //Set of assertions to check if password meets site's criteria;
        Assertions.assertTrue(driver.getPageSource().contains("span class=\"ht13u6 c1tzf\">min. 8 znaków"),
                "Password too short");
        Assertions.assertTrue(driver.getPageSource().contains("span class=\"ht13u6 c1tzf\">wielka litera"),
                "Capital letter missing");
        Assertions.assertTrue(driver.getPageSource().contains("span class=\"ht13u6 c1tzf\">mała litera"),
                "Lowercase letter missing");
        Assertions.assertTrue(driver.getPageSource().contains("span class=\"ht13u6 c1tzf\">cyfra"),
                "Digit missing");

        newAccount.clickAgeRange();
        newAccount.clickObligatoryConsent();

        newAccount.clickSubmit();
        //checks if obligatory consent has been clicked;
        Assertions.assertFalse(driver.getPageSource().contains("class=\"_1dd5x mgmw_1p _44753_3g4PV\""),
                "Obligatory consent has not ben ticked");

        newAccount.registerConfirmation("https://allegro.pl/rejestracja/potwierdzenie");
        }
}
