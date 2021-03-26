import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogInNoCredentialsTest extends TestSettings{

    @Test
    //this test checks what happens when user tries to log in without credentials
    //and if correct warnings are displayed;
    public  void logInWithoutCreds(){
        driver.get("https://allegro.pl/logowanie");
        LogInNoCredentials logInNoCredentials = new LogInNoCredentials(driver);

        logInNoCredentials.acceptCookies();
        logInNoCredentials.pressLogIn();
        //Checks the red tooltip message for empty login/e-mail field;
        Assertions.assertTrue(driver.getPageSource().contains("div id=\"login-error\""), "Login or e-mail field is not empty");
        //Checks the red tooltip message for empty password field;
        Assertions.assertTrue(driver.getPageSource().contains("div id=\"password-error\""), "Password field is not empty");


    }
}
