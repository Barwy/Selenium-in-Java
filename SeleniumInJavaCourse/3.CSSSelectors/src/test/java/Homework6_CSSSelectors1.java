import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Zlokalizuj za pomocą lokatorów CSS:
1. +okienko użytkownik/email;
2. +okienko hasło;
3. okienko adres email;
4. okienko hasło
5. przyciks zaloguj;
6. checkbox zapamietaj;
7. link "nie pamiętasz hasła?";
8. przycisk zarejestruj się;
9. link do kategorii "Wspinaczka"
 */

public class Homework6_CSSSelectors1 {
    WebDriver driver;

    @BeforeEach
    public void testStart() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(800, 600));
        driver.get("https://fakestore.testelka.pl/moje-konto/");
    }

    @AfterEach
    public void testEnd() {
        driver.close();
        driver.quit();
    }

    @Test
    public void CSSTest(){
        driver.findElement(By.cssSelector("input[name='username'][type='text'][id='username'][autocomplete='username']"));
        driver.findElement(By.cssSelector("input[type='password'][name='password'][id='password][autocomplete='current-password']"));
        driver.findElement(By.cssSelector("input[name='email'][type='email'][id='reg_email'][autocomplete='email']"));
        driver.findElement(By.cssSelector("li[class='cat-item cat-item-18']"));
        driver.findElement(By.cssSelector("label[for='reg_email']"));


    }
}
