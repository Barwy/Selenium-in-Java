import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BillPayment {
    WebDriver driver;

    @BeforeEach
    public void testStart() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://ebok.gkpge.pl/ebok/faces/profil/logowanie.xhtml");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hiddenLoginForm")));
    }

    @AfterEach
    public void testEnd() {
        driver.close();
        driver.quit();
    }

    @Test
    public void billLogin() {
        String username = "abc";
        String password = "cab";
        driver.findElement(By.id("loginForm:email")).sendKeys(username);
        driver.findElement(By.id("loginForm:haslo")).sendKeys(password);
        driver.findElement(By.id("loginForm:haslo")).sendKeys(Keys.RETURN);

    }

    @Test
    public void billPayment() {

    }
}
